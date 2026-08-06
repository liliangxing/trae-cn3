package com.bytedance.pitaya.api.bean;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PTYApplogEvent.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYApplogEvent;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", SchemaConstants.INNER_PARAM_EVENT_NAME, "", "args", "type", "Lcom/bytedance/pitaya/api/bean/PTYApplogEventType;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/pitaya/api/bean/PTYApplogEventType;)V", "getArgs", "()Ljava/lang/String;", "getEventName", "timestamp", "", "getTimestamp", "()D", "getType", "()Lcom/bytedance/pitaya/api/bean/PTYApplogEventType;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PTYApplogEvent implements ReflectionCall {
    private final String args;
    private final String eventName;
    private final double timestamp;
    private final PTYApplogEventType type;

    public static /* synthetic */ PTYApplogEvent copy$default(PTYApplogEvent pTYApplogEvent, String str, String str2, PTYApplogEventType pTYApplogEventType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pTYApplogEvent.eventName;
        }
        if ((i & 2) != 0) {
            str2 = pTYApplogEvent.args;
        }
        if ((i & 4) != 0) {
            pTYApplogEventType = pTYApplogEvent.type;
        }
        return pTYApplogEvent.copy(str, str2, pTYApplogEventType);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getArgs() {
        return this.args;
    }

    /* renamed from: component3, reason: from getter */
    public final PTYApplogEventType getType() {
        return this.type;
    }

    public final PTYApplogEvent copy(String eventName, String args, PTYApplogEventType type) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(type, "type");
        return new PTYApplogEvent(eventName, args, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PTYApplogEvent)) {
            return false;
        }
        PTYApplogEvent pTYApplogEvent = (PTYApplogEvent) other;
        return Intrinsics.areEqual(this.eventName, pTYApplogEvent.eventName) && Intrinsics.areEqual(this.args, pTYApplogEvent.args) && this.type == pTYApplogEvent.type;
    }

    public int hashCode() {
        int hashCode = this.eventName.hashCode() * 31;
        String str = this.args;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "PTYApplogEvent(eventName=" + this.eventName + ", args=" + this.args + ", type=" + this.type + ')';
    }

    public PTYApplogEvent(String eventName, String str, PTYApplogEventType type) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(type, "type");
        this.eventName = eventName;
        this.args = str;
        this.type = type;
        this.timestamp = System.currentTimeMillis() / 1000.0d;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final String getArgs() {
        return this.args;
    }

    public /* synthetic */ PTYApplogEvent(String str, String str2, PTYApplogEventType pTYApplogEventType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? PTYApplogEventType.NORMAL : pTYApplogEventType);
    }

    public final PTYApplogEventType getType() {
        return this.type;
    }

    public final double getTimestamp() {
        return this.timestamp;
    }
}
