package com.lynx.tasm.behavior;

import com.lynx.tasm.BehaviorClassWarmer;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;

/* loaded from: classes7.dex */
public class Behavior {
    private final boolean mCreateAsync;
    private final boolean mFlatten;
    private String mName;
    private final boolean mNeedProcessDirection;

    public BehaviorClassWarmer createClassWarmer() {
        return null;
    }

    public LynxFlattenUI createFlattenUI(LynxContext lynxContext) {
        return null;
    }

    public LynxFlattenUI createFlattenUIFiber(LynxContext lynxContext) {
        return null;
    }

    public ShadowNode createShadowNode() {
        return null;
    }

    public Behavior(String str) {
        this(str, false, false, false);
    }

    public Behavior(String str, boolean z) {
        this(str, z, false, false);
    }

    public Behavior(String str, boolean z, boolean z2) {
        this(str, z, z2, false);
    }

    public Behavior(String str, boolean z, boolean z2, boolean z3) {
        this.mName = str;
        this.mFlatten = z;
        this.mCreateAsync = z2;
        this.mNeedProcessDirection = z3;
    }

    public boolean supportCreateAsync() {
        return this.mCreateAsync;
    }

    public boolean needProcessDirection() {
        return this.mNeedProcessDirection;
    }

    public LynxUI createUIWithParams(LynxContext lynxContext, Object obj) {
        return createUI(lynxContext);
    }

    public LynxFlattenUI createFlattenUIWithParams(LynxContext lynxContext, Object obj) {
        return createFlattenUI(lynxContext);
    }

    public LynxUI createUI(LynxContext lynxContext) {
        throw new RuntimeException(this.mName + " is a virtual node, do not have real ui!");
    }

    public LynxUI createUIFiber(LynxContext lynxContext) {
        throw new RuntimeException(this.mName + " is a virtual node, do not have real ui!");
    }

    public final boolean supportUIFlatten() {
        return this.mFlatten;
    }

    public String getName() {
        return this.mName;
    }

    public String toString() {
        return "[" + getClass().getSimpleName() + " - " + this.mName + "]";
    }
}
