package com.bytedance.trae.login.enterprise;

import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.multilanguage.C0882R;
import com.bytedance.trae.utils.logger.FLogger;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EnterpriseLoginActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.enterprise.EnterpriseLoginActivity$performCheckLoginConfig$1", f = "EnterpriseLoginActivity.kt", i = {}, l = {202}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class EnterpriseLoginActivity$performCheckLoginConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $email;
    int label;
    final /* synthetic */ EnterpriseLoginActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterpriseLoginActivity$performCheckLoginConfig$1(EnterpriseLoginActivity enterpriseLoginActivity, String str, Continuation<? super EnterpriseLoginActivity$performCheckLoginConfig$1> continuation) {
        super(2, continuation);
        this.this$0 = enterpriseLoginActivity;
        this.$email = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EnterpriseLoginActivity$performCheckLoginConfig$1(this.this$0, this.$email, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String string;
        Object withContext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                withContext = BuildersKt.withContext(Dispatchers.getIO(), new EnterpriseLoginActivity$performCheckLoginConfig$1$result$1(this.$email, null), (Continuation) this);
                if (withContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                withContext = obj;
            }
            this.this$0.handleCheckLoginConfigResult(this.$email, (CheckLoginConfigResult) withContext);
        } catch (EnterpriseAuthException e) {
            FLogger.INSTANCE.mo426e("EnterpriseLoginActivity", "checkLoginConfig failed: " + e.getMessage());
            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_ENTERPRISE_CHECK_CONFIG_FAIL, "enterprise", null, null, null, e.getMessage(), null, null, null, null, null, 2012, null);
            this.this$0.setEmailStepLoading(false);
            EnterpriseLoginActivity enterpriseLoginActivity = this.this$0;
            String userMessage = e.getUserMessage();
            if (userMessage == null) {
                userMessage = "";
            }
            enterpriseLoginActivity.showEmailError(userMessage);
        } catch (Exception e2) {
            FLogger.INSTANCE.mo426e("EnterpriseLoginActivity", "checkLoginConfig unexpected error: " + e2.getMessage());
            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_ENTERPRISE_CHECK_CONFIG_FAIL, "enterprise", null, null, null, e2.getMessage(), null, null, null, null, null, 2012, null);
            this.this$0.setEmailStepLoading(false);
            EnterpriseLoginActivity enterpriseLoginActivity2 = this.this$0;
            if (e2 instanceof IOException) {
                string = enterpriseLoginActivity2.getString(C0882R.string.trae_enterprise_error_network);
            } else {
                string = enterpriseLoginActivity2.getString(C0882R.string.trae_enterprise_error_service);
            }
            Intrinsics.checkNotNull(string);
            enterpriseLoginActivity2.showEmailError(string);
        }
        return Unit.INSTANCE;
    }
}
