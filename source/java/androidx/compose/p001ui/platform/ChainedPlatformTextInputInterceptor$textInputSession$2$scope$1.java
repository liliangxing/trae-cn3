package androidx.compose.p001ui.platform;

import android.view.View;
import androidx.compose.ui.SessionMutex;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PlatformTextInputModifierNode.kt */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"androidx/compose/ui/platform/ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "startInputMethod", "", "request", "Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;", "(Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1 implements PlatformTextInputSessionScope {
    private final /* synthetic */ PlatformTextInputSessionScope $$delegate_0;
    final /* synthetic */ AtomicReference<SessionMutex.Session<T>> $inputMethodMutex;
    final /* synthetic */ PlatformTextInputSessionScope $parentSession;
    final /* synthetic */ ChainedPlatformTextInputInterceptor this$0;

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // androidx.compose.p001ui.platform.PlatformTextInputSession
    public View getView() {
        return this.$$delegate_0.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1(PlatformTextInputSessionScope platformTextInputSessionScope, AtomicReference<SessionMutex.Session<T>> atomicReference, ChainedPlatformTextInputInterceptor chainedPlatformTextInputInterceptor) {
        this.$parentSession = platformTextInputSessionScope;
        this.$inputMethodMutex = atomicReference;
        this.this$0 = chainedPlatformTextInputInterceptor;
        this.$$delegate_0 = platformTextInputSessionScope;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.p001ui.platform.PlatformTextInputSession
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object startInputMethod(PlatformTextInputMethodRequest platformTextInputMethodRequest, Continuation<?> continuation) {
        C0030x61f42b4d c0030x61f42b4d;
        int i;
        if (continuation instanceof C0030x61f42b4d) {
            c0030x61f42b4d = (C0030x61f42b4d) continuation;
            if ((c0030x61f42b4d.label & Integer.MIN_VALUE) != 0) {
                c0030x61f42b4d.label -= Integer.MIN_VALUE;
                Object obj = c0030x61f42b4d.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c0030x61f42b4d.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    AtomicReference<SessionMutex.Session<T>> atomicReference = this.$inputMethodMutex;
                    C0031x61f42b4e c0031x61f42b4e = new Function1<CoroutineScope, Unit>() { // from class: androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1$startInputMethod$2
                        public final void invoke(CoroutineScope coroutineScope) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            invoke((CoroutineScope) obj2);
                            return Unit.INSTANCE;
                        }
                    };
                    C0032x61f42b4f c0032x61f42b4f = new C0032x61f42b4f(this.this$0, platformTextInputMethodRequest, this.$parentSession, null);
                    c0030x61f42b4d.label = 1;
                    if (SessionMutex.withSessionCancellingPrevious-impl(atomicReference, c0031x61f42b4e, c0032x61f42b4f, c0030x61f42b4d) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }
        c0030x61f42b4d = new C0030x61f42b4d(this, continuation);
        Object obj2 = c0030x61f42b4d.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = c0030x61f42b4d.label;
        if (i != 0) {
        }
        throw new KotlinNothingValueException();
    }
}
