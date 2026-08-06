package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FinishCardResult.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/im/model/SkillInfo;", "", "skillName", "", "folderName", "description", "filePath", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSkillName", "()Ljava/lang/String;", "getFolderName", "getDescription", "getFilePath", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SkillInfo {

    @SerializedName("description")
    private final String description;

    @SerializedName("file_path")
    private final String filePath;

    @SerializedName("folder_name")
    private final String folderName;

    @SerializedName("skill_name")
    private final String skillName;

    public SkillInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SkillInfo copy$default(SkillInfo skillInfo, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = skillInfo.skillName;
        }
        if ((i & 2) != 0) {
            str2 = skillInfo.folderName;
        }
        if ((i & 4) != 0) {
            str3 = skillInfo.description;
        }
        if ((i & 8) != 0) {
            str4 = skillInfo.filePath;
        }
        return skillInfo.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSkillName() {
        return this.skillName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFolderName() {
        return this.folderName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    public final SkillInfo copy(String skillName, String folderName, String description, String filePath) {
        return new SkillInfo(skillName, folderName, description, filePath);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkillInfo)) {
            return false;
        }
        SkillInfo skillInfo = (SkillInfo) other;
        return Intrinsics.areEqual(this.skillName, skillInfo.skillName) && Intrinsics.areEqual(this.folderName, skillInfo.folderName) && Intrinsics.areEqual(this.description, skillInfo.description) && Intrinsics.areEqual(this.filePath, skillInfo.filePath);
    }

    public int hashCode() {
        String str = this.skillName;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.folderName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.filePath;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "SkillInfo(skillName=" + this.skillName + ", folderName=" + this.folderName + ", description=" + this.description + ", filePath=" + this.filePath + ')';
    }

    public SkillInfo(String str, String str2, String str3, String str4) {
        this.skillName = str;
        this.folderName = str2;
        this.description = str3;
        this.filePath = str4;
    }

    public /* synthetic */ SkillInfo(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getSkillName() {
        return this.skillName;
    }

    public final String getFolderName() {
        return this.folderName;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getFilePath() {
        return this.filePath;
    }
}
