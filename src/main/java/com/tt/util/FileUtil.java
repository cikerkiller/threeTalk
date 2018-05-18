package com.tt.util;

import java.io.File;

public class FileUtil {
	public static void main(String[] args) {
		delete("D:/developer/git-repository/mmall-fe");
	}
	
	public static void delete(String path){
		File file=new File(path);
		if(file.isDirectory()){
			for(File fi:file.listFiles()){
				delete(fi.getAbsolutePath());
			}
			file.delete();
		}else{
			boolean isDele=file.delete();
			if(!isDele){
				System.gc();
				file.delete();
			}
		}
	}
}
