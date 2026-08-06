package com.bytedance.lego.init.model;

import java.io.Serializable;

/* loaded from: classes4.dex */
public enum InitPeriod implements Serializable {
    APP_ATTACHBASE2SUPER(0),
    APP_SUPER2ATTACHBASEEND(1),
    APP_ONCREATE2SUPER(2),
    APP_SUPER2ONCREATEEND(3),
    SPLASH_ONCREATE2SUPER(4),
    SPLASH_SUPER2ONCREATEEND(5),
    SPLASH_ONRESUME2SUPER(6),
    SPLASH_SUPER2ONRESUMEEND(7),
    MAIN_ONCREATE2SUPER(8),
    MAIN_SUPER2ONCREATEEND(9),
    MAIN_ONRESUME2SUPER(10),
    MAIN_SUPER2ONRESUMEEND(11),
    NONE(12);

    private int value;

    InitPeriod(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
