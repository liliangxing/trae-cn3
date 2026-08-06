package com.bytedance.trae.conversation.tracker;

import com.bytedance.forest.model.PreloadConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceEvents.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/DeviceEvent;", "", "name", "", "params", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getName", "()Ljava/lang/String;", "getParams", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DeviceEvent {
    private final String name;
    private final Map<String, Object> params;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeviceEvent copy$default(DeviceEvent deviceEvent, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceEvent.name;
        }
        if ((i & 2) != 0) {
            map = deviceEvent.params;
        }
        return deviceEvent.copy(str, map);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Map<String, Object> component2() {
        return this.params;
    }

    public final DeviceEvent copy(String name, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(params, "params");
        return new DeviceEvent(name, params);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceEvent)) {
            return false;
        }
        DeviceEvent deviceEvent = (DeviceEvent) other;
        return Intrinsics.areEqual(this.name, deviceEvent.name) && Intrinsics.areEqual(this.params, deviceEvent.params);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.params.hashCode();
    }

    public String toString() {
        return "DeviceEvent(name=" + this.name + ", params=" + this.params + ')';
    }

    public DeviceEvent(String name, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(params, "params");
        this.name = name;
        this.params = params;
    }

    public final String getName() {
        return this.name;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }
}
