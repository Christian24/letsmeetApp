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

import java.util.List;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.HeaderProperty;
import java.util.Hashtable;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import android.os.AsyncTask;
import org.ksoap2.serialization.MarshalFloat;
import com.webwemser.web.OnlineIntegrationService.*;

public class OnlineIntegrationService {
    
    public String NAMESPACE ="http://web/";
    public String url="";
    public int timeOut = 180;
    public IWsdl2CodeEvents eventHandler;
    public WS_Enums.SoapProtocolVersion soapVersion;
    
    public OnlineIntegrationService(){}
    
    public OnlineIntegrationService(IWsdl2CodeEvents eventHandler)
    {
        this.eventHandler = eventHandler;
    }
    public OnlineIntegrationService(IWsdl2CodeEvents eventHandler,String url)
    {
        this.eventHandler = eventHandler;
        this.url = url;
    }
    public OnlineIntegrationService(IWsdl2CodeEvents eventHandler,String url,int timeOutInSeconds)
    {
        this.eventHandler = eventHandler;
        this.url = url;
        this.setTimeOut(timeOutInSeconds);
    }
    public void setTimeOut(int seconds){
        this.timeOut = seconds * 1000;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public void loginAsync(String arg0,String arg1) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        loginAsync(arg0, arg1, null);
    }
    
