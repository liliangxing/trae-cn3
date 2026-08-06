package com.bytedance.iesgurd.model;

import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeploymentsData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0081\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0013\u001a\u00020\u0004J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J \u0010\u0016\u001a\u00020\u00112\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/iesgurd/model/DeploymentsData;", "", "groups", "", "", "channels", "(Ljava/util/List;Ljava/util/List;)V", "getChannels", "()Ljava/util/List;", "setChannels", "(Ljava/util/List;)V", "getGroups", "setGroups", "component1", "component2", "copy", "equals", "", "other", "getSortString", "hashCode", "", "isHit", "group", "channel", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class DeploymentsData {

    @SerializedName("target_channels")
    private List<String> channels;

    @SerializedName("group_names")
    private List<String> groups;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeploymentsData copy$default(DeploymentsData deploymentsData, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = deploymentsData.groups;
        }
        if ((i & 2) != 0) {
            list2 = deploymentsData.channels;
        }
        return deploymentsData.copy(list, list2);
    }

    public final List<String> component1() {
        return this.groups;
    }

    public final List<String> component2() {
        return this.channels;
    }

    public final DeploymentsData copy(List<String> groups, List<String> channels) {
        return new DeploymentsData(groups, channels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeploymentsData)) {
            return false;
        }
        DeploymentsData deploymentsData = (DeploymentsData) other;
        return Intrinsics.areEqual(this.groups, deploymentsData.groups) && Intrinsics.areEqual(this.channels, deploymentsData.channels);
    }

    public int hashCode() {
        List<String> list = this.groups;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<String> list2 = this.channels;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "DeploymentsData(groups=" + this.groups + ", channels=" + this.channels + ")";
    }

    public DeploymentsData(List<String> list, List<String> list2) {
        this.groups = list;
        this.channels = list2;
    }

    public final List<String> getGroups() {
        return this.groups;
    }

    public final void setGroups(List<String> list) {
        this.groups = list;
    }

    public final List<String> getChannels() {
        return this.channels;
    }

    public final void setChannels(List<String> list) {
        this.channels = list;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
    
        if ((r0 == null || r0.isEmpty()) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
    
        if (r0.contains(r6) != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isHit(List<String> group, String channel) {
        Object obj;
        List<String> list = this.groups;
        if (list == null || list.isEmpty()) {
            List<String> list2 = this.channels;
        }
        if (channel != null) {
            List<String> list3 = this.channels;
            if (!(list3 == null || list3.isEmpty())) {
                List<String> list4 = this.channels;
                if (list4 == null) {
                    Intrinsics.throwNpe();
                }
            }
        }
        if (group == null) {
            return false;
        }
        List<String> list5 = this.groups;
        if (list5 == null || list5.isEmpty()) {
            return false;
        }
        List<String> list6 = this.groups;
        if (list6 == null) {
            Intrinsics.throwNpe();
        }
        Iterator<T> it = list6.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (group.contains((String) obj)) {
                break;
            }
        }
        CharSequence charSequence = (CharSequence) obj;
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        return true;
    }

    public final String getSortString() {
        StringBuilder sb = new StringBuilder();
        List<String> list = this.groups;
        if (list != null) {
            sb.append(CollectionsKt.sorted(list).toString());
        }
        List<String> list2 = this.channels;
        if (list2 != null) {
            sb.append(CollectionsKt.sorted(list2).toString());
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
        return sb2;
    }
}
