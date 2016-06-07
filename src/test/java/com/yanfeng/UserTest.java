package com.yanfeng;


import com.yanfeng.entity.Student;
import com.yanfeng.entity.StudentExample;
import com.yanfeng.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yanfeng on 2016/5/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UserTest {
//    @Autowired(required = true)
//    @Qualifier("userMapper")
////    @Resource
//    private UserMapper userMapper;

//    @Resource
//    private StudentMapper studentMapper;

    @Test
    public void getNearbyNum()  {
        System.out.println(123);
//        User load = userMapper.load(1);
//        System.out.print(load.toString());
    }



//    @Test
//    public void test1(){
//        StudentExample example = new StudentExample();
//        example.or().andNameLike("%yan%");
//        System.out.print(studentMapper.selectByExample(example).get(0).toString());
//    }
}
