package com.bytedance.reparo;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.reparo.core.common.utils.DigestUtils;
import com.bytedance.reparo.core.common.utils.ProcessUtils;
import com.bytedance.reparo.secondary.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
class CrashRescuer {
    private static final String CRASH_ALARM = "crash_alarm";
    private static volatile CrashRescuer INSTANCE = null;
    private static final String KEY_CRASH_TIME = "crash_time";
    private static final int MAX_COUNT = 2;
    private static final long ONE_HOUR = 3600000;
    private static final String SEPARATOR = ";";
    private static final String TAG = "FrankieCrashRescuer";
    private static final long TIME_SECTION = 15000;
    private static final Object mLock = new Object();
    private List<Long> crashTimeList;
    private final Context mContext;

    /* renamed from: sp */
    private SharedPreferences f102sp;
    private long timeSection = TIME_SECTION;
    private int maxCount = 2;

    public static CrashRescuer getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (mLock) {
                if (INSTANCE == null) {
                    INSTANCE = new CrashRescuer(context);
                }
            }
        }
        return INSTANCE;
    }

    private CrashRescuer(Context context) {
        this.mContext = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("crash_alarm_" + DigestUtils.md5Hex(ProcessUtils.getCurrentProcessName(context)), 0);
        this.f102sp = sharedPreferences;
        String[] split = sharedPreferences.getString(KEY_CRASH_TIME, "").split(SEPARATOR);
        this.crashTimeList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        for (String str : split) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (currentTimeMillis - Long.parseLong(str) < 3600000) {
                        this.crashTimeList.add(Long.valueOf(Long.parseLong(str)));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public void setMaxCount(int i) {
        this.maxCount = i;
    }

    public void setTimeSection(long j) {
        this.timeSection = j;
    }

    public void rescueIfNeeded() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.timeSection;
        this.crashTimeList.add(Long.valueOf(currentTimeMillis));
        Logger.m326e(TAG, "rescueIfNeeded: now=" + currentTimeMillis + ", timeSectionAgo=" + j);
        save();
        Iterator<Long> it = this.crashTimeList.iterator();
        int i = 0;
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            Logger.m326e(TAG, "crash time: " + longValue);
            if (longValue >= j) {
                i++;
            }
        }
        Logger.m326e(TAG, "crashCount: " + i);
        if (i >= this.maxCount) {
            Reparo.getInstance().clearPatchForCrash();
        }
    }

    private void save() {
        String str;
        List<Long> list = this.crashTimeList;
        if (list == null || list.isEmpty()) {
            str = "";
        } else {
            StringBuilder sb = new StringBuilder();
            int size = this.crashTimeList.size();
            for (int i = 0; i < size; i++) {
                if (this.crashTimeList.get(i) != null) {
                    if (i != 0) {
                        sb.append(SEPARATOR);
                    }
                    sb.append(this.crashTimeList.get(i).toString());
                }
            }
            str = sb.toString();
        }
        SharedPreferences.Editor edit = this.f102sp.edit();
        edit.putString(KEY_CRASH_TIME, str);
        edit.commit();
    }
}
