package com.bytedance.ies.bullet.service.base;

import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import kotlin.Metadata;

/* compiled from: IPrefetchV2Service.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001¨\u0006\u0002"}, d2 = {"getPrefetchV2Service", "Lcom/bytedance/ies/bullet/service/base/IPrefetchV2Service;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class IPrefetchV2ServiceKt {
    public static final IPrefetchV2Service getPrefetchV2Service() {
        return (IPrefetchV2Service) StandardServiceManager.INSTANCE.get(IPrefetchV2Service.class);
    }
}
