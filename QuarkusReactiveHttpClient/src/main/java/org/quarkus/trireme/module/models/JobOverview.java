package org.quarkus.trireme.module.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class JobOverview{
    public String jid;
    public String name;
    public boolean isStoppable;
    public String state;
    @JsonProperty("start-time")
    public long startTime;
    @JsonProperty("end-time")
    public int endTime;
    public int duration;
    public int maxParallelism;
    public long now;
}

