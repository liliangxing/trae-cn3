package com.bytedance.trae.home.solo.setting.data;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.solo.setting.data.DefaultSettingsCreditsRepository;
import com.bytedance.trae.home.solo.setting.data.SettingsCreditsState;
import com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: SettingsCreditsRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.data.DefaultSettingsCreditsRepository$refresh$2", f = "SettingsCreditsRepository.kt", i = {0}, l = {58}, m = "invokeSuspend", n = {"requestUserId"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class DefaultSettingsCreditsRepository$refresh$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DefaultSettingsCreditsRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultSettingsCreditsRepository$refresh$2(DefaultSettingsCreditsRepository defaultSettingsCreditsRepository, Continuation<? super DefaultSettingsCreditsRepository$refresh$2> continuation) {
        super(2, continuation);
        this.this$0 = defaultSettingsCreditsRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> defaultSettingsCreditsRepository$refresh$2 = new DefaultSettingsCreditsRepository$refresh$2(this.this$0, continuation);
        defaultSettingsCreditsRepository$refresh$2.L$0 = obj;
        return defaultSettingsCreditsRepository$refresh$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00b1, code lost:
    
        r7 = r6.this$0.toBalancePresentation(r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String currentEligibleUserId;
        DefaultSettingsCreditsRepository.OwnedCreditsBalance ownedCreditsBalance;
        MutableStateFlow mutableStateFlow;
        String str;
        Throwable th;
        Object fetchCreditsUsage;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        Object obj2;
        String currentEligibleUserId2;
        DefaultSettingsCreditsRepository.OwnedCreditsBalance ownedCreditsBalance2;
        SettingsCreditsState.Loading loading;
        MutableStateFlow mutableStateFlow4;
        SettingsCreditsState.Visible balancePresentation;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            currentEligibleUserId = this.this$0.currentEligibleUserId();
            if (currentEligibleUserId == null) {
                this.this$0.ownedCreditsBalance = null;
                mutableStateFlow3 = this.this$0._creditsState;
                mutableStateFlow3.setValue(SettingsCreditsState.Hidden.INSTANCE);
                return Unit.INSTANCE;
            }
            ownedCreditsBalance = this.this$0.ownedCreditsBalance;
            try {
                if (ownedCreditsBalance != null) {
                    if (!Intrinsics.areEqual(ownedCreditsBalance.getUserId(), currentEligibleUserId)) {
                        ownedCreditsBalance = null;
                    }
                    if (ownedCreditsBalance != null) {
                        mutableStateFlow2 = this.this$0._creditsState;
                        mutableStateFlow2.setValue(ownedCreditsBalance.getPresentation());
                        DefaultSettingsCreditsRepository defaultSettingsCreditsRepository = this.this$0;
                        Result.Companion companion = Result.Companion;
                        this.L$0 = currentEligibleUserId;
                        this.label = 1;
                        fetchCreditsUsage = defaultSettingsCreditsRepository.fetchCreditsUsage(this);
                        if (fetchCreditsUsage != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str = currentEligibleUserId;
                        obj = fetchCreditsUsage;
                    }
                }
                Result.Companion companion2 = Result.Companion;
                this.L$0 = currentEligibleUserId;
                this.label = 1;
                fetchCreditsUsage = defaultSettingsCreditsRepository.fetchCreditsUsage(this);
                if (fetchCreditsUsage != coroutine_suspended) {
                }
            } catch (Throwable th2) {
                str = currentEligibleUserId;
                th = th2;
                Result.Companion companion3 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                if (Result.isFailure-impl(obj2)) {
                }
                CreditsUsageResponseDto creditsUsageResponseDto = (CreditsUsageResponseDto) obj2;
                currentEligibleUserId2 = this.this$0.currentEligibleUserId();
                if (!Intrinsics.areEqual(currentEligibleUserId2, str)) {
                }
            }
            mutableStateFlow = this.this$0._creditsState;
            mutableStateFlow.setValue(SettingsCreditsState.Loading.INSTANCE);
            DefaultSettingsCreditsRepository defaultSettingsCreditsRepository2 = this.this$0;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                Result.Companion companion32 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                if (Result.isFailure-impl(obj2)) {
                }
                CreditsUsageResponseDto creditsUsageResponseDto2 = (CreditsUsageResponseDto) obj2;
                currentEligibleUserId2 = this.this$0.currentEligibleUserId();
                if (!Intrinsics.areEqual(currentEligibleUserId2, str)) {
                }
            }
        }
        obj2 = Result.constructor-impl((CreditsUsageResponseDto) obj);
        if (Result.isFailure-impl(obj2)) {
            obj2 = null;
        }
        CreditsUsageResponseDto creditsUsageResponseDto22 = (CreditsUsageResponseDto) obj2;
        currentEligibleUserId2 = this.this$0.currentEligibleUserId();
        if (!Intrinsics.areEqual(currentEligibleUserId2, str)) {
            return Unit.INSTANCE;
        }
        if (creditsUsageResponseDto22 == null || balancePresentation == null) {
            ownedCreditsBalance2 = this.this$0.ownedCreditsBalance;
            if (ownedCreditsBalance2 != null) {
                DefaultSettingsCreditsRepository.OwnedCreditsBalance ownedCreditsBalance3 = Intrinsics.areEqual(ownedCreditsBalance2.getUserId(), str) ? ownedCreditsBalance2 : null;
                if (ownedCreditsBalance3 != null) {
                    loading = ownedCreditsBalance3.getPresentation();
                }
            }
            loading = SettingsCreditsState.Loading.INSTANCE;
        } else {
            loading = balancePresentation;
        }
        if (loading instanceof SettingsCreditsState.Visible) {
            this.this$0.ownedCreditsBalance = new DefaultSettingsCreditsRepository.OwnedCreditsBalance(str, (SettingsCreditsState.Visible) loading);
        }
        mutableStateFlow4 = this.this$0._creditsState;
        mutableStateFlow4.setValue(loading);
        return Unit.INSTANCE;
    }
}
