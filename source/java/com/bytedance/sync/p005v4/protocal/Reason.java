package com.bytedance.sync.p005v4.protocal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public enum Reason implements WireEnum {
    Def(0),
    Init(1),
    Ping(2),
    Switch(3),
    ReConnect(4),
    DataAck(5),
    DataLost(6),
    HttpPollCtrl(7),
    HttpPollBiz(8),
    BackgroundPing(9);

    public static final ProtoAdapter<Reason> ADAPTER = new EnumAdapter<Reason>() { // from class: com.bytedance.sync.v4.protocal.Reason.ProtoAdapter_Reason
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: fromValue, reason: merged with bridge method [inline-methods] */
        public Reason m1017fromValue(int i) {
            return Reason.fromValue(i);
        }
    };
    private final int value;

    Reason(int i) {
        this.value = i;
    }

    public static Reason fromValue(int i) {
        switch (i) {
            case 0:
                return Def;
            case 1:
                return Init;
            case 2:
                return Ping;
            case 3:
                return Switch;
            case 4:
                return ReConnect;
            case 5:
                return DataAck;
            case 6:
                return DataLost;
            case 7:
                return HttpPollCtrl;
            case 8:
                return HttpPollBiz;
            case 9:
                return BackgroundPing;
            default:
                return null;
        }
    }

    public int getValue() {
        return this.value;
    }
}
