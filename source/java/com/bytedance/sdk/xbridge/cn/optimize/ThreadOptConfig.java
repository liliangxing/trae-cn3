package com.bytedance.sdk.xbridge.cn.optimize;

import com.bytedance.forest.model.PreloadConfig;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OptimizeConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\u0002\u0010\nJ\u001d\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u001d\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u001d\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u001d\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u001d\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u009f\u0001\u0010\u001c\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001R.\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000e¨\u0006#"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/optimize/ThreadOptConfig;", "", "threadOptSchemas", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "syncMethods", "asyncMethods", "mainThreadMethods", "mainThreadOptMethods", "(Ljava/util/HashSet;Ljava/util/HashSet;Ljava/util/HashSet;Ljava/util/HashSet;Ljava/util/HashSet;)V", "getAsyncMethods", "()Ljava/util/HashSet;", "setAsyncMethods", "(Ljava/util/HashSet;)V", "getMainThreadMethods", "setMainThreadMethods", "getMainThreadOptMethods", "setMainThreadOptMethods", "getSyncMethods", "setSyncMethods", "getThreadOptSchemas", "setThreadOptSchemas", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ThreadOptConfig {
    private HashSet<String> asyncMethods;
    private HashSet<String> mainThreadMethods;
    private HashSet<String> mainThreadOptMethods;
    private HashSet<String> syncMethods;
    private HashSet<String> threadOptSchemas;

    public ThreadOptConfig() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ThreadOptConfig copy$default(ThreadOptConfig threadOptConfig, HashSet hashSet, HashSet hashSet2, HashSet hashSet3, HashSet hashSet4, HashSet hashSet5, int i, Object obj) {
        if ((i & 1) != 0) {
            hashSet = threadOptConfig.threadOptSchemas;
        }
        if ((i & 2) != 0) {
            hashSet2 = threadOptConfig.syncMethods;
        }
        HashSet hashSet6 = hashSet2;
        if ((i & 4) != 0) {
            hashSet3 = threadOptConfig.asyncMethods;
        }
        HashSet hashSet7 = hashSet3;
        if ((i & 8) != 0) {
            hashSet4 = threadOptConfig.mainThreadMethods;
        }
        HashSet hashSet8 = hashSet4;
        if ((i & 16) != 0) {
            hashSet5 = threadOptConfig.mainThreadOptMethods;
        }
        return threadOptConfig.copy(hashSet, hashSet6, hashSet7, hashSet8, hashSet5);
    }

    public final HashSet<String> component1() {
        return this.threadOptSchemas;
    }

    public final HashSet<String> component2() {
        return this.syncMethods;
    }

    public final HashSet<String> component3() {
        return this.asyncMethods;
    }

    public final HashSet<String> component4() {
        return this.mainThreadMethods;
    }

    public final HashSet<String> component5() {
        return this.mainThreadOptMethods;
    }

    public final ThreadOptConfig copy(HashSet<String> threadOptSchemas, HashSet<String> syncMethods, HashSet<String> asyncMethods, HashSet<String> mainThreadMethods, HashSet<String> mainThreadOptMethods) {
        return new ThreadOptConfig(threadOptSchemas, syncMethods, asyncMethods, mainThreadMethods, mainThreadOptMethods);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadOptConfig)) {
            return false;
        }
        ThreadOptConfig threadOptConfig = (ThreadOptConfig) other;
        return Intrinsics.areEqual(this.threadOptSchemas, threadOptConfig.threadOptSchemas) && Intrinsics.areEqual(this.syncMethods, threadOptConfig.syncMethods) && Intrinsics.areEqual(this.asyncMethods, threadOptConfig.asyncMethods) && Intrinsics.areEqual(this.mainThreadMethods, threadOptConfig.mainThreadMethods) && Intrinsics.areEqual(this.mainThreadOptMethods, threadOptConfig.mainThreadOptMethods);
    }

    public int hashCode() {
        HashSet<String> hashSet = this.threadOptSchemas;
        int hashCode = (hashSet == null ? 0 : hashSet.hashCode()) * 31;
        HashSet<String> hashSet2 = this.syncMethods;
        int hashCode2 = (hashCode + (hashSet2 == null ? 0 : hashSet2.hashCode())) * 31;
        HashSet<String> hashSet3 = this.asyncMethods;
        int hashCode3 = (hashCode2 + (hashSet3 == null ? 0 : hashSet3.hashCode())) * 31;
        HashSet<String> hashSet4 = this.mainThreadMethods;
        int hashCode4 = (hashCode3 + (hashSet4 == null ? 0 : hashSet4.hashCode())) * 31;
        HashSet<String> hashSet5 = this.mainThreadOptMethods;
        return hashCode4 + (hashSet5 != null ? hashSet5.hashCode() : 0);
    }

    public String toString() {
        return "ThreadOptConfig(threadOptSchemas=" + this.threadOptSchemas + ", syncMethods=" + this.syncMethods + ", asyncMethods=" + this.asyncMethods + ", mainThreadMethods=" + this.mainThreadMethods + ", mainThreadOptMethods=" + this.mainThreadOptMethods + ')';
    }

    public ThreadOptConfig(HashSet<String> hashSet, HashSet<String> hashSet2, HashSet<String> hashSet3, HashSet<String> hashSet4, HashSet<String> hashSet5) {
        this.threadOptSchemas = hashSet;
        this.syncMethods = hashSet2;
        this.asyncMethods = hashSet3;
        this.mainThreadMethods = hashSet4;
        this.mainThreadOptMethods = hashSet5;
    }

    public /* synthetic */ ThreadOptConfig(HashSet hashSet, HashSet hashSet2, HashSet hashSet3, HashSet hashSet4, HashSet hashSet5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : hashSet, (i & 2) != 0 ? null : hashSet2, (i & 4) != 0 ? null : hashSet3, (i & 8) != 0 ? null : hashSet4, (i & 16) != 0 ? null : hashSet5);
    }

    public final HashSet<String> getThreadOptSchemas() {
        return this.threadOptSchemas;
    }

    public final void setThreadOptSchemas(HashSet<String> hashSet) {
        this.threadOptSchemas = hashSet;
    }

    public final HashSet<String> getSyncMethods() {
        return this.syncMethods;
    }

    public final void setSyncMethods(HashSet<String> hashSet) {
        this.syncMethods = hashSet;
    }

    public final HashSet<String> getAsyncMethods() {
        return this.asyncMethods;
    }

    public final void setAsyncMethods(HashSet<String> hashSet) {
        this.asyncMethods = hashSet;
    }

    public final HashSet<String> getMainThreadMethods() {
        return this.mainThreadMethods;
    }

    public final void setMainThreadMethods(HashSet<String> hashSet) {
        this.mainThreadMethods = hashSet;
    }

    public final HashSet<String> getMainThreadOptMethods() {
        return this.mainThreadOptMethods;
    }

    public final void setMainThreadOptMethods(HashSet<String> hashSet) {
        this.mainThreadOptMethods = hashSet;
    }
}
