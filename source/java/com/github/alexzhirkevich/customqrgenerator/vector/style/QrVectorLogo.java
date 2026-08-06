package com.github.alexzhirkevich.customqrgenerator.vector.style;

import android.graphics.drawable.Drawable;
import com.github.alexzhirkevich.customqrgenerator.style.BitmapScale;
import com.github.alexzhirkevich.customqrgenerator.style.EmptyDrawable;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorLogoPadding;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorLogoShape;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrVectorLogo.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001*BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003JG\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006+"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogo;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/IQRVectorLogo;", "drawable", "Landroid/graphics/drawable/Drawable;", "size", "", "padding", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding;", "shape", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape;", "scale", "Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "backgroundColor", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "(Landroid/graphics/drawable/Drawable;FLcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding;Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape;Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;)V", "getBackgroundColor", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getPadding", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding;", "getScale", "()Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "getShape", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape;", "getSize", "()F", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Builder", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final /* data */ class QrVectorLogo implements IQRVectorLogo {
    private final QrVectorColor backgroundColor;
    private final Drawable drawable;
    private final QrVectorLogoPadding padding;
    private final BitmapScale scale;
    private final QrVectorLogoShape shape;
    private final float size;

    public QrVectorLogo() {
        this(null, 0.0f, null, null, null, null, 63, null);
    }

    public static /* synthetic */ QrVectorLogo copy$default(QrVectorLogo qrVectorLogo, Drawable drawable, float f, QrVectorLogoPadding qrVectorLogoPadding, QrVectorLogoShape qrVectorLogoShape, BitmapScale bitmapScale, QrVectorColor qrVectorColor, int i, Object obj) {
        if ((i & 1) != 0) {
            drawable = qrVectorLogo.getDrawable();
        }
        if ((i & 2) != 0) {
            f = qrVectorLogo.getSize();
        }
        float f2 = f;
        if ((i & 4) != 0) {
            qrVectorLogoPadding = qrVectorLogo.getPadding();
        }
        QrVectorLogoPadding qrVectorLogoPadding2 = qrVectorLogoPadding;
        if ((i & 8) != 0) {
            qrVectorLogoShape = qrVectorLogo.getShape();
        }
        QrVectorLogoShape qrVectorLogoShape2 = qrVectorLogoShape;
        if ((i & 16) != 0) {
            bitmapScale = qrVectorLogo.getScale();
        }
        BitmapScale bitmapScale2 = bitmapScale;
        if ((i & 32) != 0) {
            qrVectorColor = qrVectorLogo.getBackgroundColor();
        }
        return qrVectorLogo.copy(drawable, f2, qrVectorLogoPadding2, qrVectorLogoShape2, bitmapScale2, qrVectorColor);
    }

    public final Drawable component1() {
        return getDrawable();
    }

    public final float component2() {
        return getSize();
    }

    public final QrVectorLogoPadding component3() {
        return getPadding();
    }

    public final QrVectorLogoShape component4() {
        return getShape();
    }

    public final BitmapScale component5() {
        return getScale();
    }

    public final QrVectorColor component6() {
        return getBackgroundColor();
    }

    public final QrVectorLogo copy(Drawable drawable, float size, QrVectorLogoPadding padding, QrVectorLogoShape shape, BitmapScale scale, QrVectorColor backgroundColor) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(scale, "scale");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        return new QrVectorLogo(drawable, size, padding, shape, scale, backgroundColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QrVectorLogo)) {
            return false;
        }
        QrVectorLogo qrVectorLogo = (QrVectorLogo) other;
        return Intrinsics.areEqual(getDrawable(), qrVectorLogo.getDrawable()) && Intrinsics.areEqual(Float.valueOf(getSize()), Float.valueOf(qrVectorLogo.getSize())) && Intrinsics.areEqual(getPadding(), qrVectorLogo.getPadding()) && Intrinsics.areEqual(getShape(), qrVectorLogo.getShape()) && Intrinsics.areEqual(getScale(), qrVectorLogo.getScale()) && Intrinsics.areEqual(getBackgroundColor(), qrVectorLogo.getBackgroundColor());
    }

    public int hashCode() {
        return ((((((((((getDrawable() == null ? 0 : getDrawable().hashCode()) * 31) + Float.hashCode(getSize())) * 31) + getPadding().hashCode()) * 31) + getShape().hashCode()) * 31) + getScale().hashCode()) * 31) + getBackgroundColor().hashCode();
    }

    public String toString() {
        return "QrVectorLogo(drawable=" + getDrawable() + ", size=" + getSize() + ", padding=" + getPadding() + ", shape=" + getShape() + ", scale=" + getScale() + ", backgroundColor=" + getBackgroundColor() + ')';
    }

    public QrVectorLogo(Drawable drawable, float f, QrVectorLogoPadding qrVectorLogoPadding, QrVectorLogoShape qrVectorLogoShape, BitmapScale bitmapScale, QrVectorColor qrVectorColor) {
        Intrinsics.checkNotNullParameter(qrVectorLogoPadding, "padding");
        Intrinsics.checkNotNullParameter(qrVectorLogoShape, "shape");
        Intrinsics.checkNotNullParameter(bitmapScale, "scale");
        Intrinsics.checkNotNullParameter(qrVectorColor, "backgroundColor");
        this.drawable = drawable;
        this.size = f;
        this.padding = qrVectorLogoPadding;
        this.shape = qrVectorLogoShape;
        this.scale = bitmapScale;
        this.backgroundColor = qrVectorColor;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
    public Drawable getDrawable() {
        return this.drawable;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
    public float getSize() {
        return this.size;
    }

    public /* synthetic */ QrVectorLogo(Drawable drawable, float f, QrVectorLogoPadding.Empty empty, QrVectorLogoShape.Default r8, BitmapScale.FitXY fitXY, QrVectorColor.Unspecified unspecified, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : drawable, (i & 2) != 0 ? 0.2f : f, (i & 4) != 0 ? QrVectorLogoPadding.Empty.INSTANCE : empty, (i & 8) != 0 ? QrVectorLogoShape.Default.INSTANCE : r8, (i & 16) != 0 ? BitmapScale.FitXY.INSTANCE : fitXY, (i & 32) != 0 ? QrVectorColor.Unspecified.INSTANCE : unspecified);
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
    public QrVectorLogoPadding getPadding() {
        return this.padding;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
    public QrVectorLogoShape getShape() {
        return this.shape;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
    public BitmapScale getScale() {
        return this.scale;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
    public QrVectorColor getBackgroundColor() {
        return this.backgroundColor;
    }

    /* compiled from: QrVectorLogo.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0004J\u0006\u0010(\u001a\u00020)J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogo$Builder;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/IQRVectorLogo;", "()V", "backgroundColor", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "getBackgroundColor", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "setBackgroundColor", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;)V", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "padding", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding;", "getPadding", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding;", "setPadding", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding;)V", "scale", "Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "getScale", "()Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "setScale", "(Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;)V", "shape", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape;", "getShape", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape;", "setShape", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape;)V", "size", "", "getSize", "()F", "setSize", "(F)V", RemoteMessageConst.Notification.COLOR, "build", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogo;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Builder implements IQRVectorLogo {
        private Drawable drawable = EmptyDrawable.INSTANCE;
        private float size = 0.2f;
        private QrVectorLogoPadding padding = QrVectorLogoPadding.Empty.INSTANCE;
        private QrVectorLogoShape shape = QrVectorLogoShape.Default.INSTANCE;
        private BitmapScale scale = BitmapScale.FitXY.INSTANCE;
        private QrVectorColor backgroundColor = QrVectorColor.Unspecified.INSTANCE;

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
        public Drawable getDrawable() {
            return this.drawable;
        }

        public void setDrawable(Drawable drawable) {
            Intrinsics.checkNotNullParameter(drawable, "<set-?>");
            this.drawable = drawable;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
        public float getSize() {
            return this.size;
        }

        public void setSize(float f) {
            this.size = f;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
        public QrVectorLogoPadding getPadding() {
            return this.padding;
        }

        public void setPadding(QrVectorLogoPadding qrVectorLogoPadding) {
            Intrinsics.checkNotNullParameter(qrVectorLogoPadding, "<set-?>");
            this.padding = qrVectorLogoPadding;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
        public QrVectorLogoShape getShape() {
            return this.shape;
        }

        public void setShape(QrVectorLogoShape qrVectorLogoShape) {
            Intrinsics.checkNotNullParameter(qrVectorLogoShape, "<set-?>");
            this.shape = qrVectorLogoShape;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
        public BitmapScale getScale() {
            return this.scale;
        }

        public void setScale(BitmapScale bitmapScale) {
            Intrinsics.checkNotNullParameter(bitmapScale, "<set-?>");
            this.scale = bitmapScale;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
        public QrVectorColor getBackgroundColor() {
            return this.backgroundColor;
        }

        public void setBackgroundColor(QrVectorColor qrVectorColor) {
            Intrinsics.checkNotNullParameter(qrVectorColor, "<set-?>");
            this.backgroundColor = qrVectorColor;
        }

        public final Builder drawable(Drawable drawable) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            setDrawable(drawable);
            return this;
        }

        public final Builder size(float size) {
            setSize(size);
            return this;
        }

        public final Builder padding(QrVectorLogoPadding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            setPadding(padding);
            return this;
        }

        public final Builder shape(QrVectorLogoShape shape) {
            Intrinsics.checkNotNullParameter(shape, "shape");
            setShape(shape);
            return this;
        }

        public final Builder scale(BitmapScale scale) {
            Intrinsics.checkNotNullParameter(scale, "scale");
            setScale(scale);
            return this;
        }

        public final Builder backgroundColor(QrVectorColor color) {
            Intrinsics.checkNotNullParameter(color, RemoteMessageConst.Notification.COLOR);
            setBackgroundColor(color);
            return this;
        }

        public final QrVectorLogo build() {
            return new QrVectorLogo(getDrawable(), getSize(), getPadding(), getShape(), getScale(), getBackgroundColor());
        }
    }
}
