package com.github.alexzhirkevich.customqrgenerator.dsl;

import com.github.alexzhirkevich.customqrgenerator.QrErrorCorrectionLevel;
import com.github.alexzhirkevich.customqrgenerator.QrOptions;
import com.github.alexzhirkevich.customqrgenerator.style.QrShape;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import com.lynx.tasm.animation.AnimationConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;

/* compiled from: QrOptionsBuilderScope.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u001f\u001a\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020 0\"¢\u0006\u0002\b$H\u0016J!\u0010%\u001a\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020 0\"¢\u0006\u0002\b$H\u0016J!\u0010'\u001a\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020 0\"¢\u0006\u0002\b$H\u0016J!\u0010)\u001a\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020 0\"¢\u0006\u0002\b$H\u0016J!\u0010+\u001a\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020 0\"¢\u0006\u0002\b$H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011*\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00168V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\u001a\u0004\b\u001e\u0010\u0011*\u0004\b\u001d\u0010\u000f¨\u0006-"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/dsl/InternalQrOptionsBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrOptionsBuilderScope;", "builder", "Lcom/github/alexzhirkevich/customqrgenerator/QrOptions$Builder;", "(Lcom/github/alexzhirkevich/customqrgenerator/QrOptions$Builder;)V", CustomDataTagHandler.VALUE_ATTRIBUTE, "Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;", "errorCorrectionLevel", "getErrorCorrectionLevel", "()Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;", "setErrorCorrectionLevel", "(Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;)V", AnimationConstant.PROP_STR_HEIGHT, "", "getHeight$delegate", "(Lcom/github/alexzhirkevich/customqrgenerator/dsl/InternalQrOptionsBuilderScope;)Ljava/lang/Object;", "getHeight", "()I", "padding", "", "getPadding", "()F", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;", "shape", "getShape", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;", "setShape", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;)V", AnimationConstant.PROP_STR_WIDTH, "getWidth$delegate", "getWidth", "background", "", "block", "Lkotlin/Function1;", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrBackgroundBuilderScope;", "Lkotlin/ExtensionFunctionType;", "colors", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrColorsBuilderScope;", "logo", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrLogoBuilderScope;", "offset", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrOffsetBuilderScope;", "shapes", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrElementsShapesBuilderScope;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
final class InternalQrOptionsBuilderScope implements QrOptionsBuilderScope {
    private final QrOptions.Builder builder;

    public InternalQrOptionsBuilderScope(QrOptions.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrOptionsBuilderScope
    public void offset(Function1<? super QrOffsetBuilderScope, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(new InternalQrOffsetBuilderScope(this.builder));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrOptionsBuilderScope
    public void logo(Function1<? super QrLogoBuilderScope, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        QrOptions.Builder builder = this.builder;
        block.invoke(new InternalQrLogoBuilderScope(builder, builder.getWidth(), this.builder.getHeight(), 0.0f, 8, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrOptionsBuilderScope
    public void background(Function1<? super QrBackgroundBuilderScope, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(new InternalQrBackgroundBuilderScope(this.builder));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrOptionsBuilderScope
    public void colors(Function1<? super QrColorsBuilderScope, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(new InternalColorsBuilderScope(this.builder));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrOptionsBuilderScope
    public void shapes(Function1<? super QrElementsShapesBuilderScope, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(new InternalQrElementsShapesBuilderScope(this.builder));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrOptionsBuilderScope
    public QrShape getShape() {
        return this.builder.getCodeShape();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrOptionsBuilderScope
    public void setShape(QrShape qrShape) {
        Intrinsics.checkNotNullParameter(qrShape, CustomDataTagHandler.VALUE_ATTRIBUTE);
        this.builder.codeShape(qrShape);
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrOptionsBuilderScope
    public float getPadding() {
        return this.builder.getPadding();
    }

    public static Object getWidth$delegate(InternalQrOptionsBuilderScope internalQrOptionsBuilderScope) {
        Intrinsics.checkNotNullParameter(internalQrOptionsBuilderScope, "<this>");
        return Reflection.property0(new PropertyReference0Impl(internalQrOptionsBuilderScope.builder, QrOptions.Builder.class, AnimationConstant.PROP_STR_WIDTH, "getWidth()I", 0));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrOptionsBuilderScope
    public int getWidth() {
        return this.builder.getWidth();
    }

    public static Object getHeight$delegate(InternalQrOptionsBuilderScope internalQrOptionsBuilderScope) {
        Intrinsics.checkNotNullParameter(internalQrOptionsBuilderScope, "<this>");
        return Reflection.property0(new PropertyReference0Impl(internalQrOptionsBuilderScope.builder, QrOptions.Builder.class, AnimationConstant.PROP_STR_HEIGHT, "getHeight()I", 0));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrOptionsBuilderScope
    public int getHeight() {
        return this.builder.getHeight();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrOptionsBuilderScope
    public QrErrorCorrectionLevel getErrorCorrectionLevel() {
        return this.builder.getErrorCorrectionLevel();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrOptionsBuilderScope
    public void setErrorCorrectionLevel(QrErrorCorrectionLevel qrErrorCorrectionLevel) {
        Intrinsics.checkNotNullParameter(qrErrorCorrectionLevel, CustomDataTagHandler.VALUE_ATTRIBUTE);
        this.builder.errorCorrectionLevel(qrErrorCorrectionLevel);
    }
}
