package com.bytedance.dr.impl;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.dr.OaidApi;
import com.bytedance.tobshadow.applog.log.LoggerImpl;

/* loaded from: classes3.dex */
public final class j implements OaidApi {
    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "Nubia";
    }

    @Override // com.bytedance.dr.OaidApi
    public OaidApi.a getOaid(Context context) {
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
            if (call.getInt("code", -1) == 0) {
                OaidApi.a aVar = new OaidApi.a();
                aVar.a = call.getString("id");
                return aVar;
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

    @Override // com.bytedance.dr.OaidApi
    public boolean support(Context context) {
        return Build.VERSION.SDK_INT > 28;
    }
}
