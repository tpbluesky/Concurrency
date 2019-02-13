package com.bluesky.concurrency.examples.publish;

import com.bluesky.concurrency.annotations.NotThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@NotThreadSafe
public class UnsafePublish {
    @Getter
    private String[] states = {"a", "b", "c"};

    public static void main(String[] args) {
        UnsafePublish publish = new UnsafePublish();
        publish.getStates()[0] = "d";
        log.info("states: {}", Arrays.toString(publish.getStates()));
    }
}
