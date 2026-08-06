package com.bytedance.timon.clipboard.suite.checker;

import com.bytedance.bpea.basics.Cert;
import com.bytedance.timon.clipboard.suite.config.CertConfigManager;
import com.bytedance.timonbase.scene.ScenesDetector;
import kotlin.Metadata;

/* compiled from: WriteFastPassChecker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/timon/clipboard/suite/checker/WriteFastPassChecker;", "", "()V", "check", "Lcom/bytedance/timon/clipboard/suite/checker/CheckResult;", "cert", "Lcom/bytedance/bpea/basics/Cert;", "clipboard-suite_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class WriteFastPassChecker {
    public static final WriteFastPassChecker INSTANCE = new WriteFastPassChecker();

    private WriteFastPassChecker() {
    }

    public final CheckResult check(Cert cert) {
        String str;
        if (cert == null || (str = cert.certToken()) == null) {
            str = "";
        }
        String str2 = str;
        if (CertConfigManager.INSTANCE.disableFastPass(str2)) {
            return new CheckResult(false, "disable fastPass", str2, 0, 8, null);
        }
        if (CertConfigManager.INSTANCE.tokenExpire(str2)) {
            return new CheckResult(true, "token was Expired", str2, CheckResultKt.kTMPasteboardErrorCodeCertExpired);
        }
        if (!ScenesDetector.INSTANCE.isAgreedPrivacy()) {
            return new CheckResult(true, "Can't write clipboard before  agreed   privacy policy.", str2, CheckResultKt.kTMPasteboardErrorCodeNotAgreePrivacy);
        }
        if (ScenesDetector.INSTANCE.isAppBackground() && ScenesDetector.INSTANCE.enterBackgroundDuration() > CertConfigManager.INSTANCE.getBackgroundDuration()) {
            return new CheckResult(true, "Can't write clipboard in background", str2, CheckResultKt.kTMPasteboardErrorCodeInBackground);
        }
        return new CheckResult(false, "write fastPass check pass", str2, 0, 8, null);
    }
}
