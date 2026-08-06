package com.ss.bytertc.engine.type;

import com.ttnet.org.chromium.net.NetError;

/* loaded from: classes7.dex */
public enum SetRoomExtraInfoResult {
    SUCCESS(0),
    NOT_JOIN_ROOM(-1),
    KEY_IS_NULL(-2),
    VALUE_IS_NULL(-3),
    UNKNOW(-99),
    KEY_IS_EMPTY(-400),
    TOO_OFTEN(NetError.ERR_CACHE_RACE),
    SILENT_USER(NetError.ERR_CACHE_DOOM_FAILURE),
    KEY_TOO_LONG(NetError.ERR_CACHE_OPEN_OR_CREATE_FAILURE),
    VALUE_TOO_LONG(-414),
    SERVER_ERROR(-500);

    private final int value;

    SetRoomExtraInfoResult() {
        this.value = 0;
    }

    public int value() {
        return this.value;
    }

    SetRoomExtraInfoResult(int value) {
        this.value = value;
    }

    public static SetRoomExtraInfoResult fromId(int type) {
        for (SetRoomExtraInfoResult setRoomExtraInfoResult : values()) {
            if (setRoomExtraInfoResult.value() == type) {
                return setRoomExtraInfoResult;
            }
        }
        return UNKNOW;
    }
}
