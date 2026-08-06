package com.bytedance.ies.xbridge.event;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.xbridge.XReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Js2NativeEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/xbridge/event/Js2NativeEvent;", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "", "params", "Lcom/bytedance/ies/xbridge/XReadableMap;", "(Ljava/lang/String;Lcom/bytedance/ies/xbridge/XReadableMap;)V", "getEventName", "()Ljava/lang/String;", "getParams", "()Lcom/bytedance/ies/xbridge/XReadableMap;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Js2NativeEvent {
    private final String eventName;
    private final XReadableMap params;

    public static /* synthetic */ Js2NativeEvent copy$default(Js2NativeEvent js2NativeEvent, String str, XReadableMap xReadableMap, int i, Object obj) {
        if ((i & 1) != 0) {
            str = js2NativeEvent.eventName;
        }
        if ((i & 2) != 0) {
            xReadableMap = js2NativeEvent.params;
        }
        return js2NativeEvent.copy(str, xReadableMap);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    /* renamed from: component2, reason: from getter */
    public final XReadableMap getParams() {
        return this.params;
    }

    public final Js2NativeEvent copy(String eventName, XReadableMap params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        return new Js2NativeEvent(eventName, params);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Js2NativeEvent)) {
            return false;
        }
        Js2NativeEvent js2NativeEvent = (Js2NativeEvent) other;
        return Intrinsics.areEqual(this.eventName, js2NativeEvent.eventName) && Intrinsics.areEqual(this.params, js2NativeEvent.params);
    }

    public int hashCode() {
        int hashCode = this.eventName.hashCode() * 31;
        XReadableMap xReadableMap = this.params;
        return hashCode + (xReadableMap == null ? 0 : xReadableMap.hashCode());
    }

    public String toString() {
        return "Js2NativeEvent(eventName=" + this.eventName + ", params=" + this.params + ')';
    }

    public Js2NativeEvent(String eventName, XReadableMap xReadableMap) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.eventName = eventName;
        this.params = xReadableMap;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final XReadableMap getParams() {
        return this.params;
    }
}
