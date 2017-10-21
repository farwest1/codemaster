package com.moeller.decenc.interfaces;

import com.moeller.decenc.domain.model.Decoder;
import com.moeller.decenc.domain.service.CoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bernd on 13.10.2017.
 *
 * Package com.moeller.decenc.interfaces
 */
@RestController
public class DecodeController {

  @Autowired
  private CoderService coderService;

  @RequestMapping("/decode")
  public String decode(@RequestParam(value = "tobedecoded", defaultValue = "123") String in){
    return coderService.decode(in);
  }

  @RequestMapping("/encode")
  public String encode(@RequestParam(value = "tobeencoded", defaultValue = "123") String in){
    return coderService.encode(in);
  }
}
