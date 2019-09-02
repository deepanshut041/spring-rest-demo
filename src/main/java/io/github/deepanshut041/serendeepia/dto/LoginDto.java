package io.github.deepanshut041.serendeepia.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@ApiModel(value = "Login Request", description = "This Login request model")
public class LoginDto {

    @NotBlank
    @Email
    @ApiModelProperty(notes = "Your email for login", required = true)
    private String email;

    @NotBlank
    @ApiModelProperty(notes = "Your password for login", required = true)
    private String password;
}
