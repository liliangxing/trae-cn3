package com.bytedance.trae.login.service;

import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.bytecloud.BytecloudAuthManager;
import com.bytedance.trae.login.enterprise.EnterpriseProfileRefresher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LoginServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.service.LoginServiceImpl$refreshUserInfo$1", f = "LoginServiceImpl.kt", i = {}, l = {359, 361, 363}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class LoginServiceImpl$refreshUserInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $jwtToken;
    final /* synthetic */ Function0<Unit> $onFail;
    final /* synthetic */ Function1<AccountInfo, Unit> $onSuccess;
    int label;
    final /* synthetic */ LoginServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LoginServiceImpl$refreshUserInfo$1(LoginServiceImpl loginServiceImpl, String str, Function1<? super AccountInfo, Unit> function1, Function0<Unit> function0, Continuation<? super LoginServiceImpl$refreshUserInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = loginServiceImpl;
        this.$jwtToken = str;
        this.$onSuccess = function1;
        this.$onFail = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginServiceImpl$refreshUserInfo$1(this.this$0, this.$jwtToken, this.$onSuccess, this.$onFail, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x006e -> B:11:0x0073). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0070 -> B:11:0x0073). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object obj) {
        Object refreshPublicUserInfo;
        Object refreshEnterpriseUserInfo;
        Object refreshBytecloudUserInfo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (BytecloudAuthManager.INSTANCE.isBytecloudLogin()) {
                    this.label = 1;
                    refreshBytecloudUserInfo = this.this$0.refreshBytecloudUserInfo(this.$jwtToken, this.$onSuccess, this.$onFail, (Continuation) this);
                    if (refreshBytecloudUserInfo == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (EnterpriseProfileRefresher.INSTANCE.isEnterpriseLogin()) {
                    this.label = 2;
                    refreshEnterpriseUserInfo = this.this$0.refreshEnterpriseUserInfo(this.$jwtToken, this.$onSuccess, this.$onFail, (Continuation) this);
                    if (refreshEnterpriseUserInfo == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    this.label = 3;
                    refreshPublicUserInfo = this.this$0.refreshPublicUserInfo(this.$jwtToken, this.$onSuccess, this.$onFail, (Continuation) this);
                    if (refreshPublicUserInfo == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1 && i != 2 && i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception unused) {
            Function0<Unit> function0 = this.$onFail;
            if (function0 != null) {
                function0.invoke();
            }
        }
        return Unit.INSTANCE;
    }
}
