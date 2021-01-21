package vn.com.viettel.vds.example.flux.domain.repository;

import vn.com.viettel.vds.example.flux.domain.entity.UserDetailEntity;

import java.util.List;

public interface UserDetailRepository {
    List<UserDetailEntity> getAllUserDetail();

    UserDetailEntity save(UserDetailEntity userDetailEntity);
}
