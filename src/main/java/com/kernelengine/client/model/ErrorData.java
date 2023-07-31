package com.kernelengine.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ErrorData {

    @JsonProperty("error")
    private String error;

    public String getError() {
        return this.error;
    }
}
