package com.bytedance.trae.conversation.chat.block.renderer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PureShowWidgetPresentationState.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;", "", "<init>", "()V", "initialized", "", "currentWidgetId", "", "hasCompletedContent", "resolve", "Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationDecision;", "widgetId", "groupFinished", "hasRenderableCode", "reset", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PureShowWidgetPresentationState {
    private String currentWidgetId;
    private boolean hasCompletedContent;
    private boolean initialized;

    public final PureShowWidgetPresentationDecision resolve(String widgetId, boolean groupFinished, boolean hasRenderableCode) {
        PureShowWidgetPresentationMode pureShowWidgetPresentationMode;
        boolean z = (this.initialized && Intrinsics.areEqual(widgetId, this.currentWidgetId)) ? false : true;
        if (z) {
            this.initialized = true;
            this.currentWidgetId = widgetId;
            this.hasCompletedContent = false;
        }
        if (groupFinished && hasRenderableCode) {
            this.hasCompletedContent = true;
            pureShowWidgetPresentationMode = PureShowWidgetPresentationMode.SHOW_COMPLETED;
        } else if (groupFinished) {
            this.hasCompletedContent = false;
            pureShowWidgetPresentationMode = PureShowWidgetPresentationMode.SHOW_LOADING;
        } else {
            pureShowWidgetPresentationMode = this.hasCompletedContent ? PureShowWidgetPresentationMode.KEEP_COMPLETED : PureShowWidgetPresentationMode.SHOW_LOADING;
        }
        return new PureShowWidgetPresentationDecision(pureShowWidgetPresentationMode, z);
    }

    public final void reset() {
        this.initialized = false;
        this.currentWidgetId = null;
        this.hasCompletedContent = false;
    }
}
