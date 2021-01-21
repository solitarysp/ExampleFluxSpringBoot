package vn.com.viettel.vds.example.flux.api.rest.dto.request;

import lombok.Data;

@Data
public class PostUserAndAddressRequestDto {
    private PostUserRequestDto userDto;
    private PostAddressRequestDto addressDto;
}
