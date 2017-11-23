package com.yingview.dao.impl;

import java.sql.Date;

import org.apache.commons.dbutils.QueryRunner;

import com.yingview.domain.User;
import com.yingview.utils.MailUtils;

public class Regist extends Thread {
	private User user;
	private QueryRunner qr;
	public Regist(User user, QueryRunner qr){
		super();
		this.user = user;
		this.qr = qr;
	}
	public void run() {
		String sql = "insert into users values(?,?, ?, ? , ?, ? , ?, ? , ?, ? , ?, ?, ?, ? , ?, ?, ?)";
		try {
			qr.update(sql,
						null,
						user.getUsercode(),
						user.getUsername(),
						user.getPassword(),
						user.getPasscode(),
						user.getNickname(),
						user.getSax(),
						user.getEmail(),
						user.getTel(),
						user.getBirthday(),
						user.getPhotoadd(),
						user.getUserlevel(),
						user.getUserpower(),
						user.getUserstatus(),
						user.getUserjob(),
						user.getActivecode(),
						user.getUsercreatetime()
						);
			MailUtils.sendMail(user.getEmail(), "<table height='100%' width='100%' cellpadding='0' cellspacing='0' border='0'><tbody><tr><td valign='top' align='center' class='devicewidth' style='background-color:#ffffff;'><table border='0' cellpadding='0' cellspacing='0' style='border:none;border-collapse:collapse;mso-table-lspace:0;mso-table-rspace:0;' width='600' class='devicewidth' align='center'><tbody><tr><td><table border='0' cellpadding='0' cellspacing='0' style='border:none;border-collapse:collapse;mso-table-lspace:0;mso-table-rspace:0;' width='600' class='devicewidth' align='center'><tbody><tr><td align='left' style=' color:#2dbe60; font-family: helvetica, arial, sans-serif; font-size:30px; font-weight:100; padding:0 0 10px 0;' class='pl25 pr25'>欢迎使用鹰视觉</td></tr></tbody></table></td></tr><tr><td><table border='0' cellpadding='0' cellspacing='0' style='border:none;border-collapse:collapse;mso-table-lspace:0;mso-table-rspace:0;table-layout:fixed;overflow-wrap:break-word;word-wrap:break-word;' width='600' class='devicewidth'><tbody><tr><td style='color:#484848; font-family: helvetica, arial, sans-serif; font-size:18px; line-height:26px; font-weight:100; padding:0 30px 35px 0;' align='left' class='pr25 pl25 f18 l26'>使用印象笔记，体验高效工作；在所有设备上安装印象笔记，享受完美生活。工作无拘无束，随时随地高效。在任意设备上打开这封邮件，点击下载印象笔记，即可安装。<br><br>小贴示：你知道吗？印象笔记还能帮你永久保存微信消息哦！关注「我的印象笔记」公众号，转发消息或文章给它，就可以永久保存，随时找到啦！</td></tr></tbody></table></td></tr><tr><td><table border='0' cellpadding='0' cellspacing='0' style='border:none;border-collapse:collapse;mso-table-lspace:0;mso-table-rspace:0;' width='600' class='devicewidth'><tbody><tr><td style='padding:0 0 30px 0;' class='pl25 pr25' align='left'><table border='0' cellpadding='0' cellspacing='0' style='border:none;border-collapse:collapse;mso-table-lspace:0;mso-table-rspace:0;' width='600' class='devicewidth'><tbody><tr><td align='left' class='full'><div><a href='http://127.0.0.1:8080/user.json?method=active&activecode="+user.getActivecode()+"&code="+user.getUsercode()+"' style='background-color:#2dbe60;border:1px solid #2dbe60;border-radius:4px;color:#ffffff;display:inline-block;font-family:Helvetica,Arial,sans-serif;font-size:14px;font-weight:bold;line-height:35px;text-align:center;text-decoration:none;-webkit-text-size-adjust:none;mso-hide:all;letter-spacing:.5px;min-width:150px;' class='button' target='_blank'>点此激活</a></div></td></tr></tbody></table></td></tr></tbody></table></td></tr><tr><td></td></tr></tbody></table></td></tr></tbody></table>");
		} catch (Exception e) {
			System.out.println("异常");
		}
	}
}
