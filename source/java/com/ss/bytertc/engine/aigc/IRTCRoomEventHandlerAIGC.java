package com.ss.bytertc.engine.aigc;

import com.ss.bytertc.engine.UserInfo;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public abstract class IRTCRoomEventHandlerAIGC {
    public void onStartSessionResult(StartSessionResult result, UserInfo user_info, ByteBuffer message) {
    }

    public void onStartSessionResultWithErrorCode(StartSessionResult result, int error_code, UserInfo user_info, ByteBuffer message) {
    }
}
