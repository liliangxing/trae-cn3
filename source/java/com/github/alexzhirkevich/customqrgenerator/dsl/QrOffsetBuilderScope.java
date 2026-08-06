package com.github.alexzhirkevich.customqrgenerator.dsl;

import com.github.alexzhirkevich.customqrgenerator.style.IQrOffset;
import kotlin.Metadata;

/* compiled from: QrOffsetBuilderScope.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007\u0082\u0001\u0001\u000b¨\u0006\f"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrOffsetBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/style/IQrOffset;", "x", "", "getX", "()F", "setX", "(F)V", "y", "getY", "setY", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/InternalQrOffsetBuilderScope;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface QrOffsetBuilderScope extends IQrOffset {
    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQrOffset
    float getX();

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQrOffset
    float getY();

    void setX(float f);

    void setY(float f);
}
