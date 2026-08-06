package com.bytedance.ies.bullet.service.base.web;

import android.net.Uri;
import com.bytedance.ies.bullet.IBulletKitViewService;
import com.bytedance.ies.bullet.service.base.bridge.IWebJsBridge;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IWebKitService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0015\u001a\u00020\u0004H&J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H&R&\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u0004\u0018\u00010\nX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u0010X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/web/IWebKitViewService;", "Lcom/bytedance/ies/bullet/IBulletKitViewService;", "additionalHttpHeaders", "", "", "getAdditionalHttpHeaders", "()Ljava/util/Map;", "setAdditionalHttpHeaders", "(Ljava/util/Map;)V", "currentUri", "Landroid/net/Uri;", "getCurrentUri", "()Landroid/net/Uri;", "setCurrentUri", "(Landroid/net/Uri;)V", "mWebJsBridge", "Lcom/bytedance/ies/bullet/service/base/bridge/IWebJsBridge;", "getMWebJsBridge", "()Lcom/bytedance/ies/bullet/service/base/bridge/IWebJsBridge;", "setMWebJsBridge", "(Lcom/bytedance/ies/bullet/service/base/bridge/IWebJsBridge;)V", "getCurrentUrl", "invokeJavaMethod", "", "url", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IWebKitViewService extends IBulletKitViewService {
    Map<String, String> getAdditionalHttpHeaders();

    Uri getCurrentUri();

    String getCurrentUrl();

    IWebJsBridge getMWebJsBridge();

    boolean invokeJavaMethod(String url);

    void setAdditionalHttpHeaders(Map<String, String> map);

    void setCurrentUri(Uri uri);

    void setMWebJsBridge(IWebJsBridge iWebJsBridge);

    /* compiled from: IWebKitService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static boolean ensureViewCreated(IWebKitViewService iWebKitViewService, String schemaUrl) {
            Intrinsics.checkNotNullParameter(schemaUrl, "schemaUrl");
            return IBulletKitViewService.DefaultImpls.ensureViewCreated(iWebKitViewService, schemaUrl);
        }
    }
}
