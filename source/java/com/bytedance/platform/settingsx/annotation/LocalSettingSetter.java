package com.bytedance.platform.settingsx.annotation;

/* loaded from: classes4.dex */
public @interface LocalSettingSetter {
    int forceBlockIndex() default -1;

    @Deprecated
    boolean isHeaderBlock() default false;

    String key();
}
