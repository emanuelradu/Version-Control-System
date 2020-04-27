package vcs;

import java.util.ArrayList;

import utils.Context;
import utils.ErrorCodeManager;
import utils.OperationType;

public class CheckoutOperation extends VcsOperation {

	public CheckoutOperation(OperationType type, ArrayList<String> operationArgs) {
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
		// TODO Auto-generated method stub
		Context context = Context.getInstance();
		if (!context.getStaging().isEmpty()) {
			return ErrorCodeManager.VCS_STAGED_OP_CODE;
		}
		Boolean a = false;
		int size = vcs.getCurrentBranch().getCommits().size();
		if (operationArgs.size() == 1) {
			for (Branch b : vcs.getBranchArray()) {
				if (b.getName().equals(operationArgs.get(0))) {
					a = true;
				}
				if (a == false) {
					return ErrorCodeManager.VCS_BAD_CMD_CODE;
				}
			}

			vcs.getCurrentBranch().setIsHead(false);
			for (Branch bran : vcs.getBranchArray()) {
				if (bran.getName().equals(this.operationArgs.get(0))) {
					bran.setIsHead(true);
					vcs.setCurrentBranch(bran);
				}
			}
		}

		Boolean var = false;
		if (operationArgs.size() == 2) {
			int number = Integer.parseInt(this.operationArgs.get(1));
			for (Commit com : vcs.getCurrentBranch().getCommits()) {
				if (com.getId() == number) {
					var = true;
				}
				if (var == false) {
					return ErrorCodeManager.VCS_BAD_PATH_CODE;
				}
			}
			vcs.getCurrentBranch().getCommits().get(size - 1).setIsHead(false);
			for (Commit c : vcs.getCurrentBranch().getCommits()) {
				if (c.getId() == number) {
					c.setIsHead(true);
				}
			}

		}

		return ErrorCodeManager.OK;
	}

}
