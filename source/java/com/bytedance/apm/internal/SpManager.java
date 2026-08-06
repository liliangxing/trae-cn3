package com.bytedance.apm.internal;

import android.content.SharedPreferences;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.apm.core.MonitorSharedPreferences;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SpManager {
    private final SharedPreferences mSharedPreferences;

    private SpManager() {
        this.mSharedPreferences = MonitorSharedPreferences.getSharedPreferences(ApmContext.getContext(), SlardarConfigConsts.MONITOR_CONFIG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class Holder {
        private static final SpManager INSTANCE = new SpManager();

        private Holder() {
        }
    }

    public static SpManager getInstance() {
        return Holder.INSTANCE;
    }

    public String getString(String str) {
        return this.mSharedPreferences.getString(str, null);
    }

    public int getInt(String str) {
        return this.mSharedPreferences.getInt(str, -1);
    }

    public long getLong(String str) {
        return this.mSharedPreferences.getLong(str, 0L);
    }

    public void saveAsync(String str, String str2) {
        this.mSharedPreferences.edit().putString(str, str2).apply();
    }

    public void saveAsync(String str, long j) {
        this.mSharedPreferences.edit().putLong(str, j).apply();
    }

    public void saveAsync(String str, int i) {
        this.mSharedPreferences.edit().putInt(str, i).apply();
    }
}
