package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: BridgeMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R$\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00050\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeScopeProviderFactory;", "", "bridgesProvider", "Lkotlin/Function1;", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "", "Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod;", "getBridgesProvider", "()Lkotlin/jvm/functions/Function1;", "name", "", "getName", "()Ljava/lang/String;", "subScopesProvider", "getSubScopesProvider", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IBridgeScopeProviderFactory {
    Function1<ContextProviderFactory, List<IGenericBridgeMethod>> getBridgesProvider();

    String getName();

    Function1<ContextProviderFactory, List<IBridgeScopeProviderFactory>> getSubScopesProvider();
}
