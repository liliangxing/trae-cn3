package com.bytedance.p009dr.impl;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.p009dr.OaidApi;
import com.bytedance.tobshadow.applog.log.LoggerImpl;

/* renamed from: com.bytedance.dr.impl.j */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class C1075j implements OaidApi {
    @Override // com.bytedance.p009dr.OaidApi
    public String getName() {
        return "Nubia";
    }

    @Override // com.bytedance.p009dr.OaidApi
    public OaidApi.C1053a getOaid(Context context) {
        try {
            ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (acquireContentProviderClient == null) {
                return null;
            }
            Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            acquireContentProviderClient.close();
            if (call == null) {
                return null;
            }
            if (call.getInt(AlogMonitor.ALOG_RESULT_CODE, -1) == 0) {
                OaidApi.C1053a c1053a = new OaidApi.C1053a();
                c1053a.f153a = call.getString("id");
                return c1053a;
            }
            String string = call.getString("message");
            if (!TextUtils.isEmpty(string)) {
                LoggerImpl.global().error(1, string, new Object[0]);
            }
            return null;
        } catch (Exception e) {
            LoggerImpl.global().error(1, "getOaid failed", e, new Object[0]);
            return null;
        }
    }

    @Override // com.bytedance.p009dr.OaidApi
    public boolean support(Context context) {
        return Build.VERSION.SDK_INT > 28;
    }
}
