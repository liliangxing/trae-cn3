package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.TransformEvent;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Transformable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$detectZoomByCtrlMouseScroll$2", f = "Transformable.kt", i = {0, 1}, l = {272, 284}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope"}, s = {"L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TransformableKt$detectZoomByCtrlMouseScroll$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<TransformEvent> $channel;
    final /* synthetic */ CoroutineContext $currentContext;
    final /* synthetic */ ScrollConfig $scrollConfig;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransformableKt$detectZoomByCtrlMouseScroll$2(CoroutineContext coroutineContext, ScrollConfig scrollConfig, Channel<TransformEvent> channel, Continuation<? super TransformableKt$detectZoomByCtrlMouseScroll$2> continuation) {
        super(2, continuation);
        this.$currentContext = coroutineContext;
        this.$scrollConfig = scrollConfig;
        this.$channel = channel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> transformableKt$detectZoomByCtrlMouseScroll$2 = new TransformableKt$detectZoomByCtrlMouseScroll$2(this.$currentContext, this.$scrollConfig, this.$channel, continuation);
        transformableKt$detectZoomByCtrlMouseScroll$2.L$0 = obj;
        return transformableKt$detectZoomByCtrlMouseScroll$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa A[Catch: all -> 0x00be, TRY_LEAVE, TryCatch #2 {all -> 0x00be, blocks: (B:20:0x00a6, B:22:0x00aa, B:11:0x0057), top: B:19:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0042 A[Catch: all -> 0x00c0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00c0, blocks: (B:15:0x006d, B:6:0x0042), top: B:14:0x006d }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00aa -> B:12:0x00ae). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00b2 -> B:4:0x003a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        TransformableKt$detectZoomByCtrlMouseScroll$2 transformableKt$detectZoomByCtrlMouseScroll$2;
        AwaitPointerEventScope awaitPointerEventScope;
        Object obj2;
        TransformableKt$detectZoomByCtrlMouseScroll$2 transformableKt$detectZoomByCtrlMouseScroll$22;
        AwaitPointerEventScope awaitPointerEventScope2;
        long m4603unboximpl;
        TransformableKt$detectZoomByCtrlMouseScroll$2 transformableKt$detectZoomByCtrlMouseScroll$23;
        Object obj3;
        Object awaitCtrlMouseScrollOrNull;
        Object awaitFirstCtrlMouseScroll;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            try {
                if (i == 1) {
                    AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope = awaitPointerEventScope3;
                    obj2 = coroutine_suspended;
                    transformableKt$detectZoomByCtrlMouseScroll$2 = this;
                    m4603unboximpl = ((Offset) obj).m4603unboximpl();
                    transformableKt$detectZoomByCtrlMouseScroll$2.$channel.trySend-JP2dKIU(TransformEvent.TransformStarted.INSTANCE);
                    transformableKt$detectZoomByCtrlMouseScroll$23 = transformableKt$detectZoomByCtrlMouseScroll$2;
                    obj3 = obj2;
                    AwaitPointerEventScope awaitPointerEventScope4 = awaitPointerEventScope;
                    transformableKt$detectZoomByCtrlMouseScroll$23.$channel.trySend-JP2dKIU(new TransformEvent.TransformDelta((float) Math.pow(2.0f, Float.intBitsToFloat((int) (m4603unboximpl & 4294967295L)) / 545.0f), Offset.INSTANCE.m4609getZeroF1C5BW0(), 0.0f, null));
                    transformableKt$detectZoomByCtrlMouseScroll$23.L$0 = awaitPointerEventScope4;
                    transformableKt$detectZoomByCtrlMouseScroll$23.label = 2;
                    awaitCtrlMouseScrollOrNull = TransformableKt.awaitCtrlMouseScrollOrNull(awaitPointerEventScope4, transformableKt$detectZoomByCtrlMouseScroll$23.$scrollConfig, (Continuation) transformableKt$detectZoomByCtrlMouseScroll$23);
                    if (awaitCtrlMouseScrollOrNull == obj3) {
                    }
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope = awaitPointerEventScope5;
                    obj2 = coroutine_suspended;
                    transformableKt$detectZoomByCtrlMouseScroll$2 = this;
                    try {
                        Offset offset = (Offset) obj;
                        if (offset == null) {
                            try {
                                m4603unboximpl = offset.m4603unboximpl();
                                transformableKt$detectZoomByCtrlMouseScroll$23 = transformableKt$detectZoomByCtrlMouseScroll$2;
                                obj3 = obj2;
                                AwaitPointerEventScope awaitPointerEventScope42 = awaitPointerEventScope;
                                transformableKt$detectZoomByCtrlMouseScroll$23.$channel.trySend-JP2dKIU(new TransformEvent.TransformDelta((float) Math.pow(2.0f, Float.intBitsToFloat((int) (m4603unboximpl & 4294967295L)) / 545.0f), Offset.INSTANCE.m4609getZeroF1C5BW0(), 0.0f, null));
                                transformableKt$detectZoomByCtrlMouseScroll$23.L$0 = awaitPointerEventScope42;
                                transformableKt$detectZoomByCtrlMouseScroll$23.label = 2;
                                awaitCtrlMouseScrollOrNull = TransformableKt.awaitCtrlMouseScrollOrNull(awaitPointerEventScope42, transformableKt$detectZoomByCtrlMouseScroll$23.$scrollConfig, (Continuation) transformableKt$detectZoomByCtrlMouseScroll$23);
                                if (awaitCtrlMouseScrollOrNull == obj3) {
                                    return obj3;
                                }
                                transformableKt$detectZoomByCtrlMouseScroll$2 = transformableKt$detectZoomByCtrlMouseScroll$23;
                                obj = awaitCtrlMouseScrollOrNull;
                                awaitPointerEventScope = awaitPointerEventScope42;
                                obj2 = obj3;
                                Offset offset2 = (Offset) obj;
                                if (offset2 == null) {
                                    transformableKt$detectZoomByCtrlMouseScroll$2.$channel.trySend-JP2dKIU(TransformEvent.TransformStopped.INSTANCE);
                                    transformableKt$detectZoomByCtrlMouseScroll$22 = transformableKt$detectZoomByCtrlMouseScroll$2;
                                    coroutine_suspended = obj2;
                                    awaitPointerEventScope2 = awaitPointerEventScope;
                                    if (!JobKt.isActive(transformableKt$detectZoomByCtrlMouseScroll$22.$currentContext)) {
                                        transformableKt$detectZoomByCtrlMouseScroll$22.L$0 = awaitPointerEventScope2;
                                        transformableKt$detectZoomByCtrlMouseScroll$22.label = 1;
                                        awaitFirstCtrlMouseScroll = TransformableKt.awaitFirstCtrlMouseScroll(awaitPointerEventScope2, transformableKt$detectZoomByCtrlMouseScroll$22.$scrollConfig, (Continuation) transformableKt$detectZoomByCtrlMouseScroll$22);
                                        if (awaitFirstCtrlMouseScroll == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        Object obj4 = coroutine_suspended;
                                        transformableKt$detectZoomByCtrlMouseScroll$2 = transformableKt$detectZoomByCtrlMouseScroll$22;
                                        obj = awaitFirstCtrlMouseScroll;
                                        awaitPointerEventScope = awaitPointerEventScope2;
                                        obj2 = obj4;
                                        m4603unboximpl = ((Offset) obj).m4603unboximpl();
                                        transformableKt$detectZoomByCtrlMouseScroll$2.$channel.trySend-JP2dKIU(TransformEvent.TransformStarted.INSTANCE);
                                        transformableKt$detectZoomByCtrlMouseScroll$23 = transformableKt$detectZoomByCtrlMouseScroll$2;
                                        obj3 = obj2;
                                        AwaitPointerEventScope awaitPointerEventScope422 = awaitPointerEventScope;
                                        transformableKt$detectZoomByCtrlMouseScroll$23.$channel.trySend-JP2dKIU(new TransformEvent.TransformDelta((float) Math.pow(2.0f, Float.intBitsToFloat((int) (m4603unboximpl & 4294967295L)) / 545.0f), Offset.INSTANCE.m4609getZeroF1C5BW0(), 0.0f, null));
                                        transformableKt$detectZoomByCtrlMouseScroll$23.L$0 = awaitPointerEventScope422;
                                        transformableKt$detectZoomByCtrlMouseScroll$23.label = 2;
                                        awaitCtrlMouseScrollOrNull = TransformableKt.awaitCtrlMouseScrollOrNull(awaitPointerEventScope422, transformableKt$detectZoomByCtrlMouseScroll$23.$scrollConfig, (Continuation) transformableKt$detectZoomByCtrlMouseScroll$23);
                                        if (awaitCtrlMouseScrollOrNull == obj3) {
                                        }
                                    } else {
                                        return Unit.INSTANCE;
                                    }
                                }
                            } catch (Throwable th) {
                                transformableKt$detectZoomByCtrlMouseScroll$2 = transformableKt$detectZoomByCtrlMouseScroll$23;
                                th = th;
                                transformableKt$detectZoomByCtrlMouseScroll$2.$channel.trySend-JP2dKIU(TransformEvent.TransformStopped.INSTANCE);
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        transformableKt$detectZoomByCtrlMouseScroll$2.$channel.trySend-JP2dKIU(TransformEvent.TransformStopped.INSTANCE);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                transformableKt$detectZoomByCtrlMouseScroll$2 = this;
                transformableKt$detectZoomByCtrlMouseScroll$2.$channel.trySend-JP2dKIU(TransformEvent.TransformStopped.INSTANCE);
                throw th;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
            transformableKt$detectZoomByCtrlMouseScroll$22 = this;
            if (!JobKt.isActive(transformableKt$detectZoomByCtrlMouseScroll$22.$currentContext)) {
            }
        }
    }
}
