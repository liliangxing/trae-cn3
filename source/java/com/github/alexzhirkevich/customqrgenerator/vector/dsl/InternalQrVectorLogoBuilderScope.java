package com.github.alexzhirkevich.customqrgenerator.vector.dsl;

import android.graphics.drawable.Drawable;
import com.github.alexzhirkevich.customqrgenerator.style.BitmapScale;
import com.github.alexzhirkevich.customqrgenerator.vector.QrVectorOptions;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorLogo;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorLogoPadding;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorLogoShape;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InternalQrVectorLogoBuilderScope.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u001a8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020 8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020&8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/InternalQrVectorLogoBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrVectorLogoBuilderScope;", "builder", "Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;)V", CustomDataTagHandler.VALUE_ATTRIBUTE, "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "backgroundColor", "getBackgroundColor", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "setBackgroundColor", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;)V", "getBuilder", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;", "Landroid/graphics/drawable/Drawable;", "drawable", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding;", "padding", "getPadding", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding;", "setPadding", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding;)V", "Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "scale", "getScale", "()Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "setScale", "(Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;)V", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape;", "shape", "getShape", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape;", "setShape", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape;)V", "", "size", "getSize", "()F", "setSize", "(F)V", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class InternalQrVectorLogoBuilderScope implements QrVectorLogoBuilderScope {
    private final QrVectorOptions.Builder builder;

    public InternalQrVectorLogoBuilderScope(QrVectorOptions.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
    }

    public final QrVectorOptions.Builder getBuilder() {
        return this.builder;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorLogoBuilderScope, com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
    public Drawable getDrawable() {
        return this.builder.getLogo().getDrawable();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorLogoBuilderScope
    public void setDrawable(Drawable drawable) {
        QrVectorOptions.Builder builder = this.builder;
        builder.setLogo(QrVectorLogo.copy$default(builder.getLogo(), drawable, 0.0f, null, null, null, null, 62, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorLogoBuilderScope, com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
    public float getSize() {
        return this.builder.getLogo().getSize();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorLogoBuilderScope
    public void setSize(float f) {
        QrVectorOptions.Builder builder = this.builder;
        builder.setLogo(QrVectorLogo.copy$default(builder.getLogo(), null, f, null, null, null, null, 61, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorLogoBuilderScope, com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
    public QrVectorLogoPadding getPadding() {
        return this.builder.getLogo().getPadding();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorLogoBuilderScope
    public void setPadding(QrVectorLogoPadding qrVectorLogoPadding) {
        Intrinsics.checkNotNullParameter(qrVectorLogoPadding, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrVectorOptions.Builder builder = this.builder;
        builder.setLogo(QrVectorLogo.copy$default(builder.getLogo(), null, 0.0f, qrVectorLogoPadding, null, null, null, 59, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorLogoBuilderScope, com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
    public QrVectorLogoShape getShape() {
        return this.builder.getLogo().getShape();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorLogoBuilderScope
    public void setShape(QrVectorLogoShape qrVectorLogoShape) {
        Intrinsics.checkNotNullParameter(qrVectorLogoShape, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrVectorOptions.Builder builder = this.builder;
        builder.setLogo(QrVectorLogo.copy$default(builder.getLogo(), null, 0.0f, null, qrVectorLogoShape, null, null, 55, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorLogoBuilderScope, com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
    public BitmapScale getScale() {
        return this.builder.getLogo().getScale();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorLogoBuilderScope
    public void setScale(BitmapScale bitmapScale) {
        Intrinsics.checkNotNullParameter(bitmapScale, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrVectorOptions.Builder builder = this.builder;
        builder.setLogo(QrVectorLogo.copy$default(builder.getLogo(), null, 0.0f, null, null, bitmapScale, null, 47, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorLogoBuilderScope, com.github.alexzhirkevich.customqrgenerator.vector.style.IQRVectorLogo
    public QrVectorColor getBackgroundColor() {
        return this.builder.getLogo().getBackgroundColor();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorLogoBuilderScope
    public void setBackgroundColor(QrVectorColor qrVectorColor) {
        Intrinsics.checkNotNullParameter(qrVectorColor, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrVectorOptions.Builder builder = this.builder;
        builder.setLogo(QrVectorLogo.copy$default(builder.getLogo(), null, 0.0f, null, null, null, qrVectorColor, 31, null));
    }
}
