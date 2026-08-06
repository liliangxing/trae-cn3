package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.ttnet.org.chromium.net.impl.CronetFrontierClient;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class CronetFrontierClientJni implements CronetFrontierClient.Natives {
    public static final JniStaticTestMocker<CronetFrontierClient.Natives> TEST_HOOKS = new JniStaticTestMocker<CronetFrontierClient.Natives>() { // from class: com.ttnet.org.chromium.net.impl.CronetFrontierClientJni.1
        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(CronetFrontierClient.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                CronetFrontierClient.Natives unused = CronetFrontierClientJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    private static CronetFrontierClient.Natives testInstance;

    CronetFrontierClientJni() {
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public long createFrontierClientAdapter(CronetFrontierClient cronetFrontierClient) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_createFrontierClientAdapter(cronetFrontierClient);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void addHeader(long j, CronetFrontierClient cronetFrontierClient, String str, String str2) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_addHeader(j, cronetFrontierClient, str, str2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void addServiceId(long j, CronetFrontierClient cronetFrontierClient, int i) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_addServiceId(j, cronetFrontierClient, i);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void configParams(long j, CronetFrontierClient cronetFrontierClient, int i, int i2, String str, int i3, String str2, String str3, String str4, String str5, int i4, int i5, int i6, boolean z, String str6, String str7) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_configParams(j, cronetFrontierClient, i, i2, str, i3, str2, str3, str4, str5, i4, i5, i6, z, str6, str7);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void registerService(long j, CronetFrontierClient cronetFrontierClient, String[] strArr, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_registerService(j, cronetFrontierClient, strArr, byteBuffer, i, i2, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void unregisterService(long j, CronetFrontierClient cronetFrontierClient, int i) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_unregisterService(j, cronetFrontierClient, i);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public boolean isServiceReady(long j, CronetFrontierClient cronetFrontierClient, int i) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_isServiceReady(j, cronetFrontierClient, i);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void sendMessage(long j, CronetFrontierClient cronetFrontierClient, int i, String[] strArr, ByteBuffer byteBuffer) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_sendMessage(j, cronetFrontierClient, i, strArr, byteBuffer);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void reportAppStateChange(long j, CronetFrontierClient cronetFrontierClient, boolean z) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_reportAppStateChange(j, cronetFrontierClient, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void destroy(long j, CronetFrontierClient cronetFrontierClient) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_destroy(j, cronetFrontierClient);
    }

    public static CronetFrontierClient.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            CronetFrontierClient.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetFrontierClientJni();
    }
}
