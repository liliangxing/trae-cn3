package com.bytedance.trae.home.solo.setting.data;

import com.bytedance.trae.home.solo.setting.data.model.PayIdentity;
import com.bytedance.trae.home.solo.setting.data.model.PayStatusRequestDto;
import com.bytedance.trae.home.solo.setting.data.model.PayStatusResponseDto;
import com.bytedance.trae.home.solo.sitemessage.SiteMessageParams;
import com.bytedance.trae.kmp.host.KmpHostInfo;
import com.bytedance.trae.kmp.network.KmpHostType;
import com.bytedance.trae.kmp.network.KmpHttpClient;
import com.bytedance.trae.kmp.network.KmpHttpRequestOptions;
import com.bytedance.trae.kmp.network.KmpHttpResult;
import com.bytedance.trae.kmp.network.KmpRequestAuth;
import com.bytedance.trae.kmp.repository.KmpRepositoryCoroutinesKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.Json;

/* compiled from: PayRepository.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0082@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;", "Lcom/bytedance/trae/home/solo/setting/data/PayRepository;", "httpClient", "Lcom/bytedance/trae/kmp/network/KmpHttpClient;", "hostInfo", "Lcom/bytedance/trae/kmp/host/KmpHostInfo;", "repositoryDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/bytedance/trae/kmp/network/KmpHttpClient;Lcom/bytedance/trae/kmp/host/KmpHostInfo;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_payIdentity", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/trae/home/solo/setting/data/model/PayIdentity;", "payIdentity", "Lkotlinx/coroutines/flow/StateFlow;", "getPayIdentity", "()Lkotlinx/coroutines/flow/StateFlow;", "refresh", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchPayStatus", "Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DefaultPayRepository implements PayRepository {
    private static final String DEFAULT_FREE_BADGE_TEXT = "Free";
    private static final String PAY_STATUS_MAINLAND_PATH = "/trae/api/v2/pay/ide_user_pay_status";
    private static final String PAY_STATUS_OVERSEA_PATH = "/trae/api/v1/pay/ide_user_pay_status";
    private final MutableStateFlow<PayIdentity> _payIdentity;
    private final KmpHostInfo hostInfo;
    private final KmpHttpClient httpClient;
    private final StateFlow<PayIdentity> payIdentity;
    private final CoroutineDispatcher repositoryDispatcher;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String PAY_STATUS_TAG = "user_pay_status";
    private static final KmpHttpRequestOptions PAY_STATUS_OVERSEA_REQUEST_OPTIONS = new KmpHttpRequestOptions(PAY_STATUS_TAG, false, false, false, (KmpRequestAuth) null, KmpHostType.Login, 30, (DefaultConstructorMarker) null);
    private static final KmpHttpRequestOptions PAY_STATUS_MAINLAND_REQUEST_OPTIONS = new KmpHttpRequestOptions(PAY_STATUS_TAG, false, false, false, (KmpRequestAuth) null, KmpHostType.Login, 30, (DefaultConstructorMarker) null);

    public DefaultPayRepository(KmpHttpClient kmpHttpClient, KmpHostInfo kmpHostInfo, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(kmpHttpClient, "httpClient");
        Intrinsics.checkNotNullParameter(kmpHostInfo, "hostInfo");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "repositoryDispatcher");
        this.httpClient = kmpHttpClient;
        this.hostInfo = kmpHostInfo;
        this.repositoryDispatcher = coroutineDispatcher;
        MutableStateFlow<PayIdentity> MutableStateFlow = StateFlowKt.MutableStateFlow((Object) null);
        this._payIdentity = MutableStateFlow;
        this.payIdentity = FlowKt.asStateFlow(MutableStateFlow);
    }

    public /* synthetic */ DefaultPayRepository(KmpHttpClient kmpHttpClient, KmpHostInfo kmpHostInfo, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kmpHttpClient, kmpHostInfo, (i & 4) != 0 ? Dispatchers.getDefault() : coroutineDispatcher);
    }

    @Override // com.bytedance.trae.home.solo.setting.data.PayRepository
    public StateFlow<PayIdentity> getPayIdentity() {
        return this.payIdentity;
    }

    @Override // com.bytedance.trae.home.solo.setting.data.PayRepository
    public Object refresh(Continuation<? super Unit> continuation) {
        Object withRepositoryContext = KmpRepositoryCoroutinesKt.withRepositoryContext(this.repositoryDispatcher, new DefaultPayRepository$refresh$2(this, null), continuation);
        return withRepositoryContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withRepositoryContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchPayStatus(Continuation<? super PayStatusResponseDto> continuation) {
        DefaultPayRepository$fetchPayStatus$1 defaultPayRepository$fetchPayStatus$1;
        int i;
        if (continuation instanceof DefaultPayRepository$fetchPayStatus$1) {
            defaultPayRepository$fetchPayStatus$1 = (DefaultPayRepository$fetchPayStatus$1) continuation;
            if ((defaultPayRepository$fetchPayStatus$1.label & Integer.MIN_VALUE) != 0) {
                defaultPayRepository$fetchPayStatus$1.label -= Integer.MIN_VALUE;
                DefaultPayRepository$fetchPayStatus$1 defaultPayRepository$fetchPayStatus$12 = defaultPayRepository$fetchPayStatus$1;
                Object obj = defaultPayRepository$fetchPayStatus$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = defaultPayRepository$fetchPayStatus$12.label;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                        return (PayStatusResponseDto) ((KmpHttpResult) obj).getData();
                    }
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return (PayStatusResponseDto) ((KmpHttpResult) obj).getData();
                }
                ResultKt.throwOnFailure(obj);
                if (this.hostInfo.isOversea()) {
                    KmpHttpClient kmpHttpClient = this.httpClient;
                    KmpHostType kmpHostType = KmpHostType.Login;
                    KmpHttpRequestOptions kmpHttpRequestOptions = PAY_STATUS_OVERSEA_REQUEST_OPTIONS;
                    DeserializationStrategy serializer = PayStatusResponseDto.INSTANCE.serializer();
                    defaultPayRepository$fetchPayStatus$12.label = 1;
                    obj = KmpHttpClient.DefaultImpls.getResult$default(kmpHttpClient, kmpHostType, PAY_STATUS_OVERSEA_PATH, (Map) null, (Map) null, kmpHttpRequestOptions, serializer, defaultPayRepository$fetchPayStatus$12, 12, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return (PayStatusResponseDto) ((KmpHttpResult) obj).getData();
                }
                String encodeToString = Json.Default.encodeToString(PayStatusRequestDto.INSTANCE.serializer(), new PayStatusRequestDto(this.hostInfo.isIOS() ? "iOS" : SiteMessageParams.platform, this.hostInfo.getDeviceId()));
                KmpHttpClient kmpHttpClient2 = this.httpClient;
                KmpHostType kmpHostType2 = KmpHostType.Login;
                KmpHttpRequestOptions kmpHttpRequestOptions2 = PAY_STATUS_MAINLAND_REQUEST_OPTIONS;
                DeserializationStrategy serializer2 = PayStatusResponseDto.INSTANCE.serializer();
                defaultPayRepository$fetchPayStatus$12.label = 2;
                obj = KmpHttpClient.DefaultImpls.postResult$default(kmpHttpClient2, kmpHostType2, PAY_STATUS_MAINLAND_PATH, encodeToString, (String) null, (Map) null, kmpHttpRequestOptions2, serializer2, defaultPayRepository$fetchPayStatus$12, 24, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (PayStatusResponseDto) ((KmpHttpResult) obj).getData();
            }
        }
        defaultPayRepository$fetchPayStatus$1 = new DefaultPayRepository$fetchPayStatus$1(this, continuation);
        DefaultPayRepository$fetchPayStatus$1 defaultPayRepository$fetchPayStatus$122 = defaultPayRepository$fetchPayStatus$1;
        Object obj2 = defaultPayRepository$fetchPayStatus$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = defaultPayRepository$fetchPayStatus$122.label;
        if (i == 0) {
        }
    }

    /* compiled from: PayRepository.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$Companion;", "", "<init>", "()V", "DEFAULT_FREE_BADGE_TEXT", "", "PAY_STATUS_TAG", "PAY_STATUS_OVERSEA_PATH", "PAY_STATUS_MAINLAND_PATH", "PAY_STATUS_OVERSEA_REQUEST_OPTIONS", "Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;", "PAY_STATUS_MAINLAND_REQUEST_OPTIONS", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
