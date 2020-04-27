package vcs;

import java.util.ArrayList;

import utils.Context;
import utils.ErrorCodeManager;
import utils.OperationType;

public class RollbackOperation extends VcsOperation {

	public RollbackOperation(OperationType type, ArrayList<String> operationArgs) {
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
		context.getStaging().clear();
		return ErrorCodeManager.OK;

	}

}
