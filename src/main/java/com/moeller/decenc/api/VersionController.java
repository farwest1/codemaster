package com.moeller.decenc.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bernd on 16.10.2017.
 *
 * Package com.moeller.decenc.api
 */

@RestController
public class VersionController {

  @RequestMapping("/version")
  public String getVersion(){
    return "0.9";
  }

}
