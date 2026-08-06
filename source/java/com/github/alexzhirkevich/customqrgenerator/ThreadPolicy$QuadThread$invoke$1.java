package com.github.alexzhirkevich.customqrgenerator;

import com.github.alexzhirkevich.customqrgenerator.ThreadPolicy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QrCodeGenerator.kt */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.github.alexzhirkevich.customqrgenerator.ThreadPolicy$QuadThread", f = "QrCodeGenerator.kt", i = {}, l = {97, 108}, m = "invoke", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class ThreadPolicy$QuadThread$invoke$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ThreadPolicy.QuadThread this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadPolicy$QuadThread$invoke$1(ThreadPolicy.QuadThread quadThread, Continuation<? super ThreadPolicy$QuadThread$invoke$1> continuation) {
        super(continuation);
        this.this$0 = quadThread;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(0, 0, null, (Continuation) this);
    }
}
