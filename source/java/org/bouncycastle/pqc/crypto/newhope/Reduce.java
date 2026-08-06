package org.bouncycastle.pqc.crypto.newhope;

import com.heytap.mcssdk.constant.MessageConstant;

/* loaded from: classes8.dex */
class Reduce {
    static final int QInv = 12287;
    static final int RLog = 18;
    static final int RMask = 262143;

    Reduce() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short barrett(short s) {
        int i = s & 65535;
        return (short) (i - (((i * 5) >>> 16) * MessageConstant.CommandId.COMMAND_REGISTER));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short montgomery(int i) {
        return (short) (((((i * 12287) & RMask) * MessageConstant.CommandId.COMMAND_REGISTER) + i) >>> 18);
    }
}
