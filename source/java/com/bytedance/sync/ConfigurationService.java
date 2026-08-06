package com.bytedance.sync;

import com.bytedance.sync.p005v4.intf.IConfiguration;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ConfigurationService implements IConfiguration {
    private final Configuration mConfig;

    public ConfigurationService(Configuration configuration) {
        this.mConfig = configuration;
    }

    @Override // com.bytedance.sync.p005v4.intf.IConfiguration
    public Configuration config() {
        return this.mConfig;
    }
}
