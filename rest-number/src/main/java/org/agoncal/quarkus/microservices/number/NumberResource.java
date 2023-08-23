package org.agoncal.quarkus.microservices.number;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

import java.time.Instant;
import java.util.Random;

@Path("/api/numbers")
@Tag(name = "Number REST endpoint")
public class NumberResource {

    @Inject
    Logger logger;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public IsbnNumbers generateIsbnNumbers() {
        IsbnNumbers isbnNumbers = new IsbnNumbers();
        isbnNumbers.isbn13 = "13-" + new Random().nextInt(100_000_000);
        isbnNumbers.isbn10 = "10-" + new Random().nextInt(100_000);
        isbnNumbers.generationDate = Instant.now();
        logger.info("Numbers generated " + isbnNumbers);
        return isbnNumbers;
    }

}
