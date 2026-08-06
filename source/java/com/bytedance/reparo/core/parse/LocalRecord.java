package com.bytedance.reparo.core.parse;

import android.text.TextUtils;
import com.ss.android.update.UpdateDialogNewBase;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes4.dex */
public class LocalRecord {
    private String hostAppVersion;
    private Set<PatchRecordInfo> patchRecordInfoSet;

    public Set<PatchRecordInfo> getPatchRecordInfoSet() {
        if (this.patchRecordInfoSet == null) {
            this.patchRecordInfoSet = new HashSet();
        }
        return this.patchRecordInfoSet;
    }

    public void setPatchRecordInfoSet(Set<PatchRecordInfo> set) {
        this.patchRecordInfoSet = set;
    }

    public String getHostAppVersion() {
        if (this.hostAppVersion == null) {
            this.hostAppVersion = "";
        }
        return this.hostAppVersion;
    }

    public void setHostAppVersion(String str) {
        this.hostAppVersion = str;
    }

    public void addNewPatchRecord(PatchRecordInfo patchRecordInfo) {
        getPatchRecordInfoSet().add(patchRecordInfo);
    }

    public void store(LocalRecordParser localRecordParser) {
        localRecordParser.write(this);
    }

    public boolean isPatchRecordInfoLegal(PatchRecordInfo patchRecordInfo) {
        return patchRecordInfo.illegalNextStart() || (TextUtils.equals(this.hostAppVersion, patchRecordInfo.getHostAppVersion()) && patchRecordInfo.isLegal());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("hostAppVersion=");
        sb.append(getHostAppVersion()).append(UpdateDialogNewBase.TYPE);
        Iterator<PatchRecordInfo> it = getPatchRecordInfoSet().iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString()).append(UpdateDialogNewBase.TYPE);
        }
        return sb.toString();
    }
}
