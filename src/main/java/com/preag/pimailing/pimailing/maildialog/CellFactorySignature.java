package com.preag.pimailing.maildialog;

import com.preag.pimailing.maildialog.run.Signature;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Callback;

public class CellFactorySignature {
	public static Callback<ListView<Signature>, ListCell<Signature>> signatureWithToolTip() {
		return new Callback<ListView<Signature>, ListCell<Signature>>() {
			@Override
			public ListCell<Signature> call(ListView<Signature> p) {
				ListCell<Signature> cell = new ListCell<Signature>() {
					@Override
					protected void updateItem(Signature item, boolean empty) {
						super.updateItem(item, empty);
						if (item != null) {
							setText(item.getSignatureName());
							setOnMouseEntered(evt -> {
								setTooltip(createToolTip(item));
							});
						}
					}
				};
				return cell;
			}
		};
	}

	private static Tooltip createToolTip(Signature item) {
		Tooltip tooltip = new Tooltip();
		VBox vbBox = new VBox();
		WebView webView = new WebView();
		webView.setPrefWidth(400);
		WebEngine webEngine = webView.getEngine();
		webEngine.loadContent(item.getSignatureHTML());
		Label name = new Label(item.getSignatureName());
		name.setStyle("-fx-font-weight:bold;-fx-font-size:20;");
		vbBox.getChildren().addAll(name, webView);
		tooltip.setGraphic(vbBox);
		return tooltip;
	}
}
