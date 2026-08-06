package coil3.network;

import coil3.network.NetworkHeaders;
import coil3.network.internal.Utils_commonKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.BufferedSink;
import okio.BufferedSource;

/* compiled from: CacheResponse.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\nJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcoil3/network/CacheResponse;", "", "source", "Lokio/BufferedSource;", "<init>", "(Lokio/BufferedSource;)V", "response", "Lcoil3/network/NetworkResponse;", "headers", "Lcoil3/network/NetworkHeaders;", "(Lcoil3/network/NetworkResponse;Lcoil3/network/NetworkHeaders;)V", "sentRequestAtMillis", "", "getSentRequestAtMillis", "()J", "receivedResponseAtMillis", "getReceivedResponseAtMillis", "responseHeaders", "getResponseHeaders", "()Lcoil3/network/NetworkHeaders;", "writeTo", "", "sink", "Lokio/BufferedSink;", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class CacheResponse {
    private final long receivedResponseAtMillis;
    private final NetworkHeaders responseHeaders;
    private final long sentRequestAtMillis;

    public final long getSentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public final long getReceivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    public final NetworkHeaders getResponseHeaders() {
        return this.responseHeaders;
    }

    public CacheResponse(BufferedSource bufferedSource) {
        this.sentRequestAtMillis = Long.parseLong(bufferedSource.readUtf8LineStrict());
        this.receivedResponseAtMillis = Long.parseLong(bufferedSource.readUtf8LineStrict());
        NetworkHeaders.Builder builder = new NetworkHeaders.Builder();
        int parseInt = Integer.parseInt(bufferedSource.readUtf8LineStrict());
        for (int i = 0; i < parseInt; i++) {
            Utils_commonKt.append(builder, bufferedSource.readUtf8LineStrict());
        }
        this.responseHeaders = builder.build();
    }

    public CacheResponse(NetworkResponse networkResponse, NetworkHeaders networkHeaders) {
        this.sentRequestAtMillis = networkResponse.getRequestMillis();
        this.receivedResponseAtMillis = networkResponse.getResponseMillis();
        this.responseHeaders = networkHeaders;
    }

    public /* synthetic */ CacheResponse(NetworkResponse networkResponse, NetworkHeaders networkHeaders, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(networkResponse, (i & 2) != 0 ? networkResponse.getHeaders() : networkHeaders);
    }

    public final void writeTo(BufferedSink sink) {
        sink.writeDecimalLong(this.sentRequestAtMillis).writeByte(10);
        sink.writeDecimalLong(this.receivedResponseAtMillis).writeByte(10);
        Set<Map.Entry<String, List<String>>> entrySet = this.responseHeaders.asMap().entrySet();
        Iterator<T> it = entrySet.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((List) ((Map.Entry) it.next()).getValue()).size();
        }
        sink.writeDecimalLong(i).writeByte(10);
        for (Map.Entry<String, List<String>> entry : entrySet) {
            Iterator<String> it2 = entry.getValue().iterator();
            while (it2.hasNext()) {
                sink.writeUtf8(entry.getKey()).writeUtf8(":").writeUtf8(it2.next()).writeByte(10);
            }
        }
    }
}
