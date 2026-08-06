package com.bytedance.sysoptimizer.javahook;

import android.os.Process;
import android.util.Log;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.perflock.DoubleReflectUtils;
import java.lang.reflect.Field;
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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ProxyArrayListV2<E> extends ArrayList<E> {
    private static final int MAX_COUNT = 8;
    private static final String TAG = "ProxyArrayListV2";
    private static final ArrayDeque<RemoveInfo> infos = new ArrayDeque<>(8);
    private static final ConcurrentHashMap<Object, Thread> sObjTouchThreadMap = new ConcurrentHashMap<>();
    private static final AtomicBoolean needRegisterHook = new AtomicBoolean(true);

    public static void init() {
        System.out.println("");
    }

    private static String toString1(Object obj) {
        return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
    }

    public ProxyArrayListV2(int i) throws Throwable {
        super(i);
    }

    public void ProxyArrayListV2Constructor() throws Throwable {
        Class<?> cls = getClass();
        Field field = DoubleReflectUtils.getField(Class.class, "accessFlags");
        field.setAccessible(true);
        int intValue = ((Integer) field.get(cls)).intValue();
        AHook.nDumpClz(cls);
        if ((intValue & Integer.MIN_VALUE) != 0) {
            AHook.getCallback().mo207e(TAG, "isFinalizable Class 1 " + cls);
        }
        field.set(cls, Integer.valueOf(intValue | Integer.MIN_VALUE));
        int intValue2 = ((Integer) field.get(cls)).intValue();
        AHook.nDumpClz(cls);
        if ((intValue2 & Integer.MIN_VALUE) != 0) {
            AHook.getCallback().mo207e(TAG, "isFinalizable Class 2 " + cls);
        }
        Field field2 = DoubleReflectUtils.getField(Object.class, "shadow$_klass_");
        field2.setAccessible(true);
        field2.set(this, ProxyArrayListV2.class);
        AHook.callOrigin(OriginMethodKey.KEY_ARRAYLIST_INIT, this, new Object[0]);
        sObjTouchThreadMap.put(this, Thread.currentThread());
    }

    public ProxyArrayListV2(Collection<? extends E> collection) throws Throwable {
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        checkThread();
        return super.add(e);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        checkThread();
        super.add(i, e);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        checkThread();
        return super.addAll(collection);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        checkThread();
        return super.addAll(i, collection);
    }

    private void checkThread() {
        sObjTouchThreadMap.get(this);
        Thread.currentThread();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        checkThread();
        RemoveInfo removeInfo = new RemoveInfo();
        traceInfo(removeInfo);
        removeInfo.desc = toString1(this) + " remove : o = [" + obj + "]";
        return super.remove(obj);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public E remove(int i) {
        checkThread();
        return (E) super.remove(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    protected void removeRange(int i, int i2) {
        checkThread();
        super.removeRange(i, i2);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> collection) {
        checkThread();
        return super.removeAll(collection);
    }

    @Override // java.util.ArrayList, java.util.Collection
    public boolean removeIf(Predicate<? super E> predicate) {
        checkThread();
        return super.removeIf(predicate);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkThread();
        super.clear();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        checkThread();
        return new ProxyIterator(super.iterator());
    }

    @Override // java.util.ArrayList
    public void trimToSize() {
        checkThread();
        super.trimToSize();
    }

    @Override // java.util.ArrayList
    public void ensureCapacity(int i) {
        checkThread();
        super.ensureCapacity(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        checkThread();
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        checkThread();
        return super.isEmpty();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        checkThread();
        return super.contains(obj);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        checkThread();
        return super.indexOf(obj);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        checkThread();
        return super.lastIndexOf(obj);
    }

    @Override // java.util.ArrayList
    public Object clone() {
        checkThread();
        return super.clone();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        checkThread();
        return super.toArray();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        checkThread();
        return (T[]) super.toArray(tArr);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public E get(int i) {
        checkThread();
        return (E) super.get(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        checkThread();
        return (E) super.set(i, e);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> collection) {
        checkThread();
        return super.retainAll(collection);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i) {
        checkThread();
        return super.listIterator(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        checkThread();
        return super.listIterator();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public List<E> subList(int i, int i2) {
        checkThread();
        return super.subList(i, i2);
    }

    @Override // java.util.ArrayList, java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        checkThread();
        super.forEach(consumer);
    }

    @Override // java.util.ArrayList, java.util.Collection, java.lang.Iterable, java.util.List
    public Spliterator<E> spliterator() {
        checkThread();
        return super.spliterator();
    }

    @Override // java.util.ArrayList, java.util.List
    public void replaceAll(UnaryOperator<E> unaryOperator) {
        checkThread();
        super.replaceAll(unaryOperator);
    }

    @Override // java.util.ArrayList, java.util.List
    public void sort(Comparator<? super E> comparator) {
        checkThread();
        super.sort(comparator);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection<?> collection) {
        checkThread();
        return super.containsAll(collection);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        checkThread();
        return super.toString();
    }

    @Override // java.util.Collection
    public Stream<E> stream() {
        checkThread();
        return super.stream();
    }

    @Override // java.util.Collection
    public Stream<E> parallelStream() {
        checkThread();
        return super.parallelStream();
    }

    protected void finalize() throws Throwable {
        Log.d(TAG, "finalize() called " + this);
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
            Log.d(ProxyArrayListV2.TAG, "finalize() called " + this);
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
            ICrashCallback iCrashCallback = new ICrashCallback() { // from class: com.bytedance.sysoptimizer.javahook.ProxyArrayListV2$$ExternalSyntheticLambda1
                public final void onCrash(CrashType crashType, String str, Thread thread) {
                    ProxyArrayListV2.lambda$initHook$1(crashType, str, thread);
                }
            };
            Npth.registerCrashCallback(iCrashCallback, CrashType.JAVA);
            Npth.registerCrashCallback(iCrashCallback, CrashType.LAUNCH);
            HashMap hashMap = new HashMap();
            hashMap.put("ProxyArrayListV2Remove", "1");
            Npth.addTags(hashMap);
            AHook.getCallback().mo207e(TAG, "initHook");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$initHook$1(CrashType crashType, String str, Thread thread) {
        if (str != null && str.contains("java.util.ConcurrentModificationException") && str.contains("java.util.ArrayList$Itr.next")) {
            AttachUserData attachUserData = new AttachUserData() { // from class: com.bytedance.sysoptimizer.javahook.ProxyArrayListV2$$ExternalSyntheticLambda0
                public final Map getUserData(CrashType crashType2) {
                    return ProxyArrayListV2.lambda$null$0(crashType2);
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
        hashMap.put("ProxyArrayListV2Remove", info);
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
        public String desc;
        private final long time = System.currentTimeMillis();
        private final int tid = Process.myTid();
        private final String threadName = Thread.currentThread().getName();
        private final Throwable stack = new Throwable();

        RemoveInfo() {
        }

        public String toString() {
            return "time: " + format(this.time) + ", tid: " + this.tid + ", thread: " + this.threadName + "\ndesc: " + this.desc + "\nstack: " + Log.getStackTraceString(this.stack);
        }

        private static String format(long j) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Long.valueOf(j));
        }
    }
}
