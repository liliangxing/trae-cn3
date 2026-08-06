package com.bytedance.trae.home.solo.setting.data;

import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sync.interfaze.IFileDataCacheService;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.solo.setting.SettingsTracker;
import com.bytedance.trae.kmp.network.KmpBusinessResponse;
import com.bytedance.trae.kmp.network.KmpHostType;
import com.bytedance.trae.kmp.network.KmpHttpClient;
import com.bytedance.trae.kmp.network.KmpHttpRequestOptions;
import com.bytedance.trae.kmp.network.KmpHttpResult;
import com.bytedance.trae.kmp.network.KmpRequestAuth;
import com.bytedance.trae.kmp.repository.KmpRepositoryCoroutinesKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: DeviceManagementRepository.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000 O2\u00020\u0001:\u0007IJKLMNOB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010&\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010'J\u001e\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0015H\u0002J\u0010\u00101\u001a\u00020/2\u0006\u00100\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020/2\u0006\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020/2\u0006\u00100\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020/2\u0006\u00100\u001a\u000209H\u0002J\b\u0010:\u001a\u00020/H\u0002J\u0010\u0010;\u001a\u00020/2\u0006\u0010)\u001a\u00020\u001cH\u0002J\u000e\u0010<\u001a\u000205H\u0082@¢\u0006\u0002\u0010'J\u0016\u0010=\u001a\u00020\u00192\u0006\u0010>\u001a\u00020 H\u0082@¢\u0006\u0002\u0010?J\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J$\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010>\u001a\u00020 H\u0002J\u000e\u0010D\u001a\u0004\u0018\u00010\u000e*\u00020EH\u0002J\u0010\u0010F\u001a\u00020\u001c2\u0006\u0010G\u001a\u00020HH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020 0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;", "Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;", "httpClient", "Lcom/bytedance/trae/kmp/network/KmpHttpClient;", "ownerScope", "Lkotlinx/coroutines/CoroutineScope;", "repositoryDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/bytedance/trae/kmp/network/KmpHttpClient;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;)V", "repositoryScope", "_devices", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;", "devices", "Lkotlinx/coroutines/flow/StateFlow;", "getDevices", "()Lkotlinx/coroutines/flow/StateFlow;", "events", "Lkotlinx/coroutines/channels/Channel;", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event;", "refreshWaiters", "", "Lkotlinx/coroutines/CompletableDeferred;", "", "overlays", "", "", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$OperationOverlay;", "mutationQueues", "Lkotlin/collections/ArrayDeque;", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;", "activeMutations", "refreshInFlight", "refreshQueued", "nextOperationId", "", "refresh", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renameDevice", "cliId", "name", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDevice", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reduce", "", Fields.EVENT, "handleRefreshRequested", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$RefreshRequested;", "handleRefreshCompleted", "result", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;", "handleMutationRequested", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;", "handleMutationCompleted", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;", "startRefresh", "startNextMutation", "fetchDevices", "executeMutation", "mutation", "(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyOverlays", IFileDataCacheService.TYPE_SNAPSHOT, "applyOptimisticMutation", "current", "toDeviceOrNull", "Lcom/bytedance/trae/home/solo/setting/data/CliDto;", "defaultModel", "product", "Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;", "Event", "MutationType", "OperationOverlay", "Mutation", "MutationRequest", "RefreshResult", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DefaultDeviceManagementRepository implements DeviceManagementRepository {
    private static final String CLI_TYPE_IDE = "local_ide";
    private static final String CLI_TYPE_WORK = "local";
    private static final String DELETE_CLI_PATH = "/api/solo_hub/v1/clis/unregister";
    private static final String LIST_CLIS_PATH = "/api/solo_hub/v1/clis";
    private static final String RENAME_CLI_PATH = "/api/solo_hub/v1/apps/rename_cli";
    private static final String STATUS_ONLINE = "online";
    private final MutableStateFlow<List<DeviceManagementDevice>> _devices;
    private final Map<String, Mutation> activeMutations;
    private final StateFlow<List<DeviceManagementDevice>> devices;
    private final Channel<Event> events;
    private final KmpHttpClient httpClient;
    private final Map<String, ArrayDeque<Mutation>> mutationQueues;
    private long nextOperationId;
    private final Map<String, OperationOverlay> overlays;
    private boolean refreshInFlight;
    private boolean refreshQueued;
    private final List<CompletableDeferred<Boolean>> refreshWaiters;
    private final CoroutineScope repositoryScope;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Set<Long> SUCCESS_CODES = SetsKt.setOf(200L);
    private static final KmpHttpRequestOptions SOLO_HUB_OPTIONS = new KmpHttpRequestOptions(SettingsTracker.TYPE_DEVICE_MANAGEMENT, false, false, false, (KmpRequestAuth) null, KmpHostType.Ai, 30, (DefaultConstructorMarker) null);
    private static final Json json = JsonKt.Json$default((Json) null, new Function1() { // from class: com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit json$lambda$10;
            json$lambda$10 = DefaultDeviceManagementRepository.json$lambda$10((JsonBuilder) obj);
            return json$lambda$10;
        }
    }, 1, (Object) null);

    /* compiled from: DeviceManagementRepository.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceManagementProduct.values().length];
            try {
                iArr[DeviceManagementProduct.Work.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeviceManagementProduct.Ide.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DefaultDeviceManagementRepository(KmpHttpClient kmpHttpClient, CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(kmpHttpClient, "httpClient");
        Intrinsics.checkNotNullParameter(coroutineScope, "ownerScope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "repositoryDispatcher");
        this.httpClient = kmpHttpClient;
        CoroutineScope repositoryScope = KmpRepositoryCoroutinesKt.repositoryScope(coroutineScope, coroutineDispatcher);
        this.repositoryScope = repositoryScope;
        MutableStateFlow<List<DeviceManagementDevice>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._devices = MutableStateFlow;
        this.devices = FlowKt.asStateFlow(MutableStateFlow);
        this.events = ChannelKt.Channel$default(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.refreshWaiters = new ArrayList();
        this.overlays = new LinkedHashMap();
        this.mutationQueues = new LinkedHashMap();
        this.activeMutations = new LinkedHashMap();
        BuildersKt.launch$default(repositoryScope, (CoroutineContext) null, (CoroutineStart) null, new C08291(null), 3, (Object) null);
    }

    public /* synthetic */ DefaultDeviceManagementRepository(KmpHttpClient kmpHttpClient, CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kmpHttpClient, coroutineScope, (i & 4) != 0 ? Dispatchers.getDefault() : coroutineDispatcher);
    }

    @Override // com.bytedance.trae.home.solo.setting.data.DeviceManagementRepository
    public StateFlow<List<DeviceManagementDevice>> getDevices() {
        return this.devices;
    }

    /* compiled from: DeviceManagementRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$1", f = "DeviceManagementRepository.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    static final class C08291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C08291(Continuation<? super C08291> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08291(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x003a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0048  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x003b -> B:5:0x0040). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ChannelIterator it;
            C08291 c08291;
            Object hasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                it = DefaultDeviceManagementRepository.this.events.iterator();
                c08291 = this;
                c08291.L$0 = it;
                c08291.label = 1;
                hasNext = it.hasNext((Continuation) c08291);
                if (hasNext != coroutine_suspended) {
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ChannelIterator channelIterator = (ChannelIterator) this.L$0;
                ResultKt.throwOnFailure(obj);
                ChannelIterator channelIterator2 = channelIterator;
                Object obj2 = coroutine_suspended;
                C08291 c082912 = this;
                if (!((Boolean) obj).booleanValue()) {
                    DefaultDeviceManagementRepository.this.reduce((Event) channelIterator2.next());
                    c08291 = c082912;
                    coroutine_suspended = obj2;
                    it = channelIterator2;
                    c08291.L$0 = it;
                    c08291.label = 1;
                    hasNext = it.hasNext((Continuation) c08291);
                    if (hasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj3 = coroutine_suspended;
                    c082912 = c08291;
                    obj = hasNext;
                    channelIterator2 = it;
                    obj2 = obj3;
                    if (!((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0062 A[PHI: r8
      0x0062: PHI (r8v5 java.lang.Object) = (r8v4 java.lang.Object), (r8v1 java.lang.Object) binds: [B:17:0x005f, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // com.bytedance.trae.home.solo.setting.data.DeviceManagementRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object refresh(Continuation<? super Boolean> continuation) {
        DefaultDeviceManagementRepository$refresh$1 defaultDeviceManagementRepository$refresh$1;
        int i;
        CompletableDeferred CompletableDeferred$default;
        if (continuation instanceof DefaultDeviceManagementRepository$refresh$1) {
            defaultDeviceManagementRepository$refresh$1 = (DefaultDeviceManagementRepository$refresh$1) continuation;
            if ((defaultDeviceManagementRepository$refresh$1.label & Integer.MIN_VALUE) != 0) {
                defaultDeviceManagementRepository$refresh$1.label -= Integer.MIN_VALUE;
                Object obj = defaultDeviceManagementRepository$refresh$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = defaultDeviceManagementRepository$refresh$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
                    Channel<Event> channel = this.events;
                    Event.RefreshRequested refreshRequested = new Event.RefreshRequested(CompletableDeferred$default);
                    defaultDeviceManagementRepository$refresh$1.L$0 = CompletableDeferred$default;
                    defaultDeviceManagementRepository$refresh$1.label = 1;
                    if (channel.send(refreshRequested, defaultDeviceManagementRepository$refresh$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    CompletableDeferred$default = (CompletableDeferred) defaultDeviceManagementRepository$refresh$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                defaultDeviceManagementRepository$refresh$1.L$0 = null;
                defaultDeviceManagementRepository$refresh$1.label = 2;
                obj = CompletableDeferred$default.await(defaultDeviceManagementRepository$refresh$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        defaultDeviceManagementRepository$refresh$1 = new DefaultDeviceManagementRepository$refresh$1(this, continuation);
        Object obj2 = defaultDeviceManagementRepository$refresh$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = defaultDeviceManagementRepository$refresh$1.label;
        if (i != 0) {
        }
        defaultDeviceManagementRepository$refresh$1.L$0 = null;
        defaultDeviceManagementRepository$refresh$1.label = 2;
        obj2 = CompletableDeferred$default.await(defaultDeviceManagementRepository$refresh$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006a A[PHI: r11
      0x006a: PHI (r11v4 java.lang.Object) = (r11v3 java.lang.Object), (r11v1 java.lang.Object) binds: [B:17:0x0067, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // com.bytedance.trae.home.solo.setting.data.DeviceManagementRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object renameDevice(String str, String str2, Continuation<? super Boolean> continuation) {
        DefaultDeviceManagementRepository$renameDevice$1 defaultDeviceManagementRepository$renameDevice$1;
        int i;
        CompletableDeferred completableDeferred;
        if (continuation instanceof DefaultDeviceManagementRepository$renameDevice$1) {
            defaultDeviceManagementRepository$renameDevice$1 = (DefaultDeviceManagementRepository$renameDevice$1) continuation;
            if ((defaultDeviceManagementRepository$renameDevice$1.label & Integer.MIN_VALUE) != 0) {
                defaultDeviceManagementRepository$renameDevice$1.label -= Integer.MIN_VALUE;
                Object obj = defaultDeviceManagementRepository$renameDevice$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = defaultDeviceManagementRepository$renameDevice$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
                    Channel<Event> channel = this.events;
                    Event.MutationRequested mutationRequested = new Event.MutationRequested(str, new MutationType.Rename(str2), CompletableDeferred$default);
                    defaultDeviceManagementRepository$renameDevice$1.L$0 = CompletableDeferred$default;
                    defaultDeviceManagementRepository$renameDevice$1.label = 1;
                    if (channel.send(mutationRequested, defaultDeviceManagementRepository$renameDevice$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    completableDeferred = CompletableDeferred$default;
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    completableDeferred = (CompletableDeferred) defaultDeviceManagementRepository$renameDevice$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                defaultDeviceManagementRepository$renameDevice$1.L$0 = null;
                defaultDeviceManagementRepository$renameDevice$1.label = 2;
                obj = completableDeferred.await(defaultDeviceManagementRepository$renameDevice$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        defaultDeviceManagementRepository$renameDevice$1 = new DefaultDeviceManagementRepository$renameDevice$1(this, continuation);
        Object obj2 = defaultDeviceManagementRepository$renameDevice$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = defaultDeviceManagementRepository$renameDevice$1.label;
        if (i != 0) {
        }
        defaultDeviceManagementRepository$renameDevice$1.L$0 = null;
        defaultDeviceManagementRepository$renameDevice$1.label = 2;
        obj2 = completableDeferred.await(defaultDeviceManagementRepository$renameDevice$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0067 A[PHI: r10
      0x0067: PHI (r10v4 java.lang.Object) = (r10v3 java.lang.Object), (r10v1 java.lang.Object) binds: [B:17:0x0064, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // com.bytedance.trae.home.solo.setting.data.DeviceManagementRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deleteDevice(String str, Continuation<? super Boolean> continuation) {
        DefaultDeviceManagementRepository$deleteDevice$1 defaultDeviceManagementRepository$deleteDevice$1;
        int i;
        CompletableDeferred completableDeferred;
        if (continuation instanceof DefaultDeviceManagementRepository$deleteDevice$1) {
            defaultDeviceManagementRepository$deleteDevice$1 = (DefaultDeviceManagementRepository$deleteDevice$1) continuation;
            if ((defaultDeviceManagementRepository$deleteDevice$1.label & Integer.MIN_VALUE) != 0) {
                defaultDeviceManagementRepository$deleteDevice$1.label -= Integer.MIN_VALUE;
                Object obj = defaultDeviceManagementRepository$deleteDevice$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = defaultDeviceManagementRepository$deleteDevice$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
                    Channel<Event> channel = this.events;
                    Event.MutationRequested mutationRequested = new Event.MutationRequested(str, MutationType.Delete.INSTANCE, CompletableDeferred$default);
                    defaultDeviceManagementRepository$deleteDevice$1.L$0 = CompletableDeferred$default;
                    defaultDeviceManagementRepository$deleteDevice$1.label = 1;
                    if (channel.send(mutationRequested, defaultDeviceManagementRepository$deleteDevice$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    completableDeferred = CompletableDeferred$default;
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    completableDeferred = (CompletableDeferred) defaultDeviceManagementRepository$deleteDevice$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                defaultDeviceManagementRepository$deleteDevice$1.L$0 = null;
                defaultDeviceManagementRepository$deleteDevice$1.label = 2;
                obj = completableDeferred.await(defaultDeviceManagementRepository$deleteDevice$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        defaultDeviceManagementRepository$deleteDevice$1 = new DefaultDeviceManagementRepository$deleteDevice$1(this, continuation);
        Object obj2 = defaultDeviceManagementRepository$deleteDevice$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = defaultDeviceManagementRepository$deleteDevice$1.label;
        if (i != 0) {
        }
        defaultDeviceManagementRepository$deleteDevice$1.L$0 = null;
        defaultDeviceManagementRepository$deleteDevice$1.label = 2;
        obj2 = completableDeferred.await(defaultDeviceManagementRepository$deleteDevice$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reduce(Event event) {
        if (event instanceof Event.RefreshRequested) {
            handleRefreshRequested((Event.RefreshRequested) event);
            return;
        }
        if (event instanceof Event.RefreshCompleted) {
            handleRefreshCompleted(((Event.RefreshCompleted) event).getResult());
        } else if (event instanceof Event.MutationRequested) {
            handleMutationRequested((Event.MutationRequested) event);
        } else {
            if (!(event instanceof Event.MutationCompleted)) {
                throw new NoWhenBranchMatchedException();
            }
            handleMutationCompleted((Event.MutationCompleted) event);
        }
    }

    private final void handleRefreshRequested(Event.RefreshRequested event) {
        this.refreshWaiters.add(event.getResult());
        if (this.refreshInFlight) {
            this.refreshQueued = true;
        } else {
            this.refreshInFlight = true;
            startRefresh();
        }
    }

    private final void handleRefreshCompleted(RefreshResult result) {
        if (result.getDevices() != null) {
            this._devices.setValue(applyOverlays(result.getDevices()));
        }
        this.overlays.clear();
        if (!result.getSuccess() && this.refreshQueued) {
            this.refreshQueued = false;
            startRefresh();
            return;
        }
        this.refreshInFlight = false;
        this.refreshQueued = false;
        Iterator<T> it = this.refreshWaiters.iterator();
        while (it.hasNext()) {
            ((CompletableDeferred) it.next()).complete(Boolean.valueOf(result.getSuccess()));
        }
        this.refreshWaiters.clear();
    }

    private final void handleMutationRequested(Event.MutationRequested event) {
        OperationOverlay.Delete delete;
        long j = this.nextOperationId + 1;
        this.nextOperationId = j;
        Mutation mutation = new Mutation(j, event.getCliId(), event.getType(), event.getResult());
        Map<String, OperationOverlay> map = this.overlays;
        String cliId = event.getCliId();
        MutationType type = event.getType();
        if (type instanceof MutationType.Rename) {
            delete = new OperationOverlay.Rename(j, ((MutationType.Rename) event.getType()).getName());
        } else {
            if (!Intrinsics.areEqual(type, MutationType.Delete.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            delete = new OperationOverlay.Delete(j);
        }
        map.put(cliId, delete);
        MutableStateFlow<List<DeviceManagementDevice>> mutableStateFlow = this._devices;
        mutableStateFlow.setValue(applyOptimisticMutation((List) mutableStateFlow.getValue(), mutation));
        Map<String, ArrayDeque<Mutation>> map2 = this.mutationQueues;
        String cliId2 = event.getCliId();
        ArrayDeque<Mutation> arrayDeque = map2.get(cliId2);
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque<>();
            map2.put(cliId2, arrayDeque);
        }
        arrayDeque.addLast(mutation);
        if (this.activeMutations.containsKey(event.getCliId())) {
            return;
        }
        startNextMutation(event.getCliId());
    }

    private final void handleMutationCompleted(Event.MutationCompleted event) {
        Mutation mutation = this.activeMutations.get(event.getCliId());
        boolean z = false;
        if (mutation != null && mutation.getOperationId() == event.getOperationId()) {
            z = true;
        }
        if (z) {
            this.activeMutations.remove(event.getCliId());
            mutation.getResult().complete(Boolean.valueOf(event.getSuccess()));
            startNextMutation(event.getCliId());
        }
    }

    private final void startRefresh() {
        BuildersKt.launch$default(this.repositoryScope, (CoroutineContext) null, (CoroutineStart) null, new DefaultDeviceManagementRepository$startRefresh$1(this, null), 3, (Object) null);
    }

    private final void startNextMutation(String cliId) {
        ArrayDeque<Mutation> arrayDeque = this.mutationQueues.get(cliId);
        if (arrayDeque == null || arrayDeque.isEmpty()) {
            this.mutationQueues.remove(cliId);
            return;
        }
        Mutation mutation = (Mutation) arrayDeque.removeFirst();
        this.activeMutations.put(cliId, mutation);
        BuildersKt.launch$default(this.repositoryScope, (CoroutineContext) null, (CoroutineStart) null, new DefaultDeviceManagementRepository$startNextMutation$1(this, mutation, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(10:5|6|7|(1:(3:10|11|12)(2:49|50))(3:51|52|(1:54)(1:55))|13|(2:(1:47)(1:18)|(1:20)(10:21|(1:23)(1:46)|(1:25)|26|(4:29|(3:31|32|33)(1:35)|34|27)|36|37|38|39|(1:44)(2:41|42)))|48|38|39|(0)(0)))|58|6|7|(0)(0)|13|(0)|48|38|39|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d9, code lost:
    
        r2 = kotlin.Result.Companion;
        r0 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r0));
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchDevices(Continuation<? super RefreshResult> continuation) {
        DefaultDeviceManagementRepository$fetchDevices$1 defaultDeviceManagementRepository$fetchDevices$1;
        int i;
        boolean z;
        List list;
        boolean z2;
        DefaultDeviceManagementRepository defaultDeviceManagementRepository;
        KmpHttpResult kmpHttpResult;
        RefreshResult refreshResult;
        if (continuation instanceof DefaultDeviceManagementRepository$fetchDevices$1) {
            defaultDeviceManagementRepository$fetchDevices$1 = (DefaultDeviceManagementRepository$fetchDevices$1) continuation;
            if ((defaultDeviceManagementRepository$fetchDevices$1.label & Integer.MIN_VALUE) != 0) {
                defaultDeviceManagementRepository$fetchDevices$1.label -= Integer.MIN_VALUE;
                DefaultDeviceManagementRepository$fetchDevices$1 defaultDeviceManagementRepository$fetchDevices$12 = defaultDeviceManagementRepository$fetchDevices$1;
                Object obj = defaultDeviceManagementRepository$fetchDevices$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = defaultDeviceManagementRepository$fetchDevices$12.label;
                z = false;
                list = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Result.Companion companion = Result.Companion;
                    DefaultDeviceManagementRepository defaultDeviceManagementRepository2 = this;
                    KmpHttpClient kmpHttpClient = this.httpClient;
                    KmpHostType kmpHostType = KmpHostType.Ai;
                    KmpHttpRequestOptions kmpHttpRequestOptions = SOLO_HUB_OPTIONS;
                    DeserializationStrategy serializer = KmpBusinessResponse.Companion.serializer(ListClisResponseData.INSTANCE.serializer());
                    defaultDeviceManagementRepository$fetchDevices$12.L$0 = this;
                    defaultDeviceManagementRepository$fetchDevices$12.label = 1;
                    z2 = true;
                    obj = KmpHttpClient.DefaultImpls.getResult$default(kmpHttpClient, kmpHostType, LIST_CLIS_PATH, (Map) null, (Map) null, kmpHttpRequestOptions, serializer, defaultDeviceManagementRepository$fetchDevices$12, 12, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    defaultDeviceManagementRepository = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    defaultDeviceManagementRepository = (DefaultDeviceManagementRepository) defaultDeviceManagementRepository$fetchDevices$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    z2 = true;
                }
                kmpHttpResult = (KmpHttpResult) obj;
                KmpBusinessResponse kmpBusinessResponse = (KmpBusinessResponse) kmpHttpResult.getData();
                if (kmpHttpResult.getError() == null) {
                    if ((kmpBusinessResponse == null || kmpBusinessResponse.isSuccess(SUCCESS_CODES) != z2) ? false : z2) {
                        ListClisResponseData listClisResponseData = (ListClisResponseData) kmpBusinessResponse.getData();
                        List<CliDto> clis = listClisResponseData != null ? listClisResponseData.getClis() : null;
                        if (clis == null) {
                            clis = CollectionsKt.emptyList();
                        }
                        ArrayList arrayList = new ArrayList();
                        Iterator<T> it = clis.iterator();
                        while (it.hasNext()) {
                            DeviceManagementDevice deviceOrNull = defaultDeviceManagementRepository.toDeviceOrNull((CliDto) it.next());
                            if (deviceOrNull != null) {
                                arrayList.add(deviceOrNull);
                            }
                        }
                        refreshResult = new RefreshResult(z2, arrayList);
                        Object obj2 = Result.constructor-impl(refreshResult);
                        return Result.exceptionOrNull-impl(obj2) == null ? obj2 : new RefreshResult(z, list, 2, list);
                    }
                }
                refreshResult = new RefreshResult(z, list, 2, list);
                Object obj22 = Result.constructor-impl(refreshResult);
                if (Result.exceptionOrNull-impl(obj22) == null) {
                }
            }
        }
        defaultDeviceManagementRepository$fetchDevices$1 = new DefaultDeviceManagementRepository$fetchDevices$1(this, continuation);
        DefaultDeviceManagementRepository$fetchDevices$1 defaultDeviceManagementRepository$fetchDevices$122 = defaultDeviceManagementRepository$fetchDevices$1;
        Object obj3 = defaultDeviceManagementRepository$fetchDevices$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = defaultDeviceManagementRepository$fetchDevices$122.label;
        z = false;
        list = null;
        if (i != 0) {
        }
        kmpHttpResult = (KmpHttpResult) obj3;
        KmpBusinessResponse kmpBusinessResponse2 = (KmpBusinessResponse) kmpHttpResult.getData();
        if (kmpHttpResult.getError() == null) {
        }
        refreshResult = new RefreshResult(z, list, 2, list);
        Object obj222 = Result.constructor-impl(refreshResult);
        if (Result.exceptionOrNull-impl(obj222) == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(10:5|6|7|(1:(1:10)(2:29|30))(5:31|32|(1:34)(2:38|(1:40)(2:41|42))|35|(1:37))|11|(3:13|(1:27)(1:17)|(4:19|20|21|(2:23|24)(1:26)))|28|20|21|(0)(0)))|45|6|7|(0)(0)|11|(0)|28|20|21|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ee, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ef, code lost:
    
        r2 = kotlin.Result.Companion;
        r0 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r0));
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00c8 A[Catch: all -> 0x00ee, TryCatch #0 {all -> 0x00ee, blocks: (B:10:0x002c, B:11:0x00c0, B:13:0x00c8, B:15:0x00d0, B:20:0x00df, B:32:0x003c, B:34:0x0049, B:35:0x0094, B:38:0x006e, B:40:0x0076, B:41:0x00e8, B:42:0x00ed), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeMutation(Mutation mutation, Continuation<? super Boolean> continuation) {
        DefaultDeviceManagementRepository$executeMutation$1 defaultDeviceManagementRepository$executeMutation$1;
        int i;
        MutationRequest mutationRequest;
        KmpHttpResult kmpHttpResult;
        if (continuation instanceof DefaultDeviceManagementRepository$executeMutation$1) {
            defaultDeviceManagementRepository$executeMutation$1 = (DefaultDeviceManagementRepository$executeMutation$1) continuation;
            if ((defaultDeviceManagementRepository$executeMutation$1.label & Integer.MIN_VALUE) != 0) {
                defaultDeviceManagementRepository$executeMutation$1.label -= Integer.MIN_VALUE;
                DefaultDeviceManagementRepository$executeMutation$1 defaultDeviceManagementRepository$executeMutation$12 = defaultDeviceManagementRepository$executeMutation$1;
                Object obj = defaultDeviceManagementRepository$executeMutation$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = defaultDeviceManagementRepository$executeMutation$12.label;
                boolean z = true;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Result.Companion companion = Result.Companion;
                    DefaultDeviceManagementRepository defaultDeviceManagementRepository = this;
                    MutationType type = mutation.getType();
                    if (type instanceof MutationType.Rename) {
                        mutationRequest = new MutationRequest(RENAME_CLI_PATH, json.encodeToString(RenameCliRequest.INSTANCE.serializer(), new RenameCliRequest(mutation.getCliId(), ((MutationType.Rename) type).getName())));
                    } else {
                        if (!Intrinsics.areEqual(type, MutationType.Delete.INSTANCE)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        mutationRequest = new MutationRequest(DELETE_CLI_PATH, json.encodeToString(DeleteCliRequest.INSTANCE.serializer(), new DeleteCliRequest(mutation.getCliId())));
                    }
                    KmpHttpClient kmpHttpClient = this.httpClient;
                    KmpHostType kmpHostType = KmpHostType.Ai;
                    String path = mutationRequest.getPath();
                    String body = mutationRequest.getBody();
                    KmpHttpRequestOptions kmpHttpRequestOptions = SOLO_HUB_OPTIONS;
                    DeserializationStrategy serializer = KmpBusinessResponse.Companion.serializer(EmptyResponse.INSTANCE.serializer());
                    defaultDeviceManagementRepository$executeMutation$12.label = 1;
                    obj = KmpHttpClient.DefaultImpls.postResult$default(kmpHttpClient, kmpHostType, path, body, (String) null, (Map) null, kmpHttpRequestOptions, serializer, defaultDeviceManagementRepository$executeMutation$12, 24, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                kmpHttpResult = (KmpHttpResult) obj;
                if (kmpHttpResult.getError() == null) {
                    KmpBusinessResponse kmpBusinessResponse = (KmpBusinessResponse) kmpHttpResult.getData();
                    if (kmpBusinessResponse != null && kmpBusinessResponse.isSuccess(SUCCESS_CODES)) {
                        Object obj2 = Result.constructor-impl(Boxing.boxBoolean(z));
                        return Result.isFailure-impl(obj2) ? Boxing.boxBoolean(false) : obj2;
                    }
                }
                z = false;
                Object obj22 = Result.constructor-impl(Boxing.boxBoolean(z));
                if (Result.isFailure-impl(obj22)) {
                }
            }
        }
        defaultDeviceManagementRepository$executeMutation$1 = new DefaultDeviceManagementRepository$executeMutation$1(this, continuation);
        DefaultDeviceManagementRepository$executeMutation$1 defaultDeviceManagementRepository$executeMutation$122 = defaultDeviceManagementRepository$executeMutation$1;
        Object obj3 = defaultDeviceManagementRepository$executeMutation$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = defaultDeviceManagementRepository$executeMutation$122.label;
        boolean z2 = true;
        if (i != 0) {
        }
        kmpHttpResult = (KmpHttpResult) obj3;
        if (kmpHttpResult.getError() == null) {
        }
        z2 = false;
        Object obj222 = Result.constructor-impl(Boxing.boxBoolean(z2));
        if (Result.isFailure-impl(obj222)) {
        }
    }

    private final List<DeviceManagementDevice> applyOverlays(List<DeviceManagementDevice> snapshot) {
        ArrayList arrayList = new ArrayList();
        for (DeviceManagementDevice deviceManagementDevice : snapshot) {
            OperationOverlay operationOverlay = this.overlays.get(deviceManagementDevice.getId());
            if (operationOverlay instanceof OperationOverlay.Rename) {
                deviceManagementDevice = DeviceManagementDevice.copy$default(deviceManagementDevice, null, ((OperationOverlay.Rename) operationOverlay).getName(), null, false, null, 29, null);
            } else if (operationOverlay instanceof OperationOverlay.Delete) {
                deviceManagementDevice = null;
            } else if (operationOverlay != null) {
                throw new NoWhenBranchMatchedException();
            }
            if (deviceManagementDevice != null) {
                arrayList.add(deviceManagementDevice);
            }
        }
        return arrayList;
    }

    private final List<DeviceManagementDevice> applyOptimisticMutation(List<DeviceManagementDevice> current, Mutation mutation) {
        MutationType type = mutation.getType();
        if (!(type instanceof MutationType.Rename)) {
            if (!Intrinsics.areEqual(type, MutationType.Delete.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : current) {
                if (!Intrinsics.areEqual(((DeviceManagementDevice) obj).getId(), mutation.getCliId())) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        List<DeviceManagementDevice> list = current;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (DeviceManagementDevice deviceManagementDevice : list) {
            if (Intrinsics.areEqual(deviceManagementDevice.getId(), mutation.getCliId())) {
                deviceManagementDevice = DeviceManagementDevice.copy$default(deviceManagementDevice, null, ((MutationType.Rename) type).getName(), null, false, null, 29, null);
            }
            arrayList2.add(deviceManagementDevice);
        }
        return arrayList2;
    }

    private final DeviceManagementDevice toDeviceOrNull(CliDto cliDto) {
        DeviceManagementProduct deviceManagementProduct;
        String type = cliDto.getType();
        if (!Intrinsics.areEqual(type, CLI_TYPE_WORK)) {
            if (Intrinsics.areEqual(type, CLI_TYPE_IDE)) {
                deviceManagementProduct = DeviceManagementProduct.Ide;
            }
            return null;
        }
        deviceManagementProduct = DeviceManagementProduct.Work;
        DeviceManagementProduct deviceManagementProduct2 = deviceManagementProduct;
        if (!StringsKt.isBlank(cliDto.getId()) && !StringsKt.isBlank(cliDto.getName())) {
            String id = cliDto.getId();
            String name = cliDto.getName();
            String ideVersion = cliDto.getIdeVersion();
            String str = StringsKt.isBlank(ideVersion) ^ true ? ideVersion : null;
            return new DeviceManagementDevice(id, name, str == null ? defaultModel(deviceManagementProduct2) : str, StringsKt.equals(cliDto.getStatus(), STATUS_ONLINE, true), deviceManagementProduct2);
        }
        return null;
    }

    private final String defaultModel(DeviceManagementProduct product) {
        int i = WhenMappings.$EnumSwitchMapping$0[product.ordinal()];
        if (i == 1) {
            return "MacBook Pro 16''";
        }
        if (i == 2) {
            return "TRAE IDE";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeviceManagementRepository.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event;", "", "RefreshRequested", "RefreshCompleted", "MutationRequested", "MutationCompleted", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$RefreshCompleted;", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$RefreshRequested;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface Event {

        /* compiled from: DeviceManagementRepository.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÇ\u0001J\u0013\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0011H×\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$RefreshRequested;", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event;", "result", "Lkotlinx/coroutines/CompletableDeferred;", "", "<init>", "(Lkotlinx/coroutines/CompletableDeferred;)V", "getResult", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class RefreshRequested implements Event {
            public static final int $stable = 8;
            private final CompletableDeferred<Boolean> result;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ RefreshRequested copy$default(RefreshRequested refreshRequested, CompletableDeferred completableDeferred, int i, Object obj) {
                if ((i & 1) != 0) {
                    completableDeferred = refreshRequested.result;
                }
                return refreshRequested.copy(completableDeferred);
            }

            public final CompletableDeferred<Boolean> component1() {
                return this.result;
            }

            public final RefreshRequested copy(CompletableDeferred<Boolean> result) {
                Intrinsics.checkNotNullParameter(result, "result");
                return new RefreshRequested(result);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RefreshRequested) && Intrinsics.areEqual(this.result, ((RefreshRequested) other).result);
            }

            public int hashCode() {
                return this.result.hashCode();
            }

            public String toString() {
                return "RefreshRequested(result=" + this.result + ')';
            }

            public RefreshRequested(CompletableDeferred<Boolean> completableDeferred) {
                Intrinsics.checkNotNullParameter(completableDeferred, "result");
                this.result = completableDeferred;
            }

            public final CompletableDeferred<Boolean> getResult() {
                return this.result;
            }
        }

        /* compiled from: DeviceManagementRepository.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0011H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$RefreshCompleted;", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event;", "result", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;", "<init>", "(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;)V", "getResult", "()Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class RefreshCompleted implements Event {
            public static final int $stable = 8;
            private final RefreshResult result;

            public static /* synthetic */ RefreshCompleted copy$default(RefreshCompleted refreshCompleted, RefreshResult refreshResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    refreshResult = refreshCompleted.result;
                }
                return refreshCompleted.copy(refreshResult);
            }

            /* renamed from: component1, reason: from getter */
            public final RefreshResult getResult() {
                return this.result;
            }

            public final RefreshCompleted copy(RefreshResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                return new RefreshCompleted(result);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RefreshCompleted) && Intrinsics.areEqual(this.result, ((RefreshCompleted) other).result);
            }

            public int hashCode() {
                return this.result.hashCode();
            }

            public String toString() {
                return "RefreshCompleted(result=" + this.result + ')';
            }

            public RefreshCompleted(RefreshResult refreshResult) {
                Intrinsics.checkNotNullParameter(refreshResult, "result");
                this.result = refreshResult;
            }

            public final RefreshResult getResult() {
                return this.result;
            }
        }

        /* compiled from: DeviceManagementRepository.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÇ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H×\u0003J\t\u0010\u0018\u001a\u00020\u0019H×\u0001J\t\u0010\u001a\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event;", "cliId", "", DBData.FIELD_TYPE, "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;", "result", "Lkotlinx/coroutines/CompletableDeferred;", "", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;Lkotlinx/coroutines/CompletableDeferred;)V", "getCliId", "()Ljava/lang/String;", "getType", "()Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;", "getResult", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class MutationRequested implements Event {
            public static final int $stable = 8;
            private final String cliId;
            private final CompletableDeferred<Boolean> result;
            private final MutationType type;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ MutationRequested copy$default(MutationRequested mutationRequested, String str, MutationType mutationType, CompletableDeferred completableDeferred, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = mutationRequested.cliId;
                }
                if ((i & 2) != 0) {
                    mutationType = mutationRequested.type;
                }
                if ((i & 4) != 0) {
                    completableDeferred = mutationRequested.result;
                }
                return mutationRequested.copy(str, mutationType, completableDeferred);
            }

            /* renamed from: component1, reason: from getter */
            public final String getCliId() {
                return this.cliId;
            }

            /* renamed from: component2, reason: from getter */
            public final MutationType getType() {
                return this.type;
            }

            public final CompletableDeferred<Boolean> component3() {
                return this.result;
            }

            public final MutationRequested copy(String cliId, MutationType type, CompletableDeferred<Boolean> result) {
                Intrinsics.checkNotNullParameter(cliId, "cliId");
                Intrinsics.checkNotNullParameter(type, DBData.FIELD_TYPE);
                Intrinsics.checkNotNullParameter(result, "result");
                return new MutationRequested(cliId, type, result);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MutationRequested)) {
                    return false;
                }
                MutationRequested mutationRequested = (MutationRequested) other;
                return Intrinsics.areEqual(this.cliId, mutationRequested.cliId) && Intrinsics.areEqual(this.type, mutationRequested.type) && Intrinsics.areEqual(this.result, mutationRequested.result);
            }

            public int hashCode() {
                return (((this.cliId.hashCode() * 31) + this.type.hashCode()) * 31) + this.result.hashCode();
            }

            public String toString() {
                return "MutationRequested(cliId=" + this.cliId + ", type=" + this.type + ", result=" + this.result + ')';
            }

            public MutationRequested(String str, MutationType mutationType, CompletableDeferred<Boolean> completableDeferred) {
                Intrinsics.checkNotNullParameter(str, "cliId");
                Intrinsics.checkNotNullParameter(mutationType, DBData.FIELD_TYPE);
                Intrinsics.checkNotNullParameter(completableDeferred, "result");
                this.cliId = str;
                this.type = mutationType;
                this.result = completableDeferred;
            }

            public final String getCliId() {
                return this.cliId;
            }

            public final MutationType getType() {
                return this.type;
            }

            public final CompletableDeferred<Boolean> getResult() {
                return this.result;
            }
        }

        /* compiled from: DeviceManagementRepository.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÇ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H×\u0003J\t\u0010\u0017\u001a\u00020\u0018H×\u0001J\t\u0010\u0019\u001a\u00020\u0005H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event;", "operationId", "", "cliId", "", "success", "", "<init>", "(JLjava/lang/String;Z)V", "getOperationId", "()J", "getCliId", "()Ljava/lang/String;", "getSuccess", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class MutationCompleted implements Event {
            public static final int $stable = 0;
            private final String cliId;
            private final long operationId;
            private final boolean success;

            public static /* synthetic */ MutationCompleted copy$default(MutationCompleted mutationCompleted, long j, String str, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = mutationCompleted.operationId;
                }
                if ((i & 2) != 0) {
                    str = mutationCompleted.cliId;
                }
                if ((i & 4) != 0) {
                    z = mutationCompleted.success;
                }
                return mutationCompleted.copy(j, str, z);
            }

            /* renamed from: component1, reason: from getter */
            public final long getOperationId() {
                return this.operationId;
            }

            /* renamed from: component2, reason: from getter */
            public final String getCliId() {
                return this.cliId;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getSuccess() {
                return this.success;
            }

            public final MutationCompleted copy(long operationId, String cliId, boolean success) {
                Intrinsics.checkNotNullParameter(cliId, "cliId");
                return new MutationCompleted(operationId, cliId, success);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MutationCompleted)) {
                    return false;
                }
                MutationCompleted mutationCompleted = (MutationCompleted) other;
                return this.operationId == mutationCompleted.operationId && Intrinsics.areEqual(this.cliId, mutationCompleted.cliId) && this.success == mutationCompleted.success;
            }

            public int hashCode() {
                return (((Long.hashCode(this.operationId) * 31) + this.cliId.hashCode()) * 31) + Boolean.hashCode(this.success);
            }

            public String toString() {
                return "MutationCompleted(operationId=" + this.operationId + ", cliId=" + this.cliId + ", success=" + this.success + ')';
            }

            public MutationCompleted(long j, String str, boolean z) {
                Intrinsics.checkNotNullParameter(str, "cliId");
                this.operationId = j;
                this.cliId = str;
                this.success = z;
            }

            public final long getOperationId() {
                return this.operationId;
            }

            public final String getCliId() {
                return this.cliId;
            }

            public final boolean getSuccess() {
                return this.success;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeviceManagementRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;", "", "Rename", "Delete", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Delete;", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Rename;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface MutationType {

        /* compiled from: DeviceManagementRepository.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Rename;", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class Rename implements MutationType {
            public static final int $stable = 0;
            private final String name;

            public static /* synthetic */ Rename copy$default(Rename rename, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = rename.name;
                }
                return rename.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public final Rename copy(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                return new Rename(name);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Rename) && Intrinsics.areEqual(this.name, ((Rename) other).name);
            }

            public int hashCode() {
                return this.name.hashCode();
            }

            public String toString() {
                return "Rename(name=" + this.name + ')';
            }

            public Rename(String str) {
                Intrinsics.checkNotNullParameter(str, "name");
                this.name = str;
            }

            public final String getName() {
                return this.name;
            }
        }

        /* compiled from: DeviceManagementRepository.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Delete;", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class Delete implements MutationType {
            public static final int $stable = 0;
            public static final Delete INSTANCE = new Delete();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Delete)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 725711682;
            }

            public String toString() {
                return "Delete";
            }

            private Delete() {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeviceManagementRepository.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0006\u0007R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$OperationOverlay;", "", "operationId", "", "getOperationId", "()J", "Rename", "Delete", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$OperationOverlay$Delete;", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$OperationOverlay$Rename;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface OperationOverlay {
        long getOperationId();

        /* compiled from: DeviceManagementRepository.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H×\u0003J\t\u0010\u0013\u001a\u00020\u0014H×\u0001J\t\u0010\u0015\u001a\u00020\u0005H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$OperationOverlay$Rename;", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$OperationOverlay;", "operationId", "", "name", "", "<init>", "(JLjava/lang/String;)V", "getOperationId", "()J", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class Rename implements OperationOverlay {
            public static final int $stable = 0;
            private final String name;
            private final long operationId;

            public static /* synthetic */ Rename copy$default(Rename rename, long j, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = rename.operationId;
                }
                if ((i & 2) != 0) {
                    str = rename.name;
                }
                return rename.copy(j, str);
            }

            /* renamed from: component1, reason: from getter */
            public final long getOperationId() {
                return this.operationId;
            }

            /* renamed from: component2, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public final Rename copy(long operationId, String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                return new Rename(operationId, name);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Rename)) {
                    return false;
                }
                Rename rename = (Rename) other;
                return this.operationId == rename.operationId && Intrinsics.areEqual(this.name, rename.name);
            }

            public int hashCode() {
                return (Long.hashCode(this.operationId) * 31) + this.name.hashCode();
            }

            public String toString() {
                return "Rename(operationId=" + this.operationId + ", name=" + this.name + ')';
            }

            public Rename(long j, String str) {
                Intrinsics.checkNotNullParameter(str, "name");
                this.operationId = j;
                this.name = str;
            }

            @Override // com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository.OperationOverlay
            public long getOperationId() {
                return this.operationId;
            }

            public final String getName() {
                return this.name;
            }
        }

        /* compiled from: DeviceManagementRepository.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0011H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$OperationOverlay$Delete;", "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$OperationOverlay;", "operationId", "", "<init>", "(J)V", "getOperationId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class Delete implements OperationOverlay {
            public static final int $stable = 0;
            private final long operationId;

            public static /* synthetic */ Delete copy$default(Delete delete, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = delete.operationId;
                }
                return delete.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getOperationId() {
                return this.operationId;
            }

            public final Delete copy(long operationId) {
                return new Delete(operationId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Delete) && this.operationId == ((Delete) other).operationId;
            }

            public int hashCode() {
                return Long.hashCode(this.operationId);
            }

            public String toString() {
                return "Delete(operationId=" + this.operationId + ')';
            }

            public Delete(long j) {
                this.operationId = j;
            }

            @Override // com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository.OperationOverlay
            public long getOperationId() {
                return this.operationId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeviceManagementRepository.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;", "", "operationId", "", "cliId", "", DBData.FIELD_TYPE, "Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;", "result", "Lkotlinx/coroutines/CompletableDeferred;", "", "<init>", "(JLjava/lang/String;Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;Lkotlinx/coroutines/CompletableDeferred;)V", "getOperationId", "()J", "getCliId", "()Ljava/lang/String;", "getType", "()Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;", "getResult", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Mutation {
        private final String cliId;
        private final long operationId;
        private final CompletableDeferred<Boolean> result;
        private final MutationType type;

        public static /* synthetic */ Mutation copy$default(Mutation mutation, long j, String str, MutationType mutationType, CompletableDeferred completableDeferred, int i, Object obj) {
            if ((i & 1) != 0) {
                j = mutation.operationId;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = mutation.cliId;
            }
            String str2 = str;
            if ((i & 4) != 0) {
                mutationType = mutation.type;
            }
            MutationType mutationType2 = mutationType;
            if ((i & 8) != 0) {
                completableDeferred = mutation.result;
            }
            return mutation.copy(j2, str2, mutationType2, completableDeferred);
        }

        /* renamed from: component1, reason: from getter */
        public final long getOperationId() {
            return this.operationId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCliId() {
            return this.cliId;
        }

        /* renamed from: component3, reason: from getter */
        public final MutationType getType() {
            return this.type;
        }

        public final CompletableDeferred<Boolean> component4() {
            return this.result;
        }

        public final Mutation copy(long operationId, String cliId, MutationType type, CompletableDeferred<Boolean> result) {
            Intrinsics.checkNotNullParameter(cliId, "cliId");
            Intrinsics.checkNotNullParameter(type, DBData.FIELD_TYPE);
            Intrinsics.checkNotNullParameter(result, "result");
            return new Mutation(operationId, cliId, type, result);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Mutation)) {
                return false;
            }
            Mutation mutation = (Mutation) other;
            return this.operationId == mutation.operationId && Intrinsics.areEqual(this.cliId, mutation.cliId) && Intrinsics.areEqual(this.type, mutation.type) && Intrinsics.areEqual(this.result, mutation.result);
        }

        public int hashCode() {
            return (((((Long.hashCode(this.operationId) * 31) + this.cliId.hashCode()) * 31) + this.type.hashCode()) * 31) + this.result.hashCode();
        }

        public String toString() {
            return "Mutation(operationId=" + this.operationId + ", cliId=" + this.cliId + ", type=" + this.type + ", result=" + this.result + ')';
        }

        public Mutation(long j, String str, MutationType mutationType, CompletableDeferred<Boolean> completableDeferred) {
            Intrinsics.checkNotNullParameter(str, "cliId");
            Intrinsics.checkNotNullParameter(mutationType, DBData.FIELD_TYPE);
            Intrinsics.checkNotNullParameter(completableDeferred, "result");
            this.operationId = j;
            this.cliId = str;
            this.type = mutationType;
            this.result = completableDeferred;
        }

        public final long getOperationId() {
            return this.operationId;
        }

        public final String getCliId() {
            return this.cliId;
        }

        public final MutationType getType() {
            return this.type;
        }

        public final CompletableDeferred<Boolean> getResult() {
            return this.result;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeviceManagementRepository.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationRequest;", "", "path", "", "body", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "getBody", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class MutationRequest {
        private final String body;
        private final String path;

        public static /* synthetic */ MutationRequest copy$default(MutationRequest mutationRequest, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mutationRequest.path;
            }
            if ((i & 2) != 0) {
                str2 = mutationRequest.body;
            }
            return mutationRequest.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        /* renamed from: component2, reason: from getter */
        public final String getBody() {
            return this.body;
        }

        public final MutationRequest copy(String path, String body) {
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(body, "body");
            return new MutationRequest(path, body);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MutationRequest)) {
                return false;
            }
            MutationRequest mutationRequest = (MutationRequest) other;
            return Intrinsics.areEqual(this.path, mutationRequest.path) && Intrinsics.areEqual(this.body, mutationRequest.body);
        }

        public int hashCode() {
            return (this.path.hashCode() * 31) + this.body.hashCode();
        }

        public String toString() {
            return "MutationRequest(path=" + this.path + ", body=" + this.body + ')';
        }

        public MutationRequest(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "path");
            Intrinsics.checkNotNullParameter(str2, "body");
            this.path = str;
            this.body = str2;
        }

        public final String getPath() {
            return this.path;
        }

        public final String getBody() {
            return this.body;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeviceManagementRepository.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;", "", "success", "", "devices", "", "Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;", "<init>", "(ZLjava/util/List;)V", "getSuccess", "()Z", "getDevices", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class RefreshResult {
        private final List<DeviceManagementDevice> devices;
        private final boolean success;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RefreshResult copy$default(RefreshResult refreshResult, boolean z, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                z = refreshResult.success;
            }
            if ((i & 2) != 0) {
                list = refreshResult.devices;
            }
            return refreshResult.copy(z, list);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getSuccess() {
            return this.success;
        }

        public final List<DeviceManagementDevice> component2() {
            return this.devices;
        }

        public final RefreshResult copy(boolean success, List<DeviceManagementDevice> devices) {
            return new RefreshResult(success, devices);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RefreshResult)) {
                return false;
            }
            RefreshResult refreshResult = (RefreshResult) other;
            return this.success == refreshResult.success && Intrinsics.areEqual(this.devices, refreshResult.devices);
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.success) * 31;
            List<DeviceManagementDevice> list = this.devices;
            return hashCode + (list == null ? 0 : list.hashCode());
        }

        public String toString() {
            return "RefreshResult(success=" + this.success + ", devices=" + this.devices + ')';
        }

        public RefreshResult(boolean z, List<DeviceManagementDevice> list) {
            this.success = z;
            this.devices = list;
        }

        public /* synthetic */ RefreshResult(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? null : list);
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final List<DeviceManagementDevice> getDevices() {
            return this.devices;
        }
    }

    /* compiled from: DeviceManagementRepository.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Companion;", "", "<init>", "()V", "LIST_CLIS_PATH", "", "RENAME_CLI_PATH", "DELETE_CLI_PATH", "CLI_TYPE_WORK", "CLI_TYPE_IDE", "STATUS_ONLINE", "SUCCESS_CODES", "", "", "SOLO_HUB_OPTIONS", "Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;", "json", "Lkotlinx/serialization/json/Json;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit json$lambda$10(JsonBuilder jsonBuilder) {
        Intrinsics.checkNotNullParameter(jsonBuilder, "$this$Json");
        jsonBuilder.setIgnoreUnknownKeys(true);
        return Unit.INSTANCE;
    }
}
