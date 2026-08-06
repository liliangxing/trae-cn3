package org.jetbrains.compose.resources.vector;

import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;

/* compiled from: ValueParsers.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\b\u001a\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\b\u001a\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\b\u001a\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\b\u001a\u001b\u0010\u0012\u001a\u00020\u0013*\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\u0010\u0016\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"ALPHA_MASK", "", "parseColorValue", "color", "", "parseFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fillType", "(Ljava/lang/String;)I", "parseStrokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeCap", "parseStrokeJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeJoin", "parseTileMode", "Landroidx/compose/ui/graphics/TileMode;", "tileMode", "parseDp", "Landroidx/compose/ui/unit/Dp;", "density", "Landroidx/compose/ui/unit/Density;", "(Ljava/lang/String;Landroidx/compose/ui/unit/Density;)F", "library_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes9.dex */
public final class ValueParsersKt {
    private static final int ALPHA_MASK = -16777216;

    public static final int parseColorValue(String str) {
        int uInt;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(str, "color");
        if (!StringsKt.startsWith$default(str, "#", false, 2, (Object) null)) {
            throw new IllegalArgumentException(("Invalid color value " + str).toString());
        }
        int length = str.length();
        if (length == 4) {
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            uInt = UStringsKt.toUInt(substring, 16);
            i = ((uInt >> 8) & 15) * 1114112;
        } else {
            if (length != 5) {
                if (length == 7) {
                    String substring2 = str.substring(1);
                    Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                    i2 = UStringsKt.toUInt(substring2, 16);
                    return ALPHA_MASK | i2;
                }
                if (length != 9) {
                    return ALPHA_MASK;
                }
                String substring3 = str.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
                return UStringsKt.toUInt(substring3, 16);
            }
            String substring4 = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring4, "substring(...)");
            uInt = UStringsKt.toUInt(substring4, 16);
            i = (((uInt >> 12) & 15) * 285212672) | (((uInt >> 8) & 15) * 1114112);
        }
        i2 = ((uInt & 15) * 17) | i | (((uInt >> 4) & 15) * 4352);
        return ALPHA_MASK | i2;
    }

    public static final int parseFillType(String str) {
        Intrinsics.checkNotNullParameter(str, "fillType");
        if (Intrinsics.areEqual(str, "nonZero")) {
            return PathFillType.Companion.getNonZero-Rg-k1Os();
        }
        if (Intrinsics.areEqual(str, "evenOdd")) {
            return PathFillType.Companion.getEvenOdd-Rg-k1Os();
        }
        throw new UnsupportedOperationException("unknown fillType: " + str);
    }

    public static final int parseStrokeCap(String str) {
        Intrinsics.checkNotNullParameter(str, "strokeCap");
        int hashCode = str.hashCode();
        if (hashCode != -894674659) {
            if (hashCode != 3035667) {
                if (hashCode == 108704142 && str.equals("round")) {
                    return StrokeCap.Companion.getRound-KaPHkGw();
                }
            } else if (str.equals("butt")) {
                return StrokeCap.Companion.getButt-KaPHkGw();
            }
        } else if (str.equals("square")) {
            return StrokeCap.Companion.getSquare-KaPHkGw();
        }
        throw new UnsupportedOperationException("unknown strokeCap: " + str);
    }

    public static final int parseStrokeJoin(String str) {
        Intrinsics.checkNotNullParameter(str, "strokeJoin");
        int hashCode = str.hashCode();
        if (hashCode != 93630586) {
            if (hashCode != 103906565) {
                if (hashCode == 108704142 && str.equals("round")) {
                    return StrokeJoin.Companion.getRound-LxFBmk8();
                }
            } else if (str.equals("miter")) {
                return StrokeJoin.Companion.getMiter-LxFBmk8();
            }
        } else if (str.equals("bevel")) {
            return StrokeJoin.Companion.getBevel-LxFBmk8();
        }
        throw new UnsupportedOperationException("unknown strokeJoin: " + str);
    }

    public static final int parseTileMode(String str) {
        Intrinsics.checkNotNullParameter(str, "tileMode");
        int hashCode = str.hashCode();
        if (hashCode != -1073910849) {
            if (hashCode != -436781190) {
                if (hashCode == 94742715 && str.equals("clamp")) {
                    return TileMode.Companion.getClamp-3opZhB0();
                }
            } else if (str.equals("repeated")) {
                return TileMode.Companion.getRepeated-3opZhB0();
            }
        } else if (str.equals("mirror")) {
            return TileMode.Companion.getMirror-3opZhB0();
        }
        throw new UnsupportedOperationException("unknown tileMode: " + str);
    }

    public static final float parseDp(String str, Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        if (str != null) {
            if (!StringsKt.endsWith$default(str, "dp", false, 2, (Object) null)) {
                if (StringsKt.endsWith$default(str, "px", false, 2, (Object) null)) {
                    return density.toDp-u2uoSUM(Float.parseFloat(StringsKt.removeSuffix(str, "px")));
                }
                throw new UnsupportedOperationException("value should ends with dp or px");
            }
            return Dp.constructor-impl(Float.parseFloat(StringsKt.removeSuffix(str, "dp")));
        }
        return Dp.constructor-impl(0.0f);
    }
}
