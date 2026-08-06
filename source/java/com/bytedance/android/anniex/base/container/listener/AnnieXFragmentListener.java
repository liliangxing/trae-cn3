package com.bytedance.android.anniex.base.container.listener;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.lynx.tasm.DefaultLogicExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXFragmentListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tJ\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0014\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0014\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0006\u0010\u0016\u001a\u00020\u0004J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/anniex/base/container/listener/AnnieXFragmentListener;", "", "()V", WebViewContainer.EVENT_onConfigurationChanged, "", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", DefaultLogicExecutor.LIFECYCLE_EVENT_ON_DESTROY, "anniexContainer", "Lcom/bytedance/android/anniex/base/container/IContainer;", "onDetach", WebViewContainer.EVENT_onPause, "onResume", "onStart", "onStop", "onViewCreated", "view", "Landroid/view/View;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public class AnnieXFragmentListener {
    public final void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
    }

    public final void onCreate(Bundle savedInstanceState) {
    }

    public final void onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
    }

    public void onDestroy(IContainer anniexContainer) {
    }

    public final void onDetach() {
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public void onStart(IContainer anniexContainer) {
    }

    public final void onStop() {
    }

    public final void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public static /* synthetic */ void onDestroy$default(AnnieXFragmentListener annieXFragmentListener, IContainer iContainer, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDestroy");
        }
        if ((i & 1) != 0) {
            iContainer = null;
        }
        annieXFragmentListener.onDestroy(iContainer);
    }

    public static /* synthetic */ void onStart$default(AnnieXFragmentListener annieXFragmentListener, IContainer iContainer, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onStart");
        }
        if ((i & 1) != 0) {
            iContainer = null;
        }
        annieXFragmentListener.onStart(iContainer);
    }
}
