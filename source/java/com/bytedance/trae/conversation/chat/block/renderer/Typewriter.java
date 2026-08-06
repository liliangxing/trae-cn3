package com.bytedance.trae.conversation.chat.block.renderer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: Typewriter.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"BQ\u00126\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0011H\u0002J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020!H\u0002R>\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;", "", "onTick", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "displayText", "", "finished", "", "onContentChanged", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "fullText", "current", "", "end", "remainingBytes", "job", "Lkotlinx/coroutines/Job;", "cancelled", "feed", "text", "cancel", "loop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "advanceCursor", "utf8ByteSize", "c", "", "computeDelay", "", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class Typewriter {
    private static final int ACCEL_THRESHOLD = 80;
    private static final int BYTE_COUNT_PER_TICK = 6;
    private static final int DECEL_THRESHOLD = 20;
    private static final long DEFAULT_DELAY_MS = 25;
    private static final long FAST_DELAY_MS = 15;
    private static final long SLOW_DELAY_MS = 40;
    private static final CoroutineScope scope;
    private static final ExecutorService singleThread;
    private volatile boolean cancelled;
    private int current;
    private int end;
    private String fullText;
    private Job job;
    private final Function0<Unit> onContentChanged;
    private final Function2<String, Boolean, Unit> onTick;
    private int remainingBytes;

    private final int utf8ByteSize(char c) {
        if (c <= 127) {
            return 1;
        }
        if (c > 2047) {
            if (!(55296 <= c && c < 57344)) {
                return 3;
            }
        }
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Typewriter(Function2<? super String, ? super Boolean, Unit> function2, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function2, "onTick");
        this.onTick = function2;
        this.onContentChanged = function0;
        this.fullText = "";
    }

    public /* synthetic */ Typewriter(Function2 function2, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2, (i & 2) != 0 ? null : function0);
    }

    public final void feed(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new Typewriter$feed$1(this, text, null), 3, (Object) null);
    }

    public final void cancel() {
        this.cancelled = true;
        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new Typewriter$cancel$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0096 -> B:11:0x0030). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loop(Continuation<? super Unit> continuation) {
        Typewriter$loop$1 typewriter$loop$1;
        int i;
        Typewriter typewriter;
        Typewriter typewriter2;
        long computeDelay;
        if (continuation instanceof Typewriter$loop$1) {
            typewriter$loop$1 = (Typewriter$loop$1) continuation;
            if ((typewriter$loop$1.label & Integer.MIN_VALUE) != 0) {
                typewriter$loop$1.label -= Integer.MIN_VALUE;
                Object obj = typewriter$loop$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = typewriter$loop$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    typewriter = this;
                    if (typewriter.current >= typewriter.end) {
                    }
                } else if (i == 1) {
                    typewriter2 = (Typewriter) typewriter$loop$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    computeDelay = typewriter2.computeDelay();
                    typewriter$loop$1.L$0 = typewriter2;
                    typewriter$loop$1.label = 2;
                    if (DelayKt.delay(computeDelay, typewriter$loop$1) == coroutine_suspended) {
                    }
                    typewriter = typewriter2;
                    if (typewriter.current >= typewriter.end) {
                    }
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    typewriter2 = (Typewriter) typewriter$loop$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    typewriter = typewriter2;
                    if (typewriter.current >= typewriter.end) {
                        typewriter.remainingBytes = RangesKt.coerceAtLeast(typewriter.remainingBytes - typewriter.advanceCursor(), 0);
                        String str = typewriter.fullText;
                        String substring = str.substring(0, RangesKt.coerceAtMost(typewriter.current, str.length()));
                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                        CoroutineContext main = Dispatchers.getMain();
                        Typewriter$loop$2 typewriter$loop$2 = new Typewriter$loop$2(typewriter, substring, null);
                        typewriter$loop$1.L$0 = typewriter;
                        typewriter$loop$1.label = 1;
                        if (BuildersKt.withContext(main, typewriter$loop$2, typewriter$loop$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        typewriter2 = typewriter;
                        computeDelay = typewriter2.computeDelay();
                        typewriter$loop$1.L$0 = typewriter2;
                        typewriter$loop$1.label = 2;
                        if (DelayKt.delay(computeDelay, typewriter$loop$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        typewriter = typewriter2;
                        if (typewriter.current >= typewriter.end) {
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
        }
        typewriter$loop$1 = new Typewriter$loop$1(this, continuation);
        Object obj2 = typewriter$loop$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = typewriter$loop$1.label;
        if (i != 0) {
        }
    }

    private final int advanceCursor() {
        int i = this.current;
        String str = this.fullText;
        int coerceAtMost = RangesKt.coerceAtMost(this.end, str.length());
        int i2 = 0;
        while (i < coerceAtMost) {
            i2 += utf8ByteSize(str.charAt(i));
            i++;
            if (i2 >= 6) {
                break;
            }
        }
        this.current = i;
        return i2;
    }

    private final long computeDelay() {
        int i = this.remainingBytes / 3;
        return i > 80 ? FAST_DELAY_MS : i < 20 ? SLOW_DELAY_MS : DEFAULT_DELAY_MS;
    }

    static {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.bytedance.trae.conversation.chat.block.renderer.Typewriter$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread singleThread$lambda$1;
                singleThread$lambda$1 = Typewriter.singleThread$lambda$1(runnable);
                return singleThread$lambda$1;
            }
        });
        singleThread = newSingleThreadExecutor;
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "singleThread");
        scope = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(newSingleThreadExecutor).plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread singleThread$lambda$1(Runnable runnable) {
        Thread thread = new Thread(runnable, "trae-typewriter");
        thread.setDaemon(true);
        return thread;
    }
}
