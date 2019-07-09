package ca.jrvs.apps.twitter.example;

import ca.jrvs.apps.twitter.example.dto.Company;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class JsonParser {
        public static final String companystr="{\n" +
                " \"symbol\" : \"AAPL\",\n" +
                " \"companyName\" : \"Apple Inc.\",\n" +
                " \"exchange\" : \"Nasdaq Global Select\",\n" +
                " \"description\" : \"Apple Inc is designs, manufactures and markets mobile communication and media devices and personal computers, and sells a variety of related software, services, accessories,networking solutions and third-party digital content and applications.\",\n" +
                " \"sector\" : \"Technology\",\n" +
                " \"financials\" : [ {\n" +
                "   \"reportDate\" : \"2018-12-31\",\n" +
                "   \"grossProfit\" : 32131000000,\n" +
                "   \"costOfRevenue\" : 52279000000,\n" +
                "   \"operatingRevenue\" : 84310000000,\n" +
                "   \"totalRevenue\" : 84310000000,\n" +
                "   \"operatingIncome\" : 23346000000,\n" +
                "   \"netIncome\" : 19965000000\n" +
                " }, {\n" +
                "   \"reportDate\" : \"2018-09-30\",\n" +
                "   \"grossProfit\" : 24084000000,\n" +
                "   \"costOfRevenue\" : 38816000000,\n" +
                "   \"operatingRevenue\" : 62900000000,\n" +
                "   \"totalRevenue\" : 62900000000,\n" +
                "   \"operatingIncome\" : 16118000000,\n" +
                "   \"netIncome\" : 14125000000\n" +
                " } ],\n" +
                " \"dividends\" : [ {\n" +
                "   \"exDate\" : \"2018-02-09\",\n" +
                "   \"paymentDate\" : \"2018-02-15\",\n" +
                "   \"recordDate\" : \"2018-02-12\",\n" +
                "   \"declaredDate\" : \"2018-02-01\",\n" +
                "   \"amount\" : 0.63\n" +
                " }, {\n" +
                "   \"exDate\" : \"2017-11-10\",\n" +
                "   \"paymentDate\" : \"2017-11-16\",\n" +
                "   \"recordDate\" : \"2017-11-13\",\n" +
                "   \"declaredDate\" : \"2017-11-02\",\n" +
                "   \"amount\" : 0.63\n" +
                " } ],\n" +
                " \"ceo\" : \"Timothy D. Cook\"\n" +
                "} ";

        public static String toJson(Object object,boolean prettyJson) throws JsonProcessingException {

            ObjectMapper mapper = new ObjectMapper();
            if(prettyJson){
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
            }
            return mapper.writeValueAsString(object);
        }
        public static <T> T toObjectFromJson(String json,Class clas) throws IOException{
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return (T) mapper.readValue(json,clas);
        }
        public static void main(String[] args) throws IOException{
            Company company = toObjectFromJson(companystr,Company.class);
            System.out.println(company.toString());

        }


}
