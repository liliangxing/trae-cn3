package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.CreditsBalanceManager;
import com.bytedance.trae.conversation.billing.BillingUpgradePromptCoordinator;
import com.bytedance.trae.conversation.chat.UserPayIdentityService;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
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
/* compiled from: CreditsBalanceManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.CreditsBalanceManager$refresh$1", f = "CreditsBalanceManager.kt", i = {}, l = {91, 92}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CreditsBalanceManager$refresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CreditsBalanceManager$refresh$1(Continuation<? super CreditsBalanceManager$refresh$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CreditsBalanceManager$refresh$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ad, code lost:
    
        if (r12.getAndSet(false) != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00af, code lost:
    
        com.bytedance.trae.conversation.CreditsBalanceManager.INSTANCE.refresh();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d2, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00cd, code lost:
    
        if (r12.getAndSet(false) == false) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004a A[Catch: all -> 0x001f, CancellationException -> 0x0022, TRY_LEAVE, TryCatch #3 {CancellationException -> 0x0022, all -> 0x001f, blocks: (B:36:0x000f, B:10:0x0046, B:12:0x004a, B:17:0x0063, B:19:0x006b, B:24:0x0084, B:25:0x008e, B:27:0x0094, B:5:0x001b, B:6:0x003a, B:45:0x0028), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0063 A[Catch: all -> 0x001f, CancellationException -> 0x0022, TRY_ENTER, TryCatch #3 {CancellationException -> 0x0022, all -> 0x001f, blocks: (B:36:0x000f, B:10:0x0046, B:12:0x004a, B:17:0x0063, B:19:0x006b, B:24:0x0084, B:25:0x008e, B:27:0x0094, B:5:0x001b, B:6:0x003a, B:45:0x0028), top: B:2:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        UserPayIdentityService.CreditsBalanceData creditsBalanceData;
        boolean belongsToCurrentUser;
        CopyOnWriteArraySet copyOnWriteArraySet;
        AtomicBoolean atomicBoolean3;
        AtomicBoolean atomicBoolean4;
        AtomicBoolean atomicBoolean5;
        AtomicBoolean atomicBoolean6;
        AtomicBoolean atomicBoolean7;
        AtomicBoolean atomicBoolean8;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BillingUpgradePromptCoordinator.awaitReady$default(BillingUpgradePromptCoordinator.INSTANCE, 0L, (Continuation) this, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                try {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    creditsBalanceData = (UserPayIdentityService.CreditsBalanceData) obj;
                    if (creditsBalanceData != null) {
                        return Unit.INSTANCE;
                    }
                    belongsToCurrentUser = CreditsBalanceManager.INSTANCE.belongsToCurrentUser(creditsBalanceData);
                    if (!belongsToCurrentUser) {
                        Unit unit = Unit.INSTANCE;
                        atomicBoolean5 = CreditsBalanceManager.isFetching;
                        atomicBoolean5.set(false);
                        atomicBoolean6 = CreditsBalanceManager.refreshPending;
                        if (atomicBoolean6.getAndSet(false)) {
                            CreditsBalanceManager.INSTANCE.refresh();
                        }
                        return unit;
                    }
                    copyOnWriteArraySet = CreditsBalanceManager.listeners;
                    Iterator it = copyOnWriteArraySet.iterator();
                    while (it.hasNext()) {
                        ((CreditsBalanceManager.OnBalanceChangedListener) it.next()).onBalanceChanged(creditsBalanceData);
                    }
                    atomicBoolean3 = CreditsBalanceManager.isFetching;
                    atomicBoolean3.set(false);
                    atomicBoolean4 = CreditsBalanceManager.refreshPending;
                } finally {
                    atomicBoolean7 = CreditsBalanceManager.isFetching;
                    atomicBoolean7.set(false);
                    atomicBoolean8 = CreditsBalanceManager.refreshPending;
                    if (atomicBoolean8.getAndSet(false)) {
                        CreditsBalanceManager.INSTANCE.refresh();
                    }
                }
            } else {
                ResultKt.throwOnFailure(obj);
            }
            this.label = 2;
            obj = UserPayIdentityService.fetchCreditsBalanceData((Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            creditsBalanceData = (UserPayIdentityService.CreditsBalanceData) obj;
            if (creditsBalanceData != null) {
            }
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            TraeLogUtil.INSTANCE.w("CreditsBalanceManager", "refresh credits balance failed", th);
            atomicBoolean = CreditsBalanceManager.isFetching;
            atomicBoolean.set(false);
            atomicBoolean2 = CreditsBalanceManager.refreshPending;
        }
    }
}
