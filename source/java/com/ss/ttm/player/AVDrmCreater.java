package com.ss.ttm.player;

/* loaded from: classes7.dex */
public class AVDrmCreater {
    public static final int DrmTypeIntertrust = 1;
    public static final int DrmTypeNone = 0;

    public static synchronized long createDrm(int drmType) {
        synchronized (AVDrmCreater.class) {
            if (drmType != 1) {
                return 0L;
            }
            return createDrm(100, "com.ss.ttm.drm.intertrust.IntertrustDrm");
        }
    }

    private static long createDrm(int pluginType, String className) {
        try {
            ClassLoader loadPlugin = TTPlayerPluginLoader.loadPlugin(pluginType);
            return Long.parseLong(String.valueOf((loadPlugin != null ? Class.forName(className, true, loadPlugin) : Class.forName(className)).getMethod("createDrm", new Class[0]).invoke(null, new Object[0])));
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
