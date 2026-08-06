package com.bytedance.sync.p005v4.process;

import android.content.Context;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.sync.SyncConstants;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.intf.ICompensatorServiceV4;
import com.bytedance.sync.p005v4.intf.IDBServiceV4;
import com.bytedance.sync.p005v4.intf.IWsChannelMsgProcessor;
import com.bytedance.sync.p005v4.presistence.DBServiceImplV4;
import com.bytedance.sync.settings.SyncSettings;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WsChannelMsgProcessorV4.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/sync/v4/process/WsChannelMsgProcessorV4;", "Lcom/bytedance/sync/v4/intf/IWsChannelMsgProcessor;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "check", "", "clearDatabase", "closeSync", "process", "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "msg", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class WsChannelMsgProcessorV4 implements IWsChannelMsgProcessor {
    private final Context context;

    public WsChannelMsgProcessorV4(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.bytedance.sync.p005v4.intf.IWsChannelMsgProcessor
    public WsChannelMsg process(WsChannelMsg msg) {
        if (msg != null) {
            try {
                List msgHeaders = msg.getMsgHeaders();
                LogUtils.m187i(Intrinsics.stringPlus("wschannel msg headers = ", msgHeaders));
                if (msgHeaders == null) {
                    check();
                    return msg;
                }
                int size = msgHeaders.size() - 1;
                boolean z = false;
                if (size >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        WsChannelMsg.MsgHeader msgHeader = (WsChannelMsg.MsgHeader) msgHeaders.get(i);
                        String key = msgHeader.getKey();
                        Intrinsics.checkNotNullExpressionValue(key, "header.key");
                        String lowerCase = key.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                        if (Intrinsics.areEqual(lowerCase, SyncConstants.FLAG_SYNC)) {
                            String value = msgHeader.getValue();
                            if (Intrinsics.areEqual(value, SyncConstants.FLAG_CLOSE_SYNC)) {
                                closeSync();
                            } else {
                                if (Intrinsics.areEqual(value, SyncConstants.FLAG_CLOSE_AND_CLEAR)) {
                                    closeSync();
                                    clearDatabase();
                                }
                                z = true;
                            }
                            msg = null;
                            z = true;
                        } else {
                            if (i2 > size) {
                                break;
                            }
                            i = i2;
                        }
                    }
                }
                if (!z) {
                    check();
                }
            } catch (Throwable unused) {
            }
        }
        return msg;
    }

    private final void closeSync() {
        ((ICompensatorServiceV4) UgBusFramework.getService(ICompensatorServiceV4.class)).reset();
        SyncSettings.inst(this.context).setEnable(false);
    }

    private final void clearDatabase() {
        try {
            ICompensatorServiceV4 iCompensatorServiceV4 = (ICompensatorServiceV4) UgBusFramework.getService(ICompensatorServiceV4.class);
            if (iCompensatorServiceV4 != null) {
                iCompensatorServiceV4.reset();
            }
            DBServiceImplV4 dBServiceImplV4 = (IDBServiceV4) UgBusFramework.getService(IDBServiceV4.class);
            if (dBServiceImplV4 == null) {
                dBServiceImplV4 = new DBServiceImplV4(this.context);
            }
            dBServiceImplV4.deleteAllTableData();
        } catch (Throwable unused) {
        }
    }

    private final void check() {
        if (SyncSettings.inst(this.context).getEnable()) {
            return;
        }
        SyncSettings.inst(this.context).setEnable(true);
        ((ICompensatorServiceV4) UgBusFramework.getService(ICompensatorServiceV4.class)).startOnce();
    }
}
