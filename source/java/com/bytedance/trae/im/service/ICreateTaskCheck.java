package com.bytedance.trae.im.service;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.trae.im.service.ICreateTaskCheck;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.bytedance.ttnet.http.RequestContext;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICreateTaskCheck.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ&\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0001H'¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/im/service/ICreateTaskCheck;", "", "createTaskCheckRaw", "Lcom/bytedance/retrofit2/Call;", "", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/CreateTaskCheckRequest;", "extraInfo", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface ICreateTaskCheck {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST("api/solo_hub/v1/conversations/tasks/create_check")
    Call<String> createTaskCheckRaw(@Body CreateTaskCheckRequest request, @ExtraInfo Object extraInfo);

    /* compiled from: ICreateTaskCheck.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/im/service/ICreateTaskCheck$Companion;", "", "<init>", "()V", "DEFAULT_HEADERS", "", "", "getDEFAULT_HEADERS", "()Ljava/util/Map;", "SUCCESS_CODES", "", "", "TAG", "createTaskCheckRawCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/CreateTaskCheckResponse;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/CreateTaskCheckRequest;", "(Lcom/bytedance/trae/im/service/CreateTaskCheckRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<Long> SUCCESS_CODES = SetsKt.setOf(200L);
        private static final String TAG = "ICreateTaskCheck";

        private Companion() {
        }

        private final Map<String, String> getDEFAULT_HEADERS() {
            return DebugSettings.buildDefaultHeaders$default(DebugSettings.INSTANCE, (Map) null, 1, (Object) null);
        }

        public final Object createTaskCheckRawCall(final CreateTaskCheckRequest createTaskCheckRequest, Continuation<? super HttpDataResult<CreateTaskCheckResponse>> continuation) {
            TraeLogUtil.INSTANCE.d(TAG, "POST /api/solo_hub/v1/conversations/tasks/create_check rawCall: conversationId=" + createTaskCheckRequest.getConversationId());
            return TraeHttpConnection.rawBizCall$default(TraeHttpConnection.INSTANCE, "base", ICreateTaskCheck.class, CreateTaskCheckResponse.class, (String) null, (String) null, getDEFAULT_HEADERS(), true, SUCCESS_CODES, false, new Function2() { // from class: com.bytedance.trae.im.service.ICreateTaskCheck$Companion$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Call createTaskCheckRawCall$lambda$0;
                    createTaskCheckRawCall$lambda$0 = ICreateTaskCheck.Companion.createTaskCheckRawCall$lambda$0(CreateTaskCheckRequest.this, (ICreateTaskCheck) obj, (RequestContext) obj2);
                    return createTaskCheckRawCall$lambda$0;
                }
            }, continuation, 280, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call createTaskCheckRawCall$lambda$0(CreateTaskCheckRequest createTaskCheckRequest, ICreateTaskCheck iCreateTaskCheck, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iCreateTaskCheck, "$this$rawBizCall");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iCreateTaskCheck.createTaskCheckRaw(createTaskCheckRequest, requestContext);
        }
    }
}
