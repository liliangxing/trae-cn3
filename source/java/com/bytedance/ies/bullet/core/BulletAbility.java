package com.bytedance.ies.bullet.core;

import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.push.interfaze.ISignalReportService;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletAbility.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/core/BulletAbility;", "Lcom/bytedance/ies/bullet/core/IBulletAbility;", "bid", "", "(Ljava/lang/String;)V", "dispatchEvent", "", ISignalReportService.BODY_KEY_EVENT, "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "getBid", "getIBulletContainer", "Lcom/bytedance/ies/bullet/core/container/IBulletContainer;", "sessionId", "onAppStateChange", "state", "Lcom/bytedance/ies/bullet/core/AppState;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletAbility implements IBulletAbility {
    private final String bid;

    /* compiled from: BulletAbility.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AppState.values().length];
            try {
                iArr[AppState.ON_APP_SHOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppState.ON_APP_HIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BulletAbility(String str) {
        Intrinsics.checkNotNullParameter(str, "bid");
        this.bid = str;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletAbility
    public String getBid() {
        return this.bid;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletAbility
    public IBulletContainer getIBulletContainer(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return BulletContainerManager.INSTANCE.getInstance().getBySessionId(getBid(), sessionId);
    }

    @Override // com.bytedance.ies.bullet.core.IBulletAbility
    public void dispatchEvent(String bid, IEvent event) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(event, ISignalReportService.BODY_KEY_EVENT);
        Map<String, IBulletContainer> containers = BulletContainerManager.INSTANCE.getInstance().getContainers(bid);
        if (containers != null) {
            Iterator<T> it = containers.values().iterator();
            while (it.hasNext()) {
                ((IBulletContainer) it.next()).onEvent(event);
            }
        }
    }

    @Override // com.bytedance.ies.bullet.core.IBulletAbility
    public void onAppStateChange(AppState state) {
        IEvent iEvent;
        Intrinsics.checkNotNullParameter(state, "state");
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1) {
            iEvent = new IEvent() { // from class: com.bytedance.ies.bullet.core.BulletAbility$onAppStateChange$event$1
                @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
                public String getName() {
                    return "appBecomeActive";
                }

                @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
                public Object getParams() {
                    return null;
                }
            };
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            iEvent = new IEvent() { // from class: com.bytedance.ies.bullet.core.BulletAbility$onAppStateChange$event$2
                @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
                public String getName() {
                    return "appResignActive";
                }

                @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
                public Object getParams() {
                    return null;
                }
            };
        }
        Map<String, IBulletContainer> containers = BulletContainerManager.INSTANCE.getInstance().getContainers(this.bid);
        if (containers != null) {
            Iterator<T> it = containers.values().iterator();
            while (it.hasNext()) {
                ((IBulletContainer) it.next()).onEvent(iEvent);
            }
        }
    }
}
