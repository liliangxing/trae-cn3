package com.bytedance.upc.cache;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.framwork.core.sdklib.apm6.downgrade.DowngradeInfo;
import com.bytedance.upc.cache.ApiMultiProcessSharedProvider;
import com.bytedance.upc.common.ICommonBusinessService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApiHookCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/upc/cache/ApiHookCache;", "", "()V", "KEY_DEVICE_ID", "", "KEY_IMEI", "mDeviceId", "mImei", "check", "getContext", "Landroid/content/Context;", "multiProcessShared", "Lcom/bytedance/upc/cache/ApiMultiProcessSharedProvider$MultiProcessShared;", "obtain", "key", DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE, "save", "", StrategyConstants.VALUE, "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ApiHookCache {
    public static final ApiHookCache INSTANCE = new ApiHookCache();
    public static final String KEY_DEVICE_ID = "upc_cache_deviceid";
    public static final String KEY_IMEI = "upc_cache_imei";
    private static String mDeviceId;
    private static String mImei;

    private ApiHookCache() {
    }

    private final Context getContext() {
        try {
            return ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getContext();
        } catch (Throwable unused) {
            return null;
        }
    }

    private final ApiMultiProcessSharedProvider.MultiProcessShared multiProcessShared() {
        try {
            return ApiMultiProcessSharedProvider.getMultiprocessShared(getContext());
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void save(String key, String value) {
        ApiMultiProcessSharedProvider.Editor edit;
        ApiMultiProcessSharedProvider.Editor putString;
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (Intrinsics.areEqual(key, KEY_IMEI) && !TextUtils.isEmpty(value)) {
            mImei = value;
        } else if (Intrinsics.areEqual(key, KEY_DEVICE_ID) && !TextUtils.isEmpty(value)) {
            mDeviceId = value;
        }
        ApiMultiProcessSharedProvider.MultiProcessShared multiProcessShared = multiProcessShared();
        if (multiProcessShared == null || (edit = multiProcessShared.edit()) == null || (putString = edit.putString(key, value)) == null) {
            return;
        }
        putString.apply();
    }

    public final String obtain(String key, String r3) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (Intrinsics.areEqual(key, KEY_IMEI) && !TextUtils.isEmpty(mImei)) {
            return mImei;
        }
        if (Intrinsics.areEqual(key, KEY_DEVICE_ID) && TextUtils.isEmpty(mDeviceId)) {
            return mDeviceId;
        }
        ApiMultiProcessSharedProvider.MultiProcessShared multiProcessShared = multiProcessShared();
        if (multiProcessShared != null) {
            return multiProcessShared.getString(key, r3);
        }
        return null;
    }

    public final String check() {
        Context context;
        if (Build.VERSION.SDK_INT < 29 && (context = getContext()) != null && ActivityCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0) {
            return null;
        }
        return "";
    }
}
