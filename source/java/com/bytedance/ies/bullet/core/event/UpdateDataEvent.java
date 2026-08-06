package com.bytedance.ies.bullet.core.event;

import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: UpdateDataEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/core/event/UpdateDataEvent;", "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "params", "", "(Ljava/lang/Object;)V", "name", "", "getName", "()Ljava/lang/String;", "getParams", "()Ljava/lang/Object;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class UpdateDataEvent implements IEvent {
    public static final String EVENT_NAME_UPDATE_DATA = "__updateData";
    private final Object params;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UpdateDataEvent() {
        this(r0, 1, r0);
        DefaultConstructorMarker defaultConstructorMarker = null;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
    public String getName() {
        return EVENT_NAME_UPDATE_DATA;
    }

    public UpdateDataEvent(Object obj) {
        this.params = obj;
    }

    public /* synthetic */ UpdateDataEvent(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj);
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
    public Object getParams() {
        return this.params;
    }
}
