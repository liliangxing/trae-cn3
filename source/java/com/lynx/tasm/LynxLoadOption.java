package com.lynx.tasm;

/* loaded from: classes6.dex */
public enum LynxLoadOption {
    DUMP_ELEMENT(2),
    RECYCLE_TEMPLATE_BUNDLE(4),
    PROCESS_LAYOUT_WITHOUT_UI_FLUSH(8),
    RENDER_FOR_RECREATE_ENGINE(16);

    private int mId;

    LynxLoadOption(int i) {
        this.mId = i;
    }

    public int id() {
        return this.mId;
    }
}
