package com.webwemser.letsmeetapp;

import java.util.ArrayList;

/**
 * Created by Jannik W. on 26.04.2016.
 */
public class Dummy {
    
    private ArrayList<Meet> meets = new ArrayList<>();
    
    public ArrayList<Meet> getAllMeets(){
        for(int i = 0; i<18; i++) {
            Meet meet = new Meet();
            meet.setAuthor("Jannik Wortmann");
            meet.setDatetime("01.05.2016 - 22:22");
            meet.setDescription("We will have a lot of fun.");
            meet.setLocation("FH Münster");
            meet.setMaxGuests(10);
            meet.setTitle("WI Meetup " + i);
            meets.add(meet);
        }
        return meets;
    }
}
