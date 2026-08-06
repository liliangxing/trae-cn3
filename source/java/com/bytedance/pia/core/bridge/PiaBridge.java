package com.bytedance.pia.core.bridge;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.pia.core.PiaContext;
import com.bytedance.pia.core.api.bridge.IPiaBridge;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.context.IPiaContext;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.bridge.channel.IBridgePort;
import com.bytedance.pia.core.bridge.protocol.ProtocolMessage;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.CacheHandle;
import com.bytedance.pia.core.utils.GsonUtils;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.ReflectUtils;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.core.worker.IPiaDebugger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PiaBridge implements IPiaBridge {
    public static final String INTERNAL_PREFIX = "pia.internal.";
    private final PiaContext context;
    private IPiaDebugger debugger;
    private final BridgeRegistry registry;
    private final PiaMethod.Scope scope;
    private boolean hasClosed = false;
    private final CacheHandle<JsonObject> localMessageCache = new CacheHandle<>();
    private IBridgePort port = null;
    private int currentMessageID = 0;
    private final SparseArray<IConsumer<ProtocolMessage.Callback>> callbacks = new SparseArray<>();

    public PiaBridge(PiaMethod.Scope scope, PiaContext piaContext, BridgeRegistry bridgeRegistry) {
        this.scope = scope;
        this.context = piaContext;
        this.registry = bridgeRegistry;
    }

    public void start(final IBridgePort iBridgePort) {
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.bridge.PiaBridge$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                PiaBridge.this.m740lambda$start$0$combytedancepiacorebridgePiaBridge(iBridgePort);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$start$0$com-bytedance-pia-core-bridge-PiaBridge, reason: not valid java name */
    public /* synthetic */ void m740lambda$start$0$combytedancepiacorebridgePiaBridge(final IBridgePort iBridgePort) {
        this.port = iBridgePort;
        CacheHandle<JsonObject> cacheHandle = this.localMessageCache;
        Objects.requireNonNull(iBridgePort);
        cacheHandle.setConsumer(new IConsumer() { // from class: com.bytedance.pia.core.bridge.PiaBridge$$ExternalSyntheticLambda0
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public final void accept(Object obj) {
                IBridgePort.this.postMessage((JsonObject) obj);
            }
        });
        iBridgePort.setOnMessage(new IConsumer() { // from class: com.bytedance.pia.core.bridge.PiaBridge$$ExternalSyntheticLambda2
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public final void accept(Object obj) {
                PiaBridge.this.handleRemoteMessage((JsonObject) obj);
            }
        });
    }

    @Override // com.bytedance.pia.core.api.bridge.IPiaBridge
    public IPiaContext getContext() {
        return this.context;
    }

    private View getTargetView() {
        PiaContext piaContext = this.context;
        if (piaContext instanceof PiaRuntime) {
            return ((PiaRuntime) piaContext).getRenderView();
        }
        return null;
    }

    @Override // com.bytedance.pia.core.api.bridge.IPiaBridge
    public void send(String str, Object obj) {
        send(str, obj, null, null);
    }

    public void call(String str, Object obj) {
        call(str, obj, null, null);
    }

    public <T> void send(final String str, final Object obj, final IConsumer<T> iConsumer, final IConsumer<PiaMethod.Error> iConsumer2) {
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.bridge.PiaBridge$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                PiaBridge.this.m739lambda$send$2$combytedancepiacorebridgePiaBridge(obj, str, iConsumer2, iConsumer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x007a A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:20:0x000c, B:22:0x0010, B:8:0x006f, B:10:0x007a, B:12:0x0088, B:13:0x0098, B:16:0x009c, B:18:0x004e, B:28:0x0021, B:30:0x0030, B:31:0x0040, B:25:0x0015), top: B:19:0x000c, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009c A[Catch: all -> 0x0044, TRY_LEAVE, TryCatch #1 {all -> 0x0044, blocks: (B:20:0x000c, B:22:0x0010, B:8:0x006f, B:10:0x007a, B:12:0x0088, B:13:0x0098, B:16:0x009c, B:18:0x004e, B:28:0x0021, B:30:0x0030, B:31:0x0040, B:25:0x0015), top: B:19:0x000c, inners: #0 }] */
    /* renamed from: lambda$send$2$com-bytedance-pia-core-bridge-PiaBridge, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void m739lambda$send$2$combytedancepiacorebridgePiaBridge(final Object obj, final String str, final IConsumer iConsumer, final IConsumer iConsumer2) {
        JsonObject jsonTree;
        JsonObject jsonObject;
        int i;
        JsonObject raw;
        if (obj != null) {
            try {
                if (obj instanceof JsonObject) {
                    jsonTree = (JsonObject) obj;
                } else {
                    try {
                        jsonTree = GsonUtils.getGson().toJsonTree(obj);
                    } catch (Throwable th) {
                        report(-3, str, "parse data failed.", th);
                        PiaMethod.InvalidParamsError invalidParamsError = new PiaMethod.InvalidParamsError();
                        IPiaDebugger iPiaDebugger = this.debugger;
                        if (iPiaDebugger != null) {
                            iPiaDebugger.onJsbRequest(str, obj, invalidParamsError, getTargetView(), System.currentTimeMillis());
                        }
                        safeAccept(iConsumer, invalidParamsError);
                        return;
                    }
                }
                jsonObject = jsonTree;
            } catch (Throwable th2) {
                PiaMethod.InvalidParamsError invalidParamsError2 = new PiaMethod.InvalidParamsError(th2.toString());
                IPiaDebugger iPiaDebugger2 = this.debugger;
                if (iPiaDebugger2 != null) {
                    iPiaDebugger2.onJsbRequest(str, obj, invalidParamsError2, getTargetView(), System.currentTimeMillis());
                }
                safeAccept(iConsumer, invalidParamsError2);
                return;
            }
        } else {
            jsonObject = null;
        }
        if (iConsumer2 == null && iConsumer == null) {
            i = 0;
            raw = ProtocolMessage.toRaw(new ProtocolMessage.Invocation(i, str, jsonObject));
            if (raw != null) {
                report(-3, str, "create protocol message failed.", null);
                PiaMethod.InvalidParamsError invalidParamsError3 = new PiaMethod.InvalidParamsError();
                IPiaDebugger iPiaDebugger3 = this.debugger;
                if (iPiaDebugger3 != null) {
                    iPiaDebugger3.onJsbRequest(str, obj, invalidParamsError3, getTargetView(), System.currentTimeMillis());
                }
                safeAccept(iConsumer, invalidParamsError3);
                return;
            }
            this.localMessageCache.offer(raw);
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        IConsumer<ProtocolMessage.Callback> iConsumer3 = new IConsumer() { // from class: com.bytedance.pia.core.bridge.PiaBridge$$ExternalSyntheticLambda1
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public final void accept(Object obj2) {
                PiaBridge.this.m738lambda$send$1$combytedancepiacorebridgePiaBridge(iConsumer2, str, obj, currentTimeMillis, iConsumer, (ProtocolMessage.Callback) obj2);
            }
        };
        SparseArray<IConsumer<ProtocolMessage.Callback>> sparseArray = this.callbacks;
        int i2 = this.currentMessageID - 1;
        this.currentMessageID = i2;
        sparseArray.append(i2, iConsumer3);
        i = this.currentMessageID;
        raw = ProtocolMessage.toRaw(new ProtocolMessage.Invocation(i, str, jsonObject));
        if (raw != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$send$1$com-bytedance-pia-core-bridge-PiaBridge, reason: not valid java name */
    public /* synthetic */ void m738lambda$send$1$combytedancepiacorebridgePiaBridge(IConsumer iConsumer, String str, Object obj, long j, IConsumer iConsumer2, ProtocolMessage.Callback callback) {
        try {
            if (callback.getStatus() == 1 && iConsumer != null) {
                Class<?> typeArgument = ReflectUtils.getTypeArgument(iConsumer, IConsumer.class);
                if (typeArgument.isInstance(callback.getData())) {
                    JsonObject data = callback.getData();
                    iConsumer.accept(data);
                    IPiaDebugger iPiaDebugger = this.debugger;
                    if (iPiaDebugger != null) {
                        iPiaDebugger.onJsbRequest(str, obj, data, getTargetView(), j);
                        return;
                    }
                    return;
                }
                Object fromJson = GsonUtils.getGson().fromJson(callback.getData(), typeArgument);
                iConsumer.accept(fromJson);
                IPiaDebugger iPiaDebugger2 = this.debugger;
                if (iPiaDebugger2 != null) {
                    iPiaDebugger2.onJsbRequest(str, obj, fromJson, getTargetView(), j);
                    return;
                }
                return;
            }
            if (callback.getStatus() >= 1 || iConsumer2 == null) {
                return;
            }
            report(callback.getStatus(), str, callback.getMessage(), null);
            PiaMethod.Error error = new PiaMethod.Error(callback.getStatus(), callback.getMessage());
            IPiaDebugger iPiaDebugger3 = this.debugger;
            if (iPiaDebugger3 != null) {
                iPiaDebugger3.onJsbRequest(str, obj, error, getTargetView(), j);
            }
            iConsumer2.accept(error);
        } catch (Throwable th) {
            report(-4, str, "invoke callback failed.", th);
            PiaMethod.InvalidResultError invalidResultError = new PiaMethod.InvalidResultError(th.toString());
            IPiaDebugger iPiaDebugger4 = this.debugger;
            if (iPiaDebugger4 != null) {
                iPiaDebugger4.onJsbRequest(str, obj, invalidResultError, getTargetView(), j);
            }
            safeAccept(iConsumer2, invalidResultError);
        }
    }

    public <T> void call(final String str, final Object obj, final IConsumer<T> iConsumer, final IConsumer<PiaMethod.Error> iConsumer2) {
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.bridge.PiaBridge$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                PiaBridge.this.m736lambda$call$5$combytedancepiacorebridgePiaBridge(str, iConsumer2, obj, iConsumer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$call$5$com-bytedance-pia-core-bridge-PiaBridge, reason: not valid java name */
    public /* synthetic */ void m736lambda$call$5$combytedancepiacorebridgePiaBridge(final String str, final IConsumer iConsumer, final Object obj, final IConsumer iConsumer2) {
        PiaMethod.ICall<?, ?> iCall;
        Object obj2;
        try {
            Logger.m181i("[PiaBridge-Call] bridgeName:" + str);
            if (str != null && str.startsWith(INTERNAL_PREFIX)) {
                String substring = str.substring(13);
                String substring2 = substring.substring(0, substring.indexOf(46));
                Map<String, Boolean> base = Settings.get().getBase();
                if (base.containsKey(substring2) && Boolean.FALSE.equals(base.get(substring2))) {
                    report(-6, str, null, null);
                    safeAccept(iConsumer, new PiaMethod.SettingDisableError());
                    return;
                }
            }
            PiaMethod<?, ?> piaMethod = this.registry.get(str, this.scope);
            if (piaMethod != null) {
                PiaContext piaContext = this.context;
                iCall = piaMethod.makeCall(piaContext == null ? "" : piaContext.getCustomContext());
            } else {
                iCall = null;
            }
            if (iCall == null) {
                report(-2, str, null, null);
                safeAccept(iConsumer, new PiaMethod.UnregisteredError());
                return;
            }
            Class<?> typeArgument = ReflectUtils.getTypeArgument(iCall, PiaMethod.ICall.class);
            final Class<?> typeArgument2 = ReflectUtils.getTypeArgument(iCall, PiaMethod.ICall.class, 1);
            if (typeArgument != null && (obj instanceof JsonElement)) {
                try {
                    obj2 = GsonUtils.getGson().fromJson((JsonElement) obj, typeArgument);
                } catch (Throwable th) {
                    report(-3, str, "parse params failed.", th);
                    safeAccept(iConsumer, new PiaMethod.InvalidParamsError());
                    return;
                }
            } else {
                obj2 = (typeArgument == null || !typeArgument.isInstance(obj)) ? null : obj;
            }
            if (obj2 == null && Void.class != typeArgument) {
                report(-3, str, "unsupported params type.", null);
                safeAccept(iConsumer, new PiaMethod.InvalidParamsError());
            } else {
                final long currentTimeMillis = System.currentTimeMillis();
                iCall.invoke(this, obj2, new IConsumer() { // from class: com.bytedance.pia.core.bridge.PiaBridge$$ExternalSyntheticLambda8
                    @Override // com.bytedance.pia.core.api.utils.IConsumer
                    public final void accept(Object obj3) {
                        PiaBridge.this.m734lambda$call$3$combytedancepiacorebridgePiaBridge(iConsumer2, typeArgument2, str, iConsumer, obj, currentTimeMillis, obj3);
                    }
                }, new IConsumer() { // from class: com.bytedance.pia.core.bridge.PiaBridge$$ExternalSyntheticLambda9
                    @Override // com.bytedance.pia.core.api.utils.IConsumer
                    public final void accept(Object obj3) {
                        PiaBridge.this.m735lambda$call$4$combytedancepiacorebridgePiaBridge(str, obj, currentTimeMillis, iConsumer, obj3);
                    }
                });
            }
        } catch (Throwable th2) {
            IPiaDebugger iPiaDebugger = this.debugger;
            if (iPiaDebugger != null) {
                iPiaDebugger.onJsbRequest(str, obj, th2, getTargetView(), System.currentTimeMillis());
            }
            report(0, str, null, th2);
            safeAccept(iConsumer, new PiaMethod.Error(th2.toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$call$3$com-bytedance-pia-core-bridge-PiaBridge, reason: not valid java name */
    public /* synthetic */ void m734lambda$call$3$combytedancepiacorebridgePiaBridge(IConsumer iConsumer, Class cls, String str, IConsumer iConsumer2, Object obj, long j, Object obj2) {
        if (iConsumer == null) {
            return;
        }
        Class<?> typeArgument = ReflectUtils.getTypeArgument(iConsumer, IConsumer.class);
        if (Void.class == cls || Unit.class == cls) {
            obj2 = null;
        } else {
            if (typeArgument == null || !typeArgument.isInstance(obj2)) {
                if (JsonObject.class == typeArgument) {
                    try {
                        obj2 = GsonUtils.getGson().toJsonTree(obj2);
                    } catch (Throwable th) {
                        report(-4, str, null, th);
                        safeAccept(iConsumer2, new PiaMethod.InvalidResultError());
                        return;
                    }
                } else {
                    obj2 = null;
                }
            }
            if (obj2 == null && Void.class != typeArgument) {
                report(-4, str, "unsupported result type.", null);
                safeAccept(iConsumer2, new PiaMethod.InvalidResultError());
                return;
            }
        }
        IPiaDebugger iPiaDebugger = this.debugger;
        if (iPiaDebugger != null) {
            iPiaDebugger.onJsbRequest(str, obj, obj2, getTargetView(), j);
        }
        iConsumer.accept(obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$call$4$com-bytedance-pia-core-bridge-PiaBridge, reason: not valid java name */
    public /* synthetic */ void m735lambda$call$4$combytedancepiacorebridgePiaBridge(String str, Object obj, long j, IConsumer iConsumer, Object obj2) {
        PiaMethod.Error error = (PiaMethod.Error) obj2;
        IPiaDebugger iPiaDebugger = this.debugger;
        if (iPiaDebugger != null) {
            iPiaDebugger.onJsbRequest(str, obj, error, getTargetView(), j);
        }
        report(error.getCode(), null, error.getMessage(), error.getCause());
        safeAccept(iConsumer, error);
    }

    public static <T> void callOnce(String str, Object obj, IConsumer<T> iConsumer, IConsumer<PiaMethod.Error> iConsumer2) {
        new PiaBridge(PiaMethod.Scope.All, null, new BridgeRegistry()).call(str, obj, iConsumer, iConsumer2);
    }

    public void close() {
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.bridge.PiaBridge$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                PiaBridge.this.m737lambda$close$6$combytedancepiacorebridgePiaBridge();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$close$6$com-bytedance-pia-core-bridge-PiaBridge, reason: not valid java name */
    public /* synthetic */ void m737lambda$close$6$combytedancepiacorebridgePiaBridge() {
        if (this.hasClosed) {
            return;
        }
        this.hasClosed = true;
        this.localMessageCache.close();
        IBridgePort iBridgePort = this.port;
        if (iBridgePort != null) {
            iBridgePort.close();
        }
    }

    public void setDebugger(IPiaDebugger iPiaDebugger) {
        this.debugger = iPiaDebugger;
    }

    private static <T> void safeAccept(IConsumer<T> iConsumer, T t) {
        if (iConsumer != null) {
            try {
                iConsumer.accept(t);
            } catch (Throwable th) {
                Logger.m179e("[Bridge] invoke callback error:", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRemoteMessage(final JsonObject jsonObject) {
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.bridge.PiaBridge$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                PiaBridge.this.m159xf6d85f4(jsonObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$handleRemoteMessage$8$com-bytedance-pia-core-bridge-PiaBridge */
    public /* synthetic */ void m159xf6d85f4(JsonObject jsonObject) {
        IConsumer<ProtocolMessage.Callback> iConsumer;
        ProtocolMessage fromRaw = ProtocolMessage.fromRaw(jsonObject);
        if (fromRaw == null) {
            return;
        }
        final ProtocolMessage.Invocation asInvocation = fromRaw.asInvocation();
        if (asInvocation != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            call(asInvocation.getName(), asInvocation.getData(), new IConsumer<JsonObject>() { // from class: com.bytedance.pia.core.bridge.PiaBridge.1
                @Override // com.bytedance.pia.core.api.utils.IConsumer
                public void accept(JsonObject jsonObject2) {
                    JsonObject raw = ProtocolMessage.toRaw(new ProtocolMessage.Callback(asInvocation.getId(), 1, jsonObject2, null));
                    if (raw == null || !atomicBoolean.compareAndSet(false, true)) {
                        return;
                    }
                    PiaBridge.this.localMessageCache.offer(raw);
                }
            }, new IConsumer() { // from class: com.bytedance.pia.core.bridge.PiaBridge$$ExternalSyntheticLambda5
                @Override // com.bytedance.pia.core.api.utils.IConsumer
                public final void accept(Object obj) {
                    PiaBridge.this.m158x82cd5af3(asInvocation, atomicBoolean, (PiaMethod.Error) obj);
                }
            });
            return;
        }
        ProtocolMessage.Callback asCallback = fromRaw.asCallback();
        if (asCallback == null || (iConsumer = this.callbacks.get(asCallback.getId())) == null) {
            return;
        }
        this.callbacks.remove(asCallback.getId());
        iConsumer.accept(asCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$handleRemoteMessage$7$com-bytedance-pia-core-bridge-PiaBridge */
    public /* synthetic */ void m158x82cd5af3(ProtocolMessage.Invocation invocation, AtomicBoolean atomicBoolean, PiaMethod.Error error) {
        JsonObject jsonObject;
        JsonObject raw;
        if (error.getMessage() != null && error.getMessage().startsWith("{")) {
            try {
                jsonObject = (JsonObject) GsonUtils.getParser().parse(error.getMessage());
            } catch (Throwable unused) {
            }
            raw = ProtocolMessage.toRaw(new ProtocolMessage.Callback(invocation.getId(), error.getCode(), jsonObject, error.getMessage()));
            if (raw == null && atomicBoolean.compareAndSet(false, true)) {
                this.localMessageCache.offer(raw);
                return;
            }
        }
        jsonObject = null;
        raw = ProtocolMessage.toRaw(new ProtocolMessage.Callback(invocation.getId(), error.getCode(), jsonObject, error.getMessage()));
        if (raw == null) {
        }
    }

    private void report(int i, String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder("name=");
        sb.append(str);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(", message=");
            sb.append(str2);
        }
        if (th != null) {
            sb.append(", error=");
            sb.append(Log.getStackTraceString(th));
        }
        PiaContext piaContext = this.context;
        if (piaContext != null) {
            piaContext.getMetrics().onError("bridge", i, sb.toString());
        }
    }
}
