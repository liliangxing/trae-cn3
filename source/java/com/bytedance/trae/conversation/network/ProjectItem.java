package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/network/ProjectItem;", "", "projectId", "", "folderPath", "name", "workspaceType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getProjectId", "()Ljava/lang/String;", "getFolderPath", "getName", "getWorkspaceType", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ProjectItem {

    @SerializedName("folder_path")
    private final String folderPath;

    @SerializedName("name")
    private final String name;

    @SerializedName("project_id")
    private final String projectId;

    @SerializedName("workspace_type")
    private final String workspaceType;

    public ProjectItem() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ProjectItem copy$default(ProjectItem projectItem, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = projectItem.projectId;
        }
        if ((i & 2) != 0) {
            str2 = projectItem.folderPath;
        }
        if ((i & 4) != 0) {
            str3 = projectItem.name;
        }
        if ((i & 8) != 0) {
            str4 = projectItem.workspaceType;
        }
        return projectItem.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getProjectId() {
        return this.projectId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFolderPath() {
        return this.folderPath;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getWorkspaceType() {
        return this.workspaceType;
    }

    public final ProjectItem copy(String projectId, String folderPath, String name, String workspaceType) {
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        Intrinsics.checkNotNullParameter(folderPath, "folderPath");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(workspaceType, "workspaceType");
        return new ProjectItem(projectId, folderPath, name, workspaceType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProjectItem)) {
            return false;
        }
        ProjectItem projectItem = (ProjectItem) other;
        return Intrinsics.areEqual(this.projectId, projectItem.projectId) && Intrinsics.areEqual(this.folderPath, projectItem.folderPath) && Intrinsics.areEqual(this.name, projectItem.name) && Intrinsics.areEqual(this.workspaceType, projectItem.workspaceType);
    }

    public int hashCode() {
        return (((((this.projectId.hashCode() * 31) + this.folderPath.hashCode()) * 31) + this.name.hashCode()) * 31) + this.workspaceType.hashCode();
    }

    public String toString() {
        return "ProjectItem(projectId=" + this.projectId + ", folderPath=" + this.folderPath + ", name=" + this.name + ", workspaceType=" + this.workspaceType + ')';
    }

    public ProjectItem(String projectId, String folderPath, String name, String workspaceType) {
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        Intrinsics.checkNotNullParameter(folderPath, "folderPath");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(workspaceType, "workspaceType");
        this.projectId = projectId;
        this.folderPath = folderPath;
        this.name = name;
        this.workspaceType = workspaceType;
    }

    public /* synthetic */ ProjectItem(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    public final String getProjectId() {
        return this.projectId;
    }

    public final String getFolderPath() {
        return this.folderPath;
    }

    public final String getName() {
        return this.name;
    }

    public final String getWorkspaceType() {
        return this.workspaceType;
    }
}
