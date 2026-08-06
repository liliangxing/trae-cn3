package com.bytedance.sdk.xbridge.cn.calendar.utils;

import android.net.Uri;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.bytedance.sdk.account.constants.AccountConstants;
import com.bytedance.trae.home.solo.setting.SettingsTracker;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KotlinUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00012\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0005\u001a\u0004\u0018\u0001H\u00032\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00010\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u001a\u0010\t\u001a\u00020\n*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"lets", "R", "T1", "T2", "x1", "x2", "block", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "asSyncAdapter", "Landroid/net/Uri;", SettingsTracker.TYPE_ACCOUNT, "", "accountType", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class KotlinUtilsKt {
    public static final <T1, T2, R> R lets(T1 t1, T2 t2, Function2<? super T1, ? super T2, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (t1 == null || t2 == null) {
            return null;
        }
        return block.invoke(t1, t2);
    }

    public static final Uri asSyncAdapter(Uri uri, String account, String accountType) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(accountType, "accountType");
        Uri build = uri.buildUpon().appendQueryParameter("caller_is_syncadapter", RouterConstants.TRUE).appendQueryParameter("account_name", account).appendQueryParameter(AccountConstants.AccountShareCols.ACCOUNT_TYPE, accountType).build();
        Intrinsics.checkNotNullExpressionValue(build, "buildUpon().appendQueryP…YPE, accountType).build()");
        return build;
    }
}
