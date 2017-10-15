package com.moeller.decenc.business;

import com.moeller.decenc.business.Person.Sex;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bernd on 10.10.2017.
 *
 * Package com.moeller.decenc.business
 */
public class LamdaTest {

  public static void printPersons(List<Person> personList, CheckPerson checkPerson){
    for (Person p: personList) {

      if(checkPerson.test(p)){
        System.out.println(p.getGender());
      }

    }
  }

  public void listPersons(){
    List<Person> personList = new ArrayList<Person>();

    personList.add(new Person(1,"Bernd", "Moeller", Sex.MALE));
    personList.add(new Person(2,"Romina", "Salaris", Sex.FEMALE));

//    printPersons(personList, new CheckPerson() {
//      public boolean test(Person person){
//        return person.getGender().equals(Sex.FEMALE);
//      }
//    });
    printPersons(personList, p -> p.getGender().equals(Sex.FEMALE));
    
  }
}
