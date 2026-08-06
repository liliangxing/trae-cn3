package androidx.compose.p002ui.input.pointer;

import android.view.MotionEvent;
import androidx.autofill.HintConstants;
import androidx.compose.p002ui.ComposedModifierKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: PointerInteropFilter.android.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0000\u001a-\u0010\n\u001a\u00020\u0001*\u00020\u00012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u0005¨\u0006\u0010"}, d2 = {"pointerInteropFilter", "Landroidx/compose/ui/Modifier;", "requestDisallowInterceptTouchEvent", "Landroidx/compose/ui/input/pointer/RequestDisallowInterceptTouchEvent;", "onTouchEvent", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "", "view", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "motionEventSpy", "watcher", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "motionEvent", "", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class PointerInteropFilter_androidKt {
    public static /* synthetic */ Modifier pointerInteropFilter$default(Modifier modifier, RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            requestDisallowInterceptTouchEvent = null;
        }
        return pointerInteropFilter(modifier, requestDisallowInterceptTouchEvent, function1);
    }

    public static final Modifier pointerInteropFilter(Modifier modifier, final AndroidViewHolder androidViewHolder) {
        PointerInteropFilter pointerInteropFilter = new PointerInteropFilter();
        pointerInteropFilter.setOnTouchEvent(new Function1<MotionEvent, Boolean>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$pointerInteropFilter$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Boolean invoke(MotionEvent motionEvent) {
                boolean dispatchTouchEvent;
                switch (motionEvent.getActionMasked()) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        dispatchTouchEvent = androidViewHolder.dispatchTouchEvent(motionEvent);
                        break;
                    default:
                        dispatchTouchEvent = androidViewHolder.dispatchGenericMotionEvent(motionEvent);
                        break;
                }
                return Boolean.valueOf(dispatchTouchEvent);
            }
        });
        RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent = new RequestDisallowInterceptTouchEvent();
        pointerInteropFilter.setRequestDisallowInterceptTouchEvent(requestDisallowInterceptTouchEvent);
        androidViewHolder.setOnRequestDisallowInterceptTouchEvent$ui_release(requestDisallowInterceptTouchEvent);
        return modifier.then(pointerInteropFilter);
    }

    public static final Modifier motionEventSpy(Modifier modifier, final Function1<? super MotionEvent, Unit> function1) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, function1, new PointerInputEventHandler() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$motionEventSpy$1

            /* compiled from: PointerInteropFilter.android.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$motionEventSpy$1$1", f = "PointerInteropFilter.android.kt", i = {0}, l = {404}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
            /* renamed from: androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$motionEventSpy$1$1 */
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
            static final class C07681 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<MotionEvent, Unit> $watcher;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C07681(Function1<? super MotionEvent, Unit> function1, Continuation<? super C07681> continuation) {
                    super(2, continuation);
                    this.$watcher = function1;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    Continuation<Unit> c07681 = new C07681(this.$watcher, continuation);
                    c07681.L$0 = obj;
                    return c07681;
                }

                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0036 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0044  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0037 -> B:5:0x003c). Please report as a decompilation issue!!! */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    AwaitPointerEventScope awaitPointerEventScope;
                    C07681 c07681;
                    Object awaitPointerEvent;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        c07681 = this;
                        c07681.L$0 = awaitPointerEventScope;
                        c07681.label = 1;
                        awaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Initial, (Continuation) c07681);
                        if (awaitPointerEvent == coroutine_suspended) {
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        AwaitPointerEventScope awaitPointerEventScope3 = awaitPointerEventScope2;
                        Object obj2 = coroutine_suspended;
                        C07681 c076812 = this;
                        MotionEvent motionEvent = ((PointerEvent) obj).getMotionEvent();
                        if (motionEvent != null) {
                            c076812.$watcher.invoke(motionEvent);
                        }
                        c07681 = c076812;
                        coroutine_suspended = obj2;
                        awaitPointerEventScope = awaitPointerEventScope3;
                        c07681.L$0 = awaitPointerEventScope;
                        c07681.label = 1;
                        awaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Initial, (Continuation) c07681);
                        if (awaitPointerEvent == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj3 = coroutine_suspended;
                        c076812 = c07681;
                        obj = awaitPointerEvent;
                        awaitPointerEventScope3 = awaitPointerEventScope;
                        obj2 = obj3;
                        MotionEvent motionEvent2 = ((PointerEvent) obj).getMotionEvent();
                        if (motionEvent2 != null) {
                        }
                        c07681 = c076812;
                        coroutine_suspended = obj2;
                        awaitPointerEventScope = awaitPointerEventScope3;
                        c07681.L$0 = awaitPointerEventScope;
                        c07681.label = 1;
                        awaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Initial, (Continuation) c07681);
                        if (awaitPointerEvent == coroutine_suspended) {
                        }
                    }
                }
            }

            @Override // androidx.compose.p002ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                pointerInputScope.setInterceptOutOfBoundsChildEvents(true);
                Object awaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new C07681(function1, null), continuation);
                return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
            }
        });
    }

    public static final Modifier pointerInteropFilter(Modifier modifier, final RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent, final Function1<? super MotionEvent, Boolean> function1) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$pointerInteropFilter$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("pointerInteropFilter");
                inspectorInfo.getProperties().set("requestDisallowInterceptTouchEvent", RequestDisallowInterceptTouchEvent.this);
                inspectorInfo.getProperties().set("onTouchEvent", function1);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$pointerInteropFilter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceGroup(374375707);
                ComposerKt.sourceInformation(composer, "C79@3559L35:PointerInteropFilter.android.kt#a556rk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(374375707, i, -1, "androidx.compose.ui.input.pointer.pointerInteropFilter.<anonymous> (PointerInteropFilter.android.kt:79)");
                }
                ComposerKt.sourceInformationMarkerStart(composer, -1002197666, "CC(remember):PointerInteropFilter.android.kt#9igjgp");
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new PointerInteropFilter();
                    composer.updateRememberedValue(rememberedValue);
                }
                PointerInteropFilter pointerInteropFilter = (PointerInteropFilter) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                pointerInteropFilter.setOnTouchEvent(function1);
                pointerInteropFilter.setRequestDisallowInterceptTouchEvent(requestDisallowInterceptTouchEvent);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return pointerInteropFilter;
            }
        });
    }
}
