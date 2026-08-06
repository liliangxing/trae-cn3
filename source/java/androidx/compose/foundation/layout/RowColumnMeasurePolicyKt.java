package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: RowColumnMeasurePolicy.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "mainAxisMin", "", "crossAxisMin", "mainAxisMax", "crossAxisMax", "arrangementSpacingInt", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "startIndex", "endIndex", "crossAxisOffset", "", "currentLineIndex", "(Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;IIIIILandroidx/compose/ui/layout/MeasureScope;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;II[II)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class RowColumnMeasurePolicyKt {
    public static final MeasureResult measure(RowColumnMeasurePolicy rowColumnMeasurePolicy, int i, int i2, int i3, int i4, int i5, MeasureScope measureScope, List<? extends Measurable> list, Placeable[] placeableArr, int i6, int i7, int[] iArr, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        float f;
        FlowLayoutData flowLayoutData;
        int i13;
        int i14;
        int i15;
        int i16;
        int[] iArr2;
        int i17;
        FlowLayoutData flowLayoutData2;
        long j = i5;
        int i18 = i7 - i6;
        int[] iArr3 = new int[i18];
        int i19 = i6;
        float f2 = 0.0f;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        boolean z = false;
        int i23 = 0;
        while (true) {
            Integer num = null;
            if (i19 >= i7) {
                break;
            }
            Measurable measurable = list.get(i19);
            RowColumnParentData rowColumnParentData = RowColumnImplKt.getRowColumnParentData(measurable);
            float weight = RowColumnImplKt.getWeight(rowColumnParentData);
            z = z || RowColumnImplKt.isRelative(rowColumnParentData);
            if (weight > 0.0f) {
                f2 += weight;
                i22++;
                i16 = i19;
                i17 = i18;
            } else {
                if (i4 != Integer.MAX_VALUE && rowColumnParentData != null && (flowLayoutData2 = rowColumnParentData.getFlowLayoutData()) != null) {
                    num = Integer.valueOf(Math.round(flowLayoutData2.getFillCrossAxisFraction() * i4));
                }
                int i24 = i3 - i23;
                Placeable placeable = placeableArr[i19];
                if (placeable == null) {
                    i15 = i21;
                    i16 = i19;
                    iArr2 = iArr3;
                    i17 = i18;
                    placeable = measurable.mo6318measureBRTryo0(RowColumnMeasurePolicy.m1097createConstraintsxF2OJ5Q$default(rowColumnMeasurePolicy, 0, num != null ? num.intValue() : 0, i3 == Integer.MAX_VALUE ? Integer.MAX_VALUE : i24 < 0 ? 0 : i24, num != null ? num.intValue() : i4, false, 16, null));
                } else {
                    i15 = i21;
                    i16 = i19;
                    iArr2 = iArr3;
                    i17 = i18;
                }
                int mainAxisSize = rowColumnMeasurePolicy.mainAxisSize(placeable);
                int crossAxisSize = rowColumnMeasurePolicy.crossAxisSize(placeable);
                iArr3 = iArr2;
                iArr3[i16 - i6] = mainAxisSize;
                int i25 = i24 - mainAxisSize;
                if (i25 < 0) {
                    i25 = 0;
                }
                int min = Math.min(i5, i25);
                i23 += mainAxisSize + min;
                int max = Math.max(i15, crossAxisSize);
                placeableArr[i16] = placeable;
                i20 = min;
                i21 = max;
            }
            i19 = i16 + 1;
            i18 = i17;
        }
        int i26 = i21;
        int i27 = i18;
        if (i22 == 0) {
            i23 -= i20;
            i11 = i26;
            i10 = 0;
            i9 = 0;
        } else {
            long j2 = j * (i22 - 1);
            long j3 = ((i3 != Integer.MAX_VALUE ? i3 : i) - i23) - j2;
            if (j3 < 0) {
                j3 = 0;
            }
            float f3 = ((float) j3) / f2;
            for (int i28 = i6; i28 < i7; i28++) {
                j3 -= Math.round(RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(list.get(i28))) * f3);
            }
            int i29 = i6;
            int i30 = 0;
            while (i29 < i7) {
                if (placeableArr[i29] == null) {
                    Measurable measurable2 = list.get(i29);
                    RowColumnParentData rowColumnParentData2 = RowColumnImplKt.getRowColumnParentData(measurable2);
                    float weight2 = RowColumnImplKt.getWeight(rowColumnParentData2);
                    Integer valueOf = (i4 == Integer.MAX_VALUE || rowColumnParentData2 == null || (flowLayoutData = rowColumnParentData2.getFlowLayoutData()) == null) ? null : Integer.valueOf(Math.round(flowLayoutData.getFillCrossAxisFraction() * i4));
                    if (!(weight2 > 0.0f)) {
                        InlineClassHelperKt.throwIllegalStateException("All weights <= 0 should have placeables");
                    }
                    int sign = MathKt.getSign(j3);
                    int i31 = i29;
                    int i32 = i30;
                    long j4 = j3 - sign;
                    int max2 = Math.max(0, Math.round(weight2 * f3) + sign);
                    int i33 = (!RowColumnImplKt.getFill(rowColumnParentData2) || max2 == Integer.MAX_VALUE) ? 0 : max2;
                    i12 = i31;
                    f = f3;
                    Placeable mo6318measureBRTryo0 = measurable2.mo6318measureBRTryo0(rowColumnMeasurePolicy.mo947createConstraintsxF2OJ5Q(i33, valueOf != null ? valueOf.intValue() : 0, max2, valueOf != null ? valueOf.intValue() : i4, true));
                    int mainAxisSize2 = rowColumnMeasurePolicy.mainAxisSize(mo6318measureBRTryo0);
                    int crossAxisSize2 = rowColumnMeasurePolicy.crossAxisSize(mo6318measureBRTryo0);
                    iArr3[i12 - i6] = mainAxisSize2;
                    i30 = i32 + mainAxisSize2;
                    int max3 = Math.max(i26, crossAxisSize2);
                    placeableArr[i12] = mo6318measureBRTryo0;
                    i26 = max3;
                    j3 = j4;
                } else {
                    i12 = i29;
                    f = f3;
                }
                i29 = i12 + 1;
                f3 = f;
            }
            int i34 = i26;
            i9 = 0;
            i10 = (int) (i30 + j2);
            int i35 = i3 - i23;
            if (i10 < 0) {
                i10 = 0;
            }
            if (i10 > i35) {
                i10 = i35;
            }
            i11 = i34;
        }
        if (z) {
            int i36 = i9;
            i13 = i36;
            for (int i37 = i6; i37 < i7; i37++) {
                Placeable placeable2 = placeableArr[i37];
                Intrinsics.checkNotNull(placeable2);
                CrossAxisAlignment crossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(RowColumnImplKt.getRowColumnParentData(placeable2));
                Integer calculateAlignmentLinePosition$foundation_layout = crossAxisAlignment != null ? crossAxisAlignment.calculateAlignmentLinePosition$foundation_layout(placeable2) : null;
                if (calculateAlignmentLinePosition$foundation_layout != null) {
                    int intValue = calculateAlignmentLinePosition$foundation_layout.intValue();
                    int crossAxisSize3 = rowColumnMeasurePolicy.crossAxisSize(placeable2);
                    i36 = Math.max(i36, intValue != Integer.MIN_VALUE ? calculateAlignmentLinePosition$foundation_layout.intValue() : i9);
                    if (intValue == Integer.MIN_VALUE) {
                        intValue = crossAxisSize3;
                    }
                    i13 = Math.max(i13, crossAxisSize3 - intValue);
                }
            }
            i14 = i36;
        } else {
            i13 = i9;
            i14 = i13;
        }
        int i38 = i23 + i10;
        if (i38 < 0) {
            i38 = i9;
        }
        int max4 = Math.max(i38, i);
        int max5 = Math.max(i11, Math.max(i2, i13 + i14));
        int[] iArr4 = new int[i27];
        rowColumnMeasurePolicy.populateMainAxisPositions(max4, iArr3, iArr4, measureScope);
        return rowColumnMeasurePolicy.placeHelper(placeableArr, measureScope, i14, iArr4, max4, max5, iArr, i8, i6, i7);
    }
}
