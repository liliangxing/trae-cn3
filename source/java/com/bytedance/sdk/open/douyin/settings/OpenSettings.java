package com.bytedance.sdk.open.douyin.settings;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.core.OpenHostSettingService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.init.DouYinSdkContext;
import com.bytedance.sdk.open.douyin.settings.C0127c;
import com.bytedance.sdk.open.tt.C0139e;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class OpenSettings {
    private static volatile OpenSettings INSTANCE = null;
    private static final String TAG = "OpenSettings";
    private C0130f mCacheModel = null;
    private Context mContext;
    private C0129e mSettingsDao;
    private C0127c mSettingsUpdater;

    /* renamed from: com.bytedance.sdk.open.douyin.settings.OpenSettings$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    class C0124a implements C0127c.b {
        C0124a() {
        }

        @Override // com.bytedance.sdk.open.douyin.settings.C0127c.b
        /* renamed from: a */
        public void mo43a(C0130f c0130f) {
            OpenSettings.this.mCacheModel = c0130f;
        }
    }

    private OpenSettings(Context context) {
        this.mContext = context;
        C0129e c0129e = new C0129e(context);
        this.mSettingsDao = c0129e;
        this.mSettingsUpdater = new C0127c(this.mContext, c0129e, new C0124a());
    }

    public static OpenSettings get() {
        if (INSTANCE == null) {
            synchronized (OpenSettings.class) {
                if (INSTANCE == null) {
                    INSTANCE = new OpenSettings(DouYinSdkContext.inst().getContext());
                }
            }
        }
        return INSTANCE;
    }

    private C0130f loadSettingsModel() {
        C0130f c0130f = this.mCacheModel;
        if (c0130f != null) {
            return c0130f;
        }
        C0130f m71c = this.mSettingsDao.m71c();
        this.mCacheModel = m71c;
        return m71c;
    }

    public String getCtxInfo() {
        return loadSettingsModel().m73a();
    }

    public JSONObject getHostSettings(String str) {
        OpenHostSettingService openHostSettingService;
        if (TextUtils.isEmpty(str) || (openHostSettingService = (OpenHostSettingService) OpenServiceManager.getInst().getService(OpenHostSettingService.class)) == null) {
            return null;
        }
        return openHostSettingService.getSettingJson(str);
    }

    public long getLastUpdateTime() {
        return loadSettingsModel().m74b();
    }

    public JSONObject getSettings() {
        C0130f loadSettingsModel = loadSettingsModel();
        updateSettings(false, "getSettings");
        return loadSettingsModel.m75c();
    }

    public JSONObject getSettings(String str) {
        Object opt = opt(str);
        if (opt instanceof JSONObject) {
            return (JSONObject) opt;
        }
        return null;
    }

    public JSONObject getSettingsHostFirst(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject hostSettings = getHostSettings(str);
        return hostSettings != null ? hostSettings : getSettings(str);
    }

    public long getSettingsTime() {
        return loadSettingsModel().m76d();
    }

    public JSONObject getVidInfo() {
        return loadSettingsModel().m77e();
    }

    public Object opt(String str) {
        C0130f loadSettingsModel = loadSettingsModel();
        C0139e.m139a(this.mContext).m145a(str, loadSettingsModel.m77e());
        Object opt = loadSettingsModel.m75c().opt(str);
        updateSettings(false, "opt_" + str);
        return opt;
    }

    public void updateSettings(boolean z, String str) {
        this.mSettingsUpdater.m64a((Map<String, String>) null, z, str);
    }
}
