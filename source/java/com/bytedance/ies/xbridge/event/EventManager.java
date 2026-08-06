package com.bytedance.ies.xbridge.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EventManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/xbridge/event/EventManager;", "", "()V", "getEvent", "Lcom/bytedance/ies/xbridge/event/AppEvent;", "name", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class EventManager {
    public static final EventManager INSTANCE = new EventManager();

    private EventManager() {
    }

    public final AppEvent getEvent(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            return AppEvent.INSTANCE.getByName(name);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
