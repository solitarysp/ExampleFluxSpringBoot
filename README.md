# Java Core archetype DDD Client

## Overview :

- Đây là project Demo cho việc tích hợp java Core archetype lib vào dự án. Với việc sử dụng kiến trúc hexagon

### Lưu ý :

- Sau khi tạo mới một project, cần nhờ đội devops config để chạy tích hợp CI/CD cloud với bên mình xem thành công hay
  chưa, sau đó thì mới bắt đầu code tiếp

# Require structural  client

```
---src
|   +---main
|   |   +---java
|   |   |   \---vn
|   |   |       \---com
|   |   |           \---viettel
|   |   |               \---vds
|   |   |                   \---archclientddd
|   |   |                       |   Application.java # Main Start app
|   |   |                       |   
|   |   |                       +---api # Các API Open cho client giao tiếp đến
|   |   |                       |   +---grpc # định nghĩa các GRPC và các component chỉ phục vụ cho GRPC
|   |   |                       |   |       HelloWorldGRPCServerController.java
|   |   |                       |   |       
|   |   |                       |   +---rest # Định nghĩa các restful và các component chỉ phục vụ cho rest
|   |   |                       |   |   +---aop
|   |   |                       |   |   |       .gitkeep
|   |   |                       |   |   |       
|   |   |                       |   |   +---constant
|   |   |                       |   |   |       ResponseStatusCodeEnumClient.java
|   |   |                       |   |   |       
|   |   |                       |   |   +---dto # DTO của rest
|   |   |                       |   |   |   +---request
|   |   |                       |   |   |   |       CreateUserDetailDto.java
|   |   |                       |   |   |   |       PostAddressRequestDto.java
|   |   |                       |   |   |   |       PostUserAndAddressRequestDto.java
|   |   |                       |   |   |   |       PostUserRequestDto.java
|   |   |                       |   |   |   |       
|   |   |                       |   |   |   \---response
|   |   |                       |   |   |           PostUserAndAddressResponseDto.java
|   |   |                       |   |   |           
|   |   |                       |   |   +---exception  # Định nghĩa exception của rest định nghĩa
|   |   |                       |   |   |       .gitkeep
|   |   |                       |   |   |       
|   |   |                       |   |   +---router # Nơi config các đầu API rest
|   |   |                       |   |   |   |   UserDetailController.java
|   |   |                       |   |   \---service # Service của rest
|   |   |                       |   |       |   RepoServiceFacade.java
|   |   |                       |   |       |   
|   |   |                       |   |       \---impl
|   |   |                       |   |               DefaultRepoServiceFacade.java
|   |   |                       |   |               
|   |   |                       |   \---stream 
|   |   |                       |       \---kafka
|   |   |                       |               DemoListenKafka.java
|   |   |                       |               
|   |   |                       +---application # chứa các config, component của application; là cầu nối giữa tầng nghiệp vụ (domain) và tầng presentation (api) và infrastructure)
|   |   |                       |   +---configuration # Chứa các config ví dụ config connect db..etc..
|   |   |                       |   |       AddressDatabaseConfig.java
|   |   |                       |   |       ChainedTransactionManageConfig.java
|   |   |                       |   |       UserDatabaseConfig.java
|   |   |                       |   |       
|   |   |                       |   +---exception # chứa các exception mà layer application định nghĩa
|   |   |                       |   |       .gitkeep
|   |   |                       |   |       
|   |   |                       |   +---repository # Repo của application thường impl repo của domain sau đó thực hiện các hành vi CURD
|   |   |                       |   |       UserDetailRepositoryImpl.java
|   |   |                       |   |       
|   |   |                       |   \---service # Service application, thường impl của domain để phục vụ business của domain
|   |   |                       |           UserDetailServiceImpl.java
|   |   |                       |           
|   |   |                       +---commons # Chứa các utils commons
|   |   |                       |       StringUtils.java
|   |   |                       |       
|   |   |                       +---domain #  (chứa mọi thông tin về  business domain)
|   |   |                       |   +---entity # Chứa các entity của domain
|   |   |                       |   |       UserDetailEntity.java
|   |   |                       |   |       
|   |   |                       |   +---exceptions # Định nghĩa các exceptions mà domain định nghĩa
|   |   |                       |   |       UserDetailException.java
|   |   |                       |   |       
|   |   |                       |   +---repository # Các hoạt động trên entity
|   |   |                       |   |       UserDetailRepository.java
|   |   |                       |   |       
|   |   |                       |   \---service # Các dịch vụ của domain
|   |   |                       |           UserDetailService.java
|   |   |                       |           
|   |   |                       \---infrastructure #  Chứa các kết nối với các thành phần bên ngoài để phục vụ cho ứng dụng (DB,MQ...)
|   |   |                           \---database
|   |   |                               +---address
|   |   |                               |   +---entity
|   |   |                               |   |       AddressEntity.java
|   |   |                               |   |       
|   |   |                               |   \---repository
|   |   |                               |           AddressEntityRepo.java
|   |   |                               |           
|   |   |                               \---user
|   |   |                                   +---entity
|   |   |                                   |       UserEntity.java
|   |   |                                   |       
|   |   |                                   \---repository
|   |   |                                           UserRepo.java
|   |   |                                           
|   |   \---resources
|   |           application.properties
|   |           bootstrap.properties
|   |           messages_en.properties
|   |           messages_vi.properties
|   |           
|   \---test
|       +---java
|       |   \---vn
|       |       \---com
|       |           \---viettel
|       |               \---vds
|       |                   \---archclientddd
|       |                           DemoTest.java
|       |                           
|       \---resources
```

# Các thuộc tính bắt buộc

