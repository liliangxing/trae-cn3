package com.github.alexzhirkevich.customqrgenerator.vector.dsl;

import com.github.alexzhirkevich.customqrgenerator.vector.QrVectorOptions;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorBallShape;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorFrameShape;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorPixelShape;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapes;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InternalQrVectorShapesBuilderScope.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00168V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/InternalQrVectorShapesBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrVectorShapesBuilderScope;", "builder", "Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;", "centralSymmetry", "", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;Z)V", CustomDataTagHandler.VALUE_ATTRIBUTE, "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape;", "ball", "getBall", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape;", "setBall", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape;)V", "getCentralSymmetry", "()Z", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;", "darkPixel", "getDarkPixel", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;", "setDarkPixel", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;)V", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape;", "frame", "getFrame", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape;", "setFrame", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape;)V", "lightPixel", "getLightPixel", "setLightPixel", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class InternalQrVectorShapesBuilderScope implements QrVectorShapesBuilderScope {
    private final QrVectorOptions.Builder builder;
    private final boolean centralSymmetry;

    public InternalQrVectorShapesBuilderScope(QrVectorOptions.Builder builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.centralSymmetry = z;
        builder.setShapes(QrVectorShapes.copy$default(builder.getShapes(), null, null, null, null, getCentralSymmetry(), 15, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorShapes
    public boolean getCentralSymmetry() {
        return this.centralSymmetry;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorShapesBuilderScope, com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorShapes
    public QrVectorPixelShape getDarkPixel() {
        return this.builder.getShapes().getDarkPixel();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorShapesBuilderScope
    public void setDarkPixel(QrVectorPixelShape qrVectorPixelShape) {
        Intrinsics.checkNotNullParameter(qrVectorPixelShape, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrVectorOptions.Builder builder = this.builder;
        builder.setShapes(QrVectorShapes.copy$default(builder.getShapes(), qrVectorPixelShape, null, null, null, false, 30, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorShapesBuilderScope, com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorShapes
    public QrVectorPixelShape getLightPixel() {
        return this.builder.getShapes().getLightPixel();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorShapesBuilderScope
    public void setLightPixel(QrVectorPixelShape qrVectorPixelShape) {
        Intrinsics.checkNotNullParameter(qrVectorPixelShape, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrVectorOptions.Builder builder = this.builder;
        builder.setShapes(QrVectorShapes.copy$default(builder.getShapes(), null, qrVectorPixelShape, null, null, false, 29, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorShapesBuilderScope, com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorShapes
    public QrVectorBallShape getBall() {
        return this.builder.getShapes().getBall();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorShapesBuilderScope
    public void setBall(QrVectorBallShape qrVectorBallShape) {
        Intrinsics.checkNotNullParameter(qrVectorBallShape, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrVectorOptions.Builder builder = this.builder;
        builder.setShapes(QrVectorShapes.copy$default(builder.getShapes(), null, null, qrVectorBallShape, null, false, 27, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorShapesBuilderScope, com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorShapes
    public QrVectorFrameShape getFrame() {
        return this.builder.getShapes().getFrame();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorShapesBuilderScope
    public void setFrame(QrVectorFrameShape qrVectorFrameShape) {
        Intrinsics.checkNotNullParameter(qrVectorFrameShape, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrVectorOptions.Builder builder = this.builder;
        builder.setShapes(QrVectorShapes.copy$default(builder.getShapes(), null, null, null, qrVectorFrameShape, false, 23, null));
    }
}
