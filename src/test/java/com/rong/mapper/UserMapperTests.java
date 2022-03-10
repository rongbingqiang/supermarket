package com.rong.mapper;

import com.rong.entity.Address;
import com.rong.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @title: UserMapperTests
 * @projectName supermarket
 * @description: TODO
 * @author 荣兵强
 * @date 2022/1/2511:19
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void insert(){
        User user = new User();
        user.setUid(122);
        user.setUsername("rong");
        user.setPassword("rr");

        Integer a =userMapper.insert(user);
        System.out.println(a);
    }

    @Test
    public void insertAddress(){
        Address address = new Address();
        address.setUid(1645);
        addressMapper.insert(address);
    }
}
