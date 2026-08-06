package com.bytedance.trae.home.zlink;

import com.bytedance.sdk.xbridge.cn.auth.respository.PermissionConfigParser;
import com.bytedance.trae.home.zlink.PendingDeepLinkRoute;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* compiled from: PendingDeepLinkRoutePolicy.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoutePolicy;", "", "<init>", "()V", "resolve", "Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute;", PermissionConfigParser.WEBCAST_HOST_NAMESPACE, "", "conversationId", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PendingDeepLinkRoutePolicy {
    public static final int $stable = 0;
    public static final PendingDeepLinkRoutePolicy INSTANCE = new PendingDeepLinkRoutePolicy();

    private PendingDeepLinkRoutePolicy() {
    }

    public final PendingDeepLinkRoute resolve(String host, String conversationId) {
        if (StringsKt.equals(host, "conversation", true)) {
            if (conversationId == null || !(!StringsKt.isBlank(conversationId))) {
                conversationId = null;
            }
            return new PendingDeepLinkRoute.Conversation(conversationId);
        }
        return PendingDeepLinkRoute.RoutedByZlink.INSTANCE;
    }
}
