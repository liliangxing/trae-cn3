package com.bytedance.trae.login.traeauth;

import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TraeAuthManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.traeauth.TraeAuthManager$performExchangeAndPersist$1", f = "TraeAuthManager.kt", i = {0, 1, 2}, l = {1789, 659, 663}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeAuthManager$performExchangeAndPersist$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TraeAuthManager.TraeAuthCallback $callback;
    final /* synthetic */ String $refreshToken;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TraeAuthManager$performExchangeAndPersist$1(String str, TraeAuthManager.TraeAuthCallback traeAuthCallback, Continuation<? super TraeAuthManager$performExchangeAndPersist$1> continuation) {
        super(2, continuation);
        this.$refreshToken = str;
        this.$callback = traeAuthCallback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TraeAuthManager$performExchangeAndPersist$1(this.$refreshToken, this.$callback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        AtomicBoolean atomicBoolean;
        Mutex mutex;
        String str;
        TraeAuthManager.TraeAuthCallback traeAuthCallback;
        Mutex mutex2;
        AtomicBoolean atomicBoolean2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = TraeAuthManager.refreshMutex;
                    str = this.$refreshToken;
                    traeAuthCallback = this.$callback;
                    this.L$0 = mutex;
                    this.L$1 = str;
                    this.L$2 = traeAuthCallback;
                    this.label = 1;
                    if (mutex.lock((Object) null, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            mutex2 = (Mutex) this.L$0;
                        } else {
                            if (i != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            mutex2 = (Mutex) this.L$0;
                        }
                        try {
                            ResultKt.throwOnFailure(obj);
                            Unit unit = Unit.INSTANCE;
                            mutex2.unlock((Object) null);
                            atomicBoolean2 = TraeAuthManager.isExchangeRequesting;
                            atomicBoolean2.set(false);
                            return Unit.INSTANCE;
                        } catch (Throwable th) {
                            th = th;
                            mutex2.unlock((Object) null);
                            throw th;
                        }
                    }
                    TraeAuthManager.TraeAuthCallback traeAuthCallback2 = (TraeAuthManager.TraeAuthCallback) this.L$2;
                    str = (String) this.L$1;
                    Mutex mutex3 = (Mutex) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    traeAuthCallback = traeAuthCallback2;
                    mutex = mutex3;
                }
                boolean isFirstAppUpgrade = TraeAuthStorage.INSTANCE.isFirstAppUpgrade();
                FLogger fLogger = FLogger.INSTANCE;
                StringBuilder sb = new StringBuilder("performExchangeAndPersist:");
                if (!isFirstAppUpgrade) {
                    z = false;
                }
                fLogger.mo430w("TraeAuthManager", sb.append(z).toString());
                System.currentTimeMillis();
                long jwtExpireAt = TraeAuthStorage.INSTANCE.getJwtExpireAt();
                long currentTimeMillis = jwtExpireAt - System.currentTimeMillis();
                if (jwtExpireAt > 0 && currentTimeMillis > 18000000 && !DebugSettings.INSTANCE.getForceTokenRefresh()) {
                    FLogger.INSTANCE.mo428i("TraeAuthManager", "performExchangeAndPersist: skip (double-check), token still valid for " + (currentTimeMillis / BytePatchException.ErrorCode.paramsError) + 's');
                    if (!isFirstAppUpgrade) {
                        CoroutineContext main = Dispatchers.getMain();
                        TraeAuthManager$performExchangeAndPersist$1$1$1 traeAuthManager$performExchangeAndPersist$1$1$1 = new TraeAuthManager$performExchangeAndPersist$1$1$1(traeAuthCallback, null);
                        this.L$0 = mutex;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 2;
                        if (BuildersKt.withContext(main, traeAuthManager$performExchangeAndPersist$1$1$1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        mutex2 = mutex;
                        Unit unit2 = Unit.INSTANCE;
                        mutex2.unlock((Object) null);
                        atomicBoolean2 = TraeAuthManager.isExchangeRequesting;
                        atomicBoolean2.set(false);
                        return Unit.INSTANCE;
                    }
                }
                TraeAuthManager traeAuthManager = TraeAuthManager.INSTANCE;
                this.L$0 = mutex;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 3;
                if (traeAuthManager.exchangeTokenOrThrowIgnoreDevice$impl_mainlandRelease(str, traeAuthCallback, false, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex2 = mutex;
                Unit unit22 = Unit.INSTANCE;
                mutex2.unlock((Object) null);
                atomicBoolean2 = TraeAuthManager.isExchangeRequesting;
                atomicBoolean2.set(false);
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                mutex2 = mutex;
                mutex2.unlock((Object) null);
                throw th;
            }
        } catch (Throwable th3) {
            atomicBoolean = TraeAuthManager.isExchangeRequesting;
            atomicBoolean.set(false);
            throw th3;
        }
    }
}
