package androidx.compose.p002ui.input.pointer;

import android.view.MotionEvent;
import androidx.compose.p002ui.geometry.Offset;
import kotlin.Metadata;

/* compiled from: MotionEventAdapter.android.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/ui/input/pointer/MotionEventHelper;", "", "<init>", "()V", "toRawOffset", "Landroidx/compose/ui/geometry/Offset;", "motionEvent", "Landroid/view/MotionEvent;", "index", "", "toRawOffset-dBAh8RU", "(Landroid/view/MotionEvent;I)J", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class MotionEventHelper {
    public static final MotionEventHelper INSTANCE = new MotionEventHelper();

    private MotionEventHelper() {
    }

    /* renamed from: toRawOffset-dBAh8RU, reason: not valid java name */
    public final long m6073toRawOffsetdBAh8RU(MotionEvent motionEvent, int index) {
        float rawX = motionEvent.getRawX(index);
        float rawY = motionEvent.getRawY(index);
        return Offset.m4585constructorimpl((Float.floatToRawIntBits(rawY) & 4294967295L) | (Float.floatToRawIntBits(rawX) << 32));
    }
}
