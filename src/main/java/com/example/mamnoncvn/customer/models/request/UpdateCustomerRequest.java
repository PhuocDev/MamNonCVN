package com.example.mamnoncvn.customer.models.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class UpdateCustomerRequest {

    @NotNull(message = "Id of update cannot be null")
    private Long id;
    @Column(name = "ghi_chu")
    private String ghiChu;

    @NotNull
    private Boolean status;

    public UpdateCustomerRequest() {

    }

    public UpdateCustomerRequest(Long id, String ghiChu, Boolean status) {
        this.id = id;
        this.ghiChu = ghiChu;
        this.status = status;
    }
}
