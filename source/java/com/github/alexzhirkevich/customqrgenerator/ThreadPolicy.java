package com.github.alexzhirkevich.customqrgenerator;

import com.lynx.tasm.animation.AnimationConstant;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: QrCodeGenerator.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J;\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tH¦Bø\u0001\u0000¢\u0006\u0002\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/ThreadPolicy;", "", "(Ljava/lang/String;I)V", "invoke", "", AnimationConstant.PROP_STR_WIDTH, "", AnimationConstant.PROP_STR_HEIGHT, "block", "Lkotlin/Function2;", "Lkotlin/ranges/IntRange;", "(IILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SingleThread", "DoubleThread", "QuadThread", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class ThreadPolicy {
    public static final ThreadPolicy SingleThread = new ThreadPolicy("SingleThread", 0) { // from class: com.github.alexzhirkevich.customqrgenerator.ThreadPolicy.SingleThread
        {
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.ThreadPolicy
        public Object invoke(int i, int i2, Function2<? super IntRange, ? super IntRange, Unit> function2, Continuation<? super Unit> continuation) {
            Object invoke = function2.invoke(RangesKt.until(0, i), RangesKt.until(0, i2));
            return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
        }
    };
    public static final ThreadPolicy DoubleThread = new DoubleThread("DoubleThread", 1);
    public static final ThreadPolicy QuadThread = new QuadThread("QuadThread", 2);
    private static final /* synthetic */ ThreadPolicy[] $VALUES = $values();

    private static final /* synthetic */ ThreadPolicy[] $values() {
        return new ThreadPolicy[]{SingleThread, DoubleThread, QuadThread};
    }

    public /* synthetic */ ThreadPolicy(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i);
    }

    public static ThreadPolicy valueOf(String str) {
        return (ThreadPolicy) Enum.valueOf(ThreadPolicy.class, str);
    }

    public static ThreadPolicy[] values() {
        return (ThreadPolicy[]) $VALUES.clone();
    }

    public abstract Object invoke(int i, int i2, Function2<? super IntRange, ? super IntRange, Unit> function2, Continuation<? super Unit> continuation);

    private ThreadPolicy(String str, int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QrCodeGenerator.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\bH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/ThreadPolicy$DoubleThread;", "Lcom/github/alexzhirkevich/customqrgenerator/ThreadPolicy;", "invoke", "", AnimationConstant.PROP_STR_WIDTH, "", AnimationConstant.PROP_STR_HEIGHT, "block", "Lkotlin/Function2;", "Lkotlin/ranges/IntRange;", "(IILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class DoubleThread extends ThreadPolicy {
        DoubleThread(String str, int i) {
            super(str, i, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0057 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        @Override // com.github.alexzhirkevich.customqrgenerator.ThreadPolicy
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object invoke(int i, int i2, Function2<? super IntRange, ? super IntRange, Unit> function2, Continuation<? super Unit> continuation) {
            ThreadPolicy$DoubleThread$invoke$1 threadPolicy$DoubleThread$invoke$1;
            Object obj;
            Object coroutine_suspended;
            int i3;
            if (continuation instanceof ThreadPolicy$DoubleThread$invoke$1) {
                threadPolicy$DoubleThread$invoke$1 = (ThreadPolicy$DoubleThread$invoke$1) continuation;
                if ((threadPolicy$DoubleThread$invoke$1.label & Integer.MIN_VALUE) != 0) {
                    threadPolicy$DoubleThread$invoke$1.label -= Integer.MIN_VALUE;
                    obj = threadPolicy$DoubleThread$invoke$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = threadPolicy$DoubleThread$invoke$1.label;
                    if (i3 != 0) {
                        ResultKt.throwOnFailure(obj);
                        ThreadPolicy$DoubleThread$invoke$2 threadPolicy$DoubleThread$invoke$2 = new ThreadPolicy$DoubleThread$invoke$2(i, i2, function2, null);
                        threadPolicy$DoubleThread$invoke$1.label = 1;
                        obj = CoroutineScopeKt.coroutineScope(threadPolicy$DoubleThread$invoke$2, threadPolicy$DoubleThread$invoke$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i3 != 1) {
                            if (i3 == 2) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    threadPolicy$DoubleThread$invoke$1.label = 2;
                    if (AwaitKt.joinAll((Collection) obj, threadPolicy$DoubleThread$invoke$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
            }
            threadPolicy$DoubleThread$invoke$1 = new ThreadPolicy$DoubleThread$invoke$1(this, continuation);
            obj = threadPolicy$DoubleThread$invoke$1.result;
            coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i3 = threadPolicy$DoubleThread$invoke$1.label;
            if (i3 != 0) {
            }
            threadPolicy$DoubleThread$invoke$1.label = 2;
            if (AwaitKt.joinAll((Collection) obj, threadPolicy$DoubleThread$invoke$1) == coroutine_suspended) {
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QrCodeGenerator.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\bH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/ThreadPolicy$QuadThread;", "Lcom/github/alexzhirkevich/customqrgenerator/ThreadPolicy;", "invoke", "", AnimationConstant.PROP_STR_WIDTH, "", AnimationConstant.PROP_STR_HEIGHT, "block", "Lkotlin/Function2;", "Lkotlin/ranges/IntRange;", "(IILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class QuadThread extends ThreadPolicy {
        QuadThread(String str, int i) {
            super(str, i, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0057 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        @Override // com.github.alexzhirkevich.customqrgenerator.ThreadPolicy
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object invoke(int i, int i2, Function2<? super IntRange, ? super IntRange, Unit> function2, Continuation<? super Unit> continuation) {
            ThreadPolicy$QuadThread$invoke$1 threadPolicy$QuadThread$invoke$1;
            Object obj;
            Object coroutine_suspended;
            int i3;
            if (continuation instanceof ThreadPolicy$QuadThread$invoke$1) {
                threadPolicy$QuadThread$invoke$1 = (ThreadPolicy$QuadThread$invoke$1) continuation;
                if ((threadPolicy$QuadThread$invoke$1.label & Integer.MIN_VALUE) != 0) {
                    threadPolicy$QuadThread$invoke$1.label -= Integer.MIN_VALUE;
                    obj = threadPolicy$QuadThread$invoke$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = threadPolicy$QuadThread$invoke$1.label;
                    if (i3 != 0) {
                        ResultKt.throwOnFailure(obj);
                        ThreadPolicy$QuadThread$invoke$2 threadPolicy$QuadThread$invoke$2 = new ThreadPolicy$QuadThread$invoke$2(i, i2, function2, null);
                        threadPolicy$QuadThread$invoke$1.label = 1;
                        obj = CoroutineScopeKt.coroutineScope(threadPolicy$QuadThread$invoke$2, threadPolicy$QuadThread$invoke$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i3 != 1) {
                            if (i3 == 2) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    threadPolicy$QuadThread$invoke$1.label = 2;
                    if (AwaitKt.joinAll((Collection) obj, threadPolicy$QuadThread$invoke$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
            }
            threadPolicy$QuadThread$invoke$1 = new ThreadPolicy$QuadThread$invoke$1(this, continuation);
            obj = threadPolicy$QuadThread$invoke$1.result;
            coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i3 = threadPolicy$QuadThread$invoke$1.label;
            if (i3 != 0) {
            }
            threadPolicy$QuadThread$invoke$1.label = 2;
            if (AwaitKt.joinAll((Collection) obj, threadPolicy$QuadThread$invoke$1) == coroutine_suspended) {
            }
            return Unit.INSTANCE;
        }
    }
}
