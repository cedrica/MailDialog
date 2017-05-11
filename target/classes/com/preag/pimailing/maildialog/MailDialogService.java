package com.preag.pimailing.maildialog;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.preag.pimailing.maildialog.run.Attachment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

public class MailDialogService {

	public static ObservableList<Label> convertFileToLabelAttachment(List<File> list) {
		ObservableList<Label> items = list.stream().map(Adapter::mapFileToObsList).collect(collectingAndThen(toList(), FXCollections::observableArrayList));
		return items;
	}

	public static ObservableList<Attachment> convertFileToAttachment(List<File> list) {
		ObservableList<Attachment> items = list.stream().map(Adapter::mapFileToAttachment).collect(collectingAndThen(toList(), FXCollections::observableArrayList));
		return items;
	}
	public static ObservableList<String> convertAttachmentToString(ObservableList<Label> list) {
		ObservableList<String> result = FXCollections.observableList(new ArrayList<>());
		if(list == null)
			return result;
		for (Label label : list) {
			result.add(label.getText());
		}
		return result;
	}
	public static class Adapter{
		public static Label mapFileToObsList(File file) {
			Label item = new Label(file.getName());
			item.setId(file.getName());
			item.setUserData(file);
			return item;
		}
		
		public static Attachment mapFileToAttachment(File file) {
			Attachment item = new Attachment();
			item.setName(file.getName());
			return item;
		}
	}
}
