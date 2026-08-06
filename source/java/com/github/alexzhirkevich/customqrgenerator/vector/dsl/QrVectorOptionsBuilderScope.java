package com.github.alexzhirkevich.customqrgenerator.vector.dsl;

import com.github.alexzhirkevich.customqrgenerator.QrErrorCorrectionLevel;
import com.github.alexzhirkevich.customqrgenerator.style.QrShape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: QrVectorOptionsBuilderScope.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J!\u0010\u001a\u001a\u00020\u001b2\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001b0\u001d¢\u0006\u0002\b\u001fH&J!\u0010 \u001a\u00020\u001b2\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001b0\u001d¢\u0006\u0002\b\u001fH&J!\u0010\"\u001a\u00020\u001b2\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001b0\u001d¢\u0006\u0002\b\u001fH&J!\u0010$\u001a\u00020\u001b2\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001b0\u001d¢\u0006\u0002\b\u001fH&J\u0018\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u0015H&J+\u0010)\u001a\u00020\u001b2\b\b\u0002\u0010*\u001a\u00020\u000f2\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u001b0\u001d¢\u0006\u0002\b\u001fH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u0082\u0001\u0001,¨\u0006-"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrVectorOptionsBuilderScope;", "", "codeShape", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;", "getCodeShape", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;", "setCodeShape", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;)V", "errorCorrectionLevel", "Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;", "getErrorCorrectionLevel", "()Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;", "setErrorCorrectionLevel", "(Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;)V", "fourthEyeEnabled", "", "getFourthEyeEnabled", "()Z", "setFourthEyeEnabled", "(Z)V", "padding", "", "getPadding", "()F", "setPadding", "(F)V", "background", "", "block", "Lkotlin/Function1;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrVectorBackgroundBuilderScope;", "Lkotlin/ExtensionFunctionType;", "colors", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrVectorColorsBuilderScope;", "highlighting", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrHighlightingBuilderScope;", "logo", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrVectorLogoBuilderScope;", "offset", "x", "y", "shapes", "centralSymmetry", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrVectorShapesBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/InternalQrVectorOptionsBuilderScope;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface QrVectorOptionsBuilderScope {
    void background(Function1<? super QrVectorBackgroundBuilderScope, Unit> block);

    void colors(Function1<? super QrVectorColorsBuilderScope, Unit> block);

    QrShape getCodeShape();

    QrErrorCorrectionLevel getErrorCorrectionLevel();

    boolean getFourthEyeEnabled();

    float getPadding();

    void highlighting(Function1<? super QrHighlightingBuilderScope, Unit> block);

    void logo(Function1<? super QrVectorLogoBuilderScope, Unit> block);

    void offset(float x, float y);

    void setCodeShape(QrShape qrShape);

    void setErrorCorrectionLevel(QrErrorCorrectionLevel qrErrorCorrectionLevel);

    void setFourthEyeEnabled(boolean z);

    void setPadding(float f);

    void shapes(boolean centralSymmetry, Function1<? super QrVectorShapesBuilderScope, Unit> block);

    /* compiled from: QrVectorOptionsBuilderScope.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void shapes$default(QrVectorOptionsBuilderScope qrVectorOptionsBuilderScope, boolean z, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: shapes");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            qrVectorOptionsBuilderScope.shapes(z, function1);
        }
    }
}
