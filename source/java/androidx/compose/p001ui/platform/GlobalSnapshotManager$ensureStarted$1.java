package androidx.compose.p001ui.platform;

import androidx.compose.runtime.snapshots.Snapshot;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GlobalSnapshotManager.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1", f = "GlobalSnapshotManager.android.kt", i = {0}, l = {71}, m = "invokeSuspend", n = {"$this$consume$iv$iv"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class GlobalSnapshotManager$ensureStarted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Unit> $channel;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSnapshotManager$ensureStarted$1(Channel<Unit> channel, Continuation<? super GlobalSnapshotManager$ensureStarted$1> continuation) {
        super(2, continuation);
        this.$channel = channel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlobalSnapshotManager$ensureStarted$1(this.$channel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004c A[Catch: all -> 0x006d, TryCatch #2 {all -> 0x006d, blocks: (B:9:0x0044, B:11:0x004c, B:18:0x0064), top: B:8:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064 A[Catch: all -> 0x006d, TRY_LEAVE, TryCatch #2 {all -> 0x006d, blocks: (B:9:0x0044, B:11:0x004c, B:18:0x0064), top: B:8:0x0044 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x003e -> B:8:0x0044). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ReceiveChannel receiveChannel;
        ChannelIterator it;
        GlobalSnapshotManager$ensureStarted$1 globalSnapshotManager$ensureStarted$1;
        Object hasNext;
        AtomicBoolean atomicBoolean;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                receiveChannel = (ReceiveChannel) this.$channel;
                it = receiveChannel.iterator();
                globalSnapshotManager$ensureStarted$1 = this;
                globalSnapshotManager$ensureStarted$1.L$0 = receiveChannel;
                globalSnapshotManager$ensureStarted$1.L$1 = it;
                globalSnapshotManager$ensureStarted$1.label = 1;
                hasNext = it.hasNext(globalSnapshotManager$ensureStarted$1);
                if (hasNext != coroutine_suspended) {
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ChannelIterator channelIterator = (ChannelIterator) this.L$1;
                ReceiveChannel receiveChannel2 = (ReceiveChannel) this.L$0;
                ResultKt.throwOnFailure(obj);
                ReceiveChannel receiveChannel3 = receiveChannel2;
                ChannelIterator channelIterator2 = channelIterator;
                Object obj2 = coroutine_suspended;
                GlobalSnapshotManager$ensureStarted$1 globalSnapshotManager$ensureStarted$12 = this;
                try {
                    if (!((Boolean) obj).booleanValue()) {
                        atomicBoolean = GlobalSnapshotManager.sent;
                        atomicBoolean.set(false);
                        Snapshot.Companion.sendApplyNotifications();
                        globalSnapshotManager$ensureStarted$1 = globalSnapshotManager$ensureStarted$12;
                        coroutine_suspended = obj2;
                        it = channelIterator2;
                        receiveChannel = receiveChannel3;
                        globalSnapshotManager$ensureStarted$1.L$0 = receiveChannel;
                        globalSnapshotManager$ensureStarted$1.L$1 = it;
                        globalSnapshotManager$ensureStarted$1.label = 1;
                        hasNext = it.hasNext(globalSnapshotManager$ensureStarted$1);
                        if (hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj3 = coroutine_suspended;
                        globalSnapshotManager$ensureStarted$12 = globalSnapshotManager$ensureStarted$1;
                        obj = hasNext;
                        receiveChannel3 = receiveChannel;
                        channelIterator2 = it;
                        obj2 = obj3;
                        if (!((Boolean) obj).booleanValue()) {
                            Unit unit = Unit.INSTANCE;
                            ChannelsKt.cancelConsumed(receiveChannel3, (Throwable) null);
                            return Unit.INSTANCE;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    receiveChannel = receiveChannel3;
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        ChannelsKt.cancelConsumed(receiveChannel, th);
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
