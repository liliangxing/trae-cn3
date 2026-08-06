package com.bytedance.ies.bullet.core;

import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import kotlin.Metadata;

/* compiled from: IBulletAbility.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/core/IBulletAbility;", "", "dispatchEvent", "", "bid", "", "event", "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "getBid", "getIBulletContainer", "Lcom/bytedance/ies/bullet/core/container/IBulletContainer;", "sessionId", "onAppStateChange", "state", "Lcom/bytedance/ies/bullet/core/AppState;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IBulletAbility {
    void dispatchEvent(String bid, IEvent event);

    String getBid();

    IBulletContainer getIBulletContainer(String sessionId);

    void onAppStateChange(AppState state);
}
