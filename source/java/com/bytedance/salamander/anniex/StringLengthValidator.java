package com.bytedance.salamander.anniex;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.rts.foundation.RTSMapKt;
import com.bytedance.rts.foundation.RTSStringKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorCoreValidator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J,\u0010\t\u001a\u00020\n2\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b`\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/salamander/anniex/StringLengthValidator;", "Lcom/bytedance/salamander/anniex/AbsLengthValidator;", "", "()V", "getLengthAndAllowedValue", "Lcom/bytedance/salamander/anniex/LengthAndAllowedValue;", "value", "rule", "Lcom/bytedance/salamander/anniex/ValidatorRule;", "initRules", "", StrategyConstants.RULES, "", "Lcom/bytedance/rts/foundation/RTSMap;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class StringLengthValidator extends AbsLengthValidator<String> {
    @Override // com.bytedance.salamander.anniex.AbsLengthValidator
    public void initRules(Map<String, ValidatorRule> rules) {
        Intrinsics.checkNotNullParameter(rules, "rules");
        RTSMapKt.set(rules, "sdk_version", new ValidatorRule("sdk_version", 100, ValidationAction.None));
        RTSMapKt.set(rules, "bid", new ValidatorRule("bid", 64, ValidationAction.CutOff));
        RTSMapKt.set(rules, "pid", new ValidatorRule("pid", 100, ValidationAction.CutOff));
        RTSMapKt.set(rules, "js_base_release", new ValidatorRule("js_base_release", 100, ValidationAction.Exception));
        RTSMapKt.set(rules, "js_base_env", new ValidatorRule("js_base_env", 100, ValidationAction.Exception));
        RTSMapKt.set(rules, "js_base_context_key", new ValidatorRule("js_base_context_key", 64, ValidationAction.Exception));
        RTSMapKt.set(rules, "js_base_context_value", new ValidatorRule("js_base_context_value", 128, ValidationAction.Exception));
        RTSMapKt.set(rules, "js_exception_js_info_exception", new ValidatorRule("js_exception_js_info_exception", 10000, ValidationAction.Exception));
        RTSMapKt.set(rules, "js_exception_native_info_error_msg", new ValidatorRule("js_exception_native_info_error_msg", 10000, ValidationAction.Exception));
        RTSMapKt.set(rules, "js_exception_root_cause", new ValidatorRule("js_exception_native_info_root_cause", 1000, ValidationAction.Exception));
        RTSMapKt.set(rules, "jsb_perf_info_jsb_name", new ValidatorRule("jsb_perf_info_jsb_name", 100, ValidationAction.None));
        RTSMapKt.set(rules, "jsb_error_bridge_name", new ValidatorRule("jsb_error_bridge_name", 100, ValidationAction.None));
        RTSMapKt.set(rules, "jsb_error_error_message", new ValidatorRule("jsb_error_error_message", 1000, ValidationAction.CutOff));
        RTSMapKt.set(rules, "jsb_error_jsb_params", new ValidatorRule("jsb_error_jsb_params", 1000, ValidationAction.Discard));
        RTSMapKt.set(rules, "schema", new ValidatorRule("schema", 4000, ValidationAction.CutOff));
        RTSMapKt.set(rules, "url", new ValidatorRule("url", 4000, ValidationAction.CutOff));
    }

    @Override // com.bytedance.salamander.anniex.AbsLengthValidator
    public LengthAndAllowedValue<String> getLengthAndAllowedValue(String value, ValidatorRule rule) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(rule, "rule");
        return new LengthAndAllowedValue<>(value.length(), value.length() <= rule.getLength() ? value : RTSStringKt.slice(value, 0, rule.getLength()));
    }
}
