package com.lynx.tasm.core.resource;

import com.lynx.tasm.LynxInfoReportHelper;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.service.LynxServiceCenter;
import com.lynx.tasm.service.security.ILynxSecurityService;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TemplateResourceCallback extends GuardedResourceCallback {
    private final LynxInfoReportHelper mReportHelper;
    private final LynxResourceRequest.LynxResourceType mResourceType;
    private final long mResponseHandler;

    public TemplateResourceCallback(String str, long j, LynxInfoReportHelper lynxInfoReportHelper, LynxResourceRequest.LynxResourceType lynxResourceType) {
        super(str);
        this.mResponseHandler = j;
        this.mReportHelper = lynxInfoReportHelper;
        this.mResourceType = lynxResourceType;
    }

    public LynxResourceRequest.LynxResourceType getResourceType() {
        return this.mResourceType;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onTemplateLoaded(boolean z, byte[] bArr, TemplateBundle templateBundle, ByteBuffer byteBuffer, String str) {
        String str2;
        ILynxSecurityService iLynxSecurityService;
        LynxInfoReportHelper lynxInfoReportHelper;
        if (EnsureInvokedOnce()) {
            boolean z2 = bArr != null && bArr.length > 0;
            boolean z3 = templateBundle != null && templateBundle.isValid();
            if (z && ((z2 || z3) && (lynxInfoReportHelper = this.mReportHelper) != null)) {
                lynxInfoReportHelper.reportLynxCrashContext("last_lynx_async_component_url", this.mUrl);
            }
            if (z && !z3 && z2 && (iLynxSecurityService = (ILynxSecurityService) LynxServiceCenter.inst().getService(ILynxSecurityService.class)) != null) {
                if (!iLynxSecurityService.verifyTASM(null, bArr, byteBuffer, this.mUrl, this.mResourceType == LynxResourceRequest.LynxResourceType.LynxResourceTypeTemplate ? ILynxSecurityService.LynxTasmType.TYPE_TEMPLATE : ILynxSecurityService.LynxTasmType.TYPE_DYNAMIC_COMPONENT).isVerified()) {
                    str2 = "tasm verify failed, url: " + this.mUrl;
                    z = false;
                    LynxResourceLoader.nativeInvokeCallback(this.mResponseHandler, bArr, !z3 ? templateBundle.getNativePtr() : 0L, byteBuffer, z ? 0 : -1, str2);
                }
            }
            str2 = str;
            LynxResourceLoader.nativeInvokeCallback(this.mResponseHandler, bArr, !z3 ? templateBundle.getNativePtr() : 0L, byteBuffer, z ? 0 : -1, str2);
        }
    }
}
