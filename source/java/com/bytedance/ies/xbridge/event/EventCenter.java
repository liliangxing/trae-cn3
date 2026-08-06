package com.bytedance.ies.xbridge.event;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.depend.IHostEventDepend;
import com.bytedance.ies.xbridge.event.depend.XEventRuntime;
import com.bytedance.ies.xbridge.model.collections.defaultimpl.DefaultXReadableMapImpl;
import com.bytedance.ies.xbridge.utils.JsonUtils;
import com.bytedance.ies.xbridge.utils.XLog;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.push.interfaze.ISignalReportService;
import com.bytedance.push.settings.StatisticsSettings;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EventCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\u0018\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u000fH\u0002J\u0012\u0010\u001c\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u0007J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0014H\u0007J \u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0004H\u0007J(\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u000eH\u0007J \u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u000eH\u0007J\u001c\u0010!\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000eH\u0007J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u000eH\u0007J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0004H\u0007J\u0018\u0010%\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0014H\u0007J\u001c\u0010&\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR-\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00060\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011R3\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0015\u0010\u0011¨\u0006'"}, d2 = {"Lcom/bytedance/ies/xbridge/event/EventCenter;", "", "()V", "EVENT_EFFECTIVE_DURATION", "", "eventQueue", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/ies/xbridge/event/Event;", "getEventQueue", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "eventQueue$delegate", "Lkotlin/Lazy;", "eventSubscribers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/ies/xbridge/event/Subscriber;", "getEventSubscribers", "()Ljava/util/concurrent/ConcurrentHashMap;", "eventSubscribers$delegate", "nativeSubscribers", "Lcom/bytedance/ies/xbridge/event/JsEventSubscriber;", "getNativeSubscribers", "nativeSubscribers$delegate", "compatBroadcastEvent", "", ISignalReportService.BODY_KEY_EVENT, "compatSendEvent", "subscriber", "enqueueEvent", "registerJsEventSubscriber", SchemaConstants.INNER_PARAM_EVENT_NAME, ReportConst.KEY_TIMESTAMP, "containerId", "registerSubscriber", "release", "setEventTTL", "timeInMills", "unregisterJsEventSubscriber", "unregisterSubscriber", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class EventCenter {
    public static final EventCenter INSTANCE = new EventCenter();
    private static long EVENT_EFFECTIVE_DURATION = StatisticsSettings.DEFAULT_STATS_INTERVAL;

    /* renamed from: eventQueue$delegate, reason: from kotlin metadata */
    private static final Lazy eventQueue = LazyKt.lazy(new Function0<CopyOnWriteArrayList<Event>>() { // from class: com.bytedance.ies.xbridge.event.EventCenter$eventQueue$2
        public final CopyOnWriteArrayList<Event> invoke() {
            return new CopyOnWriteArrayList<>();
        }
    });

    /* renamed from: eventSubscribers$delegate, reason: from kotlin metadata */
    private static final Lazy eventSubscribers = LazyKt.lazy(new Function0<ConcurrentHashMap<String, CopyOnWriteArrayList<Subscriber>>>() { // from class: com.bytedance.ies.xbridge.event.EventCenter$eventSubscribers$2
        public final ConcurrentHashMap<String, CopyOnWriteArrayList<Subscriber>> invoke() {
            return new ConcurrentHashMap<>();
        }
    });

    /* renamed from: nativeSubscribers$delegate, reason: from kotlin metadata */
    private static final Lazy nativeSubscribers = LazyKt.lazy(new Function0<ConcurrentHashMap<JsEventSubscriber, ConcurrentHashMap<String, Subscriber>>>() { // from class: com.bytedance.ies.xbridge.event.EventCenter$nativeSubscribers$2
        public final ConcurrentHashMap<JsEventSubscriber, ConcurrentHashMap<String, Subscriber>> invoke() {
            return new ConcurrentHashMap<>();
        }
    });

    private EventCenter() {
    }

    private final CopyOnWriteArrayList<Event> getEventQueue() {
        return (CopyOnWriteArrayList) eventQueue.getValue();
    }

    private final ConcurrentHashMap<String, CopyOnWriteArrayList<Subscriber>> getEventSubscribers() {
        return (ConcurrentHashMap) eventSubscribers.getValue();
    }

    private final ConcurrentHashMap<JsEventSubscriber, ConcurrentHashMap<String, Subscriber>> getNativeSubscribers() {
        return (ConcurrentHashMap) nativeSubscribers.getValue();
    }

    @JvmStatic
    public static final void setEventTTL(long timeInMills) {
        if (timeInMills <= 0) {
            return;
        }
        EVENT_EFFECTIVE_DURATION = timeInMills;
    }

    @JvmStatic
    public static final void registerJsEventSubscriber(String eventName, JsEventSubscriber subscriber) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        long currentTimeMillis = System.currentTimeMillis();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        registerJsEventSubscriber(eventName, subscriber, currentTimeMillis, uuid);
    }

    @JvmStatic
    public static final void registerJsEventSubscriber(String eventName, JsEventSubscriber subscriber, String containerId) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        registerJsEventSubscriber(eventName, subscriber, System.currentTimeMillis(), containerId);
    }

    @JvmStatic
    public static final void registerJsEventSubscriber(String eventName, JsEventSubscriber subscriber, long timestamp) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        registerJsEventSubscriber(eventName, subscriber, timestamp, uuid);
    }

    @JvmStatic
    public static final void registerJsEventSubscriber(String eventName, final JsEventSubscriber subscriber, long timestamp, String containerId) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        Subscriber subscriber2 = new Subscriber(containerId, timestamp, new XBridgeMethod.JsEventDelegate() { // from class: com.bytedance.ies.xbridge.event.EventCenter$registerJsEventSubscriber$internalSubscriber$1
            @Override // com.bytedance.ies.xbridge.XBridgeMethod.JsEventDelegate
            public void sendJsEvent(String eventName2, XReadableMap params) {
                Intrinsics.checkNotNullParameter(eventName2, SchemaConstants.INNER_PARAM_EVENT_NAME);
                JsEventSubscriber.this.onReceiveJsEvent(new Js2NativeEvent(eventName2, params));
            }
        }, null);
        EventCenter eventCenter = INSTANCE;
        if (eventCenter.getNativeSubscribers().get(subscriber) == null) {
            eventCenter.getNativeSubscribers().put(subscriber, new ConcurrentHashMap<>());
        }
        ConcurrentHashMap<String, Subscriber> concurrentHashMap = eventCenter.getNativeSubscribers().get(subscriber);
        if (concurrentHashMap != null) {
            concurrentHashMap.put(eventName, subscriber2);
        }
        registerSubscriber(subscriber2, eventName);
    }

    @JvmStatic
    public static final void unregisterJsEventSubscriber(String eventName, JsEventSubscriber subscriber) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        EventCenter eventCenter = INSTANCE;
        ConcurrentHashMap<String, Subscriber> concurrentHashMap = eventCenter.getNativeSubscribers().get(subscriber);
        if (concurrentHashMap != null) {
            Subscriber subscriber2 = concurrentHashMap.get(eventName);
            if (subscriber2 != null) {
                unregisterSubscriber(subscriber2, eventName);
                concurrentHashMap.remove(eventName);
            }
            if (concurrentHashMap.isEmpty()) {
                eventCenter.getNativeSubscribers().remove(subscriber);
            }
        }
    }

    @JvmStatic
    public static final void registerSubscriber(Subscriber subscriber, String eventName) {
        if (subscriber == null || eventName == null) {
            return;
        }
        EventCenter eventCenter = INSTANCE;
        CopyOnWriteArrayList<Subscriber> copyOnWriteArrayList = eventCenter.getEventSubscribers().get(eventName);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            eventCenter.getEventSubscribers().put(eventName, copyOnWriteArrayList);
        }
        if (copyOnWriteArrayList.contains(subscriber)) {
            copyOnWriteArrayList.set(copyOnWriteArrayList.indexOf(subscriber), subscriber);
        } else {
            copyOnWriteArrayList.add(subscriber);
        }
        eventCenter.getEventSubscribers().put(eventName, copyOnWriteArrayList);
        for (Event event : eventCenter.getEventQueue()) {
            if (Intrinsics.areEqual(event.getEventName(), eventName) && subscriber.getTimestamp() <= event.getTimestamp()) {
                EventCenter eventCenter2 = INSTANCE;
                Intrinsics.checkNotNullExpressionValue(event, "it");
                eventCenter2.compatSendEvent(event, subscriber);
            }
        }
    }

    @JvmStatic
    public static final void unregisterSubscriber(Subscriber subscriber, String eventName) {
        CopyOnWriteArrayList<Subscriber> copyOnWriteArrayList;
        if (subscriber == null || eventName == null || (copyOnWriteArrayList = INSTANCE.getEventSubscribers().get(eventName)) == null) {
            return;
        }
        copyOnWriteArrayList.remove(subscriber);
    }

    @JvmStatic
    public static final void enqueueEvent(Event event) {
        if ((event != null ? event.getEventName() : null) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ConcurrentSkipListSet concurrentSkipListSet = new ConcurrentSkipListSet();
        Iterator<Event> it = INSTANCE.getEventQueue().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "eventQueue.iterator()");
        while (it.hasNext()) {
            Event next = it.next();
            if (Math.abs(currentTimeMillis - next.getTimestamp()) > EVENT_EFFECTIVE_DURATION) {
                concurrentSkipListSet.add(next);
            }
        }
        Iterator it2 = concurrentSkipListSet.iterator();
        while (it2.hasNext()) {
            INSTANCE.getEventQueue().remove((Event) it2.next());
        }
        EventCenter eventCenter = INSTANCE;
        eventCenter.getEventQueue().add(event);
        eventCenter.compatBroadcastEvent(event);
        CopyOnWriteArrayList<Subscriber> copyOnWriteArrayList = eventCenter.getEventSubscribers().get(event.getEventName());
        if (copyOnWriteArrayList != null) {
            for (Subscriber subscriber : copyOnWriteArrayList) {
                EventCenter eventCenter2 = INSTANCE;
                Intrinsics.checkNotNullExpressionValue(subscriber, "it");
                eventCenter2.compatSendEvent(event, subscriber);
            }
        }
    }

    private final void compatBroadcastEvent(Event event) {
        IHostEventDepend hostEventDepend;
        IHostEventDepend hostEventDepend2;
        IHostEventDepend hostEventDepend3;
        if (event.getIsBroadcast()) {
            if (event.getMapParams() == null && event.getParams() == null) {
                XEventRuntime instance = XEventRuntime.INSTANCE.getINSTANCE();
                if (instance == null || (hostEventDepend3 = instance.getHostEventDepend()) == null) {
                    return;
                }
                hostEventDepend3.broadcastEvent(event.getEventName(), new LinkedHashMap());
                return;
            }
            if (event.getMapParams() != null) {
                XEventRuntime instance2 = XEventRuntime.INSTANCE.getINSTANCE();
                if (instance2 == null || (hostEventDepend2 = instance2.getHostEventDepend()) == null) {
                    return;
                }
                String eventName = event.getEventName();
                Map<String, ? extends Object> mapParams = event.getMapParams();
                Intrinsics.checkNotNull(mapParams);
                hostEventDepend2.broadcastEvent(eventName, mapParams);
                return;
            }
            if (event.getParams() != null) {
                Map<String, Object> map = event.getParams().toMap();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                XEventRuntime instance3 = XEventRuntime.INSTANCE.getINSTANCE();
                if (instance3 == null || (hostEventDepend = instance3.getHostEventDepend()) == null) {
                    return;
                }
                hostEventDepend.broadcastEvent(event.getEventName(), linkedHashMap);
            }
        }
    }

    private final void compatSendEvent(Event event, Subscriber subscriber) {
        if (event.getTargetContainerID() == null || Intrinsics.areEqual(event.getTargetContainerID(), subscriber.getContainerID())) {
            if (event.getMapParams() == null && event.getParams() == null) {
                XBridgeMethod.JsEventDelegate jsEventDelegate = subscriber.getJsEventDelegate();
                if (jsEventDelegate != null) {
                    jsEventDelegate.sendJsEvent(event.getEventName(), event.getParams());
                }
                IDLXBridgeMethod.JSEventDelegate idlJsEventDelegate = subscriber.getIdlJsEventDelegate();
                if (idlJsEventDelegate != null) {
                    idlJsEventDelegate.sendJSEvent(event.getEventName(), event.getMapParams());
                }
                XLog.INSTANCE.info("Publish Event:" + event.getEventName() + " no params");
                return;
            }
            if (event.getMapParams() != null) {
                XBridgeMethod.JsEventDelegate jsEventDelegate2 = subscriber.getJsEventDelegate();
                if (jsEventDelegate2 != null) {
                    String eventName = event.getEventName();
                    JsonUtils jsonUtils = JsonUtils.INSTANCE;
                    Map<String, ? extends Object> mapParams = event.getMapParams();
                    Intrinsics.checkNotNull(mapParams);
                    jsEventDelegate2.sendJsEvent(eventName, new DefaultXReadableMapImpl(jsonUtils.mapToJSON(mapParams)));
                }
                IDLXBridgeMethod.JSEventDelegate idlJsEventDelegate2 = subscriber.getIdlJsEventDelegate();
                if (idlJsEventDelegate2 != null) {
                    idlJsEventDelegate2.sendJSEvent(event.getEventName(), event.getMapParams());
                }
                XLog.INSTANCE.info("Publish Event:" + event.getEventName() + " mapParams != null");
                return;
            }
            if (event.getParams() != null) {
                XBridgeMethod.JsEventDelegate jsEventDelegate3 = subscriber.getJsEventDelegate();
                if (jsEventDelegate3 != null) {
                    jsEventDelegate3.sendJsEvent(event.getEventName(), event.getParams());
                }
                Map<String, Object> map = event.getParams().toMap();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                IDLXBridgeMethod.JSEventDelegate idlJsEventDelegate3 = subscriber.getIdlJsEventDelegate();
                if (idlJsEventDelegate3 != null) {
                    idlJsEventDelegate3.sendJSEvent(event.getEventName(), linkedHashMap);
                }
                XLog.INSTANCE.info("Publish Event:" + event.getEventName() + " params != null");
            }
        }
    }

    @JvmStatic
    public static final void release(String containerId) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        for (Map.Entry<String, CopyOnWriteArrayList<Subscriber>> entry : INSTANCE.getEventSubscribers().entrySet()) {
            for (Subscriber subscriber : entry.getValue()) {
                if (Intrinsics.areEqual(subscriber.getContainerID(), containerId)) {
                    entry.getValue().remove(subscriber);
                }
            }
        }
    }
}
