package com.github.alexzhirkevich.customqrgenerator;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QrCodeGeneratorImpl.kt */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.github.alexzhirkevich.customqrgenerator.QrCodeGeneratorImpl", f = "QrCodeGeneratorImpl.kt", i = {0, 0}, l = {46, 54}, m = "createQrCodeInternal", n = {"this", "options"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class QrCodeGeneratorImpl$createQrCodeInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QrCodeGeneratorImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QrCodeGeneratorImpl$createQrCodeInternal$1(QrCodeGeneratorImpl qrCodeGeneratorImpl, Continuation<? super QrCodeGeneratorImpl$createQrCodeInternal$1> continuation) {
        super(continuation);
        this.this$0 = qrCodeGeneratorImpl;
    }

    public final Object invokeSuspend(Object obj) {
        Object createQrCodeInternal;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        createQrCodeInternal = this.this$0.createQrCodeInternal(null, null, null, (Continuation) this);
        return createQrCodeInternal;
    }
}
