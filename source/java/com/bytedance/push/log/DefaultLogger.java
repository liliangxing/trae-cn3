package com.bytedance.push.log;

import android.util.Log;
import com.bytedance.push.interfaze.IPushService;

/* loaded from: classes4.dex */
public class DefaultLogger implements ILogger {
    private final String TAG = IPushService.TAG;
    private boolean debuggable = false;

    public void setDebug(boolean z) {
        this.debuggable = z;
    }

    @Override // com.bytedance.push.log.ILogger
    public void d(String str) {
        Log.d(IPushService.TAG, str);
    }

    @Override // com.bytedance.push.log.ILogger
    public void d(String str, String str2) {
        Log.d(IPushService.TAG, str + " >>> " + str2);
    }

    @Override // com.bytedance.push.log.ILogger
    public void e(String str) {
        Log.e(IPushService.TAG, str);
    }

    @Override // com.bytedance.push.log.ILogger
    public void e(String str, String str2) {
        Log.e(IPushService.TAG, str2);
    }

    @Override // com.bytedance.push.log.ILogger
    public void e(String str, String str2, Throwable th) {
        Log.d(IPushService.TAG, str + " >>> " + str2);
    }

    @Override // com.bytedance.push.log.ILogger
    public boolean debug() {
        return this.debuggable;
    }

    @Override // com.bytedance.push.log.ILogger
    public void i(String str) {
        Log.d(IPushService.TAG, str);
    }

    @Override // com.bytedance.push.log.ILogger
    public void i(String str, String str2) {
        Log.i(IPushService.TAG, str + " >>> " + str2);
    }

    @Override // com.bytedance.push.log.ILogger
    public void i(String str, String str2, Throwable th) {
        Log.i(IPushService.TAG, str + " >>> " + str2, th);
    }

    @Override // com.bytedance.push.log.ILogger
    public void v(String str, String str2) {
        Log.v(IPushService.TAG, str + " >>> " + str2);
    }

    @Override // com.bytedance.push.log.ILogger
    public void w(String str, String str2) {
        Log.w(IPushService.TAG, str + " >>> " + str2);
    }
}
