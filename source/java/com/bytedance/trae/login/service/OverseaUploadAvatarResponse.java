package com.bytedance.trae.login.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OverseaProfileApi.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;", "", "message", "", "data", "Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;)V", "getMessage", "()Ljava/lang/String;", "getData", "()Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class OverseaUploadAvatarResponse {

    @SerializedName("data")
    private final OverseaUploadAvatarData data;

    @SerializedName("message")
    private final String message;

    /* JADX WARN: Multi-variable type inference failed */
    public OverseaUploadAvatarResponse() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ OverseaUploadAvatarResponse copy$default(OverseaUploadAvatarResponse overseaUploadAvatarResponse, String str, OverseaUploadAvatarData overseaUploadAvatarData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = overseaUploadAvatarResponse.message;
        }
        if ((i & 2) != 0) {
            overseaUploadAvatarData = overseaUploadAvatarResponse.data;
        }
        return overseaUploadAvatarResponse.copy(str, overseaUploadAvatarData);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component2, reason: from getter */
    public final OverseaUploadAvatarData getData() {
        return this.data;
    }

    public final OverseaUploadAvatarResponse copy(String message, OverseaUploadAvatarData data) {
        return new OverseaUploadAvatarResponse(message, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OverseaUploadAvatarResponse)) {
            return false;
        }
        OverseaUploadAvatarResponse overseaUploadAvatarResponse = (OverseaUploadAvatarResponse) other;
        return Intrinsics.areEqual(this.message, overseaUploadAvatarResponse.message) && Intrinsics.areEqual(this.data, overseaUploadAvatarResponse.data);
    }

    public int hashCode() {
        String str = this.message;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        OverseaUploadAvatarData overseaUploadAvatarData = this.data;
        return hashCode + (overseaUploadAvatarData != null ? overseaUploadAvatarData.hashCode() : 0);
    }

    public String toString() {
        return "OverseaUploadAvatarResponse(message=" + this.message + ", data=" + this.data + ')';
    }

    public OverseaUploadAvatarResponse(String str, OverseaUploadAvatarData overseaUploadAvatarData) {
        this.message = str;
        this.data = overseaUploadAvatarData;
    }

    public /* synthetic */ OverseaUploadAvatarResponse(String str, OverseaUploadAvatarData overseaUploadAvatarData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : overseaUploadAvatarData);
    }

    public final String getMessage() {
        return this.message;
    }

    public final OverseaUploadAvatarData getData() {
        return this.data;
    }
}
