module com.dkuzmyk.videoplayer {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.media;

    opens com.dkuzmyk.videoplayer to javafx.fxml;
    exports com.dkuzmyk.videoplayer;
}