package com.zz.apiinterface;

import com.zz.apiclientsdk.client.ApiClient;
import com.zz.apiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class ApiInterfaceApplicationTests {
    @Resource
    private ApiClient apiClient;

    @Test
    void contextLoads() {
        String zz = apiClient.getNameByGet("zz");
        User user = new User();
        user.setUsername("ziye zhang");
        System.out.println(apiClient.getUsernameByPost(user));

    }

}
