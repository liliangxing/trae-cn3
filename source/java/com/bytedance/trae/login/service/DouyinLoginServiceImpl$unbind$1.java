package com.bytedance.trae.login.service;

import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DouyinLoginServiceImpl.kt */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/bytedance/trae/login/service/DouyinLoginServiceImpl$unbind$1", "Lcom/bytedance/sdk/account/api/call/AbsApiCall;", "Lcom/bytedance/sdk/account/api/call/BaseApiResponse;", "onResponse", "", "response", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DouyinLoginServiceImpl$unbind$1 extends AbsApiCall<BaseApiResponse> {
    final /* synthetic */ Function2<Integer, String, Unit> $onFail;
    final /* synthetic */ Function0<Unit> $onSuccess;
    final /* synthetic */ DouyinLoginServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public DouyinLoginServiceImpl$unbind$1(DouyinLoginServiceImpl douyinLoginServiceImpl, Function0<Unit> function0, Function2<? super Integer, ? super String, Unit> function2) {
        this.this$0 = douyinLoginServiceImpl;
        this.$onSuccess = function0;
        this.$onFail = function2;
    }

    public void onResponse(final BaseApiResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.success) {
            DouyinLoginServiceImpl douyinLoginServiceImpl = this.this$0;
            final Function0<Unit> function0 = this.$onSuccess;
            douyinLoginServiceImpl.postToMain(new Function0() { // from class: com.bytedance.trae.login.service.DouyinLoginServiceImpl$unbind$1$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit onResponse$lambda$0;
                    onResponse$lambda$0 = DouyinLoginServiceImpl$unbind$1.onResponse$lambda$0(function0);
                    return onResponse$lambda$0;
                }
            });
        } else {
            DouyinLoginServiceImpl douyinLoginServiceImpl2 = this.this$0;
            final Function2<Integer, String, Unit> function2 = this.$onFail;
            douyinLoginServiceImpl2.postToMain(new Function0() { // from class: com.bytedance.trae.login.service.DouyinLoginServiceImpl$unbind$1$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit onResponse$lambda$1;
                    onResponse$lambda$1 = DouyinLoginServiceImpl$unbind$1.onResponse$lambda$1(function2, response);
                    return onResponse$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResponse$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResponse$lambda$1(Function2 function2, BaseApiResponse baseApiResponse) {
        function2.invoke(Integer.valueOf(baseApiResponse.error), baseApiResponse.errorMsg);
        return Unit.INSTANCE;
    }
}
