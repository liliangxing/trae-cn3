package com.bytedance.ies.argus.api.params;

import android.net.Uri;
import com.bytedance.ies.argus.api.ArgusResourceType;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.lynx.tasm.core.ResManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: LoadTemplateParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0015J\b\u0010,\u001a\u00020\u0003H\u0016R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010!\u001a\u0004\b%\u0010 R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0017¨\u0006-"}, d2 = {"Lcom/bytedance/ies/argus/api/params/ArgusResourceLoaderInfo;", "", CDNLoader.DIAGNOSE_SOURCE_URL, "", "cdnUrl", "channel", "bundle", "schemaUrl", "loaderName", "resourceVersion", "", "resourceType", "Lcom/bytedance/ies/argus/api/ArgusResourceType;", "from", "Lcom/bytedance/ies/argus/api/params/ArgusResourceFrom;", "cacheKey", "filePath", "accessKey", "srcUri", "Landroid/net/Uri;", "lastModified", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/bytedance/ies/argus/api/ArgusResourceType;Lcom/bytedance/ies/argus/api/params/ArgusResourceFrom;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/Long;)V", "getAccessKey", "()Ljava/lang/String;", "getBundle", "getCacheKey", "getCdnUrl", "getChannel", "getFilePath", "getFrom", "()Lcom/bytedance/ies/argus/api/params/ArgusResourceFrom;", "getLastModified", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLoaderName", "getResourceType", "()Lcom/bytedance/ies/argus/api/ArgusResourceType;", "getResourceVersion", "getSchemaUrl", "getSourceUrl", "getSrcUri", "()Landroid/net/Uri;", "verifyUrl", "getVerifyUrl", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class ArgusResourceLoaderInfo {
    private final String accessKey;
    private final String bundle;
    private final String cacheKey;
    private final String cdnUrl;
    private final String channel;
    private final String filePath;
    private final ArgusResourceFrom from;
    private final Long lastModified;
    private final String loaderName;
    private final ArgusResourceType resourceType;
    private final Long resourceVersion;
    private final String schemaUrl;
    private final String sourceUrl;
    private final Uri srcUri;
    private final String verifyUrl;

    public ArgusResourceLoaderInfo(String sourceUrl, String str, String str2, String str3, String str4, String loaderName, Long l, ArgusResourceType resourceType, ArgusResourceFrom argusResourceFrom, String str5, String str6, String accessKey, Uri srcUri, Long l2) {
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        Intrinsics.checkNotNullParameter(loaderName, "loaderName");
        Intrinsics.checkNotNullParameter(resourceType, "resourceType");
        Intrinsics.checkNotNullParameter(accessKey, "accessKey");
        Intrinsics.checkNotNullParameter(srcUri, "srcUri");
        this.sourceUrl = sourceUrl;
        this.cdnUrl = str;
        this.channel = str2;
        this.bundle = str3;
        this.schemaUrl = str4;
        this.loaderName = loaderName;
        this.resourceVersion = l;
        this.resourceType = resourceType;
        this.from = argusResourceFrom;
        this.cacheKey = str5;
        this.filePath = str6;
        this.accessKey = accessKey;
        this.srcUri = srcUri;
        this.lastModified = l2;
        if (str == null || (!StringsKt.startsWith$default(str, ResManager.HTTP_SCHEME, false, 2, (Object) null) && !StringsKt.startsWith$default(str, "https://", false, 2, (Object) null))) {
            if (str2 != null) {
                str = "gecko://" + str2 + '/' + (str3 != null ? StringsKt.trimStart(str3, '/') : null);
            } else {
                str = (str4 == null || !(StringsKt.startsWith$default(str4, ResManager.HTTP_SCHEME, false, 2, (Object) null) || StringsKt.startsWith$default(str4, "https://", false, 2, (Object) null))) ? "unknown://biz/" + sourceUrl : str4;
            }
        }
        this.verifyUrl = str;
    }

    public /* synthetic */ ArgusResourceLoaderInfo(String str, String str2, String str3, String str4, String str5, String str6, Long l, ArgusResourceType argusResourceType, ArgusResourceFrom argusResourceFrom, String str7, String str8, String str9, Uri uri, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, str6, (i & 64) != 0 ? null : l, argusResourceType, (i & 256) != 0 ? null : argusResourceFrom, (i & 512) != 0 ? null : str7, (i & 1024) != 0 ? null : str8, str9, uri, (i & 8192) != 0 ? null : l2);
    }

    public final String getSourceUrl() {
        return this.sourceUrl;
    }

    public final String getCdnUrl() {
        return this.cdnUrl;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getBundle() {
        return this.bundle;
    }

    public final String getSchemaUrl() {
        return this.schemaUrl;
    }

    public final String getLoaderName() {
        return this.loaderName;
    }

    public final Long getResourceVersion() {
        return this.resourceVersion;
    }

    public final ArgusResourceType getResourceType() {
        return this.resourceType;
    }

    public final ArgusResourceFrom getFrom() {
        return this.from;
    }

    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final Uri getSrcUri() {
        return this.srcUri;
    }

    public final Long getLastModified() {
        return this.lastModified;
    }

    public final String getVerifyUrl() {
        return this.verifyUrl;
    }

    public String toString() {
        return "LynxSignResourceInfo(verifyUrl=" + this.verifyUrl + ", sourceUrl=" + this.sourceUrl + ", cdnUrl=" + this.cdnUrl + ", channel=" + this.channel + ", bundle=" + this.bundle + ", schemaUrl=" + this.schemaUrl + ", loaderName=" + this.loaderName + ", resourceVersion=" + this.resourceVersion + ')';
    }
}
