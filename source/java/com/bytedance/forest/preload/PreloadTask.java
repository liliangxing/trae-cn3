package com.bytedance.forest.preload;

import com.bytedance.applog.server.Api;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.utils.CacheIdentifier;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/forest/preload/PreloadTask;", "", "url", "", "params", "Lcom/bytedance/forest/model/RequestParams;", Api.KEY_ENCRYPT_RESP_KEY, "Lcom/bytedance/forest/utils/CacheIdentifier;", "delegate", "Lcom/bytedance/forest/preload/CallbackDelegate;", "(Ljava/lang/String;Lcom/bytedance/forest/model/RequestParams;Lcom/bytedance/forest/utils/CacheIdentifier;Lcom/bytedance/forest/preload/CallbackDelegate;)V", "getDelegate", "()Lcom/bytedance/forest/preload/CallbackDelegate;", "getKey", "()Lcom/bytedance/forest/utils/CacheIdentifier;", "getParams", "()Lcom/bytedance/forest/model/RequestParams;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class PreloadTask {
    private final CallbackDelegate delegate;
    private final CacheIdentifier key;
    private final RequestParams params;
    private final String url;

    public static /* synthetic */ PreloadTask copy$default(PreloadTask preloadTask, String str, RequestParams requestParams, CacheIdentifier cacheIdentifier, CallbackDelegate callbackDelegate, int i, Object obj) {
        if ((i & 1) != 0) {
            str = preloadTask.url;
        }
        if ((i & 2) != 0) {
            requestParams = preloadTask.params;
        }
        if ((i & 4) != 0) {
            cacheIdentifier = preloadTask.key;
        }
        if ((i & 8) != 0) {
            callbackDelegate = preloadTask.delegate;
        }
        return preloadTask.copy(str, requestParams, cacheIdentifier, callbackDelegate);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final RequestParams getParams() {
        return this.params;
    }

    /* renamed from: component3, reason: from getter */
    public final CacheIdentifier getKey() {
        return this.key;
    }

    /* renamed from: component4, reason: from getter */
    public final CallbackDelegate getDelegate() {
        return this.delegate;
    }

    public final PreloadTask copy(String url, RequestParams params, CacheIdentifier key, CallbackDelegate delegate) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        return new PreloadTask(url, params, key, delegate);
    }

    public PreloadTask(String str, RequestParams requestParams, CacheIdentifier cacheIdentifier, CallbackDelegate callbackDelegate) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intrinsics.checkParameterIsNotNull(requestParams, "params");
        Intrinsics.checkParameterIsNotNull(cacheIdentifier, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkParameterIsNotNull(callbackDelegate, "delegate");
        this.url = str;
        this.params = requestParams;
        this.key = cacheIdentifier;
        this.delegate = callbackDelegate;
    }

    public final String getUrl() {
        return this.url;
    }

    public final RequestParams getParams() {
        return this.params;
    }

    public final CacheIdentifier getKey() {
        return this.key;
    }

    public final CallbackDelegate getDelegate() {
        return this.delegate;
    }

    public String toString() {
        return "PreloadTask@" + hashCode() + "(key=" + this.key + ", params=" + this.params + ", delegate=" + this.delegate + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        if (other != null) {
            return !(Intrinsics.areEqual(this.key, ((PreloadTask) other).key) ^ true);
        }
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.preload.PreloadTask");
    }

    public int hashCode() {
        return this.key.hashCode();
    }
}
