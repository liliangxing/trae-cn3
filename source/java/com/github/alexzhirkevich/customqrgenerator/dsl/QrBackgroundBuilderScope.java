package com.github.alexzhirkevich.customqrgenerator.dsl;

import android.graphics.drawable.Drawable;
import com.github.alexzhirkevich.customqrgenerator.style.BitmapScale;
import com.github.alexzhirkevich.customqrgenerator.style.IQRBackground;
import com.github.alexzhirkevich.customqrgenerator.style.QrColor;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;

/* compiled from: QrBackgroundBuilderScope.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u0082\u0001\u0001\u001a¨\u0006\u001b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrBackgroundBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/style/IQRBackground;", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", RemoteMessageConst.Notification.COLOR, "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "getColor", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "setColor", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;)V", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "scale", "Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "getScale", "()Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "setScale", "(Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;)V", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/InternalQrBackgroundBuilderScope;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface QrBackgroundBuilderScope extends IQRBackground {
    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRBackground
    float getAlpha();

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRBackground
    QrColor getColor();

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRBackground
    Drawable getDrawable();

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQRBackground
    BitmapScale getScale();

    void setAlpha(float f);

    void setColor(QrColor qrColor);

    void setDrawable(Drawable drawable);

    void setScale(BitmapScale bitmapScale);
}
