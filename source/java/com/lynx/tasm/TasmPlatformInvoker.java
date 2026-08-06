package com.lynx.tasm;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class TasmPlatformInvoker {
    private static final String TAG = "TasmPlatformInvoker";
    private WeakReference<NativeFacade> mNativeFacade;

    public TasmPlatformInvoker(NativeFacade nativeFacade) {
        this.mNativeFacade = new WeakReference<>(nativeFacade);
    }

    public void setNativeFacade(NativeFacade nativeFacade) {
        this.mNativeFacade = new WeakReference<>(nativeFacade);
    }

    private void onPageConfigDecoded(ReadableMap readableMap) {
        NativeFacade nativeFacade = this.mNativeFacade.get();
        if (nativeFacade == null) {
            LLog.m2578i(TAG, "onPageConfigDecoded failed, NativeFacade has been released.");
        } else {
            nativeFacade.onPageConfigDecoded(readableMap);
        }
    }

    private void onRunPipelineFinished() {
        NativeFacade nativeFacade = this.mNativeFacade.get();
        if (nativeFacade == null) {
            LLog.m2578i(TAG, "OnRunPipelineFinished failed, NativeFacade has been released.");
        } else {
            nativeFacade.onRunPipelineFinished();
        }
    }

    private String translateResourceForTheme(String str, String str2) {
        NativeFacade nativeFacade = this.mNativeFacade.get();
        if (nativeFacade == null) {
            LLog.m2578i(TAG, "translateResourceForTheme failed, NativeFacade has been released.");
            return null;
        }
        return nativeFacade.translateResourceForTheme(str, str2);
    }

    private ByteBuffer triggerLepusBridge(String str, Object obj) {
        NativeFacade nativeFacade = this.mNativeFacade.get();
        if (nativeFacade == null) {
            LLog.m2578i(TAG, "triggerLepusBridge failed, NativeFacade has been released.");
            return null;
        }
        return nativeFacade.triggerLepusBridge(str, obj);
    }

    private void triggerLepusBridgeAsync(String str, Object obj) {
        NativeFacade nativeFacade = this.mNativeFacade.get();
        if (nativeFacade == null) {
            LLog.m2578i(TAG, "triggerLepusBridgeAsync failed, NativeFacade has been released.");
        } else {
            nativeFacade.triggerLepusBridgeAsync(str, obj);
        }
    }

    private void getI18nResourceByNative(String str, String str2) {
        NativeFacade nativeFacade = this.mNativeFacade.get();
        if (nativeFacade == null) {
            LLog.m2578i(TAG, "getI18nResourceByNative failed, NativeFacade has been released.");
        } else {
            nativeFacade.getI18nResourceByNative(str, str2);
        }
    }
}
