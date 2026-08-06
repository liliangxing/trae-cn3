package androidx.compose.foundation.text;

import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: AnnotatedStringResolveInlineContent.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class AnnotatedStringResolveInlineContentKt$InlineChildren$1$2$1 implements MeasurePolicy {
    public static final AnnotatedStringResolveInlineContentKt$InlineChildren$1$2$1 INSTANCE = new AnnotatedStringResolveInlineContentKt$InlineChildren$1$2$1();

    AnnotatedStringResolveInlineContentKt$InlineChildren$1$2$1() {
    }

    @Override // androidx.compose.p002ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo147measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(list.get(i).mo6318measureBRTryo0(j));
        }
        final ArrayList arrayList2 = arrayList;
        return MeasureScope.layout$default(measureScope, Constraints.getMaxWidth-impl(j), Constraints.getMaxHeight-impl(j), null, new Function1() { // from class: androidx.compose.foundation.text.AnnotatedStringResolveInlineContentKt$InlineChildren$1$2$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$2;
                measure_3p2s80s$lambda$2 = AnnotatedStringResolveInlineContentKt$InlineChildren$1$2$1.measure_3p2s80s$lambda$2(arrayList2, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$2;
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$2(List list, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list.get(i), 0, 0, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
