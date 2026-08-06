package com.bytedance.trae.conversation.mediachoose.p008ui;

import com.bytedance.trae.conversation.mediachoose.model.MediaChooseConfig;
import com.bytedance.trae.conversation.mediachoose.model.MediaItem;
import com.bytedance.trae.conversation.mediachoose.model.MediaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MediaSelection.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0014J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\bJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\""}, d2 = {"Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;", "", "config", "Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;", "<init>", "(Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;)V", "selected", "Ljava/util/ArrayList;", "Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;", "Lkotlin/collections/ArrayList;", "value", "", "keepOrigin", "getKeepOrigin", "()Z", "isSelectedVideo", "setKeepOrigin", "", "setSelected", "items", "", "selectedItems", "selectedCount", "", "getOrderText", "", "id", "", "isSelected", "isDisabled", "item", "toggle", "Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;", "ToggleResult", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MediaSelection {
    private final MediaChooseConfig config;
    private boolean isSelectedVideo;
    private boolean keepOrigin;
    private final ArrayList<MediaItem> selected;

    public MediaSelection(MediaChooseConfig mediaChooseConfig) {
        Intrinsics.checkNotNullParameter(mediaChooseConfig, "config");
        this.config = mediaChooseConfig;
        this.selected = new ArrayList<>();
        this.keepOrigin = mediaChooseConfig.getKeepOriginDefault();
    }

    public final boolean getKeepOrigin() {
        return this.keepOrigin;
    }

    /* renamed from: isSelectedVideo, reason: from getter */
    public final boolean getIsSelectedVideo() {
        return this.isSelectedVideo;
    }

    public final void setKeepOrigin(boolean value) {
        this.keepOrigin = value;
    }

    public final void setSelected(List<MediaItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.selected.clear();
        this.selected.addAll(items);
        MediaItem mediaItem = (MediaItem) CollectionsKt.firstOrNull(this.selected);
        boolean z = false;
        if (mediaItem != null && mediaItem.isVideo()) {
            z = true;
        }
        this.isSelectedVideo = z;
    }

    public final List<MediaItem> selectedItems() {
        return CollectionsKt.toList(this.selected);
    }

    public final int selectedCount() {
        return this.selected.size();
    }

    public final String getOrderText(long id) {
        Iterator<MediaItem> it = this.selected.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (it.next().getId() == id) {
                break;
            }
            i++;
        }
        return i >= 0 ? String.valueOf(i + 1) : "";
    }

    public final boolean isSelected(long id) {
        ArrayList<MediaItem> arrayList = this.selected;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            if (((MediaItem) it.next()).getId() == id) {
                return true;
            }
        }
        return false;
    }

    public final boolean isDisabled(MediaItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (isSelected(item.getId()) || this.selected.isEmpty() || this.config.getMediaType() != MediaType.ALL_EXCLUSIVE) {
            return false;
        }
        if (this.isSelectedVideo) {
            return this.config.getSingleVideo() || !item.isVideo();
        }
        return item.isVideo();
    }

    public final ToggleResult toggle(MediaItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (isDisabled(item)) {
            return ToggleResult.BlockedByExclusive;
        }
        Iterator<MediaItem> it = this.selected.iterator();
        boolean z = false;
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (it.next().getId() == item.getId()) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            this.selected.remove(i);
            if (this.selected.isEmpty()) {
                this.isSelectedVideo = false;
            } else if (this.config.getMediaType() == MediaType.ALL_EXCLUSIVE) {
                this.isSelectedVideo = ((MediaItem) CollectionsKt.first(this.selected)).isVideo();
            }
            return ToggleResult.Removed;
        }
        boolean z2 = this.selected.size() == this.config.getMaxSelectCount();
        if (this.config.getSingleVideo() && this.selected.size() == 1 && this.isSelectedVideo) {
            z = true;
        }
        if (z2 || z) {
            return ToggleResult.ReachMax;
        }
        this.selected.add(item);
        if (this.selected.size() == 1) {
            this.isSelectedVideo = item.isVideo();
        }
        return ToggleResult.Added;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: MediaSelection.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;", "", "<init>", "(Ljava/lang/String;I)V", "Added", "Removed", "ReachMax", "BlockedByExclusive", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ToggleResult {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ToggleResult[] $VALUES;
        public static final ToggleResult Added = new ToggleResult("Added", 0);
        public static final ToggleResult Removed = new ToggleResult("Removed", 1);
        public static final ToggleResult ReachMax = new ToggleResult("ReachMax", 2);
        public static final ToggleResult BlockedByExclusive = new ToggleResult("BlockedByExclusive", 3);

        private static final /* synthetic */ ToggleResult[] $values() {
            return new ToggleResult[]{Added, Removed, ReachMax, BlockedByExclusive};
        }

        public static EnumEntries<ToggleResult> getEntries() {
            return $ENTRIES;
        }

        private ToggleResult(String str, int i) {
        }

        static {
            ToggleResult[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static ToggleResult valueOf(String str) {
            return (ToggleResult) Enum.valueOf(ToggleResult.class, str);
        }

        public static ToggleResult[] values() {
            return (ToggleResult[]) $VALUES.clone();
        }
    }
}
