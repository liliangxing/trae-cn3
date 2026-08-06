package com.bytedance.trae.conversation.devices;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceBindingPolicy.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\u0003\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/devices/BindingGuideState;", "", "displayState", "Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;", "getDisplayState", "()Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;", "RefreshFailed", "Lcom/bytedance/trae/conversation/devices/BindingGuideState$RefreshFailed;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface BindingGuideState {
    BindingGuideStableState getDisplayState();

    /* compiled from: DeviceBindingPolicy.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/devices/BindingGuideState$RefreshFailed;", "Lcom/bytedance/trae/conversation/devices/BindingGuideState;", "displayState", "Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;", "<init>", "(Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;)V", "getDisplayState", "()Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class RefreshFailed implements BindingGuideState {
        private final BindingGuideStableState displayState;

        public static /* synthetic */ RefreshFailed copy$default(RefreshFailed refreshFailed, BindingGuideStableState bindingGuideStableState, int i, Object obj) {
            if ((i & 1) != 0) {
                bindingGuideStableState = refreshFailed.displayState;
            }
            return refreshFailed.copy(bindingGuideStableState);
        }

        /* renamed from: component1, reason: from getter */
        public final BindingGuideStableState getDisplayState() {
            return this.displayState;
        }

        public final RefreshFailed copy(BindingGuideStableState displayState) {
            Intrinsics.checkNotNullParameter(displayState, "displayState");
            return new RefreshFailed(displayState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RefreshFailed) && Intrinsics.areEqual(this.displayState, ((RefreshFailed) other).displayState);
        }

        public int hashCode() {
            return this.displayState.hashCode();
        }

        public String toString() {
            return "RefreshFailed(displayState=" + this.displayState + ')';
        }

        public RefreshFailed(BindingGuideStableState displayState) {
            Intrinsics.checkNotNullParameter(displayState, "displayState");
            this.displayState = displayState;
        }

        @Override // com.bytedance.trae.conversation.devices.BindingGuideState
        public BindingGuideStableState getDisplayState() {
            return this.displayState;
        }
    }
}
