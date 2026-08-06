package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.ttnet.org.chromium.net.NetworkChangeNotifier;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NetworkChangeNotifierJni implements NetworkChangeNotifier.Natives {
    public static final JniStaticTestMocker<NetworkChangeNotifier.Natives> TEST_HOOKS = new JniStaticTestMocker<NetworkChangeNotifier.Natives>() { // from class: com.ttnet.org.chromium.net.NetworkChangeNotifierJni.1
        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(NetworkChangeNotifier.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                NetworkChangeNotifier.Natives unused = NetworkChangeNotifierJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    private static NetworkChangeNotifier.Natives testInstance;

    NetworkChangeNotifierJni() {
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyConnectionTypeChanged(long j, NetworkChangeNotifier networkChangeNotifier, int i, long j2) {
        GEN_JNI.m339xf12b1008(j, networkChangeNotifier, i, j2);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyConnectionCostChanged(long j, NetworkChangeNotifier networkChangeNotifier, int i) {
        GEN_JNI.m338x561bb415(j, networkChangeNotifier, i);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyMaxBandwidthChanged(long j, NetworkChangeNotifier networkChangeNotifier, int i) {
        GEN_JNI.m340xd34464f3(j, networkChangeNotifier, i);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyOfNetworkConnect(long j, NetworkChangeNotifier networkChangeNotifier, long j2, boolean z, int i) {
        GEN_JNI.m341x3f073967(j, networkChangeNotifier, j2, z, i);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyOfNetworkSoonToDisconnect(long j, NetworkChangeNotifier networkChangeNotifier, long j2) {
        GEN_JNI.m343xb4a56a75(j, networkChangeNotifier, j2);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyOfNetworkDisconnect(long j, NetworkChangeNotifier networkChangeNotifier, boolean z, long j2) {
        GEN_JNI.m342xf78b6aff(j, networkChangeNotifier, z, j2);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyPurgeActiveNetworkList(long j, NetworkChangeNotifier networkChangeNotifier, long[] jArr) {
        GEN_JNI.m344x19ae96f(j, networkChangeNotifier, jArr);
    }

    public static NetworkChangeNotifier.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            NetworkChangeNotifier.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new NetworkChangeNotifierJni();
    }
}
