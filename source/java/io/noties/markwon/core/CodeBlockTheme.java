package io.noties.markwon.core;

import android.graphics.Typeface;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodeBlockTheme.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\u0006\u0012\b\b\u0001\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003Jm\u0010)\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u00062\b\b\u0003\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0003\u0010\u000e\u001a\u00020\u00062\b\b\u0003\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lio/noties/markwon/core/CodeBlockTheme;", "", "codeBlockBgColor", "", "codeBlockWidth", "codeBlockTextSize", "", "codeBlockRadius", "codeBlockHPadding", "codeBlockVPadding", "codeTypeface", "Landroid/graphics/Typeface;", "scrollable", "", "borderWidth", "borderColor", "(IIFFFFLandroid/graphics/Typeface;ZFI)V", "getBorderColor", "()I", "getBorderWidth", "()F", "getCodeBlockBgColor", "getCodeBlockHPadding", "getCodeBlockRadius", "getCodeBlockTextSize", "getCodeBlockVPadding", "getCodeBlockWidth", "getCodeTypeface", "()Landroid/graphics/Typeface;", "getScrollable", "()Z", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final /* data */ class CodeBlockTheme {
    private final int borderColor;
    private final float borderWidth;
    private final int codeBlockBgColor;
    private final float codeBlockHPadding;
    private final float codeBlockRadius;
    private final float codeBlockTextSize;
    private final float codeBlockVPadding;
    private final int codeBlockWidth;
    private final Typeface codeTypeface;
    private final boolean scrollable;

    /* renamed from: component1, reason: from getter */
    public final int getCodeBlockBgColor() {
        return this.codeBlockBgColor;
    }

    /* renamed from: component10, reason: from getter */
    public final int getBorderColor() {
        return this.borderColor;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCodeBlockWidth() {
        return this.codeBlockWidth;
    }

    /* renamed from: component3, reason: from getter */
    public final float getCodeBlockTextSize() {
        return this.codeBlockTextSize;
    }

    /* renamed from: component4, reason: from getter */
    public final float getCodeBlockRadius() {
        return this.codeBlockRadius;
    }

    /* renamed from: component5, reason: from getter */
    public final float getCodeBlockHPadding() {
        return this.codeBlockHPadding;
    }

    /* renamed from: component6, reason: from getter */
    public final float getCodeBlockVPadding() {
        return this.codeBlockVPadding;
    }

    /* renamed from: component7, reason: from getter */
    public final Typeface getCodeTypeface() {
        return this.codeTypeface;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getScrollable() {
        return this.scrollable;
    }

    /* renamed from: component9, reason: from getter */
    public final float getBorderWidth() {
        return this.borderWidth;
    }

    public final CodeBlockTheme copy(int codeBlockBgColor, int codeBlockWidth, float codeBlockTextSize, float codeBlockRadius, float codeBlockHPadding, float codeBlockVPadding, Typeface codeTypeface, boolean scrollable, float borderWidth, int borderColor) {
        Intrinsics.checkParameterIsNotNull(codeTypeface, "codeTypeface");
        return new CodeBlockTheme(codeBlockBgColor, codeBlockWidth, codeBlockTextSize, codeBlockRadius, codeBlockHPadding, codeBlockVPadding, codeTypeface, scrollable, borderWidth, borderColor);
    }

    public boolean equals(Object other) {
        if (this != other) {
            if (other instanceof CodeBlockTheme) {
                CodeBlockTheme codeBlockTheme = (CodeBlockTheme) other;
                if (this.codeBlockBgColor == codeBlockTheme.codeBlockBgColor) {
                    if ((this.codeBlockWidth == codeBlockTheme.codeBlockWidth) && Float.compare(this.codeBlockTextSize, codeBlockTheme.codeBlockTextSize) == 0 && Float.compare(this.codeBlockRadius, codeBlockTheme.codeBlockRadius) == 0 && Float.compare(this.codeBlockHPadding, codeBlockTheme.codeBlockHPadding) == 0 && Float.compare(this.codeBlockVPadding, codeBlockTheme.codeBlockVPadding) == 0 && Intrinsics.areEqual(this.codeTypeface, codeBlockTheme.codeTypeface)) {
                        if ((this.scrollable == codeBlockTheme.scrollable) && Float.compare(this.borderWidth, codeBlockTheme.borderWidth) == 0) {
                            if (this.borderColor == codeBlockTheme.borderColor) {
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
        int floatToIntBits = ((((((((((this.codeBlockBgColor * 31) + this.codeBlockWidth) * 31) + Float.floatToIntBits(this.codeBlockTextSize)) * 31) + Float.floatToIntBits(this.codeBlockRadius)) * 31) + Float.floatToIntBits(this.codeBlockHPadding)) * 31) + Float.floatToIntBits(this.codeBlockVPadding)) * 31;
        Typeface typeface = this.codeTypeface;
        int hashCode = (floatToIntBits + (typeface != null ? typeface.hashCode() : 0)) * 31;
        boolean z = this.scrollable;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((((hashCode + i) * 31) + Float.floatToIntBits(this.borderWidth)) * 31) + this.borderColor;
    }

    public String toString() {
        return "CodeBlockTheme(codeBlockBgColor=" + this.codeBlockBgColor + ", codeBlockWidth=" + this.codeBlockWidth + ", codeBlockTextSize=" + this.codeBlockTextSize + ", codeBlockRadius=" + this.codeBlockRadius + ", codeBlockHPadding=" + this.codeBlockHPadding + ", codeBlockVPadding=" + this.codeBlockVPadding + ", codeTypeface=" + this.codeTypeface + ", scrollable=" + this.scrollable + ", borderWidth=" + this.borderWidth + ", borderColor=" + this.borderColor + ")";
    }

    public CodeBlockTheme(int i, int i2, float f, float f2, float f3, float f4, Typeface codeTypeface, boolean z, float f5, int i3) {
        Intrinsics.checkParameterIsNotNull(codeTypeface, "codeTypeface");
        this.codeBlockBgColor = i;
        this.codeBlockWidth = i2;
        this.codeBlockTextSize = f;
        this.codeBlockRadius = f2;
        this.codeBlockHPadding = f3;
        this.codeBlockVPadding = f4;
        this.codeTypeface = codeTypeface;
        this.scrollable = z;
        this.borderWidth = f5;
        this.borderColor = i3;
    }

    public final int getCodeBlockBgColor() {
        return this.codeBlockBgColor;
    }

    public final int getCodeBlockWidth() {
        return this.codeBlockWidth;
    }

    public final float getCodeBlockTextSize() {
        return this.codeBlockTextSize;
    }

    public final float getCodeBlockRadius() {
        return this.codeBlockRadius;
    }

    public final float getCodeBlockHPadding() {
        return this.codeBlockHPadding;
    }

    public final float getCodeBlockVPadding() {
        return this.codeBlockVPadding;
    }

    public final Typeface getCodeTypeface() {
        return this.codeTypeface;
    }

    public /* synthetic */ CodeBlockTheme(int i, int i2, float f, float f2, float f3, float f4, Typeface typeface, boolean z, float f5, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, f, f2, f3, f4, typeface, (i4 & 128) != 0 ? true : z, f5, i3);
    }

    public final boolean getScrollable() {
        return this.scrollable;
    }

    public final float getBorderWidth() {
        return this.borderWidth;
    }

    public final int getBorderColor() {
        return this.borderColor;
    }
}
