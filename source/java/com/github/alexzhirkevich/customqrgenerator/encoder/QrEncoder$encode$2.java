package com.github.alexzhirkevich.customqrgenerator.encoder;

import com.github.alexzhirkevich.customqrgenerator.QrData;
import com.github.alexzhirkevich.customqrgenerator.QrOptions;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QrEncoder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrRenderResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.github.alexzhirkevich.customqrgenerator.encoder.QrEncoder$encode$2", f = "QrEncoder.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class QrEncoder$encode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super QrRenderResult>, Object> {
    final /* synthetic */ Charset $charset;
    final /* synthetic */ QrData $contents;
    int label;
    final /* synthetic */ QrEncoder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QrEncoder$encode$2(QrData qrData, QrEncoder qrEncoder, Charset charset, Continuation<? super QrEncoder$encode$2> continuation) {
        super(2, continuation);
        this.$contents = qrData;
        this.this$0 = qrEncoder;
        this.$charset = charset;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QrEncoder$encode$2(this.$contents, this.this$0, this.$charset, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super QrRenderResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        QrOptions qrOptions;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String encode = this.$contents.encode();
            if (encode.length() > 0) {
                qrOptions = this.this$0.options;
                ErrorCorrectionLevel lvl = qrOptions.getErrorCorrectionLevel().getLvl();
                Charset charset = this.$charset;
                QRCode encode2 = Encoder.encode(encode, lvl, charset != null ? MapsKt.mapOf(TuplesKt.to(EncodeHintType.CHARACTER_SET, charset)) : null);
                QrEncoder qrEncoder = this.this$0;
                Intrinsics.checkNotNullExpressionValue(encode2, "code");
                this.label = 1;
                obj = qrEncoder.renderResult(encode2, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw new IllegalArgumentException("Found empty contents".toString());
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
