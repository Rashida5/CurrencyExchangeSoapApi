package org.example.Exceptions;


import jakarta.xml.ws.WebFault;

@WebFault
public class ParserException extends Exception{

    private String code;
    public ParserException(String message , String FaultCode){
        super(message);
        this.code= FaultCode;

    }
    public String getCode(){
        return code;
    }
}
