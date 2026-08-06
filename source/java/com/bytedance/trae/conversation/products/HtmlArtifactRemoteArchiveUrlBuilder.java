package com.bytedance.trae.conversation.products;

import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: HtmlArtifactRemoteArchiveUrlBuilder.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlBuilder;", "", "<init>", "()V", "build", "", "explorerUrl", "archivePath", "filename", "xttToken", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class HtmlArtifactRemoteArchiveUrlBuilder {
    public static final HtmlArtifactRemoteArchiveUrlBuilder INSTANCE = new HtmlArtifactRemoteArchiveUrlBuilder();

    private HtmlArtifactRemoteArchiveUrlBuilder() {
    }

    public final String build(String explorerUrl, String archivePath, String filename, String xttToken) {
        Intrinsics.checkNotNullParameter(explorerUrl, "explorerUrl");
        Intrinsics.checkNotNullParameter(archivePath, "archivePath");
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(xttToken, "xttToken");
        return StringsKt.trimEnd(explorerUrl, new char[]{'/'}) + "/archive.zip?path=" + URLEncoder.encode(archivePath, "UTF-8") + "&filename=" + URLEncoder.encode(filename, "UTF-8") + "&authorization=" + URLEncoder.encode("Cloud-IDE-JWT " + xttToken, "UTF-8");
    }
}
