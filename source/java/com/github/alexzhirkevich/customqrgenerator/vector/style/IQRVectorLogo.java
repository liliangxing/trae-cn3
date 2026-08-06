package com.github.alexzhirkevich.customqrgenerator.vector.style;

import android.graphics.drawable.Drawable;
import com.github.alexzhirkevich.customqrgenerator.style.BitmapScale;
import kotlin.Metadata;

/* compiled from: QrVectorLogo.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/IQRVectorLogo;", "", "backgroundColor", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "getBackgroundColor", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "padding", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding;", "getPadding", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding;", "scale", "Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "getScale", "()Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "shape", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape;", "getShape", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape;", "size", "", "getSize", "()F", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface IQRVectorLogo {
    QrVectorColor getBackgroundColor();

    Drawable getDrawable();

    QrVectorLogoPadding getPadding();

    BitmapScale getScale();

    QrVectorLogoShape getShape();

    float getSize();
}
