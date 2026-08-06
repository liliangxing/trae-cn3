package com.bytedance.trae.conversation.network;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.trae.conversation.network.IRemoteModelsApi;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.bytedance.ttnet.http.RequestContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IRemoteModelsApi.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lcom/bytedance/trae/conversation/network/RemoteModelItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.network.IRemoteModelsApi$Companion$fetchPcModelsForUi$2", f = "IRemoteModelsApi.kt", i = {0, 1, 1}, l = {132, 143}, m = "invokeSuspend", n = {"requestOwner", "requestOwner", "resolvedCliId"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IRemoteModelsApi$Companion$fetchPcModelsForUi$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends RemoteModelItem>>, Object> {
    final /* synthetic */ String $cliId;
    final /* synthetic */ CliType $cliType;
    final /* synthetic */ boolean $forceRefresh;
    final /* synthetic */ List<String> $functions;
    final /* synthetic */ String $ideVersion;
    final /* synthetic */ String $trigger;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IRemoteModelsApi$Companion$fetchPcModelsForUi$2(String str, CliType cliType, String str2, List<String> list, boolean z, String str3, Continuation<? super IRemoteModelsApi$Companion$fetchPcModelsForUi$2> continuation) {
        super(2, continuation);
        this.$trigger = str;
        this.$cliType = cliType;
        this.$cliId = str2;
        this.$functions = list;
        this.$forceRefresh = z;
        this.$ideVersion = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IRemoteModelsApi$Companion$fetchPcModelsForUi$2(this.$trigger, this.$cliType, this.$cliId, this.$functions, this.$forceRefresh, this.$ideVersion, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<RemoteModelItem>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00f1, code lost:
    
        if (r12 == null) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        UserScopedModelListMemoryCache userScopedModelListMemoryCache;
        String currentModelListUserId;
        UserScopedModelListMemoryCache.Owner captureOwner;
        Object resolvePcCliInfo;
        String id;
        String str;
        Object findCliIdeVersion;
        String str2;
        String minSupportedIdeVersion;
        String readBody;
        String pcCacheKey;
        List cachedModelsOrAuto;
        Integer parseBizCode;
        List parseModels;
        List normalizeModels;
        boolean putModelsCache;
        List cachedModelsOrAuto2;
        boolean isSuccessBizCode;
        boolean isExpectedPcModelListBizCode;
        List cachedModelsOrAuto3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            userScopedModelListMemoryCache = IRemoteModelsApi.Companion.modelListMemoryCache;
            currentModelListUserId = IRemoteModelsApi.Companion.$$INSTANCE.currentModelListUserId();
            captureOwner = userScopedModelListMemoryCache.captureOwner(currentModelListUserId);
            TraeLogUtil.INSTANCE.i("IRemoteModelsApi", "fetchPcModelsForUi: start, trigger=" + this.$trigger + ", cliType=" + this.$cliType + ", cliId=" + this.$cliId + ", functions=" + this.$functions + ", forceRefresh=" + this.$forceRefresh + ", ideVersion=" + this.$ideVersion);
            this.L$0 = captureOwner;
            this.label = 1;
            resolvePcCliInfo = IRemoteModelsApi.Companion.$$INSTANCE.resolvePcCliInfo(this.$cliId, (Continuation) this);
            if (resolvePcCliInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str2 = (String) this.L$1;
                captureOwner = (UserScopedModelListMemoryCache.Owner) this.L$0;
                ResultKt.throwOnFailure(obj);
                findCliIdeVersion = obj;
                str = (String) findCliIdeVersion;
                id = str2;
                minSupportedIdeVersion = IRemoteModelsApi.Companion.$$INSTANCE.minSupportedIdeVersion();
                TraeLogUtil.INSTANCE.i("IRemoteModelsApi", "fetchPcModelsForUi: minIdeVersion=" + minSupportedIdeVersion + ", cliType=" + this.$cliType + ", cliId=" + id + ", ideVersion=" + str + ", trigger=" + this.$trigger);
                if (!IdeVersionGate.INSTANCE.shouldBlockCliModelList(this.$cliType, str, minSupportedIdeVersion)) {
                    TraeLogUtil.INSTANCE.w("IRemoteModelsApi", "fetchPcModelsForUi: unsupported cliType=" + this.$cliType + ", ideVersion=" + str + ", cliId=" + id + ", minVersion=" + minSupportedIdeVersion + ", fallback auto");
                    return CollectionsKt.listOf(RemoteModelItem.INSTANCE.auto());
                }
                RequestContext requestContext = new RequestContext();
                requestContext.force_handle_response = true;
                SsResponse execute = ((IRemoteModelsApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "models", IRemoteModelsApi.class, (Converter.Factory) null, HostResolver.INSTANCE.getBaseUrl(HostType.AI), (Map) null, false, 52, (Object) null)).getPcModels(id, this.$functions, this.$forceRefresh, requestContext).execute();
                readBody = IRemoteModelsApi.Companion.$$INSTANCE.readBody((String) execute.body(), execute.errorBody());
                TraeLogUtil.INSTANCE.i("IRemoteModelsApi", "fetchPcModelsForUi: httpCode=" + execute.code() + ", bodyLen=" + (readBody != null ? readBody.length() : -1));
                pcCacheKey = IRemoteModelsApi.Companion.$$INSTANCE.pcCacheKey(id, this.$functions);
                if (execute.code() == 200) {
                    String str3 = readBody;
                    if (!(str3 == null || StringsKt.isBlank(str3))) {
                        parseBizCode = IRemoteModelsApi.Companion.$$INSTANCE.parseBizCode(readBody);
                        if (parseBizCode != null) {
                            isSuccessBizCode = IRemoteModelsApi.Companion.$$INSTANCE.isSuccessBizCode(parseBizCode.intValue());
                            Integer num = isSuccessBizCode ^ true ? parseBizCode : null;
                            if (num != null) {
                                int intValue = num.intValue();
                                isExpectedPcModelListBizCode = IRemoteModelsApi.Companion.$$INSTANCE.isExpectedPcModelListBizCode(intValue);
                                if (isExpectedPcModelListBizCode) {
                                    TraeLogUtil.INSTANCE.w("IRemoteModelsApi", "fetchPcModelsForUi: expected pc model list bizCode=" + intValue + ", cliId=" + id + ", ideVersion=" + str + ", body=" + StringsKt.take(readBody, 800));
                                } else {
                                    TraeLogUtil.INSTANCE.w("IRemoteModelsApi", "fetchPcModelsForUi: bizCode=" + intValue + ", cliId=" + id + ", body=" + StringsKt.take(readBody, 800));
                                }
                                cachedModelsOrAuto3 = IRemoteModelsApi.Companion.$$INSTANCE.getCachedModelsOrAuto(pcCacheKey, "fetchPcModelsForUi_biz_" + intValue);
                                return cachedModelsOrAuto3;
                            }
                        }
                        IRemoteModelsApi.Companion companion = IRemoteModelsApi.Companion.$$INSTANCE;
                        parseModels = IRemoteModelsApi.Companion.$$INSTANCE.parseModels(readBody);
                        normalizeModels = companion.normalizeModels(parseModels);
                        putModelsCache = IRemoteModelsApi.Companion.$$INSTANCE.putModelsCache(captureOwner, pcCacheKey, normalizeModels);
                        if (!putModelsCache) {
                            cachedModelsOrAuto2 = IRemoteModelsApi.Companion.$$INSTANCE.getCachedModelsOrAuto(pcCacheKey, "fetchPcModelsForUi_account_changed");
                            return cachedModelsOrAuto2;
                        }
                        TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
                        StringBuilder append = new StringBuilder("fetchPcModelsForUi: parsedCount=").append(normalizeModels.size()).append(", names=");
                        List take = CollectionsKt.take(normalizeModels, 6);
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(take, 10));
                        Iterator it = take.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((RemoteModelItem) it.next()).getName());
                        }
                        traeLogUtil.i("IRemoteModelsApi", append.append(arrayList).toString());
                        if (normalizeModels.size() <= 1) {
                            TraeLogUtil.INSTANCE.w("IRemoteModelsApi", "fetchPcModelsForUi: only auto model parsed, body=" + StringsKt.take(readBody, 800));
                        }
                        return normalizeModels;
                    }
                }
                TraeLogUtil.INSTANCE.w("IRemoteModelsApi", "fetchPcModelsForUi: httpCode=" + execute.code() + ", body=" + readBody);
                cachedModelsOrAuto = IRemoteModelsApi.Companion.$$INSTANCE.getCachedModelsOrAuto(pcCacheKey, "fetchPcModelsForUi_http_" + execute.code());
                return cachedModelsOrAuto;
            }
            captureOwner = (UserScopedModelListMemoryCache.Owner) this.L$0;
            ResultKt.throwOnFailure(obj);
            resolvePcCliInfo = obj;
        }
        IRemoteModelsApi.Companion.PcCliInfo pcCliInfo = (IRemoteModelsApi.Companion.PcCliInfo) resolvePcCliInfo;
        if (pcCliInfo == null) {
            TraeLogUtil.INSTANCE.w("IRemoteModelsApi", "fetchPcModelsForUi: empty cliId and no single online local cli, fallback auto");
            return CollectionsKt.listOf(RemoteModelItem.INSTANCE.auto());
        }
        id = pcCliInfo.getId();
        if (StringsKt.isBlank(this.$cliId)) {
            TraeLogUtil.INSTANCE.i("IRemoteModelsApi", "fetchPcModelsForUi: resolved empty cliId to online local cli, cliId=" + id);
        }
        str = this.$ideVersion;
        if (str != null) {
            if (!(!StringsKt.isBlank(str))) {
                str = null;
            }
        }
        String ideVersion = pcCliInfo.getIdeVersion();
        if (ideVersion != null) {
            if (!(!StringsKt.isBlank(ideVersion))) {
                ideVersion = null;
            }
            str = ideVersion;
        } else {
            str = null;
        }
        if (str == null) {
            this.L$0 = captureOwner;
            this.L$1 = id;
            this.label = 2;
            findCliIdeVersion = IRemoteModelsApi.Companion.$$INSTANCE.findCliIdeVersion(id, (Continuation) this);
            if (findCliIdeVersion == coroutine_suspended) {
                return coroutine_suspended;
            }
            str2 = id;
            str = (String) findCliIdeVersion;
            id = str2;
        }
        minSupportedIdeVersion = IRemoteModelsApi.Companion.$$INSTANCE.minSupportedIdeVersion();
        TraeLogUtil.INSTANCE.i("IRemoteModelsApi", "fetchPcModelsForUi: minIdeVersion=" + minSupportedIdeVersion + ", cliType=" + this.$cliType + ", cliId=" + id + ", ideVersion=" + str + ", trigger=" + this.$trigger);
        if (!IdeVersionGate.INSTANCE.shouldBlockCliModelList(this.$cliType, str, minSupportedIdeVersion)) {
        }
    }
}
