package androidx.compose.animation;

import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.p002ui.geometry.RectKt;
import kotlin.Metadata;

/* compiled from: SharedElement.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\b\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"targetBounds", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/animation/TargetData;", "getTargetBounds", "(Landroidx/compose/animation/TargetData;)Landroidx/compose/ui/geometry/Rect;", "calculateOffsetFromDirectManipulation", "Landroidx/compose/ui/geometry/Offset;", "animatedBounds", "(Landroidx/compose/animation/TargetData;Landroidx/compose/ui/geometry/Rect;)J", "animation"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class SharedElementKt {
    public static final Rect getTargetBounds(TargetData targetData) {
        return RectKt.m4633Recttz77jQw(Offset.m4598plusMKHz9U(targetData.m260getInitialMfrOffsetF1C5BW0(), targetData.m262getTargetStructuralOffsetF1C5BW0()), targetData.m261getSizeNHjbRc());
    }

    public static final long calculateOffsetFromDirectManipulation(TargetData targetData, Rect rect) {
        return Offset.m4598plusMKHz9U(Offset.m4597minusMKHz9U(rect.m4628getTopLeftF1C5BW0(), targetData.m260getInitialMfrOffsetF1C5BW0()), targetData.m259getCurrentMfrOffsetF1C5BW0());
    }
}
