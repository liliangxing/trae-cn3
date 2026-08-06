package com.bytedance.trae.im.service;

import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.im.model.ChangedFileData;
import com.bytedance.trae.im.model.ChangedSkillsData;
import com.bytedance.trae.im.model.MergeChangedFilesData;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IDiffViewApi.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0092\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00068"}, d2 = {"Lcom/bytedance/trae/im/service/DiffViewResponse;", "", "turnId", "", "chatSessionId", PageDataManager.EXTRA_STATUS, "createdAt", "", "changedDocs", "Lcom/bytedance/trae/im/model/ChangedFileData;", "changedCodes", "changedSkills", "Lcom/bytedance/trae/im/model/ChangedSkillsData;", "changedSheets", "changedSlides", "changedImages", "mergeProducts", "Lcom/bytedance/trae/im/model/MergeChangedFilesData;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/bytedance/trae/im/model/ChangedFileData;Lcom/bytedance/trae/im/model/ChangedFileData;Lcom/bytedance/trae/im/model/ChangedSkillsData;Lcom/bytedance/trae/im/model/ChangedFileData;Lcom/bytedance/trae/im/model/ChangedFileData;Lcom/bytedance/trae/im/model/ChangedFileData;Lcom/bytedance/trae/im/model/MergeChangedFilesData;)V", "getTurnId", "()Ljava/lang/String;", "getChatSessionId", "getStatus", "getCreatedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getChangedDocs", "()Lcom/bytedance/trae/im/model/ChangedFileData;", "getChangedCodes", "getChangedSkills", "()Lcom/bytedance/trae/im/model/ChangedSkillsData;", "getChangedSheets", "getChangedSlides", "getChangedImages", "getMergeProducts", "()Lcom/bytedance/trae/im/model/MergeChangedFilesData;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/bytedance/trae/im/model/ChangedFileData;Lcom/bytedance/trae/im/model/ChangedFileData;Lcom/bytedance/trae/im/model/ChangedSkillsData;Lcom/bytedance/trae/im/model/ChangedFileData;Lcom/bytedance/trae/im/model/ChangedFileData;Lcom/bytedance/trae/im/model/ChangedFileData;Lcom/bytedance/trae/im/model/MergeChangedFilesData;)Lcom/bytedance/trae/im/service/DiffViewResponse;", "equals", "", "other", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class DiffViewResponse {

    @SerializedName("changed_codes")
    private final ChangedFileData changedCodes;

    @SerializedName("changed_docs")
    private final ChangedFileData changedDocs;

    @SerializedName("changed_images")
    private final ChangedFileData changedImages;

    @SerializedName("changed_sheets")
    private final ChangedFileData changedSheets;

    @SerializedName("changed_skills")
    private final ChangedSkillsData changedSkills;

    @SerializedName("changed_slides")
    private final ChangedFileData changedSlides;

    @SerializedName("chat_session_id")
    private final String chatSessionId;

    @SerializedName("created_at")
    private final Long createdAt;

    @SerializedName("merge_products")
    private final MergeChangedFilesData mergeProducts;

    @SerializedName(PageDataManager.EXTRA_STATUS)
    private final String status;

    @SerializedName("turn_id")
    private final String turnId;

    public DiffViewResponse() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTurnId() {
        return this.turnId;
    }

    /* renamed from: component10, reason: from getter */
    public final ChangedFileData getChangedImages() {
        return this.changedImages;
    }

    /* renamed from: component11, reason: from getter */
    public final MergeChangedFilesData getMergeProducts() {
        return this.mergeProducts;
    }

    /* renamed from: component2, reason: from getter */
    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component5, reason: from getter */
    public final ChangedFileData getChangedDocs() {
        return this.changedDocs;
    }

    /* renamed from: component6, reason: from getter */
    public final ChangedFileData getChangedCodes() {
        return this.changedCodes;
    }

    /* renamed from: component7, reason: from getter */
    public final ChangedSkillsData getChangedSkills() {
        return this.changedSkills;
    }

    /* renamed from: component8, reason: from getter */
    public final ChangedFileData getChangedSheets() {
        return this.changedSheets;
    }

    /* renamed from: component9, reason: from getter */
    public final ChangedFileData getChangedSlides() {
        return this.changedSlides;
    }

    public final DiffViewResponse copy(String turnId, String chatSessionId, String status, Long createdAt, ChangedFileData changedDocs, ChangedFileData changedCodes, ChangedSkillsData changedSkills, ChangedFileData changedSheets, ChangedFileData changedSlides, ChangedFileData changedImages, MergeChangedFilesData mergeProducts) {
        return new DiffViewResponse(turnId, chatSessionId, status, createdAt, changedDocs, changedCodes, changedSkills, changedSheets, changedSlides, changedImages, mergeProducts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiffViewResponse)) {
            return false;
        }
        DiffViewResponse diffViewResponse = (DiffViewResponse) other;
        return Intrinsics.areEqual(this.turnId, diffViewResponse.turnId) && Intrinsics.areEqual(this.chatSessionId, diffViewResponse.chatSessionId) && Intrinsics.areEqual(this.status, diffViewResponse.status) && Intrinsics.areEqual(this.createdAt, diffViewResponse.createdAt) && Intrinsics.areEqual(this.changedDocs, diffViewResponse.changedDocs) && Intrinsics.areEqual(this.changedCodes, diffViewResponse.changedCodes) && Intrinsics.areEqual(this.changedSkills, diffViewResponse.changedSkills) && Intrinsics.areEqual(this.changedSheets, diffViewResponse.changedSheets) && Intrinsics.areEqual(this.changedSlides, diffViewResponse.changedSlides) && Intrinsics.areEqual(this.changedImages, diffViewResponse.changedImages) && Intrinsics.areEqual(this.mergeProducts, diffViewResponse.mergeProducts);
    }

    public int hashCode() {
        String str = this.turnId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.chatSessionId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.status;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l = this.createdAt;
        int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        ChangedFileData changedFileData = this.changedDocs;
        int hashCode5 = (hashCode4 + (changedFileData == null ? 0 : changedFileData.hashCode())) * 31;
        ChangedFileData changedFileData2 = this.changedCodes;
        int hashCode6 = (hashCode5 + (changedFileData2 == null ? 0 : changedFileData2.hashCode())) * 31;
        ChangedSkillsData changedSkillsData = this.changedSkills;
        int hashCode7 = (hashCode6 + (changedSkillsData == null ? 0 : changedSkillsData.hashCode())) * 31;
        ChangedFileData changedFileData3 = this.changedSheets;
        int hashCode8 = (hashCode7 + (changedFileData3 == null ? 0 : changedFileData3.hashCode())) * 31;
        ChangedFileData changedFileData4 = this.changedSlides;
        int hashCode9 = (hashCode8 + (changedFileData4 == null ? 0 : changedFileData4.hashCode())) * 31;
        ChangedFileData changedFileData5 = this.changedImages;
        int hashCode10 = (hashCode9 + (changedFileData5 == null ? 0 : changedFileData5.hashCode())) * 31;
        MergeChangedFilesData mergeChangedFilesData = this.mergeProducts;
        return hashCode10 + (mergeChangedFilesData != null ? mergeChangedFilesData.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DiffViewResponse(turnId=");
        sb.append(this.turnId).append(", chatSessionId=").append(this.chatSessionId).append(", status=").append(this.status).append(", createdAt=").append(this.createdAt).append(", changedDocs=").append(this.changedDocs).append(", changedCodes=").append(this.changedCodes).append(", changedSkills=").append(this.changedSkills).append(", changedSheets=").append(this.changedSheets).append(", changedSlides=").append(this.changedSlides).append(", changedImages=").append(this.changedImages).append(", mergeProducts=").append(this.mergeProducts).append(')');
        return sb.toString();
    }

    public DiffViewResponse(String str, String str2, String str3, Long l, ChangedFileData changedFileData, ChangedFileData changedFileData2, ChangedSkillsData changedSkillsData, ChangedFileData changedFileData3, ChangedFileData changedFileData4, ChangedFileData changedFileData5, MergeChangedFilesData mergeChangedFilesData) {
        this.turnId = str;
        this.chatSessionId = str2;
        this.status = str3;
        this.createdAt = l;
        this.changedDocs = changedFileData;
        this.changedCodes = changedFileData2;
        this.changedSkills = changedSkillsData;
        this.changedSheets = changedFileData3;
        this.changedSlides = changedFileData4;
        this.changedImages = changedFileData5;
        this.mergeProducts = mergeChangedFilesData;
    }

    public /* synthetic */ DiffViewResponse(String str, String str2, String str3, Long l, ChangedFileData changedFileData, ChangedFileData changedFileData2, ChangedSkillsData changedSkillsData, ChangedFileData changedFileData3, ChangedFileData changedFileData4, ChangedFileData changedFileData5, MergeChangedFilesData mergeChangedFilesData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : changedFileData, (i & 32) != 0 ? null : changedFileData2, (i & 64) != 0 ? null : changedSkillsData, (i & 128) != 0 ? null : changedFileData3, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : changedFileData4, (i & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? null : changedFileData5, (i & 1024) == 0 ? mergeChangedFilesData : null);
    }

    public final String getTurnId() {
        return this.turnId;
    }

    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    public final String getStatus() {
        return this.status;
    }

    public final Long getCreatedAt() {
        return this.createdAt;
    }

    public final ChangedFileData getChangedDocs() {
        return this.changedDocs;
    }

    public final ChangedFileData getChangedCodes() {
        return this.changedCodes;
    }

    public final ChangedSkillsData getChangedSkills() {
        return this.changedSkills;
    }

    public final ChangedFileData getChangedSheets() {
        return this.changedSheets;
    }

    public final ChangedFileData getChangedSlides() {
        return this.changedSlides;
    }

    public final ChangedFileData getChangedImages() {
        return this.changedImages;
    }

    public final MergeChangedFilesData getMergeProducts() {
        return this.mergeProducts;
    }
}
