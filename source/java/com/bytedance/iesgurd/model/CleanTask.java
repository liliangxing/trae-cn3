package com.bytedance.iesgurd.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* compiled from: CleanTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/iesgurd/model/CleanTask;", "", "()V", "cleanPackages", "", "", "getCleanPackages", "()Ljava/util/List;", "closePackages", "getClosePackages", "forbiddenPackages", "getForbiddenPackages", "unforbiddenPackages", "getUnforbiddenPackages", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final class CleanTask {

    @SerializedName("clean_packages")
    private final List<Long> cleanPackages;

    @SerializedName("close_packages")
    private final List<Long> closePackages;

    @SerializedName("forbidden_packages")
    private final List<Long> forbiddenPackages;

    @SerializedName("unforbidden_packages")
    private final List<Long> unforbiddenPackages;

    public final List<Long> getCleanPackages() {
        return this.cleanPackages;
    }

    public final List<Long> getClosePackages() {
        return this.closePackages;
    }

    public final List<Long> getForbiddenPackages() {
        return this.forbiddenPackages;
    }

    public final List<Long> getUnforbiddenPackages() {
        return this.unforbiddenPackages;
    }
}
