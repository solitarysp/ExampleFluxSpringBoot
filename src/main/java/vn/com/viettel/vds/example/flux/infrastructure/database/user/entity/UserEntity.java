package vn.com.viettel.vds.example.flux.infrastructure.database.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Table(name = "user")
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

}
