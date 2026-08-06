package com.ss.android.deviceregister.core.cache.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.ss.android.common.util.TLog;
import com.ss.android.deviceregister.LogUtils;
import com.ss.android.deviceregister.base.AppLogConstants;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class SharePreferenceCacheHandler extends CacheHelper {
    private static final String TAG = "SharePreferenceCacheHandler";
    private final SharedPreferences mDeviceIdSp;
    private final SharedPreferences mSp;

    public SharePreferenceCacheHandler(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.mSp = context.getSharedPreferences(AppLogConstants.getDeviceParamsSpName(), 0);
        this.mDeviceIdSp = AppLogConstants.getApplogStatsSp(context);
    }

    @Override // com.ss.android.deviceregister.core.cache.internal.CacheHelper
    protected void cacheString(String str, String str2) {
        if (Logger.debug()) {
            TLog.m81w("SharePreferenceCacheHandler cacheString key = " + str + " value = " + str2);
        }
        storeValue(str, str2);
    }

    @Override // com.ss.android.deviceregister.core.cache.internal.CacheHelper
    protected String getCachedString(String str) {
        String value = getValue(str);
        if (Logger.debug()) {
            TLog.m81w("SharePreferenceCacheHandler getCachedString key = " + str + " value = " + value);
        }
        return value;
    }

    private String getValue(String str) {
        return getSp(str).getString(str, null);
    }

    private void storeValue(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = getSp(str).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    private SharedPreferences getSp(String str) {
        return "device_id".equals(str) ? this.mDeviceIdSp : this.mSp;
    }

    @Override // com.ss.android.deviceregister.core.cache.internal.CacheHelper
    public void clear(String str) {
        SharedPreferences sp = getSp(str);
        if (sp != null && sp.contains(str)) {
            getSp(str).edit().remove(str).commit();
        }
        LogUtils.m88d(LogUtils.TAG, "SharePreferenceCacheHandler#clear key=" + str + " getCachedString(key)=" + getCachedString(str));
        super.clear(str);
    }
}
