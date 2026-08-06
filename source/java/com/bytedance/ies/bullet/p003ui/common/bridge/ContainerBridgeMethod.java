package com.bytedance.ies.bullet.p003ui.common.bridge;

import android.content.Context;
import com.bytedance.ies.bullet.core.container.IBulletActivityWrapper;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContainerBridgeMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/bridge/ContainerBridgeMethod;", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeMethod;", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "(Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;)V", "getActivityWrapper", "Lcom/bytedance/ies/bullet/core/container/IBulletActivityWrapper;", "getContext", "Landroid/content/Context;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class ContainerBridgeMethod extends BridgeMethod {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContainerBridgeMethod(ContextProviderFactory contextProviderFactory) {
        super(contextProviderFactory);
        Intrinsics.checkNotNullParameter(contextProviderFactory, "contextProviderFactory");
    }

    protected final Context getContext() {
        return (Context) getContextProviderFactory().provideInstance(Context.class);
    }

    protected final IBulletActivityWrapper getActivityWrapper() {
        IBulletContainer iBulletContainer = (IBulletContainer) getContextProviderFactory().provideInstance(IBulletContainer.class);
        if (iBulletContainer != null) {
            return iBulletContainer.getActivityWrapper();
        }
        return null;
    }
}
