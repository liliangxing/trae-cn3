package com.bytedance.ug.sdk.clipboard_handler;

import com.bytedance.applog.IDataObserver;
import com.bytedance.ug.sdk.deeplink.utils.Logger;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DataObserver implements IDataObserver {
    private static volatile DataObserver INSTANCE = null;
    private static final String TAG = "DataObserver";

    public void onAbVidsChange(String str, String str2) {
    }

    public void onRemoteAbConfigGet(boolean z, JSONObject jSONObject) {
    }

    public void onRemoteConfigGet(boolean z, JSONObject jSONObject) {
    }

    public static DataObserver getInstance() {
        if (INSTANCE == null) {
            synchronized (DataObserver.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DataObserver();
                }
            }
        }
        return INSTANCE;
    }

    public void onIdLoaded(String str, String str2, String str3) {
        Logger.m449i(TAG, "SchemeClipboardChecker doReCheck onIdLoaded");
        SchemeClipboardChecker.inst().doReCheck();
    }

    public void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        if (z) {
            Logger.m449i(TAG, "SchemeClipboardChecker doReCheck onRemoteIdGet");
            SchemeClipboardChecker.inst().doReCheck();
        }
    }
}
