package org.postgres.search.word;

import io.smallrye.mutiny.Multi;
import org.postgres.model.TextNotes;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/searchWordAndPhrasesAcrossRecords")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SearchPhrasesAndWordAcrossRecords {

    @Inject
    io.vertx.mutiny.pgclient.PgPool client;

    @GET
    @Transactional
    public Multi<TextNotes> searchAcrossNotes(TextNotes textNotes) {

        return textNotes.findAll(client,textNotes.content);
    }


}
