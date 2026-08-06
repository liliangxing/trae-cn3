package com.github.alexzhirkevich.customqrgenerator.vector.style;

import com.github.alexzhirkevich.customqrgenerator.style.QrColorKt;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrVectorColors.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColors;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/IQrVectorColors;", "dark", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "light", "ball", "frame", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;)V", "getBall", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "getDark", "getFrame", "getLight", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final /* data */ class QrVectorColors implements IQrVectorColors {
    private final QrVectorColor ball;
    private final QrVectorColor dark;
    private final QrVectorColor frame;
    private final QrVectorColor light;

    public QrVectorColors() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ QrVectorColors copy$default(QrVectorColors qrVectorColors, QrVectorColor qrVectorColor, QrVectorColor qrVectorColor2, QrVectorColor qrVectorColor3, QrVectorColor qrVectorColor4, int i, Object obj) {
        if ((i & 1) != 0) {
            qrVectorColor = qrVectorColors.getDark();
        }
        if ((i & 2) != 0) {
            qrVectorColor2 = qrVectorColors.getLight();
        }
        if ((i & 4) != 0) {
            qrVectorColor3 = qrVectorColors.getBall();
        }
        if ((i & 8) != 0) {
            qrVectorColor4 = qrVectorColors.getFrame();
        }
        return qrVectorColors.copy(qrVectorColor, qrVectorColor2, qrVectorColor3, qrVectorColor4);
    }

    public final QrVectorColor component1() {
        return getDark();
    }

    public final QrVectorColor component2() {
        return getLight();
    }

    public final QrVectorColor component3() {
        return getBall();
    }

    public final QrVectorColor component4() {
        return getFrame();
    }

    public final QrVectorColors copy(QrVectorColor dark, QrVectorColor light, QrVectorColor ball, QrVectorColor frame) {
        Intrinsics.checkNotNullParameter(dark, "dark");
        Intrinsics.checkNotNullParameter(light, "light");
        Intrinsics.checkNotNullParameter(ball, "ball");
        Intrinsics.checkNotNullParameter(frame, "frame");
        return new QrVectorColors(dark, light, ball, frame);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QrVectorColors)) {
            return false;
        }
        QrVectorColors qrVectorColors = (QrVectorColors) other;
        return Intrinsics.areEqual(getDark(), qrVectorColors.getDark()) && Intrinsics.areEqual(getLight(), qrVectorColors.getLight()) && Intrinsics.areEqual(getBall(), qrVectorColors.getBall()) && Intrinsics.areEqual(getFrame(), qrVectorColors.getFrame());
    }

    public int hashCode() {
        return (((((getDark().hashCode() * 31) + getLight().hashCode()) * 31) + getBall().hashCode()) * 31) + getFrame().hashCode();
    }

    public String toString() {
        return "QrVectorColors(dark=" + getDark() + ", light=" + getLight() + ", ball=" + getBall() + ", frame=" + getFrame() + ')';
    }

    public QrVectorColors(QrVectorColor qrVectorColor, QrVectorColor qrVectorColor2, QrVectorColor qrVectorColor3, QrVectorColor qrVectorColor4) {
        Intrinsics.checkNotNullParameter(qrVectorColor, "dark");
        Intrinsics.checkNotNullParameter(qrVectorColor2, "light");
        Intrinsics.checkNotNullParameter(qrVectorColor3, "ball");
        Intrinsics.checkNotNullParameter(qrVectorColor4, "frame");
        this.dark = qrVectorColor;
        this.light = qrVectorColor2;
        this.ball = qrVectorColor3;
        this.frame = qrVectorColor4;
    }

    public /* synthetic */ QrVectorColors(QrVectorColor.Solid solid, QrVectorColor.Unspecified unspecified, QrVectorColor.Unspecified unspecified2, QrVectorColor.Unspecified unspecified3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new QrVectorColor.Solid(QrColorKt.toColor(4278190080L)) : solid, (i & 2) != 0 ? QrVectorColor.Unspecified.INSTANCE : unspecified, (i & 4) != 0 ? QrVectorColor.Unspecified.INSTANCE : unspecified2, (i & 8) != 0 ? QrVectorColor.Unspecified.INSTANCE : unspecified3);
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorColors
    public QrVectorColor getDark() {
        return this.dark;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorColors
    public QrVectorColor getLight() {
        return this.light;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorColors
    public QrVectorColor getBall() {
        return this.ball;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorColors
    public QrVectorColor getFrame() {
        return this.frame;
    }
}
