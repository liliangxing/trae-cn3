package com.bytedance.tobshadow.bdtracker;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class s3 implements r3 {
    public static final s3 a = new s3();

    @Override // com.bytedance.tobshadow.bdtracker.r3
    public void a() {
    }

    @Override // com.bytedance.tobshadow.bdtracker.r3
    public <T> void a(String key, T t) {
        Intrinsics.checkParameterIsNotNull(key, "key");
    }

    @Override // com.bytedance.tobshadow.bdtracker.r3
    public void a(Throwable t, String tag) {
        Intrinsics.checkParameterIsNotNull(t, "t");
        Intrinsics.checkParameterIsNotNull(tag, "tag");
    }
}
