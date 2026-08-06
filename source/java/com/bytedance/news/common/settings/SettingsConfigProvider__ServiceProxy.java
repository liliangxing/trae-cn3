package com.bytedance.news.common.settings;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.bytedance.trae.settings.impl.SettingsConfigProviderImpl;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SettingsConfigProvider__ServiceProxy implements IServiceProxy<SettingsConfigProvider> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public SettingsConfigProvider newInstance() {
        return new SettingsConfigProviderImpl();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> map) {
        map.put("com.bytedance.news.common.settings.SettingsConfigProvider", "com.bytedance.trae.settings.impl.SettingsConfigProviderImpl");
    }
}
