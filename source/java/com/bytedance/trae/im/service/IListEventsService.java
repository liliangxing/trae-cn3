package com.bytedance.trae.im.service;

import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* compiled from: IListEventsService.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ@\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\n\u001a\u00020\bH§@¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/im/service/IListEventsService;", "", "listEvents", "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/ListEventsResponse;", "taskId", "", "toSeqNum", "", "fromSeqNum", "maxLength", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IListEventsService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @GET("api/solo_hub/v1/conversations/events")
    Object listEvents(@Query("task_id") String str, @Query("to_seq_num") Integer num, @Query("from_seq_num") Integer num2, @MaxLength int i, Continuation<? super BizResponse<ListEventsResponse>> continuation);

    /* compiled from: IListEventsService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object listEvents$default(IListEventsService iListEventsService, String str, Integer num, Integer num2, int i, Continuation continuation, int i2, Object obj) {
            if (obj == null) {
                return iListEventsService.listEvents(str, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : num2, i, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listEvents");
        }
    }

    /* compiled from: IListEventsService.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\u000b2/\u0010\f\u001a+\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r¢\u0006\u0002\b\u0011H\u0086@¢\u0006\u0002\u0010\u0012R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/im/service/IListEventsService$Companion;", "", "<init>", "()V", "DEFAULT_HEADERS", "", "", "getDEFAULT_HEADERS", "()Ljava/util/Map;", "safeCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "T", "call", "Lkotlin/Function2;", "Lcom/bytedance/trae/im/service/IListEventsService;", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/trae/network/response/BizResponse;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        private final Map<String, String> getDEFAULT_HEADERS() {
            return DebugSettings.buildDefaultHeaders$default(DebugSettings.INSTANCE, (Map) null, 1, (Object) null);
        }

        public final <T> Object safeCall(Function2<? super IListEventsService, ? super Continuation<? super BizResponse<T>>, ? extends Object> function2, Continuation<? super HttpDataResult<? extends T>> continuation) {
            return TraeHttpConnection.safeCall$default(TraeHttpConnection.INSTANCE, "base", IListEventsService.class, getDEFAULT_HEADERS(), function2, (String) null, (Set) null, continuation, 48, (Object) null);
        }
    }
}
