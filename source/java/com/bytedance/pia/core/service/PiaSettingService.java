package com.bytedance.pia.core.service;

import com.bytedance.pia.core.api.PiaAppInfo;
import com.bytedance.pia.core.api.services.IPiaSettingService;
import com.bytedance.pia.core.setting.SettingService;
import kotlin.Metadata;

/* compiled from: PiaSettingService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/pia/core/service/PiaSettingService;", "Lcom/bytedance/pia/core/api/services/IPiaSettingService;", "()V", "enableSetting", "", "enable", "", "initialize", "appInfo", "Lcom/bytedance/pia/core/api/PiaAppInfo;", "apiHost", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PiaSettingService implements IPiaSettingService {
    public static final PiaSettingService INSTANCE = new PiaSettingService();

    private PiaSettingService() {
    }

    @Override // com.bytedance.pia.core.api.services.IPiaSettingService
    public void initialize(PiaAppInfo appInfo, String apiHost) {
        if (appInfo == null || apiHost == null) {
            return;
        }
        SettingService.INSTANCE.initialize(appInfo, apiHost);
    }

    @Override // com.bytedance.pia.core.api.services.IPiaSettingService
    public void enableSetting(boolean enable) {
        SettingService.INSTANCE.enableSetting(enable);
    }
}
