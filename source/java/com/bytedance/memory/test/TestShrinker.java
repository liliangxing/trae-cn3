package com.bytedance.memory.test;

import com.bytedance.memory.shrink.HprofBufferShrinker;
import java.io.File;
import java.io.IOException;

/* loaded from: classes4.dex */
public class TestShrinker {
    public static void main(String[] strArr) throws IOException {
        File file = new File("/Users/Liuzhao.Future/Downloads/线上Hprof文件/helo/dump.hprof");
        File file2 = new File("/Users/Liuzhao.Future/Downloads/线上Hprof文件/helo/dump1211shrink2.hprof");
        new HprofBufferShrinker().shrink(file, file2);
        System.out.println("origin length " + ((file.length() / 1000) / 1000) + " shrinklength " + ((file2.length() / 1000) / 1000));
    }
}
