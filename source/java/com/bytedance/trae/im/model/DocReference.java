package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParsedChatMessage.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/im/model/DocReference;", "", "type", "", "title", "link", "favicon", "snippet", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getTitle", "getLink", "getFavicon", "getSnippet", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DocReference {

    @SerializedName("favicon")
    private final String favicon;

    @SerializedName("link")
    private final String link;

    @SerializedName("snippet")
    private final String snippet;

    @SerializedName("title")
    private final String title;

    @SerializedName("type")
    private final String type;

    public DocReference() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ DocReference copy$default(DocReference docReference, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = docReference.type;
        }
        if ((i & 2) != 0) {
            str2 = docReference.title;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = docReference.link;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = docReference.favicon;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = docReference.snippet;
        }
        return docReference.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFavicon() {
        return this.favicon;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSnippet() {
        return this.snippet;
    }

    public final DocReference copy(String type, String title, String link, String favicon, String snippet) {
        return new DocReference(type, title, link, favicon, snippet);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocReference)) {
            return false;
        }
        DocReference docReference = (DocReference) other;
        return Intrinsics.areEqual(this.type, docReference.type) && Intrinsics.areEqual(this.title, docReference.title) && Intrinsics.areEqual(this.link, docReference.link) && Intrinsics.areEqual(this.favicon, docReference.favicon) && Intrinsics.areEqual(this.snippet, docReference.snippet);
    }

    public int hashCode() {
        String str = this.type;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.link;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.favicon;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.snippet;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "DocReference(type=" + this.type + ", title=" + this.title + ", link=" + this.link + ", favicon=" + this.favicon + ", snippet=" + this.snippet + ')';
    }

    public DocReference(String str, String str2, String str3, String str4, String str5) {
        this.type = str;
        this.title = str2;
        this.link = str3;
        this.favicon = str4;
        this.snippet = str5;
    }

    public /* synthetic */ DocReference(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    public final String getType() {
        return this.type;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getFavicon() {
        return this.favicon;
    }

    public final String getSnippet() {
        return this.snippet;
    }
}
