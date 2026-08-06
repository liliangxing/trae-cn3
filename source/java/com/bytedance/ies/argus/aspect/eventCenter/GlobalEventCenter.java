package com.bytedance.ies.argus.aspect.eventCenter;

import com.bytedance.ies.argus.api.ArgusLynxDelegate;
import com.bytedance.ies.argus.util.CommonUtils;
import com.lynx.tasm.LynxView;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GlobalEventCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0005R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/argus/aspect/eventCenter/GlobalEventCenter;", "", "()V", "lynxViewStorage", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/ies/argus/api/ArgusLynxDelegate;", "signFailedVerifyUrl2CountMap", "", "", "getSignFailedVerifyUrl2CountMap", "()Ljava/util/Map;", "getContext", "lynxView", "Lcom/lynx/tasm/LynxView;", "recordContext", "", "delegate", "removeContext", "viewId", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GlobalEventCenter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<GlobalEventCenter> instance$delegate = LazyKt.lazy(new Function0<GlobalEventCenter>() { // from class: com.bytedance.ies.argus.aspect.eventCenter.GlobalEventCenter$Companion$instance$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final GlobalEventCenter m598invoke() {
            return new GlobalEventCenter();
        }
    });
    private final ConcurrentHashMap<String, WeakReference<ArgusLynxDelegate>> lynxViewStorage = new ConcurrentHashMap<>();
    private final Map<String, Integer> signFailedVerifyUrl2CountMap = new LinkedHashMap();

    /* compiled from: GlobalEventCenter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/aspect/eventCenter/GlobalEventCenter$Companion;", "", "()V", "instance", "Lcom/bytedance/ies/argus/aspect/eventCenter/GlobalEventCenter;", "getInstance", "()Lcom/bytedance/ies/argus/aspect/eventCenter/GlobalEventCenter;", "instance$delegate", "Lkotlin/Lazy;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlobalEventCenter getInstance() {
            return (GlobalEventCenter) GlobalEventCenter.instance$delegate.getValue();
        }
    }

    public final void recordContext(ArgusLynxDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        String viewId = delegate.getViewContext$anniex_release().getViewId();
        if (viewId != null) {
            this.lynxViewStorage.put(viewId, new WeakReference<>(delegate));
        }
    }

    public final WeakReference<ArgusLynxDelegate> getContext(LynxView lynxView) {
        Intrinsics.checkNotNullParameter(lynxView, "lynxView");
        String objectId = CommonUtils.INSTANCE.getObjectId(lynxView);
        if (objectId != null) {
            return this.lynxViewStorage.get(objectId);
        }
        return null;
    }

    public final void removeContext(String viewId) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        this.lynxViewStorage.remove(viewId);
    }

    public final Map<String, Integer> getSignFailedVerifyUrl2CountMap() {
        return this.signFailedVerifyUrl2CountMap;
    }
}
