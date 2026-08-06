package com.bytedance.trae.conversation.voice.subtask;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VoiceSubTaskCoordinator.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator", f = "VoiceSubTaskCoordinator.kt", i = {0, 0, 0, 0, 0, 1, 1, 1}, l = {2206, 2230, 2308, 2320}, m = "createSubTask", n = {"this", "cfg", "proxyConvId", "req", "queryJson", "this", "proxyConvId", "req"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceSubTaskCoordinator$createSubTask$1 extends ContinuationImpl {
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
    public VoiceSubTaskCoordinator$createSubTask$1(VoiceSubTaskCoordinator voiceSubTaskCoordinator, Continuation<? super VoiceSubTaskCoordinator$createSubTask$1> continuation) {
        super(continuation);
        this.this$0 = voiceSubTaskCoordinator;
    }

    public final Object invokeSuspend(Object obj) {
        Object createSubTask;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        createSubTask = this.this$0.createSubTask(null, null, null, (Continuation) this);
        return createSubTask;
    }
}
