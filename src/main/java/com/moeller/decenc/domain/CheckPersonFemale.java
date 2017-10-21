package com.moeller.decenc.domain;

import com.moeller.decenc.domain.Person.Sex;

/**
 * Created by Bernd on 10.10.2017.
 *
 * Package com.moeller.decenc.domain
 */
public class CheckPersonFemale implements CheckPerson{

  @Override
  public boolean test(Person person) {
    return person.getGender().equals(Sex.FEMALE)? true:false;
  }
}
