package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICreateTaskCheck.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/im/service/CreateTaskCheckResponse;", "", "projectId", "", "available", "", "<init>", "(Ljava/lang/String;Z)V", "getProjectId", "()Ljava/lang/String;", "getAvailable", "()Z", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CreateTaskCheckResponse {

    @SerializedName("available")
    private final boolean available;

    @SerializedName("project_id")
    private final String projectId;

    /* JADX WARN: Multi-variable type inference failed */
    public CreateTaskCheckResponse() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CreateTaskCheckResponse copy$default(CreateTaskCheckResponse createTaskCheckResponse, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createTaskCheckResponse.projectId;
        }
        if ((i & 2) != 0) {
            z = createTaskCheckResponse.available;
        }
        return createTaskCheckResponse.copy(str, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getProjectId() {
        return this.projectId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getAvailable() {
        return this.available;
    }

    public final CreateTaskCheckResponse copy(String projectId, boolean available) {
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        return new CreateTaskCheckResponse(projectId, available);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateTaskCheckResponse)) {
            return false;
        }
        CreateTaskCheckResponse createTaskCheckResponse = (CreateTaskCheckResponse) other;
        return Intrinsics.areEqual(this.projectId, createTaskCheckResponse.projectId) && this.available == createTaskCheckResponse.available;
    }

    public int hashCode() {
        return (this.projectId.hashCode() * 31) + Boolean.hashCode(this.available);
    }

    public String toString() {
        return "CreateTaskCheckResponse(projectId=" + this.projectId + ", available=" + this.available + ')';
    }

    public CreateTaskCheckResponse(String projectId, boolean z) {
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        this.projectId = projectId;
        this.available = z;
    }

    public /* synthetic */ CreateTaskCheckResponse(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z);
    }

    public final String getProjectId() {
        return this.projectId;
    }

    public final boolean getAvailable() {
        return this.available;
    }
}
