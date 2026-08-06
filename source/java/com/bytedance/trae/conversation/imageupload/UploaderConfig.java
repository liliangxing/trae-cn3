package com.bytedance.trae.conversation.imageupload;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageUploadModels.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;", "", "appId", "", "imageHost", "", "uploadDomain", "defaultServiceId", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()I", "getImageHost", "()Ljava/lang/String;", "getUploadDomain", "getDefaultServiceId", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UploaderConfig {
    private final int appId;
    private final String defaultServiceId;
    private final String imageHost;
    private final String uploadDomain;

    public static /* synthetic */ UploaderConfig copy$default(UploaderConfig uploaderConfig, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = uploaderConfig.appId;
        }
        if ((i2 & 2) != 0) {
            str = uploaderConfig.imageHost;
        }
        if ((i2 & 4) != 0) {
            str2 = uploaderConfig.uploadDomain;
        }
        if ((i2 & 8) != 0) {
            str3 = uploaderConfig.defaultServiceId;
        }
        return uploaderConfig.copy(i, str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAppId() {
        return this.appId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getImageHost() {
        return this.imageHost;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUploadDomain() {
        return this.uploadDomain;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDefaultServiceId() {
        return this.defaultServiceId;
    }

    public final UploaderConfig copy(int appId, String imageHost, String uploadDomain, String defaultServiceId) {
        Intrinsics.checkNotNullParameter(imageHost, "imageHost");
        return new UploaderConfig(appId, imageHost, uploadDomain, defaultServiceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploaderConfig)) {
            return false;
        }
        UploaderConfig uploaderConfig = (UploaderConfig) other;
        return this.appId == uploaderConfig.appId && Intrinsics.areEqual(this.imageHost, uploaderConfig.imageHost) && Intrinsics.areEqual(this.uploadDomain, uploaderConfig.uploadDomain) && Intrinsics.areEqual(this.defaultServiceId, uploaderConfig.defaultServiceId);
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.appId) * 31) + this.imageHost.hashCode()) * 31;
        String str = this.uploadDomain;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.defaultServiceId;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "UploaderConfig(appId=" + this.appId + ", imageHost=" + this.imageHost + ", uploadDomain=" + this.uploadDomain + ", defaultServiceId=" + this.defaultServiceId + ')';
    }

    public UploaderConfig(int i, String imageHost, String str, String str2) {
        Intrinsics.checkNotNullParameter(imageHost, "imageHost");
        this.appId = i;
        this.imageHost = imageHost;
        this.uploadDomain = str;
        this.defaultServiceId = str2;
    }

    public /* synthetic */ UploaderConfig(int i, String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3);
    }

    public final int getAppId() {
        return this.appId;
    }

    public final String getImageHost() {
        return this.imageHost;
    }

    public final String getUploadDomain() {
        return this.uploadDomain;
    }

    public final String getDefaultServiceId() {
        return this.defaultServiceId;
    }
}
