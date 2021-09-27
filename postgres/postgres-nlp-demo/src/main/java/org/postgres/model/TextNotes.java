package org.postgres.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonValue;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.Tuple;
import org.jboss.logging.Logger;
import org.w3c.dom.Text;


public class TextNotes  {


    public int id;

    public String content;

    private static final Logger textNotesLogger = Logger.getLogger(TextNotes.class);

    public TextNotes(int id,String content)
    {
        this.id = id;
        this.content = content;
    }

    public Uni<Integer> save(PgPool client) {
        return client.preparedQuery("INSERT INTO documents (document_id,document_text,document_tokens) VALUES ($1,$2,to_tsvector($2))").execute(Tuple.of(id,content))
                .onItem().transform(pgRowSet -> id);
    }

    private static TextNotes from(Row row) {
        return new TextNotes(row.getInteger("document_id"), row.getString("document_text"));
    }


    public Multi<TextNotes> findAll(PgPool client,String word) {

        

        textNotesLogger.infof("Current word for search is %s",word);

        if(word.contains(" "))
        {
            word = word.replaceAll(" "," <-> ");
            textNotesLogger.infof("Modified word for search is %s",word);
        }

        return  client
                /*.preparedQuery
                ("SELECT document_id, document_text FROM documents WHERE document_tokens @@ to_tsquery($1)")*/
                .preparedQuery("SELECT ts_rank_cd(document_tokens,to_tsquery($1)) AS score," +
                        " document_id,document_text FROM documents" +
                        " WHERE document_tokens @@ to_tsquery($1) ORDER BY score DESC")
                .execute(Tuple.of(word))
                .onItem().transformToMulti(set -> Multi.createFrom().iterable(set))
                .onItem().transform(TextNotes::from);
    }



}

