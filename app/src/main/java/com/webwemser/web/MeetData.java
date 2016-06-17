package com.webwemser.web;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 4.5.6.0
//
// Created by Quasar Development at 15/06/2016
//
//---------------------------------------------------


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import org.ksoap2.serialization.*;
import java.util.ArrayList;
import org.ksoap2.serialization.PropertyInfo;

/**
 * MeetData from server
 * generated using easywsdl.com
 */
public class MeetData extends DataTransferObject implements KvmSerializable
{


    public UserData admin;

    public String category;

    public ArrayList< ConversationData> conversations =new ArrayList<ConversationData >();

    public java.util.Date dateTime;

    public String description;

    public Integer getId() {
        return id;
    }

    public Integer id=0;

    public String location;

    public Integer maxGuests=0;

    public String title;

    public ArrayList< UserData> visitors =new ArrayList<UserData >();

    public MeetData ()
    {
    }

    public MeetData (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
    {
        super(paramObj, __envelope);
        if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;


        if(inObj instanceof SoapObject)
        {
            SoapObject soapObject=(SoapObject)inObj;
            int size = soapObject.getPropertyCount();
            for (int i0=0;i0< size;i0++)
            {
                //if you have compilation error here, please use a ksoap2.jar and ExKsoap2.jar from libs folder (in the generated zip file)
                PropertyInfo info=soapObject.getPropertyInfo(i0);
                java.lang.Object obj = info.getValue();
                if (info.name.equals("admin"))
                {
                    if(obj!=null)
                    {
                        java.lang.Object j = obj;
                        this.admin = (UserData)__envelope.get(j,UserData.class);
                    }
                    continue;
                }
                if (info.name.equals("category"))
                {
                    if(obj!=null)
                    {

                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.category = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.category = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("conversations"))
                {
                    if(obj!=null)
                    {


                        if(this.conversations==null)
                        {
                            this.conversations = new ArrayList<ConversationData>();
                        }
                        java.lang.Object j =obj;
                        ConversationData j1= (ConversationData)__envelope.get(j,ConversationData.class);
                        this.conversations.add(j1);


                    }
                    continue;
                }
                if (info.name.equals("dateTime"))
                {
                    if(obj!=null)
                    {

                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.dateTime = Helper.ConvertFromWebService(j.toString());
                            }
                        }
                        else if (obj instanceof java.util.Date){
                            this.dateTime = (java.util.Date)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("description"))
                {
                    if(obj!=null)
                    {

                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.description = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.description = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("id"))
                {
                    if(obj!=null)
                    {

                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.id = Integer.parseInt(j.toString());
                            }
                        }
                        else if (obj instanceof Integer){
                            this.id = (Integer)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("location"))
                {
                    if(obj!=null)
                    {

                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.location = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.location = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("maxGuests"))
                {
                    if(obj!=null)
                    {

                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.maxGuests = Integer.parseInt(j.toString());
                            }
                        }
                        else if (obj instanceof Integer){
                            this.maxGuests = (Integer)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("title"))
                {
                    if(obj!=null)
                    {

                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.title = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.title = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("visitors"))
                {
                    if(obj!=null)
                    {


                        if(this.visitors==null)
                        {
                            this.visitors = new ArrayList<UserData>();
                        }
                        java.lang.Object j =obj;
                        UserData j1= (UserData)__envelope.get(j,UserData.class);
                        this.visitors.add(j1);


                    }
                    continue;
                }

            }

        }



    }

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        int count = super.getPropertyCount();
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==count+0)
        {
            return this.admin!=null?this.admin:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+1)
        {
            return this.category!=null?this.category:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+2)
        {
            return this.dateTime!=null?Helper.getDateTimeFormat().format(this.dateTime):SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+3)
        {
            return this.description!=null?this.description:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+4)
        {
            return id;
        }
        if(propertyIndex==count+5)
        {
            return this.location!=null?this.location:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+6)
        {
            return maxGuests;
        }
        if(propertyIndex==count+7)
        {
            return this.title!=null?this.title:SoapPrimitive.NullSkip;
        }
        if(propertyIndex>=count+8 && propertyIndex< count+ 8+this.conversations.size())
        {
            return this.conversations.get(propertyIndex-(count+8));
        }
        if(propertyIndex>=count+8+this.conversations.size() && propertyIndex< count+ 8+this.conversations.size()+this.visitors.size())
        {
            return this.visitors.get(propertyIndex-(count+8+this.conversations.size()));
        }
        return super.getProperty(propertyIndex);
    }


    @Override
    public int getPropertyCount() {
        return super.getPropertyCount()+8+conversations.size()+visitors.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        int count = super.getPropertyCount();
        if(propertyIndex==count+0)
        {
            info.type = UserData.class;
            info.name = "admin";
            info.namespace= "";
        }
        if(propertyIndex==count+1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "category";
            info.namespace= "";
        }
        if(propertyIndex==count+2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "dateTime";
            info.namespace= "";
        }
        if(propertyIndex==count+3)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "description";
            info.namespace= "";
        }
        if(propertyIndex==count+4)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "id";
            info.namespace= "";
        }
        if(propertyIndex==count+5)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "location";
            info.namespace= "";
        }
        if(propertyIndex==count+6)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "maxGuests";
            info.namespace= "";
        }
        if(propertyIndex==count+7)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "title";
            info.namespace= "";
        }
        if(propertyIndex>=count+8 && propertyIndex <= count+8+this.conversations.size())
        {
            info.type = ConversationData.class;
            info.name = "conversations";
            info.namespace= "";
        }
        if(propertyIndex>=count+8+this.conversations.size() && propertyIndex <= count+8+this.conversations.size()+this.visitors.size())
        {
            info.type = UserData.class;
            info.name = "visitors";
            info.namespace= "";
        }
        super.getPropertyInfo(propertyIndex,arg1,info);
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    /**
     * Gets the title of the MeetData
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the category
     * NOTE THIS IS A STRING
     * @return String
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the dateTime as String
     * @return String
     */
    public String getDateTime() {
        return new SimpleDateFormat("dd.MM.yyyy  hh:mm").format(dateTime);
    }

    /**
     * A list of all the visitors
     * @return
     */
    public ArrayList<UserData> getVisitors() {
        return visitors;
    }

    /**
     * Returns how many spaces are left in the Meet
     * @return
     */
    public int getFreeSpace() {
        return visitors.size()+1;
    }

    /**
     * returns the number of maximum guests
     * @return
     */
    public int getMaxGuests() {
        return maxGuests;
    }

    /**
     * Gets the username of the admin
     * @return String
     */
    public String getAdminUserName() {
        return admin.getUserName();
    }

    /**
     * Checks for the given user if he/she has joined already
     * @param user
     * @return boolean
     */
    public boolean hasJoined(UserData user) {
        return admin.equals(user) || getVisitors().contains(user);
    }

    /**
     * Gets the conversations of the Meet
     * @return
     */
    public ArrayList<ConversationData> getConversations() {
        return conversations;
    }

}
