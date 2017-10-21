package com.moeller.decenc.interfaces;

import static org.springframework.http.ResponseEntity.ok;

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

  @RequestMapping(
      value = "/version",
      produces = {"application/xml", "application/json"},
      method = RequestMethod.GET)
  public ResponseEntity<Version> getVersion(HttpServletRequest request, HttpServletResponse response){
    LOGGER.info("Caller Ip: " + request.getRemoteAddr());
    response.setHeader("X-IPAddress", request.getRemoteHost());
    return ResponseEntity.ok(new Version());
  }

}
