package shared;

import org.eclipse.core.runtime.IProgressMonitor;

public class ConsoleProgressMonitor implements IProgressMonitor {
	private static ConsoleProgressMonitor instance = null;
	private String taskName = "Unknown";
	private int taskWork = 0;

	protected ConsoleProgressMonitor() {
	}

	public static ConsoleProgressMonitor getInstanceAndStart(String name) {
		ConsoleProgressMonitor cpm = getInstance();
		cpm.beginTask(name, 0);
		return cpm;
	}

	public static ConsoleProgressMonitor getInstance() {
		if (instance == null) {
			instance = new ConsoleProgressMonitor();
		}
		return instance;
	}

	@Override
	public void beginTask(String name, int totalWork) {
		this.taskName = name;
		this.taskWork = totalWork;
		System.out.println("Starting task: " + name + " total work: " + this.taskWork);
	}

	@Override
	public void done() {
		System.out.println("Finished task: " + taskName);
	}

	@Override
	public void internalWorked(double arg0) {
		// do nothing
	}

	@Override
	public boolean isCanceled() {
		return false;
	}

	@Override
	public void setCanceled(boolean value) {
		// do nothing
	}

	@Override
	public void setTaskName(String name) {
		taskName = name;
	}

	@Override
	public void subTask(String name) {
		System.out.println("Starting subtask for task: " + taskName + " subtask: " + name);
	}

	@Override
	public void worked(int work) {
		System.out.println("Task work is changed: " + work + "/" + taskWork);
	}

}
