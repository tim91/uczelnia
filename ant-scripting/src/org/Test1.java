package org;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;


public class Test1 extends org.apache.tools.ant.Task {

	public Test1() {
		
////		Date d;
//		try {
//			HashCode hc = Files.hash(new File(""), Hashing.md5());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	@Test
	public void dateTest(){
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
		System.out.println(sdf.format(d));
	}
}
