package com.bytedance.ies.xbridge.event;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EventManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/xbridge/event/AppEvent;", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "isActive", "", "active", "", "unActive", "KeyboardStatusChange", "SystemBack", "LoginStatusChange", "AppStatusChange", "GeckoResourceUpdated", "OnHeadSetPlug", "MemoryWarning", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public enum AppEvent {
    KeyboardStatusChange("keyboardStatusChange"),
    SystemBack("systemBack"),
    LoginStatusChange("loginStatusChange"),
    AppStatusChange("appStatusChange"),
    GeckoResourceUpdated("geckoResourceUpdated"),
    OnHeadSetPlug("onHeadsetPlug"),
    MemoryWarning("memoryWarning");


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String eventName;
    private boolean isActive;

    AppEvent(String str) {
        this.eventName = str;
    }

    public final String getEventName() {
        return this.eventName;
    }

    /* compiled from: EventManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/xbridge/event/AppEvent$Companion;", "", "()V", "getByName", "Lcom/bytedance/ies/xbridge/event/AppEvent;", SchemaConstants.INNER_PARAM_EVENT_NAME, "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AppEvent getByName(String eventName) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            for (AppEvent appEvent : AppEvent.values()) {
                if (Intrinsics.areEqual(eventName, appEvent.getEventName())) {
                    return appEvent;
                }
            }
            return null;
        }
    }

    public final void active() {
        this.isActive = true;
    }

    public final void unActive() {
        this.isActive = true;
    }

    /* renamed from: isActive, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }
}
