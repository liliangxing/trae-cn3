package com.bytedance.ies.bullet.base.settings;

import com.bytedance.news.common.settings.api.annotation.ITypeConverter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;

/* compiled from: ArgusSecuritySettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0000H\u0016J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\b\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/ArgusSecuritySettings;", "Lcom/bytedance/news/common/settings/api/annotation/ITypeConverter;", "()V", "config", "", "from", "t", "getConfig", RemoteMessageConst.TO, "json", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class ArgusSecuritySettings implements ITypeConverter<ArgusSecuritySettings> {
    private String config;

    public final String getConfig() {
        return this.config;
    }

    @Override // com.bytedance.news.common.settings.api.annotation.ITypeConverter, com.bytedance.platform.settingsx.api.ITypeConverter
    public ArgusSecuritySettings to(String json) {
        ArgusSecuritySettings argusSecuritySettings = new ArgusSecuritySettings();
        argusSecuritySettings.config = json;
        return argusSecuritySettings;
    }

    @Override // com.bytedance.news.common.settings.api.annotation.ITypeConverter, com.bytedance.platform.settingsx.api.ITypeConverter
    public String from(ArgusSecuritySettings t) {
        if (t != null) {
            return t.config;
        }
        return null;
    }
}
