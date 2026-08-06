package com.lynx.tasm.service.async;

import android.content.Context;
import com.lynx.tasm.service.async.IPreLayoutContainer;
import java.util.HashMap;

/* loaded from: classes7.dex */
public abstract class IPreLayoutContainerCreator<T extends IPreLayoutContainer> {
    public abstract T createContainer(Context context, HashMap<String, Object> hashMap);

    public String getCreateIdentify() {
        return "";
    }
}
