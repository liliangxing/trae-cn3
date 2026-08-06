package com.bytedance.ies.bullet.redirect.api;

import com.bytedance.ies.bullet.redirect.data.RedirectInputInfo;
import com.bytedance.ies.bullet.redirect.data.RedirectOutputInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAnnieXRedirectInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001Jk\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00030\u000726\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00030\fH\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/api/IAnnieXRedirectInterceptor;", "", "intercept", "", "info", "Lcom/bytedance/ies/bullet/redirect/data/RedirectInputInfo;", "success", "Lkotlin/Function1;", "Lcom/bytedance/ies/bullet/redirect/data/RedirectOutputInfo;", "Lkotlin/ParameterName;", "name", "fail", "Lkotlin/Function2;", "", "code", "", "msg", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IAnnieXRedirectInterceptor {

    /* compiled from: IAnnieXRedirectInterceptor.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void intercept(IAnnieXRedirectInterceptor iAnnieXRedirectInterceptor, RedirectInputInfo info, Function1<? super RedirectOutputInfo, Unit> success, Function2<? super Integer, ? super String, Unit> fail) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(success, "success");
            Intrinsics.checkNotNullParameter(fail, "fail");
        }
    }

    void intercept(RedirectInputInfo info, Function1<? super RedirectOutputInfo, Unit> success, Function2<? super Integer, ? super String, Unit> fail);
}
