package com.bytedance.trae.settings.impl;

import com.bytedance.news.common.settings.api.SettingsAbReportService;
import com.bytedance.trae.applog.api.IApplog;
import kotlin.Metadata;

/* compiled from: SettingsAbVersionServiceImpl.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/settings/impl/SettingsAbVersionServiceImpl;", "Lcom/bytedance/news/common/settings/api/SettingsAbReportService;", "<init>", "()V", "setAbSDKVersion", "", "vid", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SettingsAbVersionServiceImpl implements SettingsAbReportService {
    @Override // com.bytedance.news.common.settings.api.SettingsAbReportService
    public void setAbSDKVersion(String vid) {
        String str = vid;
        if (str == null || str.length() == 0) {
            return;
        }
        IApplog.Companion.setExternalAbVersionFromSettings(vid);
    }
}
