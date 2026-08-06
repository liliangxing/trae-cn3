package com.bytedance.trae.home.solo.sitemessage;

import androidx.recyclerview.widget.DiffUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SiteMessageAdapter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldPos", "newPos", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class SiteMessageDiffCallback extends DiffUtil.Callback {
    private final List<SiteMessageItem> newList;
    private final List<SiteMessageItem> oldList;

    public SiteMessageDiffCallback(List<SiteMessageItem> list, List<SiteMessageItem> list2) {
        Intrinsics.checkNotNullParameter(list, "oldList");
        Intrinsics.checkNotNullParameter(list2, "newList");
        this.oldList = list;
        this.newList = list2;
    }

    public int getOldListSize() {
        return this.oldList.size();
    }

    public int getNewListSize() {
        return this.newList.size();
    }

    public boolean areItemsTheSame(int oldPos, int newPos) {
        return this.oldList.get(oldPos).getId() == this.newList.get(newPos).getId();
    }

    public boolean areContentsTheSame(int oldPos, int newPos) {
        return Intrinsics.areEqual(this.oldList.get(oldPos), this.newList.get(newPos));
    }
}
