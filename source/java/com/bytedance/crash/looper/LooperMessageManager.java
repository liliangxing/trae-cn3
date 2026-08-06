package com.bytedance.crash.looper;

import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.GlobalSwitch;
import com.bytedance.crash.dumper.JavaStack;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LooperMessageManager {
    private static final int BLOCK_INTERNAL_MS = 3000;
    private static final int GROUP_POOL_SIZE = 30;
    private static final int HISTORY_RING_SIZE = 50;
    private static final long LONG_MESSAGE_THRESHOLD = 200;
    private static final String MESSAGE_IS_RUNNING = "message is running";
    private static final String NO_MESSAGE_RUNNING = "no message running";
    private static final int PENDING_MESSAGE_MAX_COUNT = 200;
    private final Runnable mBlockRunnable = new Runnable() { // from class: com.bytedance.crash.looper.LooperMessageManager.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            String stackTrace = NativeBridge.getStackTrace(true);
            String javaStack = LooperMessageManager.this.getJavaStack(stackTrace);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(OaidModel.KEY_TIME, currentTimeMillis);
                jSONObject.put(TraceStatsConsts.STATS_KEY_TRACE, javaStack);
                jSONObject.put("native_trace", stackTrace);
                LooperMessageManager.this.mStackArray.put(jSONObject);
                if (LooperMessageManager.this.mStackArray.length() >= 5) {
                    LooperMessageManager.this.mStackArray.remove(0);
                }
            } catch (Throwable unused) {
            }
        }
    };
    private volatile CollectionState mCollectionState;
    private volatile CollectionStateHistory mCollectionStateHistory;
    private boolean mIsJavaMessage;
    private long mLastCpuTime;
    private long mLastUpTime;
    private long mLastWallTime;
    private JSONArray mStackArray;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private interface CollectionState {
        CollectionState onMessage(Message message, long j, long j2, long j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getJavaStack(String str) {
        if (str != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
                StringBuilder sb = new StringBuilder();
                boolean z = false;
                int i = 0;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (readLine.startsWith("  at ")) {
                        i++;
                        sb.append(readLine).append('\n');
                    } else if (readLine.contains("__libc_init") || readLine.contains("__start_thread")) {
                        z = true;
                    }
                }
                if (z || i >= 5) {
                    return sb.toString();
                }
            } catch (Exception unused) {
            }
        }
        return JavaStack.getMainStack();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void start() {
        CollectionStateHistory collectionStateHistory = new CollectionStateHistory();
        this.mCollectionStateHistory = collectionStateHistory;
        this.mCollectionState = collectionStateHistory;
        this.mStackArray = new JSONArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stop() {
        this.mCollectionState = null;
    }

    public synchronized void onMessage(Message message) {
        if (this.mCollectionState == null) {
            return;
        }
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        long currentTimeMillis = System.currentTimeMillis();
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = this.mLastWallTime;
        if (j != 0) {
            CollectionState onMessage = this.mCollectionState.onMessage(message, currentTimeMillis - j, currentThreadTimeMillis - this.mLastCpuTime, this.mLastUpTime);
            if (GlobalSwitch.isAllowBlockStack()) {
                if (message == null) {
                    DefaultWorkThread.postDelayed(this.mBlockRunnable, WsConstants.EXIT_DELAY_TIME);
                } else {
                    DefaultWorkThread.removeCallbacks(this.mBlockRunnable);
                }
            }
            if (onMessage == null) {
                onMessage = this.mCollectionStateHistory;
            }
            this.mCollectionState = onMessage;
        }
        this.mIsJavaMessage = message != null;
        this.mLastWallTime = currentTimeMillis;
        this.mLastCpuTime = currentThreadTimeMillis;
        this.mLastUpTime = uptimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dumpMessages(File file) {
        boolean z;
        long j;
        long j2;
        CollectionStateHistory collectionStateHistory;
        CollectionStateCurrent collectionStateCurrent;
        long currentTimeMillis = System.currentTimeMillis();
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            if (this.mCollectionState != null) {
                if (this.mLastWallTime != 0 && (this.mCollectionState instanceof CollectionStateHistory)) {
                    collectionStateHistory = (CollectionStateHistory) this.mCollectionState;
                    CollectionStateCurrent collectionStateCurrent2 = new CollectionStateCurrent();
                    long j3 = this.mLastWallTime;
                    long j4 = this.mLastCpuTime;
                    z = this.mIsJavaMessage;
                    this.mCollectionState = collectionStateCurrent2;
                    collectionStateCurrent = collectionStateCurrent2;
                    j2 = j4;
                    j = j3;
                }
                return;
            }
            z = false;
            j = 0;
            j2 = 0;
            collectionStateHistory = null;
            collectionStateCurrent = null;
            if (collectionStateCurrent != null) {
                collectionStateCurrent.dumpBlockedMessage(file, currentTimeMillis - j, z);
            }
            if (collectionStateHistory != null) {
                collectionStateHistory.dumpAllMessage(file, currentTimeMillis, uptimeMillis, j, j2);
            }
            dumpBlockStack(file);
            CollectionStatePending collectionStatePending = new CollectionStatePending();
            collectionStatePending.collectPendingMessage(uptimeMillis);
            synchronized (this) {
                if (!(this.mCollectionState instanceof CollectionStatePending)) {
                    if ((this.mCollectionState instanceof CollectionStateCurrent) && collectionStateCurrent != null) {
                        collectionStateCurrent.updateState();
                    }
                } else {
                    collectionStatePending.setHistoryQueue((CollectionStatePending) this.mCollectionState);
                    this.mCollectionState = this.mCollectionStateHistory;
                }
            }
            collectionStatePending.dumpAllMessages(file);
        }
    }

    private void dumpBlockStack(File file) {
        if (this.mStackArray.length() != 0) {
            JSONObject jSONObject = new JSONObject();
            JSONUtils.put(jSONObject, "block_stack", this.mStackArray);
            FileUtils.writeFile(LooperMessageConfig.getBlockStackJsonFile(file), jSONObject, false);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class CollectionStatePending implements CollectionState {
        private LinkedList<HistoryMessage> mHistoryQueue;
        private final LinkedList<ShadowMessage> mPendingQueue;

        private CollectionStatePending() {
            this.mPendingQueue = new LinkedList<>();
            this.mHistoryQueue = new LinkedList<>();
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.CollectionState
        public CollectionState onMessage(Message message, long j, long j2, long j3) {
            if (message != null) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.copyFrom(message, j3);
                historyMessage.setDuration(j, j2);
                this.mHistoryQueue.add(historyMessage);
            }
            return this;
        }

        private static MessageQueue getMainMessageQueue() {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == Looper.myLooper()) {
                return Looper.myQueue();
            }
            return mainLooper.getQueue();
        }

        private static Field getField(String str, String str2) {
            try {
                Field declaredField = Class.forName(str).getDeclaredField(str2);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Exception unused) {
                return null;
            }
        }

        private static Object getMember(Field field, Object obj) {
            try {
                return field.get(obj);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void collectPendingMessage(long j) {
            MessageQueue mainMessageQueue = getMainMessageQueue();
            Field field = getField("android.os.MessageQueue", "mMessages");
            Field field2 = getField("android.os.Message", "next");
            if (mainMessageQueue == null || field == null || field2 == null) {
                return;
            }
            try {
                synchronized (mainMessageQueue) {
                    Message message = (Message) getMember(field, mainMessageQueue);
                    int i = 0;
                    while (message != null) {
                        int i2 = i + 1;
                        if (i >= 200) {
                            break;
                        }
                        ShadowMessage shadowMessage = new ShadowMessage();
                        shadowMessage.copyFrom(message, j);
                        this.mPendingQueue.add(shadowMessage);
                        message = (Message) getMember(field2, message);
                        i = i2;
                    }
                }
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHistoryQueue(CollectionStatePending collectionStatePending) {
            this.mHistoryQueue = collectionStatePending.mHistoryQueue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dumpAllMessages(File file) {
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i < 200) {
                if (i2 < this.mHistoryQueue.size()) {
                    int i4 = i2 + 1;
                    HistoryMessage historyMessage = this.mHistoryQueue.get(i2);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        historyMessage.toJson(jSONObject);
                        int i5 = i + 1;
                        try {
                            jSONObject.put("id", i);
                            jSONArray.put(jSONObject);
                        } catch (JSONException unused) {
                        }
                        i = i5;
                    } catch (JSONException unused2) {
                    }
                    if (i3 < this.mPendingQueue.size() && historyMessage.equals(this.mPendingQueue.get(i3))) {
                        i3++;
                    }
                    i2 = i4;
                } else {
                    if (i3 >= this.mPendingQueue.size()) {
                        break;
                    }
                    int i6 = i3 + 1;
                    ShadowMessage shadowMessage = this.mPendingQueue.get(i3);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        shadowMessage.toJson(jSONObject2);
                        int i7 = i + 1;
                        try {
                            jSONObject2.put("id", i);
                            jSONArray.put(jSONObject2);
                        } catch (JSONException unused3) {
                        }
                        i = i7;
                    } catch (JSONException unused4) {
                    }
                    i3 = i6;
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("pending_messages", jSONArray);
            } catch (JSONException unused5) {
            }
            FileUtils.writeFile(LooperMessageConfig.getPendingJsonFile(file), jSONObject3, false);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class CollectionStateCurrent implements CollectionState {
        private boolean mCollectedPendingMessage;
        private File mDirectory;
        private final JSONObject mJsonObject;
        private HistoryMessage mMessage;

        private CollectionStateCurrent() {
            this.mJsonObject = new JSONObject();
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.CollectionState
        public CollectionState onMessage(Message message, long j, long j2, long j3) {
            HistoryMessage historyMessage = new HistoryMessage();
            this.mMessage = historyMessage;
            historyMessage.setDuration(j, j2);
            this.mMessage.copyFrom(message, j3);
            updateBlockedMessage();
            if (this.mCollectedPendingMessage) {
                return null;
            }
            return new CollectionStatePending();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dumpBlockedMessage(File file, long j, boolean z) {
            synchronized (this.mJsonObject) {
                try {
                    JSONObject optJSONObject = this.mJsonObject.optJSONObject("current_message");
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                        this.mJsonObject.put("current_message", optJSONObject);
                        optJSONObject.put("message", z ? LooperMessageManager.MESSAGE_IS_RUNNING : LooperMessageManager.NO_MESSAGE_RUNNING);
                    }
                    optJSONObject.put("currentMessageCost", j);
                    optJSONObject.put("currentMessageCpu", -1);
                    this.mDirectory = file;
                    writeToFile();
                } catch (JSONException unused) {
                }
            }
        }

        private void updateBlockedMessage() {
            synchronized (this.mJsonObject) {
                try {
                    JSONObject jSONObject = (JSONObject) this.mJsonObject.opt("current_message");
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                        this.mJsonObject.put("current_message", jSONObject);
                    }
                    jSONObject.put("message", this.mMessage.getTag());
                    jSONObject.put("currentMessageLastCost", this.mMessage.mWallDuration);
                    jSONObject.put("currentMessageLastCpu", this.mMessage.mCpuDuration);
                    writeToFile();
                } catch (JSONException unused) {
                }
            }
        }

        private void writeToFile() {
            File file = this.mDirectory;
            if (file != null) {
                FileUtils.writeFile(LooperMessageConfig.getCurrentJsonFile(file), this.mJsonObject, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateState() {
            this.mCollectedPendingMessage = true;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class CollectionStateHistory implements CollectionState {
        private final PackedMessagesChunk mPackedMessagesChunk;
        private final PackingMessages mPackingMessages;

        private CollectionStateHistory() {
            PackedMessagesChunk packedMessagesChunk = new PackedMessagesChunk(50);
            this.mPackedMessagesChunk = packedMessagesChunk;
            this.mPackingMessages = new PackingMessages(packedMessagesChunk, 30);
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.CollectionState
        public CollectionState onMessage(Message message, long j, long j2, long j3) {
            if (message == null) {
                this.mPackingMessages.mergeIdle(j, j2);
            } else {
                this.mPackingMessages.mergeMessage(message, j, j2, j3);
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dumpAllMessage(File file, long j, long j2, long j3, long j4) {
            this.mPackingMessages.pushToChunk(true);
            JSONArray jSONArray = new JSONArray();
            PackedMessages firstRead = this.mPackedMessagesChunk.getFirstRead();
            while (firstRead != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    firstRead.toJson(jSONObject);
                    jSONArray.put(jSONObject);
                } catch (JSONException unused) {
                }
                firstRead = this.mPackedMessagesChunk.getNextRead();
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("history_message", jSONArray);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("dump_wall_time", j);
                jSONObject3.put("dump_up_time", j2);
                jSONObject3.put("last_wall_time", j3);
                jSONObject3.put("last_cpu_time", j4);
                jSONObject2.put("history_details", jSONObject3);
            } catch (JSONException unused2) {
            }
            FileUtils.writeFile(LooperMessageConfig.getHistoryJsonFile(file), jSONObject2, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static class PackedMessagesChunk {
            private final PackedMessages[] mBuffer;
            private int mReadPosition;
            private final int mSize;
            private int mWritePosition;

            PackedMessagesChunk(int i) {
                this.mBuffer = new PackedMessages[i];
                for (int i2 = 0; i2 < i; i2++) {
                    this.mBuffer[i2] = new PackedMessages();
                }
                this.mSize = i;
                this.mWritePosition = -1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public PackedMessages getNextMessage() {
                int i = this.mWritePosition + 1;
                this.mWritePosition = i;
                if (i == this.mSize) {
                    this.mWritePosition = 0;
                }
                return this.mBuffer[this.mWritePosition];
            }

            /* JADX INFO: Access modifiers changed from: private */
            public PackedMessages getFirstRead() {
                int i = this.mWritePosition;
                if (i == -1) {
                    return null;
                }
                int i2 = i + 1;
                this.mReadPosition = i2;
                if (i2 == this.mSize || this.mBuffer[i2].mWallDuration == 0) {
                    this.mReadPosition = 0;
                }
                return this.mBuffer[this.mReadPosition];
            }

            /* JADX INFO: Access modifiers changed from: private */
            public PackedMessages getNextRead() {
                int i = this.mReadPosition + 1;
                this.mReadPosition = i;
                if (i == this.mWritePosition + 1) {
                    return null;
                }
                if (i == this.mSize) {
                    this.mReadPosition = 0;
                }
                return this.mBuffer[this.mReadPosition];
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static class PackingMessages extends TimePeriodHistoryMessages {
            private final HashMap<String, LinkableHistoryMessageGroup> mHashMap;
            private HistoryMessageGroup mLongestGroup;
            private final LinkableMessagePool mMessagePool;
            private final PackedMessagesChunk mPackedChunk;

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            PackingMessages(PackedMessagesChunk packedMessagesChunk, int i) {
                super();
                this.mHashMap = new HashMap<>(i);
                this.mMessagePool = new LinkableMessagePool(i);
                this.mPackedChunk = packedMessagesChunk;
            }

            @Override // com.bytedance.crash.looper.LooperMessageManager.TimePeriodHistoryMessages, com.bytedance.crash.looper.LooperMessageManager.HistoryMessageGroup, com.bytedance.crash.looper.LooperMessageManager.HistoryMessage, com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
            protected void reset() {
                super.reset();
                this.mLongestGroup = null;
                for (LinkableHistoryMessageGroup linkableHistoryMessageGroup : this.mHashMap.values()) {
                    if (linkableHistoryMessageGroup != null) {
                        this.mMessagePool.recycle(linkableHistoryMessageGroup);
                    }
                }
                this.mHashMap.clear();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void pushToChunk(boolean z) {
                if (this.mWallDuration == 0 && this.mCount == 0) {
                    return;
                }
                if (z || this.mWallDuration > LooperMessageManager.LONG_MESSAGE_THRESHOLD) {
                    PackedMessages nextMessage = this.mPackedChunk.getNextMessage();
                    nextMessage.reset();
                    nextMessage.mCount = this.mCount;
                    nextMessage.mWallDuration = this.mWallDuration;
                    nextMessage.mCpuDuration = this.mCpuDuration;
                    nextMessage.mDelay = this.mDelay;
                    nextMessage.copyIdleFrom(this);
                    nextMessage.copyLongestFrom(this.mLongestGroup);
                    nextMessage.copyShadowFrom(this.mLongestGroup);
                    reset();
                }
            }

            @Override // com.bytedance.crash.looper.LooperMessageManager.TimePeriodHistoryMessages
            protected void mergeIdle(long j, long j2) {
                if (j > LooperMessageManager.LONG_MESSAGE_THRESHOLD) {
                    pushToChunk(true);
                }
                super.mergeIdle(j, j2);
                this.mWallDuration += j;
                this.mCpuDuration += j2;
                pushToChunk(false);
            }

            private void addOneMsg(Message message, long j, long j2, long j3) {
                this.mCount++;
                if (this.mDelay == Long.MAX_VALUE) {
                    long delay = getDelay(message, j3);
                    if (delay <= 0) {
                        if (this.mWallDuration + delay > 0) {
                            this.mDelay = 0L;
                        } else {
                            this.mDelay = delay + this.mWallDuration;
                        }
                    }
                }
                this.mWallDuration += j;
                this.mCpuDuration += j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeMessage(Message message, long j, long j2, long j3) {
                if (j > LooperMessageManager.LONG_MESSAGE_THRESHOLD) {
                    pushToChunk(true);
                }
                String hashKey = getHashKey(message);
                LinkableHistoryMessageGroup linkableHistoryMessageGroup = this.mHashMap.get(hashKey);
                if (linkableHistoryMessageGroup == null) {
                    linkableHistoryMessageGroup = this.mMessagePool.obtain();
                    if (linkableHistoryMessageGroup == null) {
                        pushToChunk(true);
                        LinkableHistoryMessageGroup obtain = this.mMessagePool.obtain();
                        if (obtain == null) {
                            return;
                        } else {
                            linkableHistoryMessageGroup = obtain;
                        }
                    }
                    this.mHashMap.put(hashKey, linkableHistoryMessageGroup);
                    linkableHistoryMessageGroup.copyFrom(message, j3);
                }
                LinkableHistoryMessageGroup linkableHistoryMessageGroup2 = linkableHistoryMessageGroup;
                linkableHistoryMessageGroup2.addOneMsg(message, j, j2, j3);
                addOneMsg(message, j, j2, j3);
                if (this.mLongestGroup == null || linkableHistoryMessageGroup2.mWallDuration > this.mLongestGroup.mWallDuration) {
                    this.mLongestGroup = linkableHistoryMessageGroup2;
                }
                pushToChunk(false);
            }

            private String getHashKey(Message message) {
                if (message.getCallback() != null) {
                    return message.getCallback().getClass().getName();
                }
                return message.getTarget() != null ? message.getTarget().getClass().getName() : "unknown";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class LinkableMessagePool {
        private LinkableHistoryMessageGroup mHead;

        private LinkableMessagePool(int i) {
            while (i > 0) {
                recycle(new LinkableHistoryMessageGroup());
                i--;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void recycle(LinkableHistoryMessageGroup linkableHistoryMessageGroup) {
            linkableHistoryMessageGroup.mNext = this.mHead;
            this.mHead = linkableHistoryMessageGroup;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public LinkableHistoryMessageGroup obtain() {
            LinkableHistoryMessageGroup linkableHistoryMessageGroup = this.mHead;
            if (linkableHistoryMessageGroup == null) {
                return null;
            }
            this.mHead = linkableHistoryMessageGroup.mNext;
            linkableHistoryMessageGroup.mNext = null;
            linkableHistoryMessageGroup.reset();
            return linkableHistoryMessageGroup;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class LinkableHistoryMessageGroup extends HistoryMessageGroup {
        private LinkableHistoryMessageGroup mNext;

        private LinkableHistoryMessageGroup() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addOneMsg(Message message, long j, long j2, long j3) {
            this.mWallDuration += j;
            this.mCpuDuration += j2;
            this.mCount++;
            long delay = getDelay(message, j3);
            if (this.mDelay > delay) {
                this.mDelay = delay;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class PackedMessages extends TimePeriodHistoryMessages {
        private long mLongestGroupCpuDuration;
        private long mLongestGroupDelay;
        private int mLongestGroupMessageCount;
        private long mLongestGroupWallDuration;

        private PackedMessages() {
            super();
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.TimePeriodHistoryMessages, com.bytedance.crash.looper.LooperMessageManager.HistoryMessageGroup, com.bytedance.crash.looper.LooperMessageManager.HistoryMessage, com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
        protected void reset() {
            super.reset();
            this.mLongestGroupMessageCount = 0;
            this.mLongestGroupWallDuration = 0L;
            this.mLongestGroupCpuDuration = 0L;
        }

        protected void copyLongestFrom(HistoryMessageGroup historyMessageGroup) {
            if (historyMessageGroup == null) {
                return;
            }
            this.mLongestGroupMessageCount = historyMessageGroup.mCount;
            this.mLongestGroupWallDuration = historyMessageGroup.mWallDuration;
            this.mLongestGroupCpuDuration = historyMessageGroup.mCpuDuration;
            this.mLongestGroupDelay = historyMessageGroup.mDelay;
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.TimePeriodHistoryMessages, com.bytedance.crash.looper.LooperMessageManager.HistoryMessage, com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
        protected void toJson(JSONObject jSONObject) throws JSONException {
            super.toJson(jSONObject);
            int type = getType();
            if (type == 9) {
                jSONObject.put("LongestGroupMessageCount", this.mLongestGroupMessageCount);
                jSONObject.put("LongestGroupDuration", this.mLongestGroupWallDuration);
                jSONObject.put("LongestGroupCpuDuration", this.mLongestGroupCpuDuration);
                jSONObject.put("LongestGroupDelay", this.mLongestGroupDelay);
                jSONObject.put("messageCount", this.mCount);
            }
            jSONObject.put("msg", getTag());
            jSONObject.put("type", type);
        }

        private int getType() {
            if (this.mCount == 0) {
                return 1;
            }
            return isLongMessage() ? 8 : 9;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class TimePeriodHistoryMessages extends HistoryMessageGroup {
        private static final int DILE_TIME_THRESHOLD = 1;
        private int mIdleCount;
        private long mIdleCpuDuration;
        private long mIdleWallDuration;

        private TimePeriodHistoryMessages() {
            super();
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.HistoryMessageGroup, com.bytedance.crash.looper.LooperMessageManager.HistoryMessage, com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
        protected void reset() {
            super.reset();
            this.mIdleWallDuration = 0L;
            this.mIdleCpuDuration = 0L;
            this.mIdleCount = 0;
        }

        protected boolean isLongMessage() {
            return this.mCount == 1 && this.mWallDuration - this.mIdleWallDuration > LooperMessageManager.LONG_MESSAGE_THRESHOLD;
        }

        protected void mergeIdle(long j, long j2) {
            this.mIdleWallDuration += j;
            this.mIdleCpuDuration += j2;
            if (j > 1) {
                this.mIdleCount++;
            }
        }

        protected void copyIdleFrom(TimePeriodHistoryMessages timePeriodHistoryMessages) {
            this.mIdleCount = timePeriodHistoryMessages.mIdleCount;
            this.mIdleWallDuration = timePeriodHistoryMessages.mIdleWallDuration;
            this.mIdleCpuDuration = timePeriodHistoryMessages.mIdleCpuDuration;
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.HistoryMessage, com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
        protected void toJson(JSONObject jSONObject) throws JSONException {
            super.toJson(jSONObject);
            if (this.mIdleCount != 0) {
                jSONObject.put("idleDuration", this.mIdleWallDuration);
                jSONObject.put("idleCpuDuration", this.mIdleCpuDuration);
                jSONObject.put("idleCount", this.mIdleCount);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class HistoryMessageGroup extends HistoryMessage {
        protected int mCount;

        private HistoryMessageGroup() {
            super();
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.HistoryMessage, com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
        protected void reset() {
            super.reset();
            this.mCount = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class HistoryMessage extends ShadowMessage {
        protected long mCpuDuration;
        protected long mWallDuration;

        private HistoryMessage() {
            super();
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
        protected void reset() {
            super.reset();
            setDuration(0L, 0L);
        }

        protected void setDuration(long j, long j2) {
            this.mWallDuration = j;
            this.mCpuDuration = j2;
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
        protected void toJson(JSONObject jSONObject) throws JSONException {
            super.toJson(jSONObject);
            jSONObject.put("duration", this.mWallDuration);
            jSONObject.put("cpuDuration", this.mCpuDuration);
        }

        protected String getTag() {
            if (this.mCallback != null) {
                return this.mCallback;
            }
            return this.mTarget != null ? this.mTarget : LooperMessageManager.NO_MESSAGE_RUNNING;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class ShadowMessage {
        private static final int MINIMUM_WHEN = 100;
        protected String mCallback;
        protected long mDelay;
        protected String mTarget;
        protected int mWhat;

        private ShadowMessage() {
            this.mDelay = Long.MAX_VALUE;
        }

        protected static long getDelay(Message message, long j) {
            if (isInstant(message)) {
                return message.getWhen() - j;
            }
            return Long.MAX_VALUE;
        }

        protected static boolean isInstant(Message message) {
            return message.getWhen() > 100;
        }

        protected void copyFrom(Message message, long j) {
            if (message == null) {
                return;
            }
            if (message.getTarget() != null) {
                this.mTarget = message.getTarget().getClass().getName();
            }
            if (message.getCallback() != null) {
                String name = message.getCallback().getClass().getName();
                this.mCallback = name;
                if (name.startsWith("Y.ARunnable")) {
                    String obj = message.getCallback().toString();
                    if (obj.charAt(0) >= '0' && obj.charAt(0) <= '9') {
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.mCallback);
                        sb.append(".run$");
                        for (int i = 0; i < obj.length() && obj.charAt(i) != '_'; i++) {
                            sb.append(obj.charAt(i));
                        }
                        this.mCallback = sb.toString();
                    }
                }
            }
            this.mDelay = getDelay(message, j);
            this.mWhat = message.what;
        }

        protected void copyShadowFrom(ShadowMessage shadowMessage) {
            if (shadowMessage == null) {
                return;
            }
            this.mTarget = shadowMessage.mTarget;
            this.mCallback = shadowMessage.mCallback;
            this.mWhat = shadowMessage.mWhat;
        }

        protected void reset() {
            this.mTarget = null;
            this.mCallback = null;
            this.mDelay = Long.MAX_VALUE;
            this.mWhat = -1;
        }

        protected void toJson(JSONObject jSONObject) throws JSONException {
            String str = this.mCallback;
            if (str != null) {
                jSONObject.put(JsCallParser.VALUE_CALLBACK, str);
            }
            String str2 = this.mTarget;
            if (str2 != null) {
                jSONObject.put("target", str2);
            }
            int i = this.mWhat;
            if (i != -1) {
                jSONObject.put("what", i);
            }
            long j = this.mDelay;
            if (j != Long.MAX_VALUE) {
                jSONObject.put("when", j);
            }
        }

        protected boolean equals(ShadowMessage shadowMessage) {
            return this.mDelay == shadowMessage.mDelay && this.mWhat == shadowMessage.mWhat && this.mTarget == shadowMessage.mTarget && this.mCallback == shadowMessage.mCallback;
        }
    }
}
