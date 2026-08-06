package com.bytedance.android.anniex.base.service;

import com.bytedance.android.anniex.model.AnnieXLynxModel;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.p026ui.AnnieXLynxView;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.service.async.LynxAsyncManager;
import com.lynx.tasm.service.async.LynxAsyncService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: AnnieXLynxOptimizeService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0084\u0001\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00152\u001a\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\u0004\u0018\u0001` 2>\u0010!\u001a:\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001f\u0018\u00010\"j\u0004\u0018\u0001`'2\b\u0010(\u001a\u0004\u0018\u00010)J\u0016\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\rJ\u0016\u0010-\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\rJ\u0018\u0010.\u001a\u0004\u0018\u00010\u000f2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\rJ\u0018\u0010/\u001a\u0004\u0018\u00010\u00152\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\rJ\u0010\u00100\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001b\u001a\u00020\u000fJ\u001e\u00101\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u000fJ\u001e\u00102\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0015J\u0010\u00103\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001b\u001a\u00020\u000fJ\u0016\u00104\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0015R?\u0010\u0003\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0087\u0001\u0010\u000b\u001an\u0012\u0004\u0012\u00020\r\u0012,\u0012*\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\fj\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e`\u00100\fj6\u0012\u0004\u0012\u00020\r\u0012,\u0012*\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\fj\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e`\u0010`\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0011\u0010\u0012R\u0087\u0001\u0010\u0014\u001an\u0012\u0004\u0012\u00020\r\u0012,\u0012*\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000e0\fj\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000e`\u00100\fj6\u0012\u0004\u0012\u00020\r\u0012,\u0012*\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000e0\fj\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000e`\u0010`\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0016\u0010\u0012¨\u00065"}, d2 = {"Lcom/bytedance/android/anniex/base/service/AnnieXLynxOptimizeService;", "", "()V", "lynxAsyncManager", "Lcom/lynx/tasm/service/async/LynxAsyncManager;", "Lcom/bytedance/android/anniex/base/service/AnnieXLynxAsyncLayoutContainer;", "kotlin.jvm.PlatformType", "getLynxAsyncManager", "()Lcom/lynx/tasm/service/async/LynxAsyncManager;", "lynxAsyncManager$delegate", "Lkotlin/Lazy;", "lynxModelCacheMap", "Ljava/util/HashMap;", "", "", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel;", "Lkotlin/collections/HashMap;", "getLynxModelCacheMap", "()Ljava/util/HashMap;", "lynxModelCacheMap$delegate", "lynxViewCacheMap", "Lcom/bytedance/android/anniex/ui/AnnieXLynxView;", "getLynxViewCacheMap", "lynxViewCacheMap$delegate", "asyncLayoutView", "", "needRender", "lynxModel", "lynxView", "loadMethod", "Lkotlin/Function1;", "", "Lcom/bytedance/android/anniex/api/AnnieXLynxLoadMethod;", "layoutCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", StrategyConstants.NAME, "view", "success", "Lcom/bytedance/android/anniex/api/AnnieXLynxLayoutCallback;", "loadMeta", "Lcom/bytedance/android/anniex/base/service/AnnieXLynxAsyncLoadRunnableMeta;", "clearModel", "bid", "key", "clearView", "getModel", "getView", "getViewFromCacheFuture", "putModel", "putView", "removeViewFromCache", "renderView", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLynxOptimizeService {
    public static final AnnieXLynxOptimizeService INSTANCE = new AnnieXLynxOptimizeService();

    /* renamed from: lynxModelCacheMap$delegate, reason: from kotlin metadata */
    private static final Lazy lynxModelCacheMap = LazyKt.lazy(new Function0<HashMap<String, HashMap<String, List<AnnieXLynxModel>>>>() { // from class: com.bytedance.android.anniex.base.service.AnnieXLynxOptimizeService$lynxModelCacheMap$2
        public final HashMap<String, HashMap<String, List<AnnieXLynxModel>>> invoke() {
            return new HashMap<>();
        }
    });

    /* renamed from: lynxViewCacheMap$delegate, reason: from kotlin metadata */
    private static final Lazy lynxViewCacheMap = LazyKt.lazy(new Function0<HashMap<String, HashMap<String, List<AnnieXLynxView>>>>() { // from class: com.bytedance.android.anniex.base.service.AnnieXLynxOptimizeService$lynxViewCacheMap$2
        public final HashMap<String, HashMap<String, List<AnnieXLynxView>>> invoke() {
            return new HashMap<>();
        }
    });

    /* renamed from: lynxAsyncManager$delegate, reason: from kotlin metadata */
    private static final Lazy lynxAsyncManager = LazyKt.lazy(new Function0<LynxAsyncManager<AnnieXLynxAsyncLayoutContainer>>() { // from class: com.bytedance.android.anniex.base.service.AnnieXLynxOptimizeService$lynxAsyncManager$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final LynxAsyncManager<AnnieXLynxAsyncLayoutContainer> m3291invoke() {
            return LynxAsyncService.getInstance().generateLynxAsyncManager(new LynxAsyncManager.Builder());
        }
    });

    private AnnieXLynxOptimizeService() {
    }

    private final HashMap<String, HashMap<String, List<AnnieXLynxModel>>> getLynxModelCacheMap() {
        return (HashMap) lynxModelCacheMap.getValue();
    }

    public final AnnieXLynxModel getModel(String bid, String key) {
        List<AnnieXLynxModel> list;
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(key, "key");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (getLynxModelCacheMap()) {
            HashMap<String, List<AnnieXLynxModel>> hashMap = INSTANCE.getLynxModelCacheMap().get(bid);
            AnnieXLynxModel annieXLynxModel = null;
            if (hashMap != null && (list = hashMap.get(key)) != null) {
                Intrinsics.checkNotNullExpressionValue(list, "it");
                if (!Boolean.valueOf(!list.isEmpty()).booleanValue()) {
                    list = null;
                }
                if (list != null) {
                    annieXLynxModel = list.remove(0);
                }
            }
            objectRef.element = annieXLynxModel;
            Unit unit = Unit.INSTANCE;
        }
        return (AnnieXLynxModel) objectRef.element;
    }

    public final void putModel(String bid, String key, AnnieXLynxModel lynxModel) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(lynxModel, "lynxModel");
        synchronized (getLynxModelCacheMap()) {
            AnnieXLynxOptimizeService annieXLynxOptimizeService = INSTANCE;
            if (annieXLynxOptimizeService.getLynxModelCacheMap().containsKey(bid)) {
                HashMap<String, List<AnnieXLynxModel>> hashMap = annieXLynxOptimizeService.getLynxModelCacheMap().get(bid);
                if (hashMap != null) {
                    if (hashMap.containsKey(key)) {
                        List<AnnieXLynxModel> list = hashMap.get(key);
                        if (list != null) {
                            Boolean.valueOf(list.add(lynxModel));
                        }
                    } else {
                        Intrinsics.checkNotNullExpressionValue(hashMap, "it");
                        hashMap.put(key, CollectionsKt.mutableListOf(new AnnieXLynxModel[]{lynxModel}));
                        Unit unit = Unit.INSTANCE;
                    }
                }
            } else {
                annieXLynxOptimizeService.getLynxModelCacheMap().put(bid, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(key, CollectionsKt.mutableListOf(new AnnieXLynxModel[]{lynxModel}))}));
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    public final void clearModel(String bid, String key) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (getLynxModelCacheMap()) {
            HashMap<String, List<AnnieXLynxModel>> hashMap = INSTANCE.getLynxModelCacheMap().get(bid);
            if (hashMap != null) {
                hashMap.remove(key);
            }
        }
    }

    private final HashMap<String, HashMap<String, List<AnnieXLynxView>>> getLynxViewCacheMap() {
        return (HashMap) lynxViewCacheMap.getValue();
    }

    public final AnnieXLynxView getView(String bid, String key) {
        List<AnnieXLynxView> list;
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(key, "key");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (getLynxViewCacheMap()) {
            HashMap<String, List<AnnieXLynxView>> hashMap = INSTANCE.getLynxViewCacheMap().get(bid);
            AnnieXLynxView annieXLynxView = null;
            if (hashMap != null && (list = hashMap.get(key)) != null) {
                Intrinsics.checkNotNullExpressionValue(list, "it");
                if (!Boolean.valueOf(!list.isEmpty()).booleanValue()) {
                    list = null;
                }
                if (list != null) {
                    annieXLynxView = list.remove(0);
                }
            }
            objectRef.element = annieXLynxView;
            Unit unit = Unit.INSTANCE;
        }
        return (AnnieXLynxView) objectRef.element;
    }

    public final void putView(String bid, String key, AnnieXLynxView lynxView) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(lynxView, "lynxView");
        lynxView.markOptimizeFlag(1);
        synchronized (getLynxViewCacheMap()) {
            AnnieXLynxOptimizeService annieXLynxOptimizeService = INSTANCE;
            if (annieXLynxOptimizeService.getLynxViewCacheMap().containsKey(bid)) {
                HashMap<String, List<AnnieXLynxView>> hashMap = annieXLynxOptimizeService.getLynxViewCacheMap().get(bid);
                if (hashMap != null) {
                    if (hashMap.containsKey(key)) {
                        List<AnnieXLynxView> list = hashMap.get(key);
                        if (list != null) {
                            Boolean.valueOf(list.add(lynxView));
                        }
                    } else {
                        Intrinsics.checkNotNullExpressionValue(hashMap, "it");
                        hashMap.put(key, CollectionsKt.mutableListOf(new AnnieXLynxView[]{lynxView}));
                        Unit unit = Unit.INSTANCE;
                    }
                }
            } else {
                annieXLynxOptimizeService.getLynxViewCacheMap().put(bid, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(key, CollectionsKt.mutableListOf(new AnnieXLynxView[]{lynxView}))}));
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    public final void clearView(String bid, String key) {
        List<AnnieXLynxView> remove;
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (getLynxViewCacheMap()) {
            HashMap<String, List<AnnieXLynxView>> hashMap = INSTANCE.getLynxViewCacheMap().get(bid);
            remove = hashMap != null ? hashMap.remove(key) : null;
            Unit unit = Unit.INSTANCE;
        }
        if (remove != null) {
            Iterator<T> it = remove.iterator();
            while (it.hasNext()) {
                ((AnnieXLynxView) it.next()).destroy();
            }
            remove.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LynxAsyncManager<AnnieXLynxAsyncLayoutContainer> getLynxAsyncManager() {
        return (LynxAsyncManager) lynxAsyncManager.getValue();
    }

    public final boolean asyncLayoutView(final boolean needRender, final AnnieXLynxModel lynxModel, final AnnieXLynxView lynxView, final Function1<? super AnnieXLynxView, Unit> loadMethod, final Function2<? super AnnieXLynxView, ? super Boolean, Unit> layoutCallback, final AnnieXLynxAsyncLoadRunnableMeta loadMeta) {
        Intrinsics.checkNotNullParameter(lynxModel, "lynxModel");
        Intrinsics.checkNotNullParameter(lynxView, "lynxView");
        if (lynxView.getThreadStrategyForRendering() == ThreadStrategyForRendering.ALL_ON_UI) {
            if (loadMethod != null) {
                loadMethod.invoke(lynxView);
            } else {
                AnnieXLynxView.load$default(lynxView, lynxModel, null, null, 6, null);
            }
            if (layoutCallback != null) {
                layoutCallback.invoke(lynxView, false);
            }
            return false;
        }
        lynxView.markOptimizeFlag(2);
        final String sessionId = lynxModel.getSessionId();
        LynxAsyncManager.LynxAsyncLoadRunnable<AnnieXLynxAsyncLayoutContainer> lynxAsyncLoadRunnable = new LynxAsyncManager.LynxAsyncLoadRunnable<AnnieXLynxAsyncLayoutContainer>() { // from class: com.bytedance.android.anniex.base.service.AnnieXLynxOptimizeService$asyncLayoutView$asyncLoadRunnable$1
            public void load(AnnieXLynxAsyncLayoutContainer container) {
                Function1<AnnieXLynxView, Unit> function1 = loadMethod;
                if (function1 != null) {
                    function1.invoke(lynxView);
                } else {
                    AnnieXLynxView.load$default(lynxView, lynxModel, null, null, 6, null);
                }
            }

            protected boolean enablePreLayoutViewCache() {
                AnnieXLynxAsyncLoadRunnableMeta annieXLynxAsyncLoadRunnableMeta = loadMeta;
                if (annieXLynxAsyncLoadRunnableMeta != null) {
                    return annieXLynxAsyncLoadRunnableMeta.getEnablePreLayoutViewCache();
                }
                return true;
            }

            protected long getWaitLayoutFinishedTimeout() {
                AnnieXLynxAsyncLoadRunnableMeta annieXLynxAsyncLoadRunnableMeta = loadMeta;
                if (annieXLynxAsyncLoadRunnableMeta != null) {
                    return annieXLynxAsyncLoadRunnableMeta.getWaitLayoutFinishedTimeout();
                }
                return 0L;
            }

            protected boolean enablePreLayoutFutureCache() {
                AnnieXLynxAsyncLoadRunnableMeta annieXLynxAsyncLoadRunnableMeta = loadMeta;
                if (annieXLynxAsyncLoadRunnableMeta != null) {
                    return annieXLynxAsyncLoadRunnableMeta.getEnablePreLayoutFutureCache();
                }
                return false;
            }

            protected boolean enableUIFlush() {
                AnnieXLynxAsyncLoadRunnableMeta annieXLynxAsyncLoadRunnableMeta = loadMeta;
                if (annieXLynxAsyncLoadRunnableMeta != null) {
                    return annieXLynxAsyncLoadRunnableMeta.getEnableUIFlush();
                }
                return false;
            }
        };
        LynxAsyncManager.ILynxAsyncLayoutCallback<AnnieXLynxAsyncLayoutContainer> iLynxAsyncLayoutCallback = new LynxAsyncManager.ILynxAsyncLayoutCallback<AnnieXLynxAsyncLayoutContainer>() { // from class: com.bytedance.android.anniex.base.service.AnnieXLynxOptimizeService$asyncLayoutView$asyncLayoutCallback$1
            public void onLayoutFinish(String identify, AnnieXLynxAsyncLayoutContainer view) {
                LynxAsyncManager lynxAsyncManager2;
                if (needRender) {
                    lynxAsyncManager2 = AnnieXLynxOptimizeService.INSTANCE.getLynxAsyncManager();
                    lynxAsyncManager2.processRenderFromLayoutCache(sessionId);
                }
                Function2<AnnieXLynxView, Boolean, Unit> function2 = layoutCallback;
                if (function2 != null) {
                    function2.invoke(lynxView, true);
                }
                MonitorManager.INSTANCE.onLynxViewAsyncLayoutEnd(sessionId, true);
            }

            public void onPreLayoutError(LynxAsyncManager.AsyncCallbackCode code, LynxError error) {
                Function2<AnnieXLynxView, Boolean, Unit> function2 = layoutCallback;
                if (function2 != null) {
                    function2.invoke(lynxView, false);
                }
                MonitorManager.INSTANCE.onLynxViewAsyncLayoutEnd(sessionId, false);
            }
        };
        MonitorManager.INSTANCE.onLynxViewAsyncLayoutBegin(sessionId);
        getLynxAsyncManager().preLayout(sessionId, new AnnieXLynxAsyncLayoutContainer(lynxView), lynxAsyncLoadRunnable, iLynxAsyncLayoutCallback);
        return true;
    }

    public final boolean renderView(AnnieXLynxModel lynxModel, AnnieXLynxView lynxView) {
        Intrinsics.checkNotNullParameter(lynxModel, "lynxModel");
        Intrinsics.checkNotNullParameter(lynxView, "lynxView");
        return getLynxAsyncManager().processRenderFromLayoutCache(lynxModel.getSessionId()) != null;
    }

    public final AnnieXLynxView removeViewFromCache(AnnieXLynxModel lynxModel) {
        Intrinsics.checkNotNullParameter(lynxModel, "lynxModel");
        AnnieXLynxAsyncLayoutContainer annieXLynxAsyncLayoutContainer = (AnnieXLynxAsyncLayoutContainer) getLynxAsyncManager().removeLynxViewFromLayoutCache(lynxModel.getSessionId());
        LynxView lynxView = annieXLynxAsyncLayoutContainer != null ? annieXLynxAsyncLayoutContainer.getLynxView() : null;
        if (lynxView instanceof AnnieXLynxView) {
            return (AnnieXLynxView) lynxView;
        }
        return null;
    }

    public final AnnieXLynxView getViewFromCacheFuture(AnnieXLynxModel lynxModel) {
        Intrinsics.checkNotNullParameter(lynxModel, "lynxModel");
        AnnieXLynxAsyncLayoutContainer annieXLynxAsyncLayoutContainer = (AnnieXLynxAsyncLayoutContainer) getLynxAsyncManager().getContainerFromFuture(lynxModel.getSessionId());
        LynxView lynxView = annieXLynxAsyncLayoutContainer != null ? annieXLynxAsyncLayoutContainer.getLynxView() : null;
        if (lynxView instanceof AnnieXLynxView) {
            return (AnnieXLynxView) lynxView;
        }
        return null;
    }
}
