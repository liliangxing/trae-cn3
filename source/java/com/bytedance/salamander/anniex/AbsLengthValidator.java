package com.bytedance.salamander.anniex;

import com.bytedance.rts.foundation.RTSMapKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorCoreValidator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0003J#\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011J#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0015J\u001f\u0010\u0016\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J,\u0010\u0018\u001a\u00020\u00192\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u0016R6\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/salamander/anniex/AbsLengthValidator;", "VALUE", "", "()V", "rules", "", "", "Lcom/bytedance/salamander/anniex/ValidatorRule;", "Lcom/bytedance/rts/foundation/RTSMap;", "getRules", "()Ljava/util/Map;", "setRules", "(Ljava/util/Map;)V", "doValidation", "Lcom/bytedance/salamander/anniex/ValidationResult;", "key", "value", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/bytedance/salamander/anniex/ValidationResult;", "getLengthAndAllowedValue", "Lcom/bytedance/salamander/anniex/LengthAndAllowedValue;", "rule", "(Ljava/lang/Object;Lcom/bytedance/salamander/anniex/ValidatorRule;)Lcom/bytedance/salamander/anniex/LengthAndAllowedValue;", "getValidatedField", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "initRules", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AbsLengthValidator<VALUE> {
    private Map<String, ValidatorRule> rules = RTSMapKt.RTSMap();

    /* compiled from: AnniexMonitorCoreValidator.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ValidationAction.values().length];
            try {
                iArr[ValidationAction.Exception.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ValidationAction.Discard.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ValidationAction.CutOff.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ValidationAction.None.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void initRules(Map<String, ValidatorRule> rules) {
        Intrinsics.checkNotNullParameter(rules, "rules");
    }

    public Map<String, ValidatorRule> getRules() {
        return this.rules;
    }

    public void setRules(Map<String, ValidatorRule> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.rules = map;
    }

    public AbsLengthValidator() {
        initRules(getRules());
    }

    public LengthAndAllowedValue<VALUE> getLengthAndAllowedValue(VALUE value, ValidatorRule rule) {
        Intrinsics.checkNotNullParameter(rule, "rule");
        return new LengthAndAllowedValue<>(0, value);
    }

    public ValidationResult<VALUE> doValidation(String key, VALUE value) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (RTSMapKt.has(getRules(), key)) {
            ValidatorRule validatorRule = getRules().get(key);
            Intrinsics.checkNotNull(validatorRule);
            LengthAndAllowedValue<VALUE> lengthAndAllowedValue = getLengthAndAllowedValue(value, validatorRule);
            int i = WhenMappings.$EnumSwitchMapping$0[validatorRule.getAction().ordinal()];
            if (i == 1) {
                if (lengthAndAllowedValue.getLength() <= validatorRule.getLength()) {
                    return new ValidationResult<>(true, "validate success", ValidateResultCode.Success, (Object) lengthAndAllowedValue.getValue());
                }
                return new ValidationResult<>(false, "validate failed and throw exception", ValidateResultCode.Invalid_input, validatorRule.getLength(), lengthAndAllowedValue.getValue());
            }
            if (i == 2) {
                if (lengthAndAllowedValue.getLength() <= validatorRule.getLength()) {
                    return new ValidationResult<>(true, "validate success", ValidateResultCode.Success, (Object) lengthAndAllowedValue.getValue());
                }
                return new ValidationResult<>(false, "validate failed and the field is discarded", ValidateResultCode.Fail, validatorRule.getLength());
            }
            if (i != 3) {
                if (i == 4) {
                    return new ValidationResult<>(true, "validate success with none action", ValidateResultCode.Success, (Object) lengthAndAllowedValue.getValue());
                }
                throw new NoWhenBranchMatchedException();
            }
            if (lengthAndAllowedValue.getLength() <= validatorRule.getLength()) {
                return new ValidationResult<>(true, "validate success", ValidateResultCode.Success, (Object) lengthAndAllowedValue.getValue());
            }
            return new ValidationResult<>(true, "validate success and the field is truncated", ValidateResultCode.Invalid_input, validatorRule.getLength(), lengthAndAllowedValue.getValue());
        }
        return new ValidationResult<>(true, "don't need to validate", ValidateResultCode.Success, (Object) value);
    }

    public VALUE getValidatedField(String key, VALUE value) {
        Intrinsics.checkNotNullParameter(key, "key");
        return doValidation(key, value).getValueWhenSuccess();
    }
}
