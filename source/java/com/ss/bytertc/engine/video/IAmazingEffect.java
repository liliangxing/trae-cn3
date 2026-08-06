package com.ss.bytertc.engine.video;

import java.util.List;

/* loaded from: classes7.dex */
public abstract class IAmazingEffect {
    public abstract int appendEffectNodes(List<String> effectNodes);

    public abstract int removeEffectNodes(List<String> effectNodes);

    public abstract int replaceEffectNodes(List<String> oldEffectNodes, List<String> newEffectNodes);

    public abstract int setAlgoModelResourceFinder(IRtcResourceFinder finder);

    public abstract int setEffectNodes(List<String> effectNodes);

    public abstract void setVirtualBackgroundFilePath(String path, int id);

    public abstract int updateEffectNode(String effectNode, String key, float value);

    public static String getEffectSDKVersion() {
        return AmazingEffect.getEffectSDKVersion();
    }
}
