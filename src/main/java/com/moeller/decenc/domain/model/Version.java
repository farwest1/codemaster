package com.moeller.decenc.domain.model;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bernd on 17.10.2017.
 *
 * Package com.moeller.decenc.interfaces
 */
@XmlRootElement
@JsonPropertyOrder({"major","fix","minor"})
//Todo: Order does not work for XML
public final class Version {
  private int major = 0;
  private int minor = 1;
  private int fix = 0;

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

  public int getFix() {
    return fix;
  }

  public void setFix(int fix) {
    this.fix = fix;
  }
}
