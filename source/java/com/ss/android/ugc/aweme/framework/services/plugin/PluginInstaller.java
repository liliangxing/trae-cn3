package com.ss.android.ugc.aweme.framework.services.plugin;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PluginInstaller.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/plugin/PluginInstaller;", "", "()V", "GEN_CLASS_NAME", "", "onPluginInstall", "", "pluginPackageName", "spi_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class PluginInstaller {
    private static final String GEN_CLASS_NAME = "SpiPluginBinder";
    public static final PluginInstaller INSTANCE = new PluginInstaller();

    private PluginInstaller() {
    }

    public final void onPluginInstall(String pluginPackageName) {
        Intrinsics.checkParameterIsNotNull(pluginPackageName, "pluginPackageName");
        Object newInstance = Class.forName(pluginPackageName + ".SpiPluginBinder").newInstance();
        if (newInstance == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.ss.android.ugc.aweme.framework.services.plugin.IPluginBinder");
        }
        ((IPluginBinder) newInstance).bindPluginSpi();
    }
}
