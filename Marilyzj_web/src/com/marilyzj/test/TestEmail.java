package com.marilyzj.test;

import org.junit.Test;

import com.marilyzj.utils.MailUitls;



public class TestEmail {
	@Test
	public void sendEmail() {
		MailUitls.sendMail("jia_chao23@126.com", "333");
	}
}
