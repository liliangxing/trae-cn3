package com.bytedance.trae.home.solo.setting.data;

import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.bytedance.trae.home.solo.setting.data.SettingsCreditsState;
import com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto;
import com.bytedance.trae.kmp.host.KmpHostInfo;
import com.bytedance.trae.kmp.network.KmpHostType;
import com.bytedance.trae.kmp.network.KmpHttpClient;
import com.bytedance.trae.kmp.network.KmpHttpRequestOptions;
import com.bytedance.trae.kmp.network.KmpHttpResult;
import com.bytedance.trae.kmp.network.KmpRequestAuth;
import com.bytedance.trae.kmp.repository.KmpRepositoryCoroutinesKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObjectBuilder;

/* compiled from: SettingsCreditsRepository.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0001\u0018\u0000 #2\u00020\u0001:\u0003!\"#B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\fH\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0082@¢\u0006\u0002\u0010\u0015J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u000e\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;", "Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsRepository;", "httpClient", "Lcom/bytedance/trae/kmp/network/KmpHttpClient;", "hostInfo", "Lcom/bytedance/trae/kmp/host/KmpHostInfo;", "repositoryDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/bytedance/trae/kmp/network/KmpHttpClient;Lcom/bytedance/trae/kmp/host/KmpHostInfo;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_creditsState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState;", "creditsState", "Lkotlinx/coroutines/flow/StateFlow;", "getCreditsState", "()Lkotlinx/coroutines/flow/StateFlow;", "ownedCreditsBalance", "Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$OwnedCreditsBalance;", "refresh", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initialState", "currentEligibleUserId", "", "fetchCreditsUsage", "Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;", "creditsUsageRequestBody", "toBalancePresentation", "Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Visible;", "formatFiniteBalance", "balance", "", "OwnedCreditsBalance", "SettingsCreditsPolicy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DefaultSettingsCreditsRepository implements SettingsCreditsRepository {
    private static final String CREDITS_USAGE_PATH = "/trae/api/v2/pay/ide_user_ent_usage";
    private static final String INFINITE_BALANCE_TEXT = "∞";
    private static final long INFINITE_LIMIT = -1;
    private static final long SUCCESS_CODE = 0;
    private final MutableStateFlow<SettingsCreditsState> _creditsState;
    private final StateFlow<SettingsCreditsState> creditsState;
    private final KmpHostInfo hostInfo;
    private final KmpHttpClient httpClient;
    private OwnedCreditsBalance ownedCreditsBalance;
    private final CoroutineDispatcher repositoryDispatcher;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final KmpHttpRequestOptions CREDITS_USAGE_REQUEST_OPTIONS = new KmpHttpRequestOptions("user_ent_status", true, false, false, (KmpRequestAuth) null, KmpHostType.Login, 28, (DefaultConstructorMarker) null);

    public DefaultSettingsCreditsRepository(KmpHttpClient kmpHttpClient, KmpHostInfo kmpHostInfo, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(kmpHttpClient, "httpClient");
        Intrinsics.checkNotNullParameter(kmpHostInfo, "hostInfo");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "repositoryDispatcher");
        this.httpClient = kmpHttpClient;
        this.hostInfo = kmpHostInfo;
        this.repositoryDispatcher = coroutineDispatcher;
        MutableStateFlow<SettingsCreditsState> MutableStateFlow = StateFlowKt.MutableStateFlow(initialState());
        this._creditsState = MutableStateFlow;
        this.creditsState = FlowKt.asStateFlow(MutableStateFlow);
    }

    public /* synthetic */ DefaultSettingsCreditsRepository(KmpHttpClient kmpHttpClient, KmpHostInfo kmpHostInfo, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kmpHttpClient, kmpHostInfo, (i & 4) != 0 ? Dispatchers.getDefault() : coroutineDispatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SettingsCreditsRepository.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$OwnedCreditsBalance;", "", "userId", "", "presentation", "Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Visible;", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Visible;)V", "getUserId", "()Ljava/lang/String;", "getPresentation", "()Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Visible;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class OwnedCreditsBalance {
        private final SettingsCreditsState.Visible presentation;
        private final String userId;

        public static /* synthetic */ OwnedCreditsBalance copy$default(OwnedCreditsBalance ownedCreditsBalance, String str, SettingsCreditsState.Visible visible, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ownedCreditsBalance.userId;
            }
            if ((i & 2) != 0) {
                visible = ownedCreditsBalance.presentation;
            }
            return ownedCreditsBalance.copy(str, visible);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        /* renamed from: component2, reason: from getter */
        public final SettingsCreditsState.Visible getPresentation() {
            return this.presentation;
        }

        public final OwnedCreditsBalance copy(String userId, SettingsCreditsState.Visible presentation) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(presentation, "presentation");
            return new OwnedCreditsBalance(userId, presentation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OwnedCreditsBalance)) {
                return false;
            }
            OwnedCreditsBalance ownedCreditsBalance = (OwnedCreditsBalance) other;
            return Intrinsics.areEqual(this.userId, ownedCreditsBalance.userId) && Intrinsics.areEqual(this.presentation, ownedCreditsBalance.presentation);
        }

        public int hashCode() {
            return (this.userId.hashCode() * 31) + this.presentation.hashCode();
        }

        public String toString() {
            return "OwnedCreditsBalance(userId=" + this.userId + ", presentation=" + this.presentation + ')';
        }

        public OwnedCreditsBalance(String str, SettingsCreditsState.Visible visible) {
            Intrinsics.checkNotNullParameter(str, "userId");
            Intrinsics.checkNotNullParameter(visible, "presentation");
            this.userId = str;
            this.presentation = visible;
        }

        public final String getUserId() {
            return this.userId;
        }

        public final SettingsCreditsState.Visible getPresentation() {
            return this.presentation;
        }
    }

    @Override // com.bytedance.trae.home.solo.setting.data.SettingsCreditsRepository
    public StateFlow<SettingsCreditsState> getCreditsState() {
        return this.creditsState;
    }

    @Override // com.bytedance.trae.home.solo.setting.data.SettingsCreditsRepository
    public Object refresh(Continuation<? super Unit> continuation) {
        Object withRepositoryContext = KmpRepositoryCoroutinesKt.withRepositoryContext(this.repositoryDispatcher, new DefaultSettingsCreditsRepository$refresh$2(this, null), continuation);
        return withRepositoryContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withRepositoryContext : Unit.INSTANCE;
    }

    private final SettingsCreditsState initialState() {
        if (currentEligibleUserId() == null) {
            return SettingsCreditsState.Hidden.INSTANCE;
        }
        return SettingsCreditsState.Loading.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0019, code lost:
    
        if ((!kotlin.text.StringsKt.isBlank(r0)) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String currentEligibleUserId() {
        String userId = this.hostInfo.getUserId();
        boolean z = SettingsCreditsPolicy.INSTANCE.isEligible(this.hostInfo);
        if (z) {
            return userId;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchCreditsUsage(Continuation<? super CreditsUsageResponseDto> continuation) {
        DefaultSettingsCreditsRepository$fetchCreditsUsage$1 defaultSettingsCreditsRepository$fetchCreditsUsage$1;
        int i;
        if (continuation instanceof DefaultSettingsCreditsRepository$fetchCreditsUsage$1) {
            defaultSettingsCreditsRepository$fetchCreditsUsage$1 = (DefaultSettingsCreditsRepository$fetchCreditsUsage$1) continuation;
            if ((defaultSettingsCreditsRepository$fetchCreditsUsage$1.label & Integer.MIN_VALUE) != 0) {
                defaultSettingsCreditsRepository$fetchCreditsUsage$1.label -= Integer.MIN_VALUE;
                DefaultSettingsCreditsRepository$fetchCreditsUsage$1 defaultSettingsCreditsRepository$fetchCreditsUsage$12 = defaultSettingsCreditsRepository$fetchCreditsUsage$1;
                Object obj = defaultSettingsCreditsRepository$fetchCreditsUsage$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = defaultSettingsCreditsRepository$fetchCreditsUsage$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    KmpHttpClient kmpHttpClient = this.httpClient;
                    KmpHostType kmpHostType = KmpHostType.Login;
                    String creditsUsageRequestBody = creditsUsageRequestBody();
                    KmpHttpRequestOptions kmpHttpRequestOptions = CREDITS_USAGE_REQUEST_OPTIONS;
                    DeserializationStrategy serializer = CreditsUsageResponseDto.INSTANCE.serializer();
                    defaultSettingsCreditsRepository$fetchCreditsUsage$12.label = 1;
                    obj = KmpHttpClient.DefaultImpls.postResult$default(kmpHttpClient, kmpHostType, CREDITS_USAGE_PATH, creditsUsageRequestBody, (String) null, (Map) null, kmpHttpRequestOptions, serializer, defaultSettingsCreditsRepository$fetchCreditsUsage$12, 24, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((KmpHttpResult) obj).getData();
            }
        }
        defaultSettingsCreditsRepository$fetchCreditsUsage$1 = new DefaultSettingsCreditsRepository$fetchCreditsUsage$1(this, continuation);
        DefaultSettingsCreditsRepository$fetchCreditsUsage$1 defaultSettingsCreditsRepository$fetchCreditsUsage$122 = defaultSettingsCreditsRepository$fetchCreditsUsage$1;
        Object obj2 = defaultSettingsCreditsRepository$fetchCreditsUsage$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = defaultSettingsCreditsRepository$fetchCreditsUsage$122.label;
        if (i != 0) {
        }
        return ((KmpHttpResult) obj2).getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingsCreditsState.Visible toBalancePresentation(CreditsUsageResponseDto creditsUsageResponseDto) {
        List<CreditsUsageResponseDto.EntitlementPackDto> effectiveEntitlementPacks;
        boolean z;
        CreditsUsageResponseDto.EntQuotaDto quota;
        Long creditsLimit;
        Double creditsAmount;
        CreditsUsageResponseDto.EntQuotaDto quota2;
        Long creditsLimit2;
        Long effectiveCode = creditsUsageResponseDto.getEffectiveCode();
        if ((effectiveCode != null && effectiveCode.longValue() != 0) || (effectiveEntitlementPacks = creditsUsageResponseDto.getEffectiveEntitlementPacks()) == null) {
            return null;
        }
        List<CreditsUsageResponseDto.EntitlementPackDto> list = effectiveEntitlementPacks;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                CreditsUsageResponseDto.EntitlementBaseInfoDto entitlementBaseInfo = ((CreditsUsageResponseDto.EntitlementPackDto) it.next()).getEntitlementBaseInfo();
                if ((entitlementBaseInfo == null || (quota = entitlementBaseInfo.getQuota()) == null || (creditsLimit = quota.getCreditsLimit()) == null || creditsLimit.longValue() != -1) ? false : true) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            return new SettingsCreditsState.Visible(INFINITE_BALANCE_TEXT);
        }
        long j = 0;
        double d = 0.0d;
        for (CreditsUsageResponseDto.EntitlementPackDto entitlementPackDto : list) {
            CreditsUsageResponseDto.EntitlementBaseInfoDto entitlementBaseInfo2 = entitlementPackDto.getEntitlementBaseInfo();
            long longValue = (entitlementBaseInfo2 == null || (quota2 = entitlementBaseInfo2.getQuota()) == null || (creditsLimit2 = quota2.getCreditsLimit()) == null) ? 0L : creditsLimit2.longValue();
            if (longValue > 0) {
                if (Long.MAX_VALUE - j < longValue) {
                    return null;
                }
                j += longValue;
                CreditsUsageResponseDto.EntUsageDto usage = entitlementPackDto.getUsage();
                double doubleValue = (usage == null || (creditsAmount = usage.getCreditsAmount()) == null) ? 0.0d : creditsAmount.doubleValue();
                if (!(Math.abs(doubleValue) <= Double.MAX_VALUE) || doubleValue < 0.0d) {
                    return null;
                }
                d += doubleValue;
            }
        }
        return new SettingsCreditsState.Visible(formatFiniteBalance(RangesKt.coerceAtLeast(j - MathKt.roundToLong(d), 0L)));
    }

    private final String formatFiniteBalance(long balance) {
        return StringsKt.reversed(CollectionsKt.joinToString$default(StringsKt.chunked(StringsKt.reversed(String.valueOf(balance)).toString(), 3), IWeiboService.Scope.EMPTY_SCOPE, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SettingsCreditsRepository.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$SettingsCreditsPolicy;", "", "<init>", "()V", "isEligible", "", "hostInfo", "Lcom/bytedance/trae/kmp/host/KmpHostInfo;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class SettingsCreditsPolicy {
        public static final SettingsCreditsPolicy INSTANCE = new SettingsCreditsPolicy();

        private SettingsCreditsPolicy() {
        }

        public final boolean isEligible(KmpHostInfo hostInfo) {
            Intrinsics.checkNotNullParameter(hostInfo, "hostInfo");
            return hostInfo.isLoggedIn() && hostInfo.isMainland() && hostInfo.isPublicCloud();
        }
    }

    /* compiled from: SettingsCreditsRepository.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$Companion;", "", "<init>", "()V", "SUCCESS_CODE", "", "INFINITE_LIMIT", "INFINITE_BALANCE_TEXT", "", "CREDITS_USAGE_PATH", "CREDITS_USAGE_REQUEST_OPTIONS", "Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final String creditsUsageRequestBody() {
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        JsonElementBuildersKt.put(jsonObjectBuilder, "require_usage", true);
        return jsonObjectBuilder.build().toString();
    }
}
