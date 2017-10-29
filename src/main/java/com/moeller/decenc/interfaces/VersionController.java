package com.moeller.decenc.interfaces;

import static org.springframework.http.ResponseEntity.ok;

import com.moeller.decenc.domain.model.Version;
import io.prometheus.client.Counter;
import io.prometheus.client.Summary;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
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

  @RequestMapping(
      value = "/version",
      produces = {"application/xml", "application/json"},
      method = RequestMethod.GET)
  public ResponseEntity<Version> getVersion(HttpServletRequest request, HttpServletResponse response){
    Summary.Timer reqTimer = REQUEST_LATENCY.startTimer();
    try {
      LOGGER.info("Caller Ip: " + request.getRemoteAddr());
      response.setHeader("X-IPAddress", request.getRemoteHost());
      REQUESTS.inc();
      return ResponseEntity.ok(new Version());
    } finally {
      reqTimer.observeDuration();
    }

  }

}
