package com.lynx.tasm;

import android.text.TextUtils;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.base.trace.TraceEventDef;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.common.LepusBuffer;
import com.lynx.tasm.common.NullableConcurrentHashMap;
import com.lynx.tasm.core.LynxThreadPool;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class TemplateData {
    private static final String TAG = "LynxTemplateData";
    private volatile Map<String, Object> mData;
    private volatile boolean mIsConcurrent;
    volatile long mJsNativeData;
    private volatile long mNativeData;
    private String mProcessorName;
    private WeakReference<LynxContext> weakContext;
    private boolean readOnly = false;
    private boolean mEnableJSData = true;
    private final AtomicBoolean mConsumed = new AtomicBoolean(false);
    List<UpdateAction> mUpdateActions = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public enum ActionType {
        STRING_DATA,
        BYTE_BUFFER,
        NATIVE_DATA,
        REMOVE_DATA
    }

    private static native long nativeClone(long j);

    private static native long nativeCreateObject();

    private static native long nativeCreateTemplateData(long j, boolean z, String str, Object obj);

    static native Object nativeGetData(long j);

    static native void nativeMergeTemplateData(long j, long j2);

    private static native long nativeParseData(ByteBuffer byteBuffer, int i);

    private static native long nativeParseStringData(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeReleaseData(long j);

    private static native void nativeReleaseTemplateData(long j);

    private static native void nativeRemoveData(long j, String str);

    private static native long nativeShallowCopy(long j);

    private static native void nativeUpdateData(long j, ByteBuffer byteBuffer, int i);

    static /* synthetic */ boolean access$100() {
        return checkIfEnvPrepared();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class UpdateAction {
        private ByteBuffer mBuffer = null;
        private String mJsonString = null;
        private String mKey = null;
        private long mNativeData = 0;
        private ActionType mType;

        private UpdateAction() {
        }

        static UpdateAction buildBufferAction(ByteBuffer byteBuffer) {
            UpdateAction updateAction = new UpdateAction();
            updateAction.mType = ActionType.BYTE_BUFFER;
            updateAction.mBuffer = byteBuffer;
            return updateAction;
        }

        static UpdateAction buildStringAction(String str) {
            UpdateAction updateAction = new UpdateAction();
            updateAction.mType = ActionType.STRING_DATA;
            updateAction.mJsonString = str;
            return updateAction;
        }

        static UpdateAction buildNativeAction(long j) {
            UpdateAction updateAction = new UpdateAction();
            updateAction.mType = ActionType.NATIVE_DATA;
            updateAction.mNativeData = j;
            return updateAction;
        }

        static UpdateAction buildRemoveAction(String str) {
            UpdateAction updateAction = new UpdateAction();
            updateAction.mType = ActionType.REMOVE_DATA;
            updateAction.mKey = str;
            return updateAction;
        }

        ActionType getType() {
            return this.mType;
        }

        String getJsonString() {
            return this.mJsonString;
        }

        ByteBuffer getByteBuffer() {
            return this.mBuffer;
        }

        long getNativeData() {
            return this.mNativeData;
        }

        protected void finalize() throws Throwable {
            super.finalize();
            long j = this.mNativeData;
            if (j != 0) {
                TemplateData.nativeReleaseData(j);
            }
        }
    }

    public static TemplateData fromMap(Map<String, Object> map) {
        TraceEvent.beginSection(TraceEventDef.TEMPLATE_DATA_FROM_MAP);
        TemplateData templateData = new TemplateData(map);
        TraceEvent.endSection(TraceEventDef.TEMPLATE_DATA_FROM_MAP);
        return templateData;
    }

    public static TemplateData empty() {
        return new TemplateData();
    }

    public static TemplateData fromString(String str) {
        TraceEvent.beginSection(TraceEventDef.TEMPLATE_DATA_FROM_STRING);
        TemplateData templateData = new TemplateData(str);
        TraceEvent.endSection(TraceEventDef.TEMPLATE_DATA_FROM_STRING);
        return templateData;
    }

    private synchronized void addUpdateActions(List<UpdateAction> list) {
        if (list == null) {
            return;
        }
        if (this.mEnableJSData) {
            if (this.mUpdateActions == null) {
                this.mUpdateActions = new ArrayList();
            }
            this.mUpdateActions.addAll(list);
        }
    }

    private synchronized void addUpdateAction(UpdateAction updateAction) {
        if (updateAction == null) {
            return;
        }
        if (this.mEnableJSData) {
            if (this.mUpdateActions == null) {
                this.mUpdateActions = new ArrayList();
            }
            this.mUpdateActions.add(updateAction);
        }
    }

    private synchronized List<UpdateAction> getUpdateActionsWithJsNativeData() {
        if (!this.mEnableJSData) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.mJsNativeData != 0) {
            arrayList.add(UpdateAction.buildNativeAction(nativeShallowCopy(this.mJsNativeData)));
        }
        arrayList.addAll(this.mUpdateActions);
        consumeUpdateActions();
        return arrayList;
    }

    private synchronized List<UpdateAction> obtainUpdateActions() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.mUpdateActions);
        this.mUpdateActions.clear();
        return arrayList;
    }

    public void markConcurrent() {
        this.mIsConcurrent = true;
    }

    public long getNativePtr() {
        return this.mNativeData;
    }

    @Deprecated
    public void removeKey(String str) {
        put(str, null);
    }

    public Map<Object, Object> toMap() {
        if (!checkIfEnvPrepared()) {
            LLog.w(TAG, "toMap failed since env not ready.");
            return null;
        }
        flush();
        if (this.mNativeData == 0) {
            LLog.w(TAG, "toMap failed since mNativeData == 0.");
            return null;
        }
        Object nativeGetData = nativeGetData(this.mNativeData);
        HashMap hashMap = new HashMap();
        if (nativeGetData instanceof Map) {
            hashMap.putAll((Map) nativeGetData);
        }
        return hashMap;
    }

    public void updateWithTemplateData(TemplateData templateData) {
        if (templateData == null) {
            return;
        }
        if (this == templateData) {
            LLog.w(TAG, "can not update TemplateData with self");
            return;
        }
        if (this.readOnly) {
            LLog.w(TAG, "can not update readOnly TemplateData");
            return;
        }
        if (!checkIfEnvPrepared()) {
            LLog.w(TAG, "updateWithTemplateData failed since env not ready.");
            return;
        }
        if (this.mConsumed.get()) {
            LLog.w(TAG, "updateWithTemplateData to consumed TemplateData, this:" + this + ",diff:" + templateData);
        }
        flush();
        templateData.flush();
        addUpdateActions(templateData.getUpdateActionsWithJsNativeData());
        if (templateData.getNativePtr() != 0) {
            nativeMergeTemplateData(getNativePtr(), templateData.getNativePtr());
        }
    }

    public void put(String str, Object obj) {
        if (this.readOnly) {
            LLog.w(TAG, "can not update readOnly TemplateData");
            return;
        }
        if (this.mConsumed.get()) {
            LLog.w(TAG, "put data to consumed TemplateData,key:" + str);
        }
        putSafely(str, obj);
    }

    public void remove(String str) {
        if (!checkIfEnvPrepared()) {
            LLog.e(TAG, "remove failed since env not ready!");
            return;
        }
        if (this.readOnly) {
            LLog.w(TAG, "can not remove readOnly TemplateData");
            return;
        }
        if (this.mConsumed.get()) {
            LLog.w(TAG, "put data to consumed TemplateData,key:" + str);
        }
        addUpdateAction(UpdateAction.buildRemoveAction(str));
        if (this.mNativeData != 0) {
            nativeRemoveData(this.mNativeData, str);
        }
    }

    public void updateData(Map<String, Object> map) {
        if (this.readOnly) {
            LLog.e(TAG, "can not update readOnly TemplateData");
            return;
        }
        if (this.mConsumed.get()) {
            LLog.w(TAG, "updateData to consumed TemplateData, diff:" + map.keySet());
        }
        putSafely(map);
    }

    @Deprecated
    public void updateData(String str, Object obj) {
        put(str, obj);
    }

    public synchronized void flush() {
        if (!checkIfEnvPrepared()) {
            LLog.w(TAG, "Env not ready!");
            return;
        }
        if (this.mData != null && !this.mData.isEmpty()) {
            ByteBuffer encodeMessage = LepusBuffer.INSTANCE.encodeMessage(this.mData);
            this.mData.clear();
            if (encodeMessage != null && encodeMessage.position() > 0) {
                LLog.i(TAG, "flush data." + this);
                addUpdateAction(UpdateAction.buildBufferAction(encodeMessage));
                if (this.mNativeData == 0) {
                    this.mNativeData = nativeParseData(encodeMessage, encodeMessage.position());
                } else {
                    nativeUpdateData(this.mNativeData, encodeMessage, encodeMessage.position());
                }
            }
            return;
        }
        if (this.mNativeData == 0) {
            this.mNativeData = nativeCreateObject();
        }
    }

    protected void finalize() throws Throwable {
        recycle();
        recycleJsData();
        super.finalize();
    }

    public synchronized void recycle() {
        LynxContext lynxContext;
        WeakReference<LynxContext> weakReference = this.weakContext;
        if (weakReference != null && (lynxContext = weakReference.get()) != null) {
            lynxContext.runOnTasmThread(new Runnable() { // from class: com.lynx.tasm.TemplateData.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!TemplateData.access$100() || TemplateData.this.mNativeData == 0) {
                        return;
                    }
                    TemplateData.nativeReleaseData(TemplateData.this.mNativeData);
                    TemplateData.this.mNativeData = 0L;
                }
            });
            return;
        }
        if (checkIfEnvPrepared() && this.mNativeData != 0) {
            nativeReleaseData(this.mNativeData);
            this.mNativeData = 0L;
        }
    }

    synchronized void recycleJsData() {
        LynxContext lynxContext;
        WeakReference<LynxContext> weakReference = this.weakContext;
        if (weakReference != null && (lynxContext = weakReference.get()) != null) {
            lynxContext.runOnTasmThread(new Runnable() { // from class: com.lynx.tasm.TemplateData.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!TemplateData.access$100() || TemplateData.this.mJsNativeData == 0) {
                        return;
                    }
                    TemplateData.nativeReleaseData(TemplateData.this.mJsNativeData);
                    TemplateData.this.mJsNativeData = 0L;
                }
            });
            return;
        }
        if (checkIfEnvPrepared() && this.mJsNativeData != 0) {
            nativeReleaseData(this.mJsNativeData);
            this.mJsNativeData = 0L;
        }
    }

    private synchronized void ensureInternalMap() {
        if (this.mData == null) {
            this.mData = this.mIsConcurrent ? new NullableConcurrentHashMap<>() : new HashMap<>();
        }
    }

    private void putSafely(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        ensureInternalMap();
        this.mData.putAll(map);
    }

    private void putSafely(String str, Object obj) {
        ensureInternalMap();
        this.mData.put(str, obj);
    }

    private TemplateData() {
        LynxEnv.inst();
        this.mProcessorName = null;
    }

    private TemplateData(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        LynxEnv.inst();
        if (!checkIfEnvPrepared()) {
            putSafely(map);
            return;
        }
        ByteBuffer encodeMessage = LepusBuffer.INSTANCE.encodeMessage(map);
        if (encodeMessage == null || encodeMessage.position() <= 0) {
            return;
        }
        this.mNativeData = nativeParseData(encodeMessage, encodeMessage.position());
        this.mProcessorName = null;
        addUpdateAction(UpdateAction.buildBufferAction(encodeMessage));
    }

    static List<Object> jsonArrayToList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Object obj = jSONArray.get(i);
                if (obj instanceof JSONObject) {
                    obj = jsonToMap((JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    obj = jsonArrayToList((JSONArray) obj);
                }
                arrayList.add(obj);
            } catch (Throwable th) {
                LLog.e(TAG, "Failed to parse JSONArray at index " + i + ": " + th.getMessage());
            }
        }
        return arrayList;
    }

    static Map<String, Object> jsonToMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONObject) {
                    obj = jsonToMap((JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    obj = jsonArrayToList((JSONArray) obj);
                }
                hashMap.put(next, obj);
            }
        } catch (Throwable th) {
            LLog.e(TAG, "Failed to parse JSONObject: " + th.getMessage());
        }
        return hashMap;
    }

    private TemplateData(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LynxEnv.inst();
        if (!checkIfEnvPrepared()) {
            try {
                putSafely(jsonToMap(new JSONObject(str)));
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.mNativeData = nativeParseStringData(str);
        this.mProcessorName = null;
        addUpdateAction(UpdateAction.buildStringAction(str));
    }

    public boolean checkIsLegalData() {
        return this.mNativeData != 0;
    }

    private static boolean checkIfEnvPrepared() {
        return LynxEnv.inst().isNativeLibraryLoaded();
    }

    public void markState(String str) {
        this.mProcessorName = str;
    }

    public String processorName() {
        return this.mProcessorName;
    }

    public TemplateData deepClone() {
        if (!checkIfEnvPrepared()) {
            LLog.e(TAG, "deepClone failed since env not ready!");
            return empty();
        }
        flush();
        TemplateData empty = empty();
        if (this.mNativeData != 0) {
            empty.mNativeData = nativeClone(this.mNativeData);
        }
        empty.mProcessorName = this.mProcessorName;
        empty.readOnly = this.readOnly;
        empty.mIsConcurrent = this.mIsConcurrent;
        empty.addUpdateActions(getUpdateActionsWithJsNativeData());
        return empty;
    }

    public TemplateData shallowClone() {
        TraceEvent.beginSection(TraceEventDef.TEMPLATE_DATA_SHALLOW_CLONE);
        if (!checkIfEnvPrepared()) {
            LLog.e(TAG, "shallowClone failed since env not ready!");
            TraceEvent.endSection(TraceEventDef.TEMPLATE_DATA_SHALLOW_CLONE);
            return empty();
        }
        flush();
        TemplateData empty = empty();
        if (this.mNativeData != 0) {
            empty.mNativeData = nativeShallowCopy(this.mNativeData);
        }
        empty.mProcessorName = this.mProcessorName;
        empty.readOnly = this.readOnly;
        empty.mIsConcurrent = this.mIsConcurrent;
        empty.addUpdateActions(getUpdateActionsWithJsNativeData());
        TraceEvent.endSection(TraceEventDef.TEMPLATE_DATA_SHALLOW_CLONE);
        return empty;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bindContext(LynxContext lynxContext) {
        this.weakContext = new WeakReference<>(lynxContext);
    }

    public void markReadOnly() {
        this.readOnly = true;
    }

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public boolean isEmpty() {
        return this.mNativeData == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void markConsumed() {
        this.mConsumed.set(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEnableJSData(boolean z) {
        this.mEnableJSData = z;
    }

    static long createNativeTemplateData(TemplateData templateData) {
        templateData.flush();
        return nativeCreateTemplateData(templateData.getNativePtr(), templateData.isReadOnly(), templateData.processorName(), templateData);
    }

    static void releaseNativeTemplateData(long j) {
        nativeReleaseTemplateData(j);
    }

    private void consumeUpdateActions() {
        LynxThreadPool.getAsyncServiceExecutor().execute(new Runnable() { // from class: com.lynx.tasm.TemplateData.3
            @Override // java.lang.Runnable
            public void run() {
                TemplateData.this.getDataForJSThreadInner();
            }
        });
    }

    synchronized long getDataForJSThreadInner() {
        if (!this.mEnableJSData) {
            return 0L;
        }
        List<UpdateAction> obtainUpdateActions = obtainUpdateActions();
        if (obtainUpdateActions.isEmpty()) {
            return this.mJsNativeData;
        }
        if (this.mJsNativeData == 0) {
            this.mJsNativeData = nativeCreateObject();
        }
        for (UpdateAction updateAction : obtainUpdateActions) {
            int i = AnonymousClass4.$SwitchMap$com$lynx$tasm$TemplateData$ActionType[updateAction.getType().ordinal()];
            if (i == 1) {
                String jsonString = updateAction.getJsonString();
                if (!TextUtils.isEmpty(jsonString)) {
                    long nativeParseStringData = nativeParseStringData(jsonString);
                    nativeMergeTemplateData(this.mJsNativeData, nativeParseStringData);
                    nativeReleaseData(nativeParseStringData);
                }
            } else if (i == 2) {
                nativeMergeTemplateData(this.mJsNativeData, updateAction.getNativeData());
            } else if (i == 3) {
                ByteBuffer byteBuffer = updateAction.getByteBuffer();
                if (byteBuffer != null && byteBuffer.position() != 0) {
                    nativeUpdateData(this.mJsNativeData, updateAction.getByteBuffer(), updateAction.getByteBuffer().position());
                }
            } else if (i == 4) {
                nativeRemoveData(this.mJsNativeData, updateAction.mKey);
            } else {
                LLog.e(TAG, "undefined action type: " + updateAction.getType());
            }
        }
        return this.mJsNativeData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.lynx.tasm.TemplateData$4, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$lynx$tasm$TemplateData$ActionType;

        static {
            int[] iArr = new int[ActionType.values().length];
            $SwitchMap$com$lynx$tasm$TemplateData$ActionType = iArr;
            try {
                iArr[ActionType.STRING_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$lynx$tasm$TemplateData$ActionType[ActionType.NATIVE_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$lynx$tasm$TemplateData$ActionType[ActionType.BYTE_BUFFER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$lynx$tasm$TemplateData$ActionType[ActionType.REMOVE_DATA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    long getDataForJSThread() {
        return getDataForJSThreadInner();
    }

    TemplateData getTemplateDataForJSThread() {
        TemplateData empty = empty();
        empty.mEnableJSData = true;
        if (this.mJsNativeData != 0) {
            empty.mJsNativeData = nativeClone(this.mJsNativeData);
        }
        empty.addUpdateActions(getUpdateActionsWithJsNativeData());
        return empty;
    }

    long getNativeTemplateData() {
        return this.mNativeData;
    }

    private static Object decodeByteBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            return LepusBuffer.INSTANCE.decodeMessage(byteBuffer);
        }
        return null;
    }
}
