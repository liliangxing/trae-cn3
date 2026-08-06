package com.bytedance.android.service.manager.permission.boot;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IPermissionBootDialog {

    /* loaded from: classes3.dex */
    public interface ClickListener {
        void onAgree(boolean z);

        void onReject();

        void onShowResult(boolean z, String str);
    }

    boolean showDialog(JSONObject jSONObject, ClickListener clickListener);
}
