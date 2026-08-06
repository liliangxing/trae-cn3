package com.lynx.tasm;

import com.google.android.material.timepicker.TimeModel;
import com.lynx.tasm.base.LLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class LynxGroup {
    public static String SINGNLE_GROUP = "-1";
    private static int sNextID;
    private Map<String, Object> mConfig;
    private boolean mEnableCanvas;
    private boolean mEnableJSGroupThread;
    private boolean mEnableV8;
    private String mGroupName;
    private String mID;
    private String[] mPreloadJSPaths;
    private LynxWhiteBoard mWhiteBoard;

    public boolean useProviderJsEnv() {
        return false;
    }

    @Deprecated
    public static LynxGroup Create(String str) {
        return Create(str, null);
    }

    @Deprecated
    public static LynxGroup Create(String str, String[] strArr) {
        return Create(str, strArr, false, false);
    }

    @Deprecated
    public static LynxGroup Create(String str, String[] strArr, boolean z, boolean z2) {
        return Create(str, strArr, z, z2, false);
    }

    @Deprecated
    public static LynxGroup Create(String str, String[] strArr, boolean z, boolean z2, boolean z3) {
        return Create(str, generateID(), strArr, z, z2, z3);
    }

    @Deprecated
    public static LynxGroup Create(String str, String str2, String[] strArr, boolean z, boolean z2) {
        return Create(str, str2, strArr, z, z2, false);
    }

    @Deprecated
    public static LynxGroup Create(String str, String str2, String[] strArr, boolean z, boolean z2, boolean z3) {
        return new LynxGroup(str, str2, strArr, z, z2, z3, false, false);
    }

    @Deprecated
    public static LynxGroup Create(String str, String[] strArr, boolean z, boolean z2, boolean z3, boolean z4) {
        return Create(str, generateID(), strArr, z, z2 || z4, z3);
    }

    @Deprecated
    public static LynxGroup Create(String str, String str2, String[] strArr, boolean z, boolean z2, boolean z3, boolean z4) {
        return Create(str, str2, strArr, z, z2 || z4, z3);
    }

    public static LynxGroup Create(LynxGroupBuilder lynxGroupBuilder) {
        return lynxGroupBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LynxGroup(String str, String str2, String[] strArr, boolean z, boolean z2, boolean z3, Boolean bool, boolean z4) {
        this.mGroupName = str;
        this.mID = str2;
        this.mPreloadJSPaths = strArr;
        if (bool == null) {
            this.mEnableJSGroupThread = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.ENABLE_MULTI_JS_THREAD_BY_DEFAULT, false);
        } else {
            this.mEnableJSGroupThread = bool.booleanValue();
        }
        if (z4) {
            this.mWhiteBoard = new LynxWhiteBoard();
        }
        this.mEnableV8 = z3;
        this.mEnableCanvas = z2;
        LLog.i("LynxGroup", "LynxGroup init with name " + str + ", id: " + str2 + ", enableV8: " + z3 + ", canvas:" + this.mEnableCanvas);
    }

    LynxGroup(LynxGroupBuilder lynxGroupBuilder) {
        this.mGroupName = lynxGroupBuilder.mGroupName;
        this.mID = lynxGroupBuilder.mID != null ? lynxGroupBuilder.mID : generateID();
        this.mPreloadJSPaths = lynxGroupBuilder.mPreloadJSPaths;
        if (lynxGroupBuilder.mEnableJSGroupThread == null) {
            this.mEnableJSGroupThread = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.ENABLE_MULTI_JS_THREAD_BY_DEFAULT, false);
        } else {
            this.mEnableJSGroupThread = lynxGroupBuilder.mEnableJSGroupThread.booleanValue();
        }
        this.mEnableV8 = lynxGroupBuilder.mEnableV8;
        this.mConfig = lynxGroupBuilder.mConfig;
        if (lynxGroupBuilder.mEnableWhiteBoard) {
            this.mWhiteBoard = new LynxWhiteBoard();
        }
        this.mEnableCanvas = lynxGroupBuilder.mEnableCanvas;
        LLog.i("LynxGroup", "LynxGroup init with name " + this.mGroupName + ", id: " + this.mID + ", enableV8: " + this.mEnableV8 + ", canvas:" + this.mEnableCanvas);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String generateID() {
        String format = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(sNextID));
        sNextID++;
        return format;
    }

    public String getID() {
        return this.mID;
    }

    public String[] getPreloadJSPaths() {
        return this.mPreloadJSPaths;
    }

    public boolean enableJSGroupThread() {
        return this.mEnableJSGroupThread;
    }

    public void setEnableJSGroupThread(boolean z) {
        this.mEnableJSGroupThread = z;
    }

    public void destroy() {
        LynxWhiteBoard lynxWhiteBoard = this.mWhiteBoard;
        if (lynxWhiteBoard != null) {
            lynxWhiteBoard.destroy();
        }
    }

    public long getWhiteBoardPtr() {
        LynxWhiteBoard lynxWhiteBoard = this.mWhiteBoard;
        if (lynxWhiteBoard != null) {
            return lynxWhiteBoard.getPtr();
        }
        return 0L;
    }

    public boolean enableDynamicV8() {
        return this.mEnableV8;
    }

    public boolean enableV8() {
        return this.mEnableV8;
    }

    public boolean enableCanvas() {
        return this.mEnableCanvas;
    }

    public String getStringConfig(String str) {
        Object obj;
        Map<String, Object> map = this.mConfig;
        if (map == null || (obj = map.get(str)) == null || !(obj instanceof String)) {
            return null;
        }
        return (String) obj;
    }

    public boolean getBoolConfig(String str) {
        Object obj;
        Map<String, Object> map = this.mConfig;
        if (map == null || (obj = map.get(str)) == null || !(obj instanceof Boolean)) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }

    /* loaded from: classes6.dex */
    public static class LynxGroupBuilder {
        protected Map<String, Object> mConfig;
        protected boolean mEnableCanvas;
        protected Boolean mEnableJSGroupThread;
        protected boolean mEnableV8;
        protected boolean mEnableWhiteBoard;
        protected String mGroupName;
        protected boolean mHasSetID;
        protected String mID;
        protected String[] mPreloadJSPaths;

        public LynxGroupBuilder setUseProviderJsEnv(boolean z) {
            return this;
        }

        public LynxGroupBuilder setGroupName(String str) {
            this.mGroupName = str;
            return this;
        }

        public LynxGroupBuilder setID(String str) {
            this.mHasSetID = true;
            this.mID = str;
            return this;
        }

        public LynxGroupBuilder setPreloadJSPaths(String[] strArr) {
            this.mPreloadJSPaths = strArr;
            return this;
        }

        public LynxGroupBuilder setEnableCanvas(boolean z) {
            this.mEnableCanvas = z;
            return this;
        }

        public LynxGroupBuilder setEnableDynamicV8(boolean z) {
            this.mEnableV8 = z;
            return this;
        }

        public LynxGroupBuilder setEnableV8(boolean z) {
            this.mEnableV8 = z;
            return this;
        }

        public LynxGroupBuilder setEnableJSGroupThread(Boolean bool) {
            this.mEnableJSGroupThread = bool;
            return this;
        }

        public LynxGroupBuilder setStringConfig(String str, String str2) {
            if (this.mConfig == null) {
                this.mConfig = new HashMap();
            }
            this.mConfig.put(str, str2);
            return this;
        }

        public LynxGroupBuilder setBoolConfig(String str, boolean z) {
            if (this.mConfig == null) {
                this.mConfig = new HashMap();
            }
            this.mConfig.put(str, Boolean.valueOf(z));
            return this;
        }

        public LynxGroup build() {
            return new LynxGroup(this);
        }
    }
}
