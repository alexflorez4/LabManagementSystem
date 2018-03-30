package com.cop.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientRestCall {

    public static void main(String[] args) {

        Client client = Client.create();
        String url = "http://localhost:8080/faulms/getAllUsers";

        WebResource webResource = client.resource(url);

        ClientResponse response = webResource
                .header("Content-Type", "application/json")
                .accept("application/json")
                .get(ClientResponse.class);

        String out = response.getEntity(String.class);
        System.out.println(out);

        //From here, you need to parse the string to an json object, use the
        //model to form either LabDetailsModel or UserModel object
    }
}
