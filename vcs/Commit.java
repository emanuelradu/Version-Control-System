package vcs;

public class Commit {

	private int id;
	private String message;
	private Boolean isHead;

	public Commit(int id, String message, Boolean isHead) {
		this.id = id;
		this.message = message;
		this.isHead = isHead;
	}

	/**
	 * Executes operation.
	 *
	 * @param param
	 * @return return
	 */
	public Boolean getIsHead() {
		return isHead;
	}

	/**
	 * Executes operation.
	 *
	 * @param param
	 * @return return
	 */
	public void setIsHead(Boolean isHead) {
		this.isHead = isHead;
	}

	/**
	 * Executes operation.
	 *
	 * @param param
	 * @return return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Executes operation.
	 *
	 * @param param
	 * @return return
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Executes operation.
	 *
	 * @param param
	 * @return return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Executes operation.
	 *
	 * @param param
	 * @return return
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
