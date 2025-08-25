package com.ra.session10.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentDTO {
    @NotBlank(message = "Student name không được để trống")
    private String studentName;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;

    @NotNull(message = "Điểm số không được để trống")
    @Min(value = 0, message = "Điểm số phải lớn hơn 0")
    private Float ageMark;

    private Boolean isStudying;
}
