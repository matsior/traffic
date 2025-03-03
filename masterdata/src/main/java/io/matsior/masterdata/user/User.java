package io.matsior.masterdata.user;

import com.fasterxml.jackson.annotation.JsonProperty;

record User(@JsonProperty("name") String name,
            @JsonProperty("email") String email) {
}
