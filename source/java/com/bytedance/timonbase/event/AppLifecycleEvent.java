package com.bytedance.timonbase.event;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;

/* compiled from: AppLifecycleEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/timonbase/event/AppLifecycleEvent;", "", "background", "", "(Z)V", "getBackground", "()Z", "component1", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final /* data */ class AppLifecycleEvent {
    private final boolean background;

    public static /* synthetic */ AppLifecycleEvent copy$default(AppLifecycleEvent appLifecycleEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = appLifecycleEvent.background;
        }
        return appLifecycleEvent.copy(z);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getBackground() {
        return this.background;
    }

    public final AppLifecycleEvent copy(boolean background) {
        return new AppLifecycleEvent(background);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof AppLifecycleEvent) && this.background == ((AppLifecycleEvent) other).background;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.background;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "AppLifecycleEvent(background=" + this.background + ")";
    }

    public AppLifecycleEvent(boolean z) {
        this.background = z;
    }

    public final boolean getBackground() {
        return this.background;
    }
}
