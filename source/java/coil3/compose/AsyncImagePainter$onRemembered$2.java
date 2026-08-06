package coil3.compose;

import coil3.compose.AsyncImagePainter;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AsyncImagePainter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.compose.AsyncImagePainter$onRemembered$2", f = "AsyncImagePainter.kt", i = {}, l = {HttpStatus.SC_USE_PROXY}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AsyncImagePainter$onRemembered$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<AsyncImagePainter.Input> $inputs;
    int label;
    final /* synthetic */ AsyncImagePainter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncImagePainter$onRemembered$2(Flow<AsyncImagePainter.Input> flow, AsyncImagePainter asyncImagePainter, Continuation<? super AsyncImagePainter$onRemembered$2> continuation) {
        super(2, continuation);
        this.$inputs = flow;
        this.this$0 = asyncImagePainter;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AsyncImagePainter$onRemembered$2(this.$inputs, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AsyncImagePainter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006H\n"}, d2 = {"<anonymous>", "Lcoil3/compose/AsyncImagePainter$State;", "it", "Lcoil3/compose/AsyncImagePainter$Input;", "Lkotlin/ParameterName;", StrategyConstants.NAME, StrategyConstants.VALUE}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "coil3.compose.AsyncImagePainter$onRemembered$2$1", f = "AsyncImagePainter.kt", i = {}, l = {HttpStatus.SC_NOT_MODIFIED}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: coil3.compose.AsyncImagePainter$onRemembered$2$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class C07131 extends SuspendLambda implements Function2<AsyncImagePainter.Input, Continuation<? super AsyncImagePainter.State>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AsyncImagePainter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07131(AsyncImagePainter asyncImagePainter, Continuation<? super C07131> continuation) {
            super(2, continuation);
            this.this$0 = asyncImagePainter;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c07131 = new C07131(this.this$0, continuation);
            c07131.L$0 = obj;
            return c07131;
        }

        public final Object invoke(AsyncImagePainter.Input input, Continuation<? super AsyncImagePainter.State> continuation) {
            return create(input, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            ImageRequest updateRequest;
            AsyncImagePainter asyncImagePainter;
            AsyncImagePainter.State state;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AsyncImagePainter.Input input = (AsyncImagePainter.Input) this.L$0;
                updateRequest = this.this$0.updateRequest(input.getRequest(), false);
                AsyncImagePainter asyncImagePainter2 = this.this$0;
                this.L$0 = asyncImagePainter2;
                this.label = 1;
                obj = input.getImageLoader().execute(updateRequest, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                asyncImagePainter = asyncImagePainter2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                asyncImagePainter = (AsyncImagePainter) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            state = asyncImagePainter.toState((ImageResult) obj);
            return state;
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (FlowKt.mapLatest(this.$inputs, new C07131(this.this$0, null)).collect(new C07142(this.this$0), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AsyncImagePainter.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: coil3.compose.AsyncImagePainter$onRemembered$2$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public /* synthetic */ class C07142 implements FlowCollector, FunctionAdapter {
        final /* synthetic */ AsyncImagePainter $tmp0;

        C07142(AsyncImagePainter asyncImagePainter) {
            this.$tmp0 = asyncImagePainter;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        public final Function<?> getFunctionDelegate() {
            return new AdaptedFunctionReference<>(2, this.$tmp0, AsyncImagePainter.class, "updateState", "updateState(Lcoil3/compose/AsyncImagePainter$State;)V", 4);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final Object emit(AsyncImagePainter.State state, Continuation<? super Unit> continuation) {
            Object invokeSuspend$updateState = AsyncImagePainter$onRemembered$2.invokeSuspend$updateState(this.$tmp0, state, continuation);
            return invokeSuspend$updateState == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invokeSuspend$updateState : Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((AsyncImagePainter.State) obj, (Continuation<? super Unit>) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object invokeSuspend$updateState(AsyncImagePainter asyncImagePainter, AsyncImagePainter.State state, Continuation continuation) {
        asyncImagePainter.updateState(state);
        return Unit.INSTANCE;
    }
}
