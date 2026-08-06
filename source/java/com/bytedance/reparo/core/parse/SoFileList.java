package com.bytedance.reparo.core.parse;

import com.bytedance.reparo.core.WandTrick;
import com.bytedance.reparo.core.utils.Predicate;
import com.bytedance.reparo.core.utils.PredicateUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SoFileList {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String CPU_ARM64_V8A = "arm64-v8a";
    private static final String CPU_ARMEABI = "armeabi";
    private static final String CPU_ARMEABI_V7A = "armeabi-v7a";
    private static final String CPU_UNKNOWN = "unknown";
    private static final String CPU_X86 = "x86";
    private static final String CPU_X86_64 = "x86_64";
    public String cpuAbi;
    private List<SoFile> soFileList = new ArrayList();
    private boolean hasNonSelfSo = false;

    public boolean hasNonSelfSo() {
        return this.hasNonSelfSo;
    }

    public SoFileList(String str) {
        this.cpuAbi = str;
    }

    public void addSoFile(SoFile soFile) {
        if (this.soFileList.contains(soFile)) {
            return;
        }
        this.soFileList.add(soFile);
        if (WandTrick.isSelfSo(soFile.name)) {
            return;
        }
        this.hasNonSelfSo = true;
    }

    public SoFile findSoFile(Predicate<SoFile> predicate) {
        return (SoFile) PredicateUtils.findFirst(this.soFileList, predicate);
    }

    public int size() {
        return this.soFileList.size();
    }

    public List<SoFile> get() {
        return this.soFileList;
    }

    public HashMap<String, SoFile> getSoFileMaps() {
        HashMap<String, SoFile> hashMap = new HashMap<>();
        for (SoFile soFile : this.soFileList) {
            hashMap.put(soFile.relativePath, soFile);
        }
        return hashMap;
    }

    public static SoFile parse(String str) {
        String substring = str.substring(str.lastIndexOf("/") + 1);
        SoFile soFile = new SoFile();
        soFile.name = substring;
        soFile.relativePath = str;
        soFile.cpuAbi = str.split("/")[1];
        return soFile;
    }
}
