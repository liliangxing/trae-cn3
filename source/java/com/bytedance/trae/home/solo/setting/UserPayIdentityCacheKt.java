package com.bytedance.trae.home.solo.setting;

import com.bytedance.trae.conversation.CreditsBalance;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: UserPayIdentityCache.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0002H\u0000\u001a0\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0000¨\u0006\f"}, d2 = {"toFastRequestUsageQuota", "Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;", "Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;", "toCreditsBalance", "Lcom/bytedance/trae/conversation/CreditsBalance;", "selectCachedCNPayStatusForRequest", "Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;", "requestUserId", "", "currentUserId", "cachedUserId", "cachedStatus", "impl_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UserPayIdentityCacheKt {
    public static final UsageQuotaData toFastRequestUsageQuota(UserEntStatusResponse userEntStatusResponse) {
        EntQuota quota;
        Long premiumModelFastRequestLimit;
        Double premiumModelFastAmount;
        EntQuota quota2;
        Long premiumModelFastRequestLimit2;
        Intrinsics.checkNotNullParameter(userEntStatusResponse, "<this>");
        List<UserEntitlementPack> userEntitlementPackList = userEntStatusResponse.getUserEntitlementPackList();
        if (userEntitlementPackList == null) {
            userEntitlementPackList = CollectionsKt.emptyList();
        }
        List<UserEntitlementPack> list = userEntitlementPackList;
        boolean z = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                EntitlementBaseInfo entitlementBaseInfo = ((UserEntitlementPack) it.next()).getEntitlementBaseInfo();
                if ((entitlementBaseInfo == null || (quota = entitlementBaseInfo.getQuota()) == null || (premiumModelFastRequestLimit = quota.getPremiumModelFastRequestLimit()) == null || premiumModelFastRequestLimit.longValue() != -1) ? false : true) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            return new UsageQuotaData(0L, Long.MAX_VALUE, true);
        }
        Iterator<T> it2 = list.iterator();
        long j = 0;
        while (it2.hasNext()) {
            EntitlementBaseInfo entitlementBaseInfo2 = ((UserEntitlementPack) it2.next()).getEntitlementBaseInfo();
            j += (entitlementBaseInfo2 == null || (quota2 = entitlementBaseInfo2.getQuota()) == null || (premiumModelFastRequestLimit2 = quota2.getPremiumModelFastRequestLimit()) == null) ? 0L : premiumModelFastRequestLimit2.longValue();
        }
        Iterator<T> it3 = list.iterator();
        long j2 = 0;
        while (it3.hasNext()) {
            EntUsage usage = ((UserEntitlementPack) it3.next()).getUsage();
            j2 += (usage == null || (premiumModelFastAmount = usage.getPremiumModelFastAmount()) == null) ? 0L : (long) premiumModelFastAmount.doubleValue();
        }
        return new UsageQuotaData(RangesKt.coerceAtLeast(j - j2, 0L), j, false);
    }

    public static final CreditsBalance toCreditsBalance(UserEntStatusResponse userEntStatusResponse) {
        boolean z;
        EntQuota quota;
        Long creditsLimit;
        Object obj;
        Object obj2;
        Double creditsAmount;
        EntQuota quota2;
        Long creditsLimit2;
        EntQuota quota3;
        Long creditsLimit3;
        Intrinsics.checkNotNullParameter(userEntStatusResponse, "<this>");
        List<UserEntitlementPack> userEntitlementPackList = userEntStatusResponse.getUserEntitlementPackList();
        if (userEntitlementPackList == null) {
            userEntitlementPackList = CollectionsKt.emptyList();
        }
        List<UserEntitlementPack> list = userEntitlementPackList;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                EntitlementBaseInfo entitlementBaseInfo = ((UserEntitlementPack) it.next()).getEntitlementBaseInfo();
                if ((entitlementBaseInfo == null || (quota = entitlementBaseInfo.getQuota()) == null || (creditsLimit = quota.getCreditsLimit()) == null || creditsLimit.longValue() != -1) ? false : true) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            return new CreditsBalance(Long.MAX_VALUE, 0L, Long.MAX_VALUE, true);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj3 : list) {
            EntitlementBaseInfo entitlementBaseInfo2 = ((UserEntitlementPack) obj3).getEntitlementBaseInfo();
            if (((entitlementBaseInfo2 == null || (quota3 = entitlementBaseInfo2.getQuota()) == null || (creditsLimit3 = quota3.getCreditsLimit()) == null) ? 0L : creditsLimit3.longValue()) > 0) {
                arrayList.add(obj3);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            Iterator it2 = arrayList2.iterator();
            long j = 0;
            while (it2.hasNext()) {
                EntitlementBaseInfo entitlementBaseInfo3 = ((UserEntitlementPack) it2.next()).getEntitlementBaseInfo();
                j = Math.addExact(j, (entitlementBaseInfo3 == null || (quota2 = entitlementBaseInfo3.getQuota()) == null || (creditsLimit2 = quota2.getCreditsLimit()) == null) ? 0L : creditsLimit2.longValue());
            }
            obj = Result.constructor-impl(Long.valueOf(j));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Long l = (Long) obj;
        if (l != null) {
            long longValue = l.longValue();
            BigDecimal bigDecimal = BigDecimal.ZERO;
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                EntUsage usage = ((UserEntitlementPack) it3.next()).getUsage();
                double doubleValue = (usage == null || (creditsAmount = usage.getCreditsAmount()) == null) ? 0.0d : creditsAmount.doubleValue();
                if (!(Math.abs(doubleValue) <= Double.MAX_VALUE) || doubleValue < 0.0d) {
                    return null;
                }
                bigDecimal = bigDecimal.add(BigDecimal.valueOf(doubleValue));
            }
            try {
                Result.Companion companion3 = Result.Companion;
                obj2 = Result.constructor-impl(Long.valueOf(bigDecimal.setScale(0, RoundingMode.HALF_UP).longValueExact()));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
            }
            if (Result.isFailure-impl(obj2)) {
                obj2 = null;
            }
            Long l2 = (Long) obj2;
            if (l2 != null) {
                long longValue2 = l2.longValue();
                return new CreditsBalance(longValue, longValue2, RangesKt.coerceAtLeast(longValue - longValue2, 0L), false, 8, null);
            }
        }
        return null;
    }

    public static final CNUserPayStatusData selectCachedCNPayStatusForRequest(String str, String str2, String str3, CNUserPayStatusData cNUserPayStatusData) {
        Intrinsics.checkNotNullParameter(str, "requestUserId");
        if (!StringsKt.isBlank(str) && Intrinsics.areEqual(str2, str) && Intrinsics.areEqual(str3, str)) {
            return cNUserPayStatusData;
        }
        return null;
    }
}
