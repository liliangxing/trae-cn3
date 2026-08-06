package com.bytedance.lego.init.model;

import com.bytedance.apm.block.BlockConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

/* loaded from: classes4.dex */
public enum DelayTime implements Serializable {
    SECOND_5(5000),
    SECOND_8(8000),
    SECOND_15(15000),
    SECOND_30(30000),
    SECOND_60(60000),
    MINUTE_2(120000),
    MINUTE_5(300000),
    MINUTE_10(BlockConstants.BUFFER_SIZE),
    MINUTE_15(Constants.MAX_VALID_TIME_FOR_REGISTRATION_REQUEST);

    private int value;

    DelayTime(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static DelayTime from(int i) {
        switch (i) {
            case 5000:
                return SECOND_5;
            case 8000:
                return SECOND_8;
            case 15000:
                return SECOND_15;
            case 30000:
                return SECOND_30;
            case 60000:
                return SECOND_60;
            case 120000:
                return MINUTE_2;
            case 300000:
                return MINUTE_5;
            case BlockConstants.BUFFER_SIZE /* 600000 */:
                return MINUTE_10;
            case Constants.MAX_VALID_TIME_FOR_REGISTRATION_REQUEST /* 900000 */:
                return MINUTE_15;
            default:
                return null;
        }
    }
}
