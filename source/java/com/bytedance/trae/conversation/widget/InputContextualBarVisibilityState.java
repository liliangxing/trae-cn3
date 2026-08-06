package com.bytedance.trae.conversation.widget;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: InputContextualBarVisibilityState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/widget/InputContextualBarVisibilityState;", "", "requestedVisible", "", "<init>", "(Z)V", "setRequestedVisible", "", "visible", "shouldShowForDevice", "hasDevice", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InputContextualBarVisibilityState {
    private boolean requestedVisible;

    public InputContextualBarVisibilityState() {
        this(false, 1, null);
    }

    public InputContextualBarVisibilityState(boolean z) {
        this.requestedVisible = z;
    }

    public /* synthetic */ InputContextualBarVisibilityState(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    public final void setRequestedVisible(boolean visible) {
        this.requestedVisible = visible;
    }

    public final boolean shouldShowForDevice(boolean hasDevice) {
        return this.requestedVisible && hasDevice;
    }
}
