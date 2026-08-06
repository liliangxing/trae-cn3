package com.bytedance.platform.settingsx.api.cache;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.platform.settingsx.api.GlobalConfig;

/* loaded from: classes4.dex */
public class CtxInfoManagerX {
    private static final String KET_CTX_INFO = "key_ctx_info";
    private static volatile CtxInfoManagerX sInstance;
    private SharedPreferences mCtxInfoSp;

    public static CtxInfoManagerX getInstance(Context context) {
        if (sInstance == null) {
            synchronized (CtxInfoManagerX.class) {
                if (sInstance == null) {
                    sInstance = new CtxInfoManagerX(context);
                }
            }
        }
        return sInstance;
    }

    private CtxInfoManagerX(Context context) {
        this.mCtxInfoSp = GlobalConfig.getSp().getSharedPreferences(context, "__ctx_info.sp", 0);
    }

    public synchronized void updateCtxInfo(String str) {
        this.mCtxInfoSp.edit().putString(KET_CTX_INFO, str).apply();
    }

    public String getCtxInfo() {
        return this.mCtxInfoSp.getString(KET_CTX_INFO, "");
    }
}
