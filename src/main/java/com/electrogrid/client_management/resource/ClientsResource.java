package com.electrogrid.client_management.resource;

import com.electrogrid.client_management.model.Clients;
import com.electrogrid.client_management.repository.ClientsRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/clients")
public class ClientsResource {

    ClientsRepository repo = new ClientsRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List <Clients> getClients() {
        System.out.println("Get Clients");
        return repo.getClients();
    }

    @GET
    @Path("client/{clientsID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Clients getClient(@PathParam("clientsID") int clientsID) {

        return repo.getClients(clientsID);

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Clients createBills(Clients c1){

        System.out.println(c1);
        repo.createClient(c1);
        return c1;

    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Clients updateClient(Clients c1){

        System.out.println(c1);
        if (repo.getClients(c1.getClientsID()).getClientsID()==0) {
            repo.createClient(c1);
        }
        else{
            repo.updateClient(c1);
        }
        return c1;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Clients deleteClients(@PathParam("id") int id){

        Clients c = repo.getClients(id);
        if (c.getClientsID()!=0){
            repo.deleteClient(id);
        }
        return c;
    }



}
