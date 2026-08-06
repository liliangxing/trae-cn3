package com.bytedance.trae.conversation.tracker;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DeviceEvents.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\u0003J\u0006\u0010\n\u001a\u00020\u000bR\u001e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;", "", "initiallyConsumed", "", "<init>", "(Z)V", "value", "isConsumed", "()Z", "tryConsume", "reset", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeviceEventGate {
    private volatile boolean isConsumed;

    public DeviceEventGate() {
        this(false, 1, null);
    }

    public DeviceEventGate(boolean z) {
        this.isConsumed = z;
    }

    public /* synthetic */ DeviceEventGate(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    /* renamed from: isConsumed, reason: from getter */
    public final boolean getIsConsumed() {
        return this.isConsumed;
    }

    public final synchronized boolean tryConsume() {
        if (this.isConsumed) {
            return false;
        }
        this.isConsumed = true;
        return true;
    }

    public final synchronized void reset() {
        this.isConsumed = false;
    }
}
