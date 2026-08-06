package com.bytedance.trae.im.service;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.im.service.IListConversationsService;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.ttnet.http.RequestContext;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IListConversationsService.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJ|\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0010\b\u0003\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011H§@¢\u0006\u0002\u0010\u0012J\u0089\u0001\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00142\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0010\b\u0003\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0001H'¢\u0006\u0002\u0010\u0016JN\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00142\b\b\u0001\u0010\u0018\u001a\u00020\t2\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\u0019\u001a\u00020\u001a2\b\b\u0003\u0010\u001b\u001a\u00020\u001a2\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0001H'¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/im/service/IListConversationsService;", "", "listConversations", "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/ListConversationsResponse;", "pageSize", "", "pageIndex", "orderBy", "", "sort", "pinnedTop", "", "hasNoParentConversation", "hasTasks", "hiddenStatus", "parentConversationIds", "", "(IILjava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listConversationsRaw", "Lcom/bytedance/retrofit2/Call;", "extraInfo", "(IILjava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;", "searchConversationsRaw", "keyword", "startTime", "", "endTime", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IListConversationsService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @GET("api/solo_hub/v1/conversations")
    Object listConversations(@Query("page_size") int i, @Query("page_index") int i2, @Query("order_by") String str, @Query("sort") String str2, @Query("pinned_top") boolean z, @Query("has_no_parent_conversation") Integer num, @Query("has_tasks") Integer num2, @Query("hidden_status") String str3, @Query("parent_conversation_ids") List<String> list, Continuation<? super BizResponse<ListConversationsResponse>> continuation);

    @GET("api/solo_hub/v1/conversations")
    Call<String> listConversationsRaw(@Query("page_size") int pageSize, @Query("page_index") int pageIndex, @Query("order_by") String orderBy, @Query("sort") String sort, @Query("pinned_top") boolean pinnedTop, @Query("has_no_parent_conversation") Integer hasNoParentConversation, @Query("has_tasks") Integer hasTasks, @Query("hidden_status") String hiddenStatus, @Query("parent_conversation_ids") List<String> parentConversationIds, @ExtraInfo Object extraInfo);

    @GET("api/solo_hub/v1/conversations/search")
    Call<String> searchConversationsRaw(@Query("keyword") String keyword, @Query("page_size") int pageSize, @Query("page_index") int pageIndex, @Query("start_time") long startTime, @Query("end_time") long endTime, @ExtraInfo Object extraInfo);

    /* compiled from: IListConversationsService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object listConversations$default(IListConversationsService iListConversationsService, int i, int i2, String str, String str2, boolean z, Integer num, Integer num2, String str3, List list, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                return iListConversationsService.listConversations((i3 & 1) != 0 ? 300 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? "updated_at" : str, (i3 & 8) != 0 ? "desc" : str2, (i3 & 16) != 0 ? true : z, (i3 & 32) != 0 ? 1 : num, (i3 & 64) != 0 ? 1 : num2, (i3 & 128) != 0 ? "" : str3, (i3 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : list, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listConversations");
        }

        public static /* synthetic */ Call listConversationsRaw$default(IListConversationsService iListConversationsService, int i, int i2, String str, String str2, boolean z, Integer num, Integer num2, String str3, List list, Object obj, int i3, Object obj2) {
            if (obj2 == null) {
                return iListConversationsService.listConversationsRaw((i3 & 1) != 0 ? 300 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? "updated_at" : str, (i3 & 8) != 0 ? "desc" : str2, (i3 & 16) != 0 ? true : z, (i3 & 32) != 0 ? 1 : num, (i3 & 64) != 0 ? 1 : num2, (i3 & 128) != 0 ? "" : str3, (i3 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : list, (i3 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) == 0 ? obj : null);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listConversationsRaw");
        }

        public static /* synthetic */ Call searchConversationsRaw$default(IListConversationsService iListConversationsService, String str, int i, int i2, long j, long j2, Object obj, int i3, Object obj2) {
            if (obj2 == null) {
                return iListConversationsService.searchConversationsRaw(str, (i3 & 2) != 0 ? 20 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? 0L : j, (i3 & 16) != 0 ? 0L : j2, obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: searchConversationsRaw");
        }
    }

    /* compiled from: IListConversationsService.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J|\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001aH\u0086@¢\u0006\u0002\u0010\u001bJD\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\r2\u0006\u0010\u001e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010!R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\""}, d2 = {"Lcom/bytedance/trae/im/service/IListConversationsService$Companion;", "", "<init>", "()V", "SUCCESS_CODES", "", "", "DEFAULT_HEADERS", "", "", "getDEFAULT_HEADERS", "()Ljava/util/Map;", "listConversationsRawCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/ListConversationsResponse;", "pageSize", "", "pageIndex", "orderBy", "sort", "pinnedTop", "", "hasNoParentConversation", "hasTasks", "hiddenStatus", "parentConversationIds", "", "(IILjava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchRawCall", "Lcom/bytedance/trae/im/service/SearchConversationsResponse;", "keyword", "startTime", "endTime", "(Ljava/lang/String;IIJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<Long> SUCCESS_CODES = SetsKt.setOf(200L);

        private Companion() {
        }

        private final Map<String, String> getDEFAULT_HEADERS() {
            return DebugSettings.buildDefaultHeaders$default(DebugSettings.INSTANCE, (Map) null, 1, (Object) null);
        }

        public final Object listConversationsRawCall(final int i, final int i2, final String str, final String str2, final boolean z, final Integer num, final Integer num2, final String str3, final List<String> list, Continuation<? super HttpDataResult<ListConversationsResponse>> continuation) {
            return TraeHttpConnection.rawBizCall$default(TraeHttpConnection.INSTANCE, "base", IListConversationsService.class, ListConversationsResponse.class, (String) null, (String) null, getDEFAULT_HEADERS(), true, SUCCESS_CODES, true, new Function2() { // from class: com.bytedance.trae.im.service.IListConversationsService$Companion$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Call listConversationsRawCall$lambda$0;
                    listConversationsRawCall$lambda$0 = IListConversationsService.Companion.listConversationsRawCall$lambda$0(i, i2, str, str2, z, num, num2, str3, list, (IListConversationsService) obj, (RequestContext) obj2);
                    return listConversationsRawCall$lambda$0;
                }
            }, continuation, 24, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call listConversationsRawCall$lambda$0(int i, int i2, String str, String str2, boolean z, Integer num, Integer num2, String str3, List list, IListConversationsService iListConversationsService, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iListConversationsService, "$this$rawBizCall");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iListConversationsService.listConversationsRaw(i, i2, str, str2, z, num, num2, str3, list, requestContext);
        }

        public final Object searchRawCall(final String str, final int i, final int i2, final long j, final long j2, Continuation<? super HttpDataResult<SearchConversationsResponse>> continuation) {
            return TraeHttpConnection.rawBizCall$default(TraeHttpConnection.INSTANCE, "base", IListConversationsService.class, SearchConversationsResponse.class, (String) null, (String) null, getDEFAULT_HEADERS(), true, SUCCESS_CODES, true, new Function2() { // from class: com.bytedance.trae.im.service.IListConversationsService$Companion$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Call searchRawCall$lambda$1;
                    searchRawCall$lambda$1 = IListConversationsService.Companion.searchRawCall$lambda$1(str, i, i2, j, j2, (IListConversationsService) obj, (RequestContext) obj2);
                    return searchRawCall$lambda$1;
                }
            }, continuation, 24, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call searchRawCall$lambda$1(String str, int i, int i2, long j, long j2, IListConversationsService iListConversationsService, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iListConversationsService, "$this$rawBizCall");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iListConversationsService.searchConversationsRaw(str, i, i2, j, j2, requestContext);
        }
    }
}
