package vn.com.viettel.vds.example.flux.api.rest.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class PostUserRequestDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull(message = "firstName là bắt buộc")
    @NotEmpty(message = "firstName là bắt buộc")
    private String firstName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull(message = "lastName là bắt buộc")
    @NotEmpty(message = "lastName là bắt buộc")

    private String lastName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull(message = "career là bắt buộc")
    @NotEmpty(message = "career là bắt buộc")
    private String career;
}
