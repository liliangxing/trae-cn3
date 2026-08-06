package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/network/CreateFolderRequest;", "", "cliId", "", "parent", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCliId", "()Ljava/lang/String;", "getParent", "getName", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CreateFolderRequest {

    @SerializedName("cli_id")
    private final String cliId;

    @SerializedName("name")
    private final String name;

    @SerializedName("parent")
    private final String parent;

    public static /* synthetic */ CreateFolderRequest copy$default(CreateFolderRequest createFolderRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createFolderRequest.cliId;
        }
        if ((i & 2) != 0) {
            str2 = createFolderRequest.parent;
        }
        if ((i & 4) != 0) {
            str3 = createFolderRequest.name;
        }
        return createFolderRequest.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCliId() {
        return this.cliId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getParent() {
        return this.parent;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final CreateFolderRequest copy(String cliId, String parent, String name) {
        Intrinsics.checkNotNullParameter(cliId, "cliId");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(name, "name");
        return new CreateFolderRequest(cliId, parent, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateFolderRequest)) {
            return false;
        }
        CreateFolderRequest createFolderRequest = (CreateFolderRequest) other;
        return Intrinsics.areEqual(this.cliId, createFolderRequest.cliId) && Intrinsics.areEqual(this.parent, createFolderRequest.parent) && Intrinsics.areEqual(this.name, createFolderRequest.name);
    }

    public int hashCode() {
        return (((this.cliId.hashCode() * 31) + this.parent.hashCode()) * 31) + this.name.hashCode();
    }

    public String toString() {
        return "CreateFolderRequest(cliId=" + this.cliId + ", parent=" + this.parent + ", name=" + this.name + ')';
    }

    public CreateFolderRequest(String cliId, String parent, String name) {
        Intrinsics.checkNotNullParameter(cliId, "cliId");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(name, "name");
        this.cliId = cliId;
        this.parent = parent;
        this.name = name;
    }

    public final String getCliId() {
        return this.cliId;
    }

    public final String getParent() {
        return this.parent;
    }

    public final String getName() {
        return this.name;
    }
}
