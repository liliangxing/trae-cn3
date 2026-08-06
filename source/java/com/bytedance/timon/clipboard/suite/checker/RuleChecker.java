package com.bytedance.timon.clipboard.suite.checker;

import com.bytedance.bpea.basics.Cert;
import com.bytedance.ruler.base.models.RuleExecuteResult;
import com.bytedance.ruler.base.models.RuleModel;
import com.bytedance.ruler.base.models.StrategyExecuteResult;
import com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService;
import com.bytedance.timonbase.TimonConstantKt;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RuleChecker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/timon/clipboard/suite/checker/RuleChecker;", "", "()V", "validate", "Lcom/bytedance/timon/clipboard/suite/checker/CheckResult;", "apiId", "", "cert", "Lcom/bytedance/bpea/basics/Cert;", "clipboard-suite_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class RuleChecker {
    public static final RuleChecker INSTANCE = new RuleChecker();

    private RuleChecker() {
    }

    public final CheckResult validate(int apiId, Cert cert) {
        String str;
        String str2;
        JsonElement jsonElement;
        IRulerBusinessService iRulerBusinessService = (IRulerBusinessService) ServiceManager.get().getServiceForReal(IRulerBusinessService.class);
        if (cert == null || (str = cert.certToken()) == null) {
            str = "";
        }
        String str3 = str;
        HashMap hashMap = new HashMap();
        hashMap.put(TimonPipeline.KEY_SOURCE, TimonConstantKt.TIMON_CLIPBOARD_SUITE);
        hashMap.put("api_id", Integer.valueOf(apiId));
        hashMap.put("cert_token", str3);
        StrategyExecuteResult validate = iRulerBusinessService != null ? iRulerBusinessService.validate(hashMap) : null;
        ArrayList<RuleExecuteResult> ruleResults = validate != null ? validate.getRuleResults() : null;
        if (ruleResults != null && ruleResults.isEmpty()) {
            return new CheckResult(false, "", str3, 0, 8, null);
        }
        if (ruleResults != null) {
            for (RuleExecuteResult ruleExecuteResult : ruleResults) {
                JsonElement result = ruleExecuteResult.getResult();
                JsonObject asJsonObject = result != null ? result.getAsJsonObject() : null;
                String asString = (asJsonObject == null || (jsonElement = asJsonObject.get("action")) == null) ? null : jsonElement.getAsString();
                RuleModel ruleModel = ruleExecuteResult.getRuleModel();
                if (ruleExecuteResult.getCode() == 0 && Intrinsics.areEqual(asString, "fuse")) {
                    if (ruleModel == null || (str2 = ruleModel.getKey()) == null) {
                        str2 = "intercept by rule engine";
                    }
                    return new CheckResult(true, str2, str3, CheckResultKt.kTMPasteboardErrorCodeRuleIntercept);
                }
            }
        }
        return new CheckResult(false, "", str3, 0, 8, null);
    }
}
