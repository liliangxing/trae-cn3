package coil3.network;

import coil3.decode.DataSource;
import coil3.decode.ImageSource;
import coil3.disk.DiskCache;
import coil3.fetch.SourceFetchResult;
import coil3.network.CacheStrategy;
import coil3.network.internal.Utils_commonKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okio.Buffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkFetcher.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcoil3/fetch/SourceFetchResult;", "response", "Lcoil3/network/NetworkResponse;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.NetworkFetcher$fetch$result$1", f = "NetworkFetcher.kt", i = {0, 0, 1}, l = {62, 73}, m = "invokeSuspend", n = {"response", "responseBody", "response"}, s = {"L$0", "L$1", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class NetworkFetcher$fetch$result$1 extends SuspendLambda implements Function2<NetworkResponse, Continuation<? super SourceFetchResult>, Object> {
    final /* synthetic */ Ref.ObjectRef<CacheStrategy.Output> $output;
    final /* synthetic */ Ref.ObjectRef<DiskCache.Snapshot> $snapshot;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ NetworkFetcher this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkFetcher$fetch$result$1(Ref.ObjectRef<DiskCache.Snapshot> objectRef, NetworkFetcher networkFetcher, Ref.ObjectRef<CacheStrategy.Output> objectRef2, Continuation<? super NetworkFetcher$fetch$result$1> continuation) {
        super(2, continuation);
        this.$snapshot = objectRef;
        this.this$0 = networkFetcher;
        this.$output = objectRef2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> networkFetcher$fetch$result$1 = new NetworkFetcher$fetch$result$1(this.$snapshot, this.this$0, this.$output, continuation);
        networkFetcher$fetch$result$1.L$0 = obj;
        return networkFetcher$fetch$result$1;
    }

    public final Object invoke(NetworkResponse networkResponse, Continuation<? super SourceFetchResult> continuation) {
        return create(networkResponse, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00f0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object writeToDiskCache;
        NetworkResponse networkResponse;
        NetworkResponseBody networkResponseBody;
        Ref.ObjectRef<DiskCache.Snapshot> objectRef;
        NetworkResponse networkResponse2;
        CacheResponse cacheResponse;
        ImageSource imageSource;
        String str;
        NetworkHeaders responseHeaders;
        Buffer buffer;
        ImageSource imageSource2;
        String str2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        String str3 = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            NetworkResponse networkResponse3 = (NetworkResponse) this.L$0;
            NetworkResponseBody body = networkResponse3.getBody();
            if (body == null) {
                throw new IllegalStateException("body == null".toString());
            }
            Ref.ObjectRef<DiskCache.Snapshot> objectRef2 = this.$snapshot;
            NetworkFetcher networkFetcher = this.this$0;
            DiskCache.Snapshot snapshot = (DiskCache.Snapshot) objectRef2.element;
            CacheStrategy.Output output = (CacheStrategy.Output) this.$output.element;
            CacheResponse cacheResponse2 = output != null ? output.getCacheResponse() : null;
            this.L$0 = networkResponse3;
            this.L$1 = body;
            this.L$2 = objectRef2;
            this.label = 1;
            writeToDiskCache = networkFetcher.writeToDiskCache(snapshot, cacheResponse2, networkResponse3, body, (Continuation) this);
            if (writeToDiskCache == coroutine_suspended) {
                return coroutine_suspended;
            }
            networkResponse = networkResponse3;
            obj = writeToDiskCache;
            networkResponseBody = body;
            objectRef = objectRef2;
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                networkResponse2 = (NetworkResponse) this.L$0;
                ResultKt.throwOnFailure(obj);
                buffer = (Buffer) obj;
                if (buffer.size() > 0) {
                    return null;
                }
                imageSource2 = this.this$0.toImageSource(buffer);
                NetworkFetcher networkFetcher2 = this.this$0;
                str2 = networkFetcher2.url;
                return new SourceFetchResult(imageSource2, networkFetcher2.getMimeType(str2, networkResponse2.getHeaders().get("Content-Type")), DataSource.NETWORK);
            }
            objectRef = (Ref.ObjectRef) this.L$2;
            networkResponseBody = (NetworkResponseBody) this.L$1;
            networkResponse = (NetworkResponse) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        objectRef.element = obj;
        if (this.$snapshot.element != null) {
            NetworkFetcher networkFetcher3 = this.this$0;
            Object obj2 = this.$snapshot.element;
            Intrinsics.checkNotNull(obj2);
            cacheResponse = networkFetcher3.toCacheResponse((DiskCache.Snapshot) obj2);
            NetworkFetcher networkFetcher4 = this.this$0;
            Object obj3 = this.$snapshot.element;
            Intrinsics.checkNotNull(obj3);
            imageSource = networkFetcher4.toImageSource((DiskCache.Snapshot) obj3);
            NetworkFetcher networkFetcher5 = this.this$0;
            str = networkFetcher5.url;
            if (cacheResponse != null && (responseHeaders = cacheResponse.getResponseHeaders()) != null) {
                str3 = responseHeaders.get("Content-Type");
            }
            return new SourceFetchResult(imageSource, networkFetcher5.getMimeType(str, str3), DataSource.NETWORK);
        }
        this.L$0 = networkResponse;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 2;
        obj = Utils_commonKt.readBuffer(networkResponseBody, (Continuation) this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        networkResponse2 = networkResponse;
        buffer = (Buffer) obj;
        if (buffer.size() > 0) {
        }
    }
}
