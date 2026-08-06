package com.lynx.tasm.behavior.p000ui.accessibility;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.event.LynxImpressionEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxAccessibilityMutationHelper {
    public static final int MUTATION_ACTION_DETACH = 2;
    public static final int MUTATION_ACTION_INSERT = 0;
    public static final int MUTATION_ACTION_REMOVE = 1;
    public static final int MUTATION_ACTION_STYLE_UPDATE = 4;
    public static final int MUTATION_ACTION_UPDATE = 3;
    private static final String TAG = "LynxAccessibilityMutationHelper";
    protected final ArrayList<JavaOnlyMap> mMutationEventList = new ArrayList<>();
    protected final Set<String> mMutationStyles = new HashSet();

    private String mutationEventTypeToString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : "style_update" : "update" : LynxImpressionEvent.EVENT_DETACH : "remove" : "insert";
    }

    public void registerMutationStyle(ReadableArray readableArray) {
        Set<String> set;
        if (readableArray == null || (set = this.mMutationStyles) == null) {
            return;
        }
        set.clear();
        for (int i = 0; i < readableArray.size(); i++) {
            if (readableArray.getType(i) == ReadableType.String) {
                this.mMutationStyles.add(readableArray.getString(i));
            }
        }
    }

    public void insertA11yMutationEvent(int i, LynxBaseUI lynxBaseUI) {
        insertA11yMutationEvent(i, lynxBaseUI, "");
    }

    public void insertA11yMutationEvent(int i, LynxBaseUI lynxBaseUI, String str) {
        if (lynxBaseUI == null || mutationEventTypeToString(i).isEmpty()) {
            return;
        }
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putInt("target", lynxBaseUI.getSign());
        javaOnlyMap.putString("action", mutationEventTypeToString(i));
        javaOnlyMap.putString(PropsConstants.ACCESSIBILITY_ID, lynxBaseUI.getAccessibilityId());
        if (i == 4) {
            if (!this.mMutationStyles.contains(str)) {
                return;
            } else {
                javaOnlyMap.putString("style", str);
            }
        }
        this.mMutationEventList.add(javaOnlyMap);
    }

    public void flushA11yMutationEvents(LynxContext lynxContext) {
        if (lynxContext == null || this.mMutationEventList.isEmpty()) {
            return;
        }
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        Iterator<JavaOnlyMap> it = this.mMutationEventList.iterator();
        while (it.hasNext()) {
            javaOnlyArray.add(it.next());
        }
        JavaOnlyArray javaOnlyArray2 = new JavaOnlyArray();
        javaOnlyArray2.add(javaOnlyArray);
        lynxContext.sendGlobalEvent("a11y-mutations", javaOnlyArray2);
        this.mMutationEventList.clear();
    }
}
