package com.bytedance.trae.im.service;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.trae.im.service.IListMessagesService;
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

/* compiled from: IListMessagesService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJZ\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\b2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0001H'¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/im/service/IListMessagesService;", "", "listMessagesByAnchorRaw", "Lcom/bytedance/retrofit2/Call;", "", "conversationId", "anchorCreatedAtMs", "beforeLimit", "", "afterLimit", "includeAnchor", "", "maxLength", "extraInfo", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IListMessagesService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @GET("api/solo_hub/v1/conversations/messages/anchor")
    Call<String> listMessagesByAnchorRaw(@Query("conversation_id") String conversationId, @Query("anchor_created_at_ms") String anchorCreatedAtMs, @Query("before_limit") int beforeLimit, @Query("after_limit") int afterLimit, @Query("include_anchor") boolean includeAnchor, @MaxLength int maxLength, @ExtraInfo Object extraInfo);

    /* compiled from: IListMessagesService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Call listMessagesByAnchorRaw$default(IListMessagesService iListMessagesService, String str, String str2, int i, int i2, boolean z, int i3, Object obj, int i4, Object obj2) {
            if (obj2 == null) {
                return iListMessagesService.listMessagesByAnchorRaw(str, (i4 & 2) != 0 ? null : str2, i, i2, z, i3, obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listMessagesByAnchorRaw");
        }
    }

    /* compiled from: IListMessagesService.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/im/service/IListMessagesService$Companion;", "", "<init>", "()V", "SUCCESS_CODES", "", "", "DEFAULT_HEADERS", "", "", "getDEFAULT_HEADERS", "()Ljava/util/Map;", "listMessagesByAnchorRawCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/ListMessagesResponse;", "conversationId", "anchorCreatedAtMs", "beforeLimit", "", "afterLimit", "includeAnchor", "", "(Ljava/lang/String;Ljava/lang/String;IIZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<Long> SUCCESS_CODES = SetsKt.setOf(200L);

        private Companion() {
        }

        private final Map<String, String> getDEFAULT_HEADERS() {
            return DebugSettings.buildDefaultHeaders$default(DebugSettings.INSTANCE, (Map) null, 1, (Object) null);
        }

        public static /* synthetic */ Object listMessagesByAnchorRawCall$default(Companion companion, String str, String str2, int i, int i2, boolean z, Continuation continuation, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str2 = null;
            }
            String str3 = str2;
            if ((i3 & 4) != 0) {
                i = 10;
            }
            return companion.listMessagesByAnchorRawCall(str, str3, i, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) != 0 ? false : z, continuation);
        }

        public final Object listMessagesByAnchorRawCall(final String str, final String str2, final int i, final int i2, final boolean z, Continuation<? super HttpDataResult<ListMessagesResponse>> continuation) {
            return TraeHttpConnection.rawBizCall$default(TraeHttpConnection.INSTANCE, "base", IListMessagesService.class, ListMessagesResponse.class, (String) null, (String) null, getDEFAULT_HEADERS(), true, SUCCESS_CODES, true, new Function2() { // from class: com.bytedance.trae.im.service.IListMessagesService$Companion$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Call listMessagesByAnchorRawCall$lambda$0;
                    listMessagesByAnchorRawCall$lambda$0 = IListMessagesService.Companion.listMessagesByAnchorRawCall$lambda$0(str, str2, i, i2, z, (IListMessagesService) obj, (RequestContext) obj2);
                    return listMessagesByAnchorRawCall$lambda$0;
                }
            }, continuation, 24, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call listMessagesByAnchorRawCall$lambda$0(String str, String str2, int i, int i2, boolean z, IListMessagesService iListMessagesService, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iListMessagesService, "$this$rawBizCall");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iListMessagesService.listMessagesByAnchorRaw(str, str2, i, i2, z, 52428800, requestContext);
        }
    }
}
