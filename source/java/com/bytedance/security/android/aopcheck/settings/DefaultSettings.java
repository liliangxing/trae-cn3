package com.bytedance.security.android.aopcheck.settings;

import com.bytedance.news.common.settings.api.annotation.IDefaultValueProvider;
import kotlin.Metadata;

/* compiled from: MobiusAOPCheckSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/security/android/aopcheck/settings/DefaultSettings;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "Lcom/bytedance/security/android/aopcheck/settings/SettingsModel;", "()V", "create", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class DefaultSettings implements IDefaultValueProvider<SettingsModel> {
    @Override // com.bytedance.news.common.settings.api.annotation.IDefaultValueProvider, com.bytedance.platform.settingsx.api.IDefaultValueProvider
    public SettingsModel create() {
        return new SettingsModel();
    }
}
