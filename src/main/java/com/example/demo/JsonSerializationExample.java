package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

public class JsonSerializationExample {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        MyJavaClass myJavaObject = new MyJavaClass();
        myJavaObject.setIField(100);
        myJavaObject.setSField("hello");
        myJavaObject.setSField("hello2");

        String json = mapper.writeValueAsString(myJavaObject); //serialization
        System.out.println(json);

        MyJavaClass myJavaObject2 = mapper.readValue(json, MyJavaClass.class); //deserialization
        System.out.println(myJavaObject2.sField);
    }

    @Getter @Setter
    public static class MyJavaClass {
        private String sField;
        private int iField;
    }

}
