package com.bytedance.trae.conversation.tracker;

import kotlin.Metadata;

/* compiled from: TraeAITracker.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/AsrDiscussAction;", "", "<init>", "()V", "DISCUSSION_BUTTON_CLICK", "", "SUBTITLE_MODE_ENABLE", "SUBTITLE_MODE_DISABLE", "END_DISCUSSION_CLICK", "EXIT_DISCUSSION_CLICK", "SUMMARY_DIRECT_EXECUTE_CLICK", "SUMMARY_ADDITIONAL_INPUT_CLICK", "SUMMARY_OTHER_OPTION_CLICK", "ATTACH_BUTTON_CLICK", "ATTACH_UPLOAD_SUCCESS", "ATTACH_UPLOAD_FAILED", "ATTACH_DISPATCH_TO_AGENT", "ATTACH_DISPATCH_REFUSED", "SUMMARY_VIEW_DETAIL_CLICK", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AsrDiscussAction {
    public static final String ATTACH_BUTTON_CLICK = "discussion_attach_button_click";
    public static final String ATTACH_DISPATCH_REFUSED = "discussion_attach_dispatch_refused";
    public static final String ATTACH_DISPATCH_TO_AGENT = "discussion_attach_dispatch_to_agent";
    public static final String ATTACH_UPLOAD_FAILED = "discussion_attach_upload_failed";
    public static final String ATTACH_UPLOAD_SUCCESS = "discussion_attach_upload_success";
    public static final String DISCUSSION_BUTTON_CLICK = "discussion_button_click";
    public static final String END_DISCUSSION_CLICK = "end_discussion_click";
    public static final String EXIT_DISCUSSION_CLICK = "exit_discussion_click";
    public static final AsrDiscussAction INSTANCE = new AsrDiscussAction();
    public static final String SUBTITLE_MODE_DISABLE = "subtitle_mode_disable";
    public static final String SUBTITLE_MODE_ENABLE = "subtitle_mode_enbale";
    public static final String SUMMARY_ADDITIONAL_INPUT_CLICK = "summary_additional_input_click";
    public static final String SUMMARY_DIRECT_EXECUTE_CLICK = "summary_direct_execute_click";
    public static final String SUMMARY_OTHER_OPTION_CLICK = "summary_other_option_click";
    public static final String SUMMARY_VIEW_DETAIL_CLICK = "summary_view_detail_click";

    private AsrDiscussAction() {
    }
}
