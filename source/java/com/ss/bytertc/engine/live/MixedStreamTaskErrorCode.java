package com.ss.bytertc.engine.live;

import com.bytedance.sdk.account.api.AccountErrorCode;
import com.ss.ttm.player.MediaPlayer;

/* loaded from: classes7.dex */
public enum MixedStreamTaskErrorCode {
    OK(0),
    BASE(1090),
    TIMEOUT(1091),
    INVALID_PARAM_BY_SERVER(1092),
    SUB_TIMEOUT_BY_SERVER(1093),
    INVALID_STATE_BY_SERVER(1094),
    AUTHENTICATION_BY_CDN(MediaPlayer.MEDIA_PLAYER_OPTION_PLAYER_LIB_NAME),
    UNKNOWN_BY_SERVER(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_ASYNC_DOWNLOAD),
    SIGNAL_REQUEST_TIMEOUT(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_LIVE_PTS_ROLLBACK),
    MIX_IMAGE_FAIL(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_RADIO_MODE),
    STREAM_SYNC_WORSE(1099),
    PUSH_WTN_FAILED(1195),
    MAX(AccountErrorCode.CAPTCHA_CEILING);

    private int value;

    MixedStreamTaskErrorCode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.live.MixedStreamTaskErrorCode$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode;

        static {
            int[] iArr = new int[MixedStreamTaskErrorCode.values().length];
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode = iArr;
            try {
                iArr[MixedStreamTaskErrorCode.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.BASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.TIMEOUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.INVALID_PARAM_BY_SERVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.SUB_TIMEOUT_BY_SERVER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.INVALID_STATE_BY_SERVER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.AUTHENTICATION_BY_CDN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.UNKNOWN_BY_SERVER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.SIGNAL_REQUEST_TIMEOUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.MIX_IMAGE_FAIL.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.STREAM_SYNC_WORSE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.PUSH_WTN_FAILED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.MAX.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        switch (AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[ordinal()]) {
            case 1:
                return "OK";
            case 2:
                return "BASE";
            case 3:
                return "TIMEOUT";
            case 4:
                return "INVALID_PARAM_BY_SERVER";
            case 5:
                return "SUB_TIMEOUT_BY_SERVER";
            case 6:
                return "INVALID_STATE_BY_SERVER";
            case 7:
                return "AUTHENTICATION_BY_CDN";
            case 8:
                return "UNKNOWN_BY_SERVER";
            case 9:
                return "SIGNAL_REQUEST_TIMEOUT";
            case 10:
                return "MIX_IMAGE_FAIL";
            case 11:
                return "STREAM_SYNC_WORSE";
            case 12:
                return "PUSH_WTN_FAILED";
            case 13:
                return "MAX";
            default:
                return "";
        }
    }

    public static MixedStreamTaskErrorCode fromId(int id) {
        for (MixedStreamTaskErrorCode mixedStreamTaskErrorCode : values()) {
            if (mixedStreamTaskErrorCode.value() == id) {
                return mixedStreamTaskErrorCode;
            }
        }
        return null;
    }
}
