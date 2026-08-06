package com.bytedance.trae.login.bytecloud;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import com.bytedance.trae.login.api.AccountStatus;
import com.bytedance.trae.login.bytecloud.BytecloudPassportLogin;
import com.bytedance.trae.login.bytecloud.CallbackResult;
import com.bytedance.trae.login.service.AccountStatusManager;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.login.traeauth.TraeAuthStorage;
import com.bytedance.trae.multilanguage.C0882R;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BytecloudLoginActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.bytecloud.BytecloudLoginActivity$handleIntent$1", f = "BytecloudLoginActivity.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BytecloudLoginActivity$handleIntent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $callbackStartTime;
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ BytecloudLoginActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BytecloudLoginActivity$handleIntent$1(Uri uri, long j, BytecloudLoginActivity bytecloudLoginActivity, Continuation<? super BytecloudLoginActivity$handleIntent$1> continuation) {
        super(2, continuation);
        this.$uri = uri;
        this.$callbackStartTime = j;
        this.this$0 = bytecloudLoginActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BytecloudLoginActivity$handleIntent$1(this.$uri, this.$callbackStartTime, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        Object handleCallback;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            handleCallback = BytecloudAuthManager.INSTANCE.handleCallback(this.$uri, (Continuation) this);
            if (handleCallback == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            handleCallback = obj;
        }
        CallbackResult callbackResult = (CallbackResult) handleCallback;
        long currentTimeMillis = System.currentTimeMillis() - this.$callbackStartTime;
        if (callbackResult instanceof CallbackResult.Success) {
            FLogger.INSTANCE.mo428i("BytecloudLoginActivity", "ByteCloud 回调校验通过，先完成主登录，再异步补齐 Passport 身份");
            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_SUCCESS, "bytecloud", Boxing.boxLong(currentTimeMillis), null, null, null, null, null, null, null, null, 2040, null);
            AccountStatusManager.INSTANCE.loginStatusChanged(AccountStatus.LOGGED_IN, "bytecloud_login");
            String jwtToken = TraeAuthStorage.INSTANCE.getJwtToken();
            final long currentTimeMillis2 = System.currentTimeMillis();
            BytecloudPassportLogin.INSTANCE.login(jwtToken, new BytecloudPassportLogin.Callback() { // from class: com.bytedance.trae.login.bytecloud.BytecloudLoginActivity$handleIntent$1.1
                @Override // com.bytedance.trae.login.bytecloud.BytecloudPassportLogin.Callback
                public void onSuccess(long userId) {
                    FLogger.INSTANCE.mo428i("BytecloudLoginActivity", "Passport 三方登录成功, userId=" + userId);
                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_BYTECLOUD_PASSPORT_DONE, "bytecloud", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), null, null, null, null, null, null, null, null, 2040, null);
                }

                @Override // com.bytedance.trae.login.bytecloud.BytecloudPassportLogin.Callback
                public void onError(int errorCode, String errorMessage) {
                    String str = errorMessage;
                    FLogger.INSTANCE.mo426e("BytecloudLoginActivity", "Passport 三方登录失败(降级): code=" + errorCode + ", msg=" + str);
                    TraeAuthManager traeAuthManager = TraeAuthManager.INSTANCE;
                    Long valueOf = Long.valueOf(System.currentTimeMillis() - currentTimeMillis2);
                    if (str == null) {
                        str = "unknown";
                    }
                    TraeAuthManager.reportLoginFunnel$default(traeAuthManager, TraeAuthManager.STAGE_BYTECLOUD_PASSPORT_FAIL, "bytecloud", valueOf, "passport_async_login", null, str, null, null, null, null, null, 2000, null);
                }
            });
            this.this$0.navigateToMainActivity();
        } else {
            if (!(callbackResult instanceof CallbackResult.Rejected)) {
                throw new NoWhenBranchMatchedException();
            }
            CallbackResult.Rejected rejected = (CallbackResult.Rejected) callbackResult;
            FLogger.INSTANCE.mo426e("BytecloudLoginActivity", "ByteCloud 回调被拒绝: " + rejected.getReason());
            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_PASSPORT_FAIL, "bytecloud", Boxing.boxLong(currentTimeMillis), "callback_security_check", null, rejected.getReason(), null, null, null, null, null, 2000, null);
            BytecloudLoginActivity bytecloudLoginActivity = this.this$0;
            Toast.makeText((Context) bytecloudLoginActivity, bytecloudLoginActivity.getString(C0882R.string.trae_login_error_failed), 0).show();
            this.this$0.finish();
        }
        return Unit.INSTANCE;
    }
}
