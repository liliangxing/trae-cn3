package com.bytedance.trae.home;

import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.network.CustomActivityRepository;
import com.bytedance.trae.conversation.network.ThirdPartyTokenRepository;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.login.api.AccountInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.MainActivity$fetchStarbucksIfLoggedIn$1", f = "MainActivity.kt", i = {}, l = {327}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class MainActivity$fetchStarbucksIfLoggedIn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AccountInfo $accountInfo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$fetchStarbucksIfLoggedIn$1(AccountInfo accountInfo, Continuation<? super MainActivity$fetchStarbucksIfLoggedIn$1> continuation) {
        super(2, continuation);
        this.$accountInfo = accountInfo;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$fetchStarbucksIfLoggedIn$1(this.$accountInfo, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!AppHost.INSTANCE.isOversea() && !Intrinsics.areEqual(this.$accountInfo.getLoginPlatform(), ThirdPartyTokenRepository.TYPE_BYTECLOUD) && !Intrinsics.areEqual(this.$accountInfo.getLoginPlatform(), "enterprise")) {
                this.label = 1;
                if (CustomActivityRepository.fetchActivities$default(CustomActivityRepository.INSTANCE.getInstance(), false, (Continuation) this, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
