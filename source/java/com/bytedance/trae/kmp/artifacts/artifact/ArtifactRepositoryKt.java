package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.librarian.LibrarianImpl;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* compiled from: ArtifactRepository.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0002¨\u0006\u0002"}, d2 = {"extensionSuffix", "", "artifacts_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArtifactRepositoryKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String extensionSuffix(String str) {
        String substringAfterLast = StringsKt.substringAfterLast(StringsKt.substringAfterLast$default(str, '/', (String) null, 2, (Object) null), '.', "");
        if (!((StringsKt.isBlank(substringAfterLast) ^ true) && substringAfterLast.length() <= 12)) {
            substringAfterLast = null;
        }
        String str2 = substringAfterLast != null ? LibrarianImpl.Constants.DOT + substringAfterLast : null;
        return str2 == null ? "" : str2;
    }
}
