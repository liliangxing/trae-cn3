package com.bytedance.sync.p005v4.process.ctrl;

import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.intf.IMsgHandler;
import com.bytedance.sync.p005v4.intf.ISyncMsgSenderV4;
import com.bytedance.sync.p005v4.protocal.BsyncHeader;
import com.bytedance.sync.p005v4.protocal.BsyncTopic;
import com.bytedance.sync.p005v4.protocal.Ctrl;
import com.bytedance.sync.p005v4.protocal.Reason;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpPollCtrlHandlerV4.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sync/v4/process/ctrl/HttpPollCtrlHandlerV4;", "Lcom/bytedance/sync/v4/intf/IMsgHandler;", "Lcom/bytedance/sync/v4/protocal/Ctrl;", "()V", "canHandle", "", "obj", "handle", "", "header", "Lcom/bytedance/sync/v4/protocal/BsyncHeader;", "topics", "", "Lcom/bytedance/sync/v4/protocal/BsyncTopic;", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class HttpPollCtrlHandlerV4 implements IMsgHandler<Ctrl> {
    @Override // com.bytedance.sync.p005v4.intf.IMsgHandler
    public void handle(BsyncHeader header, List<BsyncTopic> topics) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(topics, "topics");
        LogUtils.m188v("received http poll cmd, do http poll");
        ((ISyncMsgSenderV4) UgBusFramework.getService(ISyncMsgSenderV4.class)).sendPollMsg(true, Reason.HttpPollCtrl.getValue());
    }

    @Override // com.bytedance.sync.p005v4.intf.IMsgHandler
    public boolean canHandle(Ctrl obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        return obj == Ctrl.HttpPoll;
    }
}
