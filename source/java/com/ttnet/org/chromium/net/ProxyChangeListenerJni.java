package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.ttnet.org.chromium.net.ProxyChangeListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ProxyChangeListenerJni implements ProxyChangeListener.Natives {
    public static final JniStaticTestMocker<ProxyChangeListener.Natives> TEST_HOOKS = new JniStaticTestMocker<ProxyChangeListener.Natives>() { // from class: com.ttnet.org.chromium.net.ProxyChangeListenerJni.1
        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(ProxyChangeListener.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                ProxyChangeListener.Natives unused = ProxyChangeListenerJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    private static ProxyChangeListener.Natives testInstance;

    ProxyChangeListenerJni() {
    }

    @Override // com.ttnet.org.chromium.net.ProxyChangeListener.Natives
    public void proxySettingsChangedTo(long j, ProxyChangeListener proxyChangeListener, String str, int i, String str2, String[] strArr) {
        GEN_JNI.m346xc094defb(j, proxyChangeListener, str, i, str2, strArr);
    }

    @Override // com.ttnet.org.chromium.net.ProxyChangeListener.Natives
    public void proxySettingsChanged(long j, ProxyChangeListener proxyChangeListener) {
        GEN_JNI.m345x667e6c60(j, proxyChangeListener);
    }

    public static ProxyChangeListener.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            ProxyChangeListener.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.ProxyChangeListener.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new ProxyChangeListenerJni();
    }
}
