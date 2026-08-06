package androidx.compose.p001ui.prewarm;

import android.content.Context;
import androidx.compose.p001ui.platform.GlobalSnapshotManager;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ComposePreWarm.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.prewarm.ComposePreWarm$preWarn$1", f = "ComposePreWarm.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class ComposePreWarm$preWarn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function1<Throwable, Unit> $onError;
    final /* synthetic */ Function3<Integer, Long, Long, Unit> $onFinish;
    final /* synthetic */ ComposePreWarmType $type;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ComposePreWarm$preWarn$1(Context context, ComposePreWarmType composePreWarmType, Function3<? super Integer, ? super Long, ? super Long, Unit> function3, Function1<? super Throwable, Unit> function1, Function2<? super Composer, ? super Integer, Unit> function2, Continuation<? super ComposePreWarm$preWarn$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$type = composePreWarmType;
        this.$onFinish = function3;
        this.$onError = function1;
        this.$content = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ComposePreWarm$preWarn$1(this.$context, this.$type, this.$onFinish, this.$onError, this.$content, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        long currentTimeMillis = System.currentTimeMillis();
        GlobalSnapshotManager.INSTANCE.ensureStarted();
        ComposePreWarm.INSTANCE.doPreWarm(this.$context, this.$type, System.currentTimeMillis() - currentTimeMillis, this.$onFinish, this.$onError, this.$content);
        return Unit.INSTANCE;
    }
}
