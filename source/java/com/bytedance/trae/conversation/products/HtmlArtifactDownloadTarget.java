package com.bytedance.trae.conversation.products;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: HtmlArtifactDownloadTarget.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\nR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;", "", "localRequestPath", "", "remoteArchivePath", "savePath", "requestedHtmlName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLocalRequestPath", "()Ljava/lang/String;", "getRemoteArchivePath", "getSavePath", "getRequestedHtmlName", "requestPath", "getRequestPath", "archiveFileName", "getArchiveFileName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class HtmlArtifactDownloadTarget {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String localRequestPath;
    private final String remoteArchivePath;
    private final String requestedHtmlName;
    private final String savePath;

    public static /* synthetic */ HtmlArtifactDownloadTarget copy$default(HtmlArtifactDownloadTarget htmlArtifactDownloadTarget, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = htmlArtifactDownloadTarget.localRequestPath;
        }
        if ((i & 2) != 0) {
            str2 = htmlArtifactDownloadTarget.remoteArchivePath;
        }
        if ((i & 4) != 0) {
            str3 = htmlArtifactDownloadTarget.savePath;
        }
        if ((i & 8) != 0) {
            str4 = htmlArtifactDownloadTarget.requestedHtmlName;
        }
        return htmlArtifactDownloadTarget.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLocalRequestPath() {
        return this.localRequestPath;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRemoteArchivePath() {
        return this.remoteArchivePath;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSavePath() {
        return this.savePath;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRequestedHtmlName() {
        return this.requestedHtmlName;
    }

    public final HtmlArtifactDownloadTarget copy(String localRequestPath, String remoteArchivePath, String savePath, String requestedHtmlName) {
        Intrinsics.checkNotNullParameter(localRequestPath, "localRequestPath");
        Intrinsics.checkNotNullParameter(remoteArchivePath, "remoteArchivePath");
        Intrinsics.checkNotNullParameter(savePath, "savePath");
        Intrinsics.checkNotNullParameter(requestedHtmlName, "requestedHtmlName");
        return new HtmlArtifactDownloadTarget(localRequestPath, remoteArchivePath, savePath, requestedHtmlName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HtmlArtifactDownloadTarget)) {
            return false;
        }
        HtmlArtifactDownloadTarget htmlArtifactDownloadTarget = (HtmlArtifactDownloadTarget) other;
        return Intrinsics.areEqual(this.localRequestPath, htmlArtifactDownloadTarget.localRequestPath) && Intrinsics.areEqual(this.remoteArchivePath, htmlArtifactDownloadTarget.remoteArchivePath) && Intrinsics.areEqual(this.savePath, htmlArtifactDownloadTarget.savePath) && Intrinsics.areEqual(this.requestedHtmlName, htmlArtifactDownloadTarget.requestedHtmlName);
    }

    public int hashCode() {
        return (((((this.localRequestPath.hashCode() * 31) + this.remoteArchivePath.hashCode()) * 31) + this.savePath.hashCode()) * 31) + this.requestedHtmlName.hashCode();
    }

    public String toString() {
        return "HtmlArtifactDownloadTarget(localRequestPath=" + this.localRequestPath + ", remoteArchivePath=" + this.remoteArchivePath + ", savePath=" + this.savePath + ", requestedHtmlName=" + this.requestedHtmlName + ')';
    }

    public HtmlArtifactDownloadTarget(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "localRequestPath");
        Intrinsics.checkNotNullParameter(str2, "remoteArchivePath");
        Intrinsics.checkNotNullParameter(str3, "savePath");
        Intrinsics.checkNotNullParameter(str4, "requestedHtmlName");
        this.localRequestPath = str;
        this.remoteArchivePath = str2;
        this.savePath = str3;
        this.requestedHtmlName = str4;
    }

    public final String getLocalRequestPath() {
        return this.localRequestPath;
    }

    public final String getRemoteArchivePath() {
        return this.remoteArchivePath;
    }

    public final String getSavePath() {
        return this.savePath;
    }

    public final String getRequestedHtmlName() {
        return this.requestedHtmlName;
    }

    public final String getRequestPath() {
        return this.localRequestPath;
    }

    public final String getArchiveFileName() {
        return INSTANCE.substringAfterLastPathSeparator(this.savePath);
    }

    /* compiled from: HtmlArtifactDownloadTarget.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\u00020\u0007*\u00020\u0007H\u0002J\f\u0010\t\u001a\u00020\u0007*\u00020\u0007H\u0002J\f\u0010\n\u001a\u00020\u0007*\u00020\u0007H\u0002J\f\u0010\u000b\u001a\u00020\f*\u00020\u0007H\u0002J\f\u0010\r\u001a\u00020\u0007*\u00020\u0007H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;", "", "<init>", "()V", "fromPreviewPath", "Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;", "previewPath", "", "toZipSavePath", "parentPath", "substringAfterLastPathSeparator", "lastPathSeparatorIndex", "", "normalizePathSeparators", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HtmlArtifactDownloadTarget fromPreviewPath(String previewPath) {
            Intrinsics.checkNotNullParameter(previewPath, "previewPath");
            return new HtmlArtifactDownloadTarget(previewPath, parentPath(previewPath), normalizePathSeparators(toZipSavePath(previewPath)), substringAfterLastPathSeparator(previewPath));
        }

        private final String toZipSavePath(String str) {
            return str.length() == 0 ? str : StringsKt.endsWith(str, ".html", true) ? StringsKt.dropLast(str, 5) + ".zip" : StringsKt.endsWith(str, ".htm", true) ? StringsKt.dropLast(str, 4) + ".zip" : StringsKt.endsWith(str, ".zip", true) ? str : str + ".zip";
        }

        private final String parentPath(String str) {
            String normalizePathSeparators = normalizePathSeparators(StringsKt.trim(str, new char[]{'/', '\\'}));
            int lastPathSeparatorIndex = lastPathSeparatorIndex(normalizePathSeparators);
            if (lastPathSeparatorIndex < 0) {
                return "";
            }
            String substring = normalizePathSeparators.substring(0, lastPathSeparatorIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String substringAfterLastPathSeparator(String str) {
            int lastPathSeparatorIndex = lastPathSeparatorIndex(str);
            if (lastPathSeparatorIndex < 0) {
                return str;
            }
            String substring = str.substring(lastPathSeparatorIndex + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }

        private final int lastPathSeparatorIndex(String str) {
            String str2 = str;
            return Math.max(StringsKt.lastIndexOf$default(str2, '/', 0, false, 6, (Object) null), StringsKt.lastIndexOf$default(str2, '\\', 0, false, 6, (Object) null));
        }

        private final String normalizePathSeparators(String str) {
            return StringsKt.replace$default(str, '\\', '/', false, 4, (Object) null);
        }
    }
}
