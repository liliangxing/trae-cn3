package com.bytedance.android.monitor.util;

import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;

/* loaded from: classes3.dex */
public class NavigationUtil {
    public static String generateID() {
        return System.currentTimeMillis() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + UUID.randomUUID().toString();
    }
}
