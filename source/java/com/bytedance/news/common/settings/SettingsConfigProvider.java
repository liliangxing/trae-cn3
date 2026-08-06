package com.bytedance.news.common.settings;

import com.bytedance.news.common.service.manager.IService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface SettingsConfigProvider extends IService {
    SettingsConfig getConfig();

    SettingsLazyConfig getLazyConfig();
}
