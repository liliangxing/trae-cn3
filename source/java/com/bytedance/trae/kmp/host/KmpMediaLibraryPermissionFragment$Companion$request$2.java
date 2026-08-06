package com.bytedance.trae.kmp.host;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidKmpMediaLibraryHandler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.host.KmpMediaLibraryPermissionFragment$Companion$request$2", f = "AndroidKmpMediaLibraryHandler.kt", i = {}, l = {248}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpMediaLibraryPermissionFragment$Companion$request$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KmpMediaLibraryPermissionFragment$Companion$request$2(FragmentActivity fragmentActivity, Continuation<? super KmpMediaLibraryPermissionFragment$Companion$request$2> continuation) {
        super(2, continuation);
        this.$activity = fragmentActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpMediaLibraryPermissionFragment$Companion$request$2(this.$activity, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FragmentActivity fragmentActivity = this.$activity;
            this.L$0 = fragmentActivity;
            this.label = 1;
            Continuation continuation = (Continuation) this;
            CancellableContinuation<? super Boolean> cancellableContinuationImpl = new CancellableContinuationImpl<>(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            CancellableContinuation<? super Boolean> cancellableContinuation = cancellableContinuationImpl;
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag("KmpMediaLibraryPermission");
            KmpMediaLibraryPermissionFragment kmpMediaLibraryPermissionFragment = findFragmentByTag instanceof KmpMediaLibraryPermissionFragment ? (KmpMediaLibraryPermissionFragment) findFragmentByTag : null;
            if (kmpMediaLibraryPermissionFragment == null) {
                kmpMediaLibraryPermissionFragment = new KmpMediaLibraryPermissionFragment();
                supportFragmentManager.beginTransaction().add(kmpMediaLibraryPermissionFragment, "KmpMediaLibraryPermission").commitNow();
            }
            kmpMediaLibraryPermissionFragment.requestPermission(cancellableContinuation);
            obj = cancellableContinuationImpl.getResult();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
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
