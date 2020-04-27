package vcs;

import java.util.ArrayList;
import java.util.List;

import filesystem.FileSystemSnapshot;

public class Branch {
	private FileSystemSnapshot fs;
	private String name;
	private ArrayList<Commit> commits = new ArrayList<Commit>();
	private Boolean isHead = false;

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

	public Branch(FileSystemSnapshot fs, String name) {
		this.fs = fs;
		this.name = name;
	}

	/**
	 * Executes operation.
	 *
	 * @param param
	 * @return return
	 */
	public FileSystemSnapshot getFs() {
		return fs;
	}

	/**
	 * Executes operation.
	 *
	 * @param param
	 * @return return
	 */
	public void setFs(FileSystemSnapshot fs) {
		this.fs = fs;
	}

	/**
	 * Executes operation.
	 *
	 * @param param
	 * @return return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Executes operation.
	 *
	 * @param param
	 * @return return
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Executes operation.
	 *
	 * @param param
	 * @return return
	 */
	public List<Commit> getCommits() {
		return commits;
	}

	/**
	 * Executes operation.
	 *
	 * @param param
	 * @return return
	 */
	public void setCommits(ArrayList<Commit> commits) {
		this.commits = commits;
	}

}
