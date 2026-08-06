package com.bytedance.android.monitorV2.net;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.monitorV2.AnnieXMonitorConstants;
import com.bytedance.android.monitorV2.hybridSetting.AbsRestoreRequestService;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingInitConfig;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingResponse;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.bdinstall.Api;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.salamander.anniex.SLAnnieXMonitorManager;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.google.gson.JsonObject;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TTNetSettingRequestService extends AbsRestoreRequestService {
    public TTNetSettingRequestService(HybridSettingInitConfig hybridSettingInitConfig) {
        super(hybridSettingInitConfig);
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.ISettingRequestService
    public HybridSettingResponse stepOneFromRequest() {
        Call<String> call;
        try {
            try {
                call = ((MonitorNetApi) RetrofitUtils.createOkService(this.initConfig.getHost(), MonitorNetApi.class)).doPost(tryGetNetworkTag(), generateBody());
                try {
                    String str = (String) call.execute().body();
                    SLAnnieXMonitorManager.Companion.getInstance().parseSettingsWithV2Response(str);
                    return toSettingResponseStepOne(str);
                } catch (Throwable th) {
                    th = th;
                    try {
                        ExceptionUtil.handleException(th);
                        if (call != null) {
                            call.cancel();
                        }
                        return null;
                    } finally {
                        if (call != null) {
                            call.cancel();
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                call = null;
            }
        } catch (Throwable th3) {
            ExceptionUtil.handleException(th3);
        }
    }

    private List<Header> tryGetNetworkTag() {
        ArrayList arrayList = new ArrayList();
        try {
            Pair buildBDNetworkTag = BDNetworkTagManager.getInstance().buildBDNetworkTag(new BDNetworkTagContextProviderAdapter() { // from class: com.bytedance.android.monitorV2.net.TTNetSettingRequestService.1
                public int triggerType() {
                    return 0;
                }
            });
            if (buildBDNetworkTag != null && !TextUtils.isEmpty((CharSequence) buildBDNetworkTag.first)) {
                arrayList.add(new Header((String) buildBDNetworkTag.first, (String) buildBDNetworkTag.second));
            }
        } catch (Throwable unused) {
            MonitorLog.m27e(this.TAG, "host app has not add the tag lib as dependency");
        }
        return arrayList;
    }

    private JsonObject generateBody() {
        if (this.initConfig.getAid() == null) {
            MonitorLog.m27e(this.TAG, "monitor setting aid should not be null");
        }
        JsonObject jsonObject = new JsonObject();
        if (this.initConfig.getAid() != null) {
            jsonObject.addProperty("aid", this.initConfig.getAid());
        }
        if (this.initConfig.getOs() != null) {
            jsonObject.addProperty("os", this.initConfig.getOs());
        }
        if (this.initConfig.getOsVersion() != null) {
            jsonObject.addProperty("os_version", this.initConfig.getOsVersion());
        }
        if (this.initConfig.getInstallId() != null) {
            jsonObject.addProperty("install_id", this.initConfig.getInstallId());
        }
        if (this.initConfig.getDeviceId() != null) {
            jsonObject.addProperty("device_id", this.initConfig.getDeviceId());
        }
        if (this.initConfig.getChannel() != null) {
            jsonObject.addProperty("channel", this.initConfig.getChannel());
        }
        if (this.initConfig.getVersionCode() != null) {
            jsonObject.addProperty("version_code", this.initConfig.getVersionCode());
        }
        if (this.initConfig.getUpdateVersionCode() != null) {
            jsonObject.addProperty("update_version_code", this.initConfig.getUpdateVersionCode());
        }
        if (this.initConfig.getRegion() != null) {
            jsonObject.addProperty("region", this.initConfig.getRegion());
        }
        if (this.initConfig.getLanguage() != null) {
            jsonObject.addProperty(Api.KEY_LANGUAGE, this.initConfig.getLanguage());
        }
        jsonObject.addProperty("device_model", Build.MODEL);
        jsonObject.addProperty("sdk_version", AnnieXMonitorConstants.ANNIEX_VERSION);
        jsonObject.addProperty("device_brand", Build.BRAND);
        return jsonObject;
    }
}
