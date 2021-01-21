package vn.com.viettel.vds.example.flux.api.rest.router;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import vn.com.viettel.vds.example.flux.api.rest.dto.request.CreateUserDetailDto;
import vn.com.viettel.vds.example.flux.api.rest.service.RepoServiceFacade;
import vn.com.viettel.vds.example.flux.domain.entity.UserDetailEntity;

import java.util.List;

@RestController
@RequestMapping("/ExampleFlux/full/v1/api/users")
@Slf4j
@RequiredArgsConstructor
public class UserDetailController {
    @Autowired
    RepoServiceFacade userDetailService;

    @GetMapping(produces = "application/json", consumes = "application/json")
    public Mono<List<UserDetailEntity>> getAllUsers() {
        return userDetailService.getAllUserDetail();
    }

    @GetMapping(value = "sayhello", produces = "application/json", consumes = "application/json")
    public Mono<String> sayHello() {
        return Mono.just("Hello");
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @Transactional
    public Mono<UserDetailEntity> addUser(@RequestBody CreateUserDetailDto createUserDetailDto) {
        return userDetailService.addUserDetail(createUserDetailDto);
    }
}
