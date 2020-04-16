package com.example.demo.user.domain;

import com.example.demo.common.Preconditions;
import org.apache.commons.lang3.StringUtils;

public class UserName {
    public  static  UserName of(String value){
        return new UserName(value);
    }

    private final String value;


    private UserName(String value) {
        Preconditions.checkNotNull(value);
        Preconditions.checkAgument(StringUtils.isNotBlank(value));
        Preconditions.checkAgument(value.length() >= 6 );
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "UserName{" +
                "value='" + value + '\'' +
                '}';
    }
}

