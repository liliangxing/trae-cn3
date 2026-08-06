package com.bytedance.trae.conversation.devices;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.im.service.CliType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectedDeviceItem.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003Jk\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000bHÆ\u0001J\u0013\u0010'\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0018R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018¨\u0006,"}, d2 = {"Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;", "", "id", "", "name", "type", "Lcom/bytedance/trae/im/service/CliType;", "selectedDirectory", "ideVersion", "projectId", "isProjectAvailable", "", "projectName", "showProductType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/CliType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "getName", "getType", "()Lcom/bytedance/trae/im/service/CliType;", "getSelectedDirectory", "getIdeVersion", "getProjectId", "()Z", "getProjectName", "setProjectName", "(Ljava/lang/String;)V", "getShowProductType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SelectedDeviceItem {
    private final String id;
    private final String ideVersion;
    private final boolean isProjectAvailable;
    private final String name;
    private final String projectId;
    private String projectName;
    private final String selectedDirectory;
    private final boolean showProductType;
    private final CliType type;

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final CliType getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSelectedDirectory() {
        return this.selectedDirectory;
    }

    /* renamed from: component5, reason: from getter */
    public final String getIdeVersion() {
        return this.ideVersion;
    }

    /* renamed from: component6, reason: from getter */
    public final String getProjectId() {
        return this.projectId;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsProjectAvailable() {
        return this.isProjectAvailable;
    }

    /* renamed from: component8, reason: from getter */
    public final String getProjectName() {
        return this.projectName;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getShowProductType() {
        return this.showProductType;
    }

    public final SelectedDeviceItem copy(String id, String name, CliType type, String selectedDirectory, String ideVersion, String projectId, boolean isProjectAvailable, String projectName, boolean showProductType) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        return new SelectedDeviceItem(id, name, type, selectedDirectory, ideVersion, projectId, isProjectAvailable, projectName, showProductType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectedDeviceItem)) {
            return false;
        }
        SelectedDeviceItem selectedDeviceItem = (SelectedDeviceItem) other;
        return Intrinsics.areEqual(this.id, selectedDeviceItem.id) && Intrinsics.areEqual(this.name, selectedDeviceItem.name) && this.type == selectedDeviceItem.type && Intrinsics.areEqual(this.selectedDirectory, selectedDeviceItem.selectedDirectory) && Intrinsics.areEqual(this.ideVersion, selectedDeviceItem.ideVersion) && Intrinsics.areEqual(this.projectId, selectedDeviceItem.projectId) && this.isProjectAvailable == selectedDeviceItem.isProjectAvailable && Intrinsics.areEqual(this.projectName, selectedDeviceItem.projectName) && this.showProductType == selectedDeviceItem.showProductType;
    }

    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.type.hashCode()) * 31;
        String str = this.selectedDirectory;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.ideVersion;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.projectId;
        int hashCode4 = (((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + Boolean.hashCode(this.isProjectAvailable)) * 31;
        String str4 = this.projectName;
        return ((hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + Boolean.hashCode(this.showProductType);
    }

    public String toString() {
        return "SelectedDeviceItem(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", selectedDirectory=" + this.selectedDirectory + ", ideVersion=" + this.ideVersion + ", projectId=" + this.projectId + ", isProjectAvailable=" + this.isProjectAvailable + ", projectName=" + this.projectName + ", showProductType=" + this.showProductType + ')';
    }

    public SelectedDeviceItem(String id, String name, CliType type, String str, String str2, String str3, boolean z, String str4, boolean z2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.name = name;
        this.type = type;
        this.selectedDirectory = str;
        this.ideVersion = str2;
        this.projectId = str3;
        this.isProjectAvailable = z;
        this.projectName = str4;
        this.showProductType = z2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public /* synthetic */ SelectedDeviceItem(String str, String str2, CliType cliType, String str3, String str4, String str5, boolean z, String str6, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? CliType.LOCAL : cliType, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? true : z, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? false : z2);
    }

    public final CliType getType() {
        return this.type;
    }

    public final String getSelectedDirectory() {
        return this.selectedDirectory;
    }

    public final String getIdeVersion() {
        return this.ideVersion;
    }

    public final String getProjectId() {
        return this.projectId;
    }

    public final boolean isProjectAvailable() {
        return this.isProjectAvailable;
    }

    public final String getProjectName() {
        return this.projectName;
    }

    public final void setProjectName(String str) {
        this.projectName = str;
    }

    public final boolean getShowProductType() {
        return this.showProductType;
    }
}
