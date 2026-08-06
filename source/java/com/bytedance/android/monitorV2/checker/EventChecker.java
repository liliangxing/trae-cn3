package com.bytedance.android.monitorV2.checker;

import com.bytedance.android.monitorV2.event.EventInfo;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.listener.IBusinessEventListener;
import com.bytedance.android.monitorV2.listener.IHybridEventListener;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.ReportDataUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EventChecker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000bR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/monitorV2/checker/EventChecker;", "", "()V", "businessEventListener", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/android/monitorV2/listener/IBusinessEventListener;", "getBusinessEventListener", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setBusinessEventListener", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "eventListenerList", "Lcom/bytedance/android/monitorV2/listener/IHybridEventListener;", "getEventListenerList", "setEventListenerList", "createEventListener", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class EventChecker {
    public static final EventChecker INSTANCE = new EventChecker();
    private static CopyOnWriteArrayList<IHybridEventListener> eventListenerList = new CopyOnWriteArrayList<>();
    private static CopyOnWriteArrayList<IBusinessEventListener> businessEventListener = new CopyOnWriteArrayList<>();

    private EventChecker() {
    }

    public final CopyOnWriteArrayList<IHybridEventListener> getEventListenerList() {
        return eventListenerList;
    }

    public final void setEventListenerList(CopyOnWriteArrayList<IHybridEventListener> copyOnWriteArrayList) {
        Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        eventListenerList = copyOnWriteArrayList;
    }

    public final CopyOnWriteArrayList<IBusinessEventListener> getBusinessEventListener() {
        return businessEventListener;
    }

    public final void setBusinessEventListener(CopyOnWriteArrayList<IBusinessEventListener> copyOnWriteArrayList) {
        Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        businessEventListener = copyOnWriteArrayList;
    }

    public final IHybridEventListener createEventListener() {
        return new IHybridEventListener() { // from class: com.bytedance.android.monitorV2.checker.EventChecker$createEventListener$1
            @Override // com.bytedance.android.monitorV2.listener.IHybridEventListener
            public void onEventCreated(HybridEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                event.getState().setEventPhase(HybridEvent.EventPhase.EVENT_CREATE);
                Iterator<IHybridEventListener> it = EventChecker.INSTANCE.getEventListenerList().iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onEventCreated(event);
                    } catch (Throwable th) {
                        ExceptionUtil.handleException(th);
                    }
                }
                Iterator<IBusinessEventListener> it2 = EventChecker.INSTANCE.getBusinessEventListener().iterator();
                while (it2.hasNext()) {
                    IBusinessEventListener next = it2.next();
                    try {
                        String eventType = event.getEventType();
                        HybridEvent.State state = event.getState();
                        String uuid = event.getEventId().toString();
                        Intrinsics.checkNotNullExpressionValue(uuid, "event.eventId.toString()");
                        next.onEventCreated(new EventInfo(eventType, state, uuid, ReportDataUtils.INSTANCE.eventToJsonObj(event)));
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.bytedance.android.monitorV2.listener.IHybridEventListener
            public void onEventTerminated(HybridEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                event.getState().setEventPhase(HybridEvent.EventPhase.EVENT_TERMINATED);
                Iterator<IHybridEventListener> it = EventChecker.INSTANCE.getEventListenerList().iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onEventTerminated(event);
                    } catch (Throwable th) {
                        ExceptionUtil.handleException(th);
                    }
                }
                Iterator<IBusinessEventListener> it2 = EventChecker.INSTANCE.getBusinessEventListener().iterator();
                while (it2.hasNext()) {
                    IBusinessEventListener next = it2.next();
                    try {
                        String eventType = event.getEventType();
                        HybridEvent.State state = event.getState();
                        String uuid = event.getEventId().toString();
                        Intrinsics.checkNotNullExpressionValue(uuid, "event.eventId.toString()");
                        next.onEventTerminated(new EventInfo(eventType, state, uuid, ReportDataUtils.INSTANCE.eventToJsonObj(event)));
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.bytedance.android.monitorV2.listener.IHybridEventListener
            public void onEventSampled(HybridEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                event.getState().setEventPhase(HybridEvent.EventPhase.SAMPLE_THROW);
                Iterator<IHybridEventListener> it = EventChecker.INSTANCE.getEventListenerList().iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onEventSampled(event);
                    } catch (Throwable th) {
                        ExceptionUtil.handleException(th);
                    }
                }
                Iterator<IBusinessEventListener> it2 = EventChecker.INSTANCE.getBusinessEventListener().iterator();
                while (it2.hasNext()) {
                    IBusinessEventListener next = it2.next();
                    try {
                        String eventType = event.getEventType();
                        HybridEvent.State state = event.getState();
                        String uuid = event.getEventId().toString();
                        Intrinsics.checkNotNullExpressionValue(uuid, "event.eventId.toString()");
                        next.onEventSampled(new EventInfo(eventType, state, uuid, ReportDataUtils.INSTANCE.eventToJsonObj(event)));
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.bytedance.android.monitorV2.listener.IHybridEventListener
            public void onEventUploaded(HybridEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                event.getState().setEventPhase(HybridEvent.EventPhase.EVENT_UPLOAD);
                Iterator<IHybridEventListener> it = EventChecker.INSTANCE.getEventListenerList().iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onEventUploaded(event);
                    } catch (Throwable th) {
                        ExceptionUtil.handleException(th);
                    }
                }
                Iterator<IBusinessEventListener> it2 = EventChecker.INSTANCE.getBusinessEventListener().iterator();
                while (it2.hasNext()) {
                    IBusinessEventListener next = it2.next();
                    try {
                        String eventType = event.getEventType();
                        HybridEvent.State state = event.getState();
                        String uuid = event.getEventId().toString();
                        Intrinsics.checkNotNullExpressionValue(uuid, "event.eventId.toString()");
                        next.onEventUploaded(new EventInfo(eventType, state, uuid, ReportDataUtils.INSTANCE.eventToJsonObj(event)));
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.bytedance.android.monitorV2.listener.IHybridEventListener
            public void onEventUpdated(HybridEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                event.getState().setEventPhase(HybridEvent.EventPhase.EVENT_UPDATED);
                Iterator<IHybridEventListener> it = EventChecker.INSTANCE.getEventListenerList().iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onEventUpdated(event);
                    } catch (Throwable th) {
                        ExceptionUtil.handleException(th);
                    }
                }
                Iterator<IBusinessEventListener> it2 = EventChecker.INSTANCE.getBusinessEventListener().iterator();
                while (it2.hasNext()) {
                    IBusinessEventListener next = it2.next();
                    try {
                        String eventType = event.getEventType();
                        HybridEvent.State state = event.getState();
                        String uuid = event.getEventId().toString();
                        Intrinsics.checkNotNullExpressionValue(uuid, "event.eventId.toString()");
                        next.onEventUpdated(new EventInfo(eventType, state, uuid, ReportDataUtils.INSTANCE.eventToJsonObj(event)));
                    } catch (Throwable unused) {
                    }
                }
            }
        };
    }
}
