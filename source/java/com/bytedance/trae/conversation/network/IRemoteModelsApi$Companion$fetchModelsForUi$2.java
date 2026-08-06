package com.bytedance.trae.conversation.network;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.trae.conversation.network.IRemoteModelsApi;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
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
@DebugMetadata(c = "com.bytedance.trae.conversation.network.IRemoteModelsApi$Companion$fetchModelsForUi$2", f = "IRemoteModelsApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IRemoteModelsApi$Companion$fetchModelsForUi$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends RemoteModelItem>>, Object> {
    final /* synthetic */ List<String> $functions;
    final /* synthetic */ String $trigger;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IRemoteModelsApi$Companion$fetchModelsForUi$2(String str, List<String> list, Continuation<? super IRemoteModelsApi$Companion$fetchModelsForUi$2> continuation) {
        super(2, continuation);
        this.$trigger = str;
        this.$functions = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IRemoteModelsApi$Companion$fetchModelsForUi$2(this.$trigger, this.$functions, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<RemoteModelItem>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        UserScopedModelListMemoryCache userScopedModelListMemoryCache;
        String currentModelListUserId;
        String readBody;
        String remoteCacheKey;
        List cachedModelsOrAuto;
        Integer parseBizCode;
        List parseModels;
        List normalizeModels;
        boolean putModelsCache;
        List cachedModelsOrAuto2;
        boolean isSuccessBizCode;
        List cachedModelsOrAuto3;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            userScopedModelListMemoryCache = IRemoteModelsApi.Companion.modelListMemoryCache;
            currentModelListUserId = IRemoteModelsApi.Companion.$$INSTANCE.currentModelListUserId();
            UserScopedModelListMemoryCache.Owner captureOwner = userScopedModelListMemoryCache.captureOwner(currentModelListUserId);
            TraeLogUtil.INSTANCE.i("IRemoteModelsApi", "fetchModelsForUi: start, trigger=" + this.$trigger + ", functions=" + this.$functions);
            RequestContext requestContext = new RequestContext();
            requestContext.force_handle_response = true;
            SsResponse execute = ((IRemoteModelsApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "models", IRemoteModelsApi.class, (Converter.Factory) null, HostResolver.INSTANCE.getBaseUrl(HostType.REMOTE), (Map) null, false, 52, (Object) null)).getModels(this.$functions, requestContext).execute();
            readBody = IRemoteModelsApi.Companion.$$INSTANCE.readBody((String) execute.body(), execute.errorBody());
            TraeLogUtil.INSTANCE.i("IRemoteModelsApi", "fetchModelsForUi: httpCode=" + execute.code() + ", bodyLen=" + (readBody != null ? readBody.length() : -1));
            remoteCacheKey = IRemoteModelsApi.Companion.$$INSTANCE.remoteCacheKey(this.$functions);
            if (execute.code() == 200) {
                String str = readBody;
                if (!(str == null || StringsKt.isBlank(str))) {
                    parseBizCode = IRemoteModelsApi.Companion.$$INSTANCE.parseBizCode(readBody);
                    if (parseBizCode != null) {
                        isSuccessBizCode = IRemoteModelsApi.Companion.$$INSTANCE.isSuccessBizCode(parseBizCode.intValue());
                        if (!(!isSuccessBizCode)) {
                            parseBizCode = null;
                        }
                        if (parseBizCode != null) {
                            int intValue = parseBizCode.intValue();
                            TraeLogUtil.INSTANCE.w("IRemoteModelsApi", "fetchModelsForUi: bizCode=" + intValue + ", body=" + StringsKt.take(readBody, 800));
                            cachedModelsOrAuto3 = IRemoteModelsApi.Companion.$$INSTANCE.getCachedModelsOrAuto(remoteCacheKey, "fetchModelsForUi_biz_" + intValue);
                            return cachedModelsOrAuto3;
                        }
                    }
                    IRemoteModelsApi.Companion companion = IRemoteModelsApi.Companion.$$INSTANCE;
                    parseModels = IRemoteModelsApi.Companion.$$INSTANCE.parseModels(readBody);
                    normalizeModels = companion.normalizeModels(parseModels);
                    putModelsCache = IRemoteModelsApi.Companion.$$INSTANCE.putModelsCache(captureOwner, remoteCacheKey, normalizeModels);
                    if (!putModelsCache) {
                        cachedModelsOrAuto2 = IRemoteModelsApi.Companion.$$INSTANCE.getCachedModelsOrAuto(remoteCacheKey, "fetchModelsForUi_account_changed");
                        return cachedModelsOrAuto2;
                    }
                    TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
                    StringBuilder append = new StringBuilder("fetchModelsForUi: parsedCount=").append(normalizeModels.size()).append(", names=");
                    List take = CollectionsKt.take(normalizeModels, 6);
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(take, 10));
                    Iterator it = take.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((RemoteModelItem) it.next()).getName());
                    }
                    traeLogUtil.i("IRemoteModelsApi", append.append(arrayList).toString());
                    if (normalizeModels.size() <= 1) {
                        TraeLogUtil.INSTANCE.w("IRemoteModelsApi", "fetchModelsForUi: only auto model parsed, body=" + StringsKt.take(readBody, 800));
                    }
                    return normalizeModels;
                }
            }
            TraeLogUtil.INSTANCE.w("IRemoteModelsApi", "fetchModelsForUi: httpCode=" + execute.code() + ", body=" + readBody);
            cachedModelsOrAuto = IRemoteModelsApi.Companion.$$INSTANCE.getCachedModelsOrAuto(remoteCacheKey, "fetchModelsForUi_http_" + execute.code());
            return cachedModelsOrAuto;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
