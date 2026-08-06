package com.bytedance.trae.im.service;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.trae.im.service.IGetConversationFullDetailService;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.ttnet.http.RequestContext;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IGetConversationFullDetailService.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J&\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0001H'¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/im/service/IGetConversationFullDetailService;", "", "getConversationFullDetailRaw", "Lcom/bytedance/retrofit2/Call;", "", "conversationId", "extraInfo", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IGetConversationFullDetailService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @GET("api/solo_hub/v1/conversations/full_detail")
    Call<String> getConversationFullDetailRaw(@Query("conversation_id") String conversationId, @ExtraInfo Object extraInfo);

    /* compiled from: IGetConversationFullDetailService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Call getConversationFullDetailRaw$default(IGetConversationFullDetailService iGetConversationFullDetailService, String str, Object obj, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getConversationFullDetailRaw");
            }
            if ((i & 2) != 0) {
                obj = null;
            }
            return iGetConversationFullDetailService.getConversationFullDetailRaw(str, obj);
        }
    }

    /* compiled from: IGetConversationFullDetailService.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/im/service/IGetConversationFullDetailService$Companion;", "", "<init>", "()V", "SUCCESS_CODES", "", "", "DEFAULT_HEADERS", "", "", "getDEFAULT_HEADERS", "()Ljava/util/Map;", "getConversationFullDetailRawCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/ConversationFullDetailResponse;", "conversationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<Long> SUCCESS_CODES = SetsKt.setOf(200L);

        private Companion() {
        }

        private final Map<String, String> getDEFAULT_HEADERS() {
            return DebugSettings.buildDefaultHeaders$default(DebugSettings.INSTANCE, (Map) null, 1, (Object) null);
        }

        public final Object getConversationFullDetailRawCall(final String str, Continuation<? super HttpDataResult<ConversationFullDetailResponse>> continuation) {
            return TraeHttpConnection.rawBizCall$default(TraeHttpConnection.INSTANCE, "base", IGetConversationFullDetailService.class, ConversationFullDetailResponse.class, (String) null, (String) null, getDEFAULT_HEADERS(), true, SUCCESS_CODES, true, new Function2() { // from class: com.bytedance.trae.im.service.IGetConversationFullDetailService$Companion$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Call conversationFullDetailRawCall$lambda$0;
                    conversationFullDetailRawCall$lambda$0 = IGetConversationFullDetailService.Companion.getConversationFullDetailRawCall$lambda$0(str, (IGetConversationFullDetailService) obj, (RequestContext) obj2);
                    return conversationFullDetailRawCall$lambda$0;
                }
            }, continuation, 24, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call getConversationFullDetailRawCall$lambda$0(String str, IGetConversationFullDetailService iGetConversationFullDetailService, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iGetConversationFullDetailService, "$this$rawBizCall");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iGetConversationFullDetailService.getConversationFullDetailRaw(str, requestContext);
        }
    }
}
