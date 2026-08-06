package com.bytedance.trae.conversation.tracker;

import kotlin.Metadata;

/* compiled from: TraeAITracker.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/AsrRecogAction;", "", "<init>", "()V", "BUTTON_CLICK", "", "RECOG_START", "RECOG_END", "RECOG_KEEP", "RECOG_CANCEL", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AsrRecogAction {
    public static final String BUTTON_CLICK = "asr_button_click";
    public static final AsrRecogAction INSTANCE = new AsrRecogAction();
    public static final String RECOG_CANCEL = "asr_recog_cancel";
    public static final String RECOG_END = "asr_recog_end";
    public static final String RECOG_KEEP = "asr_recog_keep";
    public static final String RECOG_START = "asr_recog_start";

    private AsrRecogAction() {
    }
}
