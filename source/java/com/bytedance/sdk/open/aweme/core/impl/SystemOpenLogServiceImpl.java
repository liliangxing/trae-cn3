package com.bytedance.sdk.open.aweme.core.impl;

import android.util.Log;
import com.bytedance.sdk.open.aweme.core.OpenLogService;

/* loaded from: classes5.dex */
public class SystemOpenLogServiceImpl implements OpenLogService {
    @Override // com.bytedance.sdk.open.aweme.core.OpenLogService
    public void d(String str, String str2) {
        Log.d(str, str2);
    }

    @Override // com.bytedance.sdk.open.aweme.core.OpenLogService
    public void e(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // com.bytedance.sdk.open.aweme.core.OpenLogService
    public void i(String str, String str2) {
        Log.d(str, str2);
    }

    @Override // com.bytedance.sdk.open.aweme.core.OpenLogService
    public void w(String str, String str2) {
        Log.w(str, str2);
    }
}
