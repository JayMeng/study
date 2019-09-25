package com.jay.java8.stream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * stream基本使用
 *
 * @author jay
 * @create 2019-05-06 10:07
 **/

public class Demo {

    public static void main(String[] args) throws IOException {
        List<UserDO> userDOList = new ArrayList<>();
        userDOList.add(UserDO.create(UserDO::new));
        userDOList.add(UserDO.create(UserDO::new));
        List<UserVO> userVOS = userDOList.stream().map(userDO -> {
            UserVO vo = new UserVO();
            vo.setName(userDO.getName());
            return vo;
        }).collect(Collectors.toList());
    }
}


class UserDO {
    String name;

    String mobile;

    public static UserDO create(Supplier<UserDO> supplier) {
        return supplier.get();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}

class UserVO {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "name='" + name + '\'' +
                '}';
    }
}
