package com.github.alexzhirkevich.customqrgenerator.vector;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.MatrixKt;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.facebook.imageutils.JfifUtil;
import com.github.alexzhirkevich.customqrgenerator.HighlightingType;
import com.github.alexzhirkevich.customqrgenerator.QrData;
import com.github.alexzhirkevich.customqrgenerator.QrErrorCorrectionLevel;
import com.github.alexzhirkevich.customqrgenerator.encoder.QrCodeMatrix;
import com.github.alexzhirkevich.customqrgenerator.encoder.QrCodeMatrixKt;
import com.github.alexzhirkevich.customqrgenerator.encoder.QrEncoderKt;
import com.github.alexzhirkevich.customqrgenerator.style.Neighbors;
import com.github.alexzhirkevich.customqrgenerator.style.QrOffset;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorBallShape;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColorKt;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorFrameShape;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorLogoPadding;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorPixelShape;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapeModifier;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import com.lynx.tasm.animation.AnimationConstant;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QrCodeDrawable.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ \u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002J\n\u0010$\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010!\u001a\u00020\"H\u0002J\u0012\u0010)\u001a\u0004\u0018\u00010\u00112\u0006\u0010*\u001a\u00020\"H\u0002J@\u0010+\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\"2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020-H\u0002J\u0010\u00103\u001a\u00020\u001f2\u0006\u00104\u001a\u000205H\u0016J~\u00106\u001a\u00020\u001f2\u0006\u00104\u001a\u0002052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020-2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\b\u00107\u001a\u0004\u0018\u00010\u00112\u0006\u0010 \u001a\u00020\"2\u0006\u00108\u001a\u00020-2\b\u00109\u001a\u0004\u0018\u00010&2\b\u0010:\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010;\u001a\u00020\fH\u0017J\u0018\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020\fH\u0002J\u0018\u0010@\u001a\u00020=2\u0006\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020\fH\u0002J\"\u0010A\u001a\u00020=2\u0006\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020\f2\b\b\u0002\u0010B\u001a\u00020=H\u0002J\u0018\u0010C\u001a\u00020=2\u0006\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020\fH\u0002J\u0018\u0010D\u001a\u00020=2\u0006\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020\fH\u0002J\u0018\u0010E\u001a\u00020\u001f2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\fH\u0002J\u0010\u0010H\u001a\u00020\u001f2\u0006\u0010I\u001a\u00020\fH\u0016J\u0010\u0010J\u001a\u00020\u001f2\u0006\u0010K\u001a\u00020LH\u0016J(\u0010J\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\f2\u0006\u0010N\u001a\u00020\f2\u0006\u0010O\u001a\u00020\f2\u0006\u0010P\u001a\u00020\fH\u0016J\u0012\u0010Q\u001a\u00020\u001f2\b\u0010R\u001a\u0004\u0018\u00010\u001cH\u0016J$\u0010S\u001a\u00020\u001f*\u0002052\u0006\u0010#\u001a\u00020\"2\u0006\u0010.\u001a\u00020-2\u0006\u0010T\u001a\u00020&H\u0002J\u0016\u0010U\u001a\u00020\u001f*\u0002052\b\u00107\u001a\u0004\u0018\u00010\u0011H\u0002J$\u0010V\u001a\u00020\u001f*\u0002052\u0006\u0010#\u001a\u00020\"2\u0006\u0010,\u001a\u00020-2\u0006\u0010W\u001a\u00020&H\u0002J\u0014\u0010X\u001a\u00020\u001f*\u0002052\u0006\u0010#\u001a\u00020\"H\u0002J\u0014\u0010Y\u001a\u00020\u001f*\u0002052\u0006\u0010#\u001a\u00020\"H\u0002R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/QrCodeDrawableImpl;", "Landroid/graphics/drawable/Drawable;", "data", "Lcom/github/alexzhirkevich/customqrgenerator/QrData;", "options", "Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions;", "charset", "Ljava/nio/charset/Charset;", "(Lcom/github/alexzhirkevich/customqrgenerator/QrData;Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions;Ljava/nio/charset/Charset;)V", "anchorCenters", "", "Lkotlin/Pair;", "", "ballShape", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape;", "balls", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "codeMatrix", "Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrCodeMatrix;", "getCodeMatrix", "()Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrCodeMatrix;", "frameShape", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape;", "frames", "initialMatrix", "mAlpha", "mColorFilter", "Landroid/graphics/ColorFilter;", "shapeIncrease", "applyNaturalLogo", "", "logoBgSize", "size", "", "pixelSize", "createBackground", "createHighlightingPaint", "Landroid/graphics/Paint;", "highlightingType", "Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType;", "createLogo", "logoSize", "createMainElements", "framePath", "Landroid/graphics/Path;", "ballPath", "darkPixelPath", "lightPixelPath", "darkTimingPath", "lightTimingPath", WebViewContainer.EVENT_draw, "canvas", "Landroid/graphics/Canvas;", "drawToCanvas", "background", "logoBgPath", "logoBgPaint", "logo", "getOpacity", "isBallStart", "", "x", "y", "isFrameStart", "isInsideFrameOrBall", "checkAnchor", "isOnTimingLine", "isVersionEyeCenter", "resize", AnimationConstant.PROP_STR_WIDTH, AnimationConstant.PROP_STR_HEIGHT, "setAlpha", "alpha", "setBounds", "bounds", "Landroid/graphics/Rect;", AnimationConstant.PROP_STR_LEFT, AnimationConstant.PROP_STR_TOP, AnimationConstant.PROP_STR_RIGHT, AnimationConstant.PROP_STR_BOTTOM, "setColorFilter", "colorFilter", "drawBalls", "ballPaint", "drawBg", "drawFrames", "framePaint", "highlightCornerEyes", "highlightVersionEyes", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class QrCodeDrawableImpl extends Drawable {
    private List<Pair<Integer, Integer>> anchorCenters;
    private final QrVectorBallShape ballShape;
    private final List<Pair<Integer, Integer>> balls;
    private Bitmap bitmap;
    private final QrCodeMatrix codeMatrix;
    private final QrVectorFrameShape frameShape;
    private final List<Pair<Integer, Integer>> frames;
    private final QrCodeMatrix initialMatrix;
    private int mAlpha;
    private ColorFilter mColorFilter;
    private final QrVectorOptions options;
    private final int shapeIncrease;

    /* compiled from: QrCodeDrawable.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[QrCodeMatrix.PixelType.values().length];
            iArr[QrCodeMatrix.PixelType.DarkPixel.ordinal()] = 1;
            iArr[QrCodeMatrix.PixelType.LightPixel.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "PixelFormat.TRANSLUCENT", imports = {"android.graphics.PixelFormat"}))
    public int getOpacity() {
        return -3;
    }

    public /* synthetic */ QrCodeDrawableImpl(QrData qrData, QrVectorOptions qrVectorOptions, Charset charset, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(qrData, qrVectorOptions, (i & 4) != 0 ? null : charset);
    }

    public QrCodeDrawableImpl(QrData qrData, QrVectorOptions qrVectorOptions, Charset charset) {
        ErrorCorrectionLevel lvl;
        List pairCombinations;
        QrErrorCorrectionLevel fit;
        Intrinsics.checkNotNullParameter(qrData, "data");
        Intrinsics.checkNotNullParameter(qrVectorOptions, "options");
        this.options = qrVectorOptions;
        String encode = qrData.encode();
        QrErrorCorrectionLevel errorCorrectionLevel = qrVectorOptions.getErrorCorrectionLevel();
        if (errorCorrectionLevel == QrErrorCorrectionLevel.Auto) {
            fit = QrCodeDrawableKt.fit(errorCorrectionLevel, qrVectorOptions.getLogo(), qrVectorOptions.getCodeShape());
            lvl = fit.getLvl();
        } else {
            lvl = errorCorrectionLevel.getLvl();
        }
        QRCode encode2 = Encoder.encode(encode, lvl, charset != null ? MapsKt.mapOf(TuplesKt.to(EncodeHintType.CHARACTER_SET, charset)) : null);
        ByteMatrix matrix = encode2.getMatrix();
        Intrinsics.checkNotNullExpressionValue(matrix, "code.matrix");
        QrCodeMatrix qrMatrix = QrEncoderKt.toQrMatrix(matrix);
        if (qrVectorOptions.getFourthEyeEnabled()) {
            int size = qrMatrix.getSize();
            for (int size2 = qrMatrix.getSize() - 8; size2 < size; size2++) {
                int size3 = qrMatrix.getSize();
                for (int size4 = qrMatrix.getSize() - 8; size4 < size3; size4++) {
                    qrMatrix.set(size2, size4, QrCodeMatrix.PixelType.Background);
                }
            }
        }
        this.initialMatrix = qrMatrix;
        this.shapeIncrease = (MathKt.roundToInt(qrMatrix.getSize() * this.options.getCodeShape().getShapeSizeIncrease()) - qrMatrix.getSize()) / 2;
        int[] alignmentPatternCenters = encode2.getVersion().getAlignmentPatternCenters();
        Intrinsics.checkNotNullExpressionValue(alignmentPatternCenters, "it");
        Integer maxOrNull = ArraysKt.maxOrNull(alignmentPatternCenters);
        Integer valueOf = Integer.valueOf(maxOrNull != null ? maxOrNull.intValue() : 0);
        Integer minOrNull = ArraysKt.minOrNull(alignmentPatternCenters);
        Pair pair = TuplesKt.to(valueOf, Integer.valueOf(minOrNull != null ? minOrNull.intValue() : 0));
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        int[] alignmentPatternCenters2 = encode2.getVersion().getAlignmentPatternCenters();
        Intrinsics.checkNotNullExpressionValue(alignmentPatternCenters2, "code.version.alignmentPatternCenters");
        pairCombinations = QrCodeDrawableKt.pairCombinations(ArraysKt.toList(alignmentPatternCenters2));
        ArrayList arrayList = new ArrayList();
        Iterator it = pairCombinations.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Pair pair2 = (Pair) next;
            if ((((Number) pair2.getFirst()).intValue() != intValue2 || ((Number) pair2.getSecond()).intValue() != intValue2) && ((((Number) pair2.getFirst()).intValue() != intValue || ((Number) pair2.getSecond()).intValue() != intValue2) && ((((Number) pair2.getFirst()).intValue() != intValue2 || ((Number) pair2.getSecond()).intValue() != intValue) && (!this.options.getFourthEyeEnabled() || ((Number) pair2.getFirst()).intValue() != intValue || ((Number) pair2.getSecond()).intValue() != intValue)))) {
                z = false;
            }
            if (!z) {
                arrayList.add(next);
            }
        }
        this.anchorCenters = arrayList;
        if (this.options.getHighlighting().getVersionEyes() instanceof HighlightingType.Styled) {
            QrCodeMatrix qrCodeMatrix = this.initialMatrix;
            Iterator<T> it2 = this.anchorCenters.iterator();
            while (it2.hasNext()) {
                Pair pair3 = (Pair) it2.next();
                int intValue3 = ((Number) pair3.getFirst()).intValue() + 3;
                for (int intValue4 = ((Number) pair3.getFirst()).intValue() - 2; intValue4 < intValue3; intValue4++) {
                    int intValue5 = ((Number) pair3.getSecond()).intValue() + 3;
                    for (int intValue6 = ((Number) pair3.getSecond()).intValue() - 2; intValue6 < intValue5; intValue6++) {
                        qrCodeMatrix.set(intValue4, intValue6, QrCodeMatrix.PixelType.VersionEye);
                    }
                }
            }
        }
        this.codeMatrix = this.options.getCodeShape().apply(this.initialMatrix);
        List mutableListOf = CollectionsKt.mutableListOf(new Pair[]{TuplesKt.to(Integer.valueOf(this.shapeIncrease + 2), Integer.valueOf(this.shapeIncrease + 2)), TuplesKt.to(Integer.valueOf(this.shapeIncrease + 2), Integer.valueOf((r11.getSize() - 5) - this.shapeIncrease)), TuplesKt.to(Integer.valueOf((r11.getSize() - 5) - this.shapeIncrease), Integer.valueOf(this.shapeIncrease + 2))});
        if (this.options.getFourthEyeEnabled()) {
            mutableListOf.add(TuplesKt.to(Integer.valueOf((r11.getSize() - 5) - this.shapeIncrease), Integer.valueOf((r11.getSize() - 5) - this.shapeIncrease)));
        }
        this.balls = CollectionsKt.toList(mutableListOf);
        List mutableListOf2 = CollectionsKt.mutableListOf(new Pair[]{TuplesKt.to(Integer.valueOf(this.shapeIncrease), Integer.valueOf(this.shapeIncrease)), TuplesKt.to(Integer.valueOf(this.shapeIncrease), Integer.valueOf((r11.getSize() - 7) - this.shapeIncrease)), TuplesKt.to(Integer.valueOf((r11.getSize() - 7) - this.shapeIncrease), Integer.valueOf(this.shapeIncrease))});
        if (this.options.getFourthEyeEnabled()) {
            mutableListOf2.add(TuplesKt.to(Integer.valueOf((r11.getSize() - 7) - this.shapeIncrease), Integer.valueOf((r11.getSize() - 7) - this.shapeIncrease)));
        }
        this.frames = CollectionsKt.toList(mutableListOf2);
        this.mAlpha = JfifUtil.MARKER_FIRST_BYTE;
        QrVectorBallShape.AsPixelShape ball = this.options.getShapes().getBall();
        ball = (ball instanceof QrVectorBallShape.AsDarkPixels) ^ true ? ball : null;
        this.ballShape = ball == null ? new QrVectorBallShape.AsPixelShape(this.options.getShapes().getDarkPixel()) : ball;
        QrVectorFrameShape frame = this.options.getShapes().getFrame();
        QrVectorFrameShape.AsPixelShape asPixelShape = (frame instanceof QrVectorFrameShape.AsDarkPixels) ^ true ? frame : null;
        this.frameShape = asPixelShape == null ? new QrVectorFrameShape.AsPixelShape(this.options.getShapes().getDarkPixel()) : asPixelShape;
    }

    public final QrCodeMatrix getCodeMatrix() {
        return this.codeMatrix;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.mAlpha = alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        resize(right - left, bottom - top);
    }

    private final void drawBg(Canvas canvas, Bitmap bitmap) {
        if (!(this.options.getBackground().getColor() instanceof QrVectorColor.Unspecified) && !(this.options.getBackground().getColor() instanceof QrVectorColor.Transparent)) {
            canvas.drawPaint(this.options.getBackground().getColor().createPaint(getBounds().width(), getBounds().height()));
        }
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private final void drawBalls(Canvas canvas, float f, Path path, Paint paint) {
        Path path2;
        Iterator<T> it = this.balls.iterator();
        int i = -1;
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (this.options.getShapes().getCentralSymmetry()) {
                i++;
                path2 = new Path(path);
                float f2 = (3 * f) / 2;
                path2.transform(MatrixKt.rotationMatrix(i != 0 ? i != 1 ? i != 2 ? 180.0f : 90.0f : -90.0f : 0.0f, f2, f2));
            } else {
                path2 = path;
            }
            float floatValue = ((Number) pair.getFirst()).floatValue() * f;
            float floatValue2 = ((Number) pair.getSecond()).floatValue() * f;
            int save = canvas.save();
            canvas.translate(floatValue, floatValue2);
            try {
                canvas.drawPath(path2, paint);
            } finally {
                canvas.restoreToCount(save);
            }
        }
    }

    private final Paint createHighlightingPaint(HighlightingType highlightingType, float size) {
        QrVectorColor.Solid light;
        boolean z = highlightingType instanceof HighlightingType.Styled;
        HighlightingType.Styled styled = z ? (HighlightingType.Styled) highlightingType : null;
        if (styled == null || (light = styled.getColor()) == null) {
            light = this.options.getColors().getLight();
            if (!(!QrVectorColorKt.isTransparent(light) && z)) {
                light = null;
            }
            if (light == null) {
                QrVectorColor color = this.options.getBackground().getColor();
                QrVectorColor qrVectorColor = QrVectorColorKt.isTransparent(color) && z ? color : null;
                light = qrVectorColor == null ? new QrVectorColor.Solid(-1) : qrVectorColor;
            }
        }
        Paint createPaint = light.createPaint(size, size);
        createPaint.setAlpha(MathKt.roundToInt(RangesKt.coerceIn(this.options.getHighlighting().getAlpha(), 0.0f, 1.0f) * JfifUtil.MARKER_FIRST_BYTE));
        return createPaint;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x014c, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0150, code lost:
    
        throw r12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void highlightVersionEyes(Canvas canvas, float f) {
        Pair pair;
        Path path;
        QrVectorShapeModifier shape;
        HighlightingType versionEyes = this.options.getHighlighting().getVersionEyes();
        if (Intrinsics.areEqual(versionEyes, HighlightingType.None.INSTANCE)) {
            return;
        }
        if (Intrinsics.areEqual(versionEyes, HighlightingType.Default.INSTANCE)) {
            pair = TuplesKt.to(DefaultVersionFrame.INSTANCE, QrVectorBallShape.Default.INSTANCE);
        } else if (versionEyes instanceof HighlightingType.Styled) {
            pair = TuplesKt.to(this.options.getShapes().getFrame(), this.options.getShapes().getBall());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        QrVectorFrameShape qrVectorFrameShape = (QrVectorFrameShape) pair.component1();
        QrVectorBallShape qrVectorBallShape = (QrVectorBallShape) pair.component2();
        float f2 = 5 * f;
        Path createPath = qrVectorFrameShape.createPath(f2, Neighbors.INSTANCE.getEmpty());
        Path createPath2 = qrVectorBallShape.createPath(f, Neighbors.INSTANCE.getEmpty());
        Paint createHighlightingPaint = createHighlightingPaint(this.options.getHighlighting().getVersionEyes(), f2);
        HighlightingType versionEyes2 = this.options.getHighlighting().getVersionEyes();
        HighlightingType.Styled styled = versionEyes2 instanceof HighlightingType.Styled ? (HighlightingType.Styled) versionEyes2 : null;
        if (styled == null || (shape = styled.getShape()) == null || (path = shape.createPath(f2, Neighbors.INSTANCE.getEmpty())) == null) {
            Path createPath3 = QrVectorBallShape.Default.INSTANCE.createPath(3 * f, Neighbors.INSTANCE.getEmpty());
            createPath3.transform(MatrixKt.translationMatrix(f, f));
            Path path2 = new Path(createPath);
            path2.op(createPath3, Path.Op.UNION);
            path = path2;
        }
        Iterator<T> it = this.anchorCenters.iterator();
        while (it.hasNext()) {
            Pair pair2 = (Pair) it.next();
            int save = canvas.save();
            canvas.translate(((this.shapeIncrease + ((Number) pair2.getFirst()).intValue()) - 2) * f, ((this.shapeIncrease + ((Number) pair2.getSecond()).intValue()) - 2) * f);
            try {
                canvas.drawPath(path, createHighlightingPaint);
                if (!(this.options.getColors().getFrame() instanceof QrVectorColor.Unspecified)) {
                    canvas.drawPath(createPath, this.options.getColors().getFrame().createPaint(f2, f2));
                }
                float f3 = 2 * f;
                save = canvas.save();
                canvas.translate(f3, f3);
                if (!(this.options.getColors().getFrame() instanceof QrVectorColor.Unspecified)) {
                    canvas.drawPath(createPath2, this.options.getColors().getBall().createPaint(f, f));
                }
                canvas.restoreToCount(save);
            } finally {
            }
        }
    }

    private final void highlightCornerEyes(Canvas canvas, float f) {
        Path path;
        HighlightingType cornerEyes = this.options.getHighlighting().getCornerEyes();
        if (Intrinsics.areEqual(cornerEyes, HighlightingType.None.INSTANCE)) {
            return;
        }
        if (Intrinsics.areEqual(cornerEyes, HighlightingType.Default.INSTANCE)) {
            path = QrVectorBallShape.Default.INSTANCE.createPath(9 * f, Neighbors.INSTANCE.getEmpty());
        } else {
            if (!(cornerEyes instanceof HighlightingType.Styled)) {
                throw new NoWhenBranchMatchedException();
            }
            QrVectorShapeModifier shape = ((HighlightingType.Styled) this.options.getHighlighting().getCornerEyes()).getShape();
            if (shape == null || (path = shape.createPath(9 * f, Neighbors.INSTANCE.getEmpty())) == null) {
                Path createPath = this.options.getShapes().getFrame().createPath(9 * f, Neighbors.INSTANCE.getEmpty());
                Path createPath2 = QrVectorBallShape.Default.INSTANCE.createPath(7 * f, Neighbors.INSTANCE.getEmpty());
                createPath2.transform(MatrixKt.translationMatrix(f, f));
                Path path2 = new Path(createPath);
                path2.op(createPath2, Path.Op.UNION);
                path = path2;
            }
        }
        Paint createHighlightingPaint = createHighlightingPaint(this.options.getHighlighting().getCornerEyes(), 9 * f);
        Iterator<T> it = this.frames.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            int save = canvas.save();
            canvas.translate((((Number) pair.getFirst()).intValue() - 1) * f, (((Number) pair.getSecond()).intValue() - 1) * f);
            try {
                canvas.drawPath(path, createHighlightingPaint);
            } finally {
                canvas.restoreToCount(save);
            }
        }
    }

    private final void drawFrames(Canvas canvas, float f, Path path, Paint paint) {
        Path path2;
        Iterator<T> it = this.frames.iterator();
        int i = -1;
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            float floatValue = ((Number) pair.getFirst()).floatValue() * f;
            float floatValue2 = ((Number) pair.getSecond()).floatValue() * f;
            int save = canvas.save();
            canvas.translate(floatValue, floatValue2);
            try {
                if (this.options.getShapes().getCentralSymmetry()) {
                    i++;
                    path2 = new Path(path);
                    float f2 = (7 * f) / 2;
                    path2.transform(MatrixKt.rotationMatrix(i != 0 ? i != 1 ? i != 2 ? 180.0f : 90.0f : -90.0f : 0.0f, f2, f2));
                } else {
                    path2 = path;
                }
                canvas.drawPath(path2, paint);
            } finally {
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    private final void drawToCanvas(Canvas canvas, float size, float pixelSize, Path darkPixelPath, Path lightPixelPath, Path darkTimingPath, Path lightTimingPath, Path framePath, Path ballPath, Bitmap background, float logoBgSize, Path logoBgPath, Paint logoBgPaint, Bitmap logo) {
        Paint createPaint;
        Paint createPaint2 = this.options.getColors().getDark().createPaint(this.codeMatrix.getSize() * pixelSize, this.codeMatrix.getSize() * pixelSize);
        createPaint2.setAntiAlias(true);
        Paint createPaint3 = this.options.getColors().getLight().createPaint(this.codeMatrix.getSize() * pixelSize, this.codeMatrix.getSize() * pixelSize);
        createPaint3.setAntiAlias(true);
        float f = 3.0f * pixelSize;
        Paint createPaint4 = this.options.getColors().getBall().createPaint(f, f);
        createPaint4.setAntiAlias(true);
        float f2 = 7.0f * pixelSize;
        Paint createPaint5 = this.options.getColors().getFrame().createPaint(f2, f2);
        createPaint5.setAntiAlias(true);
        Pair pair = TuplesKt.to(Integer.valueOf(getBounds().width()), Integer.valueOf(getBounds().height()));
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        QrOffset offset = this.options.getOffset();
        List listOf = CollectionsKt.listOf(new Float[]{Float.valueOf(offset.getX()), Float.valueOf(offset.getY())});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf, 10));
        for (Iterator it = listOf.iterator(); it.hasNext(); it = it) {
            arrayList.add(Float.valueOf(RangesKt.coerceIn(((Number) it.next()).floatValue(), -1.0f, 1.0f) + 1));
        }
        ArrayList arrayList2 = arrayList;
        float floatValue = ((Number) arrayList2.get(0)).floatValue();
        float floatValue2 = ((Number) arrayList2.get(1)).floatValue();
        int density = canvas.getDensity();
        canvas.setDensity(0);
        drawBg(canvas, background);
        float f3 = ((intValue2 - size) / 2.0f) * floatValue2;
        int save = canvas.save();
        canvas.translate(((intValue - size) / 2.0f) * floatValue, f3);
        try {
            highlightCornerEyes(canvas, pixelSize);
            highlightVersionEyes(canvas, pixelSize);
            canvas.drawPath(darkPixelPath, createPaint2);
            canvas.drawPath(lightPixelPath, createPaint3);
            HighlightingType timingLines = this.options.getHighlighting().getTimingLines();
            if (Intrinsics.areEqual(timingLines, HighlightingType.Default.INSTANCE)) {
                createPaint2 = new QrVectorColor.Solid(-16777216).createPaint(this.codeMatrix.getSize() * pixelSize, this.codeMatrix.getSize() * pixelSize);
            } else if (Intrinsics.areEqual(timingLines, HighlightingType.None.INSTANCE)) {
                createPaint2 = new Paint();
            } else if (!(timingLines instanceof HighlightingType.Styled)) {
                throw new NoWhenBranchMatchedException();
            }
            canvas.drawPath(darkTimingPath, createPaint2);
            HighlightingType timingLines2 = this.options.getHighlighting().getTimingLines();
            if (Intrinsics.areEqual(timingLines2, HighlightingType.Default.INSTANCE)) {
                createPaint3 = new QrVectorColor.Solid(-1).createPaint(this.codeMatrix.getSize() * pixelSize, this.codeMatrix.getSize() * pixelSize);
                createPaint3.setAlpha(MathKt.roundToInt(RangesKt.coerceIn(this.options.getHighlighting().getAlpha(), 0.0f, 1.0f) * JfifUtil.MARKER_FIRST_BYTE));
                Unit unit = Unit.INSTANCE;
            } else if (Intrinsics.areEqual(timingLines2, HighlightingType.None.INSTANCE)) {
                createPaint3 = new Paint();
            } else {
                if (!(timingLines2 instanceof HighlightingType.Styled)) {
                    throw new NoWhenBranchMatchedException();
                }
                QrVectorColor color = ((HighlightingType.Styled) this.options.getHighlighting().getTimingLines()).getColor();
                if (color != null && (createPaint = color.createPaint(this.codeMatrix.getSize() * pixelSize, this.codeMatrix.getSize() * pixelSize)) != null) {
                    createPaint3 = createPaint;
                }
            }
            canvas.drawPath(lightTimingPath, createPaint3);
            if (!(this.options.getColors().getFrame() instanceof QrVectorColor.Unspecified)) {
                drawFrames(canvas, pixelSize, framePath, createPaint5);
            }
            if (!(this.options.getColors().getBall() instanceof QrVectorColor.Unspecified)) {
                drawBalls(canvas, pixelSize, ballPath, createPaint4);
            }
            float f4 = (size - logoBgSize) / 2.0f;
            Pair pair2 = TuplesKt.to(Float.valueOf(f4), Float.valueOf(f4));
            float floatValue3 = ((Number) pair2.component1()).floatValue();
            float floatValue4 = ((Number) pair2.component2()).floatValue();
            if (logoBgPaint != null) {
                save = canvas.save();
                canvas.translate(floatValue3, floatValue4);
                try {
                    canvas.drawPath(logoBgPath, logoBgPaint);
                    canvas.restoreToCount(save);
                } finally {
                    canvas.restoreToCount(save);
                }
            }
            if (logo != null) {
                Pair pair3 = TuplesKt.to(Float.valueOf((size - logo.getWidth()) / 2.0f), Float.valueOf((size - logo.getHeight()) / 2.0f));
                canvas.drawBitmap(logo, ((Number) pair3.component1()).floatValue(), ((Number) pair3.component2()).floatValue(), (Paint) null);
            }
            canvas.restoreToCount(save);
            canvas.setDensity(density);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x007d, code lost:
    
        if (r5.isEmpty() != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void applyNaturalLogo(int logoBgSize, float size, float pixelSize) {
        float f = logoBgSize;
        Path createPath = this.options.getLogo().getShape().createPath(f, Neighbors.INSTANCE.getEmpty());
        float f2 = (size - f) / 2.0f;
        createPath.transform(MatrixKt.translationMatrix(f2, f2));
        int size2 = this.codeMatrix.getSize();
        for (int i = 0; i < size2; i++) {
            int size3 = this.codeMatrix.getSize();
            for (int i2 = 0; i2 < size3; i2++) {
                Neighbors neighbors = QrCodeMatrixKt.neighbors(this.codeMatrix, i, i2);
                Path createPath2 = this.options.getShapes().getDarkPixel().createPath(pixelSize, neighbors);
                Path createPath3 = this.options.getShapes().getLightPixel().createPath(pixelSize, neighbors);
                if (this.codeMatrix.get(i, i2) == QrCodeMatrix.PixelType.DarkPixel) {
                    Path path = new Path(createPath2);
                    path.transform(MatrixKt.translationMatrix(i * pixelSize, i2 * pixelSize));
                    Path path2 = new Path();
                    path2.op(createPath, path, Path.Op.INTERSECT);
                }
                if (this.codeMatrix.get(i, i2) == QrCodeMatrix.PixelType.LightPixel) {
                    Path path3 = new Path(createPath3);
                    path3.transform(MatrixKt.translationMatrix(i * pixelSize, i2 * pixelSize));
                    Path path4 = new Path();
                    path4.op(createPath, path3, Path.Op.INTERSECT);
                    if (path4.isEmpty()) {
                    }
                    this.codeMatrix.set(i, i2, QrCodeMatrix.PixelType.Logo);
                }
            }
        }
    }

    private final boolean isOnTimingLine(int x, int y) {
        int i = this.shapeIncrease;
        return (x - i == 6 || y - i == 6) && !isInsideFrameOrBall$default(this, x, y, false, 4, null);
    }

    private final boolean isVersionEyeCenter(int x, int y) {
        List<Pair<Integer, Integer>> list = this.anchorCenters;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (((Number) pair.getFirst()).intValue() == x - this.shapeIncrease && ((Number) pair.getSecond()).intValue() == y - this.shapeIncrease) {
                return true;
            }
        }
        return false;
    }

    private final boolean isFrameStart(int x, int y) {
        int i = this.shapeIncrease;
        return (x - i == 0 && y - i == 0) || (x - i == 0 && i + y == this.codeMatrix.getSize() + (-7)) || ((this.shapeIncrease + x == this.codeMatrix.getSize() + (-7) && y - this.shapeIncrease == 0) || (this.options.getFourthEyeEnabled() && x + this.shapeIncrease == this.codeMatrix.getSize() + (-7) && y + this.shapeIncrease == this.codeMatrix.getSize() + (-7)));
    }

    private final boolean isBallStart(int x, int y) {
        int i = this.shapeIncrease;
        if ((x - i != 2 || i + y != this.codeMatrix.getSize() - 5) && (this.shapeIncrease + x != this.codeMatrix.getSize() - 5 || y - this.shapeIncrease != 2)) {
            int i2 = this.shapeIncrease;
            if ((x - i2 != 2 || y - i2 != 2) && (!this.options.getFourthEyeEnabled() || x + this.shapeIncrease != this.codeMatrix.getSize() - 5 || y + this.shapeIncrease != this.codeMatrix.getSize() - 5)) {
                return false;
            }
        }
        return true;
    }

    static /* synthetic */ boolean isInsideFrameOrBall$default(QrCodeDrawableImpl qrCodeDrawableImpl, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = true;
        }
        return qrCodeDrawableImpl.isInsideFrameOrBall(i, i2, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[LOOP:0: B:72:0x0029->B:89:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isInsideFrameOrBall(int x, int y, boolean checkAnchor) {
        boolean z;
        boolean z2;
        boolean z3;
        if (checkAnchor && !(this.options.getHighlighting().getVersionEyes() instanceof HighlightingType.None)) {
            List<Pair<Integer, Integer>> list = this.anchorCenters;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    int intValue = ((Number) pair.getFirst()).intValue() - 2;
                    int intValue2 = ((Number) pair.getFirst()).intValue() + 3;
                    int i = x - this.shapeIncrease;
                    if (intValue <= i && i < intValue2) {
                        int intValue3 = ((Number) pair.getSecond()).intValue() - 2;
                        int intValue4 = ((Number) pair.getSecond()).intValue() + 3;
                        int i2 = y - this.shapeIncrease;
                        if (intValue3 <= i2 && i2 < intValue4) {
                            z2 = true;
                            if (!z2) {
                                z3 = true;
                                break;
                            }
                        }
                    }
                    z2 = false;
                    if (!z2) {
                    }
                }
            }
            z3 = false;
            if (z3) {
                z = true;
                if (!z) {
                    return true;
                }
                int i3 = this.shapeIncrease;
                int i4 = x - i3;
                if (-1 <= i4 && i4 < 8) {
                    int i5 = y - i3;
                    if (-1 <= i5 && i5 < 8) {
                        return true;
                    }
                }
                int i6 = x - i3;
                if (-1 <= i6 && i6 < 8) {
                    int size = this.codeMatrix.getSize() - 8;
                    int size2 = this.codeMatrix.getSize() + 1;
                    int i7 = this.shapeIncrease + y;
                    if (size <= i7 && i7 < size2) {
                        return true;
                    }
                }
                int size3 = this.codeMatrix.getSize() - 8;
                int size4 = this.codeMatrix.getSize() + 1;
                int i8 = this.shapeIncrease;
                int i9 = x + i8;
                if (size3 <= i9 && i9 < size4) {
                    int i10 = y - i8;
                    if (-1 <= i10 && i10 < 8) {
                        return true;
                    }
                }
                if (this.options.getFourthEyeEnabled()) {
                    int size5 = this.codeMatrix.getSize() - 8;
                    int size6 = this.codeMatrix.getSize() + 1;
                    int i11 = x + this.shapeIncrease;
                    if (size5 <= i11 && i11 < size6) {
                        int size7 = this.codeMatrix.getSize() - 8;
                        int size8 = this.codeMatrix.getSize() + 1;
                        int i12 = y + this.shapeIncrease;
                        if (size7 <= i12 && i12 < size8) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        z = false;
        if (!z) {
        }
    }

    private final Bitmap createLogo(float logoSize) {
        if (this.options.getLogo().getDrawable() == null) {
            return null;
        }
        int i = (int) logoSize;
        Bitmap scale = this.options.getLogo().getScale().scale(this.options.getLogo().getDrawable(), i, i);
        if (!scale.isMutable()) {
            scale = scale.copy(scale.getConfig(), true);
        }
        Intrinsics.checkNotNullExpressionValue(scale, "options.logo.scale.scale…t.copy(it.config, true) }");
        Canvas canvas = new Canvas(scale);
        Path path = new Path();
        path.addRect(0.0f, 0.0f, logoSize, logoSize, Path.Direction.CW);
        Path createPath = this.options.getLogo().getShape().createPath(logoSize, Neighbors.INSTANCE.getEmpty());
        Path path2 = new Path(path);
        path2.op(createPath, Path.Op.DIFFERENCE);
        int save = canvas.save();
        canvas.clipPath(path2);
        try {
            float width = canvas.getWidth();
            float height = canvas.getHeight();
            Paint paint = new Paint();
            paint.setColor(0);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
            paint.setAntiAlias(true);
            Unit unit = Unit.INSTANCE;
            canvas.drawRect(0.0f, 0.0f, width, height, paint);
            return scale;
        } finally {
            canvas.restoreToCount(save);
        }
    }

    private final Bitmap createBackground() {
        if (this.options.getBackground().getDrawable() != null) {
            return this.options.getBackground().getScale().scale(this.options.getBackground().getDrawable(), getBounds().width(), getBounds().height());
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0259  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void createMainElements(float pixelSize, Path framePath, Path ballPath, Path darkPixelPath, Path lightPixelPath, Path darkTimingPath, Path lightTimingPath) {
        Path createPath;
        Path createPath2;
        Path path;
        Path path2;
        Path path3;
        int size = this.codeMatrix.getSize();
        int i = -1;
        int i2 = -1;
        int i3 = 0;
        while (i3 < size) {
            int size2 = this.codeMatrix.getSize();
            int i4 = i;
            int i5 = i2;
            for (int i6 = 0; i6 < size2; i6++) {
                Neighbors neighbors = QrCodeMatrixKt.neighbors(this.codeMatrix, i3, i6);
                Path createPath3 = this.options.getShapes().getDarkPixel().createPath(pixelSize, neighbors);
                Path createPath4 = this.options.getShapes().getLightPixel().createPath(pixelSize, neighbors);
                HighlightingType timingLines = this.options.getHighlighting().getTimingLines();
                if (Intrinsics.areEqual(timingLines, HighlightingType.None.INSTANCE)) {
                    createPath = new Path();
                } else if (Intrinsics.areEqual(timingLines, HighlightingType.Default.INSTANCE)) {
                    createPath = QrVectorPixelShape.Default.INSTANCE.createPath(pixelSize, neighbors);
                } else {
                    if (!(timingLines instanceof HighlightingType.Styled)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    QrVectorShapeModifier shape = ((HighlightingType.Styled) this.options.getHighlighting().getTimingLines()).getShape();
                    if (shape == null || (createPath2 = shape.createPath(pixelSize, neighbors)) == null) {
                        if (this.codeMatrix.get(i3, i6) == QrCodeMatrix.PixelType.DarkPixel) {
                            QrVectorPixelShape darkPixel = this.options.getShapes().getDarkPixel();
                            if (QrVectorColorKt.isTransparent(this.options.getColors().getDark())) {
                                neighbors = Neighbors.INSTANCE.getEmpty();
                            }
                            createPath = darkPixel.createPath(pixelSize, neighbors);
                        } else {
                            QrVectorPixelShape lightPixel = this.options.getShapes().getLightPixel();
                            if (QrVectorColorKt.isTransparent(this.options.getColors().getLight())) {
                                neighbors = Neighbors.INSTANCE.getEmpty();
                            }
                            createPath = lightPixel.createPath(pixelSize, neighbors);
                        }
                    } else {
                        path = createPath2;
                        float f = 180.0f;
                        if (!(this.options.getColors().getFrame() instanceof QrVectorColor.Unspecified) && isFrameStart(i3, i6)) {
                            if (this.options.getShapes().getCentralSymmetry()) {
                                i4++;
                                path3 = new Path(framePath);
                                if (i4 == 0) {
                                    f = 0.0f;
                                } else if (i4 == 1) {
                                    f = -90.0f;
                                } else if (i4 == 2) {
                                    f = 90.0f;
                                }
                                float f2 = (7 * pixelSize) / 2;
                                path3.transform(MatrixKt.rotationMatrix(f, f2, f2));
                            } else {
                                path3 = framePath;
                            }
                            darkPixelPath.addPath(path3, i3 * pixelSize, i6 * pixelSize);
                        } else if (!(this.options.getColors().getBall() instanceof QrVectorColor.Unspecified) && isBallStart(i3, i6)) {
                            if (this.options.getShapes().getCentralSymmetry()) {
                                i5++;
                                path2 = new Path(ballPath);
                                if (i5 == 0) {
                                    f = 0.0f;
                                } else if (i5 == 1) {
                                    f = -90.0f;
                                } else if (i5 == 2) {
                                    f = 90.0f;
                                }
                                float f3 = (3 * pixelSize) / 2;
                                path2.transform(MatrixKt.rotationMatrix(f, f3, f3));
                            } else {
                                path2 = ballPath;
                            }
                            darkPixelPath.addPath(path2, i3 * pixelSize, i6 * pixelSize);
                        } else if ((this.options.getHighlighting().getVersionEyes() instanceof HighlightingType.None) && (((this.options.getColors().getFrame() instanceof QrVectorColor.Unspecified) || (this.options.getColors().getBall() instanceof QrVectorColor.Unspecified)) && isVersionEyeCenter(i3, i6))) {
                            if (this.options.getColors().getFrame() instanceof QrVectorColor.Unspecified) {
                                darkPixelPath.addPath((this.options.getHighlighting().getVersionEyes() instanceof HighlightingType.Styled ? this.options.getShapes().getFrame() : DefaultVersionFrame.INSTANCE).createPath(5 * pixelSize, Neighbors.INSTANCE.getEmpty()), (i3 - 2) * pixelSize, (i6 - 2) * pixelSize);
                            }
                            if (this.options.getColors().getBall() instanceof QrVectorColor.Unspecified) {
                                darkPixelPath.addPath((this.options.getHighlighting().getVersionEyes() instanceof HighlightingType.Styled ? this.options.getShapes().getBall() : QrVectorBallShape.Default.INSTANCE).createPath(pixelSize, Neighbors.INSTANCE.getEmpty()), i3 * pixelSize, i6 * pixelSize);
                            }
                        } else {
                            Path path4 = path;
                            if (!isInsideFrameOrBall$default(this, i3, i6, false, 4, null)) {
                                if ((this.options.getHighlighting().getTimingLines() instanceof HighlightingType.None) || !isOnTimingLine(i3, i6)) {
                                    int i7 = WhenMappings.$EnumSwitchMapping$0[this.codeMatrix.get(i3, i6).ordinal()];
                                    if (i7 == 1) {
                                        darkPixelPath.addPath(createPath3, i3 * pixelSize, i6 * pixelSize);
                                    } else if (i7 == 2) {
                                        lightPixelPath.addPath(createPath4, i3 * pixelSize, i6 * pixelSize);
                                    }
                                } else {
                                    int i8 = WhenMappings.$EnumSwitchMapping$0[this.codeMatrix.get(i3, i6).ordinal()];
                                    if (i8 == 1) {
                                        darkTimingPath.addPath(path4, i3 * pixelSize, i6 * pixelSize);
                                    } else if (i8 == 2) {
                                        lightTimingPath.addPath(path4, i3 * pixelSize, i6 * pixelSize);
                                    }
                                }
                            }
                        }
                    }
                }
                path = createPath;
                float f4 = 180.0f;
                if (!(this.options.getColors().getFrame() instanceof QrVectorColor.Unspecified)) {
                }
                if (!(this.options.getColors().getBall() instanceof QrVectorColor.Unspecified)) {
                }
                if (this.options.getHighlighting().getVersionEyes() instanceof HighlightingType.None) {
                }
                Path path42 = path;
                if (!isInsideFrameOrBall$default(this, i3, i6, false, 4, null)) {
                }
            }
            i3++;
            i = i4;
            i2 = i5;
        }
    }

    private final void resize(int width, int height) {
        QrVectorColor color;
        Path path = new Path();
        Path path2 = new Path();
        Path path3 = new Path();
        Path path4 = new Path();
        float f = 1;
        float min = Math.min(width, height) * (f - RangesKt.coerceIn(this.options.getPadding(), 0.0f, 0.5f));
        if (min <= Float.MIN_VALUE) {
            return;
        }
        float size = min / this.codeMatrix.getSize();
        setColorFilter(this.mColorFilter);
        setAlpha(this.mAlpha);
        Path createPath = this.ballShape.createPath(3.0f * size, Neighbors.INSTANCE.getEmpty());
        Path createPath2 = this.frameShape.createPath(7.0f * size, Neighbors.INSTANCE.getEmpty());
        float size2 = min * this.options.getLogo().getSize();
        int roundToInt = MathKt.roundToInt((f + this.options.getLogo().getPadding().getValue()) * size2);
        if (this.options.getLogo().getPadding() instanceof QrVectorLogoPadding.Natural) {
            applyNaturalLogo(roundToInt, min, size);
        }
        float f2 = roundToInt;
        Path createPath3 = this.options.getLogo().getShape().createPath(f2, Neighbors.INSTANCE.getEmpty());
        if (this.options.getLogo().getPadding() instanceof QrVectorLogoPadding.Empty) {
            color = null;
        } else {
            color = this.options.getLogo().getBackgroundColor() instanceof QrVectorColor.Unspecified ? this.options.getBackground().getColor() : this.options.getLogo().getBackgroundColor();
        }
        Paint createPaint = color != null ? color.createPaint(f2, f2) : null;
        createMainElements(size, createPath2, createPath, path, path2, path3, path4);
        Bitmap createLogo = createLogo(size2);
        Bitmap createBackground = createBackground();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.bitmap = createBitmap;
        if (createBitmap != null) {
            createBitmap.setHasAlpha(true);
            drawToCanvas(new Canvas(createBitmap), min, size, path, path2, path3, path4, createPath2, createPath, createBackground, f2, createPath3, createPaint, createLogo);
        }
    }
}
