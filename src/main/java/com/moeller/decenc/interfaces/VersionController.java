package com.moeller.decenc.interfaces;

import com.moeller.decenc.domain.model.Version;
import com.moeller.decenc.domain.service.VersionService;
import com.moeller.decenc.infrastructure.RaspberryPiGPIO;
import com.pi4j.io.gpio.PinState;
import io.prometheus.client.Counter;
import io.prometheus.client.Summary;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bernd on 16.10.2017.
 *
 * Package com.moeller.decenc.interfaces
 */
@RestController
public class VersionController {

  private static final Logger LOGGER = LoggerFactory.getLogger(VersionController.class);
  static final Counter REQUESTS = Counter.build().name("version_requests_total").help("Total requests.").register();
  static final Summary REQUEST_LATENCY = Summary.build().name("requests_latency_seconds").help("Request latency in seconds.").register();

  @Autowired(required = false)
  private RaspberryPiGPIO raspberryPiGPIO;

  @Autowired
  private VersionService versionService;

  @RequestMapping(
      value = "/version",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE},
      method = RequestMethod.GET)
  public ResponseEntity<Version> getVersion(HttpServletRequest request, HttpServletResponse response){
    Summary.Timer reqTimer = REQUEST_LATENCY.startTimer();
    try {
      LOGGER.info("Caller Ip: " + request.getRemoteAddr());
      LOGGER.info("Caller User: " + request.getRemoteUser());
      LOGGER.info("Blink LED");
      if (raspberryPiGPIO != null) {
          raspberryPiGPIO.getOutputPin().pulse(1000, PinState.HIGH);
      }
      response.setHeader("X-IPAddress", request.getRemoteHost());
      REQUESTS.inc();
    }
    finally {
      reqTimer.observeDuration();
    }
    return ResponseEntity.ok(versionService.getVersion());
  }
  @RequestMapping(
    method = RequestMethod.POST,
    consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE},
    produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
  public ResponseEntity<Version> setVersion(@RequestBody Version version){
    versionService.setVersion(version);
    return ResponseEntity.accepted().body(version);
  }

}
