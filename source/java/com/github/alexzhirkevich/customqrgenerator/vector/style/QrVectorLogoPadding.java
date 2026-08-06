package com.github.alexzhirkevich.customqrgenerator.vector.style;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrVectorLogoPadding.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding;", "", "value", "", "getValue", "()F", "Accurate", "Empty", "Natural", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding$Empty;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding$Accurate;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding$Natural;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface QrVectorLogoPadding {
    float getValue();

    /* compiled from: QrVectorLogoPadding.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding$Empty;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding;", "()V", "value", "", "getValue", "()F", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Empty implements QrVectorLogoPadding {
        public static final Empty INSTANCE = new Empty();

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorLogoPadding
        public float getValue() {
            return 0.0f;
        }

        private Empty() {
        }
    }

    /* compiled from: QrVectorLogoPadding.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding$Accurate;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding;", "value", "", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* data */ class Accurate implements QrVectorLogoPadding {
        private final float value;

        public static /* synthetic */ Accurate copy$default(Accurate accurate, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = accurate.getValue();
            }
            return accurate.copy(f);
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
            return (other instanceof Accurate) && Intrinsics.areEqual((Object) Float.valueOf(getValue()), (Object) Float.valueOf(((Accurate) other).getValue()));
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

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorLogoPadding
        public float getValue() {
            return this.value;
        }
    }

    /* compiled from: QrVectorLogoPadding.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding$Natural;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoPadding;", "value", "", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* data */ class Natural implements QrVectorLogoPadding {
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
            return (other instanceof Natural) && Intrinsics.areEqual((Object) Float.valueOf(getValue()), (Object) Float.valueOf(((Natural) other).getValue()));
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

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorLogoPadding
        public float getValue() {
            return this.value;
        }
    }
}
