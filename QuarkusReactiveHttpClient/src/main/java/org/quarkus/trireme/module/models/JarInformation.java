package org.quarkus.trireme.module.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties
public class JarInformation {

    private String address;
    private List<JarProperties> files;
}
