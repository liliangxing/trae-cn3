package com.github.alexzhirkevich.customqrgenerator;

import androidx.webkit.Profile;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapeModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: QrHighlighting.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType;", "", Profile.DEFAULT_PROFILE_NAME, "None", "Styled", "Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType$None;", "Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType$Default;", "Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType$Styled;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface HighlightingType {

    /* compiled from: QrHighlighting.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType$None;", "Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType;", "()V", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class None implements HighlightingType {
        public static final None INSTANCE = new None();

        private None() {
        }
    }

    /* compiled from: QrHighlighting.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType$Default;", "Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType;", "()V", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Default implements HighlightingType {
        public static final Default INSTANCE = new Default();

        private Default() {
        }
    }

    /* compiled from: QrHighlighting.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType$Styled;", "Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType;", "shape", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "color", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;)V", "getColor", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "getShape", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Styled implements HighlightingType {
        private final QrVectorColor color;
        private final QrVectorShapeModifier shape;

        /* JADX WARN: Multi-variable type inference failed */
        public Styled() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public Styled(QrVectorShapeModifier qrVectorShapeModifier, QrVectorColor qrVectorColor) {
            this.shape = qrVectorShapeModifier;
            this.color = qrVectorColor;
        }

        public /* synthetic */ Styled(QrVectorShapeModifier qrVectorShapeModifier, QrVectorColor qrVectorColor, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : qrVectorShapeModifier, (i & 2) != 0 ? null : qrVectorColor);
        }

        public final QrVectorShapeModifier getShape() {
            return this.shape;
        }

        public final QrVectorColor getColor() {
            return this.color;
        }
    }
}
