package com.ss.ttm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes7.dex */
public class AVTime {
    public static String getFormatNow() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm ss:SSS").format(new Date());
    }
}
