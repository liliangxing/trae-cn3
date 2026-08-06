package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BridgeMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeMethod;", "Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod;", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "(Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;)V", "access", "Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access;", "setAccess", "(Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access;)V", "getContextProviderFactory", "()Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "setContextProviderFactory", "needCallback", "", "getNeedCallback", "()Z", "setNeedCallback", "(Z)V", "canRunInBackground", "release", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class BridgeMethod implements IBridgeMethod {
    private IBridgeMethod.Access access;
    private ContextProviderFactory contextProviderFactory;
    private boolean needCallback;

    public boolean canRunInBackground() {
        return false;
    }

    @Override // com.bytedance.ies.bullet.service.base.IReleasable
    public void release() {
    }

    public BridgeMethod(ContextProviderFactory contextProviderFactory) {
        Intrinsics.checkNotNullParameter(contextProviderFactory, "contextProviderFactory");
        this.contextProviderFactory = contextProviderFactory;
        this.access = IBridgeMethod.Access.PRIVATE;
    }

    public final ContextProviderFactory getContextProviderFactory() {
        return this.contextProviderFactory;
    }

    public final void setContextProviderFactory(ContextProviderFactory contextProviderFactory) {
        Intrinsics.checkNotNullParameter(contextProviderFactory, "<set-?>");
        this.contextProviderFactory = contextProviderFactory;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod
    public IBridgeMethod.Access getAccess() {
        return this.access;
    }

    public void setAccess(IBridgeMethod.Access access) {
        Intrinsics.checkNotNullParameter(access, "<set-?>");
        this.access = access;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod
    public boolean getNeedCallback() {
        return this.needCallback;
    }

    public void setNeedCallback(boolean z) {
        this.needCallback = z;
    }
}
