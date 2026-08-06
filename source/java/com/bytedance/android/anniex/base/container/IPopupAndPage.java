package com.bytedance.android.anniex.base.container;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.lynx.tasm.DefaultLogicExecutor;
import kotlin.Metadata;

/* compiled from: IPopupAndPage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH'J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H'J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0003H&J\u001a\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/anniex/base/container/IPopupAndPage;", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", WebViewContainer.EVENT_onConfigurationChanged, "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "rootView", "Landroid/view/View;", DefaultLogicExecutor.LIFECYCLE_EVENT_ON_DESTROY, "onDetach", WebViewContainer.EVENT_onPause, "onResume", "onStart", "onStop", "onViewCreated", "view", "setUserVisibleHint", "isVisibleToUser", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IPopupAndPage {
    void onActivityCreated(Bundle savedInstanceState);

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onConfigurationChanged(Configuration newConfig);

    void onCreateView(View rootView);

    void onDestroy();

    void onDetach();

    void onPause();

    void onResume();

    void onStart();

    void onStop();

    void onViewCreated(View view, Bundle savedInstanceState);

    void setUserVisibleHint(boolean isVisibleToUser);
}
