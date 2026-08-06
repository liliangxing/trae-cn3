package com.bytedance.trae;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes5.dex */
public @interface ServiceType {
    public static final String AUDIO = "Audio";
    public static final String BASIC_SERVICE = "Basic";
    public static final String BASIC_TEC = "Infra";
    public static final String DOC = "Doc";
    public static final String DORA = "DORA";
    public static final String DRIVE = "Drive";
    public static final String FIRST_PART = "AISDK";
    public static final String IM = "Message";
    public static final String MAIN_BOT = "MainBot";
    public static final String OFFICE = "Office";
    public static final String UGC = "Social";
}
