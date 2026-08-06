package com.github.alexzhirkevich.customqrgenerator.dsl;

import android.graphics.drawable.Drawable;
import com.github.alexzhirkevich.customqrgenerator.QrOptions;
import com.github.alexzhirkevich.customqrgenerator.style.BitmapScale;
import com.github.alexzhirkevich.customqrgenerator.style.QrColor;
import com.github.alexzhirkevich.customqrgenerator.style.QrLogo;
import com.github.alexzhirkevich.customqrgenerator.style.QrLogoPadding;
import com.github.alexzhirkevich.customqrgenerator.style.QrLogoShape;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import com.lynx.tasm.animation.AnimationConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrLogoBuilderScope.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R(\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u00158V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u001d8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u00020#2\u0006\u0010\n\u001a\u00020#8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010*\u001a\u00020)2\u0006\u0010\n\u001a\u00020)8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b0\u0010\u0014\"\u0004\b1\u00102R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001c¨\u00064"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/dsl/InternalQrLogoBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrLogoBuilderScope;", "builder", "Lcom/github/alexzhirkevich/customqrgenerator/QrOptions$Builder;", AnimationConstant.PROP_STR_WIDTH, "", AnimationConstant.PROP_STR_HEIGHT, "codePadding", "", "(Lcom/github/alexzhirkevich/customqrgenerator/QrOptions$Builder;IIF)V", CustomDataTagHandler.VALUE_ATTRIBUTE, "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "backgroundColor", "getBackgroundColor", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "setBackgroundColor", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;)V", "getBuilder", "()Lcom/github/alexzhirkevich/customqrgenerator/QrOptions$Builder;", "getCodePadding", "()F", "Landroid/graphics/drawable/Drawable;", "drawable", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "getHeight", "()I", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoPadding;", "padding", "getPadding", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoPadding;", "setPadding", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoPadding;)V", "Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "scale", "getScale", "()Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "setScale", "(Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;)V", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoShape;", "shape", "getShape", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoShape;", "setShape", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoShape;)V", "size", "getSize", "setSize", "(F)V", "getWidth", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class InternalQrLogoBuilderScope implements QrLogoBuilderScope {
    private final QrOptions.Builder builder;
    private final float codePadding;
    private final int height;
    private final int width;

    public InternalQrLogoBuilderScope(QrOptions.Builder builder, int i, int i2, float f) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.width = i;
        this.height = i2;
        this.codePadding = f;
    }

    public /* synthetic */ InternalQrLogoBuilderScope(QrOptions.Builder builder, int i, int i2, float f, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder, i, i2, (i3 & 8) != 0 ? -1.0f : f);
    }

    public final QrOptions.Builder getBuilder() {
        return this.builder;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final float getCodePadding() {
        return this.codePadding;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrLogoBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQRLogo
    public Drawable getDrawable() {
        return this.builder.getLogo().getDrawable();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrLogoBuilderScope
    public void setDrawable(Drawable drawable) {
        QrOptions.Builder builder = this.builder;
        builder.setLogo$custom_qr_generator_release(QrLogo.copy$default(builder.getLogo(), drawable, 0.0f, null, null, null, null, 62, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrLogoBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQRLogo
    public float getSize() {
        return this.builder.getLogo().getSize();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrLogoBuilderScope
    public void setSize(float f) {
        QrOptions.Builder builder = this.builder;
        builder.setLogo$custom_qr_generator_release(QrLogo.copy$default(builder.getLogo(), null, f, null, null, null, null, 61, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrLogoBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQRLogo
    public QrLogoPadding getPadding() {
        return this.builder.getLogo().getPadding();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrLogoBuilderScope
    public void setPadding(QrLogoPadding qrLogoPadding) {
        Intrinsics.checkNotNullParameter(qrLogoPadding, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrOptions.Builder builder = this.builder;
        builder.setLogo$custom_qr_generator_release(QrLogo.copy$default(builder.getLogo(), null, 0.0f, qrLogoPadding, null, null, null, 59, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrLogoBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQRLogo
    public QrLogoShape getShape() {
        return this.builder.getLogo().getShape();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrLogoBuilderScope
    public void setShape(QrLogoShape qrLogoShape) {
        Intrinsics.checkNotNullParameter(qrLogoShape, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrOptions.Builder builder = this.builder;
        builder.setLogo$custom_qr_generator_release(QrLogo.copy$default(builder.getLogo(), null, 0.0f, null, qrLogoShape, null, null, 55, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrLogoBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQRLogo
    public BitmapScale getScale() {
        return this.builder.getLogo().getScale();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrLogoBuilderScope
    public void setScale(BitmapScale bitmapScale) {
        Intrinsics.checkNotNullParameter(bitmapScale, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrOptions.Builder builder = this.builder;
        builder.setLogo$custom_qr_generator_release(QrLogo.copy$default(builder.getLogo(), null, 0.0f, null, null, bitmapScale, null, 47, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrLogoBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQRLogo
    public QrColor getBackgroundColor() {
        return this.builder.getLogo().getBackgroundColor();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrLogoBuilderScope
    public void setBackgroundColor(QrColor qrColor) {
        Intrinsics.checkNotNullParameter(qrColor, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrOptions.Builder builder = this.builder;
        builder.setLogo$custom_qr_generator_release(QrLogo.copy$default(builder.getLogo(), null, 0.0f, null, null, null, qrColor, 31, null));
    }
}
