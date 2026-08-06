package com.bytedance.ies.bullet.redirect.rule;

import com.bytedance.ies.bullet.redirect.data.RedirectRule;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AppVersionStrategy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010\u0010\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/rule/AppVersionStrategy;", "Lcom/bytedance/ies/bullet/redirect/rule/RuleStrategy;", "appVersion", "", "(Ljava/lang/String;)V", "major", "", "minor", "ver", "versionValue", "match", "", "redirectRule", "Lcom/bytedance/ies/bullet/redirect/data/RedirectRule;", "parseVersion", "Lkotlin/Triple;", IPiaCacheProvider.CacheConfig.FIELD_VERSION, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AppVersionStrategy extends RuleStrategy {
    private final String appVersion;
    private final int major;
    private final int minor;
    private final int ver;
    private final int versionValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppVersionStrategy(String str) {
        super(1);
        Intrinsics.checkNotNullParameter(str, "appVersion");
        this.appVersion = str;
        Triple<Integer, Integer, Integer> parseVersion = parseVersion(str);
        int intValue = ((Number) parseVersion.component1()).intValue();
        int intValue2 = ((Number) parseVersion.component2()).intValue();
        int intValue3 = ((Number) parseVersion.component3()).intValue();
        this.major = intValue;
        this.minor = intValue2;
        this.ver = intValue3;
        this.versionValue = intValue3 + (intValue2 * BytePatchException.ErrorCode.paramsError) + (intValue * 1000000);
    }

    @Override // com.bytedance.ies.bullet.redirect.rule.RuleStrategy
    public boolean match(RedirectRule redirectRule) {
        Intrinsics.checkNotNullParameter(redirectRule, "redirectRule");
        String optString = redirectRule.getCurRuleJSONObject().optString("targetValue");
        int optInt = redirectRule.getCurRuleJSONObject().optInt("rule", -1);
        if (!(optInt != -1)) {
            throw new IllegalStateException("rule value not exists, please check config".toString());
        }
        Intrinsics.checkNotNullExpressionValue(optString, "targetVersion");
        if (!(optString.length() > 0)) {
            throw new IllegalStateException("targetValue not exists, please check config".toString());
        }
        if (this.major == -1 || this.minor == -1 || this.ver == -1) {
            return false;
        }
        Triple<Integer, Integer, Integer> parseVersion = parseVersion(optString);
        int intValue = ((Number) parseVersion.component3()).intValue() + (((Number) parseVersion.component2()).intValue() * BytePatchException.ErrorCode.paramsError) + (((Number) parseVersion.component1()).intValue() * 1000000);
        if (optInt != 0) {
            if (optInt != 1) {
                if (optInt != 2) {
                    if (optInt != 3) {
                        if (optInt == 4) {
                            if (this.versionValue - intValue <= 0) {
                                return true;
                            }
                        } else if (optInt == 5 && this.versionValue != intValue) {
                            return true;
                        }
                    } else if (this.versionValue - intValue >= 0) {
                        return true;
                    }
                } else if (this.versionValue - intValue < 0) {
                    return true;
                }
            } else if (this.versionValue - intValue > 0) {
                return true;
            }
        } else if (this.versionValue == intValue) {
            return true;
        }
        return false;
    }

    public final Triple<Integer, Integer, Integer> parseVersion(String version) {
        Intrinsics.checkNotNullParameter(version, IPiaCacheProvider.CacheConfig.FIELD_VERSION);
        List split$default = StringsKt.split$default(version, new String[]{LibrarianImpl.Constants.DOT}, false, 0, 6, (Object) null);
        if (split$default.size() != 3) {
            return new Triple<>(-1, -1, -1);
        }
        return new Triple<>(Integer.valueOf(Integer.parseInt((String) split$default.get(0))), Integer.valueOf(Integer.parseInt((String) split$default.get(1))), Integer.valueOf(Integer.parseInt((String) split$default.get(2))));
    }
}
