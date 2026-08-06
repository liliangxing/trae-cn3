package com.bytedance.trae.login.api;

import android.app.Activity;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.trae.home.solo.setting.SettingsTracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IDouyinLoginService.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\tH\u0016JP\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f28\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00030\u0011H\u0016JX\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f28\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00030\u0011H\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/login/api/IDouyinLoginService;", "", "authorize", "", "activity", "Landroid/app/Activity;", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/trae/login/api/IAccountCallback;", "businessScene", "", "isBound", "", "getDouyinNickname", SettingsTracker.BINDING_ACTION_UNBIND, "onSuccess", "Lkotlin/Function0;", "onFail", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "errorCode", "errorMsg", "bindToAccount", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IDouyinLoginService {

    /* compiled from: IDouyinLoginService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void authorize(IDouyinLoginService iDouyinLoginService, Activity activity, IAccountCallback callback, String str) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(callback, "callback");
        }

        public static void bindToAccount(IDouyinLoginService iDouyinLoginService, Activity activity, Function0<Unit> onSuccess, Function2<? super Integer, ? super String, Unit> onFail) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onFail, "onFail");
        }

        public static String getDouyinNickname(IDouyinLoginService iDouyinLoginService) {
            return null;
        }

        public static boolean isBound(IDouyinLoginService iDouyinLoginService) {
            return false;
        }

        public static void unbind(IDouyinLoginService iDouyinLoginService, Function0<Unit> onSuccess, Function2<? super Integer, ? super String, Unit> onFail) {
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onFail, "onFail");
        }
    }

    void authorize(Activity activity, IAccountCallback callback, String businessScene);

    void bindToAccount(Activity activity, Function0<Unit> onSuccess, Function2<? super Integer, ? super String, Unit> onFail);

    String getDouyinNickname();

    boolean isBound();

    void unbind(Function0<Unit> onSuccess, Function2<? super Integer, ? super String, Unit> onFail);
}
