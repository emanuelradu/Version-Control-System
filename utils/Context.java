package utils;

import java.util.ArrayList;

import vcs.Vcs;

public final class Context {
	private Vcs vcs;
	private static Context instance = null;
	private InputReader inputReader;
	private OutputWriter outputWriter;
	private ArrayList<String> staging = new ArrayList<String>();

	/**
	 * Context constructor.
	 */
	private Context() {
	}

	/**
	 * Gets the instance.
	 *
	 * @return the instance
	 */
	public static Context getInstance() {
		if (instance == null) {
			instance = new Context();
		}

		return instance;
	}

	/**
	 * Initialise the vcs.
	 *
	 * @param input
	 *            the input file
	 * @param output
	 *            the output file
	 */
	public void init(String input, String output) {
		inputReader = new InputReader(input);
		outputWriter = new OutputWriter(output);
		vcs = new Vcs(outputWriter);
	}

	/**
	 * Runs the context.
	 */
	public ArrayList<String> getStaging() {
		return this.staging;
	}

	public void run() {
		String operationString = "";
		AbstractOperation operation;
		OperationParser parser = new OperationParser();
		int exitCode;
		boolean wasError;

		this.vcs.init();

		while (true) {
			operationString = this.inputReader.readLine();
			if (operationString == null || operationString.isEmpty()) {
				continue;
			}
			if (operationString.equals("exit")) {
				return;
			}

			operation = parser.parseOperation(operationString);
			exitCode = operation.accept(vcs);
			wasError = ErrorCodeManager.getInstance().checkExitCode(
					outputWriter, exitCode);

			if (!wasError && this.isTrackable(operation)) {
				// TODO If the operation is trackable, vcs should track it
				if (operation.getType() == OperationType.MAKEDIR) {
					staging.add("Created directory " + operation.
							operationArgs.get(1));
				}
				if (operation.getType() == OperationType.TOUCH) {
					staging.add("Created file " + operation.
							operationArgs.get(1));
				}
				if (operation.getType() == OperationType.WRITETOFILE) {
					staging.add("Added " + "\"" + operation.
							operationArgs.get(1) + "\""
							+ " to file " + operation.
							operationArgs.get(0));
				}
				if (operation.getType() == OperationType.REMOVE) {
					staging.add("Removed " + operation.operationArgs.get(1));
				}
				if (operation.getType() == OperationType.RMDIR) {
					staging.add("Created file " + operation.
							operationArgs.get(1));
				}
				if (operation.getType() == OperationType.CHANGEDIR) {
					staging.add("Changed directory to " + operation.
							operationArgs.get(0));
				}

			}

		}
	}

	/**
	 * Specifies if an operation is vcs trackable or not. You can use it when you
	 * implement rollback/checkout -c functionalities.
	 *
	 * @param abstractOperation
	 *            the operation
	 * @return whether it's trackable or not
	 */
	private boolean isTrackable(AbstractOperation abstractOperation) {
		boolean result;

		switch (abstractOperation.type) {
		case CHANGEDIR:
		case MAKEDIR:
		case REMOVE:
		case TOUCH:
		case WRITETOFILE:
			result = true;
			break;
		default:
			result = false;
		}

		return result;
	}
}
