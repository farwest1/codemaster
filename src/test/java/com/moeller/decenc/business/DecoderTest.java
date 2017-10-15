package com.moeller.decenc.business;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by Bernd on 14.10.2017.
 *
 * Package com.moeller.decenc.business
 */
public class DecoderTest {

  @Test
  public void decode() throws Exception {
      assertEquals(Decoder.decode("MTIz"),"123");
  }

  public void encode() throws Exception {
    assertEquals(Decoder.encode("123"), "MTIz");
  }

}