package com.bytedance.trae.conversation.widget;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: UploadTempFileFactory.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000¨\u0006\u0005"}, d2 = {"createUploadTempFile", "Ljava/io/File;", "cacheDir", "extension", "", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UploadTempFileFactoryKt {
    /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
    
        if (r5 != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final File createUploadTempFile(File file, String str) {
        String str2;
        String obj;
        Intrinsics.checkNotNullParameter(file, "cacheDir");
        if (str != null && (obj = StringsKt.trim(str).toString()) != null && (str2 = StringsKt.trimStart(obj, new char[]{'.'})) != null) {
            if (!(true ^ StringsKt.isBlank(str2))) {
                str2 = null;
            }
        }
        str2 = "bin";
        File createTempFile = File.createTempFile("upload_", "." + str2, file);
        Intrinsics.checkNotNullExpressionValue(createTempFile, "createTempFile(...)");
        return createTempFile;
    }
}
