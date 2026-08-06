package com.bytedance.vcloud.uniplayer;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniClassLoad.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0001H\u0007¨\u0006\u0004"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/UniClassLoad;", "", "()V", "getClassLoader", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UniClassLoad {
    public static final UniClassLoad INSTANCE = new UniClassLoad();

    private UniClassLoad() {
    }

    @JvmStatic
    public static final Object getClassLoader() {
        ClassLoader classLoader = UniClassLoad.class.getClassLoader();
        Intrinsics.checkNotNullExpressionValue(classLoader, "UniClassLoad::class.java.classLoader");
        return classLoader;
    }
}
