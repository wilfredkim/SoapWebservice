package com.wilfred.soap.SoapExample.endpoints;

import com.wilfred.soap.SoapExample.repository.StudentRepository;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import webservice.StudentDetailsRequest;
import webservice.StudentDetailsResponse;

@Endpoint
public class StudentEndpoint {
   // private static final String NAMESPACE_URI = "http://www.howtodoinjava.com/xml/school";
    private StudentRepository studentRepository;

    public StudentEndpoint(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @ResponsePayload
    @PayloadRoot( localPart = "StudentDetailsRequest")
    public StudentDetailsResponse getStudent(@RequestPayload StudentDetailsRequest studentDetailsRequest) {
        System.out.println("tume hit endpoint");
        StudentDetailsResponse response = new StudentDetailsResponse();
        response.setStudent(studentRepository.findStudent(studentDetailsRequest.getName()));

        return response;
    }
}
