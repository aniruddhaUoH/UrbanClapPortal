package com.alacriti.ucp.exception;

public class BaseException extends Exception {
	/*
	 * private static final AppLogger log =
	 * LogUtil.getLogger(BaseException.class); protected Throwable
	 * m_innerException; protected String m_message = Constants.EMPTY_STRING;
	 * protected String m_errorCode = ErrorConstants.ERR_GENERIC;
	 */
	// TODO: USAGE: To Override in the child exceptions

	/*
	 * protected BaseException() { }
	 * 
	 * public BaseException(String msg, Throwable th, String errorCode) {
	 * super(StringUtil.noNullTrim(msg), th); setErrorCode(errorCode); }
	 * 
	 * 
	 * public ServerError getError() { return ErrorUtil.getError(this); }
	 * 
	 * 
	 * public String getErrorCode() { log.debugPrintCurrentMethodName(); return
	 * m_errorCode; }
	 * 
	 * @Override public String getMessage() { log.debugPrintCurrentMethodName();
	 * return m_message; }
	 * 
	 * public Throwable getThrowable() { log.debugPrintCurrentMethodName();
	 * return getCause(); }
	 * 
	 * protected void setErrorCode(String errorCode) {
	 * log.debugPrintCurrentMethodName(); m_errorCode =
	 * StringUtil.noNullTrim(errorCode); }
	 * 
	 * public String returnStackTrace() { log.debugPrintCurrentMethodName();
	 * final Writer result = new StringWriter(); final PrintWriter printWriter =
	 * new PrintWriter(result); this.printStackTrace(printWriter); return
	 * result.toString(); }
	 */
}
