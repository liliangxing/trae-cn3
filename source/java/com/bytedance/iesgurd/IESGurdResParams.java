package com.bytedance.iesgurd;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IESGurdResParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/bytedance/iesgurd/IESGurdResParams;", "", "tag", "", "accessKey", "channel", "bundle", "onlyOffline", "", "getCdnSync", "rootDir", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V", "getAccessKey", "()Ljava/lang/String;", "getBundle", "getChannel", "getGetCdnSync", "()Z", "getOnlyOffline", "getRootDir", "getTag", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final /* data */ class IESGurdResParams {
    private final String accessKey;
    private final String bundle;
    private final String channel;
    private final boolean getCdnSync;
    private final boolean onlyOffline;
    private final String rootDir;
    private final String tag;

    public static /* synthetic */ IESGurdResParams copy$default(IESGurdResParams iESGurdResParams, String str, String str2, String str3, String str4, boolean z, boolean z2, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = iESGurdResParams.tag;
        }
        if ((i & 2) != 0) {
            str2 = iESGurdResParams.accessKey;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = iESGurdResParams.channel;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = iESGurdResParams.bundle;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            z = iESGurdResParams.onlyOffline;
        }
        boolean z3 = z;
        if ((i & 32) != 0) {
            z2 = iESGurdResParams.getCdnSync;
        }
        boolean z4 = z2;
        if ((i & 64) != 0) {
            str5 = iESGurdResParams.rootDir;
        }
        return iESGurdResParams.copy(str, str6, str7, str8, z3, z4, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAccessKey() {
        return this.accessKey;
    }

    /* renamed from: component3, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBundle() {
        return this.bundle;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getOnlyOffline() {
        return this.onlyOffline;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getGetCdnSync() {
        return this.getCdnSync;
    }

    /* renamed from: component7, reason: from getter */
    public final String getRootDir() {
        return this.rootDir;
    }

    public final IESGurdResParams copy(String tag, String accessKey, String channel, String bundle, boolean onlyOffline, boolean getCdnSync, String rootDir) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Intrinsics.checkParameterIsNotNull(bundle, "bundle");
        return new IESGurdResParams(tag, accessKey, channel, bundle, onlyOffline, getCdnSync, rootDir);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IESGurdResParams)) {
            return false;
        }
        IESGurdResParams iESGurdResParams = (IESGurdResParams) other;
        return Intrinsics.areEqual(this.tag, iESGurdResParams.tag) && Intrinsics.areEqual(this.accessKey, iESGurdResParams.accessKey) && Intrinsics.areEqual(this.channel, iESGurdResParams.channel) && Intrinsics.areEqual(this.bundle, iESGurdResParams.bundle) && this.onlyOffline == iESGurdResParams.onlyOffline && this.getCdnSync == iESGurdResParams.getCdnSync && Intrinsics.areEqual(this.rootDir, iESGurdResParams.rootDir);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.tag;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.accessKey;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.channel;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.bundle;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        boolean z = this.onlyOffline;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode4 + i) * 31;
        boolean z2 = this.getCdnSync;
        int i3 = (i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31;
        String str5 = this.rootDir;
        return i3 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "IESGurdResParams(tag=" + this.tag + ", accessKey=" + this.accessKey + ", channel=" + this.channel + ", bundle=" + this.bundle + ", onlyOffline=" + this.onlyOffline + ", getCdnSync=" + this.getCdnSync + ", rootDir=" + this.rootDir + ")";
    }

    public IESGurdResParams(String tag, String accessKey, String channel, String bundle, boolean z, boolean z2, String str) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Intrinsics.checkParameterIsNotNull(bundle, "bundle");
        this.tag = tag;
        this.accessKey = accessKey;
        this.channel = channel;
        this.bundle = bundle;
        this.onlyOffline = z;
        this.getCdnSync = z2;
        this.rootDir = str;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getBundle() {
        return this.bundle;
    }

    public final boolean getOnlyOffline() {
        return this.onlyOffline;
    }

    public final boolean getGetCdnSync() {
        return this.getCdnSync;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ IESGurdResParams(String str, String str2, String str3, String str4, boolean z, boolean z2, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, r7, r8, r9);
        String str6;
        boolean z3 = (i & 16) != 0 ? false : z;
        boolean z4 = (i & 32) != 0 ? false : z2;
        if ((i & 64) != 0) {
            str6 = null;
        } else {
            str6 = str5;
        }
    }

    public final String getRootDir() {
        return this.rootDir;
    }
}
