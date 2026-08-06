package com.bytedance.android.monitorV2.event;

import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.forest.model.PreloadConfig;
import com.heytap.mcssdk.constant.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: EventInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/monitorV2/event/EventInfo;", "", "eventType", "", "state", "Lcom/bytedance/android/monitorV2/event/HybridEvent$State;", b.k, "info", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lcom/bytedance/android/monitorV2/event/HybridEvent$State;Ljava/lang/String;Lorg/json/JSONObject;)V", "getEventId", "()Ljava/lang/String;", "setEventId", "(Ljava/lang/String;)V", "getEventType", "getInfo", "()Lorg/json/JSONObject;", "getState", "()Lcom/bytedance/android/monitorV2/event/HybridEvent$State;", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class EventInfo {
    private String eventId;
    private final String eventType;
    private final JSONObject info;
    private final HybridEvent.State state;

    public static /* synthetic */ EventInfo copy$default(EventInfo eventInfo, String str, HybridEvent.State state, String str2, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            str = eventInfo.eventType;
        }
        if ((i & 2) != 0) {
            state = eventInfo.state;
        }
        if ((i & 4) != 0) {
            str2 = eventInfo.eventId;
        }
        if ((i & 8) != 0) {
            jSONObject = eventInfo.info;
        }
        return eventInfo.copy(str, state, str2, jSONObject);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEventType() {
        return this.eventType;
    }

    /* renamed from: component2, reason: from getter */
    public final HybridEvent.State getState() {
        return this.state;
    }

    /* renamed from: component3, reason: from getter */
    public final String getEventId() {
        return this.eventId;
    }

    /* renamed from: component4, reason: from getter */
    public final JSONObject getInfo() {
        return this.info;
    }

    public final EventInfo copy(String eventType, HybridEvent.State state, String eventId, JSONObject info) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(info, "info");
        return new EventInfo(eventType, state, eventId, info);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventInfo)) {
            return false;
        }
        EventInfo eventInfo = (EventInfo) other;
        return Intrinsics.areEqual(this.eventType, eventInfo.eventType) && Intrinsics.areEqual(this.state, eventInfo.state) && Intrinsics.areEqual(this.eventId, eventInfo.eventId) && Intrinsics.areEqual(this.info, eventInfo.info);
    }

    public int hashCode() {
        return (((((this.eventType.hashCode() * 31) + this.state.hashCode()) * 31) + this.eventId.hashCode()) * 31) + this.info.hashCode();
    }

    public String toString() {
        return "EventInfo(eventType=" + this.eventType + ", state=" + this.state + ", eventId=" + this.eventId + ", info=" + this.info + ')';
    }

    public EventInfo(String eventType, HybridEvent.State state, String eventId, JSONObject info) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(info, "info");
        this.eventType = eventType;
        this.state = state;
        this.eventId = eventId;
        this.info = info;
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final HybridEvent.State getState() {
        return this.state;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final void setEventId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.eventId = str;
    }

    public final JSONObject getInfo() {
        return this.info;
    }
}
