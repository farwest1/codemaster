package com.moeller.decenc.api;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bernd on 16.10.2017.
 *
 * Package com.moeller.decenc.api
 */

@RestController
public class VersionController {

  @RequestMapping(
      value = "/version",
      produces = {"application/xml", "application/json"})
  public ResponseEntity<Version> getVersion(){
    return ResponseEntity.ok(new Version());
  }

}
