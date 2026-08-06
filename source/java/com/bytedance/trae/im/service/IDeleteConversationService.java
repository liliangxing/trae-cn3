package com.bytedance.trae.im.service;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.HTTP;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.bytedance.trae.im.service.IDeleteConversationService;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.ttnet.http.RequestContext;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IDeleteConversationService.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J&\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/im/service/IDeleteConversationService;", "", "delete", "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/DeleteConversationResponse;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/DeleteConversationRequest;", "(Lcom/bytedance/trae/im/service/DeleteConversationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRaw", "Lcom/bytedance/retrofit2/Call;", "", "extraInfo", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IDeleteConversationService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @HTTP(hasBody = true, method = OpenNetMethod.DELETE, path = "api/solo_hub/v1/conversations")
    Object delete(@Body DeleteConversationRequest deleteConversationRequest, Continuation<? super BizResponse<DeleteConversationResponse>> continuation);

    @HTTP(hasBody = true, method = OpenNetMethod.DELETE, path = "api/solo_hub/v1/conversations")
    Call<String> deleteRaw(@Body DeleteConversationRequest request, @ExtraInfo Object extraInfo);

    /* compiled from: IDeleteConversationService.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/im/service/IDeleteConversationService$Companion;", "", "<init>", "()V", "SUCCESS_CODES", "", "", "DEFAULT_HEADERS", "", "", "getDEFAULT_HEADERS", "()Ljava/util/Map;", "deleteConversationRawCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/DeleteConversationResponse;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/DeleteConversationRequest;", "(Lcom/bytedance/trae/im/service/DeleteConversationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<Long> SUCCESS_CODES = SetsKt.setOf(200L);

        private Companion() {
        }

        private final Map<String, String> getDEFAULT_HEADERS() {
            return DebugSettings.buildDefaultHeaders$default(DebugSettings.INSTANCE, (Map) null, 1, (Object) null);
        }

        public final Object deleteConversationRawCall(final DeleteConversationRequest deleteConversationRequest, Continuation<? super HttpDataResult<DeleteConversationResponse>> continuation) {
            return TraeHttpConnection.rawBizCall$default(TraeHttpConnection.INSTANCE, "delete", IDeleteConversationService.class, DeleteConversationResponse.class, (String) null, (String) null, getDEFAULT_HEADERS(), true, SUCCESS_CODES, false, new Function2() { // from class: com.bytedance.trae.im.service.IDeleteConversationService$Companion$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Call deleteConversationRawCall$lambda$0;
                    deleteConversationRawCall$lambda$0 = IDeleteConversationService.Companion.deleteConversationRawCall$lambda$0(DeleteConversationRequest.this, (IDeleteConversationService) obj, (RequestContext) obj2);
                    return deleteConversationRawCall$lambda$0;
                }
            }, continuation, 280, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call deleteConversationRawCall$lambda$0(DeleteConversationRequest deleteConversationRequest, IDeleteConversationService iDeleteConversationService, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iDeleteConversationService, "$this$rawBizCall");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iDeleteConversationService.deleteRaw(deleteConversationRequest, requestContext);
        }
    }
}
