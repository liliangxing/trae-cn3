package com.lynx.jsbridge;

import android.os.Build;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.SafeRunnable;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.UIThreadUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxAccessibilityModule extends LynxContextModule {
    public static final String MSG = "msg";
    public static final String MSG_CONTENT = "content";
    public static final String MSG_MUTATION_STYLES = "mutation_styles";
    public static final String NAME = "LynxAccessibilityModule";

    public LynxAccessibilityModule(LynxContext lynxContext) {
        super(lynxContext);
    }

    @LynxMethod
    void registerMutationStyle(final ReadableMap readableMap, final Callback callback) {
        UIThreadUtils.runOnUiThread(new SafeRunnable(this.mLynxContext) { // from class: com.lynx.jsbridge.LynxAccessibilityModule.1
            @Override // com.lynx.react.bridge.SafeRunnable
            public void unsafeRun() {
                JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
                LynxAccessibilityModule.this.registerMutationStyleInner(readableMap, javaOnlyMap);
                callback.invoke(javaOnlyMap);
            }
        });
    }

    void registerMutationStyleInner(ReadableMap readableMap, JavaOnlyMap javaOnlyMap) {
        if (this.mLynxContext.getLynxAccessibilityWrapper() == null) {
            javaOnlyMap.putString("msg", "Fail: init accessibility env error with a11y wrapper is null");
        } else {
            this.mLynxContext.getLynxAccessibilityWrapper().registerMutationStyleInner(readableMap, javaOnlyMap);
        }
    }

    @LynxMethod
    void accessibilityAnnounce(final ReadableMap readableMap, final Callback callback) {
        UIThreadUtils.runOnUiThread(new SafeRunnable(this.mLynxContext) { // from class: com.lynx.jsbridge.LynxAccessibilityModule.2
            @Override // com.lynx.react.bridge.SafeRunnable
            public void unsafeRun() {
                JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
                LynxAccessibilityModule.this.accessibilityAnnounceInner(readableMap, javaOnlyMap);
                callback.invoke(javaOnlyMap);
            }
        });
    }

    void accessibilityAnnounceInner(ReadableMap readableMap, JavaOnlyMap javaOnlyMap) {
        String string = readableMap != null ? readableMap.getString("content") : null;
        if (string != null) {
            if (this.mLynxContext != null && this.mLynxContext.getLynxView() != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    this.mLynxContext.getLynxView().setAccessibilityPaneTitle(string);
                } else {
                    this.mLynxContext.getLynxView().announceForAccessibility(string);
                }
                javaOnlyMap.putString("msg", "Success");
                return;
            }
            javaOnlyMap.putString("msg", "Error: LynxView missing");
            return;
        }
        javaOnlyMap.putString("msg", "Params error: no content found");
    }
}
