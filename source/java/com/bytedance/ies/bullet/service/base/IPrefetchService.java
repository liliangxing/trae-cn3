package com.bytedance.ies.bullet.service.base;

import android.net.Uri;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.pia.core.metrics.ErrorType;
import java.util.Collection;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: IPrefetchService.kt */
@Deprecated(message = "建议使用已有的默认配置，无需自定义")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H&J\u001c\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/IPrefetchService;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "getCacheByScheme", "Lorg/json/JSONObject;", "scheme", "Landroid/net/Uri;", "getCacheBySchemeV2", "", "Lcom/bytedance/ies/bullet/service/base/PrefetchV2Data;", ErrorType.PREFETCH, "", "schema", "url", "", "prefetchForRouter", "prefetchForView", "providePrefetchBridge", "", "providerFactory", "bridgeName", "shouldInjectProps", "", "uri", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IPrefetchService extends IBulletService {
    JSONObject getCacheByScheme(Uri scheme);

    @Deprecated(message = "收到PrefetchV2Service内")
    Collection<PrefetchV2Data> getCacheBySchemeV2(Uri scheme);

    void prefetch(Uri schema);

    void prefetch(String url);

    void prefetchForRouter(Uri schema);

    void prefetchForView(Uri schema);

    Object providePrefetchBridge(Object providerFactory, String bridgeName);

    boolean shouldInjectProps(Uri uri);

    /* compiled from: IPrefetchService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object providePrefetchBridge$default(IPrefetchService iPrefetchService, Object obj, String str, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: providePrefetchBridge");
            }
            if ((i & 2) != 0) {
                str = null;
            }
            return iPrefetchService.providePrefetchBridge(obj, str);
        }
    }
}
