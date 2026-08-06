package com.bytedance.sysoptimizer;

import android.app.Activity;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.This;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

@Skip({"-com.bytedance.pagex.dispatch.PageHostActivity", "com.bytedance.thanos+"})
/* loaded from: classes5.dex */
public class EnterTransitionLancet {
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public void onStop() {
        Origin.callVoid();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) This.get()).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
