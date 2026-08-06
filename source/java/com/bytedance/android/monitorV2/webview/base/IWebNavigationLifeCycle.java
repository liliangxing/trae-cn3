package com.bytedance.android.monitorV2.webview.base;

import androidx.core.app.NotificationCompat;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.webx.core.webview.client.WebChromeContainerClient;
import com.bytedance.webx.core.webview.client.WebViewContainerClient;
import kotlin.Metadata;

/* compiled from: IWebNavigationLifeCycle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/base/IWebNavigationLifeCycle;", "", WebViewContainerClient.EVENT_onPageFinished, "", WebViewContainerClient.EVENT_onPageStarted, "event", "Lcom/bytedance/android/monitorV2/event/CommonEvent;", WebChromeContainerClient.EVENT_onProgressChanged, NotificationCompat.CATEGORY_PROGRESS, "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public interface IWebNavigationLifeCycle {
    void onPageFinished();

    void onPageStarted(CommonEvent event);

    void onProgressChanged(int progress);
}
