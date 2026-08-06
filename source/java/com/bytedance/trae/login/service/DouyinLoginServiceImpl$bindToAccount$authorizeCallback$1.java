package com.bytedance.trae.login.service;

import android.os.Bundle;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.sdk.account.impl.BDAccountPlatformImpl;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.login.C0820R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DouyinLoginServiceImpl.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/bytedance/trae/login/service/DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1", "Lcom/bytedance/sdk/account/platform/base/AuthorizeCallback;", "onSuccess", "", SchemaConstants.QUERY_KEY_BUNDLE, "Landroid/os/Bundle;", "onError", "msg", "Lcom/bytedance/sdk/account/platform/base/AuthorizeErrorResponse;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1 implements AuthorizeCallback {
    final /* synthetic */ DouyinLoginServiceImpl$bindToAccount$bindCallback$1 $bindCallback;
    final /* synthetic */ Function2<Integer, String, Unit> $onFail;
    final /* synthetic */ DouyinLoginServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1(DouyinLoginServiceImpl$bindToAccount$bindCallback$1 douyinLoginServiceImpl$bindToAccount$bindCallback$1, DouyinLoginServiceImpl douyinLoginServiceImpl, Function2<? super Integer, ? super String, Unit> function2) {
        this.$bindCallback = douyinLoginServiceImpl$bindToAccount$bindCallback$1;
        this.this$0 = douyinLoginServiceImpl;
        this.$onFail = function2;
    }

    public void onSuccess(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, SchemaConstants.QUERY_KEY_BUNDLE);
        String string = bundle.getString("auth_code");
        String str = string;
        if (!(str == null || str.length() == 0)) {
            BDAccountPlatformImpl.instance().ssoWithAuthCodeBind("23081", "aweme_v2", string, 0L, (Map) null, this.$bindCallback);
            return;
        }
        DouyinLoginServiceImpl douyinLoginServiceImpl = this.this$0;
        final Function2<Integer, String, Unit> function2 = this.$onFail;
        douyinLoginServiceImpl.postToMain(new Function0() { // from class: com.bytedance.trae.login.service.DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit onSuccess$lambda$0;
                onSuccess$lambda$0 = DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1.onSuccess$lambda$0(function2);
                return onSuccess$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSuccess$lambda$0(Function2 function2) {
        function2.invoke(-1, AppHost.Companion.getApplication().getString(C0820R.string.trae_douyin_get_auth_code_failed));
        return Unit.INSTANCE;
    }

    public void onError(final AuthorizeErrorResponse msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        DouyinLoginServiceImpl douyinLoginServiceImpl = this.this$0;
        final Function2<Integer, String, Unit> function2 = this.$onFail;
        douyinLoginServiceImpl.postToMain(new Function0() { // from class: com.bytedance.trae.login.service.DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit onError$lambda$1;
                onError$lambda$1 = DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1.onError$lambda$1(function2, msg);
                return onError$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onError$lambda$1(Function2 function2, AuthorizeErrorResponse authorizeErrorResponse) {
        Integer intOrNull;
        String str = authorizeErrorResponse.platformErrorCode;
        Integer valueOf = Integer.valueOf((str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? -1 : intOrNull.intValue());
        String str2 = authorizeErrorResponse.platformErrorMsg;
        if (str2 == null) {
            str2 = AppHost.Companion.getApplication().getString(C0820R.string.trae_douyin_authorize_failed);
            Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
        }
        function2.invoke(valueOf, str2);
        return Unit.INSTANCE;
    }
}
