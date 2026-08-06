package com.bytedance.salamander.adapter;

import android.os.Looper;
import com.bytedance.ies.bullet.lynx.DefaultLynxParams;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.lynx.service.image.LynxImageService;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: thread.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0006\u0010\n\u001a\u00020\t\u001a\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t\u001a=\u0010\f\u001a\u00020\r2%\u0010\u000e\u001a!\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\r0\u000fj\u0002`\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0015\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"handlerCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/salamander/adapter/QueueAdapter;", "createQosHandler", "name", LynxImageService.PRIORITY_KEY, "", "serial", "", "isMainThreadImpl", "queue", "runOnThreadImpl", "", "workload", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "isCancelled", "Lcom/bytedance/salamander/adapter/Workload;", "after", "", "Lcom/bytedance/salamander/adapter/Queue;", "runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ThreadKt {
    private static final ConcurrentHashMap<String, QueueAdapter> handlerCache = new ConcurrentHashMap<>();

    public static /* synthetic */ QueueAdapter queue$default(String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return queue(str, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final QueueAdapter queue(String str, boolean z) {
        ConcurrentQueueAdapter concurrentQueueAdapter;
        Intrinsics.checkNotNullParameter(str, "name");
        ConcurrentHashMap<String, QueueAdapter> concurrentHashMap = handlerCache;
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        QueueAdapter queueAdapter = concurrentHashMap.get(lowerCase);
        if (queueAdapter == null) {
            String lowerCase2 = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            switch (lowerCase2.hashCode()) {
                case -1332194002:
                    if (lowerCase2.equals("background")) {
                        concurrentQueueAdapter = createQosHandler(str, 10, z);
                        break;
                    }
                    if (!z) {
                        concurrentQueueAdapter = new ConcurrentQueueAdapter(str, 0, 2, null);
                        break;
                    } else {
                        concurrentQueueAdapter = new SerialQueueAdapter(str, 0, 2, null);
                        break;
                    }
                case -288953984:
                    if (lowerCase2.equals("userinitiated")) {
                        concurrentQueueAdapter = createQosHandler(str, -4, z);
                        break;
                    }
                    if (!z) {
                    }
                    break;
                case -114978452:
                    if (lowerCase2.equals("utility")) {
                        concurrentQueueAdapter = createQosHandler(str, 19, z);
                        break;
                    }
                    if (!z) {
                    }
                    break;
                case 3343801:
                    if (lowerCase2.equals("main")) {
                        concurrentQueueAdapter = new MainQueueAdapter();
                        break;
                    }
                    if (!z) {
                    }
                    break;
                case 1544803905:
                    if (lowerCase2.equals(DefaultLynxParams.DEFAULT_LYNX_GROUP_NAME)) {
                        concurrentQueueAdapter = createQosHandler(str, 0, z);
                        break;
                    }
                    if (!z) {
                    }
                    break;
                case 2090935863:
                    if (lowerCase2.equals("userinteractive")) {
                        concurrentQueueAdapter = createQosHandler(str, -8, z);
                        break;
                    }
                    if (!z) {
                    }
                    break;
                default:
                    if (!z) {
                    }
                    break;
            }
            QueueAdapter putIfAbsent = concurrentHashMap.putIfAbsent(lowerCase, concurrentQueueAdapter);
            queueAdapter = putIfAbsent == null ? concurrentQueueAdapter : putIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(queueAdapter, "handlerCache.getOrPut(na…ter(name)\n        }\n    }");
        return queueAdapter;
    }

    private static final QueueAdapter createQosHandler(String str, int i, boolean z) {
        if (z) {
            return new SerialQueueAdapter(str, i);
        }
        return new ConcurrentQueueAdapter(str, i);
    }

    public static final void runOnThreadImpl(final Function1<? super Boolean, Unit> function1, double d, Queue queue) {
        Intrinsics.checkNotNullParameter(function1, "workload");
        Intrinsics.checkNotNullParameter(queue, "queue");
        Object ref = queue.getRef();
        QueueAdapter queueAdapter = ref instanceof QueueAdapter ? (QueueAdapter) ref : null;
        if (queueAdapter == null) {
            System.out.println((Object) ("Queue.ref must be Handler for " + queue.getName()));
            return;
        }
        long coerceAtLeast = RangesKt.coerceAtLeast((long) (d * BytePatchException.ErrorCode.paramsError), 0L);
        Runnable runnable = new Runnable() { // from class: com.bytedance.salamander.adapter.ThreadKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ThreadKt.runOnThreadImpl$lambda$2(function1);
            }
        };
        if (coerceAtLeast > 0) {
            queueAdapter.postDelayed(runnable, coerceAtLeast);
        } else {
            queueAdapter.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runOnThreadImpl$lambda$2(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "$workload");
        function1.invoke(false);
    }

    public static final boolean isMainThreadImpl() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
