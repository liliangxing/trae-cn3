package com.bytedance.trae.conversation.brainstorm;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrainstormViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BrainstormViewModel", f = "BrainstormViewModel.kt", i = {0}, l = {1787}, m = "resolveVoiceConversationIdForRecording", n = {"this"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormViewModel$resolveVoiceConversationIdForRecording$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BrainstormViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrainstormViewModel$resolveVoiceConversationIdForRecording$1(BrainstormViewModel brainstormViewModel, Continuation<? super BrainstormViewModel$resolveVoiceConversationIdForRecording$1> continuation) {
        super(continuation);
        this.this$0 = brainstormViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object resolveVoiceConversationIdForRecording;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        resolveVoiceConversationIdForRecording = this.this$0.resolveVoiceConversationIdForRecording((Continuation) this);
        return resolveVoiceConversationIdForRecording;
    }
}
