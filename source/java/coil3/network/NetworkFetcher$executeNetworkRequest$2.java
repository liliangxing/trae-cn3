package coil3.network;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: NetworkFetcher.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "response", "Lcoil3/network/NetworkResponse;", "Lkotlin/ParameterName;", StrategyConstants.NAME}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.NetworkFetcher$executeNetworkRequest$2", f = "NetworkFetcher.kt", i = {}, l = {HttpStatus.SC_RESET_CONTENT}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class NetworkFetcher$executeNetworkRequest$2<T> extends SuspendLambda implements Function2<NetworkResponse, Continuation<? super T>, Object> {
    final /* synthetic */ Function2<NetworkResponse, Continuation<? super T>, Object> $block;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NetworkFetcher$executeNetworkRequest$2(Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super NetworkFetcher$executeNetworkRequest$2> continuation) {
        super(2, continuation);
        this.$block = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> networkFetcher$executeNetworkRequest$2 = new NetworkFetcher$executeNetworkRequest$2<>(this.$block, continuation);
        networkFetcher$executeNetworkRequest$2.L$0 = obj;
        return networkFetcher$executeNetworkRequest$2;
    }

    public final Object invoke(NetworkResponse networkResponse, Continuation<? super T> continuation) {
        return create(networkResponse, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            NetworkResponse networkResponse = (NetworkResponse) this.L$0;
            int code = networkResponse.getCode();
            boolean z = false;
            if (200 <= code && code < 300) {
                z = true;
            }
            if (!z && networkResponse.getCode() != 304) {
                throw new HttpException(networkResponse);
            }
            Function2<NetworkResponse, Continuation<? super T>, Object> function2 = this.$block;
            this.label = 1;
            obj = function2.invoke(networkResponse, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
