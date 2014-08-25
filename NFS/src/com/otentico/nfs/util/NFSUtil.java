package com.otentico.nfs.util;

import java.io.File;

import android.os.Environment;

public class NFSUtil {
	private static final String DBFILEPATH = Environment.getExternalStorageDirectory().getPath()+"/nfs/db.json";

	public static File getLocalJSONFile() {
		return new File(DBFILEPATH);
	}
}
