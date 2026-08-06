package com.ss.bytertc.engine.data;

import com.ttnet.org.chromium.net.NetError;

/* loaded from: classes7.dex */
public enum ReturnStatus {
    RETURN_STATUS_SUCCESS(0),
    RETURN_STATUS_FAILURE(-1),
    RETURN_STATUS_PARAMETER_ERR(-2),
    RETURN_STATUS_WRONG_STATE(-3),
    RETURN_STATUS_HAS_IN_ROOM(-4),
    RETURN_STATUS_HAS_IN_LOGIN(-5),
    RETURN_STATUS_HAS_IN_ECHO_TEST(-6),
    RETURN_STATUS_NEITHER_VIDEO_NOR_AUDIO(-7),
    RETURN_STATUS_ROOMID_IN_USE(-8),
    RETURN_STATUS_SCREEN_NOT_SUPPORT(-9),
    RETURN_STATUS_NOT_SUPPORT(-10),
    RETURN_STATUS_RESOURCE_OVERFLOW(-11),
    RETURN_STATUS_VIDEO_NOT_SUPPORT(-12),
    RETURN_STATUS_AUDIO_NO_FRAME(-101),
    RETURN_STATUS_AUDIO_NOT_IMPLEMENTED(-102),
    RETURN_STATUS_AUDIO_NO_PERMISSION(-103),
    RETURN_STATUS_AUDIO_DEVICE_NOT_EXISTS(NetError.ERR_CONNECTION_FAILED),
    RETURN_STATUS_AUDIO_DEVICE_FORMAT_NOT_SUPPORT(NetError.ERR_NAME_NOT_RESOLVED),
    RETURN_STATUS_AUDIO_DEVICE_NO_DEVICE(NetError.ERR_INTERNET_DISCONNECTED),
    RETURN_STATUS_AUDIO_DEVICE_CAN_NOT_USE(NetError.ERR_SSL_PROTOCOL_ERROR),
    RETURN_STATUS_AUDIO_DEVICE_INIT_FAILED(NetError.ERR_ADDRESS_INVALID),
    RETURN_STATUS_AUDIO_DEVICE_START_FAILED(NetError.ERR_ADDRESS_UNREACHABLE),
    RETURN_STATUS_AUDIO_DEVICE_PROCESS_NOT_EXIST(NetError.ERR_SSL_CLIENT_AUTH_CERT_NEEDED),
    RETURN_STATUS_NATIVE_IN_VALID(-201),
    RETURN_STATUS_VIDEO_TIMESTAMP_WARNING(-202);

    private int value;

    ReturnStatus(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static ReturnStatus fromId(int id) {
        for (ReturnStatus returnStatus : values()) {
            if (returnStatus.value() == id) {
                return returnStatus;
            }
        }
        return null;
    }
}
