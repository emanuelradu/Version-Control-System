package vcs;

import java.util.ArrayList;

import utils.Context;
import utils.ErrorCodeManager;
import utils.OperationType;

public class StatusOperation extends VcsOperation {
	public StatusOperation(OperationType type, ArrayList<String> operationArgs) {
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
		Context context = Context.getInstance();
		vcs.getOutputWriter().write("On branch: " + vcs.
				getCurrentBranch().getName() + "\n");
		vcs.getOutputWriter().write("Staged changes:\n");
		for (String s : context.getStaging()) {
			vcs.getOutputWriter().write("\t" + s + "\n");
		}
		return ErrorCodeManager.OK;
	}

}
