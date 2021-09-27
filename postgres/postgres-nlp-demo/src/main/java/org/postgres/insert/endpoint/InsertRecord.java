package org.postgres.insert.endpoint;

import io.smallrye.mutiny.Uni;
import org.postgres.model.TextNotes;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.net.URI;

import static org.jboss.resteasy.reactive.RestResponse.StatusCode.CREATED;

@Path("/insertDbRecord")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InsertRecord {

    @Inject
    io.vertx.mutiny.pgclient.PgPool client;

    @POST
    public Uni<Response> storeNotes(TextNotes textNotes) {

        return textNotes.save(client)
                .onItem().transform(id -> URI.create("/insertDbRecord/" + id))
                .onItem().transform(uri -> Response.created(uri).build());
    }
}