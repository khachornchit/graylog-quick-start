/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graylog.obj;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kajornjit.songsaen
 */
//@XmlRootElement
public class Person {
    private int personId;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

//    public Person(int personId, String name) {
//        this.personId = personId;
//        this.name = name;
//    }
}
