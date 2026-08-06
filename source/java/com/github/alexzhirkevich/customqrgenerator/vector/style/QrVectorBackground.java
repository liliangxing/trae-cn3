package com.github.alexzhirkevich.customqrgenerator.vector.style;

import android.graphics.drawable.Drawable;
import com.github.alexzhirkevich.customqrgenerator.style.BitmapScale;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrVectorBackground.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBackground;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/IQrVectorBackground;", "drawable", "Landroid/graphics/drawable/Drawable;", "scale", "Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", RemoteMessageConst.Notification.COLOR, "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "(Landroid/graphics/drawable/Drawable;Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;)V", "getColor", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getScale", "()Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final /* data */ class QrVectorBackground implements IQrVectorBackground {
    private final QrVectorColor color;
    private final Drawable drawable;
    private final BitmapScale scale;

    public QrVectorBackground() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ QrVectorBackground copy$default(QrVectorBackground qrVectorBackground, Drawable drawable, BitmapScale bitmapScale, QrVectorColor qrVectorColor, int i, Object obj) {
        if ((i & 1) != 0) {
            drawable = qrVectorBackground.getDrawable();
        }
        if ((i & 2) != 0) {
            bitmapScale = qrVectorBackground.getScale();
        }
        if ((i & 4) != 0) {
            qrVectorColor = qrVectorBackground.getColor();
        }
        return qrVectorBackground.copy(drawable, bitmapScale, qrVectorColor);
    }

    public final Drawable component1() {
        return getDrawable();
    }

    public final BitmapScale component2() {
        return getScale();
    }

    public final QrVectorColor component3() {
        return getColor();
    }

    public final QrVectorBackground copy(Drawable drawable, BitmapScale scale, QrVectorColor color) {
        Intrinsics.checkNotNullParameter(scale, "scale");
        Intrinsics.checkNotNullParameter(color, RemoteMessageConst.Notification.COLOR);
        return new QrVectorBackground(drawable, scale, color);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QrVectorBackground)) {
            return false;
        }
        QrVectorBackground qrVectorBackground = (QrVectorBackground) other;
        return Intrinsics.areEqual(getDrawable(), qrVectorBackground.getDrawable()) && Intrinsics.areEqual(getScale(), qrVectorBackground.getScale()) && Intrinsics.areEqual(getColor(), qrVectorBackground.getColor());
    }

    public int hashCode() {
        return ((((getDrawable() == null ? 0 : getDrawable().hashCode()) * 31) + getScale().hashCode()) * 31) + getColor().hashCode();
    }

    public String toString() {
        return "QrVectorBackground(drawable=" + getDrawable() + ", scale=" + getScale() + ", color=" + getColor() + ')';
    }

    public QrVectorBackground(Drawable drawable, BitmapScale bitmapScale, QrVectorColor qrVectorColor) {
        Intrinsics.checkNotNullParameter(bitmapScale, "scale");
        Intrinsics.checkNotNullParameter(qrVectorColor, RemoteMessageConst.Notification.COLOR);
        this.drawable = drawable;
        this.scale = bitmapScale;
        this.color = qrVectorColor;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorBackground
    public Drawable getDrawable() {
        return this.drawable;
    }

    public /* synthetic */ QrVectorBackground(Drawable drawable, BitmapScale.FitXY fitXY, QrVectorColor.Transparent transparent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : drawable, (i & 2) != 0 ? BitmapScale.FitXY.INSTANCE : fitXY, (i & 4) != 0 ? QrVectorColor.Transparent.INSTANCE : transparent);
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorBackground
    public BitmapScale getScale() {
        return this.scale;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorBackground
    public QrVectorColor getColor() {
        return this.color;
    }
}
