package coil3.compose;

import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: AsyncImage.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class AsyncImageKt$UseMinConstraintsMeasurePolicy$1 implements MeasurePolicy {
    public static final AsyncImageKt$UseMinConstraintsMeasurePolicy$1 INSTANCE = new AsyncImageKt$UseMinConstraintsMeasurePolicy$1();

    AsyncImageKt$UseMinConstraintsMeasurePolicy$1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m3184measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        return MeasureScope.layout$default(measureScope, Constraints.m2623getMinWidthimpl(j), Constraints.m2622getMinHeightimpl(j), (Map) null, new Function1() { // from class: coil3.compose.AsyncImageKt$UseMinConstraintsMeasurePolicy$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$0;
                measure_3p2s80s$lambda$0 = AsyncImageKt$UseMinConstraintsMeasurePolicy$1.measure_3p2s80s$lambda$0((Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$0;
            }
        }, 4, (Object) null);
    }
}
