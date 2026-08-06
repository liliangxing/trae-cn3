package com.lynx.tasm;

import com.lynx.tasm.LynxGroup;

/* loaded from: classes6.dex */
public final class LynxStorageGroup extends LynxGroup {
    LynxStorageGroup(String str, String str2, String[] strArr, boolean z, boolean z2, boolean z3, Boolean bool) {
        super(str, str2, strArr, z, z2, z3, bool, true);
    }

    /* loaded from: classes6.dex */
    public static class LynxStorageGroupBuilder extends LynxGroup.LynxGroupBuilder {
        @Override // com.lynx.tasm.LynxGroup.LynxGroupBuilder
        public LynxStorageGroup build() {
            return new LynxStorageGroup(this.mGroupName, this.mHasSetID ? this.mID : LynxGroup.generateID(), this.mPreloadJSPaths, false, this.mEnableCanvas, this.mEnableV8, this.mEnableJSGroupThread);
        }
    }
}
