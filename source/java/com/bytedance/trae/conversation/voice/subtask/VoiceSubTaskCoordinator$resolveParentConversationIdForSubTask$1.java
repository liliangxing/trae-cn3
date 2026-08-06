package com.bytedance.trae.conversation.voice.subtask;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VoiceSubTaskCoordinator.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator", f = "VoiceSubTaskCoordinator.kt", i = {0}, l = {2195}, m = "resolveParentConversationIdForSubTask", n = {"cfg"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoiceSubTaskCoordinator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1(VoiceSubTaskCoordinator voiceSubTaskCoordinator, Continuation<? super VoiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1> continuation) {
        super(continuation);
        this.this$0 = voiceSubTaskCoordinator;
    }

    public final Object invokeSuspend(Object obj) {
        Object resolveParentConversationIdForSubTask;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        resolveParentConversationIdForSubTask = this.this$0.resolveParentConversationIdForSubTask(null, (Continuation) this);
        return resolveParentConversationIdForSubTask;
    }
}
