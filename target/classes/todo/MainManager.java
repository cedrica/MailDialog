package todo;

import javax.inject.Singleton;

import helper.database.TaskDatabase;
import todo.main.container.MainContainerEvent;
import todo.main.container.MainContainerView;

@Singleton
public class MainManager {

	private MainContainerView mainContainer;
	private TaskDatabase database;

	public void initialize(MainContainerView mainContainer, TaskDatabase database){
		this.mainContainer = mainContainer;
		this.database = database;
		
		addEventHandler();
	}

	private void addEventHandler() {
		mainContainer.addEventHandler(MainContainerEvent.SETTINGS, evt -> openSettings(evt));
	}

	private void openSettings(MainContainerEvent evt) {
		System.out.println("Settings clicked");
	}
}
