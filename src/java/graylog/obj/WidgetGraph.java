/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graylog.obj;

/**
 *
 * @author kajornjit.songsaen
 */
public class WidgetGraph {

    private String time;
    private int pagespeed;
    private int restspeed;
    private int reference;

    public WidgetGraph() {
    }

    public WidgetGraph(String time, int pagespeed, int restspeed, int reference) {
        this.time = time;
        this.pagespeed = pagespeed;
        this.restspeed = restspeed;
        this.reference = reference;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public int getRestspeed() {
        return restspeed;
    }

    public void setRestspeed(int restSpeed) {
        this.restspeed = restSpeed;
    }

    public int getPagespeed() {
        return pagespeed;
    }

    public void setPagespeed(int pagespeed) {
        this.pagespeed = pagespeed;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
