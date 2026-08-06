package com.bytedance.vcloud.uniplayer;

import com.bytedance.vcloud.strategy.IAppService;
import com.bytedance.vcloud.uniplayer.UniWindowClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniVideoView.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/WindowClientNative;", "Lcom/bytedance/vcloud/uniplayer/UniWindowClient;", "release", "", "uniplayer-ui-trae_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface WindowClientNative extends UniWindowClient {
    void release();

    /* compiled from: UniVideoView.kt */
    @Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class DefaultImpls {
        public static void bindEngine(WindowClientNative windowClientNative, UniAVEngine uniAVEngine) {
            Intrinsics.checkNotNullParameter(uniAVEngine, IAppService.SOURCE_ENGINE);
            UniWindowClient.DefaultImpls.bindEngine(windowClientNative, uniAVEngine);
        }
    }
}
