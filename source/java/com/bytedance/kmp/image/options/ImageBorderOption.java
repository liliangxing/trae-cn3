package com.bytedance.kmp.image.options;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ImageBorderOptions.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010\u0013\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0010J\u0016\u0010\u0015\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0010J\u0016\u0010\u0017\u001a\u00020\u0006HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\rJ\t\u0010\u0019\u001a\u00020\bHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Lcom/bytedance/kmp/image/options/ImageBorderOption;", "", "borderWidth", "Landroidx/compose/ui/unit/Dp;", "radius", "borderColor", "Landroidx/compose/ui/graphics/Color;", "asCircle", "", "(FFJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAsCircle", "()Z", "getBorderColor-0d7_KjU", "()J", "J", "getBorderWidth-D9Ej5fM", "()F", "F", "getRadius-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "component3", "component3-0d7_KjU", "component4", "copy", "copy-pqm8yaE", "(FFJZ)Lcom/bytedance/kmp/image/options/ImageBorderOption;", "equals", "other", "hashCode", "", "toString", "", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class ImageBorderOption {
    public static final int $stable = 0;
    private final boolean asCircle;
    private final long borderColor;
    private final float borderWidth;
    private final float radius;

    public /* synthetic */ ImageBorderOption(float f, float f2, long j, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, j, z);
    }

    /* renamed from: copy-pqm8yaE$default, reason: not valid java name */
    public static /* synthetic */ ImageBorderOption m647copypqm8yaE$default(ImageBorderOption imageBorderOption, float f, float f2, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            f = imageBorderOption.borderWidth;
        }
        if ((i & 2) != 0) {
            f2 = imageBorderOption.radius;
        }
        float f3 = f2;
        if ((i & 4) != 0) {
            j = imageBorderOption.borderColor;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            z = imageBorderOption.asCircle;
        }
        return imageBorderOption.m651copypqm8yaE(f, f3, j2, z);
    }

    /* renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
    public final float getBorderWidth() {
        return this.borderWidth;
    }

    /* renamed from: component2-D9Ej5fM, reason: not valid java name and from getter */
    public final float getRadius() {
        return this.radius;
    }

    /* renamed from: component3-0d7_KjU, reason: not valid java name and from getter */
    public final long getBorderColor() {
        return this.borderColor;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getAsCircle() {
        return this.asCircle;
    }

    /* renamed from: copy-pqm8yaE, reason: not valid java name */
    public final ImageBorderOption m651copypqm8yaE(float borderWidth, float radius, long borderColor, boolean asCircle) {
        return new ImageBorderOption(borderWidth, radius, borderColor, asCircle, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageBorderOption)) {
            return false;
        }
        ImageBorderOption imageBorderOption = (ImageBorderOption) other;
        return Dp.equals-impl0(this.borderWidth, imageBorderOption.borderWidth) && Dp.equals-impl0(this.radius, imageBorderOption.radius) && Color.equals-impl0(this.borderColor, imageBorderOption.borderColor) && this.asCircle == imageBorderOption.asCircle;
    }

    public int hashCode() {
        return (((((Dp.hashCode-impl(this.borderWidth) * 31) + Dp.hashCode-impl(this.radius)) * 31) + Color.hashCode-impl(this.borderColor)) * 31) + Boolean.hashCode(this.asCircle);
    }

    public String toString() {
        return "ImageBorderOption(borderWidth=" + ((Object) Dp.toString-impl(this.borderWidth)) + ", radius=" + ((Object) Dp.toString-impl(this.radius)) + ", borderColor=" + ((Object) Color.toString-impl(this.borderColor)) + ", asCircle=" + this.asCircle + ')';
    }

    private ImageBorderOption(float f, float f2, long j, boolean z) {
        this.borderWidth = f;
        this.radius = f2;
        this.borderColor = j;
        this.asCircle = z;
    }

    public final boolean getAsCircle() {
        return this.asCircle;
    }

    /* renamed from: getBorderColor-0d7_KjU, reason: not valid java name */
    public final long m652getBorderColor0d7_KjU() {
        return this.borderColor;
    }

    /* renamed from: getBorderWidth-D9Ej5fM, reason: not valid java name */
    public final float m653getBorderWidthD9Ej5fM() {
        return this.borderWidth;
    }

    /* renamed from: getRadius-D9Ej5fM, reason: not valid java name */
    public final float m654getRadiusD9Ej5fM() {
        return this.radius;
    }

    public /* synthetic */ ImageBorderOption(float f, float f2, long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.constructor-impl(0) : f, (i & 2) != 0 ? Dp.constructor-impl(0) : f2, (i & 4) != 0 ? Color.Companion.getTransparent-0d7_KjU() : j, (i & 8) != 0 ? false : z, null);
    }
}
