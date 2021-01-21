package vn.com.viettel.vds.example.flux.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@FieldNameConstants
@NoArgsConstructor
public class UserDetailEntity implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
}
