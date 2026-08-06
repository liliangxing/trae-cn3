package com.bytedance.trae.login.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginServiceImpl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.service.LoginServiceImpl", f = "LoginServiceImpl.kt", i = {0, 0}, l = {452}, m = "refreshBytecloudUserInfo", n = {"onSuccess", "onFail"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LoginServiceImpl$refreshBytecloudUserInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginServiceImpl$refreshBytecloudUserInfo$1(LoginServiceImpl loginServiceImpl, Continuation<? super LoginServiceImpl$refreshBytecloudUserInfo$1> continuation) {
        super(continuation);
        this.this$0 = loginServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        Object refreshBytecloudUserInfo;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        refreshBytecloudUserInfo = this.this$0.refreshBytecloudUserInfo(null, null, null, (Continuation) this);
        return refreshBytecloudUserInfo;
    }
}
