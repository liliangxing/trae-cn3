package com.github.alexzhirkevich.customqrgenerator.style;

import com.github.alexzhirkevich.customqrgenerator.encoder.QrCodeMatrix;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrLogoPadding.kt */
@Deprecated(message = "Use QrCodeDrawable with QrVectorLogoPadding instead")
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0003\u0013\u0014\u0015J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoPadding;", "", "shouldApplyAccuratePadding", "", "getShouldApplyAccuratePadding", "()Z", CustomDataTagHandler.VALUE_ATTRIBUTE, "", "getValue", "()F", "apply", "", "matrix", "Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrCodeMatrix;", "logoSize", "", "logoPos", "logoShape", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoShape;", "Accurate", "Empty", "Natural", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface QrLogoPadding {
    void apply(QrCodeMatrix matrix, int logoSize, int logoPos, QrLogoShape logoShape);

    boolean getShouldApplyAccuratePadding();

    float getValue();

    /* compiled from: QrLogoPadding.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoPadding$Empty;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoPadding;", "()V", "shouldApplyAccuratePadding", "", "getShouldApplyAccuratePadding", "()Z", CustomDataTagHandler.VALUE_ATTRIBUTE, "", "getValue", "()F", "apply", "", "matrix", "Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrCodeMatrix;", "logoSize", "", "logoPos", "logoShape", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoShape;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Empty implements QrLogoPadding {
        public static final Empty INSTANCE = new Empty();

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrLogoPadding
        public void apply(QrCodeMatrix matrix, int logoSize, int logoPos, QrLogoShape logoShape) {
            Intrinsics.checkNotNullParameter(matrix, "matrix");
            Intrinsics.checkNotNullParameter(logoShape, "logoShape");
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrLogoPadding
        public boolean getShouldApplyAccuratePadding() {
            return false;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrLogoPadding
        public float getValue() {
            return 0.0f;
        }

        private Empty() {
        }
    }

    /* compiled from: QrLogoPadding.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0010HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoPadding$Accurate;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoPadding;", CustomDataTagHandler.VALUE_ATTRIBUTE, "", "(F)V", "shouldApplyAccuratePadding", "", "getShouldApplyAccuratePadding", "()Z", "getValue", "()F", "apply", "", "matrix", "Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrCodeMatrix;", "logoSize", "", "logoPos", "logoShape", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoShape;", "component1", "copy", "equals", "other", "", "hashCode", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class Accurate implements QrLogoPadding {
        private final float value;

        public static /* synthetic */ Accurate copy$default(Accurate accurate, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = accurate.getValue();
            }
            return accurate.copy(f);
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrLogoPadding
        public void apply(QrCodeMatrix matrix, int logoSize, int logoPos, QrLogoShape logoShape) {
            Intrinsics.checkNotNullParameter(matrix, "matrix");
            Intrinsics.checkNotNullParameter(logoShape, "logoShape");
        }

        public final float component1() {
            return getValue();
        }

        public final Accurate copy(float value) {
            return new Accurate(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Accurate) && Intrinsics.areEqual(Float.valueOf(getValue()), Float.valueOf(((Accurate) other).getValue()));
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrLogoPadding
        public boolean getShouldApplyAccuratePadding() {
            return true;
        }

        public int hashCode() {
            return Float.hashCode(getValue());
        }

        public String toString() {
            return "Accurate(value=" + getValue() + ')';
        }

        public Accurate(float f) {
            this.value = f;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrLogoPadding
        public float getValue() {
            return this.value;
        }
    }

    /* compiled from: QrLogoPadding.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0010HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoPadding$Natural;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoPadding;", CustomDataTagHandler.VALUE_ATTRIBUTE, "", "(F)V", "shouldApplyAccuratePadding", "", "getShouldApplyAccuratePadding", "()Z", "getValue", "()F", "apply", "", "matrix", "Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrCodeMatrix;", "logoSize", "", "logoPos", "logoShape", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrLogoShape;", "component1", "copy", "equals", "other", "", "hashCode", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class Natural implements QrLogoPadding {
        private final float value;

        public static /* synthetic */ Natural copy$default(Natural natural, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = natural.getValue();
            }
            return natural.copy(f);
        }

        public final float component1() {
            return getValue();
        }

        public final Natural copy(float value) {
            return new Natural(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Natural) && Intrinsics.areEqual(Float.valueOf(getValue()), Float.valueOf(((Natural) other).getValue()));
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrLogoPadding
        public boolean getShouldApplyAccuratePadding() {
            return false;
        }

        public int hashCode() {
            return Float.hashCode(getValue());
        }

        public String toString() {
            return "Natural(value=" + getValue() + ')';
        }

        public Natural(float f) {
            this.value = f;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrLogoPadding
        public float getValue() {
            return this.value;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrLogoPadding
        public void apply(QrCodeMatrix matrix, int logoSize, int logoPos, QrLogoShape logoShape) {
            Intrinsics.checkNotNullParameter(matrix, "matrix");
            Intrinsics.checkNotNullParameter(logoShape, "logoShape");
            for (int i = 0; i < logoSize; i++) {
                for (int i2 = 0; i2 < logoSize; i2++) {
                    if (logoShape.invoke(i, i2, logoSize, Neighbors.INSTANCE.getEmpty())) {
                        matrix.set(logoPos + i, logoPos + i2, QrCodeMatrix.PixelType.Logo);
                    }
                }
            }
        }
    }
}
