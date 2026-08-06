package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.ttnet.org.chromium.net.impl.CronetUrlRequest;
import com.ttnet.org.chromium.net.impl.VersionSafeCallbacks;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CronetUrlRequestJni implements CronetUrlRequest.Natives {
    public static final JniStaticTestMocker<CronetUrlRequest.Natives> TEST_HOOKS = new JniStaticTestMocker<CronetUrlRequest.Natives>() { // from class: com.ttnet.org.chromium.net.impl.CronetUrlRequestJni.1
        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(CronetUrlRequest.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                CronetUrlRequest.Natives unused = CronetUrlRequestJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    private static CronetUrlRequest.Natives testInstance;

    CronetUrlRequestJni() {
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public long createRequestAdapter(CronetUrlRequest cronetUrlRequest, long j, String str, int i, int i2, boolean z, boolean z2, boolean z3, int i3, boolean z4, int i4, int i5, long j2) {
        return GEN_JNI.m414x7c31f80f(cronetUrlRequest, j, str, i, i2, z, z2, z3, i3, z4, i4, i5, j2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public boolean setHttpMethod(long j, CronetUrlRequest cronetUrlRequest, String str) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_setHttpMethod(j, cronetUrlRequest, str);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public boolean addRequestHeader(long j, CronetUrlRequest cronetUrlRequest, String str, String str2) {
        return GEN_JNI.m413x796cca8e(j, cronetUrlRequest, str, str2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void start(long j, CronetUrlRequest cronetUrlRequest) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_start(j, cronetUrlRequest);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void followDeferredRedirect(long j, CronetUrlRequest cronetUrlRequest) {
        GEN_JNI.m415xe8622c1f(j, cronetUrlRequest);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public boolean readData(long j, CronetUrlRequest cronetUrlRequest, ByteBuffer byteBuffer, int i, int i2) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_readData(j, cronetUrlRequest, byteBuffer, i, i2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void destroy(long j, CronetUrlRequest cronetUrlRequest, boolean z) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_destroy(j, cronetUrlRequest, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void appTimeout(long j, CronetUrlRequest cronetUrlRequest) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_appTimeout(j, cronetUrlRequest);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void abortWhenUploadException(long j, CronetUrlRequest cronetUrlRequest) {
        GEN_JNI.m411xe118417(j, cronetUrlRequest);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void addRequestCookieHeader(long j, CronetUrlRequest cronetUrlRequest, String str, String str2) {
        GEN_JNI.m412x3fa9a152(j, cronetUrlRequest, str, str2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void removeRequestCookieHeader(long j, CronetUrlRequest cronetUrlRequest) {
        GEN_JNI.m416xb1fa4cc9(j, cronetUrlRequest);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setSocketTimeout(long j, CronetUrlRequest cronetUrlRequest, int i, int i2, int i3) {
        GEN_JNI.m420x5d561cdf(j, cronetUrlRequest, i, i2, i3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setRequestTimeout(long j, CronetUrlRequest cronetUrlRequest, int i) {
        GEN_JNI.m418x61ae8381(j, cronetUrlRequest, i);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setThrottleNetSpeed(long j, CronetUrlRequest cronetUrlRequest, long j2) {
        GEN_JNI.m421x864495e3(j, cronetUrlRequest, j2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setRequestTypeFlags(long j, CronetUrlRequest cronetUrlRequest, int i) {
        GEN_JNI.m419xca9b118d(j, cronetUrlRequest, i);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setAuthCredentials(long j, CronetUrlRequest cronetUrlRequest, String str, String str2) {
        GEN_JNI.m417xa4438a65(j, cronetUrlRequest, str, str2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void getStatus(long j, CronetUrlRequest cronetUrlRequest, VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_getStatus(j, cronetUrlRequest, urlRequestStatusListener);
    }

    public static CronetUrlRequest.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            CronetUrlRequest.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetUrlRequestJni();
    }
}
