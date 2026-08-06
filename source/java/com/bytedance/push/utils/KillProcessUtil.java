package com.bytedance.push.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.ss.android.message.util.ToolUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class KillProcessUtil {
    private static final int CHECK_INTERVAL_SECOND = 7;
    public static final String LAST_KILL_TIMES = "last_kill_times";
    private static final int MAX_CACHE_KILL_TIMES = 5;
    private static final String SP_CONFIG_NAME = "kill_process_sp";
    private static final String TAG = "KillProcess";

    public static void killProcess(Context context) {
        Context applicationContext = context.getApplicationContext();
        LimitQueue<Long> lastKillTimes = getLastKillTimes(applicationContext);
        long currentTimeMillis = ToolUtils.currentTimeMillis();
        lastKillTimes.offer(Long.valueOf(currentTimeMillis));
        if (lastKillTimes.size() < 5 || currentTimeMillis - lastKillTimes.get(0).longValue() > 7000) {
            Logger.m268d(TAG, "killProcess: real kill " + Log.getStackTraceString(new Throwable()));
            saveKillTimes(applicationContext, lastKillTimes);
            Process.killProcess(Process.myPid());
        }
    }

    private static LimitQueue<Long> getLastKillTimes(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_CONFIG_NAME, 0);
        LimitQueue<Long> limitQueue = new LimitQueue<>(5);
        String string = sharedPreferences.getString(LAST_KILL_TIMES, "");
        if (TextUtils.isEmpty(string)) {
            return limitQueue;
        }
        for (String str : string.split("\\|")) {
            try {
                limitQueue.offer(Long.valueOf(Long.parseLong(str)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return limitQueue;
    }

    private static void saveKillTimes(Context context, LimitQueue<Long> limitQueue) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < limitQueue.size(); i++) {
            sb.append(limitQueue.get(i)).append("|");
        }
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_CONFIG_NAME, 0);
        if (Logger.debug()) {
            Logger.m268d(TAG, "killTimesStr = " + ((Object) sb));
        }
        sharedPreferences.edit().putString(LAST_KILL_TIMES, sb.toString()).commit();
    }
}
