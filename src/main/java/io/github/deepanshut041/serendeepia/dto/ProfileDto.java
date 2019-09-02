package io.github.deepanshut041.serendeepia.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Profile Response", description = "This profile response model")
public class ProfileDto {

    @ApiModelProperty(notes = "User id, It is unique")
    private Long id;

    @ApiModelProperty(notes = "User email, It is unique")
    private String email;

    @ApiModelProperty(notes = "Full name user")
    private String name;
}
