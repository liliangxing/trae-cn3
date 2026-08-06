package com.github.alexzhirkevich.customqrgenerator.vector.dsl;

import android.graphics.drawable.Drawable;
import com.github.alexzhirkevich.customqrgenerator.style.BitmapScale;
import com.github.alexzhirkevich.customqrgenerator.vector.QrVectorOptions;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorBackground;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InternalQrVectorBackgroundBuilderScope.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/InternalQrVectorBackgroundBuilderScope;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/dsl/QrVectorBackgroundBuilderScope;", "builder", "Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;)V", "getBuilder", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;", CustomDataTagHandler.VALUE_ATTRIBUTE, "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", RemoteMessageConst.Notification.COLOR, "getColor", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "setColor", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "scale", "getScale", "()Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;", "setScale", "(Lcom/github/alexzhirkevich/customqrgenerator/style/BitmapScale;)V", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class InternalQrVectorBackgroundBuilderScope implements QrVectorBackgroundBuilderScope {
    private final QrVectorOptions.Builder builder;

    public InternalQrVectorBackgroundBuilderScope(QrVectorOptions.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
    }

    public final QrVectorOptions.Builder getBuilder() {
        return this.builder;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorBackgroundBuilderScope, com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorBackground
    public Drawable getDrawable() {
        return this.builder.getBackground().getDrawable();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorBackgroundBuilderScope
    public void setDrawable(Drawable drawable) {
        QrVectorOptions.Builder builder = this.builder;
        builder.setBackground(QrVectorBackground.copy$default(builder.getBackground(), drawable, null, null, 6, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorBackgroundBuilderScope, com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorBackground
    public BitmapScale getScale() {
        return this.builder.getBackground().getScale();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorBackgroundBuilderScope
    public void setScale(BitmapScale bitmapScale) {
        Intrinsics.checkNotNullParameter(bitmapScale, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrVectorOptions.Builder builder = this.builder;
        builder.setBackground(QrVectorBackground.copy$default(builder.getBackground(), null, bitmapScale, null, 5, null));
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorBackgroundBuilderScope, com.github.alexzhirkevich.customqrgenerator.vector.style.IQrVectorBackground
    public QrVectorColor getColor() {
        return this.builder.getBackground().getColor();
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.dsl.QrVectorBackgroundBuilderScope
    public void setColor(QrVectorColor qrVectorColor) {
        Intrinsics.checkNotNullParameter(qrVectorColor, CustomDataTagHandler.VALUE_ATTRIBUTE);
        QrVectorOptions.Builder builder = this.builder;
        builder.setBackground(QrVectorBackground.copy$default(builder.getBackground(), null, null, qrVectorColor, 3, null));
    }
}
