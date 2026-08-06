package com.bytedance.trae.conversation.network;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.TraeHttpConnection;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* compiled from: IGithubAccessApi.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\"\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\"\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\"\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\fH§@¢\u0006\u0002\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/network/IGithubAccessApi;", "", "setThirdPartyToken", "Lcom/bytedance/retrofit2/SsResponse;", "", "body", "Lcom/bytedance/trae/conversation/network/SetThirdPartyTokenRequest;", "(Lcom/bytedance/trae/conversation/network/SetThirdPartyTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getThirdPartyToken", "Lcom/bytedance/trae/conversation/network/GetThirdPartyTokenRequest;", "(Lcom/bytedance/trae/conversation/network/GetThirdPartyTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnectThirdPartyToken", "Lcom/bytedance/trae/conversation/network/DisconnectThirdPartyTokenRequest;", "(Lcom/bytedance/trae/conversation/network/DisconnectThirdPartyTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IGithubAccessApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST("cloudide/api/v3/trae/DisconnectThirdPartyToken")
    Object disconnectThirdPartyToken(@Body DisconnectThirdPartyTokenRequest disconnectThirdPartyTokenRequest, Continuation<? super SsResponse<String>> continuation);

    @POST("cloudide/api/v3/trae/GetThirdPartyToken")
    Object getThirdPartyToken(@Body GetThirdPartyTokenRequest getThirdPartyTokenRequest, Continuation<? super SsResponse<String>> continuation);

    @POST("cloudide/api/v3/trae/SetThirdPartyToken")
    Object setThirdPartyToken(@Body SetThirdPartyTokenRequest setThirdPartyTokenRequest, Continuation<? super SsResponse<String>> continuation);

    /* compiled from: IGithubAccessApi.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\b\nH\u0086@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/network/IGithubAccessApi$Companion;", "", "<init>", "()V", "safeCallPost", "T", "call", "Lkotlin/Function2;", "Lcom/bytedance/trae/conversation/network/IGithubAccessApi;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final <T> Object safeCallPost(Function2<? super IGithubAccessApi, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
            ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
            String xTToken = iLoginService != null ? iLoginService.getXTToken() : null;
            if (xTToken == null) {
                xTToken = "";
            }
            Map createMapBuilder = MapsKt.createMapBuilder();
            if (xTToken.length() > 0) {
                createMapBuilder.put("X-Cloudide-Token", xTToken);
            }
            return function2.invoke((IGithubAccessApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "github_connect", IGithubAccessApi.class, (Converter.Factory) null, HostResolver.INSTANCE.getBaseUrl(HostType.LOGIN), MapsKt.build(createMapBuilder), false, 36, (Object) null), continuation);
        }
    }
}
