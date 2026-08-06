package coil3.intercept;

import coil3.ComponentRegistry;
import coil3.EventListener;
import coil3.ExtrasKt;
import coil3.Image;
import coil3.ImageLoader;
import coil3.decode.DataSource;
import coil3.decode.DecodeResult;
import coil3.decode.Decoder;
import coil3.decode.FileImageSource;
import coil3.decode.ImageSource;
import coil3.fetch.FetchResult;
import coil3.fetch.Fetcher;
import coil3.fetch.ImageFetchResult;
import coil3.fetch.SourceFetchResult;
import coil3.intercept.Interceptor;
import coil3.memory.MemoryCache;
import coil3.memory.MemoryCacheService;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import coil3.request.Options;
import coil3.request.RequestService;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeResolver;
import coil3.util.Logger;
import coil3.util.SystemCallbacks;
import coil3.util.Utils_commonKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;

/* compiled from: EngineInterceptor.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 (2\u00020\u0001:\u0002'(B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J.\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010\u001dJ6\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010\"J>\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcoil3/intercept/EngineInterceptor;", "Lcoil3/intercept/Interceptor;", "imageLoader", "Lcoil3/ImageLoader;", "systemCallbacks", "Lcoil3/util/SystemCallbacks;", "requestService", "Lcoil3/request/RequestService;", "logger", "Lcoil3/util/Logger;", "<init>", "(Lcoil3/ImageLoader;Lcoil3/util/SystemCallbacks;Lcoil3/request/RequestService;Lcoil3/util/Logger;)V", "memoryCacheService", "Lcoil3/memory/MemoryCacheService;", "intercept", "Lcoil3/request/ImageResult;", "chain", "Lcoil3/intercept/Interceptor$Chain;", "(Lcoil3/intercept/Interceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "Lcoil3/intercept/EngineInterceptor$ExecuteResult;", "request", "Lcoil3/request/ImageRequest;", "mappedData", "", "options", "Lcoil3/request/Options;", "eventListener", "Lcoil3/EventListener;", "(Lcoil3/request/ImageRequest;Ljava/lang/Object;Lcoil3/request/Options;Lcoil3/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetch", "Lcoil3/fetch/FetchResult;", "components", "Lcoil3/ComponentRegistry;", "(Lcoil3/ComponentRegistry;Lcoil3/request/ImageRequest;Ljava/lang/Object;Lcoil3/request/Options;Lcoil3/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decode", "fetchResult", "Lcoil3/fetch/SourceFetchResult;", "(Lcoil3/fetch/SourceFetchResult;Lcoil3/ComponentRegistry;Lcoil3/request/ImageRequest;Ljava/lang/Object;Lcoil3/request/Options;Lcoil3/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ExecuteResult", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class EngineInterceptor implements Interceptor {
    public static final String TAG = "EngineInterceptor";
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final MemoryCacheService memoryCacheService;
    private final RequestService requestService;
    private final SystemCallbacks systemCallbacks;

    public EngineInterceptor(ImageLoader imageLoader, SystemCallbacks systemCallbacks, RequestService requestService, Logger logger) {
        this.imageLoader = imageLoader;
        this.systemCallbacks = systemCallbacks;
        this.requestService = requestService;
        this.logger = logger;
        this.memoryCacheService = new MemoryCacheService(imageLoader, requestService, logger);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(10:5|6|7|(5:(1:(1:(1:(4:13|14|15|(2:17|18)(1:20))(2:21|22))(5:23|24|25|26|27))(6:28|29|30|31|32|(2:34|(1:36)(4:37|25|26|27))(1:38)))(4:49|50|51|52)|42|(2:45|(1:47)(2:48|14))|15|(0)(0))(6:72|73|74|(2:93|94)(1:76)|77|(3:92|58|(2:60|61)(4:62|(1:64)|32|(0)(0)))(4:82|83|84|(1:86)(1:87)))|53|54|(1:56)(2:65|66)|57|58|(0)(0)))|99|6|7|(0)(0)|53|54|(0)(0)|57|58|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x018e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x018f, code lost:
    
        r2 = r0;
        r7 = r9;
        r5 = r5;
        r8 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x005d, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01e5 A[Catch: all -> 0x005d, TryCatch #4 {all -> 0x005d, blocks: (B:24:0x0058, B:25:0x0204, B:32:0x01de, B:34:0x01e5, B:60:0x019a, B:62:0x01a4, B:84:0x014f), top: B:7:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x023a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x017a A[Catch: all -> 0x018e, TryCatch #5 {all -> 0x018e, blocks: (B:54:0x0176, B:56:0x017a, B:65:0x0181), top: B:53:0x0176 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x019a A[Catch: all -> 0x005d, TRY_ENTER, TryCatch #4 {all -> 0x005d, blocks: (B:24:0x0058, B:25:0x0204, B:32:0x01de, B:34:0x01e5, B:60:0x019a, B:62:0x01a4, B:84:0x014f), top: B:7:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01a4 A[Catch: all -> 0x005d, TryCatch #4 {all -> 0x005d, blocks: (B:24:0x0058, B:25:0x0204, B:32:0x01de, B:34:0x01e5, B:60:0x019a, B:62:0x01a4, B:84:0x014f), top: B:7:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0181 A[Catch: all -> 0x018e, TRY_LEAVE, TryCatch #5 {all -> 0x018e, blocks: (B:54:0x0176, B:56:0x017a, B:65:0x0181), top: B:53:0x0176 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v5, types: [kotlin.jvm.internal.Ref$BooleanRef, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v7, types: [coil3.memory.MemoryCache$Key, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v7 */
    @Override // coil3.intercept.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object intercept(Interceptor.Chain chain, Continuation<? super ImageResult> continuation) {
        EngineInterceptor$intercept$1 engineInterceptor$intercept$1;
        Object obj;
        ?? r5;
        Throwable th;
        Interceptor.Chain chain2;
        MemoryCache.Key key;
        Ref.BooleanRef booleanRef;
        SignalRegistry<MemoryCache.Key, Boolean> interceptorCache;
        Interceptor.Chain chain3;
        Interceptor.Chain chain4;
        ImageRequest request;
        Size size;
        EventListener eventListener;
        Options options;
        Scale scale;
        Object map;
        MemoryCache.Value cacheValue;
        Interceptor.Chain chain5;
        EngineInterceptor engineInterceptor;
        MemoryCache.Key key2;
        MemoryCache.Key key3;
        MemoryCache.Value value;
        MemoryCache.Key key4;
        Ref.BooleanRef booleanRef2;
        Interceptor.Chain chain6;
        MemoryCache.Key key5;
        Ref.BooleanRef booleanRef3;
        Interceptor.Chain chain7;
        MemoryCache.Key key6;
        Ref.BooleanRef booleanRef4;
        Object obj2;
        Ref.BooleanRef booleanRef5;
        if (continuation instanceof EngineInterceptor$intercept$1) {
            engineInterceptor$intercept$1 = (EngineInterceptor$intercept$1) continuation;
            if ((engineInterceptor$intercept$1.label & Integer.MIN_VALUE) != 0) {
                engineInterceptor$intercept$1.label -= Integer.MIN_VALUE;
                obj = engineInterceptor$intercept$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                r5 = engineInterceptor$intercept$1.label;
                ?? r7 = 3;
                ?? r8 = 2;
                if (r5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    r5 = new Ref.BooleanRef();
                    try {
                        request = chain.getRequest();
                        Object data = request.getData();
                        size = chain.getSize();
                        SizeResolver sizeResolver = Utils_commonKt.getSizeResolver(chain);
                        eventListener = Utils_commonKt.getEventListener(chain);
                        options = this.requestService.options(request, sizeResolver, size);
                        scale = options.getScale();
                        eventListener.mapStart(request, data);
                        map = this.imageLoader.getComponents().map(data, options);
                        eventListener.mapEnd(request, map);
                        r7 = this.memoryCacheService.newCacheKey(request, map, options, eventListener);
                        if (r7 != 0) {
                            try {
                                cacheValue = this.memoryCacheService.getCacheValue(request, r7, size, scale);
                            } catch (Throwable th2) {
                                th = th2;
                                r8 = chain;
                                th = th;
                                booleanRef = r5;
                                key = r7;
                                chain2 = r8;
                                chain4 = chain2;
                                chain4 = chain2;
                                if (booleanRef.element) {
                                    interceptorCache = SignalRegistryKt.getInterceptorCache();
                                    engineInterceptor$intercept$1.L$0 = chain2;
                                    engineInterceptor$intercept$1.L$1 = th;
                                    engineInterceptor$intercept$1.L$2 = null;
                                    engineInterceptor$intercept$1.L$3 = null;
                                    engineInterceptor$intercept$1.L$4 = null;
                                    engineInterceptor$intercept$1.L$5 = null;
                                    engineInterceptor$intercept$1.L$6 = null;
                                    engineInterceptor$intercept$1.L$7 = null;
                                    engineInterceptor$intercept$1.L$8 = null;
                                    engineInterceptor$intercept$1.L$9 = null;
                                    engineInterceptor$intercept$1.L$10 = null;
                                    engineInterceptor$intercept$1.L$11 = null;
                                    engineInterceptor$intercept$1.label = 4;
                                    if (interceptorCache.completeExceptionally(key, th, engineInterceptor$intercept$1) != coroutine_suspended) {
                                    }
                                }
                                if (th instanceof CancellationException) {
                                }
                            }
                        } else {
                            cacheValue = null;
                        }
                        System.out.println((Object) ("[woods]EngineInterceptor:intercept " + options.getExtras().get(ExtrasKt.getUseOptimizationKey())));
                        if (cacheValue == null && r7 != 0 && Intrinsics.areEqual(options.getExtras().get(ExtrasKt.getUseOptimizationKey()), Boxing.boxBoolean(true))) {
                            SignalRegistry<MemoryCache.Key, Boolean> interceptorCache2 = SignalRegistryKt.getInterceptorCache();
                            engineInterceptor$intercept$1.L$0 = this;
                            Interceptor.Chain chain8 = chain;
                            engineInterceptor$intercept$1.L$1 = chain8;
                            engineInterceptor$intercept$1.L$2 = r7;
                            engineInterceptor$intercept$1.L$3 = r5;
                            engineInterceptor$intercept$1.L$4 = request;
                            engineInterceptor$intercept$1.L$5 = size;
                            engineInterceptor$intercept$1.L$6 = eventListener;
                            engineInterceptor$intercept$1.L$7 = options;
                            engineInterceptor$intercept$1.L$8 = scale;
                            engineInterceptor$intercept$1.L$9 = map;
                            engineInterceptor$intercept$1.L$10 = r7;
                            engineInterceptor$intercept$1.L$11 = cacheValue;
                            engineInterceptor$intercept$1.label = 1;
                            Object await = interceptorCache2.await(r7, engineInterceptor$intercept$1);
                            if (await == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            engineInterceptor = this;
                            key3 = r7;
                            value = cacheValue;
                            obj = await;
                            booleanRef3 = r5;
                            key5 = r7;
                            chain6 = chain8;
                        } else {
                            chain5 = chain;
                            engineInterceptor = this;
                            key2 = r7;
                            booleanRef2 = r5;
                            key4 = r7;
                            Object obj3 = map;
                            Options options2 = options;
                            EventListener eventListener2 = eventListener;
                            if (cacheValue != null) {
                                MemoryCacheService memoryCacheService = engineInterceptor.memoryCacheService;
                                Intrinsics.checkNotNull(key2);
                                return memoryCacheService.newResult(chain5, request, key2, cacheValue);
                            }
                            CoroutineContext fetcherCoroutineContext = request.getFetcherCoroutineContext();
                            EngineInterceptor$intercept$2 engineInterceptor$intercept$2 = new EngineInterceptor$intercept$2(engineInterceptor, request, obj3, options2, eventListener2, key2, chain5, null);
                            engineInterceptor$intercept$1.L$0 = chain5;
                            engineInterceptor$intercept$1.L$1 = key4;
                            engineInterceptor$intercept$1.L$2 = booleanRef2;
                            engineInterceptor$intercept$1.L$3 = key2;
                            engineInterceptor$intercept$1.L$4 = null;
                            engineInterceptor$intercept$1.L$5 = null;
                            engineInterceptor$intercept$1.L$6 = null;
                            engineInterceptor$intercept$1.L$7 = null;
                            engineInterceptor$intercept$1.L$8 = null;
                            engineInterceptor$intercept$1.L$9 = null;
                            engineInterceptor$intercept$1.L$10 = null;
                            engineInterceptor$intercept$1.L$11 = null;
                            engineInterceptor$intercept$1.label = 2;
                            obj = BuildersKt.withContext(fetcherCoroutineContext, engineInterceptor$intercept$2, engineInterceptor$intercept$1);
                            booleanRef4 = booleanRef2;
                            key6 = key4;
                            chain7 = chain5;
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (booleanRef4.element) {
                            }
                        }
                    } catch (Throwable th3) {
                        chain2 = chain;
                        th = th3;
                        key = null;
                        booleanRef = r5;
                    }
                } else {
                    if (r5 == 1) {
                        value = (MemoryCache.Value) engineInterceptor$intercept$1.L$11;
                        MemoryCache.Key key7 = (MemoryCache.Key) engineInterceptor$intercept$1.L$10;
                        map = engineInterceptor$intercept$1.L$9;
                        scale = (Scale) engineInterceptor$intercept$1.L$8;
                        options = (Options) engineInterceptor$intercept$1.L$7;
                        eventListener = (EventListener) engineInterceptor$intercept$1.L$6;
                        size = (Size) engineInterceptor$intercept$1.L$5;
                        request = (ImageRequest) engineInterceptor$intercept$1.L$4;
                        Ref.BooleanRef booleanRef6 = (Ref.BooleanRef) engineInterceptor$intercept$1.L$3;
                        MemoryCache.Key key8 = (MemoryCache.Key) engineInterceptor$intercept$1.L$2;
                        Interceptor.Chain chain9 = (Interceptor.Chain) engineInterceptor$intercept$1.L$1;
                        EngineInterceptor engineInterceptor2 = (EngineInterceptor) engineInterceptor$intercept$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            key5 = key7;
                            booleanRef3 = booleanRef6;
                            key3 = key8;
                            chain6 = chain9;
                            engineInterceptor = engineInterceptor2;
                        } catch (Throwable th4) {
                            th = th4;
                            booleanRef = booleanRef6;
                            key = key8;
                            chain2 = chain9;
                        }
                    } else {
                        if (r5 != 2) {
                            if (r5 == 3) {
                                obj2 = engineInterceptor$intercept$1.L$3;
                                Ref.BooleanRef booleanRef7 = (Ref.BooleanRef) engineInterceptor$intercept$1.L$2;
                                ResultKt.throwOnFailure(obj);
                                booleanRef5 = booleanRef7;
                                booleanRef5.element = false;
                                return obj2;
                            }
                            if (r5 != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            th = (Throwable) engineInterceptor$intercept$1.L$1;
                            chain3 = (Interceptor.Chain) engineInterceptor$intercept$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            chain4 = chain3;
                            if (th instanceof CancellationException) {
                                throw th;
                            }
                            return Utils_commonKt.ErrorResult(chain4.getRequest(), th);
                        }
                        key2 = (MemoryCache.Key) engineInterceptor$intercept$1.L$3;
                        Ref.BooleanRef booleanRef8 = (Ref.BooleanRef) engineInterceptor$intercept$1.L$2;
                        MemoryCache.Key key9 = (MemoryCache.Key) engineInterceptor$intercept$1.L$1;
                        Interceptor.Chain chain10 = (Interceptor.Chain) engineInterceptor$intercept$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            key6 = key9;
                            chain7 = chain10;
                            booleanRef4 = booleanRef8;
                            if (booleanRef4.element) {
                                return obj;
                            }
                            SignalRegistry<MemoryCache.Key, Boolean> interceptorCache3 = SignalRegistryKt.getInterceptorCache();
                            Intrinsics.checkNotNull(key2);
                            Boolean boxBoolean = Boxing.boxBoolean(true);
                            engineInterceptor$intercept$1.L$0 = chain7;
                            engineInterceptor$intercept$1.L$1 = key6;
                            engineInterceptor$intercept$1.L$2 = booleanRef4;
                            engineInterceptor$intercept$1.L$3 = obj;
                            engineInterceptor$intercept$1.label = 3;
                            if (interceptorCache3.complete(key2, boxBoolean, engineInterceptor$intercept$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj2 = obj;
                            booleanRef5 = booleanRef4;
                            booleanRef5.element = false;
                            return obj2;
                        } catch (Throwable th5) {
                            th = th5;
                            key = key9;
                            chain2 = chain10;
                            booleanRef = booleanRef8;
                        }
                    }
                    chain4 = chain2;
                    chain4 = chain2;
                    if (booleanRef.element && key != null) {
                        interceptorCache = SignalRegistryKt.getInterceptorCache();
                        engineInterceptor$intercept$1.L$0 = chain2;
                        engineInterceptor$intercept$1.L$1 = th;
                        engineInterceptor$intercept$1.L$2 = null;
                        engineInterceptor$intercept$1.L$3 = null;
                        engineInterceptor$intercept$1.L$4 = null;
                        engineInterceptor$intercept$1.L$5 = null;
                        engineInterceptor$intercept$1.L$6 = null;
                        engineInterceptor$intercept$1.L$7 = null;
                        engineInterceptor$intercept$1.L$8 = null;
                        engineInterceptor$intercept$1.L$9 = null;
                        engineInterceptor$intercept$1.L$10 = null;
                        engineInterceptor$intercept$1.L$11 = null;
                        engineInterceptor$intercept$1.label = 4;
                        if (interceptorCache.completeExceptionally(key, th, engineInterceptor$intercept$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        chain3 = chain2;
                        chain4 = chain3;
                    }
                    if (th instanceof CancellationException) {
                    }
                }
                if (((Boolean) obj) == null) {
                    cacheValue = engineInterceptor.memoryCacheService.getCacheValue(request, key5, size, scale);
                } else {
                    booleanRef3.element = true;
                    cacheValue = value;
                }
                key2 = key5;
                key4 = key3;
                booleanRef2 = booleanRef3;
                chain5 = chain6;
                Object obj32 = map;
                Options options22 = options;
                EventListener eventListener22 = eventListener;
                if (cacheValue != null) {
                }
            }
        }
        engineInterceptor$intercept$1 = new EngineInterceptor$intercept$1(this, continuation);
        obj = engineInterceptor$intercept$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r5 = engineInterceptor$intercept$1.label;
        ?? r72 = 3;
        ?? r82 = 2;
        if (r5 != 0) {
        }
        if (((Boolean) obj) == null) {
        }
        key2 = key5;
        key4 = key3;
        booleanRef2 = booleanRef3;
        chain5 = chain6;
        Object obj322 = map;
        Options options222 = options;
        EventListener eventListener222 = eventListener;
        if (cacheValue != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x01bf A[PHI: r1
      0x01bf: PHI (r1v38 java.lang.Object) = (r1v34 java.lang.Object), (r1v3 java.lang.Object) binds: [B:29:0x01bc, B:11:0x0032] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01be A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0123 A[Catch: all -> 0x01c6, TRY_LEAVE, TryCatch #1 {all -> 0x01c6, blocks: (B:46:0x0119, B:48:0x0123, B:52:0x0162, B:54:0x0166, B:56:0x01c0, B:57:0x01c5, B:63:0x00a6, B:65:0x00b8, B:67:0x00dc, B:71:0x00be), top: B:62:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0162 A[Catch: all -> 0x01c6, TRY_ENTER, TryCatch #1 {all -> 0x01c6, blocks: (B:46:0x0119, B:48:0x0123, B:52:0x0162, B:54:0x0166, B:56:0x01c0, B:57:0x01c5, B:63:0x00a6, B:65:0x00b8, B:67:0x00dc, B:71:0x00be), top: B:62:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object execute(ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) {
        EngineInterceptor$execute$1 engineInterceptor$execute$1;
        int i;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Object obj2;
        EventListener eventListener2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        ImageRequest imageRequest2;
        EngineInterceptor engineInterceptor;
        FetchResult fetchResult;
        ExecuteResult executeResult;
        Ref.ObjectRef objectRef6;
        EventListener eventListener3;
        ImageRequest imageRequest3;
        EventListener eventListener4;
        ImageRequest imageRequest4;
        EngineInterceptor engineInterceptor2;
        SourceFetchResult sourceFetchResult;
        ImageSource source;
        SourceFetchResult sourceFetchResult2;
        ImageSource source2;
        if (continuation instanceof EngineInterceptor$execute$1) {
            engineInterceptor$execute$1 = (EngineInterceptor$execute$1) continuation;
            if ((engineInterceptor$execute$1.label & Integer.MIN_VALUE) != 0) {
                engineInterceptor$execute$1.label -= Integer.MIN_VALUE;
                EngineInterceptor$execute$1 engineInterceptor$execute$12 = engineInterceptor$execute$1;
                Object obj3 = engineInterceptor$execute$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = engineInterceptor$execute$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    Ref.ObjectRef objectRef7 = new Ref.ObjectRef();
                    objectRef7.element = options;
                    Ref.ObjectRef objectRef8 = new Ref.ObjectRef();
                    objectRef8.element = this.imageLoader.getComponents();
                    objectRef = new Ref.ObjectRef();
                    try {
                        objectRef7.element = this.requestService.updateOptionsOnWorkerThread((Options) objectRef7.element);
                        if (imageRequest.getFetcherFactory() != null || imageRequest.getDecoderFactory() != null) {
                            objectRef8.element = Utils_commonKt.addFirst(Utils_commonKt.addFirst(((ComponentRegistry) objectRef8.element).newBuilder(), imageRequest.getFetcherFactory()), imageRequest.getDecoderFactory()).build();
                        }
                        ComponentRegistry componentRegistry = (ComponentRegistry) objectRef8.element;
                        Options options2 = (Options) objectRef7.element;
                        engineInterceptor$execute$12.L$0 = this;
                        engineInterceptor$execute$12.L$1 = imageRequest;
                        engineInterceptor$execute$12.L$2 = obj;
                        engineInterceptor$execute$12.L$3 = eventListener;
                        engineInterceptor$execute$12.L$4 = objectRef7;
                        engineInterceptor$execute$12.L$5 = objectRef8;
                        engineInterceptor$execute$12.L$6 = objectRef;
                        engineInterceptor$execute$12.L$7 = objectRef;
                        engineInterceptor$execute$12.label = 1;
                        obj3 = fetch(componentRegistry, imageRequest, obj, options2, eventListener, engineInterceptor$execute$12);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj2 = obj;
                        eventListener2 = eventListener;
                        objectRef3 = objectRef7;
                        objectRef4 = objectRef8;
                        objectRef5 = objectRef;
                        imageRequest2 = imageRequest;
                        engineInterceptor = this;
                    } catch (Throwable th) {
                        th = th;
                        objectRef2 = objectRef;
                        Object obj4 = objectRef2.element;
                        if (obj4 instanceof SourceFetchResult) {
                        }
                        if (sourceFetchResult != null) {
                            Utils_commonKt.closeQuietly(source);
                        }
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                ResultKt.throwOnFailure(obj3);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        objectRef2 = (Ref.ObjectRef) engineInterceptor$execute$12.L$4;
                        objectRef3 = (Ref.ObjectRef) engineInterceptor$execute$12.L$3;
                        eventListener4 = (EventListener) engineInterceptor$execute$12.L$2;
                        imageRequest4 = (ImageRequest) engineInterceptor$execute$12.L$1;
                        engineInterceptor2 = (EngineInterceptor) engineInterceptor$execute$12.L$0;
                        try {
                            ResultKt.throwOnFailure(obj3);
                            objectRef = objectRef2;
                            engineInterceptor = engineInterceptor2;
                            executeResult = (ExecuteResult) obj3;
                            objectRef6 = objectRef3;
                            imageRequest3 = imageRequest4;
                            eventListener3 = eventListener4;
                            Object obj5 = objectRef.element;
                            sourceFetchResult2 = obj5 instanceof SourceFetchResult ? (SourceFetchResult) obj5 : null;
                            if (sourceFetchResult2 != null && (source2 = sourceFetchResult2.getSource()) != null) {
                                Utils_commonKt.closeQuietly(source2);
                            }
                            Options options3 = (Options) objectRef6.element;
                            Logger logger = engineInterceptor.logger;
                            engineInterceptor$execute$12.L$0 = null;
                            engineInterceptor$execute$12.L$1 = null;
                            engineInterceptor$execute$12.L$2 = null;
                            engineInterceptor$execute$12.L$3 = null;
                            engineInterceptor$execute$12.L$4 = null;
                            engineInterceptor$execute$12.L$5 = null;
                            engineInterceptor$execute$12.L$6 = null;
                            engineInterceptor$execute$12.L$7 = null;
                            engineInterceptor$execute$12.label = 3;
                            obj3 = EngineInterceptorKt.transform(executeResult, imageRequest3, options3, eventListener3, logger, engineInterceptor$execute$12);
                            return obj3 == coroutine_suspended ? coroutine_suspended : obj3;
                        } catch (Throwable th2) {
                            th = th2;
                            Object obj42 = objectRef2.element;
                            if (obj42 instanceof SourceFetchResult) {
                            }
                            if (sourceFetchResult != null) {
                            }
                            throw th;
                        }
                    }
                    objectRef5 = (Ref.ObjectRef) engineInterceptor$execute$12.L$7;
                    Ref.ObjectRef objectRef9 = (Ref.ObjectRef) engineInterceptor$execute$12.L$6;
                    Ref.ObjectRef objectRef10 = (Ref.ObjectRef) engineInterceptor$execute$12.L$5;
                    Ref.ObjectRef objectRef11 = (Ref.ObjectRef) engineInterceptor$execute$12.L$4;
                    eventListener2 = (EventListener) engineInterceptor$execute$12.L$3;
                    Object obj6 = engineInterceptor$execute$12.L$2;
                    imageRequest2 = (ImageRequest) engineInterceptor$execute$12.L$1;
                    engineInterceptor = (EngineInterceptor) engineInterceptor$execute$12.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        objectRef = objectRef9;
                        objectRef4 = objectRef10;
                        objectRef3 = objectRef11;
                        obj2 = obj6;
                    } catch (Throwable th3) {
                        th = th3;
                        objectRef2 = objectRef9;
                        Object obj422 = objectRef2.element;
                        sourceFetchResult = obj422 instanceof SourceFetchResult ? (SourceFetchResult) obj422 : null;
                        if (sourceFetchResult != null && (source = sourceFetchResult.getSource()) != null) {
                            Utils_commonKt.closeQuietly(source);
                        }
                        throw th;
                    }
                }
                objectRef5.element = obj3;
                fetchResult = (FetchResult) objectRef.element;
                if (!(fetchResult instanceof SourceFetchResult)) {
                    CoroutineContext decoderCoroutineContext = imageRequest2.getDecoderCoroutineContext();
                    EngineInterceptor$execute$executeResult$1 engineInterceptor$execute$executeResult$1 = new EngineInterceptor$execute$executeResult$1(engineInterceptor, objectRef, objectRef4, imageRequest2, obj2, objectRef3, eventListener2, null);
                    engineInterceptor$execute$12.L$0 = engineInterceptor;
                    engineInterceptor$execute$12.L$1 = imageRequest2;
                    engineInterceptor$execute$12.L$2 = eventListener2;
                    engineInterceptor$execute$12.L$3 = objectRef3;
                    engineInterceptor$execute$12.L$4 = objectRef;
                    engineInterceptor$execute$12.L$5 = null;
                    engineInterceptor$execute$12.L$6 = null;
                    engineInterceptor$execute$12.L$7 = null;
                    engineInterceptor$execute$12.label = 2;
                    obj3 = BuildersKt.withContext(decoderCoroutineContext, engineInterceptor$execute$executeResult$1, engineInterceptor$execute$12);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eventListener4 = eventListener2;
                    imageRequest4 = imageRequest2;
                    engineInterceptor2 = engineInterceptor;
                    objectRef2 = objectRef;
                    objectRef = objectRef2;
                    engineInterceptor = engineInterceptor2;
                    executeResult = (ExecuteResult) obj3;
                    objectRef6 = objectRef3;
                    imageRequest3 = imageRequest4;
                    eventListener3 = eventListener4;
                    Object obj52 = objectRef.element;
                    if (obj52 instanceof SourceFetchResult) {
                    }
                    if (sourceFetchResult2 != null) {
                        Utils_commonKt.closeQuietly(source2);
                    }
                    Options options32 = (Options) objectRef6.element;
                    Logger logger2 = engineInterceptor.logger;
                    engineInterceptor$execute$12.L$0 = null;
                    engineInterceptor$execute$12.L$1 = null;
                    engineInterceptor$execute$12.L$2 = null;
                    engineInterceptor$execute$12.L$3 = null;
                    engineInterceptor$execute$12.L$4 = null;
                    engineInterceptor$execute$12.L$5 = null;
                    engineInterceptor$execute$12.L$6 = null;
                    engineInterceptor$execute$12.L$7 = null;
                    engineInterceptor$execute$12.label = 3;
                    obj3 = EngineInterceptorKt.transform(executeResult, imageRequest3, options32, eventListener3, logger2, engineInterceptor$execute$12);
                    if (obj3 == coroutine_suspended) {
                    }
                } else {
                    if (!(fetchResult instanceof ImageFetchResult)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    executeResult = new ExecuteResult(((ImageFetchResult) objectRef.element).getImage(), ((ImageFetchResult) objectRef.element).getIsSampled(), ((ImageFetchResult) objectRef.element).getDataSource(), null);
                    objectRef6 = objectRef3;
                    eventListener3 = eventListener2;
                    imageRequest3 = imageRequest2;
                    Object obj522 = objectRef.element;
                    if (obj522 instanceof SourceFetchResult) {
                    }
                    if (sourceFetchResult2 != null) {
                    }
                    Options options322 = (Options) objectRef6.element;
                    Logger logger22 = engineInterceptor.logger;
                    engineInterceptor$execute$12.L$0 = null;
                    engineInterceptor$execute$12.L$1 = null;
                    engineInterceptor$execute$12.L$2 = null;
                    engineInterceptor$execute$12.L$3 = null;
                    engineInterceptor$execute$12.L$4 = null;
                    engineInterceptor$execute$12.L$5 = null;
                    engineInterceptor$execute$12.L$6 = null;
                    engineInterceptor$execute$12.L$7 = null;
                    engineInterceptor$execute$12.label = 3;
                    obj3 = EngineInterceptorKt.transform(executeResult, imageRequest3, options322, eventListener3, logger22, engineInterceptor$execute$12);
                    if (obj3 == coroutine_suspended) {
                    }
                }
            }
        }
        engineInterceptor$execute$1 = new EngineInterceptor$execute$1(this, continuation);
        EngineInterceptor$execute$1 engineInterceptor$execute$122 = engineInterceptor$execute$1;
        Object obj32 = engineInterceptor$execute$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = engineInterceptor$execute$122.label;
        if (i != 0) {
        }
        objectRef5.element = obj32;
        fetchResult = (FetchResult) objectRef.element;
        if (!(fetchResult instanceof SourceFetchResult)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0093 -> B:10:0x0098). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetch(ComponentRegistry componentRegistry, ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, Continuation<? super FetchResult> continuation) {
        EngineInterceptor$fetch$1 engineInterceptor$fetch$1;
        int i;
        int i2;
        EngineInterceptor engineInterceptor;
        Pair<Fetcher, Integer> newFetcher;
        ImageSource source;
        if (continuation instanceof EngineInterceptor$fetch$1) {
            engineInterceptor$fetch$1 = (EngineInterceptor$fetch$1) continuation;
            if ((engineInterceptor$fetch$1.label & Integer.MIN_VALUE) != 0) {
                engineInterceptor$fetch$1.label -= Integer.MIN_VALUE;
                Object obj2 = engineInterceptor$fetch$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = engineInterceptor$fetch$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    i2 = 0;
                    engineInterceptor = this;
                    newFetcher = componentRegistry.newFetcher(obj, options, engineInterceptor.imageLoader, i2);
                    if (newFetcher != null) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i3 = engineInterceptor$fetch$1.I$0;
                    Fetcher fetcher = (Fetcher) engineInterceptor$fetch$1.L$6;
                    EventListener eventListener2 = (EventListener) engineInterceptor$fetch$1.L$5;
                    options = (Options) engineInterceptor$fetch$1.L$4;
                    Object obj3 = engineInterceptor$fetch$1.L$3;
                    ImageRequest imageRequest2 = (ImageRequest) engineInterceptor$fetch$1.L$2;
                    ComponentRegistry componentRegistry2 = (ComponentRegistry) engineInterceptor$fetch$1.L$1;
                    engineInterceptor = (EngineInterceptor) engineInterceptor$fetch$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    EngineInterceptor$fetch$1 engineInterceptor$fetch$12 = engineInterceptor$fetch$1;
                    int i4 = i3;
                    componentRegistry = componentRegistry2;
                    Object obj4 = coroutine_suspended;
                    EngineInterceptor$fetch$1 engineInterceptor$fetch$13 = engineInterceptor$fetch$12;
                    Fetcher fetcher2 = fetcher;
                    imageRequest = imageRequest2;
                    eventListener = eventListener2;
                    obj = obj3;
                    FetchResult fetchResult = (FetchResult) obj2;
                    try {
                        eventListener.fetchEnd(imageRequest, fetcher2, options, fetchResult);
                        if (fetchResult == null) {
                            return fetchResult;
                        }
                        i2 = i4;
                        engineInterceptor$fetch$1 = engineInterceptor$fetch$13;
                        coroutine_suspended = obj4;
                        newFetcher = componentRegistry.newFetcher(obj, options, engineInterceptor.imageLoader, i2);
                        if (newFetcher != null) {
                            throw new IllegalStateException(("Unable to create a fetcher that supports: " + obj).toString());
                        }
                        fetcher2 = (Fetcher) newFetcher.getFirst();
                        int intValue = ((Number) newFetcher.getSecond()).intValue() + 1;
                        eventListener.fetchStart(imageRequest, fetcher2, options);
                        engineInterceptor$fetch$1.L$0 = engineInterceptor;
                        engineInterceptor$fetch$1.L$1 = componentRegistry;
                        engineInterceptor$fetch$1.L$2 = imageRequest;
                        engineInterceptor$fetch$1.L$3 = obj;
                        engineInterceptor$fetch$1.L$4 = options;
                        engineInterceptor$fetch$1.L$5 = eventListener;
                        engineInterceptor$fetch$1.L$6 = fetcher2;
                        engineInterceptor$fetch$1.I$0 = intValue;
                        engineInterceptor$fetch$1.label = 1;
                        Object fetch = fetcher2.fetch(engineInterceptor$fetch$1);
                        if (fetch == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        EngineInterceptor$fetch$1 engineInterceptor$fetch$14 = engineInterceptor$fetch$1;
                        i4 = intValue;
                        obj2 = fetch;
                        obj4 = coroutine_suspended;
                        engineInterceptor$fetch$13 = engineInterceptor$fetch$14;
                        FetchResult fetchResult2 = (FetchResult) obj2;
                        eventListener.fetchEnd(imageRequest, fetcher2, options, fetchResult2);
                        if (fetchResult2 == null) {
                        }
                    } catch (Throwable th) {
                        SourceFetchResult sourceFetchResult = fetchResult2 instanceof SourceFetchResult ? (SourceFetchResult) fetchResult2 : null;
                        if (sourceFetchResult != null && (source = sourceFetchResult.getSource()) != null) {
                            Utils_commonKt.closeQuietly(source);
                        }
                        throw th;
                    }
                }
            }
        }
        engineInterceptor$fetch$1 = new EngineInterceptor$fetch$1(this, continuation);
        Object obj22 = engineInterceptor$fetch$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = engineInterceptor$fetch$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00ac -> B:10:0x00b5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object decode(SourceFetchResult sourceFetchResult, ComponentRegistry componentRegistry, ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) {
        EngineInterceptor$decode$1 engineInterceptor$decode$1;
        EngineInterceptor engineInterceptor;
        int i;
        Object obj2;
        Options options2;
        EventListener eventListener2;
        int i2;
        EngineInterceptor$decode$1 engineInterceptor$decode$12;
        EngineInterceptor engineInterceptor2;
        Object obj3;
        SourceFetchResult sourceFetchResult2;
        ComponentRegistry componentRegistry2;
        ImageRequest imageRequest2;
        Pair<Decoder, Integer> newDecoder;
        if (continuation instanceof EngineInterceptor$decode$1) {
            engineInterceptor$decode$1 = (EngineInterceptor$decode$1) continuation;
            if ((engineInterceptor$decode$1.label & Integer.MIN_VALUE) != 0) {
                engineInterceptor$decode$1.label -= Integer.MIN_VALUE;
                engineInterceptor = this;
                Object obj4 = engineInterceptor$decode$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = engineInterceptor$decode$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj4);
                    obj2 = obj;
                    options2 = options;
                    eventListener2 = eventListener;
                    i2 = 0;
                    engineInterceptor$decode$12 = engineInterceptor$decode$1;
                    engineInterceptor2 = engineInterceptor;
                    obj3 = coroutine_suspended;
                    sourceFetchResult2 = sourceFetchResult;
                    componentRegistry2 = componentRegistry;
                    imageRequest2 = imageRequest;
                    newDecoder = componentRegistry2.newDecoder(sourceFetchResult2, options2, engineInterceptor2.imageLoader, i2);
                    if (newDecoder != null) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i3 = engineInterceptor$decode$1.I$0;
                    Decoder decoder = (Decoder) engineInterceptor$decode$1.L$7;
                    eventListener2 = (EventListener) engineInterceptor$decode$1.L$6;
                    Options options3 = (Options) engineInterceptor$decode$1.L$5;
                    Object obj5 = engineInterceptor$decode$1.L$4;
                    ImageRequest imageRequest3 = (ImageRequest) engineInterceptor$decode$1.L$3;
                    ComponentRegistry componentRegistry3 = (ComponentRegistry) engineInterceptor$decode$1.L$2;
                    SourceFetchResult sourceFetchResult3 = (SourceFetchResult) engineInterceptor$decode$1.L$1;
                    engineInterceptor2 = (EngineInterceptor) engineInterceptor$decode$1.L$0;
                    ResultKt.throwOnFailure(obj4);
                    EngineInterceptor$decode$1 engineInterceptor$decode$13 = engineInterceptor$decode$1;
                    componentRegistry2 = componentRegistry3;
                    Object obj6 = coroutine_suspended;
                    imageRequest2 = imageRequest3;
                    int i4 = i3;
                    obj2 = obj5;
                    DecodeResult decodeResult = (DecodeResult) obj4;
                    eventListener2.decodeEnd(imageRequest2, decoder, options3, decodeResult);
                    if (decodeResult != null) {
                        options2 = options3;
                        i2 = i4;
                        engineInterceptor$decode$12 = engineInterceptor$decode$13;
                        obj3 = obj6;
                        sourceFetchResult2 = sourceFetchResult3;
                        newDecoder = componentRegistry2.newDecoder(sourceFetchResult2, options2, engineInterceptor2.imageLoader, i2);
                        if (newDecoder != null) {
                            throw new IllegalStateException(("Unable to create a decoder that supports: " + obj2).toString());
                        }
                        Decoder decoder2 = (Decoder) newDecoder.getFirst();
                        int intValue = ((Number) newDecoder.getSecond()).intValue() + 1;
                        eventListener2.decodeStart(imageRequest2, decoder2, options2);
                        engineInterceptor$decode$12.L$0 = engineInterceptor2;
                        engineInterceptor$decode$12.L$1 = sourceFetchResult2;
                        engineInterceptor$decode$12.L$2 = componentRegistry2;
                        engineInterceptor$decode$12.L$3 = imageRequest2;
                        engineInterceptor$decode$12.L$4 = obj2;
                        engineInterceptor$decode$12.L$5 = options2;
                        engineInterceptor$decode$12.L$6 = eventListener2;
                        engineInterceptor$decode$12.L$7 = decoder2;
                        engineInterceptor$decode$12.I$0 = intValue;
                        engineInterceptor$decode$12.label = 1;
                        Object decode = decoder2.decode(engineInterceptor$decode$12);
                        if (decode == obj3) {
                            return obj3;
                        }
                        sourceFetchResult3 = sourceFetchResult2;
                        obj4 = decode;
                        options3 = options2;
                        decoder = decoder2;
                        obj6 = obj3;
                        engineInterceptor$decode$13 = engineInterceptor$decode$12;
                        i4 = intValue;
                        DecodeResult decodeResult2 = (DecodeResult) obj4;
                        eventListener2.decodeEnd(imageRequest2, decoder, options3, decodeResult2);
                        if (decodeResult2 != null) {
                        }
                    } else {
                        Image image = decodeResult2.getImage();
                        boolean isSampled = decodeResult2.getIsSampled();
                        DataSource dataSource = sourceFetchResult3.getDataSource();
                        ImageSource source = sourceFetchResult3.getSource();
                        FileImageSource fileImageSource = source instanceof FileImageSource ? (FileImageSource) source : null;
                        return new ExecuteResult(image, isSampled, dataSource, fileImageSource != null ? fileImageSource.getDiskCacheKey() : null);
                    }
                }
            }
        }
        engineInterceptor = this;
        engineInterceptor$decode$1 = new EngineInterceptor$decode$1(engineInterceptor, continuation);
        Object obj42 = engineInterceptor$decode$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = engineInterceptor$decode$1.label;
        if (i != 0) {
        }
    }

    /* compiled from: EngineInterceptor.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcoil3/intercept/EngineInterceptor$ExecuteResult;", "", "image", "Lcoil3/Image;", "isSampled", "", "dataSource", "Lcoil3/decode/DataSource;", "diskCacheKey", "", "<init>", "(Lcoil3/Image;ZLcoil3/decode/DataSource;Ljava/lang/String;)V", "getImage", "()Lcoil3/Image;", "()Z", "getDataSource", "()Lcoil3/decode/DataSource;", "getDiskCacheKey", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final /* data */ class ExecuteResult {
        private final DataSource dataSource;
        private final String diskCacheKey;
        private final Image image;
        private final boolean isSampled;

        public static /* synthetic */ ExecuteResult copy$default(ExecuteResult executeResult, Image image, boolean z, DataSource dataSource, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                image = executeResult.image;
            }
            if ((i & 2) != 0) {
                z = executeResult.isSampled;
            }
            if ((i & 4) != 0) {
                dataSource = executeResult.dataSource;
            }
            if ((i & 8) != 0) {
                str = executeResult.diskCacheKey;
            }
            return executeResult.copy(image, z, dataSource, str);
        }

        /* renamed from: component1, reason: from getter */
        public final Image getImage() {
            return this.image;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsSampled() {
            return this.isSampled;
        }

        /* renamed from: component3, reason: from getter */
        public final DataSource getDataSource() {
            return this.dataSource;
        }

        /* renamed from: component4, reason: from getter */
        public final String getDiskCacheKey() {
            return this.diskCacheKey;
        }

        public final ExecuteResult copy(Image image, boolean isSampled, DataSource dataSource, String diskCacheKey) {
            return new ExecuteResult(image, isSampled, dataSource, diskCacheKey);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ExecuteResult)) {
                return false;
            }
            ExecuteResult executeResult = (ExecuteResult) other;
            return Intrinsics.areEqual(this.image, executeResult.image) && this.isSampled == executeResult.isSampled && this.dataSource == executeResult.dataSource && Intrinsics.areEqual(this.diskCacheKey, executeResult.diskCacheKey);
        }

        public int hashCode() {
            int hashCode = ((((this.image.hashCode() * 31) + Boolean.hashCode(this.isSampled)) * 31) + this.dataSource.hashCode()) * 31;
            String str = this.diskCacheKey;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ExecuteResult(image=" + this.image + ", isSampled=" + this.isSampled + ", dataSource=" + this.dataSource + ", diskCacheKey=" + this.diskCacheKey + ')';
        }

        public ExecuteResult(Image image, boolean z, DataSource dataSource, String str) {
            this.image = image;
            this.isSampled = z;
            this.dataSource = dataSource;
            this.diskCacheKey = str;
        }

        public final Image getImage() {
            return this.image;
        }

        public final boolean isSampled() {
            return this.isSampled;
        }

        public final DataSource getDataSource() {
            return this.dataSource;
        }

        public final String getDiskCacheKey() {
            return this.diskCacheKey;
        }
    }
}
