package vcs;

import java.util.ArrayList;

import filesystem.FileSystemOperation;
import filesystem.FileSystemSnapshot;
import utils.IDGenerator;
import utils.OutputWriter;
import utils.Visitor;

public final class Vcs implements Visitor {
	private final OutputWriter outputWriter;
	private FileSystemSnapshot activeSnapshot;
	private ArrayList<Branch> branchArray = new ArrayList<Branch>();
	private Branch currentBranch;

	/**
	 * Vcs constructor.
	 *
	 * @param outputWriter
	 *            the output writer
	 */
	public Vcs(OutputWriter outputWriter) {
		this.outputWriter = outputWriter;
	}

	public ArrayList<Branch> getBranchArray() {
		return branchArray;
	}

	public void setBranchArray(ArrayList<Branch> branchArray) {
		this.branchArray = branchArray;
	}

	/**
	 * Does initialisations.
	 */

	public OutputWriter getOutputWriter() {
		return outputWriter;
	}

	public void setCurrentBranch(Branch currentBranch) {
		this.currentBranch = currentBranch;
	}

	public void init() {
		this.activeSnapshot = new FileSystemSnapshot(outputWriter);
		Branch master = new Branch(activeSnapshot, "master");
		master.setIsHead(true);
		this.currentBranch = master;
		this.getBranchArray().add(master);
		Commit firstCommit = new Commit(IDGenerator.
				generateCommitID(), "First commit", true);
		firstCommit.setIsHead(true);
		master.getCommits().add(firstCommit);

		// TODO other initialisations
	}

	public Branch getCurrentBranch() {
		return currentBranch;
	}

	/**
	 * Visits a file system operation.
	 *
	 * @param fileSystemOperation
	 *            the file system operation
	 * @return the return code
	 */
	public int visit(FileSystemOperation fileSystemOperation) {
		return fileSystemOperation.execute(this.activeSnapshot);
	}

	/**
	 * Visits a vcs operation.
	 *
	 * @param vcsOperation
	 *            the vcs operation
	 * @return return code
	 */
	@Override
	public int visit(VcsOperation vcsOperation) {
		// TODO
		return vcsOperation.execute(this);
	}

	// TODO methods through which vcs operations interact with this
}
