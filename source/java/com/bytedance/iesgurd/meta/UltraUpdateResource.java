package com.bytedance.iesgurd.meta;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PrepareMetaPackage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0081\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u001e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003J\t\u0010\u001b\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/iesgurd/meta/UltraUpdateResource;", "", "schema", "", "domains", "", "resourcePrefix", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getDomains", "()Ljava/util/List;", "getResourcePrefix", "()Ljava/lang/String;", "setResourcePrefix", "(Ljava/lang/String;)V", "getSchema", "component1", "component2", "component3", "copy", "equals", "", "other", "getUrl", "index", "", "channel", SchemaConstants.QUERY_KEY_BUNDLE, "hashCode", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class UltraUpdateResource {

    @SerializedName("domains")
    private final List<String> domains;

    @SerializedName("resource_prefix")
    private String resourcePrefix;

    @SerializedName("schema")
    private final String schema;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UltraUpdateResource copy$default(UltraUpdateResource ultraUpdateResource, String str, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ultraUpdateResource.schema;
        }
        if ((i & 2) != 0) {
            list = ultraUpdateResource.domains;
        }
        if ((i & 4) != 0) {
            str2 = ultraUpdateResource.resourcePrefix;
        }
        return ultraUpdateResource.copy(str, list, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSchema() {
        return this.schema;
    }

    public final List<String> component2() {
        return this.domains;
    }

    /* renamed from: component3, reason: from getter */
    public final String getResourcePrefix() {
        return this.resourcePrefix;
    }

    public final UltraUpdateResource copy(String schema, List<String> domains, String resourcePrefix) {
        Intrinsics.checkParameterIsNotNull(schema, "schema");
        Intrinsics.checkParameterIsNotNull(domains, "domains");
        Intrinsics.checkParameterIsNotNull(resourcePrefix, "resourcePrefix");
        return new UltraUpdateResource(schema, domains, resourcePrefix);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UltraUpdateResource)) {
            return false;
        }
        UltraUpdateResource ultraUpdateResource = (UltraUpdateResource) other;
        return Intrinsics.areEqual(this.schema, ultraUpdateResource.schema) && Intrinsics.areEqual(this.domains, ultraUpdateResource.domains) && Intrinsics.areEqual(this.resourcePrefix, ultraUpdateResource.resourcePrefix);
    }

    public int hashCode() {
        String str = this.schema;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.domains;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.resourcePrefix;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "UltraUpdateResource(schema=" + this.schema + ", domains=" + this.domains + ", resourcePrefix=" + this.resourcePrefix + ")";
    }

    public UltraUpdateResource(String str, List<String> list, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "schema");
        Intrinsics.checkParameterIsNotNull(list, "domains");
        Intrinsics.checkParameterIsNotNull(str2, "resourcePrefix");
        this.schema = str;
        this.domains = list;
        this.resourcePrefix = str2;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final List<String> getDomains() {
        return this.domains;
    }

    public final String getResourcePrefix() {
        return this.resourcePrefix;
    }

    public final void setResourcePrefix(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.resourcePrefix = str;
    }

    public final String getUrl(int index, String channel, String bundle) {
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Intrinsics.checkParameterIsNotNull(bundle, SchemaConstants.QUERY_KEY_BUNDLE);
        String str = this.domains.get(index);
        if (!StringsKt.endsWith$default(str, "/", false, 2, (Object) null) && !StringsKt.startsWith$default(this.resourcePrefix, "/", false, 2, (Object) null)) {
            str = str + "/";
        }
        if (!StringsKt.endsWith$default(this.resourcePrefix, "/", false, 2, (Object) null)) {
            this.resourcePrefix += "/";
        }
        return this.schema + "://" + str + this.resourcePrefix + channel + '/' + bundle;
    }
}
