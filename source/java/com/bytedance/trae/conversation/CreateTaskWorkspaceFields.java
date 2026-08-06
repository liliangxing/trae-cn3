package com.bytedance.trae.conversation;

import com.bytedance.forest.model.PreloadConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CreateTaskWorkspacePolicy.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;", "", "workspaceDir", "", "workspaceFolders", "", "projectId", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getWorkspaceDir", "()Ljava/lang/String;", "getWorkspaceFolders", "()Ljava/util/List;", "getProjectId", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CreateTaskWorkspaceFields {
    private final String projectId;
    private final String workspaceDir;
    private final List<String> workspaceFolders;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreateTaskWorkspaceFields copy$default(CreateTaskWorkspaceFields createTaskWorkspaceFields, String str, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createTaskWorkspaceFields.workspaceDir;
        }
        if ((i & 2) != 0) {
            list = createTaskWorkspaceFields.workspaceFolders;
        }
        if ((i & 4) != 0) {
            str2 = createTaskWorkspaceFields.projectId;
        }
        return createTaskWorkspaceFields.copy(str, list, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getWorkspaceDir() {
        return this.workspaceDir;
    }

    public final List<String> component2() {
        return this.workspaceFolders;
    }

    /* renamed from: component3, reason: from getter */
    public final String getProjectId() {
        return this.projectId;
    }

    public final CreateTaskWorkspaceFields copy(String workspaceDir, List<String> workspaceFolders, String projectId) {
        return new CreateTaskWorkspaceFields(workspaceDir, workspaceFolders, projectId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateTaskWorkspaceFields)) {
            return false;
        }
        CreateTaskWorkspaceFields createTaskWorkspaceFields = (CreateTaskWorkspaceFields) other;
        return Intrinsics.areEqual(this.workspaceDir, createTaskWorkspaceFields.workspaceDir) && Intrinsics.areEqual(this.workspaceFolders, createTaskWorkspaceFields.workspaceFolders) && Intrinsics.areEqual(this.projectId, createTaskWorkspaceFields.projectId);
    }

    public int hashCode() {
        String str = this.workspaceDir;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.workspaceFolders;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.projectId;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "CreateTaskWorkspaceFields(workspaceDir=" + this.workspaceDir + ", workspaceFolders=" + this.workspaceFolders + ", projectId=" + this.projectId + ')';
    }

    public CreateTaskWorkspaceFields(String str, List<String> list, String str2) {
        this.workspaceDir = str;
        this.workspaceFolders = list;
        this.projectId = str2;
    }

    public final String getWorkspaceDir() {
        return this.workspaceDir;
    }

    public final List<String> getWorkspaceFolders() {
        return this.workspaceFolders;
    }

    public final String getProjectId() {
        return this.projectId;
    }
}
