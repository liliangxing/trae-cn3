package com.bytedance.trae.kmp.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KmpRepositoryCoroutines.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007\u001aG\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u00032'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007¢\u0006\u0002\b\nH\u0087@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"repositoryScope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "withRepositoryContext", "T", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpRepositoryCoroutinesKt {
    public static /* synthetic */ CoroutineScope repositoryScope$default(CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineDispatcher = Dispatchers.getDefault();
        }
        return repositoryScope(coroutineScope, coroutineDispatcher);
    }

    public static final CoroutineScope repositoryScope(CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        return CoroutineScopeKt.CoroutineScope(coroutineScope.getCoroutineContext().plus((CoroutineContext) coroutineDispatcher));
    }

    public static /* synthetic */ Object withRepositoryContext$default(CoroutineDispatcher coroutineDispatcher, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineDispatcher = Dispatchers.getDefault();
        }
        return withRepositoryContext(coroutineDispatcher, function2, continuation);
    }

    public static final <T> Object withRepositoryContext(CoroutineDispatcher coroutineDispatcher, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return BuildersKt.withContext((CoroutineContext) coroutineDispatcher, function2, continuation);
    }
}
