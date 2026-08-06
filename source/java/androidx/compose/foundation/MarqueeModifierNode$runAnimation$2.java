package androidx.compose.foundation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BasicMarquee.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.MarqueeModifierNode$runAnimation$2", f = "BasicMarquee.kt", i = {}, l = {402}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class MarqueeModifierNode$runAnimation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MarqueeModifierNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeModifierNode$runAnimation$2(MarqueeModifierNode marqueeModifierNode, Continuation<? super MarqueeModifierNode$runAnimation$2> continuation) {
        super(2, continuation);
        this.this$0 = marqueeModifierNode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MarqueeModifierNode$runAnimation$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final MarqueeModifierNode marqueeModifierNode = this.this$0;
            this.label = 1;
            if (FlowKt.collectLatest(SnapshotStateKt.snapshotFlow(new Function0() { // from class: androidx.compose.foundation.MarqueeModifierNode$runAnimation$2$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Float invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = MarqueeModifierNode$runAnimation$2.invokeSuspend$lambda$0(MarqueeModifierNode.this);
                    return invokeSuspend$lambda$0;
                }
            }), new C02372(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Float invokeSuspend$lambda$0(MarqueeModifierNode marqueeModifierNode) {
        int contentWidth;
        int containerWidth;
        int contentWidth2;
        int spacingPx;
        boolean hasFocus;
        contentWidth = marqueeModifierNode.getContentWidth();
        containerWidth = marqueeModifierNode.getContainerWidth();
        if (contentWidth <= containerWidth) {
            return null;
        }
        if (MarqueeAnimationMode.m491equalsimpl0(marqueeModifierNode.m505getAnimationModeZbEOnfQ(), MarqueeAnimationMode.INSTANCE.m496getWhileFocusedZbEOnfQ())) {
            hasFocus = marqueeModifierNode.getHasFocus();
            if (!hasFocus) {
                return null;
            }
        }
        contentWidth2 = marqueeModifierNode.getContentWidth();
        spacingPx = marqueeModifierNode.getSpacingPx();
        return Float.valueOf(contentWidth2 + spacingPx);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BasicMarquee.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "contentWithSpacingWidth", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.MarqueeModifierNode$runAnimation$2$2", f = "BasicMarquee.kt", i = {0, 0}, l = {416, 418, 422, 422}, m = "invokeSuspend", n = {"contentWithSpacingWidth", "spec"}, s = {"L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.MarqueeModifierNode$runAnimation$2$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class C02372 extends SuspendLambda implements Function2<Float, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MarqueeModifierNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02372(MarqueeModifierNode marqueeModifierNode, Continuation<? super C02372> continuation) {
            super(2, continuation);
            this.this$0 = marqueeModifierNode;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c02372 = new C02372(this.this$0, continuation);
            c02372.L$0 = obj;
            return c02372;
        }

        public final Object invoke(Float f, Continuation<? super Unit> continuation) {
            return create(f, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x00c9 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Animatable animatable;
            int i;
            int i2;
            int i3;
            float f;
            AnimationSpec m405createMarqueeAnimationSpecZ4HSEVQ;
            Animatable animatable2;
            Float f2;
            AnimationSpec animationSpec;
            Animatable animatable3;
            Object animateTo$default;
            Animatable animatable4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            try {
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Float f3 = (Float) this.L$0;
                    if (f3 != null) {
                        i = this.this$0.iterations;
                        float floatValue = f3.floatValue();
                        i2 = this.this$0.initialDelayMillis;
                        i3 = this.this$0.delayMillis;
                        f = this.this$0.velocity;
                        m405createMarqueeAnimationSpecZ4HSEVQ = BasicMarqueeKt.m405createMarqueeAnimationSpecZ4HSEVQ(i, floatValue, i2, i3, f, DelegatableNodeKt.requireDensity(this.this$0));
                        animatable2 = this.this$0.offset;
                        this.L$0 = f3;
                        this.L$1 = m405createMarqueeAnimationSpecZ4HSEVQ;
                        this.label = 1;
                        if (animatable2.snapTo(Boxing.boxFloat(0.0f), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        f2 = f3;
                        animationSpec = m405createMarqueeAnimationSpecZ4HSEVQ;
                    } else {
                        return Unit.INSTANCE;
                    }
                } else {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 == 3) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            if (i4 != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            Throwable th = (Throwable) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            throw th;
                        }
                        ResultKt.throwOnFailure(obj);
                        animateTo$default = obj;
                        animatable4 = this.this$0.offset;
                        this.label = 3;
                        if (animatable4.snapTo(Boxing.boxFloat(0.0f), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    AnimationSpec animationSpec2 = (AnimationSpec) this.L$1;
                    Float f4 = (Float) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    animationSpec = animationSpec2;
                    f2 = f4;
                }
                animatable3 = this.this$0.offset;
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                animateTo$default = Animatable.animateTo$default(animatable3, f2, animationSpec, null, null, (Continuation) this, 12, null);
                if (animateTo$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                animatable4 = this.this$0.offset;
                this.label = 3;
                if (animatable4.snapTo(Boxing.boxFloat(0.0f), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                animatable = this.this$0.offset;
                this.L$0 = th2;
                this.L$1 = null;
                this.label = 4;
                if (animatable.snapTo(Boxing.boxFloat(0.0f), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                throw th2;
            }
        }
    }
}
