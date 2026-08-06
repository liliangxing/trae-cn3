package com.bytedance.push.third;

/* loaded from: classes4.dex */
public interface IPushChannel {
    IPushAdapter getAdapterInstance();

    String getChannelClassName();

    String getSenderName();

    boolean isSupport();

    void resetInitStatus();
}
