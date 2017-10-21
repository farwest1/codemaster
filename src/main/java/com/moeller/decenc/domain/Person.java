package com.moeller.decenc.domain;



/**
 * Created by Bernd on 10.10.2017.
 *
 * Package com.moeller.decenc.domain
 */
public class Person {

  public enum Sex {
    MALE, FEMALE
  }

  private final long id;
  private final String firstName;
  private final String lastName;
  private Sex gender;

  public Person(long id, String firstName, String lastName, Sex gender) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
  }

  public long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Sex getGender() {
    return gender;
  }

  public void setGender(Sex gender){
    this.gender = gender;
  }
}
