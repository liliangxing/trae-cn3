package com.bytedance.pitaya.api;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PTYCustomURLHost.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/pitaya/api/PTYCustomURLHost;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "urlHost", "", "authURLHost", "(Ljava/lang/String;Ljava/lang/String;)V", "getAuthURLHost", "()Ljava/lang/String;", "getUrlHost", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PTYCustomURLHost implements ReflectionCall {
    private final String authURLHost;
    private final String urlHost;

    public static /* synthetic */ PTYCustomURLHost copy$default(PTYCustomURLHost pTYCustomURLHost, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pTYCustomURLHost.urlHost;
        }
        if ((i & 2) != 0) {
            str2 = pTYCustomURLHost.authURLHost;
        }
        return pTYCustomURLHost.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrlHost() {
        return this.urlHost;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAuthURLHost() {
        return this.authURLHost;
    }

    public final PTYCustomURLHost copy(String urlHost, String authURLHost) {
        return new PTYCustomURLHost(urlHost, authURLHost);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PTYCustomURLHost)) {
            return false;
        }
        PTYCustomURLHost pTYCustomURLHost = (PTYCustomURLHost) other;
        return Intrinsics.areEqual(this.urlHost, pTYCustomURLHost.urlHost) && Intrinsics.areEqual(this.authURLHost, pTYCustomURLHost.authURLHost);
    }

    public int hashCode() {
        String str = this.urlHost;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.authURLHost;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "PTYCustomURLHost(urlHost=" + this.urlHost + ", authURLHost=" + this.authURLHost + ')';
    }

    public PTYCustomURLHost(String str, String str2) {
        this.urlHost = str;
        this.authURLHost = str2;
    }

    public final String getAuthURLHost() {
        return this.authURLHost;
    }

    public final String getUrlHost() {
        return this.urlHost;
    }
}
