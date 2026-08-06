package com.github.alexzhirkevich.customqrgenerator;

import com.github.alexzhirkevich.customqrgenerator.style.QrBackground;
import com.github.alexzhirkevich.customqrgenerator.style.QrColors;
import com.github.alexzhirkevich.customqrgenerator.style.QrElementsShapes;
import com.github.alexzhirkevich.customqrgenerator.style.QrLogo;
import com.github.alexzhirkevich.customqrgenerator.style.QrOffset;
import com.github.alexzhirkevich.customqrgenerator.style.QrShape;
import com.lynx.tasm.animation.AnimationConstant;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrOptions.kt */
@Deprecated(message = "Use QrCodeDrawable with QrVectorOptions instead")
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001:B[\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0014HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003J\t\u00100\u001a\u00020\u000eHÆ\u0003J\t\u00101\u001a\u00020\u0010HÆ\u0003J\t\u00102\u001a\u00020\u0012HÆ\u0003Jm\u00103\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0003HÖ\u0001J\t\u00108\u001a\u000209HÖ\u0001R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001f¨\u0006;"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrOptions;", "", AnimationConstant.PROP_STR_WIDTH, "", AnimationConstant.PROP_STR_HEIGHT, "padding", "", "offset", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrOffset;", "colors", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColors;", "logo", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogo;", "background", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrBackground;", "shapes", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrElementsShapes;", "codeShape", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;", "errorCorrectionLevel", "Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;", "(IIFLcom/github/alexzhirkevich/customqrgenerator/style/QrOffset;Lcom/github/alexzhirkevich/customqrgenerator/style/QrColors;Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogo;Lcom/github/alexzhirkevich/customqrgenerator/style/QrBackground;Lcom/github/alexzhirkevich/customqrgenerator/style/QrElementsShapes;Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;)V", "getBackground", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrBackground;", "getCodeShape", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;", "getColors", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrColors;", "getErrorCorrectionLevel", "()Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;", "getHeight", "()I", "getLogo", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogo;", "getOffset", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrOffset;", "getPadding", "()F", "getShapes", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrElementsShapes;", "getWidth", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "Builder", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final /* data */ class QrOptions {
    private final QrBackground background;
    private final QrShape codeShape;
    private final QrColors colors;
    private final QrErrorCorrectionLevel errorCorrectionLevel;
    private final int height;
    private final QrLogo logo;
    private final QrOffset offset;
    private final float padding;
    private final QrElementsShapes shapes;
    private final int width;

    /* renamed from: component1, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component10, reason: from getter */
    public final QrErrorCorrectionLevel getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }

    /* renamed from: component2, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component3, reason: from getter */
    public final float getPadding() {
        return this.padding;
    }

    /* renamed from: component4, reason: from getter */
    public final QrOffset getOffset() {
        return this.offset;
    }

    /* renamed from: component5, reason: from getter */
    public final QrColors getColors() {
        return this.colors;
    }

    /* renamed from: component6, reason: from getter */
    public final QrLogo getLogo() {
        return this.logo;
    }

    /* renamed from: component7, reason: from getter */
    public final QrBackground getBackground() {
        return this.background;
    }

    /* renamed from: component8, reason: from getter */
    public final QrElementsShapes getShapes() {
        return this.shapes;
    }

    /* renamed from: component9, reason: from getter */
    public final QrShape getCodeShape() {
        return this.codeShape;
    }

    public final QrOptions copy(int width, int height, float padding, QrOffset offset, QrColors colors, QrLogo logo, QrBackground background, QrElementsShapes shapes, QrShape codeShape, QrErrorCorrectionLevel errorCorrectionLevel) {
        Intrinsics.checkNotNullParameter(offset, "offset");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(logo, "logo");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(shapes, "shapes");
        Intrinsics.checkNotNullParameter(codeShape, "codeShape");
        Intrinsics.checkNotNullParameter(errorCorrectionLevel, "errorCorrectionLevel");
        return new QrOptions(width, height, padding, offset, colors, logo, background, shapes, codeShape, errorCorrectionLevel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QrOptions)) {
            return false;
        }
        QrOptions qrOptions = (QrOptions) other;
        return this.width == qrOptions.width && this.height == qrOptions.height && Intrinsics.areEqual(Float.valueOf(this.padding), Float.valueOf(qrOptions.padding)) && Intrinsics.areEqual(this.offset, qrOptions.offset) && Intrinsics.areEqual(this.colors, qrOptions.colors) && Intrinsics.areEqual(this.logo, qrOptions.logo) && Intrinsics.areEqual(this.background, qrOptions.background) && Intrinsics.areEqual(this.shapes, qrOptions.shapes) && Intrinsics.areEqual(this.codeShape, qrOptions.codeShape) && this.errorCorrectionLevel == qrOptions.errorCorrectionLevel;
    }

    public int hashCode() {
        return (((((((((((((((((Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height)) * 31) + Float.hashCode(this.padding)) * 31) + this.offset.hashCode()) * 31) + this.colors.hashCode()) * 31) + this.logo.hashCode()) * 31) + this.background.hashCode()) * 31) + this.shapes.hashCode()) * 31) + this.codeShape.hashCode()) * 31) + this.errorCorrectionLevel.hashCode();
    }

    public String toString() {
        return "QrOptions(width=" + this.width + ", height=" + this.height + ", padding=" + this.padding + ", offset=" + this.offset + ", colors=" + this.colors + ", logo=" + this.logo + ", background=" + this.background + ", shapes=" + this.shapes + ", codeShape=" + this.codeShape + ", errorCorrectionLevel=" + this.errorCorrectionLevel + ')';
    }

    public QrOptions(int i, int i2, float f, QrOffset qrOffset, QrColors qrColors, QrLogo qrLogo, QrBackground qrBackground, QrElementsShapes qrElementsShapes, QrShape qrShape, QrErrorCorrectionLevel qrErrorCorrectionLevel) {
        Intrinsics.checkNotNullParameter(qrOffset, "offset");
        Intrinsics.checkNotNullParameter(qrColors, "colors");
        Intrinsics.checkNotNullParameter(qrLogo, "logo");
        Intrinsics.checkNotNullParameter(qrBackground, "background");
        Intrinsics.checkNotNullParameter(qrElementsShapes, "shapes");
        Intrinsics.checkNotNullParameter(qrShape, "codeShape");
        Intrinsics.checkNotNullParameter(qrErrorCorrectionLevel, "errorCorrectionLevel");
        this.width = i;
        this.height = i2;
        this.padding = f;
        this.offset = qrOffset;
        this.colors = qrColors;
        this.logo = qrLogo;
        this.background = qrBackground;
        this.shapes = qrElementsShapes;
        this.codeShape = qrShape;
        this.errorCorrectionLevel = qrErrorCorrectionLevel;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final float getPadding() {
        return this.padding;
    }

    public final QrOffset getOffset() {
        return this.offset;
    }

    public final QrColors getColors() {
        return this.colors;
    }

    public final QrLogo getLogo() {
        return this.logo;
    }

    public final QrBackground getBackground() {
        return this.background;
    }

    public final QrElementsShapes getShapes() {
        return this.shapes;
    }

    public final QrShape getCodeShape() {
        return this.codeShape;
    }

    public final QrErrorCorrectionLevel getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }

    /* compiled from: QrOptions.kt */
    @Deprecated(message = "Use QrCodeDrawable with QrVectorOptions.Builder")
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0006\u00109\u001a\u00020:J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u001fJ\u0010\u0010&\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010'J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-J\u0010\u00102\u001a\u00020\u00002\b\b\u0001\u00102\u001a\u000203J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u0019R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u000203X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%¨\u0006>"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrOptions$Builder;", "", AnimationConstant.PROP_STR_WIDTH, "", AnimationConstant.PROP_STR_HEIGHT, "(II)V", "background", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrBackground;", "getBackground$custom_qr_generator_release", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrBackground;", "setBackground$custom_qr_generator_release", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrBackground;)V", "codeShape", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;", "getCodeShape$custom_qr_generator_release", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;", "setCodeShape$custom_qr_generator_release", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;)V", "colors", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColors;", "getColors$custom_qr_generator_release", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrColors;", "setColors$custom_qr_generator_release", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrColors;)V", "elementsShapes", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrElementsShapes;", "getElementsShapes$custom_qr_generator_release", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrElementsShapes;", "setElementsShapes$custom_qr_generator_release", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrElementsShapes;)V", "errorCorrectionLevel", "Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;", "getErrorCorrectionLevel$custom_qr_generator_release", "()Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;", "setErrorCorrectionLevel$custom_qr_generator_release", "(Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;)V", "getHeight", "()I", "logo", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogo;", "getLogo$custom_qr_generator_release", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogo;", "setLogo$custom_qr_generator_release", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogo;)V", "offset", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrOffset;", "getOffset$custom_qr_generator_release", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrOffset;", "setOffset$custom_qr_generator_release", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrOffset;)V", "padding", "", "getPadding$custom_qr_generator_release", "()F", "setPadding$custom_qr_generator_release", "(F)V", "getWidth", "build", "Lcom/github/alexzhirkevich/customqrgenerator/QrOptions;", "shape", "level", "shapes", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Builder {
        private QrBackground background;
        private QrShape codeShape;
        private QrColors colors;
        private QrElementsShapes elementsShapes;
        private QrErrorCorrectionLevel errorCorrectionLevel;
        private final int height;
        private QrLogo logo;
        private QrOffset offset;
        private float padding;
        private final int width;

        public Builder(int i, int i2) {
            this.width = i;
            this.height = i2;
            this.padding = 0.125f;
            this.offset = QrOffset.INSTANCE.getZero();
            this.colors = new QrColors(null, null, null, null, null, false, 63, null);
            this.logo = new QrLogo(null, 0.0f, null, null, null, null, 63, null);
            this.background = new QrBackground(null, 0.0f, null, null, 15, null);
            this.elementsShapes = new QrElementsShapes(null, null, null, null, null, 31, null);
            this.codeShape = QrShape.Default.INSTANCE;
            this.errorCorrectionLevel = QrErrorCorrectionLevel.Auto;
        }

        public /* synthetic */ Builder(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i3 & 2) != 0 ? i : i2);
        }

        public final int getWidth() {
            return this.width;
        }

        public final int getHeight() {
            return this.height;
        }

        /* renamed from: getPadding$custom_qr_generator_release, reason: from getter */
        public final float getPadding() {
            return this.padding;
        }

        public final void setPadding$custom_qr_generator_release(float f) {
            this.padding = f;
        }

        /* renamed from: getOffset$custom_qr_generator_release, reason: from getter */
        public final QrOffset getOffset() {
            return this.offset;
        }

        public final void setOffset$custom_qr_generator_release(QrOffset qrOffset) {
            Intrinsics.checkNotNullParameter(qrOffset, "<set-?>");
            this.offset = qrOffset;
        }

        /* renamed from: getColors$custom_qr_generator_release, reason: from getter */
        public final QrColors getColors() {
            return this.colors;
        }

        public final void setColors$custom_qr_generator_release(QrColors qrColors) {
            Intrinsics.checkNotNullParameter(qrColors, "<set-?>");
            this.colors = qrColors;
        }

        /* renamed from: getLogo$custom_qr_generator_release, reason: from getter */
        public final QrLogo getLogo() {
            return this.logo;
        }

        public final void setLogo$custom_qr_generator_release(QrLogo qrLogo) {
            Intrinsics.checkNotNullParameter(qrLogo, "<set-?>");
            this.logo = qrLogo;
        }

        /* renamed from: getBackground$custom_qr_generator_release, reason: from getter */
        public final QrBackground getBackground() {
            return this.background;
        }

        public final void setBackground$custom_qr_generator_release(QrBackground qrBackground) {
            Intrinsics.checkNotNullParameter(qrBackground, "<set-?>");
            this.background = qrBackground;
        }

        /* renamed from: getElementsShapes$custom_qr_generator_release, reason: from getter */
        public final QrElementsShapes getElementsShapes() {
            return this.elementsShapes;
        }

        public final void setElementsShapes$custom_qr_generator_release(QrElementsShapes qrElementsShapes) {
            Intrinsics.checkNotNullParameter(qrElementsShapes, "<set-?>");
            this.elementsShapes = qrElementsShapes;
        }

        /* renamed from: getCodeShape$custom_qr_generator_release, reason: from getter */
        public final QrShape getCodeShape() {
            return this.codeShape;
        }

        public final void setCodeShape$custom_qr_generator_release(QrShape qrShape) {
            Intrinsics.checkNotNullParameter(qrShape, "<set-?>");
            this.codeShape = qrShape;
        }

        /* renamed from: getErrorCorrectionLevel$custom_qr_generator_release, reason: from getter */
        public final QrErrorCorrectionLevel getErrorCorrectionLevel() {
            return this.errorCorrectionLevel;
        }

        public final void setErrorCorrectionLevel$custom_qr_generator_release(QrErrorCorrectionLevel qrErrorCorrectionLevel) {
            Intrinsics.checkNotNullParameter(qrErrorCorrectionLevel, "<set-?>");
            this.errorCorrectionLevel = qrErrorCorrectionLevel;
        }

        public final QrOptions build() {
            return new QrOptions(this.width, this.height, this.padding, this.offset, this.colors, this.logo, this.background, this.elementsShapes, this.codeShape, this.errorCorrectionLevel);
        }

        public final Builder padding(float padding) {
            this.padding = padding;
            return this;
        }

        public final Builder offset(QrOffset offset) {
            Intrinsics.checkNotNullParameter(offset, "offset");
            this.offset = offset;
            return this;
        }

        public final Builder colors(QrColors colors) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            this.colors = colors;
            return this;
        }

        public final Builder logo(QrLogo logo) {
            if (logo == null) {
                logo = new QrLogo(null, 0.0f, null, null, null, null, 63, null);
            }
            this.logo = logo;
            return this;
        }

        public final Builder background(QrBackground background) {
            if (background == null) {
                background = new QrBackground(null, 0.0f, null, null, 15, null);
            }
            this.background = background;
            return this;
        }

        public final Builder codeShape(QrShape shape) {
            Intrinsics.checkNotNullParameter(shape, "shape");
            this.codeShape = shape;
            return this;
        }

        public final Builder shapes(QrElementsShapes shapes) {
            Intrinsics.checkNotNullParameter(shapes, "shapes");
            this.elementsShapes = shapes;
            return this;
        }

        public final Builder errorCorrectionLevel(QrErrorCorrectionLevel level) {
            Intrinsics.checkNotNullParameter(level, "level");
            this.errorCorrectionLevel = level;
            return this;
        }
    }
}
