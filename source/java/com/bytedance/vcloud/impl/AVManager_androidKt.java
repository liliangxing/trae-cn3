package com.bytedance.vcloud.impl;

import com.bytedance.vcloud.uniplayer.UniAbConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AVManager.android.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000¨\u0006\u0006"}, d2 = {"newAVManagerBridge", "Lcom/bytedance/vcloud/impl/AVManagerBridge;", "sceneID", "", "abConfig", "Lcom/bytedance/vcloud/uniplayer/UniAbConfig;", "uniplayer_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class AVManager_androidKt {
    public static /* synthetic */ AVManagerBridge newAVManagerBridge$default(String str, UniAbConfig uniAbConfig, int i, Object obj) {
        if ((i & 2) != 0) {
            uniAbConfig = null;
        }
        return newAVManagerBridge(str, uniAbConfig);
    }

    public static final AVManagerBridge newAVManagerBridge(String str, UniAbConfig uniAbConfig) {
        Intrinsics.checkNotNullParameter(str, "sceneID");
        return new AVManagerJvmBridge(str, uniAbConfig);
    }
}
