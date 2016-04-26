package com.webwemser.letsmeetapp;

/**
 * Created by User on 26.04.2016.
 */
public class Dummy {
    
    private Meet[] meets = new Meet[5];
    
    public Meet[] getAllMeets(){
        Meet meet5 = new Meet();
        meet5.setAuthor("Julian");
        meet5.setDatetime("01.01.1970 - 22:22");
        meet5.setDescription("We will have a lot of fun.");
        meet5.setLocation("FH Münster");
        meet5.setMaxGuests(10);
        meet5.setTitle("Webwemser Meetup 5");
        Meet meet4 = new Meet();
        meet4.setAuthor("Sergei");
        meet4.setDatetime("01.01.1970 - 22:22");
        meet4.setDescription("We will have a lot of fun.");
        meet4.setLocation("FH Münster");
        meet4.setMaxGuests(10);
        meet4.setTitle("Webwemser Meetup 4");
        Meet meet3 = new Meet();
        meet3.setAuthor("Christian");
        meet3.setDatetime("01.01.1970 - 22:22");
        meet3.setDescription("We will have a lot of fun.");
        meet3.setLocation("FH Münster");
        meet3.setMaxGuests(10);
        meet3.setTitle("Webwemser Meetup 3");
        Meet meet2 = new Meet();
        meet2.setAuthor("MvG");
        meet2.setDatetime("01.01.1970 - 22:22");
        meet2.setDescription("We will have a lot of fun.");
        meet2.setLocation("FH Münster");
        meet2.setMaxGuests(10);
        meet2.setTitle("Webwemser Meetup 2");
        Meet meet1 = new Meet();
        meet1.setAuthor("Jannik W.");
        meet1.setDatetime("01.01.1970 - 22:22");
        meet1.setDescription("We will have a lot of fun.");
        meet1.setLocation("FH Münster");
        meet1.setMaxGuests(10);
        meet1.setTitle("Webwemser Meetup");
        meets[0] = meet1;
        meets[1] = meet2;
        meets[2] = meet3;
        meets[3] = meet4;
        meets[4] = meet5;
        return meets;
    }
    
}
