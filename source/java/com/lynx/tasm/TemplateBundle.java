package com.lynx.tasm;

import android.text.TextUtils;
import com.lynx.jsbridge.LynxBytecodeCallback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.base.trace.TraceEventDef;
import com.lynx.tasm.common.LepusBuffer;
import com.lynx.tasm.service.LynxServiceCenter;
import com.lynx.tasm.service.security.ILynxSecurityService;
import com.lynx.tasm.service.security.ILynxSecurityTarget;
import com.lynx.tasm.service.security.SecurityResult;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class TemplateBundle implements ILynxSecurityTarget {
    public static final String TAG = "TemplateBundle";
    private Map<String, Object> extraInfo;
    private OnReleaseCallback onReleaseCallback;
    private int templateSize;
    private String url;
    private long nativePtr = 0;
    private String errorMsg = null;
    private boolean initialized = false;
    private PageConfig pageConfig = new PageConfig(null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface OnReleaseCallback {
        void onRelease();
    }

    private static native boolean nativeConstructContext(long j, int i);

    private static native boolean nativeGetContainsElementTree(long j);

    private static native Object nativeGetExtraInfo(long j);

    private static native void nativeInitWithOption(long j, int i, boolean z);

    private static native long nativeParseTemplateFromByteArray(byte[] bArr, Object[] objArr);

    private static native long nativeParseTemplateFromByteBuffer(ByteBuffer byteBuffer, Object[] objArr);

    private static native void nativePostJsCacheGenerationTask(long j, String str, boolean z, LynxBytecodeCallback lynxBytecodeCallback);

    private static native void nativeReleaseBundle(long j);

    public boolean equals(Object obj) {
        return this == obj;
    }

    private synchronized boolean initialize(long j, int i, String str, String str2, ReadableMap readableMap) {
        if (this.initialized) {
            return false;
        }
        this.nativePtr = j;
        this.templateSize = i;
        this.url = str;
        this.errorMsg = str2;
        this.pageConfig = new PageConfig(readableMap);
        this.initialized = true;
        return true;
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    private static SecurityResult verifyTasm(ILynxSecurityTarget iLynxSecurityTarget, byte[] bArr, ByteBuffer byteBuffer, String str) {
        ILynxSecurityService service = LynxServiceCenter.inst().getService(ILynxSecurityService.class);
        if (service != null) {
            return service.verifyTASM(iLynxSecurityTarget, bArr, byteBuffer, str, ILynxSecurityService.LynxTasmType.TYPE_TEMPLATE);
        }
        return SecurityResult.onSuccess();
    }

    private static TemplateBundle internalBuildTemplate(TemplateBundle templateBundle, byte[] bArr, ByteBuffer byteBuffer, String str) {
        long nativeParseTemplateFromByteArray;
        if (templateBundle == null) {
            templateBundle = new TemplateBundle();
        }
        if (bArr != null || byteBuffer != null) {
            int limit = byteBuffer != null ? byteBuffer.limit() : bArr.length;
            TraceEvent.beginSection(TraceEventDef.TEMPLATE_BUNDLE_FROM_TEMPLATE);
            try {
                if (checkIfEnvPrepared()) {
                    SecurityResult verifyTasm = verifyTasm(templateBundle, bArr, byteBuffer, str);
                    if (!verifyTasm.isVerified()) {
                        templateBundle.initialize(0L, limit, str, "template verify failed, error message: " + verifyTasm.getErrorMsg(), null);
                        return templateBundle;
                    }
                    Object[] objArr = new Object[2];
                    if (byteBuffer != null) {
                        nativeParseTemplateFromByteArray = nativeParseTemplateFromByteBuffer(byteBuffer, objArr);
                    } else {
                        nativeParseTemplateFromByteArray = nativeParseTemplateFromByteArray(bArr, objArr);
                    }
                    templateBundle.initialize(nativeParseTemplateFromByteArray, limit, str, (String) objArr[0], (ReadableMap) objArr[1]);
                } else {
                    templateBundle.initialize(0L, limit, str, "Lynx Env is not prepared", null);
                }
            } finally {
                TraceEvent.endSection(TraceEventDef.TEMPLATE_BUNDLE_FROM_TEMPLATE);
            }
        }
        return templateBundle;
    }

    public static TemplateBundle fromTemplate(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return internalBuildTemplate(new TemplateBundle(), bArr, null, null);
    }

    public static TemplateBundle fromTemplate(ByteBuffer byteBuffer, TemplateBundleOption templateBundleOption) {
        String url = templateBundleOption != null ? templateBundleOption.getUrl() : null;
        if (byteBuffer == null) {
            return null;
        }
        if (!byteBuffer.isDirect()) {
            LLog.m2578i(TAG, "TemplateBundle only supports DirectByteBuffer.");
            TemplateBundle templateBundle = new TemplateBundle();
            templateBundle.initialize(0L, byteBuffer.limit(), url, "TemplateBundle only supports DirectByteBuffer.", null);
            return templateBundle;
        }
        TemplateBundle internalBuildTemplate = internalBuildTemplate(new TemplateBundle(), null, byteBuffer, url);
        internalBuildTemplate.initWithOption(templateBundleOption);
        return internalBuildTemplate;
    }

    public static TemplateBundle fromTemplate(byte[] bArr, TemplateBundleOption templateBundleOption) {
        if (bArr == null) {
            return null;
        }
        TemplateBundle internalBuildTemplate = internalBuildTemplate(new TemplateBundle(), bArr, null, templateBundleOption != null ? templateBundleOption.getUrl() : null);
        internalBuildTemplate.initWithOption(templateBundleOption);
        return internalBuildTemplate;
    }

    public boolean initWithTemplate(ByteBuffer byteBuffer, TemplateBundleOption templateBundleOption) {
        String url = templateBundleOption != null ? templateBundleOption.getUrl() : null;
        if (byteBuffer == null || isInitialized()) {
            return false;
        }
        if (!byteBuffer.isDirect()) {
            LLog.m2578i(TAG, "TemplateBundle only supports DirectByteBuffer.");
            return initialize(0L, byteBuffer.limit(), url, "TemplateBundle only supports DirectByteBuffer.", null);
        }
        internalBuildTemplate(this, null, byteBuffer, url);
        initWithOption(templateBundleOption);
        return true;
    }

    public boolean initWithTemplate(ByteBuffer byteBuffer) {
        return initWithTemplate(byteBuffer, (TemplateBundleOption) null);
    }

    public boolean initWithTemplate(byte[] bArr, TemplateBundleOption templateBundleOption) {
        if (bArr == null || isInitialized()) {
            return false;
        }
        internalBuildTemplate(this, bArr, null, templateBundleOption != null ? templateBundleOption.getUrl() : null);
        initWithOption(templateBundleOption);
        return true;
    }

    public boolean initWithTemplate(byte[] bArr) {
        return initWithTemplate(bArr, (TemplateBundleOption) null);
    }

    private static TemplateBundle fromNative(long j, ReadableMap readableMap) {
        String str = j == 0 ? "native TemplateBundle doesn't exist" : null;
        TemplateBundle templateBundle = new TemplateBundle();
        templateBundle.initialize(j, 0, null, str, readableMap);
        return templateBundle;
    }

    private void initWithOption(TemplateBundleOption templateBundleOption) {
        if (!isValid() || templateBundleOption == null) {
            return;
        }
        nativeInitWithOption(this.nativePtr, templateBundleOption.getContextPoolSize(), templateBundleOption.getEnableContextAutoRefill());
    }

    public Map<String, Object> getExtraInfo() {
        if (this.extraInfo == null && checkIfEnvPrepared() && isValid()) {
            this.extraInfo = new HashMap();
            Object nativeGetExtraInfo = nativeGetExtraInfo(this.nativePtr);
            if (nativeGetExtraInfo instanceof Map) {
                this.extraInfo.putAll((Map) nativeGetExtraInfo);
            }
        }
        return this.extraInfo;
    }

    public boolean isElementBundleValid() {
        if (checkIfEnvPrepared() && isValid()) {
            return nativeGetContainsElementTree(this.nativePtr);
        }
        return false;
    }

    public int getTemplateSize() {
        return this.templateSize;
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public void release() {
        if (!checkIfEnvPrepared() || this.nativePtr == 0) {
            return;
        }
        OnReleaseCallback onReleaseCallback = this.onReleaseCallback;
        if (onReleaseCallback != null) {
            onReleaseCallback.onRelease();
            this.onReleaseCallback = null;
        }
        nativeReleaseBundle(this.nativePtr);
        this.nativePtr = 0L;
    }

    protected void finalize() throws Throwable {
        release();
    }

    public boolean isValid() {
        return this.nativePtr != 0;
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    private static boolean checkIfEnvPrepared() {
        return LynxEnv.inst().isNativeLibraryLoaded();
    }

    private static Object decodeByteBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            return LepusBuffer.INSTANCE.decodeMessage(byteBuffer);
        }
        return null;
    }

    public void postJsCacheGenerationTask(String str, boolean z, LynxBytecodeCallback lynxBytecodeCallback) {
        if (!isValid() || TextUtils.isEmpty(str)) {
            return;
        }
        nativePostJsCacheGenerationTask(getNativePtr(), str, z, lynxBytecodeCallback);
    }

    public void postJsCacheGenerationTask(String str, boolean z) {
        postJsCacheGenerationTask(str, z, null);
    }

    public String getErrorMessage() {
        return this.errorMsg;
    }

    public String getUrl() {
        return this.url;
    }

    @Deprecated
    public boolean constructContext(int i) {
        return checkIfEnvPrepared() && isValid() && nativeConstructContext(this.nativePtr, i);
    }

    public PageConfig getPageConfig() {
        return this.pageConfig;
    }

    @Deprecated
    public boolean constructContext() {
        return constructContext(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnReleaseCallback(OnReleaseCallback onReleaseCallback) {
        this.onReleaseCallback = onReleaseCallback;
    }
}
