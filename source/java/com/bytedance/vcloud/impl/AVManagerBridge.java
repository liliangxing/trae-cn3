package com.bytedance.vcloud.impl;

import com.bytedance.vcloud.uniplayer.UniAVEngine;
import com.bytedance.vcloud.uniplayer.UniInstConfig;
import com.bytedance.vcloud.uniplayer.UniWindowBinder;
import com.bytedance.vcloud.uniplayer.VideoModel;
import com.lynx.animax.monitor.AnimaXMonitorUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: AVManagerImpl.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H&J \u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H&J\b\u0010\u0016\u001a\u00020\u0003H&J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0000H&¨\u0006\u001a"}, d2 = {"Lcom/bytedance/vcloud/impl/AVManagerBridge;", "", "close", "", "create", "", "videoModel", "Lcom/bytedance/vcloud/uniplayer/VideoModel;", "instConfig", "Lcom/bytedance/vcloud/uniplayer/UniInstConfig;", "getBinder", "Lcom/bytedance/vcloud/uniplayer/UniWindowBinder;", "engineID", "getEngine", "Lcom/bytedance/vcloud/uniplayer/UniAVEngine;", AnimaXMonitorUtil.TRIGGER_ON_RELEASE, "Lkotlin/Function0;", "getScene", "Lcom/bytedance/vcloud/impl/UniAvSceneBridge;", "pause", "play", "release", "releaseAll", "transferEngineTo", "", "target", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface AVManagerBridge {
    void close();

    String create(VideoModel videoModel, UniInstConfig instConfig);

    UniWindowBinder getBinder(String engineID);

    UniAVEngine getEngine(String engineID, Function0<Unit> onRelease);

    UniAvSceneBridge getScene();

    void pause(String engineID);

    void play(String engineID);

    void release(String engineID);

    void releaseAll();

    boolean transferEngineTo(String engineID, AVManagerBridge target);
}
