package androidx.compose.p002ui.hapticfeedback;

import android.view.View;
import kotlin.Metadata;

/* compiled from: PlatformHapticFeedback.android.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/compose/ui/hapticfeedback/PlatformHapticFeedback;", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "performHapticFeedback", "", "hapticFeedbackType", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "performHapticFeedback-CdsT49E", "(I)V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class PlatformHapticFeedback implements HapticFeedback {
    public static final int $stable = 8;
    private final View view;

    public PlatformHapticFeedback(View view) {
        this.view = view;
    }

    @Override // androidx.compose.p002ui.hapticfeedback.HapticFeedback
    /* renamed from: performHapticFeedback-CdsT49E */
    public void mo5617performHapticFeedbackCdsT49E(int hapticFeedbackType) {
        if (HapticFeedbackType.m5621equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5625getConfirm5zf0vsI())) {
            this.view.performHapticFeedback(16);
            return;
        }
        if (HapticFeedbackType.m5621equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5626getContextClick5zf0vsI())) {
            this.view.performHapticFeedback(6);
            return;
        }
        if (HapticFeedbackType.m5621equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5627getGestureEnd5zf0vsI())) {
            this.view.performHapticFeedback(13);
            return;
        }
        if (HapticFeedbackType.m5621equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5628getGestureThresholdActivate5zf0vsI())) {
            this.view.performHapticFeedback(23);
            return;
        }
        if (HapticFeedbackType.m5621equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5629getKeyboardTap5zf0vsI())) {
            this.view.performHapticFeedback(3);
            return;
        }
        if (HapticFeedbackType.m5621equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5630getLongPress5zf0vsI())) {
            this.view.performHapticFeedback(0);
            return;
        }
        if (HapticFeedbackType.m5621equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5631getReject5zf0vsI())) {
            this.view.performHapticFeedback(17);
            return;
        }
        if (HapticFeedbackType.m5621equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5632getSegmentFrequentTick5zf0vsI())) {
            this.view.performHapticFeedback(27);
            return;
        }
        if (HapticFeedbackType.m5621equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5633getSegmentTick5zf0vsI())) {
            this.view.performHapticFeedback(26);
            return;
        }
        if (HapticFeedbackType.m5621equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5634getTextHandleMove5zf0vsI())) {
            this.view.performHapticFeedback(9);
            return;
        }
        if (HapticFeedbackType.m5621equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5635getToggleOff5zf0vsI())) {
            this.view.performHapticFeedback(22);
        } else if (HapticFeedbackType.m5621equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5636getToggleOn5zf0vsI())) {
            this.view.performHapticFeedback(21);
        } else if (HapticFeedbackType.m5621equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5637getVirtualKey5zf0vsI())) {
            this.view.performHapticFeedback(1);
        }
    }
}
