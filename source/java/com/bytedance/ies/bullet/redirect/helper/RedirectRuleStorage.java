package com.bytedance.ies.bullet.redirect.helper;

import android.app.Application;
import android.content.SharedPreferences;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.redirect.data.RedirectSettingsData;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RedirectRuleStorage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/helper/RedirectRuleStorage;", "", "()V", "restore", "Lcom/bytedance/ies/bullet/redirect/data/RedirectSettingsData;", "save", "", "data", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RedirectRuleStorage {
    private static final String SP_FILE_NAME = "annie_redirect";
    private static final String SP_KEY = "redirect_rules";

    public final void save(final RedirectSettingsData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Schedulers.io().scheduleDirect(new Runnable() { // from class: com.bytedance.ies.bullet.redirect.helper.RedirectRuleStorage$save$1
            @Override // java.lang.Runnable
            public final void run() {
                SharedPreferences.Editor edit;
                SharedPreferences.Editor putString;
                Application application = BulletEnv.INSTANCE.getInstance().getApplication();
                SharedPreferences sharedPreferences = application != null ? application.getSharedPreferences("annie_redirect", 0) : null;
                if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null || (putString = edit.putString("redirect_rules", RedirectSettingsData.INSTANCE.toJson(RedirectSettingsData.this))) == null) {
                    return;
                }
                putString.apply();
            }
        });
    }

    public final RedirectSettingsData restore() {
        Application application = BulletEnv.INSTANCE.getInstance().getApplication();
        SharedPreferences sharedPreferences = application != null ? application.getSharedPreferences("annie_redirect", 0) : null;
        String string = sharedPreferences != null ? sharedPreferences.getString(SP_KEY, "") : null;
        String str = string;
        if (str == null || str.length() == 0) {
            return null;
        }
        RedirectSettingsData fromJson = RedirectSettingsData.INSTANCE.fromJson(string);
        if (fromJson == null) {
            sharedPreferences.edit().remove(SP_KEY).apply();
        }
        return fromJson;
    }
}
