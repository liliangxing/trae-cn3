package com.bytedance.android.monitorV2.lynx.blank;

import android.view.View;
import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: LynxBlankDetect.kt */
@Deprecated(message = "No longer supported")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/blank/LynxBlankDetect;", "", "()V", "OnLynxBlankCallback", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class LynxBlankDetect {
    public static final LynxBlankDetect INSTANCE = new LynxBlankDetect();

    /* compiled from: LynxBlankDetect.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/blank/LynxBlankDetect$OnLynxBlankCallback;", "", "onDetectCost", "", "view", "Landroid/view/View;", "type", "", "collectDuration", "", "calculateDuration", "onDetectResult", "percent", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public interface OnLynxBlankCallback {
        void onDetectCost(View view, String type, long collectDuration, long calculateDuration);

        void onDetectResult(View view, String type, float percent);
    }

    private LynxBlankDetect() {
    }
}
