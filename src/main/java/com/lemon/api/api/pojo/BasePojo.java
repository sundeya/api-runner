package com.lemon.api.api.pojo;

import com.lemon.api.api.untils.DateUntils;
import com.lemon.api.api.untils.LoginUntils;
import lombok.Data;

import java.util.Date;

@Data
public class BasePojo {
    private String id;
    private String createUser= LoginUntils.getCrentUserId();
    private String createTime= DateUntils.formatYmdhms(new Date());
}
