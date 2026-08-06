package com.bytedance.push.configuration;

import com.bytedance.push.frontier.interfaze.IFrontierService;

/* loaded from: classes4.dex */
public abstract class AbsPushCommonConfiguration {
    public boolean enableAutoInit() {
        return true;
    }

    public boolean enableAutoStart() {
        return true;
    }

    public final int getFrontierMode() {
        return 2;
    }

    public abstract IFrontierService getFrontierService();

    public abstract String getSessionId();
}
