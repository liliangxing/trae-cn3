package com.bytedance.trae.conversation.devices.flow;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceFlowConnectionSuccessPolicy.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination;", "", "ReturnToDeviceSelection", "DeferReturnToDeviceSelection", "NotifyHost", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination$DeferReturnToDeviceSelection;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination$NotifyHost;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination$ReturnToDeviceSelection;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface DeviceFlowConnectionSuccessDestination {

    /* compiled from: DeviceFlowConnectionSuccessPolicy.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination$ReturnToDeviceSelection;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination;", "selectedDeviceId", "", "<init>", "(Ljava/lang/String;)V", "getSelectedDeviceId", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class ReturnToDeviceSelection implements DeviceFlowConnectionSuccessDestination {
        private final String selectedDeviceId;

        public static /* synthetic */ ReturnToDeviceSelection copy$default(ReturnToDeviceSelection returnToDeviceSelection, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = returnToDeviceSelection.selectedDeviceId;
            }
            return returnToDeviceSelection.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getSelectedDeviceId() {
            return this.selectedDeviceId;
        }

        public final ReturnToDeviceSelection copy(String selectedDeviceId) {
            Intrinsics.checkNotNullParameter(selectedDeviceId, "selectedDeviceId");
            return new ReturnToDeviceSelection(selectedDeviceId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ReturnToDeviceSelection) && Intrinsics.areEqual(this.selectedDeviceId, ((ReturnToDeviceSelection) other).selectedDeviceId);
        }

        public int hashCode() {
            return this.selectedDeviceId.hashCode();
        }

        public String toString() {
            return "ReturnToDeviceSelection(selectedDeviceId=" + this.selectedDeviceId + ')';
        }

        public ReturnToDeviceSelection(String selectedDeviceId) {
            Intrinsics.checkNotNullParameter(selectedDeviceId, "selectedDeviceId");
            this.selectedDeviceId = selectedDeviceId;
        }

        public final String getSelectedDeviceId() {
            return this.selectedDeviceId;
        }
    }

    /* compiled from: DeviceFlowConnectionSuccessPolicy.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination$DeferReturnToDeviceSelection;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination;", "selectedDeviceId", "", "<init>", "(Ljava/lang/String;)V", "getSelectedDeviceId", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class DeferReturnToDeviceSelection implements DeviceFlowConnectionSuccessDestination {
        private final String selectedDeviceId;

        public static /* synthetic */ DeferReturnToDeviceSelection copy$default(DeferReturnToDeviceSelection deferReturnToDeviceSelection, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = deferReturnToDeviceSelection.selectedDeviceId;
            }
            return deferReturnToDeviceSelection.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getSelectedDeviceId() {
            return this.selectedDeviceId;
        }

        public final DeferReturnToDeviceSelection copy(String selectedDeviceId) {
            Intrinsics.checkNotNullParameter(selectedDeviceId, "selectedDeviceId");
            return new DeferReturnToDeviceSelection(selectedDeviceId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DeferReturnToDeviceSelection) && Intrinsics.areEqual(this.selectedDeviceId, ((DeferReturnToDeviceSelection) other).selectedDeviceId);
        }

        public int hashCode() {
            return this.selectedDeviceId.hashCode();
        }

        public String toString() {
            return "DeferReturnToDeviceSelection(selectedDeviceId=" + this.selectedDeviceId + ')';
        }

        public DeferReturnToDeviceSelection(String selectedDeviceId) {
            Intrinsics.checkNotNullParameter(selectedDeviceId, "selectedDeviceId");
            this.selectedDeviceId = selectedDeviceId;
        }

        public final String getSelectedDeviceId() {
            return this.selectedDeviceId;
        }
    }

    /* compiled from: DeviceFlowConnectionSuccessPolicy.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination$NotifyHost;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class NotifyHost implements DeviceFlowConnectionSuccessDestination {
        public static final NotifyHost INSTANCE = new NotifyHost();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NotifyHost)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1659321166;
        }

        public String toString() {
            return "NotifyHost";
        }

        private NotifyHost() {
        }
    }
}
