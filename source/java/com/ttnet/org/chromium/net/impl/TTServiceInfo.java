package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.impl.CronetFrontierClient;

/* loaded from: classes7.dex */
public class TTServiceInfo {
    public boolean connected;
    public int identity;
    public boolean lazy;
    public CronetFrontierClient.IServiceMessageReceiver listener;
    public boolean sequence = true;
    public ServicePriority priority = ServicePriority.Low;

    /* loaded from: classes7.dex */
    public enum ServicePriority {
        Low(0),
        Medium(1),
        High(2);

        final int priority;

        ServicePriority(int i) {
            this.priority = i;
        }

        public int getValue() {
            return this.priority;
        }
    }

    public TTServiceInfo(int i, CronetFrontierClient.IServiceMessageReceiver iServiceMessageReceiver) {
        if (i <= 0) {
            throw new IllegalArgumentException("Service identity must be set greater than 0.");
        }
        if (iServiceMessageReceiver == null) {
            throw new IllegalArgumentException("Service listener must not be null.");
        }
        this.identity = i;
        this.listener = iServiceMessageReceiver;
    }
}
