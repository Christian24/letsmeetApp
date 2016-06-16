package com.webwemser.web;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 4.5.6.0
//
// Created by Quasar Development at 15/06/2016
//
//---------------------------------------------------


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.ksoap2.serialization.*;

public class ConversationData extends UserContentData implements KvmSerializable
{


    public Integer origin=0;

    public ArrayList<ReplyData> getReplies() {
        return replies;
    }

    public void setReplies(ArrayList<ReplyData> replies) {
        this.replies = replies;
    }

    public ArrayList< ReplyData> replies =new ArrayList<ReplyData >();

    public ConversationData ()
    {
    }

    public ConversationData (java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("origin"))
                {
                    if(obj!=null)
                    {

                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.origin = Integer.parseInt(j.toString());
                            }
                        }
                        else if (obj instanceof Integer){
                            this.origin = (Integer)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("replies"))
                {
                    if(obj!=null)
                    {


                        if(this.replies==null)
                        {
                            this.replies = new ArrayList<ReplyData>();
                        }
                        java.lang.Object j =obj;
                        ReplyData j1= (ReplyData)__envelope.get(j,ReplyData.class);
                        this.replies.add(j1);


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
            return origin;
        }
        if(propertyIndex>=count+1 && propertyIndex< count+ 1+this.replies.size())
        {
            return this.replies.get(propertyIndex-(count+1));
        }
        return super.getProperty(propertyIndex);
    }


    @Override
    public int getPropertyCount() {
        return super.getPropertyCount()+1+replies.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        int count = super.getPropertyCount();
        if(propertyIndex==count+0)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "origin";
            info.namespace= "";
        }
        if(propertyIndex>=count+1 && propertyIndex <= count+1+this.replies.size())
        {
            info.type = ReplyData.class;
            info.name = "replies";
            info.namespace= "";
        }
        super.getPropertyInfo(propertyIndex,arg1,info);
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    public List<UserContentData> getConversation() {
        ArrayList<UserContentData> conversation = new ArrayList<>();
        conversation.add(this);
        for(ReplyData reply : getReplies()){
            conversation.add(reply);
        }
       Collections.sort(conversation);
        return conversation;
    }
    public int getReplyCount() {
        return replies.size();
    }


}
