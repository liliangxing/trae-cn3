package com.github.alexzhirkevich.customqrgenerator.encoder;

import com.github.alexzhirkevich.customqrgenerator.QrOptions;
import com.github.alexzhirkevich.customqrgenerator.encoder.QrCodeMatrix;
import com.github.alexzhirkevich.customqrgenerator.style.Neighbors;
import com.github.alexzhirkevich.customqrgenerator.style.QrBallShape;
import com.github.alexzhirkevich.customqrgenerator.style.QrFrameShape;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.QRCode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QrEncoder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrRenderResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.github.alexzhirkevich.customqrgenerator.encoder.QrEncoder$renderResult$2", f = "QrEncoder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class QrEncoder$renderResult$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super QrRenderResult>, Object> {
    final /* synthetic */ QRCode $code;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ QrEncoder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QrEncoder$renderResult$2(QRCode qRCode, QrEncoder qrEncoder, Continuation<? super QrEncoder$renderResult$2> continuation) {
        super(2, continuation);
        this.$code = qRCode;
        this.this$0 = qrEncoder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> qrEncoder$renderResult$2 = new QrEncoder$renderResult$2(this.$code, this.this$0, continuation);
        qrEncoder$renderResult$2.L$0 = obj;
        return qrEncoder$renderResult$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super QrRenderResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        QrOptions qrOptions;
        QrOptions qrOptions2;
        QrOptions qrOptions3;
        QrOptions qrOptions4;
        QrOptions qrOptions5;
        QrOptions qrOptions6;
        QrOptions qrOptions7;
        QrOptions qrOptions8;
        QrOptions qrOptions9;
        QrOptions qrOptions10;
        Pair pair;
        QrOptions qrOptions11;
        ElementData elementDataOrNull;
        QrOptions qrOptions12;
        QrOptions qrOptions13;
        QrCodeMatrix.PixelType pixelType;
        QrOptions qrOptions14;
        ElementData elementData;
        QrCodeMatrix.PixelType pixelType2;
        QrOptions qrOptions15;
        QrOptions qrOptions16;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ByteMatrix matrix = this.$code.getMatrix();
            if (matrix == null) {
                throw new IllegalStateException();
            }
            QrCodeMatrix qrMatrix = QrEncoderKt.toQrMatrix(matrix);
            qrOptions = this.this$0.options;
            QrCodeMatrix apply = qrOptions.getCodeShape().apply(qrMatrix);
            int size = (apply.getSize() - qrMatrix.getSize()) / 2;
            qrOptions2 = this.this$0.options;
            int width = qrOptions2.getWidth();
            qrOptions3 = this.this$0.options;
            int min = Math.min(width, qrOptions3.getHeight());
            qrOptions4 = this.this$0.options;
            int roundToInt = MathKt.roundToInt((min * RangesKt.coerceIn(qrOptions4.getPadding(), 0.0f, 1.0f)) / 2.0f);
            int coerceAtLeast = RangesKt.coerceAtLeast(min - (roundToInt * 2), apply.getSize());
            int size2 = coerceAtLeast / apply.getSize();
            QrCodeMatrix qrCodeMatrix = new QrCodeMatrix(coerceAtLeast);
            float f = size2;
            int roundToInt2 = MathKt.roundToInt(((coerceAtLeast / apply.getSize()) - f) * apply.getSize());
            this.this$0.applyLogoPadding(apply, MathKt.roundToInt((((r0 / apply.getSize()) - f) * apply.getSize()) / 2) / f);
            qrOptions5 = this.this$0.options;
            QrBallShape.AsPixelShape ball = qrOptions5.getShapes().getBall();
            if (!(!(ball instanceof QrBallShape.AsDarkPixels))) {
                ball = null;
            }
            if (ball == null) {
                qrOptions16 = this.this$0.options;
                ball = new QrBallShape.AsPixelShape(qrOptions16.getShapes().getDarkPixel());
            }
            QrBallShape qrBallShape = ball;
            qrOptions6 = this.this$0.options;
            QrFrameShape frame = qrOptions6.getShapes().getFrame();
            QrFrameShape.AsPixelShape asPixelShape = (frame instanceof QrFrameShape.AsDarkPixels) ^ true ? frame : null;
            if (asPixelShape == null) {
                qrOptions15 = this.this$0.options;
                asPixelShape = new QrFrameShape.AsPixelShape(qrOptions15.getShapes().getDarkPixel());
            }
            QrFrameShape qrFrameShape = asPixelShape;
            Ref.IntRef intRef = new Ref.IntRef();
            int i = 0;
            while (intRef.element < apply.getSize()) {
                Ref.IntRef intRef2 = new Ref.IntRef();
                int i2 = 0;
                while (intRef2.element < apply.getSize()) {
                    CoroutineScopeKt.ensureActive(coroutineScope);
                    Ref.IntRef intRef3 = intRef2;
                    CoroutineScope coroutineScope2 = coroutineScope;
                    Ref.IntRef intRef4 = intRef;
                    int i3 = coerceAtLeast;
                    int i4 = roundToInt2;
                    int i5 = roundToInt;
                    QrCodeMatrix qrCodeMatrix2 = qrCodeMatrix;
                    int i6 = size;
                    int i7 = size2;
                    elementDataOrNull = this.this$0.elementDataOrNull(intRef.element, intRef2.element, size, size2, apply.getSize(), qrBallShape, qrFrameShape);
                    if (elementDataOrNull != null) {
                        for (int i8 = 0; i8 < i7; i8++) {
                            int i9 = 0;
                            while (i9 < i7) {
                                try {
                                    Result.Companion companion = Result.Companion;
                                    int i10 = (intRef4.element * i7) + i8;
                                    int i11 = (intRef3.element * i7) + i9;
                                    elementData = elementDataOrNull;
                                    try {
                                        if (elementDataOrNull.getModifier().invoke(((Number) elementDataOrNull.getX().invoke(Boxing.boxInt(i8))).intValue(), ((Number) elementDataOrNull.getY().invoke(Boxing.boxInt(i9))).intValue(), elementDataOrNull.getSize(), Neighbors.INSTANCE.getEmpty())) {
                                            pixelType2 = QrCodeMatrix.PixelType.DarkPixel;
                                        } else {
                                            pixelType2 = QrCodeMatrix.PixelType.Background;
                                        }
                                        qrCodeMatrix2.set(i10, i11, pixelType2);
                                        Result.constructor-impl(Unit.INSTANCE);
                                    } catch (Throwable th) {
                                        th = th;
                                        Result.Companion companion2 = Result.Companion;
                                        Result.constructor-impl(ResultKt.createFailure(th));
                                        i9++;
                                        elementDataOrNull = elementData;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    elementData = elementDataOrNull;
                                }
                                i9++;
                                elementDataOrNull = elementData;
                            }
                        }
                    } else if (apply.get(intRef4.element, intRef3.element) != QrCodeMatrix.PixelType.Logo) {
                        Neighbors neighborsReversed = QrCodeMatrixKt.neighborsReversed(apply, intRef4.element, intRef3.element);
                        int i12 = i + i7;
                        for (int i13 = i; i13 < i12; i13++) {
                            int i14 = i2 + i7;
                            for (int i15 = i2; i15 < i14; i15++) {
                                qrOptions12 = this.this$0.options;
                                if (!qrOptions12.getCodeShape().pixelInShape(intRef4.element, intRef3.element, apply)) {
                                    pixelType = QrCodeMatrix.PixelType.Background;
                                } else {
                                    if (apply.get(intRef4.element, intRef3.element) == QrCodeMatrix.PixelType.DarkPixel) {
                                        qrOptions14 = this.this$0.options;
                                        if (qrOptions14.getShapes().getDarkPixel().invoke(i13 - i, i15 - i2, i7, neighborsReversed)) {
                                            pixelType = QrCodeMatrix.PixelType.DarkPixel;
                                        }
                                    }
                                    qrOptions13 = this.this$0.options;
                                    if (qrOptions13.getShapes().getLightPixel().invoke(i13 - i, i15 - i2, i7, neighborsReversed)) {
                                        pixelType = QrCodeMatrix.PixelType.LightPixel;
                                    } else {
                                        pixelType = QrCodeMatrix.PixelType.Background;
                                    }
                                }
                                qrCodeMatrix2.set(i13, i15, pixelType);
                            }
                        }
                    }
                    intRef3.element++;
                    i2 += i7;
                    intRef = intRef4;
                    size2 = i7;
                    intRef2 = intRef3;
                    qrCodeMatrix = qrCodeMatrix2;
                    roundToInt2 = i4;
                    coroutineScope = coroutineScope2;
                    coerceAtLeast = i3;
                    roundToInt = i5;
                    size = i6;
                }
                CoroutineScope coroutineScope3 = coroutineScope;
                intRef.element++;
                i += size2;
                coroutineScope = coroutineScope3;
                coerceAtLeast = coerceAtLeast;
                roundToInt = roundToInt;
                size = size;
            }
            int i16 = size;
            int i17 = size2;
            int i18 = roundToInt;
            int i19 = coerceAtLeast;
            int i20 = roundToInt2;
            QrCodeMatrix qrCodeMatrix3 = qrCodeMatrix;
            qrOptions7 = this.this$0.options;
            if (qrOptions7.getLogo().getPadding().getShouldApplyAccuratePadding()) {
                this.this$0.applyMinimalLogoPadding(qrCodeMatrix3, i20);
            }
            int i21 = i16 * i17;
            Rectangle rectangle = new Rectangle(i21, i21, i17 * 7);
            int i22 = i17 * 2;
            Rectangle rectangle2 = new Rectangle(rectangle.getX() + i22, rectangle.getY() + i22, i17 * 3);
            qrOptions8 = this.this$0.options;
            int width2 = qrOptions8.getWidth();
            qrOptions9 = this.this$0.options;
            if (width2 >= qrOptions9.getHeight()) {
                qrOptions10 = this.this$0.options;
                pair = TuplesKt.to(Boxing.boxInt((qrOptions10.getWidth() - i19) / 2), Boxing.boxInt(i18));
            } else {
                Integer boxInt = Boxing.boxInt(i18);
                qrOptions11 = this.this$0.options;
                pair = TuplesKt.to(boxInt, Boxing.boxInt((qrOptions11.getHeight() - i19) / 2));
            }
            return new QrRenderResult(qrCodeMatrix3, ((Number) pair.component1()).intValue(), ((Number) pair.component2()).intValue(), i17, i21, rectangle, rectangle2, i20);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
