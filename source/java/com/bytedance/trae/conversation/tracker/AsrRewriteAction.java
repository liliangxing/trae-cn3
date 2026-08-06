package com.bytedance.trae.conversation.tracker;

import kotlin.Metadata;

/* compiled from: TraeAITracker.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/AsrRewriteAction;", "", "<init>", "()V", "REQUEST", "", "SUCCESS", "FAIL", "APPLY", "EDIT", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AsrRewriteAction {
    public static final String APPLY = "asr_rewrite_apply";
    public static final String EDIT = "asr_rewrite_edit";
    public static final String FAIL = "asr_rewrite_fail";
    public static final AsrRewriteAction INSTANCE = new AsrRewriteAction();
    public static final String REQUEST = "asr_rewrite_request";
    public static final String SUCCESS = "asr_rewrite_success";

    private AsrRewriteAction() {
    }
}
