package com.bytedance.ies.bullet.core;

import kotlin.Metadata;

/* compiled from: PoolBulletLifeCycle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0002¨\u0006\u0002"}, d2 = {"expectPool", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class PoolBulletLifeCycleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final IBulletLifeCycle expectPool(IBulletLifeCycle iBulletLifeCycle) {
        if (iBulletLifeCycle instanceof PoolBulletLifeCycle) {
            return null;
        }
        return iBulletLifeCycle;
    }
}
