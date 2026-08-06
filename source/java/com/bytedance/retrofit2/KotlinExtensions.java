package com.bytedance.retrofit2;

import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KotlinExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a+\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0003H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a+\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001a\u0010\b\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\tH\u0086\b¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u000b\u001a\u00020\f*\u00060\rj\u0002`\u000eH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"await", "T", "", "Lcom/bytedance/retrofit2/Call;", "(Lcom/bytedance/retrofit2/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitNullable", "awaitResponse", "Lcom/bytedance/retrofit2/SsResponse;", "create", "Lcom/bytedance/retrofit2/Retrofit;", "(Lcom/bytedance/retrofit2/Retrofit;)Ljava/lang/Object;", "suspendAndThrow", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ss-retrofit2_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KotlinExtensions {
    public static final /* synthetic */ <T> T create(Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "$this$create");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) retrofit.create(Object.class);
    }

    public static final Object suspendAndThrow(final Exception exc, final Continuation<?> continuation) {
        Dispatchers.getDefault().dispatch(continuation.getContext(), new Runnable() { // from class: com.bytedance.retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1
            @Override // java.lang.Runnable
            public final void run() {
                Continuation intercepted = IntrinsicsKt.intercepted(continuation);
                Exception exc2 = exc;
                Result.Companion companion = Result.Companion;
                intercepted.resumeWith(Result.constructor-impl(ResultKt.createFailure(exc2)));
            }
        });
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutine_suspended : Unit.INSTANCE;
    }

    public static final <T> Object await(final Call<T> call, Continuation<? super T> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        cancellableContinuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.bytedance.retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                Call.this.cancel();
            }
        });
        call.enqueue(new Callback<T>() { // from class: com.bytedance.retrofit2.KotlinExtensions$await$2$2
            @Override // com.bytedance.retrofit2.Callback
            public void onResponse(Call<T> call2, SsResponse<T> response) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.isSuccessful()) {
                    T body = response.body();
                    if (body == null) {
                        Object tag = call2.request().tag(Invocation.class);
                        Intrinsics.checkNotNull(tag);
                        Method method = ((Invocation) tag).method();
                        StringBuilder sb = new StringBuilder("Response from ");
                        Intrinsics.checkNotNullExpressionValue(method, "method");
                        Class<?> declaringClass = method.getDeclaringClass();
                        Intrinsics.checkNotNullExpressionValue(declaringClass, "method.declaringClass");
                        Throwable kotlinNullPointerException = new KotlinNullPointerException(sb.append(declaringClass.getName()).append('.').append(method.getName()).append(" was null but response body type was declared as non-null").toString());
                        Continuation continuation2 = cancellableContinuation;
                        Result.Companion companion = Result.Companion;
                        continuation2.resumeWith(Result.constructor-impl(ResultKt.createFailure(kotlinNullPointerException)));
                        return;
                    }
                    Continuation continuation3 = cancellableContinuation;
                    Result.Companion companion2 = Result.Companion;
                    continuation3.resumeWith(Result.constructor-impl(body));
                    return;
                }
                Continuation continuation4 = cancellableContinuation;
                HttpException httpException = new HttpException(response);
                Result.Companion companion3 = Result.Companion;
                continuation4.resumeWith(Result.constructor-impl(ResultKt.createFailure(httpException)));
            }

            @Override // com.bytedance.retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable t) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                Continuation continuation2 = cancellableContinuation;
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.constructor-impl(ResultKt.createFailure(t)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final <T> Object awaitNullable(final Call<T> call, Continuation<? super T> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        cancellableContinuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.bytedance.retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                Call.this.cancel();
            }
        });
        call.enqueue(new Callback<T>() { // from class: com.bytedance.retrofit2.KotlinExtensions$await$4$2
            @Override // com.bytedance.retrofit2.Callback
            public void onResponse(Call<T> call2, SsResponse<T> response) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.isSuccessful()) {
                    Continuation continuation2 = cancellableContinuation;
                    T body = response.body();
                    Result.Companion companion = Result.Companion;
                    continuation2.resumeWith(Result.constructor-impl(body));
                    return;
                }
                Continuation continuation3 = cancellableContinuation;
                HttpException httpException = new HttpException(response);
                Result.Companion companion2 = Result.Companion;
                continuation3.resumeWith(Result.constructor-impl(ResultKt.createFailure(httpException)));
            }

            @Override // com.bytedance.retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable t) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                Continuation continuation2 = cancellableContinuation;
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.constructor-impl(ResultKt.createFailure(t)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final <T> Object awaitResponse(final Call<T> call, Continuation<? super SsResponse<T>> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        cancellableContinuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.bytedance.retrofit2.KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                Call.this.cancel();
            }
        });
        call.enqueue(new Callback<T>() { // from class: com.bytedance.retrofit2.KotlinExtensions$awaitResponse$2$2
            @Override // com.bytedance.retrofit2.Callback
            public void onResponse(Call<T> call2, SsResponse<T> response) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                Continuation continuation2 = cancellableContinuation;
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.constructor-impl(response));
            }

            @Override // com.bytedance.retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable t) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                Continuation continuation2 = cancellableContinuation;
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.constructor-impl(ResultKt.createFailure(t)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
