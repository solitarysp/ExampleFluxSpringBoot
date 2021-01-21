package vn.com.viettel.vds.example.flux.application.repository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.viettel.vds.example.flux.domain.entity.UserDetailEntity;
import vn.com.viettel.vds.example.flux.domain.repository.UserDetailRepository;
import vn.com.viettel.vds.example.flux.infrastructure.database.user.entity.UserEntity;
import vn.com.viettel.vds.example.flux.infrastructure.database.user.repository.UserRepo;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DefaultUserDetailRepository implements UserDetailRepository {
    @Autowired
    UserRepo userRepo;


    @Override
    public List<UserDetailEntity> getAllUserDetail() {
        List<UserEntity> userEntities = (List<UserEntity>) userRepo.findAll();
        List<UserDetailEntity> userDetailEntities = new ArrayList<>();
        userEntities.forEach(userEntity -> {
            UserDetailEntity userDetailEntity = new UserDetailEntity();
            userDetailEntity.setId(userEntity.getId());
            userDetailEntity.setFirstName(userEntity.getFirstName());
            userDetailEntity.setLastName(userEntity.getLastName());
            userDetailEntities.add(userDetailEntity);
        });
        return userDetailEntities;
    }

    @Override
    public UserDetailEntity save(UserDetailEntity userDetailEntity) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userDetailEntity.getFirstName());
        userEntity.setLastName(userDetailEntity.getLastName());
        userEntity = userRepo.save(userEntity);
        UserDetailEntity result = new UserDetailEntity();
        BeanUtils.copyProperties(userEntity, result);
        return result;
    }

}
