package vcs;

import java.util.ArrayList;
import utils.ErrorCodeManager;
import utils.OperationType;

public class InvalidVcsOperation extends VcsOperation {
	public InvalidVcsOperation(OperationType type, ArrayList<String> operationArgs) {
		super(type, operationArgs);
	}

	/**
	 * Execute the invalid file system operation operation.
	 *
	 * @param fileSystemSnapshot
	 *            the active file system snapshot
	 * @return return code
	 */

	@Override
	public int execute(Vcs vcs) {
		// TODO Auto-generated method stub
		return ErrorCodeManager.VCS_BAD_CMD_CODE;
	}
}
