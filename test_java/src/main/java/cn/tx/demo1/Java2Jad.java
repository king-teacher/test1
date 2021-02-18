/**
 * FileName:Java2Jad
 * Author:Administrator
 * Date:2021/2/18 14:12
 * <autor>  <time>  <version>  <desc>
 * 作者姓名  修改时间   版本号     描述
 */
package cn.tx.demo1;

import java.io.*;

public class Java2Jad {

	public static void main(String[] args) throws Exception {
		File file = new File("d:/java");
		if (!file.exists() || !file.isDirectory()) {
			throw new Exception("java不存在");
		}

		File[] files = file.listFiles(
				new FilenameFilter() {
					public boolean accept(File dir, String name) {
						return name.endsWith(".java");
					}
				}
		);

		File file1 = new File("d:/jad");
		if (!file1.exists()) {
			file1.mkdir();
		}

		for (File f : files) {
			FileInputStream in = new FileInputStream(f);
			String newFileName = f.getName().replaceAll("\\.java$", ".jad");
			FileOutputStream out = new FileOutputStream(new File(file1, newFileName));
			copyFile(in, out);

		}

	}

	public static void copyFile(InputStream in, OutputStream out) throws Exception {
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = in.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
	}
}
