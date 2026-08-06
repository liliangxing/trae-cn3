package com.bytedance.sync.p005v4.utils;

import com.bytedance.sync.p005v4.protocal.BsyncProtocol;
import com.bytedance.sync.p005v4.protocal.Flag;
import kotlin.Metadata;

/* compiled from: ProtocolUtils.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0017\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sync/v4/utils/ProtocolUtils;", "", "()V", "isDataMsg", "", "msgType", "", "isPollMsg", "isSyncMsg", "protocolMsgType", "msg", "Lcom/bytedance/sync/v4/protocal/BsyncProtocol;", "(Lcom/bytedance/sync/v4/protocal/BsyncProtocol;)Ljava/lang/Integer;", "protocolMsgTypeString", "", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ProtocolUtils {
    public static final ProtocolUtils INSTANCE = new ProtocolUtils();

    /* compiled from: ProtocolUtils.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Flag.values().length];
            iArr[Flag.Sync.ordinal()] = 1;
            iArr[Flag.Poll.ordinal()] = 2;
            iArr[Flag.Data.ordinal()] = 3;
            iArr[Flag.FIN.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ProtocolUtils() {
    }

    public final Integer protocolMsgType(BsyncProtocol msg) {
        if (msg == null) {
            return 0;
        }
        try {
            return Integer.valueOf(msg.topics.get(0).flag.getValue());
        } catch (Throwable unused) {
            return 0;
        }
    }

    public final boolean isSyncMsg(int msgType) {
        try {
            return Flag.Sync.getValue() == msgType;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean isPollMsg(int msgType) {
        try {
            return Flag.Poll.getValue() == msgType;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean isDataMsg(int msgType) {
        try {
            return Flag.Data.getValue() == msgType;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final String protocolMsgTypeString(BsyncProtocol msg) {
        int i;
        if (msg == null) {
            return "";
        }
        try {
            Flag flag = msg.topics.get(0).flag;
            i = flag == null ? -1 : WhenMappings.$EnumSwitchMapping$0[flag.ordinal()];
        } catch (Throwable unused) {
        }
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : "fin" : "report" : "poll" : msg.topics.get(msg.topics.size() - 1).flag == Flag.Poll ? "syncpoll" : "sync";
    }
}
