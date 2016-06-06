package com.webwemser.web;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 4.5.5.2
//
// Created by Quasar Development at 29/05/2016
//
//---------------------------------------------------


import java.util.Hashtable;
import org.ksoap2.serialization.*;
import java.util.ArrayList;
import org.ksoap2.serialization.PropertyInfo;

public class KILmeet extends AttributeContainer implements KvmSerializable
{

    
    public KILuser admin;
    
    public KILcategory category;
    
    public long dateTime;
    
    public String description;
    
    public String location;
    
    public Integer maxGuests=0;
    
    public String title;
    
    public ArrayList< KILuser> visitors =new ArrayList<KILuser >();

    public KILmeet ()
    {
    }

    public KILmeet (java.lang.Object paramObj,KILExtendedSoapSerializationEnvelope __envelope)
    {
	    
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
                        this.admin = (KILuser)__envelope.get(j,KILuser.class);
                    }
                    continue;
                }
                if (info.name.equals("category"))
                {
                    if(obj!=null)
                    {
                        java.lang.Object j = obj;
                        this.category = (KILcategory)__envelope.get(j,KILcategory.class);
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
                                //this.dateTime = KILHelper.ConvertFromWebService(j.toString());
                            }
                        }
                        else if (obj instanceof java.util.Date){
                            this.dateTime = (long)obj;
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
                            this.visitors = new ArrayList<KILuser>();
                        }
                        java.lang.Object j =obj;
                        KILuser j1= (KILuser)__envelope.get(j,KILuser.class);
                        this.visitors.add(j1);
                   
        
                    }
                    continue;
                }

            }

        }



    }

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==0)
        {
            return this.admin!=null?this.admin:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return this.category!=null?this.category:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==2)
        {
            return this.dateTime>0?KILHelper.getDateTimeFormat().format(this.dateTime):SoapPrimitive.NullSkip;
        }
        if(propertyIndex==3)
        {
            return this.description!=null?this.description:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==4)
        {
            return this.location!=null?this.location:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==5)
        {
            return maxGuests;
        }
        if(propertyIndex==6)
        {
            return this.title!=null?this.title:SoapPrimitive.NullSkip;
        }
        if(propertyIndex>=+7 && propertyIndex< + 7+this.visitors.size())
        {
            return this.visitors.get(propertyIndex-(+7));
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 7+visitors.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = KILuser.class;
            info.name = "admin";
            info.namespace= "";
        }
        if(propertyIndex==1)
        {
            info.type = KILcategory.class;
            info.name = "category";
            info.namespace= "";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "dateTime";
            info.namespace= "";
        }
        if(propertyIndex==3)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "description";
            info.namespace= "";
        }
        if(propertyIndex==4)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "location";
            info.namespace= "";
        }
        if(propertyIndex==5)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "maxGuests";
            info.namespace= "";
        }
        if(propertyIndex==6)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "title";
            info.namespace= "";
        }
        if(propertyIndex>=+7 && propertyIndex <= +7+this.visitors.size())
        {
            info.type = KILuser.class;
            info.name = "visitors";
            info.namespace= "";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public long getDatetime() {
        return dateTime;
    }
}
