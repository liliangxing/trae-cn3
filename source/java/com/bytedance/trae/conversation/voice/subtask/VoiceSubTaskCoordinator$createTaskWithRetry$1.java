package com.bytedance.trae.conversation.voice.subtask;

import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VoiceSubTaskCoordinator.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator", f = "VoiceSubTaskCoordinator.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {2347, 2369}, m = "createTaskWithRetry", n = {"this", OauthTokenTriggerScene.REQUEST, "sourceTaskId", "retryCount", "elapsedDelayMs", "this", OauthTokenTriggerScene.REQUEST, "sourceTaskId", "retryCount", "elapsedDelayMs", AccountMonitorConstants.CommonParameter.RAW}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceSubTaskCoordinator$createTaskWithRetry$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoiceSubTaskCoordinator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceSubTaskCoordinator$createTaskWithRetry$1(VoiceSubTaskCoordinator voiceSubTaskCoordinator, Continuation<? super VoiceSubTaskCoordinator$createTaskWithRetry$1> continuation) {
        super(continuation);
        this.this$0 = voiceSubTaskCoordinator;
    }

    public final Object invokeSuspend(Object obj) {
        Object createTaskWithRetry;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        createTaskWithRetry = this.this$0.createTaskWithRetry(null, null, (Continuation) this);
        return createTaskWithRetry;
    }
}
