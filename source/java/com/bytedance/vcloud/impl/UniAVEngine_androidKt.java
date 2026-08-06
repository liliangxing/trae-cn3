package com.bytedance.vcloud.impl;

import com.bytedance.vcloud.strategy.IAppService;
import com.bytedance.vcloud.uniplayer.UniAbConfig;
import com.bytedance.vcloud.uniplayer.UniInstConfig;
import com.bytedance.vcloud.uniplayer.VideoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniAVEngine.android.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a,\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\r"}, d2 = {"attachNativeEngine", "Lcom/bytedance/vcloud/impl/UniAvEngineNative;", "enginePtr", "", IAppService.SOURCE_ENGINE, "Lcom/bytedance/vcloud/impl/UniAVEngineImpl;", "createNativeEngine", "videoModel", "Lcom/bytedance/vcloud/uniplayer/VideoModel;", "abConfig", "Lcom/bytedance/vcloud/uniplayer/UniAbConfig;", "instConfig", "Lcom/bytedance/vcloud/uniplayer/UniInstConfig;", "uniplayer_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class UniAVEngine_androidKt {
    public static final UniAvEngineNative createNativeEngine(VideoModel videoModel, UniAbConfig uniAbConfig, UniInstConfig uniInstConfig, UniAVEngineImpl uniAVEngineImpl) {
        Intrinsics.checkNotNullParameter(videoModel, "videoModel");
        Intrinsics.checkNotNullParameter(uniAVEngineImpl, IAppService.SOURCE_ENGINE);
        return new UniAVEngineBridge((UniVideoModelImpl) videoModel, (UniAbConfigImpl) uniAbConfig, (UniInstConfigImpl) uniInstConfig, uniAVEngineImpl);
    }

    public static final UniAvEngineNative attachNativeEngine(long j, UniAVEngineImpl uniAVEngineImpl) {
        Intrinsics.checkNotNullParameter(uniAVEngineImpl, IAppService.SOURCE_ENGINE);
        return new UniAVEngineBridge(j, uniAVEngineImpl);
    }
}
