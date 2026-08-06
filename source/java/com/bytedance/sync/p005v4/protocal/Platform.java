package com.bytedance.sync.p005v4.protocal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public enum Platform implements WireEnum {
    unknown(0),
    android(1),
    iphone(2),
    ipad(3),
    windows(4),
    macOS(5),
    harmony(6),
    web(7);

    public static final ProtoAdapter<Platform> ADAPTER = new EnumAdapter<Platform>() { // from class: com.bytedance.sync.v4.protocal.Platform.ProtoAdapter_Platform
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: fromValue, reason: merged with bridge method [inline-methods] */
        public Platform m1016fromValue(int i) {
            return Platform.fromValue(i);
        }
    };
    private final int value;

    Platform(int i) {
        this.value = i;
    }

    public static Platform fromValue(int i) {
        switch (i) {
            case 0:
                return unknown;
            case 1:
                return android;
            case 2:
                return iphone;
            case 3:
                return ipad;
            case 4:
                return windows;
            case 5:
                return macOS;
            case 6:
                return harmony;
            case 7:
                return web;
            default:
                return null;
        }
    }

    public int getValue() {
        return this.value;
    }
}
