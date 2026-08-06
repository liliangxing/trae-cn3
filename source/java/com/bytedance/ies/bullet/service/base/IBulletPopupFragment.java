package com.bytedance.ies.bullet.service.base;

import android.net.Uri;
import android.view.View;
import com.bytedance.webx.core.webview.WebViewContainer;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: IPopUpService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0007H&J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/IBulletPopupFragment;", "", "constructContentView", "Landroid/view/View;", "containerID", "", "init", "", "load", "uri", "Landroid/net/Uri;", "provideTitleBarText", "", WebViewContainer.EVENT_reload, "sendEventToFE", "name", "params", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IBulletPopupFragment {
    View constructContentView();

    String containerID();

    void init();

    void load(Uri uri);

    CharSequence provideTitleBarText();

    void reload();

    void sendEventToFE(String name, JSONObject params);
}
