package com.bytedance.tobshadow.bdtracker;

import android.util.Log;
import com.bytedance.tobshadow.applog.log.ILogProcessor;
import com.bytedance.tobshadow.applog.log.LogInfo;

/* renamed from: com.bytedance.tobshadow.bdtracker.t1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0518t1 implements ILogProcessor {
    public C0518t1(C0467m c0467m) {
        onLog(LogInfo.builder().appId(c0467m.f784m).level(1).thread(Thread.currentThread().getName()).message(C0380a.m252a("Console logger debug is:").append(c0467m.f767G).toString()).build());
    }

    @Override // com.bytedance.tobshadow.applog.log.ILogProcessor
    public void onLog(LogInfo logInfo) {
        int level = logInfo.getLevel();
        if (level == 2) {
            Log.i("AppLog", logInfo.toLiteString());
            return;
        }
        if (level == 3) {
            Log.w("AppLog", logInfo.toLiteString(), logInfo.getThrowable());
        } else if (level == 4 || level == 5) {
            Log.e("AppLog", logInfo.toLiteString(), logInfo.getThrowable());
        } else {
            Log.d("AppLog", logInfo.toLiteString());
        }
    }
}
