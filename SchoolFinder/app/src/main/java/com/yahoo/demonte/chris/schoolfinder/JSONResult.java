package com.yahoo.demonte.chris.schoolfinder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

public class JSONResult {
    @JsonIgnore
    private String metadata;
    private School[] results;

    public JSONResult(){

    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public School[] getResults() {
        return results;
    }

    @JsonSetter("results")
    public void setResults(School[] results) {
        this.results = results;
    }
}
