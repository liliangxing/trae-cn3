package com.bytedance.ug.sdk.deeplink;

import android.app.Application;
import com.bytedance.ug.sdk.deeplink.fission.CallbackForFission;
import com.bytedance.ug.sdk.deeplink.utils.CollectionsUtils;
import java.util.List;

/* loaded from: classes4.dex */
public class ZlinkDependAbility {
    private Application mApplication;
    private boolean mAutoCheck;
    private CallBackForAppLink mCallBackForAppLink;
    private CallbackForFission mCallbackForFission;
    private boolean mEnableClipboardOutside;
    private boolean mEnableHuaWeiReferrer;
    private boolean mEnableLaunchLogForAppLink;
    private String mEntranceOfLaunchLogForAppLink;
    private List<String> mForbiddenActivityList;
    private boolean mForbiddenCheckClipBoard;
    private boolean mIsDebug;
    private String mSettingHost;
    private IZlinkDepend mZlinkDepend;

    private ZlinkDependAbility(Builder builder) {
        if (builder != null) {
            this.mIsDebug = builder.mIsDebug;
            this.mAutoCheck = builder.mAutoCheck;
            this.mEnableHuaWeiReferrer = builder.mEnableHuaWeiReferrer;
            this.mForbiddenCheckClipBoard = builder.mForbiddenCheckClipBoard;
            this.mEnableClipboardOutside = builder.mEnableClipboardOutside;
            this.mApplication = builder.mApplication;
            this.mZlinkDepend = builder.mZlinkDepend;
            this.mCallBackForAppLink = builder.mCallBackForAppLink;
            this.mCallbackForFission = builder.mCallbackForFission;
            this.mForbiddenActivityList = builder.mForbiddenActivityList;
            this.mEnableLaunchLogForAppLink = builder.mEnableLaunchLogForAppLink;
            this.mEntranceOfLaunchLogForAppLink = builder.mEntranceOfLaunchLogForAppLink;
            this.mSettingHost = builder.mSettingHost;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isDebug() {
        return this.mIsDebug;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getAutoCheck() {
        return this.mAutoCheck;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEnableHuaWeiReferrer() {
        return this.mEnableHuaWeiReferrer;
    }

    public boolean isForbiddenCheckClipBoard() {
        return this.mForbiddenCheckClipBoard;
    }

    public void setForbiddenClipboardByHost(boolean z) {
        this.mForbiddenCheckClipBoard = z;
    }

    public boolean getEnableClipboardOutside() {
        return this.mEnableClipboardOutside;
    }

    public Application getApplication() {
        return this.mApplication;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IZlinkDepend getZlinkDepend() {
        return this.mZlinkDepend;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallBackForAppLink getCallBackForAppLink() {
        return this.mCallBackForAppLink;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallbackForFission getCallbackForFission() {
        return this.mCallbackForFission;
    }

    public List<String> getForbiddenActivityList() {
        return this.mForbiddenActivityList;
    }

    public boolean enableLaunchLogForAppLink() {
        return this.mEnableLaunchLogForAppLink;
    }

    public String entranceOfLaunchLogForAppLink() {
        return this.mEntranceOfLaunchLogForAppLink;
    }

    public String getSettingHost() {
        return this.mSettingHost;
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        private Application mApplication;
        private boolean mAutoCheck;
        private CallBackForAppLink mCallBackForAppLink;
        private CallbackForFission mCallbackForFission;
        private boolean mEnableClipboardOutside;
        private boolean mEnableLaunchLogForAppLink;
        private String mEntranceOfLaunchLogForAppLink;
        private List<String> mForbiddenActivityList;
        private boolean mIsDebug;
        private String mSettingHost;
        private IZlinkDepend mZlinkDepend;
        private boolean mEnableHuaWeiReferrer = true;
        private boolean mForbiddenCheckClipBoard = false;

        public Builder withDebug(boolean z) {
            this.mIsDebug = z;
            return this;
        }

        public Builder withEnableClipboardOutside(boolean z) {
            this.mEnableClipboardOutside = z;
            return this;
        }

        public Builder withAutoCheck(boolean z) {
            this.mAutoCheck = z;
            return this;
        }

        public Builder withHuaWeiReferrer(boolean z) {
            this.mEnableHuaWeiReferrer = z;
            return this;
        }

        public Builder withForbiddenCheckClipBoard(boolean z) {
            this.mForbiddenCheckClipBoard = z;
            return this;
        }

        public Builder withApplication(Application application) {
            if (application != null) {
                this.mApplication = application;
            }
            return this;
        }

        public Builder withZlinkDepend(IZlinkDepend iZlinkDepend) {
            if (iZlinkDepend != null) {
                this.mZlinkDepend = iZlinkDepend;
            }
            return this;
        }

        public Builder withCallBackForAppLink(CallBackForAppLink callBackForAppLink) {
            if (callBackForAppLink != null) {
                this.mCallBackForAppLink = callBackForAppLink;
            }
            return this;
        }

        public Builder withCallbackForFission(CallbackForFission callbackForFission) {
            if (callbackForFission != null) {
                this.mCallbackForFission = callbackForFission;
            }
            return this;
        }

        public Builder withForbiddenActivityList(List<String> list) {
            if (!CollectionsUtils.isEmptyList(list)) {
                this.mForbiddenActivityList = list;
            }
            return this;
        }

        public Builder withLaunchLogForAppLink(boolean z, String str) {
            this.mEnableLaunchLogForAppLink = z;
            this.mEntranceOfLaunchLogForAppLink = str;
            return this;
        }

        public Builder withSettingHost(String str) {
            this.mSettingHost = str;
            return this;
        }

        public <T, K extends T> Builder withService(Class<T> cls, K k) {
            ZlinkProviderManager.register(cls, k);
            return this;
        }

        public ZlinkDependAbility build() {
            return new ZlinkDependAbility(this);
        }
    }
}
