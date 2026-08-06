package com.bytedance.apm.block;

import com.bytedance.apm.util.ListUtils;
import java.util.ConcurrentModificationException;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class FluencySceneManager {
    private static HashSet<String> sFpsScenes = new HashSet<>();
    private static String sFpsScenesString = "";
    private static boolean sInjectSceneChanged = true;

    public static String getInjectScene() {
        if (sInjectSceneChanged) {
            try {
                sFpsScenesString = ListUtils.listToString(sFpsScenes, ",");
                sInjectSceneChanged = false;
            } catch (ConcurrentModificationException unused) {
            }
        }
        return sFpsScenesString;
    }

    public static void addScene(String str) {
        sInjectSceneChanged = true;
        sFpsScenes.add(str);
    }

    public static void removeScene(String str) {
        sInjectSceneChanged = true;
        sFpsScenes.remove(str);
    }
}
