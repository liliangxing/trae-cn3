package com.bytedance.trae.conversation.network;

import com.bytedance.trae.conversation.network.IGeneralActivityApi;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: CustomActivityRepository.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020 R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/trae/conversation/network/CustomActivityRepository;", "", "<init>", "()V", "_cachedActivities", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/trae/conversation/network/GeneralActivityData;", "cachedActivities", "Lkotlinx/coroutines/flow/StateFlow;", "getCachedActivities", "()Lkotlinx/coroutines/flow/StateFlow;", "_firstBanner", "", "firstBanner", "getFirstBanner", "h5Url", "getH5Url", "()Ljava/lang/String;", "setH5Url", "(Ljava/lang/String;)V", "shareUrl", "getShareUrl", "setShareUrl", "postUrl", "getPostUrl", "setPostUrl", "fetchActivities", "Lcom/bytedance/trae/network/response/HttpDataResult;", "forceRefresh", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCache", "", "lastFetchSuccessAt", "", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CustomActivityRepository {
    private static final int MAX_RETRY_COUNT = 10;
    private static final long RETRY_INTERVAL_MS = 30000;
    private static final long SUCCESS_POLL_INTERVAL_MS = 1800000;
    private final MutableStateFlow<GeneralActivityData> _cachedActivities;
    private final MutableStateFlow<String> _firstBanner;
    private final StateFlow<GeneralActivityData> cachedActivities;
    private final StateFlow<String> firstBanner;
    private String h5Url;
    private long lastFetchSuccessAt;
    private String postUrl;
    private String shareUrl;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<CustomActivityRepository> instance$delegate = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.network.CustomActivityRepository$$ExternalSyntheticLambda0
        public final Object invoke() {
            CustomActivityRepository instance_delegate$lambda$0;
            instance_delegate$lambda$0 = CustomActivityRepository.instance_delegate$lambda$0();
            return instance_delegate$lambda$0;
        }
    });

    private CustomActivityRepository() {
        MutableStateFlow<GeneralActivityData> MutableStateFlow = StateFlowKt.MutableStateFlow((Object) null);
        this._cachedActivities = MutableStateFlow;
        this.cachedActivities = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<String> MutableStateFlow2 = StateFlowKt.MutableStateFlow((Object) null);
        this._firstBanner = MutableStateFlow2;
        this.firstBanner = FlowKt.asStateFlow(MutableStateFlow2);
    }

    public final StateFlow<GeneralActivityData> getCachedActivities() {
        return this.cachedActivities;
    }

    public final StateFlow<String> getFirstBanner() {
        return this.firstBanner;
    }

    public final String getH5Url() {
        return this.h5Url;
    }

    public final void setH5Url(String str) {
        this.h5Url = str;
    }

    public final String getShareUrl() {
        return this.shareUrl;
    }

    public final void setShareUrl(String str) {
        this.shareUrl = str;
    }

    public final String getPostUrl() {
        return this.postUrl;
    }

    public final void setPostUrl(String str) {
        this.postUrl = str;
    }

    public static /* synthetic */ Object fetchActivities$default(CustomActivityRepository customActivityRepository, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return customActivityRepository.fetchActivities(z, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x01a8 -> B:11:0x01b9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x01b6 -> B:11:0x01b9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchActivities(boolean z, Continuation<? super HttpDataResult<GeneralActivityData>> continuation) {
        CustomActivityRepository$fetchActivities$1 customActivityRepository$fetchActivities$1;
        int i;
        CustomActivityRepository customActivityRepository;
        int i2;
        GeneralActivityData generalActivityData;
        CustomActivityRepository customActivityRepository2;
        HttpDataResult.Success success;
        ActivityItem first;
        ActivityItem first2;
        ActivityItem first3;
        ActivityItem first4;
        ActivityItem first5;
        if (continuation instanceof CustomActivityRepository$fetchActivities$1) {
            customActivityRepository$fetchActivities$1 = (CustomActivityRepository$fetchActivities$1) continuation;
            if ((customActivityRepository$fetchActivities$1.label & Integer.MIN_VALUE) != 0) {
                customActivityRepository$fetchActivities$1.label -= Integer.MIN_VALUE;
                Object obj = customActivityRepository$fetchActivities$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = customActivityRepository$fetchActivities$1.label;
                String str = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!z) {
                        long j = this.lastFetchSuccessAt;
                        if (j > 0 && currentTimeMillis - j < SUCCESS_POLL_INTERVAL_MS && (generalActivityData = (GeneralActivityData) this._cachedActivities.getValue()) != null) {
                            ActivityItem first6 = generalActivityData.getFirst();
                            if (first6 != null ? Intrinsics.areEqual(first6.getHitActivityTime(), Boxing.boxBoolean(true)) : false) {
                                this._firstBanner.setValue(generalActivityData.getFirst().getIconUrl());
                                this.h5Url = generalActivityData.getFirst().getH5Url();
                                this.shareUrl = generalActivityData.getFirst().getShareUrl();
                                this.postUrl = generalActivityData.getFirst().getPostUrl();
                            } else {
                                this._firstBanner.setValue((Object) null);
                                this.h5Url = null;
                                this.shareUrl = null;
                                this.postUrl = null;
                            }
                            return new HttpDataResult.Success(new BizResponse(0L, (String) null, (String) null, (String) null, generalActivityData, (String) null, 46, (DefaultConstructorMarker) null), (Throwable) null);
                        }
                    }
                    customActivityRepository = this;
                    i2 = 0;
                    if (i2 < 10) {
                    }
                } else if (i == 1) {
                    i2 = customActivityRepository$fetchActivities$1.I$0;
                    customActivityRepository2 = (CustomActivityRepository) customActivityRepository$fetchActivities$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    success = (HttpDataResult) obj;
                    if (success instanceof HttpDataResult.Success) {
                    }
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = customActivityRepository$fetchActivities$1.I$0;
                    customActivityRepository2 = (CustomActivityRepository) customActivityRepository$fetchActivities$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    customActivityRepository = customActivityRepository2;
                    if (i2 < 10) {
                        IGeneralActivityApi.Companion companion = IGeneralActivityApi.INSTANCE;
                        CustomActivityRepository$fetchActivities$result$1 customActivityRepository$fetchActivities$result$1 = new CustomActivityRepository$fetchActivities$result$1(null);
                        customActivityRepository$fetchActivities$1.L$0 = customActivityRepository;
                        customActivityRepository$fetchActivities$1.I$0 = i2;
                        customActivityRepository$fetchActivities$1.label = 1;
                        Object safeCall = companion.safeCall(customActivityRepository$fetchActivities$result$1, customActivityRepository$fetchActivities$1);
                        if (safeCall == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        customActivityRepository2 = customActivityRepository;
                        obj = safeCall;
                        success = (HttpDataResult) obj;
                        if (success instanceof HttpDataResult.Success) {
                            HttpDataResult.Success success2 = success;
                            customActivityRepository2._cachedActivities.setValue(success2.getBizResp().getData());
                            GeneralActivityData generalActivityData2 = (GeneralActivityData) success2.getBizResp().getData();
                            if (generalActivityData2 != null && (first5 = generalActivityData2.getFirst()) != null) {
                                r7 = Intrinsics.areEqual(first5.getHitActivityTime(), Boxing.boxBoolean(true));
                            }
                            if (r7) {
                                MutableStateFlow<String> mutableStateFlow = customActivityRepository2._firstBanner;
                                GeneralActivityData generalActivityData3 = (GeneralActivityData) success2.getBizResp().getData();
                                mutableStateFlow.setValue((generalActivityData3 == null || (first4 = generalActivityData3.getFirst()) == null) ? null : first4.getIconUrl());
                                GeneralActivityData generalActivityData4 = (GeneralActivityData) success2.getBizResp().getData();
                                customActivityRepository2.h5Url = (generalActivityData4 == null || (first3 = generalActivityData4.getFirst()) == null) ? null : first3.getH5Url();
                                GeneralActivityData generalActivityData5 = (GeneralActivityData) success2.getBizResp().getData();
                                customActivityRepository2.shareUrl = (generalActivityData5 == null || (first2 = generalActivityData5.getFirst()) == null) ? null : first2.getShareUrl();
                                GeneralActivityData generalActivityData6 = (GeneralActivityData) success2.getBizResp().getData();
                                if (generalActivityData6 != null && (first = generalActivityData6.getFirst()) != null) {
                                    str = first.getPostUrl();
                                }
                                customActivityRepository2.postUrl = str;
                            } else {
                                customActivityRepository2._firstBanner.setValue((Object) null);
                                customActivityRepository2.h5Url = null;
                                customActivityRepository2.shareUrl = null;
                                customActivityRepository2.postUrl = null;
                            }
                            customActivityRepository2.lastFetchSuccessAt = System.currentTimeMillis();
                            return success;
                        }
                        i2++;
                        if (i2 < 10) {
                            customActivityRepository$fetchActivities$1.L$0 = customActivityRepository2;
                            customActivityRepository$fetchActivities$1.I$0 = i2;
                            customActivityRepository$fetchActivities$1.label = 2;
                            if (DelayKt.delay(30000L, customActivityRepository$fetchActivities$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        customActivityRepository = customActivityRepository2;
                        if (i2 < 10) {
                            return new HttpDataResult.Error(-1000, "Failed after 10 retries", new Exception("Failed after 10 retries"), (String) null, 8, (DefaultConstructorMarker) null);
                        }
                    }
                }
            }
        }
        customActivityRepository$fetchActivities$1 = new CustomActivityRepository$fetchActivities$1(this, continuation);
        Object obj2 = customActivityRepository$fetchActivities$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = customActivityRepository$fetchActivities$1.label;
        String str2 = null;
        if (i != 0) {
        }
    }

    public final void clearCache() {
        this._cachedActivities.setValue((Object) null);
        this.lastFetchSuccessAt = 0L;
    }

    /* compiled from: CustomActivityRepository.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/network/CustomActivityRepository$Companion;", "", "<init>", "()V", "RETRY_INTERVAL_MS", "", "SUCCESS_POLL_INTERVAL_MS", "MAX_RETRY_COUNT", "", "instance", "Lcom/bytedance/trae/conversation/network/CustomActivityRepository;", "getInstance", "()Lcom/bytedance/trae/conversation/network/CustomActivityRepository;", "instance$delegate", "Lkotlin/Lazy;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CustomActivityRepository getInstance() {
            return (CustomActivityRepository) CustomActivityRepository.instance$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomActivityRepository instance_delegate$lambda$0() {
        return new CustomActivityRepository();
    }
}
