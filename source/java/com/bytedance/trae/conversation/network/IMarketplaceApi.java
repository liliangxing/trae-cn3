package com.bytedance.trae.conversation.network;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.TraeHttpConnection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: IMarketplaceApi.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ$\u0010\u0002\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H§@¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/network/IMarketplaceApi;", "", "listPlugins", "Lcom/bytedance/trae/conversation/network/MarketplaceResponse;", "query", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IMarketplaceApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @GET("extensions/api/-/plugin/list")
    Object listPlugins(@QueryMap Map<String, String> map, Continuation<? super MarketplaceResponse> continuation);

    /* compiled from: IMarketplaceApi.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0086@¢\u0006\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion;", "", "<init>", "()V", "PAGE_SIZE", "", "fetchMarketplacePlugins", "", "", "Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final int PAGE_SIZE = 200;

        private Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:52:0x00e3, code lost:
        
            if (r4.add(r15) == false) goto L41;
         */
        /* JADX WARN: Removed duplicated region for block: B:14:0x00a9 A[Catch: all -> 0x014f, CancellationException -> 0x0154, TryCatch #2 {CancellationException -> 0x0154, all -> 0x014f, blocks: (B:11:0x0036, B:12:0x00a1, B:14:0x00a9, B:17:0x00ae, B:20:0x00e5, B:21:0x00f2, B:23:0x00f8, B:25:0x0107, B:29:0x0111, B:32:0x0114, B:38:0x0118, B:39:0x0137, B:41:0x013d, B:44:0x00b5, B:46:0x00c8, B:49:0x00d4, B:51:0x00da, B:53:0x0076, B:55:0x0087, B:56:0x008c, B:63:0x0045), top: B:7:0x0022 }] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00ae A[Catch: all -> 0x014f, CancellationException -> 0x0154, TryCatch #2 {CancellationException -> 0x0154, all -> 0x014f, blocks: (B:11:0x0036, B:12:0x00a1, B:14:0x00a9, B:17:0x00ae, B:20:0x00e5, B:21:0x00f2, B:23:0x00f8, B:25:0x0107, B:29:0x0111, B:32:0x0114, B:38:0x0118, B:39:0x0137, B:41:0x013d, B:44:0x00b5, B:46:0x00c8, B:49:0x00d4, B:51:0x00da, B:53:0x0076, B:55:0x0087, B:56:0x008c, B:63:0x0045), top: B:7:0x0022 }] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0114 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00f2 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x009e -> B:12:0x00a1). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object fetchMarketplacePlugins(Continuation<? super Map<String, MarketplacePluginItem>> continuation) {
            IMarketplaceApi$Companion$fetchMarketplacePlugins$1 iMarketplaceApi$Companion$fetchMarketplacePlugins$1;
            int i;
            LinkedHashSet linkedHashSet;
            IMarketplaceApi iMarketplaceApi;
            List list;
            Ref.ObjectRef objectRef;
            MarketplaceResponse marketplaceResponse;
            boolean z;
            try {
                if (continuation instanceof IMarketplaceApi$Companion$fetchMarketplacePlugins$1) {
                    iMarketplaceApi$Companion$fetchMarketplacePlugins$1 = (IMarketplaceApi$Companion$fetchMarketplacePlugins$1) continuation;
                    if ((iMarketplaceApi$Companion$fetchMarketplacePlugins$1.label & Integer.MIN_VALUE) != 0) {
                        iMarketplaceApi$Companion$fetchMarketplacePlugins$1.label -= Integer.MIN_VALUE;
                        Object obj = iMarketplaceApi$Companion$fetchMarketplacePlugins$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = iMarketplaceApi$Companion$fetchMarketplacePlugins$1.label;
                        if (i == 0) {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            objectRef = (Ref.ObjectRef) iMarketplaceApi$Companion$fetchMarketplacePlugins$1.L$3;
                            linkedHashSet = (Set) iMarketplaceApi$Companion$fetchMarketplacePlugins$1.L$2;
                            list = (List) iMarketplaceApi$Companion$fetchMarketplacePlugins$1.L$1;
                            iMarketplaceApi = (IMarketplaceApi) iMarketplaceApi$Companion$fetchMarketplacePlugins$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            marketplaceResponse = (MarketplaceResponse) obj;
                            if (!marketplaceResponse.isSuccess()) {
                                return MapsKt.emptyMap();
                            }
                            MarketplacePluginsData data = marketplaceResponse.getData();
                            if (data != null) {
                                CollectionsKt.addAll(list, data.getAllPlugins());
                                String nextPageToken = data.getNextPageToken();
                                if (nextPageToken == null || !(!StringsKt.isBlank(nextPageToken))) {
                                    nextPageToken = null;
                                }
                                objectRef.element = nextPageToken;
                                if (objectRef.element != null) {
                                    Object obj2 = objectRef.element;
                                    Intrinsics.checkNotNull(obj2);
                                }
                            }
                            ArrayList arrayList = new ArrayList();
                            for (Object obj3 : list) {
                                String name = ((MarketplacePluginItem) obj3).getName();
                                if (name != null && !StringsKt.isBlank(name)) {
                                    z = false;
                                    if (!(!z)) {
                                        arrayList.add(obj3);
                                    }
                                }
                                z = true;
                                if (!(!z)) {
                                }
                            }
                            ArrayList arrayList2 = arrayList;
                            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
                            for (Object obj4 : arrayList2) {
                                String name2 = ((MarketplacePluginItem) obj4).getName();
                                Intrinsics.checkNotNull(name2);
                                linkedHashMap.put(name2, obj4);
                            }
                            return linkedHashMap;
                        }
                        ResultKt.throwOnFailure(obj);
                        IMarketplaceApi iMarketplaceApi2 = (IMarketplaceApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "marketplace", IMarketplaceApi.class, (Converter.Factory) null, HostResolver.INSTANCE.getBaseUrl(HostType.MARKETPLACE), (Map) null, false, 52, (Object) null);
                        ArrayList arrayList3 = new ArrayList();
                        linkedHashSet = new LinkedHashSet();
                        iMarketplaceApi = iMarketplaceApi2;
                        list = arrayList3;
                        objectRef = new Ref.ObjectRef();
                        Map createMapBuilder = MapsKt.createMapBuilder();
                        createMapBuilder.put("page_size", "200");
                        String str = (String) objectRef.element;
                        if (str != null) {
                            createMapBuilder.put("page_token", str);
                        }
                        Map<String, String> build = MapsKt.build(createMapBuilder);
                        iMarketplaceApi$Companion$fetchMarketplacePlugins$1.L$0 = iMarketplaceApi;
                        iMarketplaceApi$Companion$fetchMarketplacePlugins$1.L$1 = list;
                        iMarketplaceApi$Companion$fetchMarketplacePlugins$1.L$2 = linkedHashSet;
                        iMarketplaceApi$Companion$fetchMarketplacePlugins$1.L$3 = objectRef;
                        iMarketplaceApi$Companion$fetchMarketplacePlugins$1.label = 1;
                        obj = iMarketplaceApi.listPlugins(build, iMarketplaceApi$Companion$fetchMarketplacePlugins$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        marketplaceResponse = (MarketplaceResponse) obj;
                        if (!marketplaceResponse.isSuccess()) {
                        }
                    }
                }
                if (i == 0) {
                }
            } catch (CancellationException unused) {
                throw new CancellationException();
            } catch (Throwable unused2) {
                return MapsKt.emptyMap();
            }
            iMarketplaceApi$Companion$fetchMarketplacePlugins$1 = new IMarketplaceApi$Companion$fetchMarketplacePlugins$1(this, continuation);
            Object obj5 = iMarketplaceApi$Companion$fetchMarketplacePlugins$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iMarketplaceApi$Companion$fetchMarketplacePlugins$1.label;
        }
    }
}
