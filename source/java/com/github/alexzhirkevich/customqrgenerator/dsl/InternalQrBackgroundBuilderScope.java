package com.github.alexzhirkevich.customqrgenerator.dsl;

import android.graphics.drawable.Drawable;
import com.github.alexzhirkevich.customqrgenerator.QrOptions;
import com.github.alexzhirkevich.customqrgenerator.style.BitmapScale;
import com.github.alexzhirkevich.customqrgenerator.style.QrBackground;
import com.github.alexzhirkevich.customqrgenerator.style.QrColor;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrBackgroundBuilderScope.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u001a8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/dsl/InternalQrBackgroundBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrBackgroundBuilderScope;", "builder", "Lcom/github/alexzhirkevich/customqrgenerator/QrOptions$Builder;", "(Lcom/github/alexzhirkevich/customqrgenerator/QrOptions$Builder;)V", CustomDataTagHandler.VALUE_ATTRIBUTE, "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "getBuilder", "()Lcom/github/alexzhirkevich/customqrgenerator/QrOptions$Builder;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", RemoteMessageConst.Notification.COLOR, "getColor", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "setColor", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "scale", "getScale", "()Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "setScale", "(Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;)V", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class InternalQrBackgroundBuilderScope implements QrBackgroundBuilderScope {
    private final QrOptions.Builder builder;

    public InternalQrBackgroundBuilderScope(QrOptions.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
    }

    public final QrOptions.Builder getBuilder() {
        return this.builder;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrBackgroundBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQRBackground
    public Drawable getDrawable() {
        return this.builder.getBackground().getDrawable();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrBackgroundBuilderScope
    public void setDrawable(Drawable drawable) {
        QrOptions.Builder builder = this.builder;
        builder.background(QrBackground.copy$default(builder.getBackground(), drawable, 0.0f, null, null, 14, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrBackgroundBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQRBackground
    public float getAlpha() {
        return this.builder.getBackground().getAlpha();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrBackgroundBuilderScope
    public void setAlpha(float f) {
        QrOptions.Builder builder = this.builder;
        builder.background(QrBackground.copy$default(builder.getBackground(), null, f, null, null, 13, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrBackgroundBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQRBackground
    public BitmapScale getScale() {
        return this.builder.getBackground().getScale();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrBackgroundBuilderScope
    public void setScale(BitmapScale bitmapScale) {
        Intrinsics.checkNotNullParameter(bitmapScale, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrOptions.Builder builder = this.builder;
        builder.background(QrBackground.copy$default(builder.getBackground(), null, 0.0f, bitmapScale, null, 11, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrBackgroundBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQRBackground
    public QrColor getColor() {
        return this.builder.getBackground().getColor();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrBackgroundBuilderScope
    public void setColor(QrColor qrColor) {
        Intrinsics.checkNotNullParameter(qrColor, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrOptions.Builder builder = this.builder;
        builder.background(QrBackground.copy$default(builder.getBackground(), null, 0.0f, null, qrColor, 7, null));
    }
}
