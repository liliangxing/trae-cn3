package com.github.alexzhirkevich.customqrgenerator.vector;

import com.github.alexzhirkevich.customqrgenerator.QrErrorCorrectionLevel;
import com.github.alexzhirkevich.customqrgenerator.QrHighlighting;
import com.github.alexzhirkevich.customqrgenerator.style.QrOffset;
import com.github.alexzhirkevich.customqrgenerator.style.QrShape;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorBackground;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColors;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorLogo;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrVectorOptions.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001<BW\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0015HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\t\u0010/\u001a\u00020\tHÆ\u0003J\t\u00100\u001a\u00020\u000bHÆ\u0003J\t\u00101\u001a\u00020\rHÆ\u0003J\t\u00102\u001a\u00020\u000fHÆ\u0003J\t\u00103\u001a\u00020\u0011HÆ\u0003J\t\u00104\u001a\u00020\u0013HÆ\u0003Jm\u00105\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015HÆ\u0001J\u0013\u00106\u001a\u00020\u00132\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u000209HÖ\u0001J\t\u0010:\u001a\u00020;HÖ\u0001R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006="}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions;", "", "padding", "", "offset", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrOffset;", "shapes", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapes;", "codeShape", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;", "colors", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColors;", "logo", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogo;", "background", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBackground;", "errorCorrectionLevel", "Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;", "fourthEyeEnabled", "", "highlighting", "Lcom/github/alexzhirkevich/customqrgenerator/QrHighlighting;", "(FLcom/github/alexzhirkevich/customqrgenerator/style/QrOffset;Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapes;Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColors;Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogo;Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBackground;Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;ZLcom/github/alexzhirkevich/customqrgenerator/QrHighlighting;)V", "getBackground", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBackground;", "getCodeShape", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;", "getColors", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColors;", "getErrorCorrectionLevel", "()Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;", "getFourthEyeEnabled", "()Z", "getHighlighting", "()Lcom/github/alexzhirkevich/customqrgenerator/QrHighlighting;", "getLogo", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogo;", "getOffset", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrOffset;", "getPadding", "()F", "getShapes", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapes;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "", "Builder", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final /* data */ class QrVectorOptions {
    private final QrVectorBackground background;
    private final QrShape codeShape;
    private final QrVectorColors colors;
    private final QrErrorCorrectionLevel errorCorrectionLevel;
    private final boolean fourthEyeEnabled;
    private final QrHighlighting highlighting;
    private final QrVectorLogo logo;
    private final QrOffset offset;
    private final float padding;
    private final QrVectorShapes shapes;

    /* renamed from: component1, reason: from getter */
    public final float getPadding() {
        return this.padding;
    }

    /* renamed from: component10, reason: from getter */
    public final QrHighlighting getHighlighting() {
        return this.highlighting;
    }

    /* renamed from: component2, reason: from getter */
    public final QrOffset getOffset() {
        return this.offset;
    }

    /* renamed from: component3, reason: from getter */
    public final QrVectorShapes getShapes() {
        return this.shapes;
    }

    /* renamed from: component4, reason: from getter */
    public final QrShape getCodeShape() {
        return this.codeShape;
    }

    /* renamed from: component5, reason: from getter */
    public final QrVectorColors getColors() {
        return this.colors;
    }

    /* renamed from: component6, reason: from getter */
    public final QrVectorLogo getLogo() {
        return this.logo;
    }

    /* renamed from: component7, reason: from getter */
    public final QrVectorBackground getBackground() {
        return this.background;
    }

    /* renamed from: component8, reason: from getter */
    public final QrErrorCorrectionLevel getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getFourthEyeEnabled() {
        return this.fourthEyeEnabled;
    }

    public final QrVectorOptions copy(float padding, QrOffset offset, QrVectorShapes shapes, QrShape codeShape, QrVectorColors colors, QrVectorLogo logo, QrVectorBackground background, QrErrorCorrectionLevel errorCorrectionLevel, boolean fourthEyeEnabled, QrHighlighting highlighting) {
        Intrinsics.checkNotNullParameter(offset, "offset");
        Intrinsics.checkNotNullParameter(shapes, "shapes");
        Intrinsics.checkNotNullParameter(codeShape, "codeShape");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(logo, "logo");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(errorCorrectionLevel, "errorCorrectionLevel");
        Intrinsics.checkNotNullParameter(highlighting, "highlighting");
        return new QrVectorOptions(padding, offset, shapes, codeShape, colors, logo, background, errorCorrectionLevel, fourthEyeEnabled, highlighting);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QrVectorOptions)) {
            return false;
        }
        QrVectorOptions qrVectorOptions = (QrVectorOptions) other;
        return Intrinsics.areEqual(Float.valueOf(this.padding), Float.valueOf(qrVectorOptions.padding)) && Intrinsics.areEqual(this.offset, qrVectorOptions.offset) && Intrinsics.areEqual(this.shapes, qrVectorOptions.shapes) && Intrinsics.areEqual(this.codeShape, qrVectorOptions.codeShape) && Intrinsics.areEqual(this.colors, qrVectorOptions.colors) && Intrinsics.areEqual(this.logo, qrVectorOptions.logo) && Intrinsics.areEqual(this.background, qrVectorOptions.background) && this.errorCorrectionLevel == qrVectorOptions.errorCorrectionLevel && this.fourthEyeEnabled == qrVectorOptions.fourthEyeEnabled && Intrinsics.areEqual(this.highlighting, qrVectorOptions.highlighting);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((((Float.hashCode(this.padding) * 31) + this.offset.hashCode()) * 31) + this.shapes.hashCode()) * 31) + this.codeShape.hashCode()) * 31) + this.colors.hashCode()) * 31) + this.logo.hashCode()) * 31) + this.background.hashCode()) * 31) + this.errorCorrectionLevel.hashCode()) * 31;
        boolean z = this.fourthEyeEnabled;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((hashCode + i) * 31) + this.highlighting.hashCode();
    }

    public String toString() {
        return "QrVectorOptions(padding=" + this.padding + ", offset=" + this.offset + ", shapes=" + this.shapes + ", codeShape=" + this.codeShape + ", colors=" + this.colors + ", logo=" + this.logo + ", background=" + this.background + ", errorCorrectionLevel=" + this.errorCorrectionLevel + ", fourthEyeEnabled=" + this.fourthEyeEnabled + ", highlighting=" + this.highlighting + ')';
    }

    public QrVectorOptions(float f, QrOffset qrOffset, QrVectorShapes qrVectorShapes, QrShape qrShape, QrVectorColors qrVectorColors, QrVectorLogo qrVectorLogo, QrVectorBackground qrVectorBackground, QrErrorCorrectionLevel qrErrorCorrectionLevel, boolean z, QrHighlighting qrHighlighting) {
        Intrinsics.checkNotNullParameter(qrOffset, "offset");
        Intrinsics.checkNotNullParameter(qrVectorShapes, "shapes");
        Intrinsics.checkNotNullParameter(qrShape, "codeShape");
        Intrinsics.checkNotNullParameter(qrVectorColors, "colors");
        Intrinsics.checkNotNullParameter(qrVectorLogo, "logo");
        Intrinsics.checkNotNullParameter(qrVectorBackground, "background");
        Intrinsics.checkNotNullParameter(qrErrorCorrectionLevel, "errorCorrectionLevel");
        Intrinsics.checkNotNullParameter(qrHighlighting, "highlighting");
        this.padding = f;
        this.offset = qrOffset;
        this.shapes = qrVectorShapes;
        this.codeShape = qrShape;
        this.colors = qrVectorColors;
        this.logo = qrVectorLogo;
        this.background = qrVectorBackground;
        this.errorCorrectionLevel = qrErrorCorrectionLevel;
        this.fourthEyeEnabled = z;
        this.highlighting = qrHighlighting;
    }

    public final float getPadding() {
        return this.padding;
    }

    public final QrOffset getOffset() {
        return this.offset;
    }

    public final QrVectorShapes getShapes() {
        return this.shapes;
    }

    public final QrShape getCodeShape() {
        return this.codeShape;
    }

    public final QrVectorColors getColors() {
        return this.colors;
    }

    public final QrVectorLogo getLogo() {
        return this.logo;
    }

    public final QrVectorBackground getBackground() {
        return this.background;
    }

    public final QrErrorCorrectionLevel getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }

    public final boolean getFourthEyeEnabled() {
        return this.fourthEyeEnabled;
    }

    public final QrHighlighting getHighlighting() {
        return this.highlighting;
    }

    /* compiled from: QrVectorOptions.kt */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u00100\u001a\u00020\u00002\u0006\u0010%\u001a\u00020$J\u000e\u00101\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u00102\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fJ\u000e\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u0010J\u000e\u00105\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u00106\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cJ\u0010\u00107\u001a\u00020\u00002\b\b\u0001\u0010!\u001a\u00020 J\u000e\u00108\u001a\u00020\u00002\u0006\u0010)\u001a\u00020(R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0014@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u001c@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR \u0010!\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020 8\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001e\u0010%\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020$@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001e\u0010)\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020(@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u00069"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;", "", "()V", "<set-?>", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBackground;", "background", "getBackground", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBackground;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColors;", "colors", "getColors", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColors;", "Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;", "errorCorrectionLevel", "getErrorCorrectionLevel", "()Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;", "", "fourthEyeEnabled", "getFourthEyeEnabled", "()Z", "Lcom/github/alexzhirkevich/customqrgenerator/QrHighlighting;", "highlighting", "getHighlighting", "()Lcom/github/alexzhirkevich/customqrgenerator/QrHighlighting;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogo;", "logo", "getLogo", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogo;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrOffset;", "offset", "getOffset", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrOffset;", "", "padding", "getPadding", "()F", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;", "shape", "getShape", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapes;", "shapes", "getShapes", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapes;", "build", "Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions;", "setAnchorsHighlighting", "setBackground", "setCodeShape", "setColors", "setErrorCorrectionLevel", "setFourthEyeEnabled", "enabled", "setLogo", "setOffset", "setPadding", "setShapes", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Builder {
        private boolean fourthEyeEnabled;
        private float padding;
        private QrOffset offset = new QrOffset(0.0f, 0.0f);
        private QrVectorShapes shapes = new QrVectorShapes(null, null, null, null, false, 31, null);
        private QrShape shape = QrShape.Default.INSTANCE;
        private QrVectorColors colors = new QrVectorColors(null, null, null, null, 15, null);
        private QrVectorLogo logo = new QrVectorLogo(null, 0.0f, null, null, null, null, 63, null);
        private QrVectorBackground background = new QrVectorBackground(null, null, null, 7, null);
        private QrErrorCorrectionLevel errorCorrectionLevel = QrErrorCorrectionLevel.Auto;
        private QrHighlighting highlighting = new QrHighlighting(null, null, null, 0.0f, 15, null);

        public final float getPadding() {
            return this.padding;
        }

        public final QrOffset getOffset() {
            return this.offset;
        }

        public final QrVectorShapes getShapes() {
            return this.shapes;
        }

        public final QrShape getShape() {
            return this.shape;
        }

        public final QrVectorColors getColors() {
            return this.colors;
        }

        public final QrVectorLogo getLogo() {
            return this.logo;
        }

        public final QrVectorBackground getBackground() {
            return this.background;
        }

        public final QrErrorCorrectionLevel getErrorCorrectionLevel() {
            return this.errorCorrectionLevel;
        }

        public final boolean getFourthEyeEnabled() {
            return this.fourthEyeEnabled;
        }

        public final QrHighlighting getHighlighting() {
            return this.highlighting;
        }

        public final Builder setPadding(float padding) {
            this.padding = padding;
            return this;
        }

        public final Builder setOffset(QrOffset offset) {
            Intrinsics.checkNotNullParameter(offset, "offset");
            this.offset = offset;
            return this;
        }

        public final Builder setShapes(QrVectorShapes shapes) {
            Intrinsics.checkNotNullParameter(shapes, "shapes");
            this.shapes = shapes;
            return this;
        }

        public final Builder setColors(QrVectorColors colors) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            this.colors = colors;
            return this;
        }

        public final Builder setCodeShape(QrShape shape) {
            Intrinsics.checkNotNullParameter(shape, "shape");
            this.shape = shape;
            return this;
        }

        public final Builder setLogo(QrVectorLogo logo) {
            Intrinsics.checkNotNullParameter(logo, "logo");
            this.logo = logo;
            return this;
        }

        public final Builder setBackground(QrVectorBackground background) {
            Intrinsics.checkNotNullParameter(background, "background");
            this.background = background;
            return this;
        }

        public final Builder setErrorCorrectionLevel(QrErrorCorrectionLevel errorCorrectionLevel) {
            Intrinsics.checkNotNullParameter(errorCorrectionLevel, "errorCorrectionLevel");
            this.errorCorrectionLevel = errorCorrectionLevel;
            return this;
        }

        public final Builder setFourthEyeEnabled(boolean enabled) {
            this.fourthEyeEnabled = enabled;
            return this;
        }

        public final Builder setAnchorsHighlighting(QrHighlighting highlighting) {
            Intrinsics.checkNotNullParameter(highlighting, "highlighting");
            this.highlighting = highlighting;
            return this;
        }

        public final QrVectorOptions build() {
            return new QrVectorOptions(this.padding, this.offset, this.shapes, this.shape, this.colors, this.logo, this.background, this.errorCorrectionLevel, this.fourthEyeEnabled, this.highlighting);
        }
    }
}
