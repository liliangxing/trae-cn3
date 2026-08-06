package androidx.compose.p001ui.precompose;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;

/* compiled from: Delegates.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Landroidx/compose/ui/precompose/ViewModelStoreOwnerDelegate;", "Landroidx/lifecycle/ViewModelStoreOwner;", "<init>", "()V", "_viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "viewModelStore", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "bindRealViewModelStore", "", "realViewModelStore", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ViewModelStoreOwnerDelegate implements ViewModelStoreOwner {
    public static final int $stable = 8;
    private ViewModelStore _viewModelStore = new ViewModelStore();

    @Override // androidx.lifecycle.ViewModelStoreOwner
    /* renamed from: getViewModelStore, reason: from getter */
    public ViewModelStore get_viewModelStore() {
        return this._viewModelStore;
    }

    public final void bindRealViewModelStore(ViewModelStore realViewModelStore) {
        Set<String> keys = this._viewModelStore.keys();
        ArrayList<Pair> arrayList = new ArrayList();
        for (String str : keys) {
            ViewModel viewModel = this._viewModelStore.get(str);
            Pair pair = viewModel != null ? TuplesKt.to(str, viewModel) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        for (Pair pair2 : arrayList) {
            realViewModelStore.put((String) pair2.getFirst(), (ViewModel) pair2.getSecond());
        }
        this._viewModelStore.clear();
        this._viewModelStore = realViewModelStore;
    }
}
