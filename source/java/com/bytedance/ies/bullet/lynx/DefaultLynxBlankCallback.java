package com.bytedance.ies.bullet.lynx;

import android.view.View;
import com.bytedance.android.monitorV2.lynx.blank.LynxBlankDetect;
import com.bytedance.ies.bullet.core.BulletContext;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxKitBlankDetectResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0002\u0010\u0005J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J \u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/DefaultLynxBlankCallback;", "Lcom/bytedance/android/monitorV2/lynx/blank/LynxBlankDetect$OnLynxBlankCallback;", "contextRef", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/ies/bullet/core/BulletContext;", "(Ljava/lang/ref/WeakReference;)V", "onDetectCost", "", "view", "Landroid/view/View;", "type", "", "collectDuration", "", "calculateDuration", "onDetectResult", "percent", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DefaultLynxBlankCallback implements LynxBlankDetect.OnLynxBlankCallback {
    private final WeakReference<BulletContext> contextRef;

    public void onDetectCost(View view, String type, long collectDuration, long calculateDuration) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(type, "type");
    }

    public DefaultLynxBlankCallback(WeakReference<BulletContext> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "contextRef");
        this.contextRef = weakReference;
    }

    public void onDetectResult(View view, String type, float percent) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(type, "type");
        BulletContext bulletContext = this.contextRef.get();
        if (bulletContext != null) {
            bulletContext.getMonitorCallback().onBlankDetected(bulletContext, null, Float.valueOf(percent));
        }
    }
}
