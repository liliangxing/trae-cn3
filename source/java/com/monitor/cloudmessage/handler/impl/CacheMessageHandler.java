package com.monitor.cloudmessage.handler.impl;

import android.content.Context;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.util.ParseUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.internal.file.generator.DirTreeFileGenerator;
import com.monitor.cloudmessage.refactor.CommandReportUtils;
import com.monitor.cloudmessage.refactor.CommandResultUploader;
import com.monitor.cloudmessage.utils.ExceptionUtils;
import com.monitor.cloudmessage.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CacheMessageHandler extends BaseMessageHandler {
    private static final String CACHE_FILE_TYPE = "log_dir_tree";
    private static final String EXTERNAL_PREFIX = "external";
    private static final String INTERNAL_PREFIX = "internal";
    private static final String KEY_RELATIVE_DIRNAME = "relativeDirName";
    private static final String KEY_ROOT_NODE = "rootNode";

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.CACHE;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(final CloudMessage cloudMessage) throws Exception {
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).registerConfigListener(new IConfigListener() { // from class: com.monitor.cloudmessage.handler.impl.CacheMessageHandler.1
            public void onReady() {
            }

            public void onRefresh(JSONObject jSONObject, boolean z) {
                try {
                    try {
                        CacheMessageHandler.this.parseConfig(jSONObject, z, cloudMessage);
                    } catch (CloudMessageException e) {
                        CacheMessageHandler.this.uploadFailStatus(e.getMessage(), cloudMessage);
                    } catch (Exception e2) {
                        CacheMessageHandler.this.uploadFailStatus(String.format("系统错误：%s", ExceptionUtils.getFullStacktrace(e2)), cloudMessage);
                    }
                } finally {
                    ((IConfigManager) ServiceManager.getService(IConfigManager.class)).unregisterConfigListener(this);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseConfig(JSONObject jSONObject, boolean z, CloudMessage cloudMessage) throws Exception {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("performance_modules");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("disk")) == null) {
            return;
        }
        List<String> absolutePath = toAbsolutePath(ParseUtils.parseList(optJSONObject, "compliance_relative_paths"));
        JSONObject paramsJson = cloudMessage.getParamsJson();
        File joinFile = FileUtils.joinFile(paramsJson.optString(KEY_ROOT_NODE), paramsJson.optString(KEY_RELATIVE_DIRNAME));
        if (joinFile == null) {
            throw new CloudMessageException("目录参数解析失败");
        }
        CommandReportUtils.uploadRunningMessage("handling dir upload:" + joinFile.getAbsolutePath(), cloudMessage);
        if (!joinFile.exists()) {
            throw new CloudMessageException("目录不存在");
        }
        File pendingDir = CommandResultUploader.getInstance().getPendingDir();
        if (pendingDir == null) {
            throw new CloudMessageException("pending目录因拿不到context而未设置");
        }
        File file = new File(pendingDir, cloudMessage.getCommandId() + "_temp");
        FileUtils.ensureDirectoryClean(file);
        boolean writeDirTreeInfo = DirTreeFileGenerator.writeDirTreeInfo(joinFile, new File(file, "dir_tree.txt"), absolutePath);
        Logger.d("cloudmessage", new String[]{"dir tree generate result " + writeDirTreeInfo});
        if (!writeDirTreeInfo) {
            throw new CloudMessageException("目录树文件生成失败");
        }
        CommandResultUploader.getInstance().upload(cloudMessage, file, CACHE_FILE_TYPE);
    }

    private List<String> toAbsolutePath(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (ListUtils.isEmpty(list)) {
            return arrayList;
        }
        Context context = CloudMessageManager.getInstance().getContext();
        for (String str : list) {
            if (str.contains(INTERNAL_PREFIX)) {
                arrayList.add(str.replace(INTERNAL_PREFIX, context.getFilesDir().getParentFile().getAbsolutePath()));
            } else if (str.contains(EXTERNAL_PREFIX)) {
                arrayList.add(str.replace(EXTERNAL_PREFIX, context.getExternalFilesDir(null).getParentFile().getAbsolutePath()));
            }
        }
        return arrayList;
    }
}
