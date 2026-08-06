package com.bytedance.trae.conversation.chat.checkpoint;

import kotlin.Metadata;

/* compiled from: CheckpointInteraction.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;", "", "onDecision", "", "decision", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface CheckpointInteractionCallback {
    void onDecision(CheckpointDecision decision);
}
