package com.bytedance.webx;

import com.bytedance.webx.impl.IWebX;
import com.bytedance.webx.impl.WebXImpl;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class WebX {
    private static IWebX sDefaultWebX;
    private static HashMap<String, IWebX> sWebXMap = new HashMap<>();

    private WebX() {
    }

    public static <T extends IManager> T getContainerManager(Class<T> cls) {
        IWebX iWebX = sDefaultWebX;
        if (iWebX != null) {
            return (T) iWebX.getContainerManager(cls);
        }
        IWebX webX = getWebX("");
        sDefaultWebX = webX;
        return (T) webX.getContainerManager(cls);
    }

    public static <T extends IManager> T getContainerManager(String str, Class<T> cls) {
        return (T) getWebX(str).getContainerManager(cls);
    }

    private static IWebX getWebX(String str) {
        IWebX iWebX = sWebXMap.get(str);
        if (iWebX != null) {
            return iWebX;
        }
        synchronized (WebX.class) {
            IWebX iWebX2 = sWebXMap.get(str);
            if (iWebX2 != null) {
                return iWebX2;
            }
            WebXImpl webXImpl = new WebXImpl(str);
            HashMap<String, IWebX> hashMap = new HashMap<>(sWebXMap);
            hashMap.put(str, webXImpl);
            sWebXMap = hashMap;
            return webXImpl;
        }
    }
}
