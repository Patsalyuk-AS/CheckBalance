package com.github.patsalyukas.outsideclasses;

import com.github.patsalyukas.client.Wish;

public interface Moving {

    default Result move(Wish wish) {
        return (wish == Wish.YES ? Result.SUCCESS : Result.FAILURE);
    }

}
