package vn.com.viettel.vds.example.flux.infrastructure.database.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.com.viettel.vds.example.flux.infrastructure.database.user.entity.UserEntity;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Integer> {
    boolean existsByFirstNameAndLastName(String firstName, String lastName);
}
