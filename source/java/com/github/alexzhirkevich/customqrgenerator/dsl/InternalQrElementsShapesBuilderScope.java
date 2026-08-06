package com.github.alexzhirkevich.customqrgenerator.dsl;

import com.github.alexzhirkevich.customqrgenerator.QrOptions;
import com.github.alexzhirkevich.customqrgenerator.style.QrBallShape;
import com.github.alexzhirkevich.customqrgenerator.style.QrElementsShapes;
import com.github.alexzhirkevich.customqrgenerator.style.QrFrameShape;
import com.github.alexzhirkevich.customqrgenerator.style.QrHighlightingShape;
import com.github.alexzhirkevich.customqrgenerator.style.QrPixelShape;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrElementsShapesBuilderScope.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u001a8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013¨\u0006#"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/dsl/InternalQrElementsShapesBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrElementsShapesBuilderScope;", "builder", "Lcom/github/alexzhirkevich/customqrgenerator/QrOptions$Builder;", "(Lcom/github/alexzhirkevich/customqrgenerator/QrOptions$Builder;)V", CustomDataTagHandler.VALUE_ATTRIBUTE, "Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape;", "ball", "getBall", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape;", "setBall", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape;)V", "getBuilder", "()Lcom/github/alexzhirkevich/customqrgenerator/QrOptions$Builder;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;", "darkPixel", "getDarkPixel", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;", "setDarkPixel", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;)V", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrFrameShape;", "frame", "getFrame", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrFrameShape;", "setFrame", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrFrameShape;)V", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrHighlightingShape;", "highlighting", "getHighlighting", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrHighlightingShape;", "setHighlighting", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrHighlightingShape;)V", "lightPixel", "getLightPixel", "setLightPixel", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class InternalQrElementsShapesBuilderScope implements QrElementsShapesBuilderScope {
    private final QrOptions.Builder builder;

    public InternalQrElementsShapesBuilderScope(QrOptions.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
    }

    public final QrOptions.Builder getBuilder() {
        return this.builder;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrElementsShapesBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQRElementsShapes
    public QrPixelShape getDarkPixel() {
        return this.builder.getElementsShapes().getDarkPixel();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrElementsShapesBuilderScope
    public void setDarkPixel(QrPixelShape qrPixelShape) {
        Intrinsics.checkNotNullParameter(qrPixelShape, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrOptions.Builder builder = this.builder;
        builder.shapes(QrElementsShapes.copy$default(builder.getElementsShapes(), qrPixelShape, null, null, null, null, 30, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrElementsShapesBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQRElementsShapes
    public QrPixelShape getLightPixel() {
        return this.builder.getElementsShapes().getLightPixel();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrElementsShapesBuilderScope
    public void setLightPixel(QrPixelShape qrPixelShape) {
        Intrinsics.checkNotNullParameter(qrPixelShape, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrOptions.Builder builder = this.builder;
        builder.shapes(QrElementsShapes.copy$default(builder.getElementsShapes(), null, qrPixelShape, null, null, null, 29, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrElementsShapesBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQRElementsShapes
    public QrFrameShape getFrame() {
        return this.builder.getElementsShapes().getFrame();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrElementsShapesBuilderScope
    public void setFrame(QrFrameShape qrFrameShape) {
        Intrinsics.checkNotNullParameter(qrFrameShape, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrOptions.Builder builder = this.builder;
        builder.shapes(QrElementsShapes.copy$default(builder.getElementsShapes(), null, null, qrFrameShape, null, null, 27, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrElementsShapesBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQRElementsShapes
    public QrBallShape getBall() {
        return this.builder.getElementsShapes().getBall();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrElementsShapesBuilderScope
    public void setBall(QrBallShape qrBallShape) {
        Intrinsics.checkNotNullParameter(qrBallShape, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrOptions.Builder builder = this.builder;
        builder.shapes(QrElementsShapes.copy$default(builder.getElementsShapes(), null, null, null, qrBallShape, null, 23, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrElementsShapesBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQRElementsShapes
    public QrHighlightingShape getHighlighting() {
        return this.builder.getElementsShapes().getHighlighting();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrElementsShapesBuilderScope
    public void setHighlighting(QrHighlightingShape qrHighlightingShape) {
        Intrinsics.checkNotNullParameter(qrHighlightingShape, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrOptions.Builder builder = this.builder;
        builder.shapes(QrElementsShapes.copy$default(builder.getElementsShapes(), null, null, null, null, qrHighlightingShape, 15, null));
    }
}
