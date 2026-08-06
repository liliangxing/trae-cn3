package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003Jy\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000bHÆ\u0001J\u0013\u0010&\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0016\u0010\r\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0019¨\u0006+"}, d2 = {"Lcom/bytedance/trae/conversation/network/SkillItem;", "", "skillId", "", "name", "dirName", "folderName", "description", "createdAt", "updatedAt", "enabled", "", "scope", "isBuiltin", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Z)V", "getSkillId", "()Ljava/lang/String;", "getName", "getDirName", "getFolderName", "getDescription", "getCreatedAt", "getUpdatedAt", "getEnabled", "()Z", "getScope", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SkillItem {

    @SerializedName("created_at")
    private final String createdAt;

    @SerializedName("description")
    private final String description;

    @SerializedName(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME)
    private final String dirName;

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("folder_name")
    private final String folderName;

    @SerializedName("is_builtin")
    private final boolean isBuiltin;

    @SerializedName("name")
    private final String name;

    @SerializedName("scope")
    private final String scope;

    @SerializedName("skill_id")
    private final String skillId;

    @SerializedName("updated_at")
    private final String updatedAt;

    /* renamed from: component1, reason: from getter */
    public final String getSkillId() {
        return this.skillId;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsBuiltin() {
        return this.isBuiltin;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDirName() {
        return this.dirName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFolderName() {
        return this.folderName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component7, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component9, reason: from getter */
    public final String getScope() {
        return this.scope;
    }

    public final SkillItem copy(String skillId, String name, String dirName, String folderName, String description, String createdAt, String updatedAt, boolean enabled, String scope, boolean isBuiltin) {
        Intrinsics.checkNotNullParameter(skillId, "skillId");
        Intrinsics.checkNotNullParameter(name, "name");
        return new SkillItem(skillId, name, dirName, folderName, description, createdAt, updatedAt, enabled, scope, isBuiltin);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkillItem)) {
            return false;
        }
        SkillItem skillItem = (SkillItem) other;
        return Intrinsics.areEqual(this.skillId, skillItem.skillId) && Intrinsics.areEqual(this.name, skillItem.name) && Intrinsics.areEqual(this.dirName, skillItem.dirName) && Intrinsics.areEqual(this.folderName, skillItem.folderName) && Intrinsics.areEqual(this.description, skillItem.description) && Intrinsics.areEqual(this.createdAt, skillItem.createdAt) && Intrinsics.areEqual(this.updatedAt, skillItem.updatedAt) && this.enabled == skillItem.enabled && Intrinsics.areEqual(this.scope, skillItem.scope) && this.isBuiltin == skillItem.isBuiltin;
    }

    public int hashCode() {
        int hashCode = ((this.skillId.hashCode() * 31) + this.name.hashCode()) * 31;
        String str = this.dirName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.folderName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.createdAt;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.updatedAt;
        int hashCode6 = (((hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + Boolean.hashCode(this.enabled)) * 31;
        String str6 = this.scope;
        return ((hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + Boolean.hashCode(this.isBuiltin);
    }

    public String toString() {
        return "SkillItem(skillId=" + this.skillId + ", name=" + this.name + ", dirName=" + this.dirName + ", folderName=" + this.folderName + ", description=" + this.description + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", enabled=" + this.enabled + ", scope=" + this.scope + ", isBuiltin=" + this.isBuiltin + ')';
    }

    public SkillItem(String skillId, String name, String str, String str2, String str3, String str4, String str5, boolean z, String str6, boolean z2) {
        Intrinsics.checkNotNullParameter(skillId, "skillId");
        Intrinsics.checkNotNullParameter(name, "name");
        this.skillId = skillId;
        this.name = name;
        this.dirName = str;
        this.folderName = str2;
        this.description = str3;
        this.createdAt = str4;
        this.updatedAt = str5;
        this.enabled = z;
        this.scope = str6;
        this.isBuiltin = z2;
    }

    public /* synthetic */ SkillItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, String str8, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? true : z, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? false : z2);
    }

    public final String getSkillId() {
        return this.skillId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDirName() {
        return this.dirName;
    }

    public final String getFolderName() {
        return this.folderName;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getScope() {
        return this.scope;
    }

    public final boolean isBuiltin() {
        return this.isBuiltin;
    }
}
