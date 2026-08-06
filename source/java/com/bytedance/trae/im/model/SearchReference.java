package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParsedChatMessage.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jh\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\tHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006'"}, d2 = {"Lcom/bytedance/trae/im/model/SearchReference;", "", "title", "", "link", "snippets", "", "favicon", "index", "", "description", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getLink", "getSnippets", "()Ljava/util/List;", "getFavicon", "getIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDescription", "getContent", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/trae/im/model/SearchReference;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SearchReference {

    @SerializedName("content")
    private final String content;

    @SerializedName("description")
    private final String description;

    @SerializedName("favicon")
    private final String favicon;

    @SerializedName("index")
    private final Integer index;

    @SerializedName("link")
    private final String link;

    @SerializedName("snippets")
    private final List<String> snippets;

    @SerializedName("title")
    private final String title;

    public SearchReference() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ SearchReference copy$default(SearchReference searchReference, String str, String str2, List list, String str3, Integer num, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = searchReference.title;
        }
        if ((i & 2) != 0) {
            str2 = searchReference.link;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            list = searchReference.snippets;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            str3 = searchReference.favicon;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            num = searchReference.index;
        }
        Integer num2 = num;
        if ((i & 32) != 0) {
            str4 = searchReference.description;
        }
        String str8 = str4;
        if ((i & 64) != 0) {
            str5 = searchReference.content;
        }
        return searchReference.copy(str, str6, list2, str7, num2, str8, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    public final List<String> component3() {
        return this.snippets;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFavicon() {
        return this.favicon;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getIndex() {
        return this.index;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component7, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final SearchReference copy(String title, String link, List<String> snippets, String favicon, Integer index, String description, String content) {
        return new SearchReference(title, link, snippets, favicon, index, description, content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchReference)) {
            return false;
        }
        SearchReference searchReference = (SearchReference) other;
        return Intrinsics.areEqual(this.title, searchReference.title) && Intrinsics.areEqual(this.link, searchReference.link) && Intrinsics.areEqual(this.snippets, searchReference.snippets) && Intrinsics.areEqual(this.favicon, searchReference.favicon) && Intrinsics.areEqual(this.index, searchReference.index) && Intrinsics.areEqual(this.description, searchReference.description) && Intrinsics.areEqual(this.content, searchReference.content);
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.link;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.snippets;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.favicon;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.index;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.description;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.content;
        return hashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "SearchReference(title=" + this.title + ", link=" + this.link + ", snippets=" + this.snippets + ", favicon=" + this.favicon + ", index=" + this.index + ", description=" + this.description + ", content=" + this.content + ')';
    }

    public SearchReference(String str, String str2, List<String> list, String str3, Integer num, String str4, String str5) {
        this.title = str;
        this.link = str2;
        this.snippets = list;
        this.favicon = str3;
        this.index = num;
        this.description = str4;
        this.content = str5;
    }

    public /* synthetic */ SearchReference(String str, String str2, List list, String str3, Integer num, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getLink() {
        return this.link;
    }

    public final List<String> getSnippets() {
        return this.snippets;
    }

    public final String getFavicon() {
        return this.favicon;
    }

    public final Integer getIndex() {
        return this.index;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getContent() {
        return this.content;
    }
}
