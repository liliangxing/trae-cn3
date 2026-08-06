package com.bytedance.tobshadow.bdtracker;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.bytedance.tobshadow.bdtracker.s3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0513s3 implements InterfaceC0506r3 {

    /* renamed from: a */
    public static final C0513s3 f1017a = new C0513s3();

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0506r3
    /* renamed from: a */
    public void mo637a() {
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0506r3
    /* renamed from: a */
    public <T> void mo638a(String str, T t) {
        Intrinsics.checkParameterIsNotNull(str, "key");
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0506r3
    /* renamed from: a */
    public void mo639a(Throwable th, String str) {
        Intrinsics.checkParameterIsNotNull(th, "t");
        Intrinsics.checkParameterIsNotNull(str, "tag");
    }
}
