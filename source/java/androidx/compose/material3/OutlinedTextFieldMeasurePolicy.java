package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p002ui.geometry.Size;
import androidx.compose.p002ui.geometry.SizeKt;
import androidx.compose.p002ui.layout.IntrinsicMeasurable;
import androidx.compose.p002ui.layout.IntrinsicMeasureScope;
import androidx.compose.p002ui.layout.LayoutIdKt;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OutlinedTextField.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ<\u0010\r\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J<\u0010\u0016\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J\"\u0010\u0018\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010\u0019\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J,\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b \u0010!J\"\u0010\"\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010#\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/material3/OutlinedTextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "onLabelMeasured", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Size;", "", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Lkotlin/jvm/functions/Function1;ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicWidth", "height", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class OutlinedTextFieldMeasurePolicy implements MeasurePolicy {
    private final float animationProgress;
    private final Function1<Size, Unit> onLabelMeasured;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    /* JADX WARN: Multi-variable type inference failed */
    public OutlinedTextFieldMeasurePolicy(Function1<? super Size, Unit> function1, boolean z, float f, PaddingValues paddingValues) {
        this.onLabelMeasured = function1;
        this.singleLine = z;
        this.animationProgress = f;
        this.paddingValues = paddingValues;
    }

    @Override // androidx.compose.p002ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo147measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Measurable measurable;
        Measurable measurable2;
        Measurable measurable3;
        Measurable measurable4;
        Measurable measurable5;
        Measurable measurable6;
        Measurable measurable7;
        final int m2780calculateWidthDHJA7U0;
        final int m2779calculateHeightmKXJcVc;
        List<? extends Measurable> list2 = list;
        int i = measureScope.roundToPx-0680j_4(this.paddingValues.getBottom());
        long j2 = Constraints.copy-Zbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
        int size = list.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                measurable = null;
                break;
            }
            measurable = list2.get(i2);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), TextFieldImplKt.LeadingId)) {
                break;
            }
            i2++;
        }
        Measurable measurable8 = measurable;
        Placeable mo6318measureBRTryo0 = measurable8 != null ? measurable8.mo6318measureBRTryo0(j2) : null;
        int widthOrZero = TextFieldImplKt.widthOrZero(mo6318measureBRTryo0) + 0;
        int max = Math.max(0, TextFieldImplKt.heightOrZero(mo6318measureBRTryo0));
        int size2 = list.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size2) {
                measurable2 = null;
                break;
            }
            measurable2 = list2.get(i3);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), TextFieldImplKt.TrailingId)) {
                break;
            }
            i3++;
        }
        Measurable measurable9 = measurable2;
        Placeable mo6318measureBRTryo02 = measurable9 != null ? measurable9.mo6318measureBRTryo0(ConstraintsKt.offset-NN6Ew-U$default(j2, -widthOrZero, 0, 2, (Object) null)) : null;
        int widthOrZero2 = widthOrZero + TextFieldImplKt.widthOrZero(mo6318measureBRTryo02);
        int max2 = Math.max(max, TextFieldImplKt.heightOrZero(mo6318measureBRTryo02));
        int size3 = list.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size3) {
                measurable3 = null;
                break;
            }
            measurable3 = list2.get(i4);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), TextFieldImplKt.PrefixId)) {
                break;
            }
            i4++;
        }
        Measurable measurable10 = measurable3;
        final Placeable mo6318measureBRTryo03 = measurable10 != null ? measurable10.mo6318measureBRTryo0(ConstraintsKt.offset-NN6Ew-U$default(j2, -widthOrZero2, 0, 2, (Object) null)) : null;
        int widthOrZero3 = widthOrZero2 + TextFieldImplKt.widthOrZero(mo6318measureBRTryo03);
        int max3 = Math.max(max2, TextFieldImplKt.heightOrZero(mo6318measureBRTryo03));
        int size4 = list.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size4) {
                measurable4 = null;
                break;
            }
            measurable4 = list2.get(i5);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), TextFieldImplKt.SuffixId)) {
                break;
            }
            i5++;
        }
        Measurable measurable11 = measurable4;
        Placeable mo6318measureBRTryo04 = measurable11 != null ? measurable11.mo6318measureBRTryo0(ConstraintsKt.offset-NN6Ew-U$default(j2, -widthOrZero3, 0, 2, (Object) null)) : null;
        int widthOrZero4 = widthOrZero3 + TextFieldImplKt.widthOrZero(mo6318measureBRTryo04);
        int max4 = Math.max(max3, TextFieldImplKt.heightOrZero(mo6318measureBRTryo04));
        int i6 = measureScope.roundToPx-0680j_4(this.paddingValues.mo998calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection())) + measureScope.roundToPx-0680j_4(this.paddingValues.mo999calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection()));
        int i7 = -widthOrZero4;
        int i8 = -i;
        long j3 = ConstraintsKt.offset-NN6Ew-U(j2, MathHelpersKt.lerp(i7 - i6, -i6, this.animationProgress), i8);
        int size5 = list.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size5) {
                measurable5 = null;
                break;
            }
            Measurable measurable12 = list2.get(i9);
            int i10 = size5;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable12), TextFieldImplKt.LabelId)) {
                measurable5 = measurable12;
                break;
            }
            i9++;
            size5 = i10;
        }
        Measurable measurable13 = measurable5;
        Placeable mo6318measureBRTryo05 = measurable13 != null ? measurable13.mo6318measureBRTryo0(j3) : null;
        if (mo6318measureBRTryo05 != null) {
            this.onLabelMeasured.invoke(Size.m4650boximpl(SizeKt.Size(mo6318measureBRTryo05.getWidth(), mo6318measureBRTryo05.getHeight())));
        }
        int size6 = list.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size6) {
                measurable6 = null;
                break;
            }
            measurable6 = list2.get(i11);
            int i12 = size6;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable6), TextFieldImplKt.SupportingId)) {
                break;
            }
            i11++;
            size6 = i12;
        }
        Measurable measurable14 = measurable6;
        int minIntrinsicHeight = measurable14 != null ? measurable14.minIntrinsicHeight(Constraints.getMinWidth-impl(j)) : 0;
        int max5 = Math.max(TextFieldImplKt.heightOrZero(mo6318measureBRTryo05) / 2, measureScope.roundToPx-0680j_4(this.paddingValues.getTop()));
        long j4 = Constraints.copy-Zbe2FdA$default(ConstraintsKt.offset-NN6Ew-U(j, i7, (i8 - max5) - minIntrinsicHeight), 0, 0, 0, 0, 11, (Object) null);
        int size7 = list.size();
        int i13 = 0;
        while (i13 < size7) {
            int i14 = size7;
            Measurable measurable15 = list2.get(i13);
            int i15 = i13;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable15), TextFieldImplKt.TextFieldId)) {
                final Placeable mo6318measureBRTryo06 = measurable15.mo6318measureBRTryo0(j4);
                long j5 = Constraints.copy-Zbe2FdA$default(j4, 0, 0, 0, 0, 14, (Object) null);
                int size8 = list.size();
                int i16 = 0;
                while (true) {
                    if (i16 >= size8) {
                        measurable7 = null;
                        break;
                    }
                    measurable7 = list2.get(i16);
                    int i17 = size8;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable7), TextFieldImplKt.PlaceholderId)) {
                        break;
                    }
                    i16++;
                    list2 = list;
                    size8 = i17;
                }
                Measurable measurable16 = measurable7;
                Placeable mo6318measureBRTryo07 = measurable16 != null ? measurable16.mo6318measureBRTryo0(j5) : null;
                int max6 = Math.max(max4, Math.max(TextFieldImplKt.heightOrZero(mo6318measureBRTryo06), TextFieldImplKt.heightOrZero(mo6318measureBRTryo07)) + max5 + i);
                m2780calculateWidthDHJA7U0 = OutlinedTextFieldKt.m2780calculateWidthDHJA7U0(TextFieldImplKt.widthOrZero(mo6318measureBRTryo0), TextFieldImplKt.widthOrZero(mo6318measureBRTryo02), TextFieldImplKt.widthOrZero(mo6318measureBRTryo03), TextFieldImplKt.widthOrZero(mo6318measureBRTryo04), mo6318measureBRTryo06.getWidth(), TextFieldImplKt.widthOrZero(mo6318measureBRTryo05), TextFieldImplKt.widthOrZero(mo6318measureBRTryo07), this.animationProgress, j, measureScope.getDensity(), this.paddingValues);
                Placeable mo6318measureBRTryo08 = measurable14 != null ? measurable14.mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(ConstraintsKt.offset-NN6Ew-U$default(j2, 0, -max6, 1, (Object) null), 0, m2780calculateWidthDHJA7U0, 0, 0, 9, (Object) null)) : null;
                int heightOrZero = TextFieldImplKt.heightOrZero(mo6318measureBRTryo08);
                m2779calculateHeightmKXJcVc = OutlinedTextFieldKt.m2779calculateHeightmKXJcVc(TextFieldImplKt.heightOrZero(mo6318measureBRTryo0), TextFieldImplKt.heightOrZero(mo6318measureBRTryo02), TextFieldImplKt.heightOrZero(mo6318measureBRTryo03), TextFieldImplKt.heightOrZero(mo6318measureBRTryo04), mo6318measureBRTryo06.getHeight(), TextFieldImplKt.heightOrZero(mo6318measureBRTryo05), TextFieldImplKt.heightOrZero(mo6318measureBRTryo07), TextFieldImplKt.heightOrZero(mo6318measureBRTryo08), this.animationProgress, j, measureScope.getDensity(), this.paddingValues);
                int i18 = m2779calculateHeightmKXJcVc - heightOrZero;
                int size9 = list.size();
                for (int i19 = 0; i19 < size9; i19++) {
                    Measurable measurable17 = list.get(i19);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable17), TextFieldImplKt.ContainerId)) {
                        final Placeable mo6318measureBRTryo09 = measurable17.mo6318measureBRTryo0(ConstraintsKt.Constraints(m2780calculateWidthDHJA7U0 != Integer.MAX_VALUE ? m2780calculateWidthDHJA7U0 : 0, m2780calculateWidthDHJA7U0, i18 != Integer.MAX_VALUE ? i18 : 0, i18));
                        final Placeable placeable = mo6318measureBRTryo0;
                        final Placeable placeable2 = mo6318measureBRTryo02;
                        final Placeable placeable3 = mo6318measureBRTryo04;
                        final Placeable placeable4 = mo6318measureBRTryo05;
                        final Placeable placeable5 = mo6318measureBRTryo07;
                        final Placeable placeable6 = mo6318measureBRTryo08;
                        return MeasureScope.layout$default(measureScope, m2780calculateWidthDHJA7U0, m2779calculateHeightmKXJcVc, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$measure$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                float f;
                                boolean z;
                                PaddingValues paddingValues;
                                int i20 = m2779calculateHeightmKXJcVc;
                                int i21 = m2780calculateWidthDHJA7U0;
                                Placeable placeable7 = placeable;
                                Placeable placeable8 = placeable2;
                                Placeable placeable9 = mo6318measureBRTryo03;
                                Placeable placeable10 = placeable3;
                                Placeable placeable11 = mo6318measureBRTryo06;
                                Placeable placeable12 = placeable4;
                                Placeable placeable13 = placeable5;
                                Placeable placeable14 = mo6318measureBRTryo09;
                                Placeable placeable15 = placeable6;
                                f = this.animationProgress;
                                z = this.singleLine;
                                float density = measureScope.getDensity();
                                LayoutDirection layoutDirection = measureScope.getLayoutDirection();
                                paddingValues = this.paddingValues;
                                OutlinedTextFieldKt.place(placementScope, i20, i21, placeable7, placeable8, placeable9, placeable10, placeable11, placeable12, placeable13, placeable14, placeable15, f, z, density, layoutDirection, paddingValues);
                            }
                        }, 4, null);
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            i13 = i15 + 1;
            size7 = i14;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.p002ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$maxIntrinsicHeight$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i2) {
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i2));
            }
        });
    }

    @Override // androidx.compose.p002ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$minIntrinsicHeight$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i2) {
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i2));
            }
        });
    }

    @Override // androidx.compose.p002ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(intrinsicMeasureScope, list, i, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$maxIntrinsicWidth$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i2) {
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i2));
            }
        });
    }

    @Override // androidx.compose.p002ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(intrinsicMeasureScope, list, i, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$minIntrinsicWidth$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i2) {
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i2));
            }
        });
    }

    private final int intrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        IntrinsicMeasurable intrinsicMeasurable;
        IntrinsicMeasurable intrinsicMeasurable2;
        IntrinsicMeasurable intrinsicMeasurable3;
        IntrinsicMeasurable intrinsicMeasurable4;
        IntrinsicMeasurable intrinsicMeasurable5;
        IntrinsicMeasurable intrinsicMeasurable6;
        int m2780calculateWidthDHJA7U0;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            IntrinsicMeasurable intrinsicMeasurable7 = list.get(i2);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable7), TextFieldImplKt.TextFieldId)) {
                int intValue = ((Number) function2.invoke(intrinsicMeasurable7, Integer.valueOf(i))).intValue();
                int size2 = list.size();
                int i3 = 0;
                while (true) {
                    intrinsicMeasurable = null;
                    if (i3 >= size2) {
                        intrinsicMeasurable2 = null;
                        break;
                    }
                    intrinsicMeasurable2 = list.get(i3);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable2), TextFieldImplKt.LabelId)) {
                        break;
                    }
                    i3++;
                }
                IntrinsicMeasurable intrinsicMeasurable8 = intrinsicMeasurable2;
                int intValue2 = intrinsicMeasurable8 != null ? ((Number) function2.invoke(intrinsicMeasurable8, Integer.valueOf(i))).intValue() : 0;
                int size3 = list.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size3) {
                        intrinsicMeasurable3 = null;
                        break;
                    }
                    intrinsicMeasurable3 = list.get(i4);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable3), TextFieldImplKt.TrailingId)) {
                        break;
                    }
                    i4++;
                }
                IntrinsicMeasurable intrinsicMeasurable9 = intrinsicMeasurable3;
                int intValue3 = intrinsicMeasurable9 != null ? ((Number) function2.invoke(intrinsicMeasurable9, Integer.valueOf(i))).intValue() : 0;
                int size4 = list.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size4) {
                        intrinsicMeasurable4 = null;
                        break;
                    }
                    intrinsicMeasurable4 = list.get(i5);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable4), TextFieldImplKt.LeadingId)) {
                        break;
                    }
                    i5++;
                }
                IntrinsicMeasurable intrinsicMeasurable10 = intrinsicMeasurable4;
                int intValue4 = intrinsicMeasurable10 != null ? ((Number) function2.invoke(intrinsicMeasurable10, Integer.valueOf(i))).intValue() : 0;
                int size5 = list.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size5) {
                        intrinsicMeasurable5 = null;
                        break;
                    }
                    intrinsicMeasurable5 = list.get(i6);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable5), TextFieldImplKt.PrefixId)) {
                        break;
                    }
                    i6++;
                }
                IntrinsicMeasurable intrinsicMeasurable11 = intrinsicMeasurable5;
                int intValue5 = intrinsicMeasurable11 != null ? ((Number) function2.invoke(intrinsicMeasurable11, Integer.valueOf(i))).intValue() : 0;
                int size6 = list.size();
                int i7 = 0;
                while (true) {
                    if (i7 >= size6) {
                        intrinsicMeasurable6 = null;
                        break;
                    }
                    intrinsicMeasurable6 = list.get(i7);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable6), TextFieldImplKt.SuffixId)) {
                        break;
                    }
                    i7++;
                }
                IntrinsicMeasurable intrinsicMeasurable12 = intrinsicMeasurable6;
                int intValue6 = intrinsicMeasurable12 != null ? ((Number) function2.invoke(intrinsicMeasurable12, Integer.valueOf(i))).intValue() : 0;
                int size7 = list.size();
                int i8 = 0;
                while (true) {
                    if (i8 >= size7) {
                        break;
                    }
                    IntrinsicMeasurable intrinsicMeasurable13 = list.get(i8);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable13), TextFieldImplKt.PlaceholderId)) {
                        intrinsicMeasurable = intrinsicMeasurable13;
                        break;
                    }
                    i8++;
                }
                IntrinsicMeasurable intrinsicMeasurable14 = intrinsicMeasurable;
                m2780calculateWidthDHJA7U0 = OutlinedTextFieldKt.m2780calculateWidthDHJA7U0(intValue4, intValue3, intValue5, intValue6, intValue, intValue2, intrinsicMeasurable14 != null ? ((Number) function2.invoke(intrinsicMeasurable14, Integer.valueOf(i))).intValue() : 0, this.animationProgress, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
                return m2780calculateWidthDHJA7U0;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        IntrinsicMeasurable intrinsicMeasurable;
        int i2;
        int i3;
        IntrinsicMeasurable intrinsicMeasurable2;
        int i4;
        IntrinsicMeasurable intrinsicMeasurable3;
        IntrinsicMeasurable intrinsicMeasurable4;
        int i5;
        IntrinsicMeasurable intrinsicMeasurable5;
        int i6;
        IntrinsicMeasurable intrinsicMeasurable6;
        IntrinsicMeasurable intrinsicMeasurable7;
        int m2779calculateHeightmKXJcVc;
        int size = list.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size) {
                intrinsicMeasurable = null;
                break;
            }
            intrinsicMeasurable = list.get(i7);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable), TextFieldImplKt.LeadingId)) {
                break;
            }
            i7++;
        }
        IntrinsicMeasurable intrinsicMeasurable8 = intrinsicMeasurable;
        if (intrinsicMeasurable8 != null) {
            i2 = OutlinedTextFieldKt.substractConstraintSafely(i, intrinsicMeasurable8.maxIntrinsicWidth(Integer.MAX_VALUE));
            i3 = ((Number) function2.invoke(intrinsicMeasurable8, Integer.valueOf(i))).intValue();
        } else {
            i2 = i;
            i3 = 0;
        }
        int size2 = list.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size2) {
                intrinsicMeasurable2 = null;
                break;
            }
            intrinsicMeasurable2 = list.get(i8);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable2), TextFieldImplKt.TrailingId)) {
                break;
            }
            i8++;
        }
        IntrinsicMeasurable intrinsicMeasurable9 = intrinsicMeasurable2;
        if (intrinsicMeasurable9 != null) {
            i2 = OutlinedTextFieldKt.substractConstraintSafely(i2, intrinsicMeasurable9.maxIntrinsicWidth(Integer.MAX_VALUE));
            i4 = ((Number) function2.invoke(intrinsicMeasurable9, Integer.valueOf(i))).intValue();
        } else {
            i4 = 0;
        }
        int size3 = list.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size3) {
                intrinsicMeasurable3 = null;
                break;
            }
            intrinsicMeasurable3 = list.get(i9);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable3), TextFieldImplKt.LabelId)) {
                break;
            }
            i9++;
        }
        IntrinsicMeasurable intrinsicMeasurable10 = intrinsicMeasurable3;
        int intValue = intrinsicMeasurable10 != null ? ((Number) function2.invoke(intrinsicMeasurable10, Integer.valueOf(MathHelpersKt.lerp(i2, i, this.animationProgress)))).intValue() : 0;
        int size4 = list.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size4) {
                intrinsicMeasurable4 = null;
                break;
            }
            intrinsicMeasurable4 = list.get(i10);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable4), TextFieldImplKt.PrefixId)) {
                break;
            }
            i10++;
        }
        IntrinsicMeasurable intrinsicMeasurable11 = intrinsicMeasurable4;
        if (intrinsicMeasurable11 != null) {
            i5 = ((Number) function2.invoke(intrinsicMeasurable11, Integer.valueOf(i2))).intValue();
            i2 = OutlinedTextFieldKt.substractConstraintSafely(i2, intrinsicMeasurable11.maxIntrinsicWidth(Integer.MAX_VALUE));
        } else {
            i5 = 0;
        }
        int size5 = list.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size5) {
                intrinsicMeasurable5 = null;
                break;
            }
            intrinsicMeasurable5 = list.get(i11);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable5), TextFieldImplKt.SuffixId)) {
                break;
            }
            i11++;
        }
        IntrinsicMeasurable intrinsicMeasurable12 = intrinsicMeasurable5;
        if (intrinsicMeasurable12 != null) {
            int intValue2 = ((Number) function2.invoke(intrinsicMeasurable12, Integer.valueOf(i2))).intValue();
            i2 = OutlinedTextFieldKt.substractConstraintSafely(i2, intrinsicMeasurable12.maxIntrinsicWidth(Integer.MAX_VALUE));
            i6 = intValue2;
        } else {
            i6 = 0;
        }
        int size6 = list.size();
        for (int i12 = 0; i12 < size6; i12++) {
            IntrinsicMeasurable intrinsicMeasurable13 = list.get(i12);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable13), TextFieldImplKt.TextFieldId)) {
                int intValue3 = ((Number) function2.invoke(intrinsicMeasurable13, Integer.valueOf(i2))).intValue();
                int size7 = list.size();
                int i13 = 0;
                while (true) {
                    if (i13 >= size7) {
                        intrinsicMeasurable6 = null;
                        break;
                    }
                    intrinsicMeasurable6 = list.get(i13);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable6), TextFieldImplKt.PlaceholderId)) {
                        break;
                    }
                    i13++;
                }
                IntrinsicMeasurable intrinsicMeasurable14 = intrinsicMeasurable6;
                int intValue4 = intrinsicMeasurable14 != null ? ((Number) function2.invoke(intrinsicMeasurable14, Integer.valueOf(i2))).intValue() : 0;
                int size8 = list.size();
                int i14 = 0;
                while (true) {
                    if (i14 >= size8) {
                        intrinsicMeasurable7 = null;
                        break;
                    }
                    IntrinsicMeasurable intrinsicMeasurable15 = list.get(i14);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable15), TextFieldImplKt.SupportingId)) {
                        intrinsicMeasurable7 = intrinsicMeasurable15;
                        break;
                    }
                    i14++;
                }
                IntrinsicMeasurable intrinsicMeasurable16 = intrinsicMeasurable7;
                m2779calculateHeightmKXJcVc = OutlinedTextFieldKt.m2779calculateHeightmKXJcVc(i3, i4, i5, i6, intValue3, intValue, intValue4, intrinsicMeasurable16 != null ? ((Number) function2.invoke(intrinsicMeasurable16, Integer.valueOf(i))).intValue() : 0, this.animationProgress, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
                return m2779calculateHeightmKXJcVc;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
