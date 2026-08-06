package com.bytedance.sync.p005v4.history;

import android.content.Context;
import com.bytedance.sync.Configuration;
import com.bytedance.sync.p005v4.intf.IConfiguration;
import com.bytedance.sync.p005v4.intf.IHistoryMsgProcessor;
import com.bytedance.sync.p005v4.intf.IMsgHandlerWithMethod;
import com.bytedance.sync.p005v4.process.flag.HistoryDataMsgHandlerV4;
import com.bytedance.sync.p005v4.protocal.Flag;
import com.ss.android.ug.bus.UgBusFramework;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class HistoryMgrV4 implements IHistoryMgr {
    private HistoryDataMsgHandlerV4 historyDataMsgHandler;
    private final Configuration mConfiguration = ((IConfiguration) UgBusFramework.getService(IConfiguration.class)).config();
    private Context mContext;

    public HistoryMgrV4(Context context) {
        this.mContext = context;
        this.historyDataMsgHandler = new HistoryDataMsgHandlerV4(context);
    }

    @Override // com.bytedance.sync.p005v4.history.IHistoryMgr
    public IHistoryMsgProcessor historyMsgProcessor() {
        return this.historyDataMsgHandler;
    }

    @Override // com.bytedance.sync.p005v4.history.IHistoryMgr
    public IMsgHandlerWithMethod<Flag> historyHandlerWithMethod() {
        return this.historyDataMsgHandler;
    }
}
