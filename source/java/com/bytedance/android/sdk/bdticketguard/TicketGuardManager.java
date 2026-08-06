package com.bytedance.android.sdk.bdticketguard;

import android.util.Base64;
import android.util.Log;
import com.bytedance.android.sdk.bdticketguard.ServerDataV2;
import com.bytedance.android.sdk.bdticketguard.TicketDataBean;
import com.bytedance.applog.server.Api;
import com.bytedance.bdturing.methods.JsCallParser;
import com.google.gson.Gson;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: TicketGuardManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 b2\u00020\u0001:\u0001bB\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\rH&J\u0017\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\rH\u0016¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016JB\u0010,\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0.\u0018\u00010-2\u0006\u0010/\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u00010\r2\b\u00101\u001a\u0004\u0018\u00010\r2\b\u00102\u001a\u0004\u0018\u00010\rH\u0002J\b\u00103\u001a\u00020\rH&J\b\u00104\u001a\u00020\rH&J\b\u00105\u001a\u00020%H&J\b\u00106\u001a\u00020\rH&J\u0012\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020\rH&J\u0010\u0010:\u001a\u00020\u00192\u0006\u0010;\u001a\u00020<H\u0016J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00020>0-2\u0006\u0010?\u001a\u00020@H\u0016J\u001f\u0010A\u001a\u00020\u00192\b\u0010B\u001a\u0004\u0018\u00010%2\b\u0010C\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010DJ\u001a\u0010E\u001a\u00020\u00192\u0006\u0010F\u001a\u00020\r2\b\u0010C\u001a\u0004\u0018\u00010\u001dH&J\u001a\u0010G\u001a\u00020\u00192\u0006\u0010F\u001a\u00020\r2\b\u0010C\u001a\u0004\u0018\u00010\u001dH&J\u001a\u0010H\u001a\u00020\u00192\u0006\u0010F\u001a\u00020\r2\b\u0010C\u001a\u0004\u0018\u00010\u001dH&J\u000e\u0010I\u001a\u00020\u00192\u0006\u0010J\u001a\u00020\rJ\b\u0010K\u001a\u00020%H&J\u0016\u0010L\u001a\u00020\u00192\u0006\u0010M\u001a\u00020\r2\u0006\u0010*\u001a\u00020NJ\u0010\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010Q\u001a\u00020\rJ\u0012\u00101\u001a\u00020\u00192\b\u0010C\u001a\u0004\u0018\u00010RH\u0016J\u0018\u0010S\u001a\u00020\u00192\b\u0010C\u001a\u0004\u0018\u00010R2\u0006\u0010F\u001a\u00020\rJ\u0010\u0010T\u001a\u00020\u00192\u0006\u0010U\u001a\u00020\rH&J&\u0010V\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00122\u0014\u0010C\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0019\u0018\u00010WH\u0016J\u001a\u0010X\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010C\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010Y\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010C\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010Z\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010C\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010[\u001a\u00020\u00192\u0006\u0010F\u001a\u00020\r2\b\u0010C\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010\\\u001a\u00020\u0019H\u0002J\u0010\u0010]\u001a\u00020\u00192\u0006\u0010^\u001a\u000208H&J\u001e\u0010_\u001a\u00020\u0019*\u00020N2\u0006\u0010`\u001a\u00020\r2\b\u0010a\u001a\u0004\u0018\u00010\rH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@DX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006c"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/TicketGuardManager;", "Lcom/bytedance/android/sdk/bdticketguard/TicketGuardService;", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "initLock", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initStatusMap", "", "", "Lcom/bytedance/android/sdk/bdticketguard/InitStatus;", "getInitStatusMap", "()Ljava/util/Map;", "<set-?>", "Lcom/bytedance/android/sdk/bdticketguard/TicketGuardInitParam;", "ticketGuardInitParam", "getTicketGuardInitParam", "()Lcom/bytedance/android/sdk/bdticketguard/TicketGuardInitParam;", "setTicketGuardInitParam", "(Lcom/bytedance/android/sdk/bdticketguard/TicketGuardInitParam;)V", "commonInit", "", "func", "Lkotlin/Function0;", "loadAllDataCallback", "Lcom/bytedance/android/sdk/bdticketguard/TicketInitCallback;", "getBase64ReePub", "getConsumerRequestContent", "Lcom/bytedance/android/sdk/bdticketguard/ConsumerRequestContent;", "consumerRequestParam", "Lcom/bytedance/android/sdk/bdticketguard/ConsumerRequestParam;", "getCsr", "getInitResult", "", "type", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getProviderContent", "Lcom/bytedance/android/sdk/bdticketguard/ProviderRequestContent;", "params", "Lcom/bytedance/android/sdk/bdticketguard/ProviderRequestParam;", "getProviderHeaders", "", "Landroid/util/Pair;", "param", "requestCsr", "requestCert", "reePub", "getReeCreateLog", "getTeeCreateLog", "getTeeEverFail", "getTeePublic", "getTicketData", "Lcom/bytedance/android/sdk/bdticketguard/TicketDataBean;", "ticket", "handleConsumerResponse", "handleConsumerResponseParam", "Lcom/bytedance/android/sdk/bdticketguard/HandleConsumerResponseParam;", "handleProviderResponse", "Lcom/bytedance/android/sdk/bdticketguard/TicketData;", "handleProviderResponseParams", "Lcom/bytedance/android/sdk/bdticketguard/HandleProviderResponseParam;", "initCallback", "initResult", JsCallParser.VALUE_CALLBACK, "(Ljava/lang/Boolean;Lcom/bytedance/android/sdk/bdticketguard/TicketInitCallback;)V", "loadEncryption", "scene", "loadRee", "loadTee", "log", "msg", "needRee", "onEvent", "event", "Lorg/json/JSONObject;", "parseServerData", "Lcom/bytedance/android/sdk/bdticketguard/ServerData;", "serverData", "Lcom/bytedance/android/sdk/bdticketguard/GetCertCallback;", "requestCertInner", "setTeeEverFail", "reason", "tryInit", "Lkotlin/Function1;", "tryInitEncryption", "tryInitRee", "tryInitTee", "tryLoadData", "tryUseTTNet", "updateTicketData", "ticketData", "safePut", Api.KEY_ENCRYPT_RESP_KEY, "value", "Companion", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class TicketGuardManager implements TicketGuardService {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TicketGuardManager.class), "gson", "getGson()Lcom/google/gson/Gson;"))};
    public static final String LOG_TAG = "bd-ticket-guard";
    public static final String TAG = "TicketGuardManager";

    /* renamed from: gson$delegate, reason: from kotlin metadata */
    private final Lazy gson = LazyKt.lazy(new Function0<Gson>() { // from class: com.bytedance.android.sdk.bdticketguard.TicketGuardManager$gson$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Gson m406invoke() {
            return new Gson();
        }
    });
    private final AtomicBoolean initLock = new AtomicBoolean(false);
    private final Map<String, InitStatus> initStatusMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(TicketGuardApiKt.INIT_STATUS_REE, new InitStatus()), TuplesKt.to(TicketGuardApiKt.INIT_STATUS_TEE, new InitStatus()), TuplesKt.to(TicketGuardApiKt.INIT_STATUS_ENCRYPTION, new InitStatus())});
    protected TicketGuardInitParam ticketGuardInitParam;

    public abstract String getBase64ReePub();

    public abstract String getCsr();

    /* JADX INFO: Access modifiers changed from: protected */
    public final Gson getGson() {
        Lazy lazy = this.gson;
        KProperty kProperty = $$delegatedProperties[0];
        return (Gson) lazy.getValue();
    }

    public abstract String getReeCreateLog();

    public abstract String getTeeCreateLog();

    public abstract boolean getTeeEverFail();

    public abstract String getTeePublic();

    public abstract TicketDataBean getTicketData(String ticket);

    public abstract void loadEncryption(String scene, TicketInitCallback callback);

    public abstract void loadRee(String scene, TicketInitCallback callback);

    public abstract void loadTee(String scene, TicketInitCallback callback);

    public abstract boolean needRee();

    public abstract void setTeeEverFail(String reason);

    public abstract void updateTicketData(TicketDataBean ticketData);

    public final TicketGuardInitParam getTicketGuardInitParam() {
        TicketGuardInitParam ticketGuardInitParam = this.ticketGuardInitParam;
        if (ticketGuardInitParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ticketGuardInitParam");
        }
        return ticketGuardInitParam;
    }

    protected final void setTicketGuardInitParam(TicketGuardInitParam ticketGuardInitParam) {
        Intrinsics.checkParameterIsNotNull(ticketGuardInitParam, "<set-?>");
        this.ticketGuardInitParam = ticketGuardInitParam;
    }

    public final Map<String, InitStatus> getInitStatusMap() {
        return this.initStatusMap;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public void tryInit(TicketGuardInitParam ticketGuardInitParam, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(ticketGuardInitParam, "ticketGuardInitParam");
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        commonInit(ticketGuardInitParam, new Function0<Unit>() { // from class: com.bytedance.android.sdk.bdticketguard.TicketGuardManager$tryInit$1
            /* renamed from: invoke, reason: collision with other method in class */
            public final void m407invoke() {
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m407invoke();
                return Unit.INSTANCE;
            }
        }, new TicketInitCallback() { // from class: com.bytedance.android.sdk.bdticketguard.TicketGuardManager$tryInit$2
            @Override // com.bytedance.android.sdk.bdticketguard.TicketInitCallback
            public void onFinish(Boolean initResult) {
                if (atomicInteger.addAndGet(1) == TicketGuardManager.this.getInitStatusMap().size()) {
                    Iterator<InitStatus> it = TicketGuardManager.this.getInitStatusMap().values().iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual(it.next().getInitResult(), false)) {
                            Function1 function1 = callback;
                            if (function1 != null) {
                                return;
                            }
                            return;
                        }
                    }
                    Function1 function12 = callback;
                    if (function12 != null) {
                    }
                }
            }
        });
    }

    static /* synthetic */ void commonInit$default(TicketGuardManager ticketGuardManager, TicketGuardInitParam ticketGuardInitParam, Function0 function0, TicketInitCallback ticketInitCallback, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: commonInit");
        }
        if ((i & 4) != 0) {
            ticketInitCallback = null;
        }
        ticketGuardManager.commonInit(ticketGuardInitParam, function0, ticketInitCallback);
    }

    private final void commonInit(TicketGuardInitParam ticketGuardInitParam, final Function0<Unit> func, final TicketInitCallback loadAllDataCallback) {
        this.ticketGuardInitParam = ticketGuardInitParam;
        new Thread(new Runnable() { // from class: com.bytedance.android.sdk.bdticketguard.TicketGuardManager$commonInit$1
            @Override // java.lang.Runnable
            public final void run() {
                AtomicBoolean atomicBoolean;
                atomicBoolean = TicketGuardManager.this.initLock;
                if (atomicBoolean.compareAndSet(false, true)) {
                    TicketGuardManager.this.tryUseTTNet();
                    TicketGuardEventHelper.monitorSdkLaunch();
                }
                func.invoke();
                TicketGuardManager.this.tryLoadData("init", loadAllDataCallback);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryLoadData(String scene, TicketInitCallback callback) {
        loadRee(scene, callback);
        loadTee(scene, callback);
        loadEncryption(scene, callback);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public void tryInitRee(TicketGuardInitParam ticketGuardInitParam, final TicketInitCallback callback) {
        Intrinsics.checkParameterIsNotNull(ticketGuardInitParam, "ticketGuardInitParam");
        commonInit$default(this, ticketGuardInitParam, new Function0<Unit>() { // from class: com.bytedance.android.sdk.bdticketguard.TicketGuardManager$tryInitRee$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m409invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m409invoke() {
                TicketGuardManager.this.loadRee("init", callback);
            }
        }, null, 4, null);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public void tryInitTee(TicketGuardInitParam ticketGuardInitParam, final TicketInitCallback callback) {
        Intrinsics.checkParameterIsNotNull(ticketGuardInitParam, "ticketGuardInitParam");
        commonInit$default(this, ticketGuardInitParam, new Function0<Unit>() { // from class: com.bytedance.android.sdk.bdticketguard.TicketGuardManager$tryInitTee$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m410invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m410invoke() {
                TicketGuardManager.this.loadTee("init", callback);
            }
        }, null, 4, null);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public void tryInitEncryption(TicketGuardInitParam ticketGuardInitParam, final TicketInitCallback callback) {
        Intrinsics.checkParameterIsNotNull(ticketGuardInitParam, "ticketGuardInitParam");
        commonInit$default(this, ticketGuardInitParam, new Function0<Unit>() { // from class: com.bytedance.android.sdk.bdticketguard.TicketGuardManager$tryInitEncryption$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m408invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m408invoke() {
                TicketGuardManager.this.loadEncryption("init", callback);
            }
        }, null, 4, null);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public Boolean getInitResult(String type) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        InitStatus initStatus = this.initStatusMap.get(type);
        if (initStatus != null) {
            return initStatus.getInitResult();
        }
        return null;
    }

    public final void initCallback(Boolean initResult, TicketInitCallback callback) {
        if (callback != null) {
            callback.onFinish(initResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryUseTTNet() {
        try {
            Class.forName("com.bytedance.android.sdk.bdticketguard.TicketGuardInjectManager").getMethod("tryInit", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            log(message);
        }
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public void requestCert(GetCertCallback callback) {
        requestCertInner(callback, "network");
    }

    public final void requestCertInner(final GetCertCallback callback, String scene) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        String clientCert = getClientCert();
        boolean z = clientCert == null || clientCert.length() == 0;
        boolean z2 = getServerCert() == null;
        String csr = z ? getCsr() : null;
        log("requestCert, needClient=" + z + ", needServer=" + z2);
        TicketGuardNetworkHelper.getCert(csr, z2, new GetCertCallback() { // from class: com.bytedance.android.sdk.bdticketguard.TicketGuardManager$requestCertInner$1
            @Override // com.bytedance.android.sdk.bdticketguard.GetCertCallback
            public void onCallback(String resClientCert, String resServerCert) {
                TicketGuardManager.this.updateLocalCert(resClientCert, resServerCert);
                GetCertCallback getCertCallback = callback;
                if (getCertCallback != null) {
                    getCertCallback.onCallback(resClientCert, resServerCert);
                }
            }
        }, scene);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public ProviderRequestContent getProviderContent(ProviderRequestParam params) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        tryLoadData(TicketGuardManagerKt.SCENE_TICKET_NETWORK, null);
        String clientCert = getClientCert();
        return new ProviderRequestContent(clientCert, getProviderHeaders(params, getCsr(), clientCert, getBase64ReePub()), params);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.sdk.bdticketguard.TicketGuardManager$getProviderHeaders$2] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.bytedance.android.sdk.bdticketguard.TicketGuardManager$getProviderHeaders$1] */
    private final List<android.util.Pair<String, String>> getProviderHeaders(final ProviderRequestParam param, String requestCsr, String requestCert, String reePub) {
        String serialNumber;
        final long currentTimeMillis = System.currentTimeMillis();
        final ArrayList arrayList = new ArrayList();
        ?? r7 = new Function0<Unit>() { // from class: com.bytedance.android.sdk.bdticketguard.TicketGuardManager$getProviderHeaders$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m404invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m404invoke() {
                TicketGuardManager.this.log("getProviderHeaders: success, headers=" + arrayList);
                TicketGuardEventHelper.monitorGetProviderHeaders(param.getPath(), true, null, System.currentTimeMillis() - currentTimeMillis);
            }
        };
        ?? r0 = new Function0<Unit>() { // from class: com.bytedance.android.sdk.bdticketguard.TicketGuardManager$getProviderHeaders$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m405invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m405invoke() {
                TicketGuardManager.this.log("getProviderHeaders: fail");
                TicketGuardEventHelper.monitorGetProviderHeaders(param.getPath(), false, null, 0L);
            }
        };
        if (!param.getReeOnly()) {
            String str = requestCert;
            if (str == null || str.length() == 0) {
                String str2 = requestCsr;
                if (!(str2 == null || str2.length() == 0)) {
                    Charset charset = Charsets.UTF_8;
                    if (requestCsr == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    byte[] bytes = requestCsr.getBytes(charset);
                    Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                    arrayList.add(new android.util.Pair(TicketGuardApiKt.HEADER_CLIENT_CSR, Base64.encodeToString(bytes, 2)));
                }
            } else {
                arrayList.add(new android.util.Pair(TicketGuardApiKt.HEADER_CLIENT_CERT, requestCert));
            }
            if (arrayList.isEmpty()) {
                setTeeEverFail("get provider header, csr and cert are empty");
            }
        }
        String str3 = "0";
        if ((needRee() || param.getNeedEncrypt()) && reePub != null) {
            arrayList.add(new android.util.Pair(TicketGuardApiKt.HEADER_REE_PUBLIC_KEY, reePub));
            arrayList.add(new android.util.Pair(TicketGuardApiKt.HEADER_TEE_STATUS, getTeeEverFail() ? "1" : "0"));
        }
        if (param.getNeedEncrypt()) {
            ServerCert serverCert = getServerCert();
            if (serverCert != null && (serialNumber = serverCert.getSerialNumber()) != null) {
                str3 = serialNumber;
            }
            arrayList.add(new android.util.Pair(TicketGuardApiKt.HEADER_SERVER_CERT_SN, str3));
        }
        if (!arrayList.isEmpty()) {
            arrayList.add(new android.util.Pair(TicketGuardApiKt.HEADER_VERSION, TicketGuardApiKt.TICKET_GUARD_VERSION));
            arrayList.add(new android.util.Pair(TicketGuardApiKt.HEADER_ITERATION_VERSION, TicketGuardApiKt.TICKET_GUARD_ITERATION_VERSION));
            r7.m404invoke();
            return arrayList;
        }
        r0.m405invoke();
        return null;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public List<TicketData> handleProviderResponse(HandleProviderResponseParam handleProviderResponseParams) {
        String str;
        Iterator<android.util.Pair<String, String>> it;
        String str2;
        ArrayList<ServerDataV2.ServerDataItem> itemArray;
        Intrinsics.checkParameterIsNotNull(handleProviderResponseParams, "handleProviderResponseParams");
        String requestCert = handleProviderResponseParams.getRequestContent().getRequestCert();
        String str3 = requestCert;
        boolean z = str3 == null || str3.length() == 0;
        String path = handleProviderResponseParams.getRequestContent().getRequestParam().getPath();
        ArrayList arrayList = new ArrayList();
        Iterator<android.util.Pair<String, String>> it2 = handleProviderResponseParams.getResponseHeaders().iterator();
        String str4 = "";
        ServerData serverData = null;
        String str5 = "";
        String str6 = str5;
        while (it2.hasNext()) {
            android.util.Pair<String, String> next = it2.next();
            CharSequence charSequence = (CharSequence) next.second;
            if (charSequence == null || charSequence.length() == 0) {
                str = requestCert;
                str2 = path;
                it = it2;
            } else {
                Object obj = next.first;
                Intrinsics.checkExpressionValueIsNotNull(obj, "resHeader.first");
                String str7 = (String) obj;
                Locale locale = Locale.ROOT;
                Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
                if (str7 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = str7.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                str = requestCert;
                Locale locale2 = Locale.ROOT;
                Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.ROOT");
                String lowerCase2 = TicketGuardApiKt.HEADER_LOGID.toLowerCase(locale2);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                    Object obj2 = next.second;
                    Intrinsics.checkExpressionValueIsNotNull(obj2, "resHeader.second");
                    str4 = (String) obj2;
                    str2 = path;
                    it = it2;
                } else {
                    Locale locale3 = Locale.ROOT;
                    Intrinsics.checkExpressionValueIsNotNull(locale3, "Locale.ROOT");
                    it = it2;
                    String lowerCase3 = TicketGuardApiKt.HEADER_SERVER_DATA.toLowerCase(locale3);
                    Intrinsics.checkExpressionValueIsNotNull(lowerCase3, "(this as java.lang.String).toLowerCase(locale)");
                    if (Intrinsics.areEqual(lowerCase, lowerCase3)) {
                        Object obj3 = next.second;
                        Intrinsics.checkExpressionValueIsNotNull(obj3, "resHeader.second");
                        String str8 = (String) obj3;
                        Charset charset = Charsets.UTF_8;
                        if (str8 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        byte[] bytes = str8.getBytes(charset);
                        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                        byte[] decode = Base64.decode(bytes, 0);
                        Intrinsics.checkExpressionValueIsNotNull(decode, "Base64.decode(resHeader.…eArray(), Base64.DEFAULT)");
                        str5 = new String(decode, Charsets.UTF_8);
                        serverData = parseServerData(str5);
                        if (serverData instanceof ServerDataV1) {
                            if (z) {
                                String clientCert = ((ServerDataV1) serverData).getClientCert();
                                if (clientCert.length() > 0) {
                                    Charset charset2 = Charsets.UTF_8;
                                    if (clientCert == null) {
                                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                    }
                                    byte[] bytes2 = clientCert.getBytes(charset2);
                                    Intrinsics.checkExpressionValueIsNotNull(bytes2, "(this as java.lang.String).getBytes(charset)");
                                    String encodeToString = Base64.encodeToString(bytes2, 2);
                                    updateLocalCert(clientCert, null);
                                    str = encodeToString;
                                }
                                str6 = clientCert;
                            }
                            String str9 = path + '_' + handleProviderResponseParams.getType();
                            Charset charset3 = Charsets.UTF_8;
                            if (str9 == null) {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                            }
                            byte[] bytes3 = str9.getBytes(charset3);
                            Intrinsics.checkExpressionValueIsNotNull(bytes3, "(this as java.lang.String).getBytes(charset)");
                            String encodeToString2 = Base64.encodeToString(bytes3, 2);
                            Intrinsics.checkExpressionValueIsNotNull(encodeToString2, "saveTypeKey");
                            ServerDataV1 serverDataV1 = (ServerDataV1) serverData;
                            TicketDataBean ticketDataBean = new TicketDataBean(encodeToString2, serverDataV1.getTicket(), serverDataV1.getTsSign(), null, str);
                            if (handleProviderResponseParams.getNeedSave()) {
                                updateTicketData(ticketDataBean);
                            }
                            arrayList.add(ticketDataBean.toTicketData());
                        } else if ((serverData instanceof ServerDataV2) && (itemArray = ((ServerDataV2) serverData).getItemArray()) != null) {
                            int size = itemArray.size();
                            int i = 0;
                            while (i < size) {
                                ServerDataV2.ServerDataItem serverDataItem = itemArray.get(i);
                                Intrinsics.checkExpressionValueIsNotNull(serverDataItem, "it[i]");
                                ServerDataV2.ServerDataItem serverDataItem2 = serverDataItem;
                                ArrayList<ServerDataV2.ServerDataItem> arrayList2 = itemArray;
                                String str10 = path;
                                String str11 = path + '_' + handleProviderResponseParams.getType() + '_' + i;
                                Charset charset4 = Charsets.UTF_8;
                                if (str11 == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                }
                                byte[] bytes4 = str11.getBytes(charset4);
                                Intrinsics.checkExpressionValueIsNotNull(bytes4, "(this as java.lang.String).getBytes(charset)");
                                String encodeToString3 = Base64.encodeToString(bytes4, 2);
                                Intrinsics.checkExpressionValueIsNotNull(encodeToString3, "saveTypeKey");
                                TicketDataBean ticketDataBean2 = new TicketDataBean(encodeToString3, serverDataItem2.getTicket(), serverDataItem2.getTsSign(), serverDataItem2.getTsSignRee(), null);
                                if (handleProviderResponseParams.getNeedSave()) {
                                    updateTicketData(ticketDataBean2);
                                }
                                arrayList.add(ticketDataBean2.toTicketData());
                                i++;
                                path = str10;
                                itemArray = arrayList2;
                            }
                        }
                        str2 = path;
                    } else {
                        str2 = path;
                        Locale locale4 = Locale.ROOT;
                        Intrinsics.checkExpressionValueIsNotNull(locale4, "Locale.ROOT");
                        String lowerCase4 = TicketGuardApiKt.HEADER_CLIENT_CERT.toLowerCase(locale4);
                        Intrinsics.checkExpressionValueIsNotNull(lowerCase4, "(this as java.lang.String).toLowerCase(locale)");
                        if (!Intrinsics.areEqual(lowerCase, lowerCase4)) {
                            Locale locale5 = Locale.ROOT;
                            Intrinsics.checkExpressionValueIsNotNull(locale5, "Locale.ROOT");
                            String lowerCase5 = TicketGuardApiKt.HEADER_SERVER_CERT.toLowerCase(locale5);
                            Intrinsics.checkExpressionValueIsNotNull(lowerCase5, "(this as java.lang.String).toLowerCase(locale)");
                            if (Intrinsics.areEqual(lowerCase, lowerCase5)) {
                                byte[] decode2 = Base64.decode((String) next.second, 0);
                                Intrinsics.checkExpressionValueIsNotNull(decode2, "Base64.decode(resHeader.second, Base64.DEFAULT)");
                                updateLocalCert(null, new String(decode2, Charsets.UTF_8));
                                requestCert = str;
                                it2 = it;
                                path = str2;
                            }
                        } else if (z) {
                            CharSequence charSequence2 = (CharSequence) next.second;
                            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                                String str12 = (String) next.second;
                                byte[] decode3 = Base64.decode(str12, 0);
                                Intrinsics.checkExpressionValueIsNotNull(decode3, "Base64.decode(currentCert, Base64.DEFAULT)");
                                str6 = new String(decode3, Charsets.UTF_8);
                                updateLocalCert(str6, null);
                                str = str12;
                            }
                        }
                    }
                }
            }
            requestCert = str;
            it2 = it;
            path = str2;
        }
        ArrayList arrayList3 = arrayList;
        TicketGuardEventHelper.monitorGetTicket(new ProviderResponseContent(handleProviderResponseParams, str4, str5, serverData, arrayList3, str6));
        return arrayList3;
    }

    public final ServerData parseServerData(String serverData) {
        ServerData serverData2;
        Intrinsics.checkParameterIsNotNull(serverData, "serverData");
        try {
            serverData2 = (ServerData) getGson().fromJson(serverData, ServerDataV2.class);
        } catch (Throwable th) {
            log("parse v2 server data failed, e=" + Log.getStackTraceString(th));
            serverData2 = null;
        }
        ServerDataV2 serverDataV2 = (ServerDataV2) (!(serverData2 instanceof ServerDataV2) ? null : serverData2);
        ArrayList<ServerDataV2.ServerDataItem> itemArray = serverDataV2 != null ? serverDataV2.getItemArray() : null;
        if (itemArray != null && !itemArray.isEmpty()) {
            return serverData2;
        }
        try {
            return (ServerData) getGson().fromJson(serverData, ServerDataV1.class);
        } catch (Throwable th2) {
            log("parse v1 server data failed, e=" + Log.getStackTraceString(th2));
            return serverData2;
        }
    }

    private final void safePut(JSONObject jSONObject, String str, String str2) {
        String str3 = str2;
        if (str3 == null || str3.length() == 0) {
            return;
        }
        try {
            jSONObject.put(str, str2);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d4  */
    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ConsumerRequestContent getConsumerRequestContent(ConsumerRequestParam consumerRequestParam) {
        TicketDataBean.CombineTsSign combineTsSign;
        ClientData clientData;
        String str;
        boolean z;
        String ts_sign_ree;
        String str2;
        boolean z2;
        String str3;
        String str4;
        boolean z3;
        boolean z4;
        String json;
        String ts_sign;
        boolean z5;
        Intrinsics.checkParameterIsNotNull(consumerRequestParam, "consumerRequestParam");
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        tryLoadData(TicketGuardManagerKt.SCENE_TICKET_NETWORK, null);
        arrayList.add(new android.util.Pair(TicketGuardApiKt.HEADER_VERSION, TicketGuardApiKt.TICKET_GUARD_VERSION));
        arrayList.add(new android.util.Pair(TicketGuardApiKt.HEADER_ITERATION_VERSION, TicketGuardApiKt.TICKET_GUARD_ITERATION_VERSION));
        String target = consumerRequestParam.getTarget();
        String path = consumerRequestParam.getPath();
        long j = 1000;
        long currentTimeMillis = System.currentTimeMillis() / j;
        String str5 = "ticket=" + target + "&path=" + path + "&timestamp=" + currentTimeMillis;
        Log.d(LOG_TAG, "contentToSign=" + str5);
        TicketDataBean ticketData = getTicketData(target);
        ClientData clientData2 = new ClientData("ticket,path,timestamp", currentTimeMillis, null, null, null, null, 60, null);
        StringBuilder sb2 = new StringBuilder();
        if (consumerRequestParam instanceof ConsumerRequestParamWithTsSign) {
            log("is ConsumerRequestWithTsSign");
            String tsSign = ((ConsumerRequestParamWithTsSign) consumerRequestParam).getTsSign();
            log("input tsSign=" + tsSign);
            try {
                combineTsSign = (TicketDataBean.CombineTsSign) getGson().fromJson(tsSign, TicketDataBean.CombineTsSign.class);
            } catch (Throwable th) {
                String stackTraceString = Log.getStackTraceString(th);
                Intrinsics.checkExpressionValueIsNotNull(stackTraceString, "Log.getStackTraceString(ignore)");
                TicketGuardEventHelper.monitorParseJsonError("custom_ts_sign", tsSign, stackTraceString);
                combineTsSign = null;
            }
            if (combineTsSign == null) {
                combineTsSign = new TicketDataBean.CombineTsSign(tsSign, null);
            }
        } else {
            log("is ConsumerRequest");
            combineTsSign = null;
        }
        log("combineTsSign=" + combineTsSign);
        if (consumerRequestParam.getReeOnly()) {
            clientData = clientData2;
            str = str5;
        } else {
            String cert = ticketData != null ? ticketData.getCert() : null;
            String str6 = cert;
            if (str6 == null || str6.length() == 0) {
                cert = getClientCert();
            }
            if (combineTsSign == null || (ts_sign = combineTsSign.getTs_sign()) == null) {
                ts_sign = ticketData != null ? ticketData.getTs_sign() : null;
            }
            str = str5;
            String sign = sign(str, path);
            String str7 = cert;
            if (str7 == null || str7.length() == 0) {
                sb.append("tee error: client cert, ");
                z5 = false;
            } else {
                arrayList.add(new android.util.Pair(TicketGuardApiKt.HEADER_CLIENT_CERT, cert));
                z5 = true;
            }
            String str8 = ts_sign;
            if (str8 == null || str8.length() == 0) {
                sb.append("tee error: tsSign, ");
                clientData = clientData2;
                z5 = false;
            } else {
                clientData = clientData2;
                clientData.setTsSign(ts_sign);
            }
            String str9 = sign;
            if (str9 == null || str9.length() == 0) {
                sb.append("tee error: sign, ");
                z5 = false;
            } else {
                clientData.setRequestSign(sign);
            }
            if (z5) {
                sb2.append("tee, ");
                z = true;
                if (!needRee() || consumerRequestParam.getReeOnly() || consumerRequestParam.getNeedEncrypt()) {
                    String base64ReePub = getBase64ReePub();
                    if (combineTsSign != null || (ts_sign_ree = combineTsSign.getTs_sign_ree()) == null) {
                        ts_sign_ree = ticketData == null ? ticketData.getTs_sign_ree() : null;
                    }
                    String reeSign = reeSign(str, path);
                    str2 = base64ReePub;
                    if (!(str2 != null || str2.length() == 0)) {
                        sb.append("ree error: public key, ");
                        z2 = false;
                    } else {
                        arrayList.add(new android.util.Pair(TicketGuardApiKt.HEADER_REE_PUBLIC_KEY, base64ReePub));
                        z2 = true;
                    }
                    str3 = ts_sign_ree;
                    if (!(str3 != null || str3.length() == 0)) {
                        sb.append("ree error: tsSignRee, ");
                        z2 = false;
                    } else {
                        clientData.setTsSignRee(ts_sign_ree);
                    }
                    str4 = reeSign;
                    if (!(str4 != null || str4.length() == 0)) {
                        sb.append("ree error: sign, ");
                        z3 = false;
                    } else {
                        clientData.setRequestSignRee(reeSign);
                        z3 = z2;
                    }
                    if (z3) {
                        sb2.append("ree, ");
                        z4 = true;
                        json = getGson().toJson(clientData);
                        Intrinsics.checkExpressionValueIsNotNull(json, "gson.toJson(clientData)");
                        Charset charset = Charsets.UTF_8;
                        if (json == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        byte[] bytes = json.getBytes(charset);
                        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                        String encodeToString = Base64.encodeToString(bytes, 2);
                        arrayList.add(new android.util.Pair(TicketGuardApiKt.HEADER_CLIENT_DATA, encodeToString));
                        String sb3 = sb.toString();
                        Intrinsics.checkExpressionValueIsNotNull(sb3, "errorDesc.toString()");
                        TicketGuardEventHelper.monitorGetConsumerHeaders(consumerRequestParam.getPath(), z4, sb3, System.currentTimeMillis() - (currentTimeMillis * j));
                        String sb4 = sb2.toString();
                        Intrinsics.checkExpressionValueIsNotNull(sb4, "signType.toString()");
                        Intrinsics.checkExpressionValueIsNotNull(encodeToString, "clientDataBase64");
                        return new ConsumerRequestContent(consumerRequestParam, arrayList, sb3, sb4, clientData, encodeToString);
                    }
                }
                z4 = z;
                json = getGson().toJson(clientData);
                Intrinsics.checkExpressionValueIsNotNull(json, "gson.toJson(clientData)");
                Charset charset2 = Charsets.UTF_8;
                if (json == null) {
                }
            }
        }
        z = false;
        if (!needRee()) {
        }
        String base64ReePub2 = getBase64ReePub();
        if (combineTsSign != null) {
        }
        if (ticketData == null) {
        }
        String reeSign2 = reeSign(str, path);
        str2 = base64ReePub2;
        if (!(str2 != null || str2.length() == 0)) {
        }
        str3 = ts_sign_ree;
        if (!(str3 != null || str3.length() == 0)) {
        }
        str4 = reeSign2;
        if (!(str4 != null || str4.length() == 0)) {
        }
        if (z3) {
        }
        z4 = z;
        json = getGson().toJson(clientData);
        Intrinsics.checkExpressionValueIsNotNull(json, "gson.toJson(clientData)");
        Charset charset22 = Charsets.UTF_8;
        if (json == null) {
        }
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public void handleConsumerResponse(HandleConsumerResponseParam handleConsumerResponseParam) {
        Intrinsics.checkParameterIsNotNull(handleConsumerResponseParam, "handleConsumerResponseParam");
        if (handleConsumerResponseParam.getResponseHeaders() == null) {
            return;
        }
        String str = "";
        String str2 = "";
        for (android.util.Pair<String, String> pair : handleConsumerResponseParam.getResponseHeaders()) {
            Object obj = pair.first;
            Intrinsics.checkExpressionValueIsNotNull(obj, "header.first");
            String str3 = (String) obj;
            Locale locale = Locale.ROOT;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
            if (str3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = str3.toLowerCase(locale);
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            Locale locale2 = Locale.ROOT;
            Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.ROOT");
            String lowerCase2 = TicketGuardApiKt.HEADER_LOGID.toLowerCase(locale2);
            Intrinsics.checkExpressionValueIsNotNull(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                Object obj2 = pair.second;
                Intrinsics.checkExpressionValueIsNotNull(obj2, "header.second");
                str = (String) obj2;
            } else {
                Locale locale3 = Locale.ROOT;
                Intrinsics.checkExpressionValueIsNotNull(locale3, "Locale.ROOT");
                String lowerCase3 = TicketGuardApiKt.HEADER_VERIFY_RESULT.toLowerCase(locale3);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase3, "(this as java.lang.String).toLowerCase(locale)");
                if (Intrinsics.areEqual(lowerCase, lowerCase3)) {
                    Object obj3 = pair.second;
                    Intrinsics.checkExpressionValueIsNotNull(obj3, "header.second");
                    str2 = (String) obj3;
                    if (TicketGuardManagerKt.getREE_RECOVER_ERROR_CODE().contains(str2)) {
                        setTeeEverFail("verify result " + str2);
                    }
                }
            }
        }
        TicketGuardEventHelper.monitorUseTicketFail(new ConsumerResponseContent(handleConsumerResponseParam, str, str2));
    }

    public final void log(String msg) {
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        if (this.ticketGuardInitParam != null) {
            TicketGuardInitParam ticketGuardInitParam = this.ticketGuardInitParam;
            if (ticketGuardInitParam == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ticketGuardInitParam");
            }
            ticketGuardInitParam.getLogger().log(LOG_TAG, msg);
            return;
        }
        Log.d(LOG_TAG, msg);
    }

    public final void onEvent(String event, JSONObject params) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        Intrinsics.checkParameterIsNotNull(params, "params");
        if (this.ticketGuardInitParam != null) {
            TicketGuardInitParam ticketGuardInitParam = this.ticketGuardInitParam;
            if (ticketGuardInitParam == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ticketGuardInitParam");
            }
            ticketGuardInitParam.getMonitor().onEvent(event, params);
        }
    }
}
