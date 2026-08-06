package coil3.network.bytedance.internal;

import coil3.network.NetworkRequest;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import kotlin.Metadata;

/* compiled from: utils.common.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcoil3/network/bytedance/internal/CoilInterceptor;", "", "interceptorRequest", "Lcoil3/network/NetworkRequest;", OauthTokenTriggerScene.REQUEST, "coil_network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface CoilInterceptor {
    NetworkRequest interceptorRequest(NetworkRequest request);
}
