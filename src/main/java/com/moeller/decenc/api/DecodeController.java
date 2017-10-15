package com.moeller.decenc.api;

import com.moeller.decenc.business.Decoder;
import java.util.Base64;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bernd on 13.10.2017.
 *
 * Package com.moeller.decenc.api
 */
@RestController
public class DecodeController {

  @RequestMapping("/decode")
  public String decode(@RequestParam(value = "tobedecoded", defaultValue = "123") String in){
    return Decoder.decode(in);
  }

  @RequestMapping("/encode")
  public String encode(@RequestParam(value = "tobeencoded", defaultValue = "123") String in){
    return Decoder.encode(in);
  }
}
