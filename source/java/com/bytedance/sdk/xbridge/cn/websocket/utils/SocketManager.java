package com.bytedance.sdk.xbridge.cn.websocket.utils;

import android.content.Context;
import android.util.Base64;
import com.bytedance.sdk.xbridge.cn.websocket.utils.SocketRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SocketManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006J\b\u0010\t\u001a\u00020\u0006H\u0002J(\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J \u0010\u0018\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J \u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001cJ \u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006¨\u0006!"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketManager;", "", "()V", "clearContainerRecordIfNecessary", "", "containerID", "", "closeSocket", "socketTaskID", "createSocketId", "createTask", "context", "Landroid/content/Context;", "requestTask", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$RequestTask;", "callback", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$Callback;", "createWsStatusListener", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/WsStatusListener;", "getSocketTask", "", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/IWebSocketTask;", "releaseContainerSocketTasks", "releaseSocketTask", "releaseSocketTasks", "removeSocketTask", "sendArrayBuffer", "byteData", "", "sendText", "txt", "Companion", "WsListener", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SocketManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<String, HashMap<String, ? super IWebSocketTask>> mWebSocketContainer = new HashMap<>();
    private static final Lazy<SocketManager> instance$delegate = LazyKt.lazy(new Function0<SocketManager>() { // from class: com.bytedance.sdk.xbridge.cn.websocket.utils.SocketManager$Companion$instance$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SocketManager m923invoke() {
            return new SocketManager(null);
        }
    });

    public /* synthetic */ SocketManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final SocketManager getInstance() {
        return INSTANCE.getInstance();
    }

    public final void releaseSocketTasks() {
        releaseSocketTasks$default(this, null, null, 3, null);
    }

    public final void releaseSocketTasks(String str) {
        releaseSocketTasks$default(this, str, null, 2, null);
    }

    /* compiled from: SocketManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007Rj\u0010\n\u001a^\u0012\u0004\u0012\u00020\f\u0012$\u0012\"\u0012\u0004\u0012\u00020\f\u0012\u0006\b\u0000\u0012\u00020\r0\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\b\u0000\u0012\u00020\r`\u000e0\u000bj.\u0012\u0004\u0012\u00020\f\u0012$\u0012\"\u0012\u0004\u0012\u00020\f\u0012\u0006\b\u0000\u0012\u00020\r0\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\b\u0000\u0012\u00020\r`\u000e`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketManager$Companion;", "", "()V", "instance", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketManager;", "getInstance$annotations", "getInstance", "()Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketManager;", "instance$delegate", "Lkotlin/Lazy;", "mWebSocketContainer", "Ljava/util/HashMap;", "", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/IWebSocketTask;", "Lkotlin/collections/HashMap;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        private Companion() {
        }

        public final SocketManager getInstance() {
            return (SocketManager) SocketManager.instance$delegate.getValue();
        }
    }

    private SocketManager() {
    }

    public final String createTask(Context context, String containerID, SocketRequest.RequestTask requestTask, SocketRequest.Callback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(containerID, "containerID");
        Intrinsics.checkNotNullParameter(requestTask, "requestTask");
        Intrinsics.checkNotNullParameter(callback, "callback");
        TTNetWebSocketTask tryNewInst = TTNetWebSocketTask.INSTANCE.tryNewInst(context, requestTask);
        if (tryNewInst == null) {
            return null;
        }
        TTNetWebSocketTask tTNetWebSocketTask = tryNewInst;
        String createSocketId = createSocketId();
        tTNetWebSocketTask.setStatusListener(createWsStatusListener(containerID, createSocketId, callback));
        HashMap<String, HashMap<String, ? super IWebSocketTask>> hashMap = mWebSocketContainer;
        synchronized (hashMap) {
            if (hashMap.containsKey(containerID)) {
                HashMap<String, ? super IWebSocketTask> hashMap2 = hashMap.get(containerID);
                if (hashMap2 != null) {
                    hashMap2.put(createSocketId, tTNetWebSocketTask);
                }
            } else {
                HashMap<String, ? super IWebSocketTask> hashMap3 = new HashMap<>();
                hashMap3.put(createSocketId, tTNetWebSocketTask);
                Unit unit = Unit.INSTANCE;
                hashMap.put(containerID, hashMap3);
            }
        }
        tTNetWebSocketTask.startConnect();
        return createSocketId;
    }

    public final String sendText(String containerID, String socketTaskID, String txt) {
        IWebSocketTask iWebSocketTask;
        Intrinsics.checkNotNullParameter(containerID, "containerID");
        Intrinsics.checkNotNullParameter(socketTaskID, "socketTaskID");
        Intrinsics.checkNotNullParameter(txt, "txt");
        List<IWebSocketTask> socketTask = getSocketTask(containerID, socketTaskID);
        return (socketTask == null || (iWebSocketTask = socketTask.get(0)) == null) ? "The socketTaskID doesn't exist" : iWebSocketTask.sendMessage(txt);
    }

    public final String sendArrayBuffer(String containerID, String socketTaskID, byte[] byteData) {
        IWebSocketTask iWebSocketTask;
        Intrinsics.checkNotNullParameter(containerID, "containerID");
        Intrinsics.checkNotNullParameter(socketTaskID, "socketTaskID");
        Intrinsics.checkNotNullParameter(byteData, "byteData");
        List<IWebSocketTask> socketTask = getSocketTask(containerID, socketTaskID);
        return (socketTask == null || (iWebSocketTask = socketTask.get(0)) == null) ? "The socketTaskID doesn't exist" : iWebSocketTask.sendMessage(byteData);
    }

    public final String closeSocket(String containerID, String socketTaskID) {
        Unit unit;
        Intrinsics.checkNotNullParameter(containerID, "containerID");
        List<IWebSocketTask> socketTask = getSocketTask(containerID, socketTaskID);
        if (socketTask != null) {
            Iterator<T> it = socketTask.iterator();
            while (it.hasNext()) {
                ((IWebSocketTask) it.next()).stopConnect();
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            return socketTaskID != null ? "The socketTaskID doesn't exist" : "The containerID doesn't exist";
        }
        return null;
    }

    private final WsStatusListener createWsStatusListener(String containerID, String socketTaskID, SocketRequest.Callback callback) {
        return new WsListener(this, containerID, socketTaskID, callback);
    }

    private final String createSocketId() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        return uuid;
    }

    private final List<IWebSocketTask> getSocketTask(String containerID, String socketTaskID) {
        Unit unit;
        HashMap<String, HashMap<String, ? super IWebSocketTask>> hashMap = mWebSocketContainer;
        synchronized (hashMap) {
            ArrayList arrayList = new ArrayList();
            if (socketTaskID != null) {
                HashMap<String, ? super IWebSocketTask> hashMap2 = hashMap.get(containerID);
                if (hashMap2 == null) {
                    return null;
                }
                IWebSocketTask iWebSocketTask = hashMap2.get(socketTaskID);
                IWebSocketTask iWebSocketTask2 = iWebSocketTask instanceof IWebSocketTask ? iWebSocketTask : null;
                if (iWebSocketTask2 == null) {
                    return null;
                }
                arrayList.add(iWebSocketTask2);
            } else {
                HashMap<String, ? super IWebSocketTask> hashMap3 = hashMap.get(containerID);
                if (hashMap3 != null) {
                    for (IWebSocketTask iWebSocketTask3 : hashMap3.values()) {
                        Intrinsics.checkNotNull(iWebSocketTask3, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.websocket.utils.IWebSocketTask");
                        arrayList.add(iWebSocketTask3);
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    return null;
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeSocketTask(String containerID, String socketTaskID) {
        HashMap<String, HashMap<String, ? super IWebSocketTask>> hashMap = mWebSocketContainer;
        synchronized (hashMap) {
            HashMap<String, ? super IWebSocketTask> hashMap2 = hashMap.get(containerID);
            if (hashMap2 != null) {
                hashMap2.remove(socketTaskID);
            }
            HashMap<String, ? super IWebSocketTask> hashMap3 = hashMap.get(containerID);
            boolean z = false;
            if (hashMap3 != null && hashMap3.isEmpty()) {
                z = true;
            }
            if (z) {
                hashMap.remove(containerID);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void releaseSocketTasks$default(SocketManager socketManager, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        socketManager.releaseSocketTasks(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0059 A[Catch: all -> 0x003e, TryCatch #0 {all -> 0x003e, blocks: (B:56:0x002e, B:24:0x0046, B:30:0x0059, B:31:0x00a0, B:41:0x0062, B:48:0x0073, B:49:0x0077, B:50:0x0086, B:52:0x008c, B:54:0x009b), top: B:55:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0062 A[Catch: all -> 0x003e, TryCatch #0 {all -> 0x003e, blocks: (B:56:0x002e, B:24:0x0046, B:30:0x0059, B:31:0x00a0, B:41:0x0062, B:48:0x0073, B:49:0x0077, B:50:0x0086, B:52:0x008c, B:54:0x009b), top: B:55:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0073 A[Catch: all -> 0x003e, TryCatch #0 {all -> 0x003e, blocks: (B:56:0x002e, B:24:0x0046, B:30:0x0059, B:31:0x00a0, B:41:0x0062, B:48:0x0073, B:49:0x0077, B:50:0x0086, B:52:0x008c, B:54:0x009b), top: B:55:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0077 A[Catch: all -> 0x003e, TryCatch #0 {all -> 0x003e, blocks: (B:56:0x002e, B:24:0x0046, B:30:0x0059, B:31:0x00a0, B:41:0x0062, B:48:0x0073, B:49:0x0077, B:50:0x0086, B:52:0x008c, B:54:0x009b), top: B:55:0x002e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void releaseSocketTasks(String containerID, String socketTaskID) {
        boolean z;
        boolean z2;
        boolean z3;
        String str = containerID;
        boolean z4 = false;
        if (str == null || str.length() == 0) {
            if (socketTaskID != null) {
                if (socketTaskID.length() > 0) {
                    z3 = true;
                    if (z3) {
                        return;
                    }
                }
            }
            z3 = false;
            if (z3) {
            }
        }
        HashMap<String, HashMap<String, ? super IWebSocketTask>> hashMap = mWebSocketContainer;
        synchronized (hashMap) {
            if (containerID != null) {
                try {
                    if (containerID.length() > 0) {
                        z = true;
                        if (z) {
                            if (socketTaskID != null) {
                                if (socketTaskID.length() > 0) {
                                    z2 = true;
                                    if (z2) {
                                        releaseSocketTask(containerID, socketTaskID);
                                        clearContainerRecordIfNecessary(containerID);
                                        Unit unit = Unit.INSTANCE;
                                    }
                                }
                            }
                            z2 = false;
                            if (z2) {
                            }
                        }
                        if (containerID != null) {
                            if (containerID.length() > 0) {
                                z4 = true;
                            }
                        }
                        if (!z4) {
                            releaseContainerSocketTasks(containerID);
                        } else {
                            Set<String> keySet = hashMap.keySet();
                            Intrinsics.checkNotNullExpressionValue(keySet, "mWebSocketContainer.keys");
                            for (String str2 : keySet) {
                                Intrinsics.checkNotNullExpressionValue(str2, "containerID");
                                releaseContainerSocketTasks(str2);
                            }
                            mWebSocketContainer.clear();
                        }
                        Unit unit2 = Unit.INSTANCE;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            z = false;
            if (z) {
            }
            if (containerID != null) {
            }
            if (!z4) {
            }
            Unit unit22 = Unit.INSTANCE;
        }
    }

    private final void releaseContainerSocketTasks(String containerID) {
        try {
            Result.Companion companion = Result.Companion;
            HashMap<String, ? super IWebSocketTask> hashMap = mWebSocketContainer.get(containerID);
            Unit unit = null;
            if (hashMap != null) {
                Set<Map.Entry<String, ? super IWebSocketTask>> entrySet = hashMap.entrySet();
                Intrinsics.checkNotNullExpressionValue(entrySet, "this.entries");
                Iterator<T> it = entrySet.iterator();
                while (it.hasNext()) {
                    Object value = ((Map.Entry) it.next()).getValue();
                    IWebSocketTask iWebSocketTask = value instanceof IWebSocketTask ? (IWebSocketTask) value : null;
                    if (iWebSocketTask != null) {
                        iWebSocketTask.stopConnect();
                    }
                }
                hashMap.clear();
                unit = Unit.INSTANCE;
            }
            Result.constructor-impl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    private final void releaseSocketTask(String containerID, String socketTaskID) {
        try {
            Result.Companion companion = Result.Companion;
            HashMap<String, ? super IWebSocketTask> hashMap = mWebSocketContainer.get(containerID);
            IWebSocketTask iWebSocketTask = null;
            if (hashMap != null) {
                IWebSocketTask iWebSocketTask2 = hashMap.get(socketTaskID);
                IWebSocketTask iWebSocketTask3 = iWebSocketTask2 instanceof IWebSocketTask ? iWebSocketTask2 : null;
                if (iWebSocketTask3 != null) {
                    iWebSocketTask3.stopConnect();
                    iWebSocketTask = hashMap.remove(socketTaskID);
                }
            }
            Result.constructor-impl(iWebSocketTask);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    private final void clearContainerRecordIfNecessary(String containerID) {
        Unit unit;
        try {
            Result.Companion companion = Result.Companion;
            HashMap<String, HashMap<String, ? super IWebSocketTask>> hashMap = mWebSocketContainer;
            HashMap<String, ? super IWebSocketTask> hashMap2 = hashMap.get(containerID);
            if (hashMap2 != null) {
                if (hashMap2.isEmpty()) {
                    hashMap.remove(containerID);
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.constructor-impl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SocketManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketManager$WsListener;", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/WsStatusListener;", "containerID", "", "socketTaskID", "callback", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$Callback;", "(Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketManager;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$Callback;)V", "getCallback", "()Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$Callback;", "getContainerID", "()Ljava/lang/String;", "getSocketTaskID", "onClosed", "", "needCallBack", "", "onConnected", "onFailed", "reason", "onMessage", "bytes", "", "text", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public final class WsListener implements WsStatusListener {
        private final SocketRequest.Callback callback;
        private final String containerID;
        private final String socketTaskID;
        final /* synthetic */ SocketManager this$0;

        public WsListener(SocketManager socketManager, String str, String str2, SocketRequest.Callback callback) {
            Intrinsics.checkNotNullParameter(str, "containerID");
            Intrinsics.checkNotNullParameter(str2, "socketTaskID");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.this$0 = socketManager;
            this.containerID = str;
            this.socketTaskID = str2;
            this.callback = callback;
        }

        public final SocketRequest.Callback getCallback() {
            return this.callback;
        }

        public final String getContainerID() {
            return this.containerID;
        }

        public final String getSocketTaskID() {
            return this.socketTaskID;
        }

        @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.WsStatusListener
        public void onConnected() {
            this.callback.onStateChanged(new SocketRequest.RequestState.Builder(WebSocketConsts.StateType_CONNECTED, this.socketTaskID).build());
        }

        @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.WsStatusListener
        public void onMessage(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.callback.onStateChanged(new SocketRequest.RequestState.Builder(WebSocketConsts.StateType_ONMESSAGED, this.socketTaskID).setTextData(text).setDataType("string").build());
        }

        @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.WsStatusListener
        public void onMessage(byte[] bytes) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            this.callback.onStateChanged(new SocketRequest.RequestState.Builder(WebSocketConsts.StateType_ONMESSAGED, this.socketTaskID).setTextData(Base64.encodeToString(bytes, 0)).setDataType("base64").build());
        }

        @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.WsStatusListener
        public void onClosed(boolean needCallBack) {
            SocketRequest.RequestState.Builder builder = new SocketRequest.RequestState.Builder("closed", this.socketTaskID);
            if (needCallBack) {
                this.callback.onStateChanged(builder.build());
            }
            this.this$0.removeSocketTask(this.containerID, this.socketTaskID);
        }

        @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.WsStatusListener
        public void onFailed(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.callback.onStateChanged(new SocketRequest.RequestState.Builder("failed", this.socketTaskID).setMessage(reason).build());
            this.this$0.removeSocketTask(this.containerID, this.socketTaskID);
        }
    }
}
