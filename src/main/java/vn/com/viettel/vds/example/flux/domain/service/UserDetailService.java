package vn.com.viettel.vds.example.flux.domain.service;

import vn.com.viettel.vds.example.flux.domain.entity.UserDetailEntity;

import java.util.List;

public interface UserDetailService {
    List<UserDetailEntity> getAllUserDetail();

    UserDetailEntity addUserDetail(UserDetailEntity userDetailEntity);
}
