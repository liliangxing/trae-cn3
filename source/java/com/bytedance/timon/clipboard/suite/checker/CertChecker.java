package com.bytedance.timon.clipboard.suite.checker;

import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.timon.clipboard.cert.check.api.IClipboardSuiteCertChecker;
import com.bytedance.timon.clipboard.suite.TimonClipboardSuite;
import com.bytedance.timonbase.TMLogger;
import com.bytedance.timonbase.TimonConstantKt;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CertChecker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/timon/clipboard/suite/checker/CertChecker;", "", "()V", "check", "Lcom/bytedance/timon/clipboard/suite/checker/CheckResult;", "cert", "Lcom/bytedance/bpea/basics/Cert;", "entryToken", "", "apiId", "", "clipboard-suite_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CertChecker {
    public static final CertChecker INSTANCE = new CertChecker();

    private CertChecker() {
    }

    public final CheckResult check(Cert cert, String entryToken, int apiId) {
        CheckResult checkResult;
        String certToken;
        com.bytedance.bpea.basics.CheckResult check;
        String certToken2;
        String certToken3;
        Map customInfo;
        Intrinsics.checkParameterIsNotNull(entryToken, "entryToken");
        String str = "";
        if (Intrinsics.areEqual((cert == null || (customInfo = cert.customInfo()) == null) ? null : customInfo.get(TimonConstantKt.TIMON_CLIPBOARD_SUITE_MONITOR_COMPAT_KIT), 1)) {
            String certToken4 = cert.certToken();
            return new CheckResult(false, "from bpea don't need check cert", certToken4 != null ? certToken4 : "", 0, 8, null);
        }
        try {
            check = ((IClipboardSuiteCertChecker) ServiceManager.get().getService(IClipboardSuiteCertChecker.class)).check(cert, entryToken, apiId);
        } catch (BPEAException e) {
            TMLogger.INSTANCE.m222e(TimonClipboardSuite.TAG, "bpea 证书校验失败", e);
            String message = e.getMessage();
            String str2 = message != null ? message : "bpea 证书校验失败";
            if (cert != null && (certToken = cert.certToken()) != null) {
                str = certToken;
            }
            checkResult = new CheckResult(true, str2, str, CheckResultKt.kTMPasteboardErrorCodeBpeaCheckError);
        }
        if (check != null && check.getCode() != 0) {
            checkResult = new CheckResult(true, check.getMsg(), (cert == null || (certToken3 = cert.certToken()) == null) ? "" : certToken3, 0, 8, null);
            return checkResult;
        }
        checkResult = new CheckResult(false, "cert check success", (cert == null || (certToken2 = cert.certToken()) == null) ? "" : certToken2, 0, 8, null);
        return checkResult;
    }
}
