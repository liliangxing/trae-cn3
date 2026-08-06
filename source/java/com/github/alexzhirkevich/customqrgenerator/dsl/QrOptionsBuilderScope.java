package com.github.alexzhirkevich.customqrgenerator.dsl;

import com.github.alexzhirkevich.customqrgenerator.QrErrorCorrectionLevel;
import com.github.alexzhirkevich.customqrgenerator.style.QrShape;
import com.lynx.tasm.animation.AnimationConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: QrOptionsBuilderScope.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J!\u0010\u0018\u001a\u00020\u00192\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00190\u001b¢\u0006\u0002\b\u001dH&J!\u0010\u001e\u001a\u00020\u00192\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00190\u001b¢\u0006\u0002\b\u001dH&J!\u0010 \u001a\u00020\u00192\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00190\u001b¢\u0006\u0002\b\u001dH&J!\u0010\"\u001a\u00020\u00192\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00190\u001b¢\u0006\u0002\b\u001dH&J!\u0010$\u001a\u00020\u00192\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00190\u001b¢\u0006\u0002\b\u001dH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u00020\u0011X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000b\u0082\u0001\u0001&¨\u0006'"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrOptionsBuilderScope;", "", "errorCorrectionLevel", "Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;", "getErrorCorrectionLevel", "()Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;", "setErrorCorrectionLevel", "(Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;)V", AnimationConstant.PROP_STR_HEIGHT, "", "getHeight", "()I", "padding", "", "getPadding", "()F", "shape", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;", "getShape", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;", "setShape", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;)V", AnimationConstant.PROP_STR_WIDTH, "getWidth", "background", "", "block", "Lkotlin/Function1;", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrBackgroundBuilderScope;", "Lkotlin/ExtensionFunctionType;", "colors", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrColorsBuilderScope;", "logo", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrLogoBuilderScope;", "offset", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrOffsetBuilderScope;", "shapes", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrElementsShapesBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/InternalQrOptionsBuilderScope;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface QrOptionsBuilderScope {
    void background(Function1<? super QrBackgroundBuilderScope, Unit> block);

    void colors(Function1<? super QrColorsBuilderScope, Unit> block);

    QrErrorCorrectionLevel getErrorCorrectionLevel();

    int getHeight();

    float getPadding();

    QrShape getShape();

    int getWidth();

    void logo(Function1<? super QrLogoBuilderScope, Unit> block);

    void offset(Function1<? super QrOffsetBuilderScope, Unit> block);

    void setErrorCorrectionLevel(QrErrorCorrectionLevel qrErrorCorrectionLevel);

    void setShape(QrShape qrShape);

    void shapes(Function1<? super QrElementsShapesBuilderScope, Unit> block);
}
