package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;
import com.ttnet.org.chromium.net.impl.CronetUrlRequestContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CronetUrlRequestContextJni implements CronetUrlRequestContext.Natives {
    public static final JniStaticTestMocker<CronetUrlRequestContext.Natives> TEST_HOOKS = new JniStaticTestMocker<CronetUrlRequestContext.Natives>() { // from class: com.ttnet.org.chromium.net.impl.CronetUrlRequestContextJni.1
        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(CronetUrlRequestContext.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                CronetUrlRequestContext.Natives unused = CronetUrlRequestContextJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    private static CronetUrlRequestContext.Natives testInstance;

    CronetUrlRequestContextJni() {
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public long createRequestContextConfig(String str, String str2, boolean z, String str3, boolean z2, boolean z3, boolean z4, int i, long j, String str4, long j2, boolean z5, boolean z6, int i2) {
        return GEN_JNI.m378xa22d347a(str, str2, z, str3, z2, z3, z4, i, j, str4, j2, z5, z6, i2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void addQuicHint(long j, String str, int i, int i2) {
        GEN_JNI.m372xfe32a34a(j, str, i, i2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void addPkp(long j, String str, byte[][] bArr, boolean z, long j2) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addPkp(j, str, bArr, z, j2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public long createRequestContextAdapter(long j) {
        return GEN_JNI.m377x26351917(j);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public int setMinLogLevel(int i) {
        return GEN_JNI.m396x64d9e12c(i);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public byte[] getHistogramDeltas() {
        return GEN_JNI.m380xe7aaade5();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void destroy(long j, CronetUrlRequestContext cronetUrlRequestContext) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_destroy(j, cronetUrlRequestContext);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public boolean startNetLogToFile(long j, CronetUrlRequestContext cronetUrlRequestContext, String str, boolean z) {
        return GEN_JNI.m402xb23b6204(j, cronetUrlRequestContext, str, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void startNetLogToDisk(long j, CronetUrlRequestContext cronetUrlRequestContext, String str, boolean z, int i) {
        GEN_JNI.m401xb23a7a25(j, cronetUrlRequestContext, str, z, i);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void stopNetLog(long j, CronetUrlRequestContext cronetUrlRequestContext) {
        GEN_JNI.m404xd36414e5(j, cronetUrlRequestContext);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void initRequestContextOnInitThread(long j, CronetUrlRequestContext cronetUrlRequestContext) {
        GEN_JNI.m383x29f833c5(j, cronetUrlRequestContext);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void configureNetworkQualityEstimatorForTesting(long j, CronetUrlRequestContext cronetUrlRequestContext, boolean z, boolean z2, boolean z3) {
        GEN_JNI.m375x4a660b8c(j, cronetUrlRequestContext, z, z2, z3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void provideRTTObservations(long j, CronetUrlRequestContext cronetUrlRequestContext, boolean z) {
        GEN_JNI.m386x4e655054(j, cronetUrlRequestContext, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setTTNetInitConfig(long j, int i, boolean z, boolean z2, String str, String str2, String str3, boolean z3, String str4, String str5, byte[][] bArr, TTThreadConfigInfoProvider.ThreadConfigInfo[] threadConfigInfoArr, boolean z4, boolean z5, boolean z6, String str6, TTAppInfoProvider.AppInfo appInfo, long j2, boolean z7, boolean z8, boolean z9, TTSamplingSettingProvider.TTSlaSamplingSetting tTSlaSamplingSetting, boolean z10, String str7) {
        GEN_JNI.m398x88386489(j, i, z, z2, str, str2, str3, z3, str4, str5, bArr, threadConfigInfoArr, z4, z5, z6, str6, appInfo, j2, z7, z8, z9, tTSlaSamplingSetting, z10, str7);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setClientOpaqueData(long j, String[] strArr, byte[] bArr, byte[] bArr2) {
        GEN_JNI.m393xe5ac27bc(j, strArr, bArr, bArr2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void initALogFuncAddr(long j) {
        GEN_JNI.m382x7d363b24(j);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public long[] getOpaqueFuncAddress() {
        return GEN_JNI.m381xc016efd5();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void parseTNCConfigFromSystemHTTPRequest(long j, CronetUrlRequestContext cronetUrlRequestContext, String str, String str2, String str3, String str4, String str5, String str6) {
        GEN_JNI.m384x4be490fa(j, cronetUrlRequestContext, str, str2, str3, str4, str5, str6);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void triggerTNCRequestByUser(long j, CronetUrlRequestContext cronetUrlRequestContext, boolean z) {
        GEN_JNI.m406x8a046304(j, cronetUrlRequestContext, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void ttUrlDispatch(long j, CronetUrlRequestContext cronetUrlRequestContext, URLDispatch uRLDispatch, String str, boolean z) {
        GEN_JNI.m409x7c2b110d(j, cronetUrlRequestContext, uRLDispatch, str, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void runInBackGround(long j, CronetUrlRequestContext cronetUrlRequestContext, boolean z) {
        GEN_JNI.m390x4736b622(j, cronetUrlRequestContext, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void addClientOpaqueData(long j, CronetUrlRequestContext cronetUrlRequestContext, String[] strArr, byte[] bArr, byte[] bArr2, long j2, long j3) {
        GEN_JNI.m371xa08185fb(j, cronetUrlRequestContext, strArr, bArr, bArr2, j2, j3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void clearClientOpaqueData(long j, CronetUrlRequestContext cronetUrlRequestContext) {
        GEN_JNI.m374x5f2812a7(j, cronetUrlRequestContext);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void removeClientOpaqueData(long j, CronetUrlRequestContext cronetUrlRequestContext, String str) {
        GEN_JNI.m388xbb9e7216(j, cronetUrlRequestContext, str);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setProxy(long j, CronetUrlRequestContext cronetUrlRequestContext, String str) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setProxy(j, cronetUrlRequestContext, str);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void preconnectUrl(long j, CronetUrlRequestContext cronetUrlRequestContext, String str, int i, String str2) {
        GEN_JNI.m385x68642fac(j, cronetUrlRequestContext, str, i, str2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void ttDnsResolve(long j, CronetUrlRequestContext cronetUrlRequestContext, String str, int i, String str2, String str3) {
        GEN_JNI.m408x608751ff(j, cronetUrlRequestContext, str, i, str2, str3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void controlHttpDNSConfig(long j, CronetUrlRequestContext cronetUrlRequestContext, boolean z, boolean z2, boolean z3) {
        GEN_JNI.m376xa4f7cea2(j, cronetUrlRequestContext, z, z2, z3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setHostResolverRules(long j, CronetUrlRequestContext cronetUrlRequestContext, String str) {
        GEN_JNI.m395x67833663(j, cronetUrlRequestContext, str);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void addSamplingSetting(long j, CronetUrlRequestContext cronetUrlRequestContext, TTSamplingSettingProvider.TTSlaSamplingSetting tTSlaSamplingSetting) {
        GEN_JNI.m373x1bfd0b64(j, cronetUrlRequestContext, tTSlaSamplingSetting);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void tryStartNetDetect(long j, CronetUrlRequestContext cronetUrlRequestContext, String[] strArr, int i, int i2) {
        GEN_JNI.m407x21eced9d(j, cronetUrlRequestContext, strArr, i, i2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void updateStoreRegionFromServer(long j, CronetUrlRequestContext cronetUrlRequestContext, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        GEN_JNI.m410x9fbe30fd(j, cronetUrlRequestContext, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setAlogFuncAddr(long j, CronetUrlRequestContext cronetUrlRequestContext, long j2) {
        GEN_JNI.m391xab954a5e(j, cronetUrlRequestContext, j2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setZstdFuncAddr(long j, CronetUrlRequestContext cronetUrlRequestContext, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9) {
        GEN_JNI.m399x86d13c84(j, cronetUrlRequestContext, j2, j3, j4, j5, j6, j7, j8, j9);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setRouteSelectionBestHost(long j, CronetUrlRequestContext cronetUrlRequestContext, String str, String str2) {
        GEN_JNI.m397x296bf5b5(j, cronetUrlRequestContext, str, str2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void startThrottle(long j, CronetUrlRequestContext cronetUrlRequestContext, String[] strArr, int i, long j2) {
        GEN_JNI.m403x71f62a50(j, cronetUrlRequestContext, strArr, i, j2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void stopThrottle(long j, CronetUrlRequestContext cronetUrlRequestContext, String[] strArr, int i) {
        GEN_JNI.m405x97323828(j, cronetUrlRequestContext, strArr, i);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void enableTTBizHttpDns(long j, CronetUrlRequestContext cronetUrlRequestContext, boolean z, String str, String str2, String str3, boolean z2, String str4) {
        GEN_JNI.m379xd47f346d(j, cronetUrlRequestContext, z, str, str2, str3, z2, str4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setAppStartUpState(long j, CronetUrlRequestContext cronetUrlRequestContext, int i) {
        GEN_JNI.m392x461d0dcf(j, cronetUrlRequestContext, i);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setCookieInitCompleted(long j, CronetUrlRequestContext cronetUrlRequestContext) {
        GEN_JNI.m394x43bda731(j, cronetUrlRequestContext);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void reportNetDiagnosisUserLog(long j, CronetUrlRequestContext cronetUrlRequestContext, String str) {
        GEN_JNI.m389xb58ba7d5(j, cronetUrlRequestContext, str);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void provideThroughputObservations(long j, CronetUrlRequestContext cronetUrlRequestContext, boolean z) {
        GEN_JNI.m387xa10595b6(j, cronetUrlRequestContext, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public boolean skipLogging(long j, CronetUrlRequestContext cronetUrlRequestContext) {
        return GEN_JNI.m400x2f87f284(j, cronetUrlRequestContext);
    }

    public static CronetUrlRequestContext.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            CronetUrlRequestContext.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetUrlRequestContextJni();
    }
}
