package com.bytedance.trae.conversation.voice.subtask;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VoiceSubTaskCoordinator.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator", f = "VoiceSubTaskCoordinator.kt", i = {0, 0, 0, 0, 0, 0}, l = {1117, 1133}, m = "cancelClientProxyTaskForReuse", n = {"this", "localTaskId", "sourceTaskId", "reason", "waiter", "waitRemoteTerminalMs"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoiceSubTaskCoordinator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1(VoiceSubTaskCoordinator voiceSubTaskCoordinator, Continuation<? super VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1> continuation) {
        super(continuation);
        this.this$0 = voiceSubTaskCoordinator;
    }

    public final Object invokeSuspend(Object obj) {
        Object cancelClientProxyTaskForReuse;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        cancelClientProxyTaskForReuse = this.this$0.cancelClientProxyTaskForReuse(null, null, null, null, 0L, (Continuation) this);
        return cancelClientProxyTaskForReuse;
    }
}
