package com.bytedance.ies.argus.base;

import com.bytedance.ies.argus.aspect.ArgusBaseViewDelegate;
import com.bytedance.ies.argus.bean.ArgusGlobalCommonConfig;
import com.bytedance.ies.argus.bean.GlobalDefinition;
import com.bytedance.ies.argus.repository.ArgusConfigManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArgusDelegateHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bJ\u0010\u0010\b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0005R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/argus/base/ArgusDelegateHelper;", "", "()V", "highRiskSceneList", "", "", "getHighRiskSceneList", "()Ljava/util/List;", "isHighRiskScene", "", "delegate", "Lcom/bytedance/ies/argus/aspect/ArgusBaseViewDelegate;", "scene", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusDelegateHelper {
    public static final ArgusDelegateHelper INSTANCE = new ArgusDelegateHelper();

    private ArgusDelegateHelper() {
    }

    private final List<String> getHighRiskSceneList() {
        GlobalDefinition globalDef;
        List<String> highRiskCIdList;
        ArgusGlobalCommonConfig argusSecuritySettingConfig = ArgusConfigManager.INSTANCE.getInstance().getArgusSecuritySettingConfig();
        return (argusSecuritySettingConfig == null || (globalDef = argusSecuritySettingConfig.getGlobalDef()) == null || (highRiskCIdList = globalDef.getHighRiskCIdList()) == null) ? CollectionsKt.emptyList() : highRiskCIdList;
    }

    public final boolean isHighRiskScene(ArgusBaseViewDelegate<?> delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        if (!(!getHighRiskSceneList().isEmpty())) {
            return false;
        }
        String argusSceneTag = delegate.getViewContext$anniex_release().getArgusSceneTag();
        if (argusSceneTag == null) {
            argusSceneTag = delegate.getContainerContext$anniex_release().getArgusSceneTag();
        }
        return isHighRiskScene(argusSceneTag);
    }

    public final boolean isHighRiskScene(String scene) {
        return scene != null && getHighRiskSceneList().contains(scene);
    }
}
