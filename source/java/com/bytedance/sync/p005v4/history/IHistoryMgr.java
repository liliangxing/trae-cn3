package com.bytedance.sync.p005v4.history;

import com.bytedance.sync.p005v4.intf.IHistoryMsgProcessor;
import com.bytedance.sync.p005v4.intf.IMsgHandlerWithMethod;
import com.bytedance.sync.p005v4.protocal.Flag;
import com.ss.android.ug.bus.IUgBusService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IHistoryMgr extends IUgBusService {
    IMsgHandlerWithMethod<Flag> historyHandlerWithMethod();

    IHistoryMsgProcessor historyMsgProcessor();
}
