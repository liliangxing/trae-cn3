package com.github.alexzhirkevich.customqrgenerator;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableKt;
import com.facebook.imageutils.JfifUtil;
import com.github.alexzhirkevich.customqrgenerator.encoder.QrCodeMatrix;
import com.github.alexzhirkevich.customqrgenerator.encoder.QrRenderResult;
import com.github.alexzhirkevich.customqrgenerator.encoder.Rectangle;
import com.github.alexzhirkevich.customqrgenerator.style.EmptyDrawable;
import com.github.alexzhirkevich.customqrgenerator.style.Neighbors;
import com.github.alexzhirkevich.customqrgenerator.style.QrColor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QrCodeGeneratorImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.github.alexzhirkevich.customqrgenerator.QrCodeGeneratorImpl$drawCode$2", f = "QrCodeGeneratorImpl.kt", i = {0, 0, 0, 0, 0}, l = {93}, m = "invokeSuspend", n = {"$this$coroutineScope", "$this$invokeSuspend_u24lambda_u2d4", "array", "offsetX", "offsetY"}, s = {"L$0", "L$3", "L$4", "I$0", "I$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class QrCodeGeneratorImpl$drawCode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $drawBg;
    final /* synthetic */ boolean $drawLogo;
    final /* synthetic */ QrOptions $options;
    final /* synthetic */ QrRenderResult $result;
    final /* synthetic */ Bitmap $this_drawCode;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    final /* synthetic */ QrCodeGeneratorImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QrCodeGeneratorImpl$drawCode$2(QrCodeGeneratorImpl qrCodeGeneratorImpl, QrRenderResult qrRenderResult, QrOptions qrOptions, Bitmap bitmap, boolean z, boolean z2, Continuation<? super QrCodeGeneratorImpl$drawCode$2> continuation) {
        super(2, continuation);
        this.this$0 = qrCodeGeneratorImpl;
        this.$result = qrRenderResult;
        this.$options = qrOptions;
        this.$this_drawCode = bitmap;
        this.$drawLogo = z;
        this.$drawBg = z2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> qrCodeGeneratorImpl$drawCode$2 = new QrCodeGeneratorImpl$drawCode$2(this.this$0, this.$result, this.$options, this.$this_drawCode, this.$drawLogo, this.$drawBg, continuation);
        qrCodeGeneratorImpl$drawCode$2.L$0 = obj;
        return qrCodeGeneratorImpl$drawCode$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ThreadPolicy threadPolicy;
        QrRenderResult qrRenderResult;
        int[] iArr;
        Bitmap bitmap;
        int i;
        CoroutineScope coroutineScope;
        int i2;
        QrOptions qrOptions;
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            this.this$0.getColors().clear();
            final QrRenderResult qrRenderResult2 = this.$result;
            final QrOptions qrOptions2 = this.$options;
            final Bitmap bitmap2 = this.$this_drawCode;
            final QrCodeGeneratorImpl qrCodeGeneratorImpl = this.this$0;
            boolean z2 = this.$drawLogo;
            final boolean z3 = this.$drawBg;
            Drawable drawable = qrOptions2.getBackground().getDrawable();
            if (!(!(drawable instanceof EmptyDrawable) && z3)) {
                drawable = null;
            }
            Bitmap bitmap3 = drawable != null ? DrawableKt.toBitmap(drawable, bitmap2.getWidth(), bitmap2.getHeight(), Bitmap.Config.ARGB_8888) : null;
            final int[] iArr2 = bitmap3 != null ? new int[bitmap2.getWidth() * bitmap2.getHeight()] : null;
            if (bitmap3 != null) {
                bitmap3.getPixels(iArr2, 0, bitmap2.getWidth(), 0, 0, bitmap2.getWidth(), bitmap2.getHeight());
            }
            float f = 1;
            final int roundToInt = MathKt.roundToInt(qrRenderResult2.getPaddingX() * (RangesKt.coerceIn(qrOptions2.getOffset().getX(), -1.0f, 1.0f) + f));
            final int roundToInt2 = MathKt.roundToInt(qrRenderResult2.getPaddingY() * (f + RangesKt.coerceIn(qrOptions2.getOffset().getY(), -1.0f, 1.0f)));
            final int[] iArr3 = new int[bitmap2.getWidth() * bitmap2.getHeight()];
            threadPolicy = qrCodeGeneratorImpl.threadPolicy;
            int width = bitmap2.getWidth();
            int height = bitmap2.getHeight();
            qrRenderResult = qrRenderResult2;
            Function2<IntRange, IntRange, Unit> function2 = new Function2<IntRange, IntRange, Unit>() { // from class: com.github.alexzhirkevich.customqrgenerator.QrCodeGeneratorImpl$drawCode$2$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((IntRange) obj2, (IntRange) obj3);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:111:0x0300  */
                /* JADX WARN: Removed duplicated region for block: B:141:0x04d9  */
                /* JADX WARN: Removed duplicated region for block: B:42:0x0144  */
                /* JADX WARN: Removed duplicated region for block: B:70:0x0247  */
                /* JADX WARN: Removed duplicated region for block: B:84:0x04dc A[LOOP:3: B:28:0x00b5->B:84:0x04dc, LOOP_END] */
                /* JADX WARN: Removed duplicated region for block: B:85:0x04e2 A[EDGE_INSN: B:85:0x04e2->B:86:0x04e2 BREAK  A[LOOP:3: B:28:0x00b5->B:84:0x04dc], SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke(IntRange intRange, IntRange intRange2) {
                    char c;
                    boolean z4;
                    int i4;
                    boolean z5;
                    boolean z6;
                    int first;
                    int last;
                    Intrinsics.checkNotNullParameter(intRange, "xrange");
                    Intrinsics.checkNotNullParameter(intRange2, "yrange");
                    char c2 = 0;
                    if (z3 && (first = intRange.getFirst()) <= (last = intRange.getLast())) {
                        while (true) {
                            int first2 = intRange2.getFirst();
                            int last2 = intRange2.getLast();
                            if (first2 <= last2) {
                                while (true) {
                                    int invoke = qrOptions2.getBackground().getColor().invoke(first, first2, bitmap2.getWidth(), bitmap2.getHeight());
                                    int[] iArr4 = iArr2;
                                    if (iArr4 != null) {
                                        Integer valueOf = Integer.valueOf(iArr4[(bitmap2.getWidth() * first2) + first]);
                                        if (!(((valueOf.intValue() >> 24) & JfifUtil.MARKER_FIRST_BYTE) > 0)) {
                                            valueOf = null;
                                        }
                                        if (valueOf != null) {
                                            QrOptions qrOptions3 = qrOptions2;
                                            invoke = QrUtil.INSTANCE.mixColors(valueOf.intValue(), invoke, (((r11 >> 24) & JfifUtil.MARKER_FIRST_BYTE) / 255.0f) * qrOptions3.getBackground().getAlpha());
                                        }
                                    }
                                    iArr3[(bitmap2.getWidth() * first2) + first] = invoke;
                                    if (first2 == last2) {
                                        break;
                                    } else {
                                        first2++;
                                    }
                                }
                            }
                            if (first == last) {
                                break;
                            } else {
                                first++;
                            }
                        }
                    }
                    int first3 = intRange.getFirst();
                    int last3 = intRange.getLast();
                    if (first3 > last3) {
                        return;
                    }
                    while (true) {
                        int first4 = intRange2.getFirst();
                        int last4 = intRange2.getLast();
                        if (first4 <= last4) {
                            while (true) {
                                CoroutineScopeKt.ensureActive(coroutineScope2);
                                if (first3 < (bitmap2.getWidth() - qrRenderResult2.getPaddingX()) - qrRenderResult2.getError() && qrRenderResult2.getPaddingX() <= first3) {
                                    if ((first4 < (bitmap2.getHeight() - qrRenderResult2.getPaddingY()) - qrRenderResult2.getError() && qrRenderResult2.getPaddingY() <= first4) && qrOptions2.getShapes().getHighlighting().invoke(first3 - qrRenderResult2.getPaddingX(), first4 - qrRenderResult2.getPaddingY(), bitmap2.getWidth() - (Math.min(qrRenderResult2.getPaddingX(), qrRenderResult2.getPaddingY()) * 2), Neighbors.INSTANCE.getEmpty())) {
                                        z4 = true;
                                        if (z4) {
                                            c = c2;
                                        } else {
                                            QrCodeMatrix.PixelType pixelType = qrRenderResult2.getBitMatrix().get(first3 - qrRenderResult2.getPaddingX(), first4 - qrRenderResult2.getPaddingY());
                                            int min = Math.min(first3 - qrRenderResult2.getPaddingX(), ((bitmap2.getWidth() - first3) - qrRenderResult2.getError()) - qrRenderResult2.getPaddingX());
                                            int min2 = Math.min(first4 - qrRenderResult2.getPaddingY(), ((bitmap2.getHeight() - first4) - qrRenderResult2.getError()) - qrRenderResult2.getPaddingY());
                                            boolean z7 = bitmap2.getWidth() - first3 < first3 && bitmap2.getHeight() - first4 < first4;
                                            boolean z8 = bitmap2.getHeight() - first4 < first4;
                                            boolean z9 = bitmap2.getHeight() - first3 < first3;
                                            int error = (((qrRenderResult2.getError() / 2) + first3) - qrRenderResult2.getPaddingX()) + roundToInt + (((((qrRenderResult2.getError() / 2) + first4) - qrRenderResult2.getPaddingY()) + roundToInt2) * bitmap2.getWidth());
                                            if (pixelType == QrCodeMatrix.PixelType.DarkPixel && !z7 && !(qrOptions2.getColors().getBall() instanceof QrColor.Unspecified)) {
                                                Rectangle ball = qrRenderResult2.getBall();
                                                if (min < ball.getX() + ball.getSize() && ball.getX() <= min) {
                                                    if (min2 < ball.getY() + ball.getSize() && ball.getY() <= min2) {
                                                        z6 = true;
                                                        if (z6) {
                                                            QrColor ball2 = qrOptions2.getColors().getBall();
                                                            int x = min - qrRenderResult2.getBall().getX();
                                                            QrOptions qrOptions4 = qrOptions2;
                                                            QrRenderResult qrRenderResult3 = qrRenderResult2;
                                                            if (z9 && !qrOptions4.getColors().getSymmetry()) {
                                                                x = qrRenderResult3.getBall().getSize() - x;
                                                            }
                                                            int y = min2 - qrRenderResult2.getBall().getY();
                                                            QrOptions qrOptions5 = qrOptions2;
                                                            QrRenderResult qrRenderResult4 = qrRenderResult2;
                                                            if (z8 && !qrOptions5.getColors().getSymmetry()) {
                                                                y = qrRenderResult4.getBall().getSize() - y;
                                                            }
                                                            i4 = ball2.invoke(x, y, qrRenderResult2.getBall().getSize(), qrRenderResult2.getBall().getSize());
                                                            c = 0;
                                                            iArr3[error] = i4;
                                                        }
                                                    }
                                                }
                                                z6 = false;
                                                if (z6) {
                                                }
                                            }
                                            if (pixelType == QrCodeMatrix.PixelType.DarkPixel && !z7 && !(qrOptions2.getColors().getFrame() instanceof QrColor.Unspecified)) {
                                                Rectangle frame = qrRenderResult2.getFrame();
                                                if (min < frame.getX() + frame.getSize() && frame.getX() <= min) {
                                                    if (min2 < frame.getY() + frame.getSize() && frame.getY() <= min2) {
                                                        z5 = true;
                                                        if (z5) {
                                                            QrColor frame2 = qrOptions2.getColors().getFrame();
                                                            int x2 = min - qrRenderResult2.getFrame().getX();
                                                            QrOptions qrOptions6 = qrOptions2;
                                                            QrRenderResult qrRenderResult5 = qrRenderResult2;
                                                            if (z9 && !qrOptions6.getColors().getSymmetry()) {
                                                                x2 = qrRenderResult5.getFrame().getSize() - x2;
                                                            }
                                                            int y2 = min2 - qrRenderResult2.getFrame().getY();
                                                            QrOptions qrOptions7 = qrOptions2;
                                                            QrRenderResult qrRenderResult6 = qrRenderResult2;
                                                            if (z8 && !qrOptions7.getColors().getSymmetry()) {
                                                                y2 = qrRenderResult6.getFrame().getSize() - y2;
                                                            }
                                                            i4 = frame2.invoke(x2, y2, qrRenderResult2.getFrame().getSize(), qrRenderResult2.getFrame().getSize());
                                                            c = 0;
                                                            iArr3[error] = i4;
                                                        }
                                                    }
                                                }
                                                z5 = false;
                                                if (z5) {
                                                }
                                            }
                                            if (pixelType == QrCodeMatrix.PixelType.DarkPixel && ((qrOptions2.getColors().getDark().invoke(first3 - qrRenderResult2.getPaddingX(), first4 - qrRenderResult2.getPaddingY(), bitmap2.getWidth() - (qrRenderResult2.getPaddingX() * 2), bitmap2.getHeight() - (qrRenderResult2.getPaddingY() * 2)) >> 24) & JfifUtil.MARKER_FIRST_BYTE) > 0) {
                                                i4 = qrCodeGeneratorImpl.getColor(qrOptions2.getColors().getDark(), first3 - qrRenderResult2.getPaddingX(), first4 - qrRenderResult2.getPaddingY(), bitmap2.getWidth() - (qrRenderResult2.getPaddingX() * 2), bitmap2.getHeight() - (qrRenderResult2.getPaddingY() * 2), qrRenderResult2.getPixelSize());
                                            } else if (pixelType == QrCodeMatrix.PixelType.LightPixel && ((qrOptions2.getColors().getLight().invoke(first3 - qrRenderResult2.getPaddingX(), first4 - qrRenderResult2.getPaddingY(), bitmap2.getWidth() - (qrRenderResult2.getPaddingX() * 2), bitmap2.getHeight() - (qrRenderResult2.getPaddingY() * 2)) >> 24) & JfifUtil.MARKER_FIRST_BYTE) > 0) {
                                                i4 = qrOptions2.getColors().getLight().invoke(first3 - qrRenderResult2.getPaddingX(), first4 - qrRenderResult2.getPaddingY(), bitmap2.getWidth() - (qrRenderResult2.getPaddingX() * 2), bitmap2.getHeight() - (qrRenderResult2.getPaddingY() * 2));
                                            } else {
                                                i4 = iArr3[error];
                                                int invoke2 = qrOptions2.getColors().getHighlighting().invoke(first3 - qrRenderResult2.getPaddingX(), first4 - qrRenderResult2.getPaddingY(), bitmap2.getWidth() - (qrRenderResult2.getPaddingX() * 2), bitmap2.getHeight() - (qrRenderResult2.getPaddingY() * 2));
                                                int i5 = (invoke2 >> 24) & JfifUtil.MARKER_FIRST_BYTE;
                                                if (i5 > 0) {
                                                    c = 0;
                                                    i4 = QrUtil.INSTANCE.mixColors(invoke2, i4, i5 / 255.0f);
                                                    iArr3[error] = i4;
                                                }
                                            }
                                            c = 0;
                                            iArr3[error] = i4;
                                        }
                                        if (first4 != last4) {
                                            break;
                                        }
                                        first4++;
                                        c2 = c;
                                    }
                                }
                                z4 = false;
                                if (z4) {
                                }
                                if (first4 != last4) {
                                }
                            }
                        } else {
                            c = c2;
                        }
                        if (first3 == last3) {
                            return;
                        }
                        first3++;
                        c2 = c;
                    }
                }
            };
            this.L$0 = coroutineScope2;
            this.L$1 = qrOptions2;
            this.L$2 = bitmap2;
            this.L$3 = qrRenderResult;
            iArr = iArr3;
            this.L$4 = iArr;
            this.Z$0 = z2;
            this.I$0 = roundToInt;
            this.I$1 = roundToInt2;
            this.label = 1;
            if (threadPolicy.invoke(width, height, function2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            bitmap = bitmap2;
            i = roundToInt2;
            coroutineScope = coroutineScope2;
            i2 = roundToInt;
            qrOptions = qrOptions2;
            z = z2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$1;
            i2 = this.I$0;
            z = this.Z$0;
            int[] iArr4 = (int[]) this.L$4;
            QrRenderResult qrRenderResult3 = (QrRenderResult) this.L$3;
            Bitmap bitmap4 = (Bitmap) this.L$2;
            qrOptions = (QrOptions) this.L$1;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            qrRenderResult = qrRenderResult3;
            iArr = iArr4;
            bitmap = bitmap4;
        }
        if (z && qrOptions.getLogo().getDrawable() != null) {
            int roundToInt3 = MathKt.roundToInt(((bitmap.getWidth() - (Math.min(qrRenderResult.getPaddingX(), qrRenderResult.getPaddingY()) * 2)) / qrOptions.getCodeShape().getShapeSizeIncrease()) * qrOptions.getLogo().getSize());
            int[] iArr5 = new int[roundToInt3 * roundToInt3];
            qrOptions.getLogo().getScale().scale(qrOptions.getLogo().getDrawable(), roundToInt3, roundToInt3).getPixels(iArr5, 0, roundToInt3, 0, 0, roundToInt3, roundToInt3);
            int width2 = (((bitmap.getWidth() - roundToInt3) / 2) - qrRenderResult.getPaddingX()) + i2;
            int height2 = (((bitmap.getHeight() - roundToInt3) / 2) - qrRenderResult.getPaddingY()) + i;
            for (int i4 = 0; i4 < roundToInt3; i4++) {
                for (int i5 = 0; i5 < roundToInt3; i5++) {
                    CoroutineScopeKt.ensureActive(coroutineScope);
                    if (qrOptions.getLogo().getShape().invoke(i4, i5, roundToInt3, Neighbors.INSTANCE.getEmpty())) {
                        int width3 = width2 + i4 + ((height2 + i5) * bitmap.getWidth());
                        int i6 = iArr5[(i5 * roundToInt3) + i4];
                        QrColor backgroundColor = qrOptions.getLogo().getBackgroundColor();
                        int invoke = backgroundColor instanceof QrColor.Unspecified ? iArr[width3] : backgroundColor.invoke(i4, i5, roundToInt3, roundToInt3);
                        try {
                            Result.Companion companion = Result.Companion;
                            iArr[width3] = QrUtil.INSTANCE.mixColors(i6, invoke, ((i6 >> 24) & JfifUtil.MARKER_FIRST_BYTE) / 255.0f);
                            Result.constructor-impl(Unit.INSTANCE);
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            Result.constructor-impl(ResultKt.createFailure(th));
                        }
                    }
                }
            }
        }
        bitmap.setPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        return Unit.INSTANCE;
    }
}
