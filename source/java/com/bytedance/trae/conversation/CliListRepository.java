package com.bytedance.trae.conversation;

import com.bytedance.keva.Keva;
import com.bytedance.tracing.internal.TracingConstants;
import com.bytedance.trae.conversation.devices.MobileDevice;
import com.bytedance.trae.conversation.devices.MobileDeviceKt;
import com.bytedance.trae.conversation.tracker.DeviceTracker;
import com.bytedance.trae.im.service.Cli;
import com.bytedance.trae.im.service.CliListSource;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.ListClisResponse;
import com.bytedance.trae.im.service.OnboardingStateResponse;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.response.HttpDataResult;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.json.JSONObject;

/* compiled from: CliListRepository.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 N2\u00020\u0001:\u0001NB\u001d\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010&\u001a\u0004\u0018\u00010\r2\b\u0010'\u001a\u0004\u0018\u00010\rJ\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0)J\u001a\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\r2\b\u0010-\u001a\u0004\u0018\u00010\rJ\u001a\u0010.\u001a\u00020+2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0)J\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0)J\f\u00101\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0006\u00102\u001a\u00020\u0012J\u001c\u00103\u001a\u00020+2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0)H\u0002J\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001a0\tJ\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\tJ\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086@¢\u0006\u0002\u00106J\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u001a0\tH\u0086@¢\u0006\u0002\u00106J\u000e\u00108\u001a\u000209H\u0086@¢\u0006\u0002\u00106J\u000e\u0010:\u001a\u00020;H\u0086@¢\u0006\u0002\u00106J\u000e\u0010<\u001a\u00020=H\u0086@¢\u0006\u0002\u00106J(\u0010>\u001a\u00020+2\u0018\u0010?\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020+0@H\u0086@¢\u0006\u0002\u0010AJ(\u0010B\u001a\u00020+2\u0018\u0010?\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\t\u0012\u0004\u0012\u00020+0@H\u0086@¢\u0006\u0002\u0010AJ\u001e\u0010C\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\r2\u0006\u0010D\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010EJ\u0016\u0010F\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010GJ\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0082@¢\u0006\u0002\u00106J\u000e\u0010I\u001a\u00020JH\u0086@¢\u0006\u0002\u00106J\u0016\u0010K\u001a\u00020+2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0018\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001a0\t*\b\u0012\u0004\u0012\u00020\n0\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\t0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\t0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#¨\u0006O"}, d2 = {"Lcom/bytedance/trae/conversation/CliListRepository;", "", TracingConstants.KEY_TRACE_NAME, "Lcom/bytedance/trae/conversation/CliListService;", "deviceCountEventTracker", "Lcom/bytedance/trae/conversation/DeviceCountEventTracker;", "<init>", "(Lcom/bytedance/trae/conversation/CliListService;Lcom/bytedance/trae/conversation/DeviceCountEventTracker;)V", "cachedDeviceItems", "", "Lcom/bytedance/trae/im/service/Cli;", "cachedTypes", "", "", "cachedTypesLock", "fetchedAt", "", "isInited", "", "_cachedClis", "Lkotlinx/coroutines/flow/MutableStateFlow;", "cachedClis", "Lkotlinx/coroutines/flow/StateFlow;", "getCachedClis", "()Lkotlinx/coroutines/flow/StateFlow;", "cachedDiscoveryDevices", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "_cachedDiscoverableDevices", "cachedDiscoverableDevices", "getCachedDiscoverableDevices", "discoveryRefreshMutex", "Lkotlinx/coroutines/sync/Mutex;", "keva", "Lcom/bytedance/keva/Keva;", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "Lkotlin/Lazy;", "getCliTypeById", "id", "getCacheCliTypes", "", "saveCliId", "", "cliId", "cliType", "saveCliIdToTypeMap", "map", "getCliIdToTypeMapFromKeva", "getCacheClis", "hasMultipleLocalCliTypes", "persistCliIdToTypeMap", "getCachedDevices", "getClis", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDevices", "refreshDevices", "Lcom/bytedance/trae/conversation/DeviceListRefreshResult;", "refreshDiscoverableDevices", "Lcom/bytedance/trae/conversation/DeviceDiscoveryRefreshResult;", "getOnboardingState", "Lcom/bytedance/trae/conversation/OnboardingStateResult;", "fetchClis", "onResult", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchDevices", "renameCli", "name", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterCli", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshClis", "refreshClisResult", "Lcom/bytedance/trae/conversation/CliListRefreshResult;", "updateCache", "clis", "toMobileDevices", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CliListRepository {
    private static final String KEVA_REPO_NAME = "cli_list_repo";
    private static final String KEY_CLI_ID_TO_TYPE = "cli_id_to_type";
    private final MutableStateFlow<List<Cli>> _cachedClis;
    private final MutableStateFlow<List<MobileDevice>> _cachedDiscoverableDevices;
    private final StateFlow<List<Cli>> cachedClis;
    private List<Cli> cachedDeviceItems;
    private final StateFlow<List<MobileDevice>> cachedDiscoverableDevices;
    private List<MobileDevice> cachedDiscoveryDevices;
    private volatile Map<String, String> cachedTypes;
    private final Object cachedTypesLock;
    private final DeviceCountEventTracker deviceCountEventTracker;
    private final Mutex discoveryRefreshMutex;
    private long fetchedAt;
    private volatile boolean isInited;

    /* renamed from: keva$delegate, reason: from kotlin metadata */
    private final Lazy keva;
    private final CliListService service;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<CliListRepository> instance$delegate = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.CliListRepository$$ExternalSyntheticLambda1
        public final Object invoke() {
            CliListRepository instance_delegate$lambda$14;
            instance_delegate$lambda$14 = CliListRepository.instance_delegate$lambda$14();
            return instance_delegate$lambda$14;
        }
    });

    /* JADX WARN: Multi-variable type inference failed */
    public CliListRepository() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public CliListRepository(CliListService cliListService, DeviceCountEventTracker deviceCountEventTracker) {
        Intrinsics.checkNotNullParameter(cliListService, TracingConstants.KEY_TRACE_NAME);
        Intrinsics.checkNotNullParameter(deviceCountEventTracker, "deviceCountEventTracker");
        this.service = cliListService;
        this.deviceCountEventTracker = deviceCountEventTracker;
        this.cachedDeviceItems = CollectionsKt.emptyList();
        this.cachedTypes = new HashMap();
        this.cachedTypesLock = new Object();
        MutableStateFlow<List<Cli>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._cachedClis = MutableStateFlow;
        this.cachedClis = FlowKt.asStateFlow(MutableStateFlow);
        this.cachedDiscoveryDevices = CollectionsKt.emptyList();
        MutableStateFlow<List<MobileDevice>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._cachedDiscoverableDevices = MutableStateFlow2;
        this.cachedDiscoverableDevices = FlowKt.asStateFlow(MutableStateFlow2);
        this.discoveryRefreshMutex = MutexKt.Mutex$default(false, 1, (Object) null);
        this.keva = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.CliListRepository$$ExternalSyntheticLambda0
            public final Object invoke() {
                Keva keva_delegate$lambda$0;
                keva_delegate$lambda$0 = CliListRepository.keva_delegate$lambda$0();
                return keva_delegate$lambda$0;
            }
        });
    }

    public /* synthetic */ CliListRepository(DefaultCliListService defaultCliListService, DeviceCountEventTracker deviceCountEventTracker, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DefaultCliListService.INSTANCE : defaultCliListService, (i & 2) != 0 ? new DeviceCountEventTracker(new C05921(DeviceTracker.INSTANCE)) : deviceCountEventTracker);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CliListRepository.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.bytedance.trae.conversation.CliListRepository$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class C05921 extends FunctionReferenceImpl implements Function1<DeviceCountSnapshot, Unit> {
        C05921(Object obj) {
            super(1, obj, DeviceTracker.class, "trackDevicePairCount", "trackDevicePairCount$conversation_mainlandRelease(Lcom/bytedance/trae/conversation/DeviceCountSnapshot;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((DeviceCountSnapshot) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(DeviceCountSnapshot deviceCountSnapshot) {
            Intrinsics.checkNotNullParameter(deviceCountSnapshot, "p0");
            ((DeviceTracker) this.receiver).trackDevicePairCount$conversation_mainlandRelease(deviceCountSnapshot);
        }
    }

    public final StateFlow<List<Cli>> getCachedClis() {
        return this.cachedClis;
    }

    /* renamed from: getCachedDiscoverableDevices, reason: collision with other method in class */
    public final StateFlow<List<MobileDevice>> m1135getCachedDiscoverableDevices() {
        return this.cachedDiscoverableDevices;
    }

    private final Keva getKeva() {
        Object value = this.keva.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Keva) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Keva keva_delegate$lambda$0() {
        String str;
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null || (str = accountInfo.getUserId()) == null) {
            str = "";
        }
        return Keva.getRepo(str + "_cli_list_repo", 0);
    }

    public final String getCliTypeById(String id) {
        if (!this.isInited) {
            this.cachedTypes = MapsKt.toMutableMap(getCliIdToTypeMapFromKeva());
        }
        if (id == null) {
            return null;
        }
        return this.cachedTypes.get(id);
    }

    public final Map<String, String> getCacheCliTypes() {
        if (!this.isInited) {
            this.cachedTypes = MapsKt.toMutableMap(getCliIdToTypeMapFromKeva());
        }
        return this.cachedTypes;
    }

    public final void saveCliId(String cliId, String cliType) {
        if (cliId == null || cliType == null) {
            return;
        }
        synchronized (this.cachedTypesLock) {
            this.isInited = true;
            if (this.cachedTypes.containsKey(cliId)) {
                return;
            }
            this.cachedTypes.put(cliId, cliType);
            persistCliIdToTypeMap(this.cachedTypes);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void saveCliIdToTypeMap(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        synchronized (this.cachedTypesLock) {
            boolean z = true;
            this.isInited = true;
            if (map.size() == this.cachedTypes.size()) {
                if (!map.isEmpty()) {
                    Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<String, String> next = it.next();
                        String key = next.getKey();
                        if (!Intrinsics.areEqual(this.cachedTypes.get(key), next.getValue())) {
                            z = false;
                            break;
                        }
                    }
                }
                if (z) {
                    return;
                }
            }
            this.cachedTypes = MapsKt.toMutableMap(map);
            if (map.isEmpty()) {
                persistCliIdToTypeMap(MapsKt.emptyMap());
            } else {
                persistCliIdToTypeMap(map);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final Map<String, String> getCliIdToTypeMapFromKeva() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            CliListRepository cliListRepository = this;
            String string = getKeva().getString(KEY_CLI_ID_TO_TYPE, "");
            if (string == null) {
                string = "";
            }
            obj = Result.constructor-impl(string);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = "";
        }
        String str = (String) obj;
        if (str.length() == 0) {
            return MapsKt.emptyMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
            while (keys.hasNext()) {
                String next = keys.next();
                linkedHashMap.put(next, jSONObject.optString(next, ""));
            }
            return linkedHashMap;
        } catch (Exception unused) {
            return MapsKt.emptyMap();
        }
    }

    public final List<Cli> getCacheClis() {
        return this.cachedDeviceItems;
    }

    public final boolean hasMultipleLocalCliTypes() {
        List<Cli> list = this.cachedDeviceItems;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String type = ((Cli) it.next()).getType();
            if (type != null) {
                arrayList.add(type);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (true ^ Intrinsics.areEqual((String) obj, CliType.REMOTE.getValue())) {
                arrayList2.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList2).size() >= 2;
    }

    private final void persistCliIdToTypeMap(Map<String, String> map) {
        try {
            Result.Companion companion = Result.Companion;
            CliListRepository cliListRepository = this;
            if (map.isEmpty()) {
                getKeva().storeString(KEY_CLI_ID_TO_TYPE, "");
            } else {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                getKeva().storeString(KEY_CLI_ID_TO_TYPE, jSONObject.toString());
            }
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public final List<MobileDevice> getCachedDevices() {
        return toMobileDevices(this.cachedDeviceItems);
    }

    public final List<MobileDevice> getCachedDiscoverableDevices() {
        return this.cachedDiscoveryDevices;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getClis(Continuation<? super List<Cli>> continuation) {
        CliListRepository$getClis$1 cliListRepository$getClis$1;
        int i;
        CliListRepository cliListRepository;
        HttpDataResult.Success success;
        if (continuation instanceof CliListRepository$getClis$1) {
            cliListRepository$getClis$1 = (CliListRepository$getClis$1) continuation;
            if ((cliListRepository$getClis$1.label & Integer.MIN_VALUE) != 0) {
                cliListRepository$getClis$1.label -= Integer.MIN_VALUE;
                Object obj = cliListRepository$getClis$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cliListRepository$getClis$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    long currentTimeMillis = System.currentTimeMillis();
                    if ((!this.cachedDeviceItems.isEmpty()) && currentTimeMillis - this.fetchedAt < 1000) {
                        return this.cachedDeviceItems;
                    }
                    CliListService cliListService = this.service;
                    CliListSource cliListSource = CliListSource.REGISTERED;
                    cliListRepository$getClis$1.L$0 = this;
                    cliListRepository$getClis$1.label = 1;
                    obj = cliListService.listClis(cliListSource, cliListRepository$getClis$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cliListRepository = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    cliListRepository = (CliListRepository) cliListRepository$getClis$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                success = (HttpDataResult) obj;
                if (success instanceof HttpDataResult.Success) {
                    HttpDataResult.Success success2 = success;
                    if (success2.getBizResp().isSuccess()) {
                        ListClisResponse listClisResponse = (ListClisResponse) success2.getBizResp().getData();
                        List<Cli> clis = listClisResponse != null ? listClisResponse.getClis() : null;
                        if (clis == null) {
                            clis = CollectionsKt.emptyList();
                        }
                        cliListRepository.updateCache(clis);
                        cliListRepository.deviceCountEventTracker.onFetchSucceeded(cliListRepository.cachedDeviceItems);
                        cliListRepository.fetchedAt = System.currentTimeMillis();
                        return cliListRepository.cachedDeviceItems;
                    }
                }
                cliListRepository.deviceCountEventTracker.onFetchFailed();
                return cliListRepository.cachedDeviceItems;
            }
        }
        cliListRepository$getClis$1 = new CliListRepository$getClis$1(this, continuation);
        Object obj2 = cliListRepository$getClis$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cliListRepository$getClis$1.label;
        if (i != 0) {
        }
        success = (HttpDataResult) obj2;
        if (success instanceof HttpDataResult.Success) {
        }
        cliListRepository.deviceCountEventTracker.onFetchFailed();
        return cliListRepository.cachedDeviceItems;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getDevices(Continuation<? super List<MobileDevice>> continuation) {
        CliListRepository$getDevices$1 cliListRepository$getDevices$1;
        int i;
        CliListRepository cliListRepository;
        if (continuation instanceof CliListRepository$getDevices$1) {
            cliListRepository$getDevices$1 = (CliListRepository$getDevices$1) continuation;
            if ((cliListRepository$getDevices$1.label & Integer.MIN_VALUE) != 0) {
                cliListRepository$getDevices$1.label -= Integer.MIN_VALUE;
                Object obj = cliListRepository$getDevices$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cliListRepository$getDevices$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    cliListRepository$getDevices$1.L$0 = this;
                    cliListRepository$getDevices$1.label = 1;
                    obj = getClis(cliListRepository$getDevices$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cliListRepository = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    cliListRepository = (CliListRepository) cliListRepository$getDevices$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return cliListRepository.toMobileDevices((List) obj);
            }
        }
        cliListRepository$getDevices$1 = new CliListRepository$getDevices$1(this, continuation);
        Object obj2 = cliListRepository$getDevices$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cliListRepository$getDevices$1.label;
        if (i != 0) {
        }
        return cliListRepository.toMobileDevices((List) obj2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshDevices(Continuation<? super DeviceListRefreshResult> continuation) {
        CliListRepository$refreshDevices$1 cliListRepository$refreshDevices$1;
        int i;
        CliListRepository cliListRepository;
        if (continuation instanceof CliListRepository$refreshDevices$1) {
            cliListRepository$refreshDevices$1 = (CliListRepository$refreshDevices$1) continuation;
            if ((cliListRepository$refreshDevices$1.label & Integer.MIN_VALUE) != 0) {
                cliListRepository$refreshDevices$1.label -= Integer.MIN_VALUE;
                Object obj = cliListRepository$refreshDevices$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cliListRepository$refreshDevices$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    cliListRepository$refreshDevices$1.L$0 = this;
                    cliListRepository$refreshDevices$1.label = 1;
                    obj = refreshClisResult(cliListRepository$refreshDevices$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cliListRepository = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    cliListRepository = (CliListRepository) cliListRepository$refreshDevices$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                CliListRefreshResult cliListRefreshResult = (CliListRefreshResult) obj;
                return new DeviceListRefreshResult(cliListRepository.toMobileDevices(cliListRefreshResult.getClis()), cliListRefreshResult.isSuccess());
            }
        }
        cliListRepository$refreshDevices$1 = new CliListRepository$refreshDevices$1(this, continuation);
        Object obj2 = cliListRepository$refreshDevices$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cliListRepository$refreshDevices$1.label;
        if (i != 0) {
        }
        CliListRefreshResult cliListRefreshResult2 = (CliListRefreshResult) obj2;
        return new DeviceListRefreshResult(cliListRepository.toMobileDevices(cliListRefreshResult2.getClis()), cliListRefreshResult2.isSuccess());
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0097 A[Catch: all -> 0x0036, TryCatch #1 {all -> 0x0036, blocks: (B:12:0x0032, B:13:0x0075, B:15:0x007b, B:18:0x0089, B:20:0x0097, B:22:0x009f, B:23:0x00a3, B:28:0x00b4), top: B:11:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009f A[Catch: all -> 0x0036, TryCatch #1 {all -> 0x0036, blocks: (B:12:0x0032, B:13:0x0075, B:15:0x007b, B:18:0x0089, B:20:0x0097, B:22:0x009f, B:23:0x00a3, B:28:0x00b4), top: B:11:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshDiscoverableDevices(Continuation<? super DeviceDiscoveryRefreshResult> continuation) {
        CliListRepository$refreshDiscoverableDevices$1 cliListRepository$refreshDiscoverableDevices$1;
        Object coroutine_suspended;
        int i;
        Mutex mutex;
        CliListRepository cliListRepository;
        Mutex mutex2;
        Throwable th;
        Object listClis;
        CliListRepository cliListRepository2;
        HttpDataResult.Success success;
        DeviceDiscoveryRefreshResult deviceDiscoveryRefreshResult;
        List<Cli> clis;
        try {
            if (continuation instanceof CliListRepository$refreshDiscoverableDevices$1) {
                cliListRepository$refreshDiscoverableDevices$1 = (CliListRepository$refreshDiscoverableDevices$1) continuation;
                if ((cliListRepository$refreshDiscoverableDevices$1.label & Integer.MIN_VALUE) != 0) {
                    cliListRepository$refreshDiscoverableDevices$1.label -= Integer.MIN_VALUE;
                    Object obj = cliListRepository$refreshDiscoverableDevices$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = cliListRepository$refreshDiscoverableDevices$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.discoveryRefreshMutex;
                        cliListRepository$refreshDiscoverableDevices$1.L$0 = this;
                        cliListRepository$refreshDiscoverableDevices$1.L$1 = mutex;
                        cliListRepository$refreshDiscoverableDevices$1.label = 1;
                        if (mutex.lock((Object) null, cliListRepository$refreshDiscoverableDevices$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        cliListRepository = this;
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            mutex2 = (Mutex) cliListRepository$refreshDiscoverableDevices$1.L$1;
                            cliListRepository2 = (CliListRepository) cliListRepository$refreshDiscoverableDevices$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                success = (HttpDataResult) obj;
                                if ((success instanceof HttpDataResult.Success) && success.getBizResp().isSuccess()) {
                                    ListClisResponse listClisResponse = (ListClisResponse) success.getBizResp().getData();
                                    clis = listClisResponse == null ? listClisResponse.getClis() : null;
                                    if (clis == null) {
                                        clis = CollectionsKt.emptyList();
                                    }
                                    List<MobileDevice> mapDiscoverableDevices = CliListRepositoryKt.mapDiscoverableDevices(clis);
                                    cliListRepository2.cachedDiscoveryDevices = mapDiscoverableDevices;
                                    cliListRepository2._cachedDiscoverableDevices.setValue(mapDiscoverableDevices);
                                    deviceDiscoveryRefreshResult = new DeviceDiscoveryRefreshResult(mapDiscoverableDevices, true);
                                    mutex2.unlock((Object) null);
                                    return deviceDiscoveryRefreshResult;
                                }
                                deviceDiscoveryRefreshResult = new DeviceDiscoveryRefreshResult(cliListRepository2.cachedDiscoveryDevices, false);
                                mutex2.unlock((Object) null);
                                return deviceDiscoveryRefreshResult;
                            } catch (Throwable th2) {
                                th = th2;
                                mutex2.unlock((Object) null);
                                throw th;
                            }
                        }
                        Mutex mutex3 = (Mutex) cliListRepository$refreshDiscoverableDevices$1.L$1;
                        cliListRepository = (CliListRepository) cliListRepository$refreshDiscoverableDevices$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex3;
                    }
                    CliListService cliListService = cliListRepository.service;
                    CliListSource cliListSource = CliListSource.ALL;
                    cliListRepository$refreshDiscoverableDevices$1.L$0 = cliListRepository;
                    cliListRepository$refreshDiscoverableDevices$1.L$1 = mutex;
                    cliListRepository$refreshDiscoverableDevices$1.label = 2;
                    listClis = cliListService.listClis(cliListSource, cliListRepository$refreshDiscoverableDevices$1);
                    if (listClis != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutex2 = mutex;
                    obj = listClis;
                    cliListRepository2 = cliListRepository;
                    success = (HttpDataResult) obj;
                    if (success instanceof HttpDataResult.Success) {
                        ListClisResponse listClisResponse2 = (ListClisResponse) success.getBizResp().getData();
                        if (listClisResponse2 == null) {
                        }
                        if (clis == null) {
                        }
                        List<MobileDevice> mapDiscoverableDevices2 = CliListRepositoryKt.mapDiscoverableDevices(clis);
                        cliListRepository2.cachedDiscoveryDevices = mapDiscoverableDevices2;
                        cliListRepository2._cachedDiscoverableDevices.setValue(mapDiscoverableDevices2);
                        deviceDiscoveryRefreshResult = new DeviceDiscoveryRefreshResult(mapDiscoverableDevices2, true);
                        mutex2.unlock((Object) null);
                        return deviceDiscoveryRefreshResult;
                    }
                    deviceDiscoveryRefreshResult = new DeviceDiscoveryRefreshResult(cliListRepository2.cachedDiscoveryDevices, false);
                    mutex2.unlock((Object) null);
                    return deviceDiscoveryRefreshResult;
                }
            }
            CliListService cliListService2 = cliListRepository.service;
            CliListSource cliListSource2 = CliListSource.ALL;
            cliListRepository$refreshDiscoverableDevices$1.L$0 = cliListRepository;
            cliListRepository$refreshDiscoverableDevices$1.L$1 = mutex;
            cliListRepository$refreshDiscoverableDevices$1.label = 2;
            listClis = cliListService2.listClis(cliListSource2, cliListRepository$refreshDiscoverableDevices$1);
            if (listClis != coroutine_suspended) {
            }
        } catch (Throwable th3) {
            mutex2 = mutex;
            th = th3;
            mutex2.unlock((Object) null);
            throw th;
        }
        cliListRepository$refreshDiscoverableDevices$1 = new CliListRepository$refreshDiscoverableDevices$1(this, continuation);
        Object obj2 = cliListRepository$refreshDiscoverableDevices$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cliListRepository$refreshDiscoverableDevices$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getOnboardingState(Continuation<? super OnboardingStateResult> continuation) {
        CliListRepository$getOnboardingState$1 cliListRepository$getOnboardingState$1;
        int i;
        HttpDataResult.Success success;
        OnboardingStateResponse onboardingStateResponse;
        if (continuation instanceof CliListRepository$getOnboardingState$1) {
            cliListRepository$getOnboardingState$1 = (CliListRepository$getOnboardingState$1) continuation;
            if ((cliListRepository$getOnboardingState$1.label & Integer.MIN_VALUE) != 0) {
                cliListRepository$getOnboardingState$1.label -= Integer.MIN_VALUE;
                Object obj = cliListRepository$getOnboardingState$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cliListRepository$getOnboardingState$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CliListService cliListService = this.service;
                    cliListRepository$getOnboardingState$1.label = 1;
                    obj = cliListService.getOnboardingState(cliListRepository$getOnboardingState$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                success = (HttpDataResult) obj;
                if (success instanceof HttpDataResult.Success) {
                    HttpDataResult.Success success2 = success;
                    if (success2.getBizResp().isSuccess() && (onboardingStateResponse = (OnboardingStateResponse) success2.getBizResp().getData()) != null) {
                        Boolean hasRegisteredWork = onboardingStateResponse.getHasRegisteredWork();
                        Boolean hasRegisteredIDE = onboardingStateResponse.getHasRegisteredIDE();
                        Boolean hasConversation = onboardingStateResponse.getHasConversation();
                        if (hasRegisteredWork != null && hasRegisteredIDE != null && hasConversation != null) {
                            return new OnboardingStateResult(new OnboardingState(hasRegisteredWork.booleanValue(), hasRegisteredIDE.booleanValue(), hasConversation.booleanValue()), true);
                        }
                    }
                }
                return new OnboardingStateResult(null, false);
            }
        }
        cliListRepository$getOnboardingState$1 = new CliListRepository$getOnboardingState$1(this, continuation);
        Object obj2 = cliListRepository$getOnboardingState$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cliListRepository$getOnboardingState$1.label;
        if (i != 0) {
        }
        success = (HttpDataResult) obj2;
        if (success instanceof HttpDataResult.Success) {
        }
        return new OnboardingStateResult(null, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchClis(Function1<? super List<Cli>, Unit> function1, Continuation<? super Unit> continuation) {
        CliListRepository$fetchClis$1 cliListRepository$fetchClis$1;
        int i;
        if (continuation instanceof CliListRepository$fetchClis$1) {
            cliListRepository$fetchClis$1 = (CliListRepository$fetchClis$1) continuation;
            if ((cliListRepository$fetchClis$1.label & Integer.MIN_VALUE) != 0) {
                cliListRepository$fetchClis$1.label -= Integer.MIN_VALUE;
                Object obj = cliListRepository$fetchClis$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cliListRepository$fetchClis$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    cliListRepository$fetchClis$1.L$0 = function1;
                    cliListRepository$fetchClis$1.label = 1;
                    obj = refreshClis(cliListRepository$fetchClis$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function1 = (Function1) cliListRepository$fetchClis$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                function1.invoke(obj);
                return Unit.INSTANCE;
            }
        }
        cliListRepository$fetchClis$1 = new CliListRepository$fetchClis$1(this, continuation);
        Object obj2 = cliListRepository$fetchClis$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cliListRepository$fetchClis$1.label;
        if (i != 0) {
        }
        function1.invoke(obj2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchDevices(Function1<? super List<MobileDevice>, Unit> function1, Continuation<? super Unit> continuation) {
        CliListRepository$fetchDevices$1 cliListRepository$fetchDevices$1;
        int i;
        Object obj;
        CliListRepository cliListRepository;
        if (continuation instanceof CliListRepository$fetchDevices$1) {
            cliListRepository$fetchDevices$1 = (CliListRepository$fetchDevices$1) continuation;
            if ((cliListRepository$fetchDevices$1.label & Integer.MIN_VALUE) != 0) {
                cliListRepository$fetchDevices$1.label -= Integer.MIN_VALUE;
                Object obj2 = cliListRepository$fetchDevices$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cliListRepository$fetchDevices$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    cliListRepository$fetchDevices$1.L$0 = function1;
                    cliListRepository$fetchDevices$1.L$1 = this;
                    cliListRepository$fetchDevices$1.label = 1;
                    Object refreshClis = refreshClis(cliListRepository$fetchDevices$1);
                    if (refreshClis == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = refreshClis;
                    cliListRepository = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    CliListRepository cliListRepository2 = (CliListRepository) cliListRepository$fetchDevices$1.L$1;
                    Function1<? super List<MobileDevice>, Unit> function12 = (Function1) cliListRepository$fetchDevices$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    cliListRepository = cliListRepository2;
                    function1 = function12;
                    obj = obj2;
                }
                function1.invoke(cliListRepository.toMobileDevices((List) obj));
                return Unit.INSTANCE;
            }
        }
        cliListRepository$fetchDevices$1 = new CliListRepository$fetchDevices$1(this, continuation);
        Object obj22 = cliListRepository$fetchDevices$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cliListRepository$fetchDevices$1.label;
        if (i != 0) {
        }
        function1.invoke(cliListRepository.toMobileDevices((List) obj));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object renameCli(String str, String str2, Continuation<? super Boolean> continuation) {
        CliListRepository$renameCli$1 cliListRepository$renameCli$1;
        int i;
        CliListRepository cliListRepository;
        HttpDataResult.Success success;
        if (continuation instanceof CliListRepository$renameCli$1) {
            cliListRepository$renameCli$1 = (CliListRepository$renameCli$1) continuation;
            if ((cliListRepository$renameCli$1.label & Integer.MIN_VALUE) != 0) {
                cliListRepository$renameCli$1.label -= Integer.MIN_VALUE;
                Object obj = cliListRepository$renameCli$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cliListRepository$renameCli$1.label;
                boolean z = true;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CliListService cliListService = this.service;
                    cliListRepository$renameCli$1.L$0 = this;
                    cliListRepository$renameCli$1.label = 1;
                    obj = cliListService.renameCli(str, str2, cliListRepository$renameCli$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cliListRepository = this;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Boxing.boxBoolean(z);
                    }
                    cliListRepository = (CliListRepository) cliListRepository$renameCli$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                success = (HttpDataResult) obj;
                if ((success instanceof HttpDataResult.Success) || !success.getBizResp().isSuccess()) {
                    z = false;
                } else {
                    cliListRepository$renameCli$1.L$0 = null;
                    cliListRepository$renameCli$1.label = 2;
                    if (cliListRepository.refreshClis(cliListRepository$renameCli$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Boxing.boxBoolean(z);
            }
        }
        cliListRepository$renameCli$1 = new CliListRepository$renameCli$1(this, continuation);
        Object obj2 = cliListRepository$renameCli$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cliListRepository$renameCli$1.label;
        boolean z2 = true;
        if (i != 0) {
        }
        success = (HttpDataResult) obj2;
        if (success instanceof HttpDataResult.Success) {
        }
        z2 = false;
        return Boxing.boxBoolean(z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object unregisterCli(String str, Continuation<? super Boolean> continuation) {
        CliListRepository$unregisterCli$1 cliListRepository$unregisterCli$1;
        int i;
        CliListRepository cliListRepository;
        HttpDataResult.Success success;
        if (continuation instanceof CliListRepository$unregisterCli$1) {
            cliListRepository$unregisterCli$1 = (CliListRepository$unregisterCli$1) continuation;
            if ((cliListRepository$unregisterCli$1.label & Integer.MIN_VALUE) != 0) {
                cliListRepository$unregisterCli$1.label -= Integer.MIN_VALUE;
                Object obj = cliListRepository$unregisterCli$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cliListRepository$unregisterCli$1.label;
                boolean z = true;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CliListService cliListService = this.service;
                    cliListRepository$unregisterCli$1.L$0 = this;
                    cliListRepository$unregisterCli$1.label = 1;
                    obj = cliListService.unregisterCli(str, cliListRepository$unregisterCli$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cliListRepository = this;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Boxing.boxBoolean(z);
                    }
                    cliListRepository = (CliListRepository) cliListRepository$unregisterCli$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                success = (HttpDataResult) obj;
                if ((success instanceof HttpDataResult.Success) || !success.getBizResp().isSuccess()) {
                    z = false;
                } else {
                    cliListRepository$unregisterCli$1.L$0 = null;
                    cliListRepository$unregisterCli$1.label = 2;
                    if (cliListRepository.refreshClis(cliListRepository$unregisterCli$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Boxing.boxBoolean(z);
            }
        }
        cliListRepository$unregisterCli$1 = new CliListRepository$unregisterCli$1(this, continuation);
        Object obj2 = cliListRepository$unregisterCli$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cliListRepository$unregisterCli$1.label;
        boolean z2 = true;
        if (i != 0) {
        }
        success = (HttpDataResult) obj2;
        if (success instanceof HttpDataResult.Success) {
        }
        z2 = false;
        return Boxing.boxBoolean(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshClis(Continuation<? super List<Cli>> continuation) {
        CliListRepository$refreshClis$1 cliListRepository$refreshClis$1;
        int i;
        if (continuation instanceof CliListRepository$refreshClis$1) {
            cliListRepository$refreshClis$1 = (CliListRepository$refreshClis$1) continuation;
            if ((cliListRepository$refreshClis$1.label & Integer.MIN_VALUE) != 0) {
                cliListRepository$refreshClis$1.label -= Integer.MIN_VALUE;
                Object obj = cliListRepository$refreshClis$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cliListRepository$refreshClis$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    cliListRepository$refreshClis$1.label = 1;
                    obj = refreshClisResult(cliListRepository$refreshClis$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((CliListRefreshResult) obj).getClis();
            }
        }
        cliListRepository$refreshClis$1 = new CliListRepository$refreshClis$1(this, continuation);
        Object obj2 = cliListRepository$refreshClis$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cliListRepository$refreshClis$1.label;
        if (i != 0) {
        }
        return ((CliListRefreshResult) obj2).getClis();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshClisResult(Continuation<? super CliListRefreshResult> continuation) {
        CliListRepository$refreshClisResult$1 cliListRepository$refreshClisResult$1;
        int i;
        CliListRepository cliListRepository;
        HttpDataResult.Success success;
        if (continuation instanceof CliListRepository$refreshClisResult$1) {
            cliListRepository$refreshClisResult$1 = (CliListRepository$refreshClisResult$1) continuation;
            if ((cliListRepository$refreshClisResult$1.label & Integer.MIN_VALUE) != 0) {
                cliListRepository$refreshClisResult$1.label -= Integer.MIN_VALUE;
                Object obj = cliListRepository$refreshClisResult$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cliListRepository$refreshClisResult$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CliListService cliListService = this.service;
                    CliListSource cliListSource = CliListSource.REGISTERED;
                    cliListRepository$refreshClisResult$1.L$0 = this;
                    cliListRepository$refreshClisResult$1.label = 1;
                    obj = cliListService.listClis(cliListSource, cliListRepository$refreshClisResult$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cliListRepository = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    cliListRepository = (CliListRepository) cliListRepository$refreshClisResult$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                success = (HttpDataResult) obj;
                if (success instanceof HttpDataResult.Success) {
                    HttpDataResult.Success success2 = success;
                    if (success2.getBizResp().isSuccess()) {
                        ListClisResponse listClisResponse = (ListClisResponse) success2.getBizResp().getData();
                        List<Cli> clis = listClisResponse != null ? listClisResponse.getClis() : null;
                        if (clis == null) {
                            clis = CollectionsKt.emptyList();
                        }
                        cliListRepository.updateCache(clis);
                        cliListRepository.fetchedAt = System.currentTimeMillis();
                        cliListRepository.deviceCountEventTracker.onFetchSucceeded(cliListRepository.cachedDeviceItems);
                        return new CliListRefreshResult(cliListRepository.cachedDeviceItems, true);
                    }
                }
                cliListRepository.deviceCountEventTracker.onFetchFailed();
                return new CliListRefreshResult(cliListRepository.cachedDeviceItems, false);
            }
        }
        cliListRepository$refreshClisResult$1 = new CliListRepository$refreshClisResult$1(this, continuation);
        Object obj2 = cliListRepository$refreshClisResult$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cliListRepository$refreshClisResult$1.label;
        if (i != 0) {
        }
        success = (HttpDataResult) obj2;
        if (success instanceof HttpDataResult.Success) {
        }
        cliListRepository.deviceCountEventTracker.onFetchFailed();
        return new CliListRefreshResult(cliListRepository.cachedDeviceItems, false);
    }

    private final void updateCache(List<Cli> clis) {
        String type;
        this.cachedDeviceItems = clis;
        this._cachedClis.setValue(clis);
        ArrayList arrayList = new ArrayList();
        for (Cli cli : clis) {
            String id = cli.getId();
            Pair pair = null;
            if (id != null && (type = cli.getType()) != null) {
                pair = TuplesKt.to(id, type);
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        saveCliIdToTypeMap(MapsKt.toMap(arrayList));
    }

    private final List<MobileDevice> toMobileDevices(List<Cli> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            MobileDevice mobileDeviceOrNull$default = MobileDeviceKt.toMobileDeviceOrNull$default((Cli) it.next(), false, 1, null);
            if (mobileDeviceOrNull$default != null) {
                arrayList.add(mobileDeviceOrNull$default);
            }
        }
        return arrayList;
    }

    /* compiled from: CliListRepository.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/conversation/CliListRepository$Companion;", "", "<init>", "()V", "KEVA_REPO_NAME", "", "KEY_CLI_ID_TO_TYPE", "instance", "Lcom/bytedance/trae/conversation/CliListRepository;", "getInstance", "()Lcom/bytedance/trae/conversation/CliListRepository;", "instance$delegate", "Lkotlin/Lazy;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CliListRepository getInstance() {
            return (CliListRepository) CliListRepository.instance$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final CliListRepository instance_delegate$lambda$14() {
        return new CliListRepository(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }
}
