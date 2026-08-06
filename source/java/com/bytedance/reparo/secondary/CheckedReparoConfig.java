package com.bytedance.reparo.secondary;

import android.app.Application;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.crash.Npth;
import com.bytedance.crash.NpthBus;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.reparo.IReparoConfig;
import com.bytedance.reparo.core.parse.AbiHelper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CheckedReparoConfig extends IReparoConfig {
    private IReparoConfig mConfig;
    private String mDeviceId = null;
    private int sBytestFlag = -1;

    public CheckedReparoConfig(IReparoConfig iReparoConfig) {
        this.mConfig = iReparoConfig;
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public boolean enable() {
        return this.mConfig.enable();
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public Application getApplication() {
        return this.mConfig.getApplication();
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public String getUpdateVersionCode() {
        return this.mConfig.getUpdateVersionCode();
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public String getAppId() {
        return this.mConfig.getAppId();
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public String getDeviceId() {
        if (isAvailableDid(this.mDeviceId)) {
            return this.mDeviceId;
        }
        String deviceId = this.mConfig.getDeviceId();
        this.mDeviceId = deviceId;
        if (!isAvailableDid(deviceId) && Npth.isInit()) {
            try {
                this.mDeviceId = NpthBus.getSettingManager().getDeviceId();
            } catch (Throwable unused) {
            }
        }
        return isAvailableDid(this.mDeviceId) ? this.mDeviceId : "1";
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public String getChannel() {
        if (this.sBytestFlag == -1) {
            try {
                this.sBytestFlag = TextUtils.isEmpty(Settings.Global.getString(getApplication().getContentResolver(), "bytest_automation_info")) ? 0 : 1;
            } catch (Throwable unused) {
                this.sBytestFlag = 0;
            }
        }
        return this.sBytestFlag == 1 ? "reparo_test" : this.mConfig.getChannel();
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public String executePatchRequest(int i, String str, byte[] bArr, String str2) throws Exception {
        return this.mConfig.executePatchRequest(i, str, bArr, str2);
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public boolean isMainProcess() {
        return this.mConfig.isMainProcess();
    }

    public static boolean isAvailableDid(String str) {
        return (str == null || TextUtils.isEmpty(str) || ViewVisibleBridge.INVISIBLE.equals(str) || "1".equals(str)) ? false : true;
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public AbiHelper getAbiHelper(Application application) {
        return this.mConfig.getAbiHelper(application);
    }
}
