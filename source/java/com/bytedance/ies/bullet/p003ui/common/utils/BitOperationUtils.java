package com.bytedance.ies.bullet.p003ui.common.utils;

import com.bytedance.ies.bullet.service.router.RouterConstants;
import kotlin.Metadata;

/* compiled from: BitOperationUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/utils/BitOperationUtils;", "", "()V", "clearFlag", "", RouterConstants.QUERY_KEY_FLAGS, "targetFlag", "", "hasFlag", "", "setFlag", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BitOperationUtils {
    public static final BitOperationUtils INSTANCE = new BitOperationUtils();

    public final int clearFlag(int flags, int targetFlag) {
        return flags & (~targetFlag);
    }

    public final long clearFlag(long flags, long targetFlag) {
        return flags & (~targetFlag);
    }

    public final boolean hasFlag(int flags, int targetFlag) {
        return (flags & targetFlag) == targetFlag;
    }

    public final boolean hasFlag(long flags, long targetFlag) {
        return (flags & targetFlag) == targetFlag;
    }

    public final int setFlag(int flags, int targetFlag) {
        return flags | targetFlag;
    }

    public final long setFlag(long flags, long targetFlag) {
        return flags | targetFlag;
    }

    private BitOperationUtils() {
    }
}
