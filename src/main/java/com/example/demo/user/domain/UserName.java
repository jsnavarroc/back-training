package com.example.demo.user.domain;

import com.example.demo.common.Preconditions;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

@Value(staticConstructor = "of")
public class UserName {

    String value;


    private UserName(String value) {
        Preconditions.checkNotNull(value);
        Preconditions.checkAgument(StringUtils.isNotBlank(value));
        Preconditions.checkAgument(value.length() >= 6 );
        this.value = value;
    }
}

