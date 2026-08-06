package com.bytedance.platform.godzilla.anr.monitor.idletask;

import android.os.MessageQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/* loaded from: classes4.dex */
public class ArrayListWrapper extends ArrayList<MessageQueue.IdleHandler> {
    private ArrayList<MessageQueue.IdleHandler> mOriginalArrayList;

    public ArrayListWrapper(ArrayList<MessageQueue.IdleHandler> arrayList) {
        this.mOriginalArrayList = arrayList;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(MessageQueue.IdleHandler idleHandler) {
        if (idleHandler != null && !(idleHandler instanceof IdleHandlerWrapper)) {
            return this.mOriginalArrayList.add(new IdleHandlerWrapper(idleHandler));
        }
        return this.mOriginalArrayList.add(idleHandler);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public MessageQueue.IdleHandler remove(int i) {
        return this.mOriginalArrayList.remove(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        IdleHandlerWrapper idleHandlerWrapper;
        if (this.mOriginalArrayList.remove(obj)) {
            return true;
        }
        Iterator<MessageQueue.IdleHandler> it = this.mOriginalArrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                idleHandlerWrapper = null;
                break;
            }
            MessageQueue.IdleHandler next = it.next();
            if (next instanceof IdleHandlerWrapper) {
                idleHandlerWrapper = (IdleHandlerWrapper) next;
                if (idleHandlerWrapper.getOriginalIdleHandler() == obj) {
                    break;
                }
            }
        }
        if (idleHandlerWrapper != null) {
            return this.mOriginalArrayList.remove(idleHandlerWrapper);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.mOriginalArrayList.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.mOriginalArrayList.toArray(tArr);
    }

    @Override // java.util.ArrayList
    public void trimToSize() {
        throw new RuntimeException("Reach method trimToSize");
    }

    @Override // java.util.ArrayList
    public void ensureCapacity(int i) {
        throw new RuntimeException("Reach method ensureCapacity");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        throw new RuntimeException("Reach method isEmpty");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        throw new RuntimeException("Reach method contains");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        throw new RuntimeException("Reach method indexOf");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        throw new RuntimeException("Reach method lastIndexOf");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        throw new RuntimeException("Reach method toArray");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public MessageQueue.IdleHandler get(int i) {
        throw new RuntimeException("Reach method get");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public MessageQueue.IdleHandler set(int i, MessageQueue.IdleHandler idleHandler) {
        throw new RuntimeException("Reach method set");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int i, MessageQueue.IdleHandler idleHandler) {
        throw new RuntimeException("Reach method add");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        throw new RuntimeException("Reach method clear");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends MessageQueue.IdleHandler> collection) {
        throw new RuntimeException("Reach method addAll");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends MessageQueue.IdleHandler> collection) {
        throw new RuntimeException("Reach method addAll");
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    protected void removeRange(int i, int i2) {
        throw new RuntimeException("Reach method removeRange");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> collection) {
        throw new RuntimeException("Reach method removeAll");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> collection) {
        throw new RuntimeException("Reach method retainAll");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator<MessageQueue.IdleHandler> listIterator(int i) {
        throw new RuntimeException("Reach method listIterator");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator<MessageQueue.IdleHandler> listIterator() {
        throw new RuntimeException("Reach method listIterator");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<MessageQueue.IdleHandler> iterator() {
        return this.mOriginalArrayList.iterator();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public List<MessageQueue.IdleHandler> subList(int i, int i2) {
        throw new RuntimeException("Reach method subList");
    }

    @Override // java.util.ArrayList, java.lang.Iterable
    public void forEach(Consumer<? super MessageQueue.IdleHandler> consumer) {
        throw new RuntimeException("Reach method forEach");
    }

    @Override // java.util.ArrayList, java.util.Collection, java.lang.Iterable, java.util.List
    public Spliterator<MessageQueue.IdleHandler> spliterator() {
        throw new RuntimeException("Reach method spliterator");
    }

    @Override // java.util.ArrayList, java.util.Collection
    public boolean removeIf(Predicate<? super MessageQueue.IdleHandler> predicate) {
        throw new RuntimeException("Reach method removeIf");
    }

    @Override // java.util.ArrayList, java.util.List
    public void replaceAll(UnaryOperator<MessageQueue.IdleHandler> unaryOperator) {
        throw new RuntimeException("Reach method replaceAll");
    }

    @Override // java.util.ArrayList, java.util.List
    public void sort(Comparator<? super MessageQueue.IdleHandler> comparator) {
        throw new RuntimeException("Reach method sort");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection<?> collection) {
        throw new RuntimeException("Reach method containsAll");
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return super.toString();
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override // java.util.Collection
    public Stream<MessageQueue.IdleHandler> stream() {
        throw new RuntimeException("Reach method stream");
    }

    @Override // java.util.Collection
    public Stream<MessageQueue.IdleHandler> parallelStream() {
        throw new RuntimeException("Reach method parallelStream");
    }
}
