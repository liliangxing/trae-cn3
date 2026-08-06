package com.bytedance.ies.argus.plugin;

import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.ies.argus.bean.AspectContext;
import kotlin.Metadata;

/* compiled from: ISecurePlugin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J&\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\u0010\t\u001a\u000e0\nR\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/argus/plugin/BaseSecurePlugin;", "", "()V", "name", "Lcom/bytedance/ies/argus/plugin/SecurePluginType;", SettingsManager.VERIFY_SERVICE, "", "remoteConfig", "Lcom/bytedance/ies/argus/plugin/ContainerPluginConf;", "context", "Lcom/bytedance/ies/argus/bean/AspectContext$CalculateContext;", "Lcom/bytedance/ies/argus/bean/AspectContext;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class BaseSecurePlugin {
    public abstract SecurePluginType name();

    public abstract void verify(ContainerPluginConf remoteConfig, AspectContext<?, ?>.CalculateContext context);
}
