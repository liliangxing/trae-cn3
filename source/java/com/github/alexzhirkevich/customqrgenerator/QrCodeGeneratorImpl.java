package com.github.alexzhirkevich.customqrgenerator;

import android.graphics.Bitmap;
import com.github.alexzhirkevich.customqrgenerator.encoder.QrEncoder;
import com.github.alexzhirkevich.customqrgenerator.encoder.QrRenderResult;
import com.github.alexzhirkevich.customqrgenerator.style.QrColor;
import com.github.alexzhirkevich.customqrgenerator.style.QrColorSeparatePixels;
import com.lynx.tasm.animation.AnimationConstant;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: QrCodeGeneratorImpl.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J+\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\"\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J+\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J9\u0010\u0016\u001a\u00020\u0017*\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ4\u0010\u001e\u001a\u00020\b*\u00020\u001f2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\bH\u0002R)\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrCodeGeneratorImpl;", "Lcom/github/alexzhirkevich/customqrgenerator/QrCodeGenerator;", "threadPolicy", "Lcom/github/alexzhirkevich/customqrgenerator/ThreadPolicy;", "(Lcom/github/alexzhirkevich/customqrgenerator/ThreadPolicy;)V", "colors", "", "Lkotlin/Pair;", "", "getColors", "()Ljava/util/Map;", "createQrCodeInternal", "Landroid/graphics/Bitmap;", "data", "Lcom/github/alexzhirkevich/customqrgenerator/QrData;", "options", "Lcom/github/alexzhirkevich/customqrgenerator/QrOptions;", "charset", "Ljava/nio/charset/Charset;", "(Lcom/github/alexzhirkevich/customqrgenerator/QrData;Lcom/github/alexzhirkevich/customqrgenerator/QrOptions;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateQrCode", "generateQrCodeSuspend", "drawCode", "", "result", "Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrRenderResult;", "drawBg", "", "drawLogo", "(Landroid/graphics/Bitmap;Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrRenderResult;Lcom/github/alexzhirkevich/customqrgenerator/QrOptions;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getColor", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "i", "j", AnimationConstant.PROP_STR_WIDTH, AnimationConstant.PROP_STR_HEIGHT, "pixelSize", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class QrCodeGeneratorImpl implements QrCodeGenerator {
    private final Map<Pair<Integer, Integer>, Integer> colors;
    private final ThreadPolicy threadPolicy;

    public QrCodeGeneratorImpl(ThreadPolicy threadPolicy) {
        Intrinsics.checkNotNullParameter(threadPolicy, "threadPolicy");
        this.threadPolicy = threadPolicy;
        this.colors = new LinkedHashMap();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.QrCodeGenerator
    public Bitmap generateQrCode(QrData data, QrOptions options, Charset charset) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(options, "options");
        return (Bitmap) BuildersKt.runBlocking$default((CoroutineContext) null, new QrCodeGeneratorImpl$generateQrCode$1(this, data, options, charset, null), 1, (Object) null);
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.QrCodeGenerator
    public Object generateQrCodeSuspend(QrData qrData, QrOptions qrOptions, Charset charset, Continuation<? super Bitmap> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new QrCodeGeneratorImpl$generateQrCodeSuspend$2(this, qrData, qrOptions, charset, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object createQrCodeInternal(QrData qrData, QrOptions qrOptions, Charset charset, Continuation<? super Bitmap> continuation) {
        QrCodeGeneratorImpl$createQrCodeInternal$1 qrCodeGeneratorImpl$createQrCodeInternal$1;
        QrCodeGeneratorImpl$createQrCodeInternal$1 qrCodeGeneratorImpl$createQrCodeInternal$12;
        Object coroutine_suspended;
        int i;
        QrErrorCorrectionLevel fit;
        QrOptions copy;
        QrOptions qrOptions2;
        QrCodeGeneratorImpl qrCodeGeneratorImpl;
        QrRenderResult qrRenderResult;
        Bitmap createBitmap;
        Bitmap bitmap;
        if (continuation instanceof QrCodeGeneratorImpl$createQrCodeInternal$1) {
            qrCodeGeneratorImpl$createQrCodeInternal$1 = (QrCodeGeneratorImpl$createQrCodeInternal$1) continuation;
            if ((qrCodeGeneratorImpl$createQrCodeInternal$1.label & Integer.MIN_VALUE) != 0) {
                qrCodeGeneratorImpl$createQrCodeInternal$1.label -= Integer.MIN_VALUE;
                qrCodeGeneratorImpl$createQrCodeInternal$12 = qrCodeGeneratorImpl$createQrCodeInternal$1;
                Object obj = qrCodeGeneratorImpl$createQrCodeInternal$12.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = qrCodeGeneratorImpl$createQrCodeInternal$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    fit = QrCodeGeneratorImplKt.fit(qrOptions.getErrorCorrectionLevel(), qrOptions.getLogo());
                    copy = qrOptions.copy((r22 & 1) != 0 ? qrOptions.width : 0, (r22 & 2) != 0 ? qrOptions.height : 0, (r22 & 4) != 0 ? qrOptions.padding : 0.0f, (r22 & 8) != 0 ? qrOptions.offset : null, (r22 & 16) != 0 ? qrOptions.colors : null, (r22 & 32) != 0 ? qrOptions.logo : null, (r22 & 64) != 0 ? qrOptions.background : null, (r22 & 128) != 0 ? qrOptions.shapes : null, (r22 & 256) != 0 ? qrOptions.codeShape : null, (r22 & 512) != 0 ? qrOptions.errorCorrectionLevel : fit);
                    QrEncoder qrEncoder = new QrEncoder(copy);
                    qrCodeGeneratorImpl$createQrCodeInternal$12.L$0 = this;
                    qrCodeGeneratorImpl$createQrCodeInternal$12.L$1 = qrOptions;
                    qrCodeGeneratorImpl$createQrCodeInternal$12.label = 1;
                    obj = qrEncoder.encode(qrData, charset, qrCodeGeneratorImpl$createQrCodeInternal$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    qrOptions2 = qrOptions;
                    qrCodeGeneratorImpl = this;
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            bitmap = (Bitmap) qrCodeGeneratorImpl$createQrCodeInternal$12.L$0;
                            ResultKt.throwOnFailure(obj);
                            Intrinsics.checkNotNullExpressionValue(bitmap, "bmp.apply {\n            …esult, options)\n        }");
                            return bitmap;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    QrOptions qrOptions3 = (QrOptions) qrCodeGeneratorImpl$createQrCodeInternal$12.L$1;
                    QrCodeGeneratorImpl qrCodeGeneratorImpl2 = (QrCodeGeneratorImpl) qrCodeGeneratorImpl$createQrCodeInternal$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    qrOptions2 = qrOptions3;
                    qrCodeGeneratorImpl = qrCodeGeneratorImpl2;
                }
                qrRenderResult = (QrRenderResult) obj;
                createBitmap = Bitmap.createBitmap(qrOptions2.getWidth(), qrOptions2.getHeight(), Bitmap.Config.ARGB_8888);
                Intrinsics.checkNotNullExpressionValue(createBitmap, "");
                qrCodeGeneratorImpl$createQrCodeInternal$12.L$0 = createBitmap;
                qrCodeGeneratorImpl$createQrCodeInternal$12.L$1 = null;
                qrCodeGeneratorImpl$createQrCodeInternal$12.label = 2;
                if (drawCode$default(qrCodeGeneratorImpl, createBitmap, qrRenderResult, qrOptions2, false, false, qrCodeGeneratorImpl$createQrCodeInternal$12, 12, null) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                bitmap = createBitmap;
                Intrinsics.checkNotNullExpressionValue(bitmap, "bmp.apply {\n            …esult, options)\n        }");
                return bitmap;
            }
        }
        qrCodeGeneratorImpl$createQrCodeInternal$1 = new QrCodeGeneratorImpl$createQrCodeInternal$1(this, continuation);
        qrCodeGeneratorImpl$createQrCodeInternal$12 = qrCodeGeneratorImpl$createQrCodeInternal$1;
        Object obj2 = qrCodeGeneratorImpl$createQrCodeInternal$12.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = qrCodeGeneratorImpl$createQrCodeInternal$12.label;
        if (i != 0) {
        }
        qrRenderResult = (QrRenderResult) obj2;
        createBitmap = Bitmap.createBitmap(qrOptions2.getWidth(), qrOptions2.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "");
        qrCodeGeneratorImpl$createQrCodeInternal$12.L$0 = createBitmap;
        qrCodeGeneratorImpl$createQrCodeInternal$12.L$1 = null;
        qrCodeGeneratorImpl$createQrCodeInternal$12.label = 2;
        if (drawCode$default(qrCodeGeneratorImpl, createBitmap, qrRenderResult, qrOptions2, false, false, qrCodeGeneratorImpl$createQrCodeInternal$12, 12, null) != coroutine_suspended) {
        }
    }

    public final Map<Pair<Integer, Integer>, Integer> getColors() {
        return this.colors;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getColor(QrColor qrColor, int i, int i2, int i3, int i4, int i5) {
        if (qrColor instanceof QrColorSeparatePixels) {
            int i6 = i / i5;
            int i7 = i2 / i5;
            Integer num = this.colors.get(TuplesKt.to(Integer.valueOf(i6), Integer.valueOf(i7)));
            if (num != null) {
                return num.intValue();
            }
            int invoke = qrColor.invoke(i6, i7, i3 / i5, i4 / i5);
            this.colors.put(TuplesKt.to(Integer.valueOf(i6), Integer.valueOf(i7)), Integer.valueOf(invoke));
            return invoke;
        }
        return qrColor.invoke(i, i2, i3, i4);
    }

    static /* synthetic */ Object drawCode$default(QrCodeGeneratorImpl qrCodeGeneratorImpl, Bitmap bitmap, QrRenderResult qrRenderResult, QrOptions qrOptions, boolean z, boolean z2, Continuation continuation, int i, Object obj) {
        return qrCodeGeneratorImpl.drawCode(bitmap, qrRenderResult, qrOptions, (i & 4) != 0 ? true : z, (i & 8) != 0 ? true : z2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object drawCode(Bitmap bitmap, QrRenderResult qrRenderResult, QrOptions qrOptions, boolean z, boolean z2, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new QrCodeGeneratorImpl$drawCode$2(this, qrRenderResult, qrOptions, bitmap, z2, z, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }
}
