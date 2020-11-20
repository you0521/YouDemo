package com.example.youdemo.enumPage;

import com.example.youdemo.inter.RoleOperation;

/**
 * author：  jcy
 * data：2020/11/20
 * time：14:14
 * description：
 */
public enum RoleEnum implements RoleOperation {

    ONE(1) {
        @Override
        public String op() {
            return "111111";
        }
    },
    TWO(2) {
        @Override
        public String op() {
            return "2222222";
        }
    },
    THREE(3) {
        @Override
        public String op() {
            return "333333";
        }
    };

    private final int i;

    RoleEnum(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public static RoleEnum getRoleDnum(int type) {
        for (RoleEnum roleEnum : RoleEnum.values()) {
            if (roleEnum.getI() == type) {
                return roleEnum;
            }
        }
        return null;
    }

}