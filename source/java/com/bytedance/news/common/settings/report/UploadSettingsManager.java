package com.bytedance.news.common.settings.report;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.report.api.UploadSettingsApi;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.google.gson.JsonObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class UploadSettingsManager {
    private static final String BOE_HOST = "http://i.snssdk.com.boe-gateway.byted.org";
    private static final String FORMAL_HOST = "https://i.snssdk.com";
    private static final String PATH = "/appsettings/upload/";
    private static final String TAG = "UploadSettingsManager";

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class InstanceHolder {
        private static final UploadSettingsManager INSTANCE = new UploadSettingsManager();

        private InstanceHolder() {
        }
    }

    public static UploadSettingsManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private UploadSettingsManager() {
    }

    public void uploadSettings(Context context, int i, String str, boolean z) {
        SettingsData obtainSettingsFast = SettingsManager.obtainSettingsFast(context);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(CommonConstants.KEY_AID, Integer.valueOf(i));
        jsonObject.addProperty(CommonConstants.KEY_DEVICE_ID, str);
        if (obtainSettingsFast != null) {
            jsonObject.addProperty("config", obtainSettingsFast.getAppSettings().toString());
        }
        ((UploadSettingsApi) RetrofitUtils.createOkService(z ? BOE_HOST : "https://i.snssdk.com", UploadSettingsApi.class)).executePost(PATH, jsonObject).enqueue(new Callback<String>() { // from class: com.bytedance.news.common.settings.report.UploadSettingsManager.1
            @Override // com.bytedance.retrofit2.Callback
            public void onResponse(Call<String> call, SsResponse<String> ssResponse) {
                Logger.d(UploadSettingsManager.TAG, "onResponse");
            }

            @Override // com.bytedance.retrofit2.Callback
            public void onFailure(Call<String> call, Throwable th) {
                Logger.e(UploadSettingsManager.TAG, "onFailure");
            }
        });
    }
}
