package com.bytedance.trae.home;

import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.trae.conversation.billing.BillingUpgradePromptCoordinator;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.solo.task.TaskViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.MainActivity$observeContentReady$1", f = "MainActivity.kt", i = {}, l = {410, 412}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MainActivity$observeContentReady$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TaskViewModel $vm;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$observeContentReady$1(TaskViewModel taskViewModel, MainActivity mainActivity, Continuation<? super MainActivity$observeContentReady$1> continuation) {
        super(2, continuation);
        this.$vm = taskViewModel;
        this.this$0 = mainActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$observeContentReady$1(this.$vm, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.home.MainActivity$observeContentReady$1$1", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.home.MainActivity$observeContentReady$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C08191 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
        /* synthetic */ boolean Z$0;
        int label;

        C08191(Continuation<? super C08191> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c08191 = new C08191(continuation);
            c08191.Z$0 = ((Boolean) obj).booleanValue();
            return c08191;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation<? super Boolean>) obj2);
        }

        public final Object invoke(boolean z, Continuation<? super Boolean> continuation) {
            return create(Boolean.valueOf(z), continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(this.Z$0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        boolean z;
        long j;
        Handler handler;
        Function0 function0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (FlowKt.first(this.$vm.getContentReady(), new C08191(null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                z = this.this$0.isSplashDismissed;
                if (!z) {
                    function0 = this.this$0.pendingNavigate;
                    this.this$0.pendingNavigate = null;
                    if (function0 != null) {
                        function0.invoke();
                    }
                } else {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    j = this.this$0.splashShowTime;
                    long coerceAtLeast = RangesKt.coerceAtLeast(800 - (elapsedRealtime - j), 0L);
                    if (coerceAtLeast > 0) {
                        handler = this.this$0.handler;
                        final MainActivity mainActivity = this.this$0;
                        Boxing.boxBoolean(handler.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.MainActivity$observeContentReady$1$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                MainActivity.access$dismissSplashAndNavigate(MainActivity.this);
                            }
                        }, coerceAtLeast));
                    } else {
                        this.this$0.dismissSplashAndNavigate();
                    }
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        this.label = 2;
        if (BillingUpgradePromptCoordinator.awaitReady$default(BillingUpgradePromptCoordinator.INSTANCE, 0L, (Continuation) this, 1, null) == coroutine_suspended) {
            return coroutine_suspended;
        }
        z = this.this$0.isSplashDismissed;
        if (!z) {
        }
        return Unit.INSTANCE;
    }
}
