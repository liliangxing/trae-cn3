package coil3.compose;

import androidx.compose.ui.geometry.Size;
import androidx.exifinterface.media.ExifInterface;
import coil3.compose.internal.UtilsKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: DrawScopeSizeResolver.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u000e\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcoil3/compose/RealDrawScopeSizeResolver;", "Lcoil3/compose/DrawScopeSizeResolver;", "<init>", "()V", "sizes", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/ui/geometry/Size;", "connect", "", "size", "Lcoil3/size/Size;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class RealDrawScopeSizeResolver implements DrawScopeSizeResolver {
    private final MutableSharedFlow<Flow<Size>> sizes = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);

    @Override // coil3.compose.DrawScopeSizeResolver
    public void connect(Flow<Size> sizes) {
        this.sizes.tryEmit(sizes);
    }

    @Override // coil3.size.SizeResolver
    public Object size(Continuation<? super coil3.size.Size> continuation) {
        final Flow transformLatest = FlowKt.transformLatest(this.sizes, new RealDrawScopeSizeResolver$size$2(null));
        return FlowKt.first(new Flow<coil3.size.Size>() { // from class: coil3.compose.RealDrawScopeSizeResolver$size$$inlined$mapNotNull$1
            public Object collect(FlowCollector flowCollector, Continuation continuation2) {
                Object collect = transformLatest.collect(new C07162(flowCollector), continuation2);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", StrategyConstants.VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
            /* renamed from: coil3.compose.RealDrawScopeSizeResolver$size$$inlined$mapNotNull$1$2 */
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
            public static final class C07162<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "coil3.compose.RealDrawScopeSizeResolver$size$$inlined$mapNotNull$1$2", f = "DrawScopeSizeResolver.kt", i = {}, l = {221}, m = "emit", n = {}, s = {})
                /* renamed from: coil3.compose.RealDrawScopeSizeResolver$size$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return C07162.this.emit(null, (Continuation) this);
                    }
                }

                public C07162(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                coil3.size.Size m3232toCoilSizeOrNulluvyYCjk = UtilsKt.m3232toCoilSizeOrNulluvyYCjk(((Size) obj).unbox-impl());
                                if (m3232toCoilSizeOrNulluvyYCjk != null) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(m3232toCoilSizeOrNulluvyYCjk, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }
        }, continuation);
    }
}
