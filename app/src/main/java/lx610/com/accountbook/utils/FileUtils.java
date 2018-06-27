package lx610.com.accountbook.utils;

import android.os.Environment;


public class FileUtils {

    static String BASE_File_NAME="travel_account_book";
    static String BASE_FILE_PATH= Environment.getExternalStorageDirectory().getAbsolutePath() + BASE_File_NAME;
    static String BASE_CACHE_FILE_PATH= Environment.getDownloadCacheDirectory().getAbsolutePath() + BASE_File_NAME;
    public static String getBaseFilePath(){
      return BASE_FILE_PATH;
    }

    public static String getBaseCacheFilePath(){
        return BASE_CACHE_FILE_PATH;
    }
}
