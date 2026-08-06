package com.bytedance.common.support.service;

import com.bytedance.common.model.PushCommonConfiguration;

/* loaded from: classes3.dex */
public interface IPushConfigurationService {
    long getCurProcessStartTimeStamp();

    PushCommonConfiguration getPushCommonConfiguration();

    boolean hasInjectedConfiguration();

    void injectConfiguration(PushCommonConfiguration pushCommonConfiguration);

    boolean keepOldInitTimeCost();

    boolean keepOldInitTimeCostV2();

    void runAfterInit(Runnable runnable);
}
