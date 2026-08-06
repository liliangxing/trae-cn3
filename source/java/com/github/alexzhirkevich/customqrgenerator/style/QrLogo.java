package com.github.alexzhirkevich.customqrgenerator.style;

import android.graphics.drawable.Drawable;
import com.bytedance.forest.model.PreloadConfig;
import com.github.alexzhirkevich.customqrgenerator.style.BitmapScale;
import com.github.alexzhirkevich.customqrgenerator.style.QrColor;
import com.github.alexzhirkevich.customqrgenerator.style.QrLogoPadding;
import com.github.alexzhirkevich.customqrgenerator.style.QrLogoShape;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrLogo.kt */
@Deprecated(message = "Use QrCodeDrawable with QrVectorLogo instead")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003JG\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006*"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogo;", "Lcom/github/alexzhirkevich/customqrgenerator/style/IQRLogo;", "drawable", "Landroid/graphics/drawable/Drawable;", "size", "", "padding", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoPadding;", "shape", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoShape;", "scale", "Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "backgroundColor", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "(Landroid/graphics/drawable/Drawable;FLcom/github/alexzhirkevich/customqrgenerator/style/QrLogoPadding;Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoShape;Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;)V", "getBackgroundColor", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getPadding", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoPadding;", "getScale", "()Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "getShape", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoShape;", "getSize", "()F", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class QrLogo implements IQRLogo {
    private final QrColor backgroundColor;
    private final Drawable drawable;
    private final QrLogoPadding padding;
    private final BitmapScale scale;
    private final QrLogoShape shape;
    private final float size;

    public QrLogo() {
        this(null, 0.0f, null, null, null, null, 63, null);
    }

    public static /* synthetic */ QrLogo copy$default(QrLogo qrLogo, Drawable drawable, float f, QrLogoPadding qrLogoPadding, QrLogoShape qrLogoShape, BitmapScale bitmapScale, QrColor qrColor, int i, Object obj) {
        if ((i & 1) != 0) {
            drawable = qrLogo.getDrawable();
        }
        if ((i & 2) != 0) {
            f = qrLogo.getSize();
        }
        float f2 = f;
        if ((i & 4) != 0) {
            qrLogoPadding = qrLogo.getPadding();
        }
        QrLogoPadding qrLogoPadding2 = qrLogoPadding;
        if ((i & 8) != 0) {
            qrLogoShape = qrLogo.getShape();
        }
        QrLogoShape qrLogoShape2 = qrLogoShape;
        if ((i & 16) != 0) {
            bitmapScale = qrLogo.getScale();
        }
        BitmapScale bitmapScale2 = bitmapScale;
        if ((i & 32) != 0) {
            qrColor = qrLogo.getBackgroundColor();
        }
        return qrLogo.copy(drawable, f2, qrLogoPadding2, qrLogoShape2, bitmapScale2, qrColor);
    }

    public final Drawable component1() {
        return getDrawable();
    }

    public final float component2() {
        return getSize();
    }

    public final QrLogoPadding component3() {
        return getPadding();
    }

    public final QrLogoShape component4() {
        return getShape();
    }

    public final BitmapScale component5() {
        return getScale();
    }

    public final QrColor component6() {
        return getBackgroundColor();
    }

    public final QrLogo copy(Drawable drawable, float size, QrLogoPadding padding, QrLogoShape shape, BitmapScale scale, QrColor backgroundColor) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(scale, "scale");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        return new QrLogo(drawable, size, padding, shape, scale, backgroundColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QrLogo)) {
            return false;
        }
        QrLogo qrLogo = (QrLogo) other;
        return Intrinsics.areEqual(getDrawable(), qrLogo.getDrawable()) && Intrinsics.areEqual((Object) Float.valueOf(getSize()), (Object) Float.valueOf(qrLogo.getSize())) && Intrinsics.areEqual(getPadding(), qrLogo.getPadding()) && Intrinsics.areEqual(getShape(), qrLogo.getShape()) && Intrinsics.areEqual(getScale(), qrLogo.getScale()) && Intrinsics.areEqual(getBackgroundColor(), qrLogo.getBackgroundColor());
    }

    public int hashCode() {
        return ((((((((((getDrawable() == null ? 0 : getDrawable().hashCode()) * 31) + Float.hashCode(getSize())) * 31) + getPadding().hashCode()) * 31) + getShape().hashCode()) * 31) + getScale().hashCode()) * 31) + getBackgroundColor().hashCode();
    }

    public String toString() {
        return "QrLogo(drawable=" + getDrawable() + ", size=" + getSize() + ", padding=" + getPadding() + ", shape=" + getShape() + ", scale=" + getScale() + ", backgroundColor=" + getBackgroundColor() + ')';
    }

    public QrLogo(Drawable drawable, float f, QrLogoPadding padding, QrLogoShape shape, BitmapScale scale, QrColor backgroundColor) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(scale, "scale");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        this.drawable = drawable;
        this.size = f;
        this.padding = padding;
        this.shape = shape;
        this.scale = scale;
        this.backgroundColor = backgroundColor;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRLogo
    public Drawable getDrawable() {
        return this.drawable;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRLogo
    public float getSize() {
        return this.size;
    }

    public /* synthetic */ QrLogo(Drawable drawable, float f, QrLogoPadding.Empty empty, QrLogoShape.Default r8, BitmapScale.FitXY fitXY, QrColor.Unspecified unspecified, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : drawable, (i & 2) != 0 ? 0.2f : f, (i & 4) != 0 ? QrLogoPadding.Empty.INSTANCE : empty, (i & 8) != 0 ? QrLogoShape.Default.INSTANCE : r8, (i & 16) != 0 ? BitmapScale.FitXY.INSTANCE : fitXY, (i & 32) != 0 ? QrColor.Unspecified.INSTANCE : unspecified);
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRLogo
    public QrLogoPadding getPadding() {
        return this.padding;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRLogo
    public QrLogoShape getShape() {
        return this.shape;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRLogo
    public BitmapScale getScale() {
        return this.scale;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRLogo
    public QrColor getBackgroundColor() {
        return this.backgroundColor;
    }
}
