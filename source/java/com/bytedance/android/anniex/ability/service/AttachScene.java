package com.bytedance.android.anniex.ability.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAnnieXContextProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/anniex/ability/service/AttachScene;", "", "scene", "", "(Ljava/lang/String;)V", "getScene", "()Ljava/lang/String;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class AttachScene {
    private final String scene;

    public AttachScene(String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.scene = scene;
    }

    public final String getScene() {
        return this.scene;
    }
}