Tên thuộc tính | Data Type | Ví dụ | Mô tả
  --- | --- | --- | --- 
app.application-context-name| string | arch-client | sử dụng để định nghĩa context name cho project
app.application-short-name| string | arch-ct | Giống app.application-context-name nhưng nên là một short name
info.build.artifact| string | @project.artifactId@ | sử dụng cho api get info
info.build.name| string |@project.name@| sử dụng cho api get info
info.build.description| string |@project.description@| sử dụng cho api get info
info.build.version| string |@project.version@| sử dụng cho api get info

# Hướng dẫn build app thành archetype ( Dành cho máy không kết nối repo công ty hoặc cho người deploy )

- 1 : Tại thư mục gốc của dự án. Xóa 1 số file config của iDEA đi ( .idea, *.iml... )
- 2 : Chạy lệnh `mvn archetype:create-from-project -Darchetype.properties=archetype.properties`
- 3 : Vào floder `target/generated-sources/archetype`
- 4 : Chạy lệnh `mvn clean install`

# Info archetype

Field | Value
 --- | --- 
GroupId | vn.com.viettel.vds.archclientddd
ArtifactId | arch-client-ddd-archetype
Version |    1.0.1

## Sử dụng để tạo mới project từ arch:

Việc sử dụng tùy thuộc vào IDE đang sử dụng.

- NetBeans:

    - Sau khi thực hiện xong bước Cài đặt. Khởi động netbeans. đợi netbean index lại toàn bộ repository
    - Chọn New Project/Maven/Project from Archtype
    - Chọn tên Archtype tương ứng.
    - Điền thông tin và next đến cuối

- IntelliJ:

    - Cài đặt và cấu hình plug-in Maven Archtype Catalogs và làm theo hướng dẫn tại
      đây [tại đây](https://plugins.jetbrains.com/plugin/7965-maven-archetype-catalogs)
    - Chon repo maven catalog local hoặc trên
      server `http://nexus.digital.vn/repository/maven-releases/archetype-catalog.xml`
    - Tạo project Maven, click vào `create from archtype`.
    - Chọn archtype tương ứng (`arch-client-ddd-archetype`).
    - Điền thông tin, next đến cuối

- Không dùng IDE:

```bash
mvn archetype:generate                                  \
  -DarchetypeGroupId=<archetype-groupId>                \
  -DarchetypeArtifactId=<archetype-artifactId>          \
  -DarchetypeVersion=<archetype-version>                \
  -DgroupId=<my.groupid>                                \
  -DartifactId=<my-artifactId>
```

# Config file host cho 1 số kết nối đến ứng dụng bên ngoài

## window

C:\Windows\System32\drivers\etc\hosts

## linux

/etc/host

```
10.255.135.21 nexus.digital.vn swagger.digital.vn jenkins.digital.vn sonar.digital.vn gitlab.digital.vn kibana.digital.vn
10.255.133.69 gw-alpha.digital.vn mountebank-alpha.digital.vn kong-admin-alpha.digital.vn spi-alpha.digital.vn s3-alpha.digital.vn log-alpha.digital.vn vault-alpha.digital.vn
10.255.133.162 kong-admin-staging.digital.vn gw-staging.digital.vn prometheus-staging.digital.vn prometheus-alert-staging.digital.vn log-staging.digital.vn spi-staging.digital.vn

10.255.133.82   kafka-1
10.255.133.83   kafka-2
10.255.133.84   kafka-3
10.58.244.141 web-alpha.digital.vn
10.255.63.9 mobile-money-webapi-uat.digital.vn mobile-money-web-uat.digital.vn
```

# Hướng dẫn fix một số lỗi khi deploy

Error | Fix
 --- | --- 
Lỗi check health 404  | Liên hệ với đội deploy kiểm tra file ```bootstrap.properties```  xem có đang để ```management.endpoints.web.exposure.include``` hay không. Nếu có yêu cầu xóa bỏ để mặc định
Lỗi log thành nhiều dòng -> log trên sv không ra json | Kiểm tra các thư viện thêm mới và exclusions các thư viện log đi ( ví dụ ở spring-boot-starter-test)

# Luồng ví dụ trong demo

- Ví dụ demo về quảng lý thông tin người dùng, thông tin người dùng gồm tên và địa chỉ. Tên và địa chỉ được lưu ở 2
  database khác nhau <br/> Demo ví dụ một luồng tạo và lấy thông tin người dùng.

## Các class tiêu điểm và mối quan hệ giữa các class đó.

Type |Tên class/Interface | Layer |  Mô tả
  --- |   --- | --- | --- 
Class | UserDetailEntity | domain-entity | Khai báo enity user detail với các thông tin tên địa chỉ.
Interface | UserDetailRepository | domain-repository | Khai báo các hành động lưu trữ trên UserDetailEntity
Interface | UserDetailService | domain-service | Khai báo các dịch vụ hoạt động trên UserDetailEntity
class | UserDetailRepositoryImpl | application-repository | Impl interface UserDetailRepository của domain, để thực hiện impl logic lưu trữ UserDetailEntity đến các nơi khác nhau..etc.. <br/> Ở đây sẽ giao tiếp với infrastructure
class | UserDetailServiceImpl | application-service | Impl interface UserDetailService của domain, để thực hiện impl logic business
class | AddressEntity | database-address-entity | ĐỊnh nghĩa entity address trên database
interface | AddressEntityRepo | database-address-repository | Chứa các method hành động trên database, như lưu, tìm kiếm...etc..
class | UserEntity | database-user-entity | ĐỊnh nghĩa entity User trên database
interface | UserRepo | database-user-repository | Chứa các method hành động trên database, như lưu, tìm kiếm...etc..