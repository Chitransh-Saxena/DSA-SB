package com.me.DSA.dynamicprogramming.houserobber.impl;

import com.me.DSA.dynamicprogramming.houserobber.HouseRobber;

public class RecursiveHouseRobber implements HouseRobber {

    @Override
    public int rob(int[] money) {
        return robRec(0, money);
    }

    public int robRec(int idx, int[] money) {

        if(idx >= money.length) return 0;

        int choice1 = robRec(idx+1, money);
        int choice2 = money[idx] + robRec(idx+2, money);

        return Math.max(choice1, choice2);
    }
}
