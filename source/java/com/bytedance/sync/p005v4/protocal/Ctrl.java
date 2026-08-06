package com.bytedance.sync.p005v4.protocal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public enum Ctrl implements WireEnum {
    Default(0),
    HttpPoll(1),
    HeartbeatPong(2),
    NeedStop(4),
    NeedAck(8),
    NeedData(16);

    public static final ProtoAdapter<Ctrl> ADAPTER = new EnumAdapter<Ctrl>() { // from class: com.bytedance.sync.v4.protocal.Ctrl.ProtoAdapter_Ctrl
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: fromValue, reason: merged with bridge method [inline-methods] */
        public Ctrl m1011fromValue(int i) {
            return Ctrl.fromValue(i);
        }
    };
    private final int value;

    Ctrl(int i) {
        this.value = i;
    }

    public static Ctrl fromValue(int i) {
        if (i == 0) {
            return Default;
        }
        if (i == 1) {
            return HttpPoll;
        }
        if (i == 2) {
            return HeartbeatPong;
        }
        if (i == 4) {
            return NeedStop;
        }
        if (i == 8) {
            return NeedAck;
        }
        if (i != 16) {
            return null;
        }
        return NeedData;
    }

    public int getValue() {
        return this.value;
    }
}
