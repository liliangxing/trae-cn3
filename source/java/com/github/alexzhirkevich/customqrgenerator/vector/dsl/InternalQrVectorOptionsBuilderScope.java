package com.github.alexzhirkevich.customqrgenerator.vector.dsl;

import com.github.alexzhirkevich.customqrgenerator.QrErrorCorrectionLevel;
import com.github.alexzhirkevich.customqrgenerator.style.QrOffset;
import com.github.alexzhirkevich.customqrgenerator.style.QrShape;
import com.github.alexzhirkevich.customqrgenerator.vector.QrVectorOptions;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InternalQrVectorOptionsBuilderScope.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010 \u001a\u00020!2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\b%H\u0016J!\u0010&\u001a\u00020!2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\b%H\u0016J!\u0010(\u001a\u00020!2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\b%H\u0016J!\u0010*\u001a\u00020!2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\b%H\u0016J\u0018\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001aH\u0016J)\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\u00142\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\b%H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u001a8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u00062"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/InternalQrVectorOptionsBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrVectorOptionsBuilderScope;", "builder", "Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;)V", "getBuilder", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;", CustomDataTagHandler.VALUE_ATTRIBUTE, "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;", "codeShape", "getCodeShape", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;", "setCodeShape", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;)V", "Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;", "errorCorrectionLevel", "getErrorCorrectionLevel", "()Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;", "setErrorCorrectionLevel", "(Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;)V", "", "fourthEyeEnabled", "getFourthEyeEnabled", "()Z", "setFourthEyeEnabled", "(Z)V", "", "padding", "getPadding", "()F", "setPadding", "(F)V", "background", "", "block", "Lkotlin/Function1;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrVectorBackgroundBuilderScope;", "Lkotlin/ExtensionFunctionType;", "colors", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrVectorColorsBuilderScope;", "highlighting", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrHighlightingBuilderScope;", "logo", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrVectorLogoBuilderScope;", "offset", "x", "y", "shapes", "centralSymmetry", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrVectorShapesBuilderScope;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class InternalQrVectorOptionsBuilderScope implements QrVectorOptionsBuilderScope {
    private final QrVectorOptions.Builder builder;

    public InternalQrVectorOptionsBuilderScope(QrVectorOptions.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
    }

    public final QrVectorOptions.Builder getBuilder() {
        return this.builder;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorOptionsBuilderScope
    public float getPadding() {
        return this.builder.getPadding();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorOptionsBuilderScope
    public void setPadding(float f) {
        this.builder.setPadding(f);
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorOptionsBuilderScope
    public QrErrorCorrectionLevel getErrorCorrectionLevel() {
        return this.builder.getErrorCorrectionLevel();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorOptionsBuilderScope
    public void setErrorCorrectionLevel(QrErrorCorrectionLevel qrErrorCorrectionLevel) {
        Intrinsics.checkNotNullParameter(qrErrorCorrectionLevel, CustomDataTagHandler.VALUE_ATTRIBUTE);
        this.builder.setErrorCorrectionLevel(qrErrorCorrectionLevel);
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorOptionsBuilderScope
    public QrShape getCodeShape() {
        return this.builder.getShape();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorOptionsBuilderScope
    public void setCodeShape(QrShape qrShape) {
        Intrinsics.checkNotNullParameter(qrShape, CustomDataTagHandler.VALUE_ATTRIBUTE);
        this.builder.setCodeShape(qrShape);
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorOptionsBuilderScope
    public boolean getFourthEyeEnabled() {
        return this.builder.getFourthEyeEnabled();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorOptionsBuilderScope
    public void setFourthEyeEnabled(boolean z) {
        this.builder.setFourthEyeEnabled(z);
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorOptionsBuilderScope
    public void offset(float x, float y) {
        this.builder.setOffset(new QrOffset(x, y));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorOptionsBuilderScope
    public void shapes(boolean centralSymmetry, Function1<? super QrVectorShapesBuilderScope, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(new InternalQrVectorShapesBuilderScope(this.builder, centralSymmetry));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorOptionsBuilderScope
    public void colors(Function1<? super QrVectorColorsBuilderScope, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(new InternalQrVectorColorsBuilderScope(this.builder));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorOptionsBuilderScope
    public void background(Function1<? super QrVectorBackgroundBuilderScope, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(new InternalQrVectorBackgroundBuilderScope(this.builder));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorOptionsBuilderScope
    public void logo(Function1<? super QrVectorLogoBuilderScope, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(new InternalQrVectorLogoBuilderScope(this.builder));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorOptionsBuilderScope
    public void highlighting(Function1<? super QrHighlightingBuilderScope, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(new InternalQrHighlightingBuilderScope(this.builder));
    }
}
