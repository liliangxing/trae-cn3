package com.bytedance.trae.kmp.network;

import com.bytedance.trae.kmp.host.KmpHostEnvironment;
import com.bytedance.trae.kmp.host.KmpHostInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: TraeKmpHttpClient.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJh\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0019H\u0096@¢\u0006\u0002\u0010\u001aJd\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0019H\u0096@¢\u0006\u0002\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0014\u0010 \u001a\u00020\u0017*\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J0\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0014H\u0002J4\u0010#\u001a\u00020$\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u000e0\rH\u0002J&\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e*\u00020)2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;", "Lcom/bytedance/trae/kmp/network/KmpHttpClient;", "rawClient", "Lcom/bytedance/trae/kmp/network/KmpRawHttpClient;", "headerProvider", "Lcom/bytedance/trae/kmp/network/KmpHttpHeaderProvider;", "eventReporter", "Lcom/bytedance/trae/kmp/network/KmpHttpEventReporter;", "hostInfo", "Lcom/bytedance/trae/kmp/host/KmpHostInfo;", "<init>", "(Lcom/bytedance/trae/kmp/network/KmpRawHttpClient;Lcom/bytedance/trae/kmp/network/KmpHttpHeaderProvider;Lcom/bytedance/trae/kmp/network/KmpHttpEventReporter;Lcom/bytedance/trae/kmp/host/KmpHostInfo;)V", "getResult", "Lcom/bytedance/trae/kmp/network/KmpHttpResult;", "T", "hostType", "Lcom/bytedance/trae/kmp/network/KmpHostType;", "path", "", "headers", "", "queries", "options", "Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lcom/bytedance/trae/kmp/network/KmpHostType;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;Lkotlinx/serialization/DeserializationStrategy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postResult", "body", "contentType", "(Lcom/bytedance/trae/kmp/network/KmpHostType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;Lkotlinx/serialization/DeserializationStrategy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "absoluteUrl", "withHostType", "mergedHeaders", "requestHeaders", "reportIfNeeded", "", "costTimeMs", "", "result", "decode", "Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeKmpHttpClient implements KmpHttpClient {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion(null);
    private static final Json json = JsonKt.Json$default((Json) null, new Function1() { // from class: com.bytedance.trae.kmp.network.TraeKmpHttpClient$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit json$lambda$3;
            json$lambda$3 = TraeKmpHttpClient.json$lambda$3((JsonBuilder) obj);
            return json$lambda$3;
        }
    }, 1, (Object) null);
    private final KmpHttpEventReporter eventReporter;
    private final KmpHttpHeaderProvider headerProvider;
    private final KmpHostInfo hostInfo;
    private final KmpRawHttpClient rawClient;

    public TraeKmpHttpClient(KmpRawHttpClient kmpRawHttpClient, KmpHttpHeaderProvider kmpHttpHeaderProvider, KmpHttpEventReporter kmpHttpEventReporter, KmpHostInfo kmpHostInfo) {
        Intrinsics.checkNotNullParameter(kmpRawHttpClient, "rawClient");
        Intrinsics.checkNotNullParameter(kmpHttpHeaderProvider, "headerProvider");
        Intrinsics.checkNotNullParameter(kmpHttpEventReporter, "eventReporter");
        Intrinsics.checkNotNullParameter(kmpHostInfo, "hostInfo");
        this.rawClient = kmpRawHttpClient;
        this.headerProvider = kmpHttpHeaderProvider;
        this.eventReporter = kmpHttpEventReporter;
        this.hostInfo = kmpHostInfo;
    }

    public /* synthetic */ TraeKmpHttpClient(KmpRawHttpClient kmpRawHttpClient, KmpHttpHeaderProvider kmpHttpHeaderProvider, KmpHttpEventReporter kmpHttpEventReporter, KmpHostEnvironment kmpHostEnvironment, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kmpRawHttpClient, kmpHttpHeaderProvider, kmpHttpEventReporter, (i & 8) != 0 ? KmpHostEnvironment.INSTANCE : kmpHostEnvironment);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // com.bytedance.trae.kmp.network.KmpHttpClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object getResult(KmpHostType kmpHostType, String str, Map<String, String> map, Map<String, String> map2, KmpHttpRequestOptions kmpHttpRequestOptions, DeserializationStrategy<? extends T> deserializationStrategy, Continuation<? super KmpHttpResult<T>> continuation) {
        TraeKmpHttpClient$getResult$1 traeKmpHttpClient$getResult$1;
        int i;
        KmpHttpRequestOptions withHostType;
        String str2;
        DeserializationStrategy<? extends T> deserializationStrategy2;
        TraeKmpHttpClient traeKmpHttpClient;
        TraeKmpHttpClient traeKmpHttpClient2;
        long j;
        if (continuation instanceof TraeKmpHttpClient$getResult$1) {
            traeKmpHttpClient$getResult$1 = (TraeKmpHttpClient$getResult$1) continuation;
            if ((traeKmpHttpClient$getResult$1.label & Integer.MIN_VALUE) != 0) {
                traeKmpHttpClient$getResult$1.label -= Integer.MIN_VALUE;
                TraeKmpHttpClient$getResult$1 traeKmpHttpClient$getResult$12 = traeKmpHttpClient$getResult$1;
                Object obj = traeKmpHttpClient$getResult$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = traeKmpHttpClient$getResult$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    withHostType = withHostType(kmpHttpRequestOptions, kmpHostType);
                    long j2 = TimeSource.Monotonic.INSTANCE.markNow-z9LOYto();
                    KmpRawHttpClient kmpRawHttpClient = this.rawClient;
                    String absoluteUrl = absoluteUrl(kmpHostType, str);
                    Map<String, String> mergedHeaders = mergedHeaders(withHostType, map);
                    traeKmpHttpClient$getResult$12.L$0 = this;
                    str2 = str;
                    traeKmpHttpClient$getResult$12.L$1 = str2;
                    deserializationStrategy2 = deserializationStrategy;
                    traeKmpHttpClient$getResult$12.L$2 = deserializationStrategy2;
                    traeKmpHttpClient$getResult$12.L$3 = withHostType;
                    traeKmpHttpClient$getResult$12.L$4 = this;
                    traeKmpHttpClient$getResult$12.J$0 = j2;
                    traeKmpHttpClient$getResult$12.label = 1;
                    obj = kmpRawHttpClient.getRaw(absoluteUrl, mergedHeaders, map2, withHostType, traeKmpHttpClient$getResult$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    traeKmpHttpClient = this;
                    traeKmpHttpClient2 = traeKmpHttpClient;
                    j = j2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j = traeKmpHttpClient$getResult$12.J$0;
                    traeKmpHttpClient = (TraeKmpHttpClient) traeKmpHttpClient$getResult$12.L$4;
                    KmpHttpRequestOptions kmpHttpRequestOptions2 = (KmpHttpRequestOptions) traeKmpHttpClient$getResult$12.L$3;
                    DeserializationStrategy<? extends T> deserializationStrategy3 = (DeserializationStrategy) traeKmpHttpClient$getResult$12.L$2;
                    String str3 = (String) traeKmpHttpClient$getResult$12.L$1;
                    traeKmpHttpClient2 = (TraeKmpHttpClient) traeKmpHttpClient$getResult$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    withHostType = kmpHttpRequestOptions2;
                    deserializationStrategy2 = deserializationStrategy3;
                    str2 = str3;
                }
                KmpHttpResult<T> decode = traeKmpHttpClient.decode((KmpRawHttpResult) obj, deserializationStrategy2);
                traeKmpHttpClient2.reportIfNeeded(str2, withHostType, Duration.getInWholeMilliseconds-impl(TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(j)), decode);
                return decode;
            }
        }
        traeKmpHttpClient$getResult$1 = new TraeKmpHttpClient$getResult$1(this, continuation);
        TraeKmpHttpClient$getResult$1 traeKmpHttpClient$getResult$122 = traeKmpHttpClient$getResult$1;
        Object obj2 = traeKmpHttpClient$getResult$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = traeKmpHttpClient$getResult$122.label;
        if (i != 0) {
        }
        KmpHttpResult<T> decode2 = traeKmpHttpClient.decode((KmpRawHttpResult) obj2, deserializationStrategy2);
        traeKmpHttpClient2.reportIfNeeded(str2, withHostType, Duration.getInWholeMilliseconds-impl(TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(j)), decode2);
        return decode2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // com.bytedance.trae.kmp.network.KmpHttpClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object postResult(KmpHostType kmpHostType, String str, String str2, String str3, Map<String, String> map, KmpHttpRequestOptions kmpHttpRequestOptions, DeserializationStrategy<? extends T> deserializationStrategy, Continuation<? super KmpHttpResult<T>> continuation) {
        TraeKmpHttpClient$postResult$1 traeKmpHttpClient$postResult$1;
        int i;
        KmpHttpRequestOptions withHostType;
        DeserializationStrategy<? extends T> deserializationStrategy2;
        TraeKmpHttpClient traeKmpHttpClient;
        TraeKmpHttpClient traeKmpHttpClient2;
        long j;
        String str4;
        if (continuation instanceof TraeKmpHttpClient$postResult$1) {
            traeKmpHttpClient$postResult$1 = (TraeKmpHttpClient$postResult$1) continuation;
            if ((traeKmpHttpClient$postResult$1.label & Integer.MIN_VALUE) != 0) {
                traeKmpHttpClient$postResult$1.label -= Integer.MIN_VALUE;
                TraeKmpHttpClient$postResult$1 traeKmpHttpClient$postResult$12 = traeKmpHttpClient$postResult$1;
                Object obj = traeKmpHttpClient$postResult$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = traeKmpHttpClient$postResult$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    withHostType = withHostType(kmpHttpRequestOptions, kmpHostType);
                    long j2 = TimeSource.Monotonic.INSTANCE.markNow-z9LOYto();
                    KmpRawHttpClient kmpRawHttpClient = this.rawClient;
                    String absoluteUrl = absoluteUrl(kmpHostType, str);
                    Map<String, String> mergedHeaders = mergedHeaders(withHostType, map);
                    traeKmpHttpClient$postResult$12.L$0 = this;
                    traeKmpHttpClient$postResult$12.L$1 = str;
                    deserializationStrategy2 = deserializationStrategy;
                    traeKmpHttpClient$postResult$12.L$2 = deserializationStrategy2;
                    traeKmpHttpClient$postResult$12.L$3 = withHostType;
                    traeKmpHttpClient$postResult$12.L$4 = this;
                    traeKmpHttpClient$postResult$12.J$0 = j2;
                    traeKmpHttpClient$postResult$12.label = 1;
                    obj = kmpRawHttpClient.postRaw(absoluteUrl, str2, str3, mergedHeaders, withHostType, traeKmpHttpClient$postResult$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    traeKmpHttpClient = this;
                    traeKmpHttpClient2 = traeKmpHttpClient;
                    j = j2;
                    str4 = str;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j = traeKmpHttpClient$postResult$12.J$0;
                    traeKmpHttpClient = (TraeKmpHttpClient) traeKmpHttpClient$postResult$12.L$4;
                    KmpHttpRequestOptions kmpHttpRequestOptions2 = (KmpHttpRequestOptions) traeKmpHttpClient$postResult$12.L$3;
                    DeserializationStrategy<? extends T> deserializationStrategy3 = (DeserializationStrategy) traeKmpHttpClient$postResult$12.L$2;
                    str4 = (String) traeKmpHttpClient$postResult$12.L$1;
                    traeKmpHttpClient2 = (TraeKmpHttpClient) traeKmpHttpClient$postResult$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    withHostType = kmpHttpRequestOptions2;
                    deserializationStrategy2 = deserializationStrategy3;
                }
                KmpHttpResult<T> decode = traeKmpHttpClient.decode((KmpRawHttpResult) obj, deserializationStrategy2);
                traeKmpHttpClient2.reportIfNeeded(str4, withHostType, Duration.getInWholeMilliseconds-impl(TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(j)), decode);
                return decode;
            }
        }
        traeKmpHttpClient$postResult$1 = new TraeKmpHttpClient$postResult$1(this, continuation);
        TraeKmpHttpClient$postResult$1 traeKmpHttpClient$postResult$122 = traeKmpHttpClient$postResult$1;
        Object obj2 = traeKmpHttpClient$postResult$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = traeKmpHttpClient$postResult$122.label;
        if (i != 0) {
        }
        KmpHttpResult<T> decode2 = traeKmpHttpClient.decode((KmpRawHttpResult) obj2, deserializationStrategy2);
        traeKmpHttpClient2.reportIfNeeded(str4, withHostType, Duration.getInWholeMilliseconds-impl(TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(j)), decode2);
        return decode2;
    }

    private final String absoluteUrl(KmpHostType hostType, String path) {
        String baseUrl = KmpHostResolver.INSTANCE.baseUrl(hostType, this.hostInfo);
        return (StringsKt.endsWith$default(baseUrl, "/", false, 2, (Object) null) && StringsKt.startsWith$default(path, "/", false, 2, (Object) null)) ? StringsKt.dropLast(baseUrl, 1) + path : (StringsKt.endsWith$default(baseUrl, "/", false, 2, (Object) null) || StringsKt.startsWith$default(path, "/", false, 2, (Object) null)) ? baseUrl + path : baseUrl + '/' + path;
    }

    private final KmpHttpRequestOptions withHostType(KmpHttpRequestOptions kmpHttpRequestOptions, KmpHostType kmpHostType) {
        return kmpHttpRequestOptions.getHostType() == kmpHostType ? kmpHttpRequestOptions : KmpHttpRequestOptions.copy$default(kmpHttpRequestOptions, null, false, false, false, null, kmpHostType, 31, null);
    }

    private final Map<String, String> mergedHeaders(KmpHttpRequestOptions options, Map<String, String> requestHeaders) {
        return this.headerProvider.headers(options, requestHeaders);
    }

    private final <T> void reportIfNeeded(String path, KmpHttpRequestOptions options, long costTimeMs, KmpHttpResult<T> result) {
        String statusMessage;
        if (options.getTrackRequestEvent()) {
            T data = result.getData();
            KmpBusinessResponse kmpBusinessResponse = data instanceof KmpBusinessResponse ? (KmpBusinessResponse) data : null;
            long code = kmpBusinessResponse != null ? kmpBusinessResponse.getCode() : result.getStatusCode();
            if (kmpBusinessResponse == null || (statusMessage = kmpBusinessResponse.getBusinessMessage()) == null) {
                statusMessage = result.getStatusMessage();
            }
            KmpHttpRequestEvent kmpHttpRequestEvent = new KmpHttpRequestEvent(path, costTimeMs, code, statusMessage, result.getHeaders());
            try {
                Result.Companion companion = Result.Companion;
                TraeKmpHttpClient traeKmpHttpClient = this;
                this.eventReporter.report(kmpHttpRequestEvent);
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
        }
    }

    private final <T> KmpHttpResult<T> decode(KmpRawHttpResult kmpRawHttpResult, DeserializationStrategy<? extends T> deserializationStrategy) {
        Object obj;
        Result result;
        Object obj2;
        Throwable th;
        String rawBody = kmpRawHttpResult.getRawBody();
        if (rawBody != null) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(json.decodeFromString(deserializationStrategy, rawBody));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th2));
            }
            result = Result.box-impl(obj);
        } else {
            result = null;
        }
        if (result != null) {
            Object obj3 = result.unbox-impl();
            if (!Result.isFailure-impl(obj3)) {
                obj2 = obj3;
                return new KmpHttpResult<>(obj2, kmpRawHttpResult.getRawBody(), kmpRawHttpResult.getStatusCode(), kmpRawHttpResult.getStatusMessage(), kmpRawHttpResult.getHeaders(), (result != null || (th = Result.exceptionOrNull-impl(result.unbox-impl())) == null) ? kmpRawHttpResult.getError() : th);
            }
        }
        obj2 = null;
        return new KmpHttpResult<>(obj2, kmpRawHttpResult.getRawBody(), kmpRawHttpResult.getStatusCode(), kmpRawHttpResult.getStatusMessage(), kmpRawHttpResult.getHeaders(), (result != null || (th = Result.exceptionOrNull-impl(result.unbox-impl())) == null) ? kmpRawHttpResult.getError() : th);
    }

    /* compiled from: TraeKmpHttpClient.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient$Companion;", "", "<init>", "()V", "json", "Lkotlinx/serialization/json/Json;", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit json$lambda$3(JsonBuilder jsonBuilder) {
        Intrinsics.checkNotNullParameter(jsonBuilder, "$this$Json");
        jsonBuilder.setIgnoreUnknownKeys(true);
        return Unit.INSTANCE;
    }
}
