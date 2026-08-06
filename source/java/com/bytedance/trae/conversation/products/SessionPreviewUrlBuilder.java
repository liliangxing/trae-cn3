package com.bytedance.trae.conversation.products;

import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SessionPreviewUrlBuilder.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/products/SessionPreviewUrlBuilder;", "", "<init>", "()V", "build", "", "sessionPreviewUrl", "pathSearchHash", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SessionPreviewUrlBuilder {
    public static final SessionPreviewUrlBuilder INSTANCE = new SessionPreviewUrlBuilder();

    private SessionPreviewUrlBuilder() {
    }

    public final String build(String sessionPreviewUrl, String pathSearchHash) {
        Intrinsics.checkNotNullParameter(sessionPreviewUrl, "sessionPreviewUrl");
        Intrinsics.checkNotNullParameter(pathSearchHash, "pathSearchHash");
        URL url = new URL(sessionPreviewUrl);
        String path = url.getPath();
        if (path.length() == 0) {
            path = "/";
        }
        String str = path;
        Intrinsics.checkNotNull(str);
        if (!StringsKt.endsWith$default(str, '/', false, 2, (Object) null)) {
            str = str + '/';
        }
        String url2 = new URL(new URL(url.getProtocol() + "://" + url.getAuthority() + str), StringsKt.trimStart(pathSearchHash, new char[]{'/'})).toString();
        Intrinsics.checkNotNullExpressionValue(url2, "toString(...)");
        return url2;
    }
}
