package com.github.alexzhirkevich.customqrgenerator.dsl;

import android.graphics.drawable.Drawable;
import com.github.alexzhirkevich.customqrgenerator.style.BitmapScale;
import com.github.alexzhirkevich.customqrgenerator.style.IQRLogo;
import com.github.alexzhirkevich.customqrgenerator.style.QrColor;
import com.github.alexzhirkevich.customqrgenerator.style.QrLogoPadding;
import com.github.alexzhirkevich.customqrgenerator.style.QrLogoShape;
import kotlin.Metadata;

/* compiled from: QrLogoBuilderScope.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u00020\u001bX¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u00020!X¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u0082\u0001\u0001&¨\u0006'"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrLogoBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/style/IQRLogo;", "backgroundColor", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "getBackgroundColor", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "setBackgroundColor", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;)V", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "padding", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoPadding;", "getPadding", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoPadding;", "setPadding", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoPadding;)V", "scale", "Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "getScale", "()Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "setScale", "(Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;)V", "shape", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoShape;", "getShape", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoShape;", "setShape", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoShape;)V", "size", "", "getSize", "()F", "setSize", "(F)V", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/InternalQrLogoBuilderScope;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface QrLogoBuilderScope extends IQRLogo {
    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRLogo
    QrColor getBackgroundColor();

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRLogo
    Drawable getDrawable();

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRLogo
    QrLogoPadding getPadding();

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRLogo
    BitmapScale getScale();

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRLogo
    QrLogoShape getShape();

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRLogo
    float getSize();

    void setBackgroundColor(QrColor qrColor);

    void setDrawable(Drawable drawable);

    void setPadding(QrLogoPadding qrLogoPadding);

    void setScale(BitmapScale bitmapScale);

    void setShape(QrLogoShape qrLogoShape);

    void setSize(float f);
}
