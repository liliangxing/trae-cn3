package com.bytedance.ies.bullet.kit.web;

import android.view.View;
import com.bytedance.android.monitorV2.webview.base.IWebBlankCallback;
import com.bytedance.ies.bullet.core.BulletContext;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultWebBlankCallback.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/DefaultWebBlankCallback;", "Lcom/bytedance/android/monitorV2/webview/base/IWebBlankCallback;", "contextRef", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/ies/bullet/core/BulletContext;", "(Ljava/lang/ref/WeakReference;)V", "onDetectCost", "", "view", "Landroid/view/View;", "costTime", "", "onDetectResult", "blankState", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DefaultWebBlankCallback implements IWebBlankCallback {
    private final WeakReference<BulletContext> contextRef;

    public void onDetectCost(View view, long costTime) {
    }

    public DefaultWebBlankCallback(WeakReference<BulletContext> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "contextRef");
        this.contextRef = weakReference;
    }

    public void onDetectResult(View view, int blankState) {
        BulletContext bulletContext = this.contextRef.get();
        if (bulletContext != null) {
            bulletContext.getMonitorCallback().onBlankDetected(bulletContext, Integer.valueOf(2 - blankState), null);
        }
    }
}
