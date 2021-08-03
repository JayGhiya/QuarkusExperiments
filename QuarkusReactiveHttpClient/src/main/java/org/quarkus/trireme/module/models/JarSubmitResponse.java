package org.quarkus.trireme.module.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.metrics.annotation.Gauge;

@Setter
@Getter
@JsonIgnoreProperties
public class JarSubmitResponse {

    @JsonProperty("jobid")
    private String jobId;
}
