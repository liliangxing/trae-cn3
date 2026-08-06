package com.bytedance.pia.core;

import android.net.Uri;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.metrics.PiaMetrics;
import com.bytedance.pia.core.setting.SettingService;
import com.bytedance.pia.core.utils.Logger;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PiaManifest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B7\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0005R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/bytedance/pia/core/PiaManifest;", "", "uri", "Landroid/net/Uri;", "pageName", "", "publicPath", "enableWorker", "", "enableSnapshot", "enableNsr", "(Landroid/net/Uri;Ljava/lang/String;Landroid/net/Uri;ZZZ)V", "getEnableNsr", "()Z", "getEnableSnapshot", "getEnableWorker", "getPageName", "()Ljava/lang/String;", "getPublicPath", "()Landroid/net/Uri;", "getUri", "getNsrScriptPath", "getPrefetchScriptPath", "Companion", "InlineManifest", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PiaManifest {
    private static final String HTTPS_SCHEME = "https://";
    private static final String HTTP_SCHEME = "http://";
    private static final String INLINE_MANIFEST_KEY = "__pia_manifest__";
    public static final String UserAgent = " PIA/2.0.0";
    private final boolean enableNsr;
    private final boolean enableSnapshot;
    private final boolean enableWorker;
    private final String pageName;
    private final Uri publicPath;
    private final Uri uri;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Gson gson = new Gson();

    public /* synthetic */ PiaManifest(Uri uri, String str, Uri uri2, boolean z, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, str, uri2, z, z2, z3);
    }

    private PiaManifest(Uri uri, String str, Uri uri2, boolean z, boolean z2, boolean z3) {
        this.uri = uri;
        this.pageName = str;
        this.publicPath = uri2;
        this.enableWorker = z;
        this.enableSnapshot = z2;
        this.enableNsr = z3;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final Uri getPublicPath() {
        return this.publicPath;
    }

    public final boolean getEnableWorker() {
        return this.enableWorker;
    }

    public final boolean getEnableSnapshot() {
        return this.enableSnapshot;
    }

    public final boolean getEnableNsr() {
        return this.enableNsr;
    }

    public final String getPrefetchScriptPath() {
        String uri = Uri.withAppendedPath(this.publicPath, "assets/js/" + this.pageName + ".pia.worker.js").toString();
        Intrinsics.checkNotNullExpressionValue(uri, "withAppendedPath(publicP…ia.worker.js\").toString()");
        return uri;
    }

    public final String getNsrScriptPath() {
        String uri = Uri.withAppendedPath(this.publicPath, "assets/js/" + this.pageName + ".pia.nsr.js").toString();
        Intrinsics.checkNotNullExpressionValue(uri, "withAppendedPath(publicP…}.pia.nsr.js\").toString()");
        return uri;
    }

    /* compiled from: PiaManifest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/pia/core/PiaManifest$Companion;", "", "()V", "HTTPS_SCHEME", "", "HTTP_SCHEME", "INLINE_MANIFEST_KEY", "UserAgent", "gson", "Lcom/google/gson/Gson;", "create", "Lcom/bytedance/pia/core/PiaManifest;", "url", "context", "Lcom/bytedance/pia/core/PiaContext;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PiaManifest create(String str) {
            return create$default(this, str, null, 2, null);
        }

        private Companion() {
        }

        public static /* synthetic */ PiaManifest create$default(Companion companion, String str, PiaContext piaContext, int i, Object obj) {
            if ((i & 2) != 0) {
                piaContext = null;
            }
            return companion.create(str, piaContext);
        }

        public final PiaManifest create(String url, PiaContext context) {
            Object obj;
            PiaMetrics metrics;
            Object obj2;
            PiaMetrics metrics2;
            List split$default;
            if (((url == null || StringsKt.startsWith$default(url, PiaManifest.HTTP_SCHEME, false, 2, (Object) null)) ? false : true) && !StringsKt.startsWith$default(url, PiaManifest.HTTPS_SCHEME, false, 2, (Object) null)) {
                return null;
            }
            if (!(url != null && StringsKt.contains$default(url, "__pia_manifest__", false, 2, (Object) null))) {
                return null;
            }
            Uri parse = Uri.parse(url);
            try {
                Result.Companion companion = Result.Companion;
                Object fromJson = PiaManifest.gson.fromJson(parse.getQueryParameter("__pia_manifest__"), InlineManifest.class);
                Intrinsics.checkNotNull(fromJson);
                obj = Result.constructor-impl((InlineManifest) fromJson);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.exceptionOrNull-impl(obj) != null) {
                if (context != null && (metrics = context.getMetrics()) != null) {
                    metrics.onError(ErrorType.MANIFEST, 1005);
                }
                return null;
            }
            InlineManifest inlineManifest = (InlineManifest) obj;
            Logger.i$default("[Manifest] Parse inline manifest (InlineManifest: " + inlineManifest + ')', null, null, 6, null);
            String pageName = inlineManifest.getPageName();
            if (pageName == null) {
                String lastPathSegment = parse.getLastPathSegment();
                pageName = (lastPathSegment == null || (split$default = StringsKt.split$default(lastPathSegment, new char[]{'.'}, false, 0, 6, (Object) null)) == null) ? null : (String) split$default.get(0);
                if (pageName == null) {
                    return null;
                }
            }
            String str = pageName;
            SettingService.INSTANCE.updateAsync();
            String publicPath = inlineManifest.getPublicPath();
            if (publicPath != null) {
                try {
                    Result.Companion companion3 = Result.Companion;
                    obj2 = Result.constructor-impl(Uri.parse(publicPath));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                }
                if (Result.exceptionOrNull-impl(obj2) == null) {
                    Uri uri = (Uri) obj2;
                    if (uri == null || uri.isRelative()) {
                        return null;
                    }
                    if (!Intrinsics.areEqual(uri.getScheme(), "http") && !Intrinsics.areEqual(uri.getScheme(), "https")) {
                        return null;
                    }
                    Intrinsics.checkNotNullExpressionValue(parse, "uri");
                    Boolean worker = inlineManifest.getWorker();
                    boolean booleanValue = worker != null ? worker.booleanValue() : false;
                    Boolean snapshot = inlineManifest.getSnapshot();
                    boolean booleanValue2 = snapshot != null ? snapshot.booleanValue() : false;
                    Boolean nsr = inlineManifest.getNsr();
                    return new PiaManifest(parse, str, uri, booleanValue, booleanValue2, nsr != null ? nsr.booleanValue() : false, null);
                }
                if (context != null && (metrics2 = context.getMetrics()) != null) {
                    metrics2.onError(ErrorType.MANIFEST, 1006);
                }
            }
            return null;
        }
    }

    /* compiled from: PiaManifest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJJ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\r¨\u0006%"}, d2 = {"Lcom/bytedance/pia/core/PiaManifest$InlineManifest;", "", ErrorType.WORKER, "", "publicPath", "", "pageName", ErrorType.SNAPSHOT, "nsr", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getNsr", "()Ljava/lang/Boolean;", "setNsr", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "getPublicPath", "setPublicPath", "getSnapshot", "setSnapshot", "getWorker", "setWorker", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/pia/core/PiaManifest$InlineManifest;", "equals", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class InlineManifest {

        @SerializedName("nsr")
        private Boolean nsr;

        @SerializedName("page_name")
        private String pageName;

        @SerializedName("public_path")
        private String publicPath;

        @SerializedName(ErrorType.SNAPSHOT)
        private Boolean snapshot;

        @SerializedName(ErrorType.WORKER)
        private Boolean worker;

        public static /* synthetic */ InlineManifest copy$default(InlineManifest inlineManifest, Boolean bool, String str, String str2, Boolean bool2, Boolean bool3, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = inlineManifest.worker;
            }
            if ((i & 2) != 0) {
                str = inlineManifest.publicPath;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                str2 = inlineManifest.pageName;
            }
            String str4 = str2;
            if ((i & 8) != 0) {
                bool2 = inlineManifest.snapshot;
            }
            Boolean bool4 = bool2;
            if ((i & 16) != 0) {
                bool3 = inlineManifest.nsr;
            }
            return inlineManifest.copy(bool, str3, str4, bool4, bool3);
        }

        /* renamed from: component1, reason: from getter */
        public final Boolean getWorker() {
            return this.worker;
        }

        /* renamed from: component2, reason: from getter */
        public final String getPublicPath() {
            return this.publicPath;
        }

        /* renamed from: component3, reason: from getter */
        public final String getPageName() {
            return this.pageName;
        }

        /* renamed from: component4, reason: from getter */
        public final Boolean getSnapshot() {
            return this.snapshot;
        }

        /* renamed from: component5, reason: from getter */
        public final Boolean getNsr() {
            return this.nsr;
        }

        public final InlineManifest copy(Boolean worker, String publicPath, String pageName, Boolean snapshot, Boolean nsr) {
            return new InlineManifest(worker, publicPath, pageName, snapshot, nsr);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InlineManifest)) {
                return false;
            }
            InlineManifest inlineManifest = (InlineManifest) other;
            return Intrinsics.areEqual(this.worker, inlineManifest.worker) && Intrinsics.areEqual(this.publicPath, inlineManifest.publicPath) && Intrinsics.areEqual(this.pageName, inlineManifest.pageName) && Intrinsics.areEqual(this.snapshot, inlineManifest.snapshot) && Intrinsics.areEqual(this.nsr, inlineManifest.nsr);
        }

        public int hashCode() {
            Boolean bool = this.worker;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            String str = this.publicPath;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.pageName;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Boolean bool2 = this.snapshot;
            int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.nsr;
            return hashCode4 + (bool3 != null ? bool3.hashCode() : 0);
        }

        public String toString() {
            return "InlineManifest(worker=" + this.worker + ", publicPath=" + this.publicPath + ", pageName=" + this.pageName + ", snapshot=" + this.snapshot + ", nsr=" + this.nsr + ')';
        }

        public InlineManifest(Boolean bool, String str, String str2, Boolean bool2, Boolean bool3) {
            this.worker = bool;
            this.publicPath = str;
            this.pageName = str2;
            this.snapshot = bool2;
            this.nsr = bool3;
        }

        public final Boolean getWorker() {
            return this.worker;
        }

        public final void setWorker(Boolean bool) {
            this.worker = bool;
        }

        public final String getPublicPath() {
            return this.publicPath;
        }

        public final void setPublicPath(String str) {
            this.publicPath = str;
        }

        public final String getPageName() {
            return this.pageName;
        }

        public final void setPageName(String str) {
            this.pageName = str;
        }

        public final Boolean getSnapshot() {
            return this.snapshot;
        }

        public final void setSnapshot(Boolean bool) {
            this.snapshot = bool;
        }

        public final Boolean getNsr() {
            return this.nsr;
        }

        public final void setNsr(Boolean bool) {
            this.nsr = bool;
        }
    }
}
