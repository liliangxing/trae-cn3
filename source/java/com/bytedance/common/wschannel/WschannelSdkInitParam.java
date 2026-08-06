package com.bytedance.common.wschannel;

import android.app.Application;
import com.bytedance.common.wschannel.app.OnBindWsChannelServiceListener;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;

/* loaded from: classes3.dex */
public class WschannelSdkInitParam {
    private Application application;
    public final OnBindWsChannelServiceListener bindWsChannelServiceListener;
    private boolean calculateAppState;
    private boolean delayStartPushProcess;
    private boolean isEnableOfflineDetect;
    private OnMessageReceiveListener listener;
    private ConfigProvider<Boolean> optLogic;

    public WschannelSdkInitParam(Application application, OnMessageReceiveListener onMessageReceiveListener, boolean z, boolean z2, boolean z3, OnBindWsChannelServiceListener onBindWsChannelServiceListener) {
        this.application = application;
        this.listener = onMessageReceiveListener;
        this.delayStartPushProcess = z;
        this.calculateAppState = z2;
        this.isEnableOfflineDetect = z3;
        this.bindWsChannelServiceListener = onBindWsChannelServiceListener;
    }

    public Application getApplication() {
        return this.application;
    }

    public OnMessageReceiveListener getListener() {
        return this.listener;
    }

    public boolean isEnableOfflineDetect() {
        return this.isEnableOfflineDetect;
    }

    public boolean isDelayStartPushProcess() {
        return this.delayStartPushProcess;
    }

    public boolean isCalculateAppState() {
        return this.calculateAppState;
    }

    public ConfigProvider<Boolean> getOptLogic() {
        return this.optLogic;
    }

    public void setOptLogic(ConfigProvider<Boolean> configProvider) {
        this.optLogic = configProvider;
    }

    public void setOnMessageReceiveListener(OnMessageReceiveListener onMessageReceiveListener) {
        this.listener = onMessageReceiveListener;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        private Application application;
        private OnBindWsChannelServiceListener bindWsChannelServiceListener;
        private OnMessageReceiveListener messageReceiveListener;
        private boolean delayStartPushProcess = false;
        private boolean calculateAppState = true;
        private boolean isEnableOfflineDetect = false;

        public Builder application(Application application) {
            this.application = application;
            return this;
        }

        public Builder messageReceiveListener(OnMessageReceiveListener onMessageReceiveListener) {
            this.messageReceiveListener = onMessageReceiveListener;
            return this;
        }

        public Builder delayStartPushProcess(boolean z) {
            this.delayStartPushProcess = z;
            return this;
        }

        public Builder calculateAppState(boolean z) {
            this.calculateAppState = z;
            return this;
        }

        public Builder enableOfflineDetect(boolean z) {
            this.isEnableOfflineDetect = z;
            return this;
        }

        public Builder bindWsChannelServiceListener(OnBindWsChannelServiceListener onBindWsChannelServiceListener) {
            this.bindWsChannelServiceListener = onBindWsChannelServiceListener;
            return this;
        }

        public WschannelSdkInitParam build() {
            return new WschannelSdkInitParam(this.application, this.messageReceiveListener, this.delayStartPushProcess, this.calculateAppState, this.isEnableOfflineDetect, this.bindWsChannelServiceListener);
        }
    }
}
