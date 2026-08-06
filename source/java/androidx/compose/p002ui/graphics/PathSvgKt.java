package androidx.compose.p002ui.graphics;

import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.p002ui.graphics.PathSegment;
import androidx.compose.p002ui.graphics.vector.PathParser;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PathSvg.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¨\u0006\f"}, d2 = {"addSvg", "", "Landroidx/compose/ui/graphics/Path;", "pathData", "", "toSvg", "asDocument", "", "command", "type", "Landroidx/compose/ui/graphics/PathSegment$Type;", "lastType", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class PathSvgKt {

    /* compiled from: PathSvg.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PathSegment.Type.values().length];
            try {
                iArr[PathSegment.Type.Move.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PathSegment.Type.Line.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PathSegment.Type.Quadratic.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PathSegment.Type.Conic.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PathSegment.Type.Cubic.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PathSegment.Type.Close.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PathSegment.Type.Done.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void addSvg(Path path, String str) {
        new PathParser().parsePathString(str).toPath(path);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x00b1. Please report as an issue. */
    public static final String toSvg(Path path, boolean z) {
        StringBuilder sb = new StringBuilder();
        Rect bounds = path.getBounds();
        if (z) {
            sb.append("<svg xmlns=\"http://www.w3.org/2000/svg\" ");
            StringBuilder append = sb.append("viewBox=\"" + bounds.getLeft() + ' ' + bounds.getTop() + ' ' + (bounds.getRight() - bounds.getLeft()) + ' ' + (bounds.getBottom() - bounds.getTop()) + "\">");
            Intrinsics.checkNotNullExpressionValue(append, "append(...)");
            Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append(...)");
        }
        PathIterator it = path.iterator();
        float[] fArr = new float[8];
        PathSegment.Type type = PathSegment.Type.Done;
        if (it.hasNext()) {
            if (z) {
                if (PathFillType.m5130equalsimpl0(path.mo4726getFillTypeRgk1Os(), PathFillType.INSTANCE.m5134getEvenOddRgk1Os())) {
                    sb.append("  <path fill-rule=\"evenodd\" d=\"");
                } else {
                    sb.append("  <path d=\"");
                }
            }
            while (it.hasNext()) {
                PathSegment.Type next$default = PathIterator.next$default(it, fArr, 0, 2, null);
                switch (WhenMappings.$EnumSwitchMapping$0[next$default.ordinal()]) {
                    case 1:
                        sb.append(command(PathSegment.Type.Move, type) + fArr[0] + ' ' + fArr[1]);
                        type = next$default;
                    case 2:
                        sb.append(command(PathSegment.Type.Line, type) + fArr[2] + ' ' + fArr[3]);
                        type = next$default;
                    case 3:
                        sb.append(command(PathSegment.Type.Quadratic, type));
                        sb.append(new StringBuilder().append(fArr[2]).append(' ').append(fArr[3]).append(' ').append(fArr[4]).append(' ').append(fArr[5]).toString());
                        type = next$default;
                    case 4:
                    case 7:
                    case 5:
                        sb.append(command(PathSegment.Type.Cubic, type));
                        sb.append(new StringBuilder().append(fArr[2]).append(' ').append(fArr[3]).append(' ').toString());
                        sb.append(new StringBuilder().append(fArr[4]).append(' ').append(fArr[5]).append(' ').toString());
                        sb.append(new StringBuilder().append(fArr[6]).append(' ').append(fArr[7]).toString());
                        type = next$default;
                    case 6:
                        sb.append(command(PathSegment.Type.Close, type));
                        type = next$default;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            if (z) {
                StringBuilder append2 = sb.append("\"/>");
                Intrinsics.checkNotNullExpressionValue(append2, "append(...)");
                Intrinsics.checkNotNullExpressionValue(append2.append('\n'), "append(...)");
            }
        }
        if (z) {
            StringBuilder append3 = sb.append("</svg>");
            Intrinsics.checkNotNullExpressionValue(append3, "append(...)");
            Intrinsics.checkNotNullExpressionValue(append3.append('\n'), "append(...)");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public static /* synthetic */ String toSvg$default(Path path, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return toSvg(path, z);
    }

    private static final String command(PathSegment.Type type, PathSegment.Type type2) {
        if (type == type2) {
            return " ";
        }
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 5 ? i != 6 ? "" : "Z" : "C" : "Q" : "L" : "M";
    }
}
