package com.bytedance.ies.xbridge.event.bridge;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.xbridge.event.bridge.AdVisibleAreaChangeMonitor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdVisibleAreaChangeMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\b\u0010\u0019\u001a\u00020\fH\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ies/xbridge/event/bridge/AdVisibleAreaChangeMonitor;", "", "mActivity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "callback", "Lcom/bytedance/ies/xbridge/event/bridge/AdVisibleAreaChangeMonitor$Callback;", "getCallback", "()Lcom/bytedance/ies/xbridge/event/bridge/AdVisibleAreaChangeMonitor$Callback;", "setCallback", "(Lcom/bytedance/ies/xbridge/event/bridge/AdVisibleAreaChangeMonitor$Callback;)V", "initialVisibleAreaHeight", "", "lastVisibleAreaHeight", "mDecorView", "Landroid/view/View;", "getMDecorView", "()Landroid/view/View;", "mDecorView$delegate", "Lkotlin/Lazy;", "onGlobalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", ForestLoader.PRELOAD_SCOPE_DISABLE, "", "enable", "getDecorViewVisibleHeight", "Callback", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AdVisibleAreaChangeMonitor {
    private static final int VISIBLE_AREA_CHANGE_GAP_PX = 20;
    private Callback callback;
    private int initialVisibleAreaHeight;
    private int lastVisibleAreaHeight;
    private final Activity mActivity;

    /* renamed from: mDecorView$delegate, reason: from kotlin metadata */
    private final Lazy mDecorView;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;

    /* compiled from: AdVisibleAreaChangeMonitor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/xbridge/event/bridge/AdVisibleAreaChangeMonitor$Callback;", "", "onVisibleHeightChange", "", "oldVisibleHeight", "", "curVisibleHeight", "initialVisibleHeight", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface Callback {
        void onVisibleHeightChange(int oldVisibleHeight, int curVisibleHeight, int initialVisibleHeight);
    }

    public AdVisibleAreaChangeMonitor(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "mActivity");
        this.mActivity = activity;
        this.mDecorView = LazyKt.lazy(new Function0<View>() { // from class: com.bytedance.ies.xbridge.event.bridge.AdVisibleAreaChangeMonitor$mDecorView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final View m637invoke() {
                Activity activity2;
                activity2 = AdVisibleAreaChangeMonitor.this.mActivity;
                View decorView = activity2.getWindow().getDecorView();
                Intrinsics.checkNotNullExpressionValue(decorView, "mActivity.window.decorView");
                return decorView;
            }
        });
        this.onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.ies.xbridge.event.bridge.AdVisibleAreaChangeMonitor$onGlobalLayoutListener$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                int decorViewVisibleHeight;
                int i;
                int i2;
                int i3;
                AdVisibleAreaChangeMonitor.Callback callback;
                int i4;
                int i5;
                decorViewVisibleHeight = AdVisibleAreaChangeMonitor.this.getDecorViewVisibleHeight();
                i = AdVisibleAreaChangeMonitor.this.lastVisibleAreaHeight;
                if (i == 0) {
                    AdVisibleAreaChangeMonitor.this.lastVisibleAreaHeight = decorViewVisibleHeight;
                    return;
                }
                i2 = AdVisibleAreaChangeMonitor.this.lastVisibleAreaHeight;
                if (i2 == decorViewVisibleHeight) {
                    return;
                }
                i3 = AdVisibleAreaChangeMonitor.this.lastVisibleAreaHeight;
                if (Math.abs(decorViewVisibleHeight - i3) > 20 && (callback = AdVisibleAreaChangeMonitor.this.getCallback()) != null) {
                    i4 = AdVisibleAreaChangeMonitor.this.lastVisibleAreaHeight;
                    i5 = AdVisibleAreaChangeMonitor.this.initialVisibleAreaHeight;
                    callback.onVisibleHeightChange(i4, decorViewVisibleHeight, i5);
                }
                AdVisibleAreaChangeMonitor.this.lastVisibleAreaHeight = decorViewVisibleHeight;
            }
        };
    }

    private final View getMDecorView() {
        return (View) this.mDecorView.getValue();
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void setCallback(Callback callback) {
        this.callback = callback;
    }

    public final void enable() {
        int decorViewVisibleHeight = getDecorViewVisibleHeight();
        this.initialVisibleAreaHeight = decorViewVisibleHeight;
        this.lastVisibleAreaHeight = decorViewVisibleHeight;
        getMDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public final void disable() {
        getMDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getDecorViewVisibleHeight() {
        Rect rect = new Rect();
        getMDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.height();
    }
}
