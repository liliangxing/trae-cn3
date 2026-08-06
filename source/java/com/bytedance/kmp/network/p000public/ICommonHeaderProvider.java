package com.bytedance.kmp.network.p000public;

import com.bytedance.kmp.network.requet.Request;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: BizInterceptorManager.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/bytedance/kmp/network/public/ICommonHeaderProvider;", "", "getCommonHeaders", "", "", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/kmp/network/requet/Request;", "url", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ICommonHeaderProvider {
    Map<String, String> getCommonHeaders(Request request);

    Map<String, String> getCommonHeaders(String url);
}
