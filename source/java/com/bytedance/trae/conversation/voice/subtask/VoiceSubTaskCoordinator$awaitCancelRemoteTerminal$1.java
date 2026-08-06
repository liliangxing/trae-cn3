package com.bytedance.trae.conversation.voice.subtask;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VoiceSubTaskCoordinator.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator", f = "VoiceSubTaskCoordinator.kt", i = {0, 0, 0, 0, 0}, l = {1173}, m = "awaitCancelRemoteTerminal", n = {"this", "localTaskId", "sourceTaskId", "waitRemoteTerminalMs", "startedAtMs"}, s = {"L$0", "L$1", "L$2", "J$0", "J$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoiceSubTaskCoordinator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1(VoiceSubTaskCoordinator voiceSubTaskCoordinator, Continuation<? super VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1> continuation) {
        super(continuation);
        this.this$0 = voiceSubTaskCoordinator;
    }

    public final Object invokeSuspend(Object obj) {
        Object awaitCancelRemoteTerminal;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        awaitCancelRemoteTerminal = this.this$0.awaitCancelRemoteTerminal(null, null, null, 0L, (Continuation) this);
        return awaitCancelRemoteTerminal;
    }
}
