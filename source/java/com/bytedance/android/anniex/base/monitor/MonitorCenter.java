package com.bytedance.android.anniex.base.monitor;

import androidx.core.app.NotificationCompat;
import bolts.Task;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.monitor.MonitorCenter;
import com.bytedance.android.anniex.base.service.AnnieXMonitorService;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.scene.data.SceneDbContract;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MonitorCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0003\b\u0000\u0018\u0000 *2\u00020\u0001:\u0002*+B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0002J,\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0012`\u00132\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u001d\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u001e\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bJ<\u0010\u001f\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000eH\u0016J<\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000eH\u0002J\u001a\u0010$\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010&\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bJ\u001e\u0010'\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0)R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/android/anniex/base/monitor/MonitorCenter;", "Lcom/bytedance/android/anniex/base/monitor/IMonitorCenter;", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "sessionMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/android/anniex/base/monitor/MonitorCenter$MonitorBindData;", "dataMap2ExtraMap", "", "monitorBindData", "initDataMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", SceneDbContract.Scenes.COLUMN_TIMESTAMP, "onContainerCreate", "", "container", "Lcom/bytedance/android/anniex/base/container/IContainer;", "listener", "Lcom/bytedance/android/anniex/base/service/AnnieXMonitorService$MonitorListener;", "onContainerDestroy", "sessionId", "onEnterBackground", "onEnterForeground", "onEvent", NotificationCompat.CATEGORY_EVENT, StrategyConstants.EXTRA, "onEventInternal", "session", "onNavigateFail", "failReason", "onNavigateSuccess", "onTitleBarConstruct", "buttons", "", "Companion", "MonitorBindData", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class MonitorCenter implements IMonitorCenter {
    private static final String CONTAINER_SHOW_TIME = "container_show_time";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MonitorCenter monitorCenter = new MonitorCenter();

    /* renamed from: gson$delegate, reason: from kotlin metadata */
    private final Lazy gson = LazyKt.lazy(new Function0<Gson>() { // from class: com.bytedance.android.anniex.base.monitor.MonitorCenter$gson$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Gson m3290invoke() {
            return new Gson();
        }
    });
    private final ConcurrentHashMap<String, MonitorBindData> sessionMap = new ConcurrentHashMap<>();

    /* compiled from: MonitorCenter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/base/monitor/MonitorCenter$Companion;", "", "()V", "CONTAINER_SHOW_TIME", "", "monitorCenter", "Lcom/bytedance/android/anniex/base/monitor/MonitorCenter;", "instance", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MonitorCenter instance() {
            return MonitorCenter.monitorCenter;
        }
    }

    private MonitorCenter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Gson getGson() {
        return (Gson) this.gson.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MonitorCenter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\n\u0012\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\n¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J%\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003J%\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\nHÆ\u0003Ji\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\n2$\b\u0002\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR-\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R-\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/anniex/base/monitor/MonitorCenter$MonitorBindData;", "", "container", "Lcom/bytedance/android/anniex/base/container/IContainer;", "listener", "Lcom/bytedance/android/anniex/base/service/AnnieXMonitorService$MonitorListener;", "dataMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "extraMap", "(Lcom/bytedance/android/anniex/base/container/IContainer;Lcom/bytedance/android/anniex/base/service/AnnieXMonitorService$MonitorListener;Ljava/util/HashMap;Ljava/util/HashMap;)V", "getContainer", "()Lcom/bytedance/android/anniex/base/container/IContainer;", "getDataMap", "()Ljava/util/HashMap;", "getExtraMap", "getListener", "()Lcom/bytedance/android/anniex/base/service/AnnieXMonitorService$MonitorListener;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final /* data */ class MonitorBindData {
        private final IContainer container;
        private final HashMap<String, Long> dataMap;
        private final HashMap<String, String> extraMap;
        private final AnnieXMonitorService.MonitorListener listener;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MonitorBindData copy$default(MonitorBindData monitorBindData, IContainer iContainer, AnnieXMonitorService.MonitorListener monitorListener, HashMap hashMap, HashMap hashMap2, int i, Object obj) {
            if ((i & 1) != 0) {
                iContainer = monitorBindData.container;
            }
            if ((i & 2) != 0) {
                monitorListener = monitorBindData.listener;
            }
            if ((i & 4) != 0) {
                hashMap = monitorBindData.dataMap;
            }
            if ((i & 8) != 0) {
                hashMap2 = monitorBindData.extraMap;
            }
            return monitorBindData.copy(iContainer, monitorListener, hashMap, hashMap2);
        }

        /* renamed from: component1, reason: from getter */
        public final IContainer getContainer() {
            return this.container;
        }

        /* renamed from: component2, reason: from getter */
        public final AnnieXMonitorService.MonitorListener getListener() {
            return this.listener;
        }

        public final HashMap<String, Long> component3() {
            return this.dataMap;
        }

        public final HashMap<String, String> component4() {
            return this.extraMap;
        }

        public final MonitorBindData copy(IContainer container, AnnieXMonitorService.MonitorListener listener, HashMap<String, Long> dataMap, HashMap<String, String> extraMap) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(listener, "listener");
            Intrinsics.checkNotNullParameter(dataMap, "dataMap");
            Intrinsics.checkNotNullParameter(extraMap, "extraMap");
            return new MonitorBindData(container, listener, dataMap, extraMap);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MonitorBindData)) {
                return false;
            }
            MonitorBindData monitorBindData = (MonitorBindData) other;
            return Intrinsics.areEqual(this.container, monitorBindData.container) && Intrinsics.areEqual(this.listener, monitorBindData.listener) && Intrinsics.areEqual(this.dataMap, monitorBindData.dataMap) && Intrinsics.areEqual(this.extraMap, monitorBindData.extraMap);
        }

        public int hashCode() {
            return (((((this.container.hashCode() * 31) + this.listener.hashCode()) * 31) + this.dataMap.hashCode()) * 31) + this.extraMap.hashCode();
        }

        public String toString() {
            return "MonitorBindData(container=" + this.container + ", listener=" + this.listener + ", dataMap=" + this.dataMap + ", extraMap=" + this.extraMap + ')';
        }

        public MonitorBindData(IContainer iContainer, AnnieXMonitorService.MonitorListener monitorListener, HashMap<String, Long> hashMap, HashMap<String, String> hashMap2) {
            Intrinsics.checkNotNullParameter(iContainer, "container");
            Intrinsics.checkNotNullParameter(monitorListener, "listener");
            Intrinsics.checkNotNullParameter(hashMap, "dataMap");
            Intrinsics.checkNotNullParameter(hashMap2, "extraMap");
            this.container = iContainer;
            this.listener = monitorListener;
            this.dataMap = hashMap;
            this.extraMap = hashMap2;
        }

        public final IContainer getContainer() {
            return this.container;
        }

        public final AnnieXMonitorService.MonitorListener getListener() {
            return this.listener;
        }

        public final HashMap<String, Long> getDataMap() {
            return this.dataMap;
        }

        public final HashMap<String, String> getExtraMap() {
            return this.extraMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, Long> initDataMap(long timestamp) {
        return MapsKt.hashMapOf(new Pair[]{TuplesKt.to("enter_background_count", 0L), TuplesKt.to("last_foreground_duration", 0L), TuplesKt.to("total_duration", 0L), TuplesKt.to(CONTAINER_SHOW_TIME, Long.valueOf(timestamp))});
    }

    public final void onContainerCreate(final IContainer container, final AnnieXMonitorService.MonitorListener listener) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final long currentTimeMillis = System.currentTimeMillis();
        Task.callInBackground(new Callable() { // from class: com.bytedance.android.anniex.base.monitor.MonitorCenter$onContainerCreate$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                HashMap initDataMap;
                ConcurrentHashMap concurrentHashMap;
                String containerId = IContainer.this.getContainerId();
                IContainer iContainer = IContainer.this;
                AnnieXMonitorService.MonitorListener monitorListener = listener;
                initDataMap = this.initDataMap(currentTimeMillis);
                MonitorCenter.MonitorBindData monitorBindData = new MonitorCenter.MonitorBindData(iContainer, monitorListener, initDataMap, new HashMap());
                concurrentHashMap = this.sessionMap;
                concurrentHashMap.put(containerId, monitorBindData);
                MonitorCenter.onEventInternal$default(this, monitorBindData, MapsKt.mapOf(new Pair[]{TuplesKt.to("event_type", "event_type_container"), TuplesKt.to("container_event", "container_event_create")}), null, 4, null);
            }
        });
    }

    private final Map<String, String> dataMap2ExtraMap(MonitorBindData monitorBindData) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Long> entry : monitorBindData.getDataMap().entrySet()) {
            linkedHashMap.put(entry.getKey(), String.valueOf(entry.getValue().longValue()));
        }
        return linkedHashMap;
    }

    public final void onContainerDestroy(String sessionId) {
        MonitorBindData remove;
        if (sessionId == null || (remove = this.sessionMap.remove(sessionId)) == null) {
            return;
        }
        onEventInternal(remove, MapsKt.mapOf(new Pair[]{TuplesKt.to("event_type", "event_type_container"), TuplesKt.to("container_event", "container_event_destroy")}), dataMap2ExtraMap(remove));
    }

    public final void onTitleBarConstruct(final String sessionId, final List<String> buttons) {
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        if (sessionId == null) {
            return;
        }
        Task.callInBackground(new Callable() { // from class: com.bytedance.android.anniex.base.monitor.MonitorCenter$onTitleBarConstruct$1
            @Override // java.util.concurrent.Callable
            public final String call() {
                ConcurrentHashMap concurrentHashMap;
                HashMap<String, String> extraMap;
                Gson gson;
                concurrentHashMap = MonitorCenter.this.sessionMap;
                MonitorCenter.MonitorBindData monitorBindData = (MonitorCenter.MonitorBindData) concurrentHashMap.get(sessionId);
                if (monitorBindData == null || (extraMap = monitorBindData.getExtraMap()) == null) {
                    return null;
                }
                gson = MonitorCenter.this.getGson();
                return extraMap.put("title_bar", gson.toJson(buttons));
            }
        });
    }

    public final void onEnterBackground(final String sessionId) {
        if (sessionId == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        Task.callInBackground(new Callable() { // from class: com.bytedance.android.anniex.base.monitor.MonitorCenter$onEnterBackground$1
            @Override // java.util.concurrent.Callable
            public final Unit call() {
                ConcurrentHashMap concurrentHashMap;
                long j;
                concurrentHashMap = MonitorCenter.this.sessionMap;
                MonitorCenter.MonitorBindData monitorBindData = (MonitorCenter.MonitorBindData) concurrentHashMap.get(sessionId);
                if (monitorBindData != null) {
                    long j2 = currentTimeMillis;
                    Long l = monitorBindData.getDataMap().get("enter_background_count");
                    monitorBindData.getDataMap().put("enter_background_count", Long.valueOf(l != null ? 1 + l.longValue() : 1L));
                    Long l2 = monitorBindData.getDataMap().get("container_show_time");
                    if (l2 != null) {
                        Intrinsics.checkNotNullExpressionValue(l2, "it");
                        j = j2 - l2.longValue();
                    } else {
                        j = 0;
                    }
                    monitorBindData.getDataMap().put("last_foreground_duration", Long.valueOf(j));
                    Long l3 = monitorBindData.getDataMap().get("total_duration");
                    if (l3 != null) {
                        j += l3.longValue();
                    }
                    monitorBindData.getDataMap().put("total_duration", Long.valueOf(j));
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void onEnterForeground(final String sessionId) {
        if (sessionId == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        Task.callInBackground(new Callable() { // from class: com.bytedance.android.anniex.base.monitor.MonitorCenter$onEnterForeground$1
            @Override // java.util.concurrent.Callable
            public final Unit call() {
                ConcurrentHashMap concurrentHashMap;
                concurrentHashMap = MonitorCenter.this.sessionMap;
                MonitorCenter.MonitorBindData monitorBindData = (MonitorCenter.MonitorBindData) concurrentHashMap.get(sessionId);
                if (monitorBindData != null) {
                    monitorBindData.getDataMap().put("container_show_time", Long.valueOf(currentTimeMillis));
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void onNavigateSuccess(final String sessionId) {
        if (sessionId == null) {
            return;
        }
        Task.callInBackground(new Callable() { // from class: com.bytedance.android.anniex.base.monitor.MonitorCenter$onNavigateSuccess$1
            @Override // java.util.concurrent.Callable
            public final Unit call() {
                ConcurrentHashMap concurrentHashMap;
                concurrentHashMap = MonitorCenter.this.sessionMap;
                MonitorCenter.MonitorBindData monitorBindData = (MonitorCenter.MonitorBindData) concurrentHashMap.get(sessionId);
                if (monitorBindData != null) {
                    MonitorCenter.this.onEventInternal(monitorBindData, MapsKt.mapOf(new Pair[]{TuplesKt.to("event_type", "event_type_container"), TuplesKt.to("container_event", "container_event_navigate_success")}), monitorBindData.getExtraMap());
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void onNavigateFail(final String sessionId, final String failReason) {
        if (sessionId == null) {
            return;
        }
        Task.callInBackground(new Callable() { // from class: com.bytedance.android.anniex.base.monitor.MonitorCenter$onNavigateFail$1
            @Override // java.util.concurrent.Callable
            public final Unit call() {
                ConcurrentHashMap concurrentHashMap;
                concurrentHashMap = MonitorCenter.this.sessionMap;
                MonitorCenter.MonitorBindData monitorBindData = (MonitorCenter.MonitorBindData) concurrentHashMap.get(sessionId);
                if (monitorBindData != null) {
                    String str = failReason;
                    MonitorCenter monitorCenter2 = MonitorCenter.this;
                    if (str != null) {
                        monitorBindData.getExtraMap().put("load_fail_reason", str);
                    }
                    monitorCenter2.onEventInternal(monitorBindData, MapsKt.mapOf(new Pair[]{TuplesKt.to("event_type", "event_type_container"), TuplesKt.to("container_event", "container_event_navigate_fail")}), monitorBindData.getExtraMap());
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.bytedance.android.anniex.base.monitor.IMonitorCenter
    public void onEvent(final String sessionId, final Map<String, String> event, final Map<String, String> extra) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (sessionId == null) {
            return;
        }
        Task.callInBackground(new Callable() { // from class: com.bytedance.android.anniex.base.monitor.MonitorCenter$onEvent$1
            @Override // java.util.concurrent.Callable
            public final Unit call() {
                ConcurrentHashMap concurrentHashMap;
                concurrentHashMap = MonitorCenter.this.sessionMap;
                MonitorCenter.MonitorBindData monitorBindData = (MonitorCenter.MonitorBindData) concurrentHashMap.get(sessionId);
                if (monitorBindData != null) {
                    MonitorCenter.this.onEventInternal(monitorBindData, event, extra);
                }
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onEventInternal$default(MonitorCenter monitorCenter2, MonitorBindData monitorBindData, Map map, Map map2, int i, Object obj) {
        if ((i & 4) != 0) {
            map2 = null;
        }
        monitorCenter2.onEventInternal(monitorBindData, map, map2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onEventInternal(MonitorBindData session, Map<String, String> event, Map<String, String> extra) {
        session.getListener().onEvent(session.getContainer(), event, extra);
    }
}
