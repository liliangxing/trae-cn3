package com.bytedance.trae.home.solo.setting.data;

import com.bytedance.trae.home.solo.setting.SettingsTracker;
import com.bytedance.trae.home.solo.setting.data.model.UnreadCountDto;
import com.bytedance.trae.home.solo.sitemessage.SiteMessageParams;
import com.bytedance.trae.kmp.host.KmpHostInfo;
import com.bytedance.trae.kmp.network.KmpHostType;
import com.bytedance.trae.kmp.network.KmpHttpClient;
import com.bytedance.trae.kmp.network.KmpHttpRequestOptions;
import com.bytedance.trae.kmp.network.KmpHttpResult;
import com.bytedance.trae.kmp.network.KmpRequestAuth;
import com.bytedance.trae.kmp.repository.KmpRepositoryCoroutinesKt;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.DeserializationStrategy;

/* compiled from: NotificationRepository.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;", "Lcom/bytedance/trae/home/solo/setting/data/NotificationRepository;", "httpClient", "Lcom/bytedance/trae/kmp/network/KmpHttpClient;", "hostInfo", "Lcom/bytedance/trae/kmp/host/KmpHostInfo;", "repositoryDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/bytedance/trae/kmp/network/KmpHttpClient;Lcom/bytedance/trae/kmp/host/KmpHostInfo;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_unreadCount", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "unreadCount", "Lkotlinx/coroutines/flow/StateFlow;", "getUnreadCount", "()Lkotlinx/coroutines/flow/StateFlow;", "refresh", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchUnreadCount", "notificationCountParams", "", "", "notificationLanguage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DefaultNotificationRepository implements NotificationRepository {
    private static final String NOTIFICATION_COUNT_PATH = "/icube/api/v1/notifications/count";
    private final MutableStateFlow<Integer> _unreadCount;
    private final KmpHostInfo hostInfo;
    private final KmpHttpClient httpClient;
    private final CoroutineDispatcher repositoryDispatcher;
    private final StateFlow<Integer> unreadCount;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String NOTIFICATION_TAG = "site_message";
    private static final KmpHttpRequestOptions NOTIFICATION_REQUEST_OPTIONS = new KmpHttpRequestOptions(NOTIFICATION_TAG, false, false, false, KmpRequestAuth.CloudIdeJwtAuthorization, KmpHostType.Notification, 14, (DefaultConstructorMarker) null);

    public DefaultNotificationRepository(KmpHttpClient kmpHttpClient, KmpHostInfo kmpHostInfo, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(kmpHttpClient, "httpClient");
        Intrinsics.checkNotNullParameter(kmpHostInfo, "hostInfo");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "repositoryDispatcher");
        this.httpClient = kmpHttpClient;
        this.hostInfo = kmpHostInfo;
        this.repositoryDispatcher = coroutineDispatcher;
        MutableStateFlow<Integer> MutableStateFlow = StateFlowKt.MutableStateFlow(0);
        this._unreadCount = MutableStateFlow;
        this.unreadCount = FlowKt.asStateFlow(MutableStateFlow);
    }

    public /* synthetic */ DefaultNotificationRepository(KmpHttpClient kmpHttpClient, KmpHostInfo kmpHostInfo, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kmpHttpClient, kmpHostInfo, (i & 4) != 0 ? Dispatchers.getDefault() : coroutineDispatcher);
    }

    @Override // com.bytedance.trae.home.solo.setting.data.NotificationRepository
    public StateFlow<Integer> getUnreadCount() {
        return this.unreadCount;
    }

    @Override // com.bytedance.trae.home.solo.setting.data.NotificationRepository
    public Object refresh(Continuation<? super Unit> continuation) {
        Object withRepositoryContext = KmpRepositoryCoroutinesKt.withRepositoryContext(this.repositoryDispatcher, new DefaultNotificationRepository$refresh$2(this, null), continuation);
        return withRepositoryContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withRepositoryContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchUnreadCount(Continuation<? super Integer> continuation) {
        DefaultNotificationRepository$fetchUnreadCount$1 defaultNotificationRepository$fetchUnreadCount$1;
        int i;
        UnreadCountDto.CountData data;
        if (continuation instanceof DefaultNotificationRepository$fetchUnreadCount$1) {
            defaultNotificationRepository$fetchUnreadCount$1 = (DefaultNotificationRepository$fetchUnreadCount$1) continuation;
            if ((defaultNotificationRepository$fetchUnreadCount$1.label & Integer.MIN_VALUE) != 0) {
                defaultNotificationRepository$fetchUnreadCount$1.label -= Integer.MIN_VALUE;
                DefaultNotificationRepository$fetchUnreadCount$1 defaultNotificationRepository$fetchUnreadCount$12 = defaultNotificationRepository$fetchUnreadCount$1;
                Object obj = defaultNotificationRepository$fetchUnreadCount$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = defaultNotificationRepository$fetchUnreadCount$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    KmpHttpClient kmpHttpClient = this.httpClient;
                    KmpHostType kmpHostType = KmpHostType.Notification;
                    Map<String, String> notificationCountParams = notificationCountParams();
                    KmpHttpRequestOptions kmpHttpRequestOptions = NOTIFICATION_REQUEST_OPTIONS;
                    DeserializationStrategy serializer = UnreadCountDto.INSTANCE.serializer();
                    defaultNotificationRepository$fetchUnreadCount$12.label = 1;
                    obj = KmpHttpClient.DefaultImpls.getResult$default(kmpHttpClient, kmpHostType, NOTIFICATION_COUNT_PATH, (Map) null, notificationCountParams, kmpHttpRequestOptions, serializer, defaultNotificationRepository$fetchUnreadCount$12, 4, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                UnreadCountDto unreadCountDto = (UnreadCountDto) ((KmpHttpResult) obj).getData();
                return Boxing.boxInt((unreadCountDto != null || (data = unreadCountDto.getData()) == null) ? 0 : data.getCount());
            }
        }
        defaultNotificationRepository$fetchUnreadCount$1 = new DefaultNotificationRepository$fetchUnreadCount$1(this, continuation);
        DefaultNotificationRepository$fetchUnreadCount$1 defaultNotificationRepository$fetchUnreadCount$122 = defaultNotificationRepository$fetchUnreadCount$1;
        Object obj2 = defaultNotificationRepository$fetchUnreadCount$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = defaultNotificationRepository$fetchUnreadCount$122.label;
        if (i != 0) {
        }
        UnreadCountDto unreadCountDto2 = (UnreadCountDto) ((KmpHttpResult) obj2).getData();
        return Boxing.boxInt((unreadCountDto2 != null || (data = unreadCountDto2.getData()) == null) ? 0 : data.getCount());
    }

    private final Map<String, String> notificationCountParams() {
        Map createMapBuilder = MapsKt.createMapBuilder();
        createMapBuilder.put("version", this.hostInfo.getAppVersionName());
        createMapBuilder.put("platform", this.hostInfo.isIOS() ? "iOS" : SiteMessageParams.platform);
        createMapBuilder.put(SettingsTracker.TYPE_LANGUAGE, notificationLanguage());
        String storeCountryCode = this.hostInfo.getStoreCountryCode();
        if (!(!StringsKt.isBlank(storeCountryCode))) {
            storeCountryCode = null;
        }
        if (storeCountryCode != null) {
            createMapBuilder.put("storeCountryCode", storeCountryCode);
        }
        return MapsKt.build(createMapBuilder);
    }

    private final String notificationLanguage() {
        String lowerCase = this.hostInfo.getLanguageCode().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return StringsKt.startsWith$default(lowerCase, "zh", false, 2, (Object) null) ? "zh-cn" : StringsKt.startsWith$default(lowerCase, "ja", false, 2, (Object) null) ? "ja" : "en";
    }

    /* compiled from: NotificationRepository.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository$Companion;", "", "<init>", "()V", "NOTIFICATION_TAG", "", "NOTIFICATION_COUNT_PATH", "NOTIFICATION_REQUEST_OPTIONS", "Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
