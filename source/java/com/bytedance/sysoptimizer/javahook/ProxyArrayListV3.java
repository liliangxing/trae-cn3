package com.bytedance.sysoptimizer.javahook;

import android.os.Process;
import android.util.Log;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.Npth;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ProxyArrayListV3<E> extends ArrayList<E> {
    private static final int MAX_COUNT = 8;
    private static final String TAG = "ProxyArrayListV3";
    private static final ArrayDeque<RemoveInfo> infos = new ArrayDeque<>(8);
    private static final ConcurrentHashMap<Integer, ThreadInfo> sObjTouchThreadMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Integer, Vector<RemoveInfo>> sObjTouchThreadMap2 = new ConcurrentHashMap<>();
    public static volatile Thread sLogThread = null;
    private static final AtomicBoolean needRegisterHook = new AtomicBoolean(true);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class ThreadInfo {
        private Thread readThread;
        private Throwable writeStack;
        private Thread writeThread;
        private long writeTime;

        private ThreadInfo() {
        }

        public synchronized Thread getWriteThread() {
            return this.writeThread;
        }

        public synchronized Thread getReadThread() {
            return this.readThread;
        }

        public synchronized void setReadThread(Thread thread) {
            this.readThread = thread;
        }

        public synchronized void setWriteThread(Thread thread) {
            this.writeThread = thread;
        }

        public synchronized void setWriteStack(Throwable th) {
            this.writeStack = th;
        }

        public synchronized Throwable getWriteStack() {
            return this.writeStack;
        }

        public synchronized void setWriteTime(long j) {
            this.writeTime = j;
        }

        public synchronized long getWriteTime() {
            return this.writeTime;
        }
    }

    private static String toString1(Object obj) {
        return obj.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(obj));
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        if (sLogThread != null && sLogThread == Thread.currentThread()) {
            AHook.getCallback().mo208e(TAG, key() + " add() called with: e = [" + e + "]", new Throwable());
        }
        checkThread(true);
        return super.add(e);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        checkThread(true);
        super.add(i, e);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        checkThread(true);
        return super.addAll(collection);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        checkThread(true);
        return super.addAll(i, collection);
    }

    private void checkThread(boolean z) {
        int key = key();
        ConcurrentHashMap<Integer, ThreadInfo> concurrentHashMap = sObjTouchThreadMap;
        ThreadInfo threadInfo = concurrentHashMap.get(Integer.valueOf(key));
        Thread currentThread = Thread.currentThread();
        if (threadInfo == null) {
            ThreadInfo threadInfo2 = new ThreadInfo();
            if (z) {
                threadInfo2.setWriteTime(System.currentTimeMillis());
                threadInfo2.setWriteThread(currentThread);
                threadInfo2.setWriteStack(new Throwable());
            } else {
                threadInfo2.setReadThread(currentThread);
            }
            concurrentHashMap.put(Integer.valueOf(key), threadInfo2);
        } else {
            Thread writeThread = threadInfo.getWriteThread();
            Thread readThread = threadInfo.getReadThread();
            if (z) {
                if (writeThread != null && currentThread != writeThread) {
                    AHook.getCallback().mo208e(TAG, "checkThread", new IllegalStateException(key + " expect " + RemoveInfo.format(threadInfo.getWriteTime()) + " writeThread " + writeThread + ",but actual currentThread " + currentThread, threadInfo.getWriteStack()));
                }
                if (readThread != null && currentThread != readThread) {
                    AHook.getCallback().mo208e(TAG, "checkThread", new IllegalStateException(key + " expect readThread " + readThread + ",but actual currentThread " + currentThread));
                }
                threadInfo.setWriteTime(System.currentTimeMillis());
                threadInfo.setWriteThread(currentThread);
                threadInfo.setWriteStack(new Throwable());
            } else {
                if (writeThread != null && currentThread != writeThread) {
                    AHook.getCallback().mo208e(TAG, "checkThread", new IllegalStateException(key + " expect " + RemoveInfo.format(threadInfo.getWriteTime()) + " writeThread " + writeThread + ",but actual currentThread " + currentThread, threadInfo.getWriteStack()));
                }
                threadInfo.setReadThread(currentThread);
            }
        }
        ConcurrentHashMap<Integer, Vector<RemoveInfo>> concurrentHashMap2 = sObjTouchThreadMap2;
        Vector<RemoveInfo> vector = concurrentHashMap2.get(Integer.valueOf(key));
        if (vector == null) {
            vector = new Vector<>();
            concurrentHashMap2.put(Integer.valueOf(key), vector);
        }
        RemoveInfo removeInfo = new RemoveInfo();
        vector.add(removeInfo);
        removeInfo.desc = z ? " write " : " read ";
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        checkThread(true);
        return super.remove(obj);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public E remove(int i) {
        checkThread(true);
        return (E) super.remove(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    protected void removeRange(int i, int i2) {
        checkThread(true);
        super.removeRange(i, i2);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> collection) {
        checkThread(true);
        return super.removeAll(collection);
    }

    @Override // java.util.ArrayList, java.util.Collection
    public boolean removeIf(Predicate<? super E> predicate) {
        checkThread(true);
        return super.removeIf(predicate);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkThread(true);
        super.clear();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        checkThread(false);
        return new ProxyIterator(super.iterator());
    }

    @Override // java.util.ArrayList
    public void trimToSize() {
        checkThread(true);
        super.trimToSize();
    }

    @Override // java.util.ArrayList
    public void ensureCapacity(int i) {
        checkThread(true);
        super.ensureCapacity(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        checkThread(false);
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        checkThread(false);
        return super.isEmpty();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        checkThread(false);
        return super.contains(obj);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        checkThread(false);
        return super.indexOf(obj);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        checkThread(false);
        return super.lastIndexOf(obj);
    }

    @Override // java.util.ArrayList
    public Object clone() {
        checkThread(false);
        return super.clone();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        checkThread(false);
        return super.toArray();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        checkThread(false);
        return (T[]) super.toArray(tArr);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public E get(int i) {
        checkThread(false);
        return (E) super.get(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        checkThread(true);
        return (E) super.set(i, e);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> collection) {
        checkThread(false);
        return super.retainAll(collection);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i) {
        checkThread(false);
        return super.listIterator(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        checkThread(false);
        return super.listIterator();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public List<E> subList(int i, int i2) {
        checkThread(false);
        return super.subList(i, i2);
    }

    @Override // java.util.ArrayList, java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        checkThread(false);
        super.forEach(consumer);
    }

    @Override // java.util.ArrayList, java.util.Collection, java.lang.Iterable, java.util.List
    public Spliterator<E> spliterator() {
        checkThread(false);
        return super.spliterator();
    }

    @Override // java.util.ArrayList, java.util.List
    public void replaceAll(UnaryOperator<E> unaryOperator) {
        checkThread(true);
        super.replaceAll(unaryOperator);
    }

    @Override // java.util.ArrayList, java.util.List
    public void sort(Comparator<? super E> comparator) {
        checkThread(true);
        super.sort(comparator);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection<?> collection) {
        checkThread(false);
        return super.containsAll(collection);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        checkThread(false);
        return super.toString();
    }

    @Override // java.util.Collection
    public Stream<E> stream() {
        checkThread(false);
        return super.stream();
    }

    @Override // java.util.Collection
    public Stream<E> parallelStream() {
        checkThread(false);
        return super.parallelStream();
    }

    private int key() {
        return System.identityHashCode(this);
    }

    protected void finalize() throws Throwable {
        int key = key();
        sObjTouchThreadMap.remove(Integer.valueOf(key));
        Vector<RemoveInfo> remove = sObjTouchThreadMap2.remove(Integer.valueOf(key));
        if (remove != null) {
            Iterator<RemoveInfo> it = remove.iterator();
            int i = 0;
            while (it.hasNext()) {
                AHook.getCallback().mo206d(TAG, "object " + key + " finalize() index " + i + ", " + it.next().toString());
                i++;
            }
        }
        super.finalize();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private class ProxyIterator implements Iterator<E> {
        private final Iterator<E> origin;

        public ProxyIterator(Iterator<E> it) {
            this.origin = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.origin.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            return this.origin.next();
        }

        protected void finalize() throws Throwable {
            Log.d(ProxyArrayListV3.TAG, "finalize() called " + this);
            super.finalize();
        }
    }

    private static void traceInfo(RemoveInfo removeInfo) {
        ArrayDeque<RemoveInfo> arrayDeque = infos;
        synchronized (arrayDeque) {
            if (arrayDeque.size() >= 8) {
                arrayDeque.pollFirst();
            }
            arrayDeque.addLast(removeInfo);
        }
        initHook();
    }

    private static void initHook() {
        if (needRegisterHook.getAndSet(false)) {
            ICrashCallback iCrashCallback = new ICrashCallback() { // from class: com.bytedance.sysoptimizer.javahook.ProxyArrayListV3$$ExternalSyntheticLambda0
                public final void onCrash(CrashType crashType, String str, Thread thread) {
                    ProxyArrayListV3.lambda$initHook$1(crashType, str, thread);
                }
            };
            Npth.registerCrashCallback(iCrashCallback, CrashType.JAVA);
            Npth.registerCrashCallback(iCrashCallback, CrashType.LAUNCH);
            HashMap hashMap = new HashMap();
            hashMap.put("ProxyArrayListV3Remove", "1");
            Npth.addTags(hashMap);
            AHook.getCallback().mo207e(TAG, "initHook");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$initHook$1(CrashType crashType, String str, Thread thread) {
        if (str != null && str.contains("java.util.ConcurrentModificationException") && str.contains("java.util.ArrayList$Itr.next")) {
            AttachUserData attachUserData = new AttachUserData() { // from class: com.bytedance.sysoptimizer.javahook.ProxyArrayListV3$$ExternalSyntheticLambda1
                public final Map getUserData(CrashType crashType2) {
                    return ProxyArrayListV3.lambda$null$0(crashType2);
                }
            };
            Npth.addAttachLongUserData(attachUserData, CrashType.JAVA);
            Npth.addAttachLongUserData(attachUserData, CrashType.LAUNCH);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$null$0(CrashType crashType) {
        HashMap hashMap = new HashMap();
        String info = getInfo();
        AHook.getCallback().mo207e(TAG, info);
        hashMap.put("ProxyArrayListV3Remove", info);
        return hashMap;
    }

    public static String getInfo() {
        StringBuilder sb = new StringBuilder();
        synchronized (infos) {
            int i = 0;
            while (true) {
                RemoveInfo pollLast = infos.pollLast();
                if (pollLast != null) {
                    sb.append("#").append(i).append(":").append(pollLast).append("\n\n");
                    i++;
                }
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class RemoveInfo {
        private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        public String desc;
        private final long time = System.currentTimeMillis();
        private final int tid = Process.myTid();
        private final String threadName = Thread.currentThread().getName();
        private final Throwable stack = new Throwable();

        RemoveInfo() {
        }

        public String toString() {
            return "time: " + format(this.time) + ", tid: " + this.tid + ", thread: " + this.threadName + " desc: " + this.desc + " stack: " + Log.getStackTraceString(this.stack);
        }

        public static String format(long j) {
            return dateFormat.format(Long.valueOf(j));
        }
    }
}
