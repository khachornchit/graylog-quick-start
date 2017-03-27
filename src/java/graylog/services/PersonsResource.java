/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graylog.services;

import graylog.obj.Color;
import graylog.obj.Person;
import graylog.obj.WidgetCount;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author kajornjit.songsaen
 */
@Path("Persons")
public class PersonsResource {

    @Context
    private UriInfo context;
    
    @GET
    @Path("Persons")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersons() {
        List<Person> persons = new ArrayList<Person>();
        Person p1 = new Person();
        Person p2 = new Person();

        p1.setPersonId(1);
        p1.setName("John Smith");

        p2.setPersonId(1);
        p2.setName("Jane Smith");

        persons.add(p1);
        persons.add(p2);

        GenericEntity<List<Person>> entity = new GenericEntity<List<Person>>(persons) {
        };

        return Response.ok(entity).build();
    }

    @GET
    @Path("Person")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Person getPerson() throws Exception {
        Person p = new Person();
        p.setPersonId(1);
        p.setName("John Smith");

        Color color = new Color();
        WidgetCount c = new WidgetCount();
        c.setName("Critical Error");
        c.setCount((int) (Math.random() * 100));
        c.setMessage("Failed");
        c.setColor(color.getName());

        return p;
    }
}
