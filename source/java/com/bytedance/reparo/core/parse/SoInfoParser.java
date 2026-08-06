package com.bytedance.reparo.core.parse;

import com.bytedance.reparo.core.common.utils.FileUtils;
import com.bytedance.reparo.core.exception.SoInfoParseException;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class SoInfoParser {
    private static final Map<String, List<SoInfo>> soInfoCache = new HashMap();

    private SoInfoParser() {
    }

    public static List<SoInfo> parse(File file) {
        if (!FileUtils.isExist(file)) {
            return null;
        }
        Map<String, List<SoInfo>> map = soInfoCache;
        List<SoInfo> list = map.get(file.getAbsolutePath());
        if (list != null) {
            return list;
        }
        List<SoInfo> readSoInfo = readSoInfo(file);
        if (readSoInfo.size() == 0) {
            return null;
        }
        map.put(file.getAbsolutePath(), readSoInfo);
        return readSoInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List<SoInfo> readSoInfo(File file) {
        BufferedReader bufferedReader;
        ArrayList arrayList = new ArrayList();
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2, Charset.forName("UTF-8")));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            String[] split = readLine.split(" ");
                            SoInfo soInfo = new SoInfo();
                            soInfo.name = split[0];
                            soInfo.isDiff = Boolean.parseBoolean(split[1]);
                            for (int i = 2; i < split.length; i++) {
                                String[] split2 = split[i].split(ContainerUtils.KEY_VALUE_DELIMITER);
                                soInfo.pushKey(split2[0], split2[1]);
                            }
                            arrayList.add(soInfo);
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                        try {
                            throw new SoInfoParseException(String.format("read %s failed. ", file.getAbsolutePath()), e, 0);
                        } catch (Throwable th) {
                            th = th;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (bufferedReader == null) {
                                try {
                                    bufferedReader.close();
                                    throw th;
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                        }
                        if (bufferedReader == null) {
                        }
                    }
                }
                fileInputStream2.close();
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return arrayList;
            } catch (IOException e6) {
                e = e6;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (IOException e7) {
            e = e7;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    /* loaded from: classes4.dex */
    public static class SoInfo {
        public boolean isDiff;
        private Map<String, String> keyMap = new HashMap();
        public String name;

        public void pushKey(String str, String str2) {
            this.keyMap.put(str, str2);
        }

        public Map<String, String> getKeyMap() {
            return this.keyMap;
        }
    }
}
