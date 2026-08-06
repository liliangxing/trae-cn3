package com.bytedance.geckox.model;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Resources.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006B\u0005¢\u0006\u0002\u0010\u0007J'\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\b\u0013R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/geckox/model/Resources;", "", "groups", "", "", "channels", "([Ljava/lang/String;[Ljava/lang/String;)V", "()V", "", "getChannels", "()Ljava/util/List;", "setChannels", "(Ljava/util/List;)V", "getGroups", "setGroups", "isHit", "", "group", "channel", "isHit$geckox_noasanRelease", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class Resources {
    private List<String> channels;
    private List<String> groups;

    public Resources() {
    }

    public Resources(String[] strArr, String[] strArr2) {
        this();
        this.groups = strArr != null ? ArraysKt.asList(strArr) : null;
        this.channels = strArr2 != null ? ArraysKt.asList(strArr2) : null;
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
    public final boolean isHit$geckox_noasanRelease(List<String> group, String channel) {
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
}
