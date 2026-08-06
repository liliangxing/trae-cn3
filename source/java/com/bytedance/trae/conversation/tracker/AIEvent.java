package com.bytedance.trae.conversation.tracker;

import kotlin.Metadata;

/* compiled from: TraeAITracker.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/AIEvent;", "", "<init>", "()V", "TRIGGER", "", "SHOW", "COMPLETE_SHOW", "FEEDBACK_CLICK", "COPY_CLICK", "CANCELED", "RETRY_CLICK", "REVERT_CLICK", "REVERT_SUCCESS", "DELETE_CLICK", "DELETE_SUCCESS", "ASR_RECOG", "ASR_REWRITE", "ASR_DISCUSS", "REPORT_CLICK", "TASK_CREATE_RESULT", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AIEvent {
    public static final String ASR_DISCUSS = "asr_discuss_event";
    public static final String ASR_RECOG = "asr_recog_event";
    public static final String ASR_REWRITE = "asr_rewrite_event";
    public static final String CANCELED = "code_comp_canceled";
    public static final String COMPLETE_SHOW = "code_comp_complete_show";
    public static final String COPY_CLICK = "code_comp_copy_click";
    public static final String DELETE_CLICK = "code_comp_delete_click";
    public static final String DELETE_SUCCESS = "code_comp_delete_success";
    public static final String FEEDBACK_CLICK = "code_comp_feedback_click";
    public static final AIEvent INSTANCE = new AIEvent();
    public static final String REPORT_CLICK = "icube_report_click";
    public static final String RETRY_CLICK = "code_comp_retry_click";
    public static final String REVERT_CLICK = "code_comp_revert_click";
    public static final String REVERT_SUCCESS = "code_comp_revert_success";
    public static final String SHOW = "code_comp_show";
    public static final String TASK_CREATE_RESULT = "icube_task_create_result";
    public static final String TRIGGER = "code_comp_trigger";

    private AIEvent() {
    }
}
