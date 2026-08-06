package com.bytedance.ies.xbridge.event;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.perf.monitor.ReportConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Event.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0000H\u0096\u0002J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010+\u001a\u00020\u00102\b\u0010&\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010,\u001a\u00020%HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006."}, d2 = {"Lcom/bytedance/ies/xbridge/event/Event;", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "", ReportConst.KEY_TIMESTAMP, "", "params", "Lcom/bytedance/ies/xbridge/XReadableMap;", "(Ljava/lang/String;JLcom/bytedance/ies/xbridge/XReadableMap;)V", "containerID", "getContainerID", "()Ljava/lang/String;", "setContainerID", "(Ljava/lang/String;)V", "getEventName", "isBroadcast", "", "()Z", "setBroadcast", "(Z)V", "isLocal", "setLocal", "mapParams", "", "", "getMapParams", "()Ljava/util/Map;", "setMapParams", "(Ljava/util/Map;)V", "getParams", "()Lcom/bytedance/ies/xbridge/XReadableMap;", "targetContainerID", "getTargetContainerID", "setTargetContainerID", "getTimestamp", "()J", "compareTo", "", "other", "component1", "component2", "component3", "copy", "equals", "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class Event implements Comparable<Event> {
    private String containerID;
    private final String eventName;
    private boolean isBroadcast;
    private boolean isLocal;
    private Map<String, ? extends Object> mapParams;
    private final XReadableMap params;
    private String targetContainerID;
    private final long timestamp;

    public static /* synthetic */ Event copy$default(Event event, String str, long j, XReadableMap xReadableMap, int i, Object obj) {
        if ((i & 1) != 0) {
            str = event.eventName;
        }
        if ((i & 2) != 0) {
            j = event.timestamp;
        }
        if ((i & 4) != 0) {
            xReadableMap = event.params;
        }
        return event.copy(str, j, xReadableMap);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component3, reason: from getter */
    public final XReadableMap getParams() {
        return this.params;
    }

    public final Event copy(String eventName, long timestamp, XReadableMap params) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        return new Event(eventName, timestamp, params);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Event)) {
            return false;
        }
        Event event = (Event) other;
        return Intrinsics.areEqual(this.eventName, event.eventName) && this.timestamp == event.timestamp && Intrinsics.areEqual(this.params, event.params);
    }

    public int hashCode() {
        int hashCode = ((this.eventName.hashCode() * 31) + Long.hashCode(this.timestamp)) * 31;
        XReadableMap xReadableMap = this.params;
        return hashCode + (xReadableMap == null ? 0 : xReadableMap.hashCode());
    }

    public String toString() {
        return "Event(eventName=" + this.eventName + ", timestamp=" + this.timestamp + ", params=" + this.params + ')';
    }

    public Event(String str, long j, XReadableMap xReadableMap) {
        Intrinsics.checkNotNullParameter(str, SchemaConstants.INNER_PARAM_EVENT_NAME);
        this.eventName = str;
        this.timestamp = j;
        this.params = xReadableMap;
        this.containerID = "";
    }

    public /* synthetic */ Event(String str, long j, XReadableMap xReadableMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, (i & 4) != 0 ? null : xReadableMap);
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final XReadableMap getParams() {
        return this.params;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: isLocal, reason: from getter */
    public final boolean getIsLocal() {
        return this.isLocal;
    }

    public final void setLocal(boolean z) {
        this.isLocal = z;
    }

    public final String getContainerID() {
        return this.containerID;
    }

    public final void setContainerID(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.containerID = str;
    }

    public final String getTargetContainerID() {
        return this.targetContainerID;
    }

    public final void setTargetContainerID(String str) {
        this.targetContainerID = str;
    }

    /* renamed from: isBroadcast, reason: from getter */
    public final boolean getIsBroadcast() {
        return this.isBroadcast;
    }

    public final void setBroadcast(boolean z) {
        this.isBroadcast = z;
    }

    public final Map<String, Object> getMapParams() {
        return this.mapParams;
    }

    public final void setMapParams(Map<String, ? extends Object> map) {
        this.mapParams = map;
    }

    @Override // java.lang.Comparable
    public int compareTo(Event other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this.timestamp != other.timestamp) {
            return ComparisonsKt.compareValues(Long.valueOf(this.timestamp), Long.valueOf(other.timestamp));
        }
        return -1;
    }
}
