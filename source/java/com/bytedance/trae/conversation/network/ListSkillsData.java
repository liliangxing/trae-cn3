package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.android.gms.common.data.DataBufferUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003JF\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\tHÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\r¨\u0006\""}, d2 = {"Lcom/bytedance/trae/conversation/network/ListSkillsData;", "", "items", "", "Lcom/bytedance/trae/conversation/network/SkillItem;", "skills", "total", "", "nextPageToken", "", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;)V", "getItems", "()Ljava/util/List;", "getSkills", "getTotal", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNextPageToken", "()Ljava/lang/String;", "allItems", "getAllItems", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;)Lcom/bytedance/trae/conversation/network/ListSkillsData;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ListSkillsData {

    @SerializedName("items")
    private final List<SkillItem> items;

    @SerializedName(DataBufferUtils.KEY_NEXT_PAGE_TOKEN)
    private final String nextPageToken;

    @SerializedName("skills")
    private final List<SkillItem> skills;

    @SerializedName("total")
    private final Long total;

    public ListSkillsData() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListSkillsData copy$default(ListSkillsData listSkillsData, List list, List list2, Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = listSkillsData.items;
        }
        if ((i & 2) != 0) {
            list2 = listSkillsData.skills;
        }
        if ((i & 4) != 0) {
            l = listSkillsData.total;
        }
        if ((i & 8) != 0) {
            str = listSkillsData.nextPageToken;
        }
        return listSkillsData.copy(list, list2, l, str);
    }

    public final List<SkillItem> component1() {
        return this.items;
    }

    public final List<SkillItem> component2() {
        return this.skills;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getTotal() {
        return this.total;
    }

    /* renamed from: component4, reason: from getter */
    public final String getNextPageToken() {
        return this.nextPageToken;
    }

    public final ListSkillsData copy(List<SkillItem> items, List<SkillItem> skills, Long total, String nextPageToken) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(skills, "skills");
        return new ListSkillsData(items, skills, total, nextPageToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListSkillsData)) {
            return false;
        }
        ListSkillsData listSkillsData = (ListSkillsData) other;
        return Intrinsics.areEqual(this.items, listSkillsData.items) && Intrinsics.areEqual(this.skills, listSkillsData.skills) && Intrinsics.areEqual(this.total, listSkillsData.total) && Intrinsics.areEqual(this.nextPageToken, listSkillsData.nextPageToken);
    }

    public int hashCode() {
        int hashCode = ((this.items.hashCode() * 31) + this.skills.hashCode()) * 31;
        Long l = this.total;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.nextPageToken;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ListSkillsData(items=" + this.items + ", skills=" + this.skills + ", total=" + this.total + ", nextPageToken=" + this.nextPageToken + ')';
    }

    public ListSkillsData(List<SkillItem> items, List<SkillItem> skills, Long l, String str) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(skills, "skills");
        this.items = items;
        this.skills = skills;
        this.total = l;
        this.nextPageToken = str;
    }

    public /* synthetic */ ListSkillsData(List list, List list2, Long l, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str);
    }

    public final List<SkillItem> getItems() {
        return this.items;
    }

    public final List<SkillItem> getSkills() {
        return this.skills;
    }

    public final Long getTotal() {
        return this.total;
    }

    public final String getNextPageToken() {
        return this.nextPageToken;
    }

    public final List<SkillItem> getAllItems() {
        List<SkillItem> list = this.items;
        if (list.isEmpty()) {
            list = this.skills;
        }
        return list;
    }
}
