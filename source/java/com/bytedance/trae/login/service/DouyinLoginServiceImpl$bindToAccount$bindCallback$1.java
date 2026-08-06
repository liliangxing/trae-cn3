package com.bytedance.trae.login.service;

import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.login.C0820R;
import com.ss.android.account.UserBindCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DouyinLoginServiceImpl.kt */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J.\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$bindCallback$1", "Lcom/ss/android/account/UserBindCallback;", "onBindSuccess", "", "response", "Lcom/bytedance/sdk/account/api/call/UserApiResponse;", "onBindExist", "errorTip", "", "confirmTop", "authToken", "onBindError", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DouyinLoginServiceImpl$bindToAccount$bindCallback$1 extends UserBindCallback {
    final /* synthetic */ Function2<Integer, String, Unit> $onFail;
    final /* synthetic */ Function0<Unit> $onSuccess;
    final /* synthetic */ DouyinLoginServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public DouyinLoginServiceImpl$bindToAccount$bindCallback$1(DouyinLoginServiceImpl douyinLoginServiceImpl, Function0<Unit> function0, Function2<? super Integer, ? super String, Unit> function2) {
        this.this$0 = douyinLoginServiceImpl;
        this.$onSuccess = function0;
        this.$onFail = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindSuccess$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public void onBindSuccess(UserApiResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        DouyinLoginServiceImpl douyinLoginServiceImpl = this.this$0;
        final Function0<Unit> function0 = this.$onSuccess;
        douyinLoginServiceImpl.postToMain(new Function0() { // from class: com.bytedance.trae.login.service.DouyinLoginServiceImpl$bindToAccount$bindCallback$1$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit onBindSuccess$lambda$0;
                onBindSuccess$lambda$0 = DouyinLoginServiceImpl$bindToAccount$bindCallback$1.onBindSuccess$lambda$0(function0);
                return onBindSuccess$lambda$0;
            }
        });
    }

    public void onBindExist(UserApiResponse response, final String errorTip, String confirmTop, String authToken) {
        Intrinsics.checkNotNullParameter(response, "response");
        DouyinLoginServiceImpl douyinLoginServiceImpl = this.this$0;
        final Function2<Integer, String, Unit> function2 = this.$onFail;
        douyinLoginServiceImpl.postToMain(new Function0() { // from class: com.bytedance.trae.login.service.DouyinLoginServiceImpl$bindToAccount$bindCallback$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit onBindExist$lambda$1;
                onBindExist$lambda$1 = DouyinLoginServiceImpl$bindToAccount$bindCallback$1.onBindExist$lambda$1(function2, errorTip);
                return onBindExist$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindExist$lambda$1(Function2 function2, String str) {
        if (str == null) {
            str = AppHost.Companion.getApplication().getString(C0820R.string.trae_douyin_already_bound_other);
            Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
        }
        function2.invoke(1030, str);
        return Unit.INSTANCE;
    }

    public void onBindError(final UserApiResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        DouyinLoginServiceImpl douyinLoginServiceImpl = this.this$0;
        final Function2<Integer, String, Unit> function2 = this.$onFail;
        douyinLoginServiceImpl.postToMain(new Function0() { // from class: com.bytedance.trae.login.service.DouyinLoginServiceImpl$bindToAccount$bindCallback$1$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit onBindError$lambda$2;
                onBindError$lambda$2 = DouyinLoginServiceImpl$bindToAccount$bindCallback$1.onBindError$lambda$2(function2, response);
                return onBindError$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindError$lambda$2(Function2 function2, UserApiResponse userApiResponse) {
        Integer valueOf = Integer.valueOf(userApiResponse.error);
        String str = userApiResponse.errorMsg;
        if (str == null) {
            str = AppHost.Companion.getApplication().getString(C0820R.string.trae_douyin_bind_account_failed);
            Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
        }
        function2.invoke(valueOf, str);
        return Unit.INSTANCE;
    }
}
