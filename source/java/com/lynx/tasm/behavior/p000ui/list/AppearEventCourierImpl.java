package com.lynx.tasm.behavior.p000ui.list;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.p000ui.view.UIComponent;
import com.lynx.tasm.event.LynxListEvent;
import com.ss.android.common.applog.AppLog;
import com.ss.ttm.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AppearEventCourierImpl implements AppearEventCourierInterface {
    private Callback mCallback;
    private boolean mEnableDisappear = false;
    private final EventEmitter mEventEmitter;
    private LinkedList<AppearEvent> mFlushingQueue;
    private final Handler mHandler;
    private LinkedList<AppearEvent> mPendingQueue;

    @Override // com.lynx.tasm.behavior.p000ui.list.AppearEventCourierInterface
    public void onListLayout() {
    }

    public AppearEventCourierImpl(EventEmitter eventEmitter) {
        this.mEventEmitter = eventEmitter;
        Handler handler = new Handler(Looper.getMainLooper());
        this.mHandler = handler;
        this.mPendingQueue = new LinkedList<>();
        this.mFlushingQueue = new LinkedList<>();
        Callback callback = new Callback(this);
        this.mCallback = callback;
        handler.postDelayed(callback, MediaPlayer.MEDIA_PLAYER_OPTION_SET_MDL_PROTOCOL_HANDLE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDisappear(boolean z) {
        this.mEnableDisappear = z;
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AppearEventCourierInterface
    public void onListNodeAttached(ListViewHolder listViewHolder) {
        if (UIList.DEBUG) {
            LLog.i(UIList.TAG, "onNodeAppear " + listViewHolder.getLayoutPosition());
        }
        this.mPendingQueue.push(new AppearEvent(listViewHolder, LynxListEvent.EVENT_NODE_APPEAR));
        startTimerIfNeeded();
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AppearEventCourierInterface
    public void onListNodeDetached(ListViewHolder listViewHolder) {
        if (UIList.DEBUG) {
            LLog.i(UIList.TAG, "onNodeDisappear " + listViewHolder.getLayoutPosition());
        }
        this.mPendingQueue.push(new AppearEvent(listViewHolder, LynxListEvent.EVENT_NODE_DISAPPEAR));
        startTimerIfNeeded();
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AppearEventCourierInterface
    public void holderAttached(ListViewHolder listViewHolder) {
        Iterator<AppearEvent> it = this.mFlushingQueue.iterator();
        while (it.hasNext()) {
            AppearEvent next = it.next();
            if (next.holder == listViewHolder && listViewHolder.getUIComponent() != null) {
                next.key = listViewHolder.getUIComponent().getItemKey();
            }
        }
        Iterator<AppearEvent> it2 = this.mPendingQueue.iterator();
        while (it2.hasNext()) {
            AppearEvent next2 = it2.next();
            if (next2.holder == listViewHolder) {
                next2.key = listViewHolder.getUIComponent().getItemKey();
            }
        }
    }

    private boolean isDuplicatedEvent(AppearEvent appearEvent, AppearEvent appearEvent2) {
        if (this.mEnableDisappear && !TextUtils.isEmpty(appearEvent.type) && !appearEvent.type.equals(appearEvent2.type)) {
            return false;
        }
        if (appearEvent.key == null && appearEvent2.key == null) {
            return appearEvent.position == appearEvent2.position;
        }
        return TextUtils.equals(appearEvent.key, appearEvent2.key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flush() {
        boolean z;
        boolean z2;
        this.mCallback = null;
        if (UIList.DEBUG) {
            LLog.i(UIList.TAG, "Courier flush pending " + this.mPendingQueue.size() + " " + Arrays.toString(this.mPendingQueue.toArray()) + " flushing " + this.mFlushingQueue.size() + " " + Arrays.toString(this.mFlushingQueue.toArray()));
        }
        while (this.mFlushingQueue.size() > 0) {
            AppearEvent removeFirst = this.mFlushingQueue.removeFirst();
            if (valid(removeFirst)) {
                Iterator<AppearEvent> it = this.mFlushingQueue.iterator();
                while (true) {
                    z = true;
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    AppearEvent next = it.next();
                    if (isDuplicatedEvent(removeFirst, next)) {
                        this.mFlushingQueue.remove(next);
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    Iterator<AppearEvent> it2 = this.mPendingQueue.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = z2;
                            break;
                        }
                        AppearEvent next2 = it2.next();
                        if (isDuplicatedEvent(removeFirst, next2)) {
                            this.mPendingQueue.remove(next2);
                            break;
                        }
                    }
                    if (!z && shouldSend(removeFirst)) {
                        sendNodeEvent(removeFirst);
                    }
                }
            }
        }
        this.mFlushingQueue = this.mPendingQueue;
        this.mPendingQueue = new LinkedList<>();
        if (this.mFlushingQueue.size() > 0) {
            startTimerIfNeeded();
        }
    }

    private void startTimerIfNeeded() {
        if (this.mCallback != null) {
            return;
        }
        Callback callback = new Callback(this);
        this.mCallback = callback;
        this.mHandler.postDelayed(callback, 50);
    }

    protected void sendNodeEvent(AppearEvent appearEvent) {
        if (valid(appearEvent)) {
            if (UIList.DEBUG) {
                LLog.i(UIList.TAG, "sendNodeEvent " + appearEvent.type + "  " + appearEvent.position + " " + appearEvent.key);
            }
            LynxListEvent createListEvent = LynxListEvent.createListEvent(appearEvent.sign, appearEvent.type);
            createListEvent.addDetail(PropsConstants.POSITION, Integer.valueOf(appearEvent.position));
            createListEvent.addDetail(AppLog.KEY_ENCRYPT_RESP_KEY, appearEvent.key);
            this.mEventEmitter.sendCustomEvent(createListEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Callback implements Runnable {
        WeakReference<AppearEventCourierImpl> mCourier;

        public Callback(AppearEventCourierImpl appearEventCourierImpl) {
            this.mCourier = new WeakReference<>(appearEventCourierImpl);
        }

        @Override // java.lang.Runnable
        public void run() {
            AppearEventCourierImpl appearEventCourierImpl = this.mCourier.get();
            if (appearEventCourierImpl == null) {
                return;
            }
            appearEventCourierImpl.flush();
        }
    }

    boolean shouldSend(AppearEvent appearEvent) {
        if (!valid(appearEvent)) {
            return false;
        }
        UIComponent uIComponent = appearEvent.holder.getUIComponent();
        if (uIComponent == null || uIComponent.getEvents() == null) {
            if (this.mEnableDisappear) {
                return isDisAppearEvent(appearEvent);
            }
            return false;
        }
        return uIComponent.getEvents().containsKey(appearEvent.type);
    }

    boolean isAppearEvent(AppearEvent appearEvent) {
        return LynxListEvent.EVENT_NODE_APPEAR.equals(appearEvent.type);
    }

    boolean isDisAppearEvent(AppearEvent appearEvent) {
        return LynxListEvent.EVENT_NODE_DISAPPEAR.equals(appearEvent.type);
    }

    boolean valid(AppearEvent appearEvent) {
        if (appearEvent == null) {
            return false;
        }
        if (appearEvent.holder.getUIComponent() != null) {
            return appearEvent.type != null;
        }
        if (this.mEnableDisappear) {
            return isDisAppearEvent(appearEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class AppearEvent {
        ListViewHolder holder;
        public String key;
        public int position;
        public int sign;
        public String type;

        public AppearEvent(ListViewHolder listViewHolder, String str) {
            this.holder = listViewHolder;
            this.type = str;
            this.position = listViewHolder.getLayoutPosition();
            if (listViewHolder.getUIComponent() != null) {
                this.key = listViewHolder.getUIComponent().getItemKey();
                this.sign = listViewHolder.getUIComponent().getSign();
            }
        }

        public String toString() {
            return "{type='" + this.type + "', position=" + this.position + ", key='" + this.key + "'}";
        }
    }
}
