package vcs;

import java.util.ArrayList;
import utils.ErrorCodeManager;
import utils.OperationType;

public class BranchOperation extends VcsOperation {

	public BranchOperation(OperationType type, ArrayList<String> operationArgs) {
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

		if (operationArgs.size() != 1) {
			return ErrorCodeManager.VCS_BAD_CMD_CODE;
		}

		// TODO Auto-generated method stub
		//daca am un branch cu numele primit
		for (Branch a : vcs.getBranchArray()) {
			if (a.getName().equals(this.getOperationArgs().get(0))) {
				return ErrorCodeManager.VCS_BAD_CMD_CODE;
			}
		}
		Branch newBranch = new Branch(vcs.getCurrentBranch().
				getFs(), this.operationArgs.get(0));
		vcs.getBranchArray().add(newBranch);

		return ErrorCodeManager.OK;

	}

}
