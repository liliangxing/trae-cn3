package com.bytedance.gkfs;

import com.bytedance.gkfs.cdc.GkFSCDCStatistics;
import com.bytedance.gkfs.io.ChunkFrom;
import com.bytedance.gkfs.io.ChunkIdentifier;
import com.bytedance.gkfs.io.GkFSChunk;
import com.bytedance.gkfs.io.GkFSInputInfo;
import com.bytedance.gkfs.io.GkFSOutputInfo;
import com.bytedance.gkfs.io.GkFSStatus;
import com.bytedance.gkfs.storage.GkFSChunkStorageInfo;
import com.bytedance.gkfs.storage.GkFSChunkTidyInfo;
import com.bytedance.iesgurd.statistic.UploadStatistic;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: GkFSReporter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rJ;\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0000¢\u0006\u0002\b\u0015J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ(\u0010\u001e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$¨\u0006%"}, d2 = {"Lcom/bytedance/gkfs/GkFSReporter;", "", "()V", "reportChunkReadStats", "Lorg/json/JSONObject;", "status", "Lcom/bytedance/gkfs/io/GkFSStatus;", "sourceFile", "Ljava/io/File;", "from", "Lcom/bytedance/gkfs/io/ChunkFrom;", "readInfo", "Lcom/bytedance/gkfs/io/GkFSChunk;", "reportChunkReadStats$geckox_noasanRelease", "reportChunkStoreStats", "id", "Lcom/bytedance/gkfs/io/ChunkIdentifier;", "cdc", "Lcom/bytedance/gkfs/cdc/GkFSCDCStatistics;", "store", "Lcom/bytedance/gkfs/storage/GkFSChunkStorageInfo;", "reportChunkStoreStats$geckox_noasanRelease", "reportFileReadStats", "inputInfo", "Lcom/bytedance/gkfs/io/GkFSInputInfo;", "reportFileReadStats$geckox_noasanRelease", "reportFileStoreStats", "outputInfo", "Lcom/bytedance/gkfs/io/GkFSOutputInfo;", "reportFileStoreStats$geckox_noasanRelease", "reportGeneralResourceInfo", "error", "", "resInfo", "Lcom/bytedance/gkfs/storage/GkFSChunkTidyInfo;", "geckoTotalUsage", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GkFSReporter {
    public static final GkFSReporter INSTANCE = new GkFSReporter();

    private GkFSReporter() {
    }

    public final JSONObject reportFileStoreStats$geckox_noasanRelease(GkFSOutputInfo outputInfo) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(outputInfo, "outputInfo");
        try {
            Result.Companion companion = Result.Companion;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("origin_file", outputInfo.getOriginFile().getAbsolutePath());
            jSONObject.put("gkfs_version", outputInfo.getMeta().getHeader().getVersion());
            jSONObject.put("header_size", outputInfo.getMeta().getHeader().getSize());
            jSONObject.put("chunk_count", outputInfo.getMeta().getChunks().size());
            Iterator<T> it = outputInfo.getMeta().getChunks().iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                i2 += ((GkFSChunk) it.next()).getStorageInfo().getSize();
            }
            jSONObject.put("chunk_size", i2);
            Iterator<T> it2 = outputInfo.getMeta().getChunks().iterator();
            while (it2.hasNext()) {
                i += ((GkFSChunk) it2.next()).getStorageInfo().getDilutedSize();
            }
            jSONObject.put("chunk_diluted_size", i);
            jSONObject.put("cdc_stats", outputInfo.getCdcStatistics().getStatus().getErrorCode().getCode());
            Throwable error = outputInfo.getCdcStatistics().getStatus().getError();
            if (error != null) {
                jSONObject.put("cdc_error_msg", error.getMessage() + ", cause:" + error.getCause());
            } else {
                jSONObject.put("min_size_suppress", outputInfo.getCdcStatistics().getMinSizeSuppress());
                jSONObject.put("max_size_suppress", outputInfo.getCdcStatistics().getMaxSizeSuppress());
                Iterator<T> it3 = outputInfo.getCdcStatistics().getChunkCDCTimeCost().values().iterator();
                long j = 0;
                while (it3.hasNext()) {
                    j += ((Number) it3.next()).longValue();
                }
                jSONObject.put("cdc_chunk_time_cost", j);
                jSONObject.put("cdc_time_cost", outputInfo.getCdcStatistics().getTotalTimeCost());
                jSONObject.put("store_stats", outputInfo.getStoreStatistics().getStatus().getErrorCode().getCode());
                Throwable error2 = outputInfo.getStoreStatistics().getStatus().getError();
                if (error2 != null) {
                    jSONObject.put("store_error_msg", error2.getMessage() + ", cause:" + error2.getCause());
                } else {
                    jSONObject.put("header_time_cost", outputInfo.getStoreStatistics().getHeaderTimeCost());
                    jSONObject.put("chunk_time_cost", CollectionsKt.sumOfLong(outputInfo.getStoreStatistics().getChunkStatistics().getTimeCost().values()));
                    jSONObject.put("tail_size", outputInfo.getStoreStatistics().getTailStorageCost());
                    jSONObject.put("tail_time_cost", outputInfo.getStoreStatistics().getTailTimeCost());
                    jSONObject.put("total_time_cost", outputInfo.getStoreStatistics().getTotalTimeCost());
                }
            }
            obj = Result.constructor-impl(jSONObject);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isSuccess-impl(obj)) {
            UploadStatistic.INSTANCE.uploadEventWithJson("geckosdk_gkfs_store_stats", (JSONObject) obj);
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            th2.printStackTrace();
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (JSONObject) obj;
    }

    public static /* synthetic */ JSONObject reportChunkStoreStats$geckox_noasanRelease$default(GkFSReporter gkFSReporter, ChunkIdentifier chunkIdentifier, File file, GkFSStatus gkFSStatus, GkFSCDCStatistics gkFSCDCStatistics, GkFSChunkStorageInfo gkFSChunkStorageInfo, int i, Object obj) {
        if ((i & 16) != 0) {
            gkFSChunkStorageInfo = null;
        }
        return gkFSReporter.reportChunkStoreStats$geckox_noasanRelease(chunkIdentifier, file, gkFSStatus, gkFSCDCStatistics, gkFSChunkStorageInfo);
    }

    public final JSONObject reportChunkStoreStats$geckox_noasanRelease(ChunkIdentifier id, File sourceFile, GkFSStatus status, GkFSCDCStatistics cdc, GkFSChunkStorageInfo store) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(id, "id");
        Intrinsics.checkParameterIsNotNull(sourceFile, "sourceFile");
        Intrinsics.checkParameterIsNotNull(status, "status");
        Intrinsics.checkParameterIsNotNull(cdc, "cdc");
        try {
            Result.Companion companion = Result.Companion;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (status.isSuccess()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("source_file", sourceFile.getAbsolutePath());
        jSONObject.put("id", id.getValue());
        jSONObject.put("stats", status.getErrorCode().getCode());
        Throwable error = status.getError();
        if (error != null) {
            jSONObject.put("error_msg", error.getMessage() + ", cause:" + error.getCause());
        }
        jSONObject.put("cdc_cost", cdc.getChunkCDCTimeCost().get(id));
        jSONObject.put("cdc_total_cost", cdc.getChunkTimeCost().get(id));
        if (store != null) {
            jSONObject.put("origin_size", store.getSize());
            jSONObject.put("diluted_size", store.getDilutedSize());
            jSONObject.put("lock_cost", store.getLockCost());
            jSONObject.put("indexing_cost", store.getIndexing().getTimeCost());
            jSONObject.put("write_cost", store.getIoCost());
            jSONObject.put("total_cost", store.getTimeCost());
        }
        obj = Result.constructor-impl(jSONObject);
        if (Result.isSuccess-impl(obj)) {
            UploadStatistic.INSTANCE.uploadEventWithJson("geckosdk_gkfs_chunk_store_stats", (JSONObject) obj);
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            th2.printStackTrace();
        }
        return (JSONObject) (Result.isFailure-impl(obj) ? null : obj);
    }

    public final JSONObject reportFileReadStats$geckox_noasanRelease(GkFSInputInfo inputInfo) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(inputInfo, "inputInfo");
        try {
            Result.Companion companion = Result.Companion;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("source_file", inputInfo.getSource().getAbsolutePath());
            jSONObject.put("file_gkfs_version", inputInfo.getMeta().getHeader().getVersion());
            jSONObject.put("sdk_gkfs_version", 1);
            jSONObject.put("stats", inputInfo.getReadStatistics().getStatus().getErrorCode().getCode());
            Throwable error = inputInfo.getReadStatistics().getStatus().getError();
            if (error != null) {
                jSONObject.put("error_msg", error.getMessage() + ", cause:" + error.getCause());
            } else {
                jSONObject.put("header_time_cost", inputInfo.getReadStatistics().getHeaderTimeCost());
                jSONObject.put("chunk_time_cost", inputInfo.getReadStatistics().getChunkTotalCost());
                jSONObject.put("tail_time_cost", inputInfo.getReadStatistics().getTailTimeCost());
                jSONObject.put("total_time_cost", inputInfo.getReadStatistics().getTotalTimeCost());
                long headerStorageCost = inputInfo.getReadStatistics().getHeaderStorageCost();
                jSONObject.put("header_size", headerStorageCost);
                Iterator<T> it = inputInfo.getMeta().getChunks().iterator();
                int i = 0;
                while (it.hasNext()) {
                    i += ((GkFSChunk) it.next()).getStorageInfo().getSize();
                }
                jSONObject.put("chunk_size", i);
                jSONObject.put("tail_size", inputInfo.getReadStatistics().getTailStorageCost());
                jSONObject.put("total_size", (inputInfo.getSource().length() + i) - headerStorageCost);
            }
            obj = Result.constructor-impl(jSONObject);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isSuccess-impl(obj)) {
            UploadStatistic.INSTANCE.uploadEventWithJson("geckosdk_gkfs_read_stats", (JSONObject) obj);
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            th2.printStackTrace();
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (JSONObject) obj;
    }

    public final JSONObject reportChunkReadStats$geckox_noasanRelease(GkFSStatus status, File sourceFile, ChunkFrom from, GkFSChunk readInfo) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(status, "status");
        Intrinsics.checkParameterIsNotNull(sourceFile, "sourceFile");
        Intrinsics.checkParameterIsNotNull(from, "from");
        Intrinsics.checkParameterIsNotNull(readInfo, "readInfo");
        try {
            Result.Companion companion = Result.Companion;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (status.isSuccess()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("source_file", sourceFile.getAbsolutePath());
        jSONObject.put("id", readInfo.getId().getValue());
        jSONObject.put("stats", status.getErrorCode().getCode());
        Throwable error = status.getError();
        if (error != null) {
            jSONObject.put("error_msg", error.getMessage() + ", cause:" + error.getCause());
        } else {
            jSONObject.put("from", from.getValue());
            jSONObject.put("size", readInfo.getStorageInfo().getSize());
            jSONObject.put("lock_cost", readInfo.getStorageInfo().getLockCost());
            jSONObject.put("indexing_cost", readInfo.getStorageInfo().getIndexing().getTimeCost());
            jSONObject.put("read_cost", readInfo.getStorageInfo().getIoCost());
            jSONObject.put("total_cost", readInfo.getStorageInfo().getTimeCost());
        }
        obj = Result.constructor-impl(jSONObject);
        if (Result.isSuccess-impl(obj)) {
            UploadStatistic.INSTANCE.uploadEventWithJson("geckosdk_gkfs_chunk_read_stats", (JSONObject) obj);
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            th2.printStackTrace();
        }
        return (JSONObject) (Result.isFailure-impl(obj) ? null : obj);
    }

    public static /* synthetic */ JSONObject reportGeneralResourceInfo$default(GkFSReporter gkFSReporter, Throwable th, GkFSChunkTidyInfo gkFSChunkTidyInfo, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        if ((i & 2) != 0) {
            gkFSChunkTidyInfo = null;
        }
        return gkFSReporter.reportGeneralResourceInfo(th, gkFSChunkTidyInfo, j);
    }

    public final JSONObject reportGeneralResourceInfo(Throwable error, GkFSChunkTidyInfo resInfo, long geckoTotalUsage) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            JSONObject jSONObject = new JSONObject();
            if (error != null) {
                String message = error.getMessage();
                if (message == null) {
                    message = error.toString();
                }
                jSONObject.put("error_msg", message);
            } else if (resInfo == null) {
                jSONObject.put("error_msg", "GkFSChunkTidyInfo is null");
            } else {
                jSONObject.put("gecko_total_resource_usage", geckoTotalUsage);
                jSONObject.put("gkfs_file_count", resInfo.getGeneralStorageInfo().getFileCount());
                jSONObject.put("gkfs_chunk_count", resInfo.getGeneralStorageInfo().getChunkCount());
                jSONObject.put("gkfs_chunk_usage", resInfo.getGeneralStorageInfo().getChunkSize());
                jSONObject.put("gkfs_total_resource_usage", resInfo.getGeneralStorageInfo().getOriginSize());
                jSONObject.put("gkfs_diluted_resource_usage", resInfo.getGeneralStorageInfo().getDilutedSize());
                jSONObject.put("gkfs_tidy_delete_chunk_count", resInfo.getDeleteChunkCount());
                jSONObject.put("gkfs_tidy_delete_chunk_size", resInfo.getDeleteChunkSize());
                jSONObject.put("gkfs_tidy_refs_reduce_chunk_count", resInfo.getRefsReduceChunkCount());
                jSONObject.put("gkfs_tidy_chunk_indexing_cost", resInfo.getIndexingCost());
                jSONObject.put("gkfs_tidy_chunk_io_cost", resInfo.getIoCost());
                jSONObject.put("gkfs_tidy_chunk_time_cost", resInfo.getTimeCost());
            }
            obj = Result.constructor-impl(jSONObject);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isSuccess-impl(obj)) {
            UploadStatistic.INSTANCE.uploadEventWithJson("geckosdk_gkfs_resource_info", (JSONObject) obj);
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            th2.printStackTrace();
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (JSONObject) obj;
    }
}
