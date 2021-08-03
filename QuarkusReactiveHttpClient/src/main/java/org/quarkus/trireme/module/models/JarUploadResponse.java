package org.quarkus.trireme.module.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
public class JarUploadResponse {

    @JsonProperty("filename")
    private String fileName;
    @JsonProperty("status")
    private String status;

}
