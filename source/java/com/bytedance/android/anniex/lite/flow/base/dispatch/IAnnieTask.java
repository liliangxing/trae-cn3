package com.bytedance.android.anniex.lite.flow.base.dispatch;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: IAnnieXTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/base/dispatch/IAnnieTask;", "INPUT", "", "name", "", "work", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "input", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IAnnieTask<INPUT> {
    String name();

    Object work(CoroutineScope coroutineScope, INPUT input, Continuation<? super Unit> continuation);

    /* compiled from: IAnnieXTask.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static <INPUT> Object work(IAnnieTask<INPUT> iAnnieTask, CoroutineScope coroutineScope, INPUT input, Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }
    }
}
