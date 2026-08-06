package com.bytedance.ies.xbridge.event.bridge;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyboardUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000fJ\"\u0010\u0010\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/xbridge/event/bridge/KeyboardUtils;", "", "()V", "TAG_ON_GLOBAL_LAYOUT_LISTENER", "", "sDecorViewDelta", "getDecorViewInvisibleHeight", "appContext", "Landroid/content/Context;", "window", "Landroid/view/Window;", "getNavigationBarHeight", "getStatusBarHeight", "px2dp", "pxValue", "", "registerSoftInputChangedListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/ies/xbridge/event/bridge/KeyboardUtils$OnSoftInputChangedListener;", "unregisterSoftInputChangedListener", "Landroid/app/Activity;", "OnSoftInputChangedListener", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class KeyboardUtils {
    public static final KeyboardUtils INSTANCE = new KeyboardUtils();
    private static final int TAG_ON_GLOBAL_LAYOUT_LISTENER = -8;
    private static int sDecorViewDelta;

    /* compiled from: KeyboardUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/xbridge/event/bridge/KeyboardUtils$OnSoftInputChangedListener;", "", "onSoftInputChanged", "", "height", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public interface OnSoftInputChangedListener {
        void onSoftInputChanged(int height);
    }

    private KeyboardUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getDecorViewInvisibleHeight(Context appContext, Window window) {
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int abs = Math.abs(decorView.getBottom() - rect.bottom);
        if (abs <= getStatusBarHeight(appContext) + getNavigationBarHeight(appContext)) {
            sDecorViewDelta = abs;
            return 0;
        }
        return abs - sDecorViewDelta;
    }

    public final void registerSoftInputChangedListener(final Context appContext, final Window window, final OnSoftInputChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (appContext == null || window == null) {
            return;
        }
        if ((window.getAttributes().flags & 512) != 0) {
            window.clearFlags(512);
        }
        FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.content);
        final int[] iArr = {getDecorViewInvisibleHeight(appContext, window)};
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.ies.xbridge.event.bridge.KeyboardUtils$registerSoftInputChangedListener$onGlobalLayoutListener$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                int decorViewInvisibleHeight;
                decorViewInvisibleHeight = KeyboardUtils.INSTANCE.getDecorViewInvisibleHeight(appContext, window);
                if (iArr[0] != decorViewInvisibleHeight) {
                    listener.onSoftInputChanged(decorViewInvisibleHeight);
                    iArr[0] = decorViewInvisibleHeight;
                }
            }
        };
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        frameLayout.setTag(-8, onGlobalLayoutListener);
    }

    public final void unregisterSoftInputChangedListener(Activity window) {
        FrameLayout frameLayout;
        Object tag;
        if (window == null || (tag = (frameLayout = (FrameLayout) window.findViewById(R.id.content)).getTag(-8)) == null) {
            return;
        }
        frameLayout.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) tag);
    }

    private final int getNavigationBarHeight(Context appContext) {
        Resources resources = appContext.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "appContext.resources");
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    private final int getStatusBarHeight(Context appContext) {
        Resources resources = appContext.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "appContext.resources");
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public final int px2dp(Context appContext, double pxValue) {
        Resources system;
        if (appContext != null) {
            system = appContext.getApplicationContext().getResources();
        } else {
            system = Resources.getSystem();
        }
        return (int) ((pxValue / system.getDisplayMetrics().density) + 0.5f);
    }
}
