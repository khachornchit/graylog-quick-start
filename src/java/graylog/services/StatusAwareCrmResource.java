/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graylog.services;

import com.google.common.collect.Lists;
import graylog.obj.Color;
import graylog.obj.Person;
import graylog.obj.WidgetCount;
import graylog.obj.WidgetGraph;
import graylog.obj.WidgetMessage;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.ok;
import static sun.rmi.transport.TransportConstants.Return;
import static javax.ws.rs.core.Response.ok;

/**
 * REST Web Service
 *
 * @author kajornjit.songsaen
 */
@Path("StatusAwareCrm")
public class StatusAwareCrmResource {

    @Context
    private UriInfo context;

    @GET
    @Consumes("text/plain")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String getHtml(String message) {
        return "{ 'The browser sent this message': '" + message + "'}";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postHandler(String content) {
        return content;
    }

    @GET
    @Path("CriticalError")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public WidgetCount getCriticalError() throws Exception {
        Color color = new Color();
        WidgetCount c = new WidgetCount();
        c.setName("Critical Error");
        c.setCount((int) (Math.random() * 100));
        c.setMessage("Failed");
        c.setColor(color.getName());

        return c;
    }

    @GET
    @Path("PerformanceTest")
    @Produces(MediaType.APPLICATION_JSON)
    public WidgetCount getPerformanceTest(String message) {
        Color color = new Color();
        WidgetCount c = new WidgetCount();
        c.setName("Performance Test");
        c.setCount((int) (Math.random() * 100));
        c.setMessage("Failed");
        c.setColor(color.getName());

        return c;
    }

    @GET
    @Path("RegressionTest")
    @Produces(MediaType.APPLICATION_JSON)
    public WidgetCount getRegressionTest(String message) {
        Color color = new Color();
        WidgetCount c = new WidgetCount();
        c.setName("Regression Test");
        c.setCount((int) (Math.random() * 100));
        c.setMessage("Failed");
        c.setColor(color.getName());

        return c;
    }

    @GET
    @Path("HelpTicket")
    @Produces(MediaType.APPLICATION_JSON)
    public WidgetCount getHelpTicket(String message) {
        Color color = new Color();
        WidgetCount c = new WidgetCount();
        c.setName("Help Ticket");
        c.setCount((int) (Math.random() * 100));
        c.setMessage("Failed");
        c.setColor(color.getName());

        return c;
    }

    @GET
    @Path("Bugs")
    @Produces(MediaType.APPLICATION_JSON)
    public WidgetCount getBugs(String message) {
        Color color = new Color();
        WidgetCount c = new WidgetCount();
        c.setName("BUG");
        c.setCount((int) (Math.random() * 100));
        c.setMessage("Failed");
        c.setColor(color.getName());

        return c;
    }

    @GET
    @Path("Alive")
    @Produces(MediaType.APPLICATION_JSON)
    public WidgetCount getAlive(String message) {
        Color color = new Color();
        WidgetCount c = new WidgetCount();
        c.setName("Alive URL");
        c.setCount((int) (Math.random() * 100));
        c.setMessage("Failed");
        c.setColor(color.getName());

        return c;
    }

    @GET
    @Path("HelpTickets")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHelpTickets() {
        List<WidgetMessage> listHelptickets = new ArrayList<WidgetMessage>();
        listHelptickets = createHelpTicketList();

        GenericEntity<List<WidgetMessage>> entity = new GenericEntity<List<WidgetMessage>>(listHelptickets) {
        };

        return Response.ok(entity).build();
    }

    public List<WidgetMessage> createHelpTicketList() {
        List<WidgetMessage> listOfHelpTickets = new ArrayList<WidgetMessage>();
        listOfHelpTickets.add(new WidgetMessage(1, "helpticket", "HELP-19655", "The application is unusable", "Un-resolved", "21.Jan.16", "http://jira.coast.ebuero.de/browse/HELP-19655"));
        listOfHelpTickets.add(new WidgetMessage(2, "helpticket", "HELP-19113", "TA Weblink not working", "Un-resolved", "04.Jan.16", "http://jira.coast.ebuero.de/browse/HELP-19113"));
        listOfHelpTickets.add(new WidgetMessage(3, "helpticket", "HELP-19107", "RAV 87618 show in Sugar with the Banner for teh trial month is finish since 18.12", "Un-resolved", "21.Jan.16", "http://jira.coast.ebuero.de/browse/HELP-19107"));
        listOfHelpTickets.add(new WidgetMessage(4, "helpticket", "HELP-19652", "Stafan hases has problems with his Account for CLBS HRM", "Un-resolved", "21.Jan.16", "http://jira.coast.ebuero.de/browse/HELP-19652"));
        listOfHelpTickets.add(new WidgetMessage(5, "helpticket", "HELP-19298", "Case assign to people outside FR team", "Un-resolved", "11.Jan.16", "http://jira.coast.ebuero.de/browse/HELP-19298"));
        listOfHelpTickets.add(new WidgetMessage(6, "helpticket", "HELP-19897", "Schnellsuche is not working", "Un-resolved", "28.Jan.16", "http://jiracoast.ebuero.de/browse/HELP-19897"));
        listOfHelpTickets.add(new WidgetMessage(7, "helpticket", "HELP-19494", "Contact cannot be synchronised anymore", "Un-resolved", "15.Jan.16", "http://jira.coast.ebuero.de/browse/HELP-19494"));
        return listOfHelpTickets;
    }

    @GET
    @Path("BugMessages")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBugMessages() {
        List<WidgetMessage> listBugMessages = new ArrayList<WidgetMessage>();
        listBugMessages = createBugMessages();

        GenericEntity<List<WidgetMessage>> entity = new GenericEntity<List<WidgetMessage>>(listBugMessages) {
        };

        return Response.ok(entity).build();
    }

    public List<WidgetMessage> createBugMessages() {
        List<WidgetMessage> listBugs = new ArrayList<WidgetMessage>();
        listBugs.add(new WidgetMessage(1, "bug", "IPH-2245", "Unresolved", "It always asking the question when add new contact", "27.May.16", "http://jira.coast.ebuero.de/browse/IPH-2245"));
        listBugs.add(new WidgetMessage(2, "bug", "IPH-2244", "Unresolved", "Should display + after add + character in FW No.", "27.May.16", "http://jira.coast.ebuero.de/browse/IPH-2244"));
        listBugs.add(new WidgetMessage(3, "bug", "IPH-2246", "Unresolved", "FW No. icon not show (reuse VIP icon)", "27.May.16", "http://jira.coast.ebuero.de/browse/IPH-2246"));
        listBugs.add(new WidgetMessage(4, "bug", "IPH-2247", "Unresolved", "Should show alert after delete contact from address book on menu icon or FW no. list page", "27.May.16", "http://jira.coast.ebuero.de/browse/IPH-2247"));
        listBugs.add(new WidgetMessage(5, "bug", "IPH-2248", "Unresolved", "Add back to local not remove alert then it will allow to add back again*again", "27.May.16", "http://jira.coast.ebuero.de/browse/IPH-2248"));
        listBugs.add(new WidgetMessage(6, "bug", "IPH-2250", "Unresolved", "Add or remove contact should have loading indicator.", "27.May.16", "http://jira.coast.ebuero.de/browse/IPH-2250"));
        listBugs.add(new WidgetMessage(7, "bug", "IPH-2240", "Fixed", "Minor issues from 4.6", "04.May.16", "http://jira.coast.ebuero.de/browse/IPH-2240"));
        listBugs.add(new WidgetMessage(8, "bug", "AND-1376", "Number still show in suggestion after delete from CC number.", "Fixed", "26.May.16", "http://jira.coast.ebuero.de/browse/AND-1376"));
        listBugs.add(new WidgetMessage(9, "bug", "AND-1375", "Fixed", "Create by manual should mark it can editable contact.", "26.May.16", "http://jira.coast.ebuero.de/browse/AND-1375"));
        listBugs.add(new WidgetMessage(10, "bug", "AND-1374", "Fixed", "The contact doesn't have in reachability then it should not show question asking.", "26.May.16", "http://jira.coast.ebuero.de/browse/IPH-2245"));
        listBugs.add(new WidgetMessage(11, "bug", "AND-1378", "Fixed", "In Number to be forward list should not display name and number from reachability.", "26.May.16", "http://jira.coast.ebuero.de/browse/AND-1378"));

        return listBugs;
    }

    @GET
    @Path("Graphs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGraphs() {
        List<WidgetGraph> listGraphs = new ArrayList<WidgetGraph>();
        listGraphs = createGraphs();

        GenericEntity<List<WidgetGraph>> entity = new GenericEntity<List<WidgetGraph>>(listGraphs) {
        };

        return Response.ok(entity).build();
    }

    public List<WidgetGraph> createGraphs() {
        List<WidgetGraph> listGraphs = new ArrayList<WidgetGraph>();
        listGraphs.add(new WidgetGraph("8:00", 1156, 1042, 3000));
        listGraphs.add(new WidgetGraph("8:30", 2074, 1131, 3000));
        listGraphs.add(new WidgetGraph("9:00", 1310, 1326, 3000));
        listGraphs.add(new WidgetGraph("9:30", 1907, 1910, 3000));
        listGraphs.add(new WidgetGraph("10:00", 1168, 965, 3000));
        listGraphs.add(new WidgetGraph("10:30", 1253, 992, 3000));
        listGraphs.add(new WidgetGraph("11:00", 1397, 1188, 3000));
        listGraphs.add(new WidgetGraph("11:30", 4924, 3595, 3000));
        listGraphs.add(new WidgetGraph("12:00", 1864, 1437, 3000));
        listGraphs.add(new WidgetGraph("12:30", 1446, 1242, 3000));
        listGraphs.add(new WidgetGraph("13:00", 998, 785, 3000));
        listGraphs.add(new WidgetGraph("13:30", 875, 699, 3000));
        listGraphs.add(new WidgetGraph("14:00", 1590, 1087, 3000));
        listGraphs.add(new WidgetGraph("14:30", 1466, 1281, 3000));
        listGraphs.add(new WidgetGraph("15:00", 892, 759, 3000));
        listGraphs.add(new WidgetGraph("15:30", 744, 618, 3000));
        listGraphs.add(new WidgetGraph("16:00", 1864, 1437, 3000));
        listGraphs.add(new WidgetGraph("16:30", 1446, 1242, 3000));
        listGraphs.add(new WidgetGraph("17:00", 998, 785, 3000));
        listGraphs.add(new WidgetGraph("17:30", 875, 699, 3000));

        return listGraphs;
    }

    @POST
    @Path("CriticalError")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String setCriticalError(String content) throws Exception {
        return content;
    }
}