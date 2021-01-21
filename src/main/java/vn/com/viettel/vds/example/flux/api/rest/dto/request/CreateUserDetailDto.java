package vn.com.viettel.vds.example.flux.api.rest.dto.request;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.validation.constraints.NotEmpty;

@Data
@FieldNameConstants
public class CreateUserDetailDto {
    @NotEmpty(message = "firstName khong the rong")
    private String firstName;
    @NotEmpty(message = "lastName khong the rong")
    private String lastName;
    @NotEmpty(message = "career khong the rong")
    private String career;
}
