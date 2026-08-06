package com.bytedance.trae.login.service;

import com.bytedance.trae.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.service.LoginServiceImpl$updateUserProfileOversea$3", f = "LoginServiceImpl.kt", i = {}, l = {324}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LoginServiceImpl$updateUserProfileOversea$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $apiParams;
    final /* synthetic */ Function1<Integer, Unit> $onFail;
    final /* synthetic */ Function0<Unit> $onSuccess;
    final /* synthetic */ Map<String, String> $params;
    int label;
    final /* synthetic */ LoginServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LoginServiceImpl$updateUserProfileOversea$3(Map<String, String> map, LoginServiceImpl loginServiceImpl, Map<String, String> map2, Function0<Unit> function0, Function1<? super Integer, Unit> function1, Continuation<? super LoginServiceImpl$updateUserProfileOversea$3> continuation) {
        super(2, continuation);
        this.$apiParams = map;
        this.this$0 = loginServiceImpl;
        this.$params = map2;
        this.$onSuccess = function0;
        this.$onFail = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginServiceImpl$updateUserProfileOversea$3(this.$apiParams, this.this$0, this.$params, this.$onSuccess, this.$onFail, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = IOverseaProfileApi.INSTANCE.create().updateUserInfo(this.$apiParams, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            OverseaUpdateProfileResponse overseaUpdateProfileResponse = (OverseaUpdateProfileResponse) obj;
            if (overseaUpdateProfileResponse.getErrorCode() == 0) {
                this.this$0.syncLocalUserInfo(this.$params);
                this.$onSuccess.invoke();
            } else {
                this.$onFail.invoke(Boxing.boxInt(overseaUpdateProfileResponse.getErrorCode()));
            }
        } catch (Exception e) {
            FLogger.INSTANCE.mo426e("LoginServiceImpl", "updateUserProfileOversea exception: " + e.getMessage());
            this.$onFail.invoke(Boxing.boxInt(-1));
        }
        return Unit.INSTANCE;
    }
}
