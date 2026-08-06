package com.bytedance.iesgurd.meta;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrepareMetaPackage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tBM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u0006\u0010 \u001a\u00020!J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\fHÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0010HÆ\u0003Ja\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00062\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010+\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\fJ\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u000e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/bytedance/iesgurd/meta/PrepareMetaPackage;", "", "()V", "id", "", "md5", "", "length", "url", "(JLjava/lang/String;JLjava/lang/String;)V", "schema", "domains", "", "uri", "decompressMd5", "ultraUpdateResource", "Lcom/bytedance/iesgurd/meta/UltraUpdateResource;", "(JLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/bytedance/iesgurd/meta/UltraUpdateResource;)V", "getDecompressMd5", "()Ljava/lang/String;", "getDomains", "()Ljava/util/List;", "getId", "()J", "getLength", "getMd5", "getSchema", "getUltraUpdateResource", "()Lcom/bytedance/iesgurd/meta/UltraUpdateResource;", "getUri", "urlList", "", "checkValid", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "getUrlList", "hashCode", "", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class PrepareMetaPackage {

    @SerializedName("decompress_md5")
    private final String decompressMd5;

    @SerializedName("domains")
    private final List<String> domains;

    @SerializedName("id")
    private final long id;

    @SerializedName("size")
    private final long length;

    @SerializedName("md5")
    private final String md5;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("ultra_update_resource")
    private final UltraUpdateResource ultraUpdateResource;

    @SerializedName("uri")
    private final String uri;
    private List<String> urlList;

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSchema() {
        return this.schema;
    }

    public final List<String> component3() {
        return this.domains;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDecompressMd5() {
        return this.decompressMd5;
    }

    /* renamed from: component7, reason: from getter */
    public final long getLength() {
        return this.length;
    }

    /* renamed from: component8, reason: from getter */
    public final UltraUpdateResource getUltraUpdateResource() {
        return this.ultraUpdateResource;
    }

    public final PrepareMetaPackage copy(long id, String schema, List<String> domains, String uri, String md5, String decompressMd5, long length, UltraUpdateResource ultraUpdateResource) {
        Intrinsics.checkParameterIsNotNull(schema, "schema");
        Intrinsics.checkParameterIsNotNull(domains, "domains");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(md5, "md5");
        Intrinsics.checkParameterIsNotNull(decompressMd5, "decompressMd5");
        return new PrepareMetaPackage(id, schema, domains, uri, md5, decompressMd5, length, ultraUpdateResource);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrepareMetaPackage)) {
            return false;
        }
        PrepareMetaPackage prepareMetaPackage = (PrepareMetaPackage) other;
        return this.id == prepareMetaPackage.id && Intrinsics.areEqual(this.schema, prepareMetaPackage.schema) && Intrinsics.areEqual(this.domains, prepareMetaPackage.domains) && Intrinsics.areEqual(this.uri, prepareMetaPackage.uri) && Intrinsics.areEqual(this.md5, prepareMetaPackage.md5) && Intrinsics.areEqual(this.decompressMd5, prepareMetaPackage.decompressMd5) && this.length == prepareMetaPackage.length && Intrinsics.areEqual(this.ultraUpdateResource, prepareMetaPackage.ultraUpdateResource);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.schema;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        List<String> list = this.domains;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.uri;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.md5;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.decompressMd5;
        int hashCode5 = str4 != null ? str4.hashCode() : 0;
        long j2 = this.length;
        int i2 = (((hashCode4 + hashCode5) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31;
        UltraUpdateResource ultraUpdateResource = this.ultraUpdateResource;
        return i2 + (ultraUpdateResource != null ? ultraUpdateResource.hashCode() : 0);
    }

    public String toString() {
        return "PrepareMetaPackage(id=" + this.id + ", schema=" + this.schema + ", domains=" + this.domains + ", uri=" + this.uri + ", md5=" + this.md5 + ", decompressMd5=" + this.decompressMd5 + ", length=" + this.length + ", ultraUpdateResource=" + this.ultraUpdateResource + ")";
    }

    public PrepareMetaPackage(long j, String str, List<String> list, String str2, String str3, String str4, long j2, UltraUpdateResource ultraUpdateResource) {
        Intrinsics.checkParameterIsNotNull(str, "schema");
        Intrinsics.checkParameterIsNotNull(list, "domains");
        Intrinsics.checkParameterIsNotNull(str2, "uri");
        Intrinsics.checkParameterIsNotNull(str3, "md5");
        Intrinsics.checkParameterIsNotNull(str4, "decompressMd5");
        this.id = j;
        this.schema = str;
        this.domains = list;
        this.uri = str2;
        this.md5 = str3;
        this.decompressMd5 = str4;
        this.length = j2;
        this.ultraUpdateResource = ultraUpdateResource;
    }

    public final long getId() {
        return this.id;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final List<String> getDomains() {
        return this.domains;
    }

    public final String getUri() {
        return this.uri;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getDecompressMd5() {
        return this.decompressMd5;
    }

    public final long getLength() {
        return this.length;
    }

    public final UltraUpdateResource getUltraUpdateResource() {
        return this.ultraUpdateResource;
    }

    public PrepareMetaPackage() {
        this(0L, "", CollectionsKt.emptyList(), "", "", "", 0L, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PrepareMetaPackage(long j, String str, long j2, String str2) {
        this(j, "", CollectionsKt.emptyList(), "", str, "", j2, null);
        Intrinsics.checkParameterIsNotNull(str, "md5");
        Intrinsics.checkParameterIsNotNull(str2, "url");
        ArrayList arrayList = new ArrayList();
        this.urlList = arrayList;
        arrayList.add(str2);
    }

    public final List<String> getUrlList() {
        if (this.urlList == null) {
            this.urlList = new ArrayList();
            for (String str : this.domains) {
                List<String> list = this.urlList;
                if (list == null) {
                    Intrinsics.throwNpe();
                }
                list.add(this.schema + "://" + str + this.uri);
            }
        }
        List<String> list2 = this.urlList;
        if (list2 == null) {
            Intrinsics.throwNpe();
        }
        return list2;
    }

    public final boolean checkValid() {
        if (this.id < 0) {
            return false;
        }
        String str = this.schema;
        if (str == null || str.length() == 0) {
            return false;
        }
        List<String> list = this.domains;
        if (list == null || list.isEmpty()) {
            return false;
        }
        String str2 = this.uri;
        if (str2 == null || str2.length() == 0) {
            return false;
        }
        String str3 = this.md5;
        return !(str3 == null || str3.length() == 0) && this.length > 0;
    }
}
