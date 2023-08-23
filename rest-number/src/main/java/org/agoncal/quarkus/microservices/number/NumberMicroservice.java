package org.agoncal.quarkus.microservices.number;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@ApplicationPath("/")
@OpenAPIDefinition(
        info = @Info(
                title = "Number Microservice",
                description = "This microservice generates book numbers",
                version = "1.0",
                contact = @Contact(name = "@vipul", url = "https://vipulmeh23.github.io")
        ),
        externalDocs = @ExternalDocumentation(
                url = "https://github.com/vipulmeh23", description = "All microservice code"),
        tags = {
                @Tag(name = "API", description = "Public API that can be accessed by everyone"),
                @Tag(name = "Numbers", description = "For anyone interested in book ISBN numbers")
        }
)

public class NumberMicroservice extends Application {
}
