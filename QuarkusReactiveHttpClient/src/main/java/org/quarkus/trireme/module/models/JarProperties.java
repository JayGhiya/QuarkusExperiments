package org.quarkus.trireme.module.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
public class JarProperties {

    private String id;
    private String name;
    private long uploaded;

}
