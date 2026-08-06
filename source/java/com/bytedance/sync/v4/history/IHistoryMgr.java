package com.bytedance.sync.v4.history;

import com.bytedance.sync.v4.intf.IHistoryMsgProcessor;
import com.bytedance.sync.v4.intf.IMsgHandlerWithMethod;
import com.bytedance.sync.v4.protocal.Flag;
import com.ss.android.ug.bus.IUgBusService;

/* loaded from: classes5.dex */
public interface IHistoryMgr extends IUgBusService {
    IMsgHandlerWithMethod<Flag> historyHandlerWithMethod();

    IHistoryMsgProcessor historyMsgProcessor();
}
