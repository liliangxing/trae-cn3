package com.bytedance.platform.settingsx.storage;

import android.os.Handler;
import com.bytedance.platform.settingsx.api.GlobalConfig;
import com.bytedance.platform.settingsx.api.internal.ProtoUtils;
import com.bytedance.platform.settingsx.api.map.MappedData;
import com.bytedance.platform.settingsx.api.storage.IBlock;
import com.bytedance.platform.settingsx.internal.HandlerUtils;
import com.bytedance.platform.settingsx.internal.Utils;
import com.bytedance.platform.settingsx.map.DataMapManager;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import okio.BufferedSink;
import okio.Okio;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PbFileBlock implements IBlock {
    private static final int CRC_LENGTH = 8;
    private static final int MAGIC = 1830;
    private static final int VERSION = 3;
    private final String name;
    private final String path;
    private final Map<Integer, List<MappedData>> dataMap = new ConcurrentHashMap();
    private final Runnable syncTask = new Runnable() { // from class: com.bytedance.platform.settingsx.storage.PbFileBlock$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            PbFileBlock.this.syncReal();
        }
    };
    private final Handler handler = HandlerUtils.getHandler();
    private final Future<?> loadFuture = loadFile();

    public PbFileBlock(String str) {
        this.name = str;
        this.path = new File(GlobalConfig.getContext().getFilesDir(), "settingsx/" + str).getAbsolutePath();
    }

    private void checkPath(File file) {
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // com.bytedance.platform.settingsx.api.storage.IBlock
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.platform.settingsx.api.storage.IBlock
    public void putBytes(int i, byte[] bArr) {
        throw new RuntimeException("not support");
    }

    @Override // com.bytedance.platform.settingsx.api.storage.IBlock
    public byte[] getBytes(int i, byte[] bArr) {
        throw new RuntimeException("not support");
    }

    @Override // com.bytedance.platform.settingsx.api.storage.IBlock
    public void putObject(int i, List<MappedData> list) {
        waitLoaded();
        this.dataMap.put(Integer.valueOf(i), list);
    }

    @Override // com.bytedance.platform.settingsx.api.storage.IBlock
    public List<MappedData> getObject(int i, List<MappedData> list) {
        waitLoaded();
        return this.dataMap.get(Integer.valueOf(i));
    }

    @Override // com.bytedance.platform.settingsx.api.storage.IBlock
    public void remove(int i) {
        waitLoaded();
        this.dataMap.remove(Integer.valueOf(i));
    }

    @Override // com.bytedance.platform.settingsx.api.storage.IBlock
    public Map<Integer, ?> getAll() {
        waitLoaded();
        return this.dataMap;
    }

    @Override // com.bytedance.platform.settingsx.api.storage.IBlock
    public void clear() {
        waitLoaded();
        this.dataMap.clear();
    }

    @Override // com.bytedance.platform.settingsx.api.storage.IBlock
    public boolean contains(int i) {
        waitLoaded();
        return this.dataMap.containsKey(Integer.valueOf(i));
    }

    @Override // com.bytedance.platform.settingsx.api.storage.IBlock
    public int getCount() {
        waitLoaded();
        return this.dataMap.size();
    }

    @Override // com.bytedance.platform.settingsx.api.storage.IBlock
    public void sync() {
        waitLoaded();
        this.handler.removeCallbacks(this.syncTask);
        this.handler.postDelayed(this.syncTask, 500L);
    }

    public void syncReal() {
        GlobalConfig.getIOWritePool().submit(new Runnable() { // from class: com.bytedance.platform.settingsx.storage.PbFileBlock$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PbFileBlock.this.m228x363661ab();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$syncReal$0$com-bytedance-platform-settingsx-storage-PbFileBlock */
    public /* synthetic */ void m228x363661ab() {
        File file = new File(this.path + ".temp");
        checkPath(file);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                byteArrayOutputStream = ProtoUtils.acquire();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(byteArrayOutputStream);
                newInstance.writeFixed32NoTag(MAGIC);
                newInstance.writeFixed32NoTag(3);
                for (Map.Entry<Integer, List<MappedData>> entry : this.dataMap.entrySet()) {
                    newInstance.writeInt32NoTag(entry.getKey().intValue());
                    DataMapManager.writeMappedData(newInstance, entry.getValue());
                }
                newInstance.writeFixed64NoTag(0L);
                newInstance.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                CodedOutputStream.newInstance(byteArray, byteArray.length - 8, 8).writeFixed64NoTag(Utils.computeCrc(byteArray, 0, byteArray.length - 8));
                BufferedSink buffer = Okio.buffer(Okio.sink(file));
                buffer.write(byteArray);
                buffer.flush();
                buffer.close();
                file.renameTo(new File(this.path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            ProtoUtils.release(byteArrayOutputStream);
        }
    }

    private void waitLoaded() {
        try {
            try {
                this.loadFuture.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    private Future<?> loadFile() {
        return GlobalConfig.getIOReadPool().submit(new Runnable() { // from class: com.bytedance.platform.settingsx.storage.PbFileBlock$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                PbFileBlock.this.m227x6b0e6d81();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$loadFile$1$com-bytedance-platform-settingsx-storage-PbFileBlock */
    public /* synthetic */ void m227x6b0e6d81() {
        File file = new File(this.path);
        checkPath(file);
        try {
            byte[] readByteArray = Okio.buffer(Okio.source(file)).readByteArray();
            if (readByteArray.length > 16) {
                CodedInputStream newInstance = CodedInputStream.newInstance(readByteArray, 0, readByteArray.length - 8);
                if (CodedInputStream.newInstance(readByteArray, readByteArray.length - 8, 8).readFixed64() != Utils.computeCrc(readByteArray, 0, readByteArray.length - 8)) {
                    return;
                }
                int readFixed32 = newInstance.readFixed32();
                int readFixed322 = newInstance.readFixed32();
                if (readFixed32 == MAGIC && readFixed322 == 3) {
                    while (!newInstance.isAtEnd()) {
                        int readInt32 = newInstance.readInt32();
                        this.dataMap.put(Integer.valueOf(readInt32), DataMapManager.readMappedData(readInt32, newInstance));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
