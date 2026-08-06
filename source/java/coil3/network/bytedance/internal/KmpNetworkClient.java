package coil3.network.bytedance.internal;

import androidx.exifinterface.media.ExifInterface;
import coil3.network.NetworkClient;
import coil3.network.NetworkHeaders;
import coil3.network.NetworkRequest;
import coil3.network.NetworkRequestBody;
import coil3.network.NetworkResponse;
import coil3.network.NetworkResponseBody;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.kmp.network.Header;
import com.bytedance.kmp.network.KmpNetworkManager;
import com.bytedance.kmp.network.requet.Request;
import com.bytedance.kmp.network.requet.RequestBody;
import com.bytedance.kmp.network.requet.RequestContext;
import com.bytedance.kmp.network.response.Response;
import com.bytedance.kmp.network.response.ResponseBody;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.datetime.Clock;
import okio.Buffer;
import okio.BufferedSink;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Source;

/* compiled from: utils.common.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JO\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\n21\u0010\u000b\u001a-\b\u0001\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\fH\u0096@¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcoil3/network/bytedance/internal/KmpNetworkClient;", "Lcoil3/network/NetworkClient;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "executeRequest", ExifInterface.GPS_DIRECTION_TRUE, "request", "Lcoil3/network/NetworkRequest;", "block", "Lkotlin/Function2;", "Lcoil3/network/NetworkResponse;", "Lkotlin/ParameterName;", StrategyConstants.NAME, "response", "Lkotlin/coroutines/Continuation;", "", "(Lcoil3/network/NetworkRequest;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readByteArray", "", "Lcoil3/network/NetworkRequestBody;", "(Lcoil3/network/NetworkRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil_network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class KmpNetworkClient implements NetworkClient {
    private final String TAG = "KmpNetworkClient";

    public final String getTAG() {
        return this.TAG;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x01d9 A[PHI: r0
      0x01d9: PHI (r0v24 java.lang.Object) = (r0v22 java.lang.Object), (r0v1 java.lang.Object) binds: [B:30:0x01d6, B:12:0x0035] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x017a A[LOOP:0: B:20:0x0174->B:22:0x017a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01d8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0164 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009d A[LOOP:2: B:54:0x0097->B:56:0x009d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    @Override // coil3.network.NetworkClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object executeRequest(NetworkRequest networkRequest, Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        KmpNetworkClient$executeRequest$1 kmpNetworkClient$executeRequest$1;
        int i;
        Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function22;
        Object allInterceptors;
        Ref.ObjectRef objectRef;
        Iterator<T> it;
        NetworkRequestBody body;
        Ref.ObjectRef objectRef2;
        final byte[] bArr;
        Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function23;
        Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function24;
        Ref.ObjectRef objectRef3;
        long epochMilliseconds;
        final Source byteStream;
        if (continuation instanceof KmpNetworkClient$executeRequest$1) {
            kmpNetworkClient$executeRequest$1 = (KmpNetworkClient$executeRequest$1) continuation;
            if ((kmpNetworkClient$executeRequest$1.label & Integer.MIN_VALUE) != 0) {
                kmpNetworkClient$executeRequest$1.label -= Integer.MIN_VALUE;
                KmpNetworkClient$executeRequest$1 kmpNetworkClient$executeRequest$12 = kmpNetworkClient$executeRequest$1;
                Object obj = kmpNetworkClient$executeRequest$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = kmpNetworkClient$executeRequest$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
                    objectRef4.element = networkRequest;
                    function22 = function2;
                    kmpNetworkClient$executeRequest$12.L$0 = function22;
                    kmpNetworkClient$executeRequest$12.L$1 = objectRef4;
                    kmpNetworkClient$executeRequest$12.label = 1;
                    allInterceptors = Utils_commonKt.getAllInterceptors(kmpNetworkClient$executeRequest$12);
                    if (allInterceptors == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef4;
                    obj = allInterceptors;
                } else if (i == 1) {
                    Ref.ObjectRef objectRef5 = (Ref.ObjectRef) kmpNetworkClient$executeRequest$12.L$1;
                    Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function25 = (Function2) kmpNetworkClient$executeRequest$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    objectRef = objectRef5;
                    function22 = function25;
                } else {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                ResultKt.throwOnFailure(obj);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        long j = kmpNetworkClient$executeRequest$12.J$0;
                        objectRef2 = (Ref.ObjectRef) kmpNetworkClient$executeRequest$12.L$1;
                        function23 = (Function2) kmpNetworkClient$executeRequest$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        epochMilliseconds = j;
                        Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function26 = function23;
                        Response response = (Response) obj;
                        NetworkHeaders.Builder builder = new NetworkHeaders.Builder();
                        for (Header header : response.getHeaders()) {
                            builder.set(header.getName(), header.getValue());
                        }
                        NetworkRequest networkRequest2 = (NetworkRequest) objectRef2.element;
                        int code = response.getCode();
                        long epochMilliseconds2 = Clock.System.INSTANCE.now().toEpochMilliseconds();
                        NetworkHeaders build = builder.build();
                        ResponseBody body2 = response.getBody();
                        NetworkResponse networkResponse = new NetworkResponse(networkRequest2, code, epochMilliseconds, epochMilliseconds2, build, (body2 != null || (byteStream = body2.byteStream()) == null) ? null : new NetworkResponseBody() { // from class: coil3.network.bytedance.internal.KmpNetworkClient$executeRequest$3$1
                            @Override // coil3.network.NetworkResponseBody
                            public Object writeTo(BufferedSink bufferedSink, Continuation<? super Unit> continuation2) {
                                Buffer buffer = new Buffer();
                                while (true) {
                                    long read = byteStream.read(buffer, 1024L);
                                    if (read != -1) {
                                        bufferedSink.write(buffer, read);
                                    } else {
                                        bufferedSink.flush();
                                        return Unit.INSTANCE;
                                    }
                                }
                            }

                            @Override // coil3.network.NetworkResponseBody
                            public Object writeTo(FileSystem fileSystem, Path path, Continuation<? super Unit> continuation2) {
                                Throwable th;
                                Source source = byteStream;
                                BufferedSink bufferedSink = (Closeable) Okio.buffer(fileSystem.sink(path, false));
                                try {
                                    BufferedSink bufferedSink2 = bufferedSink;
                                    Buffer buffer = new Buffer();
                                    while (true) {
                                        long read = source.read(buffer, 1024L);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedSink2.write(buffer, read);
                                    }
                                    bufferedSink2.flush();
                                    Unit unit = Unit.INSTANCE;
                                    if (bufferedSink != null) {
                                        try {
                                            bufferedSink.close();
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    }
                                    th = null;
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
                                if (th == null) {
                                    return Unit.INSTANCE;
                                }
                                throw th;
                            }

                            @Override // java.lang.AutoCloseable
                            public void close() {
                                byteStream.close();
                            }
                        }, this);
                        kmpNetworkClient$executeRequest$12.L$0 = null;
                        kmpNetworkClient$executeRequest$12.L$1 = null;
                        kmpNetworkClient$executeRequest$12.label = 4;
                        obj = function26.invoke(networkResponse, kmpNetworkClient$executeRequest$12);
                        return obj != coroutine_suspended ? coroutine_suspended : obj;
                    }
                    objectRef3 = (Ref.ObjectRef) kmpNetworkClient$executeRequest$12.L$1;
                    function24 = (Function2) kmpNetworkClient$executeRequest$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    bArr = (byte[]) obj;
                    function23 = function24;
                    objectRef2 = objectRef3;
                    Map<String, List<String>> asMap = ((NetworkRequest) objectRef2.element).getHeaders().asMap();
                    ArrayList arrayList = new ArrayList(asMap.size());
                    for (Map.Entry<String, List<String>> entry : asMap.entrySet()) {
                        String key = entry.getKey();
                        String str = (String) CollectionsKt.firstOrNull(entry.getValue());
                        if (str == null) {
                            str = "";
                        }
                        arrayList.add(TuplesKt.to(key, str));
                    }
                    Request request = new Request(((NetworkRequest) objectRef2.element).getUrl(), ((NetworkRequest) objectRef2.element).getMethod(), MapsKt.toMutableMap(MapsKt.toMap(arrayList)), bArr == null ? null : new RequestBody() { // from class: coil3.network.bytedance.internal.KmpNetworkClient$executeRequest$kmpRequest$1
                        public String contentType() {
                            return null;
                        }

                        public void writeTo(BufferedSink sink) {
                            if (sink != null) {
                                sink.write(bArr);
                            }
                            if (sink != null) {
                                sink.flush();
                            }
                        }
                    }, new RequestContext());
                    epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds();
                    KmpNetworkManager kmpNetworkManager = KmpNetworkManager.INSTANCE;
                    kmpNetworkClient$executeRequest$12.L$0 = function23;
                    kmpNetworkClient$executeRequest$12.L$1 = objectRef2;
                    kmpNetworkClient$executeRequest$12.J$0 = epochMilliseconds;
                    kmpNetworkClient$executeRequest$12.label = 3;
                    obj = kmpNetworkManager.execute(request, kmpNetworkClient$executeRequest$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function262 = function23;
                    Response response2 = (Response) obj;
                    NetworkHeaders.Builder builder2 = new NetworkHeaders.Builder();
                    while (r2.hasNext()) {
                    }
                    NetworkRequest networkRequest22 = (NetworkRequest) objectRef2.element;
                    int code2 = response2.getCode();
                    long epochMilliseconds22 = Clock.System.INSTANCE.now().toEpochMilliseconds();
                    NetworkHeaders build2 = builder2.build();
                    ResponseBody body22 = response2.getBody();
                    NetworkResponse networkResponse2 = new NetworkResponse(networkRequest22, code2, epochMilliseconds, epochMilliseconds22, build2, (body22 != null || (byteStream = body22.byteStream()) == null) ? null : new NetworkResponseBody() { // from class: coil3.network.bytedance.internal.KmpNetworkClient$executeRequest$3$1
                        @Override // coil3.network.NetworkResponseBody
                        public Object writeTo(BufferedSink bufferedSink, Continuation<? super Unit> continuation2) {
                            Buffer buffer = new Buffer();
                            while (true) {
                                long read = byteStream.read(buffer, 1024L);
                                if (read != -1) {
                                    bufferedSink.write(buffer, read);
                                } else {
                                    bufferedSink.flush();
                                    return Unit.INSTANCE;
                                }
                            }
                        }

                        @Override // coil3.network.NetworkResponseBody
                        public Object writeTo(FileSystem fileSystem, Path path, Continuation<? super Unit> continuation2) {
                            Throwable th;
                            Source source = byteStream;
                            BufferedSink bufferedSink = (Closeable) Okio.buffer(fileSystem.sink(path, false));
                            try {
                                BufferedSink bufferedSink2 = bufferedSink;
                                Buffer buffer = new Buffer();
                                while (true) {
                                    long read = source.read(buffer, 1024L);
                                    if (read == -1) {
                                        break;
                                    }
                                    bufferedSink2.write(buffer, read);
                                }
                                bufferedSink2.flush();
                                Unit unit = Unit.INSTANCE;
                                if (bufferedSink != null) {
                                    try {
                                        bufferedSink.close();
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                                th = null;
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
                            if (th == null) {
                                return Unit.INSTANCE;
                            }
                            throw th;
                        }

                        @Override // java.lang.AutoCloseable
                        public void close() {
                            byteStream.close();
                        }
                    }, this);
                    kmpNetworkClient$executeRequest$12.L$0 = null;
                    kmpNetworkClient$executeRequest$12.L$1 = null;
                    kmpNetworkClient$executeRequest$12.label = 4;
                    obj = function262.invoke(networkResponse2, kmpNetworkClient$executeRequest$12);
                    if (obj != coroutine_suspended) {
                    }
                }
                it = ((Iterable) obj).iterator();
                while (it.hasNext()) {
                    objectRef.element = ((CoilInterceptor) it.next()).interceptorRequest((NetworkRequest) objectRef.element);
                }
                body = ((NetworkRequest) objectRef.element).getBody();
                if (body == null) {
                    kmpNetworkClient$executeRequest$12.L$0 = function22;
                    kmpNetworkClient$executeRequest$12.L$1 = objectRef;
                    kmpNetworkClient$executeRequest$12.label = 2;
                    obj = readByteArray(body, kmpNetworkClient$executeRequest$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function24 = function22;
                    objectRef3 = objectRef;
                    bArr = (byte[]) obj;
                    function23 = function24;
                    objectRef2 = objectRef3;
                    Map<String, List<String>> asMap2 = ((NetworkRequest) objectRef2.element).getHeaders().asMap();
                    ArrayList arrayList2 = new ArrayList(asMap2.size());
                    while (r1.hasNext()) {
                    }
                    Request request2 = new Request(((NetworkRequest) objectRef2.element).getUrl(), ((NetworkRequest) objectRef2.element).getMethod(), MapsKt.toMutableMap(MapsKt.toMap(arrayList2)), bArr == null ? null : new RequestBody() { // from class: coil3.network.bytedance.internal.KmpNetworkClient$executeRequest$kmpRequest$1
                        public String contentType() {
                            return null;
                        }

                        public void writeTo(BufferedSink sink) {
                            if (sink != null) {
                                sink.write(bArr);
                            }
                            if (sink != null) {
                                sink.flush();
                            }
                        }
                    }, new RequestContext());
                    epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds();
                    KmpNetworkManager kmpNetworkManager2 = KmpNetworkManager.INSTANCE;
                    kmpNetworkClient$executeRequest$12.L$0 = function23;
                    kmpNetworkClient$executeRequest$12.L$1 = objectRef2;
                    kmpNetworkClient$executeRequest$12.J$0 = epochMilliseconds;
                    kmpNetworkClient$executeRequest$12.label = 3;
                    obj = kmpNetworkManager2.execute(request2, kmpNetworkClient$executeRequest$12);
                    if (obj == coroutine_suspended) {
                    }
                    Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function2622 = function23;
                    Response response22 = (Response) obj;
                    NetworkHeaders.Builder builder22 = new NetworkHeaders.Builder();
                    while (r2.hasNext()) {
                    }
                    NetworkRequest networkRequest222 = (NetworkRequest) objectRef2.element;
                    int code22 = response22.getCode();
                    long epochMilliseconds222 = Clock.System.INSTANCE.now().toEpochMilliseconds();
                    NetworkHeaders build22 = builder22.build();
                    ResponseBody body222 = response22.getBody();
                    NetworkResponse networkResponse22 = new NetworkResponse(networkRequest222, code22, epochMilliseconds, epochMilliseconds222, build22, (body222 != null || (byteStream = body222.byteStream()) == null) ? null : new NetworkResponseBody() { // from class: coil3.network.bytedance.internal.KmpNetworkClient$executeRequest$3$1
                        @Override // coil3.network.NetworkResponseBody
                        public Object writeTo(BufferedSink bufferedSink, Continuation<? super Unit> continuation2) {
                            Buffer buffer = new Buffer();
                            while (true) {
                                long read = byteStream.read(buffer, 1024L);
                                if (read != -1) {
                                    bufferedSink.write(buffer, read);
                                } else {
                                    bufferedSink.flush();
                                    return Unit.INSTANCE;
                                }
                            }
                        }

                        @Override // coil3.network.NetworkResponseBody
                        public Object writeTo(FileSystem fileSystem, Path path, Continuation<? super Unit> continuation2) {
                            Throwable th;
                            Source source = byteStream;
                            BufferedSink bufferedSink = (Closeable) Okio.buffer(fileSystem.sink(path, false));
                            try {
                                BufferedSink bufferedSink2 = bufferedSink;
                                Buffer buffer = new Buffer();
                                while (true) {
                                    long read = source.read(buffer, 1024L);
                                    if (read == -1) {
                                        break;
                                    }
                                    bufferedSink2.write(buffer, read);
                                }
                                bufferedSink2.flush();
                                Unit unit = Unit.INSTANCE;
                                if (bufferedSink != null) {
                                    try {
                                        bufferedSink.close();
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                                th = null;
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
                            if (th == null) {
                                return Unit.INSTANCE;
                            }
                            throw th;
                        }

                        @Override // java.lang.AutoCloseable
                        public void close() {
                            byteStream.close();
                        }
                    }, this);
                    kmpNetworkClient$executeRequest$12.L$0 = null;
                    kmpNetworkClient$executeRequest$12.L$1 = null;
                    kmpNetworkClient$executeRequest$12.label = 4;
                    obj = function2622.invoke(networkResponse22, kmpNetworkClient$executeRequest$12);
                    if (obj != coroutine_suspended) {
                    }
                } else {
                    objectRef2 = objectRef;
                    bArr = null;
                    function23 = function22;
                    Map<String, List<String>> asMap22 = ((NetworkRequest) objectRef2.element).getHeaders().asMap();
                    ArrayList arrayList22 = new ArrayList(asMap22.size());
                    while (r1.hasNext()) {
                    }
                    Request request22 = new Request(((NetworkRequest) objectRef2.element).getUrl(), ((NetworkRequest) objectRef2.element).getMethod(), MapsKt.toMutableMap(MapsKt.toMap(arrayList22)), bArr == null ? null : new RequestBody() { // from class: coil3.network.bytedance.internal.KmpNetworkClient$executeRequest$kmpRequest$1
                        public String contentType() {
                            return null;
                        }

                        public void writeTo(BufferedSink sink) {
                            if (sink != null) {
                                sink.write(bArr);
                            }
                            if (sink != null) {
                                sink.flush();
                            }
                        }
                    }, new RequestContext());
                    epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds();
                    KmpNetworkManager kmpNetworkManager22 = KmpNetworkManager.INSTANCE;
                    kmpNetworkClient$executeRequest$12.L$0 = function23;
                    kmpNetworkClient$executeRequest$12.L$1 = objectRef2;
                    kmpNetworkClient$executeRequest$12.J$0 = epochMilliseconds;
                    kmpNetworkClient$executeRequest$12.label = 3;
                    obj = kmpNetworkManager22.execute(request22, kmpNetworkClient$executeRequest$12);
                    if (obj == coroutine_suspended) {
                    }
                    Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function26222 = function23;
                    Response response222 = (Response) obj;
                    NetworkHeaders.Builder builder222 = new NetworkHeaders.Builder();
                    while (r2.hasNext()) {
                    }
                    NetworkRequest networkRequest2222 = (NetworkRequest) objectRef2.element;
                    int code222 = response222.getCode();
                    long epochMilliseconds2222 = Clock.System.INSTANCE.now().toEpochMilliseconds();
                    NetworkHeaders build222 = builder222.build();
                    ResponseBody body2222 = response222.getBody();
                    NetworkResponse networkResponse222 = new NetworkResponse(networkRequest2222, code222, epochMilliseconds, epochMilliseconds2222, build222, (body2222 != null || (byteStream = body2222.byteStream()) == null) ? null : new NetworkResponseBody() { // from class: coil3.network.bytedance.internal.KmpNetworkClient$executeRequest$3$1
                        @Override // coil3.network.NetworkResponseBody
                        public Object writeTo(BufferedSink bufferedSink, Continuation<? super Unit> continuation2) {
                            Buffer buffer = new Buffer();
                            while (true) {
                                long read = byteStream.read(buffer, 1024L);
                                if (read != -1) {
                                    bufferedSink.write(buffer, read);
                                } else {
                                    bufferedSink.flush();
                                    return Unit.INSTANCE;
                                }
                            }
                        }

                        @Override // coil3.network.NetworkResponseBody
                        public Object writeTo(FileSystem fileSystem, Path path, Continuation<? super Unit> continuation2) {
                            Throwable th;
                            Source source = byteStream;
                            BufferedSink bufferedSink = (Closeable) Okio.buffer(fileSystem.sink(path, false));
                            try {
                                BufferedSink bufferedSink2 = bufferedSink;
                                Buffer buffer = new Buffer();
                                while (true) {
                                    long read = source.read(buffer, 1024L);
                                    if (read == -1) {
                                        break;
                                    }
                                    bufferedSink2.write(buffer, read);
                                }
                                bufferedSink2.flush();
                                Unit unit = Unit.INSTANCE;
                                if (bufferedSink != null) {
                                    try {
                                        bufferedSink.close();
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                                th = null;
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
                            if (th == null) {
                                return Unit.INSTANCE;
                            }
                            throw th;
                        }

                        @Override // java.lang.AutoCloseable
                        public void close() {
                            byteStream.close();
                        }
                    }, this);
                    kmpNetworkClient$executeRequest$12.L$0 = null;
                    kmpNetworkClient$executeRequest$12.L$1 = null;
                    kmpNetworkClient$executeRequest$12.label = 4;
                    obj = function26222.invoke(networkResponse222, kmpNetworkClient$executeRequest$12);
                    if (obj != coroutine_suspended) {
                    }
                }
            }
        }
        kmpNetworkClient$executeRequest$1 = new KmpNetworkClient$executeRequest$1(this, continuation);
        KmpNetworkClient$executeRequest$1 kmpNetworkClient$executeRequest$122 = kmpNetworkClient$executeRequest$1;
        Object obj2 = kmpNetworkClient$executeRequest$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = kmpNetworkClient$executeRequest$122.label;
        if (i != 0) {
        }
        it = ((Iterable) obj2).iterator();
        while (it.hasNext()) {
        }
        body = ((NetworkRequest) objectRef.element).getBody();
        if (body == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readByteArray(NetworkRequestBody networkRequestBody, Continuation<? super byte[]> continuation) {
        KmpNetworkClient$readByteArray$1 kmpNetworkClient$readByteArray$1;
        int i;
        Buffer buffer;
        if (continuation instanceof KmpNetworkClient$readByteArray$1) {
            kmpNetworkClient$readByteArray$1 = (KmpNetworkClient$readByteArray$1) continuation;
            if ((kmpNetworkClient$readByteArray$1.label & Integer.MIN_VALUE) != 0) {
                kmpNetworkClient$readByteArray$1.label -= Integer.MIN_VALUE;
                Object obj = kmpNetworkClient$readByteArray$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = kmpNetworkClient$readByteArray$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Buffer buffer2 = new Buffer();
                    kmpNetworkClient$readByteArray$1.L$0 = buffer2;
                    kmpNetworkClient$readByteArray$1.label = 1;
                    if (networkRequestBody.writeTo((BufferedSink) buffer2, kmpNetworkClient$readByteArray$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    buffer = buffer2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    buffer = (Buffer) kmpNetworkClient$readByteArray$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return buffer.readByteArray();
            }
        }
        kmpNetworkClient$readByteArray$1 = new KmpNetworkClient$readByteArray$1(this, continuation);
        Object obj2 = kmpNetworkClient$readByteArray$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = kmpNetworkClient$readByteArray$1.label;
        if (i != 0) {
        }
        return buffer.readByteArray();
    }
}
