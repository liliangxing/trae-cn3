package com.bytedance.trae.conversation.imageupload;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: StsTokenManager.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BL\u00121\u0010\u0002\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0017H\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0016\u0010'\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010(J\u0016\u0010)\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010(J\u0010\u0010*\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0016\u0010+\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010(J\u0012\u0010,\u001a\u00020#2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004R;\u0010\u0002\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00150\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;", "", "getStsTokenApi", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "userId", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/trae/conversation/imageupload/StsTokenResponse;", "fallbackServiceIdProvider", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "Lkotlin/jvm/functions/Function2;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "tokenCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/trae/conversation/imageupload/StsTokenData;", "refreshPromises", "Lkotlinx/coroutines/Deferred;", "serverTimeDiffMillis", "", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "getCalibratedNowMillis", "isoParsers", "", "Ljava/text/SimpleDateFormat;", "parseIsoMillis", "iso", "formatIsoUtc", "millis", "updateServerTimeDiff", "", "serverTimeIso", "checkTokenStatus", "Lcom/bytedance/trae/conversation/imageupload/TokenStatus;", "fetchToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshTokenSync", "refreshTokenAsync", "getToken", "clearToken", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class StsTokenManager {
    private final Function0<String> fallbackServiceIdProvider;
    private final Function2<String, Continuation<? super StsTokenResponse>, Object> getStsTokenApi;
    private final Mutex mutex;
    private final ConcurrentHashMap<String, Deferred<StsTokenData>> refreshPromises;
    private final CoroutineScope scope;
    private volatile long serverTimeDiffMillis;
    private final ConcurrentHashMap<String, StsTokenData> tokenCache;

    /* compiled from: StsTokenManager.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TokenStatus.values().length];
            try {
                iArr[TokenStatus.NeedSyncRefresh.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TokenStatus.NeedAsyncRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TokenStatus.Valid.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StsTokenManager(Function2<? super String, ? super Continuation<? super StsTokenResponse>, ? extends Object> function2, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function2, "getStsTokenApi");
        Intrinsics.checkNotNullParameter(function0, "fallbackServiceIdProvider");
        this.getStsTokenApi = function2;
        this.fallbackServiceIdProvider = function0;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
        this.tokenCache = new ConcurrentHashMap<>();
        this.refreshPromises = new ConcurrentHashMap<>();
        this.mutex = MutexKt.Mutex$default(false, 1, (Object) null);
    }

    public /* synthetic */ StsTokenManager(Function2 function2, C07321 c07321, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2, (i & 2) != 0 ? new Function0() { // from class: com.bytedance.trae.conversation.imageupload.StsTokenManager.1
            public final Void invoke() {
                return null;
            }
        } : c07321);
    }

    private final long getCalibratedNowMillis() {
        return System.currentTimeMillis() + this.serverTimeDiffMillis;
    }

    private final List<SimpleDateFormat> isoParsers() {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(timeZone);
        Unit unit = Unit.INSTANCE;
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat2.setTimeZone(timeZone);
        Unit unit2 = Unit.INSTANCE;
        return CollectionsKt.listOf(new SimpleDateFormat[]{simpleDateFormat, simpleDateFormat2, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.US), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.US)});
    }

    private final long parseIsoMillis(String iso) {
        String obj = StringsKt.trim(iso).toString();
        long j = 0;
        if (obj.length() == 0) {
            return 0L;
        }
        Iterator<SimpleDateFormat> it = isoParsers().iterator();
        while (it.hasNext()) {
            try {
                Date parse = it.next().parse(obj);
                if (parse == null) {
                    break;
                }
                j = parse.getTime();
                break;
            } catch (ParseException unused) {
            }
        }
        return j;
    }

    private final String formatIsoUtc(long millis) {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(timeZone);
        String format = simpleDateFormat.format(Long.valueOf(millis));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private final void updateServerTimeDiff(String serverTimeIso) {
        long parseIsoMillis = parseIsoMillis(serverTimeIso);
        if (parseIsoMillis <= 0) {
            return;
        }
        this.serverTimeDiffMillis = parseIsoMillis - System.currentTimeMillis();
    }

    private final TokenStatus checkTokenStatus(String userId) {
        StsTokenData stsTokenData = this.tokenCache.get(userId);
        if (stsTokenData == null) {
            return TokenStatus.NeedSyncRefresh;
        }
        long parseIsoMillis = parseIsoMillis(stsTokenData.getExpiredTimeIso());
        if (parseIsoMillis <= 0) {
            return TokenStatus.NeedSyncRefresh;
        }
        long calibratedNowMillis = parseIsoMillis - getCalibratedNowMillis();
        if (calibratedNowMillis < 60000) {
            return TokenStatus.NeedSyncRefresh;
        }
        if (calibratedNowMillis < ImageUploadConstants.TOKEN_SAFETY_THRESHOLD_MS) {
            return TokenStatus.NeedAsyncRefresh;
        }
        return TokenStatus.Valid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0096 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchToken(String str, Continuation<? super StsTokenData> continuation) {
        StsTokenManager$fetchToken$1 stsTokenManager$fetchToken$1;
        int i;
        StsTokenManager stsTokenManager;
        StsTokenData stsTokenData;
        String serviceId;
        try {
            if (continuation instanceof StsTokenManager$fetchToken$1) {
                stsTokenManager$fetchToken$1 = (StsTokenManager$fetchToken$1) continuation;
                if ((stsTokenManager$fetchToken$1.label & Integer.MIN_VALUE) != 0) {
                    stsTokenManager$fetchToken$1.label -= Integer.MIN_VALUE;
                    Object obj = stsTokenManager$fetchToken$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = stsTokenManager$fetchToken$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Function2<String, Continuation<? super StsTokenResponse>, Object> function2 = this.getStsTokenApi;
                        stsTokenManager$fetchToken$1.L$0 = this;
                        stsTokenManager$fetchToken$1.label = 1;
                        obj = function2.invoke(str, stsTokenManager$fetchToken$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        stsTokenManager = this;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        stsTokenManager = (StsTokenManager) stsTokenManager$fetchToken$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    StsTokenResponse stsTokenResponse = (StsTokenResponse) obj;
                    String formatIsoUtc = stsTokenManager.formatIsoUtc(System.currentTimeMillis());
                    String accessKeyId = stsTokenResponse.getAccessKeyId();
                    String secretAccessKey = stsTokenResponse.getSecretAccessKey();
                    String sessionToken = stsTokenResponse.getSessionToken();
                    String expiredTime = stsTokenResponse.getExpiredTime();
                    String currentTime = stsTokenResponse.getCurrentTime();
                    String str2 = currentTime != null ? formatIsoUtc : currentTime;
                    serviceId = stsTokenResponse.getServiceId();
                    if (serviceId == null && (serviceId = (String) stsTokenManager.fallbackServiceIdProvider.invoke()) == null) {
                        serviceId = "";
                    }
                    stsTokenData = new StsTokenData(accessKeyId, secretAccessKey, sessionToken, expiredTime, str2, serviceId);
                    stsTokenManager.updateServerTimeDiff(stsTokenData.getCurrentTimeIso());
                    if (StringsKt.isBlank(stsTokenData.getServiceId())) {
                        return stsTokenData;
                    }
                    throw new ImageUploadException(ImageUploadErrorCode.TOKEN_FETCH_FAILED, "Token response missing service_id", null, 4, null);
                }
            }
            if (i != 0) {
            }
            StsTokenResponse stsTokenResponse2 = (StsTokenResponse) obj;
            String formatIsoUtc2 = stsTokenManager.formatIsoUtc(System.currentTimeMillis());
            String accessKeyId2 = stsTokenResponse2.getAccessKeyId();
            String secretAccessKey2 = stsTokenResponse2.getSecretAccessKey();
            String sessionToken2 = stsTokenResponse2.getSessionToken();
            String expiredTime2 = stsTokenResponse2.getExpiredTime();
            String currentTime2 = stsTokenResponse2.getCurrentTime();
            if (currentTime2 != null) {
            }
            serviceId = stsTokenResponse2.getServiceId();
            if (serviceId == null) {
                serviceId = "";
            }
            stsTokenData = new StsTokenData(accessKeyId2, secretAccessKey2, sessionToken2, expiredTime2, str2, serviceId);
            stsTokenManager.updateServerTimeDiff(stsTokenData.getCurrentTimeIso());
            if (StringsKt.isBlank(stsTokenData.getServiceId())) {
            }
        } catch (Throwable th) {
            throw new ImageUploadException(ImageUploadErrorCode.TOKEN_FETCH_FAILED, "Token fetch failed: " + th.getMessage(), th);
        }
        stsTokenManager$fetchToken$1 = new StsTokenManager$fetchToken$1(this, continuation);
        Object obj2 = stsTokenManager$fetchToken$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = stsTokenManager$fetchToken$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009d A[Catch: all -> 0x00e2, TRY_LEAVE, TryCatch #1 {all -> 0x00e2, blocks: (B:26:0x0093, B:28:0x009d, B:32:0x00b1), top: B:25:0x0093 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b1 A[Catch: all -> 0x00e2, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00e2, blocks: (B:26:0x0093, B:28:0x009d, B:32:0x00b1), top: B:25:0x0093 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshTokenSync(String str, Continuation<? super StsTokenData> continuation) {
        StsTokenManager$refreshTokenSync$1 stsTokenManager$refreshTokenSync$1;
        int i;
        StsTokenManager$refreshTokenSync$1 stsTokenManager$refreshTokenSync$12;
        StsTokenManager stsTokenManager;
        Deferred<StsTokenData> deferred;
        StsTokenManager$refreshTokenSync$1 stsTokenManager$refreshTokenSync$13;
        StsTokenData stsTokenData;
        String str2 = str;
        try {
            if (continuation instanceof StsTokenManager$refreshTokenSync$1) {
                stsTokenManager$refreshTokenSync$1 = (StsTokenManager$refreshTokenSync$1) continuation;
                if ((stsTokenManager$refreshTokenSync$1.label & Integer.MIN_VALUE) != 0) {
                    stsTokenManager$refreshTokenSync$1.label -= Integer.MIN_VALUE;
                    Object obj = stsTokenManager$refreshTokenSync$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = stsTokenManager$refreshTokenSync$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Deferred<StsTokenData> deferred2 = this.refreshPromises.get(str2);
                        if (deferred2 != null) {
                            stsTokenManager$refreshTokenSync$1.label = 1;
                            obj = deferred2.await(stsTokenManager$refreshTokenSync$1);
                            return obj == coroutine_suspended ? coroutine_suspended : obj;
                        }
                        stsTokenManager$refreshTokenSync$12 = this.mutex;
                        stsTokenManager$refreshTokenSync$1.L$0 = this;
                        stsTokenManager$refreshTokenSync$1.L$1 = str2;
                        stsTokenManager$refreshTokenSync$1.L$2 = stsTokenManager$refreshTokenSync$12;
                        stsTokenManager$refreshTokenSync$1.label = 2;
                        if (stsTokenManager$refreshTokenSync$12.lock((Object) null, stsTokenManager$refreshTokenSync$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        stsTokenManager = this;
                        deferred = stsTokenManager.refreshPromises.get(str2);
                        if (deferred == null) {
                        }
                    } else {
                        if (i == 1) {
                            ResultKt.throwOnFailure(obj);
                        }
                        if (i == 2) {
                            StsTokenManager$refreshTokenSync$1 stsTokenManager$refreshTokenSync$14 = (Mutex) stsTokenManager$refreshTokenSync$1.L$2;
                            String str3 = (String) stsTokenManager$refreshTokenSync$1.L$1;
                            stsTokenManager = (StsTokenManager) stsTokenManager$refreshTokenSync$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            stsTokenManager$refreshTokenSync$12 = stsTokenManager$refreshTokenSync$14;
                            str2 = str3;
                            try {
                                deferred = stsTokenManager.refreshPromises.get(str2);
                                if (deferred == null) {
                                    stsTokenManager$refreshTokenSync$1.L$0 = stsTokenManager$refreshTokenSync$12;
                                    stsTokenManager$refreshTokenSync$1.L$1 = null;
                                    stsTokenManager$refreshTokenSync$1.L$2 = null;
                                    stsTokenManager$refreshTokenSync$1.label = 3;
                                    Object await = deferred.await(stsTokenManager$refreshTokenSync$1);
                                    if (await == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    stsTokenManager$refreshTokenSync$13 = stsTokenManager$refreshTokenSync$12;
                                    obj = await;
                                    stsTokenData = (StsTokenData) obj;
                                } else {
                                    Deferred<StsTokenData> async$default = BuildersKt.async$default(stsTokenManager.scope, (CoroutineContext) null, (CoroutineStart) null, new StsTokenManager$refreshTokenSync$2$deferred$1(stsTokenManager, str2, null), 3, (Object) null);
                                    stsTokenManager.refreshPromises.put(str2, async$default);
                                    stsTokenManager$refreshTokenSync$1.L$0 = stsTokenManager$refreshTokenSync$12;
                                    stsTokenManager$refreshTokenSync$1.L$1 = null;
                                    stsTokenManager$refreshTokenSync$1.L$2 = null;
                                    stsTokenManager$refreshTokenSync$1.label = 4;
                                    Object await2 = async$default.await(stsTokenManager$refreshTokenSync$1);
                                    if (await2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    stsTokenManager$refreshTokenSync$13 = stsTokenManager$refreshTokenSync$12;
                                    obj = await2;
                                    stsTokenData = (StsTokenData) obj;
                                }
                            } catch (Throwable th) {
                                th = th;
                                stsTokenManager$refreshTokenSync$1 = stsTokenManager$refreshTokenSync$12;
                                stsTokenManager$refreshTokenSync$1.unlock((Object) null);
                                throw th;
                            }
                        } else if (i == 3) {
                            stsTokenManager$refreshTokenSync$13 = (Mutex) stsTokenManager$refreshTokenSync$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            stsTokenData = (StsTokenData) obj;
                        } else {
                            if (i != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            stsTokenManager$refreshTokenSync$13 = (Mutex) stsTokenManager$refreshTokenSync$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            stsTokenData = (StsTokenData) obj;
                        }
                    }
                    stsTokenManager$refreshTokenSync$13.unlock((Object) null);
                    return stsTokenData;
                }
            }
            if (i != 0) {
            }
            stsTokenManager$refreshTokenSync$13.unlock((Object) null);
            return stsTokenData;
        } catch (Throwable th2) {
            th = th2;
        }
        stsTokenManager$refreshTokenSync$1 = new StsTokenManager$refreshTokenSync$1(this, continuation);
        Object obj2 = stsTokenManager$refreshTokenSync$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = stsTokenManager$refreshTokenSync$1.label;
    }

    private final void refreshTokenAsync(String userId) {
        if (this.refreshPromises.containsKey(userId)) {
            return;
        }
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new StsTokenManager$refreshTokenAsync$1(this, userId, null), 3, (Object) null);
    }

    public final Object getToken(String str, Continuation<? super StsTokenData> continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[checkTokenStatus(str).ordinal()];
        if (i == 1) {
            return refreshTokenSync(str, continuation);
        }
        if (i == 2) {
            refreshTokenAsync(str);
            StsTokenData stsTokenData = this.tokenCache.get(str);
            return stsTokenData == null ? refreshTokenSync(str, continuation) : stsTokenData;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        StsTokenData stsTokenData2 = this.tokenCache.get(str);
        Intrinsics.checkNotNull(stsTokenData2);
        return stsTokenData2;
    }

    public static /* synthetic */ void clearToken$default(StsTokenManager stsTokenManager, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        stsTokenManager.clearToken(str);
    }

    public final void clearToken(String userId) {
        if (userId != null) {
            this.tokenCache.remove(userId);
            this.refreshPromises.remove(userId);
        } else {
            this.tokenCache.clear();
            this.refreshPromises.clear();
        }
    }
}
