package com.ra.session10.model.dto;

import com.ra.session10.validator.UniqueEmail;
import com.ra.session10.validator.UniquePhone;
import com.ra.session10.validator.UniqueUsername;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerUpdateDTO {
    @NotBlank(message = "Email không được để trống.")
    private String username;

    @Size(min = 6, message = "Password phải có ít nhất 6 ký tự.")
    private String password;

    @Email(message = "Email không hợp lệ.")
    private String email;

    @NotBlank(message = "Phone không được để trống.")
    @Pattern(regexp = "^(03|05|07|08|09)\\d{8}$", message = "Số điện thoại không hợp lệ.")
    private String phone;

    private Boolean status ;

    private String role ;
}