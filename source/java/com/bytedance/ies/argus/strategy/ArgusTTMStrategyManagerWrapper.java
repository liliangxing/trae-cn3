package com.bytedance.ies.argus.strategy;

import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider;
import com.bytedance.ies.argus.strategy.provider.ttm.ITTMStrategyManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArgusTTMStrategyManagerWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u0004\u0018\u00010\fJ\u0014\u0010\u0012\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0006\u0010\u0014\u001a\u00020\nR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/argus/strategy/ArgusTTMStrategyManagerWrapper;", "", "()V", "strategyProvider", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyProvider;", "getStrategyProvider", "()Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyProvider;", "ttmInitCallback", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function0;", "", "ttmInstance", "Lcom/bytedance/ies/argus/strategy/provider/ttm/ITTMStrategyManager;", "getTtmInstance", "()Lcom/bytedance/ies/argus/strategy/provider/ttm/ITTMStrategyManager;", "setTtmInstance", "(Lcom/bytedance/ies/argus/strategy/provider/ttm/ITTMStrategyManager;)V", "initInstance", "registerTTMInitCallback", JsCallParser.VALUE_CALLBACK, "setup", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusTTMStrategyManagerWrapper {
    private final CopyOnWriteArrayList<Function0<Unit>> ttmInitCallback = new CopyOnWriteArrayList<>();
    private ITTMStrategyManager ttmInstance;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<ArgusTTMStrategyManagerWrapper> instance$delegate = LazyKt.lazy(new Function0<ArgusTTMStrategyManagerWrapper>() { // from class: com.bytedance.ies.argus.strategy.ArgusTTMStrategyManagerWrapper$Companion$instance$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ArgusTTMStrategyManagerWrapper m618invoke() {
            return new ArgusTTMStrategyManagerWrapper();
        }
    });
    private static final String TAG = "TTMStrategyManagerWrapper";

    /* compiled from: ArgusTTMStrategyManagerWrapper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/argus/strategy/ArgusTTMStrategyManagerWrapper$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/bytedance/ies/argus/strategy/ArgusTTMStrategyManagerWrapper;", "getInstance", "()Lcom/bytedance/ies/argus/strategy/ArgusTTMStrategyManagerWrapper;", "instance$delegate", "Lkotlin/Lazy;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArgusTTMStrategyManagerWrapper getInstance() {
            return (ArgusTTMStrategyManagerWrapper) ArgusTTMStrategyManagerWrapper.instance$delegate.getValue();
        }

        public final String getTAG() {
            return ArgusTTMStrategyManagerWrapper.TAG;
        }
    }

    public final ITTMStrategyManager getTtmInstance() {
        return this.ttmInstance;
    }

    public final void setTtmInstance(ITTMStrategyManager iTTMStrategyManager) {
        this.ttmInstance = iTTMStrategyManager;
    }

    public final BaseStrategyProvider getStrategyProvider() {
        ITTMStrategyManager iTTMStrategyManager = this.ttmInstance;
        if (iTTMStrategyManager != null) {
            return iTTMStrategyManager.getStrategyProvider();
        }
        return null;
    }

    public final void setup() {
        ArgusLog.d$default(ArgusLog.INSTANCE, TAG, "setup", null, 4, null);
        ITTMStrategyManager initInstance = initInstance();
        if (initInstance != null) {
            this.ttmInstance = initInstance;
            if (!this.ttmInitCallback.isEmpty()) {
                Iterator<T> it = this.ttmInitCallback.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                this.ttmInitCallback.clear();
            }
        }
    }

    public final void registerTTMInitCallback(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, JsCallParser.VALUE_CALLBACK);
        this.ttmInitCallback.add(callback);
    }

    public final ITTMStrategyManager initInstance() {
        try {
            Object newInstance = Class.forName("com.bytedance.ies.argus.strategy.provider.ttm.TTMStrategyManager").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.bytedance.ies.argus.strategy.provider.ttm.ITTMStrategyManager");
            ITTMStrategyManager iTTMStrategyManager = (ITTMStrategyManager) newInstance;
            if (iTTMStrategyManager.setup()) {
                return iTTMStrategyManager;
            }
            return null;
        } catch (Throwable th) {
            ArgusLog.e$default(ArgusLog.INSTANCE, TAG, "com.bytedance.ies.argus.strategy.provider.ttm.TTMStrategyManager load failed: " + th.getMessage(), null, null, 12, null);
            return null;
        }
    }
}
