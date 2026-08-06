package com.bytedance.trae.conversation.network;

import com.bytedance.sdk.account.execute.ApiRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: UserScopedModelListMemoryCache.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001d*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\u001b\u001c\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u001f\u0010\u000f\u001a\u0004\u0018\u00018\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0002\u0010\u0011J-\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0002\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;", "T", "", "<init>", "()V", "lock", "entries", "", "Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$ScopedKey;", "generation", "", "captureOwner", "Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;", "userId", "", ApiRequest.METHOD_GET, "route", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "putIfCurrent", "", "requestOwner", "currentUserId", "value", "(Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z", "onAccountChanged", "", "normalizeUserId", "Owner", "ScopedKey", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UserScopedModelListMemoryCache<T> {

    @Deprecated
    public static final String ANONYMOUS_USER = "<anonymous>";
    private static final Companion Companion = new Companion(null);
    private long generation;
    private final Object lock = new Object();
    private final Map<ScopedKey, T> entries = new LinkedHashMap();

    /* compiled from: UserScopedModelListMemoryCache.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;", "", "userId", "", "generation", "", "<init>", "(Ljava/lang/String;J)V", "getUserId", "()Ljava/lang/String;", "getGeneration", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Owner {
        private final long generation;
        private final String userId;

        public static /* synthetic */ Owner copy$default(Owner owner, String str, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = owner.userId;
            }
            if ((i & 2) != 0) {
                j = owner.generation;
            }
            return owner.copy(str, j);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        /* renamed from: component2, reason: from getter */
        public final long getGeneration() {
            return this.generation;
        }

        public final Owner copy(String userId, long generation) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            return new Owner(userId, generation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Owner)) {
                return false;
            }
            Owner owner = (Owner) other;
            return Intrinsics.areEqual(this.userId, owner.userId) && this.generation == owner.generation;
        }

        public int hashCode() {
            return (this.userId.hashCode() * 31) + Long.hashCode(this.generation);
        }

        public String toString() {
            return "Owner(userId=" + this.userId + ", generation=" + this.generation + ')';
        }

        public Owner(String str, long j) {
            Intrinsics.checkNotNullParameter(str, "userId");
            this.userId = str;
            this.generation = j;
        }

        public final String getUserId() {
            return this.userId;
        }

        public final long getGeneration() {
            return this.generation;
        }
    }

    /* compiled from: UserScopedModelListMemoryCache.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$ScopedKey;", "", "userId", "", "route", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getRoute", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final /* data */ class ScopedKey {
        private final String route;
        private final String userId;

        public static /* synthetic */ ScopedKey copy$default(ScopedKey scopedKey, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = scopedKey.userId;
            }
            if ((i & 2) != 0) {
                str2 = scopedKey.route;
            }
            return scopedKey.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getRoute() {
            return this.route;
        }

        public final ScopedKey copy(String userId, String route) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(route, "route");
            return new ScopedKey(userId, route);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScopedKey)) {
                return false;
            }
            ScopedKey scopedKey = (ScopedKey) other;
            return Intrinsics.areEqual(this.userId, scopedKey.userId) && Intrinsics.areEqual(this.route, scopedKey.route);
        }

        public int hashCode() {
            return (this.userId.hashCode() * 31) + this.route.hashCode();
        }

        public String toString() {
            return "ScopedKey(userId=" + this.userId + ", route=" + this.route + ')';
        }

        public ScopedKey(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "userId");
            Intrinsics.checkNotNullParameter(str2, "route");
            this.userId = str;
            this.route = str2;
        }

        public final String getUserId() {
            return this.userId;
        }

        public final String getRoute() {
            return this.route;
        }
    }

    public final Owner captureOwner(String userId) {
        Owner owner;
        synchronized (this.lock) {
            owner = new Owner(normalizeUserId(userId), this.generation);
        }
        return owner;
    }

    public final T get(String userId, String route) {
        T t;
        Intrinsics.checkNotNullParameter(route, "route");
        synchronized (this.lock) {
            t = this.entries.get(new ScopedKey(normalizeUserId(userId), route));
        }
        return t;
    }

    public final boolean putIfCurrent(Owner requestOwner, String currentUserId, String route, T value) {
        boolean z;
        Intrinsics.checkNotNullParameter(requestOwner, "requestOwner");
        Intrinsics.checkNotNullParameter(route, "route");
        synchronized (this.lock) {
            if (requestOwner.getGeneration() == this.generation && Intrinsics.areEqual(requestOwner.getUserId(), normalizeUserId(currentUserId))) {
                this.entries.put(new ScopedKey(requestOwner.getUserId(), route), value);
                z = true;
            }
            z = false;
        }
        return z;
    }

    public final void onAccountChanged() {
        synchronized (this.lock) {
            this.generation++;
            this.entries.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final String normalizeUserId(String userId) {
        if (userId != null) {
            if (!(!StringsKt.isBlank(userId))) {
                userId = null;
            }
            if (userId != null) {
                return userId;
            }
        }
        return ANONYMOUS_USER;
    }

    /* compiled from: UserScopedModelListMemoryCache.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Companion;", "", "<init>", "()V", "ANONYMOUS_USER", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
