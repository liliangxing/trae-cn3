package com.bytedance.trae.login.region;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UserRegionManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.region.UserRegionManager", f = "UserRegionManager.kt", i = {0}, l = {92}, m = "doFetchUserRegion", n = {"this"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UserRegionManager$doFetchUserRegion$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserRegionManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserRegionManager$doFetchUserRegion$1(UserRegionManager userRegionManager, Continuation<? super UserRegionManager$doFetchUserRegion$1> continuation) {
        super(continuation);
        this.this$0 = userRegionManager;
    }

    public final Object invokeSuspend(Object obj) {
        Object doFetchUserRegion;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        doFetchUserRegion = this.this$0.doFetchUserRegion(null, (Continuation) this);
        return doFetchUserRegion;
    }
}
