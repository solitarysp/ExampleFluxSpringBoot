package vn.com.viettel.vds.example.flux.application.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.viettel.vds.example.flux.application.repository.DefaultUserDetailRepository;
import vn.com.viettel.vds.example.flux.domain.entity.UserDetailEntity;
import vn.com.viettel.vds.example.flux.domain.service.UserDetailService;

import java.util.List;

@Service
@Slf4j
public class DefaultUserDetailService implements UserDetailService {
    @Autowired
    DefaultUserDetailRepository userDetailRepository;

    @Override
    public List<UserDetailEntity> getAllUserDetail() {
        return userDetailRepository.getAllUserDetail();
    }

    @Override
    public UserDetailEntity addUserDetail(UserDetailEntity userDetailEntity) {
        return userDetailRepository.save(userDetailEntity);
    }

}
