package com.example.demo;

import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }


    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        //Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User();

        for (int i = 0; i < 10; i++) {
            String substring = UUID.randomUUID().toString().substring(0, 8);

            user.setName(substring);
            user.setAge((int) (20 + Math.random() * 10));
            user.setEmail(substring + "@sina.com");
            int insert = userMapper.insert(user);
        }

        System.out.println("user id = " + user.getId());
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setName("testName");
        user.setId("2");

        int i = userMapper.updateById(user);
        System.out.println("i = " + i);
    }

    @Test
    public void testDelete() {
        int deleteById = userMapper.deleteById("5");

        System.out.println("deleteById = " + deleteById);

    }

    /**
     * 按条件删除
     */
    @Test
    public void testDeleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "李四*");

        int deleteByMap = userMapper.deleteByMap(map);
        System.out.println("deleteByMap = " + deleteByMap);
    }

    /**
     * 根据主键批量删除
     */
    @Test
    public void deleteBatch() {
        List<String> list = new ArrayList<>();
        list.add("1457520642814455811");
        list.add("1457520642814455813");

        int batchIds = userMapper.deleteBatchIds(list);
        System.out.println("batchIds = " + batchIds);
    }

    @Test
    public void testSelectBatch() {
        List<String> list = new ArrayList<>();
        list.add("3");
        list.add("13");
        list.add("23");
        list.add("33");

        List<User> users = userMapper.selectBatchIds(list);
        for (User user : users) {
            System.out.println("users = " + user);
        }
    }

    @Test
    public void testLambda() {
        List<String> list = Stream.of("2", "12", "22", "32", "42", "992").collect(Collectors.toList());

        // Preparing: SELECT id,name,email,age FROM user WHERE id IN ( ? , ? , ? , ? , ? , ? )
        List<User> users = userMapper.selectBatchIds(list);
        //for (User user : users) {
        //    System.out.println("user = " + user);
        //}

        // 遍历集合
        users.forEach(user -> {
            System.out.println("user = " + user);
        });
    }

    /**
     *
     */
    @Test
    public void testSelectByMap() {
        Map<String, Object > map = new HashMap<>();
        map.put("name", "741ac173");
        map.put("age", "28");

        // Preparing: SELECT id,name,email,age FROM user WHERE name = ? AND age = ?
        List<User> users = userMapper.selectByMap(map);

        users.forEach(user ->{
            System.out.println("user = " + user);
        });
    }

}
