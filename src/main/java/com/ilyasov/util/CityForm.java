package com.ilyasov.util;

import org.hibernate.validator.constraints.NotBlank;

public class CityForm {
    @NotBlank(message = "Incorrect name!")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
