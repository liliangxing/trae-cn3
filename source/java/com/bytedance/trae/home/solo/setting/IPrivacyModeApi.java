package com.bytedance.trae.home.solo.setting;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.TraeHttpConnection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: PrivacyModeApi.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u000e\u0010\u0002\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi;", "", "queryPrivacyMode", "Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "operatePrivacyMode", "Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;", "body", "Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationRequest;", "(Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IPrivacyModeApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST("api/ide/v1/privacy/operation")
    Object operatePrivacyMode(@Body PrivacyModeOperationRequest privacyModeOperationRequest, Continuation<? super PrivacyModeOperationResponse> continuation);

    @GET("api/ide/v1/privacy/query")
    Object queryPrivacyMode(Continuation<? super PrivacyModeQueryResponse> continuation);

    /* compiled from: PrivacyModeApi.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u000e\u0010\u0006\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi$Companion;", "", "<init>", "()V", "createService", "Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi;", "query", "Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggle", "Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;", "open", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        private final IPrivacyModeApi createService() {
            return (IPrivacyModeApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "privacy_mode", IPrivacyModeApi.class, (Converter.Factory) null, HostResolver.INSTANCE.getBaseUrl(HostType.AI), (Map) null, false, 52, (Object) null);
        }

        public final Object query(Continuation<? super PrivacyModeQueryResponse> continuation) {
            return createService().queryPrivacyMode(continuation);
        }

        public final Object toggle(boolean z, Continuation<? super PrivacyModeOperationResponse> continuation) {
            return createService().operatePrivacyMode(new PrivacyModeOperationRequest(z ? "open" : "close"), continuation);
        }
    }
}
