package com.bytedance.kmp.image.utils;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageLog.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/kmp/image/utils/ImageLog;", "", "()V", AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE, "", "msg", "", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ImageLog {
    public static final int $stable = 0;
    public static final ImageLog INSTANCE = new ImageLog();

    private ImageLog() {
    }

    public final void d(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        System.out.println((Object) ("ImageLog " + msg));
    }
}
