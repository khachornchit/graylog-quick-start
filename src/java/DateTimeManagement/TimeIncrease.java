/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DateTimeManagement;

import org.joda.time.*;
import org.joda.time.format.*;
/**
 *
 * @author kajornjit.songsaen
 */
public class TimeIncrease {
    public void Increase30min() {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
        LocalTime time = formatter.parseLocalTime("14:00");
        time = time.plusMinutes(30);
        System.out.println(formatter.print(time));
    }
    
    public void Increase30min(String inputTime) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
        LocalTime time = formatter.parseLocalTime(inputTime);
        time = time.plusMinutes(30);
        System.out.println(formatter.print(time));
    }
}