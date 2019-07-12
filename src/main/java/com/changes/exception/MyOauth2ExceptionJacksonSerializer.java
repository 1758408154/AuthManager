package com.changes.exception;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/**
 * @author LiuJunJie
 * @since 2019/7/2 11:16
 */
public class MyOauth2ExceptionJacksonSerializer extends StdSerializer<MyOauth2Exception> {

    public MyOauth2ExceptionJacksonSerializer(){
        super(MyOauth2Exception.class);
    }
    @Override
    public void serialize(MyOauth2Exception e, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("status", e.getHttpErrorCode());
        String errorMessage = e.getOAuth2ErrorCode();
        jsonGenerator.writeStringField("msg", e.getMessage());
        jsonGenerator.writeStringField("exception",e.getOAuth2ErrorCode());
        if (e.getAdditionalInformation()!=null) {
           e.getAdditionalInformation().forEach((key,value)->{
               try {
                   jsonGenerator.writeStringField(key, value);
               } catch (IOException e1) {
                   e1.printStackTrace();
               }
           });
        }
        jsonGenerator.writeEndObject();
    }
}
