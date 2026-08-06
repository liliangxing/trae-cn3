package com.bytedance.crash;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.IoUtil;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TagService {
    private static final String IMPORT_TAG_DIR = "tags";
    private static final int MAX_COUNT = 5;
    private static final String TAG_DIR = "custom_tags";
    private static final Map<String, String> cacheImportMap = new ConcurrentHashMap();
    private static volatile File importTagsFile;
    private static ITagCacheService tagCacheService;
    private static volatile String tagPath;

    public static void setTagCacheService(ITagCacheService iTagCacheService) {
        tagCacheService = iTagCacheService;
    }

    public static Map<String, String> getTags() {
        return tagCacheService.getAll(tagPath);
    }

    public static ITagCacheService getTagCacheService() {
        return tagCacheService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initTagFile() {
        Context context;
        if (tagPath == null && (context = Global.getContext()) != null) {
            File file = new File(Global.getRootDirectory(), TAG_DIR);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, App.isMainProcess(context) ? PullConfiguration.PROCESS_NAME_MAIN : App.getCurProcessName().replaceAll(":", "@"));
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(file2, "tag_" + Global.getAppStartTime());
            if (!file3.exists()) {
                file3.mkdirs();
            }
            tagPath = file3.getAbsolutePath();
        }
    }

    public static void addTags(Map<? extends String, ? extends String> map, UserDataCenter userDataCenter) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    if (tagCacheService != null) {
                        saveTagsToFile(map);
                    } else {
                        userDataCenter.addCustomTags(map);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void addTag(String str, String str2, UserDataCenter userDataCenter) {
        if (tagCacheService != null) {
            saveTag(str, str2);
        } else {
            userDataCenter.addCustomTag(str, str2);
        }
    }

    public static void remove(String str, UserDataCenter userDataCenter) {
        if (tagCacheService != null) {
            saveTag(str, null);
        } else {
            userDataCenter.removeCustomTag(str);
        }
    }

    private static void saveTag(final String str, final String str2) {
        if (tagCacheService != null) {
            DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.TagService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        TagService.initTagFile();
                        if (str2 == null) {
                            TagService.tagCacheService.removeTag(TagService.tagPath, str);
                        } else {
                            TagService.tagCacheService.saveTag(TagService.tagPath, str, str2);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private static void saveTagsToFile(final Map<? extends String, ? extends String> map) {
        if (tagCacheService != null) {
            DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.TagService.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        TagService.initTagFile();
                        for (String str : map.keySet()) {
                            TagService.tagCacheService.saveTag(TagService.tagPath, str, (String) map.get(str));
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public static void packTags(JSONObject jSONObject) {
        ITagCacheService iTagCacheService;
        Map<String, String> all;
        try {
            final long optLong = jSONObject.optLong("app_start_time");
            String optString = jSONObject.optString("process_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("filters");
            File[] listFiles = new File(new File(Global.getRootDirectory(), TAG_DIR), App.isMainProcess(Global.getContext(), optString) ? PullConfiguration.PROCESS_NAME_MAIN : optString.replaceAll(":", "@")).listFiles(new FilenameFilter() { // from class: com.bytedance.crash.TagService.3
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str) {
                    try {
                        String[] split = str.split("_");
                        if (split.length == 2) {
                            String str2 = split[1];
                            if (Math.abs(Long.parseLong(str2.substring(0, str2.length())) - optLong) < 1000) {
                                return true;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    return false;
                }
            });
            if (listFiles == null || listFiles.length < 1 || (iTagCacheService = tagCacheService) == null || (all = iTagCacheService.getAll(listFiles[0].getAbsolutePath())) == null) {
                return;
            }
            JSONUtils.jsonPutAll(optJSONObject, all);
        } catch (Throwable unused) {
        }
    }

    public static Map<String, String> getImportTagMap() {
        return cacheImportMap;
    }

    public void clearImportTagsFile() {
        try {
            if (importTagsFile != null) {
                importTagsFile.delete();
            }
        } catch (Throwable unused) {
        }
    }

    public static void addImportTag(String str, String str2) {
        if (str == null) {
            return;
        }
        if (str2 == null) {
            removeImportTag(str);
            return;
        }
        Map<String, String> map = cacheImportMap;
        map.put(str, str2);
        if (NpthCore.isInit()) {
            final HashMap hashMap = new HashMap(map);
            DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.TagService.4
                @Override // java.lang.Runnable
                public void run() {
                    TagService.save(hashMap);
                }
            });
        }
    }

    public static void removeImportTag(String str) {
        Map<String, String> map = cacheImportMap;
        if (map.containsKey(str)) {
            map.remove(str);
            if (NpthCore.isInit()) {
                final HashMap hashMap = new HashMap(map);
                DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.TagService.5
                    @Override // java.lang.Runnable
                    public void run() {
                        TagService.save(hashMap);
                    }
                });
            }
        }
    }

    public static void addImportTags(Map<? extends String, ? extends String> map) {
        if (map == null) {
            return;
        }
        if (!NpthCore.isInit()) {
            cacheImportMap.putAll(map);
            return;
        }
        Map<String, String> map2 = cacheImportMap;
        map2.putAll(map);
        final HashMap hashMap = new HashMap(map2);
        DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.TagService.6
            @Override // java.lang.Runnable
            public void run() {
                TagService.save(hashMap);
            }
        });
    }

    public static void save() {
        Map<String, String> map = cacheImportMap;
        if (map.isEmpty()) {
            return;
        }
        save(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void save(Map<String, String> map) {
        ObjectOutputStream objectOutputStream = null;
        try {
            if (importTagsFile == null) {
                Application application = Global.getApplication();
                if (application != null) {
                    File file = new File(Global.getRootDirectory(), IMPORT_TAG_DIR);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(file, App.isMainProcess(application) ? PullConfiguration.PROCESS_NAME_MAIN : App.getCurProcessName().replaceAll(":", "@"));
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    importTagsFile = new File(file2, "import_tag_" + NpthBus.getAppStartTime() + ".txt");
                } else {
                    IoUtil.close(null);
                    return;
                }
            }
            if (importTagsFile != null) {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(importTagsFile));
                try {
                    objectOutputStream2.writeObject(map);
                    IoUtil.close(objectOutputStream2);
                    return;
                } catch (Throwable unused) {
                    objectOutputStream = objectOutputStream2;
                    IoUtil.close(objectOutputStream);
                    return;
                }
            }
            IoUtil.close(null);
        } catch (Throwable unused2) {
        }
    }

    public static void cleanTags() {
        if (Global.getContext() == null) {
            return;
        }
        clean(new File(Global.getRootDirectory(), TAG_DIR));
        clean(new File(Global.getRootDirectory(), IMPORT_TAG_DIR));
    }

    public static void clean(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (!file2.isFile()) {
                File[] listFiles2 = file2.listFiles();
                if (listFiles2 == null) {
                    continue;
                } else {
                    if (listFiles2.length <= 5) {
                        return;
                    }
                    Arrays.sort(listFiles2);
                    for (int i = 0; i < listFiles2.length - 5; i++) {
                        FileUtils.deleteFile(listFiles2[i]);
                    }
                }
            } else {
                FileUtils.deleteFile(file2);
            }
        }
    }

    public static void dumpImportTags(JSONObject jSONObject, final long j, String str) {
        File[] listFiles = new File(new File(Global.getRootDirectory(), IMPORT_TAG_DIR), App.isMainProcess(Global.getContext(), str) ? PullConfiguration.PROCESS_NAME_MAIN : str.replaceAll(":", "@")).listFiles(new FilenameFilter() { // from class: com.bytedance.crash.TagService.7
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str2) {
                try {
                    String str3 = str2.split("_")[2];
                    return Math.abs(Long.parseLong(str3.substring(0, str3.length() + (-4))) - j) < 1000;
                } catch (Throwable unused) {
                    return false;
                }
            }
        });
        if (listFiles == null || listFiles.length < 1) {
            return;
        }
        ObjectInputStream objectInputStream = null;
        try {
            ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream(listFiles[0]));
            try {
                Map map = (Map) objectInputStream2.readObject();
                if (map != null) {
                    JSONUtils.jsonPutAll(jSONObject, map);
                }
                IoUtil.close(objectInputStream2);
            } catch (Throwable unused) {
                objectInputStream = objectInputStream2;
                IoUtil.close(objectInputStream);
            }
        } catch (Throwable unused2) {
        }
    }
}
