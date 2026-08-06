package androidx.compose.p002ui.graphics;

import android.graphics.Shader;
import androidx.compose.p002ui.geometry.InlineClassHelperKt;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.geometry.Size;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Brush.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001BC\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0014\u001a\u00060\u0015j\u0002`\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Landroidx/compose/ui/graphics/LinearGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "<init>", "(Ljava/util/List;Ljava/util/List;JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "I", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class LinearGradient extends ShaderBrush {
    private final List<Color> colors;
    private final long end;
    private final long start;
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ LinearGradient(List list, List list2, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, j, j2, i);
    }

    public /* synthetic */ LinearGradient(List list, List list2, long j, long j2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? null : list2, j, j2, (i2 & 16) != 0 ? TileMode.INSTANCE.m5231getClamp3opZhB0() : i, null);
    }

    private LinearGradient(List<Color> list, List<Float> list2, long j, long j2, int i) {
        this.colors = list;
        this.stops = list2;
        this.start = j;
        this.end = j2;
        this.tileMode = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    @Override // androidx.compose.p002ui.graphics.Brush
    /* renamed from: getIntrinsicSize-NH-jbRc */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getIntrinsicSize() {
        float f;
        float intBitsToFloat;
        float intBitsToFloat2 = Float.intBitsToFloat((int) (this.start >> 32));
        float f2 = Float.NaN;
        if ((Float.isInfinite(intBitsToFloat2) || Float.isNaN(intBitsToFloat2)) ? false : true) {
            float intBitsToFloat3 = Float.intBitsToFloat((int) (this.end >> 32));
            if ((Float.isInfinite(intBitsToFloat3) || Float.isNaN(intBitsToFloat3)) ? false : true) {
                f = Math.abs(Float.intBitsToFloat((int) (this.start >> 32)) - Float.intBitsToFloat((int) (this.end >> 32)));
                intBitsToFloat = Float.intBitsToFloat((int) (this.start & 4294967295L));
                if (Float.isInfinite(intBitsToFloat) && !Float.isNaN(intBitsToFloat)) {
                    float intBitsToFloat4 = Float.intBitsToFloat((int) (this.end & 4294967295L));
                    if ((Float.isInfinite(intBitsToFloat4) || Float.isNaN(intBitsToFloat4)) ? false : true) {
                        f2 = Math.abs(Float.intBitsToFloat((int) (this.start & 4294967295L)) - Float.intBitsToFloat((int) (this.end & 4294967295L)));
                    }
                }
                return Size.m4653constructorimpl((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
            }
        }
        f = Float.NaN;
        intBitsToFloat = Float.intBitsToFloat((int) (this.start & 4294967295L));
        if (Float.isInfinite(intBitsToFloat) && !Float.isNaN(intBitsToFloat)) {
        }
        return Size.m4653constructorimpl((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    @Override // androidx.compose.p002ui.graphics.ShaderBrush
    /* renamed from: createShader-uvyYCjk */
    public Shader mo4808createShaderuvyYCjk(long size) {
        float intBitsToFloat = Float.intBitsToFloat((int) ((Float.intBitsToFloat((int) (this.start >> 32)) > Float.POSITIVE_INFINITY ? 1 : (Float.intBitsToFloat((int) (this.start >> 32)) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? size >> 32 : this.start >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) ((Float.intBitsToFloat((int) (this.start & 4294967295L)) > Float.POSITIVE_INFINITY ? 1 : (Float.intBitsToFloat((int) (this.start & 4294967295L)) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? size & 4294967295L : this.start & 4294967295L));
        float intBitsToFloat3 = Float.intBitsToFloat((int) ((Float.intBitsToFloat((int) (this.end >> 32)) > Float.POSITIVE_INFINITY ? 1 : (Float.intBitsToFloat((int) (this.end >> 32)) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? size >> 32 : this.end >> 32));
        float intBitsToFloat4 = Float.intBitsToFloat((int) (Float.intBitsToFloat((int) (this.end & 4294967295L)) == Float.POSITIVE_INFINITY ? size & 4294967295L : this.end & 4294967295L));
        return ShaderKt.m5170LinearGradientShaderVjE6UOU(Offset.m4585constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L)), Offset.m4585constructorimpl((Float.floatToRawIntBits(intBitsToFloat4) & 4294967295L) | (Float.floatToRawIntBits(intBitsToFloat3) << 32)), this.colors, this.stops, this.tileMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LinearGradient)) {
            return false;
        }
        LinearGradient linearGradient = (LinearGradient) other;
        return Intrinsics.areEqual(this.colors, linearGradient.colors) && Intrinsics.areEqual(this.stops, linearGradient.stops) && Offset.m4590equalsimpl0(this.start, linearGradient.start) && Offset.m4590equalsimpl0(this.end, linearGradient.end) && TileMode.m5227equalsimpl0(this.tileMode, linearGradient.tileMode);
    }

    public int hashCode() {
        int hashCode = this.colors.hashCode() * 31;
        List<Float> list = this.stops;
        return ((((((hashCode + (list != null ? list.hashCode() : 0)) * 31) + Offset.m4595hashCodeimpl(this.start)) * 31) + Offset.m4595hashCodeimpl(this.end)) * 31) + TileMode.m5228hashCodeimpl(this.tileMode);
    }

    public String toString() {
        return "LinearGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + ((((((this.start & InlineClassHelperKt.DualFloatInfinityBase) ^ InlineClassHelperKt.DualFloatInfinityBase) - InlineClassHelperKt.Uint64Low32) & (-9223372034707292160L)) > 0L ? 1 : (((((this.start & InlineClassHelperKt.DualFloatInfinityBase) ^ InlineClassHelperKt.DualFloatInfinityBase) - InlineClassHelperKt.Uint64Low32) & (-9223372034707292160L)) == 0L ? 0 : -1)) == 0 ? "start=" + ((Object) Offset.m4601toStringimpl(this.start)) + ", " : "") + ((((InlineClassHelperKt.DualFloatInfinityBase ^ (this.end & InlineClassHelperKt.DualFloatInfinityBase)) - InlineClassHelperKt.Uint64Low32) & (-9223372034707292160L)) == 0 ? "end=" + ((Object) Offset.m4601toStringimpl(this.end)) + ", " : "") + "tileMode=" + ((Object) TileMode.m5229toStringimpl(this.tileMode)) + ')';
    }
}
