package androidx.compose.p001ui.prewarm;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.compose.p001ui.platform.GlobalSnapshotManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* compiled from: ComposePreWarm.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jb\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u001e\u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00190\u001f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00190\"2\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00190%¢\u0006\u0002\b&¢\u0006\u0002\u0010'Jl\u0010(\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020 2\u001e\u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00190\u001f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00190\"2\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00190%¢\u0006\u0002\b&H\u0002¢\u0006\u0002\u0010*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016¨\u0006+"}, d2 = {"Landroidx/compose/ui/prewarm/ComposePreWarm;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "SUCCESS", "", "HAS_COMPOSED", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "hasPreWarmed", "", "handlerThread", "Landroid/os/HandlerThread;", "getHandlerThread", "()Landroid/os/HandlerThread;", "handlerThread$delegate", "Lkotlin/Lazy;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "preWarn", "", "context", "Landroid/content/Context;", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Landroidx/compose/ui/prewarm/ComposePreWarmType;", "onFinish", "Lkotlin/Function3;", "", "onError", "Lkotlin/Function1;", "", StrategyConstants.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroid/content/Context;Landroidx/compose/ui/prewarm/ComposePreWarmType;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "doPreWarm", "ensureStartedTime", "(Landroid/content/Context;Landroidx/compose/ui/prewarm/ComposePreWarmType;JLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ComposePreWarm implements CoroutineScope {
    public static final int HAS_COMPOSED = 1;
    public static final int SUCCESS = 0;
    private static volatile boolean hasPreWarmed;
    public static final ComposePreWarm INSTANCE = new ComposePreWarm();
    private static final CoroutineContext coroutineContext = Dispatchers.getMain().getImmediate();

    /* renamed from: handlerThread$delegate, reason: from kotlin metadata */
    private static final Lazy handlerThread = LazyKt.lazy(new Function0<HandlerThread>() { // from class: androidx.compose.ui.prewarm.ComposePreWarm$handlerThread$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final HandlerThread m1837invoke() {
            HandlerThread handlerThread2 = new HandlerThread("Compose-PreWarm");
            handlerThread2.start();
            return handlerThread2;
        }
    });

    /* renamed from: handler$delegate, reason: from kotlin metadata */
    private static final Lazy handler = LazyKt.lazy(new Function0<Handler>() { // from class: androidx.compose.ui.prewarm.ComposePreWarm$handler$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m1836invoke() {
            return new Handler(ComposePreWarm.INSTANCE.getHandlerThread().getLooper());
        }
    });
    public static final int $stable = 8;

    private ComposePreWarm() {
    }

    public CoroutineContext getCoroutineContext() {
        return coroutineContext;
    }

    public final HandlerThread getHandlerThread() {
        return (HandlerThread) handlerThread.getValue();
    }

    public final Handler getHandler() {
        return (Handler) handler.getValue();
    }

    public final void preWarn(Context context, ComposePreWarmType type, Function3<? super Integer, ? super Long, ? super Long, Unit> onFinish, Function1<? super Throwable, Unit> onError, Function2<? super Composer, ? super Integer, Unit> content) {
        if (hasPreWarmed) {
            return;
        }
        hasPreWarmed = true;
        if (GlobalSnapshotManager.INSTANCE.hasStarted()) {
            onFinish.invoke(1, 0L, 0L);
        } else {
            BuildersKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new ComposePreWarm$preWarn$1(context, type, onFinish, onError, content, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doPreWarm(Context context, ComposePreWarmType type, long ensureStartedTime, Function3<? super Integer, ? super Long, ? super Long, Unit> onFinish, Function1<? super Throwable, Unit> onError, final Function2<? super Composer, ? super Integer, Unit> content) {
        Object obj;
        long currentTimeMillis = System.currentTimeMillis();
        PreWarmComposeView preWarmComposeView = new PreWarmComposeView(context.getApplicationContext(), null, 0, 6, null);
        preWarmComposeView.setContent((Function2) ComposableLambdaKt.composableLambdaInstance(1235018508, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.prewarm.ComposePreWarm$doPreWarm$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                invoke((Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C91@3310L9:ComposePreWarm.kt#v082fj");
                if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1235018508, i, -1, "androidx.compose.ui.prewarm.ComposePreWarm.doPreWarm.<anonymous>.<anonymous> (ComposePreWarm.kt:91)");
                }
                content.invoke(composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        try {
            Result.Companion companion = Result.Companion;
            preWarmComposeView.preWarm(type);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            onError.invoke(th2);
        }
        if (Result.isSuccess-impl(obj)) {
            onFinish.invoke(0, Long.valueOf(ensureStartedTime), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
    }
}
