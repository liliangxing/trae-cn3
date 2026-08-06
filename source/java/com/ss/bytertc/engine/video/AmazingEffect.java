package com.ss.bytertc.engine.video;

import android.util.Log;
import com.ss.bytertc.engine.NativeAmazingEffectFunctions;
import com.ss.bytertc.engine.utils.LogUtil;
import java.util.List;

/* loaded from: classes7.dex */
public class AmazingEffect extends IAmazingEffect {
    private static final String TAG = "AmazingEffect";
    private static boolean mLibraryLoaded = false;
    private static final String sSoLibraryName = "volcenginertc";
    private long mNativeAmazingEffect;

    static {
        try {
            System.loadLibrary("effect");
            System.loadLibrary("volcenginertc");
            mLibraryLoaded = true;
            Log.i(TAG, "Loading library: effect");
        } catch (UnsatisfiedLinkError e) {
            mLibraryLoaded = false;
            Log.e(TAG, "Failed to load native library: effect", e);
        }
    }

    public AmazingEffect(long nativeAmazingEffect) {
        this.mNativeAmazingEffect = nativeAmazingEffect;
        LogUtil.i(TAG, "create amazing effect");
    }

    public void dispose() {
        LogUtil.i(TAG, "dispose amazing effect");
        this.mNativeAmazingEffect = 0L;
    }

    private boolean amazingEffectInvalid() {
        return this.mNativeAmazingEffect == 0;
    }

    public static String getEffectSDKVersion() {
        return !mLibraryLoaded ? "unkonw" : NativeAmazingEffectFunctions.nativeGetEffectSDKVersion();
    }

    @Override // com.ss.bytertc.engine.video.IAmazingEffect
    public int setAlgoModelResourceFinder(IRtcResourceFinder finder) {
        if (amazingEffectInvalid()) {
            LogUtil.e(TAG, "invalid, setAlgoModelResourceFinder failed.");
            return -1006;
        }
        EffectResourceFinderAdapter.sFinder = finder;
        return 0;
    }

    @Override // com.ss.bytertc.engine.video.IAmazingEffect
    public int setEffectNodes(List<String> effect_nodes) {
        if (amazingEffectInvalid()) {
            LogUtil.e(TAG, "invalid, setEffectNodes failed.");
            return -1006;
        }
        if (effect_nodes == null) {
            LogUtil.e(TAG, "param invalid, appendEffectNodes failed.");
            return -1;
        }
        String[] strArr = new String[effect_nodes.size()];
        effect_nodes.toArray(strArr);
        return NativeAmazingEffectFunctions.nativeSetAmazingEffectNodes(this.mNativeAmazingEffect, strArr);
    }

    @Override // com.ss.bytertc.engine.video.IAmazingEffect
    public int appendEffectNodes(List<String> effect_nodes) {
        if (amazingEffectInvalid()) {
            LogUtil.e(TAG, "invalid, appendEffectNodes failed.");
            return -1006;
        }
        if (effect_nodes == null) {
            LogUtil.e(TAG, "param invalid, appendEffectNodes failed.");
            return -1;
        }
        String[] strArr = new String[effect_nodes.size()];
        effect_nodes.toArray(strArr);
        return NativeAmazingEffectFunctions.nativeAppendAmazingEffectNodes(this.mNativeAmazingEffect, strArr);
    }

    @Override // com.ss.bytertc.engine.video.IAmazingEffect
    public int removeEffectNodes(List<String> effect_nodes) {
        if (amazingEffectInvalid()) {
            LogUtil.e(TAG, "invalid, removeEffectNodes failed.");
            return -1006;
        }
        if (effect_nodes == null) {
            LogUtil.e(TAG, "param invalid, appendEffectNodes failed.");
            return -1;
        }
        String[] strArr = new String[effect_nodes.size()];
        effect_nodes.toArray(strArr);
        return NativeAmazingEffectFunctions.nativeRemoveAmazingEffectNodes(this.mNativeAmazingEffect, strArr);
    }

    @Override // com.ss.bytertc.engine.video.IAmazingEffect
    public int replaceEffectNodes(List<String> oldEffectNodes, List<String> newEffectNodes) {
        if (amazingEffectInvalid()) {
            LogUtil.e(TAG, "invalid, removeEffectNodes failed.");
            return -1006;
        }
        if (oldEffectNodes == null || newEffectNodes == null) {
            LogUtil.e(TAG, "param invalid, appendEffectNodes failed.");
            return -1;
        }
        String[] strArr = new String[oldEffectNodes.size()];
        oldEffectNodes.toArray(strArr);
        String[] strArr2 = new String[newEffectNodes.size()];
        newEffectNodes.toArray(strArr2);
        return NativeAmazingEffectFunctions.nativeReplaceAmazingEffectNodes(this.mNativeAmazingEffect, strArr, strArr2);
    }

    @Override // com.ss.bytertc.engine.video.IAmazingEffect
    public int updateEffectNode(String effectNode, String key, float value) {
        if (amazingEffectInvalid()) {
            LogUtil.e(TAG, "invalid, updateEffectNode failed.");
            return -1006;
        }
        return NativeAmazingEffectFunctions.nativeUpdateAmazingEffectNode(this.mNativeAmazingEffect, effectNode, key, value);
    }

    @Override // com.ss.bytertc.engine.video.IAmazingEffect
    public void setVirtualBackgroundFilePath(String path, int id) {
        if (amazingEffectInvalid()) {
            LogUtil.e(TAG, "invalid, updateEffectNode failed.");
        } else {
            NativeAmazingEffectFunctions.nativeSetVirtualBackgroundFilePath(this.mNativeAmazingEffect, path, id);
        }
    }
}
