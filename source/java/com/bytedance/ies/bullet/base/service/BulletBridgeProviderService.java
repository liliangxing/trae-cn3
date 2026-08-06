package com.bytedance.ies.bullet.base.service;

import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.bridge.IBulletBridgeProviderService;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.ies.bullet.service.monitor.deviceperf.bridge.BulletStartRecordBridge;
import com.bytedance.ies.bullet.service.monitor.deviceperf.bridge.BulletStopRecordBridge;
import com.bytedance.ies.bullet.service.monitor.tracert.BulletSetTracertBridge;
import com.bytedance.ies.bullet.service.preload.WebPreRenderBridge;
import com.bytedance.ies.bullet.service.preload.WebPreloadBridge;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletBridgeProviderService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J4\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/base/service/BulletBridgeProviderService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "Lcom/bytedance/ies/bullet/service/base/bridge/IBulletBridgeProviderService;", "()V", "provideBridgeList", "", "", "providerFactory", "bridgeName", "", "bid", "sessionId", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletBridgeProviderService extends BaseBulletService implements IBulletBridgeProviderService {
    @Override // com.bytedance.ies.bullet.service.base.bridge.IBulletBridgeProviderService
    public List<Object> provideBridgeList(Object providerFactory, String bridgeName, String bid, String sessionId) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        Intrinsics.checkNotNullParameter(bid, "bid");
        ArrayList arrayList = new ArrayList();
        ContextProviderFactory contextProviderFactory = (ContextProviderFactory) providerFactory;
        arrayList.add(new WebPreloadBridge(contextProviderFactory));
        arrayList.add(new WebPreRenderBridge(contextProviderFactory));
        arrayList.add(new ViewVisibleBridge(contextProviderFactory));
        arrayList.add(new GetBridgeListBridge(contextProviderFactory));
        arrayList.add(new BulletSetTracertBridge(contextProviderFactory));
        arrayList.add(new BulletStartRecordBridge(contextProviderFactory));
        arrayList.add(new BulletStopRecordBridge(contextProviderFactory));
        return arrayList;
    }
}
