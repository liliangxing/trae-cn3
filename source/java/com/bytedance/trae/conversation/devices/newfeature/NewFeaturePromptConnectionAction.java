package com.bytedance.trae.conversation.devices.newfeature;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.widget.ChatMode;
import com.bytedance.trae.im.service.CliType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NewFeaturePromptConnectionPolicy.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;", "", "destinationMode", "Lcom/bytedance/trae/conversation/widget/ChatMode;", "selectedCliType", "Lcom/bytedance/trae/im/service/CliType;", "openDeviceSelection", "", "<init>", "(Lcom/bytedance/trae/conversation/widget/ChatMode;Lcom/bytedance/trae/im/service/CliType;Z)V", "getDestinationMode", "()Lcom/bytedance/trae/conversation/widget/ChatMode;", "getSelectedCliType", "()Lcom/bytedance/trae/im/service/CliType;", "getOpenDeviceSelection", "()Z", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class NewFeaturePromptConnectionAction {
    private final ChatMode destinationMode;
    private final boolean openDeviceSelection;
    private final CliType selectedCliType;

    public static /* synthetic */ NewFeaturePromptConnectionAction copy$default(NewFeaturePromptConnectionAction newFeaturePromptConnectionAction, ChatMode chatMode, CliType cliType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            chatMode = newFeaturePromptConnectionAction.destinationMode;
        }
        if ((i & 2) != 0) {
            cliType = newFeaturePromptConnectionAction.selectedCliType;
        }
        if ((i & 4) != 0) {
            z = newFeaturePromptConnectionAction.openDeviceSelection;
        }
        return newFeaturePromptConnectionAction.copy(chatMode, cliType, z);
    }

    /* renamed from: component1, reason: from getter */
    public final ChatMode getDestinationMode() {
        return this.destinationMode;
    }

    /* renamed from: component2, reason: from getter */
    public final CliType getSelectedCliType() {
        return this.selectedCliType;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getOpenDeviceSelection() {
        return this.openDeviceSelection;
    }

    public final NewFeaturePromptConnectionAction copy(ChatMode destinationMode, CliType selectedCliType, boolean openDeviceSelection) {
        Intrinsics.checkNotNullParameter(destinationMode, "destinationMode");
        Intrinsics.checkNotNullParameter(selectedCliType, "selectedCliType");
        return new NewFeaturePromptConnectionAction(destinationMode, selectedCliType, openDeviceSelection);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewFeaturePromptConnectionAction)) {
            return false;
        }
        NewFeaturePromptConnectionAction newFeaturePromptConnectionAction = (NewFeaturePromptConnectionAction) other;
        return this.destinationMode == newFeaturePromptConnectionAction.destinationMode && this.selectedCliType == newFeaturePromptConnectionAction.selectedCliType && this.openDeviceSelection == newFeaturePromptConnectionAction.openDeviceSelection;
    }

    public int hashCode() {
        return (((this.destinationMode.hashCode() * 31) + this.selectedCliType.hashCode()) * 31) + Boolean.hashCode(this.openDeviceSelection);
    }

    public String toString() {
        return "NewFeaturePromptConnectionAction(destinationMode=" + this.destinationMode + ", selectedCliType=" + this.selectedCliType + ", openDeviceSelection=" + this.openDeviceSelection + ')';
    }

    public NewFeaturePromptConnectionAction(ChatMode destinationMode, CliType selectedCliType, boolean z) {
        Intrinsics.checkNotNullParameter(destinationMode, "destinationMode");
        Intrinsics.checkNotNullParameter(selectedCliType, "selectedCliType");
        this.destinationMode = destinationMode;
        this.selectedCliType = selectedCliType;
        this.openDeviceSelection = z;
    }

    public final ChatMode getDestinationMode() {
        return this.destinationMode;
    }

    public final CliType getSelectedCliType() {
        return this.selectedCliType;
    }

    public final boolean getOpenDeviceSelection() {
        return this.openDeviceSelection;
    }
}
