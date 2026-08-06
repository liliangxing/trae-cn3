package com.bytedance.ies.bullet.secure;

import android.content.Context;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.annotation.GeckoRegister;
import com.bytedance.geckox.settings.IGeckoRegister;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ArgusSdkGeckoAppRegister.kt */
@GeckoRegister(boeAccessKey = ArgusSdkGeckoAppRegister.BOE_ACCESS_KEY, prodAccessKey = ArgusSdkGeckoAppRegister.ONLINE_ACCESS_KEY, testAccessKey = ArgusSdkGeckoAppRegister.TEST_ACCESS_KEY)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/secure/ArgusSdkGeckoAppRegister;", "Lcom/bytedance/geckox/settings/IGeckoRegister;", "()V", "registerCustomParams", "", "", "Lcom/bytedance/geckox/OptionCheckUpdateParams$CustomValue;", "registerRootDir", "context", "Landroid/content/Context;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArgusSdkGeckoAppRegister implements IGeckoRegister {
    public static final String BOE_ACCESS_KEY = "afe58e0f6709cd80a6524f309678f67d";
    public static final String DIR_NAME = "offlineX";
    public static final String ONLINE_ACCESS_KEY = "d8feacce0eae150c8140e5c435ccbbda";
    public static final String TEST_ACCESS_KEY = "e1927d8fdbbf6786914e8ca27307104b";

    public Map<String, OptionCheckUpdateParams.CustomValue> registerCustomParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("business_version", new OptionCheckUpdateParams.CustomValue() { // from class: com.bytedance.ies.bullet.secure.ArgusSdkGeckoAppRegister$registerCustomParams$1$1
            public final Object getValue() {
                return "9.0.0";
            }
        });
        return linkedHashMap;
    }

    public String registerRootDir(Context context) {
        return GeckoGlobalManager.inst().getContext().getFilesDir().getAbsolutePath() + File.separator + DIR_NAME;
    }
}
