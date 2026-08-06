package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PureShowWidgetPresentationState.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationDecision;", "", "mode", "Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;", "widgetChanged", "", "<init>", "(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;Z)V", "getMode", "()Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;", "getWidgetChanged", "()Z", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PureShowWidgetPresentationDecision {
    private final PureShowWidgetPresentationMode mode;
    private final boolean widgetChanged;

    public static /* synthetic */ PureShowWidgetPresentationDecision copy$default(PureShowWidgetPresentationDecision pureShowWidgetPresentationDecision, PureShowWidgetPresentationMode pureShowWidgetPresentationMode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            pureShowWidgetPresentationMode = pureShowWidgetPresentationDecision.mode;
        }
        if ((i & 2) != 0) {
            z = pureShowWidgetPresentationDecision.widgetChanged;
        }
        return pureShowWidgetPresentationDecision.copy(pureShowWidgetPresentationMode, z);
    }

    /* renamed from: component1, reason: from getter */
    public final PureShowWidgetPresentationMode getMode() {
        return this.mode;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getWidgetChanged() {
        return this.widgetChanged;
    }

    public final PureShowWidgetPresentationDecision copy(PureShowWidgetPresentationMode mode, boolean widgetChanged) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        return new PureShowWidgetPresentationDecision(mode, widgetChanged);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PureShowWidgetPresentationDecision)) {
            return false;
        }
        PureShowWidgetPresentationDecision pureShowWidgetPresentationDecision = (PureShowWidgetPresentationDecision) other;
        return this.mode == pureShowWidgetPresentationDecision.mode && this.widgetChanged == pureShowWidgetPresentationDecision.widgetChanged;
    }

    public int hashCode() {
        return (this.mode.hashCode() * 31) + Boolean.hashCode(this.widgetChanged);
    }

    public String toString() {
        return "PureShowWidgetPresentationDecision(mode=" + this.mode + ", widgetChanged=" + this.widgetChanged + ')';
    }

    public PureShowWidgetPresentationDecision(PureShowWidgetPresentationMode mode, boolean z) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.mode = mode;
        this.widgetChanged = z;
    }

    public final PureShowWidgetPresentationMode getMode() {
        return this.mode;
    }

    public final boolean getWidgetChanged() {
        return this.widgetChanged;
    }
}
