package com.webwemser.web;
//------------------------------------------------------------------------------
// <wsdl2code-generated>
//    This code was generated by http://www.wsdl2code.com version  2.6
//
// Date Of Creation: 5/24/2016 8:19:51 PM
//    Please dont change this code, regeneration will override your changes
//</wsdl2code-generated>
//
//------------------------------------------------------------------------------
//
//This source code was auto-generated by Wsdl2Code  Version
//

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import java.util.Hashtable;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class meet implements KvmSerializable {
    
    public user admin;
    public category category;
    public String dateTime;
    public boolean dateTimeSpecified;
    public String description;
    public String location;
    public int maxGuests;
    public String title;
    public Vectoruser visitors;
    
    public meet(){}
    
    public meet(SoapObject soapObject)
    {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("admin"))
        {
            SoapObject j = (SoapObject)soapObject.getProperty("admin");
            admin =  new user (j);
            
        }
        if (soapObject.hasProperty("category"))
        {
            SoapObject j = (SoapObject)soapObject.getProperty("category");
            category =  new category (j);
            
        }
        if (soapObject.hasProperty("dateTime"))
        {
            Object obj = soapObject.getProperty("dateTime");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                dateTime = j.toString();
            }else if (obj!= null && obj instanceof String){
                dateTime = (String) obj;
            }
        }
        if (soapObject.hasProperty("dateTimeSpecified"))
        {
            Object obj = soapObject.getProperty("dateTimeSpecified");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                dateTimeSpecified = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                dateTimeSpecified = (Boolean) obj;
            }
        }
        if (soapObject.hasProperty("description"))
        {
            Object obj = soapObject.getProperty("description");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                description = j.toString();
            }else if (obj!= null && obj instanceof String){
                description = (String) obj;
            }
        }
        if (soapObject.hasProperty("location"))
        {
            Object obj = soapObject.getProperty("location");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                location = j.toString();
            }else if (obj!= null && obj instanceof String){
                location = (String) obj;
            }
        }
        if (soapObject.hasProperty("maxGuests"))
        {
            Object obj = soapObject.getProperty("maxGuests");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                maxGuests = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                maxGuests = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("title"))
        {
            Object obj = soapObject.getProperty("title");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                title = j.toString();
            }else if (obj!= null && obj instanceof String){
                title = (String) obj;
            }
        }
        if (soapObject.hasProperty("visitors"))
        {
            SoapObject j = (SoapObject)soapObject.getProperty("visitors");
            visitors = new Vectoruser(j);
        }
    }
    @Override
    public Object getProperty(int arg0) {
        switch(arg0){
            case 0:
                return admin;
            case 1:
                return category;
            case 2:
                return dateTime;
            case 3:
                return dateTimeSpecified;
            case 4:
                return description;
            case 5:
                return location;
            case 6:
                return maxGuests;
            case 7:
                return title;
            case 8:
                return visitors;
        }
        return null;
    }
    
    @Override
    public int getPropertyCount() {
        return 9;
    }
    
    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch(index){
            case 0:
                info.type = user.class;
                info.name = "admin";
                break;
            case 1:
                info.type = category.class;
                info.name = "category";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "dateTime";
                break;
            case 3:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "dateTimeSpecified";
                break;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "description";
                break;
            case 5:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "location";
                break;
            case 6:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "maxGuests";
                break;
            case 7:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "title";
                break;
            case 8:
                info.type = PropertyInfo.VECTOR_CLASS;
                info.name = "visitors";
                break;
        }
    }
    
    @Override
    public String getInnerText() {
        return null;
    }
    
    
    @Override
    public void setInnerText(String s) {
    }
    
    
    @Override
    public void setProperty(int arg0, Object arg1) {
    }
    
}
