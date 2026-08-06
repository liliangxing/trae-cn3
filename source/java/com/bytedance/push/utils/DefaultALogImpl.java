package com.bytedance.push.utils;

import android.util.Log;
import com.bytedance.push.interfaze.IALog;

/* loaded from: classes4.dex */
public class DefaultALogImpl implements IALog {
    @Override // com.bytedance.push.interfaze.IALog
    public void d(String str, String str2) {
        Log.d(str, str2);
    }

    @Override // com.bytedance.push.interfaze.IALog
    public void e(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // com.bytedance.push.interfaze.IALog
    public void i(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // com.bytedance.push.interfaze.IALog
    public void v(String str, String str2) {
        Log.v(str, str2);
    }

    @Override // com.bytedance.push.interfaze.IALog
    public void w(String str, String str2) {
        Log.w(str, str2);
    }
}
