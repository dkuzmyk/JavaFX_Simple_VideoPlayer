package com.dkuzmyk.videoplayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public MediaView mediaView;
    public MenuItem chooseFileButton;
    public VBox anchorpane;
    private Stage st;

    @FXML
    private Button playB, stopB, pauseB, resetB;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    public void play(ActionEvent event) {
        mediaPlayer.play();
        st = (Stage)anchorpane.getScene().getWindow();
        mediaView.fitWidthProperty().bind(st.widthProperty());
        mediaView.fitHeightProperty().bind(st.heightProperty());
        mediaView.setMediaPlayer(mediaPlayer);
    }

    public void pause(ActionEvent event) {
        mediaPlayer.pause();
    }

    public void stop(ActionEvent event) {
        mediaPlayer.stop();
    }

    public void reset(ActionEvent event) {
        mediaPlayer.seek(Duration.seconds(0.0));
    }

    public void skipOn(ActionEvent event){
        mediaPlayer.seek(Duration.seconds(mediaPlayer.getCurrentTime().toSeconds()+5));
    }
    public void skipBack(ActionEvent event){
        mediaPlayer.seek(Duration.seconds(mediaPlayer.getCurrentTime().toSeconds()-5));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        file = new File("src/earth.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
    }

    public void chooseFile(ActionEvent event) {
        Stage stage = (Stage)anchorpane.getScene().getWindow();
        final FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        if(file!=null) {
            media = new Media(file.toURI().toString());
            mediaView.setMediaPlayer(mediaPlayer);
        }
    }
}