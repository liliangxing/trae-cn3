package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.metrics.NativeUmaRecorder;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

@MainDex
/* loaded from: classes7.dex */
public class NativeUmaRecorderJni implements NativeUmaRecorder.Natives {
    public static final JniStaticTestMocker<NativeUmaRecorder.Natives> TEST_HOOKS = new JniStaticTestMocker<NativeUmaRecorder.Natives>() { // from class: com.ttnet.org.chromium.base.metrics.NativeUmaRecorderJni.1
        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(NativeUmaRecorder.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                NativeUmaRecorder.Natives unused = NativeUmaRecorderJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    private static NativeUmaRecorder.Natives testInstance;

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long recordBooleanHistogram(String str, long j, boolean z) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordBooleanHistogram(str, j, z);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long recordExponentialHistogram(String str, long j, int i, int i2, int i3, int i4) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordExponentialHistogram(str, j, i, i2, i3, i4);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long recordLinearHistogram(String str, long j, int i, int i2, int i3, int i4) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordLinearHistogram(str, j, i, i2, i3, i4);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long recordSparseHistogram(String str, long j, int i) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordSparseHistogram(str, j, i);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public void recordUserAction(String str, long j) {
        GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordUserAction(str, j);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public int getHistogramValueCountForTesting(String str, int i, long j) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_getHistogramValueCountForTesting(str, i, j);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public int getHistogramTotalCountForTesting(String str, long j) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_getHistogramTotalCountForTesting(str, j);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long createHistogramSnapshotForTesting() {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_createHistogramSnapshotForTesting();
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public void destroyHistogramSnapshotForTesting(long j) {
        GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_destroyHistogramSnapshotForTesting(j);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long addActionCallbackForTesting(Callback<String> callback) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_addActionCallbackForTesting(callback);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public void removeActionCallbackForTesting(long j) {
        GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_removeActionCallbackForTesting(j);
    }

    public static NativeUmaRecorder.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            NativeUmaRecorder.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new NativeUmaRecorderJni();
    }
}
