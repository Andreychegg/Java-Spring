package org.example.web.dto;

import javax.validation.constraints.NotBlank;

public class RemoveByRegex {

    @NotBlank
    private String queryRegex;

    public String getQueryRegex() {
        return queryRegex;
    }

    public void setQueryRegex(String queryRegex) {
        this.queryRegex = queryRegex;
    }
}
