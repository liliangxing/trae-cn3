package com.bytedance.kmp.network.websocket;

import com.bytedance.kmp.network.KmpNetworkService_androidKt;
import com.bytedance.kmp.network.util.NLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.text.StringsKt;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: Websocket.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\tJ\u000e\u0010\u0016\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/kmp/network/websocket/Websocket;", "", "()V", "wsId", "Lkotlinx/atomicfu/AtomicInt;", "wsService", "Lcom/bytedance/kmp/network/websocket/IRawWsService;", "isConnected", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "", "info", "Lcom/bytedance/kmp/network/websocket/RawWebsocketInfo;", "listener", "Lcom/bytedance/kmp/network/websocket/IRawWsEventListener;", "(Lcom/bytedance/kmp/network/websocket/RawWebsocketInfo;Lcom/bytedance/kmp/network/websocket/IRawWsEventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMsg", "msg", "Lcom/bytedance/kmp/network/websocket/RawWebsocketlMsg;", "(Lcom/bytedance/kmp/network/websocket/RawWebsocketlMsg;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startConnection", "stopConnection", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class Websocket {
    private final IRawWsService wsService = KmpNetworkService_androidKt.getRawWsService();
    private AtomicInt wsId = AtomicFU.atomic(-1);

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(3:18|19|(1:21))|11|12|13))|32|6|7|(0)(0)|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002a, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
    
        r7 = com.bytedance.kmp.network.util.NLog.INSTANCE;
        r8 = com.bytedance.kmp.network.util.NLog.Level.ERROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0064, code lost:
    
        if (r8.compareTo(r7.getLevel()) >= 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0066, code lost:
    
        r7 = "Registration failed: " + r6.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0079, code lost:
    
        if (r7 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0084, code lost:
    
        java.lang.System.out.println((java.lang.Object) ("[" + kotlin.text.StringsKt.first(r8.name()) + "][kmp-ttnet] " + r7));
        java.lang.System.out.println((java.lang.Object) ("[" + kotlin.text.StringsKt.first(r8.name()) + "][kmp-ttnet] Exception: " + r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0081, code lost:
    
        r7 = "null";
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d4, code lost:
    
        r6 = -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object register(RawWebsocketInfo rawWebsocketInfo, IRawWsEventListener iRawWsEventListener, Continuation<? super Integer> continuation) {
        Websocket$register$1 websocket$register$1;
        int i;
        if (continuation instanceof Websocket$register$1) {
            websocket$register$1 = (Websocket$register$1) continuation;
            if ((websocket$register$1.label & Integer.MIN_VALUE) != 0) {
                websocket$register$1.label -= Integer.MIN_VALUE;
                Object obj = websocket$register$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = websocket$register$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext io2 = Dispatchers.getIO();
                    Websocket$register$2 websocket$register$2 = new Websocket$register$2(iRawWsEventListener, this, rawWebsocketInfo, null);
                    websocket$register$1.label = 1;
                    obj = BuildersKt.withContext(io2, websocket$register$2, websocket$register$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                int i2 = ((Number) obj).intValue();
                return Boxing.boxInt(i2);
            }
        }
        websocket$register$1 = new Websocket$register$1(this, continuation);
        Object obj2 = websocket$register$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = websocket$register$1.label;
        if (i != 0) {
        }
        int i22 = ((Number) obj2).intValue();
        return Boxing.boxInt(i22);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startConnection(Continuation<? super Boolean> continuation) {
        Websocket$startConnection$1 websocket$startConnection$1;
        int i;
        int i2;
        Exception e;
        NLog nLog;
        NLog.Level level;
        String str;
        if (continuation instanceof Websocket$startConnection$1) {
            websocket$startConnection$1 = (Websocket$startConnection$1) continuation;
            if ((websocket$startConnection$1.label & Integer.MIN_VALUE) != 0) {
                websocket$startConnection$1.label -= Integer.MIN_VALUE;
                Object obj = websocket$startConnection$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = websocket$startConnection$1.label;
                boolean z = false;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    int value = this.wsId.getValue();
                    if (value == -1) {
                        return Boxing.boxBoolean(false);
                    }
                    try {
                        CoroutineContext io2 = Dispatchers.getIO();
                        Websocket$startConnection$2 websocket$startConnection$2 = new Websocket$startConnection$2(this, value, null);
                        websocket$startConnection$1.I$0 = value;
                        websocket$startConnection$1.label = 1;
                        Object withContext = BuildersKt.withContext(io2, websocket$startConnection$2, websocket$startConnection$1);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i2 = value;
                        obj = withContext;
                    } catch (Exception e2) {
                        i2 = value;
                        e = e2;
                        nLog = NLog.INSTANCE;
                        level = NLog.Level.ERROR;
                        if (level.compareTo(nLog.getLevel()) >= 0) {
                        }
                        return Boxing.boxBoolean(z);
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = websocket$startConnection$1.I$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception e3) {
                        e = e3;
                        nLog = NLog.INSTANCE;
                        level = NLog.Level.ERROR;
                        if (level.compareTo(nLog.getLevel()) >= 0) {
                            String str2 = "Start connection failed for id " + i2 + ": " + e.getMessage();
                            if (str2 == null || (str = str2.toString()) == null) {
                                str = "null";
                            }
                            System.out.println((Object) ("[" + StringsKt.first(level.name()) + "][kmp-ttnet] " + str));
                            System.out.println((Object) ("[" + StringsKt.first(level.name()) + "][kmp-ttnet] Exception: " + e));
                        }
                        return Boxing.boxBoolean(z);
                    }
                }
                z = ((Boolean) obj).booleanValue();
                return Boxing.boxBoolean(z);
            }
        }
        websocket$startConnection$1 = new Websocket$startConnection$1(this, continuation);
        Object obj2 = websocket$startConnection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = websocket$startConnection$1.label;
        boolean z2 = false;
        if (i != 0) {
        }
        z2 = ((Boolean) obj2).booleanValue();
        return Boxing.boxBoolean(z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object stopConnection(Continuation<? super Boolean> continuation) {
        Websocket$stopConnection$1 websocket$stopConnection$1;
        int i;
        int i2;
        Exception e;
        NLog nLog;
        NLog.Level level;
        String str;
        if (continuation instanceof Websocket$stopConnection$1) {
            websocket$stopConnection$1 = (Websocket$stopConnection$1) continuation;
            if ((websocket$stopConnection$1.label & Integer.MIN_VALUE) != 0) {
                websocket$stopConnection$1.label -= Integer.MIN_VALUE;
                Object obj = websocket$stopConnection$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = websocket$stopConnection$1.label;
                boolean z = false;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    int value = this.wsId.getValue();
                    if (value == -1) {
                        return Boxing.boxBoolean(false);
                    }
                    try {
                        CoroutineContext io2 = Dispatchers.getIO();
                        Websocket$stopConnection$2 websocket$stopConnection$2 = new Websocket$stopConnection$2(this, value, null);
                        websocket$stopConnection$1.I$0 = value;
                        websocket$stopConnection$1.label = 1;
                        Object withContext = BuildersKt.withContext(io2, websocket$stopConnection$2, websocket$stopConnection$1);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i2 = value;
                        obj = withContext;
                    } catch (Exception e2) {
                        i2 = value;
                        e = e2;
                        nLog = NLog.INSTANCE;
                        level = NLog.Level.ERROR;
                        if (level.compareTo(nLog.getLevel()) >= 0) {
                        }
                        this.wsId.setValue(-1);
                        return Boxing.boxBoolean(z);
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = websocket$stopConnection$1.I$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception e3) {
                        e = e3;
                        nLog = NLog.INSTANCE;
                        level = NLog.Level.ERROR;
                        if (level.compareTo(nLog.getLevel()) >= 0) {
                            String str2 = "Stop connection failed for id " + i2 + ": " + e.getMessage();
                            if (str2 == null || (str = str2.toString()) == null) {
                                str = "null";
                            }
                            System.out.println((Object) ("[" + StringsKt.first(level.name()) + "][kmp-ttnet] " + str));
                            System.out.println((Object) ("[" + StringsKt.first(level.name()) + "][kmp-ttnet] Exception: " + e));
                        }
                        this.wsId.setValue(-1);
                        return Boxing.boxBoolean(z);
                    }
                }
                z = ((Boolean) obj).booleanValue();
                return Boxing.boxBoolean(z);
            }
        }
        websocket$stopConnection$1 = new Websocket$stopConnection$1(this, continuation);
        Object obj2 = websocket$stopConnection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = websocket$stopConnection$1.label;
        boolean z2 = false;
        if (i != 0) {
        }
        z2 = ((Boolean) obj2).booleanValue();
        return Boxing.boxBoolean(z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sendMsg(RawWebsocketlMsg rawWebsocketlMsg, Continuation<? super Boolean> continuation) {
        Websocket$sendMsg$1 websocket$sendMsg$1;
        int i;
        Exception e;
        int i2;
        NLog nLog;
        NLog.Level level;
        String str;
        if (continuation instanceof Websocket$sendMsg$1) {
            websocket$sendMsg$1 = (Websocket$sendMsg$1) continuation;
            if ((websocket$sendMsg$1.label & Integer.MIN_VALUE) != 0) {
                websocket$sendMsg$1.label -= Integer.MIN_VALUE;
                Object obj = websocket$sendMsg$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = websocket$sendMsg$1.label;
                boolean z = false;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    int value = this.wsId.getValue();
                    if (value == -1) {
                        return Boxing.boxBoolean(false);
                    }
                    try {
                        CoroutineContext io2 = Dispatchers.getIO();
                        Websocket$sendMsg$2 websocket$sendMsg$2 = new Websocket$sendMsg$2(this, value, rawWebsocketlMsg, null);
                        websocket$sendMsg$1.I$0 = value;
                        websocket$sendMsg$1.label = 1;
                        Object withContext = BuildersKt.withContext(io2, websocket$sendMsg$2, websocket$sendMsg$1);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = withContext;
                        i2 = value;
                    } catch (Exception e2) {
                        e = e2;
                        i2 = value;
                        nLog = NLog.INSTANCE;
                        level = NLog.Level.ERROR;
                        if (level.compareTo(nLog.getLevel()) >= 0) {
                        }
                        return Boxing.boxBoolean(z);
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = websocket$sendMsg$1.I$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception e3) {
                        e = e3;
                        nLog = NLog.INSTANCE;
                        level = NLog.Level.ERROR;
                        if (level.compareTo(nLog.getLevel()) >= 0) {
                            String str2 = "Send message failed for id " + i2 + ": " + e.getMessage();
                            if (str2 == null || (str = str2.toString()) == null) {
                                str = "null";
                            }
                            System.out.println((Object) ("[" + StringsKt.first(level.name()) + "][kmp-ttnet] " + str));
                            System.out.println((Object) ("[" + StringsKt.first(level.name()) + "][kmp-ttnet] Exception: " + e));
                        }
                        return Boxing.boxBoolean(z);
                    }
                }
                z = ((Boolean) obj).booleanValue();
                return Boxing.boxBoolean(z);
            }
        }
        websocket$sendMsg$1 = new Websocket$sendMsg$1(this, continuation);
        Object obj2 = websocket$sendMsg$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = websocket$sendMsg$1.label;
        boolean z2 = false;
        if (i != 0) {
        }
        z2 = ((Boolean) obj2).booleanValue();
        return Boxing.boxBoolean(z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object isConnected(Continuation<? super Boolean> continuation) {
        Websocket$isConnected$1 websocket$isConnected$1;
        int i;
        int i2;
        Exception e;
        NLog nLog;
        NLog.Level level;
        String str;
        if (continuation instanceof Websocket$isConnected$1) {
            websocket$isConnected$1 = (Websocket$isConnected$1) continuation;
            if ((websocket$isConnected$1.label & Integer.MIN_VALUE) != 0) {
                websocket$isConnected$1.label -= Integer.MIN_VALUE;
                Object obj = websocket$isConnected$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = websocket$isConnected$1.label;
                boolean z = false;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    int value = this.wsId.getValue();
                    if (value == -1) {
                        return Boxing.boxBoolean(false);
                    }
                    try {
                        CoroutineContext io2 = Dispatchers.getIO();
                        Websocket$isConnected$2 websocket$isConnected$2 = new Websocket$isConnected$2(this, value, null);
                        websocket$isConnected$1.I$0 = value;
                        websocket$isConnected$1.label = 1;
                        Object withContext = BuildersKt.withContext(io2, websocket$isConnected$2, websocket$isConnected$1);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i2 = value;
                        obj = withContext;
                    } catch (Exception e2) {
                        i2 = value;
                        e = e2;
                        nLog = NLog.INSTANCE;
                        level = NLog.Level.ERROR;
                        if (level.compareTo(nLog.getLevel()) >= 0) {
                        }
                        return Boxing.boxBoolean(z);
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = websocket$isConnected$1.I$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception e3) {
                        e = e3;
                        nLog = NLog.INSTANCE;
                        level = NLog.Level.ERROR;
                        if (level.compareTo(nLog.getLevel()) >= 0) {
                            String str2 = "isConnected check failed for id " + i2 + ": " + e.getMessage();
                            if (str2 == null || (str = str2.toString()) == null) {
                                str = "null";
                            }
                            System.out.println((Object) ("[" + StringsKt.first(level.name()) + "][kmp-ttnet] " + str));
                            System.out.println((Object) ("[" + StringsKt.first(level.name()) + "][kmp-ttnet] Exception: " + e));
                        }
                        return Boxing.boxBoolean(z);
                    }
                }
                z = ((Boolean) obj).booleanValue();
                return Boxing.boxBoolean(z);
            }
        }
        websocket$isConnected$1 = new Websocket$isConnected$1(this, continuation);
        Object obj2 = websocket$isConnected$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = websocket$isConnected$1.label;
        boolean z2 = false;
        if (i != 0) {
        }
        z2 = ((Boolean) obj2).booleanValue();
        return Boxing.boxBoolean(z2);
    }
}
