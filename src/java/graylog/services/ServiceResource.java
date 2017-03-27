/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graylog.services;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author kajornjit.songsaen
 */
@Path("services")
public class ServiceResource {

    @Context
    private UriInfo context;

    public ServiceResource() {
    }

    @GET
    @Consumes("text/plain")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHtml(String message) {
        return "{ 'The browser sent this message': '" + message + "'}";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postHandler(String content) {
        return content;
    }
}