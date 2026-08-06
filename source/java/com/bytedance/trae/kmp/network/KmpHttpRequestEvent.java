package com.bytedance.trae.kmp.network;

import com.bytedance.forest.model.PreloadConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpHttpEventReporter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003JG\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tHÇ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001d\u001a\u00020\u001eH×\u0001J\t\u0010\u001f\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;", "", "path", "", "costTimeMs", "", "code", "message", "headers", "", "<init>", "(Ljava/lang/String;JJLjava/lang/String;Ljava/util/Map;)V", "getPath", "()Ljava/lang/String;", "getCostTimeMs", "()J", "getCode", "getMessage", "getHeaders", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class KmpHttpRequestEvent {
    public static final int $stable = 8;
    private final long code;
    private final long costTimeMs;
    private final Map<String, String> headers;
    private final String message;
    private final String path;

    public static /* synthetic */ KmpHttpRequestEvent copy$default(KmpHttpRequestEvent kmpHttpRequestEvent, String str, long j, long j2, String str2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = kmpHttpRequestEvent.path;
        }
        if ((i & 2) != 0) {
            j = kmpHttpRequestEvent.costTimeMs;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = kmpHttpRequestEvent.code;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            str2 = kmpHttpRequestEvent.message;
        }
        String str3 = str2;
        if ((i & 16) != 0) {
            map = kmpHttpRequestEvent.headers;
        }
        return kmpHttpRequestEvent.copy(str, j3, j4, str3, map);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCostTimeMs() {
        return this.costTimeMs;
    }

    /* renamed from: component3, reason: from getter */
    public final long getCode() {
        return this.code;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final Map<String, String> component5() {
        return this.headers;
    }

    public final KmpHttpRequestEvent copy(String path, long costTimeMs, long code, String message, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(headers, "headers");
        return new KmpHttpRequestEvent(path, costTimeMs, code, message, headers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KmpHttpRequestEvent)) {
            return false;
        }
        KmpHttpRequestEvent kmpHttpRequestEvent = (KmpHttpRequestEvent) other;
        return Intrinsics.areEqual(this.path, kmpHttpRequestEvent.path) && this.costTimeMs == kmpHttpRequestEvent.costTimeMs && this.code == kmpHttpRequestEvent.code && Intrinsics.areEqual(this.message, kmpHttpRequestEvent.message) && Intrinsics.areEqual(this.headers, kmpHttpRequestEvent.headers);
    }

    public int hashCode() {
        return (((((((this.path.hashCode() * 31) + Long.hashCode(this.costTimeMs)) * 31) + Long.hashCode(this.code)) * 31) + this.message.hashCode()) * 31) + this.headers.hashCode();
    }

    public String toString() {
        return "KmpHttpRequestEvent(path=" + this.path + ", costTimeMs=" + this.costTimeMs + ", code=" + this.code + ", message=" + this.message + ", headers=" + this.headers + ')';
    }

    public KmpHttpRequestEvent(String path, long j, long j2, String message, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.path = path;
        this.costTimeMs = j;
        this.code = j2;
        this.message = message;
        this.headers = headers;
    }

    public final String getPath() {
        return this.path;
    }

    public final long getCostTimeMs() {
        return this.costTimeMs;
    }

    public final long getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }
}
