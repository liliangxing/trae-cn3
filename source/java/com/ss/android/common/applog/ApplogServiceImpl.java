package com.ss.android.common.applog;

import android.content.Context;
import android.util.Log;
import com.service.middleware.applog.ApplogService;
import com.service.middleware.applog.IHeaderCustomTimelyCallback;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class ApplogServiceImpl implements ApplogService {
    public static final String TAG = "ApplogServiceImpl";
    public static volatile IHeaderCustomTimelyCallback cachedHeaderCustomTimelyCallback;
    public static volatile boolean isServicePrepared;

    public static void handleCachedData() {
        if (isServicePrepared && cachedHeaderCustomTimelyCallback != null) {
            AppLog.registerHeaderCustomCallback(cachedHeaderCustomTimelyCallback);
        }
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context context, String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        if (isServicePrepared) {
            TeaAgent.onEvent(context, str, str2, str3, j, j2, jSONObject);
        } else {
            Log.e(TAG, "ApplogService not prepared!");
        }
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context context, String str, String str2, String str3, long j, long j2, boolean z) {
        if (isServicePrepared) {
            TeaAgent.onEvent(context, str, str2, str3, j, j2, z);
        } else {
            Log.e(TAG, "ApplogService not prepared!");
        }
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context context, String str, String str2, String str3, long j, long j2) {
        if (isServicePrepared) {
            TeaAgent.onEvent(context, str, str2, str3, j, j2);
        } else {
            Log.e(TAG, "ApplogService not prepared!");
        }
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context context, String str, String str2) {
        if (isServicePrepared) {
            TeaAgent.onEvent(context, str, str2);
        } else {
            Log.e(TAG, "ApplogService not prepared!");
        }
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context context, String str) {
        if (isServicePrepared) {
            TeaAgent.onEvent(context, str);
        } else {
            Log.e(TAG, "ApplogService not prepared!");
        }
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context context, String str, String str2, String str3, long j, long j2, boolean z, JSONObject jSONObject) {
        if (isServicePrepared) {
            TeaAgent.onEvent(context, str, str2, str3, j, j2, z, jSONObject);
        } else {
            Log.e(TAG, "ApplogService not prepared!");
        }
    }

    @Override // com.service.middleware.applog.ApplogService
    public void registerHeaderCustomCallback(IHeaderCustomTimelyCallback iHeaderCustomTimelyCallback) {
        if (isServicePrepared) {
            AppLog.registerHeaderCustomCallback(iHeaderCustomTimelyCallback);
        } else {
            cachedHeaderCustomTimelyCallback = iHeaderCustomTimelyCallback;
        }
    }
}
