package com.bytedance.sync.logger;

import android.util.Log;
import com.bytedance.sync.interfaze.ILogger;

/* loaded from: classes5.dex */
final class DefaultLogger implements ILogger {
    DefaultLogger() {
    }

    @Override // com.bytedance.sync.interfaze.ILogger
    public void v(String str) {
        Log.v(LogUtils.TAG, str);
    }

    @Override // com.bytedance.sync.interfaze.ILogger
    public void d(String str) {
        Log.d(LogUtils.TAG, str);
    }

    @Override // com.bytedance.sync.interfaze.ILogger
    public void i(String str) {
        Log.i(LogUtils.TAG, str);
    }

    @Override // com.bytedance.sync.interfaze.ILogger
    public void e(String str) {
        Log.e(LogUtils.TAG, str);
    }
}
