package com.bytedance.android.monitorV2.exception;

import com.bytedance.android.monitorV2.executor.HybridMonitorExecutor;
import com.bytedance.android.monitorV2.util.ReportDataUtils;
import com.bytedance.android.monitorV2.util.UrlUtil;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: HybridCrashHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u000b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/monitorV2/exception/HybridCrashHelper;", "", "()V", "lastBid", "", "lastUrl", "addUserData", "", "bindInfo", "url", "bid", "injectInfo", "schema", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class HybridCrashHelper {
    public static final HybridCrashHelper INSTANCE;
    private static volatile String lastBid;
    private static volatile String lastUrl;

    private HybridCrashHelper() {
    }

    static {
        HybridCrashHelper hybridCrashHelper = new HybridCrashHelper();
        INSTANCE = hybridCrashHelper;
        lastUrl = "";
        lastBid = "";
        hybridCrashHelper.addUserData();
    }

    public final void injectInfo(final String url, final String schema) {
        HybridMonitorExecutor.INSTANCE.post(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.exception.HybridCrashHelper$injectInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m334invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m334invoke() {
                HybridCrashHelper.INSTANCE.bindInfo(url, ReportDataUtils.getBid$default(ReportDataUtils.INSTANCE, url, schema, "", false, 8, null));
            }
        });
    }

    public final void bindInfo(String url, String bid) {
        if (url == null) {
            url = "";
        }
        lastUrl = url;
        if (bid == null) {
            bid = "";
        }
        lastBid = bid;
        HashMap hashMap = new HashMap();
        hashMap.put("last_bdhm_url", UrlUtil.INSTANCE.getFormatUrl(lastUrl));
        hashMap.put("last_bdhm_bid", lastBid);
        Npth.addTags(hashMap);
    }

    private final void addUserData() {
        try {
            Result.Companion companion = Result.Companion;
            Npth.addAttachUserData(new AttachUserData() { // from class: com.bytedance.android.monitorV2.exception.HybridCrashHelper$addUserData$1$1
                @Override // com.bytedance.crash.AttachUserData
                public final Map<? extends String, ? extends String> getUserData(CrashType crashType) {
                    String str;
                    String str2;
                    HashMap hashMap = new HashMap();
                    UrlUtil urlUtil = UrlUtil.INSTANCE;
                    str = HybridCrashHelper.lastUrl;
                    hashMap.put("last_bdhm_url", urlUtil.getFormatUrl(str));
                    str2 = HybridCrashHelper.lastBid;
                    hashMap.put("last_bdhm_bid", str2);
                    return hashMap;
                }
            }, CrashType.ALL);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }
}