    public void loginAsync(final String arg0,final String arg1,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, sessionResponse>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected sessionResponse doInBackground(Void... params) {
                return login(arg0, arg1, headers);
            }
            @Override
            protected void onPostExecute(sessionResponse result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("login", result);
                }
            }
        }.execute();
    }
    
    public sessionResponse login(String arg0,String arg1){
        return login(arg0, arg1, null);
    }
    
    public sessionResponse login(String arg0,String arg1,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://web/","login");
        soapReq.addProperty("arg0",arg0);
        soapReq.addProperty("arg1",arg1);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://web/login", soapEnvelope,headers);
            }else{
                httpTransport.call("http://web/login", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject)obj;
                    sessionResponse resultVariable =  new sessionResponse (j);
                    return resultVariable;
                    
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }
    
    public void getMeetsByUserAsync(String arg0) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getMeetsByUserAsync(arg0, null);
    }
    
    public void getMeetsByUserAsync(final String arg0,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, meetsResponse>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected meetsResponse doInBackground(Void... params) {
                return getMeetsByUser(arg0, headers);
            }
            @Override
            protected void onPostExecute(meetsResponse result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getMeetsByUser", result);
                }
            }
        }.execute();
    }
    
    public meetsResponse getMeetsByUser(String arg0){
        return getMeetsByUser(arg0, null);
    }
    
    public meetsResponse getMeetsByUser(String arg0,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://web/","getMeetsByUser");
        soapReq.addProperty("arg0",arg0);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://web/getMeetsByUser", soapEnvelope,headers);
            }else{
                httpTransport.call("http://web/getMeetsByUser", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject)obj;
                    meetsResponse resultVariable =  new meetsResponse (j);
                    return resultVariable;
                    
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }
    
    public void getMeetsByCategoryAsync(String arg0,String arg1) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getMeetsByCategoryAsync(arg0, arg1, null);
    }
    
    public void getMeetsByCategoryAsync(final String arg0,final String arg1,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, meetsResponse>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected meetsResponse doInBackground(Void... params) {
                return getMeetsByCategory(arg0, arg1, headers);
            }
            @Override
            protected void onPostExecute(meetsResponse result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getMeetsByCategory", result);
                }
            }
        }.execute();
    }
    
    public meetsResponse getMeetsByCategory(String arg0,String arg1){
        return getMeetsByCategory(arg0, arg1, null);
    }
    
    public meetsResponse getMeetsByCategory(String arg0,String arg1,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://web/","getMeetsByCategory");
        soapReq.addProperty("arg0",arg0);
        soapReq.addProperty("arg1",arg1);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://web/getMeetsByCategory", soapEnvelope,headers);
            }else{
                httpTransport.call("http://web/getMeetsByCategory", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject)obj;
                    meetsResponse resultVariable =  new meetsResponse (j);
                    return resultVariable;
                    
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }
    
    public void initAsync() throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        initAsync(null);
    }
    
    public void initAsync(final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Void doInBackground(Void... params) {
                init(headers);
                return null;
            }
            @Override
            protected void onPostExecute(Void result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("init", result);
                }
            }
        }.execute();
    }
    
    public void init(){
        init(null);
    }
    
    public void init(List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://web/","init");
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://web/init", soapEnvelope,headers);
            }else{
                httpTransport.call("http://web/init", soapEnvelope);
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
    }
    
    public void getMeetAsync(String arg0,int arg1) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getMeetAsync(arg0, arg1, null);
    }
    
    public void getMeetAsync(final String arg0,final int arg1,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, meetResponse>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected meetResponse doInBackground(Void... params) {
                return getMeet(arg0, arg1, headers);
            }
            @Override
            protected void onPostExecute(meetResponse result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getMeet", result);
                }
            }
        }.execute();
    }
    
    public meetResponse getMeet(String arg0,int arg1){
        return getMeet(arg0, arg1, null);
    }
    
    public meetResponse getMeet(String arg0,int arg1,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://web/","getMeet");
        soapReq.addProperty("arg0",arg0);
        soapReq.addProperty("arg1",arg1);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://web/getMeet", soapEnvelope,headers);
            }else{
                httpTransport.call("http://web/getMeet", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject)obj;
                    meetResponse resultVariable =  new meetResponse (j);
                    return resultVariable;
                    
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }
    
    public void leaveMeetAsync(String arg0,int arg1) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        leaveMeetAsync(arg0, arg1, null);
    }
    
    public void leaveMeetAsync(final String arg0,final int arg1,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, meetResponse>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected meetResponse doInBackground(Void... params) {
                return leaveMeet(arg0, arg1, headers);
            }
            @Override
            protected void onPostExecute(meetResponse result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("leaveMeet", result);
                }
            }
        }.execute();
    }
    
    public meetResponse leaveMeet(String arg0,int arg1){
        return leaveMeet(arg0, arg1, null);
    }
    
    public meetResponse leaveMeet(String arg0,int arg1,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://web/","leaveMeet");
        soapReq.addProperty("arg0",arg0);
        soapReq.addProperty("arg1",arg1);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://web/leaveMeet", soapEnvelope,headers);
            }else{
                httpTransport.call("http://web/leaveMeet", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject)obj;
                    meetResponse resultVariable =  new meetResponse (j);
                    return resultVariable;
                    
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }
    
    public void registerAsync(String arg0,String arg1,String arg2) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        registerAsync(arg0, arg1, arg2, null);
    }
    
    public void registerAsync(final String arg0,final String arg1,final String arg2,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, sessionResponse>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected sessionResponse doInBackground(Void... params) {
                return register(arg0, arg1, arg2, headers);
            }
            @Override
            protected void onPostExecute(sessionResponse result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("register", result);
                }
            }
        }.execute();
    }
    
    public sessionResponse register(String arg0,String arg1,String arg2){
        return register(arg0, arg1, arg2, null);
    }
    
    public sessionResponse register(String arg0,String arg1,String arg2,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://web/","register");
        soapReq.addProperty("arg0",arg0);
        soapReq.addProperty("arg1",arg1);
        soapReq.addProperty("arg2",arg2);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://web/register", soapEnvelope,headers);
            }else{
                httpTransport.call("http://web/register", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject)obj;
                    sessionResponse resultVariable =  new sessionResponse (j);
                    return resultVariable;
                    
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }
    
    public void joinMeetAsync(String arg0,int arg1) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        joinMeetAsync(arg0, arg1, null);
    }
    
    public void joinMeetAsync(final String arg0,final int arg1,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, meetResponse>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected meetResponse doInBackground(Void... params) {
                return joinMeet(arg0, arg1, headers);
            }
            @Override
            protected void onPostExecute(meetResponse result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("joinMeet", result);
                }
            }
        }.execute();
    }
    
    public meetResponse joinMeet(String arg0,int arg1){
        return joinMeet(arg0, arg1, null);
    }
    
    public meetResponse joinMeet(String arg0,int arg1,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://web/","joinMeet");
        soapReq.addProperty("arg0",arg0);
        soapReq.addProperty("arg1",arg1);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://web/joinMeet", soapEnvelope,headers);
            }else{
                httpTransport.call("http://web/joinMeet", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject)obj;
                    meetResponse resultVariable =  new meetResponse (j);
                    return resultVariable;
                    
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }
    
    public void getMeetsAsync(String arg0,String arg1,boolean arg1Specified,String arg2,boolean arg2Specified) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getMeetsAsync(arg0, arg1, arg1Specified, arg2, arg2Specified, null);
    }
    
    public void getMeetsAsync(final String arg0,final String arg1,final boolean arg1Specified,final String arg2,final boolean arg2Specified,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, meetsResponse>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected meetsResponse doInBackground(Void... params) {
                return getMeets(arg0, arg1, arg1Specified, arg2, arg2Specified, headers);
            }
            @Override
            protected void onPostExecute(meetsResponse result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getMeets", result);
                }
            }
        }.execute();
    }
    
    public meetsResponse getMeets(String arg0,String arg1,boolean arg1Specified,String arg2,boolean arg2Specified){
        return getMeets(arg0, arg1, arg1Specified, arg2, arg2Specified, null);
    }
    
    public meetsResponse getMeets(String arg0,String arg1,boolean arg1Specified,String arg2,boolean arg2Specified,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://web/","getMeets");
        soapReq.addProperty("arg0",arg0);
        soapReq.addProperty("arg1",arg1);
        soapReq.addProperty("arg1Specified",arg1Specified);
        soapReq.addProperty("arg2",arg2);
        soapReq.addProperty("arg2Specified",arg2Specified);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://web/getMeets", soapEnvelope,headers);
            }else{
                httpTransport.call("http://web/getMeets", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject)obj;
                    meetsResponse resultVariable =  new meetsResponse (j);
                    return resultVariable;
                    
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }
    
    public void createMeetAsync(String arg0,String arg1,String arg2,String arg3,String arg4,String arg5,boolean arg5Specified,int arg6) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        createMeetAsync(arg0, arg1, arg2, arg3, arg4, arg5, arg5Specified, arg6, null);
    }
    
    public void createMeetAsync(final String arg0,final String arg1,final String arg2,final String arg3,final String arg4,final String arg5,final boolean arg5Specified,final int arg6,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, meetResponse>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected meetResponse doInBackground(Void... params) {
                return createMeet(arg0, arg1, arg2, arg3, arg4, arg5, arg5Specified, arg6, headers);
            }
            @Override
            protected void onPostExecute(meetResponse result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("createMeet", result);
                }
            }
        }.execute();
    }
    
    public meetResponse createMeet(String arg0,String arg1,String arg2,String arg3,String arg4,String arg5,boolean arg5Specified,int arg6){
        return createMeet(arg0, arg1, arg2, arg3, arg4, arg5, arg5Specified, arg6, null);
    }
    
    public meetResponse createMeet(String arg0,String arg1,String arg2,String arg3,String arg4,String arg5,boolean arg5Specified,int arg6,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://web/","createMeet");
        soapReq.addProperty("arg0",arg0);
        soapReq.addProperty("arg1",arg1);
        soapReq.addProperty("arg2",arg2);
        soapReq.addProperty("arg3",arg3);
        soapReq.addProperty("arg4",arg4);
        soapReq.addProperty("arg5",arg5);
        soapReq.addProperty("arg5Specified",arg5Specified);
        soapReq.addProperty("arg6",arg6);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://web/createMeet", soapEnvelope,headers);
            }else{
                httpTransport.call("http://web/createMeet", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject)obj;
                    meetResponse resultVariable =  new meetResponse (j);
                    return resultVariable;
                    
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }
    
    public void getCategoriesAsync(String arg0) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getCategoriesAsync(arg0, null);
    }
    
    public void getCategoriesAsync(final String arg0,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, categoriesResponse>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected categoriesResponse doInBackground(Void... params) {
                return getCategories(arg0, headers);
            }
            @Override
            protected void onPostExecute(categoriesResponse result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getCategories", result);
                }
            }
        }.execute();
    }
    
    public categoriesResponse getCategories(String arg0){
        return getCategories(arg0, null);
    }
    
    public categoriesResponse getCategories(String arg0,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://web/","getCategories");
        soapReq.addProperty("arg0",arg0);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://web/getCategories", soapEnvelope,headers);
            }else{
                httpTransport.call("http://web/getCategories", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject)obj;
                    categoriesResponse resultVariable =  new categoriesResponse (j);
                    return resultVariable;
                    
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }
    
    public void logoutAsync(String arg0) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        logoutAsync(arg0, null);
    }
    
    public void logoutAsync(final String arg0,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, returnCodeResponse>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected returnCodeResponse doInBackground(Void... params) {
                return logout(arg0, headers);
            }
            @Override
            protected void onPostExecute(returnCodeResponse result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("logout", result);
                }
            }
        }.execute();
    }
    
    public returnCodeResponse logout(String arg0){
        return logout(arg0, null);
    }
    
    public returnCodeResponse logout(String arg0,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://web/","logout");
        soapReq.addProperty("arg0",arg0);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://web/logout", soapEnvelope,headers);
            }else{
                httpTransport.call("http://web/logout", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject)obj;
                    returnCodeResponse resultVariable =  new returnCodeResponse (j);
                    return resultVariable;
                    
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }
    
}
