package com.bytedance.trae.home.solo.setting;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.trae.conversation.billing.BillingUpgradePromptCoordinator;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.SettingsViewModel$fetchCreditsBalance$1", f = "SettingsViewModel.kt", i = {}, l = {120, 122}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsViewModel$fetchCreditsBalance$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ SettingsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsViewModel$fetchCreditsBalance$1(SettingsViewModel settingsViewModel, Continuation<? super SettingsViewModel$fetchCreditsBalance$1> continuation) {
        super(2, continuation);
        this.this$0 = settingsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsViewModel$fetchCreditsBalance$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            FLogger.INSTANCE.e("SettingsViewModel", "fetchCreditsBalance failed: " + th.getMessage());
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (BillingUpgradePromptCoordinator.awaitReady$default(BillingUpgradePromptCoordinator.INSTANCE, 0L, (Continuation) this, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData2 = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutableLiveData2.setValue(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        mutableLiveData = this.this$0._creditsBalanceSnapshot;
        this.L$0 = mutableLiveData;
        this.label = 2;
        Object fetchAndCacheCreditsBalanceSnapshot = UserPayIdentityCache.INSTANCE.fetchAndCacheCreditsBalanceSnapshot((Continuation) this);
        if (fetchAndCacheCreditsBalanceSnapshot == coroutine_suspended) {
            return coroutine_suspended;
        }
        mutableLiveData2 = mutableLiveData;
        obj = fetchAndCacheCreditsBalanceSnapshot;
        mutableLiveData2.setValue(obj);
        return Unit.INSTANCE;
    }
}
