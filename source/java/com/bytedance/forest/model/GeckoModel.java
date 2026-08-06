package com.bytedance.forest.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: GeckoModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\u0015J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/forest/model/GeckoModel;", "", "accessKey", "", "channel", "bundle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessKey", "()Ljava/lang/String;", "setAccessKey", "(Ljava/lang/String;)V", "getBundle", "setBundle", "getChannel", "setChannel", "buildPath", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "isChannelOrBundleBlank", "toString", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class GeckoModel {
    private String accessKey;
    private String bundle;
    private String channel;

    public static /* synthetic */ GeckoModel copy$default(GeckoModel geckoModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = geckoModel.accessKey;
        }
        if ((i & 2) != 0) {
            str2 = geckoModel.channel;
        }
        if ((i & 4) != 0) {
            str3 = geckoModel.bundle;
        }
        return geckoModel.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAccessKey() {
        return this.accessKey;
    }

    /* renamed from: component2, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBundle() {
        return this.bundle;
    }

    public final GeckoModel copy(String accessKey, String channel, String bundle) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Intrinsics.checkParameterIsNotNull(bundle, "bundle");
        return new GeckoModel(accessKey, channel, bundle);
    }

    public String toString() {
        return "GeckoModel(accessKey=" + this.accessKey + ", channel=" + this.channel + ", bundle=" + this.bundle + ")";
    }

    public GeckoModel(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "accessKey");
        Intrinsics.checkParameterIsNotNull(str2, "channel");
        Intrinsics.checkParameterIsNotNull(str3, "bundle");
        this.accessKey = str;
        this.channel = str2;
        this.bundle = str3;
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final void setAccessKey(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.accessKey = str;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final void setChannel(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.channel = str;
    }

    public final String getBundle() {
        return this.bundle;
    }

    public final void setBundle(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.bundle = str;
    }

    public final boolean isChannelOrBundleBlank() {
        return StringsKt.isBlank(this.channel) || StringsKt.isBlank(this.bundle);
    }

    public final String buildPath() {
        return this.channel + '/' + StringsKt.removePrefix(this.bundle, "/");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GeckoModel)) {
            return false;
        }
        GeckoModel geckoModel = (GeckoModel) other;
        return ((Intrinsics.areEqual(this.accessKey, geckoModel.accessKey) ^ true) || (Intrinsics.areEqual(this.channel, geckoModel.channel) ^ true) || (Intrinsics.areEqual(this.bundle, geckoModel.bundle) ^ true)) ? false : true;
    }

    public int hashCode() {
        return (((this.accessKey.hashCode() * 31) + this.channel.hashCode()) * 31) + this.bundle.hashCode();
    }
}
