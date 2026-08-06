package coil3.network;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.webkit.ProxyConfig;
import coil3.ImageLoader;
import coil3.Uri;
import coil3.decode.DataSource;
import coil3.decode.ImageSource;
import coil3.decode.ImageSourceKt;
import coil3.disk.DiskCache;
import coil3.fetch.FetchResult;
import coil3.fetch.Fetcher;
import coil3.fetch.SourceFetchResult;
import coil3.network.CacheStrategy;
import coil3.network.NetworkHeaders;
import coil3.network.internal.SingleParameterLazy;
import coil3.network.internal.SingleParameterLazyKt;
import coil3.network.internal.UtilsKt;
import coil3.network.internal.Utils_commonKt;
import coil3.request.Options;
import coil3.util.MimeTypeMap;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;

/* compiled from: NetworkFetcher.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00017BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J4\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020 H\u0002J@\u0010!\u001a\u0002H\"\"\u0004\b\u0000\u0010\"2\u0006\u0010#\u001a\u00020 2\"\u0010$\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0&\u0012\u0006\u0012\u0004\u0018\u00010'0%H\u0082@¢\u0006\u0002\u0010(J\u001c\u0010)\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010\u0003H\u0007J\u000e\u0010+\u001a\u0004\u0018\u00010\u0019*\u00020\u0015H\u0002J\f\u0010,\u001a\u00020-*\u00020\u0015H\u0002J\u0012\u0010,\u001a\u00020-*\u00020\u001dH\u0082@¢\u0006\u0002\u0010.J\f\u0010,\u001a\u00020-*\u00020/H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00103\u001a\u0002048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00106¨\u00068"}, d2 = {"Lcoil3/network/NetworkFetcher;", "Lcoil3/fetch/Fetcher;", StreamTrafficObservable.STREAM_URL, "", "options", "Lcoil3/request/Options;", "networkClient", "Lkotlin/Lazy;", "Lcoil3/network/NetworkClient;", "diskCache", "Lcoil3/disk/DiskCache;", "cacheStrategy", "Lcoil3/network/CacheStrategy;", "connectivityChecker", "Lcoil3/network/ConnectivityChecker;", "<init>", "(Ljava/lang/String;Lcoil3/request/Options;Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil3/network/ConnectivityChecker;)V", "fetch", "Lcoil3/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFromDiskCache", "Lcoil3/disk/DiskCache$Snapshot;", "writeToDiskCache", StrategyConstants.SNAPSHOT, "cacheResponse", "Lcoil3/network/CacheResponse;", "networkResponse", "Lcoil3/network/NetworkResponse;", "networkResponseBody", "Lcoil3/network/NetworkResponseBody;", "(Lcoil3/disk/DiskCache$Snapshot;Lcoil3/network/CacheResponse;Lcoil3/network/NetworkResponse;Lcoil3/network/NetworkResponseBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newRequest", "Lcoil3/network/NetworkRequest;", "executeNetworkRequest", ExifInterface.GPS_DIRECTION_TRUE, "request", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lcoil3/network/NetworkRequest;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMimeType", "contentType", "toCacheResponse", "toImageSource", "Lcoil3/decode/ImageSource;", "(Lcoil3/network/NetworkResponseBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lokio/Buffer;", "diskCacheKey", "getDiskCacheKey", "()Ljava/lang/String;", "fileSystem", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "Factory", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class NetworkFetcher implements Fetcher {
    private final Lazy<CacheStrategy> cacheStrategy;
    private final ConnectivityChecker connectivityChecker;
    private final Lazy<DiskCache> diskCache;
    private final Lazy<NetworkClient> networkClient;
    private final Options options;
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public NetworkFetcher(String str, Options options, Lazy<? extends NetworkClient> lazy, Lazy<? extends DiskCache> lazy2, Lazy<? extends CacheStrategy> lazy3, ConnectivityChecker connectivityChecker) {
        this.url = str;
        this.options = options;
        this.networkClient = lazy;
        this.diskCache = lazy2;
        this.cacheStrategy = lazy3;
        this.connectivityChecker = connectivityChecker;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0116 A[Catch: Exception -> 0x004e, TRY_LEAVE, TryCatch #0 {Exception -> 0x004e, blocks: (B:27:0x0049, B:28:0x0112, B:30:0x0116), top: B:26:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c5 A[Catch: Exception -> 0x0132, TRY_ENTER, TryCatch #3 {Exception -> 0x0132, blocks: (B:44:0x00c5, B:46:0x00e6, B:48:0x00ec, B:50:0x00f6, B:54:0x00f2, B:60:0x0078, B:62:0x0081, B:64:0x008b), top: B:59:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ec A[Catch: Exception -> 0x0132, TryCatch #3 {Exception -> 0x0132, blocks: (B:44:0x00c5, B:46:0x00e6, B:48:0x00ec, B:50:0x00f6, B:54:0x00f2, B:60:0x0078, B:62:0x0081, B:64:0x008b), top: B:59:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // coil3.fetch.Fetcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetch(Continuation<? super FetchResult> continuation) {
        NetworkFetcher$fetch$1 networkFetcher$fetch$1;
        Object coroutine_suspended;
        int i;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Exception e;
        Ref.ObjectRef objectRef3;
        NetworkFetcher networkFetcher;
        CacheResponse cacheResponse;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        CacheStrategy.Output output;
        Object executeNetworkRequest;
        NetworkFetcher networkFetcher2;
        Ref.ObjectRef objectRef6;
        SourceFetchResult sourceFetchResult;
        DiskCache.Snapshot snapshot;
        if (continuation instanceof NetworkFetcher$fetch$1) {
            networkFetcher$fetch$1 = (NetworkFetcher$fetch$1) continuation;
            if ((networkFetcher$fetch$1.label & Integer.MIN_VALUE) != 0) {
                networkFetcher$fetch$1.label -= Integer.MIN_VALUE;
                Object obj = networkFetcher$fetch$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = networkFetcher$fetch$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    objectRef = new Ref.ObjectRef();
                    objectRef.element = readFromDiskCache();
                    try {
                        objectRef3 = new Ref.ObjectRef();
                        if (objectRef.element != null) {
                            cacheResponse = toCacheResponse((DiskCache.Snapshot) objectRef.element);
                            if (cacheResponse != null) {
                                CacheStrategy.Input input = new CacheStrategy.Input(cacheResponse, newRequest(), this.options);
                                CacheStrategy cacheStrategy = (CacheStrategy) this.cacheStrategy.getValue();
                                networkFetcher$fetch$1.L$0 = this;
                                networkFetcher$fetch$1.L$1 = objectRef;
                                networkFetcher$fetch$1.L$2 = objectRef3;
                                networkFetcher$fetch$1.L$3 = objectRef3;
                                networkFetcher$fetch$1.label = 1;
                                Object compute = cacheStrategy.compute(input, networkFetcher$fetch$1);
                                if (compute == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                networkFetcher = this;
                                objectRef4 = objectRef;
                                obj = compute;
                                objectRef5 = objectRef3;
                            } else {
                                networkFetcher = this;
                                if (cacheResponse != null) {
                                    return new SourceFetchResult(networkFetcher.toImageSource((DiskCache.Snapshot) objectRef.element), networkFetcher.getMimeType(networkFetcher.url, cacheResponse.getResponseHeaders().get("Content-Type")), DataSource.DISK);
                                }
                                output = (CacheStrategy.Output) objectRef3.element;
                                if (output != null || (r5 = output.getNetworkRequest()) == null) {
                                    NetworkRequest newRequest = networkFetcher.newRequest();
                                }
                                NetworkFetcher$fetch$result$1 networkFetcher$fetch$result$1 = new NetworkFetcher$fetch$result$1(objectRef, networkFetcher, objectRef3, null);
                                networkFetcher$fetch$1.L$0 = networkFetcher;
                                networkFetcher$fetch$1.L$1 = objectRef;
                                networkFetcher$fetch$1.L$2 = null;
                                networkFetcher$fetch$1.L$3 = null;
                                networkFetcher$fetch$1.label = 2;
                                executeNetworkRequest = networkFetcher.executeNetworkRequest(newRequest, networkFetcher$fetch$result$1, networkFetcher$fetch$1);
                                if (executeNetworkRequest != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                networkFetcher2 = networkFetcher;
                                objectRef6 = objectRef;
                                obj = executeNetworkRequest;
                                sourceFetchResult = (SourceFetchResult) obj;
                                if (sourceFetchResult == null) {
                                }
                            }
                        } else {
                            networkFetcher = this;
                            output = (CacheStrategy.Output) objectRef3.element;
                            if (output != null) {
                            }
                            NetworkRequest newRequest2 = networkFetcher.newRequest();
                            NetworkFetcher$fetch$result$1 networkFetcher$fetch$result$12 = new NetworkFetcher$fetch$result$1(objectRef, networkFetcher, objectRef3, null);
                            networkFetcher$fetch$1.L$0 = networkFetcher;
                            networkFetcher$fetch$1.L$1 = objectRef;
                            networkFetcher$fetch$1.L$2 = null;
                            networkFetcher$fetch$1.L$3 = null;
                            networkFetcher$fetch$1.label = 2;
                            executeNetworkRequest = networkFetcher.executeNetworkRequest(newRequest2, networkFetcher$fetch$result$12, networkFetcher$fetch$1);
                            if (executeNetworkRequest != coroutine_suspended) {
                            }
                        }
                    } catch (Exception e2) {
                        objectRef2 = objectRef;
                        e = e2;
                        snapshot = (DiskCache.Snapshot) objectRef2.element;
                        if (snapshot != null) {
                        }
                        throw e;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            objectRef2 = (Ref.ObjectRef) networkFetcher$fetch$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                return (SourceFetchResult) obj;
                            } catch (Exception e3) {
                                e = e3;
                                snapshot = (DiskCache.Snapshot) objectRef2.element;
                                if (snapshot != null) {
                                }
                                throw e;
                            }
                        }
                        objectRef6 = (Ref.ObjectRef) networkFetcher$fetch$1.L$1;
                        networkFetcher2 = (NetworkFetcher) networkFetcher$fetch$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            sourceFetchResult = (SourceFetchResult) obj;
                            if (sourceFetchResult == null) {
                                return sourceFetchResult;
                            }
                            NetworkRequest newRequest3 = networkFetcher2.newRequest();
                            NetworkFetcher$fetch$2 networkFetcher$fetch$2 = new NetworkFetcher$fetch$2(networkFetcher2, null);
                            networkFetcher$fetch$1.L$0 = objectRef6;
                            networkFetcher$fetch$1.L$1 = null;
                            networkFetcher$fetch$1.label = 3;
                            obj = networkFetcher2.executeNetworkRequest(newRequest3, networkFetcher$fetch$2, networkFetcher$fetch$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            objectRef2 = objectRef6;
                            return (SourceFetchResult) obj;
                        } catch (Exception e4) {
                            e = e4;
                            objectRef2 = objectRef6;
                            snapshot = (DiskCache.Snapshot) objectRef2.element;
                            if (snapshot != null) {
                                Utils_commonKt.closeQuietly(snapshot);
                            }
                            throw e;
                        }
                    }
                    objectRef3 = (Ref.ObjectRef) networkFetcher$fetch$1.L$3;
                    objectRef5 = (Ref.ObjectRef) networkFetcher$fetch$1.L$2;
                    objectRef4 = (Ref.ObjectRef) networkFetcher$fetch$1.L$1;
                    networkFetcher = (NetworkFetcher) networkFetcher$fetch$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception e5) {
                        e = e5;
                        objectRef2 = objectRef4;
                        snapshot = (DiskCache.Snapshot) objectRef2.element;
                        if (snapshot != null) {
                        }
                        throw e;
                    }
                }
                objectRef3.element = obj;
                objectRef3 = objectRef5;
                Ref.ObjectRef objectRef7 = objectRef4;
                cacheResponse = ((CacheStrategy.Output) objectRef5.element).getCacheResponse();
                objectRef = objectRef7;
                if (cacheResponse != null) {
                }
                output = (CacheStrategy.Output) objectRef3.element;
                if (output != null) {
                }
                NetworkRequest newRequest22 = networkFetcher.newRequest();
                NetworkFetcher$fetch$result$1 networkFetcher$fetch$result$122 = new NetworkFetcher$fetch$result$1(objectRef, networkFetcher, objectRef3, null);
                networkFetcher$fetch$1.L$0 = networkFetcher;
                networkFetcher$fetch$1.L$1 = objectRef;
                networkFetcher$fetch$1.L$2 = null;
                networkFetcher$fetch$1.L$3 = null;
                networkFetcher$fetch$1.label = 2;
                executeNetworkRequest = networkFetcher.executeNetworkRequest(newRequest22, networkFetcher$fetch$result$122, networkFetcher$fetch$1);
                if (executeNetworkRequest != coroutine_suspended) {
                }
            }
        }
        networkFetcher$fetch$1 = new NetworkFetcher$fetch$1(this, continuation);
        Object obj2 = networkFetcher$fetch$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = networkFetcher$fetch$1.label;
        if (i != 0) {
        }
        objectRef3.element = obj2;
        objectRef3 = objectRef5;
        Ref.ObjectRef objectRef72 = objectRef4;
        cacheResponse = ((CacheStrategy.Output) objectRef5.element).getCacheResponse();
        objectRef = objectRef72;
        if (cacheResponse != null) {
        }
        output = (CacheStrategy.Output) objectRef3.element;
        if (output != null) {
        }
        NetworkRequest newRequest222 = networkFetcher.newRequest();
        NetworkFetcher$fetch$result$1 networkFetcher$fetch$result$1222 = new NetworkFetcher$fetch$result$1(objectRef, networkFetcher, objectRef3, null);
        networkFetcher$fetch$1.L$0 = networkFetcher;
        networkFetcher$fetch$1.L$1 = objectRef;
        networkFetcher$fetch$1.L$2 = null;
        networkFetcher$fetch$1.L$3 = null;
        networkFetcher$fetch$1.label = 2;
        executeNetworkRequest = networkFetcher.executeNetworkRequest(newRequest222, networkFetcher$fetch$result$1222, networkFetcher$fetch$1);
        if (executeNetworkRequest != coroutine_suspended) {
        }
    }

    private final DiskCache.Snapshot readFromDiskCache() {
        DiskCache diskCache;
        if (!this.options.getDiskCachePolicy().getReadEnabled() || (diskCache = (DiskCache) this.diskCache.getValue()) == null) {
            return null;
        }
        return diskCache.openSnapshot(getDiskCacheKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r7v0, types: [coil3.disk.DiskCache$Snapshot] */
    /* JADX WARN: Type inference failed for: r7v1, types: [coil3.disk.DiskCache$Editor] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7, types: [coil3.disk.DiskCache$Editor, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeToDiskCache(DiskCache.Snapshot snapshot, CacheResponse cacheResponse, NetworkResponse networkResponse, NetworkResponseBody networkResponseBody, Continuation<? super DiskCache.Snapshot> continuation) {
        NetworkFetcher$writeToDiskCache$1 networkFetcher$writeToDiskCache$1;
        int i;
        DiskCache.Editor editor;
        try {
            if (continuation instanceof NetworkFetcher$writeToDiskCache$1) {
                networkFetcher$writeToDiskCache$1 = (NetworkFetcher$writeToDiskCache$1) continuation;
                if ((networkFetcher$writeToDiskCache$1.label & Integer.MIN_VALUE) != 0) {
                    networkFetcher$writeToDiskCache$1.label -= Integer.MIN_VALUE;
                    Object obj = networkFetcher$writeToDiskCache$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = networkFetcher$writeToDiskCache$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Throwable th = null;
                        if (!this.options.getDiskCachePolicy().getWriteEnabled()) {
                            if (snapshot != 0) {
                                Utils_commonKt.closeQuietly((AutoCloseable) snapshot);
                            }
                            return null;
                        }
                        if (snapshot != 0) {
                            snapshot = snapshot.closeAndOpenEditor();
                        } else {
                            DiskCache diskCache = (DiskCache) this.diskCache.getValue();
                            snapshot = diskCache != null ? diskCache.openEditor(getDiskCacheKey()) : 0;
                        }
                        if (snapshot == 0) {
                            return null;
                        }
                        if (networkResponse.getCode() == 304 && cacheResponse != null) {
                            BufferedSink bufferedSink = (Closeable) Okio.buffer(getFileSystem().sink(snapshot.getMetadata(), false));
                            try {
                                BufferedSink bufferedSink2 = bufferedSink;
                                NetworkHeaders.Builder newBuilder = networkResponse.getHeaders().newBuilder();
                                for (Map.Entry<String, List<String>> entry : cacheResponse.getResponseHeaders().asMap().entrySet()) {
                                    String key = entry.getKey();
                                    List<String> value = entry.getValue();
                                    if (networkResponse.getHeaders().get(key) == null) {
                                        newBuilder.set(key, value);
                                    }
                                }
                                new CacheResponse(networkResponse, newBuilder.build()).writeTo(bufferedSink2);
                                Unit unit = Unit.INSTANCE;
                                if (bufferedSink != null) {
                                    try {
                                        bufferedSink.close();
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                            } catch (Throwable th3) {
                                if (bufferedSink != null) {
                                    try {
                                        bufferedSink.close();
                                    } catch (Throwable th4) {
                                        ExceptionsKt.addSuppressed(th3, th4);
                                    }
                                }
                                th = th3;
                            }
                            if (th != null) {
                                throw th;
                            }
                            editor = snapshot;
                        } else {
                            BufferedSink bufferedSink3 = (Closeable) Okio.buffer(getFileSystem().sink(snapshot.getMetadata(), false));
                            try {
                                new CacheResponse(networkResponse, null, 2, null).writeTo(bufferedSink3);
                                Unit unit2 = Unit.INSTANCE;
                                if (bufferedSink3 != null) {
                                    try {
                                        bufferedSink3.close();
                                    } catch (Throwable th5) {
                                        th = th5;
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                if (bufferedSink3 != null) {
                                    try {
                                        bufferedSink3.close();
                                    } catch (Throwable th7) {
                                        ExceptionsKt.addSuppressed(th, th7);
                                    }
                                }
                            }
                            if (th == null) {
                                FileSystem fileSystem = getFileSystem();
                                Path data = snapshot.getData();
                                networkFetcher$writeToDiskCache$1.L$0 = networkResponseBody;
                                networkFetcher$writeToDiskCache$1.L$1 = snapshot;
                                networkFetcher$writeToDiskCache$1.label = 1;
                                editor = snapshot;
                                if (networkResponseBody.writeTo(fileSystem, data, networkFetcher$writeToDiskCache$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                throw th;
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        DiskCache.Editor editor2 = (DiskCache.Editor) networkFetcher$writeToDiskCache$1.L$1;
                        ResultKt.throwOnFailure(obj);
                        editor = editor2;
                    }
                    return editor.commitAndOpenSnapshot();
                }
            }
            if (i != 0) {
            }
            return editor.commitAndOpenSnapshot();
        } catch (Exception e) {
            Utils_commonKt.abortQuietly(snapshot);
            networkResponseBody.close();
            throw e;
        }
        networkFetcher$writeToDiskCache$1 = new NetworkFetcher$writeToDiskCache$1(this, continuation);
        Object obj2 = networkFetcher$writeToDiskCache$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = networkFetcher$writeToDiskCache$1.label;
    }

    private final NetworkRequest newRequest() {
        NetworkHeaders.Builder newBuilder = ImageRequestsKt.getHttpHeaders(this.options).newBuilder();
        boolean readEnabled = this.options.getDiskCachePolicy().getReadEnabled();
        boolean z = this.options.getNetworkCachePolicy().getReadEnabled() && this.connectivityChecker.isOnline();
        if (!z && readEnabled) {
            newBuilder.set(Utils_commonKt.CACHE_CONTROL, "only-if-cached, max-stale=2147483647");
        } else if (!z || readEnabled) {
            if (!z && !readEnabled) {
                newBuilder.set(Utils_commonKt.CACHE_CONTROL, "no-cache, only-if-cached");
            }
        } else if (this.options.getDiskCachePolicy().getWriteEnabled()) {
            newBuilder.set(Utils_commonKt.CACHE_CONTROL, "no-cache");
        } else {
            newBuilder.set(Utils_commonKt.CACHE_CONTROL, "no-cache, no-store");
        }
        return new NetworkRequest(this.url, ImageRequestsKt.getHttpMethod(this.options), newBuilder.build(), ImageRequestsKt.getHttpBody(this.options));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Object executeNetworkRequest(NetworkRequest networkRequest, Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        if (this.options.getNetworkCachePolicy().getReadEnabled()) {
            UtilsKt.assertNotOnMainThread();
        }
        return ((NetworkClient) this.networkClient.getValue()).executeRequest(networkRequest, new NetworkFetcher$executeNetworkRequest$2(function2, null), continuation);
    }

    public final String getMimeType(String url, String contentType) {
        String mimeTypeFromUrl;
        if ((contentType == null || StringsKt.startsWith$default(contentType, "text/plain", false, 2, (Object) null)) && (mimeTypeFromUrl = MimeTypeMap.INSTANCE.getMimeTypeFromUrl(url)) != null) {
            return mimeTypeFromUrl;
        }
        if (contentType != null) {
            return StringsKt.substringBefore$default(contentType, ';', (String) null, 2, (Object) null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CacheResponse toCacheResponse(DiskCache.Snapshot snapshot) {
        CacheResponse cacheResponse;
        Throwable th;
        try {
            BufferedSource bufferedSource = (Closeable) Okio.buffer(getFileSystem().source(snapshot.getMetadata()));
            try {
                cacheResponse = new CacheResponse(bufferedSource);
                if (bufferedSource != null) {
                    try {
                        bufferedSource.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                th = null;
            } catch (Throwable th3) {
                if (bufferedSource != null) {
                    try {
                        bufferedSource.close();
                    } catch (Throwable th4) {
                        ExceptionsKt.addSuppressed(th3, th4);
                    }
                }
                cacheResponse = null;
                th = th3;
            }
            if (th == null) {
                return cacheResponse;
            }
            throw th;
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageSource toImageSource(DiskCache.Snapshot snapshot) {
        return ImageSourceKt.ImageSource$default(snapshot.getData(), getFileSystem(), getDiskCacheKey(), snapshot, null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object toImageSource(NetworkResponseBody networkResponseBody, Continuation<? super ImageSource> continuation) {
        NetworkFetcher$toImageSource$1 networkFetcher$toImageSource$1;
        int i;
        NetworkFetcher networkFetcher;
        Buffer buffer;
        if (continuation instanceof NetworkFetcher$toImageSource$1) {
            networkFetcher$toImageSource$1 = (NetworkFetcher$toImageSource$1) continuation;
            if ((networkFetcher$toImageSource$1.label & Integer.MIN_VALUE) != 0) {
                networkFetcher$toImageSource$1.label -= Integer.MIN_VALUE;
                Object obj = networkFetcher$toImageSource$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = networkFetcher$toImageSource$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Buffer buffer2 = new Buffer();
                    networkFetcher$toImageSource$1.L$0 = this;
                    networkFetcher$toImageSource$1.L$1 = buffer2;
                    networkFetcher$toImageSource$1.label = 1;
                    if (networkResponseBody.writeTo((BufferedSink) buffer2, networkFetcher$toImageSource$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    networkFetcher = this;
                    buffer = buffer2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    buffer = (Buffer) networkFetcher$toImageSource$1.L$1;
                    networkFetcher = (NetworkFetcher) networkFetcher$toImageSource$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return ImageSourceKt.ImageSource$default((BufferedSource) buffer, networkFetcher.getFileSystem(), null, null, 12, null);
            }
        }
        networkFetcher$toImageSource$1 = new NetworkFetcher$toImageSource$1(this, continuation);
        Object obj2 = networkFetcher$toImageSource$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = networkFetcher$toImageSource$1.label;
        if (i != 0) {
        }
        return ImageSourceKt.ImageSource$default((BufferedSource) buffer, networkFetcher.getFileSystem(), null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageSource toImageSource(Buffer buffer) {
        return ImageSourceKt.ImageSource$default((BufferedSource) buffer, getFileSystem(), null, null, 12, null);
    }

    private final String getDiskCacheKey() {
        String diskCacheKey = this.options.getDiskCacheKey();
        return diskCacheKey == null ? this.url : diskCacheKey;
    }

    private final FileSystem getFileSystem() {
        FileSystem fileSystem;
        DiskCache diskCache = (DiskCache) this.diskCache.getValue();
        return (diskCache == null || (fileSystem = diskCache.getFileSystem()) == null) ? this.options.getFileSystem() : fileSystem;
    }

    /* compiled from: NetworkFetcher.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\n\u0012\u0004\u0012\u00020\f0\t¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0002H\u0002R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcoil3/network/NetworkFetcher$Factory;", "Lcoil3/fetch/Fetcher$Factory;", "Lcoil3/Uri;", "networkClient", "Lkotlin/Function0;", "Lcoil3/network/NetworkClient;", "cacheStrategy", "Lcoil3/network/CacheStrategy;", "connectivityChecker", "Lkotlin/Function1;", "Lcoil3/PlatformContext;", "Landroid/content/Context;", "Lcoil3/network/ConnectivityChecker;", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "networkClientLazy", "Lkotlin/Lazy;", "cacheStrategyLazy", "connectivityCheckerLazy", "Lcoil3/network/internal/SingleParameterLazy;", "create", "Lcoil3/fetch/Fetcher;", Constants.KEY_DATA, "options", "Lcoil3/request/Options;", "imageLoader", "Lcoil3/ImageLoader;", "isApplicable", "", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Factory implements Fetcher.Factory<Uri> {
        private final Lazy<CacheStrategy> cacheStrategyLazy;
        private final SingleParameterLazy<Context, ConnectivityChecker> connectivityCheckerLazy;
        private final Lazy<NetworkClient> networkClientLazy;

        public Factory(Function0<? extends NetworkClient> function0, Function0<? extends CacheStrategy> function02, Function1<? super Context, ? extends ConnectivityChecker> function1) {
            this.networkClientLazy = LazyKt.lazy(function0);
            this.cacheStrategyLazy = LazyKt.lazy(function02);
            this.connectivityCheckerLazy = SingleParameterLazyKt.singleParameterLazy(function1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: NetworkFetcher.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* renamed from: coil3.network.NetworkFetcher$Factory$1 */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
        public /* synthetic */ class C07221 extends FunctionReferenceImpl implements Function0<CacheStrategy> {
            public static final C07221 INSTANCE = new C07221();

            C07221() {
                super(0, CacheStrategyKt.class, "CacheStrategy", "CacheStrategy()Lcoil3/network/CacheStrategy;", 1);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final CacheStrategy m3249invoke() {
                return CacheStrategyKt.CacheStrategy();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: NetworkFetcher.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* renamed from: coil3.network.NetworkFetcher$Factory$2 */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
        public /* synthetic */ class C07232 extends FunctionReferenceImpl implements Function1<Context, ConnectivityChecker> {
            public static final C07232 INSTANCE = new C07232();

            C07232() {
                super(1, ConnectivityCheckerKt.class, "ConnectivityChecker", "ConnectivityChecker(Landroid/content/Context;)Lcoil3/network/ConnectivityChecker;", 1);
            }

            public final ConnectivityChecker invoke(Context context) {
                return ConnectivityCheckerKt.ConnectivityChecker(context);
            }
        }

        public /* synthetic */ Factory(Function0 function0, C07221 c07221, C07232 c07232, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(function0, (i & 2) != 0 ? C07221.INSTANCE : c07221, (i & 4) != 0 ? C07232.INSTANCE : c07232);
        }

        @Override // coil3.fetch.Fetcher.Factory
        public Fetcher create(Uri data, Options options, final ImageLoader imageLoader) {
            if (isApplicable(data)) {
                return new NetworkFetcher(data.getData(), options, this.networkClientLazy, LazyKt.lazy(new Function0() { // from class: coil3.network.NetworkFetcher$Factory$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        DiskCache diskCache;
                        diskCache = ImageLoader.this.getDiskCache();
                        return diskCache;
                    }
                }), this.cacheStrategyLazy, this.connectivityCheckerLazy.get(options.getContext()));
            }
            return null;
        }

        private final boolean isApplicable(Uri data) {
            return Intrinsics.areEqual(data.getScheme(), "http") || Intrinsics.areEqual(data.getScheme(), ProxyConfig.MATCH_HTTPS);
        }
    }
}
