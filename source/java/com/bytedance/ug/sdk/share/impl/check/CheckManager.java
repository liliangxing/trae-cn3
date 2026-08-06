package com.bytedance.ug.sdk.share.impl.check;

import com.bytedance.ug.sdk.share.api.depend.ShareConfig;
import com.bytedance.ug.sdk.share.impl.utils.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CheckManager {
    private static final String TAG = "CheckManager";
    private boolean mIsRegister;

    private CheckManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Singleton {
        private static CheckManager sInstance = new CheckManager();

        private Singleton() {
        }
    }

    public static CheckManager getInstance() {
        return Singleton.sInstance;
    }

    public void setRegister(boolean z) {
        this.mIsRegister = z;
    }

    public void checkConfig(ShareConfig shareConfig) {
        if (shareConfig != null && shareConfig.isDebug()) {
            if (shareConfig.getLifecycleConfig() != null) {
                this.mIsRegister = true;
            }
            if (!this.mIsRegister) {
                Logger.m469i(TAG, "not register");
            }
            if (shareConfig.getNetworkConfig() == null) {
                Logger.m469i(TAG, "IShareNetworkConfig not implement");
            }
            if (shareConfig.getAppConfig() == null) {
                Logger.m469i(TAG, "IShareAppConfig not implement");
            }
            if (shareConfig.getImageConfig() == null) {
                Logger.m469i(TAG, "IShareImageConfig not implement");
            }
            if (shareConfig.getEventConfig() == null) {
                Logger.m469i(TAG, "IShareEventConfig not implement");
            }
            if (shareConfig.getDownloadConfig() == null) {
                Logger.m469i(TAG, "IShareDownloadConfig not implement");
            }
            if (shareConfig.getKeyConfig() == null) {
                Logger.m469i(TAG, "IShareKeyConfig not implement");
            }
            if (shareConfig.getPermissionConfig() == null) {
                Logger.m469i(TAG, "ISharePermissionConfig not implement");
            }
        }
    }
}
