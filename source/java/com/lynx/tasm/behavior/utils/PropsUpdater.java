package com.lynx.tasm.behavior.utils;

import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.CSSPropertySetter;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.utils.PropsSetterCache;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.utils.CallStackUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PropsUpdater {
    private static final Map<Class<?>, LynxUISetter<?>> LYNX_UI_SETTER_MAP = new ConcurrentHashMap();
    private static final Map<Class<?>, ShadowNodeSetter<?>> SHADOW_NODE_SETTER_MAP = new ConcurrentHashMap();
    private static final Map<String, Settable> PRE_REGISTER_MAP = new HashMap();

    public static void registerSetter(Settable settable) {
        PRE_REGISTER_MAP.put(settable.getClass().getName(), settable);
    }

    public static void clear() {
        PropsSetterCache.clear();
        SHADOW_NODE_SETTER_MAP.clear();
        LYNX_UI_SETTER_MAP.clear();
    }

    public static void updateProps(LynxBaseUI lynxBaseUI, StylesDiffMap stylesDiffMap) {
        LynxUISetter findLynxUISetter = findLynxUISetter(lynxBaseUI.getClass());
        ReadableMapKeySetIterator keySetIterator = stylesDiffMap.mBackingMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            try {
                findLynxUISetter.setProperty(lynxBaseUI, nextKey, stylesDiffMap);
            } catch (Throwable th) {
                LynxError lynxError = new LynxError(130100, "Error while updating property '" + nextKey + "' in ui '" + lynxBaseUI.getTagName() + "': " + th, "", "error");
                lynxError.setCallStack(CallStackUtil.getStackTraceStringWithLineTrimmed(th));
                lynxError.setUserDefineInfo(lynxBaseUI.getPlatformCustomInfo());
                lynxBaseUI.getLynxContext().handleLynxError(lynxError);
            }
        }
        CSSPropertySetter.updateStyles(lynxBaseUI, stylesDiffMap.getStyleMap());
    }

    public static <T extends ShadowNode> void updateProps(T t, StylesDiffMap stylesDiffMap) {
        ShadowNodeSetter findNodeSetter = findNodeSetter(t.getClass());
        ReadableMapKeySetIterator keySetIterator = stylesDiffMap.mBackingMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            findNodeSetter.setProperty(t, keySetIterator.nextKey(), stylesDiffMap);
        }
        CSSPropertySetter.updateStyles(t, stylesDiffMap.getStyleMap());
    }

    public static LynxUISetter<LynxBaseUI> getLynxUISetter(LynxBaseUI lynxBaseUI) {
        return findLynxUISetter(lynxBaseUI.getClass());
    }

    public static void setProperty(LynxBaseUI lynxBaseUI, LynxUISetter<LynxBaseUI> lynxUISetter, String str, StylesDiffMap stylesDiffMap) {
        try {
            lynxUISetter.setProperty(lynxBaseUI, str, stylesDiffMap);
        } catch (Throwable th) {
            LynxError lynxError = new LynxError(130100, "Error while setProperty '" + str + "' in ui '" + lynxBaseUI.getTagName() + "': " + th, "", "error");
            lynxError.setCallStack(CallStackUtil.getStackTraceStringWithLineTrimmed(th));
            lynxError.setUserDefineInfo(lynxBaseUI.getPlatformCustomInfo());
            lynxBaseUI.getLynxContext().handleLynxError(lynxError);
        }
    }

    static <T extends LynxBaseUI> LynxUISetter<T> findLynxUISetter(Class<? extends LynxBaseUI> cls) {
        Map<Class<?>, LynxUISetter<?>> map = LYNX_UI_SETTER_MAP;
        LynxUISetter<T> lynxUISetter = (LynxUISetter) map.get(cls);
        if (lynxUISetter == null) {
            lynxUISetter = (LynxUISetter) findGeneratedSetter(cls);
            if (lynxUISetter == null) {
                String str = "PropsSetter not generated for class: " + cls.getName() + ". You should add module lynxProcessor";
                if (LynxEnv.inst().isCheckPropsSetter() && LynxEnv.inst().isLynxDebugEnabled()) {
                    throw new IllegalStateException(str);
                }
                LLog.e("PropsUpdater", str);
                lynxUISetter = new FallbackLynxUISetter<>(cls);
                LynxEventReporter.onEvent("lynxsdk_props_setter_fallback", new HashMap<String, Object>(cls) { // from class: com.lynx.tasm.behavior.utils.PropsUpdater.1
                    final /* synthetic */ Class val$lynxUIClass;

                    {
                        this.val$lynxUIClass = cls;
                        put("class_name", cls.getName());
                    }
                }, -1);
            }
            map.put(cls, lynxUISetter);
        }
        return lynxUISetter;
    }

    static <T extends ShadowNode> ShadowNodeSetter<T> findNodeSetter(Class<? extends ShadowNode> cls) {
        Map<Class<?>, ShadowNodeSetter<?>> map = SHADOW_NODE_SETTER_MAP;
        ShadowNodeSetter<T> shadowNodeSetter = (ShadowNodeSetter) map.get(cls);
        if (shadowNodeSetter == null) {
            shadowNodeSetter = (ShadowNodeSetter) findGeneratedSetter(cls);
            if (shadowNodeSetter == null) {
                shadowNodeSetter = new FallbackShadowNodeSetter<>(cls);
            }
            map.put(cls, shadowNodeSetter);
        }
        return shadowNodeSetter;
    }

    private static <T> T findGeneratedSetter(Class<?> cls) {
        String str = cls.getName() + "$$PropsSetter";
        T t = (T) PRE_REGISTER_MAP.get(str);
        if (t != null) {
            return t;
        }
        try {
            return (T) Class.forName(str).newInstance();
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (IllegalAccessException e) {
            e = e;
            throw new RuntimeException("Unable to instantiate methods getter for " + str, e);
        } catch (InstantiationException e2) {
            e = e2;
            throw new RuntimeException("Unable to instantiate methods getter for " + str, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class FallbackLynxUISetter<T extends LynxBaseUI> implements LynxUISetter<T> {
        private final Map<String, PropsSetterCache.PropSetter> mPropSetters;

        private FallbackLynxUISetter(Class<? extends LynxBaseUI> cls) {
            this.mPropSetters = PropsSetterCache.getNativePropSettersForLynxUIClass(cls);
        }

        @Override // com.lynx.tasm.behavior.utils.LynxUISetter
        public void setProperty(LynxBaseUI lynxBaseUI, String str, StylesDiffMap stylesDiffMap) {
            PropsSetterCache.PropSetter propSetter = this.mPropSetters.get(str);
            if (propSetter != null) {
                propSetter.updateLynxUIProp(lynxBaseUI, stylesDiffMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class FallbackShadowNodeSetter<T extends ShadowNode> implements ShadowNodeSetter<T> {
        private final Map<String, PropsSetterCache.PropSetter> mPropSetters;

        private FallbackShadowNodeSetter(Class<? extends ShadowNode> cls) {
            this.mPropSetters = PropsSetterCache.getNativePropSettersForShadowNodeClass(cls);
        }

        @Override // com.lynx.tasm.behavior.utils.ShadowNodeSetter
        public void setProperty(ShadowNode shadowNode, String str, StylesDiffMap stylesDiffMap) {
            PropsSetterCache.PropSetter propSetter = this.mPropSetters.get(str);
            if (propSetter != null) {
                propSetter.updateShadowNodeProp(shadowNode, stylesDiffMap);
            }
        }
    }
}
