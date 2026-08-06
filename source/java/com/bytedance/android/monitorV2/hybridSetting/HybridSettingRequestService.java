package com.bytedance.android.monitorV2.hybridSetting;

import android.os.Build;
import com.bytedance.android.monitorV2.AnnieXMonitorConstants;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingInitConfig;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingResponse;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.salamander.anniex.SLAnnieXMonitorManager;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class HybridSettingRequestService extends AbsRestoreRequestService {
    private OkHttpClient client;
    private String path;

    public HybridSettingRequestService(HybridSettingInitConfig hybridSettingInitConfig) {
        super(hybridSettingInitConfig);
        this.path = "/monitor_web/settings/hybrid-settings";
        this.client = new OkHttpClient.Builder().build();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.ISettingRequestService
    public HybridSettingResponse stepOneFromRequest() {
        try {
            String string = this.client.newCall(new Request.Builder().url(this.initConfig.getHost() + this.path).method("POST", RequestBody.create(MediaType.parse("application/json"), generateBody())).addHeader("Content-Type", "application/json").build()).execute().body().string();
            SLAnnieXMonitorManager.Companion.getInstance().parseSettingsWithV2Response(string);
            return toSettingResponseStepOne(string);
        } catch (IOException e) {
            ExceptionUtil.handleException(ExceptionUtil.STARTUP_HANDLE, e);
            return null;
        }
    }

    private String generateBody() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.safePut(jSONObject, "aid", this.initConfig.getAid());
        if (this.initConfig.getAid() == null) {
            MonitorLog.m27e(this.TAG, "monitor setting aid should not be null");
        }
        JsonUtils.safePut(jSONObject, "os", this.initConfig.getOs());
        JsonUtils.safePut(jSONObject, "os_version", this.initConfig.getOsVersion());
        JsonUtils.safePut(jSONObject, "install_id", this.initConfig.getInstallId());
        JsonUtils.safePut(jSONObject, "device_id", this.initConfig.getDeviceId());
        JsonUtils.safePut(jSONObject, "channel", this.initConfig.getChannel());
        JsonUtils.safePut(jSONObject, "version_code", this.initConfig.getVersionCode());
        JsonUtils.safePut(jSONObject, "update_version_code", this.initConfig.getUpdateVersionCode());
        JsonUtils.safePut(jSONObject, "region", this.initConfig.getRegion());
        JsonUtils.safePut(jSONObject, Api.KEY_LANGUAGE, this.initConfig.getLanguage());
        JsonUtils.safePut(jSONObject, "device_model", Build.MODEL);
        JsonUtils.safePut(jSONObject, "sdk_version", AnnieXMonitorConstants.ANNIEX_VERSION);
        JsonUtils.safePut(jSONObject, "device_brand", Build.BRAND);
        return jSONObject.toString();
    }
}
