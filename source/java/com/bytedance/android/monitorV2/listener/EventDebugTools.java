package com.bytedance.android.monitorV2.listener;

import com.bytedance.android.monitorV2.ValidationReport;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EventDebugTools.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/monitorV2/listener/EventDebugTools;", "Lcom/bytedance/android/monitorV2/listener/IHybridEventListener;", "()V", "onEventCreated", "", "event", "Lcom/bytedance/android/monitorV2/event/HybridEvent;", "onEventSampled", "onEventTerminated", "onEventUpdated", "onEventUploaded", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class EventDebugTools implements IHybridEventListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "EventDebugTools";

    /* compiled from: EventDebugTools.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/monitorV2/listener/EventDebugTools$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return EventDebugTools.TAG;
        }
    }

    @Override // com.bytedance.android.monitorV2.listener.IHybridEventListener
    public void onEventCreated(HybridEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ValidationReport.INSTANCE.validationReportForEvent(event);
        MonitorLog.m26d(TAG, event.getEventId() + " - " + event.getEventType() + " onEventCreate");
    }

    @Override // com.bytedance.android.monitorV2.listener.IHybridEventListener
    public void onEventTerminated(HybridEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ValidationReport.INSTANCE.validationReportForEvent(event);
        MonitorLog.m26d(TAG, event.getEventId() + " - " + event.getEventType() + " onEventTerminated eventPhase: + " + event.getState().getEventPhase());
    }

    @Override // com.bytedance.android.monitorV2.listener.IHybridEventListener
    public void onEventSampled(HybridEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ValidationReport.INSTANCE.validationReportForEvent(event);
        MonitorLog.m26d(TAG, event.getEventId() + " - " + event.getEventType() + " onEventSampled");
    }

    @Override // com.bytedance.android.monitorV2.listener.IHybridEventListener
    public void onEventUploaded(HybridEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ValidationReport.INSTANCE.validationReportForEvent(event);
        MonitorLog.m26d(TAG, event.getEventId() + " - " + event.getEventType() + " onEventUploaded");
    }

    @Override // com.bytedance.android.monitorV2.listener.IHybridEventListener
    public void onEventUpdated(HybridEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        MonitorLog.m26d(TAG, event.getEventId() + " - " + event.getEventType() + " onEventUpdated");
    }
}
