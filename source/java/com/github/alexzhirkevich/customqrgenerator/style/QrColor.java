package com.github.alexzhirkevich.customqrgenerator.style;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdturing.EventReport;
import com.bytedance.forest.model.PreloadConfig;
import com.github.alexzhirkevich.customqrgenerator.QrUtil;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: QrColor.kt */
@Deprecated(message = "Use QrCodeDrawable with QrVectorColor instead")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\bç\u0080\u0001\u0018\u00002\u00020\u0001:\u0007\b\t\n\u000b\f\r\u000eJ)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H§\u0002¨\u0006\u000f"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "", "invoke", "", RXScreenCaptureService.KEY_INDEX, "j", "width", "height", "CrossingGradient", "LinearGradient", "RadialGradient", "RhombusGradient", "Solid", "SquareGradient", "Unspecified", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface QrColor {
    int invoke(int i, int j, int width, int height);

    /* compiled from: QrColor.kt */
    @Deprecated(message = "Use QrCodeDrawable with QrVectorColor instead")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0097\u0003¨\u0006\t"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor$Unspecified;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "()V", "invoke", "", RXScreenCaptureService.KEY_INDEX, "j", "width", "height", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Unspecified implements QrColor {
        public static final Unspecified INSTANCE = new Unspecified();
        private final /* synthetic */ Solid $$delegate_0 = new Solid(0);

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrColor
        public int invoke(int i, int j, int width, int height) {
            return this.$$delegate_0.invoke(i, j, width, height);
        }

        private Unspecified() {
        }
    }

    /* compiled from: QrColor.kt */
    @Deprecated(message = "Use QrCodeDrawable with QrVectorColor instead")
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J)\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0097\u0002J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor$Solid;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "color", "", "(I)V", "getColor", "()I", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "invoke", RXScreenCaptureService.KEY_INDEX, "j", "width", "height", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* data */ class Solid implements QrColor {
        private final int color;

        public static /* synthetic */ Solid copy$default(Solid solid, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = solid.color;
            }
            return solid.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        public final Solid copy(int color) {
            return new Solid(color);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Solid) && this.color == ((Solid) other).color;
        }

        public int hashCode() {
            return Integer.hashCode(this.color);
        }

        public String toString() {
            return "Solid(color=" + this.color + ')';
        }

        public Solid(int i) {
            this.color = i;
        }

        public final int getColor() {
            return this.color;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrColor
        public int invoke(int i, int j, int width, int height) {
            return this.color;
        }
    }

    /* compiled from: QrColor.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001dB!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J)\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0097\u0002J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor$LinearGradient;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "startColor", "", "endColor", EventReport.SCREEN_ORIENTATION, "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor$LinearGradient$Orientation;", "(IILcom/github/alexzhirkevich/customqrgenerator/style/QrColor$LinearGradient$Orientation;)V", "getEndColor", "()I", "getOrientation", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor$LinearGradient$Orientation;", "getStartColor", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "invoke", RXScreenCaptureService.KEY_INDEX, "j", "width", "height", "toString", "", ExifInterface.TAG_ORIENTATION, "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Deprecated(message = "Use QrCodeDrawable with QrVectorColor instead")
    /* loaded from: classes6.dex */
    public static final /* data */ class LinearGradient implements QrColor {
        private final int endColor;
        private final Orientation orientation;
        private final int startColor;

        /* compiled from: QrColor.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor$LinearGradient$Orientation;", "", "(Ljava/lang/String;I)V", "Vertical", "Horizontal", "LeftDiagonal", "RightDiagonal", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public enum Orientation {
            Vertical,
            Horizontal,
            LeftDiagonal,
            RightDiagonal
        }

        /* compiled from: QrColor.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Orientation.values().length];
                iArr[Orientation.Vertical.ordinal()] = 1;
                iArr[Orientation.Horizontal.ordinal()] = 2;
                iArr[Orientation.LeftDiagonal.ordinal()] = 3;
                iArr[Orientation.RightDiagonal.ordinal()] = 4;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public static /* synthetic */ LinearGradient copy$default(LinearGradient linearGradient, int i, int i2, Orientation orientation, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = linearGradient.startColor;
            }
            if ((i3 & 2) != 0) {
                i2 = linearGradient.endColor;
            }
            if ((i3 & 4) != 0) {
                orientation = linearGradient.orientation;
            }
            return linearGradient.copy(i, i2, orientation);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStartColor() {
            return this.startColor;
        }

        /* renamed from: component2, reason: from getter */
        public final int getEndColor() {
            return this.endColor;
        }

        /* renamed from: component3, reason: from getter */
        public final Orientation getOrientation() {
            return this.orientation;
        }

        public final LinearGradient copy(int startColor, int endColor, Orientation orientation) {
            Intrinsics.checkNotNullParameter(orientation, "orientation");
            return new LinearGradient(startColor, endColor, orientation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinearGradient)) {
                return false;
            }
            LinearGradient linearGradient = (LinearGradient) other;
            return this.startColor == linearGradient.startColor && this.endColor == linearGradient.endColor && this.orientation == linearGradient.orientation;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.startColor) * 31) + Integer.hashCode(this.endColor)) * 31) + this.orientation.hashCode();
        }

        public String toString() {
            return "LinearGradient(startColor=" + this.startColor + ", endColor=" + this.endColor + ", orientation=" + this.orientation + ')';
        }

        public LinearGradient(int i, int i2, Orientation orientation) {
            Intrinsics.checkNotNullParameter(orientation, "orientation");
            this.startColor = i;
            this.endColor = i2;
            this.orientation = orientation;
        }

        public final int getStartColor() {
            return this.startColor;
        }

        public final int getEndColor() {
            return this.endColor;
        }

        public final Orientation getOrientation() {
            return this.orientation;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrColor
        public int invoke(int i, int j, int width, int height) {
            float f;
            float f2;
            int i2 = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        f = i + j;
                    } else {
                        if (i2 != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        f = (i + width) - j;
                    }
                    width += height;
                } else {
                    f = i;
                }
                f2 = width;
            } else {
                f = j;
                f2 = height;
            }
            return QrUtil.INSTANCE.mixColors(this.startColor, this.endColor, ((Number) RangesKt.coerceIn(Float.valueOf(1.0f - (f / f2)), RangesKt.rangeTo(0.0f, 1.0f))).floatValue());
        }
    }

    /* compiled from: QrColor.kt */
    @Deprecated(message = "Use QrCodeDrawable with QrVectorColor instead")
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J)\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0097\u0002J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor$SquareGradient;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "startColor", "", "endColor", "(II)V", "getEndColor", "()I", "getStartColor", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "invoke", RXScreenCaptureService.KEY_INDEX, "j", "width", "height", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* data */ class SquareGradient implements QrColor {
        private final int endColor;
        private final int startColor;

        public static /* synthetic */ SquareGradient copy$default(SquareGradient squareGradient, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = squareGradient.startColor;
            }
            if ((i3 & 2) != 0) {
                i2 = squareGradient.endColor;
            }
            return squareGradient.copy(i, i2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStartColor() {
            return this.startColor;
        }

        /* renamed from: component2, reason: from getter */
        public final int getEndColor() {
            return this.endColor;
        }

        public final SquareGradient copy(int startColor, int endColor) {
            return new SquareGradient(startColor, endColor);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SquareGradient)) {
                return false;
            }
            SquareGradient squareGradient = (SquareGradient) other;
            return this.startColor == squareGradient.startColor && this.endColor == squareGradient.endColor;
        }

        public int hashCode() {
            return (Integer.hashCode(this.startColor) * 31) + Integer.hashCode(this.endColor);
        }

        public String toString() {
            return "SquareGradient(startColor=" + this.startColor + ", endColor=" + this.endColor + ')';
        }

        public SquareGradient(int i, int i2) {
            this.startColor = i;
            this.endColor = i2;
        }

        public final int getStartColor() {
            return this.startColor;
        }

        public final int getEndColor() {
            return this.endColor;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrColor
        public int invoke(int i, int j, int width, int height) {
            return QrUtil.INSTANCE.mixColors(this.startColor, this.endColor, (Math.min(Math.min(i, width - i), Math.min(j, height - j)) * 2.0f) / Math.min(width, height));
        }
    }

    /* compiled from: QrColor.kt */
    @Deprecated(message = "Use QrCodeDrawable with QrVectorColor instead")
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J)\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0097\u0002J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor$RhombusGradient;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "startColor", "", "endColor", "(II)V", "getEndColor", "()I", "getStartColor", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "invoke", RXScreenCaptureService.KEY_INDEX, "j", "width", "height", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* data */ class RhombusGradient implements QrColor {
        private final int endColor;
        private final int startColor;

        public static /* synthetic */ RhombusGradient copy$default(RhombusGradient rhombusGradient, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = rhombusGradient.startColor;
            }
            if ((i3 & 2) != 0) {
                i2 = rhombusGradient.endColor;
            }
            return rhombusGradient.copy(i, i2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStartColor() {
            return this.startColor;
        }

        /* renamed from: component2, reason: from getter */
        public final int getEndColor() {
            return this.endColor;
        }

        public final RhombusGradient copy(int startColor, int endColor) {
            return new RhombusGradient(startColor, endColor);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RhombusGradient)) {
                return false;
            }
            RhombusGradient rhombusGradient = (RhombusGradient) other;
            return this.startColor == rhombusGradient.startColor && this.endColor == rhombusGradient.endColor;
        }

        public int hashCode() {
            return (Integer.hashCode(this.startColor) * 31) + Integer.hashCode(this.endColor);
        }

        public String toString() {
            return "RhombusGradient(startColor=" + this.startColor + ", endColor=" + this.endColor + ')';
        }

        public RhombusGradient(int i, int i2) {
            this.startColor = i;
            this.endColor = i2;
        }

        public final int getStartColor() {
            return this.startColor;
        }

        public final int getEndColor() {
            return this.endColor;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrColor
        public int invoke(int i, int j, int width, int height) {
            return QrUtil.INSTANCE.mixColors(this.startColor, this.endColor, (Math.min(i, width - i) / width) + (Math.min(j, height - j) / height));
        }
    }

    /* compiled from: QrColor.kt */
    @Deprecated(message = "Use QrCodeDrawable with QrVectorColor instead")
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J)\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0097\u0002J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor$RadialGradient;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "startColor", "", "endColor", "radius", "", "(IIF)V", "getEndColor", "()I", "getRadius", "()F", "getStartColor", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "invoke", RXScreenCaptureService.KEY_INDEX, "j", "width", "height", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* data */ class RadialGradient implements QrColor {
        private final int endColor;
        private final float radius;
        private final int startColor;

        public static /* synthetic */ RadialGradient copy$default(RadialGradient radialGradient, int i, int i2, float f, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = radialGradient.startColor;
            }
            if ((i3 & 2) != 0) {
                i2 = radialGradient.endColor;
            }
            if ((i3 & 4) != 0) {
                f = radialGradient.radius;
            }
            return radialGradient.copy(i, i2, f);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStartColor() {
            return this.startColor;
        }

        /* renamed from: component2, reason: from getter */
        public final int getEndColor() {
            return this.endColor;
        }

        /* renamed from: component3, reason: from getter */
        public final float getRadius() {
            return this.radius;
        }

        public final RadialGradient copy(int startColor, int endColor, float radius) {
            return new RadialGradient(startColor, endColor, radius);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RadialGradient)) {
                return false;
            }
            RadialGradient radialGradient = (RadialGradient) other;
            return this.startColor == radialGradient.startColor && this.endColor == radialGradient.endColor && Intrinsics.areEqual((Object) Float.valueOf(this.radius), (Object) Float.valueOf(radialGradient.radius));
        }

        public int hashCode() {
            return (((Integer.hashCode(this.startColor) * 31) + Integer.hashCode(this.endColor)) * 31) + Float.hashCode(this.radius);
        }

        public String toString() {
            return "RadialGradient(startColor=" + this.startColor + ", endColor=" + this.endColor + ", radius=" + this.radius + ')';
        }

        public RadialGradient(int i, int i2, float f) {
            this.startColor = i;
            this.endColor = i2;
            this.radius = f;
        }

        public final int getStartColor() {
            return this.startColor;
        }

        public final int getEndColor() {
            return this.endColor;
        }

        public /* synthetic */ RadialGradient(int i, int i2, float f, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, (i3 & 4) != 0 ? (float) Math.sqrt(2.0f) : f);
        }

        public final float getRadius() {
            return this.radius;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrColor
        public int invoke(int i, int j, int width, int height) {
            double d = 2;
            return QrUtil.INSTANCE.mixColors(this.startColor, this.endColor, ((Number) RangesKt.coerceIn(Float.valueOf((((float) Math.sqrt(((float) Math.pow(r0 - Math.min(i, width - i), d)) + ((float) Math.pow(r0 - Math.min(j, height - j), d)))) / (width / 2.0f)) / RangesKt.coerceAtLeast(this.radius, Float.MIN_VALUE)), RangesKt.rangeTo(0.0f, 1.0f))).floatValue());
        }
    }

    /* compiled from: QrColor.kt */
    @Deprecated(message = "Use QrCodeDrawable with QrVectorColor instead")
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J)\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0097\u0002J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor$CrossingGradient;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "colorLeftDiagonal", "", "colorRightDiagonal", "(II)V", "getColorLeftDiagonal", "()I", "getColorRightDiagonal", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "invoke", RXScreenCaptureService.KEY_INDEX, "j", "width", "height", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* data */ class CrossingGradient implements QrColor {
        private final int colorLeftDiagonal;
        private final int colorRightDiagonal;

        public static /* synthetic */ CrossingGradient copy$default(CrossingGradient crossingGradient, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = crossingGradient.colorLeftDiagonal;
            }
            if ((i3 & 2) != 0) {
                i2 = crossingGradient.colorRightDiagonal;
            }
            return crossingGradient.copy(i, i2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getColorLeftDiagonal() {
            return this.colorLeftDiagonal;
        }

        /* renamed from: component2, reason: from getter */
        public final int getColorRightDiagonal() {
            return this.colorRightDiagonal;
        }

        public final CrossingGradient copy(int colorLeftDiagonal, int colorRightDiagonal) {
            return new CrossingGradient(colorLeftDiagonal, colorRightDiagonal);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CrossingGradient)) {
                return false;
            }
            CrossingGradient crossingGradient = (CrossingGradient) other;
            return this.colorLeftDiagonal == crossingGradient.colorLeftDiagonal && this.colorRightDiagonal == crossingGradient.colorRightDiagonal;
        }

        public int hashCode() {
            return (Integer.hashCode(this.colorLeftDiagonal) * 31) + Integer.hashCode(this.colorRightDiagonal);
        }

        public String toString() {
            return "CrossingGradient(colorLeftDiagonal=" + this.colorLeftDiagonal + ", colorRightDiagonal=" + this.colorRightDiagonal + ')';
        }

        public CrossingGradient(int i, int i2) {
            this.colorLeftDiagonal = i;
            this.colorRightDiagonal = i2;
        }

        public final int getColorLeftDiagonal() {
            return this.colorLeftDiagonal;
        }

        public final int getColorRightDiagonal() {
            return this.colorRightDiagonal;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrColor
        public int invoke(int i, int j, int width, int height) {
            int i2;
            float f = width / 2.0f;
            float f2 = i;
            int i3 = ((f2 > f || ((float) j) > f) && (f2 < f || ((float) j) < f)) ? this.colorRightDiagonal : this.colorLeftDiagonal;
            int mixColors = QrUtil.INSTANCE.mixColors(this.colorLeftDiagonal, this.colorRightDiagonal, 0.5f);
            int min = Math.min(i, width - i);
            int min2 = Math.min(j, width - j);
            float f3 = min;
            float f4 = f / 2;
            int min3 = Math.min(min, (int) (f3 - f4));
            float f5 = min2;
            int min4 = Math.min(min2, (int) (f5 - f4));
            if (f3 <= f4 && f5 <= f4) {
                return i3;
            }
            if (f3 > f4 && f5 < f4) {
                return new LinearGradient(i3, mixColors, LinearGradient.Orientation.Horizontal).invoke(min3, min4, width / 4, height / 4);
            }
            if (f3 < f4 && f5 > f4) {
                return new LinearGradient(i3, mixColors, LinearGradient.Orientation.Vertical).invoke(min3, min4, width / 4, height / 4);
            }
            int i4 = this.colorLeftDiagonal;
            int i5 = width / 4;
            int i6 = height / 4;
            return ((Number) (((i3 != i4 || i4 <= this.colorRightDiagonal) && (i3 != (i2 = this.colorRightDiagonal) || i4 >= i2)) ? QrColor$CrossingGradient$invoke$order$2.INSTANCE : QrColor$CrossingGradient$invoke$order$1.INSTANCE).invoke(Integer.valueOf(new LinearGradient(i3, mixColors, LinearGradient.Orientation.Vertical).invoke(min3, min4, i5, i6)), Integer.valueOf(new LinearGradient(i3, mixColors, LinearGradient.Orientation.Horizontal).invoke(min3, min4, i5, i6)))).intValue();
        }
    }
}
