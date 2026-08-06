package io.noties.markwon.ext.onetex;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LatexMathTheme.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u0000 62\u00020\u0001:\u00044567B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Bq\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0003\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0003\u0010\u0013\u001a\u00020\u000e¢\u0006\u0002\u0010\u0014J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u000eHÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010)\u001a\u00020\fHÆ\u0003J\t\u0010*\u001a\u00020\u000eHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010-\u001a\u00020\u000eHÆ\u0003Ju\u0010.\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0003\u0010\u0012\u001a\u00020\u000e2\b\b\u0003\u0010\u0013\u001a\u00020\u000eHÆ\u0001J\u0013\u0010/\u001a\u00020\f2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u000eHÖ\u0001J\t\u00102\u001a\u000203HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\u0012\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001f¨\u00068"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexMathTheme;", "", "builder", "Lio/noties/markwon/ext/onetex/LatexMathTheme$Builder;", "(Lio/noties/markwon/ext/onetex/LatexMathTheme$Builder;)V", "inlineTextSize", "", "blockTextSize", "inlineBackgroundProvider", "Lio/noties/markwon/ext/onetex/LatexMathTheme$BackgroundProvider;", "blockBackgroundProvider", "blockFitCanvas", "", "blockHorizontalAlignment", "", "inlinePadding", "Lio/noties/markwon/ext/onetex/LatexMathTheme$Padding;", "blockPadding", "inlineTextColor", "blockTextColor", "(FFLio/noties/markwon/ext/onetex/LatexMathTheme$BackgroundProvider;Lio/noties/markwon/ext/onetex/LatexMathTheme$BackgroundProvider;ZILio/noties/markwon/ext/onetex/LatexMathTheme$Padding;Lio/noties/markwon/ext/onetex/LatexMathTheme$Padding;II)V", "getBlockBackgroundProvider", "()Lio/noties/markwon/ext/onetex/LatexMathTheme$BackgroundProvider;", "getBlockFitCanvas", "()Z", "getBlockHorizontalAlignment", "()I", "getBlockPadding", "()Lio/noties/markwon/ext/onetex/LatexMathTheme$Padding;", "getBlockTextColor", "getBlockTextSize", "()F", "getInlineBackgroundProvider", "getInlinePadding", "getInlineTextColor", "getInlineTextSize", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "BackgroundProvider", "Builder", "Companion", "Padding", "markwon-ext-onetex_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final /* data */ class LatexMathTheme {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final BackgroundProvider blockBackgroundProvider;
    private final boolean blockFitCanvas;
    private final int blockHorizontalAlignment;
    private final Padding blockPadding;
    private final int blockTextColor;
    private final float blockTextSize;
    private final BackgroundProvider inlineBackgroundProvider;
    private final Padding inlinePadding;
    private final int inlineTextColor;
    private final float inlineTextSize;

    /* compiled from: LatexMathTheme.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexMathTheme$BackgroundProvider;", "", "provide", "Landroid/graphics/drawable/Drawable;", "markwon-ext-onetex_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public interface BackgroundProvider {
        Drawable provide();
    }

    /* renamed from: component1, reason: from getter */
    public final float getInlineTextSize() {
        return this.inlineTextSize;
    }

    /* renamed from: component10, reason: from getter */
    public final int getBlockTextColor() {
        return this.blockTextColor;
    }

    /* renamed from: component2, reason: from getter */
    public final float getBlockTextSize() {
        return this.blockTextSize;
    }

    /* renamed from: component3, reason: from getter */
    public final BackgroundProvider getInlineBackgroundProvider() {
        return this.inlineBackgroundProvider;
    }

    /* renamed from: component4, reason: from getter */
    public final BackgroundProvider getBlockBackgroundProvider() {
        return this.blockBackgroundProvider;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getBlockFitCanvas() {
        return this.blockFitCanvas;
    }

    /* renamed from: component6, reason: from getter */
    public final int getBlockHorizontalAlignment() {
        return this.blockHorizontalAlignment;
    }

    /* renamed from: component7, reason: from getter */
    public final Padding getInlinePadding() {
        return this.inlinePadding;
    }

    /* renamed from: component8, reason: from getter */
    public final Padding getBlockPadding() {
        return this.blockPadding;
    }

    /* renamed from: component9, reason: from getter */
    public final int getInlineTextColor() {
        return this.inlineTextColor;
    }

    public final LatexMathTheme copy(float inlineTextSize, float blockTextSize, BackgroundProvider inlineBackgroundProvider, BackgroundProvider blockBackgroundProvider, boolean blockFitCanvas, int blockHorizontalAlignment, Padding inlinePadding, Padding blockPadding, int inlineTextColor, int blockTextColor) {
        return new LatexMathTheme(inlineTextSize, blockTextSize, inlineBackgroundProvider, blockBackgroundProvider, blockFitCanvas, blockHorizontalAlignment, inlinePadding, blockPadding, inlineTextColor, blockTextColor);
    }

    public boolean equals(Object other) {
        if (this != other) {
            if (other instanceof LatexMathTheme) {
                LatexMathTheme latexMathTheme = (LatexMathTheme) other;
                if (Float.compare(this.inlineTextSize, latexMathTheme.inlineTextSize) == 0 && Float.compare(this.blockTextSize, latexMathTheme.blockTextSize) == 0 && Intrinsics.areEqual(this.inlineBackgroundProvider, latexMathTheme.inlineBackgroundProvider) && Intrinsics.areEqual(this.blockBackgroundProvider, latexMathTheme.blockBackgroundProvider)) {
                    if (this.blockFitCanvas == latexMathTheme.blockFitCanvas) {
                        if ((this.blockHorizontalAlignment == latexMathTheme.blockHorizontalAlignment) && Intrinsics.areEqual(this.inlinePadding, latexMathTheme.inlinePadding) && Intrinsics.areEqual(this.blockPadding, latexMathTheme.blockPadding)) {
                            if (this.inlineTextColor == latexMathTheme.inlineTextColor) {
                                if (this.blockTextColor == latexMathTheme.blockTextColor) {
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((Float.floatToIntBits(this.inlineTextSize) * 31) + Float.floatToIntBits(this.blockTextSize)) * 31;
        BackgroundProvider backgroundProvider = this.inlineBackgroundProvider;
        int hashCode = (floatToIntBits + (backgroundProvider != null ? backgroundProvider.hashCode() : 0)) * 31;
        BackgroundProvider backgroundProvider2 = this.blockBackgroundProvider;
        int hashCode2 = (hashCode + (backgroundProvider2 != null ? backgroundProvider2.hashCode() : 0)) * 31;
        boolean z = this.blockFitCanvas;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (((hashCode2 + i) * 31) + this.blockHorizontalAlignment) * 31;
        Padding padding = this.inlinePadding;
        int hashCode3 = (i2 + (padding != null ? padding.hashCode() : 0)) * 31;
        Padding padding2 = this.blockPadding;
        return ((((hashCode3 + (padding2 != null ? padding2.hashCode() : 0)) * 31) + this.inlineTextColor) * 31) + this.blockTextColor;
    }

    public String toString() {
        return "LatexMathTheme(inlineTextSize=" + this.inlineTextSize + ", blockTextSize=" + this.blockTextSize + ", inlineBackgroundProvider=" + this.inlineBackgroundProvider + ", blockBackgroundProvider=" + this.blockBackgroundProvider + ", blockFitCanvas=" + this.blockFitCanvas + ", blockHorizontalAlignment=" + this.blockHorizontalAlignment + ", inlinePadding=" + this.inlinePadding + ", blockPadding=" + this.blockPadding + ", inlineTextColor=" + this.inlineTextColor + ", blockTextColor=" + this.blockTextColor + ")";
    }

    public LatexMathTheme(float f, float f2, BackgroundProvider backgroundProvider, BackgroundProvider backgroundProvider2, boolean z, int i, Padding padding, Padding padding2, int i2, int i3) {
        this.inlineTextSize = f;
        this.blockTextSize = f2;
        this.inlineBackgroundProvider = backgroundProvider;
        this.blockBackgroundProvider = backgroundProvider2;
        this.blockFitCanvas = z;
        this.blockHorizontalAlignment = i;
        this.inlinePadding = padding;
        this.blockPadding = padding2;
        this.inlineTextColor = i2;
        this.blockTextColor = i3;
    }

    public final float getInlineTextSize() {
        return this.inlineTextSize;
    }

    public final float getBlockTextSize() {
        return this.blockTextSize;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ LatexMathTheme(float f, float f2, BackgroundProvider backgroundProvider, BackgroundProvider backgroundProvider2, boolean z, int i, Padding padding, Padding padding2, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, r1, r2, r4, r5, r6, r7, r3, (i4 & 256) != 0 ? 0 : i2, (i4 & 512) == 0 ? i3 : 0);
        BackgroundProvider backgroundProvider3;
        BackgroundProvider backgroundProvider4;
        Padding padding3;
        float f3 = (i4 & 2) != 0 ? f : f2;
        Padding padding4 = null;
        if ((i4 & 4) != 0) {
            backgroundProvider3 = null;
        } else {
            backgroundProvider3 = backgroundProvider;
        }
        if ((i4 & 8) != 0) {
            backgroundProvider4 = null;
        } else {
            backgroundProvider4 = backgroundProvider2;
        }
        boolean z2 = (i4 & 16) != 0 ? true : z;
        int i5 = (i4 & 32) != 0 ? 17 : i;
        if ((i4 & 64) != 0) {
            padding3 = null;
        } else {
            padding3 = padding;
        }
        if ((i4 & 128) != 0) {
        } else {
            padding4 = padding2;
        }
    }

    public final BackgroundProvider getInlineBackgroundProvider() {
        return this.inlineBackgroundProvider;
    }

    public final BackgroundProvider getBlockBackgroundProvider() {
        return this.blockBackgroundProvider;
    }

    public final boolean getBlockFitCanvas() {
        return this.blockFitCanvas;
    }

    public final int getBlockHorizontalAlignment() {
        return this.blockHorizontalAlignment;
    }

    public final Padding getInlinePadding() {
        return this.inlinePadding;
    }

    public final Padding getBlockPadding() {
        return this.blockPadding;
    }

    public final int getInlineTextColor() {
        return this.inlineTextColor;
    }

    public final int getBlockTextColor() {
        return this.blockTextColor;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LatexMathTheme(Builder builder) {
        this(r3, r4, r5, r6, r7, r8, r9, r0 == null ? builder.getPadding() : r0, builder.getInlineTextColor() > 0 ? builder.getInlineTextColor() : builder.getTextColor(), builder.getBlockTextColor() > 0 ? builder.getBlockTextColor() : builder.getTextColor());
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        float f = 0;
        float inlineTextSize = builder.getInlineTextSize() > f ? builder.getInlineTextSize() : builder.getTextSize();
        float blockTextSize = builder.getBlockTextSize() > f ? builder.getBlockTextSize() : builder.getTextSize();
        BackgroundProvider inlineBackgroundProvider = builder.getInlineBackgroundProvider();
        BackgroundProvider backgroundProvider = inlineBackgroundProvider == null ? builder.getBackgroundProvider() : inlineBackgroundProvider;
        BackgroundProvider blockBackgroundProvider = builder.getBlockBackgroundProvider();
        BackgroundProvider backgroundProvider2 = blockBackgroundProvider == null ? builder.getBackgroundProvider() : blockBackgroundProvider;
        boolean blockFitCanvas = builder.getBlockFitCanvas();
        int blockHorizontalAlignment = builder.getBlockHorizontalAlignment();
        Padding inlinePadding = builder.getInlinePadding();
        Padding padding = inlinePadding == null ? builder.getPadding() : inlinePadding;
        Padding blockPadding = builder.getBlockPadding();
    }

    /* compiled from: LatexMathTheme.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001b"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexMathTheme$Padding;", "", "left", "", "top", "right", "bottom", "(IIII)V", "getBottom", "()I", "getLeft", "getRight", "getTop", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toRect", "Landroid/graphics/Rect;", "toString", "", "Companion", "markwon-ext-onetex_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final /* data */ class Padding {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int bottom;
        private final int left;
        private final int right;
        private final int top;

        public static /* synthetic */ Padding copy$default(Padding padding, int i, int i2, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = padding.left;
            }
            if ((i5 & 2) != 0) {
                i2 = padding.top;
            }
            if ((i5 & 4) != 0) {
                i3 = padding.right;
            }
            if ((i5 & 8) != 0) {
                i4 = padding.bottom;
            }
            return padding.copy(i, i2, i3, i4);
        }

        /* renamed from: component1, reason: from getter */
        public final int getLeft() {
            return this.left;
        }

        /* renamed from: component2, reason: from getter */
        public final int getTop() {
            return this.top;
        }

        /* renamed from: component3, reason: from getter */
        public final int getRight() {
            return this.right;
        }

        /* renamed from: component4, reason: from getter */
        public final int getBottom() {
            return this.bottom;
        }

        public final Padding copy(int left, int top, int right, int bottom) {
            return new Padding(left, top, right, bottom);
        }

        public boolean equals(Object other) {
            if (this != other) {
                if (other instanceof Padding) {
                    Padding padding = (Padding) other;
                    if (this.left == padding.left) {
                        if (this.top == padding.top) {
                            if (this.right == padding.right) {
                                if (this.bottom == padding.bottom) {
                                }
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
        }

        public String toString() {
            return "Padding(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ")";
        }

        public Padding(int i, int i2, int i3, int i4) {
            this.left = i;
            this.top = i2;
            this.right = i3;
            this.bottom = i4;
        }

        public final int getBottom() {
            return this.bottom;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getRight() {
            return this.right;
        }

        public final int getTop() {
            return this.top;
        }

        /* compiled from: LatexMathTheme.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J&\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006¨\u0006\u000f"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexMathTheme$Padding$Companion;", "", "()V", "all", "Lio/noties/markwon/ext/onetex/LatexMathTheme$Padding;", "value", "", "of", "left", "top", "right", "bottom", "symmetric", "vertical", "horizontal", "markwon-ext-onetex_release"}, k = 1, mv = {1, 1, 15})
        /* loaded from: classes7.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Padding all(int value) {
                return new Padding(value, value, value, value);
            }

            public final Padding symmetric(int vertical, int horizontal) {
                return new Padding(horizontal, vertical, horizontal, vertical);
            }

            public final Padding of(int left, int top, int right, int bottom) {
                return new Padding(left, top, right, bottom);
            }
        }

        public final Rect toRect() {
            return new Rect(this.left, this.top, this.right, this.bottom);
        }
    }

    /* compiled from: LatexMathTheme.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010\"\u001a\u00020\u00002\b\b\u0001\u0010\"\u001a\u00020\u0017J\u0006\u00108\u001a\u000209J\u0010\u0010'\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010\bJ\u0010\u0010*\u001a\u00020\u00002\b\u0010*\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010-\u001a\u00020\u00002\b\b\u0001\u0010-\u001a\u00020\u0017J\u0010\u00101\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010\u001dJ\u0010\u00104\u001a\u00020\u00002\b\b\u0001\u00104\u001a\u00020\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\n\"\u0004\b)\u0010\fR\u001c\u0010*\u001a\u0004\u0018\u00010\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001f\"\u0004\b,\u0010!R\u001a\u0010-\u001a\u00020\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0019\"\u0004\b/\u0010\u001bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u001c\u00101\u001a\u0004\u0018\u00010\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!R\u001a\u00104\u001a\u00020\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0019\"\u0004\b6\u0010\u001bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010&¨\u0006:"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexMathTheme$Builder;", "", "textSize", "", "inlineTextSize", "blockTextSize", "(FFF)V", "backgroundProvider", "Lio/noties/markwon/ext/onetex/LatexMathTheme$BackgroundProvider;", "getBackgroundProvider$markwon_ext_onetex_release", "()Lio/noties/markwon/ext/onetex/LatexMathTheme$BackgroundProvider;", "setBackgroundProvider$markwon_ext_onetex_release", "(Lio/noties/markwon/ext/onetex/LatexMathTheme$BackgroundProvider;)V", "blockBackgroundProvider", "getBlockBackgroundProvider$markwon_ext_onetex_release", "setBlockBackgroundProvider$markwon_ext_onetex_release", "blockFitCanvas", "", "getBlockFitCanvas$markwon_ext_onetex_release", "()Z", "setBlockFitCanvas$markwon_ext_onetex_release", "(Z)V", "blockHorizontalAlignment", "", "getBlockHorizontalAlignment$markwon_ext_onetex_release", "()I", "setBlockHorizontalAlignment$markwon_ext_onetex_release", "(I)V", "blockPadding", "Lio/noties/markwon/ext/onetex/LatexMathTheme$Padding;", "getBlockPadding$markwon_ext_onetex_release", "()Lio/noties/markwon/ext/onetex/LatexMathTheme$Padding;", "setBlockPadding$markwon_ext_onetex_release", "(Lio/noties/markwon/ext/onetex/LatexMathTheme$Padding;)V", "blockTextColor", "getBlockTextColor$markwon_ext_onetex_release", "setBlockTextColor$markwon_ext_onetex_release", "getBlockTextSize$markwon_ext_onetex_release", "()F", "inlineBackgroundProvider", "getInlineBackgroundProvider$markwon_ext_onetex_release", "setInlineBackgroundProvider$markwon_ext_onetex_release", "inlinePadding", "getInlinePadding$markwon_ext_onetex_release", "setInlinePadding$markwon_ext_onetex_release", "inlineTextColor", "getInlineTextColor$markwon_ext_onetex_release", "setInlineTextColor$markwon_ext_onetex_release", "getInlineTextSize$markwon_ext_onetex_release", "padding", "getPadding$markwon_ext_onetex_release", "setPadding$markwon_ext_onetex_release", "textColor", "getTextColor$markwon_ext_onetex_release", "setTextColor$markwon_ext_onetex_release", "getTextSize$markwon_ext_onetex_release", "build", "Lio/noties/markwon/ext/onetex/LatexMathTheme;", "markwon-ext-onetex_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final class Builder {
        private BackgroundProvider backgroundProvider;
        private BackgroundProvider blockBackgroundProvider;
        private boolean blockFitCanvas;
        private int blockHorizontalAlignment;
        private Padding blockPadding;
        private int blockTextColor;
        private final float blockTextSize;
        private BackgroundProvider inlineBackgroundProvider;
        private Padding inlinePadding;
        private int inlineTextColor;
        private final float inlineTextSize;
        private Padding padding;
        private int textColor;
        private final float textSize;

        public Builder(float f, float f2, float f3) {
            this.textSize = f;
            this.inlineTextSize = f2;
            this.blockTextSize = f3;
            BackgroundProvider backgroundProvider = this.backgroundProvider;
            this.inlineBackgroundProvider = backgroundProvider;
            this.blockBackgroundProvider = backgroundProvider;
            this.blockFitCanvas = true;
            this.blockHorizontalAlignment = 17;
            Padding padding = this.padding;
            this.inlinePadding = padding;
            this.blockPadding = padding;
            int i = this.textColor;
            this.inlineTextColor = i;
            this.blockTextColor = i;
        }

        /* renamed from: getTextSize$markwon_ext_onetex_release, reason: from getter */
        public final float getTextSize() {
            return this.textSize;
        }

        /* renamed from: getInlineTextSize$markwon_ext_onetex_release, reason: from getter */
        public final float getInlineTextSize() {
            return this.inlineTextSize;
        }

        /* renamed from: getBlockTextSize$markwon_ext_onetex_release, reason: from getter */
        public final float getBlockTextSize() {
            return this.blockTextSize;
        }

        /* renamed from: getBackgroundProvider$markwon_ext_onetex_release, reason: from getter */
        public final BackgroundProvider getBackgroundProvider() {
            return this.backgroundProvider;
        }

        public final void setBackgroundProvider$markwon_ext_onetex_release(BackgroundProvider backgroundProvider) {
            this.backgroundProvider = backgroundProvider;
        }

        /* renamed from: getInlineBackgroundProvider$markwon_ext_onetex_release, reason: from getter */
        public final BackgroundProvider getInlineBackgroundProvider() {
            return this.inlineBackgroundProvider;
        }

        public final void setInlineBackgroundProvider$markwon_ext_onetex_release(BackgroundProvider backgroundProvider) {
            this.inlineBackgroundProvider = backgroundProvider;
        }

        /* renamed from: getBlockBackgroundProvider$markwon_ext_onetex_release, reason: from getter */
        public final BackgroundProvider getBlockBackgroundProvider() {
            return this.blockBackgroundProvider;
        }

        public final void setBlockBackgroundProvider$markwon_ext_onetex_release(BackgroundProvider backgroundProvider) {
            this.blockBackgroundProvider = backgroundProvider;
        }

        /* renamed from: getBlockFitCanvas$markwon_ext_onetex_release, reason: from getter */
        public final boolean getBlockFitCanvas() {
            return this.blockFitCanvas;
        }

        public final void setBlockFitCanvas$markwon_ext_onetex_release(boolean z) {
            this.blockFitCanvas = z;
        }

        /* renamed from: getBlockHorizontalAlignment$markwon_ext_onetex_release, reason: from getter */
        public final int getBlockHorizontalAlignment() {
            return this.blockHorizontalAlignment;
        }

        public final void setBlockHorizontalAlignment$markwon_ext_onetex_release(int i) {
            this.blockHorizontalAlignment = i;
        }

        /* renamed from: getPadding$markwon_ext_onetex_release, reason: from getter */
        public final Padding getPadding() {
            return this.padding;
        }

        public final void setPadding$markwon_ext_onetex_release(Padding padding) {
            this.padding = padding;
        }

        /* renamed from: getInlinePadding$markwon_ext_onetex_release, reason: from getter */
        public final Padding getInlinePadding() {
            return this.inlinePadding;
        }

        public final void setInlinePadding$markwon_ext_onetex_release(Padding padding) {
            this.inlinePadding = padding;
        }

        /* renamed from: getBlockPadding$markwon_ext_onetex_release, reason: from getter */
        public final Padding getBlockPadding() {
            return this.blockPadding;
        }

        public final void setBlockPadding$markwon_ext_onetex_release(Padding padding) {
            this.blockPadding = padding;
        }

        /* renamed from: getTextColor$markwon_ext_onetex_release, reason: from getter */
        public final int getTextColor() {
            return this.textColor;
        }

        public final void setTextColor$markwon_ext_onetex_release(int i) {
            this.textColor = i;
        }

        /* renamed from: getInlineTextColor$markwon_ext_onetex_release, reason: from getter */
        public final int getInlineTextColor() {
            return this.inlineTextColor;
        }

        public final void setInlineTextColor$markwon_ext_onetex_release(int i) {
            this.inlineTextColor = i;
        }

        /* renamed from: getBlockTextColor$markwon_ext_onetex_release, reason: from getter */
        public final int getBlockTextColor() {
            return this.blockTextColor;
        }

        public final void setBlockTextColor$markwon_ext_onetex_release(int i) {
            this.blockTextColor = i;
        }

        public final Builder backgroundProvider(BackgroundProvider backgroundProvider) {
            this.backgroundProvider = backgroundProvider;
            this.inlineBackgroundProvider = backgroundProvider;
            this.blockBackgroundProvider = backgroundProvider;
            return this;
        }

        public final Builder inlineBackgroundProvider(BackgroundProvider inlineBackgroundProvider) {
            this.inlineBackgroundProvider = inlineBackgroundProvider;
            return this;
        }

        public final Builder blockBackgroundProvider(BackgroundProvider blockBackgroundProvider) {
            this.blockBackgroundProvider = blockBackgroundProvider;
            return this;
        }

        public final Builder blockFitCanvas(boolean blockFitCanvas) {
            this.blockFitCanvas = blockFitCanvas;
            return this;
        }

        public final Builder blockHorizontalAlignment(int blockHorizontalAlignment) {
            this.blockHorizontalAlignment = blockHorizontalAlignment;
            return this;
        }

        public final Builder padding(Padding padding) {
            this.padding = padding;
            this.inlinePadding = padding;
            this.blockPadding = padding;
            return this;
        }

        public final Builder inlinePadding(Padding inlinePadding) {
            this.inlinePadding = inlinePadding;
            return this;
        }

        public final Builder blockPadding(Padding blockPadding) {
            this.blockPadding = blockPadding;
            return this;
        }

        public final Builder textColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        public final Builder inlineTextColor(int inlineTextColor) {
            this.inlineTextColor = inlineTextColor;
            return this;
        }

        public final Builder blockTextColor(int blockTextColor) {
            this.blockTextColor = blockTextColor;
            return this;
        }

        public final LatexMathTheme build() {
            return new LatexMathTheme(this);
        }
    }

    /* compiled from: LatexMathTheme.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006¨\u0006\u000b"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexMathTheme$Companion;", "", "()V", "builder", "Lio/noties/markwon/ext/onetex/LatexMathTheme$Builder;", "textSize", "", "inlineTextSize", "blockTextSize", "create", "Lio/noties/markwon/ext/onetex/LatexMathTheme;", "markwon-ext-onetex_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LatexMathTheme create(float textSize) {
            return builder(textSize).build();
        }

        public final LatexMathTheme create(float inlineTextSize, float blockTextSize) {
            return builder(inlineTextSize, blockTextSize).build();
        }

        public final Builder builder(float textSize) {
            return new Builder(textSize, 0.0f, 0.0f);
        }

        public final Builder builder(float inlineTextSize, float blockTextSize) {
            return new Builder(0.0f, inlineTextSize, blockTextSize);
        }
    }
}
