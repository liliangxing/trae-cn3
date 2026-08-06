package com.xm;

import com.xiaomi.mipush.sdk.PushMessageReceiver;

/* loaded from: classes7.dex */
public class HostMiPushMessageHandler {
    private static volatile HostMiPushMessageHandler hostMiPushMessageHandler;
    private PushMessageReceiver mHostPushMessageReceiver;

    public static HostMiPushMessageHandler getInstance() {
        if (hostMiPushMessageHandler == null) {
            synchronized (HostMiPushMessageHandler.class) {
                if (hostMiPushMessageHandler == null) {
                    hostMiPushMessageHandler = new HostMiPushMessageHandler();
                }
            }
        }
        return hostMiPushMessageHandler;
    }

    private HostMiPushMessageHandler() {
    }

    public void setHostMiPushMessageHandler(PushMessageReceiver pushMessageReceiver) {
        this.mHostPushMessageReceiver = pushMessageReceiver;
    }

    public PushMessageReceiver getHostPushMessageReceiver() {
        return this.mHostPushMessageReceiver;
    }
}
