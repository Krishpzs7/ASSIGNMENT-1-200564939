package com.example.boxofficea;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.ResultSet;

public class MainApp extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        primaryStage.setTitle("Movie Box Office Analysis");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/icon.png")));

        // Initial Scene with Chart
        Scene chartScene = createChartScene();

        // Button to switch to TableView Scene
        Button switchToTableViewButton = new Button("Switch to TableView");
        switchToTableViewButton.setOnAction(e -> primaryStage.setScene(createTableViewScene()));

        VBox layout = new VBox(10, switchToTableViewButton);
        layout.getChildren().add(chartScene.getRoot());

        Scene initialScene = new Scene(layout, 800, 600);
        initialScene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        primaryStage.setScene(initialScene);
        primaryStage.show();
    }

    private Scene createChartScene() {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Movie ID");
        yAxis.setLabel("Total Earnings");

        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Box Office Earnings");

        XYChart.Series series = new XYChart.Series();
        series.setName("Earnings");

        try {
            ResultSet rs = DBUtility.getBoxOfficeData();
            while (rs.next()) {
                series.getData().add(new XYChart.Data(rs.getInt("movie_id"), rs.getDouble("total_earnings")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        lineChart.getData().add(series);

        Scene scene = new Scene(lineChart, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        return scene;
    }

    private Scene createTableViewScene() {
        TableView<Movie> table = new TableView<>();
        ObservableList<Movie> data = FXCollections.observableArrayList();

        TableColumn<Movie, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Movie, String> titleCol = new TableColumn<>("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Movie, String> releaseDateCol = new TableColumn<>("Release Date");
        releaseDateCol.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        TableColumn<Movie, String> genreCol = new TableColumn<>("Genre");
        genreCol.setCellValueFactory(new PropertyValueFactory<>("genre"));

        table.getColumns().addAll(idCol, titleCol, releaseDateCol, genreCol);

        try {
            ResultSet rs = DBUtility.getMovieData();
            while (rs.next()) {
                data.add(new Movie(rs.getInt("id"), rs.getString("title"), rs.getDate("release_date").toString(), rs.getString("genre")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table.setItems(data);

        Button switchToChartButton = new Button("Switch to Chart");
        switchToChartButton.setOnAction(e -> primaryStage.setScene(createChartScene()));

        VBox layout = new VBox(10, switchToChartButton, table);
        Scene scene = new Scene(layout, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Movie {
    private int id;
    private String title;
    private String releaseDate;
    private String genre;

    public Movie(int id, String title, String releaseDate, String genre) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getGenre() {
        return genre;
    }
}
