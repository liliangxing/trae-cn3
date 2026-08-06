package com.bytedance.trae.conversation.brainstorm.model;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BrainstormSummaryEligibility.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"hasSummaryWorthyInput", "", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormSummaryEligibilityKt {
    /* JADX WARN: Removed duplicated region for block: B:36:0x009e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[LOOP:0: B:21:0x006b->B:38:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean hasSummaryWorthyInput(BrainstormUiState brainstormUiState) {
        boolean z;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(brainstormUiState, "<this>");
        List<BrainstormMessage> subtitleHistory = brainstormUiState.getSubtitleHistory();
        if (!(subtitleHistory instanceof Collection) || !subtitleHistory.isEmpty()) {
            for (BrainstormMessage brainstormMessage : subtitleHistory) {
                if (brainstormMessage.getRole() == MessageRole.User && (StringsKt.isBlank(brainstormMessage.getContent()) ^ true)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        boolean z4 = !StringsKt.isBlank(brainstormUiState.getCurrentTranscript());
        List<BrainstormAttachment> attachments = brainstormUiState.getAttachments();
        if (!(attachments instanceof Collection) || !attachments.isEmpty()) {
            for (BrainstormAttachment brainstormAttachment : attachments) {
                if (brainstormAttachment.getState() == AttachmentState.Uploaded) {
                    String uploadedRef = brainstormAttachment.getUploadedRef();
                    if (!(uploadedRef == null || StringsKt.isBlank(uploadedRef)) && brainstormAttachment.getNotifiedToBot()) {
                        z2 = true;
                        if (!z2) {
                            z3 = true;
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                }
            }
        }
        z3 = false;
        return z || z4 || z3;
    }
}
