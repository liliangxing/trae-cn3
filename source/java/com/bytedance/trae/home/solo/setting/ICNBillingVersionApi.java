package com.bytedance.trae.home.solo.setting;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.home.solo.setting.ICNBillingVersionApi;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.ttnet.http.RequestContext;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CNBillingVersionApi.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ&\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0001H'¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi;", "", "switchCnBillingVersionRaw", "Lcom/bytedance/retrofit2/Call;", "", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/home/solo/setting/SwitchCnBillingVersionRequest;", "extraInfo", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface ICNBillingVersionApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST("trae/api/v2/pay/switch_cn_billing_version")
    Call<String> switchCnBillingVersionRaw(@Body SwitchCnBillingVersionRequest request, @ExtraInfo Object extraInfo);

    /* compiled from: CNBillingVersionApi.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0086@¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi$Companion;", "", "<init>", "()V", "PATH", "", "SUCCESS_CODES", "", "", "switchCnBillingVersionRawCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ANDROID_REQUEST_SOURCE", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        private static final int ANDROID_REQUEST_SOURCE = 5;
        private static final String PATH = "/trae/api/v2/pay/switch_cn_billing_version";
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<Long> SUCCESS_CODES = BizResponse.Companion.getDEFAULT_SUCCESS_CODES();

        private Companion() {
        }

        public final Object switchCnBillingVersionRawCall(Continuation<? super HttpDataResult<Unit>> continuation) {
            final SwitchCnBillingVersionRequest switchCnBillingVersionRequest = new SwitchCnBillingVersionRequest(5, AppHost.INSTANCE.getVersionName());
            return TraeHttpConnection.rawBizCall$default(TraeHttpConnection.INSTANCE, "switch_cn_billing_version", ICNBillingVersionApi.class, PATH, HostResolver.INSTANCE.getBaseUrl(HostType.LOGIN), (Map) null, false, SUCCESS_CODES, true, true, new Function2() { // from class: com.bytedance.trae.home.solo.setting.ICNBillingVersionApi$Companion$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    BizResponse switchCnBillingVersionRawCall$lambda$0;
                    switchCnBillingVersionRawCall$lambda$0 = ICNBillingVersionApi.Companion.switchCnBillingVersionRawCall$lambda$0((String) obj, (SsResponse) obj2);
                    return switchCnBillingVersionRawCall$lambda$0;
                }
            }, new Function2() { // from class: com.bytedance.trae.home.solo.setting.ICNBillingVersionApi$Companion$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Call switchCnBillingVersionRawCall$lambda$1;
                    switchCnBillingVersionRawCall$lambda$1 = ICNBillingVersionApi.Companion.switchCnBillingVersionRawCall$lambda$1(SwitchCnBillingVersionRequest.this, (ICNBillingVersionApi) obj, (RequestContext) obj2);
                    return switchCnBillingVersionRawCall$lambda$1;
                }
            }, continuation, 48, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BizResponse switchCnBillingVersionRawCall$lambda$0(String str, SsResponse ssResponse) {
            Intrinsics.checkNotNullParameter(str, "body");
            Intrinsics.checkNotNullParameter(ssResponse, "<unused var>");
            return CNCommercialApiParser.INSTANCE.parseBillingSwitch(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call switchCnBillingVersionRawCall$lambda$1(SwitchCnBillingVersionRequest switchCnBillingVersionRequest, ICNBillingVersionApi iCNBillingVersionApi, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iCNBillingVersionApi, "$this$rawBizCall");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iCNBillingVersionApi.switchCnBillingVersionRaw(switchCnBillingVersionRequest, requestContext);
        }
    }
}
