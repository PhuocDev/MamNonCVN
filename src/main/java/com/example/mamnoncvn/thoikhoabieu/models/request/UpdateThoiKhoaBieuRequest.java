package com.example.mamnoncvn.thoikhoabieu.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateThoiKhoaBieuRequest {

    @NotNull
    private Long id;

    @NotBlank(message = "Name of TKB can not be null")
    private String tenTKB;


    private String description;


    private String anhBia;


    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayBatDau;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayKetThuc;

    @NotNull
    private String noiDung;

    @NotNull
    private boolean status;

    @NotNull
    private Long maLop;
}
