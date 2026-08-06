package com.tt.skin.sdk.android;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.webx.core.webview.WebViewContainer;
import kotlin.Metadata;

/* compiled from: ISkinPaint.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/tt/skin/sdk/android/ISkinPaint;", "", WebViewContainer.EVENT_destroy, "", "setAppChangeListener", "setColorRes", "colorRes", "", "setLifecyclerOnwer", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public interface ISkinPaint {
    void destroy();

    void setAppChangeListener();

    void setColorRes(int colorRes);

    void setLifecyclerOnwer(LifecycleOwner lifecycleOwner);
}
