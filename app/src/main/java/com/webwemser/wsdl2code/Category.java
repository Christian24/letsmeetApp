package com.webwemser.web;

//------------------------------------------------------------------------------
// <wsdl2code-generated>
//    This code was generated by http://www.wsdl2code.com version  2.6
//
// Date Of Creation: 5/25/2016 8:30:04 PM
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

public class Category implements KvmSerializable {
    
    public String title;
    
    public Category(){}
    
    public Category(SoapObject soapObject)
    {
        if (soapObject == null)
            return;
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
    }
    @Override
    public Object getProperty(int arg0) {
        switch(arg0){
            case 0:
                return title;
        }
        return null;
    }
    
    @Override
    public int getPropertyCount() {
        return 1;
    }
    
    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch(index){
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "title";
                break;
        }
    }
    

    public String getInnerText() {
        return null;
    }
    
    

    public void setInnerText(String s) {
    }
    
    
    @Override
    public void setProperty(int arg0, Object arg1) {
    }
    
}