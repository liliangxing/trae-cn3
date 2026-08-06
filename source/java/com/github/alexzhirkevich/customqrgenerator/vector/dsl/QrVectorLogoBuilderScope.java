package com.github.alexzhirkevich.customqrgenerator.vector.dsl;

import android.graphics.drawable.Drawable;
import com.github.alexzhirkevich.customqrgenerator.style.BitmapScale;
import com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorLogoPadding;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorLogoShape;
import kotlin.Metadata;

/* compiled from: QrVectorLogoBuilderScope.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u00020\u001bX¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u00020!X¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u0082\u0001\u0001&¨\u0006'"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrVectorLogoBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/IQRVectorLogo;", "backgroundColor", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "getBackgroundColor", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "setBackgroundColor", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;)V", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "padding", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding;", "getPadding", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding;", "setPadding", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding;)V", "scale", "Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "getScale", "()Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "setScale", "(Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;)V", "shape", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape;", "getShape", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape;", "setShape", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape;)V", "size", "", "getSize", "()F", "setSize", "(F)V", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/InternalQrVectorLogoBuilderScope;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface QrVectorLogoBuilderScope extends IQRVectorLogo {
    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
    QrVectorColor getBackgroundColor();

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
    Drawable getDrawable();

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
    QrVectorLogoPadding getPadding();

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
    BitmapScale getScale();

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
    QrVectorLogoShape getShape();

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
    float getSize();

    void setBackgroundColor(QrVectorColor qrVectorColor);

    void setDrawable(Drawable drawable);

    void setPadding(QrVectorLogoPadding qrVectorLogoPadding);

    void setScale(BitmapScale bitmapScale);

    void setShape(QrVectorLogoShape qrVectorLogoShape);

    void setSize(float f);
}
