package com.wj.sort;

import java.time.Duration;
import java.time.Instant;

/**
 * @author wangjie
 * @date 2020/9/1 23:22
 */
public class BaseSort {

    static void swap(int[] arr, int oldVal, int newVal) {
        int tmp = arr[oldVal];
        arr[oldVal] = arr[newVal];
        arr[newVal] = tmp;
    }

    void time() {
        Instant start = Instant.now();
        temp();
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("=======运行时间=========" + duration.getSeconds());

    }

      void temp(){};
}
