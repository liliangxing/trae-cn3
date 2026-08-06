package com.bytedance.trae.anniex;

import com.bytedance.ies.bullet.core.kit.service.BaseBridgeService;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultBridgeService.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/anniex/DefaultBridgeService;", "Lcom/bytedance/ies/bullet/core/kit/service/BaseBridgeService;", "<init>", "()V", "initialize", "", "createBridges", "", "Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod;", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "useXBridge3", "", "useWebXBridge3", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DefaultBridgeService extends BaseBridgeService {
    public static final int $stable = 0;

    public void initialize() {
    }

    public boolean useWebXBridge3() {
        return true;
    }

    public boolean useXBridge3() {
        return true;
    }

    public List<IBridgeMethod> createBridges(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return CollectionsKt.emptyList();
    }
}
