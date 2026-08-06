package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.trae.kmp.network.KmpRequestAuth;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: ArtifactModels.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactLocator;", "", "<init>", "()V", "remoteDownloadRequest", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;", "explorerUrl", "", "workspacePath", "filePath", "localTarget", "normalizeRemotePath", "encodePathSegment", "value", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArtifactLocator {
    public static final int $stable = 0;
    public static final ArtifactLocator INSTANCE = new ArtifactLocator();

    private ArtifactLocator() {
    }

    public final ArtifactDownloadRequest remoteDownloadRequest(String explorerUrl, String workspacePath, String filePath) {
        Intrinsics.checkNotNullParameter(explorerUrl, "explorerUrl");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        List split$default = StringsKt.split$default(normalizeRemotePath(filePath, workspacePath), new char[]{'/'}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return new ArtifactDownloadRequest(StringsKt.trimEnd(explorerUrl, new char[]{'/'}) + "/file/" + CollectionsKt.joinToString$default(arrayList, "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.bytedance.trae.kmp.artifacts.artifact.ArtifactLocator$$ExternalSyntheticLambda0
            public final Object invoke(Object obj2) {
                CharSequence remoteDownloadRequest$lambda$0;
                remoteDownloadRequest$lambda$0 = ArtifactLocator.remoteDownloadRequest$lambda$0((String) obj2);
                return remoteDownloadRequest$lambda$0;
            }
        }, 30, (Object) null) + "?download=true", KmpRequestAuth.CloudIdeJwtAuthorization);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence remoteDownloadRequest$lambda$0(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return INSTANCE.encodePathSegment(str);
    }

    public final String localTarget(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return "files/" + StringsKt.removePrefix(StringsKt.removePrefix(StringsKt.trim(filePath).toString(), "/"), "files/");
    }

    public final String normalizeRemotePath(String filePath, String workspacePath) {
        String str;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (workspacePath == null || (str = StringsKt.trimEnd(workspacePath, new char[]{'/'})) == null || !(true ^ StringsKt.isBlank(str))) {
            str = null;
        }
        if (str != null) {
            if (Intrinsics.areEqual(filePath, str)) {
                return "";
            }
            String str2 = str + '/';
            if (StringsKt.startsWith$default(filePath, str2, false, 2, (Object) null)) {
                return StringsKt.removePrefix(filePath, str2);
            }
        }
        return StringsKt.removePrefix(filePath, "/");
    }

    private final String encodePathSegment(String value) {
        return ArraysKt.joinToString$default(StringsKt.encodeToByteArray(value), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.bytedance.trae.kmp.artifacts.artifact.ArtifactLocator$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                CharSequence encodePathSegment$lambda$2;
                encodePathSegment$lambda$2 = ArtifactLocator.encodePathSegment$lambda$2(((Byte) obj).byteValue());
                return encodePathSegment$lambda$2;
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence encodePathSegment$lambda$2(byte b) {
        int i = b & 255;
        if (!(97 <= i && i < 123)) {
            if (!(65 <= i && i < 91)) {
                if (!(48 <= i && i < 58) && i != 45 && i != 95 && i != 46 && i != 126) {
                    StringBuilder sb = new StringBuilder("%");
                    String num = Integer.toString(i, CharsKt.checkRadix(16));
                    Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
                    String upperCase = num.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    return sb.append(StringsKt.padStart(upperCase, 2, '0')).toString();
                }
            }
        }
        return String.valueOf((char) i);
    }
}
