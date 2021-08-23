package com.ftn.ApotekaApp.dto;

public class LekFilterDTO {

    private String status;

    public LekFilterDTO(String status) {
        this.status = status;
    }

    public LekFilterDTO() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
