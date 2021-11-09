package com.example.demo;

import com.example.demo.bean.Address;
import com.example.demo.mapper.AddressMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created with IntelliJ IDEA.
 * To change it use File | Settings | Editor | File and Code Templates.
 *
 * @author Peter
 * @date 2021/11/9 11:23
 * @description TODO
 */
@SpringBootTest
public class AddressTest {
    @Autowired
    AddressMapper addressMapper;

    @Test
    public void testInsert() {
        Address address = new Address(null, "中国深圳", "mingzhijie", "147852369");

        int insert = addressMapper.insert(address);
        System.out.println("insert = " + insert);
        System.out.println("address = " + address);
    }
}
