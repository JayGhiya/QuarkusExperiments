package org.quarkus.trireme.module.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties
@Setter
@Getter
public class JobMetric {

    private String id;
    private int min;
    private int max;
    private int avg;
    private int sum;


}
