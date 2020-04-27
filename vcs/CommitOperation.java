package vcs;

import java.util.ArrayList;

import utils.Context;
import utils.ErrorCodeManager;
import utils.IDGenerator;
import utils.OperationType;

public class CommitOperation extends VcsOperation {

	public CommitOperation(OperationType type, ArrayList<String> operationArgs) {
		super(type, operationArgs);
	}

	/**
	 * Executes operation.
	 *
	 * @param param
	 * @return return
	 */
	@Override
	public int execute(Vcs vcs) {
		// TODO Auto-generated method stub

		int size = vcs.getCurrentBranch().getCommits().size();
		String str = String.join(" ", this.getOperationArgs());
		Context context = Context.getInstance();
		if (context.getStaging().size() == 0) {
			return ErrorCodeManager.VCS_BAD_CMD_CODE;
		}
		Commit newCommit = new Commit(IDGenerator.generateCommitID(), str, true);
		vcs.getCurrentBranch().getCommits().get(size - 1).setIsHead(false);
		vcs.getCurrentBranch().getCommits().add(newCommit);
		vcs.getCurrentBranch().getCommits().get(size).setIsHead(true);
		context.getStaging().clear();

		return ErrorCodeManager.OK;
	}

}
