package com.github.patsalyukas.outsideclasses;

import com.github.patsalyukas.common.utils.Wish;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovingTest {

    @Test
    void move() {
        assertEquals(Result.SUCCESS, new ClientMoving().move(Wish.YES));
        assertEquals(Result.FAILURE, new ClientMoving().move(Wish.NO));
    }
}