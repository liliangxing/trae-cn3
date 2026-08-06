package com.bytedance.bdturing.livedetect;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.VerifyTaskHandler;
import com.bytedance.bdturing.cache.TuringThreadPool;
import com.bytedance.bdturing.setting.SettingUpdateRequest;
import com.bytedance.bdturing.ttnet.TTNetUtil;
import com.bytedance.bdturing.utils.FileUtil;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LiveModelResManager implements SettingUpdateRequest.Callback {
    private static final String DETECT_MODEL_NAME = "det_model.bytenn";
    private static final String KPT_MODEL_NAME = "kpt_model.bytenn";
    private static final int MAX_RETRY_NUM = 1;
    private static final String MODEL_ZIP_NAME = "bytenn_models.zip";
    private static final int STATE_CFG_MD5_EMPTY = 1;
    private static final int STATE_MODEL_FILE_MD5_ERROR = 4;
    private static final int STATE_MODEL_FILE_MD5_NOT_EQUAL = 5;
    private static final int STATE_MODEL_FILE_NOT_EXISTS = 3;
    private static final int STATE_MODEL_PATH_EMPTY = 2;
    private static final int STATE_SUCCESS = 0;
    private static final String TAG = "LiveModelResManager";
    private static volatile LiveModelResManager sInstance;
    private boolean isDownloading;
    private int mCurrentNum;
    private String mModelDir;
    private final List<ModelFileDownLoadListener> mCallbackList = new ArrayList();
    private int modelFileUrlIndex = 0;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface ModelFileDownLoadListener {
        void onComplete(boolean z, String str);
    }

    static /* synthetic */ int access$108(LiveModelResManager liveModelResManager) {
        int i = liveModelResManager.mCurrentNum;
        liveModelResManager.mCurrentNum = i + 1;
        return i;
    }

    static /* synthetic */ int access$408(LiveModelResManager liveModelResManager) {
        int i = liveModelResManager.modelFileUrlIndex;
        liveModelResManager.modelFileUrlIndex = i + 1;
        return i;
    }

    private LiveModelResManager() {
    }

    public static LiveModelResManager getInstance() {
        if (sInstance == null) {
            synchronized (LiveModelResManager.class) {
                if (sInstance == null) {
                    sInstance = new LiveModelResManager();
                }
            }
        }
        return sInstance;
    }

    @Override // com.bytedance.bdturing.setting.SettingUpdateRequest.Callback
    public void onResponse(int i, String str, long j) {
        if (i != 200 || isModelFileReady()) {
            return;
        }
        VerifyTaskHandler.getInstance().postRunnableDelay(new Runnable() { // from class: com.bytedance.bdturing.livedetect.LiveModelResManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (LiveModelResManager.this.isModelFileReady()) {
                    return;
                }
                LiveModelResManager.this.clearCache();
                LiveModelResManager.this.downLoadModelFile("setting_update");
            }
        }, 7000L);
    }

    public void init(Context context) {
        if (context != null) {
            this.mModelDir = context.getFilesDir() + File.separator + "BdTuring" + File.separator + "face_model";
        }
    }

    public void downLoadModelInNeed() {
        if (isModelFileReady()) {
            return;
        }
        downLoadModelFile("init");
    }

    public boolean isModelFileReady() {
        if (TextUtils.isEmpty(this.mModelDir)) {
            return false;
        }
        return new File(detectModelPath()).exists() && new File(kptModelPath()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCache() {
        File file = new File(this.mModelDir);
        if (file.exists()) {
            FileUtil.deleteFile(file);
        }
    }

    public String detectModelPath() {
        if (TextUtils.isEmpty(this.mModelDir)) {
            return "";
        }
        String modelFileMd5 = LiveAuthConfig.modelFileMd5(LiveAuthConfig.DETECT_MODEL_MD5);
        return TextUtils.isEmpty(modelFileMd5) ? "" : this.mModelDir + File.separator + modelFileMd5;
    }

    public String kptModelPath() {
        if (TextUtils.isEmpty(this.mModelDir)) {
            return "";
        }
        String modelFileMd5 = LiveAuthConfig.modelFileMd5(LiveAuthConfig.KPT_MODEL_MD5);
        return TextUtils.isEmpty(modelFileMd5) ? "" : this.mModelDir + File.separator + modelFileMd5;
    }

    public void downLoadModelFile(String str) {
        downLoadModelFile(str, null);
    }

    public void downLoadModelFile(final String str, ModelFileDownLoadListener modelFileDownLoadListener) {
        if (modelFileDownLoadListener != null && !this.mCallbackList.contains(modelFileDownLoadListener)) {
            this.mCallbackList.add(modelFileDownLoadListener);
        }
        if (this.isDownloading) {
            return;
        }
        final String liveModelUrl = LiveAuthConfig.liveModelUrl(this.modelFileUrlIndex);
        if (TextUtils.isEmpty(liveModelUrl)) {
            if (modelFileDownLoadListener != null) {
                modelFileDownLoadListener.onComplete(false, "url is empty");
            }
        } else {
            this.mCurrentNum = 0;
            final long currentTimeMillis = System.currentTimeMillis();
            this.isDownloading = true;
            loadModeFileInner(liveModelUrl, new ModelFileDownLoadListener() { // from class: com.bytedance.bdturing.livedetect.LiveModelResManager.2
                @Override // com.bytedance.bdturing.livedetect.LiveModelResManager.ModelFileDownLoadListener
                public void onComplete(boolean z, String str2) {
                    EventReport.loadLiveMode(str, z, !TextUtils.isEmpty(str2) ? str2 : "", System.currentTimeMillis() - currentTimeMillis);
                    if (z || LiveModelResManager.this.mCurrentNum >= 1) {
                        LiveModelResManager.this.isDownloading = false;
                        LiveModelResManager.this.mCurrentNum = 0;
                        if (!z) {
                            LiveModelResManager.access$408(LiveModelResManager.this);
                        }
                        LiveModelResManager.this.dispatchDownLoadResult(z, str2);
                        return;
                    }
                    LiveModelResManager.access$108(LiveModelResManager.this);
                    VerifyTaskHandler.getInstance().postRunnableDelay(new Runnable() { // from class: com.bytedance.bdturing.livedetect.LiveModelResManager.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LiveModelResManager.this.loadModeFileInner(liveModelUrl, this);
                        }
                    }, 500L);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadModeFileInner(final String str, final ModelFileDownLoadListener modelFileDownLoadListener) {
        TuringThreadPool.getInstance().execute(new Runnable() { // from class: com.bytedance.bdturing.livedetect.LiveModelResManager.3
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                String str3 = "";
                boolean z = false;
                try {
                    try {
                        SsResponse execute = TTNetUtil.createRetrofitApi(str).doGet(false, str, null, null).execute();
                        if (execute == null || execute.code() != 200) {
                            str3 = "net_work_error";
                        } else {
                            LiveModelResManager.this.clearCache();
                            InputStream in = ((TypedInput) execute.body()).in();
                            long length = ((TypedInput) execute.body()).length();
                            String str4 = LiveModelResManager.this.mModelDir + File.separator + LiveModelResManager.MODEL_ZIP_NAME;
                            File copyFile = FileUtil.copyFile(in, str4);
                            if (copyFile != null && copyFile.exists() && copyFile.length() == length) {
                                String str5 = LiveModelResManager.this.mModelDir + File.separator + "temp";
                                if (!FileUtil.decompress(copyFile.getAbsolutePath(), str5)) {
                                    LiveModelResManager.this.clearCache();
                                    str3 = "model_decompress_error";
                                } else {
                                    File file = new File(str5);
                                    if (file.exists()) {
                                        Pair<Boolean, String> flatCopyFolder = FileUtil.flatCopyFolder(file, new File(LiveModelResManager.this.mModelDir));
                                        str2 = "trans file success:" + flatCopyFolder.first + ",trans_file_msg:" + ((String) flatCopyFolder.second);
                                        FileUtil.deleteFile(str5);
                                        FileUtil.deleteFile(str4);
                                    } else {
                                        str2 = "";
                                    }
                                    Pair checkAndRenameModelFile = LiveModelResManager.this.checkAndRenameModelFile();
                                    int intValue = ((Integer) checkAndRenameModelFile.first).intValue();
                                    String str6 = (String) checkAndRenameModelFile.second;
                                    if (intValue == 0) {
                                        z = true;
                                    } else {
                                        str3 = "model_checkModelSum_error:ret=" + intValue + ";msg=" + str6 + ";file_trans_msg=" + str2;
                                        LiveModelResManager.this.clearCache();
                                    }
                                }
                            } else {
                                str3 = "model_file_load_error";
                            }
                        }
                    } catch (Exception e) {
                        String message = e.getMessage();
                        ModelFileDownLoadListener modelFileDownLoadListener2 = modelFileDownLoadListener;
                        if (modelFileDownLoadListener2 != null) {
                            modelFileDownLoadListener2.onComplete(false, message);
                        }
                    }
                } finally {
                    ModelFileDownLoadListener modelFileDownLoadListener3 = modelFileDownLoadListener;
                    if (modelFileDownLoadListener3 != null) {
                        modelFileDownLoadListener3.onComplete(false, "");
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<Integer, String> checkAndRenameModelFile() {
        String str;
        String modelFileMd5 = LiveAuthConfig.modelFileMd5(LiveAuthConfig.DETECT_MODEL_MD5);
        String modelFileMd52 = LiveAuthConfig.modelFileMd5(LiveAuthConfig.KPT_MODEL_MD5);
        if (TextUtils.isEmpty(modelFileMd5) || TextUtils.isEmpty(modelFileMd52)) {
            return new Pair<>(1, "config md5 is empty:detect_md5=" + modelFileMd5 + ";kpt_md5=" + modelFileMd52);
        }
        String str2 = this.mModelDir + File.separator + DETECT_MODEL_NAME;
        String str3 = this.mModelDir + File.separator + KPT_MODEL_NAME;
        File file = new File(str2);
        File file2 = new File(str3);
        if (!file.exists() || !file2.exists()) {
            return new Pair<>(3, "mode file not exists");
        }
        String fileMd5Hex = FileUtil.fileMd5Hex(file);
        String fileMd5Hex2 = FileUtil.fileMd5Hex(file2);
        if (TextUtils.isEmpty(fileMd5Hex) || TextUtils.isEmpty(fileMd5Hex2)) {
            return new Pair<>(4, "get file md5 fail:detect_md5=" + fileMd5Hex + ";kpt_md5=" + fileMd5Hex2);
        }
        int i = 5;
        if (fileMd5Hex.equals(modelFileMd5) && fileMd5Hex2.equals(modelFileMd52)) {
            File file3 = new File(detectModelPath());
            File file4 = new File(kptModelPath());
            if (file.renameTo(file3) && file2.renameTo(file4)) {
                str = "";
                i = 0;
            } else {
                str = "rename fail";
            }
        } else {
            str = "md5 not equal:cfg_detect_md5=" + modelFileMd5 + ";detect_md5=" + fileMd5Hex + ";cfg_kpt_md5=" + modelFileMd52 + ";kpt_md5=" + fileMd5Hex2;
        }
        return new Pair<>(Integer.valueOf(i), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchDownLoadResult(boolean z, String str) {
        for (ModelFileDownLoadListener modelFileDownLoadListener : this.mCallbackList) {
            if (modelFileDownLoadListener != null) {
                try {
                    modelFileDownLoadListener.onComplete(z, str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        this.mCallbackList.clear();
    }

    public void removeCallBackRef(ModelFileDownLoadListener modelFileDownLoadListener) {
        if (this.mCallbackList.isEmpty()) {
            return;
        }
        this.mCallbackList.remove(modelFileDownLoadListener);
    }
}
