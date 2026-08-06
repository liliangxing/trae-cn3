package com.bytedance.android.anniex.container.util;

import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.container.IPageContainer;
import com.bytedance.android.anniex.container.AnnieXContainer;
import com.bytedance.android.anniex.container.AnnieXPopupContainer;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import kotlin.Metadata;

/* compiled from: AnnieXUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0006"}, d2 = {"isAnnieX", "Lcom/bytedance/android/anniex/base/container/IContainer;", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "isAnnieXPage", "isAnnieXPopup", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXUtilsKt {
    public static final IContainer isAnnieXPage(IBDXBridgeContext iBDXBridgeContext) {
        ContextProviderFactory contextProviderFactory;
        if (iBDXBridgeContext == null || (contextProviderFactory = (ContextProviderFactory) iBDXBridgeContext.getService(ContextProviderFactory.class)) == null) {
            return null;
        }
        IContainer iContainer = (IContainer) contextProviderFactory.provideInstance(IContainer.class);
        if (iContainer instanceof IPageContainer) {
            return iContainer;
        }
        return null;
    }

    public static final IContainer isAnnieXPopup(IBDXBridgeContext iBDXBridgeContext) {
        ContextProviderFactory contextProviderFactory;
        if (iBDXBridgeContext == null || (contextProviderFactory = (ContextProviderFactory) iBDXBridgeContext.getService(ContextProviderFactory.class)) == null) {
            return null;
        }
        IContainer iContainer = (IContainer) contextProviderFactory.provideInstance(IContainer.class);
        if (iContainer instanceof AnnieXPopupContainer) {
            return iContainer;
        }
        return null;
    }

    public static final IContainer isAnnieX(IBDXBridgeContext iBDXBridgeContext) {
        ContextProviderFactory contextProviderFactory;
        if (iBDXBridgeContext == null || (contextProviderFactory = (ContextProviderFactory) iBDXBridgeContext.getService(ContextProviderFactory.class)) == null) {
            return null;
        }
        IContainer iContainer = (IContainer) contextProviderFactory.provideInstance(IContainer.class);
        if (iContainer instanceof AnnieXContainer) {
            return iContainer;
        }
        return null;
    }
}
