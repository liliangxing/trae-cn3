package com.github.alexzhirkevich.customqrgenerator.style;

import com.github.alexzhirkevich.customqrgenerator.style.QrColor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrColors.kt */
@Deprecated(message = "Use QrCodeDrawable with QrVectorColors instead")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrColors;", "Lcom/github/alexzhirkevich/customqrgenerator/style/IQRColors;", "light", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "dark", "frame", "ball", "highlighting", "symmetry", "", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;Z)V", "getBall", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "getDark", "getFrame", "getHighlighting", "getLight", "getSymmetry", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final /* data */ class QrColors implements IQRColors {
    private final QrColor ball;
    private final QrColor dark;
    private final QrColor frame;
    private final QrColor highlighting;
    private final QrColor light;
    private final boolean symmetry;

    public QrColors() {
        this(null, null, null, null, null, false, 63, null);
    }

    public static /* synthetic */ QrColors copy$default(QrColors qrColors, QrColor qrColor, QrColor qrColor2, QrColor qrColor3, QrColor qrColor4, QrColor qrColor5, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            qrColor = qrColors.getLight();
        }
        if ((i & 2) != 0) {
            qrColor2 = qrColors.getDark();
        }
        QrColor qrColor6 = qrColor2;
        if ((i & 4) != 0) {
            qrColor3 = qrColors.getFrame();
        }
        QrColor qrColor7 = qrColor3;
        if ((i & 8) != 0) {
            qrColor4 = qrColors.getBall();
        }
        QrColor qrColor8 = qrColor4;
        if ((i & 16) != 0) {
            qrColor5 = qrColors.getHighlighting();
        }
        QrColor qrColor9 = qrColor5;
        if ((i & 32) != 0) {
            z = qrColors.getSymmetry();
        }
        return qrColors.copy(qrColor, qrColor6, qrColor7, qrColor8, qrColor9, z);
    }

    public final QrColor component1() {
        return getLight();
    }

    public final QrColor component2() {
        return getDark();
    }

    public final QrColor component3() {
        return getFrame();
    }

    public final QrColor component4() {
        return getBall();
    }

    public final QrColor component5() {
        return getHighlighting();
    }

    public final boolean component6() {
        return getSymmetry();
    }

    public final QrColors copy(QrColor light, QrColor dark, QrColor frame, QrColor ball, QrColor highlighting, boolean symmetry) {
        Intrinsics.checkNotNullParameter(light, "light");
        Intrinsics.checkNotNullParameter(dark, "dark");
        Intrinsics.checkNotNullParameter(frame, "frame");
        Intrinsics.checkNotNullParameter(ball, "ball");
        Intrinsics.checkNotNullParameter(highlighting, "highlighting");
        return new QrColors(light, dark, frame, ball, highlighting, symmetry);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QrColors)) {
            return false;
        }
        QrColors qrColors = (QrColors) other;
        return Intrinsics.areEqual(getLight(), qrColors.getLight()) && Intrinsics.areEqual(getDark(), qrColors.getDark()) && Intrinsics.areEqual(getFrame(), qrColors.getFrame()) && Intrinsics.areEqual(getBall(), qrColors.getBall()) && Intrinsics.areEqual(getHighlighting(), qrColors.getHighlighting()) && getSymmetry() == qrColors.getSymmetry();
    }

    public int hashCode() {
        int hashCode = ((((((((getLight().hashCode() * 31) + getDark().hashCode()) * 31) + getFrame().hashCode()) * 31) + getBall().hashCode()) * 31) + getHighlighting().hashCode()) * 31;
        boolean symmetry = getSymmetry();
        int i = symmetry;
        if (symmetry) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "QrColors(light=" + getLight() + ", dark=" + getDark() + ", frame=" + getFrame() + ", ball=" + getBall() + ", highlighting=" + getHighlighting() + ", symmetry=" + getSymmetry() + ')';
    }

    public QrColors(QrColor qrColor, QrColor qrColor2, QrColor qrColor3, QrColor qrColor4, QrColor qrColor5, boolean z) {
        Intrinsics.checkNotNullParameter(qrColor, "light");
        Intrinsics.checkNotNullParameter(qrColor2, "dark");
        Intrinsics.checkNotNullParameter(qrColor3, "frame");
        Intrinsics.checkNotNullParameter(qrColor4, "ball");
        Intrinsics.checkNotNullParameter(qrColor5, "highlighting");
        this.light = qrColor;
        this.dark = qrColor2;
        this.frame = qrColor3;
        this.ball = qrColor4;
        this.highlighting = qrColor5;
        this.symmetry = z;
    }

    public /* synthetic */ QrColors(QrColor.Unspecified unspecified, QrColor.Solid solid, QrColor.Unspecified unspecified2, QrColor.Unspecified unspecified3, QrColor.Unspecified unspecified4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? QrColor.Unspecified.INSTANCE : unspecified, (i & 2) != 0 ? new QrColor.Solid(QrColorKt.Color(4278190080L)) : solid, (i & 4) != 0 ? QrColor.Unspecified.INSTANCE : unspecified2, (i & 8) != 0 ? QrColor.Unspecified.INSTANCE : unspecified3, (i & 16) != 0 ? QrColor.Unspecified.INSTANCE : unspecified4, (i & 32) != 0 ? true : z);
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRColors
    public QrColor getLight() {
        return this.light;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRColors
    public QrColor getDark() {
        return this.dark;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRColors
    public QrColor getFrame() {
        return this.frame;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRColors
    public QrColor getBall() {
        return this.ball;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRColors
    public QrColor getHighlighting() {
        return this.highlighting;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRColors
    public boolean getSymmetry() {
        return this.symmetry;
    }
}
