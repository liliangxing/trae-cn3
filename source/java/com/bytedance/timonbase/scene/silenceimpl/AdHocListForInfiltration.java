package com.bytedance.timonbase.scene.silenceimpl;

import android.view.View;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdHocListForInfiltration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B!\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/timonbase/scene/silenceimpl/AdHocListForInfiltration;", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "origin", "(Ljava/util/ArrayList;)V", "add", "", "element", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class AdHocListForInfiltration extends ArrayList<View> {
    public /* bridge */ boolean contains(View view) {
        return super.contains((Object) view);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof View) {
            return contains((View) obj);
        }
        return false;
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ int indexOf(View view) {
        return super.indexOf((Object) view);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof View) {
            return indexOf((View) obj);
        }
        return -1;
    }

    public /* bridge */ int lastIndexOf(View view) {
        return super.lastIndexOf((Object) view);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof View) {
            return lastIndexOf((View) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ View remove(int i) {
        return removeAt(i);
    }

    public /* bridge */ boolean remove(View view) {
        return super.remove((Object) view);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof View) {
            return remove((View) obj);
        }
        return false;
    }

    public /* bridge */ View removeAt(int i) {
        return (View) super.remove(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public AdHocListForInfiltration(ArrayList<View> arrayList) {
        super(arrayList == null ? new ArrayList<>() : arrayList);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(View element) {
        Intrinsics.checkParameterIsNotNull(element, "element");
        DecorViewInfiltrator.INSTANCE.infiltrateFor(element);
        return super.add((AdHocListForInfiltration) element);
    }
}
