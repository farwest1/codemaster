package com.moeller.decenc.domain.service;

import com.moeller.decenc.domain.model.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Bernd on 04.11.2017.
 *
 * Package com.moeller.decenc.domain.service
 */
@Service
public class VersionService {

  private static final Logger LOGGER = LoggerFactory.getLogger(VersionService.class);

  private Version version = new Version();


  public void setVersion(Version version){
    this.version.setFix(version.getFix());
    this.version.setMinor(version.getMinor());
    this.version.setMajor(version.getMajor());

    LOGGER.info("New Version set.");
  }

  public Version getVersion() {
    return version;
  }
}
