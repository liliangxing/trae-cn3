package com.bytedance.pia.core.misc;

import android.os.Build;

/* loaded from: classes4.dex */
public class UserAgent {
    static /* synthetic */ String access$100() {
        return buildDefaultUserAgent();
    }

    public static String getDefault() {
        return LazyDefaultUserAgent.INSTANCE;
    }

    private static String buildDefaultUserAgent() {
        boolean z;
        StringBuilder sb = new StringBuilder("(Linux; Android ");
        sb.append(Build.VERSION.RELEASE);
        if (Build.MODEL.isEmpty() || !"REL".equals(Build.VERSION.CODENAME)) {
            z = false;
        } else {
            sb.append("; ");
            sb.append(Build.MODEL);
            z = true;
        }
        if (!Build.ID.isEmpty()) {
            if (!z) {
                sb.append("; ");
            }
            sb.append(" Build/");
            sb.append(Build.ID);
        }
        sb.append(") Mobile PIA/2.0.0");
        return sb.toString();
    }

    private UserAgent() {
    }

    /* loaded from: classes4.dex */
    private static class LazyDefaultUserAgent {
        private static final String INSTANCE = UserAgent.access$100();

        private LazyDefaultUserAgent() {
        }
    }
}
