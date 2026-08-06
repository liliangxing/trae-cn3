package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.Utils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class OaidSp {
    private static final String KEY_OAID = "oaid";
    private static final String SP_FILE = "device_register_oaid_refine";
    private final SharedPreferences sp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OaidSp(Context context) {
        this.sp = context.getSharedPreferences(SP_FILE, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void save(OaidModel oaidModel) {
        if (oaidModel == null) {
            return;
        }
        this.sp.edit().putString("oaid", oaidModel.toJson().toString()).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OaidModel fetch() {
        return OaidModel.create(this.sp.getString("oaid", ""));
    }

    public void clear() {
        Utils.removeSpValues(this.sp, new String[]{"oaid"});
    }
}
