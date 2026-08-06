package com.bytedance.kmp.network.websocket;

import com.bytedance.kmp.network.util.NLog;
import com.example.interopdemo.NativeTTNetworkClient;
import com.example.interopdemo.websocket.NativeRawWsClient;
import com.example.interopdemo.websocket.NativeRawWsInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: NativeRawWsService.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/kmp/network/websocket/NativeRawWsService;", "Lcom/bytedance/kmp/network/websocket/IRawWsService;", "()V", "idGenerator", "Lkotlinx/atomicfu/AtomicInt;", "kmpRequestMap", "", "", "Lcom/example/interopdemo/websocket/NativeRawWsClient;", "mapMutex", "Lkotlinx/coroutines/sync/Mutex;", "isConnected", "", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "info", "Lcom/bytedance/kmp/network/websocket/RawWebsocketInfo;", "listener", "Lcom/bytedance/kmp/network/websocket/IRawWsEventListener;", "(Lcom/bytedance/kmp/network/websocket/RawWebsocketInfo;Lcom/bytedance/kmp/network/websocket/IRawWsEventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMsg", "msg", "Lcom/bytedance/kmp/network/websocket/RawWebsocketlMsg;", "(ILcom/bytedance/kmp/network/websocket/RawWebsocketlMsg;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startConnection", "stopConnection", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class NativeRawWsService implements IRawWsService {
    private final Mutex mapMutex = MutexKt.Mutex$default(false, 1, (Object) null);
    private final Map<Integer, NativeRawWsClient> kmpRequestMap = new LinkedHashMap();
    private AtomicInt idGenerator = AtomicFU.atomic(0);

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(5:(2:3|(8:5|6|7|(1:(1:(1:(6:12|13|14|15|16|17)(2:23|24))(4:25|26|27|28))(3:30|31|32))(3:56|57|(1:59)(1:60))|33|34|35|(1:37)(3:38|27|28)))|33|34|35|(0)(0))|63|6|7|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00eb, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ec, code lost:
    
        r11 = r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00dd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22, types: [kotlin.jvm.internal.Ref$IntRef] */
    /* JADX WARN: Type inference failed for: r4v27 */
    @Override // com.bytedance.kmp.network.websocket.IRawWsService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object register(RawWebsocketInfo rawWebsocketInfo, IRawWsEventListener iRawWsEventListener, Continuation<? super Integer> continuation) {
        NativeRawWsService$register$1 nativeRawWsService$register$1;
        Object coroutine_suspended;
        ?? r4;
        Ref.IntRef intRef;
        Mutex mutex;
        Ref.IntRef intRef2;
        Ref.IntRef intRef3;
        NativeRawWsClient wsClient;
        IRawWsEventListener iRawWsEventListener2;
        Mutex mutex2;
        RawWebsocketInfo rawWebsocketInfo2;
        NativeRawWsInfo nativeRawWsInfo;
        NativeRawListenerImpl nativeRawListenerImpl;
        try {
            if (continuation instanceof NativeRawWsService$register$1) {
                nativeRawWsService$register$1 = (NativeRawWsService$register$1) continuation;
                if ((nativeRawWsService$register$1.label & Integer.MIN_VALUE) != 0) {
                    nativeRawWsService$register$1.label -= Integer.MIN_VALUE;
                    Object obj = nativeRawWsService$register$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    r4 = nativeRawWsService$register$1.label;
                    if (r4 != 0) {
                        ResultKt.throwOnFailure(obj);
                        intRef3 = new Ref.IntRef();
                        intRef3.element = -1;
                        wsClient = NativeTTNetworkClient.INSTANCE.getWsClient();
                        Mutex mutex3 = this.mapMutex;
                        nativeRawWsService$register$1.L$0 = rawWebsocketInfo;
                        iRawWsEventListener2 = iRawWsEventListener;
                        nativeRawWsService$register$1.L$1 = iRawWsEventListener2;
                        nativeRawWsService$register$1.L$2 = intRef3;
                        nativeRawWsService$register$1.L$3 = wsClient;
                        nativeRawWsService$register$1.L$4 = mutex3;
                        nativeRawWsService$register$1.L$5 = intRef3;
                        nativeRawWsService$register$1.label = 1;
                        if (mutex3.lock((Object) null, nativeRawWsService$register$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        mutex2 = mutex3;
                        rawWebsocketInfo2 = rawWebsocketInfo;
                        intRef = intRef3;
                    } else {
                        if (r4 != 1) {
                            if (r4 == 2) {
                                Ref.IntRef intRef4 = (Ref.IntRef) nativeRawWsService$register$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                r4 = intRef4;
                                return Boxing.boxInt(((Ref.IntRef) r4).element);
                            }
                            if (r4 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            mutex = (Mutex) nativeRawWsService$register$1.L$1;
                            intRef2 = (Ref.IntRef) nativeRawWsService$register$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            try {
                                this.kmpRequestMap.remove(Boxing.boxInt(intRef2.element));
                                return Boxing.boxInt(-1);
                            } finally {
                            }
                        }
                        intRef3 = (Ref.IntRef) nativeRawWsService$register$1.L$5;
                        mutex2 = (Mutex) nativeRawWsService$register$1.L$4;
                        wsClient = (NativeRawWsClient) nativeRawWsService$register$1.L$3;
                        intRef = (Ref.IntRef) nativeRawWsService$register$1.L$2;
                        iRawWsEventListener2 = (IRawWsEventListener) nativeRawWsService$register$1.L$1;
                        rawWebsocketInfo2 = (RawWebsocketInfo) nativeRawWsService$register$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Exception e) {
                            e = e;
                            NLog nLog = NLog.INSTANCE;
                            NLog.Level level = NLog.Level.ERROR;
                            if (level.compareTo(nLog.getLevel()) >= 0) {
                                String obj2 = "register WebSocket failed".toString();
                                if (obj2 == null) {
                                    obj2 = "null";
                                }
                                System.out.println((Object) ("[" + StringsKt.first(level.name()) + "][kmp-ttnet] " + obj2));
                                System.out.println((Object) ("[" + StringsKt.first(level.name()) + "][kmp-ttnet] Exception: " + e));
                            }
                            if (intRef.element != -1) {
                                Mutex mutex4 = this.mapMutex;
                                nativeRawWsService$register$1.L$0 = intRef;
                                nativeRawWsService$register$1.L$1 = mutex4;
                                nativeRawWsService$register$1.L$2 = null;
                                nativeRawWsService$register$1.L$3 = null;
                                nativeRawWsService$register$1.L$4 = null;
                                nativeRawWsService$register$1.L$5 = null;
                                nativeRawWsService$register$1.label = 3;
                                if (mutex4.lock((Object) null, nativeRawWsService$register$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                mutex = mutex4;
                                intRef2 = intRef;
                                this.kmpRequestMap.remove(Boxing.boxInt(intRef2.element));
                            }
                            return Boxing.boxInt(-1);
                        }
                    }
                    int incrementAndGet = this.idGenerator.incrementAndGet();
                    this.kmpRequestMap.put(Boxing.boxInt(incrementAndGet), wsClient);
                    mutex2.unlock((Object) null);
                    intRef3.element = incrementAndGet;
                    nativeRawWsInfo = new NativeRawWsInfo(rawWebsocketInfo2.getUrl(), rawWebsocketInfo2.getQueries(), rawWebsocketInfo2.getHeaders());
                    nativeRawListenerImpl = new NativeRawListenerImpl(iRawWsEventListener2);
                    nativeRawWsService$register$1.L$0 = intRef;
                    nativeRawWsService$register$1.L$1 = null;
                    nativeRawWsService$register$1.L$2 = null;
                    nativeRawWsService$register$1.L$3 = null;
                    nativeRawWsService$register$1.L$4 = null;
                    nativeRawWsService$register$1.L$5 = null;
                    nativeRawWsService$register$1.label = 2;
                    if (wsClient.register(nativeRawWsInfo, nativeRawListenerImpl, nativeRawWsService$register$1) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    r4 = intRef;
                    return Boxing.boxInt(((Ref.IntRef) r4).element);
                }
            }
            int incrementAndGet2 = this.idGenerator.incrementAndGet();
            this.kmpRequestMap.put(Boxing.boxInt(incrementAndGet2), wsClient);
            mutex2.unlock((Object) null);
            intRef3.element = incrementAndGet2;
            nativeRawWsInfo = new NativeRawWsInfo(rawWebsocketInfo2.getUrl(), rawWebsocketInfo2.getQueries(), rawWebsocketInfo2.getHeaders());
            nativeRawListenerImpl = new NativeRawListenerImpl(iRawWsEventListener2);
            nativeRawWsService$register$1.L$0 = intRef;
            nativeRawWsService$register$1.L$1 = null;
            nativeRawWsService$register$1.L$2 = null;
            nativeRawWsService$register$1.L$3 = null;
            nativeRawWsService$register$1.L$4 = null;
            nativeRawWsService$register$1.L$5 = null;
            nativeRawWsService$register$1.label = 2;
            if (wsClient.register(nativeRawWsInfo, nativeRawListenerImpl, nativeRawWsService$register$1) != coroutine_suspended) {
            }
        } finally {
        }
        nativeRawWsService$register$1 = new NativeRawWsService$register$1(this, continuation);
        Object obj3 = nativeRawWsService$register$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r4 = nativeRawWsService$register$1.label;
        if (r4 != 0) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(10:5|6|7|(1:(1:(5:11|12|13|14|15)(2:17|18))(2:19|20))(3:32|33|(1:35))|21|22|23|(3:25|(1:27)|13)|14|15))|45|6|7|(0)(0)|21|22|23|(0)|14|15|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0081, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
    
        r0 = com.bytedance.kmp.network.util.NLog.INSTANCE;
        r1 = com.bytedance.kmp.network.util.NLog.Level.ERROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0090, code lost:
    
        if (r1.compareTo(r0.getLevel()) >= 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0092, code lost:
    
        r8 = "Failed to start WebSocket connection for id " + r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a1, code lost:
    
        if (r8 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ac, code lost:
    
        java.lang.System.out.println((java.lang.Object) ("[" + kotlin.text.StringsKt.first(r1.name()) + "][kmp-ttnet] " + r8));
        java.lang.System.out.println((java.lang.Object) ("[" + kotlin.text.StringsKt.first(r1.name()) + "][kmp-ttnet] Exception: " + r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a9, code lost:
    
        r8 = "null";
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0066 A[Catch: Exception -> 0x0081, TryCatch #1 {Exception -> 0x0081, blocks: (B:12:0x002d, B:13:0x0073, B:20:0x003f, B:23:0x0061, B:25:0x0066, B:30:0x007d, B:31:0x0080, B:33:0x0046, B:22:0x0055), top: B:7:0x0025, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    @Override // com.bytedance.kmp.network.websocket.IRawWsService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object startConnection(int i, Continuation<? super Boolean> continuation) {
        NativeRawWsService$startConnection$1 nativeRawWsService$startConnection$1;
        int i2;
        Mutex mutex;
        NativeRawWsClient nativeRawWsClient;
        try {
            if (continuation instanceof NativeRawWsService$startConnection$1) {
                nativeRawWsService$startConnection$1 = (NativeRawWsService$startConnection$1) continuation;
                if ((nativeRawWsService$startConnection$1.label & Integer.MIN_VALUE) != 0) {
                    nativeRawWsService$startConnection$1.label -= Integer.MIN_VALUE;
                    Object obj = nativeRawWsService$startConnection$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i2 = nativeRawWsService$startConnection$1.label;
                    boolean z = false;
                    if (i2 != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.mapMutex;
                        nativeRawWsService$startConnection$1.L$0 = mutex;
                        nativeRawWsService$startConnection$1.I$0 = i;
                        nativeRawWsService$startConnection$1.label = 1;
                        if (mutex.lock((Object) null, nativeRawWsService$startConnection$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i3 = nativeRawWsService$startConnection$1.I$0;
                            ResultKt.throwOnFailure(obj);
                            z = ((Boolean) obj).booleanValue();
                            return Boxing.boxBoolean(z);
                        }
                        i = nativeRawWsService$startConnection$1.I$0;
                        mutex = (Mutex) nativeRawWsService$startConnection$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    nativeRawWsClient = this.kmpRequestMap.get(Boxing.boxInt(i));
                    if (nativeRawWsClient != null) {
                        nativeRawWsService$startConnection$1.L$0 = null;
                        nativeRawWsService$startConnection$1.I$0 = i;
                        nativeRawWsService$startConnection$1.label = 2;
                        obj = nativeRawWsClient.startConnection(nativeRawWsService$startConnection$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        z = ((Boolean) obj).booleanValue();
                    }
                    return Boxing.boxBoolean(z);
                }
            }
            nativeRawWsClient = this.kmpRequestMap.get(Boxing.boxInt(i));
            if (nativeRawWsClient != null) {
            }
            return Boxing.boxBoolean(z);
        } finally {
            mutex.unlock((Object) null);
        }
        nativeRawWsService$startConnection$1 = new NativeRawWsService$startConnection$1(this, continuation);
        Object obj2 = nativeRawWsService$startConnection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = nativeRawWsService$startConnection$1.label;
        boolean z2 = false;
        if (i2 != 0) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(10:5|6|7|(1:(1:(6:11|12|13|14|15|16)(2:19|20))(1:21))(2:33|(1:35))|22|23|24|(4:26|(1:28)|13|14)|15|16))|45|6|7|(0)(0)|22|23|24|(0)|15|16|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0031, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007d, code lost:
    
        r0 = com.bytedance.kmp.network.util.NLog.INSTANCE;
        r1 = com.bytedance.kmp.network.util.NLog.Level.ERROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008b, code lost:
    
        if (r1.compareTo(r0.getLevel()) >= 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008d, code lost:
    
        r8 = "Failed to stop WebSocket connection for id " + r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009c, code lost:
    
        if (r8 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a7, code lost:
    
        java.lang.System.out.println((java.lang.Object) ("[" + kotlin.text.StringsKt.first(r1.name()) + "][kmp-ttnet] " + r8));
        java.lang.System.out.println((java.lang.Object) ("[" + kotlin.text.StringsKt.first(r1.name()) + "][kmp-ttnet] Exception: " + r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a4, code lost:
    
        r8 = "null";
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0068 A[Catch: Exception -> 0x0031, TRY_ENTER, TryCatch #1 {Exception -> 0x0031, blocks: (B:12:0x002d, B:13:0x0075, B:26:0x0068), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    @Override // com.bytedance.kmp.network.websocket.IRawWsService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object stopConnection(int i, Continuation<? super Boolean> continuation) {
        NativeRawWsService$stopConnection$1 nativeRawWsService$stopConnection$1;
        int i2;
        Mutex mutex;
        NativeRawWsClient remove;
        try {
            if (continuation instanceof NativeRawWsService$stopConnection$1) {
                nativeRawWsService$stopConnection$1 = (NativeRawWsService$stopConnection$1) continuation;
                if ((nativeRawWsService$stopConnection$1.label & Integer.MIN_VALUE) != 0) {
                    nativeRawWsService$stopConnection$1.label -= Integer.MIN_VALUE;
                    Object obj = nativeRawWsService$stopConnection$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i2 = nativeRawWsService$stopConnection$1.label;
                    boolean z = false;
                    if (i2 != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.mapMutex;
                        nativeRawWsService$stopConnection$1.L$0 = mutex;
                        nativeRawWsService$stopConnection$1.I$0 = i;
                        nativeRawWsService$stopConnection$1.label = 1;
                        if (mutex.lock((Object) null, nativeRawWsService$stopConnection$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i3 = nativeRawWsService$stopConnection$1.I$0;
                            ResultKt.throwOnFailure(obj);
                            z = ((Boolean) obj).booleanValue();
                            return Boxing.boxBoolean(z);
                        }
                        i = nativeRawWsService$stopConnection$1.I$0;
                        mutex = (Mutex) nativeRawWsService$stopConnection$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    remove = this.kmpRequestMap.remove(Boxing.boxInt(i));
                    if (remove != null) {
                        nativeRawWsService$stopConnection$1.L$0 = null;
                        nativeRawWsService$stopConnection$1.I$0 = i;
                        nativeRawWsService$stopConnection$1.label = 2;
                        obj = remove.stopConnection(nativeRawWsService$stopConnection$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        z = ((Boolean) obj).booleanValue();
                    }
                    return Boxing.boxBoolean(z);
                }
            }
            remove = this.kmpRequestMap.remove(Boxing.boxInt(i));
            if (remove != null) {
            }
            return Boxing.boxBoolean(z);
        } finally {
            mutex.unlock((Object) null);
        }
        nativeRawWsService$stopConnection$1 = new NativeRawWsService$stopConnection$1(this, continuation);
        Object obj2 = nativeRawWsService$stopConnection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = nativeRawWsService$stopConnection$1.label;
        boolean z2 = false;
        if (i2 != 0) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(5:(2:3|(8:5|6|7|(1:(5:(1:(1:12)(2:18|19))(1:20)|13|14|15|16)(1:21))(2:44|(1:46)(1:47))|22|23|24|(2:26|27)(5:28|(2:30|(1:32))(2:33|(2:35|(1:37))(2:38|39))|14|15|16)))|22|23|24|(0)(0))|57|6|7|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x003f, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b6, code lost:
    
        r12 = com.bytedance.kmp.network.util.NLog.INSTANCE;
        r0 = com.bytedance.kmp.network.util.NLog.Level.ERROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c4, code lost:
    
        if (r0.compareTo(r12.getLevel()) >= 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c6, code lost:
    
        r10 = "Failed to send WebSocket message for id " + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d5, code lost:
    
        if (r10 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00e0, code lost:
    
        java.lang.System.out.println((java.lang.Object) ("[" + kotlin.text.StringsKt.first(r0.name()) + "][kmp-ttnet] " + r10));
        java.lang.System.out.println((java.lang.Object) ("[" + kotlin.text.StringsKt.first(r0.name()) + "][kmp-ttnet] Exception: " + r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00dd, code lost:
    
        r10 = "null";
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007c A[Catch: Exception -> 0x003f, TRY_ENTER, TryCatch #0 {Exception -> 0x003f, blocks: (B:13:0x003b, B:28:0x007c, B:30:0x0082, B:33:0x0095, B:35:0x009b, B:38:0x00b1), top: B:7:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    @Override // com.bytedance.kmp.network.websocket.IRawWsService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object sendMsg(int i, RawWebsocketlMsg rawWebsocketlMsg, Continuation<? super Boolean> continuation) {
        NativeRawWsService$sendMsg$1 nativeRawWsService$sendMsg$1;
        int i2;
        RawWebsocketlMsg rawWebsocketlMsg2;
        Mutex mutex;
        NativeRawWsClient nativeRawWsClient;
        try {
            if (continuation instanceof NativeRawWsService$sendMsg$1) {
                nativeRawWsService$sendMsg$1 = (NativeRawWsService$sendMsg$1) continuation;
                if ((nativeRawWsService$sendMsg$1.label & Integer.MIN_VALUE) != 0) {
                    nativeRawWsService$sendMsg$1.label -= Integer.MIN_VALUE;
                    Object obj = nativeRawWsService$sendMsg$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i2 = nativeRawWsService$sendMsg$1.label;
                    boolean z = false;
                    if (i2 != 0) {
                        ResultKt.throwOnFailure(obj);
                        Mutex mutex2 = this.mapMutex;
                        nativeRawWsService$sendMsg$1.L$0 = rawWebsocketlMsg;
                        nativeRawWsService$sendMsg$1.L$1 = mutex2;
                        nativeRawWsService$sendMsg$1.I$0 = i;
                        nativeRawWsService$sendMsg$1.label = 1;
                        if (mutex2.lock((Object) null, nativeRawWsService$sendMsg$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        rawWebsocketlMsg2 = rawWebsocketlMsg;
                        mutex = mutex2;
                    } else {
                        if (i2 != 1) {
                            if (i2 == 2) {
                                int i3 = nativeRawWsService$sendMsg$1.I$0;
                            } else {
                                if (i2 != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                int i4 = nativeRawWsService$sendMsg$1.I$0;
                            }
                            ResultKt.throwOnFailure(obj);
                            z = true;
                            return Boxing.boxBoolean(z);
                        }
                        i = nativeRawWsService$sendMsg$1.I$0;
                        mutex = (Mutex) nativeRawWsService$sendMsg$1.L$1;
                        rawWebsocketlMsg2 = (RawWebsocketlMsg) nativeRawWsService$sendMsg$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    nativeRawWsClient = this.kmpRequestMap.get(Boxing.boxInt(i));
                    if (nativeRawWsClient != null) {
                        return Boxing.boxBoolean(false);
                    }
                    if (rawWebsocketlMsg2.getPayloadString() != null) {
                        String payloadString = rawWebsocketlMsg2.getPayloadString();
                        nativeRawWsService$sendMsg$1.L$0 = null;
                        nativeRawWsService$sendMsg$1.L$1 = null;
                        nativeRawWsService$sendMsg$1.I$0 = i;
                        nativeRawWsService$sendMsg$1.label = 2;
                        if (nativeRawWsClient.sendMsg(payloadString, nativeRawWsService$sendMsg$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (rawWebsocketlMsg2.getPayloadBuffer() == null) {
                            return Boxing.boxBoolean(false);
                        }
                        byte[] payloadBuffer = rawWebsocketlMsg2.getPayloadBuffer();
                        nativeRawWsService$sendMsg$1.L$0 = null;
                        nativeRawWsService$sendMsg$1.L$1 = null;
                        nativeRawWsService$sendMsg$1.I$0 = i;
                        nativeRawWsService$sendMsg$1.label = 3;
                        if (nativeRawWsClient.sendMsg(payloadBuffer, nativeRawWsService$sendMsg$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    z = true;
                    return Boxing.boxBoolean(z);
                }
            }
            nativeRawWsClient = this.kmpRequestMap.get(Boxing.boxInt(i));
            if (nativeRawWsClient != null) {
            }
        } finally {
            mutex.unlock((Object) null);
        }
        nativeRawWsService$sendMsg$1 = new NativeRawWsService$sendMsg$1(this, continuation);
        Object obj2 = nativeRawWsService$sendMsg$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = nativeRawWsService$sendMsg$1.label;
        boolean z2 = false;
        if (i2 != 0) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(10:5|6|7|(1:(1:(5:11|12|13|14|15)(2:17|18))(2:19|20))(3:32|33|(1:35))|21|22|23|(3:25|(1:27)|13)|14|15))|45|6|7|(0)(0)|21|22|23|(0)|14|15|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0081, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
    
        r0 = com.bytedance.kmp.network.util.NLog.INSTANCE;
        r1 = com.bytedance.kmp.network.util.NLog.Level.ERROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0090, code lost:
    
        if (r1.compareTo(r0.getLevel()) >= 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0092, code lost:
    
        r8 = "Failed to check isConnected for id " + r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a1, code lost:
    
        if (r8 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ac, code lost:
    
        java.lang.System.out.println((java.lang.Object) ("[" + kotlin.text.StringsKt.first(r1.name()) + "][kmp-ttnet] " + r8));
        java.lang.System.out.println((java.lang.Object) ("[" + kotlin.text.StringsKt.first(r1.name()) + "][kmp-ttnet] Exception: " + r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a9, code lost:
    
        r8 = "null";
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0066 A[Catch: Exception -> 0x0081, TryCatch #1 {Exception -> 0x0081, blocks: (B:12:0x002d, B:13:0x0073, B:20:0x003f, B:23:0x0061, B:25:0x0066, B:30:0x007d, B:31:0x0080, B:33:0x0046, B:22:0x0055), top: B:7:0x0025, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    @Override // com.bytedance.kmp.network.websocket.IRawWsService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object isConnected(int i, Continuation<? super Boolean> continuation) {
        NativeRawWsService$isConnected$1 nativeRawWsService$isConnected$1;
        int i2;
        Mutex mutex;
        NativeRawWsClient nativeRawWsClient;
        try {
            if (continuation instanceof NativeRawWsService$isConnected$1) {
                nativeRawWsService$isConnected$1 = (NativeRawWsService$isConnected$1) continuation;
                if ((nativeRawWsService$isConnected$1.label & Integer.MIN_VALUE) != 0) {
                    nativeRawWsService$isConnected$1.label -= Integer.MIN_VALUE;
                    Object obj = nativeRawWsService$isConnected$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i2 = nativeRawWsService$isConnected$1.label;
                    boolean z = false;
                    if (i2 != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.mapMutex;
                        nativeRawWsService$isConnected$1.L$0 = mutex;
                        nativeRawWsService$isConnected$1.I$0 = i;
                        nativeRawWsService$isConnected$1.label = 1;
                        if (mutex.lock((Object) null, nativeRawWsService$isConnected$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i3 = nativeRawWsService$isConnected$1.I$0;
                            ResultKt.throwOnFailure(obj);
                            z = ((Boolean) obj).booleanValue();
                            return Boxing.boxBoolean(z);
                        }
                        i = nativeRawWsService$isConnected$1.I$0;
                        mutex = (Mutex) nativeRawWsService$isConnected$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    nativeRawWsClient = this.kmpRequestMap.get(Boxing.boxInt(i));
                    if (nativeRawWsClient != null) {
                        nativeRawWsService$isConnected$1.L$0 = null;
                        nativeRawWsService$isConnected$1.I$0 = i;
                        nativeRawWsService$isConnected$1.label = 2;
                        obj = nativeRawWsClient.isConnected(nativeRawWsService$isConnected$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        z = ((Boolean) obj).booleanValue();
                    }
                    return Boxing.boxBoolean(z);
                }
            }
            nativeRawWsClient = this.kmpRequestMap.get(Boxing.boxInt(i));
            if (nativeRawWsClient != null) {
            }
            return Boxing.boxBoolean(z);
        } finally {
            mutex.unlock((Object) null);
        }
        nativeRawWsService$isConnected$1 = new NativeRawWsService$isConnected$1(this, continuation);
        Object obj2 = nativeRawWsService$isConnected$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = nativeRawWsService$isConnected$1.label;
        boolean z2 = false;
        if (i2 != 0) {
        }
    }
}
