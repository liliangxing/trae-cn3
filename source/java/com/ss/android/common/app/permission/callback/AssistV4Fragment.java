package com.ss.android.common.app.permission.callback;

import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssistV4Fragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00052\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\u0013Rg\u0010\u0003\u001aO\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00020\n0\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/ss/android/common/app/permission/callback/AssistV4Fragment;", "Landroidx/fragment/app/Fragment;", "()V", "onRequestPermissionsResult", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "requestCode", "", "", "permissions", "", "grantResults", "", "getOnRequestPermissionsResult", "()Lkotlin/jvm/functions/Function3;", "setOnRequestPermissionsResult", "(Lkotlin/jvm/functions/Function3;)V", "(I[Ljava/lang/String;[I)V", "permissions_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class AssistV4Fragment extends Fragment {
    private HashMap _$_findViewCache;
    public Function3<? super Integer, ? super String[], ? super int[], Unit> onRequestPermissionsResult;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final Function3<Integer, String[], int[], Unit> getOnRequestPermissionsResult() {
        Function3 function3 = this.onRequestPermissionsResult;
        if (function3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onRequestPermissionsResult");
        }
        return function3;
    }

    public final void setOnRequestPermissionsResult(Function3<? super Integer, ? super String[], ? super int[], Unit> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "<set-?>");
        this.onRequestPermissionsResult = function3;
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkParameterIsNotNull(permissions, "permissions");
        Intrinsics.checkParameterIsNotNull(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Function3<? super Integer, ? super String[], ? super int[], Unit> function3 = this.onRequestPermissionsResult;
        if (function3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onRequestPermissionsResult");
        }
        function3.invoke(Integer.valueOf(requestCode), permissions, grantResults);
    }
}
