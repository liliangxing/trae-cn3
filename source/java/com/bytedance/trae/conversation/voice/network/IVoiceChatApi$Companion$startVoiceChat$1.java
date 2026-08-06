package com.bytedance.trae.conversation.voice.network;

import com.bytedance.trae.conversation.voice.network.IVoiceChatApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IVoiceChatApi.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.network.IVoiceChatApi$Companion", f = "IVoiceChatApi.kt", i = {}, l = {69}, m = "startVoiceChat", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IVoiceChatApi$Companion$startVoiceChat$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IVoiceChatApi.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IVoiceChatApi$Companion$startVoiceChat$1(IVoiceChatApi.Companion companion, Continuation<? super IVoiceChatApi$Companion$startVoiceChat$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.startVoiceChat(null, null, null, false, null, null, null, null, null, (Continuation) this);
    }
}
