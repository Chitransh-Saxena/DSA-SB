package com.me.DSA.dynamicprogramming.houserobber;

import com.me.DSA.dynamicprogramming.houserobber.impl.RecursiveHouseRobber;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class HouseRobberTest {

    @Test
    public void testRecursiveRobbery() {

        RecursiveHouseRobber robber = new RecursiveHouseRobber();
        int[] money = {1, 2, 3, 1};

        Assert.assertEquals(4, robber.rob(money));

        money = new int[]{2, 7, 9, 3, 1};
        Assert.assertEquals(12, robber.rob(money));
    }
}
