package com.bytedance.ies.bullet.core;

import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.trae.login.activity.PhoneBindActivity;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletContainerManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0006J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u0005J\u001e\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0006R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/core/BulletContainerManager;", "", "()V", "mContainersWithBid", "", "", "Lcom/bytedance/ies/bullet/core/container/IBulletContainer;", PhoneBindActivity.MODE_BIND, "", "bid", "bulletContainer", "getBySessionId", "sessionId", "getContainers", "unBind", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletContainerManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final BulletContainerManager Instance = new BulletContainerManager();
    private final Map<String, Map<String, IBulletContainer>> mContainersWithBid = new LinkedHashMap();

    private BulletContainerManager() {
    }

    /* compiled from: BulletContainerManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/core/BulletContainerManager$Companion;", "", "()V", "Instance", "Lcom/bytedance/ies/bullet/core/BulletContainerManager;", "getInstance", "()Lcom/bytedance/ies/bullet/core/BulletContainerManager;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BulletContainerManager getInstance() {
            return BulletContainerManager.Instance;
        }
    }

    public final Map<String, IBulletContainer> getContainers(String bid) {
        return this.mContainersWithBid.get(bid);
    }

    public static /* synthetic */ void bind$default(BulletContainerManager bulletContainerManager, String str, IBulletContainer iBulletContainer, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "default_bid";
        }
        bulletContainerManager.bind(str, iBulletContainer);
    }

    public final void bind(String bid, IBulletContainer bulletContainer) {
        Intrinsics.checkNotNullParameter(bulletContainer, "bulletContainer");
        if (bid != null) {
            if (getContainers(bid) == null) {
                this.mContainersWithBid.put(bid, new LinkedHashMap());
            }
            Map<String, IBulletContainer> containers = getContainers(bid);
            if (containers != null) {
                containers.put(String.valueOf(bulletContainer.hashCode()), bulletContainer);
            }
        }
    }

    public static /* synthetic */ void unBind$default(BulletContainerManager bulletContainerManager, String str, IBulletContainer iBulletContainer, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "default_bid";
        }
        bulletContainerManager.unBind(str, iBulletContainer);
    }

    public final void unBind(String bid, IBulletContainer bulletContainer) {
        Intrinsics.checkNotNullParameter(bulletContainer, "bulletContainer");
        Map<String, IBulletContainer> containers = getContainers(bid);
        if (containers != null) {
            containers.remove(String.valueOf(bulletContainer.hashCode()));
        }
        Iterator<Map.Entry<String, Map<String, IBulletContainer>>> it = this.mContainersWithBid.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().remove(String.valueOf(bulletContainer.hashCode()));
        }
    }

    public static /* synthetic */ IBulletContainer getBySessionId$default(BulletContainerManager bulletContainerManager, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "default_bid";
        }
        return bulletContainerManager.getBySessionId(str, str2);
    }

    public final IBulletContainer getBySessionId(String bid, String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Map<String, IBulletContainer> containers = getContainers(bid);
        if (containers != null) {
            for (String str : containers.keySet()) {
                IBulletContainer iBulletContainer = containers.get(str);
                if (Intrinsics.areEqual(iBulletContainer != null ? iBulletContainer.getSessionId() : null, sessionId)) {
                    return containers.get(str);
                }
            }
        }
        return null;
    }
}
