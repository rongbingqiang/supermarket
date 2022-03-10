package com.rong.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rong.entity.Order;
import com.rong.entity.Product;
import com.rong.entity.User;
import com.rong.mapper.UserMapper;
import com.rong.service.impl.AddressServiceImpl;
import com.rong.service.impl.OrderServiceImpl;
import com.rong.service.impl.ProductServiceImpl;
import com.rong.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @title: UserMapperTests
 * @projectName supermarket
 * @description: TODO
 * @author 荣兵强
 * @date 2022/1/2511:19
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AddressServiceImpl addressService;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void insert(){
        User user = new User();
        user.setUid(1462);
        user.setUsername("r5o6ng");
        user.setPassword("rr");

       User a =userService.changePassword(user.getUid(),user.getUsername(),user.getPassword(),"33");
        System.out.println(a);
    }

    @Test
    public void insertAddress(){
//        User user = userService.login("rongbingxiu", "123");
//        System.out.println(user);
        Order order = new Order();
        order.setOid(25);
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<Order>(order);
//    QueryWrapper<User> userQueryWrapper = Wrappers.query(); 和上面一样的效果
      //  userQueryWrapper.select("oid", "age").like("username" , "k").lt("age" , 35);
//    userQueryWrapper.like("username" , "k").lt("age" , 35).select("username", "age");
//    把select()放在最后面也可以，但我一般喜欢放在最前面，和sql语法保持一致
//        orderQueryWrapper.select(Order.class,o ->{
//            o.ge
//        })

//        List<User> userList = userMapper.selectList(userQueryWrapper);
//        userList.forEach(System.out::println);
        Order orderInfo = orderService.getBaseMapper().selectOne(orderQueryWrapper);
        System.out.println(orderInfo);
    }

}
