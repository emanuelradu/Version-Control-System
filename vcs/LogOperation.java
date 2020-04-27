package vcs;

import java.util.ArrayList;

import utils.ErrorCodeManager;
import utils.OperationType;

public class LogOperation extends VcsOperation {

	public LogOperation(OperationType type, ArrayList<String> operationArgs) {
		super(type, operationArgs);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Executes operation.
	 *
	 * @param param
	 * @return return
	 */
	@Override
	public int execute(Vcs vcs) {
		int n = vcs.getCurrentBranch().getCommits().size();
		// TODO Auto-generated method stub
		for (int i = 0; i < vcs.getCurrentBranch().getCommits().size() - 1; i++) {
			vcs.getOutputWriter().write(
					"Commit id: " + vcs.getCurrentBranch().
					getCommits().get(i).getId() + "\n");
			vcs.getOutputWriter().write("Message: "
					+ vcs.getCurrentBranch().getCommits().
					get(i).getMessage() + "\n" + "\n");
		}
		vcs.getOutputWriter().write(
				"Commit id: " + vcs.getCurrentBranch().
				getCommits().get(n - 1).getId() + "\n");
		vcs.getOutputWriter().write(
				"Message: " + vcs.getCurrentBranch().
				getCommits().get(n - 1).getMessage() + "\n");
		return ErrorCodeManager.OK;
	}

}
