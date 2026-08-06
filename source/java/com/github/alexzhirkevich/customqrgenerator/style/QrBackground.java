package com.github.alexzhirkevich.customqrgenerator.style;

import android.graphics.drawable.Drawable;
import com.github.alexzhirkevich.customqrgenerator.style.BitmapScale;
import com.github.alexzhirkevich.customqrgenerator.style.QrColor;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrBackground.kt */
@Deprecated(message = "Use QrCodeDrawable with QrVectorBackground instead")
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrBackground;", "Lcom/github/alexzhirkevich/customqrgenerator/style/IQRBackground;", "drawable", "Landroid/graphics/drawable/Drawable;", "alpha", "", "scale", "Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", RemoteMessageConst.Notification.COLOR, "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "(Landroid/graphics/drawable/Drawable;FLcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;)V", "getAlpha", "()F", "getColor", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getScale", "()Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final /* data */ class QrBackground implements IQRBackground {
    private final float alpha;
    private final QrColor color;
    private final Drawable drawable;
    private final BitmapScale scale;

    public QrBackground() {
        this(null, 0.0f, null, null, 15, null);
    }

    public static /* synthetic */ QrBackground copy$default(QrBackground qrBackground, Drawable drawable, float f, BitmapScale bitmapScale, QrColor qrColor, int i, Object obj) {
        if ((i & 1) != 0) {
            drawable = qrBackground.getDrawable();
        }
        if ((i & 2) != 0) {
            f = qrBackground.getAlpha();
        }
        if ((i & 4) != 0) {
            bitmapScale = qrBackground.getScale();
        }
        if ((i & 8) != 0) {
            qrColor = qrBackground.getColor();
        }
        return qrBackground.copy(drawable, f, bitmapScale, qrColor);
    }

    public final Drawable component1() {
        return getDrawable();
    }

    public final float component2() {
        return getAlpha();
    }

    public final BitmapScale component3() {
        return getScale();
    }

    public final QrColor component4() {
        return getColor();
    }

    public final QrBackground copy(Drawable drawable, float alpha, BitmapScale scale, QrColor color) {
        Intrinsics.checkNotNullParameter(scale, "scale");
        Intrinsics.checkNotNullParameter(color, RemoteMessageConst.Notification.COLOR);
        return new QrBackground(drawable, alpha, scale, color);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QrBackground)) {
            return false;
        }
        QrBackground qrBackground = (QrBackground) other;
        return Intrinsics.areEqual(getDrawable(), qrBackground.getDrawable()) && Intrinsics.areEqual(Float.valueOf(getAlpha()), Float.valueOf(qrBackground.getAlpha())) && Intrinsics.areEqual(getScale(), qrBackground.getScale()) && Intrinsics.areEqual(getColor(), qrBackground.getColor());
    }

    public int hashCode() {
        return ((((((getDrawable() == null ? 0 : getDrawable().hashCode()) * 31) + Float.hashCode(getAlpha())) * 31) + getScale().hashCode()) * 31) + getColor().hashCode();
    }

    public String toString() {
        return "QrBackground(drawable=" + getDrawable() + ", alpha=" + getAlpha() + ", scale=" + getScale() + ", color=" + getColor() + ')';
    }

    public QrBackground(Drawable drawable, float f, BitmapScale bitmapScale, QrColor qrColor) {
        Intrinsics.checkNotNullParameter(bitmapScale, "scale");
        Intrinsics.checkNotNullParameter(qrColor, RemoteMessageConst.Notification.COLOR);
        this.drawable = drawable;
        this.alpha = f;
        this.scale = bitmapScale;
        this.color = qrColor;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRBackground
    public Drawable getDrawable() {
        return this.drawable;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRBackground
    public float getAlpha() {
        return this.alpha;
    }

    public /* synthetic */ QrBackground(Drawable drawable, float f, BitmapScale.FitXY fitXY, QrColor.Solid solid, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : drawable, (i & 2) != 0 ? 1.0f : f, (i & 4) != 0 ? BitmapScale.FitXY.INSTANCE : fitXY, (i & 8) != 0 ? new QrColor.Solid(QrColorKt.Color(4294967295L)) : solid);
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRBackground
    public BitmapScale getScale() {
        return this.scale;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRBackground
    public QrColor getColor() {
        return this.color;
    }
}
