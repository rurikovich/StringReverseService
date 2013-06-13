package org.stringReverse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


/**
 * Created with IntelliJ IDEA.
 * User: Rurik
 * Date: 11.06.13
 * Time: 22:37
 * To change this template use File | Settings | File Templates.
 */


@Endpoint
public class StringReverseEndpoint {

    private static final String namespaceUri = "http://www.stringReverse.org/StringReverseService";

    @Autowired
    private StringReverseService stringReverseService;


    public StringReverseService getStringReverseService() {
        return stringReverseService;
    }

    public void setStringReverseService(StringReverseService stringReverseService) {
        this.stringReverseService = stringReverseService;
    }


    @PayloadRoot(localPart = "ServiceRequest", namespace = namespaceUri)
    public
    @ResponsePayload
    ServiceResponse handleMathServiceRequest(@RequestPayload ServiceRequest serviceRequest) {

        String input = serviceRequest.getInput();

        ServiceResponse r = new ServiceResponse();

        r.setOutput(getStringReverseService().getOutput(input));

        return r;
    }


}
