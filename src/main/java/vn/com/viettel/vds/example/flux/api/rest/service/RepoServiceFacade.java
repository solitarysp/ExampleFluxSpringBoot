package vn.com.viettel.vds.example.flux.api.rest.service;

import reactor.core.publisher.Mono;
import vn.com.viettel.vds.example.flux.api.rest.dto.request.CreateUserDetailDto;
import vn.com.viettel.vds.example.flux.domain.entity.UserDetailEntity;

import java.util.List;

public interface RepoServiceFacade {
    Mono<List<UserDetailEntity>> getAllUserDetail();
    Mono<UserDetailEntity> addUserDetail(CreateUserDetailDto createUserDetailDto);
}
