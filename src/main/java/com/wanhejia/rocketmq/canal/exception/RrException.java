package com.wanhejia.rocketmq.canal.exception;


/**
 * @author FrozenWatermelon
 * @date 2020/7/11
 */
public class RrException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String msg;
	private int code = 500;

	public RrException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public RrException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}

	public RrException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}

	public RrException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}


}
