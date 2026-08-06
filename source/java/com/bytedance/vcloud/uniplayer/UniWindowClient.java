package com.bytedance.vcloud.uniplayer;

import com.bytedance.vcloud.impl.UniAVEngineImpl;
import com.bytedance.vcloud.strategy.IAppService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniVideoView.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/UniWindowClient;", "", "bind", "", "binder", "Lcom/bytedance/vcloud/uniplayer/UniWindowBinder;", "bindEngine", IAppService.SOURCE_ENGINE, "Lcom/bytedance/vcloud/uniplayer/UniAVEngine;", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface UniWindowClient {
    void bind(UniWindowBinder binder);

    void bindEngine(UniAVEngine engine);

    /* compiled from: UniVideoView.kt */
    @Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class DefaultImpls {
        public static void bindEngine(UniWindowClient uniWindowClient, UniAVEngine uniAVEngine) {
            Intrinsics.checkNotNullParameter(uniAVEngine, IAppService.SOURCE_ENGINE);
            UniWindowBinder windowBinder = ((UniAVEngineImpl) uniAVEngine).getWindowBinder();
            uniWindowClient.bind(windowBinder);
            windowBinder.close();
        }
    }
}
