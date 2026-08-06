package com.bytedance.kmp.network.cinterop;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: IKmpNetworkCommonParamsProvider.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B-\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tR$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR,\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001a\u0012\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/bytedance/kmp/network/cinterop/KmpCommonParamsResult;", "", "useCache", "", "cacheVersion", "", "newQueries", "", "Lcom/bytedance/kmp/network/cinterop/StringPair;", "(Ljava/lang/Boolean;ILjava/util/List;)V", "getCacheVersion$annotations", "()V", "getCacheVersion", "()I", "setCacheVersion", "(I)V", "getNewQueries$annotations", "getNewQueries", "()Ljava/util/List;", "setNewQueries", "(Ljava/util/List;)V", "getUseCache$annotations", "getUseCache", "()Ljava/lang/Boolean;", "setUseCache", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KmpCommonParamsResult {
    private int cacheVersion;
    private List<StringPair> newQueries;
    private Boolean useCache;

    public KmpCommonParamsResult() {
        this(null, 0, null, 7, null);
    }

    public static /* synthetic */ void getCacheVersion$annotations() {
    }

    public static /* synthetic */ void getNewQueries$annotations() {
    }

    public static /* synthetic */ void getUseCache$annotations() {
    }

    public KmpCommonParamsResult(Boolean bool, int i, List<StringPair> list) {
        this.useCache = bool;
        this.cacheVersion = i;
        this.newQueries = list;
    }

    public /* synthetic */ KmpCommonParamsResult(Boolean bool, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : bool, (i2 & 2) != 0 ? -1 : i, (i2 & 4) != 0 ? null : list);
    }

    public final Boolean getUseCache() {
        return this.useCache;
    }

    public final void setUseCache(Boolean bool) {
        this.useCache = bool;
    }

    public final int getCacheVersion() {
        return this.cacheVersion;
    }

    public final void setCacheVersion(int i) {
        this.cacheVersion = i;
    }

    public final List<StringPair> getNewQueries() {
        return this.newQueries;
    }

    public final void setNewQueries(List<StringPair> list) {
        this.newQueries = list;
    }
}
