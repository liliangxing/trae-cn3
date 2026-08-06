package com.bytedance.sync.logger;

import android.util.Log;
import com.bytedance.sync.interfaze.ILogger;
import com.ss.android.agilelogger.ALog;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class ALogger implements ILogger {
    @Override // com.bytedance.sync.interfaze.ILogger
    /* renamed from: v */
    public void mo184v(String str) {
        try {
            Log.v(LogUtils.TAG, str);
            ALog.v(LogUtils.TAG, str);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sync.interfaze.ILogger
    /* renamed from: d */
    public void mo181d(String str) {
        try {
            ALog.i(LogUtils.TAG, str);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sync.interfaze.ILogger
    /* renamed from: i */
    public void mo183i(String str) {
        try {
            ALog.i(LogUtils.TAG, str);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sync.interfaze.ILogger
    /* renamed from: e */
    public void mo182e(String str) {
        try {
            ALog.e(LogUtils.TAG, str);
        } catch (Throwable unused) {
        }
    }
}
