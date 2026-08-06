package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.ttnet.org.chromium.net.impl.CronetUploadDataStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CronetUploadDataStreamJni implements CronetUploadDataStream.Natives {
    public static final JniStaticTestMocker<CronetUploadDataStream.Natives> TEST_HOOKS = new JniStaticTestMocker<CronetUploadDataStream.Natives>() { // from class: com.ttnet.org.chromium.net.impl.CronetUploadDataStreamJni.1
        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(CronetUploadDataStream.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                CronetUploadDataStream.Natives unused = CronetUploadDataStreamJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    private static CronetUploadDataStream.Natives testInstance;

    CronetUploadDataStreamJni() {
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public long attachUploadDataToRequest(CronetUploadDataStream cronetUploadDataStream, long j, long j2) {
        return GEN_JNI.m366x635d7b7c(cronetUploadDataStream, j, j2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public long createAdapterForTesting(CronetUploadDataStream cronetUploadDataStream) {
        return GEN_JNI.m367x6f60992(cronetUploadDataStream);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public long createUploadDataStreamForTesting(CronetUploadDataStream cronetUploadDataStream, long j, long j2) {
        return GEN_JNI.m368x8bea8bb6(cronetUploadDataStream, j, j2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public void onReadSucceeded(long j, CronetUploadDataStream cronetUploadDataStream, int i, boolean z) {
        GEN_JNI.m369xe34dbf44(j, cronetUploadDataStream, i, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public void onRewindSucceeded(long j, CronetUploadDataStream cronetUploadDataStream) {
        GEN_JNI.m370x43a537f(j, cronetUploadDataStream);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public void destroy(long j) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUploadDataStream_destroy(j);
    }

    public static CronetUploadDataStream.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            CronetUploadDataStream.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetUploadDataStreamJni();
    }
}
