package com.bytedance.trae.home.solo.setting;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.home.solo.setting.ICNUserPayStatusApi;
import com.bytedance.trae.home.solo.sitemessage.SiteMessageParams;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.ttnet.http.RequestContext;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CNUserPagStatusApi.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ&\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0001H'¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/ICNUserPayStatusApi;", "", "getUserPayStatusRaw", "Lcom/bytedance/retrofit2/Call;", "", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/home/solo/setting/GetIdeUserPayStatusRequest;", "extraInfo", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface ICNUserPayStatusApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST("trae/api/v2/pay/ide_user_pay_status")
    Call<String> getUserPayStatusRaw(@Body GetIdeUserPayStatusRequest request, @ExtraInfo Object extraInfo);

    /* compiled from: CNUserPagStatusApi.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0086@¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/ICNUserPayStatusApi$Companion;", "", "<init>", "()V", "PATH", "", "SUCCESS_CODES", "", "", "fetchPayStatusRawCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        private static final String PATH = "/trae/api/v2/pay/ide_user_pay_status";
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<Long> SUCCESS_CODES = BizResponse.Companion.getDEFAULT_SUCCESS_CODES();

        private Companion() {
        }

        public final Object fetchPayStatusRawCall(Continuation<? super HttpDataResult<CNUserPayStatusData>> continuation) {
            final GetIdeUserPayStatusRequest getIdeUserPayStatusRequest = new GetIdeUserPayStatusRequest(SiteMessageParams.platform, IApplog.INSTANCE.getDeviceId());
            return TraeHttpConnection.rawBizCall$default(TraeHttpConnection.INSTANCE, "user_pay_status", ICNUserPayStatusApi.class, PATH, HostResolver.INSTANCE.getBaseUrl(HostType.LOGIN), (Map) null, false, SUCCESS_CODES, false, false, new Function2() { // from class: com.bytedance.trae.home.solo.setting.ICNUserPayStatusApi$Companion$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    BizResponse fetchPayStatusRawCall$lambda$0;
                    fetchPayStatusRawCall$lambda$0 = ICNUserPayStatusApi.Companion.fetchPayStatusRawCall$lambda$0((String) obj, (SsResponse) obj2);
                    return fetchPayStatusRawCall$lambda$0;
                }
            }, new Function2() { // from class: com.bytedance.trae.home.solo.setting.ICNUserPayStatusApi$Companion$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Call fetchPayStatusRawCall$lambda$1;
                    fetchPayStatusRawCall$lambda$1 = ICNUserPayStatusApi.Companion.fetchPayStatusRawCall$lambda$1(GetIdeUserPayStatusRequest.this, (ICNUserPayStatusApi) obj, (RequestContext) obj2);
                    return fetchPayStatusRawCall$lambda$1;
                }
            }, continuation, 432, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BizResponse fetchPayStatusRawCall$lambda$0(String str, SsResponse ssResponse) {
            Intrinsics.checkNotNullParameter(str, "body");
            Intrinsics.checkNotNullParameter(ssResponse, "<unused var>");
            return CNCommercialApiParser.INSTANCE.parsePayStatus(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call fetchPayStatusRawCall$lambda$1(GetIdeUserPayStatusRequest getIdeUserPayStatusRequest, ICNUserPayStatusApi iCNUserPayStatusApi, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iCNUserPayStatusApi, "$this$rawBizCall");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iCNUserPayStatusApi.getUserPayStatusRaw(getIdeUserPayStatusRequest, requestContext);
        }
    }
}
