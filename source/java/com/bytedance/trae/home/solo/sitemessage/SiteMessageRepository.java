package com.bytedance.trae.home.solo.sitemessage;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.bytedance.tracing.internal.TracingConstants;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.home.solo.sitemessage.SiteMessageListResponse;
import com.bytedance.trae.home.solo.sitemessage.SiteMessagePreferencesGetResponse;
import com.bytedance.trae.network.HostResolver;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: SiteMessageRepository.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0017\u001a\u00020\u0010J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\u0006\u0010\u0019\u001a\u00020\u0010J2\u0010\u001a\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\u0004\u0012\u00020\u000e0\u001b2\u0006\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010 J@\u0010!\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u001c2\u0006\u0010#\u001a\u00020$2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010&2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010&J\u0010\u0010(\u001a\u0004\u0018\u00010)H\u0086@¢\u0006\u0002\u0010*J0\u0010+\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u000e\u0018\u00010,2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u000e0,H\u0086@¢\u0006\u0002\u0010.J\u0006\u0010/\u001a\u00020\u0010J\b\u00100\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u00061"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;", "", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "_unreadCount", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "unreadCount", "Lkotlinx/coroutines/flow/StateFlow;", "getUnreadCount", "()Lkotlinx/coroutines/flow/StateFlow;", "initialized", "", "init", "", "app", "Landroid/app/Application;", "readTracker", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;", "getReadTracker", "()Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;", "refreshUnreadCount", "initPreferences", "clearLocalUnreadBadge", "fetchList", "Lkotlin/Pair;", "", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;", "page", "pageSize", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStatus", "ids", "action", "", "onSuccess", "Lkotlin/Function0;", "onFailure", "fetchPreferences", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse$PreferencesData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePreferences", "", TracingConstants.KEY_FIELDS, "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleLogout", "migrateDefaultPreferences", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SiteMessageRepository {
    public static final int $stable;
    private static final MutableStateFlow<Integer> _unreadCount;
    private static volatile boolean initialized;
    private static final SiteMessageReadTracker readTracker;
    private static final StateFlow<Integer> unreadCount;
    public static final SiteMessageRepository INSTANCE = new SiteMessageRepository();
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));

    private SiteMessageRepository() {
    }

    static {
        MutableStateFlow<Integer> MutableStateFlow = StateFlowKt.MutableStateFlow(0);
        _unreadCount = MutableStateFlow;
        unreadCount = FlowKt.asStateFlow(MutableStateFlow);
        readTracker = new SiteMessageReadTracker();
        $stable = 8;
    }

    public final StateFlow<Integer> getUnreadCount() {
        return unreadCount;
    }

    public final void init(Application app) {
        Intrinsics.checkNotNullParameter(app, "app");
        if (initialized || HostResolver.INSTANCE.isBytecloudLogin() || HostResolver.INSTANCE.isEnterpriseLogin()) {
            return;
        }
        initialized = true;
        Runnable runnable = new Runnable() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageRepository$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SiteMessageRepository.init$lambda$0();
            }
        };
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
        refreshUnreadCount();
        if (AppHost.INSTANCE.isOversea()) {
            initPreferences();
        }
        readTracker.retryPendingEvents();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0() {
        ProcessLifecycleOwner.Companion.get().getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageRepository$init$register$1$1
            public void onStart(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                SiteMessageRepository.INSTANCE.refreshUnreadCount();
                SiteMessageRepository.INSTANCE.getReadTracker().retryPendingEvents();
            }
        });
    }

    public final SiteMessageReadTracker getReadTracker() {
        return readTracker;
    }

    public final void refreshUnreadCount() {
        if (HostResolver.INSTANCE.isBytecloudLogin() || HostResolver.INSTANCE.isEnterpriseLogin()) {
            return;
        }
        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new SiteMessageRepository$refreshUnreadCount$1(null), 3, (Object) null);
    }

    private final void initPreferences() {
        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new SiteMessageRepository$initPreferences$1(null), 3, (Object) null);
    }

    public final void clearLocalUnreadBadge() {
        _unreadCount.setValue(0);
    }

    public static /* synthetic */ Object fetchList$default(SiteMessageRepository siteMessageRepository, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 10;
        }
        return siteMessageRepository.fetchList(i, i2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchList(int i, int i2, Continuation<? super Pair<? extends List<SiteMessageItem>, Boolean>> continuation) {
        SiteMessageRepository$fetchList$1 siteMessageRepository$fetchList$1;
        int i3;
        boolean z;
        SiteMessageListResponse.ListData data;
        SiteMessageListResponse.ListData data2;
        Boolean hasMore;
        if (continuation instanceof SiteMessageRepository$fetchList$1) {
            siteMessageRepository$fetchList$1 = (SiteMessageRepository$fetchList$1) continuation;
            if ((siteMessageRepository$fetchList$1.label & Integer.MIN_VALUE) != 0) {
                siteMessageRepository$fetchList$1.label -= Integer.MIN_VALUE;
                Object obj = siteMessageRepository$fetchList$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = siteMessageRepository$fetchList$1.label;
                z = false;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Map<String, String> buildQueryParams = SiteMessageParams.INSTANCE.buildQueryParams(MapsKt.mapOf(new Pair[]{TuplesKt.to("page", String.valueOf(i)), TuplesKt.to("pageSize", String.valueOf(i2))}));
                    ISiteMessageApi createService = ISiteMessageApi.INSTANCE.createService();
                    siteMessageRepository$fetchList$1.label = 1;
                    obj = createService.getList(buildQueryParams, siteMessageRepository$fetchList$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                SiteMessageListResponse siteMessageListResponse = (SiteMessageListResponse) obj;
                data = siteMessageListResponse.getData();
                if (data != null || (r7 = data.getList()) == null) {
                    List<SiteMessageItem> emptyList = CollectionsKt.emptyList();
                }
                data2 = siteMessageListResponse.getData();
                if (data2 != null && (hasMore = data2.getHasMore()) != null) {
                    z = hasMore.booleanValue();
                }
                return TuplesKt.to(emptyList, Boxing.boxBoolean(z));
            }
        }
        siteMessageRepository$fetchList$1 = new SiteMessageRepository$fetchList$1(this, continuation);
        Object obj2 = siteMessageRepository$fetchList$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = siteMessageRepository$fetchList$1.label;
        z = false;
        if (i3 != 0) {
        }
        SiteMessageListResponse siteMessageListResponse2 = (SiteMessageListResponse) obj2;
        data = siteMessageListResponse2.getData();
        if (data != null) {
        }
        List<SiteMessageItem> emptyList2 = CollectionsKt.emptyList();
        data2 = siteMessageListResponse2.getData();
        if (data2 != null) {
            z = hasMore.booleanValue();
        }
        return TuplesKt.to(emptyList2, Boxing.boxBoolean(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateStatus$default(SiteMessageRepository siteMessageRepository, List list, String str, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        if ((i & 8) != 0) {
            function02 = null;
        }
        siteMessageRepository.updateStatus(list, str, function0, function02);
    }

    public final void updateStatus(List<Integer> ids, String action, Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        Intrinsics.checkNotNullParameter(action, "action");
        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new SiteMessageRepository$updateStatus$1(ids, action, onSuccess, onFailure, null), 3, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchPreferences(Continuation<? super SiteMessagePreferencesGetResponse.PreferencesData> continuation) {
        SiteMessageRepository$fetchPreferences$1 siteMessageRepository$fetchPreferences$1;
        int i;
        if (continuation instanceof SiteMessageRepository$fetchPreferences$1) {
            siteMessageRepository$fetchPreferences$1 = (SiteMessageRepository$fetchPreferences$1) continuation;
            if ((siteMessageRepository$fetchPreferences$1.label & Integer.MIN_VALUE) != 0) {
                siteMessageRepository$fetchPreferences$1.label -= Integer.MIN_VALUE;
                Object obj = siteMessageRepository$fetchPreferences$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = siteMessageRepository$fetchPreferences$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ISiteMessageApi createService = ISiteMessageApi.INSTANCE.createService();
                    Map<String, String> mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("platform", SiteMessageParams.platform), TuplesKt.to("storeCountryCode", SiteMessagePreferencesCache.INSTANCE.getStoreCountryCode())});
                    siteMessageRepository$fetchPreferences$1.label = 1;
                    obj = createService.getPreferences(mapOf, siteMessageRepository$fetchPreferences$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((SiteMessagePreferencesGetResponse) obj).getData();
            }
        }
        siteMessageRepository$fetchPreferences$1 = new SiteMessageRepository$fetchPreferences$1(this, continuation);
        Object obj2 = siteMessageRepository$fetchPreferences$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = siteMessageRepository$fetchPreferences$1.label;
        if (i != 0) {
        }
        return ((SiteMessagePreferencesGetResponse) obj2).getData();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updatePreferences(Map<String, Boolean> map, Continuation<? super Map<String, Boolean>> continuation) {
        SiteMessageRepository$updatePreferences$1 siteMessageRepository$updatePreferences$1;
        int i;
        if (continuation instanceof SiteMessageRepository$updatePreferences$1) {
            siteMessageRepository$updatePreferences$1 = (SiteMessageRepository$updatePreferences$1) continuation;
            if ((siteMessageRepository$updatePreferences$1.label & Integer.MIN_VALUE) != 0) {
                siteMessageRepository$updatePreferences$1.label -= Integer.MIN_VALUE;
                Object obj = siteMessageRepository$updatePreferences$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = siteMessageRepository$updatePreferences$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Map<String, Object> mutableMapOf = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("platform", SiteMessageParams.platform)});
                    for (Map.Entry<String, Boolean> entry : map.entrySet()) {
                        mutableMapOf.put(entry.getKey(), Boxing.boxBoolean(entry.getValue().booleanValue()));
                    }
                    ISiteMessageApi createService = ISiteMessageApi.INSTANCE.createService();
                    siteMessageRepository$updatePreferences$1.label = 1;
                    obj = createService.updatePreferences(mutableMapOf, siteMessageRepository$updatePreferences$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((SiteMessagePreferencesPostResponse) obj).getData();
            }
        }
        siteMessageRepository$updatePreferences$1 = new SiteMessageRepository$updatePreferences$1(this, continuation);
        Object obj2 = siteMessageRepository$updatePreferences$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = siteMessageRepository$updatePreferences$1.label;
        if (i != 0) {
        }
        return ((SiteMessagePreferencesPostResponse) obj2).getData();
    }

    public final void handleLogout() {
        _unreadCount.setValue(0);
        readTracker.clearAll();
        SiteMessagePreferencesCache.INSTANCE.clear();
        initialized = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void migrateDefaultPreferences() {
        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new SiteMessageRepository$migrateDefaultPreferences$1(SiteMessagePreferencesCache.INSTANCE.defaultPreferences(), null), 3, (Object) null);
    }
}
