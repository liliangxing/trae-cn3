package com.github.alexzhirkevich.customqrgenerator.vector.dsl;

import android.graphics.drawable.Drawable;
import com.github.alexzhirkevich.customqrgenerator.style.BitmapScale;
import com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorBackground;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;

/* compiled from: QrVectorBackgroundBuilderScope.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u0082\u0001\u0001\u0014¨\u0006\u0015"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrVectorBackgroundBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/IQrVectorBackground;", RemoteMessageConst.Notification.COLOR, "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "getColor", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "setColor", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;)V", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "scale", "Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "getScale", "()Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "setScale", "(Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;)V", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/InternalQrVectorBackgroundBuilderScope;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface QrVectorBackgroundBuilderScope extends IQrVectorBackground {
    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorBackground
    QrVectorColor getColor();

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorBackground
    Drawable getDrawable();

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorBackground
    BitmapScale getScale();

    void setColor(QrVectorColor qrVectorColor);

    void setDrawable(Drawable drawable);

    void setScale(BitmapScale bitmapScale);
}
