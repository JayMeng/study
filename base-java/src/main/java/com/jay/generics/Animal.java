package com.jay.generics;

import java.util.List;

/**
 * @author jay
 * @create 2019-09-25 16:36
 **/

public class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

    }

    // 限定通配符和非限定通配符
    //  <? extends T>
    //  <? super T>
    //  <?>
    public void list(List<? extends Animal> list){
//        list.add(new Animal("动物"));

    }

}
