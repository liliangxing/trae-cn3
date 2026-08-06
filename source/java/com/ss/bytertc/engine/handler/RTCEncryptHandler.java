package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.utils.LogUtil;

/* loaded from: classes7.dex */
public class RTCEncryptHandler {
    private static final String TAG = "RtcEngineEncryptHandler";
    private IRTCEncryptionHandler mCustomizeEncryptHandler;

    public RTCEncryptHandler(IRTCEncryptionHandler customizeEncryptHandler) {
        this.mCustomizeEncryptHandler = customizeEncryptHandler;
    }

    public byte[] onEncryptData(byte[] data) {
        LogUtil.d(TAG, "onEncryptData...");
        try {
            IRTCEncryptionHandler iRTCEncryptionHandler = this.mCustomizeEncryptHandler;
            if (iRTCEncryptionHandler != null) {
                return iRTCEncryptionHandler.onEncryptData(data);
            }
            return null;
        } catch (Exception e) {
            LogUtil.d(TAG, "onEncryptData callback catch exception.\n" + e.getMessage());
            return null;
        }
    }

    public byte[] onDecryptData(byte[] data) {
        LogUtil.d(TAG, "onDecryptData...");
        try {
            IRTCEncryptionHandler iRTCEncryptionHandler = this.mCustomizeEncryptHandler;
            if (iRTCEncryptionHandler != null) {
                return iRTCEncryptionHandler.onDecryptData(data);
            }
            return null;
        } catch (Exception e) {
            LogUtil.d(TAG, "onDecryptData callback catch exception.\n" + e.getMessage());
            return null;
        }
    }
}
