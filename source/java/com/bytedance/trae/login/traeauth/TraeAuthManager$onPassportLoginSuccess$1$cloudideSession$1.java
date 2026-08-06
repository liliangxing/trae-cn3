package com.bytedance.trae.login.traeauth;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: TraeAuthManager.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.traeauth.TraeAuthManager$onPassportLoginSuccess$1$cloudideSession$1", f = "TraeAuthManager.kt", i = {}, l = {386}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class TraeAuthManager$onPassportLoginSuccess$1$cloudideSession$1 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ String $loginPlatform;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TraeAuthManager$onPassportLoginSuccess$1$cloudideSession$1(String str, Continuation<? super TraeAuthManager$onPassportLoginSuccess$1$cloudideSession$1> continuation) {
        super(1, continuation);
        this.$loginPlatform = str;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TraeAuthManager$onPassportLoginSuccess$1$cloudideSession$1(this.$loginPlatform, continuation);
    }

    public final Object invoke(Continuation<? super String> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String loginType;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TraeAuthManager traeAuthManager = TraeAuthManager.INSTANCE;
            loginType = TraeAuthManager.INSTANCE.toLoginType(this.$loginPlatform);
            this.label = 1;
            obj = traeAuthManager.doLoginOrThrow(loginType, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
