package com.bytedance.trae.kmp.network;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpHttpClient.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003JI\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÇ\u0001J\u0013\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010!\u001a\u00020\"H×\u0001J\t\u0010#\u001a\u00020\u0003H×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;", "", "tag", "", "addPpeHeaders", "", "addCommonHeaders", "trackRequestEvent", "auth", "Lcom/bytedance/trae/kmp/network/KmpRequestAuth;", "hostType", "Lcom/bytedance/trae/kmp/network/KmpHostType;", "<init>", "(Ljava/lang/String;ZZZLcom/bytedance/trae/kmp/network/KmpRequestAuth;Lcom/bytedance/trae/kmp/network/KmpHostType;)V", "getTag", "()Ljava/lang/String;", "getAddPpeHeaders", "()Z", "getAddCommonHeaders", "getTrackRequestEvent", "getAuth", "()Lcom/bytedance/trae/kmp/network/KmpRequestAuth;", "getHostType", "()Lcom/bytedance/trae/kmp/network/KmpHostType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class KmpHttpRequestOptions {
    public static final int $stable = 0;
    private final boolean addCommonHeaders;
    private final boolean addPpeHeaders;
    private final KmpRequestAuth auth;
    private final KmpHostType hostType;
    private final String tag;
    private final boolean trackRequestEvent;

    public KmpHttpRequestOptions() {
        this(null, false, false, false, null, null, 63, null);
    }

    public static /* synthetic */ KmpHttpRequestOptions copy$default(KmpHttpRequestOptions kmpHttpRequestOptions, String str, boolean z, boolean z2, boolean z3, KmpRequestAuth kmpRequestAuth, KmpHostType kmpHostType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = kmpHttpRequestOptions.tag;
        }
        if ((i & 2) != 0) {
            z = kmpHttpRequestOptions.addPpeHeaders;
        }
        boolean z4 = z;
        if ((i & 4) != 0) {
            z2 = kmpHttpRequestOptions.addCommonHeaders;
        }
        boolean z5 = z2;
        if ((i & 8) != 0) {
            z3 = kmpHttpRequestOptions.trackRequestEvent;
        }
        boolean z6 = z3;
        if ((i & 16) != 0) {
            kmpRequestAuth = kmpHttpRequestOptions.auth;
        }
        KmpRequestAuth kmpRequestAuth2 = kmpRequestAuth;
        if ((i & 32) != 0) {
            kmpHostType = kmpHttpRequestOptions.hostType;
        }
        return kmpHttpRequestOptions.copy(str, z4, z5, z6, kmpRequestAuth2, kmpHostType);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getAddPpeHeaders() {
        return this.addPpeHeaders;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getAddCommonHeaders() {
        return this.addCommonHeaders;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getTrackRequestEvent() {
        return this.trackRequestEvent;
    }

    /* renamed from: component5, reason: from getter */
    public final KmpRequestAuth getAuth() {
        return this.auth;
    }

    /* renamed from: component6, reason: from getter */
    public final KmpHostType getHostType() {
        return this.hostType;
    }

    public final KmpHttpRequestOptions copy(String tag, boolean addPpeHeaders, boolean addCommonHeaders, boolean trackRequestEvent, KmpRequestAuth auth, KmpHostType hostType) {
        Intrinsics.checkNotNullParameter(auth, "auth");
        return new KmpHttpRequestOptions(tag, addPpeHeaders, addCommonHeaders, trackRequestEvent, auth, hostType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KmpHttpRequestOptions)) {
            return false;
        }
        KmpHttpRequestOptions kmpHttpRequestOptions = (KmpHttpRequestOptions) other;
        return Intrinsics.areEqual(this.tag, kmpHttpRequestOptions.tag) && this.addPpeHeaders == kmpHttpRequestOptions.addPpeHeaders && this.addCommonHeaders == kmpHttpRequestOptions.addCommonHeaders && this.trackRequestEvent == kmpHttpRequestOptions.trackRequestEvent && this.auth == kmpHttpRequestOptions.auth && this.hostType == kmpHttpRequestOptions.hostType;
    }

    public int hashCode() {
        String str = this.tag;
        int hashCode = (((((((((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.addPpeHeaders)) * 31) + Boolean.hashCode(this.addCommonHeaders)) * 31) + Boolean.hashCode(this.trackRequestEvent)) * 31) + this.auth.hashCode()) * 31;
        KmpHostType kmpHostType = this.hostType;
        return hashCode + (kmpHostType != null ? kmpHostType.hashCode() : 0);
    }

    public String toString() {
        return "KmpHttpRequestOptions(tag=" + this.tag + ", addPpeHeaders=" + this.addPpeHeaders + ", addCommonHeaders=" + this.addCommonHeaders + ", trackRequestEvent=" + this.trackRequestEvent + ", auth=" + this.auth + ", hostType=" + this.hostType + ')';
    }

    public KmpHttpRequestOptions(String str, boolean z, boolean z2, boolean z3, KmpRequestAuth auth, KmpHostType kmpHostType) {
        Intrinsics.checkNotNullParameter(auth, "auth");
        this.tag = str;
        this.addPpeHeaders = z;
        this.addCommonHeaders = z2;
        this.trackRequestEvent = z3;
        this.auth = auth;
        this.hostType = kmpHostType;
    }

    public final String getTag() {
        return this.tag;
    }

    public final boolean getAddPpeHeaders() {
        return this.addPpeHeaders;
    }

    public final boolean getAddCommonHeaders() {
        return this.addCommonHeaders;
    }

    public final boolean getTrackRequestEvent() {
        return this.trackRequestEvent;
    }

    public /* synthetic */ KmpHttpRequestOptions(String str, boolean z, boolean z2, boolean z3, KmpRequestAuth kmpRequestAuth, KmpHostType kmpHostType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? true : z2, (i & 8) != 0 ? true : z3, (i & 16) != 0 ? KmpRequestAuth.None : kmpRequestAuth, (i & 32) != 0 ? null : kmpHostType);
    }

    public final KmpRequestAuth getAuth() {
        return this.auth;
    }

    public final KmpHostType getHostType() {
        return this.hostType;
    }
}
