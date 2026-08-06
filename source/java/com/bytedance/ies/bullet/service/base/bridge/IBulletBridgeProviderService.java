package com.bytedance.ies.bullet.service.base.bridge;

import com.bytedance.ies.bullet.service.base.api.IBulletService;
import java.util.List;
import kotlin.Metadata;

/* compiled from: IBulletBridgeProviderService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007H&¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/bridge/IBulletBridgeProviderService;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "provideBridgeList", "", "", "providerFactory", "bridgeName", "", "bid", "sessionId", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IBulletBridgeProviderService extends IBulletService {
    List<Object> provideBridgeList(Object providerFactory, String bridgeName, String bid, String sessionId);

    /* compiled from: IBulletBridgeProviderService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ List provideBridgeList$default(IBulletBridgeProviderService iBulletBridgeProviderService, Object obj, String str, String str2, String str3, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: provideBridgeList");
            }
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                str2 = "default_bid";
            }
            if ((i & 8) != 0) {
                str3 = null;
            }
            return iBulletBridgeProviderService.provideBridgeList(obj, str, str2, str3);
        }
    }
}
