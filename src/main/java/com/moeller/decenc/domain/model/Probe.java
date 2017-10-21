package com.moeller.decenc.domain.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bernd on 21.10.2017.
 *
 * Package com.moeller.decenc.domain.model
 */

@XmlRootElement
public class Probe {

  private String plainText;
  private String base64Text;



  public String getPlainText() {
    return plainText;
  }

  public void setPlainText(String plainText) {
    this.plainText = plainText;
  }

  public String getBase64Text() {
    return base64Text;
  }

  public void setBase64Text(String base64Text) {
    this.base64Text = base64Text;
  }
}
