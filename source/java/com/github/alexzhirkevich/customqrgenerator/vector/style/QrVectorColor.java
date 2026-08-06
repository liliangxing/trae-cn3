package com.github.alexzhirkevich.customqrgenerator.vector.style;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdturing.EventReport;
import com.bytedance.forest.model.PreloadConfig;
import com.github.alexzhirkevich.customqrgenerator.style.QrColorKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: QrVectorColor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\u0007\u0007\b\t\n\u000b\f\rJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "", "createPaint", "Landroid/graphics/Paint;", "width", "", "height", "Eraser", "LinearGradient", "RadialGradient", "Solid", "SweepGradient", "Transparent", "Unspecified", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface QrVectorColor {
    Paint createPaint(float width, float height);

    /* compiled from: QrVectorColor.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor$Transparent;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "()V", "createPaint", "Landroid/graphics/Paint;", "width", "", "height", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Transparent implements QrVectorColor {
        public static final Transparent INSTANCE = new Transparent();

        private Transparent() {
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor
        public Paint createPaint(float width, float height) {
            Paint paint = new Paint();
            paint.setColor(QrColorKt.Color(0L));
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST));
            return paint;
        }
    }

    /* compiled from: QrVectorColor.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor$Eraser;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "()V", "createPaint", "Landroid/graphics/Paint;", "width", "", "height", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Eraser implements QrVectorColor {
        public static final Eraser INSTANCE = new Eraser();

        private Eraser() {
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor
        public Paint createPaint(float width, float height) {
            Paint paint = new Paint();
            paint.setAlpha(0);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
            return paint;
        }
    }

    /* compiled from: QrVectorColor.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001¨\u0006\b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor$Unspecified;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "()V", "createPaint", "Landroid/graphics/Paint;", "width", "", "height", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Unspecified implements QrVectorColor {
        public static final Unspecified INSTANCE = new Unspecified();
        private final /* synthetic */ Transparent $$delegate_0 = Transparent.INSTANCE;

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor
        public Paint createPaint(float width, float height) {
            return this.$$delegate_0.createPaint(width, height);
        }

        private Unspecified() {
        }
    }

    /* compiled from: QrVectorColor.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor$Solid;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "color", "", "(I)V", "getColor", "()I", "component1", "copy", "createPaint", "Landroid/graphics/Paint;", "width", "", "height", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* data */ class Solid implements QrVectorColor {
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

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor
        public Paint createPaint(float width, float height) {
            Paint paint = new Paint();
            paint.setColor(this.color);
            return paint;
        }
    }

    /* compiled from: QrVectorColor.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001cB'\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001b\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\bHÆ\u0003J/\u0010\u0010\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor$LinearGradient;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "colors", "", "Lkotlin/Pair;", "", "", EventReport.SCREEN_ORIENTATION, "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor$LinearGradient$Orientation;", "(Ljava/util/List;Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor$LinearGradient$Orientation;)V", "getColors", "()Ljava/util/List;", "getOrientation", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor$LinearGradient$Orientation;", "component1", "component2", "copy", "createPaint", "Landroid/graphics/Paint;", "width", "height", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "", ExifInterface.TAG_ORIENTATION, "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* data */ class LinearGradient implements QrVectorColor {
        private final List<Pair<Float, Integer>> colors;
        private final Orientation orientation;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LinearGradient copy$default(LinearGradient linearGradient, List list, Orientation orientation, int i, Object obj) {
            if ((i & 1) != 0) {
                list = linearGradient.colors;
            }
            if ((i & 2) != 0) {
                orientation = linearGradient.orientation;
            }
            return linearGradient.copy(list, orientation);
        }

        public final List<Pair<Float, Integer>> component1() {
            return this.colors;
        }

        /* renamed from: component2, reason: from getter */
        public final Orientation getOrientation() {
            return this.orientation;
        }

        public final LinearGradient copy(List<Pair<Float, Integer>> colors, Orientation orientation) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            Intrinsics.checkNotNullParameter(orientation, "orientation");
            return new LinearGradient(colors, orientation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinearGradient)) {
                return false;
            }
            LinearGradient linearGradient = (LinearGradient) other;
            return Intrinsics.areEqual(this.colors, linearGradient.colors) && this.orientation == linearGradient.orientation;
        }

        public int hashCode() {
            return (this.colors.hashCode() * 31) + this.orientation.hashCode();
        }

        public String toString() {
            return "LinearGradient(colors=" + this.colors + ", orientation=" + this.orientation + ')';
        }

        public LinearGradient(List<Pair<Float, Integer>> colors, Orientation orientation) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            Intrinsics.checkNotNullParameter(orientation, "orientation");
            this.colors = colors;
            this.orientation = orientation;
        }

        public final List<Pair<Float, Integer>> getColors() {
            return this.colors;
        }

        public final Orientation getOrientation() {
            return this.orientation;
        }

        /* compiled from: QrVectorColor.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BS\b\u0002\u0012$\u0010\u0002\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00050\u0003\u0012$\u0010\u0006\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00050\u0003¢\u0006\u0002\u0010\u0007R/\u0010\u0006\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR/\u0010\u0002\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor$LinearGradient$Orientation;", "", "start", "Lkotlin/Function2;", "", "Lkotlin/Pair;", "end", "(Ljava/lang/String;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getEnd", "()Lkotlin/jvm/functions/Function2;", "getStart", "Vertical", "Horizontal", "LeftDiagonal", "RightDiagonal", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public enum Orientation {
            Vertical(new Function2<Float, Float, Pair<? extends Float, ? extends Float>>() { // from class: com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor.LinearGradient.Orientation.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Pair<? extends Float, ? extends Float> invoke(Float f, Float f2) {
                    return invoke(f.floatValue(), f2.floatValue());
                }

                public final Pair<Float, Float> invoke(float f, float f2) {
                    return TuplesKt.to(Float.valueOf(f / 2), Float.valueOf(0.0f));
                }
            }, new Function2<Float, Float, Pair<? extends Float, ? extends Float>>() { // from class: com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor.LinearGradient.Orientation.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Pair<? extends Float, ? extends Float> invoke(Float f, Float f2) {
                    return invoke(f.floatValue(), f2.floatValue());
                }

                public final Pair<Float, Float> invoke(float f, float f2) {
                    return TuplesKt.to(Float.valueOf(f / 2), Float.valueOf(f2));
                }
            }),
            Horizontal(new Function2<Float, Float, Pair<? extends Float, ? extends Float>>() { // from class: com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor.LinearGradient.Orientation.3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Pair<? extends Float, ? extends Float> invoke(Float f, Float f2) {
                    return invoke(f.floatValue(), f2.floatValue());
                }

                public final Pair<Float, Float> invoke(float f, float f2) {
                    return TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(f2 / 2));
                }
            }, new Function2<Float, Float, Pair<? extends Float, ? extends Float>>() { // from class: com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor.LinearGradient.Orientation.4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Pair<? extends Float, ? extends Float> invoke(Float f, Float f2) {
                    return invoke(f.floatValue(), f2.floatValue());
                }

                public final Pair<Float, Float> invoke(float f, float f2) {
                    return TuplesKt.to(Float.valueOf(f), Float.valueOf(f2 / 2));
                }
            }),
            LeftDiagonal(new Function2<Float, Float, Pair<? extends Float, ? extends Float>>() { // from class: com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor.LinearGradient.Orientation.5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Pair<? extends Float, ? extends Float> invoke(Float f, Float f2) {
                    return invoke(f.floatValue(), f2.floatValue());
                }

                public final Pair<Float, Float> invoke(float f, float f2) {
                    Float valueOf = Float.valueOf(0.0f);
                    return TuplesKt.to(valueOf, valueOf);
                }
            }, new Function2<Float, Float, Pair<? extends Float, ? extends Float>>() { // from class: com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor.LinearGradient.Orientation.6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Pair<? extends Float, ? extends Float> invoke(Float f, Float f2) {
                    return invoke(f.floatValue(), f2.floatValue());
                }

                public final Pair<Float, Float> invoke(float f, float f2) {
                    return TuplesKt.to(Float.valueOf(f), Float.valueOf(f2));
                }
            }),
            RightDiagonal(new Function2<Float, Float, Pair<? extends Float, ? extends Float>>() { // from class: com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor.LinearGradient.Orientation.7
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Pair<? extends Float, ? extends Float> invoke(Float f, Float f2) {
                    return invoke(f.floatValue(), f2.floatValue());
                }

                public final Pair<Float, Float> invoke(float f, float f2) {
                    return TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(f2));
                }
            }, new Function2<Float, Float, Pair<? extends Float, ? extends Float>>() { // from class: com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor.LinearGradient.Orientation.8
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Pair<? extends Float, ? extends Float> invoke(Float f, Float f2) {
                    return invoke(f.floatValue(), f2.floatValue());
                }

                public final Pair<Float, Float> invoke(float f, float f2) {
                    return TuplesKt.to(Float.valueOf(f), Float.valueOf(0.0f));
                }
            });

            private final Function2<Float, Float, Pair<Float, Float>> end;
            private final Function2<Float, Float, Pair<Float, Float>> start;

            Orientation(Function2 function2, Function2 function22) {
                this.start = function2;
                this.end = function22;
            }

            public final Function2<Float, Float, Pair<Float, Float>> getStart() {
                return this.start;
            }

            public final Function2<Float, Float, Pair<Float, Float>> getEnd() {
                return this.end;
            }
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor
        public Paint createPaint(float width, float height) {
            Pair<Float, Float> invoke = this.orientation.getStart().invoke(Float.valueOf(width), Float.valueOf(height));
            float floatValue = invoke.component1().floatValue();
            float floatValue2 = invoke.component2().floatValue();
            Pair<Float, Float> invoke2 = this.orientation.getEnd().invoke(Float.valueOf(width), Float.valueOf(height));
            float floatValue3 = invoke2.component1().floatValue();
            float floatValue4 = invoke2.component2().floatValue();
            Paint paint = new Paint();
            List<Pair<Float, Integer>> list = this.colors;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((Number) ((Pair) it.next()).getSecond()).intValue()));
            }
            int[] intArray = CollectionsKt.toIntArray(arrayList);
            List<Pair<Float, Integer>> list2 = this.colors;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Float.valueOf(((Number) ((Pair) it2.next()).getFirst()).floatValue()));
            }
            paint.setShader(new android.graphics.LinearGradient(floatValue, floatValue2, floatValue3, floatValue4, intArray, CollectionsKt.toFloatArray(arrayList2), Shader.TileMode.CLAMP));
            return paint;
        }
    }

    /* compiled from: QrVectorColor.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u001b\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J/\u0010\u000f\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor$RadialGradient;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "colors", "", "Lkotlin/Pair;", "", "", "radius", "(Ljava/util/List;F)V", "getColors", "()Ljava/util/List;", "getRadius", "()F", "component1", "component2", "copy", "createPaint", "Landroid/graphics/Paint;", "width", "height", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* data */ class RadialGradient implements QrVectorColor {
        private final List<Pair<Float, Integer>> colors;
        private final float radius;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RadialGradient copy$default(RadialGradient radialGradient, List list, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                list = radialGradient.colors;
            }
            if ((i & 2) != 0) {
                f = radialGradient.radius;
            }
            return radialGradient.copy(list, f);
        }

        public final List<Pair<Float, Integer>> component1() {
            return this.colors;
        }

        /* renamed from: component2, reason: from getter */
        public final float getRadius() {
            return this.radius;
        }

        public final RadialGradient copy(List<Pair<Float, Integer>> colors, float radius) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            return new RadialGradient(colors, radius);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RadialGradient)) {
                return false;
            }
            RadialGradient radialGradient = (RadialGradient) other;
            return Intrinsics.areEqual(this.colors, radialGradient.colors) && Intrinsics.areEqual((Object) Float.valueOf(this.radius), (Object) Float.valueOf(radialGradient.radius));
        }

        public int hashCode() {
            return (this.colors.hashCode() * 31) + Float.hashCode(this.radius);
        }

        public String toString() {
            return "RadialGradient(colors=" + this.colors + ", radius=" + this.radius + ')';
        }

        public RadialGradient(List<Pair<Float, Integer>> colors, float f) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            this.colors = colors;
            this.radius = f;
        }

        public final List<Pair<Float, Integer>> getColors() {
            return this.colors;
        }

        public /* synthetic */ RadialGradient(List list, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? (float) Math.sqrt(2.0f) : f);
        }

        public final float getRadius() {
            return this.radius;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor
        public Paint createPaint(float width, float height) {
            Paint paint = new Paint();
            float f = 2;
            float f2 = width / f;
            float f3 = height / f;
            float max = (Math.max(width, height) / f) * RangesKt.coerceAtLeast(this.radius, 0.0f);
            List<Pair<Float, Integer>> list = this.colors;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((Number) ((Pair) it.next()).getSecond()).intValue()));
            }
            int[] intArray = CollectionsKt.toIntArray(arrayList);
            List<Pair<Float, Integer>> list2 = this.colors;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Float.valueOf(((Number) ((Pair) it2.next()).getFirst()).floatValue()));
            }
            paint.setShader(new android.graphics.RadialGradient(f2, f3, max, intArray, CollectionsKt.toFloatArray(arrayList2), Shader.TileMode.CLAMP));
            return paint;
        }
    }

    /* compiled from: QrVectorColor.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003¢\u0006\u0002\u0010\u0007J\u001b\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003HÆ\u0003J%\u0010\u000b\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003HÆ\u0001J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor$SweepGradient;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;", "colors", "", "Lkotlin/Pair;", "", "", "(Ljava/util/List;)V", "getColors", "()Ljava/util/List;", "component1", "copy", "createPaint", "Landroid/graphics/Paint;", "width", "height", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* data */ class SweepGradient implements QrVectorColor {
        private final List<Pair<Float, Integer>> colors;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SweepGradient copy$default(SweepGradient sweepGradient, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = sweepGradient.colors;
            }
            return sweepGradient.copy(list);
        }

        public final List<Pair<Float, Integer>> component1() {
            return this.colors;
        }

        public final SweepGradient copy(List<Pair<Float, Integer>> colors) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            return new SweepGradient(colors);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SweepGradient) && Intrinsics.areEqual(this.colors, ((SweepGradient) other).colors);
        }

        public int hashCode() {
            return this.colors.hashCode();
        }

        public String toString() {
            return "SweepGradient(colors=" + this.colors + ')';
        }

        public SweepGradient(List<Pair<Float, Integer>> colors) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            this.colors = colors;
        }

        public final List<Pair<Float, Integer>> getColors() {
            return this.colors;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor
        public Paint createPaint(float width, float height) {
            Paint paint = new Paint();
            float f = 2;
            float f2 = width / f;
            float f3 = height / f;
            List<Pair<Float, Integer>> list = this.colors;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((Number) ((Pair) it.next()).getSecond()).intValue()));
            }
            int[] intArray = CollectionsKt.toIntArray(arrayList);
            List<Pair<Float, Integer>> list2 = this.colors;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Float.valueOf(((Number) ((Pair) it2.next()).getFirst()).floatValue()));
            }
            paint.setShader(new android.graphics.SweepGradient(f2, f3, intArray, CollectionsKt.toFloatArray(arrayList2)));
            return paint;
        }
    }
}
