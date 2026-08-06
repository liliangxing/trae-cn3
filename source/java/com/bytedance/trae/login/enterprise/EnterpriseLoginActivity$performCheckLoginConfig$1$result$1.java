package com.bytedance.trae.login.enterprise;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: EnterpriseLoginActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.enterprise.EnterpriseLoginActivity$performCheckLoginConfig$1$result$1", f = "EnterpriseLoginActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class EnterpriseLoginActivity$performCheckLoginConfig$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CheckLoginConfigResult>, Object> {
    final /* synthetic */ String $email;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterpriseLoginActivity$performCheckLoginConfig$1$result$1(String str, Continuation<? super EnterpriseLoginActivity$performCheckLoginConfig$1$result$1> continuation) {
        super(2, continuation);
        this.$email = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EnterpriseLoginActivity$performCheckLoginConfig$1$result$1(this.$email, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CheckLoginConfigResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return EnterpriseAuthManager.INSTANCE.checkLoginConfig(this.$email);
    }
}
