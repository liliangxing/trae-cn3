package com.bytedance.trae.conversation.network;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.trae.conversation.network.ModelDiscountTag;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ModelPricingPolicy.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000b*\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;", "", "<init>", "()V", "resolve", "Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;", "features", "Lcom/bytedance/trae/conversation/network/ModelFeatures;", "formatRateNumber", "", "rate", "Ljava/math/BigDecimal;", "resolveConsumptionRate", "resolveDiscountTag", "Lcom/bytedance/trae/conversation/network/ModelDiscountTag;", "feature", "Lcom/bytedance/trae/conversation/network/ModelFeatureDiscount;", "validRateOrNull", "formatDecimal", "value", "DISPLAY_SCALE", "", "MEMBER_DISCOUNT", "BUSINESS_MEMBER_DISCOUNT", "EXCLUSIVE_DISCOUNT", "CN_CREDITS_EXCLUSIVE_DISCOUNT", "CN_CREDITS_SUBSIDY", "BUSINESS_EXCLUSIVE_DISCOUNT", "MAX_DISCOUNT_PERCENT", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ModelPricingPolicy {
    private static final String BUSINESS_EXCLUSIVE_DISCOUNT = "business_exclusive_discount";
    private static final String BUSINESS_MEMBER_DISCOUNT = "business_member_discount";
    private static final String CN_CREDITS_EXCLUSIVE_DISCOUNT = "cn_credits_exclusive_discount";
    private static final String CN_CREDITS_SUBSIDY = "cn_credits_subsidy";
    private static final int DISPLAY_SCALE = 2;
    private static final String EXCLUSIVE_DISCOUNT = "exclusive_discount";
    public static final ModelPricingPolicy INSTANCE = new ModelPricingPolicy();
    private static final BigDecimal MAX_DISCOUNT_PERCENT = new BigDecimal(OnekeyLoginConstants.CU_RESULT_SUCCESS);
    private static final String MEMBER_DISCOUNT = "member_discount";

    private ModelPricingPolicy() {
    }

    public final ModelPricingPresentation resolve(ModelFeatures features) {
        return new ModelPricingPresentation(resolveConsumptionRate(features), resolveDiscountTag(features != null ? features.getDiscount() : null));
    }

    public final String formatRateNumber(BigDecimal rate) {
        Intrinsics.checkNotNullParameter(rate, "rate");
        String plainString = rate.setScale(2, RoundingMode.HALF_UP).toPlainString();
        Intrinsics.checkNotNullExpressionValue(plainString, "toPlainString(...)");
        return plainString;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final BigDecimal resolveConsumptionRate(ModelFeatures features) {
        BigDecimal bigDecimal;
        ModelFeatureCost cost;
        ModelFeatureCostData data;
        ModelFeatureDiscount discount;
        ModelFeatureDiscountData data2;
        ModelFeatureConsumptionRate consumptionRate = features != null ? features.getConsumptionRate() : null;
        boolean z = false;
        if (consumptionRate != null && consumptionRate.getEnable()) {
            z = true;
        }
        if (z) {
            ModelFeatureConsumptionRateData data3 = consumptionRate.getData();
            return validRateOrNull(data3 != null ? data3.getRate() : null);
        }
        if (features != null && (discount = features.getDiscount()) != null) {
            if (!discount.getEnable()) {
                discount = null;
            }
            if (discount != null && (data2 = discount.getData()) != null) {
                bigDecimal = data2.getConsumptionRate();
                if (bigDecimal == null) {
                    bigDecimal = data2.getRate();
                }
                if (bigDecimal == null) {
                    return validRateOrNull(bigDecimal);
                }
                if (features != null && (cost = features.getCost()) != null) {
                    if (!cost.getEnable()) {
                        cost = null;
                    }
                    if (cost != null && (data = cost.getData()) != null) {
                        r0 = data.getManualUsage();
                    }
                }
                return validRateOrNull(r0);
            }
        }
        bigDecimal = null;
        if (bigDecimal == null) {
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0037. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ModelDiscountTag resolveDiscountTag(ModelFeatureDiscount feature) {
        String str;
        ModelFeatureDiscountData data;
        BigDecimal memberDiscount;
        String obj;
        boolean z = false;
        ModelDiscountTag.Member member = null;
        if (!(feature != null && feature.getEnable())) {
            return null;
        }
        String subKey = feature.getSubKey();
        if (subKey == null || (obj = StringsKt.trim(subKey).toString()) == null) {
            str = null;
        } else {
            str = obj.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
        }
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case -1531483999:
                if (!str.equals(BUSINESS_EXCLUSIVE_DISCOUNT)) {
                    return null;
                }
                return ModelDiscountTag.Exclusive.INSTANCE;
            case 398213595:
                if (!str.equals(CN_CREDITS_EXCLUSIVE_DISCOUNT)) {
                    return null;
                }
                return ModelDiscountTag.Exclusive.INSTANCE;
            case 542079426:
                if (!str.equals(EXCLUSIVE_DISCOUNT)) {
                    return null;
                }
                return ModelDiscountTag.Exclusive.INSTANCE;
            case 1296943410:
                if (!str.equals(CN_CREDITS_SUBSIDY)) {
                    return null;
                }
                return ModelDiscountTag.Exclusive.INSTANCE;
            case 1612906183:
                if (!str.equals(BUSINESS_MEMBER_DISCOUNT)) {
                    return null;
                }
                data = feature.getData();
                if (data != null && (memberDiscount = data.getMemberDiscount()) != null) {
                    if (memberDiscount.compareTo(BigDecimal.ZERO) >= 0 && memberDiscount.compareTo(MAX_DISCOUNT_PERCENT) <= 0) {
                        z = true;
                    }
                    if (!z) {
                        memberDiscount = null;
                    }
                    if (memberDiscount != null) {
                        ModelPricingPolicy modelPricingPolicy = INSTANCE;
                        BigDecimal movePointLeft = memberDiscount.movePointLeft(1);
                        Intrinsics.checkNotNullExpressionValue(movePointLeft, "movePointLeft(...)");
                        String formatDecimal = modelPricingPolicy.formatDecimal(movePointLeft);
                        BigDecimal subtract = MAX_DISCOUNT_PERCENT.subtract(memberDiscount);
                        Intrinsics.checkNotNullExpressionValue(subtract, "subtract(...)");
                        member = new ModelDiscountTag.Member(formatDecimal, modelPricingPolicy.formatDecimal(subtract));
                    }
                }
                return member;
            case 2069129542:
                if (!str.equals(MEMBER_DISCOUNT)) {
                    return null;
                }
                data = feature.getData();
                if (data != null) {
                    if (memberDiscount.compareTo(BigDecimal.ZERO) >= 0) {
                        z = true;
                        break;
                    }
                    if (!z) {
                    }
                    if (memberDiscount != null) {
                    }
                    break;
                }
                return member;
            default:
                return null;
        }
    }

    private final BigDecimal validRateOrNull(BigDecimal bigDecimal) {
        if (bigDecimal != null) {
            if (bigDecimal.signum() >= 0) {
                return bigDecimal;
            }
        }
        return null;
    }

    private final String formatDecimal(BigDecimal value) {
        String plainString = value.stripTrailingZeros().toPlainString();
        Intrinsics.checkNotNullExpressionValue(plainString, "toPlainString(...)");
        return plainString;
    }
}
