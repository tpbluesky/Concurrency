package com.bluesky.concurrency.examples.immutable;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class ImmutableExample1 {

    private final static int a = 10;
    private final static String b = "abc";
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
    }

    public static void main(String[] args) {
//        a = 11;
//        b = "haha"
//        map = Maps.newHashMap();
        map.put(1, 5);
        log.info("map : {}", map.toString());
    }
}
