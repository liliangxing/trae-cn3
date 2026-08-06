package com.github.alexzhirkevich.customqrgenerator.encoder;

import com.github.alexzhirkevich.customqrgenerator.QrData;
import com.github.alexzhirkevich.customqrgenerator.QrOptions;
import com.github.alexzhirkevich.customqrgenerator.encoder.QrCodeMatrix;
import com.github.alexzhirkevich.customqrgenerator.style.Neighbors;
import com.github.alexzhirkevich.customqrgenerator.style.QrBallShape;
import com.github.alexzhirkevich.customqrgenerator.style.QrFrameShape;
import com.github.alexzhirkevich.customqrgenerator.style.QrLogoShape;
import com.google.zxing.qrcode.encoder.QRCode;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: QrEncoder.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JB\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J#\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0014\u0010!\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrEncoder;", "", "options", "Lcom/github/alexzhirkevich/customqrgenerator/QrOptions;", "(Lcom/github/alexzhirkevich/customqrgenerator/QrOptions;)V", "elementDataOrNull", "Lcom/github/alexzhirkevich/customqrgenerator/encoder/ElementData;", "inputX", "", "inputY", "diff", "multiple", "inputSize", "ballShape", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape;", "frameShape", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrFrameShape;", "encode", "Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrRenderResult;", "contents", "Lcom/github/alexzhirkevich/customqrgenerator/QrData;", "charset", "Ljava/nio/charset/Charset;", "(Lcom/github/alexzhirkevich/customqrgenerator/QrData;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renderResult", "code", "Lcom/google/zxing/qrcode/encoder/QRCode;", "(Lcom/google/zxing/qrcode/encoder/QRCode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyLogoPadding", "", "Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrCodeMatrix;", "error", "", "applyMinimalLogoPadding", "Companion", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class QrEncoder {
    public static final int BALL_SIZE = 3;
    public static final int FRAME_SIZE = 7;
    private final QrOptions options;

    public QrEncoder(QrOptions qrOptions) {
        Intrinsics.checkNotNullParameter(qrOptions, "options");
        this.options = qrOptions;
    }

    public final Object encode(QrData qrData, Charset charset, Continuation<? super QrRenderResult> continuation) {
        return CoroutineScopeKt.coroutineScope(new QrEncoder$encode$2(qrData, this, charset, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object renderResult(QRCode qRCode, Continuation<? super QrRenderResult> continuation) {
        return CoroutineScopeKt.coroutineScope(new QrEncoder$renderResult$2(qRCode, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyLogoPadding(QrCodeMatrix qrCodeMatrix, float f) {
        float f2 = 2;
        float size = ((qrCodeMatrix.getSize() / RangesKt.coerceAtLeast(this.options.getCodeShape().getShapeSizeIncrease(), 1.0f)) * RangesKt.coerceIn(this.options.getLogo().getSize(), 0.0f, 1.0f) * (1 + RangesKt.coerceIn(this.options.getLogo().getPadding().getValue(), 0.0f, 1.0f))) + f2;
        if (!(this.options.getLogo().getShape() instanceof QrLogoShape.Default)) {
            if (MathKt.roundToInt(size) % 2 == qrCodeMatrix.getSize() % 2) {
                size -= 1.0f;
            }
        } else if (MathKt.roundToInt(size) % 2 != qrCodeMatrix.getSize() % 2) {
            size += 1.0f;
        }
        float coerceIn = RangesKt.coerceIn(size, 0.0f, qrCodeMatrix.getSize());
        float size2 = (qrCodeMatrix.getSize() - coerceIn) / 2.0f;
        if (!(this.options.getLogo().getShape() instanceof QrLogoShape.Default)) {
            size2 -= f / f2;
        }
        this.options.getLogo().getPadding().apply(qrCodeMatrix, MathKt.roundToInt(coerceIn), MathKt.roundToInt(size2), this.options.getLogo().getShape());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyMinimalLogoPadding(QrCodeMatrix qrCodeMatrix, int i) {
        if (this.options.getLogo().getPadding().getValue() >= Float.MIN_VALUE) {
            int coerceIn = RangesKt.coerceIn(MathKt.roundToInt((qrCodeMatrix.getSize() / RangesKt.coerceAtLeast(this.options.getCodeShape().getShapeSizeIncrease(), 1.0f)) * RangesKt.coerceIn(this.options.getLogo().getSize(), 0.0f, 1.0f) * (1 + RangesKt.coerceIn(this.options.getLogo().getPadding().getValue(), 0.0f, 1.0f))), 0, qrCodeMatrix.getSize());
            int size = ((qrCodeMatrix.getSize() - coerceIn) - i) / 2;
            for (int i2 = 0; i2 < coerceIn; i2++) {
                for (int i3 = 0; i3 < coerceIn; i3++) {
                    if (this.options.getLogo().getShape().invoke(i2, i3, coerceIn, Neighbors.INSTANCE.getEmpty())) {
                        try {
                            Result.Companion companion = Result.Companion;
                            qrCodeMatrix.set(size + i2, size + i3, QrCodeMatrix.PixelType.Background);
                            Result.constructor-impl(Unit.INSTANCE);
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            Result.constructor-impl(ResultKt.createFailure(th));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ElementData elementDataOrNull(final int inputX, final int inputY, final int diff, final int multiple, final int inputSize, QrBallShape ballShape, QrFrameShape frameShape) {
        ElementData elementData;
        ElementData elementData2;
        int i = inputX - diff;
        if (2 <= i && i < 5) {
            int i2 = inputY - diff;
            if (2 <= i2 && i2 < 5) {
                return new ElementData(new Function1<Integer, Integer>() { // from class: com.github.alexzhirkevich.customqrgenerator.encoder.QrEncoder$elementDataOrNull$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Integer invoke(int i3) {
                        return Integer.valueOf((((inputX - diff) - 2) * multiple) + i3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).intValue());
                    }
                }, new Function1<Integer, Integer>() { // from class: com.github.alexzhirkevich.customqrgenerator.encoder.QrEncoder$elementDataOrNull$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Integer invoke(int i3) {
                        return Integer.valueOf((((inputY - diff) - 2) * multiple) + i3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).intValue());
                    }
                }, multiple * 3, ballShape);
            }
        }
        if (i >= 0 && i < 7) {
            int i3 = inputY - diff;
            if (i3 >= 0 && i3 < 7) {
                return new ElementData(new Function1<Integer, Integer>() { // from class: com.github.alexzhirkevich.customqrgenerator.encoder.QrEncoder$elementDataOrNull$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Integer invoke(int i4) {
                        return Integer.valueOf(((inputX - diff) * multiple) + i4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).intValue());
                    }
                }, new Function1<Integer, Integer>() { // from class: com.github.alexzhirkevich.customqrgenerator.encoder.QrEncoder$elementDataOrNull$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Integer invoke(int i4) {
                        return Integer.valueOf(((inputY - diff) * multiple) + i4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).intValue());
                    }
                }, multiple * 7, frameShape);
            }
        }
        int i4 = ((inputSize - inputX) - 1) - diff;
        if (2 <= i4 && i4 < 5) {
            int i5 = inputY - diff;
            if (2 <= i5 && i5 < 5) {
                elementData2 = new ElementData(new Function1<Integer, Integer>() { // from class: com.github.alexzhirkevich.customqrgenerator.encoder.QrEncoder$elementDataOrNull$5
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Integer invoke(int i6) {
                        return Integer.valueOf(((((inputSize - inputX) - diff) - 2) * multiple) - i6);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).intValue());
                    }
                }, new Function1<Integer, Integer>() { // from class: com.github.alexzhirkevich.customqrgenerator.encoder.QrEncoder$elementDataOrNull$6
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Integer invoke(int i6) {
                        return Integer.valueOf((((inputY - 2) - diff) * multiple) + i6);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).intValue());
                    }
                }, multiple * 3, ballShape);
                return elementData2;
            }
        }
        if (i4 >= 0 && i4 < 7) {
            int i6 = inputY - diff;
            if (i6 >= 0 && i6 < 7) {
                elementData = new ElementData(new Function1<Integer, Integer>() { // from class: com.github.alexzhirkevich.customqrgenerator.encoder.QrEncoder$elementDataOrNull$7
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Integer invoke(int i7) {
                        return Integer.valueOf((((inputSize - inputX) - diff) * multiple) - i7);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).intValue());
                    }
                }, new Function1<Integer, Integer>() { // from class: com.github.alexzhirkevich.customqrgenerator.encoder.QrEncoder$elementDataOrNull$8
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Integer invoke(int i7) {
                        return Integer.valueOf(((inputY - diff) * multiple) + i7);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).intValue());
                    }
                }, multiple * 7, frameShape);
                return elementData;
            }
        }
        if (2 <= i && i < 5) {
            int i7 = ((inputSize - inputY) - 1) - diff;
            if (2 <= i7 && i7 < 5) {
                elementData2 = new ElementData(new Function1<Integer, Integer>() { // from class: com.github.alexzhirkevich.customqrgenerator.encoder.QrEncoder$elementDataOrNull$9
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Integer invoke(int i8) {
                        return Integer.valueOf((((inputX - 2) - diff) * multiple) + i8);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).intValue());
                    }
                }, new Function1<Integer, Integer>() { // from class: com.github.alexzhirkevich.customqrgenerator.encoder.QrEncoder$elementDataOrNull$10
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Integer invoke(int i8) {
                        return Integer.valueOf(((((inputSize - inputY) - 2) - diff) * multiple) - i8);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).intValue());
                    }
                }, multiple * 3, ballShape);
                return elementData2;
            }
        }
        if (i >= 0 && i < 7) {
            int i8 = ((inputSize - inputY) - 1) - diff;
            if (i8 >= 0 && i8 < 7) {
                elementData = new ElementData(new Function1<Integer, Integer>() { // from class: com.github.alexzhirkevich.customqrgenerator.encoder.QrEncoder$elementDataOrNull$11
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Integer invoke(int i9) {
                        return Integer.valueOf(((inputX - diff) * multiple) + i9);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).intValue());
                    }
                }, new Function1<Integer, Integer>() { // from class: com.github.alexzhirkevich.customqrgenerator.encoder.QrEncoder$elementDataOrNull$12
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Integer invoke(int i9) {
                        return Integer.valueOf((((inputSize - inputY) - diff) * multiple) - i9);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).intValue());
                    }
                }, multiple * 7, frameShape);
                return elementData;
            }
        }
        return null;
    }
}
