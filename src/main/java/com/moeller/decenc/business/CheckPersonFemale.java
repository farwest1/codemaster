package com.moeller.decenc.business;

import com.moeller.decenc.business.Person.Sex;

/**
 * Created by Bernd on 10.10.2017.
 *
 * Package com.moeller.decenc.business
 */
public class CheckPersonFemale implements CheckPerson{

  @Override
  public boolean test(Person person) {
    return person.getGender().equals(Sex.FEMALE)? true:false;
  }
}
