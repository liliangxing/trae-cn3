package com.bytedance.bdinstall;

import com.bytedance.bdinstall.SubpSyncManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
final class CpDeviceTokenServiceImpl extends AbsDeviceTokenService implements SubpSyncManager.OnUpdateListener {
    private volatile String mDeviceToken;

    public CpDeviceTokenServiceImpl(InstallOptions installOptions) {
        SubpSyncManager.inst(installOptions.getContext()).observer(installOptions.getAidString(), "device_token", this);
    }

    @Override // com.bytedance.bdinstall.AbsDeviceTokenService
    protected String getDeviceToken() {
        return this.mDeviceToken;
    }

    @Override // com.bytedance.bdinstall.DeviceTokenService
    public void updateToken(String str, Env env) {
        this.mDeviceToken = str;
    }

    @Override // com.bytedance.bdinstall.SubpSyncManager.OnUpdateListener
    public void onUpdate(String str, String str2) {
        updateToken(str, null);
    }
}
