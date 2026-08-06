package com.bytedance.android.monitorV2.webview.service;

import com.bytedance.android.monitorV2.event.HybridEvent;
import kotlin.Metadata;

/* compiled from: IWebNavigationInfoCollector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/service/IWebNavigationInfoCollector;", "", "onEventEnqueue", "", "event", "Lcom/bytedance/android/monitorV2/event/HybridEvent;", "onPageFinished", "navigationId", "", "onPageStart", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface IWebNavigationInfoCollector {
    void onEventEnqueue(HybridEvent event);

    void onPageFinished(String navigationId);

    void onPageStart(String navigationId);
}
