package vn.com.viettel.vds.example.flux.api.rest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import vn.com.viettel.vds.example.flux.api.rest.dto.request.CreateUserDetailDto;
import vn.com.viettel.vds.example.flux.application.service.DefaultUserDetailService;
import vn.com.viettel.vds.example.flux.domain.entity.UserDetailEntity;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class DefaultRepoServiceFacade implements RepoServiceFacade {
    @Autowired
    DefaultUserDetailService userDetailService;
    @Autowired
    @Qualifier("default-worker")
    Scheduler scheduler;

    @Override
    public Mono<List<UserDetailEntity>> getAllUserDetail() {
        return Mono.just(userDetailService.getAllUserDetail());
    }

    @Override
    public Mono<UserDetailEntity> addUserDetail(CreateUserDetailDto createUserDetailDto) {
        return Mono.just(createUserDetailDto).subscribeOn(scheduler)
                .filter(creteUserDto -> {
                    if(Objects.isNull(creteUserDto.getFirstName())){
                        return false;
                    }
                    if(Objects.isNull(creteUserDto.getLastName())){
                        return false;
                    }
                    return true;
                })
                .map(createUserDto -> {
                    UserDetailEntity userDetailEntity = new UserDetailEntity();
                    userDetailEntity.setFirstName(createUserDto.getFirstName());
                    userDetailEntity.setLastName(createUserDto.getLastName());
                    return userDetailEntity;
                }).doOnSuccess(userDetailEntity -> userDetailService.addUserDetail(userDetailEntity));
    }


}
