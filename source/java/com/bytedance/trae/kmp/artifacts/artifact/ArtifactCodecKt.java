package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;

/* compiled from: ArtifactCodec.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u0004"}, d2 = {"startsWith", "", "", SchemaConstants.QUERY_KEY_PREFIX, "artifacts_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArtifactCodecKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean startsWith(byte[] bArr, byte[] bArr2) {
        if (bArr.length < bArr2.length) {
            return false;
        }
        Iterable indices = ArraysKt.getIndices(bArr2);
        if (!(indices instanceof Collection) || !((Collection) indices).isEmpty()) {
            IntIterator it = indices.iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                if (!(bArr[nextInt] == bArr2[nextInt])) {
                    return false;
                }
            }
        }
        return true;
    }
}
