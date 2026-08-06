package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.ttnet.org.chromium.net.impl.CronetBidirectionalStream;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CronetBidirectionalStreamJni implements CronetBidirectionalStream.Natives {
    public static final JniStaticTestMocker<CronetBidirectionalStream.Natives> TEST_HOOKS = new JniStaticTestMocker<CronetBidirectionalStream.Natives>() { // from class: com.ttnet.org.chromium.net.impl.CronetBidirectionalStreamJni.1
        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(CronetBidirectionalStream.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                CronetBidirectionalStream.Natives unused = CronetBidirectionalStreamJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    private static CronetBidirectionalStream.Natives testInstance;

    CronetBidirectionalStreamJni() {
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public long createBidirectionalStream(CronetBidirectionalStream cronetBidirectionalStream, long j, boolean z, boolean z2, int i, boolean z3, int i2, long j2) {
        return GEN_JNI.m351x9dc457df(cronetBidirectionalStream, j, z, z2, i, z3, i2, j2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public int start(long j, CronetBidirectionalStream cronetBidirectionalStream, String str, int i, String str2, String[] strArr, boolean z) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_start(j, cronetBidirectionalStream, str, i, str2, strArr, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public void sendRequestHeaders(long j, CronetBidirectionalStream cronetBidirectionalStream) {
        GEN_JNI.m354x73142ac7(j, cronetBidirectionalStream);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public boolean readData(long j, CronetBidirectionalStream cronetBidirectionalStream, ByteBuffer byteBuffer, int i, int i2) {
        return GEN_JNI.m353x1706cb88(j, cronetBidirectionalStream, byteBuffer, i, i2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public boolean writevData(long j, CronetBidirectionalStream cronetBidirectionalStream, ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z) {
        return GEN_JNI.m355x843a13e9(j, cronetBidirectionalStream, byteBufferArr, iArr, iArr2, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public void destroy(long j, CronetBidirectionalStream cronetBidirectionalStream, boolean z) {
        GEN_JNI.m352xe35e11d2(j, cronetBidirectionalStream, z);
    }

    public static CronetBidirectionalStream.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            CronetBidirectionalStream.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetBidirectionalStreamJni();
    }
}
