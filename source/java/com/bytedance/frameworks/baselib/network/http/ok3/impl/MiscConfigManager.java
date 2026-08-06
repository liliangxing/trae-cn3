package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.ttnet.TTConfigManager;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class MiscConfigManager {
    private static volatile MiscConfigManager mInstance;
    private final List<String> mRequestLogHeaderRmList = new CopyOnWriteArrayList();

    public static MiscConfigManager inst() {
        if (mInstance == null) {
            synchronized (MiscConfigManager.class) {
                if (mInstance == null) {
                    mInstance = new MiscConfigManager();
                }
            }
        }
        return mInstance;
    }

    private MiscConfigManager() {
    }

    public void onServerConfigChanged(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        TTConfigManager.parseJsonArray(jSONObject, "log_header_rm_list", this.mRequestLogHeaderRmList);
    }

    public List<String> getRequestLogHeaderRmList() {
        return this.mRequestLogHeaderRmList;
    }
}
