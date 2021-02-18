/**
 * FileName:MainClass
 * Author:Administrator
 * Date:2021/2/18 14:02
 * <autor>  <time>  <version>  <desc>
 * 作者姓名  修改时间   版本号     描述
 */
package cn.tx.demo;

import java.io.FileWriter;

public class MainClass {

	public static void main(String[] args) throws Exception {
		FileManager a = new FileManager("test_java/src/main/java/a.txt", new char[]{'\n'});
		FileManager b = new FileManager("test_java/src/main/java/b.txt", new char[]{'\n', ' '});
		FileWriter fw = new FileWriter("test_java/src/main/java/c.txt");

		String aword = null;
		String bword = null;

		while ((aword = a.nextWord()) != null) {
			fw.write(aword + "\n");
			bword = b.nextWord();
			if (bword != null) {
				fw.write(bword + "\n");
			}
		}

		while ((bword = a.nextWord()) != null) {
			fw.write(bword + "\n");

		}

		fw.close();

	}
}
