/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graylog.services;

import graylog.obj.Country;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author kajornjit.songsaen
 */
@Path("Country")
public class CountryRestResource {

    @Context
    private UriInfo context;

//    @Path("/countries")
//    public class CountryRestService {
//    }

    @GET
    @Path("/countries")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> getCountries() {
        List<Country> listOfCountries = new ArrayList<Country>();
        listOfCountries = createCountryList();
        return listOfCountries;
    }

    @GET
    @Path("{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Country getCountryById(@PathParam("id") int id) {
        List<Country> listOfCountries = new ArrayList<Country>();
        listOfCountries = createCountryList();
        for (Country country : listOfCountries) {
            if (country.getId() == id) {
                return country;
            }
        }
        return null;
    }

    // Utiliy method to create country list. 
    public List<Country> createCountryList() {
        Country indiaCountry = new Country(1, "India");
        Country chinaCountry = new Country(4, "China");
        Country nepalCountry = new Country(3, "Nepal");
        Country bhutanCountry = new Country(2, "Bhutan");
        List<Country> listOfCountries = new ArrayList<Country>();
        listOfCountries.add(indiaCountry);
        listOfCountries.add(chinaCountry);
        listOfCountries.add(nepalCountry);
        listOfCountries.add(bhutanCountry);
        return listOfCountries;
    }
}
