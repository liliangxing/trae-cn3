package androidx.compose.p002ui.graphics;

import androidx.compose.foundation.text.input.internal.PartialGapBuffer;
import androidx.compose.p002ui.graphics.colorspace.ColorSpace;
import androidx.compose.p002ui.graphics.colorspace.ColorSpaceKt;
import androidx.compose.p002ui.graphics.colorspace.ColorSpaces;
import androidx.compose.p002ui.graphics.colorspace.Rgb;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Color.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 62\u00020\u0001:\u00016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010 \u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b!\u0010\u0016J\u0010\u0010\"\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b#\u0010\u0016J\u0010\u0010$\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b%\u0010\u0016J\u0010\u0010&\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b'\u0010\u0016J\u0010\u0010(\u001a\u00020\nH\u0087\n¢\u0006\u0004\b)\u0010\u000eJ7\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u0013H\u0007¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\f\u001a\u0004\b\u001f\u0010\u0016\u0088\u0001\u0002¨\u00067"}, d2 = {"Landroidx/compose/ui/graphics/Color;", "", "value", "Lkotlin/ULong;", "constructor-impl", "(J)J", "getValue-s-VKNKU", "()J", "J", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getColorSpace$annotations", "()V", "getColorSpace-impl", "(J)Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "convert", "convert-vNxB06k", "(JLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "red", "", "getRed$annotations", "getRed-impl", "(J)F", "green", "getGreen$annotations", "getGreen-impl", "blue", "getBlue$annotations", "getBlue-impl", "alpha", "getAlpha$annotations", "getAlpha-impl", "component1", "component1-impl", "component2", "component2-impl", "component3", "component3-impl", "component4", "component4-impl", "component5", "component5-impl", "copy", "copy-wmQWz5c", "(JFFFF)J", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "hashCode", "", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class Color {
    private final long value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Black = ColorKt.Color(4278190080L);
    private static final long DarkGray = ColorKt.Color(4282664004L);
    private static final long Gray = ColorKt.Color(4287137928L);
    private static final long LightGray = ColorKt.Color(4291611852L);
    private static final long White = ColorKt.Color(4294967295L);
    private static final long Red = ColorKt.Color(4294901760L);
    private static final long Green = ColorKt.Color(4278255360L);
    private static final long Blue = ColorKt.Color(4278190335L);
    private static final long Yellow = ColorKt.Color(4294967040L);
    private static final long Cyan = ColorKt.Color(4278255615L);
    private static final long Magenta = ColorKt.Color(4294902015L);
    private static final long Transparent = ColorKt.Color(0);
    private static final long Unspecified = ColorKt.Color(0.0f, 0.0f, 0.0f, 0.0f, ColorSpaces.INSTANCE.getUnspecified$ui_graphics_release());

    /* renamed from: box-impl */
    public static final /* synthetic */ Color m4829boximpl(long j) {
        return new Color(j);
    }

    /* renamed from: constructor-impl */
    public static long m4835constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl */
    public static boolean m4839equalsimpl(long j, Object obj) {
        return (obj instanceof Color) && j == ((Color) obj).m4849unboximpl();
    }

    /* renamed from: equals-impl0 */
    public static final boolean m4840equalsimpl0(long j, long j2) {
        return ULong.equals-impl0(j, j2);
    }

    public static /* synthetic */ void getAlpha$annotations() {
    }

    public static /* synthetic */ void getBlue$annotations() {
    }

    public static /* synthetic */ void getColorSpace$annotations() {
    }

    public static /* synthetic */ void getGreen$annotations() {
    }

    public static /* synthetic */ void getRed$annotations() {
    }

    /* renamed from: hashCode-impl */
    public static int m4846hashCodeimpl(long j) {
        return ULong.hashCode-impl(j);
    }

    public boolean equals(Object other) {
        return m4839equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m4846hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ long m4849unboximpl() {
        return this.value;
    }

    private /* synthetic */ Color(long j) {
        this.value = j;
    }

    /* renamed from: getValue-s-VKNKU, reason: from getter */
    public final long getValue() {
        return this.value;
    }

    /* renamed from: getColorSpace-impl */
    public static final ColorSpace m4843getColorSpaceimpl(long j) {
        ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
        return colorSpaces.getColorSpacesArray$ui_graphics_release()[(int) ULong.constructor-impl(j & 63)];
    }

    /* renamed from: convert-vNxB06k */
    public static final long m4836convertvNxB06k(long j, ColorSpace colorSpace) {
        return ColorSpaceKt.m5278connectYBCOT_4$default(m4843getColorSpaceimpl(j), colorSpace, 0, 2, null).mo5282transformToColorl2rxGTc$ui_graphics_release(j);
    }

    /* renamed from: getRed-impl */
    public static final float m4845getRedimpl(long j) {
        int i;
        int i2;
        int i3;
        if (ULong.constructor-impl(63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.constructor-impl(ULong.constructor-impl(j >>> 48) & 255))) / 255.0f;
        }
        int i4 = ((short) ULong.constructor-impl(ULong.constructor-impl(j >>> 48) & 65535)) & 65535;
        int i5 = 32768 & i4;
        int i6 = (i4 >>> 10) & 31;
        int i7 = i4 & 1023;
        if (i6 != 0) {
            int i8 = i7 << 13;
            if (i6 == 31) {
                i = PartialGapBuffer.BUF_SIZE;
                if (i8 != 0) {
                    i8 |= 4194304;
                }
            } else {
                i = (i6 - 15) + 127;
            }
            int i9 = i;
            i2 = i8;
            i3 = i9;
        } else {
            if (i7 != 0) {
                float intBitsToFloat = Float.intBitsToFloat(i7 + 1056964608) - Float16Kt.Fp32DenormalFloat;
                return i5 == 0 ? intBitsToFloat : -intBitsToFloat;
            }
            i3 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i3 << 23) | (i5 << 16) | i2);
    }

    /* renamed from: getGreen-impl */
    public static final float m4844getGreenimpl(long j) {
        int i;
        int i2;
        int i3;
        if (ULong.constructor-impl(63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.constructor-impl(ULong.constructor-impl(j >>> 40) & 255))) / 255.0f;
        }
        int i4 = ((short) ULong.constructor-impl(ULong.constructor-impl(j >>> 32) & 65535)) & 65535;
        int i5 = 32768 & i4;
        int i6 = (i4 >>> 10) & 31;
        int i7 = i4 & 1023;
        if (i6 != 0) {
            int i8 = i7 << 13;
            if (i6 == 31) {
                i = PartialGapBuffer.BUF_SIZE;
                if (i8 != 0) {
                    i8 |= 4194304;
                }
            } else {
                i = (i6 - 15) + 127;
            }
            int i9 = i;
            i2 = i8;
            i3 = i9;
        } else {
            if (i7 != 0) {
                float intBitsToFloat = Float.intBitsToFloat(i7 + 1056964608) - Float16Kt.Fp32DenormalFloat;
                return i5 == 0 ? intBitsToFloat : -intBitsToFloat;
            }
            i3 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i3 << 23) | (i5 << 16) | i2);
    }

    /* renamed from: getBlue-impl */
    public static final float m4842getBlueimpl(long j) {
        int i;
        int i2;
        int i3;
        if (ULong.constructor-impl(63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.constructor-impl(ULong.constructor-impl(j >>> 32) & 255))) / 255.0f;
        }
        int i4 = ((short) ULong.constructor-impl(ULong.constructor-impl(j >>> 16) & 65535)) & 65535;
        int i5 = 32768 & i4;
        int i6 = (i4 >>> 10) & 31;
        int i7 = i4 & 1023;
        if (i6 != 0) {
            int i8 = i7 << 13;
            if (i6 == 31) {
                i = PartialGapBuffer.BUF_SIZE;
                if (i8 != 0) {
                    i8 |= 4194304;
                }
            } else {
                i = (i6 - 15) + 127;
            }
            int i9 = i;
            i2 = i8;
            i3 = i9;
        } else {
            if (i7 != 0) {
                float intBitsToFloat = Float.intBitsToFloat(i7 + 1056964608) - Float16Kt.Fp32DenormalFloat;
                return i5 == 0 ? intBitsToFloat : -intBitsToFloat;
            }
            i3 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i3 << 23) | (i5 << 16) | i2);
    }

    /* renamed from: getAlpha-impl */
    public static final float m4841getAlphaimpl(long j) {
        float ulongToDouble;
        float f;
        if (ULong.constructor-impl(63 & j) == 0) {
            ulongToDouble = (float) UnsignedKt.ulongToDouble(ULong.constructor-impl(ULong.constructor-impl(j >>> 56) & 255));
            f = 255.0f;
        } else {
            ulongToDouble = (float) UnsignedKt.ulongToDouble(ULong.constructor-impl(ULong.constructor-impl(j >>> 6) & 1023));
            f = 1023.0f;
        }
        return ulongToDouble / f;
    }

    /* renamed from: component1-impl */
    public static final float m4830component1impl(long j) {
        return m4845getRedimpl(j);
    }

    /* renamed from: component2-impl */
    public static final float m4831component2impl(long j) {
        return m4844getGreenimpl(j);
    }

    /* renamed from: component3-impl */
    public static final float m4832component3impl(long j) {
        return m4842getBlueimpl(j);
    }

    /* renamed from: component4-impl */
    public static final float m4833component4impl(long j) {
        return m4841getAlphaimpl(j);
    }

    /* renamed from: component5-impl */
    public static final ColorSpace m4834component5impl(long j) {
        return m4843getColorSpaceimpl(j);
    }

    /* renamed from: copy-wmQWz5c$default */
    public static /* synthetic */ long m4838copywmQWz5c$default(long j, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m4841getAlphaimpl(j);
        }
        float f5 = f;
        if ((i & 2) != 0) {
            f2 = m4845getRedimpl(j);
        }
        float f6 = f2;
        if ((i & 4) != 0) {
            f3 = m4844getGreenimpl(j);
        }
        float f7 = f3;
        if ((i & 8) != 0) {
            f4 = m4842getBlueimpl(j);
        }
        return m4837copywmQWz5c(j, f5, f6, f7, f4);
    }

    /* renamed from: copy-wmQWz5c */
    public static final long m4837copywmQWz5c(long j, float f, float f2, float f3, float f4) {
        return ColorKt.Color(f2, f3, f4, f, m4843getColorSpaceimpl(j));
    }

    public String toString() {
        return m4847toStringimpl(this.value);
    }

    /* renamed from: toString-impl */
    public static String m4847toStringimpl(long j) {
        return "Color(" + m4845getRedimpl(j) + ", " + m4844getGreenimpl(j) + ", " + m4842getBlueimpl(j) + ", " + m4841getAlphaimpl(j) + ", " + m4843getColorSpaceimpl(j).getName() + ')';
    }

    /* compiled from: Color.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u0002002\b\b\u0002\u00103\u001a\u0002002\b\b\u0002\u00104\u001a\u000205¢\u0006\u0004\b6\u00107J(\u00108\u001a\u0002002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u0002002\u0006\u0010<\u001a\u0002002\u0006\u0010=\u001a\u000200H\u0002J9\u0010>\u001a\u00020\u00052\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u0010?\u001a\u0002002\b\b\u0002\u00103\u001a\u0002002\b\b\u0002\u00104\u001a\u000205¢\u0006\u0004\b@\u00107J(\u0010A\u001a\u0002002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u0002002\u0006\u0010<\u001a\u0002002\u0006\u0010B\u001a\u000200H\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\bR\u001e\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\bR\u001e\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\bR\u001e\u0010\u0019\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\bR\u001e\u0010\u001c\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u001d\u0010\u0003\u001a\u0004\b\u001e\u0010\bR\u001e\u0010\u001f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b \u0010\u0003\u001a\u0004\b!\u0010\bR\u001e\u0010\"\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b#\u0010\u0003\u001a\u0004\b$\u0010\bR\u001e\u0010%\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b&\u0010\u0003\u001a\u0004\b'\u0010\bR\u001e\u0010(\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b)\u0010\u0003\u001a\u0004\b*\u0010\bR\u001e\u0010+\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b,\u0010\u0003\u001a\u0004\b-\u0010\b¨\u0006C"}, d2 = {"Landroidx/compose/ui/graphics/Color$Companion;", "", "<init>", "()V", "Black", "Landroidx/compose/ui/graphics/Color;", "getBlack-0d7_KjU$annotations", "getBlack-0d7_KjU", "()J", "J", "DarkGray", "getDarkGray-0d7_KjU$annotations", "getDarkGray-0d7_KjU", "Gray", "getGray-0d7_KjU$annotations", "getGray-0d7_KjU", "LightGray", "getLightGray-0d7_KjU$annotations", "getLightGray-0d7_KjU", "White", "getWhite-0d7_KjU$annotations", "getWhite-0d7_KjU", "Red", "getRed-0d7_KjU$annotations", "getRed-0d7_KjU", "Green", "getGreen-0d7_KjU$annotations", "getGreen-0d7_KjU", "Blue", "getBlue-0d7_KjU$annotations", "getBlue-0d7_KjU", "Yellow", "getYellow-0d7_KjU$annotations", "getYellow-0d7_KjU", "Cyan", "getCyan-0d7_KjU$annotations", "getCyan-0d7_KjU", "Magenta", "getMagenta-0d7_KjU$annotations", "getMagenta-0d7_KjU", "Transparent", "getTransparent-0d7_KjU$annotations", "getTransparent-0d7_KjU", "Unspecified", "getUnspecified-0d7_KjU$annotations", "getUnspecified-0d7_KjU", "hsv", "hue", "", "saturation", "value", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "hsv-JlNiLsg", "(FFFFLandroidx/compose/ui/graphics/colorspace/Rgb;)J", "hsvToRgbComponent", "n", "", "h", "s", "v", "hsl", "lightness", "hsl-JlNiLsg", "hslToRgbComponent", "l", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getBlack-0d7_KjU$annotations */
        public static /* synthetic */ void m4850getBlack0d7_KjU$annotations() {
        }

        /* renamed from: getBlue-0d7_KjU$annotations */
        public static /* synthetic */ void m4851getBlue0d7_KjU$annotations() {
        }

        /* renamed from: getCyan-0d7_KjU$annotations */
        public static /* synthetic */ void m4852getCyan0d7_KjU$annotations() {
        }

        /* renamed from: getDarkGray-0d7_KjU$annotations */
        public static /* synthetic */ void m4853getDarkGray0d7_KjU$annotations() {
        }

        /* renamed from: getGray-0d7_KjU$annotations */
        public static /* synthetic */ void m4854getGray0d7_KjU$annotations() {
        }

        /* renamed from: getGreen-0d7_KjU$annotations */
        public static /* synthetic */ void m4855getGreen0d7_KjU$annotations() {
        }

        /* renamed from: getLightGray-0d7_KjU$annotations */
        public static /* synthetic */ void m4856getLightGray0d7_KjU$annotations() {
        }

        /* renamed from: getMagenta-0d7_KjU$annotations */
        public static /* synthetic */ void m4857getMagenta0d7_KjU$annotations() {
        }

        /* renamed from: getRed-0d7_KjU$annotations */
        public static /* synthetic */ void m4858getRed0d7_KjU$annotations() {
        }

        /* renamed from: getTransparent-0d7_KjU$annotations */
        public static /* synthetic */ void m4859getTransparent0d7_KjU$annotations() {
        }

        /* renamed from: getUnspecified-0d7_KjU$annotations */
        public static /* synthetic */ void m4860getUnspecified0d7_KjU$annotations() {
        }

        /* renamed from: getWhite-0d7_KjU$annotations */
        public static /* synthetic */ void m4861getWhite0d7_KjU$annotations() {
        }

        /* renamed from: getYellow-0d7_KjU$annotations */
        public static /* synthetic */ void m4862getYellow0d7_KjU$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getBlack-0d7_KjU */
        public final long m4865getBlack0d7_KjU() {
            return Color.Black;
        }

        /* renamed from: getDarkGray-0d7_KjU */
        public final long m4868getDarkGray0d7_KjU() {
            return Color.DarkGray;
        }

        /* renamed from: getGray-0d7_KjU */
        public final long m4869getGray0d7_KjU() {
            return Color.Gray;
        }

        /* renamed from: getLightGray-0d7_KjU */
        public final long m4871getLightGray0d7_KjU() {
            return Color.LightGray;
        }

        /* renamed from: getWhite-0d7_KjU */
        public final long m4876getWhite0d7_KjU() {
            return Color.White;
        }

        /* renamed from: getRed-0d7_KjU */
        public final long m4873getRed0d7_KjU() {
            return Color.Red;
        }

        /* renamed from: getGreen-0d7_KjU */
        public final long m4870getGreen0d7_KjU() {
            return Color.Green;
        }

        /* renamed from: getBlue-0d7_KjU */
        public final long m4866getBlue0d7_KjU() {
            return Color.Blue;
        }

        /* renamed from: getYellow-0d7_KjU */
        public final long m4877getYellow0d7_KjU() {
            return Color.Yellow;
        }

        /* renamed from: getCyan-0d7_KjU */
        public final long m4867getCyan0d7_KjU() {
            return Color.Cyan;
        }

        /* renamed from: getMagenta-0d7_KjU */
        public final long m4872getMagenta0d7_KjU() {
            return Color.Magenta;
        }

        /* renamed from: getTransparent-0d7_KjU */
        public final long m4874getTransparent0d7_KjU() {
            return Color.Transparent;
        }

        /* renamed from: getUnspecified-0d7_KjU */
        public final long m4875getUnspecified0d7_KjU() {
            return Color.Unspecified;
        }

        /* renamed from: hsv-JlNiLsg$default */
        public static /* synthetic */ long m4864hsvJlNiLsg$default(Companion companion, float f, float f2, float f3, float f4, Rgb rgb, int i, Object obj) {
            if ((i & 8) != 0) {
                f4 = 1.0f;
            }
            float f5 = f4;
            if ((i & 16) != 0) {
                rgb = ColorSpaces.INSTANCE.getSrgb();
            }
            return companion.m4879hsvJlNiLsg(f, f2, f3, f5, rgb);
        }

        /* renamed from: hsv-JlNiLsg */
        public final long m4879hsvJlNiLsg(float hue, float saturation, float value, float alpha, Rgb colorSpace) {
            boolean z = false;
            if (0.0f <= hue && hue <= 360.0f) {
                if (0.0f <= saturation && saturation <= 1.0f) {
                    if (0.0f <= value && value <= 1.0f) {
                        z = true;
                    }
                }
            }
            if (!z) {
                InlineClassHelperKt.throwIllegalArgumentException("HSV (" + hue + ", " + saturation + ", " + value + ") must be in range (0..360, 0..1, 0..1)");
            }
            return ColorKt.Color(hsvToRgbComponent(5, hue, saturation, value), hsvToRgbComponent(3, hue, saturation, value), hsvToRgbComponent(1, hue, saturation, value), alpha, colorSpace);
        }

        private final float hsvToRgbComponent(int n, float h, float s, float v) {
            float f = (n + (h / 60.0f)) % 6.0f;
            return v - ((s * v) * Math.max(0.0f, Math.min(f, Math.min(4 - f, 1.0f))));
        }

        /* renamed from: hsl-JlNiLsg$default */
        public static /* synthetic */ long m4863hslJlNiLsg$default(Companion companion, float f, float f2, float f3, float f4, Rgb rgb, int i, Object obj) {
            if ((i & 8) != 0) {
                f4 = 1.0f;
            }
            float f5 = f4;
            if ((i & 16) != 0) {
                rgb = ColorSpaces.INSTANCE.getSrgb();
            }
            return companion.m4878hslJlNiLsg(f, f2, f3, f5, rgb);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
        
            if ((0.0f <= r8 && r8 <= 1.0f) != false) goto L54;
         */
        /* renamed from: hsl-JlNiLsg */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final long m4878hslJlNiLsg(float hue, float saturation, float lightness, float alpha, Rgb colorSpace) {
            boolean z = true;
            if (0.0f <= hue && hue <= 360.0f) {
                if (0.0f <= saturation && saturation <= 1.0f) {
                }
            }
            z = false;
            if (!z) {
                InlineClassHelperKt.throwIllegalArgumentException("HSL (" + hue + ", " + saturation + ", " + lightness + ") must be in range (0..360, 0..1, 0..1)");
            }
            return ColorKt.Color(hslToRgbComponent(0, hue, saturation, lightness), hslToRgbComponent(8, hue, saturation, lightness), hslToRgbComponent(4, hue, saturation, lightness), alpha, colorSpace);
        }

        private final float hslToRgbComponent(int n, float h, float s, float l) {
            float f = (n + (h / 30.0f)) % 12.0f;
            return l - ((s * Math.min(l, 1.0f - l)) * Math.max(-1.0f, Math.min(f - 3, Math.min(9 - f, 1.0f))));
        }
    }
}
