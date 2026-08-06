package com.bytedance.geckox.settings;

import android.content.Context;
import com.bytedance.geckox.OptionCheckUpdateParams;
import java.util.Map;

/* loaded from: classes3.dex */
public interface IGeckoRegister {
    Map<String, OptionCheckUpdateParams.CustomValue> registerCustomParams();

    String registerRootDir(Context context);
}
