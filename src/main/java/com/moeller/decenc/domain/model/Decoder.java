package com.moeller.decenc.domain.model;

import java.nio.charset.Charset;
import java.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Bernd on 13.10.2017.
 *
 * Package com.moeller.decenc.domain
 */
public class Decoder {

  private static final Logger LOGGER = LoggerFactory.getLogger(Decoder.class);


  public static String decode(final String in) {

    LOGGER.debug("String to be decoded: " + in);
    String decodedValue = new String(Base64.getDecoder().decode(in), Charset.forName("UTF-8"));
    LOGGER.debug("decoded String: " + decodedValue);
    return decodedValue;
  }

  public static String encode(final String in){
    LOGGER.debug("String to be encoded: " + in);
    String encodedString = new String(Base64.getEncoder().encode(in.getBytes()), Charset.forName("UTF-8"));
    LOGGER.debug("encoded String: " + encodedString);
    return encodedString;
  }

}
