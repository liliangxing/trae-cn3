package com.github.alexzhirkevich.customqrgenerator.dsl;

import com.github.alexzhirkevich.customqrgenerator.QrOptions;
import com.github.alexzhirkevich.customqrgenerator.style.QrOffset;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrOffsetBuilderScope.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/dsl/InternalQrOffsetBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrOffsetBuilderScope;", "builder", "Lcom/github/alexzhirkevich/customqrgenerator/QrOptions$Builder;", "(Lcom/github/alexzhirkevich/customqrgenerator/QrOptions$Builder;)V", CustomDataTagHandler.VALUE_ATTRIBUTE, "", "x", "getX", "()F", "setX", "(F)V", "y", "getY", "setY", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class InternalQrOffsetBuilderScope implements QrOffsetBuilderScope {
    private final QrOptions.Builder builder;

    public InternalQrOffsetBuilderScope(QrOptions.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrOffsetBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQrOffset
    public float getX() {
        return this.builder.getOffset().getX();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrOffsetBuilderScope
    public void setX(float f) {
        QrOptions.Builder builder = this.builder;
        builder.setOffset$custom_qr_generator_release(QrOffset.copy$default(builder.getOffset(), f, 0.0f, 2, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrOffsetBuilderScope, com.github.alexzhirkevich.customqrgenerator.style.IQrOffset
    public float getY() {
        return this.builder.getOffset().getY();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.dsl.QrOffsetBuilderScope
    public void setY(float f) {
        QrOptions.Builder builder = this.builder;
        builder.setOffset$custom_qr_generator_release(QrOffset.copy$default(builder.getOffset(), 0.0f, f, 1, null));
    }
}
