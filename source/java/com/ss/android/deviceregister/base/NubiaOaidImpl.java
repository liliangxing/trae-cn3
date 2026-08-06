package com.ss.android.deviceregister.base;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.ss.android.common.util.TLog;
import com.ss.android.deviceregister.base.OaidApi;

/* loaded from: classes7.dex */
final class NubiaOaidImpl implements OaidApi {
    @Override // com.ss.android.deviceregister.base.OaidApi
    public String getName(Context context) {
        return "Nubia";
    }

    @Override // com.ss.android.deviceregister.base.OaidApi
    public boolean support(Context context) {
        return Build.VERSION.SDK_INT > 28;
    }

    @Override // com.ss.android.deviceregister.base.OaidApi
    public OaidApi.Result getOaid(Context context) {
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
                OaidApi.Result result = new OaidApi.Result();
                result.oaid = call.getString("id");
                return result;
            }
            String string = call.getString("message");
            if (!TextUtils.isEmpty(string)) {
                TLog.e(string);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
