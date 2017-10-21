package com.moeller.decenc.domain.service;

import com.moeller.decenc.domain.model.Decoder;
import org.springframework.stereotype.Service;

/**
 * Created by Bernd on 21.10.2017.
 *
 * Package com.moeller.decenc.domain.service
 */

@Service
public class CoderService {

  public String encode(final String toBeEncoded){
    return Decoder.encode(toBeEncoded);
  }

  public String decode(final String toBeDecoded){
    return Decoder.decode(toBeDecoded);
  }

}
