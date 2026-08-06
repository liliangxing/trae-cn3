package androidx.compose.foundation.layout;

import android.view.WindowInsetsAnimationController;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WindowInsetsConnection.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2", f = "WindowInsetsConnection.android.kt", i = {}, l = {345}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class WindowInsetsNestedScrollConnection$fling$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WindowInsetsAnimationController $animationController;
    final /* synthetic */ int $current;
    final /* synthetic */ Ref.FloatRef $endVelocity;
    final /* synthetic */ float $flingAmount;
    final /* synthetic */ int $hidden;
    final /* synthetic */ int $shown;
    final /* synthetic */ SplineBasedFloatDecayAnimationSpec $spec;
    final /* synthetic */ boolean $targetShown;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WindowInsetsNestedScrollConnection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowInsetsNestedScrollConnection$fling$2(WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection, int i, float f, SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec, int i2, int i3, Ref.FloatRef floatRef, WindowInsetsAnimationController windowInsetsAnimationController, boolean z, Continuation<? super WindowInsetsNestedScrollConnection$fling$2> continuation) {
        super(2, continuation);
        this.this$0 = windowInsetsNestedScrollConnection;
        this.$current = i;
        this.$flingAmount = f;
        this.$spec = splineBasedFloatDecayAnimationSpec;
        this.$hidden = i2;
        this.$shown = i3;
        this.$endVelocity = floatRef;
        this.$animationController = windowInsetsAnimationController;
        this.$targetShown = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> windowInsetsNestedScrollConnection$fling$2 = new WindowInsetsNestedScrollConnection$fling$2(this.this$0, this.$current, this.$flingAmount, this.$spec, this.$hidden, this.$shown, this.$endVelocity, this.$animationController, this.$targetShown, continuation);
        windowInsetsNestedScrollConnection$fling$2.L$0 = obj;
        return windowInsetsNestedScrollConnection$fling$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WindowInsetsConnection.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2$1", f = "WindowInsetsConnection.android.kt", i = {}, l = {329}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class C02991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ WindowInsetsAnimationController $animationController;
        final /* synthetic */ int $current;
        final /* synthetic */ Ref.FloatRef $endVelocity;
        final /* synthetic */ float $flingAmount;
        final /* synthetic */ int $hidden;
        final /* synthetic */ int $shown;
        final /* synthetic */ SplineBasedFloatDecayAnimationSpec $spec;
        final /* synthetic */ boolean $targetShown;
        int label;
        final /* synthetic */ WindowInsetsNestedScrollConnection this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02991(int i, float f, SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec, int i2, int i3, WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection, Ref.FloatRef floatRef, WindowInsetsAnimationController windowInsetsAnimationController, boolean z, Continuation<? super C02991> continuation) {
            super(2, continuation);
            this.$current = i;
            this.$flingAmount = f;
            this.$spec = splineBasedFloatDecayAnimationSpec;
            this.$hidden = i2;
            this.$shown = i3;
            this.this$0 = windowInsetsNestedScrollConnection;
            this.$endVelocity = floatRef;
            this.$animationController = windowInsetsAnimationController;
            this.$targetShown = z;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C02991(this.$current, this.$flingAmount, this.$spec, this.$hidden, this.$shown, this.this$0, this.$endVelocity, this.$animationController, this.$targetShown, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                float f = this.$current;
                float f2 = this.$flingAmount;
                SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec = this.$spec;
                final int i2 = this.$hidden;
                final int i3 = this.$shown;
                final WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection = this.this$0;
                final Ref.FloatRef floatRef = this.$endVelocity;
                final WindowInsetsAnimationController windowInsetsAnimationController = this.$animationController;
                final boolean z = this.$targetShown;
                this.label = 1;
                if (SuspendAnimationKt.animateDecay(f, f2, splineBasedFloatDecayAnimationSpec, (Function2<? super Float, ? super Float, Unit>) new Function2() { // from class: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = WindowInsetsNestedScrollConnection$fling$2.C02991.invokeSuspend$lambda$0(i2, i3, windowInsetsNestedScrollConnection, floatRef, windowInsetsAnimationController, z, ((Float) obj2).floatValue(), ((Float) obj3).floatValue());
                        return invokeSuspend$lambda$0;
                    }
                }, (Continuation<? super Unit>) this) == coroutine_suspended) {
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
        public static final Unit invokeSuspend$lambda$0(int i, int i2, WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection, Ref.FloatRef floatRef, WindowInsetsAnimationController windowInsetsAnimationController, boolean z, float f, float f2) {
            Job job;
            float f3 = i;
            boolean z2 = false;
            if (f <= i2 && f3 <= f) {
                z2 = true;
            }
            if (z2) {
                windowInsetsNestedScrollConnection.adjustInsets(f);
            } else {
                floatRef.element = f2;
                windowInsetsAnimationController.finish(z);
                windowInsetsNestedScrollConnection.animationController = null;
                job = windowInsetsNestedScrollConnection.animationJob;
                if (job != null) {
                    job.cancel(new WindowInsetsAnimationCancelledException());
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object obj) {
        Job job;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            this.this$0.animationJob = BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C02991(this.$current, this.$flingAmount, this.$spec, this.$hidden, this.$shown, this.this$0, this.$endVelocity, this.$animationController, this.$targetShown, null), 3, (Object) null);
            job = this.this$0.animationJob;
            if (job != null) {
                this.label = 1;
                if (job.join((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.animationJob = null;
        return Unit.INSTANCE;
    }
}
