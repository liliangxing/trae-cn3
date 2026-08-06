package com.bytedance.trae.conversation.chat.block.renderer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Typewriter.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.Typewriter", f = "Typewriter.kt", i = {0, 1}, l = {53, 59}, m = "loop", n = {"this", "this"}, s = {"L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class Typewriter$loop$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Typewriter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Typewriter$loop$1(Typewriter typewriter, Continuation<? super Typewriter$loop$1> continuation) {
        super(continuation);
        this.this$0 = typewriter;
    }

    public final Object invokeSuspend(Object obj) {
        Object loop;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loop = this.this$0.loop((Continuation) this);
        return loop;
    }
}
