package io.github.deepanshut041.serendeepia.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@ApiModel(value = "Register Request", description = "This Login request model")
@NoArgsConstructor
public class RegisterDto {

    @NotBlank
    @ApiModelProperty(notes = "Your full name for registration", required = true)
    private String name;

    @NotBlank
    @Email
    @ApiModelProperty(notes = "Your Email for registration", required = true)
    private String email;

    @NotBlank
    @ApiModelProperty(notes = "Your password for registration. Must be 8 digit long", required = true)
    private String password;
}
