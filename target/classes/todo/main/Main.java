package todo.main;

import org.apache.deltaspike.core.api.provider.BeanProvider;

import com.preag.core.ui.app.DesktopApp;

import helper.database.TaskDatabase;
import todo.MainManager;
import todo.main.container.MainContainerView;

public class Main extends DesktopApp {

	public static void main(String[] args) {
		enablePreloader();
		launch(args);
	}

	@Override
	public void initialize() {
		MainContainerView mainContainer = BeanProvider.getContextualReference(MainContainerView.class,false);
		MainManager mainManager = BeanProvider.getContextualReference(MainManager.class,false);
		TaskDatabase database = BeanProvider.getContextualReference(TaskDatabase.class,false);
		mainManager.initialize(mainContainer,database);
		
		closePreloader();
		showPrimaryStage(mainContainer);
	}
}
