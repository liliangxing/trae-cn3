package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.ttnet.org.chromium.net.TTSocketAccelerate;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class TTSocketAccelerateJni implements TTSocketAccelerate.Natives {
    public static final JniStaticTestMocker<TTSocketAccelerate.Natives> TEST_HOOKS = new JniStaticTestMocker<TTSocketAccelerate.Natives>() { // from class: com.ttnet.org.chromium.net.TTSocketAccelerateJni.1
        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(TTSocketAccelerate.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                TTSocketAccelerate.Natives unused = TTSocketAccelerateJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    private static TTSocketAccelerate.Natives testInstance;

    TTSocketAccelerateJni() {
    }

    @Override // com.ttnet.org.chromium.net.TTSocketAccelerate.Natives
    public void OnCheckSystemAvailableResult(long j, TTSocketAccelerate tTSocketAccelerate, int i) {
        GEN_JNI.com_ttnet_org_chromium_net_TTSocketAccelerate_OnCheckSystemAvailableResult(j, tTSocketAccelerate, i);
    }

    @Override // com.ttnet.org.chromium.net.TTSocketAccelerate.Natives
    public void OnNotifyAccelerateResult(long j, TTSocketAccelerate tTSocketAccelerate, int i, int i2) {
        GEN_JNI.com_ttnet_org_chromium_net_TTSocketAccelerate_OnNotifyAccelerateResult(j, tTSocketAccelerate, i, i2);
    }

    public static TTSocketAccelerate.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            TTSocketAccelerate.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.TTSocketAccelerate.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new TTSocketAccelerateJni();
    }
}
