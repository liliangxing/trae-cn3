package coil3.network;

import coil3.decode.DataSource;
import coil3.decode.ImageSource;
import coil3.fetch.SourceFetchResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkFetcher.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcoil3/fetch/SourceFetchResult;", "response", "Lcoil3/network/NetworkResponse;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.NetworkFetcher$fetch$2", f = "NetworkFetcher.kt", i = {0}, l = {90}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class NetworkFetcher$fetch$2 extends SuspendLambda implements Function2<NetworkResponse, Continuation<? super SourceFetchResult>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NetworkFetcher this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkFetcher$fetch$2(NetworkFetcher networkFetcher, Continuation<? super NetworkFetcher$fetch$2> continuation) {
        super(2, continuation);
        this.this$0 = networkFetcher;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> networkFetcher$fetch$2 = new NetworkFetcher$fetch$2(this.this$0, continuation);
        networkFetcher$fetch$2.L$0 = obj;
        return networkFetcher$fetch$2;
    }

    public final Object invoke(NetworkResponse networkResponse, Continuation<? super SourceFetchResult> continuation) {
        return create(networkResponse, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object imageSource;
        NetworkResponse networkResponse;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            NetworkResponse networkResponse2 = (NetworkResponse) this.L$0;
            NetworkFetcher networkFetcher = this.this$0;
            NetworkResponseBody body = networkResponse2.getBody();
            if (body != null) {
                this.L$0 = networkResponse2;
                this.label = 1;
                imageSource = networkFetcher.toImageSource(body, (Continuation) this);
                if (imageSource == coroutine_suspended) {
                    return coroutine_suspended;
                }
                networkResponse = networkResponse2;
                obj = imageSource;
            } else {
                throw new IllegalStateException("body == null".toString());
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            networkResponse = (NetworkResponse) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        NetworkFetcher networkFetcher2 = this.this$0;
        str = networkFetcher2.url;
        return new SourceFetchResult((ImageSource) obj, networkFetcher2.getMimeType(str, networkResponse.getHeaders().get("Content-Type")), DataSource.NETWORK);
    }
}
