package com.bytedance.trae.conversation.extract;

import android.util.Base64;
import android.util.Log;
import com.bytedance.trae.conversation.BuildConfig;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public final class GitHubPusher implements Runnable {

    private final String fileName;
    private final File file;

    public GitHubPusher(String fileName, File file) {
        this.fileName = fileName;
        this.file = file;
    }

    public static void push(String fileName, File file) {
        GitHubPusher pusher = new GitHubPusher(fileName, file);
        new Thread(pusher).start();
    }

    @Override
    public void run() {
        int retries = 0;
        while (retries < 10) {
            if (performPush()) {
                Log.i("GitHubPusher", "Push succeeded");
                return;
            }
            retries++;
            try {
                Thread.sleep(600000);
            } catch (Exception e) {
            }
        }
        Log.e("GitHubPusher", "Max retries reached");
    }

    private boolean performPush() {
        boolean success = false;
        try {
            URL url = new URL("https://api.github.com/repos/liliangxing/trae-cn2/contents/docs/" + fileName + ".md");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Authorization", "token " + BuildConfig.getGITHUB_TOKEN());
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/vnd.github.v3+json");
            conn.setDoOutput(true);
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);

            byte[] fileBytes = new byte[(int) file.length()];
            FileInputStream fis = new FileInputStream(file);
            fis.read(fileBytes);
            fis.close();

            String base64Content = Base64.encodeToString(fileBytes, Base64.NO_WRAP);

            JSONObject json = new JSONObject();
            json.put("message", "Extract conversation: " + fileName);
            json.put("content", base64Content);

            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            dos.writeBytes(json.toString());
            dos.close();

            int responseCode = conn.getResponseCode();
            conn.disconnect();

            if (responseCode >= 200 && responseCode < 204) {
                success = true;
            }
        } catch (Exception e) {
            FileLogger.log("GitHubPusher", "Push failed", e);
        }
        return success;
    }
}
