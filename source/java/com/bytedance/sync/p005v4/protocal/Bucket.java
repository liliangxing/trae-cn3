package com.bytedance.sync.p005v4.protocal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public enum Bucket implements WireEnum {
    Device(0),
    User(1);

    public static final ProtoAdapter<Bucket> ADAPTER = new EnumAdapter<Bucket>() { // from class: com.bytedance.sync.v4.protocal.Bucket.ProtoAdapter_Bucket
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: fromValue, reason: merged with bridge method [inline-methods] */
        public Bucket m1009fromValue(int i) {
            return Bucket.fromValue(i);
        }
    };
    private final int value;

    Bucket(int i) {
        this.value = i;
    }

    public static Bucket fromValue(int i) {
        if (i == 0) {
            return Device;
        }
        if (i != 1) {
            return null;
        }
        return User;
    }

    public int getValue() {
        return this.value;
    }
}
