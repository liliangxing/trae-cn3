package com.bytedance.trae.conversation.products;

import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.io.FileWalkDirection;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: HtmlArtifactEntryResolver.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\f\u0010\t\u001a\u00020\b*\u00020\bH\u0002¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/products/HtmlArtifactEntryResolver;", "", "<init>", "()V", "findEntryHtml", "Ljava/io/File;", "extractDir", "artifactPath", "", "substringAfterLastPathSeparator", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class HtmlArtifactEntryResolver {
    public static final HtmlArtifactEntryResolver INSTANCE = new HtmlArtifactEntryResolver();

    private HtmlArtifactEntryResolver() {
    }

    public final File findEntryHtml(File extractDir, String artifactPath) {
        Object obj;
        Intrinsics.checkNotNullParameter(extractDir, "extractDir");
        Intrinsics.checkNotNullParameter(artifactPath, "artifactPath");
        String substringAfterLastPathSeparator = substringAfterLastPathSeparator(artifactPath);
        Object obj2 = null;
        if (!StringsKt.endsWith(substringAfterLastPathSeparator, ".html", true)) {
            substringAfterLastPathSeparator = null;
        }
        String str = substringAfterLastPathSeparator;
        if (!(str == null || str.length() == 0)) {
            File file = new File(extractDir, substringAfterLastPathSeparator);
            if (file.isFile()) {
                return file;
            }
            Iterator it = FilesKt.walk$default(extractDir, (FileWalkDirection) null, 1, (Object) null).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                File file2 = (File) obj;
                if (file2.isFile() && Intrinsics.areEqual(file2.getName(), substringAfterLastPathSeparator)) {
                    break;
                }
            }
            File file3 = (File) obj;
            if (file3 != null) {
                return file3;
            }
        }
        File file4 = new File(extractDir, "index.html");
        if (file4.isFile()) {
            return file4;
        }
        Iterator it2 = FilesKt.walk$default(extractDir, (FileWalkDirection) null, 1, (Object) null).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            File file5 = (File) next;
            if (file5.isFile() && Intrinsics.areEqual(file5.getName(), "index.html")) {
                obj2 = next;
                break;
            }
        }
        return (File) obj2;
    }

    private final String substringAfterLastPathSeparator(String str) {
        String str2 = str;
        int max = Math.max(StringsKt.lastIndexOf$default(str2, '/', 0, false, 6, (Object) null), StringsKt.lastIndexOf$default(str2, '\\', 0, false, 6, (Object) null));
        if (max < 0) {
            return str;
        }
        String substring = str.substring(max + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }
}
