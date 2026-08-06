package com.bytedance.forest.model;

import com.bytedance.forest.model.ForestBuffer;
import com.bytedance.geckox.utils.MD5Utils;
import java.io.ByteArrayInputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: ForestBuffer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
final class ForestBuffer$Companion$Meta$finish$1$1 extends Lambda implements Function0<String> {
    final /* synthetic */ ForestBuffer.Companion.BufferedByteCache $it;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ForestBuffer$Companion$Meta$finish$1$1(ForestBuffer.Companion.BufferedByteCache bufferedByteCache) {
        super(0);
        this.$it = bufferedByteCache;
    }

    public final String invoke() {
        return "forestBuffer load finished, md5:" + MD5Utils.INSTANCE.getMD5(new ByteArrayInputStream(this.$it.getBuffer()));
    }
}
