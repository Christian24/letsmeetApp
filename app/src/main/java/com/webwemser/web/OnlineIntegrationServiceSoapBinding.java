package com.webwemser.web;




//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 4.5.6.0
//
// Created by Quasar Development at 15/06/2016
//
//---------------------------------------------------




import org.ksoap2.HeaderProperty;
import org.ksoap2.serialization.*;
import org.ksoap2.transport.*;

import java.util.Date;
import java.util.List;


public class OnlineIntegrationServiceSoapBinding
{
    interface IWcfMethod
    {
        ExtendedSoapSerializationEnvelope CreateSoapEnvelope() throws Exception;

        Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope, Object result) throws Exception;
    }

    String url="http://10.0.2.2:8080/letsmeet/OnlineIntegration";

    int timeOut=60000;
    public List< HeaderProperty> httpHeaders;
    public boolean enableLogging;

    IServiceEvents callback;
    public OnlineIntegrationServiceSoapBinding(){}

    public OnlineIntegrationServiceSoapBinding(IServiceEvents callback)
    {
        this.callback = callback;
    }
    public OnlineIntegrationServiceSoapBinding(IServiceEvents callback, String url)
    {
        this.callback = callback;
        this.url = url;
    }

    public OnlineIntegrationServiceSoapBinding(IServiceEvents callback, String url, int timeOut)
    {
        this.callback = callback;
        this.url = url;
        this.timeOut=timeOut;
    }

    protected Transport createTransport()
    {
        try
        {
            java.net.URI uri = new java.net.URI(url);
            if(uri.getScheme().equalsIgnoreCase("https"))
            {
                int port=uri.getPort()>0?uri.getPort():443;
                return new HttpsTransportSE(uri.getHost(), port, uri.getPath(), timeOut);
            }
            else
            {
                return new HttpTransportSE(url,timeOut);
            }

        }
        catch (java.net.URISyntaxException e)
        {
        }
        return null;
    }
    
    protected ExtendedSoapSerializationEnvelope createEnvelope()
    {
        ExtendedSoapSerializationEnvelope envelope= new ExtendedSoapSerializationEnvelope(ExtendedSoapSerializationEnvelope.VER11);
        return envelope;
    }
    
    protected List sendRequest(String methodName, ExtendedSoapSerializationEnvelope envelope, Transport transport  )throws Exception
    {
        return transport.call(methodName, envelope, httpHeaders);
    }

    Object getResult(Class destObj,Object source,String resultName,ExtendedSoapSerializationEnvelope __envelope) throws Exception
    {
        if(source==null)
        {
            return null;
        }
        if(source instanceof SoapPrimitive)
        {
            SoapPrimitive soap =(SoapPrimitive)source;
            if(soap.getName().equals(resultName))
            {
                Object instance=__envelope.get(source,destObj);
                return instance;
            }
        }
        else
        {
            SoapObject soap = (SoapObject)source;
            if (soap.hasProperty(resultName))
            {
                Object j=soap.getProperty(resultName);
                if(j==null)
                {
                    return null;
                }
                Object instance=__envelope.get(j,destObj);
                return instance;
            }
            else if( soap.getName().equals(resultName)) {
                Object instance=__envelope.get(source,destObj);
                return instance;
            }
       }

       return null;
    }

        
    public SessionResponse deleteMeet(final String arg0, final Integer arg1 ) throws Exception
    {
        return (SessionResponse)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://web.letsmeet/", "deleteMeet");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg1";
                __info.type=PropertyInfo.INTEGER_CLASS;
                __info.setValue(arg1);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope, Object __result)throws Exception {
                return (SessionResponse)getResult(SessionResponse.class,__result,"return",__envelope);
            }
        },"");
    }
    
    public android.os.AsyncTask< Void, Void, OperationResult<SessionResponse>> deleteMeetAsync(final String arg0, final Integer arg1)
    {
        return executeAsync(new Functions.IFunc<SessionResponse>() {
            public SessionResponse Func() throws Exception {
                return deleteMeet( arg0,arg1);
            }
        });
    }
    
    public ReturnCodeResponse deleteUser(final String arg0 ) throws Exception
    {
        return (ReturnCodeResponse)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://web.letsmeet/", "deleteUser");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope, Object __result)throws Exception {
                return (ReturnCodeResponse)getResult(ReturnCodeResponse.class,__result,"return",__envelope);
            }
        },"");
    }
    
    public android.os.AsyncTask< Void, Void, OperationResult<ReturnCodeResponse>> deleteUserAsync(final String arg0)
    {
        return executeAsync(new Functions.IFunc<ReturnCodeResponse>() {
            public ReturnCodeResponse Func() throws Exception {
                return deleteUser( arg0);
            }
        });
    }
    
    public MeetsResponse getMeets(final String arg0, final Date arg1, final Date arg2 ) throws Exception
    {
        return (MeetsResponse)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://web.letsmeet/", "getMeets");
                __envelope.setOutputSoapObject(__soapReq);

                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg1";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg1!=null?Helper.getDateTimeFormat().format(arg1):SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg2";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg2!=null?Helper.getDateTimeFormat().format(arg2):SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }

            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (MeetsResponse)getResult(MeetsResponse.class,__result,"return",__envelope);
            }
        },"");
    }
    

    
    public MeetResponse deleteReply(final String arg0, final Integer arg1 ) throws Exception
    {
        return (MeetResponse)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://web.letsmeet/", "deleteReply");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg1";
                __info.type=PropertyInfo.INTEGER_CLASS;
                __info.setValue(arg1);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope, Object __result)throws Exception {
                return (MeetResponse)getResult(MeetResponse.class,__result,"return",__envelope);
            }
        },"");
    }
    
    public android.os.AsyncTask< Void, Void, OperationResult<MeetResponse>> deleteReplyAsync(final String arg0, final Integer arg1)
    {
        return executeAsync(new Functions.IFunc<MeetResponse>() {
            public MeetResponse Func() throws Exception {
                return deleteReply( arg0,arg1);
            }
        });
    }
    
    public MeetResponse deleteConversation(final String arg0, final Integer arg1 ) throws Exception
    {
        return (MeetResponse)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://web.letsmeet/", "deleteConversation");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg1";
                __info.type=PropertyInfo.INTEGER_CLASS;
                __info.setValue(arg1);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope, Object __result)throws Exception {
                return (MeetResponse)getResult(MeetResponse.class,__result,"return",__envelope);
            }
        },"");
    }
    
    public android.os.AsyncTask< Void, Void, OperationResult<MeetResponse>> deleteConversationAsync(final String arg0, final Integer arg1)
    {
        return executeAsync(new Functions.IFunc<MeetResponse>() {
            public MeetResponse Func() throws Exception {
                return deleteConversation( arg0,arg1);
            }
        });
    }
    
    public MeetResponse createMeet(final String arg0, final String arg1, final String arg2, final String arg3, final String arg4, final Long arg5, final Integer arg6 ) throws Exception
    {
        return (MeetResponse)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://web.letsmeet/", "createMeet");
                __envelope.setOutputSoapObject(__soapReq);

                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg1";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg1!=null?arg1:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg2";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg2!=null?arg2:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg3";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg3!=null?arg3:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg4";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg4!=null?arg4:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg5";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg5!=null?Helper.getDateTimeFormat().format(arg5):SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg6";
                __info.type=PropertyInfo.INTEGER_CLASS;
                __info.setValue(arg6);
                __soapReq.addProperty(__info);
                return __envelope;
            }

            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (MeetResponse)getResult(MeetResponse.class,__result,"return",__envelope);
            }
        },"");
    }
    
    public android.os.AsyncTask< Void, Void, OperationResult<MeetResponse>> createMeetAsync(final String arg0, final String arg1, final String arg2, final String arg3, final String arg4, final Long arg5, final Integer arg6)
    {
        return executeAsync(new Functions.IFunc<MeetResponse>() {
            public MeetResponse Func() throws Exception {
                return createMeet( arg0,arg1,arg2,arg3,arg4,arg5,arg6);
            }
        });
    }
    
    public MeetResponse getMeet(final String arg0, final Integer arg1 ) throws Exception
    {
        return (MeetResponse)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://web.letsmeet/", "getMeet");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg1";
                __info.type=PropertyInfo.INTEGER_CLASS;
                __info.setValue(arg1);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope, Object __result)throws Exception {
                return (MeetResponse)getResult(MeetResponse.class,__result,"return",__envelope);
            }
        },"");
    }
    
    public android.os.AsyncTask< Void, Void, OperationResult<MeetResponse>> getMeetAsync(final String arg0, final Integer arg1)
    {
        return executeAsync(new Functions.IFunc<MeetResponse>() {
            public MeetResponse Func() throws Exception {
                return getMeet( arg0,arg1);
            }
        });
    }
    
    public MeetResponse leaveMeet(final String arg0, final Integer arg1 ) throws Exception
    {
        return (MeetResponse)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://web.letsmeet/", "leaveMeet");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg1";
                __info.type=PropertyInfo.INTEGER_CLASS;
                __info.setValue(arg1);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope, Object __result)throws Exception {
                return (MeetResponse)getResult(MeetResponse.class,__result,"return",__envelope);
            }
        },"");
    }
    
    public android.os.AsyncTask< Void, Void, OperationResult<MeetResponse>> leaveMeetAsync(final String arg0, final Integer arg1)
    {
        return executeAsync(new Functions.IFunc<MeetResponse>() {
            public MeetResponse Func() throws Exception {
                return leaveMeet( arg0,arg1);
            }
        });
    }
    
    public SessionResponse register(final String arg0, final String arg1, final String arg2 ) throws Exception
    {
        return (SessionResponse)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://web.letsmeet/", "register");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg1";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg1!=null?arg1:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg2";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg2!=null?arg2:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope, Object __result)throws Exception {
                return (SessionResponse)getResult(SessionResponse.class,__result,"return",__envelope);
            }
        },"");
    }
    
    public android.os.AsyncTask< Void, Void, OperationResult<SessionResponse>> registerAsync(final String arg0, final String arg1, final String arg2)
    {
        return executeAsync(new Functions.IFunc<SessionResponse>() {
            public SessionResponse Func() throws Exception {
                return register( arg0,arg1,arg2);
            }
        });
    }
    
    public MeetResponse joinMeet(final String arg0, final Integer arg1 ) throws Exception
    {
        return (MeetResponse)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://web.letsmeet/", "joinMeet");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg1";
                __info.type=PropertyInfo.INTEGER_CLASS;
                __info.setValue(arg1);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope, Object __result)throws Exception {
                return (MeetResponse)getResult(MeetResponse.class,__result,"return",__envelope);
            }
        },"");
    }
    
    public android.os.AsyncTask< Void, Void, OperationResult<MeetResponse>> joinMeetAsync(final String arg0, final Integer arg1)
    {
        return executeAsync(new Functions.IFunc<MeetResponse>() {
            public MeetResponse Func() throws Exception {
                return joinMeet( arg0,arg1);
            }
        });
    }
    
    public SessionResponse updateUserDescription(final String arg0, final String arg1 ) throws Exception
    {
        return (SessionResponse)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://web.letsmeet/", "updateUserDescription");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg1";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg1!=null?arg1:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope, Object __result)throws Exception {
                return (SessionResponse)getResult(SessionResponse.class,__result,"return",__envelope);
            }
        },"");
    }
    
    public android.os.AsyncTask< Void, Void, OperationResult<SessionResponse>> updateUserDescriptionAsync(final String arg0, final String arg1)
    {
        return executeAsync(new Functions.IFunc<SessionResponse>() {
            public SessionResponse Func() throws Exception {
                return updateUserDescription( arg0,arg1);
            }
        });
    }
    
    public ReturnCodeResponse logout(final String arg0 ) throws Exception
    {
        return (ReturnCodeResponse)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://web.letsmeet/", "logout");
                __envelope.setOutputSoapObject(__soapReq);
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }

            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (ReturnCodeResponse)getResult(ReturnCodeResponse.class,__result,"return",__envelope);
            }
        },"");
    }

    

    
    public CategoriesResponse getCategories(final String arg0 ) throws Exception
    {
        return (CategoriesResponse) execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://web.letsmeet/", "getCategories");
                __envelope.setOutputSoapObject(__soapReq);
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }

            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (CategoriesResponse)getResult(CategoriesResponse.class,__result,"return",__envelope);
            }
        },"");
    }
    

    
    public String replyToConversation(final String arg0,final String arg1,final String arg2 ) throws Exception
    {
/*This feature is available in Premium account, Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account*/
        return null;    
    }
    
    public android.os.AsyncTask< Void, Void, OperationResult< String>> replyToConversationAsync(final String arg0, final String arg1, final String arg2)
    {
        return executeAsync(new Functions.IFunc< String>() {
            public String Func() throws Exception {
                return replyToConversation( arg0,arg1,arg2);
            }
        });
    }
    
    public SessionResponse updateUserPassword(final String arg0,final String arg1 ) throws Exception
    {
        return (SessionResponse)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://web.letsmeet/", "updateUserPassword");
                __envelope.setOutputSoapObject(__soapReq);
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg1";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg1!=null?arg1:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }

            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (SessionResponse)getResult(SessionResponse.class,__result,"return",__envelope);
            }
        },"");
    }
    
   /* public android.os.AsyncTask< Void, Void, OperationResult< SessionResponse>> updateUserPasswordAsync(final String arg0, final String arg1)
    {
        return executeAsync(new Functions.IFunc< String>() {
            public String Func() throws Exception {
                return updateUserPassword( arg0,arg1);
            }
        });
    }*/
    
    public String updateMeet(final String arg0,final String arg1,final String arg2,final String arg3,final String arg4,final String arg5,final String arg6,final String arg7 ) throws Exception
    {
/*This feature is available in Premium account, Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account*/
        return null;    
    }
    
    public android.os.AsyncTask< Void, Void, OperationResult< String>> updateMeetAsync(final String arg0, final String arg1, final String arg2, final String arg3, final String arg4, final String arg5, final String arg6, final String arg7)
    {
        return executeAsync(new Functions.IFunc< String>() {
            public String Func() throws Exception {
                return updateMeet( arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
            }
        });
    }
    
    public MeetsResponse getMeetsByCategory(final String arg0,final String arg1 ) throws Exception
    {
        return (MeetsResponse)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://web.letsmeet/", "getMeetsByCategory");
                __envelope.setOutputSoapObject(__soapReq);

                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg1";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg1!=null?arg1:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }

            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (MeetsResponse)getResult(MeetsResponse.class,__result,"return",__envelope);
            }
        },"");
    }
    

    
    public SessionResponse login(final String arg0,final String arg1 ) throws Exception
    {
        return (SessionResponse)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://web.letsmeet/", "login");
                __envelope.setOutputSoapObject(__soapReq);

                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg1";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg1!=null?arg1:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }

            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (SessionResponse)getResult(SessionResponse.class,__result,"return",__envelope);
            }
        },"");
    }

    public android.os.AsyncTask< Void, Void, OperationResult<SessionResponse>> loginAsync(final String arg0,final String arg1)
    {
        return executeAsync(new Functions.IFunc< SessionResponse>() {
            public SessionResponse Func() throws java.lang.Exception {
                return login( arg0,arg1);
            }
        });
    }


    

    
    public String createNewConversation(final String arg0,final String arg1,final String arg2 ) throws Exception
    {
/*This feature is available in Premium account, Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account*/
        return null;    
    }
    
    public android.os.AsyncTask< Void, Void, OperationResult< String>> createNewConversationAsync(final String arg0, final String arg1, final String arg2)
    {
        return executeAsync(new Functions.IFunc< String>() {
            public String Func() throws Exception {
                return createNewConversation( arg0,arg1,arg2);
            }
        });
    }
    
    public MeetsResponse getMeetsByUser(final String arg0 ) throws Exception
    {
        return (MeetsResponse)execute(new IWcfMethod()
        {
            @Override
            public ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://web.letsmeet/", "getMeetsByUser");
                __envelope.setOutputSoapObject(__soapReq);

                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }

            @Override
            public java.lang.Object ProcessResult(ExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (MeetsResponse)getResult(MeetsResponse.class,__result,"return",__envelope);
            }
        },"");
    }
    

    
    public String getCategoriesWithMeets(final String arg0 ) throws Exception
    {
/*This feature is available in Premium account, Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account*/
        return null;    
    }
    
    public android.os.AsyncTask< Void, Void, OperationResult< String>> getCategoriesWithMeetsAsync(final String arg0)
    {
        return executeAsync(new Functions.IFunc< String>() {
            public String Func() throws Exception {
                return getCategoriesWithMeets( arg0);
            }
        });
    }

    
    protected Object execute(IWcfMethod wcfMethod, String methodName) throws Exception
    {
        Transport __httpTransport=createTransport();
        __httpTransport.debug=enableLogging;
        ExtendedSoapSerializationEnvelope __envelope=wcfMethod.CreateSoapEnvelope();
        try
        {
            sendRequest(methodName, __envelope, __httpTransport);
            
        }
        finally {
            if (__httpTransport.debug) {
                if (__httpTransport.requestDump != null) {
                    android.util.Log.i("requestDump",__httpTransport.requestDump);    
                    
                }
                if (__httpTransport.responseDump != null) {
                    android.util.Log.i("responseDump",__httpTransport.responseDump);
                }
            }
        }
        Object __retObj = __envelope.bodyIn;
        if (__retObj instanceof org.ksoap2.SoapFault){
            org.ksoap2.SoapFault __fault = (org.ksoap2.SoapFault)__retObj;
            throw convertToException(__fault,__envelope);
        }else{
            return wcfMethod.ProcessResult(__envelope,__retObj);
        }
    }
    
    protected < T> android.os.AsyncTask< Void, Void, OperationResult< T>>  executeAsync(final Functions.IFunc< T> func)
    {
        return new android.os.AsyncTask< Void, Void, OperationResult< T>>()
        {
            @Override
            protected void onPreExecute() {
                callback.Starting();
            };
            @Override
            protected OperationResult< T> doInBackground(Void... params) {
                OperationResult< T> result = new OperationResult< T>();
                try
                {
                    result.Result= func.Func();
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                    result.Exception=ex;
                }
                return result;
            }
            
            @Override
            protected void onPostExecute(OperationResult< T> result)
            {
                callback.Completed(result);
            }
        }.execute();
    }
        
    Exception convertToException(org.ksoap2.SoapFault fault,ExtendedSoapSerializationEnvelope envelope)
    {

        return new Exception(fault.faultstring);
    }
}


