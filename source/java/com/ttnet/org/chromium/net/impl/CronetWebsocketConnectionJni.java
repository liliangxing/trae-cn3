package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.ttnet.org.chromium.net.impl.CronetWebsocketConnection;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class CronetWebsocketConnectionJni implements CronetWebsocketConnection.Natives {
    public static final JniStaticTestMocker<CronetWebsocketConnection.Natives> TEST_HOOKS = new JniStaticTestMocker<CronetWebsocketConnection.Natives>() { // from class: com.ttnet.org.chromium.net.impl.CronetWebsocketConnectionJni.1
        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(CronetWebsocketConnection.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                CronetWebsocketConnection.Natives unused = CronetWebsocketConnectionJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    private static CronetWebsocketConnection.Natives testInstance;

    CronetWebsocketConnectionJni() {
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public long createWebsocketConnectionAdapter(CronetWebsocketConnection cronetWebsocketConnection, long j) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_createWebsocketConnectionAdapter(cronetWebsocketConnection, j);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void startWithFrontier(long j, CronetWebsocketConnection cronetWebsocketConnection, int i, String str, long j2, int i2, long j3, String str2, int i3, String str3, boolean z) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_startWithFrontier(j, cronetWebsocketConnection, i, str, j2, i2, j3, str2, i3, str3, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void startWithWSChannel(long j, CronetWebsocketConnection cronetWebsocketConnection, boolean z) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_startWithWSChannel(j, cronetWebsocketConnection, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void stop(long j, CronetWebsocketConnection cronetWebsocketConnection) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_stop(j, cronetWebsocketConnection);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void sendText(long j, CronetWebsocketConnection cronetWebsocketConnection, String str) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_sendText(j, cronetWebsocketConnection, str);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void sendBinary(long j, CronetWebsocketConnection cronetWebsocketConnection, ByteBuffer byteBuffer) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_sendBinary(j, cronetWebsocketConnection, byteBuffer);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void destroy(long j, CronetWebsocketConnection cronetWebsocketConnection) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_destroy(j, cronetWebsocketConnection);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void addUrl(long j, CronetWebsocketConnection cronetWebsocketConnection, String str) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addUrl(j, cronetWebsocketConnection, str);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void addHeader(long j, CronetWebsocketConnection cronetWebsocketConnection, String str, String str2) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addHeader(j, cronetWebsocketConnection, str, str2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void addGetParam(long j, CronetWebsocketConnection cronetWebsocketConnection, String str, String str2) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addGetParam(j, cronetWebsocketConnection, str, str2);
    }

    public static CronetWebsocketConnection.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            CronetWebsocketConnection.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetWebsocketConnectionJni();
    }
}
