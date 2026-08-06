package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParsedChatMessage.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J8\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/im/model/SearchReferenceData;", "", "references", "", "Lcom/bytedance/trae/im/model/SearchReference;", "status", "", "errorCode", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;)V", "getReferences", "()Ljava/util/List;", "getStatus", "()Ljava/lang/String;", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/trae/im/model/SearchReferenceData;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SearchReferenceData {

    @SerializedName("error_code")
    private final Integer errorCode;

    @SerializedName("references")
    private final List<SearchReference> references;

    @SerializedName("status")
    private final String status;

    public SearchReferenceData() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchReferenceData copy$default(SearchReferenceData searchReferenceData, List list, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            list = searchReferenceData.references;
        }
        if ((i & 2) != 0) {
            str = searchReferenceData.status;
        }
        if ((i & 4) != 0) {
            num = searchReferenceData.errorCode;
        }
        return searchReferenceData.copy(list, str, num);
    }

    public final List<SearchReference> component1() {
        return this.references;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final SearchReferenceData copy(List<SearchReference> references, String status, Integer errorCode) {
        return new SearchReferenceData(references, status, errorCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchReferenceData)) {
            return false;
        }
        SearchReferenceData searchReferenceData = (SearchReferenceData) other;
        return Intrinsics.areEqual(this.references, searchReferenceData.references) && Intrinsics.areEqual(this.status, searchReferenceData.status) && Intrinsics.areEqual(this.errorCode, searchReferenceData.errorCode);
    }

    public int hashCode() {
        List<SearchReference> list = this.references;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.status;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.errorCode;
        return hashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "SearchReferenceData(references=" + this.references + ", status=" + this.status + ", errorCode=" + this.errorCode + ')';
    }

    public SearchReferenceData(List<SearchReference> list, String str, Integer num) {
        this.references = list;
        this.status = str;
        this.errorCode = num;
    }

    public /* synthetic */ SearchReferenceData(List list, String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num);
    }

    public final List<SearchReference> getReferences() {
        return this.references;
    }

    public final String getStatus() {
        return this.status;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }
}
