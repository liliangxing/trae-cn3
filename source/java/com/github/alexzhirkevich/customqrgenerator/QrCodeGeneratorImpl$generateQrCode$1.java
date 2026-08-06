package com.github.alexzhirkevich.customqrgenerator;

import android.graphics.Bitmap;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: QrCodeGeneratorImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.github.alexzhirkevich.customqrgenerator.QrCodeGeneratorImpl$generateQrCode$1", f = "QrCodeGeneratorImpl.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
final class QrCodeGeneratorImpl$generateQrCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Charset $charset;
    final /* synthetic */ QrData $data;
    final /* synthetic */ QrOptions $options;
    int label;
    final /* synthetic */ QrCodeGeneratorImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QrCodeGeneratorImpl$generateQrCode$1(QrCodeGeneratorImpl qrCodeGeneratorImpl, QrData qrData, QrOptions qrOptions, Charset charset, Continuation<? super QrCodeGeneratorImpl$generateQrCode$1> continuation) {
        super(2, continuation);
        this.this$0 = qrCodeGeneratorImpl;
        this.$data = qrData;
        this.$options = qrOptions;
        this.$charset = charset;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QrCodeGeneratorImpl$generateQrCode$1(this.this$0, this.$data, this.$options, this.$charset, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                QrCodeGeneratorImpl qrCodeGeneratorImpl = this.this$0;
                QrData qrData = this.$data;
                QrOptions qrOptions = this.$options;
                Charset charset = this.$charset;
                Result.Companion companion = Result.Companion;
                this.label = 1;
                obj = qrCodeGeneratorImpl.createQrCodeInternal(qrData, qrOptions, charset, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            obj2 = Result.constructor-impl((Bitmap) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj2);
        if (th2 == null) {
            return obj2;
        }
        throw new QrCodeCreationException(th2, null, 2, null);
    }
}
