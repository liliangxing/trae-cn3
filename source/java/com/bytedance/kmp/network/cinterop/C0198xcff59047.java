package com.bytedance.kmp.network.cinterop;

import com.bytedance.kmp.spi.KmpServiceManager;
import java.util.LinkedHashMap;
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
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

/* compiled from: IKmpNetworkCommonParamsProvider.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.cinterop.IKmpNetworkCommonParamsProviderKt$initKmpCinteropCommonParamsProvider$1$getCommonParams$1", f = "IKmpNetworkCommonParamsProvider.kt", i = {0, 0, 1, 2, 2}, l = {117, 81, 127, 93}, m = "invokeSuspend", n = {"provider", "$this$withLock_u24default$iv", "provider", "cacheResult", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$0", "L$1"})
/* renamed from: com.bytedance.kmp.network.cinterop.IKmpNetworkCommonParamsProviderKt$initKmpCinteropCommonParamsProvider$1$getCommonParams$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class C0198xcff59047 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends String>>, Object> {
    final /* synthetic */ String $url;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0198xcff59047(String str, Continuation<? super C0198xcff59047> continuation) {
        super(2, continuation);
        this.$url = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0198xcff59047(this.$url, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<String, String>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c8 A[Catch: all -> 0x011c, TryCatch #1 {all -> 0x011c, blocks: (B:15:0x00a6, B:17:0x00b5, B:19:0x00bb, B:21:0x00c8, B:22:0x00cc, B:23:0x00e9, B:25:0x00ef, B:27:0x010d, B:28:0x0110), top: B:14:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ef A[Catch: all -> 0x011c, LOOP:0: B:23:0x00e9->B:25:0x00ef, LOOP_END, TryCatch #1 {all -> 0x011c, blocks: (B:15:0x00a6, B:17:0x00b5, B:19:0x00bb, B:21:0x00c8, B:22:0x00cc, B:23:0x00e9, B:25:0x00ef, B:27:0x010d, B:28:0x0110), top: B:14:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        IKmpNetworkCommonParamsProvider iKmpNetworkCommonParamsProvider;
        Mutex mutex;
        int i;
        IKmpNetworkCommonParamsProvider iKmpNetworkCommonParamsProvider2;
        KmpCommonParamsResult kmpCommonParamsResult;
        Mutex mutex2;
        Mutex mutex3;
        KmpCommonParamsResult kmpCommonParamsResult2;
        Map map;
        List<StringPair> newQueries;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                iKmpNetworkCommonParamsProvider = (IKmpNetworkCommonParamsProvider) KmpServiceManager.INSTANCE.get(Reflection.getOrCreateKotlinClass(IKmpNetworkCommonParamsProvider.class));
                if (iKmpNetworkCommonParamsProvider == null) {
                    return MapsKt.emptyMap();
                }
                mutex = IKmpNetworkCommonParamsProviderKt.commonParamsCacheMutex;
                this.L$0 = iKmpNetworkCommonParamsProvider;
                this.L$1 = mutex;
                this.label = 1;
                if (mutex.lock((Object) null, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return MapsKt.toMap((Map) obj);
                        }
                        mutex3 = (Mutex) this.L$1;
                        kmpCommonParamsResult2 = (KmpCommonParamsResult) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        try {
                            if (Intrinsics.areEqual(kmpCommonParamsResult2.getUseCache(), Boxing.boxBoolean(false)) && kmpCommonParamsResult2.getNewQueries() != null) {
                                IKmpNetworkCommonParamsProviderKt.cacheVersion = kmpCommonParamsResult2.getCacheVersion();
                                newQueries = kmpCommonParamsResult2.getNewQueries();
                                if (newQueries == null) {
                                    newQueries = CollectionsKt.emptyList();
                                }
                                List<StringPair> list = newQueries;
                                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
                                for (StringPair stringPair : list) {
                                    Pair pair = TuplesKt.to(stringPair.getFirst(), stringPair.getSecond());
                                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                                }
                                IKmpNetworkCommonParamsProviderKt.cacheQueries = linkedHashMap;
                            }
                            map = IKmpNetworkCommonParamsProviderKt.cacheQueries;
                            return MapsKt.toMap(map);
                        } finally {
                        }
                    }
                    iKmpNetworkCommonParamsProvider2 = (IKmpNetworkCommonParamsProvider) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    kmpCommonParamsResult = (KmpCommonParamsResult) obj;
                    if (kmpCommonParamsResult == null) {
                        mutex2 = IKmpNetworkCommonParamsProviderKt.commonParamsCacheMutex;
                        this.L$0 = kmpCommonParamsResult;
                        this.L$1 = mutex2;
                        this.label = 3;
                        if (mutex2.lock((Object) null, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        mutex3 = mutex2;
                        kmpCommonParamsResult2 = kmpCommonParamsResult;
                        if (Intrinsics.areEqual(kmpCommonParamsResult2.getUseCache(), Boxing.boxBoolean(false))) {
                            IKmpNetworkCommonParamsProviderKt.cacheVersion = kmpCommonParamsResult2.getCacheVersion();
                            newQueries = kmpCommonParamsResult2.getNewQueries();
                            if (newQueries == null) {
                            }
                            List<StringPair> list2 = newQueries;
                            LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
                            while (r10.hasNext()) {
                            }
                            IKmpNetworkCommonParamsProviderKt.cacheQueries = linkedHashMap2;
                        }
                        map = IKmpNetworkCommonParamsProviderKt.cacheQueries;
                        return MapsKt.toMap(map);
                    }
                    this.L$0 = null;
                    this.label = 4;
                    obj = iKmpNetworkCommonParamsProvider2.getCommonParams(this.$url, (Continuation) this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return MapsKt.toMap((Map) obj);
                }
                mutex = (Mutex) this.L$1;
                IKmpNetworkCommonParamsProvider iKmpNetworkCommonParamsProvider3 = (IKmpNetworkCommonParamsProvider) this.L$0;
                ResultKt.throwOnFailure(obj);
                iKmpNetworkCommonParamsProvider = iKmpNetworkCommonParamsProvider3;
            }
            i = IKmpNetworkCommonParamsProviderKt.cacheVersion;
            mutex.unlock((Object) null);
            this.L$0 = iKmpNetworkCommonParamsProvider;
            this.L$1 = null;
            this.label = 2;
            Object commonParamsWithCacheVersion = iKmpNetworkCommonParamsProvider.getCommonParamsWithCacheVersion(this.$url, i, (Continuation) this);
            if (commonParamsWithCacheVersion == coroutine_suspended) {
                return coroutine_suspended;
            }
            iKmpNetworkCommonParamsProvider2 = iKmpNetworkCommonParamsProvider;
            obj = commonParamsWithCacheVersion;
            kmpCommonParamsResult = (KmpCommonParamsResult) obj;
            if (kmpCommonParamsResult == null) {
            }
        } finally {
        }
    }
}
