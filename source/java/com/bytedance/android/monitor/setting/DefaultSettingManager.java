package com.bytedance.android.monitor.setting;

import android.content.Context;

/* loaded from: classes3.dex */
public class DefaultSettingManager implements ISettingManager {
    private static volatile DefaultSettingManager instance;
    private LynxSettingConfig lynxConfig;
    private WebSettingConfig webConfig;

    @Override // com.bytedance.android.monitor.setting.ISettingManager
    public void init(Context context) {
    }

    @Override // com.bytedance.android.monitor.setting.ISettingManager
    public void reset() {
    }

    public static DefaultSettingManager getInstance() {
        if (instance == null) {
            synchronized (DefaultSettingManager.class) {
                if (instance == null) {
                    instance = new DefaultSettingManager();
                }
            }
        }
        return instance;
    }

    @Override // com.bytedance.android.monitor.setting.ISettingManager
    public WebSettingConfig getWebInfo() {
        if (this.webConfig == null) {
            this.webConfig = new WebSettingConfig();
        }
        return this.webConfig;
    }

    @Override // com.bytedance.android.monitor.setting.ISettingManager
    public LynxSettingConfig getLynxConfig() {
        if (this.lynxConfig == null) {
            this.lynxConfig = new LynxSettingConfig();
        }
        return this.lynxConfig;
    }
}
