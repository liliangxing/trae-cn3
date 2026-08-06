package com.bytedance.trae.conversation.products;

import com.bytedance.trae.conversation.products.HtmlArtifactPreviewFailure;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: HtmlArtifactPreviewRetryPolicy.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\u00020\t*\u00020\u0007H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewRetryPolicy;", "", "<init>", "()V", "nextRemoteResolveMode", "Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;", "failure", "Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;", "requiresSandboxReady", "", "isSessionOfflineArchiveError", "message", "", "HTTP_STATUS_SERVICE_UNAVAILABLE", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class HtmlArtifactPreviewRetryPolicy {
    private static final int HTTP_STATUS_SERVICE_UNAVAILABLE = 503;
    public static final HtmlArtifactPreviewRetryPolicy INSTANCE = new HtmlArtifactPreviewRetryPolicy();

    private HtmlArtifactPreviewRetryPolicy() {
    }

    public final HtmlArtifactRemoteArchiveResolveMode nextRemoteResolveMode(HtmlArtifactPreviewFailure failure) {
        Intrinsics.checkNotNullParameter(failure, "failure");
        if (requiresSandboxReady(failure)) {
            return HtmlArtifactRemoteArchiveResolveMode.ENSURE_SANDBOX_READY;
        }
        return HtmlArtifactRemoteArchiveResolveMode.DIRECT_ARCHIVE;
    }

    private final boolean requiresSandboxReady(HtmlArtifactPreviewFailure htmlArtifactPreviewFailure) {
        HtmlArtifactPreviewFailure.ArchiveDownload archiveDownload;
        Integer httpStatusCode;
        if (htmlArtifactPreviewFailure instanceof HtmlArtifactPreviewFailure.UrlUnavailable) {
            return true;
        }
        return (htmlArtifactPreviewFailure instanceof HtmlArtifactPreviewFailure.ArchiveDownload) && (((httpStatusCode = (archiveDownload = (HtmlArtifactPreviewFailure.ArchiveDownload) htmlArtifactPreviewFailure).getHttpStatusCode()) != null && httpStatusCode.intValue() == HTTP_STATUS_SERVICE_UNAVAILABLE) || isSessionOfflineArchiveError(archiveDownload.getMessage()));
    }

    private final boolean isSessionOfflineArchiveError(String message) {
        String str = message;
        if (str == null || StringsKt.isBlank(str)) {
            return false;
        }
        return StringsKt.contains$default(str, "\"code\":101", false, 2, (Object) null) || StringsKt.contains$default(str, "code=101", false, 2, (Object) null) || StringsKt.contains$default(str, "SessionOffline", false, 2, (Object) null) || StringsKt.contains$default(str, "Archive download is disabled in offline mode", false, 2, (Object) null);
    }
}
