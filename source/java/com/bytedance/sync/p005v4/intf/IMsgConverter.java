package com.bytedance.sync.p005v4.intf;

import android.content.Context;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.sync.p005v4.protocal.BsyncProtocol;
import com.ss.android.ug.bus.IUgBusService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IMsgConverter extends IUgBusService {
    byte[] convertToBytes(BsyncProtocol bsyncProtocol);

    BsyncProtocol convertToProtocol(WsChannelMsg wsChannelMsg);

    BsyncProtocol convertToProtocol(byte[] bArr);

    WsChannelMsg convertToWsMsg(Context context, BsyncProtocol bsyncProtocol);
}
