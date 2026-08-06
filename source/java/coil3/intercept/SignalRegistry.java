package coil3.intercept;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: SignalRegistry.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001\u0017B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000b\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0001H\u0086@¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b*\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0016R\"\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b0\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0018"}, d2 = {"Lcoil3/intercept/SignalRegistry;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "<init>", "()V", "segments", "", "Lcoil3/intercept/SignalRegistry$Segment;", "[Lcoil3/intercept/SignalRegistry$Segment;", "await", "key", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "complete", "", StrategyConstants.VALUE, "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completeExceptionally", "t", "", "(Ljava/lang/Object;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "segment", "(Ljava/lang/Object;)Lcoil3/intercept/SignalRegistry$Segment;", "Segment", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SignalRegistry<K, V> {
    private final Segment<K, V>[] segments;

    public SignalRegistry() {
        Segment<K, V>[] segmentArr = new Segment[16];
        for (int i = 0; i < 16; i++) {
            segmentArr[i] = new Segment<>();
        }
        this.segments = segmentArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008e A[Catch: all -> 0x00dd, TryCatch #3 {all -> 0x00dd, blocks: (B:36:0x0081, B:38:0x008e, B:39:0x0099), top: B:35:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object await(K k, Continuation<? super V> continuation) {
        SignalRegistry$await$1 signalRegistry$await$1;
        int i;
        Segment<K, V> segment;
        Mutex mutex;
        Mutex mutex2;
        CompletableDeferred<V> completableDeferred;
        CompletableDeferred<V> completableDeferred2;
        Mutex mutex3;
        Object obj;
        Throwable th;
        try {
            if (continuation instanceof SignalRegistry$await$1) {
                signalRegistry$await$1 = (SignalRegistry$await$1) continuation;
                if ((signalRegistry$await$1.label & Integer.MIN_VALUE) != 0) {
                    signalRegistry$await$1.label -= Integer.MIN_VALUE;
                    Object obj2 = signalRegistry$await$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = signalRegistry$await$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        segment = segment(k);
                        mutex = segment.getMutex();
                        signalRegistry$await$1.L$0 = k;
                        signalRegistry$await$1.L$1 = segment;
                        signalRegistry$await$1.L$2 = mutex;
                        signalRegistry$await$1.label = 1;
                        if (mutex.lock((Object) null, signalRegistry$await$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i == 1) {
                        Mutex mutex4 = (Mutex) signalRegistry$await$1.L$2;
                        segment = (Segment) signalRegistry$await$1.L$1;
                        Object obj3 = signalRegistry$await$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        mutex = mutex4;
                        k = obj3;
                    } else {
                        if (i != 2) {
                            if (i != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            mutex2 = (Mutex) signalRegistry$await$1.L$3;
                            th = (Throwable) signalRegistry$await$1.L$2;
                            segment = (Segment) signalRegistry$await$1.L$1;
                            obj = signalRegistry$await$1.L$0;
                            ResultKt.throwOnFailure(obj2);
                            try {
                                segment.getSignals().remove(obj);
                                throw th;
                            } finally {
                            }
                        }
                        Segment<K, V> segment2 = (Segment) signalRegistry$await$1.L$1;
                        Object obj4 = signalRegistry$await$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                        } catch (Throwable th2) {
                            th = th2;
                            segment = segment2;
                            k = obj4;
                            mutex3 = segment.getMutex();
                            signalRegistry$await$1.L$0 = k;
                            signalRegistry$await$1.L$1 = segment;
                            signalRegistry$await$1.L$2 = th;
                            signalRegistry$await$1.L$3 = mutex3;
                            signalRegistry$await$1.label = 3;
                            if (mutex3.lock((Object) null, signalRegistry$await$1) != coroutine_suspended) {
                            }
                        }
                    }
                    completableDeferred = segment.getSignals().get(k);
                    if (completableDeferred == null) {
                        segment.getSignals().put(k, CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null));
                    }
                    completableDeferred2 = completableDeferred;
                    if (completableDeferred2 != null) {
                        return null;
                    }
                    try {
                        signalRegistry$await$1.L$0 = k;
                        signalRegistry$await$1.L$1 = segment;
                        signalRegistry$await$1.L$2 = null;
                        signalRegistry$await$1.label = 2;
                        obj2 = completableDeferred2.await(signalRegistry$await$1);
                        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
                    } catch (Throwable th3) {
                        th = th3;
                        mutex3 = segment.getMutex();
                        signalRegistry$await$1.L$0 = k;
                        signalRegistry$await$1.L$1 = segment;
                        signalRegistry$await$1.L$2 = th;
                        signalRegistry$await$1.L$3 = mutex3;
                        signalRegistry$await$1.label = 3;
                        if (mutex3.lock((Object) null, signalRegistry$await$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = k;
                        th = th;
                        mutex2 = mutex3;
                        segment.getSignals().remove(obj);
                        throw th;
                    }
                }
            }
            completableDeferred = segment.getSignals().get(k);
            if (completableDeferred == null) {
            }
            completableDeferred2 = completableDeferred;
            if (completableDeferred2 != null) {
            }
        } finally {
        }
        signalRegistry$await$1 = new SignalRegistry$await$1(this, continuation);
        Object obj22 = signalRegistry$await$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = signalRegistry$await$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object complete(K k, V v, Continuation<? super Unit> continuation) {
        SignalRegistry$complete$1 signalRegistry$complete$1;
        int i;
        Mutex mutex;
        Object obj;
        Segment<K, V> segment;
        CompletableDeferred<V> remove;
        try {
            if (continuation instanceof SignalRegistry$complete$1) {
                signalRegistry$complete$1 = (SignalRegistry$complete$1) continuation;
                if ((signalRegistry$complete$1.label & Integer.MIN_VALUE) != 0) {
                    signalRegistry$complete$1.label -= Integer.MIN_VALUE;
                    Object obj2 = signalRegistry$complete$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = signalRegistry$complete$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        Segment<K, V> segment2 = segment(k);
                        mutex = segment2.getMutex();
                        signalRegistry$complete$1.L$0 = k;
                        signalRegistry$complete$1.L$1 = v;
                        signalRegistry$complete$1.L$2 = segment2;
                        signalRegistry$complete$1.L$3 = mutex;
                        signalRegistry$complete$1.label = 1;
                        if (mutex.lock((Object) null, signalRegistry$complete$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = v;
                        segment = segment2;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Mutex mutex2 = (Mutex) signalRegistry$complete$1.L$3;
                        segment = (Segment) signalRegistry$complete$1.L$2;
                        obj = signalRegistry$complete$1.L$1;
                        Object obj3 = signalRegistry$complete$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        mutex = mutex2;
                        k = obj3;
                    }
                    remove = segment.getSignals().remove(k);
                    if (remove != null) {
                        Boxing.boxBoolean(remove.complete(obj));
                    }
                    return Unit.INSTANCE;
                }
            }
            remove = segment.getSignals().remove(k);
            if (remove != null) {
            }
            return Unit.INSTANCE;
        } finally {
            mutex.unlock((Object) null);
        }
        signalRegistry$complete$1 = new SignalRegistry$complete$1(this, continuation);
        Object obj22 = signalRegistry$complete$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = signalRegistry$complete$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object completeExceptionally(K k, Throwable th, Continuation<? super Unit> continuation) {
        SignalRegistry$completeExceptionally$1 signalRegistry$completeExceptionally$1;
        int i;
        Mutex mutex;
        Throwable th2;
        Segment<K, V> segment;
        CompletableDeferred<V> remove;
        try {
            if (continuation instanceof SignalRegistry$completeExceptionally$1) {
                signalRegistry$completeExceptionally$1 = (SignalRegistry$completeExceptionally$1) continuation;
                if ((signalRegistry$completeExceptionally$1.label & Integer.MIN_VALUE) != 0) {
                    signalRegistry$completeExceptionally$1.label -= Integer.MIN_VALUE;
                    Object obj = signalRegistry$completeExceptionally$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = signalRegistry$completeExceptionally$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Segment<K, V> segment2 = segment(k);
                        mutex = segment2.getMutex();
                        signalRegistry$completeExceptionally$1.L$0 = k;
                        signalRegistry$completeExceptionally$1.L$1 = th;
                        signalRegistry$completeExceptionally$1.L$2 = segment2;
                        signalRegistry$completeExceptionally$1.L$3 = mutex;
                        signalRegistry$completeExceptionally$1.label = 1;
                        if (mutex.lock((Object) null, signalRegistry$completeExceptionally$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        th2 = th;
                        segment = segment2;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Mutex mutex2 = (Mutex) signalRegistry$completeExceptionally$1.L$3;
                        segment = (Segment) signalRegistry$completeExceptionally$1.L$2;
                        th2 = (Throwable) signalRegistry$completeExceptionally$1.L$1;
                        Object obj2 = signalRegistry$completeExceptionally$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex2;
                        k = obj2;
                    }
                    remove = segment.getSignals().remove(k);
                    if (remove != null) {
                        Boxing.boxBoolean(remove.completeExceptionally(th2));
                    }
                    return Unit.INSTANCE;
                }
            }
            remove = segment.getSignals().remove(k);
            if (remove != null) {
            }
            return Unit.INSTANCE;
        } finally {
            mutex.unlock((Object) null);
        }
        signalRegistry$completeExceptionally$1 = new SignalRegistry$completeExceptionally$1(this, continuation);
        Object obj3 = signalRegistry$completeExceptionally$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = signalRegistry$completeExceptionally$1.label;
        if (i != 0) {
        }
    }

    private final Segment<K, V> segment(K k) {
        int hashCode = k != null ? k.hashCode() : 0;
        Segment<K, V>[] segmentArr = this.segments;
        return segmentArr[(hashCode & Integer.MAX_VALUE) % segmentArr.length];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SignalRegistry.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcoil3/intercept/SignalRegistry$Segment;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "<init>", "()V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "getMutex", "()Lkotlinx/coroutines/sync/Mutex;", "signals", "", "Lkotlinx/coroutines/CompletableDeferred;", "getSignals", "()Ljava/util/Map;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Segment<K, V> {
        private final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);
        private final Map<K, CompletableDeferred<V>> signals = new LinkedHashMap();

        public final Mutex getMutex() {
            return this.mutex;
        }

        public final Map<K, CompletableDeferred<V>> getSignals() {
            return this.signals;
        }
    }
}
