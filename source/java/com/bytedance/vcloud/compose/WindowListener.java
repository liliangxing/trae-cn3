package com.bytedance.vcloud.compose;

import com.bytedance.webx.core.webview.WebViewContainer;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* compiled from: UniInternal.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/bytedance/vcloud/compose/WindowListener;", "", "onFirstDrew", "", WebViewContainer.EVENT_onSizeChanged, "w", "", RXScreenCaptureService.KEY_HEIGHT, "onWindowReady", "uniplayer-ui-trae_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface WindowListener {
    void onFirstDrew();

    void onSizeChanged(int w, int h);

    void onWindowReady();
}
