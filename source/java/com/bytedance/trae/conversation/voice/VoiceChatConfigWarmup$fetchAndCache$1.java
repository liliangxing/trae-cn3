package com.bytedance.trae.conversation.voice;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VoiceChatConfigWarmup.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.VoiceChatConfigWarmup", f = "VoiceChatConfigWarmup.kt", i = {0}, l = {82}, m = "fetchAndCache", n = {"this"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceChatConfigWarmup$fetchAndCache$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoiceChatConfigWarmup this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceChatConfigWarmup$fetchAndCache$1(VoiceChatConfigWarmup voiceChatConfigWarmup, Continuation<? super VoiceChatConfigWarmup$fetchAndCache$1> continuation) {
        super(continuation);
        this.this$0 = voiceChatConfigWarmup;
    }

    public final Object invokeSuspend(Object obj) {
        Object fetchAndCache;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchAndCache = this.this$0.fetchAndCache((Continuation) this);
        return fetchAndCache;
    }
}
