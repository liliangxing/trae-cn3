package com.bytedance.trae.conversation.brainstorm;

import com.bytedance.trae.conversation.voice.subtask.SubTaskUiState;
import com.bytedance.trae.conversation.widget.ChatMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BrainstormViewModel.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0000¨\u0006\n"}, d2 = {"shouldUseVoiceDiscussionImageUpload", "", "chatMode", "Lcom/bytedance/trae/conversation/widget/ChatMode;", "isImage", "resolveVoiceDiscussionDebugSubTaskSessionId", "", "subTask", "Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;", "fallbackProxyChatSessionId", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormViewModelKt {
    public static final boolean shouldUseVoiceDiscussionImageUpload(ChatMode chatMode, boolean z) {
        Intrinsics.checkNotNullParameter(chatMode, "chatMode");
        return chatMode == ChatMode.CODE && z;
    }

    public static final String resolveVoiceDiscussionDebugSubTaskSessionId(SubTaskUiState subTaskUiState, String str) {
        String proxyChatSessionId;
        if (subTaskUiState != null && (proxyChatSessionId = subTaskUiState.getProxyChatSessionId()) != null) {
            if (!(!StringsKt.isBlank(proxyChatSessionId))) {
                proxyChatSessionId = null;
            }
            if (proxyChatSessionId != null) {
                return proxyChatSessionId;
            }
        }
        return str == null ? "" : str;
    }
}
