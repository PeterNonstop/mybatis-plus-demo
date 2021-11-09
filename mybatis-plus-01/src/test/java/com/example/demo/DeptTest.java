package com.example.demo;

import com.example.demo.bean.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created with IntelliJ IDEA.
 * To change it use File | Settings | Editor | File and Code Templates.
 *
 * @author Peter
 * @date 2021/11/8 15:44
 * @description TODO
 */
@SpringBootTest
public class DeptTest {

    @Test
    public void testArAdd() {
        Dept dept = new Dept();
        dept.setName("张李王");
        dept.setMobile("0755-123654789");
        dept.setManager(123);

        boolean insert = dept.insert();
        System.out.println("dept = " + dept);
    }

    @Test
    public void testUpdate() {
        Dept dept = new Dept();
        dept.setId(1);
        dept.setName("文化苦旅");

        boolean b = dept.updateById();
        System.out.println("dept = " + dept);
    }
}
