package com.jay.java8.collectors;

import com.jay.bean.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @author jay
 *
 *  collect是一个将数据流缩减为一个值的归约操作。这个值可以是集合、映射，或者一个值对象
 *
 * @create 2019-09-25 11:49
 **/

public class CollectorsDemo {


    public static void main(String[] args) {

        User mj = new User("mj");
        User yy = new User("yy");
        User nkx = new User("mkx");
        List<User> userList = new ArrayList<>();
        userList.add(mj);
        userList.add(yy);
        userList.add(nkx);

        userList.stream().collect(groupingBy(User::getName));

    }

    /**
     * @return
     * @Author mj
     * @Description 使用流和收集器在Java8中编写有名的字数统计
     * @Date 2019/9/25 14:12
     * @Param
     **/
    public static void wordCount(Path path) throws IOException {
        Map<String, Long> wordCount = Files.lines(path)
                .parallel()
                .flatMap(line -> Arrays.stream(line.trim().split("\\s")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
                .filter(word -> word.length() > 0)
                .map(word -> new AbstractMap.SimpleEntry<>(word, 1))
                .collect(groupingBy(AbstractMap.SimpleEntry::getKey, counting()));
        wordCount.forEach((k, v) -> System.out.println(String.format("%s ==>> %d", k, v)));
    }
}
