package com.bytedance.timon.clipboard.cert.check.api;

import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.basics.CheckResult;
import kotlin.Metadata;

/* compiled from: IClipboardSuiteCertChecker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/timon/clipboard/cert/check/api/IClipboardSuiteCertChecker;", "", "check", "Lcom/bytedance/bpea/basics/CheckResult;", "cert", "Lcom/bytedance/bpea/basics/Cert;", "entryToken", "", "apiId", "", "clipboard-cert-check-api_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public interface IClipboardSuiteCertChecker {
    CheckResult check(Cert cert, String entryToken, int apiId) throws BPEAException;
}
