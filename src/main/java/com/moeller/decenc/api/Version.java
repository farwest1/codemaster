package com.moeller.decenc.api;


import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bernd on 17.10.2017.
 *
 * Package com.moeller.decenc.api
 */
@XmlRootElement
public final class Version {
  private int major = 0;
  private int minor = 1;

  public Version() {
  }

  public int getMajor() {
    return major;
  }

  public int getMinor() {
    return minor;
  }

  public void setMajor(int major) {
    this.major = major;
  }

  public void setMinor(int minor) {
    this.minor = minor;
  }
}
