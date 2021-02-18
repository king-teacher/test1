/**
 * FileName:Demo1
 * Author:Administrator
 * Date:2021/2/18 13:56
 * <autor>  <time>  <version>  <desc>
 * 作者姓名  修改时间   版本号     描述
 */
package cn.tx.demo;

import java.io.File;
import java.io.FileReader;

public class FileManager {

	private String[] words = null;
	private int pos = 0;

	public FileManager(String fileName, char[] separators) throws Exception {
		File file = new File(fileName);
		FileReader fr = new FileReader(file);

		char[] buf = new char[(int) file.length()];
		int len = fr.read(buf);

		String fileContent = new String(buf, 0, len);

		String regex = null;

		if (separators.length > 1) {
			regex = separators[0] + "|" + separators[1] + "";
		} else {
			regex = separators[0] + "";
		}

		words = fileContent.split(regex);

	}

	public String nextWord() {
		if (pos == words.length) {
			return null;
		}
		return words[pos++];
	}
}
