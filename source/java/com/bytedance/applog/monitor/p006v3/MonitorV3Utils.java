package com.bytedance.applog.monitor.p006v3;

import android.os.SystemClock;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class MonitorV3Utils {
    private static final AtomicLong ATOMIC_MONITOR_EVENT_ID;
    private static final AtomicLong ATOMIC_MONITOR_ID;
    private static final SimpleDateFormat DATE_FORMAT_MS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    static {
        long elapsedRealtime = (((SystemClock.elapsedRealtime() / 1000) * 100) + new SecureRandom().nextInt(99)) * 100000;
        ATOMIC_MONITOR_ID = new AtomicLong(elapsedRealtime);
        ATOMIC_MONITOR_EVENT_ID = new AtomicLong(elapsedRealtime);
    }

    public static long getNewMonitorId() {
        return ATOMIC_MONITOR_ID.incrementAndGet();
    }

    public static long getMonitorEventId() {
        return ATOMIC_MONITOR_EVENT_ID.incrementAndGet();
    }

    public static String getNewMonitorIdString() {
        return String.valueOf(getNewMonitorId());
    }

    public static String getCurrentDateTime() {
        return DATE_FORMAT_MS.format(new Date());
    }

    public static List<String> fastSplitString(String str, char c) {
        if (str == null || str.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) == c) {
                arrayList.add(str.substring(i, i2));
                i = i2 + 1;
            }
        }
        if (i <= length) {
            arrayList.add(str.substring(i));
        }
        return arrayList;
    }
}
