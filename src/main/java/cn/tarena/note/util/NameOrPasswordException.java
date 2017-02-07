package cn.tarena.note.util;

public class NameOrPasswordException extends RuntimeException {

	private static final long serialVersionUID = -4545308997037264089L;
	
	private static final int NAME = 1;
	private static final int PASSWORD = 2;
	
	private int field;

	public NameOrPasswordException() {
		// TODO Auto-generated constructor stub
	}

	public NameOrPasswordException(int field ,String message) {
		super(message);
		this.field=field;
		// TODO Auto-generated constructor stub
	}

	public NameOrPasswordException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public NameOrPasswordException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NameOrPasswordException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public int getField() {
		return field;
	}
	
}
