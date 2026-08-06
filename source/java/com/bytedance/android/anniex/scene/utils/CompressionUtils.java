package com.bytedance.android.anniex.scene.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompressionUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/scene/utils/CompressionUtils;", "", "()V", "compressSceneId", "", "input", "decompressSceneId", "base64Input", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class CompressionUtils {
    public static final CompressionUtils INSTANCE = new CompressionUtils();

    public final String compressSceneId(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return input;
    }

    public final String decompressSceneId(String base64Input) {
        Intrinsics.checkNotNullParameter(base64Input, "base64Input");
        return base64Input;
    }

    private CompressionUtils() {
    }
}
