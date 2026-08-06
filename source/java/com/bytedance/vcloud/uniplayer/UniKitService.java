package com.bytedance.vcloud.uniplayer;

import com.bytedance.vcloud.impl.UniSoundPoolImpl;
import com.bytedance.webx.seclink.util.ReportUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniKitService.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b¨\u0006\r"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/UniKitService;", "", "()V", "getAbConfig", "Lcom/bytedance/vcloud/uniplayer/UniAbConfig;", "newAVManager", "Lcom/bytedance/vcloud/uniplayer/UniAVManager;", ReportUtil.Params.SCENE, "", "abConfig", "newSoundPool", "Lcom/bytedance/vcloud/uniplayer/SoundPool;", "tag", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class UniKitService {
    public static final UniKitService INSTANCE = new UniKitService();

    private UniKitService() {
    }

    static {
        UniKitService_androidKt.loadLibrary();
    }

    public final UniAbConfig getAbConfig() {
        return UniKitService_androidKt.getGlobalAbConfig();
    }

    public final SoundPool newSoundPool(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return new UniSoundPoolImpl(tag, UniInstConfig.INSTANCE.create());
    }

    public static /* synthetic */ UniAVManager newAVManager$default(UniKitService uniKitService, String str, UniAbConfig uniAbConfig, int i, Object obj) {
        if ((i & 2) != 0) {
            uniAbConfig = null;
        }
        return uniKitService.newAVManager(str, uniAbConfig);
    }

    public final UniAVManager newAVManager(String scene, UniAbConfig abConfig) {
        Intrinsics.checkNotNullParameter(scene, ReportUtil.Params.SCENE);
        return new UniAVManager(scene, abConfig);
    }
}
