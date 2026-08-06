package com.bytedance.vcloud.impl;

import com.bytedance.vcloud.uniplayer.UniInstConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SoundPool.android.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000¨\u0006\u0006"}, d2 = {"newSoundPoolBridge", "Lcom/bytedance/vcloud/impl/SoundPoolBridge;", "tag", "", "config", "Lcom/bytedance/vcloud/uniplayer/UniInstConfig;", "uniplayer_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class SoundPool_androidKt {
    public static final SoundPoolBridge newSoundPoolBridge(String str, UniInstConfig uniInstConfig) {
        Intrinsics.checkNotNullParameter(str, "tag");
        return new SoundPoolJvmBridge(str, uniInstConfig instanceof UniInstConfigImpl ? (UniInstConfigImpl) uniInstConfig : null);
    }
}
