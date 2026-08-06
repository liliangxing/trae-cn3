package androidx.room;

import java.lang.reflect.Method;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.ThreadContextElementKt;

/* compiled from: RoomDatabase.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u0010\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b*\u00020\b\u001a9\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\u00020\b2\u001c\u0010\u000f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"acquireTransactionThread", "Lkotlin/coroutines/ContinuationInterceptor;", "Ljava/util/concurrent/Executor;", "controlJob", "Lkotlinx/coroutines/Job;", "(Ljava/util/concurrent/Executor;Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createTransactionContext", "Lkotlin/coroutines/CoroutineContext;", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reflectGetSuspendingTransactionId", "Ljava/lang/ThreadLocal;", "", "withTransaction", "R", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/room/RoomDatabase;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class RoomDatabaseKt {
    /* JADX WARN: Removed duplicated region for block: B:11:0x0082 A[PHI: r7
      0x0082: PHI (r7v12 java.lang.Object) = (r7v9 java.lang.Object), (r7v1 java.lang.Object) binds: [B:18:0x007f, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R> Object withTransaction(RoomDatabase roomDatabase, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation) {
        RoomDatabaseKt$withTransaction$1 roomDatabaseKt$withTransaction$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        CoroutineContext transactionDispatcher;
        CoroutineContext coroutineContext;
        if (continuation instanceof RoomDatabaseKt$withTransaction$1) {
            roomDatabaseKt$withTransaction$1 = (RoomDatabaseKt$withTransaction$1) continuation;
            if ((roomDatabaseKt$withTransaction$1.label & Integer.MIN_VALUE) != 0) {
                roomDatabaseKt$withTransaction$1.label -= Integer.MIN_VALUE;
                obj = roomDatabaseKt$withTransaction$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = roomDatabaseKt$withTransaction$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    TransactionElement transactionElement = (TransactionElement) roomDatabaseKt$withTransaction$1.getContext().get(TransactionElement.INSTANCE);
                    if (transactionElement != null && (transactionDispatcher = transactionElement.getTransactionDispatcher()) != null) {
                        coroutineContext = transactionDispatcher;
                        RoomDatabaseKt$withTransaction$2 roomDatabaseKt$withTransaction$2 = new RoomDatabaseKt$withTransaction$2(roomDatabase, function1, null);
                        roomDatabaseKt$withTransaction$1.L$0 = null;
                        roomDatabaseKt$withTransaction$1.L$1 = null;
                        roomDatabaseKt$withTransaction$1.label = 2;
                        obj = BuildersKt.withContext(coroutineContext, roomDatabaseKt$withTransaction$2, roomDatabaseKt$withTransaction$1);
                        return obj == coroutine_suspended ? coroutine_suspended : obj;
                    }
                    roomDatabaseKt$withTransaction$1.L$0 = roomDatabase;
                    roomDatabaseKt$withTransaction$1.L$1 = function1;
                    roomDatabaseKt$withTransaction$1.label = 1;
                    obj = createTransactionContext(roomDatabase, roomDatabaseKt$withTransaction$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function1 = (Function1) roomDatabaseKt$withTransaction$1.L$1;
                    roomDatabase = (RoomDatabase) roomDatabaseKt$withTransaction$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                coroutineContext = (CoroutineContext) obj;
                RoomDatabaseKt$withTransaction$2 roomDatabaseKt$withTransaction$22 = new RoomDatabaseKt$withTransaction$2(roomDatabase, function1, null);
                roomDatabaseKt$withTransaction$1.L$0 = null;
                roomDatabaseKt$withTransaction$1.L$1 = null;
                roomDatabaseKt$withTransaction$1.label = 2;
                obj = BuildersKt.withContext(coroutineContext, roomDatabaseKt$withTransaction$22, roomDatabaseKt$withTransaction$1);
                if (obj == coroutine_suspended) {
                }
            }
        }
        roomDatabaseKt$withTransaction$1 = new RoomDatabaseKt$withTransaction$1(continuation);
        obj = roomDatabaseKt$withTransaction$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = roomDatabaseKt$withTransaction$1.label;
        if (i != 0) {
        }
        coroutineContext = (CoroutineContext) obj;
        RoomDatabaseKt$withTransaction$2 roomDatabaseKt$withTransaction$222 = new RoomDatabaseKt$withTransaction$2(roomDatabase, function1, null);
        roomDatabaseKt$withTransaction$1.L$0 = null;
        roomDatabaseKt$withTransaction$1.L$1 = null;
        roomDatabaseKt$withTransaction$1.label = 2;
        obj = BuildersKt.withContext(coroutineContext, roomDatabaseKt$withTransaction$222, roomDatabaseKt$withTransaction$1);
        if (obj == coroutine_suspended) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object createTransactionContext(RoomDatabase roomDatabase, Continuation<? super CoroutineContext> continuation) {
        RoomDatabaseKt$createTransactionContext$1 roomDatabaseKt$createTransactionContext$1;
        int i;
        RoomDatabase roomDatabase2;
        CompletableJob completableJob;
        if (continuation instanceof RoomDatabaseKt$createTransactionContext$1) {
            roomDatabaseKt$createTransactionContext$1 = (RoomDatabaseKt$createTransactionContext$1) continuation;
            if ((roomDatabaseKt$createTransactionContext$1.label & Integer.MIN_VALUE) != 0) {
                roomDatabaseKt$createTransactionContext$1.label -= Integer.MIN_VALUE;
                Object obj = roomDatabaseKt$createTransactionContext$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = roomDatabaseKt$createTransactionContext$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    final CompletableJob Job$default = JobKt.Job$default((Job) null, 1, (Object) null);
                    Job job = roomDatabaseKt$createTransactionContext$1.getContext().get(Job.Key);
                    if (job != null) {
                        job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.room.RoomDatabaseKt$createTransactionContext$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((Throwable) obj2);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Throwable th) {
                                Job.DefaultImpls.cancel$default(Job$default, (CancellationException) null, 1, (Object) null);
                            }
                        });
                    }
                    Executor transactionExecutor = roomDatabase.getTransactionExecutor();
                    Intrinsics.checkNotNullExpressionValue(transactionExecutor, "transactionExecutor");
                    roomDatabaseKt$createTransactionContext$1.L$0 = roomDatabase;
                    roomDatabaseKt$createTransactionContext$1.L$1 = Job$default;
                    roomDatabaseKt$createTransactionContext$1.label = 1;
                    Object acquireTransactionThread = acquireTransactionThread(transactionExecutor, (Job) Job$default, roomDatabaseKt$createTransactionContext$1);
                    if (acquireTransactionThread == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    roomDatabase2 = roomDatabase;
                    completableJob = Job$default;
                    obj = acquireTransactionThread;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    completableJob = (CompletableJob) roomDatabaseKt$createTransactionContext$1.L$1;
                    roomDatabase2 = (RoomDatabase) roomDatabaseKt$createTransactionContext$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) obj;
                return continuationInterceptor.plus(new TransactionElement((Job) completableJob, continuationInterceptor)).plus(ThreadContextElementKt.asContextElement(reflectGetSuspendingTransactionId(roomDatabase2), Boxing.boxInt(System.identityHashCode(completableJob))));
            }
        }
        roomDatabaseKt$createTransactionContext$1 = new RoomDatabaseKt$createTransactionContext$1(continuation);
        Object obj2 = roomDatabaseKt$createTransactionContext$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = roomDatabaseKt$createTransactionContext$1.label;
        if (i != 0) {
        }
        ContinuationInterceptor continuationInterceptor2 = (ContinuationInterceptor) obj2;
        return continuationInterceptor2.plus(new TransactionElement((Job) completableJob, continuationInterceptor2)).plus(ThreadContextElementKt.asContextElement(reflectGetSuspendingTransactionId(roomDatabase2), Boxing.boxInt(System.identityHashCode(completableJob))));
    }

    public static final ThreadLocal<Integer> reflectGetSuspendingTransactionId(RoomDatabase roomDatabase) {
        Intrinsics.checkNotNullParameter(roomDatabase, "<this>");
        Method declaredMethod = RoomDatabase.class.getDeclaredMethod("getSuspendingTransactionId", new Class[0]);
        declaredMethod.setAccessible(true);
        Object invoke = declaredMethod.invoke(roomDatabase, new Object[0]);
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type java.lang.ThreadLocal<kotlin.Int>");
        return (ThreadLocal) invoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object acquireTransactionThread(Executor executor, final Job job, Continuation<? super ContinuationInterceptor> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        cancellableContinuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.room.RoomDatabaseKt$acquireTransactionThread$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        });
        try {
            executor.execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2

                /* compiled from: RoomDatabase.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2$1", f = "RoomDatabase.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2$1 */
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
                static final class C04631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CancellableContinuation<ContinuationInterceptor> $continuation;
                    final /* synthetic */ Job $controlJob;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C04631(CancellableContinuation<? super ContinuationInterceptor> cancellableContinuation, Job job, Continuation<? super C04631> continuation) {
                        super(2, continuation);
                        this.$continuation = cancellableContinuation;
                        this.$controlJob = job;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        Continuation<Unit> c04631 = new C04631(this.$continuation, this.$controlJob, continuation);
                        c04631.L$0 = obj;
                        return c04631;
                    }

                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                            Continuation continuation = this.$continuation;
                            Result.Companion companion = Result.Companion;
                            CoroutineContext.Element element = coroutineScope.getCoroutineContext().get(ContinuationInterceptor.Key);
                            Intrinsics.checkNotNull(element);
                            continuation.resumeWith(Result.constructor-impl(element));
                            this.label = 1;
                            if (this.$controlJob.join((Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    BuildersKt.runBlocking$default((CoroutineContext) null, new C04631(cancellableContinuation, job, null), 1, (Object) null);
                }
            });
        } catch (RejectedExecutionException e) {
            cancellableContinuation.cancel(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
